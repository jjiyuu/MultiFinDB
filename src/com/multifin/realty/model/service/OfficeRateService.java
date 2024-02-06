package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.OfficeRateDao;
import com.multifin.realty.model.vo.OfficeRate;

public class OfficeRateService {
	private OfficeRateDao dao = new OfficeRateDao();
	private Connection conn = null;
	
	public OfficeRateService() {
		conn = openConnection();
	}
	
	public int insert(OfficeRate officeRate) {
		int result = dao.insert(conn,  officeRate);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
