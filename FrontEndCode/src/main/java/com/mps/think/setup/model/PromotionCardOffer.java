package com.mps.think.setup.model;

public class PromotionCardOffer {

	private int promotionCardOfferSeq;
	private int promotionCardId;
	private int promotionCardEffortId;
	private int rateClassId;
	private int orderCodeId;
	private int productId;
	private int subscriptionDefId;
	private String description;
	private int pkgDefId;
	
	public int getPromotionCardId() {
		return promotionCardId;
	}
	public void setPromotionCardId(int promotionCardId) {
		this.promotionCardId = promotionCardId;
	}
	public int getPromotionCardEffortId() {
		return promotionCardEffortId;
	}
	public void setPromotionCardEffortId(int promotionCardEffortId) {
		this.promotionCardEffortId = promotionCardEffortId;
	}
	public int getPromotionCardOfferSeq() {
		return promotionCardOfferSeq;
	}
	public void setPromotionCardOfferSeq(int promotionCardOfferSeq) {
		this.promotionCardOfferSeq = promotionCardOfferSeq;
	}
	public int getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(int subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPkgDefId() {
		return pkgDefId;
	}
	public void setPkgDefId(int pkgDefId) {
		this.pkgDefId = pkgDefId;
	}
	
}
