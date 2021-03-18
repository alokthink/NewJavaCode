package com.mps.think.setup.model;

public class PromotionCardEffort {

	private int promotionCardEffortId;
	private int promotionCardId;
	private int toEffort;
	private int sourceCodeId;
	private int mruPromotionCardOfferSeq;
	private int discountClassId;
	private int rateClassId;
	public int getPromotionCardEffortId() {
		return promotionCardEffortId;
	}
	public void setPromotionCardEffortId(int promotionCardEffortId) {
		this.promotionCardEffortId = promotionCardEffortId;
	}
	public int getPromotionCardId() {
		return promotionCardId;
	}
	public void setPromotionCardId(int promotionCardId) {
		this.promotionCardId = promotionCardId;
	}
	public int getToEffort() {
		return toEffort;
	}
	public void setToEffort(int toEffort) {
		this.toEffort = toEffort;
	}
	public int getSourceCodeId() {
		return sourceCodeId;
	}
	public void setSourceCodeId(int sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}
	public int getMruPromotionCardOfferSeq() {
		return mruPromotionCardOfferSeq;
	}
	public void setMruPromotionCardOfferSeq(int mruPromotionCardOfferSeq) {
		this.mruPromotionCardOfferSeq = mruPromotionCardOfferSeq;
	}
	public int getDiscountClassId() {
		return discountClassId;
	}
	public void setDiscountClassId(int discountClassId) {
		this.discountClassId = discountClassId;
	}
	public int getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}
	@Override
	public String toString() {
		return "PromotionCardEffort [promotionCardEffortId=" + promotionCardEffortId + ", promotionCardId="
				+ promotionCardId + ", toEffort=" + toEffort + ", sourceCodeId=" + sourceCodeId
				+ ", mruPromotionCardOfferSeq=" + mruPromotionCardOfferSeq + ", discountClassId=" + discountClassId
				+ ", rateClassId=" + rateClassId + "]";
	}
}
