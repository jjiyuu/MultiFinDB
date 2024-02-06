package com.multifin.realty.model.vo;
//6) APT 무순위/잔여세대 분양정보 주택형별 상세조회 상세기능 명세
public class RemainHouseType {
	private int remainHouseNo;
	private int house_manage_no;//주택관리번호
    private String house_ty; //모델타입
    private String lttot_top_amoun; //공급금액 (분양최고금액)(단위:만원)
    private int pblanc_no; //공고번호
//    private int SPSPLY_HSHLDCO; //특별공급세대수
//    private String SUPLY_AR; //공급면적
    private int suply_hshldco; //일반공급세대수
	public RemainHouseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RemainHouseType(int remainHouseNo, int house_manage_no, String house_ty, String lttot_top_amoun,
			int pblanc_no, int suply_hshldco) {
		super();
		this.remainHouseNo = remainHouseNo;
		this.house_manage_no = house_manage_no;
		this.house_ty = house_ty;
		this.lttot_top_amoun = lttot_top_amoun;
		this.pblanc_no = pblanc_no;
		this.suply_hshldco = suply_hshldco;
	}
	@Override
	public String toString() {
		return "RemainHouseType [remainHouseNo=" + remainHouseNo + ", house_manage_no=" + house_manage_no
				+ ", house_ty=" + house_ty + ", lttot_top_amoun=" + lttot_top_amoun + ", pblanc_no=" + pblanc_no
				+ ", suply_hshldco=" + suply_hshldco + "]";
	}
	public int getRemainHouseNo() {
		return remainHouseNo;
	}
	public void setRemainHouseNo(int remainHouseNo) {
		this.remainHouseNo = remainHouseNo;
	}
	public int getHouse_manage_no() {
		return house_manage_no;
	}
	public void setHouse_manage_no(int house_manage_no) {
		this.house_manage_no = house_manage_no;
	}
	public String getHouse_ty() {
		return house_ty;
	}
	public void setHouse_ty(String house_ty) {
		this.house_ty = house_ty;
	}
	public String getLttot_top_amoun() {
		return lttot_top_amoun;
	}
	public void setLttot_top_amoun(String lttot_top_amoun) {
		this.lttot_top_amoun = lttot_top_amoun;
	}
	public int getPblanc_no() {
		return pblanc_no;
	}
	public void setPblanc_no(int pblanc_no) {
		this.pblanc_no = pblanc_no;
	}
	public int getSuply_hshldco() {
		return suply_hshldco;
	}
	public void setSuply_hshldco(int suply_hshldco) {
		this.suply_hshldco = suply_hshldco;
	}
























































	

    
	

    
}
