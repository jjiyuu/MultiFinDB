package com.multifin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.multifin.model.vo.LawQna;

public class LawQnaDao {
	
	public int insert(Connection conn, LawQna lawQna) {
		try {
			String sql = "insert into lawQna(LQno, "
					+ "middleCategory, articleNo, answer, "
					+ "mainCategory, question, smallCategory) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, lawQna.getLQno());
			pstmt.setString(cnt++, lawQna.getMiddleCategory());
			pstmt.setString(cnt++, lawQna.getArticleNo());
			pstmt.setString(cnt++, lawQna.getAnswer());
			pstmt.setString(cnt++, lawQna.getMainCategory());
			pstmt.setString(cnt++, lawQna.getQuestion());
			pstmt.setString(cnt++, lawQna.getSmallCategory());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
