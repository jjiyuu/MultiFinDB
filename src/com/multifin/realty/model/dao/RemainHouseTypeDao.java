package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.RemainHouseType;

public class RemainHouseTypeDao {
	// 데이터 삽입
	public int insert(Connection conn, RemainHouseType remainHouseType) {
		try {
			String sql = "insert into remainHouseType(remainHouseNo,"
					+ "house_manage_no, house_ty, lttot_top_amoun, "
					+ "pblanc_no, suply_hshldco)"
					+ " values(?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, remainHouseType.getRemainHouseNo());
			pstmt.setInt(cnt++, remainHouseType.getHouse_manage_no());
			pstmt.setString(cnt++, remainHouseType.getHouse_ty());
			pstmt.setString(cnt++, remainHouseType.getLttot_top_amoun());
			pstmt.setInt(cnt++, remainHouseType.getPblanc_no());
			pstmt.setInt(cnt++, remainHouseType.getSuply_hshldco());

			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
