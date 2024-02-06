package com.multifin.realty.model.vo;
//APT 분양정보 주택형별 상세조회
public class APTHouseType {
	private int aptHouseNo;                           
    private int etc_hshldco; //특별공급-기타 세대수
    private int house_manage_no; //주택관리번호
    private String house_ty; //주택형
    private int instt_recomend_hshldco;//특별공급-기관추천 세대수
    private int lfe_frst_hshldco;//특별공급-생애최초 세대수
    private String lttot_top_amount; //공급금액 (분양최고금액) (단위:만원)
    private int mnych_hshldco; //특별공급-다자녀가구 세대수
    private int nwwds_hshldco; //특별공급-신혼부부 세대수
    private int old_parnts_suport_hshldco;//특별공급-노부모부양 세대수
    private int pblanc_no; //공고번호
    private int spsply_hshldco ; //특별공급세대수
    private String suply_ar; //공급면적
    private int suply_hshldco; //일반공급세대수 
    private int transr_instt_enfsn_hshldco ;//특별공급-이전기관 세대수
	public APTHouseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APTHouseType(int aptHouseNo, int etc_hshldco, int house_manage_no, String house_ty,
			int instt_recomend_hshldco, int lfe_frst_hshldco, String lttot_top_amount, int mnych_hshldco,
			int nwwds_hshldco, int old_parnts_suport_hshldco, int pblanc_no, int spsply_hshldco, String suply_ar,
			int suply_hshldco, int transr_instt_enfsn_hshldco) {
		super();
		this.aptHouseNo = aptHouseNo;
		this.etc_hshldco = etc_hshldco;
		this.house_manage_no = house_manage_no;
		this.house_ty = house_ty;
		this.instt_recomend_hshldco = instt_recomend_hshldco;
		this.lfe_frst_hshldco = lfe_frst_hshldco;
		this.lttot_top_amount = lttot_top_amount;
		this.mnych_hshldco = mnych_hshldco;
		this.nwwds_hshldco = nwwds_hshldco;
		this.old_parnts_suport_hshldco = old_parnts_suport_hshldco;
		this.pblanc_no = pblanc_no;
		this.spsply_hshldco = spsply_hshldco;
		this.suply_ar = suply_ar;
		this.suply_hshldco = suply_hshldco;
		this.transr_instt_enfsn_hshldco = transr_instt_enfsn_hshldco;
	}
	@Override
	public String toString() {
		return "APTHouseType [aptHouseNo=" + aptHouseNo + ", etc_hshldco=" + etc_hshldco + ", house_manage_no="
				+ house_manage_no + ", house_ty=" + house_ty + ", instt_recomend_hshldco=" + instt_recomend_hshldco
				+ ", lfe_frst_hshldco=" + lfe_frst_hshldco + ", lttot_top_amount=" + lttot_top_amount
				+ ", mnych_hshldco=" + mnych_hshldco + ", nwwds_hshldco=" + nwwds_hshldco
				+ ", old_parnts_suport_hshldco=" + old_parnts_suport_hshldco + ", pblanc_no=" + pblanc_no
				+ ", spsply_hshldco=" + spsply_hshldco + ", suply_ar=" + suply_ar + ", suply_hshldco=" + suply_hshldco
				+ ", transr_instt_enfsn_hshldco=" + transr_instt_enfsn_hshldco + "]";
	}
	public int getAptHouseNo() {
		return aptHouseNo;
	}
	public void setAptHouseNo(int aptHouseNo) {
		this.aptHouseNo = aptHouseNo;
	}
	public int getEtc_hshldco() {
		return etc_hshldco;
	}
	public void setEtc_hshldco(int etc_hshldco) {
		this.etc_hshldco = etc_hshldco;
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
	public int getInstt_recomend_hshldco() {
		return instt_recomend_hshldco;
	}
	public void setInstt_recomend_hshldco(int instt_recomend_hshldco) {
		this.instt_recomend_hshldco = instt_recomend_hshldco;
	}
	public int getLfe_frst_hshldco() {
		return lfe_frst_hshldco;
	}
	public void setLfe_frst_hshldco(int lfe_frst_hshldco) {
		this.lfe_frst_hshldco = lfe_frst_hshldco;
	}
	public String getLttot_top_amount() {
		return lttot_top_amount;
	}
	public void setLttot_top_amount(String lttot_top_amount) {
		this.lttot_top_amount = lttot_top_amount;
	}
	public int getMnych_hshldco() {
		return mnych_hshldco;
	}
	public void setMnych_hshldco(int mnych_hshldco) {
		this.mnych_hshldco = mnych_hshldco;
	}
	public int getNwwds_hshldco() {
		return nwwds_hshldco;
	}
	public void setNwwds_hshldco(int nwwds_hshldco) {
		this.nwwds_hshldco = nwwds_hshldco;
	}
	public int getOld_parnts_suport_hshldco() {
		return old_parnts_suport_hshldco;
	}
	public void setOld_parnts_suport_hshldco(int old_parnts_suport_hshldco) {
		this.old_parnts_suport_hshldco = old_parnts_suport_hshldco;
	}
	public int getPblanc_no() {
		return pblanc_no;
	}
	public void setPblanc_no(int pblanc_no) {
		this.pblanc_no = pblanc_no;
	}
	public int getSpsply_hshldco() {
		return spsply_hshldco;
	}
	public void setSpsply_hshldco(int spsply_hshldco) {
		this.spsply_hshldco = spsply_hshldco;
	}
	public String getSuply_ar() {
		return suply_ar;
	}
	public void setSuply_ar(String suply_ar) {
		this.suply_ar = suply_ar;
	}
	public int getSuply_hshldco() {
		return suply_hshldco;
	}
	public void setSuply_hshldco(int suply_hshldco) {
		this.suply_hshldco = suply_hshldco;
	}
	public int getTransr_instt_enfsn_hshldco() {
		return transr_instt_enfsn_hshldco;
	}
	public void setTransr_instt_enfsn_hshldco(int transr_instt_enfsn_hshldco) {
		this.transr_instt_enfsn_hshldco = transr_instt_enfsn_hshldco;
	}
	

	
    
	

	
    
    
    
    
	
    
}
