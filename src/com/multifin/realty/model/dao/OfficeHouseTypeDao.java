package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.OfficeHouseType;

public class OfficeHouseTypeDao {
	// 데이터 삽입
	public int insert(Connection conn, OfficeHouseType officeHouseType) {
		try {
			String sql = "insert into officeHouseType(officeHouseTypeNo, excluse_ar, gp, house_manage_no, "
					+ "pblanc_no, subscrpt_reqst_amount, suply_amount, suply_hshldco, tp) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			
			pstmt.setInt(cnt++, officeHouseType.getOfficeHouseNo());
			pstmt.setDouble(cnt++, officeHouseType.getExcluse_ar());
			pstmt.setString(cnt++, officeHouseType.getGp());
			pstmt.setInt(cnt++, officeHouseType.getHouse_manage_no());
			pstmt.setInt(cnt++, officeHouseType.getPblanc_no());
			pstmt.setString(cnt++, officeHouseType.getSubscrpt_reqst_amount());
			pstmt.setString(cnt++, officeHouseType.getSuply_amount());
			pstmt.setInt(cnt++, officeHouseType.getSuply_hshldco());
			pstmt.setString(cnt++, officeHouseType.getTp());

			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
