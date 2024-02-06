package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.multifin.model.vo.StockDiviInfo;

public class StockDiviInfoDao {
	// 전체 조회
//	public List<StockDiviInfo> selectAll(Connection conn) {
//		List<StockDiviInfo> list = new ArrayList<>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			String sql = "SELECT * FROM StockDiviInfo";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				int count = 1;
//				int StockDiviInfoNo = rs.getInt(count++);
//				String dcls_month = rs.getString(count++);
//				String fin_co_no = rs.getString(count++);
//				String kor_co_nm = rs.getString(count++);
//				String fin_prdt_cd = rs.getString(count++);
//				String fin_prdt_nm = rs.getString(count++);
//				String join_way = rs.getString(count++);
//				String mtrt_int = rs.getString(count++);
//				String spcl_cnd = rs.getString(count++);
//				String join_deny = rs.getString(count++);
//				String join_member = rs.getString(count++);
//				String etc_note = rs.getString(count++);
//				long max_limit = rs.getLong(count++);
//				Date dcls_strt_day = rs.getDate(count++);
//				String dcls_end_day = rs.getString(count++);
//				Date fin_co_subm_day = rs.getDate(count++);
//
//				String intr_rate_type = rs.getString(count++);
//				String intr_rate_type_nm = rs.getString(count++);
//				String save_trm = rs.getString(count++);
//				long intr_rate = rs.getLong(count++);
//				long intr_rate2 = rs.getLong(count++);
//
//				StockDiviInfo info = new StockDiviInfo(StockDiviInfoNo, dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,
//						fin_prdt_nm, join_way, mtrt_int, spcl_cnd, join_deny, join_member, etc_note, max_limit,
//						dcls_strt_day, dcls_end_day, fin_co_subm_day, intr_rate_type, intr_rate_type_nm, save_trm,
//						intr_rate, intr_rate2);
//
//				list.add(info);
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//			close(rs);
//		}
//
//		return list;
//	}

	public int insert(Connection conn, StockDiviInfo stockDiviInfo) {
		try {
			String sql = "insert into StockDiviInfo "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, stockDiviInfo.getSdno());
			pstmt.setDate(cnt++, new Date(stockDiviInfo.getBasDt().getTime()));
			pstmt.setDate(cnt++, new Date(stockDiviInfo.getCashDvdnPayDt().getTime()));
			
			pstmt.setString(cnt++, stockDiviInfo.getCashGrdnDvdnRt());
			pstmt.setString(cnt++, stockDiviInfo.getCrno());
			pstmt.setDate(cnt++, new Date(stockDiviInfo.getDvdnBasDt().getTime()));
			pstmt.setString(cnt++, stockDiviInfo.getIsinCd());
			pstmt.setString(cnt++, stockDiviInfo.getIsinCdNm());
			pstmt.setString(cnt++, stockDiviInfo.getScrsItmsKcd());
			pstmt.setString(cnt++, stockDiviInfo.getScrsItmsKcdNm());
			pstmt.setString(cnt++, stockDiviInfo.getStckDvdnRcd());
			pstmt.setString(cnt++, stockDiviInfo.getStckDvdnRcdNm());
			pstmt.setString(cnt++, stockDiviInfo.getStckGenrCashDvdnRt());
			pstmt.setString(cnt++, stockDiviInfo.getStckGenrDvdnAmt());
			pstmt.setString(cnt++, stockDiviInfo.getStckGenrDvdnRt());
			pstmt.setString(cnt++, stockDiviInfo.getStckGrdnDvdnAmt());
			pstmt.setString(cnt++, stockDiviInfo.getStckGrdnDvdnRt());
			pstmt.setDate(cnt++, new Date(stockDiviInfo.getStckHndvDt().getTime()));
			pstmt.setString(cnt++, stockDiviInfo.getStckIssuCmpyNm());
			pstmt.setString(cnt++, stockDiviInfo.getStckParPrc());
			pstmt.setString(cnt++, stockDiviInfo.getStckStacMd());
			pstmt.setString(cnt++, stockDiviInfo.getTrsnmDptyDcd());
			pstmt.setString(cnt++, stockDiviInfo.getTrsnmDptyDcdNm());

			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
