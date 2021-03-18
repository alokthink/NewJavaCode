package com.mps.think.model;

public class JournalDepositModel {
	private int customerId;
	private int paymentSeq;
	private int postingReference;
	private String postingReferenceDesc;
	private float amount;
	private int debitAccount;
	private String debitAccountDesc;
	private int creditAccount;
	private String creditAccountDesc;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPaymentSeq() {
		return paymentSeq;
	}
	public void setPaymentSeq(int paymentSeq) {
		this.paymentSeq = paymentSeq;
	}
	public int getPostingReference() {
		return postingReference;
	}
	public void setPostingReference(int postingReference) {
		this.postingReference = postingReference;
	}
	public String getPostingReferenceDesc() {
		return postingReferenceDesc;
	}
	public void setPostingReferenceDesc(String postingReferenceDesc) {
		this.postingReferenceDesc = postingReferenceDesc;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount(int debitAccount) {
		this.debitAccount = debitAccount;
	}
	public String getDebitAccountDesc() {
		return debitAccountDesc;
	}
	public void setDebitAccountDesc(String debitAccountDesc) {
		this.debitAccountDesc = debitAccountDesc;
	}
	public int getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(int creditAccount) {
		this.creditAccount = creditAccount;
	}
	public String getCreditAccountDesc() {
		return creditAccountDesc;
	}
	public void setCreditAccountDesc(String creditAccountDesc) {
		this.creditAccountDesc = creditAccountDesc;
	}
	@Override
	public String toString() {
		return "JournalDepositModel [customerId=" + customerId + ", paymentSeq=" + paymentSeq + ", postingReference="
				+ postingReference + ", postingReferenceDesc=" + postingReferenceDesc + ", amount=" + amount
				+ ", debitAccount=" + debitAccount + ", debitAccountDesc=" + debitAccountDesc + ", creditAccount="
				+ creditAccount + ", creditAccountDesc=" + creditAccountDesc + "]";
	}

}
