package com.multifin.controller;

import java.util.List;

import com.multifin.api.StockDiviInfoAPI;
import com.multifin.model.service.StockDiviInfoService;
import com.multifin.model.vo.StockDiviInfo;

public class StockDiviInfoController {
	private StockDiviInfoService stockDiviInfoService = new StockDiviInfoService();
	// BankDeposit 테이블 초기화
	public void initStockDiviInfo() {
//		
//			
//			List<StockDiviInfo> list = StockDiviInfoAPI.getStockDiviInfo();
//			
//			if (list == null || list.isEmpty()) {
//				continue;
//			}
//			// 가져온 데이터를 DB에 저장
//			for (StockDiviInfo sp : list) {
//				stockDiviInfoService.insert(sp);
//			}
		
	}
	
	public static void main(String[] args) {
		BankDepositController controller = new BankDepositController();
		controller.initBankDeposit();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
	

}
