package com.multifin.realty.model.vo;
//공공지원 민간임대 분양정보/경쟁률 조회
public class PublicRate {
	private int pubNo;
	private int house_manage_no     ;//주택관리번호
	private int pblanc_no           ;//공고번호
//	private String model_no            ;//모델번호
	private String house_ty            ;//주택형
	private int suply_hshldco       ;//공급세대수
//	private String spsply_knd_code     ;//공급유형코드
	private String spsply_knd_nm       ;//공급유형
	private int spsply_knd_hshldco  ;//배정세대수
	private String req_cnt             ;//접수건수
	private String cmpet_rate          ;//경쟁률
	public PublicRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PublicRate(int pubNo, int house_manage_no, int pblanc_no, String house_ty, int suply_hshldco,
			String spsply_knd_nm, int spsply_knd_hshldco, String req_cnt, String cmpet_rate) {
		super();
		this.pubNo = pubNo;
		this.house_manage_no = house_manage_no;
		this.pblanc_no = pblanc_no;
		this.house_ty = house_ty;
		this.suply_hshldco = suply_hshldco;
		this.spsply_knd_nm = spsply_knd_nm;
		this.spsply_knd_hshldco = spsply_knd_hshldco;
		this.req_cnt = req_cnt;
		this.cmpet_rate = cmpet_rate;
	}
	@Override
	public String toString() {
		return "PublicRate [pubNo=" + pubNo + ", house_manage_no=" + house_manage_no + ", pblanc_no=" + pblanc_no
				+ ", house_ty=" + house_ty + ", suply_hshldco=" + suply_hshldco + ", spsply_knd_nm=" + spsply_knd_nm
				+ ", spsply_knd_hshldco=" + spsply_knd_hshldco + ", req_cnt=" + req_cnt + ", cmpet_rate=" + cmpet_rate
				+ "]";
	}
	public int getPubNo() {
		return pubNo;
	}
	public void setPubNo(int pubNo) {
		this.pubNo = pubNo;
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
	public String getSpsply_knd_nm() {
		return spsply_knd_nm;
	}
	public void setSpsply_knd_nm(String spsply_knd_nm) {
		this.spsply_knd_nm = spsply_knd_nm;
	}
	public int getSpsply_knd_hshldco() {
		return spsply_knd_hshldco;
	}
	public void setSpsply_knd_hshldco(int spsply_knd_hshldco) {
		this.spsply_knd_hshldco = spsply_knd_hshldco;
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
