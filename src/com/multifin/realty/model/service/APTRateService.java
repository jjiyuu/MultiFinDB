package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.APTRateDao;
import com.multifin.realty.model.vo.APTRate;

public class APTRateService {
	private APTRateDao dao = new APTRateDao();
	private Connection conn = null;
	
	public APTRateService() {
		conn = openConnection();
	}
	
	public int insert(APTRate aptRate) {
		int result = dao.insert(conn,  aptRate);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}

}
