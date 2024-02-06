package com.multifin.controller;

import java.util.List;

import com.multifin.api.BankDepositAPI;
import com.multifin.model.service.BankDepositService;
import com.multifin.model.vo.BankDeposit;

public class BankDepositController {
	private BankDepositService bankDepositService = new BankDepositService();
	// BankDeposit 테이블 초기화
	public void initBankDeposit() {
		// 권역코드
		String[] bankAreaNo = new String[] {"020000", "030200", "030300", "050000", "060000"};
		
		for (String num : bankAreaNo) {
			int endPage = BankDepositAPI.getPageNum(num);
			for (int i = 1; i <= endPage; i++) {
				List<BankDeposit> list = BankDepositAPI.parsingDeposit(num, endPage);
				if (list == null || list.isEmpty()) {
					continue;
				}
				// 가져온 데이터를 DB에 저장
				for (BankDeposit sp : list) {
					bankDepositService.insert(sp);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BankDepositController controller = new BankDepositController();
		controller.initBankDeposit();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
	

}
