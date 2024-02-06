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

import com.multifin.realty.model.vo.APTHouseType;

public class ApiAptType {
	public static final String KEY = "0AqT6LBbXaBEpVflCkRmxb65gc0GDlTLWpxG6k3OBCdr1BjlFlfb6Rlki8Ym7uqntmpFh%2BQa4u7L3%2FR7t8xn%2Bg%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/getAPTLttotPblancMdl";// 요청 URL
	public static final String page ="";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
//	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		//7797개
		List<APTHouseType> list = parsing("1");
		
	}
	
	public static List<APTHouseType> parsing(String page) {
		List<APTHouseType> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL);
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /* page */
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
				
				 int aptHouseNo=0;                           
				 int etc_hshldco=Integer.parseInt(obj.get("ETC_HSHLDCO").toString()); //특별공급-기타 세대수
				 int house_manage_no=Integer.parseInt(obj.get("HOUSE_MANAGE_NO").toString());
			     String house_ty=getStrData(obj,"HOUSE_TY"); //주택형
			     int instt_recomend_hshldco=Integer.parseInt(obj.get("INSTT_RECOMEND_HSHLDCO").toString());//특별공급-기관추천 세대수
			     int lfe_frst_hshldco=Integer.parseInt(obj.get("LFE_FRST_HSHLDCO").toString());//특별공급-생애최초 세대수
			     String lttot_top_amount=getStrData(obj,"LTTOT_TOP_AMOUNT"); //공급금액 (분양최고금액) (단위:만원)
			     int mnych_hshldco=Integer.parseInt(obj.get("MNYCH_HSHLDCO").toString()); //특별공급-다자녀가구 세대수
			     int nwwds_hshldco=Integer.parseInt(obj.get("NWWDS_HSHLDCO").toString()); //특별공급-신혼부부 세대수
			     int old_parnts_suport_hshldco=Integer.parseInt(obj.get("OLD_PARNTS_SUPORT_HSHLDCO").toString());//특별공급-노부모부양 세대수
			     int pblanc_no=Integer.parseInt(obj.get("PBLANC_NO").toString()); //공고번호
			     int spsply_hshldco=Integer.parseInt(obj.get("SPSPLY_HSHLDCO").toString()); //특별공급세대수
			     String suply_ar=getStrData(obj,"SUPLY_AR"); //공급면적
			     int suply_hshldco=Integer.parseInt(obj.get("SUPLY_HSHLDCO").toString()); //일반공급세대수 
			     int transr_instt_enfsn_hshldco=Integer.parseInt(obj.get("TRANSR_INSTT_ENFSN_HSHLDCO").toString());//특별공급-이전기관 세대수
				
			     APTHouseType aptht = new APTHouseType(aptHouseNo,   etc_hshldco, house_manage_no,  house_ty,   instt_recomend_hshldco,
			 			  lfe_frst_hshldco,   lttot_top_amount,   mnych_hshldco,   nwwds_hshldco,
						  old_parnts_suport_hshldco,  pblanc_no, spsply_hshldco,   suply_ar,   suply_hshldco,
						  transr_instt_enfsn_hshldco);
			     list.add(aptht);

				System.out.println(aptht.toString() + "삽입 완료!");
			}                                                             
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Long.parseLong(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
	private static int getIntData(JSONObject obj , String key){
		String str = (String) obj.get(key);
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
