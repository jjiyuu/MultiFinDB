package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.RemainDetail;

public class RemainDetailDao {
	// 데이터 삽입
	public int insert(Connection conn, RemainDetail remainDetail) {
		try {
			String sql = "insert into remainDetail(remainNo, "
					+ "bsns_mby_nm, cntrct_cncls_bgnde, cntrct_cncls_endde, "
					+ "gnrl_rcept_bgnde, gnrl_rcept_endde, hmpg_adres, house_manage_no, "
					+ "house_dtl_secd_nm, house_nm, house_secd_nm, hssply_adres, "
					+ "hssply_zip, mdhs_telno, mvn_prearnge_ym, pblanc_no, pblanc_url, "
					+ "przwner_presnatn_de, rcrit_pblanc_de, spsply_rcept_bgnde, "
					+ "spsply_rcept_endde, subscrpt_rcept_bgnde, subscrpt_rcept_endde) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, remainDetail.getRemainNo());
			pstmt.setString(cnt++, remainDetail.getBsns_mby_nm());
			pstmt.setString(cnt++, remainDetail.getCntrct_cncls_bgnde());
			pstmt.setString(cnt++, remainDetail.getCntrct_cncls_endde());
			pstmt.setString(cnt++, remainDetail.getGnrl_rcept_bgnde());
			pstmt.setString(cnt++, remainDetail.getGnrl_rcept_endde());
			pstmt.setString(cnt++, remainDetail.getHmpg_adres());
			pstmt.setInt(cnt++, remainDetail.getHouse_manage_no());
			pstmt.setString(cnt++, remainDetail.getHouse_dtl_secd_nm());
			pstmt.setString(cnt++, remainDetail.getHouse_nm());
			pstmt.setString(cnt++, remainDetail.getHouse_secd_nm());
			pstmt.setString(cnt++, remainDetail.getHssply_adres());
			pstmt.setString(cnt++, remainDetail.getHssply_zip());
			pstmt.setString(cnt++, remainDetail.getMdhs_telno());
			pstmt.setString(cnt++, remainDetail.getMvn_prearnge_ym());
			pstmt.setInt(cnt++, remainDetail.getPblanc_no());
			pstmt.setString(cnt++, remainDetail.getPblanc_url());
			
			pstmt.setString(cnt++, remainDetail.getPrzwner_presnatn_de());
			pstmt.setString(cnt++, remainDetail.getRcrit_pblanc_de());
			pstmt.setString(cnt++, remainDetail.getSpsply_rcept_bgnde());
			pstmt.setString(cnt++, remainDetail.getSpsply_rcept_endde());
			pstmt.setString(cnt++, remainDetail.getSubscrpt_rcept_bgnde());
			pstmt.setString(cnt++, remainDetail.getSubscrpt_rcept_endde());
			
			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
