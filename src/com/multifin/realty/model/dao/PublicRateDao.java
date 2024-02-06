package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.PublicRate;

public class PublicRateDao {
	// 데이터 삽입
	public int insert(Connection conn, PublicRate publicRate) {
		try {
			String sql = "insert into publicRate(pubNo, "
					+ "house_manage_no, pblanc_no, house_ty, "
					+ "suply_hshldco, spsply_knd_nm, spsply_knd_hshldco,"
					+ "req_cnt, cmpet_rate) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, publicRate.getPubNo());
			pstmt.setInt(cnt++, publicRate.getHouse_manage_no());
			pstmt.setInt(cnt++, publicRate.getPblanc_no());
			pstmt.setString(cnt++, publicRate.getHouse_ty());
			pstmt.setInt(cnt++, publicRate.getSuply_hshldco());
			pstmt.setString(cnt++, publicRate.getSpsply_knd_nm());
			pstmt.setInt(cnt++, publicRate.getSpsply_knd_hshldco());
			pstmt.setString(cnt++, publicRate.getReq_cnt());
			pstmt.setString(cnt++, publicRate.getCmpet_rate());
			
			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
