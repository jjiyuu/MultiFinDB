package com.multifin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.multifin.model.vo.LoanCredit;

// 개인신용대출상품 API
// http://finlife.fss.or.kr/PageLink.do?link=openapi/detail05&menuId=2000129
public class LoanCreditAPI {

	public static final String KEY = "781549c1ac8e3a2e2521b79f392e648e";
	public static final String MORTAGE_JSON_URL = "http://finlife.fss.or.kr/finlifeapi/creditLoanProductsSearch.json";

	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm"); // YYYYMMDDHH24MI

	public static void main(String[] args) {
		lcMainmenu();
		System.out.println("프로그램이 종료되었습니다.");
	} // main 끝

	
	
	/* 권역코드 | 은행(020000), 여신전문금융(030200), 저축은행(030300), 보험(050000), 금융투자(060000) */
	public static List<LoanCredit> parsingCredit(String topFinGrpNo, int pageNo) {
		List<LoanCredit> list = new ArrayList<LoanCredit>();
		try {
			StringBuffer urlBuilder = new StringBuffer(MORTAGE_JSON_URL);
			urlBuilder.append("?" + "auth=" + KEY);
			urlBuilder.append("&" + "topFinGrpNo=" + topFinGrpNo); /* 권역코드 */
			urlBuilder.append("&" + "pageNo=" + pageNo);

			System.out.println(urlBuilder.toString()); // 요청 url

			// 객체 생성 및 url 연결
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "appliciation/json");

			int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
			System.out.println("ResponseCode : " + code);

			if (code < 200 || code > 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}

			// 데이터 받아오기
			StringBuffer sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			while (br.ready()) {
				sb.append(br.readLine());
			}
			JSONObject result = (JSONObject) new JSONParser().parse(sb.toString());

			// JSON데이터에서 "result"라는 JSONObject를 가져온다.
			JSONObject data = (JSONObject) result.get("result");
			int total_count = Integer.parseInt((String) data.get("total_count"));
			int max_page_no = Integer.parseInt((String) data.get("max_page_no"));
			if (total_count == 0) {
				System.out.println("상품이 없습니다.");
				return null;
			}
			System.out.println("상품 수 : " + total_count);
			System.out.println("페이지 수 : " + max_page_no);

			// JSONObject에서 Array데이터를 get하여 JSONArray에 저장한다.
			JSONArray baseList = (JSONArray) data.get("baseList");
			JSONArray optionList = (JSONArray) data.get("optionList");
			for (int page = 1; page <= max_page_no; page++) {

				for (int i = 0; i < baseList.size(); i++) {
					JSONObject object = (JSONObject) baseList.get(i);
					
					int lonCreditNo = 0;
					String dcls_month = getStrData(object, "dcls_month");
					String fin_co_no = getStrData(object, "fin_co_no");
					String kor_co_nm = getStrData(object, "kor_co_nm");
					String fin_prdt_cd = getStrData(object, "fin_prdt_cd");
					String fin_prdt_nm = getStrData(object, "fin_prdt_nm");
					String join_way = getStrData(object, "join_way");
					int crdt_prdt_type = getIntData(object, "crdt_prdt_type");
					String crdt_prdt_type_nm = getStrData(object, "crdt_prdt_type_nm");
					String cb_name = getStrData(object, "cb_name");
					Date dcls_strt_day = getDateData1(object, "dcls_strt_day");
					String dcls_end_day = getStrData(object, "dcls_end_day");
					Date fin_co_subm_day = getDateData2(object, "fin_co_subm_day");

					for (int j = 0; j < optionList.size(); j++) {
						JSONObject object2 = (JSONObject) optionList.get(j);
						if (getStrData(object2, "fin_co_no").equals(fin_co_no)) {
							String crdt_lend_rate_type = getStrData(object2, "crdt_lend_rate_type");
							String crdt_lend_rate_type_nm = getStrData(object2, "crdt_lend_rate_type_nm");
							double crdt_grad_1 = getDoubleData(object2, "crdt_grad_1");
							double crdt_grad_4 = getDoubleData(object2, "crdt_grad_4");
							double crdt_grad_5 = getDoubleData(object2, "crdt_grad_5");
							double crdt_grad_6 = getDoubleData(object2, "crdt_grad_6");
							double crdt_grad_avg = getDoubleData(object2, "crdt_grad_avg");
							LoanCredit lc = new LoanCredit(lonCreditNo, dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd, fin_prdt_nm, join_way, crdt_prdt_type, crdt_prdt_type_nm, cb_name, dcls_strt_day, dcls_end_day, fin_co_subm_day, 
									crdt_lend_rate_type, crdt_lend_rate_type_nm,crdt_grad_1,crdt_grad_4,crdt_grad_5,crdt_grad_6, crdt_grad_avg);
							list.add(lc);
							
							System.out.println(lc.toString() + "삽입 완료!");
						}
					} 
				}
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} // 파싱 끝

	private static String getStrData(JSONObject obj, String key) {
		String str = (String) obj.get(key);
		if (str == null) {
			return "-";
		} else {
			return str;
		}
	}

	private static Date getDateData1(JSONObject obj, String key) {
		String str = (String) obj.get(key);
		if (str != null) {
			try {
				return sdf1.parse(str);
			} catch (Exception e) {
			}
		}
		return null;
	}

	private static Date getDateData2(JSONObject obj, String key) {
		String str = (String) obj.get(key);
		if (str != null) {
			try {
				return sdf2.parse(str);
			} catch (Exception e) {
			}
		}
		return null;
	}

	private static int getIntData(JSONObject obj, String key) {
		String str = (String) obj.get(key);
		if (str != null) {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {
			}
		}
		return 0;
	}

	private static double getDoubleData(JSONObject obj, String key) {
		String str = String.valueOf(obj.get(key));
		if (str != null) {
			try {
				return Double.parseDouble(str);
			} catch (Exception e) {
			}
		}
		return 0;
	}

	public static void lcMainmenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String menu = "========== 개인신용대출 ===========\n" + "1. 은행\n" + "2. 여신전문금융\n" + "3. 저축은행\n"
					+ "4. 보험\n" + "5. 금융투자\n" + "0.프로그램 끝내기\n" + "---------------------------------------------\n"
					+ "선택 : ";
			while (true) {
				System.out.print(menu);
				int select = sc.nextInt();
				switch (select) {
				case 1:
					parsingCredit("020000", 1);
					System.out.println("완료되었습니다!!");
					break;
				case 2:
					parsingCredit("030200", 1);
					System.out.println("완료되었습니다!!");
					break;
				case 3:
					parsingCredit("030300", 1);
					System.out.println("완료되었습니다!!");
					break;
				case 4:
					parsingCredit("050000", 1);
					System.out.println("완료되었습니다!!");
					break;
				case 5:
					parsingCredit("060000", 1);
					System.out.println("완료되었습니다!!");
					break;
				case 0:
					System.out.print("정말로 끝내시겠습니까?(y/n) : ");
					String yn = sc.next();
					if (yn.equals("y") || yn.equals("Y")) {
						return;
					}
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		} // while 끝

	} // 메인메뉴 메소드 끝

}