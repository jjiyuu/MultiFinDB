package com.multifin.realty.controller;

import java.util.List;

import com.multifin.realty.api.PublicRateAPI;
import com.multifin.realty.model.service.PublicRateService;
import com.multifin.realty.model.vo.PublicRate;

public class PublicRateController {
	private PublicRateService publicRateService = new PublicRateService();
	// PublicRate 테이블 초기화
	public void initPublicRate() {
		int endPage = PublicRateAPI.getPageNum();
		
		for (int i = 1; i <= endPage; i++) {
			List<PublicRate> list = PublicRateAPI.parsing(i);
			
			for (PublicRate l: list) {
				publicRateService.insert(l);
			}
		}
	}
	
	public static void main(String[] args) {
		PublicRateController controller = new PublicRateController();
		controller.initPublicRate();
		System.out.println("초기화 완료!");
	}
}
