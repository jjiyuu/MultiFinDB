package com.multifin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.multifin.model.vo.BankSaving;

// 금융감독원 적금 API
// http://finlife.fss.or.kr/PageLink.do?link=openapi/detail03&menuId=2000127
public class BankSavingAPI {
	
	public static final String KEY = "781549c1ac8e3a2e2521b79f392e648e";
	public static final String SAVING_JSON_URL = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmm"); // YYYYMMDDHH24MI
	
	
	public static void main(String[] args) {
		/* 권역코드 | 은행(020000), 여신전문금융(030200), 저축은행(030300), 보험(050000), 금융투자(060000) */
		/* TODO 23.01.16 은행을 제외한 4가지 금융회사에는 예금데이터가 없다. */
		bdMainmenu();
		System.out.println("프로그램이 종료되었습니다.");
	} // main 끝

	public static String urlSaving(String topFinGrpNo, int pageNo) { // JSON데이터 페이지 수 가져오기
		try {
			StringBuffer urlBuilder = new StringBuffer(SAVING_JSON_URL);
			urlBuilder.append("?" + "auth=" + KEY);
			urlBuilder.append("&" + "topFinGrpNo=" + topFinGrpNo); /* 권역코드 */
			urlBuilder.append("&" + "pageNo=" + pageNo);
			
			// 객체 생성 및 url 연결
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "appliciation/json");
			
			conn.getResponseCode(); // 실제 page를 요청하는 코드부
			
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
			
			int max_page_no = Integer.parseInt((String) data.get("max_page_no"));
			System.out.println("페이지 수 : " + max_page_no);
			for(int i = 1; i <= max_page_no; i++) {
				parsingSaving(topFinGrpNo, i);
			}
			
			return urlBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} // url 끝
	
	
	public static List<BankSaving> parsingSaving(String topFinGrpNo, int pageNo) {
		List<BankSaving> list = new ArrayList<BankSaving>();
		try {
			StringBuffer urlBuilder = new StringBuffer(SAVING_JSON_URL);
			urlBuilder.append("?" + URLEncoder.encode("auth","UTF-8") + "=" + KEY);
			urlBuilder.append("&" + URLEncoder.encode("topFinGrpNo","UTF-8") + "=" + topFinGrpNo); /* 권역코드 */
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + pageNo);

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
			// JSONObject에서 Array데이터를 get하여 JSONArray에 저장한다.
			JSONArray baseList = (JSONArray) data.get("baseList");
			JSONArray optionList = (JSONArray) data.get("optionList");
		
			for(int i = 0; i < baseList.size(); i++) {
				JSONObject object = (JSONObject) baseList.get(i);
                
				int bankSavingNo = 0;
				String dcls_month= getStrData(object, "dcls_month");
				String fin_co_no= getStrData(object, "fin_co_no");
				String kor_co_nm= getStrData(object, "kor_co_nm");
				String fin_prdt_cd = getStrData(object, "fin_prdt_cd");
				String fin_prdt_nm = getStrData(object, "fin_prdt_nm");
				String join_way = getStrData(object, "join_way");
				String mtrt_int = getStrData(object, "mtrt_int");
				String spcl_cnd	= getStrData(object, "spcl_cnd");
				String join_deny = getStrData(object, "join_deny");
				String join_member = getStrData(object, "join_member");
				String etc_note = getStrData(object, "etc_note");
				long max_limit = getLongData(object, "max_limit");
				Date dcls_strt_day = getDateData(object, "dcls_strt_day");
				String dcls_end_day = getStrData(object, "dcls_end_day");
				Date fin_co_subm_day = getDateData2(object, "fin_co_subm_day");
				
				for(int j = 0; j < optionList.size(); j++) {
					JSONObject object2 = (JSONObject) optionList.get(j);
					if(getStrData(object2, "fin_co_no").equals(fin_co_no)) {
						String intr_rate_type = getStrData(object2, "intr_rate_type");
						String intr_rate_type_nm = getStrData(object2, "intr_rate_type_nm");
						String save_trm = getStrData(object2, "save_trm");
						double intr_rate = getDoubleData(object2, "intr_rate");
						double intr_rate2 = getDoubleData(object2, "intr_rate2");
						BankSaving bs = new BankSaving(bankSavingNo, dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd, fin_prdt_nm, join_way, mtrt_int, spcl_cnd, join_deny, join_member, etc_note, max_limit, dcls_strt_day, dcls_end_day, fin_co_subm_day, intr_rate_type_nm, intr_rate_type_nm, intr_rate_type, intr_rate_type_nm, save_trm, intr_rate, intr_rate2);
						list.add(bs);
						
						System.out.println(bs.toString());
					}
				} // option for문 끝
				
			} // baseList for문 끝
			
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

	private static Date getDateData(JSONObject obj, String key) {
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
				return sdf3.parse(str);
			} catch (Exception e) {
			}
		}
		return null;
	}

	private static long getLongData(JSONObject obj , String key){
		String str = String.valueOf(obj.get(key));
		if(str != null) {
			try {
				return Long.parseLong(str);
			} catch (Exception e) {}
		}
		return 0;
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
	
	public static void bdMainmenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String menu = "========== 정기예금 Info Main ===========\n"
					+ "1. 은행\n"
					+ "2. 여신전문금융\n"
					+ "3. 저축은행\n"
					+ "4. 보험\n"
					+ "5. 금융투자\n"
					+ "0.프로그램 끝내기\n"
					+ "---------------------------------------------\n"
					+ "선택 : ";
			while(true) {
				System.out.print(menu);
				int select = sc.nextInt();
				switch (select) {
					case 1:
						urlSaving("020000", 1);
						System.out.println("완료되었습니다!!");
						break;
					case 2:
						urlSaving("030200", 1);
						System.out.println("완료되었습니다!!");
						break;
					case 3:
						urlSaving("030300", 1);
						System.out.println("완료되었습니다!!");
						break;
					case 4:
						urlSaving("050000", 1);
						System.out.println("완료되었습니다!!");
						break;
					case 5:
						urlSaving("060000", 1);
						System.out.println("완료되었습니다!!");
						break;
					case 0: 
						System.out.print("정말로 끝내시겠습니까?(y/n) : ");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y")) {
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
