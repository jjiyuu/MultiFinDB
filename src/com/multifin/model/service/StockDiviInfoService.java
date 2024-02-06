package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.StockDiviInfoDao;
import com.multifin.model.vo.StockDiviInfo;

public class StockDiviInfoService {
	private StockDiviInfoDao dao = new StockDiviInfoDao();
	private Connection conn = null;
	
	public StockDiviInfoService() {
		conn = openConnection();
	}
	
	public int insert(StockDiviInfo stockDiviInfo) {
		int result = dao.insert(conn,  stockDiviInfo);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
