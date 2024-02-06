package com.multifin.realty.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.multifin.realty.api.OfficeDetailAPI;
import com.multifin.realty.model.service.OfficeDetailService;
import com.multifin.realty.model.vo.OfficeDetail;

public class OfficeDetailController {
	private OfficeDetailService officeDetailService = new OfficeDetailService();
	// OfficeDetail 테이블 초기화
	public void initOfficeDetail() {
		Calendar cal = new GregorianCalendar(2023, 0, 1); // 2023년 1월 1일
		Calendar today = Calendar.getInstance();
		
		while (true) {
			System.out.println(cal.getTime()); // 현재 날짜
			// 현재 날짜에 해당하는 데이터 페이지 수 구하기
			int endPage = OfficeDetailAPI.getPageNum(cal.getTime());
			// 데이터 불러오기
			for (int i = 1; i <= endPage; i++) {
				List<OfficeDetail> list = OfficeDetailAPI.parsing(cal.getTime(), i);
				// 가져온 리스트가 아무것도 없으면 다시 반복
				if (list == null || list.isEmpty()) {
					continue;
				}
				// 가져온 데이터를 DB에 저장
				for (OfficeDetail sp : list) {
					officeDetailService.insert(sp);
				}
			}
		
			cal.add(Calendar.DATE, 1);
			
			if (cal.after(today) == true) {
				break;
			}
		}	
	}
	
	public static void main(String[] args) {
		OfficeDetailController controller = new OfficeDetailController();
		controller.initOfficeDetail();
		System.out.println("초기화 완료!");
	}
}
