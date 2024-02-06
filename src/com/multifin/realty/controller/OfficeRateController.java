package com.multifin.realty.controller;

import java.util.List;

import com.multifin.realty.api.OfficeRateAPI;
import com.multifin.realty.model.service.OfficeRateService;
import com.multifin.realty.model.vo.OfficeRate;

public class OfficeRateController {
	private OfficeRateService officeRateService = new OfficeRateService();
	// OfficeRate 테이블 초기화
	public void initOfficeRate() {
		int endPage = OfficeRateAPI.getPageNum();
		
		for (int i = 1; i <= endPage; i++) {
			List<OfficeRate> list = OfficeRateAPI.parsing(i);
			
			for (OfficeRate l: list) {
				officeRateService.insert(l);
			}
		}
	}
	
	public static void main(String[] args) {
		OfficeRateController controller = new OfficeRateController();
		controller.initOfficeRate();
		System.out.println("초기화 완료!");
	}
}
