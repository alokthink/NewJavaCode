/**
 * Work_table_select_responseWork_table.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Work_table_select_responseWork_table  implements java.io.Serializable {
    private int job_id;  // attribute

    private int work_table_seq;  // attribute

    private int work_record_status;  // attribute

    private byte[] update_mask;  // attribute

    private byte[] insert_bits;  // attribute

    private byte[] promotion_bits;  // attribute

    private java.lang.String split_value;  // attribute

    private int customer_id;  // attribute

    private int send_to_customer_id;  // attribute

    private int send_to_customer_address_seq;  // attribute

    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int subscrip_id;  // attribute

    private java.lang.String label1;  // attribute

    private java.lang.String label2;  // attribute

    private java.lang.String label3;  // attribute

    private java.lang.String label4;  // attribute

    private java.lang.String label5;  // attribute

    private java.lang.String label6;  // attribute

    private java.lang.String label7;  // attribute

    private java.lang.String label8;  // attribute

    private java.lang.String label9;  // attribute

    private java.lang.String label10;  // attribute

    private java.lang.String sort_string;  // attribute

    private java.lang.String priority_sort_string;  // attribute

    private java.util.Date issue_date;  // attribute

    private java.lang.String enumeration;  // attribute

    private int new_n_deferred_issues_left;  // attribute

    private int product_id;  // attribute

    private java.lang.String product_size;  // attribute

    private java.lang.String product_style;  // attribute

    private java.lang.String product_color;  // attribute

    private int quantity;  // attribute

    private int quantity_backordered;  // attribute

    private java.lang.String renewal_def;  // attribute

    private int renewal_def_test_seq;  // attribute

    private int renewal_effort_number;  // attribute

    private int renewal_card_id;  // attribute

    private int rate_class_id;  // attribute

    private int added;  // attribute

    private int was_name;  // attribute

    private int was_title;  // attribute

    private int was_company;  // attribute

    private int suppress_renewal_output;  // attribute

    private java.lang.String billing_def;  // attribute

    private int billing_def_test_seq;  // attribute

    private int billing_effort_number;  // attribute

    private java.lang.String billing_code;  // attribute

    private int billing_installment_number;  // attribute

    private int suppress_billing_output;  // attribute

    private int job_ren_offer_id;  // attribute

    private int invoice_number;  // attribute

    private int undeliverable;  // attribute

    private int source_code_id;  // attribute

    private java.lang.String source_code;  // attribute

    private java.lang.String source_format;  // attribute

    private int package_id;  // attribute

    private int issue_id;  // attribute

    private int inventory_id;  // attribute

    private java.lang.String pay_id_nbr;  // attribute

    private int payment_seq;  // attribute

    private java.util.Date pay_exp_date;  // attribute

    private java.lang.String pay_ref_nbr;  // attribute

    private java.lang.String pay_auth_code;  // attribute

    private java.util.Date pay_auth_date;  // attribute

    private java.util.Date pay_clear_date;  // attribute

    private java.lang.String pay_credit_card_info;  // attribute

    private java.math.BigDecimal pay_amount;  // attribute

    private int pay_clear_status;  // attribute

    private int audit_subscription_type_id;  // attribute

    private int audit_qual_source_id;  // attribute

    private int audit_sales_channel_id;  // attribute

    private int duration;  // attribute

    private java.util.Date qual_date;  // attribute

    private java.util.Date squal_date;  // attribute

    private java.util.Date order_date;  // attribute

    private int selected;  // attribute

    private java.lang.String zip;  // attribute

    private java.lang.String state;  // attribute

    private int audit_name_title_id;  // attribute

    private java.lang.String pay_status_reason;  // attribute

    private java.lang.String currency;  // attribute

    private int oc_id;  // attribute

    private int old_audit_qual_category;  // attribute

    private int new_audit_qual_category;  // attribute

    private int percent_of_basic_price;  // attribute

    private int refund_via_process;  // attribute

    private int discount_class_id;  // attribute

    private java.lang.String billing_item_barcode;  // attribute

    private java.lang.String billing_group_barcode;  // attribute

    private java.lang.String email;  // attribute

    private int event_queue_id;  // attribute

    private int revenue_method;  // attribute

    private java.lang.String pay_check_number;  // attribute

    private java.lang.String other_label1;  // attribute

    private java.lang.String other_label2;  // attribute

    private java.lang.String other_label3;  // attribute

    private java.lang.String other_label4;  // attribute

    private java.lang.String other_label5;  // attribute

    private java.lang.String other_label6;  // attribute

    private java.lang.String other_label7;  // attribute

    private java.lang.String other_label8;  // attribute

    private java.lang.String other_label9;  // attribute

    private java.lang.String other_label10;  // attribute

    private int invoice_id;  // attribute

    private int service_seq;  // attribute

    private java.lang.String taxonomy;  // attribute

    private int has_tax;  // attribute

    private int payment_account_seq;  // attribute

    private int customer_login_id;  // attribute

    private int source_job_id;  // attribute

    private int transaction_event;  // attribute

    private int suspension_seq;  // attribute

    private int source_work_table_seq;  // attribute

    private int suppress_email;  // attribute

    private int customer_group_customer_id;  // attribute

    public Work_table_select_responseWork_table() {
    }

    public Work_table_select_responseWork_table(
           int job_id,
           int work_table_seq,
           int work_record_status,
           byte[] update_mask,
           byte[] insert_bits,
           byte[] promotion_bits,
           java.lang.String split_value,
           int customer_id,
           int send_to_customer_id,
           int send_to_customer_address_seq,
           int orderhdr_id,
           int order_item_seq,
           int subscrip_id,
           java.lang.String label1,
           java.lang.String label2,
           java.lang.String label3,
           java.lang.String label4,
           java.lang.String label5,
           java.lang.String label6,
           java.lang.String label7,
           java.lang.String label8,
           java.lang.String label9,
           java.lang.String label10,
           java.lang.String sort_string,
           java.lang.String priority_sort_string,
           java.util.Date issue_date,
           java.lang.String enumeration,
           int new_n_deferred_issues_left,
           int product_id,
           java.lang.String product_size,
           java.lang.String product_style,
           java.lang.String product_color,
           int quantity,
           int quantity_backordered,
           java.lang.String renewal_def,
           int renewal_def_test_seq,
           int renewal_effort_number,
           int renewal_card_id,
           int rate_class_id,
           int added,
           int was_name,
           int was_title,
           int was_company,
           int suppress_renewal_output,
           java.lang.String billing_def,
           int billing_def_test_seq,
           int billing_effort_number,
           java.lang.String billing_code,
           int billing_installment_number,
           int suppress_billing_output,
           int job_ren_offer_id,
           int invoice_number,
           int undeliverable,
           int source_code_id,
           java.lang.String source_code,
           java.lang.String source_format,
           int package_id,
           int issue_id,
           int inventory_id,
           java.lang.String pay_id_nbr,
           int payment_seq,
           java.util.Date pay_exp_date,
           java.lang.String pay_ref_nbr,
           java.lang.String pay_auth_code,
           java.util.Date pay_auth_date,
           java.util.Date pay_clear_date,
           java.lang.String pay_credit_card_info,
           java.math.BigDecimal pay_amount,
           int pay_clear_status,
           int audit_subscription_type_id,
           int audit_qual_source_id,
           int audit_sales_channel_id,
           int duration,
           java.util.Date qual_date,
           java.util.Date squal_date,
           java.util.Date order_date,
           int selected,
           java.lang.String zip,
           java.lang.String state,
           int audit_name_title_id,
           java.lang.String pay_status_reason,
           java.lang.String currency,
           int oc_id,
           int old_audit_qual_category,
           int new_audit_qual_category,
           int percent_of_basic_price,
           int refund_via_process,
           int discount_class_id,
           java.lang.String billing_item_barcode,
           java.lang.String billing_group_barcode,
           java.lang.String email,
           int event_queue_id,
           int revenue_method,
           java.lang.String pay_check_number,
           java.lang.String other_label1,
           java.lang.String other_label2,
           java.lang.String other_label3,
           java.lang.String other_label4,
           java.lang.String other_label5,
           java.lang.String other_label6,
           java.lang.String other_label7,
           java.lang.String other_label8,
           java.lang.String other_label9,
           java.lang.String other_label10,
           int invoice_id,
           int service_seq,
           java.lang.String taxonomy,
           int has_tax,
           int payment_account_seq,
           int customer_login_id,
           int source_job_id,
           int transaction_event,
           int suspension_seq,
           int source_work_table_seq,
           int suppress_email,
           int customer_group_customer_id) {
           this.job_id = job_id;
           this.work_table_seq = work_table_seq;
           this.work_record_status = work_record_status;
           this.update_mask = update_mask;
           this.insert_bits = insert_bits;
           this.promotion_bits = promotion_bits;
           this.split_value = split_value;
           this.customer_id = customer_id;
           this.send_to_customer_id = send_to_customer_id;
           this.send_to_customer_address_seq = send_to_customer_address_seq;
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.subscrip_id = subscrip_id;
           this.label1 = label1;
           this.label2 = label2;
           this.label3 = label3;
           this.label4 = label4;
           this.label5 = label5;
           this.label6 = label6;
           this.label7 = label7;
           this.label8 = label8;
           this.label9 = label9;
           this.label10 = label10;
           this.sort_string = sort_string;
           this.priority_sort_string = priority_sort_string;
           this.issue_date = issue_date;
           this.enumeration = enumeration;
           this.new_n_deferred_issues_left = new_n_deferred_issues_left;
           this.product_id = product_id;
           this.product_size = product_size;
           this.product_style = product_style;
           this.product_color = product_color;
           this.quantity = quantity;
           this.quantity_backordered = quantity_backordered;
           this.renewal_def = renewal_def;
           this.renewal_def_test_seq = renewal_def_test_seq;
           this.renewal_effort_number = renewal_effort_number;
           this.renewal_card_id = renewal_card_id;
           this.rate_class_id = rate_class_id;
           this.added = added;
           this.was_name = was_name;
           this.was_title = was_title;
           this.was_company = was_company;
           this.suppress_renewal_output = suppress_renewal_output;
           this.billing_def = billing_def;
           this.billing_def_test_seq = billing_def_test_seq;
           this.billing_effort_number = billing_effort_number;
           this.billing_code = billing_code;
           this.billing_installment_number = billing_installment_number;
           this.suppress_billing_output = suppress_billing_output;
           this.job_ren_offer_id = job_ren_offer_id;
           this.invoice_number = invoice_number;
           this.undeliverable = undeliverable;
           this.source_code_id = source_code_id;
           this.source_code = source_code;
           this.source_format = source_format;
           this.package_id = package_id;
           this.issue_id = issue_id;
           this.inventory_id = inventory_id;
           this.pay_id_nbr = pay_id_nbr;
           this.payment_seq = payment_seq;
           this.pay_exp_date = pay_exp_date;
           this.pay_ref_nbr = pay_ref_nbr;
           this.pay_auth_code = pay_auth_code;
           this.pay_auth_date = pay_auth_date;
           this.pay_clear_date = pay_clear_date;
           this.pay_credit_card_info = pay_credit_card_info;
           this.pay_amount = pay_amount;
           this.pay_clear_status = pay_clear_status;
           this.audit_subscription_type_id = audit_subscription_type_id;
           this.audit_qual_source_id = audit_qual_source_id;
           this.audit_sales_channel_id = audit_sales_channel_id;
           this.duration = duration;
           this.qual_date = qual_date;
           this.squal_date = squal_date;
           this.order_date = order_date;
           this.selected = selected;
           this.zip = zip;
           this.state = state;
           this.audit_name_title_id = audit_name_title_id;
           this.pay_status_reason = pay_status_reason;
           this.currency = currency;
           this.oc_id = oc_id;
           this.old_audit_qual_category = old_audit_qual_category;
           this.new_audit_qual_category = new_audit_qual_category;
           this.percent_of_basic_price = percent_of_basic_price;
           this.refund_via_process = refund_via_process;
           this.discount_class_id = discount_class_id;
           this.billing_item_barcode = billing_item_barcode;
           this.billing_group_barcode = billing_group_barcode;
           this.email = email;
           this.event_queue_id = event_queue_id;
           this.revenue_method = revenue_method;
           this.pay_check_number = pay_check_number;
           this.other_label1 = other_label1;
           this.other_label2 = other_label2;
           this.other_label3 = other_label3;
           this.other_label4 = other_label4;
           this.other_label5 = other_label5;
           this.other_label6 = other_label6;
           this.other_label7 = other_label7;
           this.other_label8 = other_label8;
           this.other_label9 = other_label9;
           this.other_label10 = other_label10;
           this.invoice_id = invoice_id;
           this.service_seq = service_seq;
           this.taxonomy = taxonomy;
           this.has_tax = has_tax;
           this.payment_account_seq = payment_account_seq;
           this.customer_login_id = customer_login_id;
           this.source_job_id = source_job_id;
           this.transaction_event = transaction_event;
           this.suspension_seq = suspension_seq;
           this.source_work_table_seq = source_work_table_seq;
           this.suppress_email = suppress_email;
           this.customer_group_customer_id = customer_group_customer_id;
    }


    /**
     * Gets the job_id value for this Work_table_select_responseWork_table.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Work_table_select_responseWork_table.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the work_table_seq value for this Work_table_select_responseWork_table.
     * 
     * @return work_table_seq
     */
    public int getWork_table_seq() {
        return work_table_seq;
    }


    /**
     * Sets the work_table_seq value for this Work_table_select_responseWork_table.
     * 
     * @param work_table_seq
     */
    public void setWork_table_seq(int work_table_seq) {
        this.work_table_seq = work_table_seq;
    }


    /**
     * Gets the work_record_status value for this Work_table_select_responseWork_table.
     * 
     * @return work_record_status
     */
    public int getWork_record_status() {
        return work_record_status;
    }


    /**
     * Sets the work_record_status value for this Work_table_select_responseWork_table.
     * 
     * @param work_record_status
     */
    public void setWork_record_status(int work_record_status) {
        this.work_record_status = work_record_status;
    }


    /**
     * Gets the update_mask value for this Work_table_select_responseWork_table.
     * 
     * @return update_mask
     */
    public byte[] getUpdate_mask() {
        return update_mask;
    }


    /**
     * Sets the update_mask value for this Work_table_select_responseWork_table.
     * 
     * @param update_mask
     */
    public void setUpdate_mask(byte[] update_mask) {
        this.update_mask = update_mask;
    }


    /**
     * Gets the insert_bits value for this Work_table_select_responseWork_table.
     * 
     * @return insert_bits
     */
    public byte[] getInsert_bits() {
        return insert_bits;
    }


    /**
     * Sets the insert_bits value for this Work_table_select_responseWork_table.
     * 
     * @param insert_bits
     */
    public void setInsert_bits(byte[] insert_bits) {
        this.insert_bits = insert_bits;
    }


    /**
     * Gets the promotion_bits value for this Work_table_select_responseWork_table.
     * 
     * @return promotion_bits
     */
    public byte[] getPromotion_bits() {
        return promotion_bits;
    }


    /**
     * Sets the promotion_bits value for this Work_table_select_responseWork_table.
     * 
     * @param promotion_bits
     */
    public void setPromotion_bits(byte[] promotion_bits) {
        this.promotion_bits = promotion_bits;
    }


    /**
     * Gets the split_value value for this Work_table_select_responseWork_table.
     * 
     * @return split_value
     */
    public java.lang.String getSplit_value() {
        return split_value;
    }


    /**
     * Sets the split_value value for this Work_table_select_responseWork_table.
     * 
     * @param split_value
     */
    public void setSplit_value(java.lang.String split_value) {
        this.split_value = split_value;
    }


    /**
     * Gets the customer_id value for this Work_table_select_responseWork_table.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Work_table_select_responseWork_table.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the send_to_customer_id value for this Work_table_select_responseWork_table.
     * 
     * @return send_to_customer_id
     */
    public int getSend_to_customer_id() {
        return send_to_customer_id;
    }


    /**
     * Sets the send_to_customer_id value for this Work_table_select_responseWork_table.
     * 
     * @param send_to_customer_id
     */
    public void setSend_to_customer_id(int send_to_customer_id) {
        this.send_to_customer_id = send_to_customer_id;
    }


    /**
     * Gets the send_to_customer_address_seq value for this Work_table_select_responseWork_table.
     * 
     * @return send_to_customer_address_seq
     */
    public int getSend_to_customer_address_seq() {
        return send_to_customer_address_seq;
    }


    /**
     * Sets the send_to_customer_address_seq value for this Work_table_select_responseWork_table.
     * 
     * @param send_to_customer_address_seq
     */
    public void setSend_to_customer_address_seq(int send_to_customer_address_seq) {
        this.send_to_customer_address_seq = send_to_customer_address_seq;
    }


    /**
     * Gets the orderhdr_id value for this Work_table_select_responseWork_table.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Work_table_select_responseWork_table.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Work_table_select_responseWork_table.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Work_table_select_responseWork_table.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the subscrip_id value for this Work_table_select_responseWork_table.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Work_table_select_responseWork_table.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the label1 value for this Work_table_select_responseWork_table.
     * 
     * @return label1
     */
    public java.lang.String getLabel1() {
        return label1;
    }


    /**
     * Sets the label1 value for this Work_table_select_responseWork_table.
     * 
     * @param label1
     */
    public void setLabel1(java.lang.String label1) {
        this.label1 = label1;
    }


    /**
     * Gets the label2 value for this Work_table_select_responseWork_table.
     * 
     * @return label2
     */
    public java.lang.String getLabel2() {
        return label2;
    }


    /**
     * Sets the label2 value for this Work_table_select_responseWork_table.
     * 
     * @param label2
     */
    public void setLabel2(java.lang.String label2) {
        this.label2 = label2;
    }


    /**
     * Gets the label3 value for this Work_table_select_responseWork_table.
     * 
     * @return label3
     */
    public java.lang.String getLabel3() {
        return label3;
    }


    /**
     * Sets the label3 value for this Work_table_select_responseWork_table.
     * 
     * @param label3
     */
    public void setLabel3(java.lang.String label3) {
        this.label3 = label3;
    }


    /**
     * Gets the label4 value for this Work_table_select_responseWork_table.
     * 
     * @return label4
     */
    public java.lang.String getLabel4() {
        return label4;
    }


    /**
     * Sets the label4 value for this Work_table_select_responseWork_table.
     * 
     * @param label4
     */
    public void setLabel4(java.lang.String label4) {
        this.label4 = label4;
    }


    /**
     * Gets the label5 value for this Work_table_select_responseWork_table.
     * 
     * @return label5
     */
    public java.lang.String getLabel5() {
        return label5;
    }


    /**
     * Sets the label5 value for this Work_table_select_responseWork_table.
     * 
     * @param label5
     */
    public void setLabel5(java.lang.String label5) {
        this.label5 = label5;
    }


    /**
     * Gets the label6 value for this Work_table_select_responseWork_table.
     * 
     * @return label6
     */
    public java.lang.String getLabel6() {
        return label6;
    }


    /**
     * Sets the label6 value for this Work_table_select_responseWork_table.
     * 
     * @param label6
     */
    public void setLabel6(java.lang.String label6) {
        this.label6 = label6;
    }


    /**
     * Gets the label7 value for this Work_table_select_responseWork_table.
     * 
     * @return label7
     */
    public java.lang.String getLabel7() {
        return label7;
    }


    /**
     * Sets the label7 value for this Work_table_select_responseWork_table.
     * 
     * @param label7
     */
    public void setLabel7(java.lang.String label7) {
        this.label7 = label7;
    }


    /**
     * Gets the label8 value for this Work_table_select_responseWork_table.
     * 
     * @return label8
     */
    public java.lang.String getLabel8() {
        return label8;
    }


    /**
     * Sets the label8 value for this Work_table_select_responseWork_table.
     * 
     * @param label8
     */
    public void setLabel8(java.lang.String label8) {
        this.label8 = label8;
    }


    /**
     * Gets the label9 value for this Work_table_select_responseWork_table.
     * 
     * @return label9
     */
    public java.lang.String getLabel9() {
        return label9;
    }


    /**
     * Sets the label9 value for this Work_table_select_responseWork_table.
     * 
     * @param label9
     */
    public void setLabel9(java.lang.String label9) {
        this.label9 = label9;
    }


    /**
     * Gets the label10 value for this Work_table_select_responseWork_table.
     * 
     * @return label10
     */
    public java.lang.String getLabel10() {
        return label10;
    }


    /**
     * Sets the label10 value for this Work_table_select_responseWork_table.
     * 
     * @param label10
     */
    public void setLabel10(java.lang.String label10) {
        this.label10 = label10;
    }


    /**
     * Gets the sort_string value for this Work_table_select_responseWork_table.
     * 
     * @return sort_string
     */
    public java.lang.String getSort_string() {
        return sort_string;
    }


    /**
     * Sets the sort_string value for this Work_table_select_responseWork_table.
     * 
     * @param sort_string
     */
    public void setSort_string(java.lang.String sort_string) {
        this.sort_string = sort_string;
    }


    /**
     * Gets the priority_sort_string value for this Work_table_select_responseWork_table.
     * 
     * @return priority_sort_string
     */
    public java.lang.String getPriority_sort_string() {
        return priority_sort_string;
    }


    /**
     * Sets the priority_sort_string value for this Work_table_select_responseWork_table.
     * 
     * @param priority_sort_string
     */
    public void setPriority_sort_string(java.lang.String priority_sort_string) {
        this.priority_sort_string = priority_sort_string;
    }


    /**
     * Gets the issue_date value for this Work_table_select_responseWork_table.
     * 
     * @return issue_date
     */
    public java.util.Date getIssue_date() {
        return issue_date;
    }


    /**
     * Sets the issue_date value for this Work_table_select_responseWork_table.
     * 
     * @param issue_date
     */
    public void setIssue_date(java.util.Date issue_date) {
        this.issue_date = issue_date;
    }


    /**
     * Gets the enumeration value for this Work_table_select_responseWork_table.
     * 
     * @return enumeration
     */
    public java.lang.String getEnumeration() {
        return enumeration;
    }


    /**
     * Sets the enumeration value for this Work_table_select_responseWork_table.
     * 
     * @param enumeration
     */
    public void setEnumeration(java.lang.String enumeration) {
        this.enumeration = enumeration;
    }


    /**
     * Gets the new_n_deferred_issues_left value for this Work_table_select_responseWork_table.
     * 
     * @return new_n_deferred_issues_left
     */
    public int getNew_n_deferred_issues_left() {
        return new_n_deferred_issues_left;
    }


    /**
     * Sets the new_n_deferred_issues_left value for this Work_table_select_responseWork_table.
     * 
     * @param new_n_deferred_issues_left
     */
    public void setNew_n_deferred_issues_left(int new_n_deferred_issues_left) {
        this.new_n_deferred_issues_left = new_n_deferred_issues_left;
    }


    /**
     * Gets the product_id value for this Work_table_select_responseWork_table.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Work_table_select_responseWork_table.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the product_size value for this Work_table_select_responseWork_table.
     * 
     * @return product_size
     */
    public java.lang.String getProduct_size() {
        return product_size;
    }


    /**
     * Sets the product_size value for this Work_table_select_responseWork_table.
     * 
     * @param product_size
     */
    public void setProduct_size(java.lang.String product_size) {
        this.product_size = product_size;
    }


    /**
     * Gets the product_style value for this Work_table_select_responseWork_table.
     * 
     * @return product_style
     */
    public java.lang.String getProduct_style() {
        return product_style;
    }


    /**
     * Sets the product_style value for this Work_table_select_responseWork_table.
     * 
     * @param product_style
     */
    public void setProduct_style(java.lang.String product_style) {
        this.product_style = product_style;
    }


    /**
     * Gets the product_color value for this Work_table_select_responseWork_table.
     * 
     * @return product_color
     */
    public java.lang.String getProduct_color() {
        return product_color;
    }


    /**
     * Sets the product_color value for this Work_table_select_responseWork_table.
     * 
     * @param product_color
     */
    public void setProduct_color(java.lang.String product_color) {
        this.product_color = product_color;
    }


    /**
     * Gets the quantity value for this Work_table_select_responseWork_table.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this Work_table_select_responseWork_table.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the quantity_backordered value for this Work_table_select_responseWork_table.
     * 
     * @return quantity_backordered
     */
    public int getQuantity_backordered() {
        return quantity_backordered;
    }


    /**
     * Sets the quantity_backordered value for this Work_table_select_responseWork_table.
     * 
     * @param quantity_backordered
     */
    public void setQuantity_backordered(int quantity_backordered) {
        this.quantity_backordered = quantity_backordered;
    }


    /**
     * Gets the renewal_def value for this Work_table_select_responseWork_table.
     * 
     * @return renewal_def
     */
    public java.lang.String getRenewal_def() {
        return renewal_def;
    }


    /**
     * Sets the renewal_def value for this Work_table_select_responseWork_table.
     * 
     * @param renewal_def
     */
    public void setRenewal_def(java.lang.String renewal_def) {
        this.renewal_def = renewal_def;
    }


    /**
     * Gets the renewal_def_test_seq value for this Work_table_select_responseWork_table.
     * 
     * @return renewal_def_test_seq
     */
    public int getRenewal_def_test_seq() {
        return renewal_def_test_seq;
    }


    /**
     * Sets the renewal_def_test_seq value for this Work_table_select_responseWork_table.
     * 
     * @param renewal_def_test_seq
     */
    public void setRenewal_def_test_seq(int renewal_def_test_seq) {
        this.renewal_def_test_seq = renewal_def_test_seq;
    }


    /**
     * Gets the renewal_effort_number value for this Work_table_select_responseWork_table.
     * 
     * @return renewal_effort_number
     */
    public int getRenewal_effort_number() {
        return renewal_effort_number;
    }


    /**
     * Sets the renewal_effort_number value for this Work_table_select_responseWork_table.
     * 
     * @param renewal_effort_number
     */
    public void setRenewal_effort_number(int renewal_effort_number) {
        this.renewal_effort_number = renewal_effort_number;
    }


    /**
     * Gets the renewal_card_id value for this Work_table_select_responseWork_table.
     * 
     * @return renewal_card_id
     */
    public int getRenewal_card_id() {
        return renewal_card_id;
    }


    /**
     * Sets the renewal_card_id value for this Work_table_select_responseWork_table.
     * 
     * @param renewal_card_id
     */
    public void setRenewal_card_id(int renewal_card_id) {
        this.renewal_card_id = renewal_card_id;
    }


    /**
     * Gets the rate_class_id value for this Work_table_select_responseWork_table.
     * 
     * @return rate_class_id
     */
    public int getRate_class_id() {
        return rate_class_id;
    }


    /**
     * Sets the rate_class_id value for this Work_table_select_responseWork_table.
     * 
     * @param rate_class_id
     */
    public void setRate_class_id(int rate_class_id) {
        this.rate_class_id = rate_class_id;
    }


    /**
     * Gets the added value for this Work_table_select_responseWork_table.
     * 
     * @return added
     */
    public int getAdded() {
        return added;
    }


    /**
     * Sets the added value for this Work_table_select_responseWork_table.
     * 
     * @param added
     */
    public void setAdded(int added) {
        this.added = added;
    }


    /**
     * Gets the was_name value for this Work_table_select_responseWork_table.
     * 
     * @return was_name
     */
    public int getWas_name() {
        return was_name;
    }


    /**
     * Sets the was_name value for this Work_table_select_responseWork_table.
     * 
     * @param was_name
     */
    public void setWas_name(int was_name) {
        this.was_name = was_name;
    }


    /**
     * Gets the was_title value for this Work_table_select_responseWork_table.
     * 
     * @return was_title
     */
    public int getWas_title() {
        return was_title;
    }


    /**
     * Sets the was_title value for this Work_table_select_responseWork_table.
     * 
     * @param was_title
     */
    public void setWas_title(int was_title) {
        this.was_title = was_title;
    }


    /**
     * Gets the was_company value for this Work_table_select_responseWork_table.
     * 
     * @return was_company
     */
    public int getWas_company() {
        return was_company;
    }


    /**
     * Sets the was_company value for this Work_table_select_responseWork_table.
     * 
     * @param was_company
     */
    public void setWas_company(int was_company) {
        this.was_company = was_company;
    }


    /**
     * Gets the suppress_renewal_output value for this Work_table_select_responseWork_table.
     * 
     * @return suppress_renewal_output
     */
    public int getSuppress_renewal_output() {
        return suppress_renewal_output;
    }


    /**
     * Sets the suppress_renewal_output value for this Work_table_select_responseWork_table.
     * 
     * @param suppress_renewal_output
     */
    public void setSuppress_renewal_output(int suppress_renewal_output) {
        this.suppress_renewal_output = suppress_renewal_output;
    }


    /**
     * Gets the billing_def value for this Work_table_select_responseWork_table.
     * 
     * @return billing_def
     */
    public java.lang.String getBilling_def() {
        return billing_def;
    }


    /**
     * Sets the billing_def value for this Work_table_select_responseWork_table.
     * 
     * @param billing_def
     */
    public void setBilling_def(java.lang.String billing_def) {
        this.billing_def = billing_def;
    }


    /**
     * Gets the billing_def_test_seq value for this Work_table_select_responseWork_table.
     * 
     * @return billing_def_test_seq
     */
    public int getBilling_def_test_seq() {
        return billing_def_test_seq;
    }


    /**
     * Sets the billing_def_test_seq value for this Work_table_select_responseWork_table.
     * 
     * @param billing_def_test_seq
     */
    public void setBilling_def_test_seq(int billing_def_test_seq) {
        this.billing_def_test_seq = billing_def_test_seq;
    }


    /**
     * Gets the billing_effort_number value for this Work_table_select_responseWork_table.
     * 
     * @return billing_effort_number
     */
    public int getBilling_effort_number() {
        return billing_effort_number;
    }


    /**
     * Sets the billing_effort_number value for this Work_table_select_responseWork_table.
     * 
     * @param billing_effort_number
     */
    public void setBilling_effort_number(int billing_effort_number) {
        this.billing_effort_number = billing_effort_number;
    }


    /**
     * Gets the billing_code value for this Work_table_select_responseWork_table.
     * 
     * @return billing_code
     */
    public java.lang.String getBilling_code() {
        return billing_code;
    }


    /**
     * Sets the billing_code value for this Work_table_select_responseWork_table.
     * 
     * @param billing_code
     */
    public void setBilling_code(java.lang.String billing_code) {
        this.billing_code = billing_code;
    }


    /**
     * Gets the billing_installment_number value for this Work_table_select_responseWork_table.
     * 
     * @return billing_installment_number
     */
    public int getBilling_installment_number() {
        return billing_installment_number;
    }


    /**
     * Sets the billing_installment_number value for this Work_table_select_responseWork_table.
     * 
     * @param billing_installment_number
     */
    public void setBilling_installment_number(int billing_installment_number) {
        this.billing_installment_number = billing_installment_number;
    }


    /**
     * Gets the suppress_billing_output value for this Work_table_select_responseWork_table.
     * 
     * @return suppress_billing_output
     */
    public int getSuppress_billing_output() {
        return suppress_billing_output;
    }


    /**
     * Sets the suppress_billing_output value for this Work_table_select_responseWork_table.
     * 
     * @param suppress_billing_output
     */
    public void setSuppress_billing_output(int suppress_billing_output) {
        this.suppress_billing_output = suppress_billing_output;
    }


    /**
     * Gets the job_ren_offer_id value for this Work_table_select_responseWork_table.
     * 
     * @return job_ren_offer_id
     */
    public int getJob_ren_offer_id() {
        return job_ren_offer_id;
    }


    /**
     * Sets the job_ren_offer_id value for this Work_table_select_responseWork_table.
     * 
     * @param job_ren_offer_id
     */
    public void setJob_ren_offer_id(int job_ren_offer_id) {
        this.job_ren_offer_id = job_ren_offer_id;
    }


    /**
     * Gets the invoice_number value for this Work_table_select_responseWork_table.
     * 
     * @return invoice_number
     */
    public int getInvoice_number() {
        return invoice_number;
    }


    /**
     * Sets the invoice_number value for this Work_table_select_responseWork_table.
     * 
     * @param invoice_number
     */
    public void setInvoice_number(int invoice_number) {
        this.invoice_number = invoice_number;
    }


    /**
     * Gets the undeliverable value for this Work_table_select_responseWork_table.
     * 
     * @return undeliverable
     */
    public int getUndeliverable() {
        return undeliverable;
    }


    /**
     * Sets the undeliverable value for this Work_table_select_responseWork_table.
     * 
     * @param undeliverable
     */
    public void setUndeliverable(int undeliverable) {
        this.undeliverable = undeliverable;
    }


    /**
     * Gets the source_code_id value for this Work_table_select_responseWork_table.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Work_table_select_responseWork_table.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the source_code value for this Work_table_select_responseWork_table.
     * 
     * @return source_code
     */
    public java.lang.String getSource_code() {
        return source_code;
    }


    /**
     * Sets the source_code value for this Work_table_select_responseWork_table.
     * 
     * @param source_code
     */
    public void setSource_code(java.lang.String source_code) {
        this.source_code = source_code;
    }


    /**
     * Gets the source_format value for this Work_table_select_responseWork_table.
     * 
     * @return source_format
     */
    public java.lang.String getSource_format() {
        return source_format;
    }


    /**
     * Sets the source_format value for this Work_table_select_responseWork_table.
     * 
     * @param source_format
     */
    public void setSource_format(java.lang.String source_format) {
        this.source_format = source_format;
    }


    /**
     * Gets the package_id value for this Work_table_select_responseWork_table.
     * 
     * @return package_id
     */
    public int getPackage_id() {
        return package_id;
    }


    /**
     * Sets the package_id value for this Work_table_select_responseWork_table.
     * 
     * @param package_id
     */
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }


    /**
     * Gets the issue_id value for this Work_table_select_responseWork_table.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Work_table_select_responseWork_table.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the inventory_id value for this Work_table_select_responseWork_table.
     * 
     * @return inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }


    /**
     * Sets the inventory_id value for this Work_table_select_responseWork_table.
     * 
     * @param inventory_id
     */
    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }


    /**
     * Gets the pay_id_nbr value for this Work_table_select_responseWork_table.
     * 
     * @return pay_id_nbr
     */
    public java.lang.String getPay_id_nbr() {
        return pay_id_nbr;
    }


    /**
     * Sets the pay_id_nbr value for this Work_table_select_responseWork_table.
     * 
     * @param pay_id_nbr
     */
    public void setPay_id_nbr(java.lang.String pay_id_nbr) {
        this.pay_id_nbr = pay_id_nbr;
    }


    /**
     * Gets the payment_seq value for this Work_table_select_responseWork_table.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Work_table_select_responseWork_table.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the pay_exp_date value for this Work_table_select_responseWork_table.
     * 
     * @return pay_exp_date
     */
    public java.util.Date getPay_exp_date() {
        return pay_exp_date;
    }


    /**
     * Sets the pay_exp_date value for this Work_table_select_responseWork_table.
     * 
     * @param pay_exp_date
     */
    public void setPay_exp_date(java.util.Date pay_exp_date) {
        this.pay_exp_date = pay_exp_date;
    }


    /**
     * Gets the pay_ref_nbr value for this Work_table_select_responseWork_table.
     * 
     * @return pay_ref_nbr
     */
    public java.lang.String getPay_ref_nbr() {
        return pay_ref_nbr;
    }


    /**
     * Sets the pay_ref_nbr value for this Work_table_select_responseWork_table.
     * 
     * @param pay_ref_nbr
     */
    public void setPay_ref_nbr(java.lang.String pay_ref_nbr) {
        this.pay_ref_nbr = pay_ref_nbr;
    }


    /**
     * Gets the pay_auth_code value for this Work_table_select_responseWork_table.
     * 
     * @return pay_auth_code
     */
    public java.lang.String getPay_auth_code() {
        return pay_auth_code;
    }


    /**
     * Sets the pay_auth_code value for this Work_table_select_responseWork_table.
     * 
     * @param pay_auth_code
     */
    public void setPay_auth_code(java.lang.String pay_auth_code) {
        this.pay_auth_code = pay_auth_code;
    }


    /**
     * Gets the pay_auth_date value for this Work_table_select_responseWork_table.
     * 
     * @return pay_auth_date
     */
    public java.util.Date getPay_auth_date() {
        return pay_auth_date;
    }


    /**
     * Sets the pay_auth_date value for this Work_table_select_responseWork_table.
     * 
     * @param pay_auth_date
     */
    public void setPay_auth_date(java.util.Date pay_auth_date) {
        this.pay_auth_date = pay_auth_date;
    }


    /**
     * Gets the pay_clear_date value for this Work_table_select_responseWork_table.
     * 
     * @return pay_clear_date
     */
    public java.util.Date getPay_clear_date() {
        return pay_clear_date;
    }


    /**
     * Sets the pay_clear_date value for this Work_table_select_responseWork_table.
     * 
     * @param pay_clear_date
     */
    public void setPay_clear_date(java.util.Date pay_clear_date) {
        this.pay_clear_date = pay_clear_date;
    }


    /**
     * Gets the pay_credit_card_info value for this Work_table_select_responseWork_table.
     * 
     * @return pay_credit_card_info
     */
    public java.lang.String getPay_credit_card_info() {
        return pay_credit_card_info;
    }


    /**
     * Sets the pay_credit_card_info value for this Work_table_select_responseWork_table.
     * 
     * @param pay_credit_card_info
     */
    public void setPay_credit_card_info(java.lang.String pay_credit_card_info) {
        this.pay_credit_card_info = pay_credit_card_info;
    }


    /**
     * Gets the pay_amount value for this Work_table_select_responseWork_table.
     * 
     * @return pay_amount
     */
    public java.math.BigDecimal getPay_amount() {
        return pay_amount;
    }


    /**
     * Sets the pay_amount value for this Work_table_select_responseWork_table.
     * 
     * @param pay_amount
     */
    public void setPay_amount(java.math.BigDecimal pay_amount) {
        this.pay_amount = pay_amount;
    }


    /**
     * Gets the pay_clear_status value for this Work_table_select_responseWork_table.
     * 
     * @return pay_clear_status
     */
    public int getPay_clear_status() {
        return pay_clear_status;
    }


    /**
     * Sets the pay_clear_status value for this Work_table_select_responseWork_table.
     * 
     * @param pay_clear_status
     */
    public void setPay_clear_status(int pay_clear_status) {
        this.pay_clear_status = pay_clear_status;
    }


    /**
     * Gets the audit_subscription_type_id value for this Work_table_select_responseWork_table.
     * 
     * @return audit_subscription_type_id
     */
    public int getAudit_subscription_type_id() {
        return audit_subscription_type_id;
    }


    /**
     * Sets the audit_subscription_type_id value for this Work_table_select_responseWork_table.
     * 
     * @param audit_subscription_type_id
     */
    public void setAudit_subscription_type_id(int audit_subscription_type_id) {
        this.audit_subscription_type_id = audit_subscription_type_id;
    }


    /**
     * Gets the audit_qual_source_id value for this Work_table_select_responseWork_table.
     * 
     * @return audit_qual_source_id
     */
    public int getAudit_qual_source_id() {
        return audit_qual_source_id;
    }


    /**
     * Sets the audit_qual_source_id value for this Work_table_select_responseWork_table.
     * 
     * @param audit_qual_source_id
     */
    public void setAudit_qual_source_id(int audit_qual_source_id) {
        this.audit_qual_source_id = audit_qual_source_id;
    }


    /**
     * Gets the audit_sales_channel_id value for this Work_table_select_responseWork_table.
     * 
     * @return audit_sales_channel_id
     */
    public int getAudit_sales_channel_id() {
        return audit_sales_channel_id;
    }


    /**
     * Sets the audit_sales_channel_id value for this Work_table_select_responseWork_table.
     * 
     * @param audit_sales_channel_id
     */
    public void setAudit_sales_channel_id(int audit_sales_channel_id) {
        this.audit_sales_channel_id = audit_sales_channel_id;
    }


    /**
     * Gets the duration value for this Work_table_select_responseWork_table.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this Work_table_select_responseWork_table.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the qual_date value for this Work_table_select_responseWork_table.
     * 
     * @return qual_date
     */
    public java.util.Date getQual_date() {
        return qual_date;
    }


    /**
     * Sets the qual_date value for this Work_table_select_responseWork_table.
     * 
     * @param qual_date
     */
    public void setQual_date(java.util.Date qual_date) {
        this.qual_date = qual_date;
    }


    /**
     * Gets the squal_date value for this Work_table_select_responseWork_table.
     * 
     * @return squal_date
     */
    public java.util.Date getSqual_date() {
        return squal_date;
    }


    /**
     * Sets the squal_date value for this Work_table_select_responseWork_table.
     * 
     * @param squal_date
     */
    public void setSqual_date(java.util.Date squal_date) {
        this.squal_date = squal_date;
    }


    /**
     * Gets the order_date value for this Work_table_select_responseWork_table.
     * 
     * @return order_date
     */
    public java.util.Date getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this Work_table_select_responseWork_table.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Date order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the selected value for this Work_table_select_responseWork_table.
     * 
     * @return selected
     */
    public int getSelected() {
        return selected;
    }


    /**
     * Sets the selected value for this Work_table_select_responseWork_table.
     * 
     * @param selected
     */
    public void setSelected(int selected) {
        this.selected = selected;
    }


    /**
     * Gets the zip value for this Work_table_select_responseWork_table.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this Work_table_select_responseWork_table.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }


    /**
     * Gets the state value for this Work_table_select_responseWork_table.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Work_table_select_responseWork_table.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the audit_name_title_id value for this Work_table_select_responseWork_table.
     * 
     * @return audit_name_title_id
     */
    public int getAudit_name_title_id() {
        return audit_name_title_id;
    }


    /**
     * Sets the audit_name_title_id value for this Work_table_select_responseWork_table.
     * 
     * @param audit_name_title_id
     */
    public void setAudit_name_title_id(int audit_name_title_id) {
        this.audit_name_title_id = audit_name_title_id;
    }


    /**
     * Gets the pay_status_reason value for this Work_table_select_responseWork_table.
     * 
     * @return pay_status_reason
     */
    public java.lang.String getPay_status_reason() {
        return pay_status_reason;
    }


    /**
     * Sets the pay_status_reason value for this Work_table_select_responseWork_table.
     * 
     * @param pay_status_reason
     */
    public void setPay_status_reason(java.lang.String pay_status_reason) {
        this.pay_status_reason = pay_status_reason;
    }


    /**
     * Gets the currency value for this Work_table_select_responseWork_table.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Work_table_select_responseWork_table.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the oc_id value for this Work_table_select_responseWork_table.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Work_table_select_responseWork_table.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the old_audit_qual_category value for this Work_table_select_responseWork_table.
     * 
     * @return old_audit_qual_category
     */
    public int getOld_audit_qual_category() {
        return old_audit_qual_category;
    }


    /**
     * Sets the old_audit_qual_category value for this Work_table_select_responseWork_table.
     * 
     * @param old_audit_qual_category
     */
    public void setOld_audit_qual_category(int old_audit_qual_category) {
        this.old_audit_qual_category = old_audit_qual_category;
    }


    /**
     * Gets the new_audit_qual_category value for this Work_table_select_responseWork_table.
     * 
     * @return new_audit_qual_category
     */
    public int getNew_audit_qual_category() {
        return new_audit_qual_category;
    }


    /**
     * Sets the new_audit_qual_category value for this Work_table_select_responseWork_table.
     * 
     * @param new_audit_qual_category
     */
    public void setNew_audit_qual_category(int new_audit_qual_category) {
        this.new_audit_qual_category = new_audit_qual_category;
    }


    /**
     * Gets the percent_of_basic_price value for this Work_table_select_responseWork_table.
     * 
     * @return percent_of_basic_price
     */
    public int getPercent_of_basic_price() {
        return percent_of_basic_price;
    }


    /**
     * Sets the percent_of_basic_price value for this Work_table_select_responseWork_table.
     * 
     * @param percent_of_basic_price
     */
    public void setPercent_of_basic_price(int percent_of_basic_price) {
        this.percent_of_basic_price = percent_of_basic_price;
    }


    /**
     * Gets the refund_via_process value for this Work_table_select_responseWork_table.
     * 
     * @return refund_via_process
     */
    public int getRefund_via_process() {
        return refund_via_process;
    }


    /**
     * Sets the refund_via_process value for this Work_table_select_responseWork_table.
     * 
     * @param refund_via_process
     */
    public void setRefund_via_process(int refund_via_process) {
        this.refund_via_process = refund_via_process;
    }


    /**
     * Gets the discount_class_id value for this Work_table_select_responseWork_table.
     * 
     * @return discount_class_id
     */
    public int getDiscount_class_id() {
        return discount_class_id;
    }


    /**
     * Sets the discount_class_id value for this Work_table_select_responseWork_table.
     * 
     * @param discount_class_id
     */
    public void setDiscount_class_id(int discount_class_id) {
        this.discount_class_id = discount_class_id;
    }


    /**
     * Gets the billing_item_barcode value for this Work_table_select_responseWork_table.
     * 
     * @return billing_item_barcode
     */
    public java.lang.String getBilling_item_barcode() {
        return billing_item_barcode;
    }


    /**
     * Sets the billing_item_barcode value for this Work_table_select_responseWork_table.
     * 
     * @param billing_item_barcode
     */
    public void setBilling_item_barcode(java.lang.String billing_item_barcode) {
        this.billing_item_barcode = billing_item_barcode;
    }


    /**
     * Gets the billing_group_barcode value for this Work_table_select_responseWork_table.
     * 
     * @return billing_group_barcode
     */
    public java.lang.String getBilling_group_barcode() {
        return billing_group_barcode;
    }


    /**
     * Sets the billing_group_barcode value for this Work_table_select_responseWork_table.
     * 
     * @param billing_group_barcode
     */
    public void setBilling_group_barcode(java.lang.String billing_group_barcode) {
        this.billing_group_barcode = billing_group_barcode;
    }


    /**
     * Gets the email value for this Work_table_select_responseWork_table.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Work_table_select_responseWork_table.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the event_queue_id value for this Work_table_select_responseWork_table.
     * 
     * @return event_queue_id
     */
    public int getEvent_queue_id() {
        return event_queue_id;
    }


    /**
     * Sets the event_queue_id value for this Work_table_select_responseWork_table.
     * 
     * @param event_queue_id
     */
    public void setEvent_queue_id(int event_queue_id) {
        this.event_queue_id = event_queue_id;
    }


    /**
     * Gets the revenue_method value for this Work_table_select_responseWork_table.
     * 
     * @return revenue_method
     */
    public int getRevenue_method() {
        return revenue_method;
    }


    /**
     * Sets the revenue_method value for this Work_table_select_responseWork_table.
     * 
     * @param revenue_method
     */
    public void setRevenue_method(int revenue_method) {
        this.revenue_method = revenue_method;
    }


    /**
     * Gets the pay_check_number value for this Work_table_select_responseWork_table.
     * 
     * @return pay_check_number
     */
    public java.lang.String getPay_check_number() {
        return pay_check_number;
    }


    /**
     * Sets the pay_check_number value for this Work_table_select_responseWork_table.
     * 
     * @param pay_check_number
     */
    public void setPay_check_number(java.lang.String pay_check_number) {
        this.pay_check_number = pay_check_number;
    }


    /**
     * Gets the other_label1 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label1
     */
    public java.lang.String getOther_label1() {
        return other_label1;
    }


    /**
     * Sets the other_label1 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label1
     */
    public void setOther_label1(java.lang.String other_label1) {
        this.other_label1 = other_label1;
    }


    /**
     * Gets the other_label2 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label2
     */
    public java.lang.String getOther_label2() {
        return other_label2;
    }


    /**
     * Sets the other_label2 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label2
     */
    public void setOther_label2(java.lang.String other_label2) {
        this.other_label2 = other_label2;
    }


    /**
     * Gets the other_label3 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label3
     */
    public java.lang.String getOther_label3() {
        return other_label3;
    }


    /**
     * Sets the other_label3 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label3
     */
    public void setOther_label3(java.lang.String other_label3) {
        this.other_label3 = other_label3;
    }


    /**
     * Gets the other_label4 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label4
     */
    public java.lang.String getOther_label4() {
        return other_label4;
    }


    /**
     * Sets the other_label4 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label4
     */
    public void setOther_label4(java.lang.String other_label4) {
        this.other_label4 = other_label4;
    }


    /**
     * Gets the other_label5 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label5
     */
    public java.lang.String getOther_label5() {
        return other_label5;
    }


    /**
     * Sets the other_label5 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label5
     */
    public void setOther_label5(java.lang.String other_label5) {
        this.other_label5 = other_label5;
    }


    /**
     * Gets the other_label6 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label6
     */
    public java.lang.String getOther_label6() {
        return other_label6;
    }


    /**
     * Sets the other_label6 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label6
     */
    public void setOther_label6(java.lang.String other_label6) {
        this.other_label6 = other_label6;
    }


    /**
     * Gets the other_label7 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label7
     */
    public java.lang.String getOther_label7() {
        return other_label7;
    }


    /**
     * Sets the other_label7 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label7
     */
    public void setOther_label7(java.lang.String other_label7) {
        this.other_label7 = other_label7;
    }


    /**
     * Gets the other_label8 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label8
     */
    public java.lang.String getOther_label8() {
        return other_label8;
    }


    /**
     * Sets the other_label8 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label8
     */
    public void setOther_label8(java.lang.String other_label8) {
        this.other_label8 = other_label8;
    }


    /**
     * Gets the other_label9 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label9
     */
    public java.lang.String getOther_label9() {
        return other_label9;
    }


    /**
     * Sets the other_label9 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label9
     */
    public void setOther_label9(java.lang.String other_label9) {
        this.other_label9 = other_label9;
    }


    /**
     * Gets the other_label10 value for this Work_table_select_responseWork_table.
     * 
     * @return other_label10
     */
    public java.lang.String getOther_label10() {
        return other_label10;
    }


    /**
     * Sets the other_label10 value for this Work_table_select_responseWork_table.
     * 
     * @param other_label10
     */
    public void setOther_label10(java.lang.String other_label10) {
        this.other_label10 = other_label10;
    }


    /**
     * Gets the invoice_id value for this Work_table_select_responseWork_table.
     * 
     * @return invoice_id
     */
    public int getInvoice_id() {
        return invoice_id;
    }


    /**
     * Sets the invoice_id value for this Work_table_select_responseWork_table.
     * 
     * @param invoice_id
     */
    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }


    /**
     * Gets the service_seq value for this Work_table_select_responseWork_table.
     * 
     * @return service_seq
     */
    public int getService_seq() {
        return service_seq;
    }


    /**
     * Sets the service_seq value for this Work_table_select_responseWork_table.
     * 
     * @param service_seq
     */
    public void setService_seq(int service_seq) {
        this.service_seq = service_seq;
    }


    /**
     * Gets the taxonomy value for this Work_table_select_responseWork_table.
     * 
     * @return taxonomy
     */
    public java.lang.String getTaxonomy() {
        return taxonomy;
    }


    /**
     * Sets the taxonomy value for this Work_table_select_responseWork_table.
     * 
     * @param taxonomy
     */
    public void setTaxonomy(java.lang.String taxonomy) {
        this.taxonomy = taxonomy;
    }


    /**
     * Gets the has_tax value for this Work_table_select_responseWork_table.
     * 
     * @return has_tax
     */
    public int getHas_tax() {
        return has_tax;
    }


    /**
     * Sets the has_tax value for this Work_table_select_responseWork_table.
     * 
     * @param has_tax
     */
    public void setHas_tax(int has_tax) {
        this.has_tax = has_tax;
    }


    /**
     * Gets the payment_account_seq value for this Work_table_select_responseWork_table.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Work_table_select_responseWork_table.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the customer_login_id value for this Work_table_select_responseWork_table.
     * 
     * @return customer_login_id
     */
    public int getCustomer_login_id() {
        return customer_login_id;
    }


    /**
     * Sets the customer_login_id value for this Work_table_select_responseWork_table.
     * 
     * @param customer_login_id
     */
    public void setCustomer_login_id(int customer_login_id) {
        this.customer_login_id = customer_login_id;
    }


    /**
     * Gets the source_job_id value for this Work_table_select_responseWork_table.
     * 
     * @return source_job_id
     */
    public int getSource_job_id() {
        return source_job_id;
    }


    /**
     * Sets the source_job_id value for this Work_table_select_responseWork_table.
     * 
     * @param source_job_id
     */
    public void setSource_job_id(int source_job_id) {
        this.source_job_id = source_job_id;
    }


    /**
     * Gets the transaction_event value for this Work_table_select_responseWork_table.
     * 
     * @return transaction_event
     */
    public int getTransaction_event() {
        return transaction_event;
    }


    /**
     * Sets the transaction_event value for this Work_table_select_responseWork_table.
     * 
     * @param transaction_event
     */
    public void setTransaction_event(int transaction_event) {
        this.transaction_event = transaction_event;
    }


    /**
     * Gets the suspension_seq value for this Work_table_select_responseWork_table.
     * 
     * @return suspension_seq
     */
    public int getSuspension_seq() {
        return suspension_seq;
    }


    /**
     * Sets the suspension_seq value for this Work_table_select_responseWork_table.
     * 
     * @param suspension_seq
     */
    public void setSuspension_seq(int suspension_seq) {
        this.suspension_seq = suspension_seq;
    }


    /**
     * Gets the source_work_table_seq value for this Work_table_select_responseWork_table.
     * 
     * @return source_work_table_seq
     */
    public int getSource_work_table_seq() {
        return source_work_table_seq;
    }


    /**
     * Sets the source_work_table_seq value for this Work_table_select_responseWork_table.
     * 
     * @param source_work_table_seq
     */
    public void setSource_work_table_seq(int source_work_table_seq) {
        this.source_work_table_seq = source_work_table_seq;
    }


    /**
     * Gets the suppress_email value for this Work_table_select_responseWork_table.
     * 
     * @return suppress_email
     */
    public int getSuppress_email() {
        return suppress_email;
    }


    /**
     * Sets the suppress_email value for this Work_table_select_responseWork_table.
     * 
     * @param suppress_email
     */
    public void setSuppress_email(int suppress_email) {
        this.suppress_email = suppress_email;
    }


    /**
     * Gets the customer_group_customer_id value for this Work_table_select_responseWork_table.
     * 
     * @return customer_group_customer_id
     */
    public int getCustomer_group_customer_id() {
        return customer_group_customer_id;
    }


    /**
     * Sets the customer_group_customer_id value for this Work_table_select_responseWork_table.
     * 
     * @param customer_group_customer_id
     */
    public void setCustomer_group_customer_id(int customer_group_customer_id) {
        this.customer_group_customer_id = customer_group_customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Work_table_select_responseWork_table)) return false;
        Work_table_select_responseWork_table other = (Work_table_select_responseWork_table) obj;
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
            this.work_record_status == other.getWork_record_status() &&
            ((this.update_mask==null && other.getUpdate_mask()==null) || 
             (this.update_mask!=null &&
              java.util.Arrays.equals(this.update_mask, other.getUpdate_mask()))) &&
            ((this.insert_bits==null && other.getInsert_bits()==null) || 
             (this.insert_bits!=null &&
              java.util.Arrays.equals(this.insert_bits, other.getInsert_bits()))) &&
            ((this.promotion_bits==null && other.getPromotion_bits()==null) || 
             (this.promotion_bits!=null &&
              java.util.Arrays.equals(this.promotion_bits, other.getPromotion_bits()))) &&
            ((this.split_value==null && other.getSplit_value()==null) || 
             (this.split_value!=null &&
              this.split_value.equals(other.getSplit_value()))) &&
            this.customer_id == other.getCustomer_id() &&
            this.send_to_customer_id == other.getSend_to_customer_id() &&
            this.send_to_customer_address_seq == other.getSend_to_customer_address_seq() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.label1==null && other.getLabel1()==null) || 
             (this.label1!=null &&
              this.label1.equals(other.getLabel1()))) &&
            ((this.label2==null && other.getLabel2()==null) || 
             (this.label2!=null &&
              this.label2.equals(other.getLabel2()))) &&
            ((this.label3==null && other.getLabel3()==null) || 
             (this.label3!=null &&
              this.label3.equals(other.getLabel3()))) &&
            ((this.label4==null && other.getLabel4()==null) || 
             (this.label4!=null &&
              this.label4.equals(other.getLabel4()))) &&
            ((this.label5==null && other.getLabel5()==null) || 
             (this.label5!=null &&
              this.label5.equals(other.getLabel5()))) &&
            ((this.label6==null && other.getLabel6()==null) || 
             (this.label6!=null &&
              this.label6.equals(other.getLabel6()))) &&
            ((this.label7==null && other.getLabel7()==null) || 
             (this.label7!=null &&
              this.label7.equals(other.getLabel7()))) &&
            ((this.label8==null && other.getLabel8()==null) || 
             (this.label8!=null &&
              this.label8.equals(other.getLabel8()))) &&
            ((this.label9==null && other.getLabel9()==null) || 
             (this.label9!=null &&
              this.label9.equals(other.getLabel9()))) &&
            ((this.label10==null && other.getLabel10()==null) || 
             (this.label10!=null &&
              this.label10.equals(other.getLabel10()))) &&
            ((this.sort_string==null && other.getSort_string()==null) || 
             (this.sort_string!=null &&
              this.sort_string.equals(other.getSort_string()))) &&
            ((this.priority_sort_string==null && other.getPriority_sort_string()==null) || 
             (this.priority_sort_string!=null &&
              this.priority_sort_string.equals(other.getPriority_sort_string()))) &&
            ((this.issue_date==null && other.getIssue_date()==null) || 
             (this.issue_date!=null &&
              this.issue_date.equals(other.getIssue_date()))) &&
            ((this.enumeration==null && other.getEnumeration()==null) || 
             (this.enumeration!=null &&
              this.enumeration.equals(other.getEnumeration()))) &&
            this.new_n_deferred_issues_left == other.getNew_n_deferred_issues_left() &&
            this.product_id == other.getProduct_id() &&
            ((this.product_size==null && other.getProduct_size()==null) || 
             (this.product_size!=null &&
              this.product_size.equals(other.getProduct_size()))) &&
            ((this.product_style==null && other.getProduct_style()==null) || 
             (this.product_style!=null &&
              this.product_style.equals(other.getProduct_style()))) &&
            ((this.product_color==null && other.getProduct_color()==null) || 
             (this.product_color!=null &&
              this.product_color.equals(other.getProduct_color()))) &&
            this.quantity == other.getQuantity() &&
            this.quantity_backordered == other.getQuantity_backordered() &&
            ((this.renewal_def==null && other.getRenewal_def()==null) || 
             (this.renewal_def!=null &&
              this.renewal_def.equals(other.getRenewal_def()))) &&
            this.renewal_def_test_seq == other.getRenewal_def_test_seq() &&
            this.renewal_effort_number == other.getRenewal_effort_number() &&
            this.renewal_card_id == other.getRenewal_card_id() &&
            this.rate_class_id == other.getRate_class_id() &&
            this.added == other.getAdded() &&
            this.was_name == other.getWas_name() &&
            this.was_title == other.getWas_title() &&
            this.was_company == other.getWas_company() &&
            this.suppress_renewal_output == other.getSuppress_renewal_output() &&
            ((this.billing_def==null && other.getBilling_def()==null) || 
             (this.billing_def!=null &&
              this.billing_def.equals(other.getBilling_def()))) &&
            this.billing_def_test_seq == other.getBilling_def_test_seq() &&
            this.billing_effort_number == other.getBilling_effort_number() &&
            ((this.billing_code==null && other.getBilling_code()==null) || 
             (this.billing_code!=null &&
              this.billing_code.equals(other.getBilling_code()))) &&
            this.billing_installment_number == other.getBilling_installment_number() &&
            this.suppress_billing_output == other.getSuppress_billing_output() &&
            this.job_ren_offer_id == other.getJob_ren_offer_id() &&
            this.invoice_number == other.getInvoice_number() &&
            this.undeliverable == other.getUndeliverable() &&
            this.source_code_id == other.getSource_code_id() &&
            ((this.source_code==null && other.getSource_code()==null) || 
             (this.source_code!=null &&
              this.source_code.equals(other.getSource_code()))) &&
            ((this.source_format==null && other.getSource_format()==null) || 
             (this.source_format!=null &&
              this.source_format.equals(other.getSource_format()))) &&
            this.package_id == other.getPackage_id() &&
            this.issue_id == other.getIssue_id() &&
            this.inventory_id == other.getInventory_id() &&
            ((this.pay_id_nbr==null && other.getPay_id_nbr()==null) || 
             (this.pay_id_nbr!=null &&
              this.pay_id_nbr.equals(other.getPay_id_nbr()))) &&
            this.payment_seq == other.getPayment_seq() &&
            ((this.pay_exp_date==null && other.getPay_exp_date()==null) || 
             (this.pay_exp_date!=null &&
              this.pay_exp_date.equals(other.getPay_exp_date()))) &&
            ((this.pay_ref_nbr==null && other.getPay_ref_nbr()==null) || 
             (this.pay_ref_nbr!=null &&
              this.pay_ref_nbr.equals(other.getPay_ref_nbr()))) &&
            ((this.pay_auth_code==null && other.getPay_auth_code()==null) || 
             (this.pay_auth_code!=null &&
              this.pay_auth_code.equals(other.getPay_auth_code()))) &&
            ((this.pay_auth_date==null && other.getPay_auth_date()==null) || 
             (this.pay_auth_date!=null &&
              this.pay_auth_date.equals(other.getPay_auth_date()))) &&
            ((this.pay_clear_date==null && other.getPay_clear_date()==null) || 
             (this.pay_clear_date!=null &&
              this.pay_clear_date.equals(other.getPay_clear_date()))) &&
            ((this.pay_credit_card_info==null && other.getPay_credit_card_info()==null) || 
             (this.pay_credit_card_info!=null &&
              this.pay_credit_card_info.equals(other.getPay_credit_card_info()))) &&
            ((this.pay_amount==null && other.getPay_amount()==null) || 
             (this.pay_amount!=null &&
              this.pay_amount.equals(other.getPay_amount()))) &&
            this.pay_clear_status == other.getPay_clear_status() &&
            this.audit_subscription_type_id == other.getAudit_subscription_type_id() &&
            this.audit_qual_source_id == other.getAudit_qual_source_id() &&
            this.audit_sales_channel_id == other.getAudit_sales_channel_id() &&
            this.duration == other.getDuration() &&
            ((this.qual_date==null && other.getQual_date()==null) || 
             (this.qual_date!=null &&
              this.qual_date.equals(other.getQual_date()))) &&
            ((this.squal_date==null && other.getSqual_date()==null) || 
             (this.squal_date!=null &&
              this.squal_date.equals(other.getSqual_date()))) &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            this.selected == other.getSelected() &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            this.audit_name_title_id == other.getAudit_name_title_id() &&
            ((this.pay_status_reason==null && other.getPay_status_reason()==null) || 
             (this.pay_status_reason!=null &&
              this.pay_status_reason.equals(other.getPay_status_reason()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            this.oc_id == other.getOc_id() &&
            this.old_audit_qual_category == other.getOld_audit_qual_category() &&
            this.new_audit_qual_category == other.getNew_audit_qual_category() &&
            this.percent_of_basic_price == other.getPercent_of_basic_price() &&
            this.refund_via_process == other.getRefund_via_process() &&
            this.discount_class_id == other.getDiscount_class_id() &&
            ((this.billing_item_barcode==null && other.getBilling_item_barcode()==null) || 
             (this.billing_item_barcode!=null &&
              this.billing_item_barcode.equals(other.getBilling_item_barcode()))) &&
            ((this.billing_group_barcode==null && other.getBilling_group_barcode()==null) || 
             (this.billing_group_barcode!=null &&
              this.billing_group_barcode.equals(other.getBilling_group_barcode()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.event_queue_id == other.getEvent_queue_id() &&
            this.revenue_method == other.getRevenue_method() &&
            ((this.pay_check_number==null && other.getPay_check_number()==null) || 
             (this.pay_check_number!=null &&
              this.pay_check_number.equals(other.getPay_check_number()))) &&
            ((this.other_label1==null && other.getOther_label1()==null) || 
             (this.other_label1!=null &&
              this.other_label1.equals(other.getOther_label1()))) &&
            ((this.other_label2==null && other.getOther_label2()==null) || 
             (this.other_label2!=null &&
              this.other_label2.equals(other.getOther_label2()))) &&
            ((this.other_label3==null && other.getOther_label3()==null) || 
             (this.other_label3!=null &&
              this.other_label3.equals(other.getOther_label3()))) &&
            ((this.other_label4==null && other.getOther_label4()==null) || 
             (this.other_label4!=null &&
              this.other_label4.equals(other.getOther_label4()))) &&
            ((this.other_label5==null && other.getOther_label5()==null) || 
             (this.other_label5!=null &&
              this.other_label5.equals(other.getOther_label5()))) &&
            ((this.other_label6==null && other.getOther_label6()==null) || 
             (this.other_label6!=null &&
              this.other_label6.equals(other.getOther_label6()))) &&
            ((this.other_label7==null && other.getOther_label7()==null) || 
             (this.other_label7!=null &&
              this.other_label7.equals(other.getOther_label7()))) &&
            ((this.other_label8==null && other.getOther_label8()==null) || 
             (this.other_label8!=null &&
              this.other_label8.equals(other.getOther_label8()))) &&
            ((this.other_label9==null && other.getOther_label9()==null) || 
             (this.other_label9!=null &&
              this.other_label9.equals(other.getOther_label9()))) &&
            ((this.other_label10==null && other.getOther_label10()==null) || 
             (this.other_label10!=null &&
              this.other_label10.equals(other.getOther_label10()))) &&
            this.invoice_id == other.getInvoice_id() &&
            this.service_seq == other.getService_seq() &&
            ((this.taxonomy==null && other.getTaxonomy()==null) || 
             (this.taxonomy!=null &&
              this.taxonomy.equals(other.getTaxonomy()))) &&
            this.has_tax == other.getHas_tax() &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            this.customer_login_id == other.getCustomer_login_id() &&
            this.source_job_id == other.getSource_job_id() &&
            this.transaction_event == other.getTransaction_event() &&
            this.suspension_seq == other.getSuspension_seq() &&
            this.source_work_table_seq == other.getSource_work_table_seq() &&
            this.suppress_email == other.getSuppress_email() &&
            this.customer_group_customer_id == other.getCustomer_group_customer_id();
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
        _hashCode += getWork_record_status();
        if (getUpdate_mask() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUpdate_mask());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUpdate_mask(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInsert_bits() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInsert_bits());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInsert_bits(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPromotion_bits() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromotion_bits());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromotion_bits(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSplit_value() != null) {
            _hashCode += getSplit_value().hashCode();
        }
        _hashCode += getCustomer_id();
        _hashCode += getSend_to_customer_id();
        _hashCode += getSend_to_customer_address_seq();
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getSubscrip_id();
        if (getLabel1() != null) {
            _hashCode += getLabel1().hashCode();
        }
        if (getLabel2() != null) {
            _hashCode += getLabel2().hashCode();
        }
        if (getLabel3() != null) {
            _hashCode += getLabel3().hashCode();
        }
        if (getLabel4() != null) {
            _hashCode += getLabel4().hashCode();
        }
        if (getLabel5() != null) {
            _hashCode += getLabel5().hashCode();
        }
        if (getLabel6() != null) {
            _hashCode += getLabel6().hashCode();
        }
        if (getLabel7() != null) {
            _hashCode += getLabel7().hashCode();
        }
        if (getLabel8() != null) {
            _hashCode += getLabel8().hashCode();
        }
        if (getLabel9() != null) {
            _hashCode += getLabel9().hashCode();
        }
        if (getLabel10() != null) {
            _hashCode += getLabel10().hashCode();
        }
        if (getSort_string() != null) {
            _hashCode += getSort_string().hashCode();
        }
        if (getPriority_sort_string() != null) {
            _hashCode += getPriority_sort_string().hashCode();
        }
        if (getIssue_date() != null) {
            _hashCode += getIssue_date().hashCode();
        }
        if (getEnumeration() != null) {
            _hashCode += getEnumeration().hashCode();
        }
        _hashCode += getNew_n_deferred_issues_left();
        _hashCode += getProduct_id();
        if (getProduct_size() != null) {
            _hashCode += getProduct_size().hashCode();
        }
        if (getProduct_style() != null) {
            _hashCode += getProduct_style().hashCode();
        }
        if (getProduct_color() != null) {
            _hashCode += getProduct_color().hashCode();
        }
        _hashCode += getQuantity();
        _hashCode += getQuantity_backordered();
        if (getRenewal_def() != null) {
            _hashCode += getRenewal_def().hashCode();
        }
        _hashCode += getRenewal_def_test_seq();
        _hashCode += getRenewal_effort_number();
        _hashCode += getRenewal_card_id();
        _hashCode += getRate_class_id();
        _hashCode += getAdded();
        _hashCode += getWas_name();
        _hashCode += getWas_title();
        _hashCode += getWas_company();
        _hashCode += getSuppress_renewal_output();
        if (getBilling_def() != null) {
            _hashCode += getBilling_def().hashCode();
        }
        _hashCode += getBilling_def_test_seq();
        _hashCode += getBilling_effort_number();
        if (getBilling_code() != null) {
            _hashCode += getBilling_code().hashCode();
        }
        _hashCode += getBilling_installment_number();
        _hashCode += getSuppress_billing_output();
        _hashCode += getJob_ren_offer_id();
        _hashCode += getInvoice_number();
        _hashCode += getUndeliverable();
        _hashCode += getSource_code_id();
        if (getSource_code() != null) {
            _hashCode += getSource_code().hashCode();
        }
        if (getSource_format() != null) {
            _hashCode += getSource_format().hashCode();
        }
        _hashCode += getPackage_id();
        _hashCode += getIssue_id();
        _hashCode += getInventory_id();
        if (getPay_id_nbr() != null) {
            _hashCode += getPay_id_nbr().hashCode();
        }
        _hashCode += getPayment_seq();
        if (getPay_exp_date() != null) {
            _hashCode += getPay_exp_date().hashCode();
        }
        if (getPay_ref_nbr() != null) {
            _hashCode += getPay_ref_nbr().hashCode();
        }
        if (getPay_auth_code() != null) {
            _hashCode += getPay_auth_code().hashCode();
        }
        if (getPay_auth_date() != null) {
            _hashCode += getPay_auth_date().hashCode();
        }
        if (getPay_clear_date() != null) {
            _hashCode += getPay_clear_date().hashCode();
        }
        if (getPay_credit_card_info() != null) {
            _hashCode += getPay_credit_card_info().hashCode();
        }
        if (getPay_amount() != null) {
            _hashCode += getPay_amount().hashCode();
        }
        _hashCode += getPay_clear_status();
        _hashCode += getAudit_subscription_type_id();
        _hashCode += getAudit_qual_source_id();
        _hashCode += getAudit_sales_channel_id();
        _hashCode += getDuration();
        if (getQual_date() != null) {
            _hashCode += getQual_date().hashCode();
        }
        if (getSqual_date() != null) {
            _hashCode += getSqual_date().hashCode();
        }
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        _hashCode += getSelected();
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        _hashCode += getAudit_name_title_id();
        if (getPay_status_reason() != null) {
            _hashCode += getPay_status_reason().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        _hashCode += getOc_id();
        _hashCode += getOld_audit_qual_category();
        _hashCode += getNew_audit_qual_category();
        _hashCode += getPercent_of_basic_price();
        _hashCode += getRefund_via_process();
        _hashCode += getDiscount_class_id();
        if (getBilling_item_barcode() != null) {
            _hashCode += getBilling_item_barcode().hashCode();
        }
        if (getBilling_group_barcode() != null) {
            _hashCode += getBilling_group_barcode().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getEvent_queue_id();
        _hashCode += getRevenue_method();
        if (getPay_check_number() != null) {
            _hashCode += getPay_check_number().hashCode();
        }
        if (getOther_label1() != null) {
            _hashCode += getOther_label1().hashCode();
        }
        if (getOther_label2() != null) {
            _hashCode += getOther_label2().hashCode();
        }
        if (getOther_label3() != null) {
            _hashCode += getOther_label3().hashCode();
        }
        if (getOther_label4() != null) {
            _hashCode += getOther_label4().hashCode();
        }
        if (getOther_label5() != null) {
            _hashCode += getOther_label5().hashCode();
        }
        if (getOther_label6() != null) {
            _hashCode += getOther_label6().hashCode();
        }
        if (getOther_label7() != null) {
            _hashCode += getOther_label7().hashCode();
        }
        if (getOther_label8() != null) {
            _hashCode += getOther_label8().hashCode();
        }
        if (getOther_label9() != null) {
            _hashCode += getOther_label9().hashCode();
        }
        if (getOther_label10() != null) {
            _hashCode += getOther_label10().hashCode();
        }
        _hashCode += getInvoice_id();
        _hashCode += getService_seq();
        if (getTaxonomy() != null) {
            _hashCode += getTaxonomy().hashCode();
        }
        _hashCode += getHas_tax();
        _hashCode += getPayment_account_seq();
        _hashCode += getCustomer_login_id();
        _hashCode += getSource_job_id();
        _hashCode += getTransaction_event();
        _hashCode += getSuspension_seq();
        _hashCode += getSource_work_table_seq();
        _hashCode += getSuppress_email();
        _hashCode += getCustomer_group_customer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Work_table_select_responseWork_table.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>work_table_select_response>work_table"));
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
        attrField.setFieldName("work_record_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "work_record_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("update_mask");
        attrField.setXmlName(new javax.xml.namespace.QName("", "update_mask"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("insert_bits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "insert_bits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotion_bits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotion_bits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("split_value");
        attrField.setXmlName(new javax.xml.namespace.QName("", "split_value"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_to_customer_address_seq"));
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
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label1");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label1"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label2");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label2"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label3");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label3"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label4");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label4"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label5");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label5"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label6");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label6"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label7");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label7"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label8");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label8"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label9");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label9"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label10");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label10"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sort_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sort_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("priority_sort_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "priority_sort_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_n_deferred_issues_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_n_deferred_issues_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_size");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_size"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_color");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_color"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quantity");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quantity"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quantity_backordered");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quantity_backordered"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_def_test_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_def_test_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_effort_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_effort_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_card_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_card_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("added");
        attrField.setXmlName(new javax.xml.namespace.QName("", "added"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("was_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "was_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("was_title");
        attrField.setXmlName(new javax.xml.namespace.QName("", "was_title"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("was_company");
        attrField.setXmlName(new javax.xml.namespace.QName("", "was_company"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_renewal_output");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_renewal_output"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_def_test_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_def_test_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_effort_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_effort_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_installment_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_installment_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_billing_output");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_billing_output"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_ren_offer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_ren_offer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoice_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoice_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("undeliverable");
        attrField.setXmlName(new javax.xml.namespace.QName("", "undeliverable"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_format");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_format"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("package_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "package_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inventory_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inventory_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_id_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_id_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_exp_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_exp_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        attrField.setFieldName("pay_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_clear_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_clear_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_subscription_type_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_subscription_type_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_qual_source_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_qual_source_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_sales_channel_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_sales_channel_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("duration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "duration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qual_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qual_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("squal_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "squal_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("selected");
        attrField.setXmlName(new javax.xml.namespace.QName("", "selected"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("zip");
        attrField.setXmlName(new javax.xml.namespace.QName("", "zip"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("state");
        attrField.setXmlName(new javax.xml.namespace.QName("", "state"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_name_title_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_name_title_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_status_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_status_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("old_audit_qual_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "old_audit_qual_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_audit_qual_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_audit_qual_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("percent_of_basic_price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "percent_of_basic_price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_via_process");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_via_process"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_item_barcode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_item_barcode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_group_barcode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_group_barcode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("event_queue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "event_queue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_check_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_check_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label1");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label1"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label2");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label2"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label3");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label3"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label4");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label4"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label5");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label5"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label6");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label6"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label7");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label7"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label8");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label8"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label9");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label9"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("other_label10");
        attrField.setXmlName(new javax.xml.namespace.QName("", "other_label10"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoice_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoice_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("taxonomy");
        attrField.setXmlName(new javax.xml.namespace.QName("", "taxonomy"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_tax");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_tax"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transaction_event");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transaction_event"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspension_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_work_table_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_work_table_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_group_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_group_customer_id"));
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
