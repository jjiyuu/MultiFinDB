package com.multifin.realty.api;
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

import com.multifin.realty.model.vo.OfficeDetail;
import com.multifin.realty.model.vo.RemainHouseType;
//오피스텔/도시형/민간임대 분양정보 상세조회
public class OfficeDetailAPI {
	public static final String KEY = "0AqT6LBbXaBEpVflCkRmxb65gc0GDlTLWpxG6k3OBCdr1BjlFlfb6Rlki8Ym7uqntmpFh%2BQa4u7L3%2FR7t8xn%2Bg%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/getUrbtyOfctlLttotPblancDetail";// 요청 URL
	public static final String GTE ="";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	public static List<OfficeDetail> parsing(Date searchDate, int pageNum) {
		String dateStr = sdf2.format(searchDate);
		
		List<OfficeDetail> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + pageNum); /* page */
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3ALTE%5D=" + "2023-06-30"); /* LTE 모집공고일 검색종료 */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3AGTE%5D=" + dateStr); /* GTE 모집공고일 검색시작 */
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
				
				int officeDno = 0;
				String bsns_mby_nm= getStrData(obj, "BSNS_MBY_NM");            //사업주체명 (시행사)       
    
				String cntrct_cncls_bgnde= getStrData(obj, "CNTRCT_CNCLS_BGNDE");          //계약시작일          
				String cntrct_cncls_endde= getStrData(obj, "CNTRCT_CNCLS_ENDDE");                //계약종료일    

				String hmpg_adres= getStrData(obj, "HMPG_ADRES");           			//홈페이지주소    
				String house_dtl_secd_nm= getStrData(obj, "HOUSE_DTL_SECD_NM");      			 //주택상세구분코드명
				int house_manage_no=Integer.parseInt(obj.get("HOUSE_MANAGE_NO").toString());
				String house_nm= getStrData(obj, "HOUSE_NM"); 							//주택명   
				String house_secd_nm= getStrData(obj, "HOUSE_SECD_NM");         //주택구분코드명              
				String hssply_adres= getStrData(obj, "HSSPLY_ADRES"); ;          //공급위치                
				String hssply_zip= getStrData(obj, "HSSPLY_ZIP");       //공급위치 우편번호                 
            
				String mdhs_telno= getStrData(obj, "MDHS_TELNO");        //문의처                      
				String mvn_prearnge_ym= getStrData(obj, "MVN_PREARNGE_YM");   //입주예정월  
				int pblanc_no=Integer.parseInt(obj.get("PBLANC_NO").toString());;
				String pblanc_url= getStrData(obj, "PBLANC_URL"); 			//분양정보 URL              
				String przwner_presnatn_de= getStrData(obj, "PRZWNER_PRESNATN_DE"); 			//당첨자발표일        
				String rcrit_pblanc_de= getStrData(obj, "RCRIT_PBLANC_DE"); 				//모집공고일         
				String subscrpt_rcept_bgnde= getStrData(obj, "SUBSCRPT_RCEPT_BGNDE"); 				//청약접수시작일           
				String subscrpt_rcept_endde= getStrData(obj, "SUBSCRPT_RCEPT_ENDDE"); 					//청ㄴ약접수종료일       
				int tot_suply_hshldco = Integer.parseInt(obj.get("TOT_SUPLY_HSHLDCO").toString()); //공급규모
     
				
				OfficeDetail office = new OfficeDetail(officeDno,  bsns_mby_nm,  cntrct_cncls_bgnde,
						  cntrct_cncls_endde,   hmpg_adres,   house_dtl_secd_nm, house_manage_no,  house_nm,
						  house_secd_nm,   hssply_adres,   hssply_zip,   mdhs_telno,   mvn_prearnge_ym,
						  pblanc_no,  pblanc_url,   przwner_presnatn_de,
						   rcrit_pblanc_de,subscrpt_rcept_bgnde,subscrpt_rcept_endde,tot_suply_hshldco
						  );
				list.add(office);
				
				System.out.println(office.toString() + "삽입 완료!");
			}                                                             
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getPageNum(Date searchDate) {
		int totalCount = 0;
		int pNo = 1;
		String dateStr = sdf2.format(searchDate);
		
		List<RemainHouseType> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + 1); /* page */
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3ALTE%5D=" + "2023-06-30"); /* LTE 모집공고일 검색종료 */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3AGTE%5D=" + dateStr); /* GTE 모집공고일 검색시작 */
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
