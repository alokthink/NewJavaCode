package com.mps.think.option.model;

public class SupplementalRefund {
	//payment table
	private Integer customerId;
	private Integer paymentSeq;
	private String userCode;   
	private String currency;
	private Integer dateStamp;
	private String creationDate;
	private String idNbr;
	private String expDate;
	private String refNbr;
	private String authCode;
	private String authDate;
	private String clearDate;
	private Integer paymentClearStatus;
	private Integer effortNbr;
	private Integer commission;
	private String paymentType;
	private String creditCardInfo;
	private Double baseAmount;
	private Double payCurrencyAmount;
	private String transactionReason;
	private Integer transactionType;
	private Integer payClearMethod;
	private Integer realizeCashWhen;
	private Double payExchangeRate;
	private String isReversed;
	private Integer statusNoedit;
	private Integer processing;
	private Integer mruPaybreakSeq;
	private Double customerDepositPayAmount;
	private Integer nbrTimesIssued;
	private Integer pendingXactionHeaderId;
	private String creditCardStartDate;
	private String cardVerificationValue;
	private String creditCardIssueId;
	private Integer creditCardBillCustomerId;
	private String creditCardBillAddressSeq;
	private Double refundDepositPayAmount;
	private String checkNumber;
	private Integer icsBankDefId;
	private String cashRealized;
	private Integer mruPaymentNoteSeq;
	private Integer depositTransaction;
	private Integer isEcommerce;
	private Integer isRecurring;
	private Integer maxSettleRetries;
	private Integer nDaysBetweenSettleRetries;
	private String nextSettleRetryDate;
	private Integer nSettleRetriesLeft;
	private String cancelItmAfterSettleRetry;	
	private Integer paymentAccountSeq;
	private Integer needsMemoPost;
	private String idNbrLastFour;
	private Integer bacsId;
	private Integer ccCleaned;
	private Integer hostedSecureTokenPmt;
	private String baNbr;
	private  Integer suspendAfterNSettleRetries;
	
	//payment_reversed_payment table
	private Integer originalCustomerId;
	private Integer originalPaymentSeq;
	private Integer reversedCustomerId;
	private Integer reversedPaymentSeq;
	
	//journal table
	
	private Integer journalId;
	//private Integer dateStamp;
	//private Integer orderHdrId;
	private Integer orderItemSeq;
	private Integer postingReference;
	private Double taxAmount;
	private Double netAmount;
	private Double delAmount;
	private Integer comAmount;
	private Integer debitAccount;
	private Integer qtyDebitAccount;
	private Integer creditAccount;
	private Integer qtyCreditAccount;
	private Integer qty;
	//private Integer customerId;
	//private Integer paymentSeq;
	private Integer bndlQty;
	private Integer jobId;
	
	//edit_trail table
	
	private Integer editTrailId;	
	//private Integer customerId;	
	private Integer customerAddressSeq;	
	//private String userCode;	
	private Integer subscripId;	
	private Integer orderhdrId;	
	//private Integer orderItemSeq;	
	private Integer orderItemAmtBreakSeq;	
	private String edited;	
	//private String currency;	
	private Integer tableEnum;	
	private Integer documentReferenceId;	
	private Integer documentReferenceSeq;	
	private Double localAmount;	
	//private Double baseAmount;	
	//private Integer dateStamp;	
	//private String creationDate;	
	private String xactionName;	
	//private Integer paymentSeq;	
	private Integer demographicSeq;	
	//private Integer jobId;	
	//private Integer paymentAccountSeq;
	private Integer serviceSeq;
	
	//paybreak table

	//private Integer customerId;
	//private Integer paymentSeq;
	private Integer paybreakSeq;
	//private Integer orderhdrId;
	//private Integer orderItemSeq;
	//private Integer orderItemAmtBreakSeq;
	//private Double localAmount;
	//private Double baseAmount;
	//private Double payCurrencyAmount;
	private Integer paybreakType;
	private Integer ocId;
	//private Integer dateStamp;
	private Integer bogusCommission;
	private Double localExchangeRate;
	//private Integer editTrailId;
	private Integer  jrnFlag;
	private Boolean isPaymentAccount; 
	private Boolean isDepositAccount;
	
	public Boolean getIsPaymentAccount() {
		return isPaymentAccount;
	}
	public void setIsPaymentAccount(Boolean isPaymentAccount) {
		this.isPaymentAccount = isPaymentAccount;
	}
	public Boolean getIsDepositAccount() {
		return isDepositAccount;
	}
	public void setIsDepositAccount(Boolean isDepositAccount) {
		this.isDepositAccount = isDepositAccount;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getPaymentSeq() {
		return paymentSeq;
	}
	public void setPaymentSeq(Integer paymentSeq) {
		this.paymentSeq = paymentSeq;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(Integer dateStamp) {
		this.dateStamp = dateStamp;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getIdNbr() {
		return idNbr;
	}
	public void setIdNbr(String idNbr) {
		this.idNbr = idNbr;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getRefNbr() {
		return refNbr;
	}
	public void setRefNbr(String refNbr) {
		this.refNbr = refNbr;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthDate() {
		return authDate;
	}
	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
	public Integer getPaymentClearStatus() {
		return paymentClearStatus;
	}
	public void setPaymentClearStatus(Integer paymentClearStatus) {
		this.paymentClearStatus = paymentClearStatus;
	}
	public Integer getEffortNbr() {
		return effortNbr;
	}
	public void setEffortNbr(Integer effortNbr) {
		this.effortNbr = effortNbr;
	}
	public Integer getCommission() {
		return commission;
	}
	public void setCommission(Integer commission) {
		this.commission = commission;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	public Double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}
	public Double getPayCurrencyAmount() {
		return payCurrencyAmount;
	}
	public void setPayCurrencyAmount(Double payCurrencyAmount) {
		this.payCurrencyAmount = payCurrencyAmount;
	}
	public String getTransactionReason() {
		return transactionReason;
	}
	public void setTransactionReason(String transactionReason) {
		this.transactionReason = transactionReason;
	}
	public Integer getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getPayClearMethod() {
		return payClearMethod;
	}
	public void setPayClearMethod(Integer payClearMethod) {
		this.payClearMethod = payClearMethod;
	}
	public Integer getRealizeCashWhen() {
		return realizeCashWhen;
	}
	public void setRealizeCashWhen(Integer realizeCashWhen) {
		this.realizeCashWhen = realizeCashWhen;
	}
	public Double getPayExchangeRate() {
		return payExchangeRate;
	}
	public void setPayExchangeRate(Double payExchangeRate) {
		this.payExchangeRate = payExchangeRate;
	}
	public String getIsReversed() {
		return isReversed;
	}
	public void setIsReversed(String isReversed) {
		this.isReversed = isReversed;
	}
	public Integer getStatusNoedit() {
		return statusNoedit;
	}
	public void setStatusNoedit(Integer statusNoedit) {
		this.statusNoedit = statusNoedit;
	}
	public Integer getProcessing() {
		return processing;
	}
	public void setProcessing(Integer processing) {
		this.processing = processing;
	}
	public Integer getMruPaybreakSeq() {
		return mruPaybreakSeq;
	}
	public void setMruPaybreakSeq(Integer mruPaybreakSeq) {
		this.mruPaybreakSeq = mruPaybreakSeq;
	}
	public Double getCustomerDepositPayAmount() {
		return customerDepositPayAmount;
	}
	public void setCustomerDepositPayAmount(Double customerDepositPayAmount) {
		this.customerDepositPayAmount = customerDepositPayAmount;
	}
	public Integer getNbrTimesIssued() {
		return nbrTimesIssued;
	}
	public void setNbrTimesIssued(Integer nbrTimesIssued) {
		this.nbrTimesIssued = nbrTimesIssued;
	}
	public Integer getPendingXactionHeaderId() {
		return pendingXactionHeaderId;
	}
	public void setPendingXactionHeaderId(Integer pendingXactionHeaderId) {
		this.pendingXactionHeaderId = pendingXactionHeaderId;
	}
	public String getCreditCardStartDate() {
		return creditCardStartDate;
	}
	public void setCreditCardStartDate(String creditCardStartDate) {
		this.creditCardStartDate = creditCardStartDate;
	}
	public String getCardVerificationValue() {
		return cardVerificationValue;
	}
	public void setCardVerificationValue(String cardVerificationValue) {
		this.cardVerificationValue = cardVerificationValue;
	}
	public String getCreditCardIssueId() {
		return creditCardIssueId;
	}
	public void setCreditCardIssueId(String creditCardIssueId) {
		this.creditCardIssueId = creditCardIssueId;
	}
	public Integer getCreditCardBillCustomerId() {
		return creditCardBillCustomerId;
	}
	public void setCreditCardBillCustomerId(Integer creditCardBillCustomerId) {
		this.creditCardBillCustomerId = creditCardBillCustomerId;
	}
	public String getCreditCardBillAddressSeq() {
		return creditCardBillAddressSeq;
	}
	public void setCreditCardBillAddressSeq(String creditCardBillAddressSeq) {
		this.creditCardBillAddressSeq = creditCardBillAddressSeq;
	}
	public Double getRefundDepositPayAmount() {
		return refundDepositPayAmount;
	}
	public void setRefundDepositPayAmount(Double refundDepositPayAmount) {
		this.refundDepositPayAmount = refundDepositPayAmount;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public Integer getIcsBankDefId() {
		return icsBankDefId;
	}
	public void setIcsBankDefId(Integer icsBankDefId) {
		this.icsBankDefId = icsBankDefId;
	}
	public String getCashRealized() {
		return cashRealized;
	}
	public void setCashRealized(String cashRealized) {
		this.cashRealized = cashRealized;
	}
	public Integer getMruPaymentNoteSeq() {
		return mruPaymentNoteSeq;
	}
	public void setMruPaymentNoteSeq(Integer mruPaymentNoteSeq) {
		this.mruPaymentNoteSeq = mruPaymentNoteSeq;
	}
	public Integer getDepositTransaction() {
		return depositTransaction;
	}
	public void setDepositTransaction(Integer depositTransaction) {
		this.depositTransaction = depositTransaction;
	}
	public Integer getIsEcommerce() {
		return isEcommerce;
	}
	public void setIsEcommerce(Integer isEcommerce) {
		this.isEcommerce = isEcommerce;
	}
	public Integer getIsRecurring() {
		return isRecurring;
	}
	public void setIsRecurring(Integer isRecurring) {
		this.isRecurring = isRecurring;
	}
	public Integer getMaxSettleRetries() {
		return maxSettleRetries;
	}
	public void setMaxSettleRetries(Integer maxSettleRetries) {
		this.maxSettleRetries = maxSettleRetries;
	}
	public Integer getnDaysBetweenSettleRetries() {
		return nDaysBetweenSettleRetries;
	}
	public void setnDaysBetweenSettleRetries(Integer nDaysBetweenSettleRetries) {
		this.nDaysBetweenSettleRetries = nDaysBetweenSettleRetries;
	}
	public String getNextSettleRetryDate() {
		return nextSettleRetryDate;
	}
	public void setNextSettleRetryDate(String nextSettleRetryDate) {
		this.nextSettleRetryDate = nextSettleRetryDate;
	}
	public Integer getnSettleRetriesLeft() {
		return nSettleRetriesLeft;
	}
	public void setnSettleRetriesLeft(Integer nSettleRetriesLeft) {
		this.nSettleRetriesLeft = nSettleRetriesLeft;
	}
	public String getCancelItmAfterSettleRetry() {
		return cancelItmAfterSettleRetry;
	}
	public void setCancelItmAfterSettleRetry(String cancelItmAfterSettleRetry) {
		this.cancelItmAfterSettleRetry = cancelItmAfterSettleRetry;
	}
	public Integer getPaymentAccountSeq() {
		return paymentAccountSeq;
	}
	public void setPaymentAccountSeq(Integer paymentAccountSeq) {
		this.paymentAccountSeq = paymentAccountSeq;
	}
	public Integer getNeedsMemoPost() {
		return needsMemoPost;
	}
	public void setNeedsMemoPost(Integer needsMemoPost) {
		this.needsMemoPost = needsMemoPost;
	}
	public String getIdNbrLastFour() {
		return idNbrLastFour;
	}
	public void setIdNbrLastFour(String idNbrLastFour) {
		this.idNbrLastFour = idNbrLastFour;
	}
	public Integer getBacsId() {
		return bacsId;
	}
	public void setBacsId(Integer bacsId) {
		this.bacsId = bacsId;
	}
	public Integer getCcCleaned() {
		return ccCleaned;
	}
	public void setCcCleaned(Integer ccCleaned) {
		this.ccCleaned = ccCleaned;
	}
	public Integer getHostedSecureTokenPmt() {
		return hostedSecureTokenPmt;
	}
	public void setHostedSecureTokenPmt(Integer hostedSecureTokenPmt) {
		this.hostedSecureTokenPmt = hostedSecureTokenPmt;
	}
	public String getBaNbr() {
		return baNbr;
	}
	public void setBaNbr(String baNbr) {
		this.baNbr = baNbr;
	}
	public Integer getSuspendAfterNSettleRetries() {
		return suspendAfterNSettleRetries;
	}
	public void setSuspendAfterNSettleRetries(Integer suspendAfterNSettleRetries) {
		this.suspendAfterNSettleRetries = suspendAfterNSettleRetries;
	}
	public Integer getoriginalCustomerId() {
		return originalCustomerId;
	}
	public void setOriginalCustomerId(Integer originalCustomerId) {
		this.originalCustomerId = originalCustomerId;
	}
	public Integer getOriginal_payment_seq() {
		return originalPaymentSeq;
	}
	public void setOriginalPaymentSeq(Integer originalPaymentSeq) {
		this.originalPaymentSeq = originalPaymentSeq;
	}
	public Integer getReversed_customer_id() {
		return reversedCustomerId;
	}
	public void setReversedCustomerId(Integer reversedCustomerId) {
		this.reversedCustomerId = reversedCustomerId;
	}
	public Integer getReversedCustomerId() {
		return reversedCustomerId;
	}
	public void setReversed_payment_seq(Integer reversedCustomerId) {
		this.reversedCustomerId = reversedCustomerId;
	}
	public Integer getJournalId() {
		return journalId;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	public Integer getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(Integer orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public Integer getPostingReference() {
		return postingReference;
	}
	public void setPostingReference(Integer postingReference) {
		this.postingReference = postingReference;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	public Double getDelAmount() {
		return delAmount;
	}
	public void setDelAmount(Double delAmount) {
		this.delAmount = delAmount;
	}
	public Integer getComAmount() {
		return comAmount;
	}
	public void setComAmount(Integer comAmount) {
		this.comAmount = comAmount;
	}
	public Integer getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount(Integer debitAccount) {
		this.debitAccount = debitAccount;
	}
	public Integer getQtyDebitAccount() {
		return qtyDebitAccount;
	}
	public void setQtyDebitAccount(Integer qtyDebitAccount) {
		this.qtyDebitAccount = qtyDebitAccount;
	}
	public Integer getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(Integer creditAccount) {
		this.creditAccount = creditAccount;
	}
	public Integer getQtyCreditAccount() {
		return qtyCreditAccount;
	}
	public void setQtyCreditAccount(Integer qtyCreditAccount) {
		this.qtyCreditAccount = qtyCreditAccount;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getBndlQty() {
		return bndlQty;
	}
	public void setBndlQty(Integer bndlQty) {
		this.bndlQty = bndlQty;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getEditTrailId() {
		return editTrailId;
	}
	public void setEditTrailId(Integer editTrailId) {
		this.editTrailId = editTrailId;
	}
	public Integer getCustomerAddressSeq() {
		return customerAddressSeq;
	}
	public void setCustomerAddressSeq(Integer customerAddressSeq) {
		this.customerAddressSeq = customerAddressSeq;
	}
	public Integer getSubscripId() {
		return subscripId;
	}
	public void setSubscripId(Integer subscripId) {
		this.subscripId = subscripId;
	}
	public Integer getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public Integer getOrderItemAmtBreakSeq() {
		return orderItemAmtBreakSeq;
	}
	public void setOrderItemAmtBreakSeq(Integer orderItemAmtBreakSeq) {
		this.orderItemAmtBreakSeq = orderItemAmtBreakSeq;
	}
	public String getEdited() {
		return edited;
	}
	public void setEdited(String edited) {
		this.edited = edited;
	}
	public Integer getTableEnum() {
		return tableEnum;
	}
	public void setTableEnum(Integer tableEnum) {
		this.tableEnum = tableEnum;
	}
	public Integer getDocumentReferenceId() {
		return documentReferenceId;
	}
	public void setDocumentReferenceId(Integer documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}
	public Integer getDocumentReferenceSeq() {
		return documentReferenceSeq;
	}
	public void setDocumentReferenceSeq(Integer documentReferenceSeq) {
		this.documentReferenceSeq = documentReferenceSeq;
	}
	public Double getLocalAmount() {
		return localAmount;
	}
	public void setLocalAmount(Double localAmount) {
		this.localAmount = localAmount;
	}
	public String getXactionName() {
		return xactionName;
	}
	public void setXactionName(String xactionName) {
		this.xactionName = xactionName;
	}
	public Integer getDemographicSeq() {
		return demographicSeq;
	}
	public void setDemographicSeq(Integer demographicSeq) {
		this.demographicSeq = demographicSeq;
	}
	public Integer getServiceSeq() {
		return serviceSeq;
	}
	public void setServiceSeq(Integer serviceSeq) {
		this.serviceSeq = serviceSeq;
	}
	public Integer getPaybreakSeq() {
		return paybreakSeq;
	}
	public void setPaybreakSeq(Integer paybreakSeq) {
		this.paybreakSeq = paybreakSeq;
	}
	public Integer getPaybreakType() {
		return paybreakType;
	}
	public void setPaybreakType(Integer paybreakType) {
		this.paybreakType = paybreakType;
	}
	public Integer getOcId() {
		return ocId;
	}
	public void setOcId(Integer ocId) {
		this.ocId = ocId;
	}
	public Integer getBogusCommission() {
		return bogusCommission;
	}
	public void setBogusCommission(Integer bogusCommission) {
		this.bogusCommission = bogusCommission;
	}
	public Double getLocalExchangeRate() {
		return localExchangeRate;
	}
	public void setLocalExchangeRate(Double localExchangeRate) {
		this.localExchangeRate = localExchangeRate;
	}
	public Integer getJrnFlag() {
		return jrnFlag;
	}
	public void setJrnFlag(Integer jrnFlag) {
		this.jrnFlag = jrnFlag;
	}
	@Override
	public String toString() {
		return "SupplementalRefund [customerId=" + customerId + ", paymentSeq=" + paymentSeq + ", userCode=" + userCode
				+ ", currency=" + currency + ", dateStamp=" + dateStamp + ", creationDate=" + creationDate + ", idNbr="
				+ idNbr + ", expDate=" + expDate + ", refNbr=" + refNbr + ", authCode=" + authCode + ", authDate="
				+ authDate + ", clearDate=" + clearDate + ", paymentClearStatus=" + paymentClearStatus + ", effortNbr="
				+ effortNbr + ", commission=" + commission + ", paymentType=" + paymentType + ", creditCardInfo="
				+ creditCardInfo + ", baseAmount=" + baseAmount + ", payCurrencyAmount=" + payCurrencyAmount
				+ ", transactionReason=" + transactionReason + ", transactionType=" + transactionType
				+ ", payClearMethod=" + payClearMethod + ", realizeCashWhen=" + realizeCashWhen + ", payExchangeRate="
				+ payExchangeRate + ", isReversed=" + isReversed + ", statusNoedit=" + statusNoedit + ", processing="
				+ processing + ", mruPaybreakSeq=" + mruPaybreakSeq + ", customerDepositPayAmount="
				+ customerDepositPayAmount + ", nbrTimesIssued=" + nbrTimesIssued + ", pendingXactionHeaderId="
				+ pendingXactionHeaderId + ", creditCardStartDate=" + creditCardStartDate + ", cardVerificationValue="
				+ cardVerificationValue + ", creditCardIssueId=" + creditCardIssueId + ", creditCardBillCustomerId="
				+ creditCardBillCustomerId + ", creditCardBillAddressSeq=" + creditCardBillAddressSeq
				+ ", refundDepositPayAmount=" + refundDepositPayAmount + ", checkNumber=" + checkNumber
				+ ", icsBankDefId=" + icsBankDefId + ", cashRealized=" + cashRealized + ", mruPaymentNoteSeq="
				+ mruPaymentNoteSeq + ", depositTransaction=" + depositTransaction + ", isEcommerce=" + isEcommerce
				+ ", isRecurring=" + isRecurring + ", maxSettleRetries=" + maxSettleRetries
				+ ", nDaysBetweenSettleRetries=" + nDaysBetweenSettleRetries + ", nextSettleRetryDate="
				+ nextSettleRetryDate + ", nSettleRetriesLeft=" + nSettleRetriesLeft + ", cancelItmAfterSettleRetry="
				+ cancelItmAfterSettleRetry + ", paymentAccountSeq=" + paymentAccountSeq + ", needsMemoPost="
				+ needsMemoPost + ", idNbrLastFour=" + idNbrLastFour + ", bacsId=" + bacsId + ", ccCleaned=" + ccCleaned
				+ ", hostedSecureTokenPmt=" + hostedSecureTokenPmt + ", baNbr=" + baNbr
				+ ", suspendAfterNSettleRetries=" + suspendAfterNSettleRetries + ", original_customer_id="
				+ originalCustomerId + ", original_payment_seq=" + originalPaymentSeq + ", reversed_customer_id="
				+ reversedCustomerId + ", reversed_payment_seq=" + reversedPaymentSeq + ", journalId=" + journalId
				+ ", orderItemSeq=" + orderItemSeq + ", postingReference="
				+ postingReference + ", taxAmount=" + taxAmount + ", netAmount=" + netAmount + ", delAmount="
				+ delAmount + ", comAmount=" + comAmount + ", debitAccount=" + debitAccount + ", qtyDebitAccount="
				+ qtyDebitAccount + ", creditAccount=" + creditAccount + ", qtyCreditAccount=" + qtyCreditAccount
				+ ", qty=" + qty + ", bndlQty=" + bndlQty + ", jobId=" + jobId + ", editTrailId=" + editTrailId
				+ ", customerAddressSeq=" + customerAddressSeq + ", subscripId=" + subscripId + ", orderhdrId="
				+ orderhdrId + ", orderItemAmtBreakSeq=" + orderItemAmtBreakSeq + ", edited=" + edited + ", tableEnum="
				+ tableEnum + ", documentReferenceId=" + documentReferenceId + ", documentReferenceSeq="
				+ documentReferenceSeq + ", localAmount=" + localAmount + ", xactionName=" + xactionName
				+ ", demographicSeq=" + demographicSeq + ", serviceSeq=" + serviceSeq + ", paybreakSeq=" + paybreakSeq
				+ ", paybreakType=" + paybreakType+ ", ocId=" + ocId + ", bogusCommission=" + bogusCommission
				+ ", localExchangeRate=" + localExchangeRate +", jrnFlag=" + jrnFlag+ "]";
	}
	
	
}
