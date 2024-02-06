package com.multifin.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.parser.ParseException;

import com.multifin.controller.BankCompanyController;
import com.multifin.controller.BankDepositController;
import com.multifin.controller.BankSavingController;
import com.multifin.controller.ExchangeRateController;
import com.multifin.controller.FundProductInfoController;
import com.multifin.controller.LawQnaController;
import com.multifin.controller.LoanCreditController;
import com.multifin.controller.LoanMortgageController;
import com.multifin.controller.LoanRentHouseController;
import com.multifin.controller.RealEstateController;
import com.multifin.controller.RealEstateXYController;
import com.multifin.controller.StockPriceController;
import com.multifin.realty.controller.APTDetailController;
import com.multifin.realty.controller.APTHouseTypeController;
import com.multifin.realty.controller.APTRateController;
import com.multifin.realty.controller.OfficeDetailController;
import com.multifin.realty.controller.OfficeHouseTypeController;
import com.multifin.realty.controller.OfficeRateController;
import com.multifin.realty.controller.PublicRateController;
import com.multifin.realty.controller.RemainDetailController;
import com.multifin.realty.controller.RemainHouseTypeController;

public class MultiFinMenu {
	// 은행 파트
	private BankCompanyController bankCompanyController = new BankCompanyController();
	private BankDepositController bankDepositController = new BankDepositController();
	private BankSavingController bankSavingController = new BankSavingController();
	private LoanCreditController loanCreditController = new LoanCreditController();
	private LoanMortgageController loanMortgageController = new LoanMortgageController();
	private LoanRentHouseController loanRentHouseController = new LoanRentHouseController();
	// 증권 파트
	private ExchangeRateController exchangeRateController = new ExchangeRateController();
	private FundProductInfoController fundProductInfoController = new FundProductInfoController();
	private StockPriceController stockPriceController = new StockPriceController();
	// 부동산 파트
	private APTDetailController aptDetailController = new APTDetailController();
	private APTHouseTypeController aptHouseTypeController = new APTHouseTypeController();
	private APTRateController aptRateController = new APTRateController();
	
	private RemainDetailController remainDetailController = new RemainDetailController();
	private RemainHouseTypeController remainHouseTypeController = new RemainHouseTypeController();
	
	private OfficeDetailController officeDetailController = new OfficeDetailController();
	private OfficeRateController officeRateController = new OfficeRateController();
	private OfficeHouseTypeController officeHouseTypeController = new OfficeHouseTypeController();
	
	private PublicRateController publicRateController = new PublicRateController();
	private RealEstateController realEstateController = new RealEstateController();
	private RealEstateXYController realEstateXYController = new RealEstateXYController();
	
	// 법률 및 뉴스 파트
	private LawQnaController lawQnaController = new LawQnaController();

	public void mainMenu() throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String menu = "========== MULTIFIN DATABASE 초기화 프로그램 ===========\n" 
				+ "1.은행파트 DB 초기화\n" 
				+ "2.증권파트 DB 초기화\n"
				+ "3.부동산 파트 DB 초기화\n" 
				+ "4. 뉴스 및 법률 파트 DB 초기화\n" 
				+ "5. RealEstate 테이블 (별개) 초기화"
				+ "0.프로그램 끝내기\n"
				+ "---------------------------------------------\n" + "선택 : ";

		while (true) {
			System.out.print(menu);
			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				System.out.println("DB 초기화를 실행합니다. 시간이 다소 걸릴 수 있습니다!");
				bankCompanyController.initBankCompany(); // 금융회사 정보
				bankDepositController.initBankDeposit(); // 정기예금 정보
				bankSavingController.initBankSaving(); // 적금 정보
				loanCreditController.initLoanCredit(); // 개인신용대출상품 정보
				loanMortgageController.initLoanMortgage(); // 주택담보대출 정보
				loanRentHouseController.initLoanRentHouse(); // 전세자금대출 정보
				System.out.println("완료되었습니다!");

				break;
				
			case 2:
				System.out.println("DB 초기화를 실행합니다. 시간이 다소 걸릴 수 있습니다!");
				exchangeRateController.initExchangeRate(); // 환율 정보
				fundProductInfoController.initFundProductInfo(); // 펀드 기본정보
				stockPriceController.initStockPrice(); // 주식 시세 정보
				System.out.println("완료되었습니다!");
				break;
				
			case 3:
				System.out.println("DB 초기화를 실행합니다. 시간이 다소 걸릴 수 있습니다!");
				aptDetailController.initAPTDetail(); // APT 분양정보 상세조회 (청약 아파트 분양정보)
				aptHouseTypeController.initaptHouseType(); // APT 분양정보 주택형별 상세조회 정보
				aptRateController.initAPTRate(); // APT 분양정보/경쟁률 정보
				
				officeDetailController.initOfficeDetail(); // 오피스텔/도시형/민간임대 분양정보 상세조회
				officeHouseTypeController.initOfficeHouseType();
				officeRateController.initOfficeRate(); // 오피스텔/도시형/민간임대 분양정보/경쟁률 조회 정보
				
				publicRateController.initPublicRate(); // 공공지원 민간임대 분양정보/경쟁률 조회 정보
				
				remainDetailController.initRemainDetail();	// APT 무순위/잔여세대 분양정보 상세조회 정보인데 오류때문에 잠시 비활성화.
				remainHouseTypeController.initRemainHouseType(); // APT 무순위/잔여세대 분양정보 주택형별 상세조회 상세기능 명세 정보
				
				System.out.println("완료되었습니다!");
				break;
				
			case 4:
				System.out.println("DB 초기화를 실행합니다. 시간이 다소 걸릴 수 있습니다!");
				lawQnaController.initLawQna(); // 법무부_생활법률지식 정보
				System.out.println("완료되었습니다!");
				break;
				
			case 5:
				System.out.println("DB 초기화를 실행합니다. 시간이 다소 걸릴 수 있습니다!");
				realEstateController.initRealEstate(); // 부동산 정보
				realEstateXYController.initRealEstate(); // 좌표 정보 초기화
				System.out.println("완료되었습니다!");
				break;
				
			case 0:
				System.out.print("정말로 끝내시겠습니까?(y/n) : ");
				if (br.readLine().equalsIgnoreCase("y")) {
					return;
				}
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!");
			}
		}
	}
}
