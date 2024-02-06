package com.multifin.realty.controller;

import java.util.List;

import com.multifin.realty.api.APTHouseTypeAPI;
import com.multifin.realty.model.service.APTHouseTypeService;
import com.multifin.realty.model.vo.APTHouseType;

public class APTHouseTypeController {
	private APTHouseTypeService aptHouseTypeService = new APTHouseTypeService();
	// aptHouseType 테이블 초기화
	public void initaptHouseType() {
		int pageNum = 1; 

		List<APTHouseType> list = APTHouseTypeAPI.parsing("1");
		
		for (APTHouseType l: list) {
			aptHouseTypeService.insert(l);
		}
	}
	
	public static void main(String[] args) {
		APTHouseTypeController controller = new APTHouseTypeController();
		controller.initaptHouseType();
		System.out.println("aptHouseType Table 초기화 완료.");
	}
}
