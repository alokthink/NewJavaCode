/**
 * ZZWorkTablePayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZWorkTablePayment  implements java.io.Serializable {
    private int job_id;  // attribute

    private int work_table_seq;  // attribute

    private java.lang.String account_reference;  // attribute

    private java.lang.String auddis_transaction_code;  // attribute

    private java.lang.String avs_address;  // attribute

    private java.lang.String avs_zip;  // attribute

    private java.lang.String currency;  // attribute

    private int customer_id;  // attribute

    private java.lang.String dd_account_name;  // attribute

    private java.lang.String dd_account_number;  // attribute

    private java.lang.String dd_account_number_plain;  // attribute

    private java.lang.String dd_bank_code;  // attribute

    private int dd_bank_def_id;  // attribute

    private java.lang.String dd_payment_type;  // attribute

    private java.lang.String dd_sorting_code;  // attribute

    private int dd_transaction_code;  // attribute

    private int icv_bank_def_id;  // attribute

    private int issue_id;  // attribute

    private int oc_id;  // attribute

    private java.util.Date order_date;  // attribute

    private int order_item_seq;  // attribute

    private int orderhdr_id;  // attribute

    private int original_payment_clear_status;  // attribute

    private java.math.BigDecimal pay_amount;  // attribute

    private java.lang.String pay_auth_code;  // attribute

    private java.util.Date pay_auth_date;  // attribute

    private java.lang.String pay_check_number;  // attribute

    private java.util.Date pay_clear_date;  // attribute

    private java.lang.String pay_credit_card_info;  // attribute

    private int pay_exp_month;  // attribute

    private java.lang.String pay_exp_year;  // attribute

    private java.lang.String pay_id_number;  // attribute

    private java.lang.String pay_ref_number;  // attribute

    private java.lang.String pay_status_reason;  // attribute

    private int payment_clear_status;  // attribute

    private int payment_seq;  // attribute

    private java.lang.String priority_sort_string;  // attribute

    private int refund_via_process;  // attribute

    private int selected;  // attribute

    private int send_to_customer_address_seq;  // attribute

    private int send_to_customer_id;  // attribute

    private java.lang.String sort_string;  // attribute

    private java.lang.String state;  // attribute

    private int subscrip_id;  // attribute

    private int work_record_status;  // attribute

    public ZZWorkTablePayment() {
    }

    public ZZWorkTablePayment(
           int job_id,
           int work_table_seq,
           java.lang.String account_reference,
           java.lang.String auddis_transaction_code,
           java.lang.String avs_address,
           java.lang.String avs_zip,
           java.lang.String currency,
           int customer_id,
           java.lang.String dd_account_name,
           java.lang.String dd_account_number,
           java.lang.String dd_account_number_plain,
           java.lang.String dd_bank_code,
           int dd_bank_def_id,
           java.lang.String dd_payment_type,
           java.lang.String dd_sorting_code,
           int dd_transaction_code,
           int icv_bank_def_id,
           int issue_id,
           int oc_id,
           java.util.Date order_date,
           int order_item_seq,
           int orderhdr_id,
           int original_payment_clear_status,
           java.math.BigDecimal pay_amount,
           java.lang.String pay_auth_code,
           java.util.Date pay_auth_date,
           java.lang.String pay_check_number,
           java.util.Date pay_clear_date,
           java.lang.String pay_credit_card_info,
           int pay_exp_month,
           java.lang.String pay_exp_year,
           java.lang.String pay_id_number,
           java.lang.String pay_ref_number,
           java.lang.String pay_status_reason,
           int payment_clear_status,
           int payment_seq,
           java.lang.String priority_sort_string,
           int refund_via_process,
           int selected,
           int send_to_customer_address_seq,
           int send_to_customer_id,
           java.lang.String sort_string,
           java.lang.String state,
           int subscrip_id,
           int work_record_status) {
           this.job_id = job_id;
           this.work_table_seq = work_table_seq;
           this.account_reference = account_reference;
           this.auddis_transaction_code = auddis_transaction_code;
           this.avs_address = avs_address;
           this.avs_zip = avs_zip;
           this.currency = currency;
           this.customer_id = customer_id;
           this.dd_account_name = dd_account_name;
           this.dd_account_number = dd_account_number;
           this.dd_account_number_plain = dd_account_number_plain;
           this.dd_bank_code = dd_bank_code;
           this.dd_bank_def_id = dd_bank_def_id;
           this.dd_payment_type = dd_payment_type;
           this.dd_sorting_code = dd_sorting_code;
           this.dd_transaction_code = dd_transaction_code;
           this.icv_bank_def_id = icv_bank_def_id;
           this.issue_id = issue_id;
           this.oc_id = oc_id;
           this.order_date = order_date;
           this.order_item_seq = order_item_seq;
           this.orderhdr_id = orderhdr_id;
           this.original_payment_clear_status = original_payment_clear_status;
           this.pay_amount = pay_amount;
           this.pay_auth_code = pay_auth_code;
           this.pay_auth_date = pay_auth_date;
           this.pay_check_number = pay_check_number;
           this.pay_clear_date = pay_clear_date;
           this.pay_credit_card_info = pay_credit_card_info;
           this.pay_exp_month = pay_exp_month;
           this.pay_exp_year = pay_exp_year;
           this.pay_id_number = pay_id_number;
           this.pay_ref_number = pay_ref_number;
           this.pay_status_reason = pay_status_reason;
           this.payment_clear_status = payment_clear_status;
           this.payment_seq = payment_seq;
           this.priority_sort_string = priority_sort_string;
           this.refund_via_process = refund_via_process;
           this.selected = selected;
           this.send_to_customer_address_seq = send_to_customer_address_seq;
           this.send_to_customer_id = send_to_customer_id;
           this.sort_string = sort_string;
           this.state = state;
           this.subscrip_id = subscrip_id;
           this.work_record_status = work_record_status;
    }


    /**
     * Gets the job_id value for this ZZWorkTablePayment.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this ZZWorkTablePayment.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the work_table_seq value for this ZZWorkTablePayment.
     * 
     * @return work_table_seq
     */
    public int getWork_table_seq() {
        return work_table_seq;
    }


    /**
     * Sets the work_table_seq value for this ZZWorkTablePayment.
     * 
     * @param work_table_seq
     */
    public void setWork_table_seq(int work_table_seq) {
        this.work_table_seq = work_table_seq;
    }


    /**
     * Gets the account_reference value for this ZZWorkTablePayment.
     * 
     * @return account_reference
     */
    public java.lang.String getAccount_reference() {
        return account_reference;
    }


    /**
     * Sets the account_reference value for this ZZWorkTablePayment.
     * 
     * @param account_reference
     */
    public void setAccount_reference(java.lang.String account_reference) {
        this.account_reference = account_reference;
    }


    /**
     * Gets the auddis_transaction_code value for this ZZWorkTablePayment.
     * 
     * @return auddis_transaction_code
     */
    public java.lang.String getAuddis_transaction_code() {
        return auddis_transaction_code;
    }


    /**
     * Sets the auddis_transaction_code value for this ZZWorkTablePayment.
     * 
     * @param auddis_transaction_code
     */
    public void setAuddis_transaction_code(java.lang.String auddis_transaction_code) {
        this.auddis_transaction_code = auddis_transaction_code;
    }


    /**
     * Gets the avs_address value for this ZZWorkTablePayment.
     * 
     * @return avs_address
     */
    public java.lang.String getAvs_address() {
        return avs_address;
    }


    /**
     * Sets the avs_address value for this ZZWorkTablePayment.
     * 
     * @param avs_address
     */
    public void setAvs_address(java.lang.String avs_address) {
        this.avs_address = avs_address;
    }


    /**
     * Gets the avs_zip value for this ZZWorkTablePayment.
     * 
     * @return avs_zip
     */
    public java.lang.String getAvs_zip() {
        return avs_zip;
    }


    /**
     * Sets the avs_zip value for this ZZWorkTablePayment.
     * 
     * @param avs_zip
     */
    public void setAvs_zip(java.lang.String avs_zip) {
        this.avs_zip = avs_zip;
    }


    /**
     * Gets the currency value for this ZZWorkTablePayment.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this ZZWorkTablePayment.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the customer_id value for this ZZWorkTablePayment.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZWorkTablePayment.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the dd_account_name value for this ZZWorkTablePayment.
     * 
     * @return dd_account_name
     */
    public java.lang.String getDd_account_name() {
        return dd_account_name;
    }


    /**
     * Sets the dd_account_name value for this ZZWorkTablePayment.
     * 
     * @param dd_account_name
     */
    public void setDd_account_name(java.lang.String dd_account_name) {
        this.dd_account_name = dd_account_name;
    }


    /**
     * Gets the dd_account_number value for this ZZWorkTablePayment.
     * 
     * @return dd_account_number
     */
    public java.lang.String getDd_account_number() {
        return dd_account_number;
    }


    /**
     * Sets the dd_account_number value for this ZZWorkTablePayment.
     * 
     * @param dd_account_number
     */
    public void setDd_account_number(java.lang.String dd_account_number) {
        this.dd_account_number = dd_account_number;
    }


    /**
     * Gets the dd_account_number_plain value for this ZZWorkTablePayment.
     * 
     * @return dd_account_number_plain
     */
    public java.lang.String getDd_account_number_plain() {
        return dd_account_number_plain;
    }


    /**
     * Sets the dd_account_number_plain value for this ZZWorkTablePayment.
     * 
     * @param dd_account_number_plain
     */
    public void setDd_account_number_plain(java.lang.String dd_account_number_plain) {
        this.dd_account_number_plain = dd_account_number_plain;
    }


    /**
     * Gets the dd_bank_code value for this ZZWorkTablePayment.
     * 
     * @return dd_bank_code
     */
    public java.lang.String getDd_bank_code() {
        return dd_bank_code;
    }


    /**
     * Sets the dd_bank_code value for this ZZWorkTablePayment.
     * 
     * @param dd_bank_code
     */
    public void setDd_bank_code(java.lang.String dd_bank_code) {
        this.dd_bank_code = dd_bank_code;
    }


    /**
     * Gets the dd_bank_def_id value for this ZZWorkTablePayment.
     * 
     * @return dd_bank_def_id
     */
    public int getDd_bank_def_id() {
        return dd_bank_def_id;
    }


    /**
     * Sets the dd_bank_def_id value for this ZZWorkTablePayment.
     * 
     * @param dd_bank_def_id
     */
    public void setDd_bank_def_id(int dd_bank_def_id) {
        this.dd_bank_def_id = dd_bank_def_id;
    }


    /**
     * Gets the dd_payment_type value for this ZZWorkTablePayment.
     * 
     * @return dd_payment_type
     */
    public java.lang.String getDd_payment_type() {
        return dd_payment_type;
    }


    /**
     * Sets the dd_payment_type value for this ZZWorkTablePayment.
     * 
     * @param dd_payment_type
     */
    public void setDd_payment_type(java.lang.String dd_payment_type) {
        this.dd_payment_type = dd_payment_type;
    }


    /**
     * Gets the dd_sorting_code value for this ZZWorkTablePayment.
     * 
     * @return dd_sorting_code
     */
    public java.lang.String getDd_sorting_code() {
        return dd_sorting_code;
    }


    /**
     * Sets the dd_sorting_code value for this ZZWorkTablePayment.
     * 
     * @param dd_sorting_code
     */
    public void setDd_sorting_code(java.lang.String dd_sorting_code) {
        this.dd_sorting_code = dd_sorting_code;
    }


    /**
     * Gets the dd_transaction_code value for this ZZWorkTablePayment.
     * 
     * @return dd_transaction_code
     */
    public int getDd_transaction_code() {
        return dd_transaction_code;
    }


    /**
     * Sets the dd_transaction_code value for this ZZWorkTablePayment.
     * 
     * @param dd_transaction_code
     */
    public void setDd_transaction_code(int dd_transaction_code) {
        this.dd_transaction_code = dd_transaction_code;
    }


    /**
     * Gets the icv_bank_def_id value for this ZZWorkTablePayment.
     * 
     * @return icv_bank_def_id
     */
    public int getIcv_bank_def_id() {
        return icv_bank_def_id;
    }


    /**
     * Sets the icv_bank_def_id value for this ZZWorkTablePayment.
     * 
     * @param icv_bank_def_id
     */
    public void setIcv_bank_def_id(int icv_bank_def_id) {
        this.icv_bank_def_id = icv_bank_def_id;
    }


    /**
     * Gets the issue_id value for this ZZWorkTablePayment.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this ZZWorkTablePayment.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the oc_id value for this ZZWorkTablePayment.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this ZZWorkTablePayment.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the order_date value for this ZZWorkTablePayment.
     * 
     * @return order_date
     */
    public java.util.Date getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this ZZWorkTablePayment.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Date order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the order_item_seq value for this ZZWorkTablePayment.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZWorkTablePayment.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the orderhdr_id value for this ZZWorkTablePayment.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZWorkTablePayment.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the original_payment_clear_status value for this ZZWorkTablePayment.
     * 
     * @return original_payment_clear_status
     */
    public int getOriginal_payment_clear_status() {
        return original_payment_clear_status;
    }


    /**
     * Sets the original_payment_clear_status value for this ZZWorkTablePayment.
     * 
     * @param original_payment_clear_status
     */
    public void setOriginal_payment_clear_status(int original_payment_clear_status) {
        this.original_payment_clear_status = original_payment_clear_status;
    }


    /**
     * Gets the pay_amount value for this ZZWorkTablePayment.
     * 
     * @return pay_amount
     */
    public java.math.BigDecimal getPay_amount() {
        return pay_amount;
    }


    /**
     * Sets the pay_amount value for this ZZWorkTablePayment.
     * 
     * @param pay_amount
     */
    public void setPay_amount(java.math.BigDecimal pay_amount) {
        this.pay_amount = pay_amount;
    }


    /**
     * Gets the pay_auth_code value for this ZZWorkTablePayment.
     * 
     * @return pay_auth_code
     */
    public java.lang.String getPay_auth_code() {
        return pay_auth_code;
    }


    /**
     * Sets the pay_auth_code value for this ZZWorkTablePayment.
     * 
     * @param pay_auth_code
     */
    public void setPay_auth_code(java.lang.String pay_auth_code) {
        this.pay_auth_code = pay_auth_code;
    }


    /**
     * Gets the pay_auth_date value for this ZZWorkTablePayment.
     * 
     * @return pay_auth_date
     */
    public java.util.Date getPay_auth_date() {
        return pay_auth_date;
    }


    /**
     * Sets the pay_auth_date value for this ZZWorkTablePayment.
     * 
     * @param pay_auth_date
     */
    public void setPay_auth_date(java.util.Date pay_auth_date) {
        this.pay_auth_date = pay_auth_date;
    }


    /**
     * Gets the pay_check_number value for this ZZWorkTablePayment.
     * 
     * @return pay_check_number
     */
    public java.lang.String getPay_check_number() {
        return pay_check_number;
    }


    /**
     * Sets the pay_check_number value for this ZZWorkTablePayment.
     * 
     * @param pay_check_number
     */
    public void setPay_check_number(java.lang.String pay_check_number) {
        this.pay_check_number = pay_check_number;
    }


    /**
     * Gets the pay_clear_date value for this ZZWorkTablePayment.
     * 
     * @return pay_clear_date
     */
    public java.util.Date getPay_clear_date() {
        return pay_clear_date;
    }


    /**
     * Sets the pay_clear_date value for this ZZWorkTablePayment.
     * 
     * @param pay_clear_date
     */
    public void setPay_clear_date(java.util.Date pay_clear_date) {
        this.pay_clear_date = pay_clear_date;
    }


    /**
     * Gets the pay_credit_card_info value for this ZZWorkTablePayment.
     * 
     * @return pay_credit_card_info
     */
    public java.lang.String getPay_credit_card_info() {
        return pay_credit_card_info;
    }


    /**
     * Sets the pay_credit_card_info value for this ZZWorkTablePayment.
     * 
     * @param pay_credit_card_info
     */
    public void setPay_credit_card_info(java.lang.String pay_credit_card_info) {
        this.pay_credit_card_info = pay_credit_card_info;
    }


    /**
     * Gets the pay_exp_month value for this ZZWorkTablePayment.
     * 
     * @return pay_exp_month
     */
    public int getPay_exp_month() {
        return pay_exp_month;
    }


    /**
     * Sets the pay_exp_month value for this ZZWorkTablePayment.
     * 
     * @param pay_exp_month
     */
    public void setPay_exp_month(int pay_exp_month) {
        this.pay_exp_month = pay_exp_month;
    }


    /**
     * Gets the pay_exp_year value for this ZZWorkTablePayment.
     * 
     * @return pay_exp_year
     */
    public java.lang.String getPay_exp_year() {
        return pay_exp_year;
    }


    /**
     * Sets the pay_exp_year value for this ZZWorkTablePayment.
     * 
     * @param pay_exp_year
     */
    public void setPay_exp_year(java.lang.String pay_exp_year) {
        this.pay_exp_year = pay_exp_year;
    }


    /**
     * Gets the pay_id_number value for this ZZWorkTablePayment.
     * 
     * @return pay_id_number
     */
    public java.lang.String getPay_id_number() {
        return pay_id_number;
    }


    /**
     * Sets the pay_id_number value for this ZZWorkTablePayment.
     * 
     * @param pay_id_number
     */
    public void setPay_id_number(java.lang.String pay_id_number) {
        this.pay_id_number = pay_id_number;
    }


    /**
     * Gets the pay_ref_number value for this ZZWorkTablePayment.
     * 
     * @return pay_ref_number
     */
    public java.lang.String getPay_ref_number() {
        return pay_ref_number;
    }


    /**
     * Sets the pay_ref_number value for this ZZWorkTablePayment.
     * 
     * @param pay_ref_number
     */
    public void setPay_ref_number(java.lang.String pay_ref_number) {
        this.pay_ref_number = pay_ref_number;
    }


    /**
     * Gets the pay_status_reason value for this ZZWorkTablePayment.
     * 
     * @return pay_status_reason
     */
    public java.lang.String getPay_status_reason() {
        return pay_status_reason;
    }


    /**
     * Sets the pay_status_reason value for this ZZWorkTablePayment.
     * 
     * @param pay_status_reason
     */
    public void setPay_status_reason(java.lang.String pay_status_reason) {
        this.pay_status_reason = pay_status_reason;
    }


    /**
     * Gets the payment_clear_status value for this ZZWorkTablePayment.
     * 
     * @return payment_clear_status
     */
    public int getPayment_clear_status() {
        return payment_clear_status;
    }


    /**
     * Sets the payment_clear_status value for this ZZWorkTablePayment.
     * 
     * @param payment_clear_status
     */
    public void setPayment_clear_status(int payment_clear_status) {
        this.payment_clear_status = payment_clear_status;
    }


    /**
     * Gets the payment_seq value for this ZZWorkTablePayment.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this ZZWorkTablePayment.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the priority_sort_string value for this ZZWorkTablePayment.
     * 
     * @return priority_sort_string
     */
    public java.lang.String getPriority_sort_string() {
        return priority_sort_string;
    }


    /**
     * Sets the priority_sort_string value for this ZZWorkTablePayment.
     * 
     * @param priority_sort_string
     */
    public void setPriority_sort_string(java.lang.String priority_sort_string) {
        this.priority_sort_string = priority_sort_string;
    }


    /**
     * Gets the refund_via_process value for this ZZWorkTablePayment.
     * 
     * @return refund_via_process
     */
    public int getRefund_via_process() {
        return refund_via_process;
    }


    /**
     * Sets the refund_via_process value for this ZZWorkTablePayment.
     * 
     * @param refund_via_process
     */
    public void setRefund_via_process(int refund_via_process) {
        this.refund_via_process = refund_via_process;
    }


    /**
     * Gets the selected value for this ZZWorkTablePayment.
     * 
     * @return selected
     */
    public int getSelected() {
        return selected;
    }


    /**
     * Sets the selected value for this ZZWorkTablePayment.
     * 
     * @param selected
     */
    public void setSelected(int selected) {
        this.selected = selected;
    }


    /**
     * Gets the send_to_customer_address_seq value for this ZZWorkTablePayment.
     * 
     * @return send_to_customer_address_seq
     */
    public int getSend_to_customer_address_seq() {
        return send_to_customer_address_seq;
    }


    /**
     * Sets the send_to_customer_address_seq value for this ZZWorkTablePayment.
     * 
     * @param send_to_customer_address_seq
     */
    public void setSend_to_customer_address_seq(int send_to_customer_address_seq) {
        this.send_to_customer_address_seq = send_to_customer_address_seq;
    }


    /**
     * Gets the send_to_customer_id value for this ZZWorkTablePayment.
     * 
     * @return send_to_customer_id
     */
    public int getSend_to_customer_id() {
        return send_to_customer_id;
    }


    /**
     * Sets the send_to_customer_id value for this ZZWorkTablePayment.
     * 
     * @param send_to_customer_id
     */
    public void setSend_to_customer_id(int send_to_customer_id) {
        this.send_to_customer_id = send_to_customer_id;
    }


    /**
     * Gets the sort_string value for this ZZWorkTablePayment.
     * 
     * @return sort_string
     */
    public java.lang.String getSort_string() {
        return sort_string;
    }


    /**
     * Sets the sort_string value for this ZZWorkTablePayment.
     * 
     * @param sort_string
     */
    public void setSort_string(java.lang.String sort_string) {
        this.sort_string = sort_string;
    }


    /**
     * Gets the state value for this ZZWorkTablePayment.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this ZZWorkTablePayment.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the subscrip_id value for this ZZWorkTablePayment.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this ZZWorkTablePayment.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the work_record_status value for this ZZWorkTablePayment.
     * 
     * @return work_record_status
     */
    public int getWork_record_status() {
        return work_record_status;
    }


    /**
     * Sets the work_record_status value for this ZZWorkTablePayment.
     * 
     * @param work_record_status
     */
    public void setWork_record_status(int work_record_status) {
        this.work_record_status = work_record_status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZWorkTablePayment)) return false;
        ZZWorkTablePayment other = (ZZWorkTablePayment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            this.work_table_seq == other.getWork_table_seq() &&
            ((this.account_reference==null && other.getAccount_reference()==null) || 
             (this.account_reference!=null &&
              this.account_reference.equals(other.getAccount_reference()))) &&
            ((this.auddis_transaction_code==null && other.getAuddis_transaction_code()==null) || 
             (this.auddis_transaction_code!=null &&
              this.auddis_transaction_code.equals(other.getAuddis_transaction_code()))) &&
            ((this.avs_address==null && other.getAvs_address()==null) || 
             (this.avs_address!=null &&
              this.avs_address.equals(other.getAvs_address()))) &&
            ((this.avs_zip==null && other.getAvs_zip()==null) || 
             (this.avs_zip!=null &&
              this.avs_zip.equals(other.getAvs_zip()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            this.customer_id == other.getCustomer_id() &&
            ((this.dd_account_name==null && other.getDd_account_name()==null) || 
             (this.dd_account_name!=null &&
              this.dd_account_name.equals(other.getDd_account_name()))) &&
            ((this.dd_account_number==null && other.getDd_account_number()==null) || 
             (this.dd_account_number!=null &&
              this.dd_account_number.equals(other.getDd_account_number()))) &&
            ((this.dd_account_number_plain==null && other.getDd_account_number_plain()==null) || 
             (this.dd_account_number_plain!=null &&
              this.dd_account_number_plain.equals(other.getDd_account_number_plain()))) &&
            ((this.dd_bank_code==null && other.getDd_bank_code()==null) || 
             (this.dd_bank_code!=null &&
              this.dd_bank_code.equals(other.getDd_bank_code()))) &&
            this.dd_bank_def_id == other.getDd_bank_def_id() &&
            ((this.dd_payment_type==null && other.getDd_payment_type()==null) || 
             (this.dd_payment_type!=null &&
              this.dd_payment_type.equals(other.getDd_payment_type()))) &&
            ((this.dd_sorting_code==null && other.getDd_sorting_code()==null) || 
             (this.dd_sorting_code!=null &&
              this.dd_sorting_code.equals(other.getDd_sorting_code()))) &&
            this.dd_transaction_code == other.getDd_transaction_code() &&
            this.icv_bank_def_id == other.getIcv_bank_def_id() &&
            this.issue_id == other.getIssue_id() &&
            this.oc_id == other.getOc_id() &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.original_payment_clear_status == other.getOriginal_payment_clear_status() &&
            ((this.pay_amount==null && other.getPay_amount()==null) || 
             (this.pay_amount!=null &&
              this.pay_amount.equals(other.getPay_amount()))) &&
            ((this.pay_auth_code==null && other.getPay_auth_code()==null) || 
             (this.pay_auth_code!=null &&
              this.pay_auth_code.equals(other.getPay_auth_code()))) &&
            ((this.pay_auth_date==null && other.getPay_auth_date()==null) || 
             (this.pay_auth_date!=null &&
              this.pay_auth_date.equals(other.getPay_auth_date()))) &&
            ((this.pay_check_number==null && other.getPay_check_number()==null) || 
             (this.pay_check_number!=null &&
              this.pay_check_number.equals(other.getPay_check_number()))) &&
            ((this.pay_clear_date==null && other.getPay_clear_date()==null) || 
             (this.pay_clear_date!=null &&
              this.pay_clear_date.equals(other.getPay_clear_date()))) &&
            ((this.pay_credit_card_info==null && other.getPay_credit_card_info()==null) || 
             (this.pay_credit_card_info!=null &&
              this.pay_credit_card_info.equals(other.getPay_credit_card_info()))) &&
            this.pay_exp_month == other.getPay_exp_month() &&
            ((this.pay_exp_year==null && other.getPay_exp_year()==null) || 
             (this.pay_exp_year!=null &&
              this.pay_exp_year.equals(other.getPay_exp_year()))) &&
            ((this.pay_id_number==null && other.getPay_id_number()==null) || 
             (this.pay_id_number!=null &&
              this.pay_id_number.equals(other.getPay_id_number()))) &&
            ((this.pay_ref_number==null && other.getPay_ref_number()==null) || 
             (this.pay_ref_number!=null &&
              this.pay_ref_number.equals(other.getPay_ref_number()))) &&
            ((this.pay_status_reason==null && other.getPay_status_reason()==null) || 
             (this.pay_status_reason!=null &&
              this.pay_status_reason.equals(other.getPay_status_reason()))) &&
            this.payment_clear_status == other.getPayment_clear_status() &&
            this.payment_seq == other.getPayment_seq() &&
            ((this.priority_sort_string==null && other.getPriority_sort_string()==null) || 
             (this.priority_sort_string!=null &&
              this.priority_sort_string.equals(other.getPriority_sort_string()))) &&
            this.refund_via_process == other.getRefund_via_process() &&
            this.selected == other.getSelected() &&
            this.send_to_customer_address_seq == other.getSend_to_customer_address_seq() &&
            this.send_to_customer_id == other.getSend_to_customer_id() &&
            ((this.sort_string==null && other.getSort_string()==null) || 
             (this.sort_string!=null &&
              this.sort_string.equals(other.getSort_string()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            this.subscrip_id == other.getSubscrip_id() &&
            this.work_record_status == other.getWork_record_status();
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
        _hashCode += getJob_id();
        _hashCode += getWork_table_seq();
        if (getAccount_reference() != null) {
            _hashCode += getAccount_reference().hashCode();
        }
        if (getAuddis_transaction_code() != null) {
            _hashCode += getAuddis_transaction_code().hashCode();
        }
        if (getAvs_address() != null) {
            _hashCode += getAvs_address().hashCode();
        }
        if (getAvs_zip() != null) {
            _hashCode += getAvs_zip().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        _hashCode += getCustomer_id();
        if (getDd_account_name() != null) {
            _hashCode += getDd_account_name().hashCode();
        }
        if (getDd_account_number() != null) {
            _hashCode += getDd_account_number().hashCode();
        }
        if (getDd_account_number_plain() != null) {
            _hashCode += getDd_account_number_plain().hashCode();
        }
        if (getDd_bank_code() != null) {
            _hashCode += getDd_bank_code().hashCode();
        }
        _hashCode += getDd_bank_def_id();
        if (getDd_payment_type() != null) {
            _hashCode += getDd_payment_type().hashCode();
        }
        if (getDd_sorting_code() != null) {
            _hashCode += getDd_sorting_code().hashCode();
        }
        _hashCode += getDd_transaction_code();
        _hashCode += getIcv_bank_def_id();
        _hashCode += getIssue_id();
        _hashCode += getOc_id();
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        _hashCode += getOrder_item_seq();
        _hashCode += getOrderhdr_id();
        _hashCode += getOriginal_payment_clear_status();
        if (getPay_amount() != null) {
            _hashCode += getPay_amount().hashCode();
        }
        if (getPay_auth_code() != null) {
            _hashCode += getPay_auth_code().hashCode();
        }
        if (getPay_auth_date() != null) {
            _hashCode += getPay_auth_date().hashCode();
        }
        if (getPay_check_number() != null) {
            _hashCode += getPay_check_number().hashCode();
        }
        if (getPay_clear_date() != null) {
            _hashCode += getPay_clear_date().hashCode();
        }
        if (getPay_credit_card_info() != null) {
            _hashCode += getPay_credit_card_info().hashCode();
        }
        _hashCode += getPay_exp_month();
        if (getPay_exp_year() != null) {
            _hashCode += getPay_exp_year().hashCode();
        }
        if (getPay_id_number() != null) {
            _hashCode += getPay_id_number().hashCode();
        }
        if (getPay_ref_number() != null) {
            _hashCode += getPay_ref_number().hashCode();
        }
        if (getPay_status_reason() != null) {
            _hashCode += getPay_status_reason().hashCode();
        }
        _hashCode += getPayment_clear_status();
        _hashCode += getPayment_seq();
        if (getPriority_sort_string() != null) {
            _hashCode += getPriority_sort_string().hashCode();
        }
        _hashCode += getRefund_via_process();
        _hashCode += getSelected();
        _hashCode += getSend_to_customer_address_seq();
        _hashCode += getSend_to_customer_id();
        if (getSort_string() != null) {
            _hashCode += getSort_string().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        _hashCode += getSubscrip_id();
        _hashCode += getWork_record_status();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZWorkTablePayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZWorkTablePayment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("work_table_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "work_table_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("account_reference");
        attrField.setXmlName(new javax.xml.namespace.QName("", "account_reference"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auddis_transaction_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auddis_transaction_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("avs_address");
        attrField.setXmlName(new javax.xml.namespace.QName("", "avs_address"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("avs_zip");
        attrField.setXmlName(new javax.xml.namespace.QName("", "avs_zip"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_account_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_account_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_account_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_account_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_account_number_plain");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_account_number_plain"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_bank_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_bank_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_bank_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_bank_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_payment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_payment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_sorting_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_sorting_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dd_transaction_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dd_transaction_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("icv_bank_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "icv_bank_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("original_payment_clear_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "original_payment_clear_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_auth_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_auth_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_auth_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_auth_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_check_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_check_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_clear_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_clear_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_credit_card_info");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_credit_card_info"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_exp_month");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_exp_month"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_exp_year");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_exp_year"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_id_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_id_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_ref_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_ref_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_status_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_status_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_clear_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_clear_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("priority_sort_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "priority_sort_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_via_process");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_via_process"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("selected");
        attrField.setXmlName(new javax.xml.namespace.QName("", "selected"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_to_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sort_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sort_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("state");
        attrField.setXmlName(new javax.xml.namespace.QName("", "state"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("work_record_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "work_record_status"));
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
