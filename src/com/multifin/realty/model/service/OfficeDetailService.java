package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.OfficeDetailDao;
import com.multifin.realty.model.vo.OfficeDetail;

public class OfficeDetailService {
	private OfficeDetailDao dao = new OfficeDetailDao();
	private Connection conn = null;
	
	public OfficeDetailService() {
		conn = openConnection();
	}
	
	public int insert(OfficeDetail officeDetail) {
		int result = dao.insert(conn,  officeDetail);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
