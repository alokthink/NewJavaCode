/**
 * Review_payments_list_select_responseView_payment_review.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Review_payments_list_select_responseView_payment_review  implements java.io.Serializable {
    private int customer_id;  // attribute

    private int payment_seq;  // attribute

    private java.lang.String user_code;  // attribute

    private java.lang.String currency;  // attribute

    private int date_stamp;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private java.lang.String id_nbr;  // attribute

    private java.util.Date exp_date;  // attribute

    private java.lang.String ref_nbr;  // attribute

    private java.lang.String auth_code;  // attribute

    private java.util.Date auth_date;  // attribute

    private java.util.Date clear_date;  // attribute

    private int payment_clear_status;  // attribute

    private int effort_nbr;  // attribute

    private int commission;  // attribute

    private java.lang.String payment_type;  // attribute

    private java.lang.String credit_card_info;  // attribute

    private java.math.BigDecimal base_amount;  // attribute

    private java.math.BigDecimal pay_currency_amount;  // attribute

    private java.lang.String transaction_reason;  // attribute

    private int transaction_type;  // attribute

    private int payment_clear_method;  // attribute

    private int realize_cash_when;  // attribute

    private java.math.BigDecimal pay_exchange_rate;  // attribute

    private int is_reversed;  // attribute

    private int status_noedit;  // attribute

    private int processing;  // attribute

    private java.math.BigDecimal customer_deposit_pay_amt;  // attribute

    private int nbr_times_issued;  // attribute

    private int pending_xaction_header_id;  // attribute

    private java.util.Date credit_card_start_date;  // attribute

    private java.lang.String card_verification_value;  // attribute

    private java.lang.String credit_card_issue_id;  // attribute

    private int credit_card_bill_customer_id;  // attribute

    private int credit_card_bill_address_seq;  // attribute

    private java.math.BigDecimal refund_deposit_pay_amt;  // attribute

    private java.lang.String check_number;  // attribute

    private int ics_bank_def_id;  // attribute

    private int cash_realized;  // attribute

    private int deposit_transaction;  // attribute

    private int is_ecommerce;  // attribute

    private int is_recurring;  // attribute

    private int max_settle_retries;  // attribute

    private int n_days_between_settle_retries;  // attribute

    private java.util.Date next_settle_retry_date;  // attribute

    private int n_settle_retries_left;  // attribute

    private int cancel_itm_after_settle_retry;  // attribute

    private int payment_account_seq;  // attribute

    private int needs_memo_post;  // attribute

    private java.lang.String id_nbr_last_four;  // attribute

    private int bacs_id;  // attribute

    private int cc_cleaned;  // attribute

    private int hosted_secure_token_pmt;  // attribute

    private java.lang.String ba_nbr;  // attribute

    private int suspend_after_n_settle_retries;  // attribute

    private int o_customer_id;  // attribute

    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    public Review_payments_list_select_responseView_payment_review() {
    }

    public Review_payments_list_select_responseView_payment_review(
           int customer_id,
           int payment_seq,
           java.lang.String user_code,
           java.lang.String currency,
           int date_stamp,
           java.util.Calendar creation_date,
           java.lang.String id_nbr,
           java.util.Date exp_date,
           java.lang.String ref_nbr,
           java.lang.String auth_code,
           java.util.Date auth_date,
           java.util.Date clear_date,
           int payment_clear_status,
           int effort_nbr,
           int commission,
           java.lang.String payment_type,
           java.lang.String credit_card_info,
           java.math.BigDecimal base_amount,
           java.math.BigDecimal pay_currency_amount,
           java.lang.String transaction_reason,
           int transaction_type,
           int payment_clear_method,
           int realize_cash_when,
           java.math.BigDecimal pay_exchange_rate,
           int is_reversed,
           int status_noedit,
           int processing,
           java.math.BigDecimal customer_deposit_pay_amt,
           int nbr_times_issued,
           int pending_xaction_header_id,
           java.util.Date credit_card_start_date,
           java.lang.String card_verification_value,
           java.lang.String credit_card_issue_id,
           int credit_card_bill_customer_id,
           int credit_card_bill_address_seq,
           java.math.BigDecimal refund_deposit_pay_amt,
           java.lang.String check_number,
           int ics_bank_def_id,
           int cash_realized,
           int deposit_transaction,
           int is_ecommerce,
           int is_recurring,
           int max_settle_retries,
           int n_days_between_settle_retries,
           java.util.Date next_settle_retry_date,
           int n_settle_retries_left,
           int cancel_itm_after_settle_retry,
           int payment_account_seq,
           int needs_memo_post,
           java.lang.String id_nbr_last_four,
           int bacs_id,
           int cc_cleaned,
           int hosted_secure_token_pmt,
           java.lang.String ba_nbr,
           int suspend_after_n_settle_retries,
           int o_customer_id,
           int orderhdr_id,
           int order_item_seq) {
           this.customer_id = customer_id;
           this.payment_seq = payment_seq;
           this.user_code = user_code;
           this.currency = currency;
           this.date_stamp = date_stamp;
           this.creation_date = creation_date;
           this.id_nbr = id_nbr;
           this.exp_date = exp_date;
           this.ref_nbr = ref_nbr;
           this.auth_code = auth_code;
           this.auth_date = auth_date;
           this.clear_date = clear_date;
           this.payment_clear_status = payment_clear_status;
           this.effort_nbr = effort_nbr;
           this.commission = commission;
           this.payment_type = payment_type;
           this.credit_card_info = credit_card_info;
           this.base_amount = base_amount;
           this.pay_currency_amount = pay_currency_amount;
           this.transaction_reason = transaction_reason;
           this.transaction_type = transaction_type;
           this.payment_clear_method = payment_clear_method;
           this.realize_cash_when = realize_cash_when;
           this.pay_exchange_rate = pay_exchange_rate;
           this.is_reversed = is_reversed;
           this.status_noedit = status_noedit;
           this.processing = processing;
           this.customer_deposit_pay_amt = customer_deposit_pay_amt;
           this.nbr_times_issued = nbr_times_issued;
           this.pending_xaction_header_id = pending_xaction_header_id;
           this.credit_card_start_date = credit_card_start_date;
           this.card_verification_value = card_verification_value;
           this.credit_card_issue_id = credit_card_issue_id;
           this.credit_card_bill_customer_id = credit_card_bill_customer_id;
           this.credit_card_bill_address_seq = credit_card_bill_address_seq;
           this.refund_deposit_pay_amt = refund_deposit_pay_amt;
           this.check_number = check_number;
           this.ics_bank_def_id = ics_bank_def_id;
           this.cash_realized = cash_realized;
           this.deposit_transaction = deposit_transaction;
           this.is_ecommerce = is_ecommerce;
           this.is_recurring = is_recurring;
           this.max_settle_retries = max_settle_retries;
           this.n_days_between_settle_retries = n_days_between_settle_retries;
           this.next_settle_retry_date = next_settle_retry_date;
           this.n_settle_retries_left = n_settle_retries_left;
           this.cancel_itm_after_settle_retry = cancel_itm_after_settle_retry;
           this.payment_account_seq = payment_account_seq;
           this.needs_memo_post = needs_memo_post;
           this.id_nbr_last_four = id_nbr_last_four;
           this.bacs_id = bacs_id;
           this.cc_cleaned = cc_cleaned;
           this.hosted_secure_token_pmt = hosted_secure_token_pmt;
           this.ba_nbr = ba_nbr;
           this.suspend_after_n_settle_retries = suspend_after_n_settle_retries;
           this.o_customer_id = o_customer_id;
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the payment_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the user_code value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the currency value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the date_stamp value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return date_stamp
     */
    public int getDate_stamp() {
        return date_stamp;
    }


    /**
     * Sets the date_stamp value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param date_stamp
     */
    public void setDate_stamp(int date_stamp) {
        this.date_stamp = date_stamp;
    }


    /**
     * Gets the creation_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the id_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return id_nbr
     */
    public java.lang.String getId_nbr() {
        return id_nbr;
    }


    /**
     * Sets the id_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param id_nbr
     */
    public void setId_nbr(java.lang.String id_nbr) {
        this.id_nbr = id_nbr;
    }


    /**
     * Gets the exp_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return exp_date
     */
    public java.util.Date getExp_date() {
        return exp_date;
    }


    /**
     * Sets the exp_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param exp_date
     */
    public void setExp_date(java.util.Date exp_date) {
        this.exp_date = exp_date;
    }


    /**
     * Gets the ref_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return ref_nbr
     */
    public java.lang.String getRef_nbr() {
        return ref_nbr;
    }


    /**
     * Sets the ref_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param ref_nbr
     */
    public void setRef_nbr(java.lang.String ref_nbr) {
        this.ref_nbr = ref_nbr;
    }


    /**
     * Gets the auth_code value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return auth_code
     */
    public java.lang.String getAuth_code() {
        return auth_code;
    }


    /**
     * Sets the auth_code value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param auth_code
     */
    public void setAuth_code(java.lang.String auth_code) {
        this.auth_code = auth_code;
    }


    /**
     * Gets the auth_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return auth_date
     */
    public java.util.Date getAuth_date() {
        return auth_date;
    }


    /**
     * Sets the auth_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param auth_date
     */
    public void setAuth_date(java.util.Date auth_date) {
        this.auth_date = auth_date;
    }


    /**
     * Gets the clear_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return clear_date
     */
    public java.util.Date getClear_date() {
        return clear_date;
    }


    /**
     * Sets the clear_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param clear_date
     */
    public void setClear_date(java.util.Date clear_date) {
        this.clear_date = clear_date;
    }


    /**
     * Gets the payment_clear_status value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return payment_clear_status
     */
    public int getPayment_clear_status() {
        return payment_clear_status;
    }


    /**
     * Sets the payment_clear_status value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param payment_clear_status
     */
    public void setPayment_clear_status(int payment_clear_status) {
        this.payment_clear_status = payment_clear_status;
    }


    /**
     * Gets the effort_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return effort_nbr
     */
    public int getEffort_nbr() {
        return effort_nbr;
    }


    /**
     * Sets the effort_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param effort_nbr
     */
    public void setEffort_nbr(int effort_nbr) {
        this.effort_nbr = effort_nbr;
    }


    /**
     * Gets the commission value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return commission
     */
    public int getCommission() {
        return commission;
    }


    /**
     * Sets the commission value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param commission
     */
    public void setCommission(int commission) {
        this.commission = commission;
    }


    /**
     * Gets the payment_type value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return payment_type
     */
    public java.lang.String getPayment_type() {
        return payment_type;
    }


    /**
     * Sets the payment_type value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param payment_type
     */
    public void setPayment_type(java.lang.String payment_type) {
        this.payment_type = payment_type;
    }


    /**
     * Gets the credit_card_info value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return credit_card_info
     */
    public java.lang.String getCredit_card_info() {
        return credit_card_info;
    }


    /**
     * Sets the credit_card_info value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param credit_card_info
     */
    public void setCredit_card_info(java.lang.String credit_card_info) {
        this.credit_card_info = credit_card_info;
    }


    /**
     * Gets the base_amount value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return base_amount
     */
    public java.math.BigDecimal getBase_amount() {
        return base_amount;
    }


    /**
     * Sets the base_amount value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param base_amount
     */
    public void setBase_amount(java.math.BigDecimal base_amount) {
        this.base_amount = base_amount;
    }


    /**
     * Gets the pay_currency_amount value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return pay_currency_amount
     */
    public java.math.BigDecimal getPay_currency_amount() {
        return pay_currency_amount;
    }


    /**
     * Sets the pay_currency_amount value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param pay_currency_amount
     */
    public void setPay_currency_amount(java.math.BigDecimal pay_currency_amount) {
        this.pay_currency_amount = pay_currency_amount;
    }


    /**
     * Gets the transaction_reason value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return transaction_reason
     */
    public java.lang.String getTransaction_reason() {
        return transaction_reason;
    }


    /**
     * Sets the transaction_reason value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param transaction_reason
     */
    public void setTransaction_reason(java.lang.String transaction_reason) {
        this.transaction_reason = transaction_reason;
    }


    /**
     * Gets the transaction_type value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return transaction_type
     */
    public int getTransaction_type() {
        return transaction_type;
    }


    /**
     * Sets the transaction_type value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param transaction_type
     */
    public void setTransaction_type(int transaction_type) {
        this.transaction_type = transaction_type;
    }


    /**
     * Gets the payment_clear_method value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return payment_clear_method
     */
    public int getPayment_clear_method() {
        return payment_clear_method;
    }


    /**
     * Sets the payment_clear_method value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param payment_clear_method
     */
    public void setPayment_clear_method(int payment_clear_method) {
        this.payment_clear_method = payment_clear_method;
    }


    /**
     * Gets the realize_cash_when value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return realize_cash_when
     */
    public int getRealize_cash_when() {
        return realize_cash_when;
    }


    /**
     * Sets the realize_cash_when value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param realize_cash_when
     */
    public void setRealize_cash_when(int realize_cash_when) {
        this.realize_cash_when = realize_cash_when;
    }


    /**
     * Gets the pay_exchange_rate value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return pay_exchange_rate
     */
    public java.math.BigDecimal getPay_exchange_rate() {
        return pay_exchange_rate;
    }


    /**
     * Sets the pay_exchange_rate value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param pay_exchange_rate
     */
    public void setPay_exchange_rate(java.math.BigDecimal pay_exchange_rate) {
        this.pay_exchange_rate = pay_exchange_rate;
    }


    /**
     * Gets the is_reversed value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return is_reversed
     */
    public int getIs_reversed() {
        return is_reversed;
    }


    /**
     * Sets the is_reversed value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param is_reversed
     */
    public void setIs_reversed(int is_reversed) {
        this.is_reversed = is_reversed;
    }


    /**
     * Gets the status_noedit value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return status_noedit
     */
    public int getStatus_noedit() {
        return status_noedit;
    }


    /**
     * Sets the status_noedit value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param status_noedit
     */
    public void setStatus_noedit(int status_noedit) {
        this.status_noedit = status_noedit;
    }


    /**
     * Gets the processing value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return processing
     */
    public int getProcessing() {
        return processing;
    }


    /**
     * Sets the processing value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param processing
     */
    public void setProcessing(int processing) {
        this.processing = processing;
    }


    /**
     * Gets the customer_deposit_pay_amt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return customer_deposit_pay_amt
     */
    public java.math.BigDecimal getCustomer_deposit_pay_amt() {
        return customer_deposit_pay_amt;
    }


    /**
     * Sets the customer_deposit_pay_amt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param customer_deposit_pay_amt
     */
    public void setCustomer_deposit_pay_amt(java.math.BigDecimal customer_deposit_pay_amt) {
        this.customer_deposit_pay_amt = customer_deposit_pay_amt;
    }


    /**
     * Gets the nbr_times_issued value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return nbr_times_issued
     */
    public int getNbr_times_issued() {
        return nbr_times_issued;
    }


    /**
     * Sets the nbr_times_issued value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param nbr_times_issued
     */
    public void setNbr_times_issued(int nbr_times_issued) {
        this.nbr_times_issued = nbr_times_issued;
    }


    /**
     * Gets the pending_xaction_header_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the credit_card_start_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return credit_card_start_date
     */
    public java.util.Date getCredit_card_start_date() {
        return credit_card_start_date;
    }


    /**
     * Sets the credit_card_start_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param credit_card_start_date
     */
    public void setCredit_card_start_date(java.util.Date credit_card_start_date) {
        this.credit_card_start_date = credit_card_start_date;
    }


    /**
     * Gets the card_verification_value value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return card_verification_value
     */
    public java.lang.String getCard_verification_value() {
        return card_verification_value;
    }


    /**
     * Sets the card_verification_value value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param card_verification_value
     */
    public void setCard_verification_value(java.lang.String card_verification_value) {
        this.card_verification_value = card_verification_value;
    }


    /**
     * Gets the credit_card_issue_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return credit_card_issue_id
     */
    public java.lang.String getCredit_card_issue_id() {
        return credit_card_issue_id;
    }


    /**
     * Sets the credit_card_issue_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param credit_card_issue_id
     */
    public void setCredit_card_issue_id(java.lang.String credit_card_issue_id) {
        this.credit_card_issue_id = credit_card_issue_id;
    }


    /**
     * Gets the credit_card_bill_customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return credit_card_bill_customer_id
     */
    public int getCredit_card_bill_customer_id() {
        return credit_card_bill_customer_id;
    }


    /**
     * Sets the credit_card_bill_customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param credit_card_bill_customer_id
     */
    public void setCredit_card_bill_customer_id(int credit_card_bill_customer_id) {
        this.credit_card_bill_customer_id = credit_card_bill_customer_id;
    }


    /**
     * Gets the credit_card_bill_address_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return credit_card_bill_address_seq
     */
    public int getCredit_card_bill_address_seq() {
        return credit_card_bill_address_seq;
    }


    /**
     * Sets the credit_card_bill_address_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param credit_card_bill_address_seq
     */
    public void setCredit_card_bill_address_seq(int credit_card_bill_address_seq) {
        this.credit_card_bill_address_seq = credit_card_bill_address_seq;
    }


    /**
     * Gets the refund_deposit_pay_amt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return refund_deposit_pay_amt
     */
    public java.math.BigDecimal getRefund_deposit_pay_amt() {
        return refund_deposit_pay_amt;
    }


    /**
     * Sets the refund_deposit_pay_amt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param refund_deposit_pay_amt
     */
    public void setRefund_deposit_pay_amt(java.math.BigDecimal refund_deposit_pay_amt) {
        this.refund_deposit_pay_amt = refund_deposit_pay_amt;
    }


    /**
     * Gets the check_number value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return check_number
     */
    public java.lang.String getCheck_number() {
        return check_number;
    }


    /**
     * Sets the check_number value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param check_number
     */
    public void setCheck_number(java.lang.String check_number) {
        this.check_number = check_number;
    }


    /**
     * Gets the ics_bank_def_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return ics_bank_def_id
     */
    public int getIcs_bank_def_id() {
        return ics_bank_def_id;
    }


    /**
     * Sets the ics_bank_def_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param ics_bank_def_id
     */
    public void setIcs_bank_def_id(int ics_bank_def_id) {
        this.ics_bank_def_id = ics_bank_def_id;
    }


    /**
     * Gets the cash_realized value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return cash_realized
     */
    public int getCash_realized() {
        return cash_realized;
    }


    /**
     * Sets the cash_realized value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param cash_realized
     */
    public void setCash_realized(int cash_realized) {
        this.cash_realized = cash_realized;
    }


    /**
     * Gets the deposit_transaction value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return deposit_transaction
     */
    public int getDeposit_transaction() {
        return deposit_transaction;
    }


    /**
     * Sets the deposit_transaction value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param deposit_transaction
     */
    public void setDeposit_transaction(int deposit_transaction) {
        this.deposit_transaction = deposit_transaction;
    }


    /**
     * Gets the is_ecommerce value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return is_ecommerce
     */
    public int getIs_ecommerce() {
        return is_ecommerce;
    }


    /**
     * Sets the is_ecommerce value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param is_ecommerce
     */
    public void setIs_ecommerce(int is_ecommerce) {
        this.is_ecommerce = is_ecommerce;
    }


    /**
     * Gets the is_recurring value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return is_recurring
     */
    public int getIs_recurring() {
        return is_recurring;
    }


    /**
     * Sets the is_recurring value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param is_recurring
     */
    public void setIs_recurring(int is_recurring) {
        this.is_recurring = is_recurring;
    }


    /**
     * Gets the max_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return max_settle_retries
     */
    public int getMax_settle_retries() {
        return max_settle_retries;
    }


    /**
     * Sets the max_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param max_settle_retries
     */
    public void setMax_settle_retries(int max_settle_retries) {
        this.max_settle_retries = max_settle_retries;
    }


    /**
     * Gets the n_days_between_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return n_days_between_settle_retries
     */
    public int getN_days_between_settle_retries() {
        return n_days_between_settle_retries;
    }


    /**
     * Sets the n_days_between_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param n_days_between_settle_retries
     */
    public void setN_days_between_settle_retries(int n_days_between_settle_retries) {
        this.n_days_between_settle_retries = n_days_between_settle_retries;
    }


    /**
     * Gets the next_settle_retry_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return next_settle_retry_date
     */
    public java.util.Date getNext_settle_retry_date() {
        return next_settle_retry_date;
    }


    /**
     * Sets the next_settle_retry_date value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param next_settle_retry_date
     */
    public void setNext_settle_retry_date(java.util.Date next_settle_retry_date) {
        this.next_settle_retry_date = next_settle_retry_date;
    }


    /**
     * Gets the n_settle_retries_left value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return n_settle_retries_left
     */
    public int getN_settle_retries_left() {
        return n_settle_retries_left;
    }


    /**
     * Sets the n_settle_retries_left value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param n_settle_retries_left
     */
    public void setN_settle_retries_left(int n_settle_retries_left) {
        this.n_settle_retries_left = n_settle_retries_left;
    }


    /**
     * Gets the cancel_itm_after_settle_retry value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return cancel_itm_after_settle_retry
     */
    public int getCancel_itm_after_settle_retry() {
        return cancel_itm_after_settle_retry;
    }


    /**
     * Sets the cancel_itm_after_settle_retry value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param cancel_itm_after_settle_retry
     */
    public void setCancel_itm_after_settle_retry(int cancel_itm_after_settle_retry) {
        this.cancel_itm_after_settle_retry = cancel_itm_after_settle_retry;
    }


    /**
     * Gets the payment_account_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the needs_memo_post value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return needs_memo_post
     */
    public int getNeeds_memo_post() {
        return needs_memo_post;
    }


    /**
     * Sets the needs_memo_post value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param needs_memo_post
     */
    public void setNeeds_memo_post(int needs_memo_post) {
        this.needs_memo_post = needs_memo_post;
    }


    /**
     * Gets the id_nbr_last_four value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return id_nbr_last_four
     */
    public java.lang.String getId_nbr_last_four() {
        return id_nbr_last_four;
    }


    /**
     * Sets the id_nbr_last_four value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param id_nbr_last_four
     */
    public void setId_nbr_last_four(java.lang.String id_nbr_last_four) {
        this.id_nbr_last_four = id_nbr_last_four;
    }


    /**
     * Gets the bacs_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return bacs_id
     */
    public int getBacs_id() {
        return bacs_id;
    }


    /**
     * Sets the bacs_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param bacs_id
     */
    public void setBacs_id(int bacs_id) {
        this.bacs_id = bacs_id;
    }


    /**
     * Gets the cc_cleaned value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return cc_cleaned
     */
    public int getCc_cleaned() {
        return cc_cleaned;
    }


    /**
     * Sets the cc_cleaned value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param cc_cleaned
     */
    public void setCc_cleaned(int cc_cleaned) {
        this.cc_cleaned = cc_cleaned;
    }


    /**
     * Gets the hosted_secure_token_pmt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return hosted_secure_token_pmt
     */
    public int getHosted_secure_token_pmt() {
        return hosted_secure_token_pmt;
    }


    /**
     * Sets the hosted_secure_token_pmt value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param hosted_secure_token_pmt
     */
    public void setHosted_secure_token_pmt(int hosted_secure_token_pmt) {
        this.hosted_secure_token_pmt = hosted_secure_token_pmt;
    }


    /**
     * Gets the ba_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return ba_nbr
     */
    public java.lang.String getBa_nbr() {
        return ba_nbr;
    }


    /**
     * Sets the ba_nbr value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param ba_nbr
     */
    public void setBa_nbr(java.lang.String ba_nbr) {
        this.ba_nbr = ba_nbr;
    }


    /**
     * Gets the suspend_after_n_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return suspend_after_n_settle_retries
     */
    public int getSuspend_after_n_settle_retries() {
        return suspend_after_n_settle_retries;
    }


    /**
     * Sets the suspend_after_n_settle_retries value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param suspend_after_n_settle_retries
     */
    public void setSuspend_after_n_settle_retries(int suspend_after_n_settle_retries) {
        this.suspend_after_n_settle_retries = suspend_after_n_settle_retries;
    }


    /**
     * Gets the o_customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return o_customer_id
     */
    public int getO_customer_id() {
        return o_customer_id;
    }


    /**
     * Sets the o_customer_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param o_customer_id
     */
    public void setO_customer_id(int o_customer_id) {
        this.o_customer_id = o_customer_id;
    }


    /**
     * Gets the orderhdr_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Review_payments_list_select_responseView_payment_review.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Review_payments_list_select_responseView_payment_review)) return false;
        Review_payments_list_select_responseView_payment_review other = (Review_payments_list_select_responseView_payment_review) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
            this.payment_seq == other.getPayment_seq() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            this.date_stamp == other.getDate_stamp() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.id_nbr==null && other.getId_nbr()==null) || 
             (this.id_nbr!=null &&
              this.id_nbr.equals(other.getId_nbr()))) &&
            ((this.exp_date==null && other.getExp_date()==null) || 
             (this.exp_date!=null &&
              this.exp_date.equals(other.getExp_date()))) &&
            ((this.ref_nbr==null && other.getRef_nbr()==null) || 
             (this.ref_nbr!=null &&
              this.ref_nbr.equals(other.getRef_nbr()))) &&
            ((this.auth_code==null && other.getAuth_code()==null) || 
             (this.auth_code!=null &&
              this.auth_code.equals(other.getAuth_code()))) &&
            ((this.auth_date==null && other.getAuth_date()==null) || 
             (this.auth_date!=null &&
              this.auth_date.equals(other.getAuth_date()))) &&
            ((this.clear_date==null && other.getClear_date()==null) || 
             (this.clear_date!=null &&
              this.clear_date.equals(other.getClear_date()))) &&
            this.payment_clear_status == other.getPayment_clear_status() &&
            this.effort_nbr == other.getEffort_nbr() &&
            this.commission == other.getCommission() &&
            ((this.payment_type==null && other.getPayment_type()==null) || 
             (this.payment_type!=null &&
              this.payment_type.equals(other.getPayment_type()))) &&
            ((this.credit_card_info==null && other.getCredit_card_info()==null) || 
             (this.credit_card_info!=null &&
              this.credit_card_info.equals(other.getCredit_card_info()))) &&
            ((this.base_amount==null && other.getBase_amount()==null) || 
             (this.base_amount!=null &&
              this.base_amount.equals(other.getBase_amount()))) &&
            ((this.pay_currency_amount==null && other.getPay_currency_amount()==null) || 
             (this.pay_currency_amount!=null &&
              this.pay_currency_amount.equals(other.getPay_currency_amount()))) &&
            ((this.transaction_reason==null && other.getTransaction_reason()==null) || 
             (this.transaction_reason!=null &&
              this.transaction_reason.equals(other.getTransaction_reason()))) &&
            this.transaction_type == other.getTransaction_type() &&
            this.payment_clear_method == other.getPayment_clear_method() &&
            this.realize_cash_when == other.getRealize_cash_when() &&
            ((this.pay_exchange_rate==null && other.getPay_exchange_rate()==null) || 
             (this.pay_exchange_rate!=null &&
              this.pay_exchange_rate.equals(other.getPay_exchange_rate()))) &&
            this.is_reversed == other.getIs_reversed() &&
            this.status_noedit == other.getStatus_noedit() &&
            this.processing == other.getProcessing() &&
            ((this.customer_deposit_pay_amt==null && other.getCustomer_deposit_pay_amt()==null) || 
             (this.customer_deposit_pay_amt!=null &&
              this.customer_deposit_pay_amt.equals(other.getCustomer_deposit_pay_amt()))) &&
            this.nbr_times_issued == other.getNbr_times_issued() &&
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            ((this.credit_card_start_date==null && other.getCredit_card_start_date()==null) || 
             (this.credit_card_start_date!=null &&
              this.credit_card_start_date.equals(other.getCredit_card_start_date()))) &&
            ((this.card_verification_value==null && other.getCard_verification_value()==null) || 
             (this.card_verification_value!=null &&
              this.card_verification_value.equals(other.getCard_verification_value()))) &&
            ((this.credit_card_issue_id==null && other.getCredit_card_issue_id()==null) || 
             (this.credit_card_issue_id!=null &&
              this.credit_card_issue_id.equals(other.getCredit_card_issue_id()))) &&
            this.credit_card_bill_customer_id == other.getCredit_card_bill_customer_id() &&
            this.credit_card_bill_address_seq == other.getCredit_card_bill_address_seq() &&
            ((this.refund_deposit_pay_amt==null && other.getRefund_deposit_pay_amt()==null) || 
             (this.refund_deposit_pay_amt!=null &&
              this.refund_deposit_pay_amt.equals(other.getRefund_deposit_pay_amt()))) &&
            ((this.check_number==null && other.getCheck_number()==null) || 
             (this.check_number!=null &&
              this.check_number.equals(other.getCheck_number()))) &&
            this.ics_bank_def_id == other.getIcs_bank_def_id() &&
            this.cash_realized == other.getCash_realized() &&
            this.deposit_transaction == other.getDeposit_transaction() &&
            this.is_ecommerce == other.getIs_ecommerce() &&
            this.is_recurring == other.getIs_recurring() &&
            this.max_settle_retries == other.getMax_settle_retries() &&
            this.n_days_between_settle_retries == other.getN_days_between_settle_retries() &&
            ((this.next_settle_retry_date==null && other.getNext_settle_retry_date()==null) || 
             (this.next_settle_retry_date!=null &&
              this.next_settle_retry_date.equals(other.getNext_settle_retry_date()))) &&
            this.n_settle_retries_left == other.getN_settle_retries_left() &&
            this.cancel_itm_after_settle_retry == other.getCancel_itm_after_settle_retry() &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            this.needs_memo_post == other.getNeeds_memo_post() &&
            ((this.id_nbr_last_four==null && other.getId_nbr_last_four()==null) || 
             (this.id_nbr_last_four!=null &&
              this.id_nbr_last_four.equals(other.getId_nbr_last_four()))) &&
            this.bacs_id == other.getBacs_id() &&
            this.cc_cleaned == other.getCc_cleaned() &&
            this.hosted_secure_token_pmt == other.getHosted_secure_token_pmt() &&
            ((this.ba_nbr==null && other.getBa_nbr()==null) || 
             (this.ba_nbr!=null &&
              this.ba_nbr.equals(other.getBa_nbr()))) &&
            this.suspend_after_n_settle_retries == other.getSuspend_after_n_settle_retries() &&
            this.o_customer_id == other.getO_customer_id() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCustomer_id();
        _hashCode += getPayment_seq();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        _hashCode += getDate_stamp();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getId_nbr() != null) {
            _hashCode += getId_nbr().hashCode();
        }
        if (getExp_date() != null) {
            _hashCode += getExp_date().hashCode();
        }
        if (getRef_nbr() != null) {
            _hashCode += getRef_nbr().hashCode();
        }
        if (getAuth_code() != null) {
            _hashCode += getAuth_code().hashCode();
        }
        if (getAuth_date() != null) {
            _hashCode += getAuth_date().hashCode();
        }
        if (getClear_date() != null) {
            _hashCode += getClear_date().hashCode();
        }
        _hashCode += getPayment_clear_status();
        _hashCode += getEffort_nbr();
        _hashCode += getCommission();
        if (getPayment_type() != null) {
            _hashCode += getPayment_type().hashCode();
        }
        if (getCredit_card_info() != null) {
            _hashCode += getCredit_card_info().hashCode();
        }
        if (getBase_amount() != null) {
            _hashCode += getBase_amount().hashCode();
        }
        if (getPay_currency_amount() != null) {
            _hashCode += getPay_currency_amount().hashCode();
        }
        if (getTransaction_reason() != null) {
            _hashCode += getTransaction_reason().hashCode();
        }
        _hashCode += getTransaction_type();
        _hashCode += getPayment_clear_method();
        _hashCode += getRealize_cash_when();
        if (getPay_exchange_rate() != null) {
            _hashCode += getPay_exchange_rate().hashCode();
        }
        _hashCode += getIs_reversed();
        _hashCode += getStatus_noedit();
        _hashCode += getProcessing();
        if (getCustomer_deposit_pay_amt() != null) {
            _hashCode += getCustomer_deposit_pay_amt().hashCode();
        }
        _hashCode += getNbr_times_issued();
        _hashCode += getPending_xaction_header_id();
        if (getCredit_card_start_date() != null) {
            _hashCode += getCredit_card_start_date().hashCode();
        }
        if (getCard_verification_value() != null) {
            _hashCode += getCard_verification_value().hashCode();
        }
        if (getCredit_card_issue_id() != null) {
            _hashCode += getCredit_card_issue_id().hashCode();
        }
        _hashCode += getCredit_card_bill_customer_id();
        _hashCode += getCredit_card_bill_address_seq();
        if (getRefund_deposit_pay_amt() != null) {
            _hashCode += getRefund_deposit_pay_amt().hashCode();
        }
        if (getCheck_number() != null) {
            _hashCode += getCheck_number().hashCode();
        }
        _hashCode += getIcs_bank_def_id();
        _hashCode += getCash_realized();
        _hashCode += getDeposit_transaction();
        _hashCode += getIs_ecommerce();
        _hashCode += getIs_recurring();
        _hashCode += getMax_settle_retries();
        _hashCode += getN_days_between_settle_retries();
        if (getNext_settle_retry_date() != null) {
            _hashCode += getNext_settle_retry_date().hashCode();
        }
        _hashCode += getN_settle_retries_left();
        _hashCode += getCancel_itm_after_settle_retry();
        _hashCode += getPayment_account_seq();
        _hashCode += getNeeds_memo_post();
        if (getId_nbr_last_four() != null) {
            _hashCode += getId_nbr_last_four().hashCode();
        }
        _hashCode += getBacs_id();
        _hashCode += getCc_cleaned();
        _hashCode += getHosted_secure_token_pmt();
        if (getBa_nbr() != null) {
            _hashCode += getBa_nbr().hashCode();
        }
        _hashCode += getSuspend_after_n_settle_retries();
        _hashCode += getO_customer_id();
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Review_payments_list_select_responseView_payment_review.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>review_payments_list_select_response>view_payment_review"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("exp_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "exp_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auth_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auth_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auth_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auth_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("clear_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "clear_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_clear_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_clear_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("effort_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "effort_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("commission");
        attrField.setXmlName(new javax.xml.namespace.QName("", "commission"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_info");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_info"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_currency_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_currency_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transaction_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transaction_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transaction_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transaction_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_clear_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_clear_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("realize_cash_when");
        attrField.setXmlName(new javax.xml.namespace.QName("", "realize_cash_when"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_exchange_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_exchange_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_reversed");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_reversed"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status_noedit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status_noedit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("processing");
        attrField.setXmlName(new javax.xml.namespace.QName("", "processing"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_deposit_pay_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_deposit_pay_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nbr_times_issued");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nbr_times_issued"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_header_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_header_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_start_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_start_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("card_verification_value");
        attrField.setXmlName(new javax.xml.namespace.QName("", "card_verification_value"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_bill_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_bill_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_bill_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_bill_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_deposit_pay_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_deposit_pay_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("check_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "check_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ics_bank_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ics_bank_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cash_realized");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cash_realized"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deposit_transaction");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deposit_transaction"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_ecommerce");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_ecommerce"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_recurring");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_recurring"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("max_settle_retries");
        attrField.setXmlName(new javax.xml.namespace.QName("", "max_settle_retries"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_days_between_settle_retries");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_days_between_settle_retries"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("next_settle_retry_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "next_settle_retry_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_settle_retries_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_settle_retries_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_itm_after_settle_retry");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_itm_after_settle_retry"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("needs_memo_post");
        attrField.setXmlName(new javax.xml.namespace.QName("", "needs_memo_post"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id_nbr_last_four");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id_nbr_last_four"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bacs_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bacs_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_cleaned");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_cleaned"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("hosted_secure_token_pmt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "hosted_secure_token_pmt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ba_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ba_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspend_after_n_settle_retries");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspend_after_n_settle_retries"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("o_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "o_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
