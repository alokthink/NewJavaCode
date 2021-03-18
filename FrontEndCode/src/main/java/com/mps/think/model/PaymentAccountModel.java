package com.mps.think.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentAccountModel {

	private String paymentAccountType;
	private Long customerId;
	private Long CardNameId;
	private int defaultAddressSeq;
	private String description;
	private String active;
	private String creditCard;
	private String cardHolder;
	private String paymentType;
	private List<DropdownModel> PaymentTypeList = new ArrayList<>();
	private String cardAddress;
	private String startDate;
	private String expireDate;
	private String issueNumber;
	private String nameOnCard;
	private String expirationNotice;
	private String bankName;
	private String branchTitle;
	private String sortCode;
	private String transposedSortCode;
	private String accountNumber;
	private String transposedAccountNumber;
	private String accountName;
	private String bankState;
	private List<DropdownModel> bankSateList = new ArrayList<>();
	private String creditCardLastFourDigit;
	private int documentReferenceId;
	private String secureStoreId;
	private String secureStoreDate;
	private List<DropdownModel> addressList = new ArrayList<>();
	private String secureStore;

	public String getSecureStore() {
		return secureStore;
	}

	public void setSecureStore(String secureStore) {
		this.secureStore = secureStore;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<DropdownModel> getPaymentTypeList() {
		return PaymentTypeList;
	}

	public void setPaymentTypeList(List<DropdownModel> paymentTypeList) {
		PaymentTypeList = paymentTypeList;
	}

	public String getCardAddress() {
		return cardAddress;
	}

	public void setCardAddress(String cardAddress) {
		this.cardAddress = cardAddress;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpirationNotice() {
		return expirationNotice;
	}

	public void setExpirationNotice(String expirationNotice) {
		this.expirationNotice = expirationNotice;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchTitle() {
		return branchTitle;
	}

	public void setBranchTitle(String branchTitle) {
		this.branchTitle = branchTitle;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getTransposedSortCode() {
		return transposedSortCode;
	}

	public void setTransposedSortCode(String transposedSortCode) {
		this.transposedSortCode = transposedSortCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankState() {
		return bankState;
	}

	public void setBankState(String bankState) {
		this.bankState = bankState;
	}

	public List<DropdownModel> getBankSateList() {
		return bankSateList;
	}

	public void setBankSateList(List<DropdownModel> bankSateList) {
		this.bankSateList = bankSateList;
	}

	public String getCreditCardLastFourDigit() {
		return creditCardLastFourDigit;
	}

	public void setCreditCardLastFourDigit(String creditCardLastFourDigit) {
		this.creditCardLastFourDigit = creditCardLastFourDigit;
	}

	public String getPaymentAccountType() {
		return paymentAccountType;
	}

	public void setPaymentAccountType(String paymentAccountType) {
		this.paymentAccountType = paymentAccountType;
	}

	public Long getCardNameId() {
		return CardNameId;
	}

	public void setCardNameId(Long cardNameId) {
		CardNameId = cardNameId;
	}

	public String getSecureStoreDate() {
		return secureStoreDate;
	}

	public void setSecureStoreDate(String secureStoreDate) {
		this.secureStoreDate = secureStoreDate;
	}

	public int getDefaultAddressSeq() {
		return defaultAddressSeq;
	}

	public void setDefaultAddressSeq(int defaultAddressSeq) {
		this.defaultAddressSeq = defaultAddressSeq;
	}

	public int getDocumentReferenceId() {
		return documentReferenceId;
	}

	public void setDocumentReferenceId(int documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}

	public String getTransposedAccountNumber() {
		return transposedAccountNumber;
	}

	public void setTransposedAccountNumber(String transposedAccountNumber) {
		this.transposedAccountNumber = transposedAccountNumber;
	}

	public String getSecureStoreId() {
		return secureStoreId;
	}

	public void setSecureStoreId(String secureStoreId) {
		this.secureStoreId = secureStoreId;
	}

	public List<DropdownModel> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<DropdownModel> addressList) {
		this.addressList = addressList;
	}

}
