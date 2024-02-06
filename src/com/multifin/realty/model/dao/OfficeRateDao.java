package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.OfficeRate;

public class OfficeRateDao {
	// 데이터 삽입
	public int insert(Connection conn, OfficeRate officeRate) {
		try {
			String sql = "insert into officeRate(officeRateNo, house_manage_no, "
					+ "pblanc_no, house_ty, suply_hshldco, residnt_prior_at, "
					+ "resident_prior_senm, req_cnt, cmpet_rate) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, officeRate.getOfficeRateNo());
			pstmt.setInt(cnt++, officeRate.getHouse_manage_no());
			pstmt.setInt(cnt++, officeRate.getPblanc_no());

			pstmt.setString(cnt++, officeRate.getHouse_ty());
			pstmt.setInt(cnt++, officeRate.getSuply_hshldco());
			pstmt.setString(cnt++, officeRate.getResidnt_prior_at());
			pstmt.setString(cnt++, officeRate.getResident_prior_senm());
			pstmt.setString(cnt++, officeRate.getReq_cnt());
			pstmt.setString(cnt++, officeRate.getCmpet_rate());

			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

}
