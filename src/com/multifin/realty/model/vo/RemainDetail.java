package com.multifin.realty.model.vo;

import java.util.Date;

//APT 무순위/잔여세대 분양정보 상세조회
public class RemainDetail {
	private int remainNo;
	private String bsns_mby_nm;             //사업주체명 (시행사)                                         
    private String cntrct_cncls_bgnde;         //계약시작일                                             
    private String cntrct_cncls_endde;               //계약종료일
    private String gnrl_rcept_bgnde; //특별공급접수시작일
    private String gnrl_rcept_endde; //특별공급접수종료일
    private String hmpg_adres;          			//홈페이지주소   
    private int house_manage_no;		//주택관리번호
    private String house_dtl_secd_nm;     			 //주택상세구분코드명                                                
    private String house_nm;							//주택명 
    private String house_secd_nm;        //주택구분코드명                                              
    private String hssply_adres;          //공급위치                                            
    private String hssply_zip;      //공급위치 우편번호                                                
    private String mdhs_telno;       //문의처                                               
    private String mvn_prearnge_ym;  //입주예정월  
    private int pblanc_no;			//공고번호
    private String pblanc_url;			//분양정보 URL
    
    private String przwner_presnatn_de;			//당첨자발표일
    private String rcrit_pblanc_de;				//모집공고일
    private String spsply_rcept_bgnde;			//특별공급 접수시작일
    private String spsply_rcept_endde;			//특별공급 접수종료일
    private String subscrpt_rcept_bgnde; //청약접수시작일
    private String subscrpt_rcept_endde; //청약접수종료일

    private int tot_suply_hshldco;			//공급규모

	public RemainDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemainDetail(int remainNo, String bsns_mby_nm, String cntrct_cncls_bgnde, String cntrct_cncls_endde,
			String gnrl_rcept_bgnde, String gnrl_rcept_endde, String hmpg_adres, int house_manage_no,
			String house_dtl_secd_nm, String house_nm, String house_secd_nm, String hssply_adres, String hssply_zip,
			String mdhs_telno, String mvn_prearnge_ym, int pblanc_no, String pblanc_url, String przwner_presnatn_de,
			String rcrit_pblanc_de, String spsply_rcept_bgnde, String spsply_rcept_endde, String subscrpt_rcept_bgnde,
			String subscrpt_rcept_endde, int tot_suply_hshldco) {
		super();
		this.remainNo = remainNo;
		this.bsns_mby_nm = bsns_mby_nm;
		this.cntrct_cncls_bgnde = cntrct_cncls_bgnde;
		this.cntrct_cncls_endde = cntrct_cncls_endde;
		this.gnrl_rcept_bgnde = gnrl_rcept_bgnde;
		this.gnrl_rcept_endde = gnrl_rcept_endde;
		this.hmpg_adres = hmpg_adres;
		this.house_manage_no = house_manage_no;
		this.house_dtl_secd_nm = house_dtl_secd_nm;
		this.house_nm = house_nm;
		this.house_secd_nm = house_secd_nm;
		this.hssply_adres = hssply_adres;
		this.hssply_zip = hssply_zip;
		this.mdhs_telno = mdhs_telno;
		this.mvn_prearnge_ym = mvn_prearnge_ym;
		this.pblanc_no = pblanc_no;
		this.pblanc_url = pblanc_url;
		this.przwner_presnatn_de = przwner_presnatn_de;
		this.rcrit_pblanc_de = rcrit_pblanc_de;
		this.spsply_rcept_bgnde = spsply_rcept_bgnde;
		this.spsply_rcept_endde = spsply_rcept_endde;
		this.subscrpt_rcept_bgnde = subscrpt_rcept_bgnde;
		this.subscrpt_rcept_endde = subscrpt_rcept_endde;
		this.tot_suply_hshldco = tot_suply_hshldco;
	}

	@Override
	public String toString() {
		return "RemainDetail [remainNo=" + remainNo + ", bsns_mby_nm=" + bsns_mby_nm + ", cntrct_cncls_bgnde="
				+ cntrct_cncls_bgnde + ", cntrct_cncls_endde=" + cntrct_cncls_endde + ", gnrl_rcept_bgnde="
				+ gnrl_rcept_bgnde + ", gnrl_rcept_endde=" + gnrl_rcept_endde + ", hmpg_adres=" + hmpg_adres
				+ ", house_manage_no=" + house_manage_no + ", house_dtl_secd_nm=" + house_dtl_secd_nm + ", house_nm="
				+ house_nm + ", house_secd_nm=" + house_secd_nm + ", hssply_adres=" + hssply_adres + ", hssply_zip="
				+ hssply_zip + ", mdhs_telno=" + mdhs_telno + ", mvn_prearnge_ym=" + mvn_prearnge_ym + ", pblanc_no="
				+ pblanc_no + ", pblanc_url=" + pblanc_url + ", przwner_presnatn_de=" + przwner_presnatn_de
				+ ", rcrit_pblanc_de=" + rcrit_pblanc_de + ", spsply_rcept_bgnde=" + spsply_rcept_bgnde
				+ ", spsply_rcept_endde=" + spsply_rcept_endde + ", subscrpt_rcept_bgnde=" + subscrpt_rcept_bgnde
				+ ", subscrpt_rcept_endde=" + subscrpt_rcept_endde + ", tot_suply_hshldco=" + tot_suply_hshldco + "]";
	}

	public int getRemainNo() {
		return remainNo;
	}

	public void setRemainNo(int remainNo) {
		this.remainNo = remainNo;
	}

	public String getBsns_mby_nm() {
		return bsns_mby_nm;
	}

	public void setBsns_mby_nm(String bsns_mby_nm) {
		this.bsns_mby_nm = bsns_mby_nm;
	}

	public String getCntrct_cncls_bgnde() {
		return cntrct_cncls_bgnde;
	}

	public void setCntrct_cncls_bgnde(String cntrct_cncls_bgnde) {
		this.cntrct_cncls_bgnde = cntrct_cncls_bgnde;
	}

	public String getCntrct_cncls_endde() {
		return cntrct_cncls_endde;
	}

	public void setCntrct_cncls_endde(String cntrct_cncls_endde) {
		this.cntrct_cncls_endde = cntrct_cncls_endde;
	}

	public String getGnrl_rcept_bgnde() {
		return gnrl_rcept_bgnde;
	}

	public void setGnrl_rcept_bgnde(String gnrl_rcept_bgnde) {
		this.gnrl_rcept_bgnde = gnrl_rcept_bgnde;
	}

	public String getGnrl_rcept_endde() {
		return gnrl_rcept_endde;
	}

	public void setGnrl_rcept_endde(String gnrl_rcept_endde) {
		this.gnrl_rcept_endde = gnrl_rcept_endde;
	}

	public String getHmpg_adres() {
		return hmpg_adres;
	}

	public void setHmpg_adres(String hmpg_adres) {
		this.hmpg_adres = hmpg_adres;
	}

	public int getHouse_manage_no() {
		return house_manage_no;
	}

	public void setHouse_manage_no(int house_manage_no) {
		this.house_manage_no = house_manage_no;
	}

	public String getHouse_dtl_secd_nm() {
		return house_dtl_secd_nm;
	}

	public void setHouse_dtl_secd_nm(String house_dtl_secd_nm) {
		this.house_dtl_secd_nm = house_dtl_secd_nm;
	}

	public String getHouse_nm() {
		return house_nm;
	}

	public void setHouse_nm(String house_nm) {
		this.house_nm = house_nm;
	}

	public String getHouse_secd_nm() {
		return house_secd_nm;
	}

	public void setHouse_secd_nm(String house_secd_nm) {
		this.house_secd_nm = house_secd_nm;
	}

	public String getHssply_adres() {
		return hssply_adres;
	}

	public void setHssply_adres(String hssply_adres) {
		this.hssply_adres = hssply_adres;
	}

	public String getHssply_zip() {
		return hssply_zip;
	}

	public void setHssply_zip(String hssply_zip) {
		this.hssply_zip = hssply_zip;
	}

	public String getMdhs_telno() {
		return mdhs_telno;
	}

	public void setMdhs_telno(String mdhs_telno) {
		this.mdhs_telno = mdhs_telno;
	}

	public String getMvn_prearnge_ym() {
		return mvn_prearnge_ym;
	}

	public void setMvn_prearnge_ym(String mvn_prearnge_ym) {
		this.mvn_prearnge_ym = mvn_prearnge_ym;
	}

	public int getPblanc_no() {
		return pblanc_no;
	}

	public void setPblanc_no(int pblanc_no) {
		this.pblanc_no = pblanc_no;
	}

	public String getPblanc_url() {
		return pblanc_url;
	}

	public void setPblanc_url(String pblanc_url) {
		this.pblanc_url = pblanc_url;
	}

	public String getPrzwner_presnatn_de() {
		return przwner_presnatn_de;
	}

	public void setPrzwner_presnatn_de(String przwner_presnatn_de) {
		this.przwner_presnatn_de = przwner_presnatn_de;
	}

	public String getRcrit_pblanc_de() {
		return rcrit_pblanc_de;
	}

	public void setRcrit_pblanc_de(String rcrit_pblanc_de) {
		this.rcrit_pblanc_de = rcrit_pblanc_de;
	}

	public String getSpsply_rcept_bgnde() {
		return spsply_rcept_bgnde;
	}

	public void setSpsply_rcept_bgnde(String spsply_rcept_bgnde) {
		this.spsply_rcept_bgnde = spsply_rcept_bgnde;
	}

	public String getSpsply_rcept_endde() {
		return spsply_rcept_endde;
	}

	public void setSpsply_rcept_endde(String spsply_rcept_endde) {
		this.spsply_rcept_endde = spsply_rcept_endde;
	}

	public String getSubscrpt_rcept_bgnde() {
		return subscrpt_rcept_bgnde;
	}

	public void setSubscrpt_rcept_bgnde(String subscrpt_rcept_bgnde) {
		this.subscrpt_rcept_bgnde = subscrpt_rcept_bgnde;
	}

	public String getSubscrpt_rcept_endde() {
		return subscrpt_rcept_endde;
	}

	public void setSubscrpt_rcept_endde(String subscrpt_rcept_endde) {
		this.subscrpt_rcept_endde = subscrpt_rcept_endde;
	}

	public int getTot_suply_hshldco() {
		return tot_suply_hshldco;
	}

	public void setTot_suply_hshldco(int tot_suply_hshldco) {
		this.tot_suply_hshldco = tot_suply_hshldco;
	}

	
}
