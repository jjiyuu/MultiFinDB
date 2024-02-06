package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.OfficeHouseTypeDao;
import com.multifin.realty.model.vo.OfficeHouseType;

public class OfficeHouseTypeService {
	private OfficeHouseTypeDao dao = new OfficeHouseTypeDao();
	private Connection conn = null;
	
	public OfficeHouseTypeService() {
		conn = openConnection();
	}
	
	public int insert(OfficeHouseType officeHouseType) {
		int result = dao.insert(conn,  officeHouseType);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
