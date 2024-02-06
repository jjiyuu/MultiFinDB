package com.multifin.realty.controller;

import java.util.List;

import com.multifin.realty.api.APTRateAPI;
import com.multifin.realty.model.service.APTRateService;
import com.multifin.realty.model.vo.APTRate;

public class APTRateController {
	private APTRateService aptRateService = new APTRateService();
	// APTRate 테이블 초기화
	public void initAPTRate() {
		int pageNum = 1; 

		List<APTRate> list = APTRateAPI.parsing("1");
		
		for (APTRate l: list) {
			aptRateService.insert(l);
		}
	}
	
	public static void main(String[] args) {
		APTRateController controller = new APTRateController();
		controller.initAPTRate();
		System.out.println("APTRate Table 초기화 완료.");
	}
}
