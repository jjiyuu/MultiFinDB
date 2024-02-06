package com.multifin.realty.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.multifin.realty.api.RemainHouseTypeAPI;
import com.multifin.realty.model.service.RemainHouseTypeService;
import com.multifin.realty.model.vo.RemainHouseType;

public class RemainHouseTypeController {
	private RemainHouseTypeService remainHouseTypeService = new RemainHouseTypeService();

	public void initRemainHouseType() {
			// 현재 날짜에 해당하는 데이터 페이지 수 구하기
			int endPage = RemainHouseTypeAPI.getPageNum();
			// 데이터 불러오기
			for (int i = 1; i <= endPage; i++) {
				System.out.println("endPage의 값 : " + endPage + "입니다!");
				List<RemainHouseType> list = RemainHouseTypeAPI.parsing(i);
				// 가져온 리스트가 아무것도 없으면 다시 반복
				if (list == null || list.isEmpty()) {
					continue;
				}
				// 가져온 데이터를 DB에 저장
				for (RemainHouseType sp : list) {
					remainHouseTypeService.insert(sp);
				}
			}
	}
	
	public static void main(String[] args) {
		RemainHouseTypeController controller = new RemainHouseTypeController();
		controller.initRemainHouseType();
		System.out.println("초기화 완료!");
	}
}
