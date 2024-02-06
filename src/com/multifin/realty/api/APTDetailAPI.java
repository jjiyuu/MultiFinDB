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

import com.multifin.realty.model.vo.APTDetail;
import com.multifin.realty.model.vo.RemainHouseType;
//APT 분양정보 상세조회
//청약홈 분양정보 조회 서비스 API : https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098547
public class APTDetailAPI {
	public static final String KEY = "0AqT6LBbXaBEpVflCkRmxb65gc0GDlTLWpxG6k3OBCdr1BjlFlfb6Rlki8Ym7uqntmpFh%2BQa4u7L3%2FR7t8xn%2Bg%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/getAPTLttotPblancDetail";// 요청 URL
	public static final String GTE ="";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
//	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	public static List<APTDetail> parsing(Date searchDate, int pageNum) {
		String dataStr = sdf2.format(searchDate);
		
		List<APTDetail> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + pageNum); /* page */
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3ALTE%5D=" + "2023-06-30"); /* LTE 모집공고일 검색종료 */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3AGTE%5D=" + dataStr); /* GTE 모집공고일 검색시작 */
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
				
				int aptDno = 0;
				String bsns_mby_nm= getStrData(obj, "BSNS_MBY_NM");            //사업주체명 (시행사)       
				String cnstrct_entrps_nm= getStrData(obj, "CNSTRCT_ENTRPS_NM");          //건설업체명 (시공사)     
				String cntrct_cncls_bgnde= getStrData(obj, "CNTRCT_CNCLS_BGNDE");          //계약시작일          
				String cntrct_cncls_endde= getStrData(obj, "CNTRCT_CNCLS_ENDDE");                //계약종료일    
				String gnrl_rnk1_crsparea_rcept_pd= getStrData(obj, "GNRL_RNK1_CRSPAREA_RCEPT_PD");  //1순위 접수일 해당지역  
				String gnrl_rnk1_etc_area_rcptde_pd= getStrData(obj, "GNRL_RNK1_ETC_AREA_RCPTDE_PD");    //1순위 접수일 경기지
				String gnrl_rnk1_etc_gg_rcptde_pd= getStrData(obj, "GNRL_RNK1_ETC_GG_RCPTDE_PD");       //1순위 접수일 기타
//				String GNRL_RNK2_CRSPAREA_RCEPT_PD= getStrData(obj, "GNRL_RNK2_CRSPAREA_RCEPT_PD");      //2순위 접수일 해당
//				String GNRL_RNK2_ETC_AREA_RCPTDE_PD= getStrData(obj, "GNRL_RNK2_ETC_AREA_RCPTDE_PD");      //2순위 접수일 경
//				String GNRL_RNK2_ETC_GG_RCPTDE_PD= getStrData(obj, "GNRL_RNK2_ETC_GG_RCPTDE_PD");        //2순위 접수일 기
				String hmpg_adres= getStrData(obj, "HMPG_ADRES");           			//홈페이지주소    
//				String HOUSE_DTL_SECD= getStrData(obj, "HOUSE_DTL_SECD");       		//주택상세구분코드      
				String house_dtl_secd_nm= getStrData(obj, "HOUSE_DTL_SECD_NM");      			 //주택상세구분코드명
				int house_manage_no= Integer.parseInt(obj.get("HOUSE_MANAGE_NO").toString());					//주택관리번호    
				String house_nm= getStrData(obj, "HOUSE_NM"); 							//주택명   
//				String HOUSE_SECD= getStrData(obj, "HOUSE_SECD");    					//주택구분코드    
				String house_secd_nm= getStrData(obj, "HOUSE_SECD_NM");         //주택구분코드명              
				String hssply_adres= getStrData(obj, "HSSPLY_ADRES"); ;          //공급위치                
				String hssply_zip= getStrData(obj, "HSSPLY_ZIP");       //공급위치 우편번호                 
//				String IMPRMN_BSNS_AT= getStrData(obj, "IMPRMN_BSNS_AT");           //정비사업              
//				String LRSCL_BLDLND_AT= getStrData(obj, "LRSCL_BLDLND_AT");        //대규모 택지개발지구          
//				String MDAT_TRGET_AREA_SECD= getStrData(obj, "MDAT_TRGET_AREA_SECD");    //조정대상지역             
				String mdhs_telno= getStrData(obj, "MDHS_TELNO");        //문의처                      
				String mvn_prearnge_ym= getStrData(obj, "MVN_PREARNGE_YM");   //입주예정월                    
				String npln_prvopr_public_house_at= getStrData(obj, "NPLN_PRVOPR_PUBLIC_HOUSE_AT");    //수도권 내 민영 공공주
				String parcprc_uls_at= getStrData(obj, "PARCPRC_ULS_AT");     		//분양가상한제            
				int pblanc_no= Integer.parseInt(obj.get("PBLANC_NO").toString()); 				//공고번호                  "
				String pblanc_url= getStrData(obj, "PBLANC_URL"); 			//분양정보 URL              
				String przwner_presnatn_de= getStrData(obj, "PRZWNER_PRESNATN_DE"); 			//당첨자발표일        
				String public_house_earth_at= getStrData(obj, "PUBLIC_HOUSE_EARTH_AT"); 		//공공주택지구        
				String rcept_bgnde= getStrData(obj, "RCEPT_BGNDE"); 				//청약접수시작일           
				String rcept_endde= getStrData(obj, "RCEPT_ENDDE"); 					//청약접수종료일       
				String rcrit_pblanc_de= getStrData(obj, "RCRIT_PBLANC_DE"); 				//모집공고일         
//				String RENT_SECD= getStrData(obj, "RENT_SECD"); 					//분양구분코드        
				String rent_secd_nm= getStrData(obj, "RENT_SECD_NM"); 				//분양구분코드명       
				String speclt_rdn_earth_at= getStrData(obj, "SPECLT_RDN_EARTH_AT"); 			//투기과열지구        
				String spsply_rcept_bgnde= getStrData(obj, "SPSPLY_RCEPT_BGNDE"); 			//특별공급 접수시작일    
				String spsply_rcept_endde= getStrData(obj, "SPSPLY_RCEPT_ENDDE"); 			//특별공급 접수종료일    
//				String SUBSCRPT_AREA_CODE= getStrData(obj, "SUBSCRPT_AREA_CODE"); 			//공급지역코드        
				String subscrpt_area_code_nm= getStrData(obj, "SUBSCRPT_AREA_CODE_NM"); 			//공급지역명     
				int tot_suply_hshldco = Integer.parseInt(obj.get("TOT_SUPLY_HSHLDCO").toString()); //공급규모
				APTDetail aptd = new APTDetail(aptDno,  bsns_mby_nm,  cnstrct_entrps_nm,   cntrct_cncls_bgnde,
						  cntrct_cncls_endde,   gnrl_rnk1_crsparea_rcept_pd,   gnrl_rnk1_etc_area_rcptde_pd,
						  gnrl_rnk1_etc_gg_rcptde_pd,   hmpg_adres,   house_dtl_secd_nm,  house_manage_no, house_nm,
						  house_secd_nm,   hssply_adres,   hssply_zip,   mdhs_telno,   mvn_prearnge_ym,
						  npln_prvopr_public_house_at,   parcprc_uls_at, pblanc_no,  pblanc_url,   przwner_presnatn_de,
						  public_house_earth_at,   rcept_bgnde,   rcept_endde,   rcrit_pblanc_de,
						  rent_secd_nm,   speclt_rdn_earth_at,   spsply_rcept_bgnde,   spsply_rcept_endde,
						  subscrpt_area_code_nm, tot_suply_hshldco);
				list.add(aptd);
				
				System.out.println(aptd.toString() + "삽입 완료!");
			}                                                             
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getPageNum(Date searchDate) {
		String dataStr = sdf2.format(searchDate);
		int totalCount = 0;
		int pNo = 1;
		
		List<RemainHouseType> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + 1); /* page */
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* perpage */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3ALTE%5D=" + "2023-06-30"); /* LTE 모집공고일 검색종료 */
			urlBuilder.append("&" + "cond%5BRCRIT_PBLANC_DE%3A%3AGTE%5D=" + dataStr); /* GTE 모집공고일 검색시작 */
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
	
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
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
		String str = String.valueOf(obj.get(key));
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
