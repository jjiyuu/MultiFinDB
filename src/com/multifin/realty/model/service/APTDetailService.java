package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.APTDetailDao;
import com.multifin.realty.model.vo.APTDetail;

public class APTDetailService {
	private APTDetailDao dao = new APTDetailDao();
	private Connection conn = null;
	
	public APTDetailService() {
		conn = openConnection();
	}
	
	public int insert(APTDetail aptDetail) {
		int result = dao.insert(conn,  aptDetail);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}

}
