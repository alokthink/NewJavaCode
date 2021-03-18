package com.mps.think.model;
import java.util.Date;
import java.util.List;
/**
 * @author itee.gupta
 *
 */
public class PaymentModel {
	private int active;
	private int payment_seq;
	private int customer_id;
	private String user_code;                          
	private int date_stamp;
	private String creation_date;
	private String payment_type;
	private String payment_clear_status;
	private String paymentClearStatusDesc;
	private String transaction_reason;
	private String currency;
	private double pay_currency_amount;
	private String transaction_type;
	private String transactionTypeDesc;
	private String check_number;
	private String fullName;
	private String address1;
	private String city;
	private Double base_amount;
	private Double payAmount;
	private String credit_card_info;
	private String credit_card_expire;
	private String card_verification_value;
	private String creditCardStartDate;
	private String cardNumber;
	private String credit_card_issue_id;
	private String auth_date;
	private String auth_code;
	private String ref_nbr;
	private String clear_date;
	private String n_settle_retries_left;
	private String nextSettleRetryDate;
	private Integer effort_nbr;
	private String currencyType;
	private List<String> currencyTypeList;
	private double pay_exchange_rate;
	private String id_nbr;
	private String exp_date;
	private int commission;
	private String payment_clear_method;
	private int realizCcashWhen;
	private int is_reversed;
	private int status_noedit;
	private int processing;
	private int mru_paybreak_seq;
	private String customer_deposit_pay_amt;
	private int nbr_times_issued;
	private int pending_xaction_header_id;
	private int credit_card_bill_customer_id;
	private int credit_card_bill_address_seq;
	private String refund_deposit_pay_amt;
	private int ics_bank_def_id;
	private String row_version;
	private boolean cash_realized;
	private boolean mru_payment_note_seq;
	private String deposit_transaction;
	private int is_ecommerce;
	private int is_recurring;
	private int max_settle_retries;
	private int n_days_between_settle_retries;
	private boolean cancelItmAfterSettleRetry;	
	private int payment_account_seq;
	private int needs_memo_post;
	private String id_nbr_last_four;
	private int bacs_id;
	private int cc_cleaned;
	private int hosted_secure_token_pmt;
	private String ba_nbr;
	private  int suspendAfterNSettleRetries;
	private String description;
	private int payerCustomer;
	private int orderId;
	private int orderItemSeq;
	private int postingReference;
	private float amount;
	private int debitAccount;
	private int creditAccount;
	private String creditAccountDesc;
	private float liabAmt;
	private int noMoreLiability;
	private int reconUpd;
	private String orderIdOrderseq;
	private int doc_ref_id;
	private int bill_to_customer_id;
	private int payment_form;
	private String dd_bank_description;
	private int bill_to_customer_address_seq;
	private String bank_account_type;
	// private Date credit_card_start_date;
	private String customer_address_seq;
	
	public String getCustomer_address_seq() {
		return customer_address_seq;
	}
	public void setCustomer_address_seq(String customer_address_seq) {
		this.customer_address_seq = customer_address_seq;
	}
	private String dd_sorting_code;
    private String dd_state;
    private String branch_title;
    private String dd_bank_name;
    private String dd_id_nbr_transposed;
    private String dd_sorting_code_transposed;
    private int expiry_notice_sent_days_left;
    private Date expiry_notice_sent_date;
    private Date secure_store_id_obtained_date;
    private int secure_bank_def_id; 
    private String threshold_option;
    
    
    public String getThreshold_option() {
		return threshold_option;
	}
	public void setThreshold_option(String threshold_option) {
		this.threshold_option = threshold_option;
	}
	private String nameOnCard;
 
    public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Integer getCreditCardAuthorization() {
		return creditCardAuthorization;
	}
	public void setCreditCardAuthorization(Integer creditCardAuthorization) {
		this.creditCardAuthorization = creditCardAuthorization;
	}
	private Integer creditCardAuthorization;
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
//	public String getThresholdOption() {
//		return threshold_option;
//	}
//	public void setThresholdOption(String thresholdOption) {
//		this.threshold_option = threshold_option;
//	}
	// private Threshold_option_enum threshold_option;
	
	
	//	public Threshold_option_enum getThreshold_option() {
//		return threshold_option;
//	}
//	public void setThreshold_option(Threshold_option_enum threshold_option) {
//		this.threshold_option = threshold_option;
//	}
	public int getBill_to_customer_id() {
		return bill_to_customer_id;
	}
	public void setBill_to_customer_id(int bill_to_customer_id) {
		this.bill_to_customer_id = bill_to_customer_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getPayment_seq() {
		return payment_seq;
	}
	public void setPayment_seq(int payment_seq) {
		this.payment_seq = payment_seq;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public int getDate_stamp() {
		return date_stamp;
	}
	public void setDate_stamp(int date_stamp) {
		this.date_stamp = date_stamp;
	}
	
	public String getPayment_clear_status() {
		return payment_clear_status;
	}
	public void setPayment_clear_status(String payment_clear_status) {
		this.payment_clear_status = payment_clear_status;
	}
	public String getTransaction_reason() {
		return transaction_reason;
	}
	public void setTransaction_reason(String transaction_reason) {
		this.transaction_reason = transaction_reason;
	}
	public double getPay_currency_amount() {
		return pay_currency_amount;
	}
	public void setPay_currency_amount(double pay_currency_amount) {
		this.pay_currency_amount = pay_currency_amount;
	}
	public String getCheck_number() {
		return check_number;
	}
	public void setCheck_number(String check_number) {
		this.check_number = check_number;
	}
	public Double getBase_amount() {
		return base_amount;
	}
	public void setBase_amount(Double base_amount) {
		this.base_amount = base_amount;
	}
	public String getCredit_card_info() {
		return credit_card_info;
	}
	public void setCredit_card_info(String credit_card_info) {
		this.credit_card_info = credit_card_info;
	}
	public String getCard_verification_value() {
		return card_verification_value;
	}
	public void setCard_verification_value(String card_verification_value) {
		this.card_verification_value = card_verification_value;
	}
	public String getCredit_card_issue_id() {
		return credit_card_issue_id;
	}
	public void setCredit_card_issue_id(String credit_card_issue_id) {
		this.credit_card_issue_id = credit_card_issue_id;
	}
	public String getAuth_date() {
		return auth_date;
	}
	public void setAuth_date(String auth_date) {
		this.auth_date = auth_date;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getRef_nbr() {
		return ref_nbr;
	}
	public void setRef_nbr(String ref_nbr) {
		this.ref_nbr = ref_nbr;
	}
	public String getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	public String getN_settle_retries_left() {
		return n_settle_retries_left;
	}
	public void setN_settle_retries_left(String n_settle_retries_left) {
		this.n_settle_retries_left = n_settle_retries_left;
	}
	public Integer getEffort_nbr() {
		return effort_nbr;
	}
	public void setEffort_nbr(Integer effort_nbr) {
		this.effort_nbr = effort_nbr;
	}
	public double getPay_exchange_rate() {
		return pay_exchange_rate;
	}
	public void setPay_exchange_rate(double pay_exchange_rate) {
		this.pay_exchange_rate = pay_exchange_rate;
	}
	public String getId_nbr() {
		return id_nbr;
	}
	public void setId_nbr(String id_nbr) {
		this.id_nbr = id_nbr;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public String getPayment_clear_method() {
		return payment_clear_method;
	}
	public void setPayment_clear_method(String payment_clear_method) {
		this.payment_clear_method = payment_clear_method;
	}
	public int getStatus_noedit() {
		return status_noedit;
	}
	public void setStatus_noedit(int status_noedit) {
		this.status_noedit = status_noedit;
	}
	public int getMru_paybreak_seq() {
		return mru_paybreak_seq;
	}
	public void setMru_paybreak_seq(int mru_paybreak_seq) {
		this.mru_paybreak_seq = mru_paybreak_seq;
	}
	public String getCustomer_deposit_pay_amt() {
		return customer_deposit_pay_amt;
	}
	public void setCustomer_deposit_pay_amt(String customer_deposit_pay_amt) {
		this.customer_deposit_pay_amt = customer_deposit_pay_amt;
	}
	public int getNbr_times_issued() {
		return nbr_times_issued;
	}
	public void setNbr_times_issued(int nbr_times_issued) {
		this.nbr_times_issued = nbr_times_issued;
	}
	public int getPending_xaction_header_id() {
		return pending_xaction_header_id;
	}
	public void setPending_xaction_header_id(int pending_xaction_header_id) {
		this.pending_xaction_header_id = pending_xaction_header_id;
	}
	public int getCredit_card_bill_customer_id() {
		return credit_card_bill_customer_id;
	}
	public void setCredit_card_bill_customer_id(int credit_card_bill_customer_id) {
		this.credit_card_bill_customer_id = credit_card_bill_customer_id;
	}
	public int getCredit_card_bill_address_seq() {
		return credit_card_bill_address_seq;
	}
	public void setCredit_card_bill_address_seq(int credit_card_bill_address_seq) {
		this.credit_card_bill_address_seq = credit_card_bill_address_seq;
	}
	public String getRefund_deposit_pay_amt() {
		return refund_deposit_pay_amt;
	}
	public void setRefund_deposit_pay_amt(String refund_deposit_pay_amt) {
		this.refund_deposit_pay_amt = refund_deposit_pay_amt;
	}
	public int getIcs_bank_def_id() {
		return ics_bank_def_id;
	}
	public void setIcs_bank_def_id(int ics_bank_def_id) {
		this.ics_bank_def_id = ics_bank_def_id;
	}
	public String getRow_version() {
		return row_version;
	}
	public void setRow_version(String row_version) {
		this.row_version = row_version;
	}
	public boolean isCash_realized() {
		return cash_realized;
	}
	public void setCash_realized(boolean cash_realized) {
		this.cash_realized = cash_realized;
	}
	public boolean isMru_payment_note_seq() {
		return mru_payment_note_seq;
	}
	public void setMru_payment_note_seq(boolean mru_payment_note_seq) {
		this.mru_payment_note_seq = mru_payment_note_seq;
	}
	public String getDeposit_transaction() {
		return deposit_transaction;
	}
	public void setDeposit_transaction(String deposit_transaction) {
		this.deposit_transaction = deposit_transaction;
	}
	public int getIs_ecommerce() {
		return is_ecommerce;
	}
	public void setIs_ecommerce(int is_ecommerce) {
		this.is_ecommerce = is_ecommerce;
	}
	public int getIs_recurring() {
		return is_recurring;
	}
	public void setIs_recurring(int is_recurring) {
		this.is_recurring = is_recurring;
	}
	public int getMax_settle_retries() {
		return max_settle_retries;
	}
	public void setMax_settle_retries(int max_settle_retries) {
		this.max_settle_retries = max_settle_retries;
	}
	public int getN_days_between_settle_retries() {
		return n_days_between_settle_retries;
	}
	public void setN_days_between_settle_retries(int n_days_between_settle_retries) {
		this.n_days_between_settle_retries = n_days_between_settle_retries;
	}
	public int getPayment_account_seq() {
		return payment_account_seq;
	}
	public void setPayment_account_seq(int payment_account_seq) {
		this.payment_account_seq = payment_account_seq;
	}
	public int getNeeds_memo_post() {
		return needs_memo_post;
	}
	public void setNeeds_memo_post(int needs_memo_post) {
		this.needs_memo_post = needs_memo_post;
	}
	public String getId_nbr_last_four() {
		return id_nbr_last_four;
	}
	public void setId_nbr_last_four(String id_nbr_last_four) {
		this.id_nbr_last_four = id_nbr_last_four;
	}
	public int getBacs_id() {
		return bacs_id;
	}
	public void setBacs_id(int bacs_id) {
		this.bacs_id = bacs_id;
	}
	public int getCc_cleaned() {
		return cc_cleaned;
	}
	public void setCc_cleaned(int cc_cleaned) {
		this.cc_cleaned = cc_cleaned;
	}
	public int getHosted_secure_token_pmt() {
		return hosted_secure_token_pmt;
	}
	public void setHosted_secure_token_pmt(int hosted_secure_token_pmt) {
		this.hosted_secure_token_pmt = hosted_secure_token_pmt;
	}
	public String getBa_nbr() {
		return ba_nbr;
	}
	public void setBa_nbr(String ba_nbr) {
		this.ba_nbr = ba_nbr;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPaymentClearStatusDesc() {
		return paymentClearStatusDesc;
	}
	public void setPaymentClearStatusDesc(String paymentClearStatusDesc) {
		this.paymentClearStatusDesc = paymentClearStatusDesc;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
//	public String getTransactionType() {
//		return transactionType;
//	}
//	public void setTransactionType(String transactionType) {
//		this.transactionType = transactionType;
//	}
	public String getTransactionTypeDesc() {
		return transactionTypeDesc;
	}
	public void setTransactionTypeDesc(String transactionTypeDesc) {
		this.transactionTypeDesc = transactionTypeDesc;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public String getCreditCardStartDate() {
		return creditCardStartDate;
	}
	public void setCreditCardStartDate(String creditCardStartDate) {
		this.creditCardStartDate = creditCardStartDate;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNextSettleRetryDate() {
		return nextSettleRetryDate;
	}
	public void setNextSettleRetryDate(String nextSettleRetryDate) {
		this.nextSettleRetryDate = nextSettleRetryDate;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public List<String> getCurrencyTypeList() {
		return currencyTypeList;
	}
	public void setCurrencyTypeList(List<String> currencyTypeList) {
		this.currencyTypeList = currencyTypeList;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getRealizCcashWhen() {
		return realizCcashWhen;
	}
	public void setRealizCcashWhen(int realizCcashWhen) {
		this.realizCcashWhen = realizCcashWhen;
	}
	public int getIs_reversed() {
		return is_reversed;
	}
	public void setIs_reversed(int is_reversed) {
		this.is_reversed = is_reversed;
	}
	public int getProcessing() {
		return processing;
	}
	public void setProcessing(int processing) {
		this.processing = processing;
	}
	public boolean isCancelItmAfterSettleRetry() {
		return cancelItmAfterSettleRetry;
	}
	public void setCancelItmAfterSettleRetry(boolean cancelItmAfterSettleRetry) {
		this.cancelItmAfterSettleRetry = cancelItmAfterSettleRetry;
	}
	public int getSuspendAfterNSettleRetries() {
		return suspendAfterNSettleRetries;
	}
	public void setSuspendAfterNSettleRetries(int suspendAfterNSettleRetries) {
		this.suspendAfterNSettleRetries = suspendAfterNSettleRetries;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPayerCustomer() {
		return payerCustomer;
	}
	public void setPayerCustomer(int payerCustomer) {
		this.payerCustomer = payerCustomer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	
	public int getPostingReference() {
		return postingReference;
	}
	public void setPostingReference(int postingReference) {
		this.postingReference = postingReference;
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
	public float getLiabAmt() {
		return liabAmt;
	}
	public void setLiabAmt(float liabAmt) {
		this.liabAmt = liabAmt;
	}
	public int getNoMoreLiability() {
		return noMoreLiability;
	}
	public void setNoMoreLiability(int noMoreLiability) {
		this.noMoreLiability = noMoreLiability;
	}
	public int getReconUpd() {
		return reconUpd;
	}
	public void setReconUpd(int reconUpd) {
		this.reconUpd = reconUpd;
	}
	
	public String getOrderIdOrderseq() {
		return orderIdOrderseq;
	}
	public void setOrderIdOrderseq(String orderIdOrderseq) {
		this.orderIdOrderseq = orderIdOrderseq;
	}
	
	public int getDoc_ref_id() {
		return doc_ref_id;
	}
	public void setDoc_ref_id(int doc_ref_id) {
		this.doc_ref_id = doc_ref_id;
	}
	
	public String getCredit_card_expire() {
		return credit_card_expire;
	}
	public void setCredit_card_expire(String credit_card_expire) {
		this.credit_card_expire = credit_card_expire;
	}
	
	public int getPayment_form() {
		return payment_form;
	}
	public void setPayment_form(int payment_form) {
		this.payment_form = payment_form;
	}
	public String getDd_bank_description() {
		return dd_bank_description;
	}
	public void setDd_bank_description(String dd_bank_description) {
		this.dd_bank_description = dd_bank_description;
	}
	public int getBill_to_customer_address_seq() {
		return bill_to_customer_address_seq;
	}
	public void setBill_to_customer_address_seq(int bill_to_customer_address_seq) {
		this.bill_to_customer_address_seq = bill_to_customer_address_seq;
	}
	public String getBank_account_type() {
		return bank_account_type;
	}
	public void setBank_account_type(String bank_account_type) {
		this.bank_account_type = bank_account_type;
	}
//	public Date getCredit_card_start_date() {
//		return credit_card_start_date;
//	}
//	public void setCredit_card_start_date(Date credit_card_start_date) {
//		this.credit_card_start_date = credit_card_start_date;
//	}
	public String getDd_sorting_code() {
		return dd_sorting_code;
	}
	public void setDd_sorting_code(String dd_sorting_code) {
		this.dd_sorting_code = dd_sorting_code;
	}
	public String getDd_state() {
		return dd_state;
	}
	public void setDd_state(String dd_state) {
		this.dd_state = dd_state;
	}
	public String getBranch_title() {
		return branch_title;
	}
	public void setBranch_title(String branch_title) {
		this.branch_title = branch_title;
	}
	public String getDd_bank_name() {
		return dd_bank_name;
	}
	public void setDd_bank_name(String dd_bank_name) {
		this.dd_bank_name = dd_bank_name;
	}
	public String getDd_id_nbr_transposed() {
		return dd_id_nbr_transposed;
	}
	public void setDd_id_nbr_transposed(String dd_id_nbr_transposed) {
		this.dd_id_nbr_transposed = dd_id_nbr_transposed;
	}
	public String getDd_sorting_code_transposed() {
		return dd_sorting_code_transposed;
	}
	public void setDd_sorting_code_transposed(String dd_sorting_code_transposed) {
		this.dd_sorting_code_transposed = dd_sorting_code_transposed;
	}
	public int getExpiry_notice_sent_days_left() {
		return expiry_notice_sent_days_left;
	}
	public void setExpiry_notice_sent_days_left(int expiry_notice_sent_days_left) {
		this.expiry_notice_sent_days_left = expiry_notice_sent_days_left;
	}
	public Date getExpiry_notice_sent_date() {
		return expiry_notice_sent_date;
	}
	public void setExpiry_notice_sent_date(Date expiry_notice_sent_date) {
		this.expiry_notice_sent_date = expiry_notice_sent_date;
	}
	public Date getSecure_store_id_obtained_date() {
		return secure_store_id_obtained_date;
	}
	public void setSecure_store_id_obtained_date(Date secure_store_id_obtained_date) {
		this.secure_store_id_obtained_date = secure_store_id_obtained_date;
	}
	public int getSecure_bank_def_id() {
		return secure_bank_def_id;
	}
	public void setSecure_bank_def_id(int secure_bank_def_id) {
		this.secure_bank_def_id = secure_bank_def_id;
	}
	@Override
	public String toString() {
		return "PaymentModel [payment_seq=" + payment_seq + ", customer_id=" + customer_id + ", user_code=" + user_code
				+ ", date_stamp=" + date_stamp + ", creation_date=" + creation_date + ", payment_type=" + payment_type
				+ ", payment_clear_status=" + payment_clear_status + ", paymentClearStatusDesc="
				+ paymentClearStatusDesc + ", transaction_reason=" + transaction_reason + ", currency=" + currency
				+ ", pay_currency_amount=" + pay_currency_amount + ", transaction_type=" + transaction_type
				+ ", transactionTypeDesc=" + transactionTypeDesc + ", check_number=" + check_number + ", fullName="
				+ fullName + ", address1=" + address1 + ", city=" + city + ", base_amount=" + base_amount
				+ ", payAmount=" + payAmount + ", credit_card_info=" + credit_card_info + ", card_verification_value="
				+ card_verification_value + ", creditCardStartDate=" + creditCardStartDate + ", cardNumber="
				+ cardNumber + ", credit_card_issue_id=" + credit_card_issue_id + ", auth_date=" + auth_date
				+ ", auth_code=" + auth_code + ", ref_nbr=" + ref_nbr + ", clear_date=" + clear_date
				+ ", n_settle_retries_left=" + n_settle_retries_left + ", nextSettleRetryDate=" + nextSettleRetryDate
				+ ", effort_nbr=" + effort_nbr + ", currencyType=" + currencyType + ", currencyTypeList="
				+ currencyTypeList + ", pay_exchange_rate=" + pay_exchange_rate + ", id_nbr=" + id_nbr + ", exp_date="
				+ exp_date + ", commission=" + commission + ", payment_clear_method=" + payment_clear_method
				+ ", realizCcashWhen=" + realizCcashWhen + ", is_reversed=" + is_reversed + ", status_noedit="
				+ status_noedit + ", processing=" + processing + ", mru_paybreak_seq=" + mru_paybreak_seq
				+ ", customer_deposit_pay_amt=" + customer_deposit_pay_amt + ", nbr_times_issued=" + nbr_times_issued
				+ ", pending_xaction_header_id=" + pending_xaction_header_id + ", credit_card_bill_customer_id="
				+ credit_card_bill_customer_id + ", credit_card_bill_address_seq=" + credit_card_bill_address_seq
				+ ", refund_deposit_pay_amt=" + refund_deposit_pay_amt + ", ics_bank_def_id=" + ics_bank_def_id
				+ ", row_version=" + row_version + ", cash_realized=" + cash_realized + ", mru_payment_note_seq="
				+ mru_payment_note_seq + ", deposit_transaction=" + deposit_transaction + ", is_ecommerce="
				+ is_ecommerce + ", is_recurring=" + is_recurring + ", max_settle_retries=" + max_settle_retries
				+ ", n_days_between_settle_retries=" + n_days_between_settle_retries + ", cancelItmAfterSettleRetry="
				+ cancelItmAfterSettleRetry + ", payment_account_seq=" + payment_account_seq + ", needs_memo_post="
				+ needs_memo_post + ", id_nbr_last_four=" + id_nbr_last_four + ", bacs_id=" + bacs_id + ", cc_cleaned="
				+ cc_cleaned + ", hosted_secure_token_pmt=" + hosted_secure_token_pmt + ", ba_nbr=" + ba_nbr
				+ ", suspendAfterNSettleRetries=" + suspendAfterNSettleRetries + ", description=" + description
				+ ", payerCustomer=" + payerCustomer + ", orderId=" + orderId + ", orderItemSeq=" + orderItemSeq
				+ ", postingReference=" + postingReference + ", amount=" + amount + ", debitAccount=" + debitAccount
				+ ", creditAccount=" + creditAccount + ", creditAccountDesc=" + creditAccountDesc + ", liabAmt="
				+ liabAmt + ", noMoreLiability=" + noMoreLiability + ", reconUpd=" + reconUpd + ", orderIdOrderseq="
				+ orderIdOrderseq + ", doc_ref_id=" + doc_ref_id + ", bill_to_customer_id=" + bill_to_customer_id + "]";
	}
	
	
	
	
}