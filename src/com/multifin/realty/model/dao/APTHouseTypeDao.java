package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.APTHouseType;

public class APTHouseTypeDao {
	// 데이터 삽입
		public int insert(Connection conn, APTHouseType aptHouseType) {
			try {
				String sql = "insert into aptHouseType values(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				int cnt = 1;
				pstmt.setInt(cnt++, aptHouseType.getAptHouseNo());
				pstmt.setInt(cnt++, aptHouseType.getEtc_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getHouse_manage_no());
				pstmt.setString(cnt++, aptHouseType.getHouse_ty());
				pstmt.setInt(cnt++, aptHouseType.getInstt_recomend_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getLfe_frst_hshldco());
				pstmt.setString(cnt++, aptHouseType.getLttot_top_amount());
				pstmt.setInt(cnt++, aptHouseType.getMnych_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getNwwds_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getOld_parnts_suport_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getPblanc_no());
				pstmt.setInt(cnt++, aptHouseType.getSpsply_hshldco());
				pstmt.setString(cnt++, aptHouseType.getSuply_ar());
				pstmt.setInt(cnt++, aptHouseType.getSuply_hshldco());
				pstmt.setInt(cnt++, aptHouseType.getTransr_instt_enfsn_hshldco());

				int result = pstmt.executeUpdate();
				
				pstmt.close();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}

}
