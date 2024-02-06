package com.multifin.realty.api;
//지역별 전환률 조회
	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.multifin.realty.model.vo.RemainHouseType;

	public class RemainHouseTypeAPI {
		public static final String KEY = "0AqT6LBbXaBEpVflCkRmxb65gc0GDlTLWpxG6k3OBCdr1BjlFlfb6Rlki8Ym7uqntmpFh%2BQa4u7L3%2FR7t8xn%2Bg%3D%3D"; // API KEY
		public static final String REQUEST_URL  = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/getRemndrLttotPblancMdl";// 요청 URL
		
		public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		public static void main(String[] args) {
			parsing(1);
		}
		
		public static List<RemainHouseType> parsing(int pageNum) {
			List<RemainHouseType> list = new ArrayList<>();
			try {
				StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
				urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + pageNum); /* page */
				urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
				urlBuilder.append("&" + "serviceKey=" + KEY); /**API KEY 입력 부분 */
				
				System.out.println(urlBuilder);
				
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");

				int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
				System.out.println("ResponseCode : " + code);
				if (code < 200 || code >= 300) {
					System.out.println("페이지가 잘못되었습니다.");
					return list;
				}
				
				InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				JSONParser jsonParser = new JSONParser();
				JSONObject rootObj = (JSONObject) jsonParser.parse(br);
				
				JSONArray jsonArr = (JSONArray) rootObj.get("data");
				
				for(int i = 0; i< jsonArr.size(); i++) {
					JSONObject obj = (JSONObject) jsonArr.get(i);
					
					int remainHouseNo=0;
					int house_manage_no=Integer.parseInt(obj.get("HOUSE_MANAGE_NO").toString());//주택관리번호
					String house_ty=getStrData(obj,"HOUSE_TY"); //모델타입    
					String lttot_top_amoun=getStrData(obj,"LTTOT_TOP_AMOUN"); //공급금액 (분양최고금액)(단위:만원)
					int pblanc_no=Integer.parseInt(obj.get("PBLANC_NO").toString()); //공고번호      
					int suply_hshldco=Integer.parseInt(obj.get("SUPLY_HSHLDCO").toString()); //일반공급세대 수
				
			
	     
					
					RemainHouseType remType = new RemainHouseType(remainHouseNo,house_manage_no,  house_ty,
							lttot_top_amoun,pblanc_no, suply_hshldco );
					list.add(remType);
					
					System.out.println(remType.toString() + "삽입 완료!");
				}                                                             
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public static int getPageNum() {
			int totalCount = 0;
			int pNo = 1;
			
			List<RemainHouseType> list = new ArrayList<>();
			try {
				StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
				urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + 1); /* page */
				urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
				urlBuilder.append("&" + "serviceKey=" + KEY); /**API KEY 입력 부분 */
				
				System.out.println(urlBuilder);
				
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");

				int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
				System.out.println("ResponseCode : " + code);
				if (code < 200 || code >= 300) {
					System.out.println("페이지가 잘못되었습니다.");
					return pNo;
				}
				
				InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				JSONParser jsonParser = new JSONParser();
				JSONObject obj = (JSONObject) jsonParser.parse(br);
				
				totalCount = getIntData(obj, "totalCount");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			pNo = (totalCount/100) + 1;
			return pNo;
		}
		
		private static String getStrData(JSONObject obj , String key){
			String str = (String) obj.get(key);
			if(str == null) {
				return "-";
			}else {
				return str;
			}
		}

		private static Date getDateData(JSONObject obj , String key) {
			String str = (String) obj.get(key);
			if(str != null) {
				try {
					return sdf2.parse(str);
				} catch (Exception e) {}
			}
			return null;
		}
		
		private static long getLongData(JSONObject obj , String key){
			String str = (String) obj.get(key);
			if(str != null) {
				try {
					return Long.parseLong(str);
				} catch (Exception e) {}
			}
			return 0;
		}
		
		private static int getIntData(JSONObject obj , String key){
			String str = String.valueOf(obj.get(key));
			if(str != null) {
				try {
					return Integer.parseInt(str);
				} catch (Exception e) {}
			}
			return 0;
		}
		
		private static double getDoubleData(JSONObject obj , String key){
			String str = (String) obj.get(key);
			if(str != null) {
				try {
					return Double.parseDouble(str);
				} catch (Exception e) {}
			}
			return 0;
		}
    
	
}
