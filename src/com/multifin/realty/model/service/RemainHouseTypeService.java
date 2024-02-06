package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.RemainHouseTypeDao;
import com.multifin.realty.model.vo.RemainHouseType;

public class RemainHouseTypeService {
	private RemainHouseTypeDao dao = new RemainHouseTypeDao();
	private Connection conn = null;
	
	public RemainHouseTypeService() {
		conn = openConnection();
	}
	
	public int insert(RemainHouseType remainHouseType) {
		int result = dao.insert(conn,  remainHouseType);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
