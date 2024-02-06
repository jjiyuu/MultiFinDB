package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.OfficeDetail;

public class OfficeDetailDao {
	// 데이터 삽입
	public int insert(Connection conn, OfficeDetail officeDetail) {
		try {
			String sql = "insert into OfficeDetail(officeDno, bsns_mby_nm, "
					+ "cntrct_cncls_bgnde, cntrct_cncls_endde, hmpg_adres, house_dtl_secd_nm, "
					+ "house_manage_no, house_nm, house_secd_nm, hssply_adres, hssply_zip, "
					+ "mdhs_telno, mvn_prearnge_ym, pblanc_no, pblanc_url, przwner_presnatn_de, "
					+ "rcrit_pblanc_de, subscrpt_rcept_bgnde, subscrpt_rcept_endde, tot_suply_hshldco) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, officeDetail.getOfficeDno());
			pstmt.setString(cnt++, officeDetail.getBsns_mby_nm());
			pstmt.setString(cnt++, officeDetail.getCntrct_cncls_bgnde());
			pstmt.setString(cnt++, officeDetail.getCntrct_cncls_endde());
			pstmt.setString(cnt++, officeDetail.getHmpg_adres());
			pstmt.setString(cnt++, officeDetail.getHouse_dtl_secd_nm());
			pstmt.setInt(cnt++, officeDetail.getHouse_manage_no());
			pstmt.setString(cnt++, officeDetail.getHouse_nm());
			pstmt.setString(cnt++, officeDetail.getHouse_secd_nm());
			pstmt.setString(cnt++, officeDetail.getHssply_adres());
			pstmt.setString(cnt++, officeDetail.getHssply_zip());
			pstmt.setString(cnt++, officeDetail.getMdhs_telno());
			pstmt.setString(cnt++, officeDetail.getMvn_prearnge_ym());
			pstmt.setInt(cnt++, officeDetail.getPblanc_no());
			pstmt.setString(cnt++, officeDetail.getPblanc_url());
			pstmt.setString(cnt++, officeDetail.getPrzwner_presnatn_de());
			pstmt.setString(cnt++, officeDetail.getRcrit_pblanc_de());
			pstmt.setString(cnt++, officeDetail.getSubscrpt_rcept_bgnde());
			pstmt.setString(cnt++, officeDetail.getSubscrpt_rcept_endde());
			pstmt.setInt(cnt++, officeDetail.getTot_suply_hshldco());
			
			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
