package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.APTDetail;

public class APTDetailDao {
	// 데이터 삽입
			public int insert(Connection conn, APTDetail aptDetail) {
				try {
					String sql = "insert into aptDetail(aptDno, bsns_mby_nm, cnstrct_entrps_nm, cntrct_cncls_bgnde, "
							+ "cntrct_cncls_endde, gnrl_rnk1_crsparea_rcept_pd, gnrl_rnk1_etc_area_rcptde_pd, gnrl_rnk1_etc_gg_rcptde_pd, "
							+ "hmpg_adres, house_dtl_secd_nm, house_manage_no, house_nm, house_secd_nm, "
							+ "hssply_adres, hssply_zip, mdhs_telno, mvn_prearnge_ym, npln_prvopr_public_house_at,parcprc_uls_at , pblanc_no,"
							+ "pblanc_url, przwner_presnatn_de, public_house_earth_at, rcept_bgnde,rcept_endde, rcrit_pblanc_de, rent_secd_nm,"
							+ "speclt_rdn_earth_at, spsply_rcept_bgnde, spsply_rcept_endde, subscrpt_area_code_nm, tot_suply_hshldco ) "
							+ "values(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					int cnt = 1;
					pstmt.setInt(cnt++, aptDetail.getAptDno());
					pstmt.setString(cnt++, aptDetail.getBsns_mby_nm());
					pstmt.setString(cnt++, aptDetail.getCnstrct_entrps_nm());
					pstmt.setString(cnt++, aptDetail.getCntrct_cncls_bgnde());
					pstmt.setString(cnt++, aptDetail.getCntrct_cncls_endde());
					pstmt.setString(cnt++, aptDetail.getGnrl_rnk1_crsparea_rcept_pd());
					pstmt.setString(cnt++, aptDetail.getGnrl_rnk1_etc_area_rcptde_pd());
					pstmt.setString(cnt++, aptDetail.getGnrl_rnk1_etc_gg_rcptde_pd());
					pstmt.setString(cnt++, aptDetail.getHmpg_adres());
					pstmt.setString(cnt++, aptDetail.getHouse_dtl_secd_nm());
					pstmt.setInt(cnt++, aptDetail.getHouse_manage_no());
					pstmt.setString(cnt++, aptDetail.getHouse_nm());
					pstmt.setString(cnt++, aptDetail.getHouse_secd_nm());
					pstmt.setString(cnt++, aptDetail.getHssply_adres());
					pstmt.setString(cnt++, aptDetail.getHssply_zip());
					pstmt.setString(cnt++, aptDetail.getMdhs_telno());
					pstmt.setString(cnt++, aptDetail.getMvn_prearnge_ym());
					pstmt.setString(cnt++, aptDetail.getNpln_prvopr_public_house_at());
					pstmt.setString(cnt++, aptDetail.getParcprc_uls_at());
					pstmt.setInt(cnt++, aptDetail.getPblanc_no());
					pstmt.setString(cnt++, aptDetail.getPblanc_url());
					pstmt.setString(cnt++, aptDetail.getPrzwner_presnatn_de());
					pstmt.setString(cnt++, aptDetail.getPublic_house_earth_at());
					pstmt.setString(cnt++, aptDetail.getRcept_bgnde());
					pstmt.setString(cnt++, aptDetail.getRcept_bgnde());
					pstmt.setString(cnt++, aptDetail.getRcrit_pblanc_de());
					pstmt.setString(cnt++, aptDetail.getRent_secd_nm());
					pstmt.setString(cnt++, aptDetail.getSpeclt_rdn_earth_at());
					pstmt.setString(cnt++, aptDetail.getSpsply_rcept_bgnde());
					pstmt.setString(cnt++, aptDetail.getSpsply_rcept_endde());
					pstmt.setString(cnt++, aptDetail.getSubscrpt_area_code_nm());
					pstmt.setInt(cnt++, aptDetail.getTot_suply_hshldco());
			

					int result = pstmt.executeUpdate();
					
					pstmt.close();
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return -1;
			}

}
