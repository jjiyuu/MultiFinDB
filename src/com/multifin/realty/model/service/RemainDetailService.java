package com.multifin.realty.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.realty.model.dao.RemainDetailDao;
import com.multifin.realty.model.vo.RemainDetail;

public class RemainDetailService {
	private RemainDetailDao dao = new RemainDetailDao();
	private Connection conn = null;

	public RemainDetailService() {
		conn = openConnection();
	}

	public int insert(RemainDetail remainDetail) {
		int result = dao.insert(conn, remainDetail);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
