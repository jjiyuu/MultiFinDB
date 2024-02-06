package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.APTHouseTypeDao;
import com.multifin.realty.model.vo.APTHouseType;

public class APTHouseTypeService {
	private APTHouseTypeDao dao = new APTHouseTypeDao();
	private Connection conn = null;
	
	public APTHouseTypeService() {
		conn = openConnection();
	}
	
	public int insert(APTHouseType aptHouseType) {
		int result = dao.insert(conn,  aptHouseType);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}

}
