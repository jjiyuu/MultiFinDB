package com.multifin.realty.api;

//공공지원 민간임대 분양정보/경쟁률 조회
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

import com.multifin.realty.model.vo.PublicRate;
import com.multifin.realty.model.vo.RemainHouseType;
public class PublicRateAPI {
	public static final String KEY = "0AqT6LBbXaBEpVflCkRmxb65gc0GDlTLWpxG6k3OBCdr1BjlFlfb6Rlki8Ym7uqntmpFh%2BQa4u7L3%2FR7t8xn%2Bg%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://api.odcloud.kr/api/ApplyhomeInfoCmpetRtSvc/v1/getPblPvtRentLttotPblancCmpet";// 요청 URL
	public static final String page ="";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		List<PublicRate> list = parsing(1);
	}
	
	public static List<PublicRate> parsing(int pageNum) {
		List<PublicRate> list = new ArrayList<>();
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
				
				int pubNo=0;                           
				int house_manage_no =getIntData(obj,"HOUSE_MANAGE_NO"); //주택관리번호        
				int pblanc_no= getIntData(obj,"PBLANC_NO"); //공고번호                
				String house_ty=getStrData(obj,"HOUSE_TY"); //주택형                   
				int suply_hshldco = getIntData(obj,"SUPLY_HSHLDCO"); //공급세대수          
				String spsply_knd_nm   =getStrData(obj,"SPSPLY_KND_NM");  //공급유형              
				int spsply_knd_hshldco =getIntData(obj,"SPSPLY_KND_HSHLDCO"); //배정세대수                
				String req_cnt = getStrData(obj,"REQ_CNT");//접수건수             
				String cmpet_rate  = getStrData(obj,"CMPET_RATE");    //경쟁률
				
				PublicRate pubr = new PublicRate(  pubNo,   house_manage_no,   pblanc_no,   house_ty,   suply_hshldco,
						spsply_knd_nm,   spsply_knd_hshldco,   req_cnt,   cmpet_rate  );
				list.add(pubr);
				
				System.out.println(pubr.toString() + "삽입 완료!");
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
	
	
	private static Date getDateData(JSONObject obj , String key){
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
