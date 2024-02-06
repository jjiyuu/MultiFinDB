package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.PublicRateDao;
import com.multifin.realty.model.vo.PublicRate;

public class PublicRateService {
	private PublicRateDao dao = new PublicRateDao();
	private Connection conn = null;
	
	public PublicRateService() {
		conn = openConnection();
	}
	
	public int insert(PublicRate publicRate) {
		int result = dao.insert(conn,  publicRate);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
