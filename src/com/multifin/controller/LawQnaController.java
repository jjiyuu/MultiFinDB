package com.multifin.controller;

import java.util.List;

import com.multifin.api.LawQnaAPI;
import com.multifin.model.service.LawQnaService;
import com.multifin.model.vo.LawQna;

public class LawQnaController {
	private LawQnaService lawQnaService = new LawQnaService();
	// LawQna 테이블 초기화
	public void initLawQna() {
		int pageNum = 1;
		int endPage = LawQnaAPI.getPageNum();
		System.out.println("endPage 값 :" + endPage + "입니다!");
		
		for (int i = 1; i <= endPage; i++) {
			List<LawQna> list = LawQnaAPI.getLawdu(i);
			// 가져온 리스트가 아무것도 없으면 다시 반복
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (LawQna sp : list) {
				lawQnaService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		LawQnaController controller = new LawQnaController();
		controller.initLawQna();
		System.out.println("초기화 완료!");
	}
}
