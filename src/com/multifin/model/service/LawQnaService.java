package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.LawQnaDao;
import com.multifin.model.dao.LawQnaDao;
import com.multifin.model.vo.LawQna;
import com.multifin.model.vo.LawQna;

public class LawQnaService {
	private LawQnaDao dao = new LawQnaDao();
	private Connection conn = null;
	
	public LawQnaService() {
		conn = openConnection();
	}
	
	public int insert(LawQna lawQna) {
		int result = dao.insert(conn,  lawQna);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
}
