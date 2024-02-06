package com.multifin.realty.controller;

import java.util.List;

import com.multifin.realty.api.OfficeHouseTypeAPI;
import com.multifin.realty.model.service.OfficeHouseTypeService;
import com.multifin.realty.model.vo.OfficeHouseType;

public class OfficeHouseTypeController {
	private OfficeHouseTypeService officeHouseTypeService = new OfficeHouseTypeService();
	
	public void initOfficeHouseType() {
		int endPage = OfficeHouseTypeAPI.getPageNum();
		
		for (int i = 1; i <= endPage; i++) {
			List<OfficeHouseType> list = OfficeHouseTypeAPI.parsing(i);
			
			for (OfficeHouseType elem : list) {
				officeHouseTypeService.insert(elem);
			}
		}
	}
	
	public static void main(String[] args) {
		OfficeHouseTypeController controller = new OfficeHouseTypeController();
		controller.initOfficeHouseType();
		System.out.println("초기화 완료!");
	}
}
