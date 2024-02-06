package com.multifin.realty.model.vo;
//오피스텔/도시형/민간임대 분양정보/경쟁률 조회
public class OfficeRate {
	private int officeRateNo;
	private int house_manage_no      ;//주택관리번호
	private int pblanc_no            ;//공고번호

	private String house_ty             ;//주택형
	private int suply_hshldco        ;//공급세대수
	private String residnt_prior_at     ;//거주자 우선여부
	private String resident_prior_senm  ;//공급구분명
	private String req_cnt              ;//접수건수
	private String cmpet_rate           ;//경쟁률
	public OfficeRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OfficeRate(int officeRateNo, int house_manage_no, int pblanc_no, String house_ty, int suply_hshldco,
			String residnt_prior_at, String resident_prior_senm, String req_cnt, String cmpet_rate) {
		super();
		this.officeRateNo = officeRateNo;
		this.house_manage_no = house_manage_no;
		this.pblanc_no = pblanc_no;
		this.house_ty = house_ty;
		this.suply_hshldco = suply_hshldco;
		this.residnt_prior_at = residnt_prior_at;
		this.resident_prior_senm = resident_prior_senm;
		this.req_cnt = req_cnt;
		this.cmpet_rate = cmpet_rate;
	}
	@Override
	public String toString() {
		return "OfficeRate [officeRateNo=" + officeRateNo + ", house_manage_no=" + house_manage_no + ", pblanc_no="
				+ pblanc_no + ", house_ty=" + house_ty + ", suply_hshldco=" + suply_hshldco + ", residnt_prior_at="
				+ residnt_prior_at + ", resident_prior_senm=" + resident_prior_senm + ", req_cnt=" + req_cnt
				+ ", cmpet_rate=" + cmpet_rate + "]";
	}
	public int getOfficeRateNo() {
		return officeRateNo;
	}
	public void setOfficeRateNo(int officeRateNo) {
		this.officeRateNo = officeRateNo;
	}
	public int getHouse_manage_no() {
		return house_manage_no;
	}
	public void setHouse_manage_no(int house_manage_no) {
		this.house_manage_no = house_manage_no;
	}
	public int getPblanc_no() {
		return pblanc_no;
	}
	public void setPblanc_no(int pblanc_no) {
		this.pblanc_no = pblanc_no;
	}
	public String getHouse_ty() {
		return house_ty;
	}
	public void setHouse_ty(String house_ty) {
		this.house_ty = house_ty;
	}
	public int getSuply_hshldco() {
		return suply_hshldco;
	}
	public void setSuply_hshldco(int suply_hshldco) {
		this.suply_hshldco = suply_hshldco;
	}
	public String getResidnt_prior_at() {
		return residnt_prior_at;
	}
	public void setResidnt_prior_at(String residnt_prior_at) {
		this.residnt_prior_at = residnt_prior_at;
	}
	public String getResident_prior_senm() {
		return resident_prior_senm;
	}
	public void setResident_prior_senm(String resident_prior_senm) {
		this.resident_prior_senm = resident_prior_senm;
	}
	public String getReq_cnt() {
		return req_cnt;
	}
	public void setReq_cnt(String req_cnt) {
		this.req_cnt = req_cnt;
	}
	public String getCmpet_rate() {
		return cmpet_rate;
	}
	public void setCmpet_rate(String cmpet_rate) {
		this.cmpet_rate = cmpet_rate;
	}
	
	
	

}
