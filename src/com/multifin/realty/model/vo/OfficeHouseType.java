package com.multifin.realty.model.vo;
//오피스텔/도시형/민간임대 분양정보 주택형별 상세조회
public class OfficeHouseType {

	private int officeHouseNo;
	private double excluse_ar; //전용면적
    private String gp;  //군 ??
    private int house_manage_no; //주택관리번호
    private int pblanc_no; //공고번호
    private String subscrpt_reqst_amount; //청약신청금
    private String suply_amount; //공급금액 (분양최고금액)
    private int suply_hshldco; //공급세대수
    private String tp; //타입 ??
	public OfficeHouseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OfficeHouseType(int officeHouseNo, double excluse_ar, String gp, int house_manage_no, int pblanc_no,
			String subscrpt_reqst_amount, String suply_amount, int suply_hshldco, String tp) {
		super();
		this.officeHouseNo = officeHouseNo;
		this.excluse_ar = excluse_ar;
		this.gp = gp;
		this.house_manage_no = house_manage_no;
		this.pblanc_no = pblanc_no;
		this.subscrpt_reqst_amount = subscrpt_reqst_amount;
		this.suply_amount = suply_amount;
		this.suply_hshldco = suply_hshldco;
		this.tp = tp;
	}
	@Override
	public String toString() {
		return "OfficeHouseType [officeHouseNo=" + officeHouseNo + ", excluse_ar=" + excluse_ar + ", gp=" + gp
				+ ", house_manage_no=" + house_manage_no + ", pblanc_no=" + pblanc_no + ", subscrpt_reqst_amount="
				+ subscrpt_reqst_amount + ", suply_amount=" + suply_amount + ", suply_hshldco=" + suply_hshldco
				+ ", tp=" + tp + "]";
	}
	public int getOfficeHouseNo() {
		return officeHouseNo;
	}
	public void setOfficeHouseNo(int officeHouseNo) {
		this.officeHouseNo = officeHouseNo;
	}
	public double getExcluse_ar() {
		return excluse_ar;
	}
	public void setExcluse_ar(double excluse_ar) {
		this.excluse_ar = excluse_ar;
	}
	public String getGp() {
		return gp;
	}
	public void setGp(String gp) {
		this.gp = gp;
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
	public String getSubscrpt_reqst_amount() {
		return subscrpt_reqst_amount;
	}
	public void setSubscrpt_reqst_amount(String subscrpt_reqst_amount) {
		this.subscrpt_reqst_amount = subscrpt_reqst_amount;
	}
	public String getSuply_amount() {
		return suply_amount;
	}
	public void setSuply_amount(String suply_amount) {
		this.suply_amount = suply_amount;
	}
	public int getSuply_hshldco() {
		return suply_hshldco;
	}
	public void setSuply_hshldco(int suply_hshldco) {
		this.suply_hshldco = suply_hshldco;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	
    
	
	
	

}
