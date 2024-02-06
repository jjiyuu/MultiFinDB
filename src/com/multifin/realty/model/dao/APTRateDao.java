package com.multifin.realty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.multifin.realty.model.vo.APTRate;

public class APTRateDao {
	// 데이터 삽입
		public int insert(Connection conn, APTRate aptRate) {
			try {
				String sql = "insert into APTRate(aptRateNo, house_manage_no, pblanc_no, house_ty, "
						+ "reside_senm, subscrpt_rank_code, suply_hshldco, req_cnt, "
						+ "cmpet_rate, lwet_score, top_score, avrg_score) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				int cnt = 1;
				pstmt.setInt(cnt++, aptRate.getAptRateNo());
				pstmt.setInt(cnt++, aptRate.getHouse_manage_no());
				pstmt.setInt(cnt++, aptRate.getPblanc_no());
				pstmt.setString(cnt++, aptRate.getHouse_ty());
				pstmt.setString(cnt++, aptRate.getReside_senm());
				pstmt.setInt(cnt++, aptRate.getSubscrpt_rank_code());
				pstmt.setInt(cnt++, aptRate.getSuply_hshldco());
				pstmt.setString(cnt++, aptRate.getReq_cnt());
				pstmt.setString(cnt++, aptRate.getCmpet_rate());

				pstmt.setInt(cnt++, aptRate.getLwet_score());
				pstmt.setInt(cnt++, aptRate.getTop_score());
				pstmt.setInt(cnt++, aptRate.getAvrg_score());

				int result = pstmt.executeUpdate();
				
				pstmt.close();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}

}
