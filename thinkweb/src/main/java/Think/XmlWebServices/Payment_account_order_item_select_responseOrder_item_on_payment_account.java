/**
 * Payment_account_order_item_select_responseOrder_item_on_payment_account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_account_order_item_select_responseOrder_item_on_payment_account  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private java.lang.String user_code;  // attribute

    private java.lang.String currency;  // attribute

    private java.lang.String delivery_method;  // attribute

    private int source_code_id;  // attribute

    private java.lang.String order_category;  // attribute

    private int package_id;  // attribute

    private int package_content_seq;  // attribute

    private int date_stamp;  // attribute

    private int order_item_type;  // attribute

    private java.util.Date order_date;  // attribute

    private int order_qty;  // attribute

    private java.math.BigDecimal gross_base_amount;  // attribute

    private java.math.BigDecimal gross_local_amount;  // attribute

    private java.math.BigDecimal net_base_amount;  // attribute

    private java.math.BigDecimal net_local_amount;  // attribute

    private int has_tax;  // attribute

    private int has_delivery_charge;  // attribute

    private java.util.Date bill_date;  // attribute

    private int n_inv_efforts;  // attribute

    private java.util.Date last_inv_date;  // attribute

    private int payment_status;  // attribute

    private int refund_status;  // attribute

    private int order_type;  // attribute

    private int billing_type;  // attribute

    private int has_premium;  // attribute

    private int prepayment_req;  // attribute

    private int product_id;  // attribute

    private int ship_qty;  // attribute

    private int backord_qty;  // attribute

    private int subscrip_id;  // attribute

    private int bundle_qty;  // attribute

    private int audit_qual_category;  // attribute

    private int is_complimentary;  // attribute

    private int subscrip_start_type;  // attribute

    private int order_code_id;  // attribute

    private java.lang.String cancel_reason;  // attribute

    private int customer_group_id;  // attribute

    private int audit_qual_source_id;  // attribute

    private int audit_subscription_type_id;  // attribute

    private int percent_of_basic_price;  // attribute

    private int duration;  // attribute

    private int renewal_status;  // attribute

    private int delivery_method_perm;  // attribute

    private int change_qty_flag;  // attribute

    private int n_issues_left;  // attribute

    private int n_ren_effort;  // attribute

    private java.util.Date last_ren_date;  // attribute

    private int n_del_iss_left;  // attribute

    private int n_remaining_paid_issues;  // attribute

    private int ext_iss_left;  // attribute

    private int ext_iss_tot;  // attribute

    private int audit_name_title_id;  // attribute

    private int audit_sales_channel_id;  // attribute

    private java.util.Date qual_date;  // attribute

    private java.util.Date squal_date;  // attribute

    private int order_status;  // attribute

    private java.util.Date cancel_date;  // attribute

    private int pub_rotation_id;  // attribute

    private int renewal_category;  // attribute

    private java.math.BigDecimal exchange_rate;  // attribute

    private int prem_to_order_item_seq;  // attribute

    private int renewal_orderhdr_id;  // attribute

    private int renewal_order_item_seq;  // attribute

    private int subscription_def_id;  // attribute

    private int rate_class_id;  // attribute

    private int rate_class_effective_seq;  // attribute

    private int ratecard_seq;  // attribute

    private int discount_class_id;  // attribute

    private int disc_class_effective_seq;  // attribute

    private int discount_card_seq;  // attribute

    private int inventory_id;  // attribute

    private int oc_id;  // attribute

    private int installment_plan_id;  // attribute

    private int auto_payment;  // attribute

    private int perpetual_order;  // attribute

    private int agency_customer_id;  // attribute

    private int bill_to_customer_id;  // attribute

    private int bill_to_customer_address_seq;  // attribute

    private int renew_to_customer_id;  // attribute

    private int renew_to_customer_address_seq;  // attribute

    private int start_issue_id;  // attribute

    private int stop_issue_id;  // attribute

    private int single_issue_id;  // attribute

    private int customer_id;  // attribute

    private int customer_address_seq;  // attribute

    private int note_exist;  // attribute

    private int service_exist;  // attribute

    private int number_volume_sets;  // attribute

    private int alt_ship_customer_id;  // attribute

    private int alt_ship_customer_address_seq;  // attribute

    private int alt_ship_del_calc;  // attribute

    private java.lang.String distribution_method;  // attribute

    private java.lang.String billing_def;  // attribute

    private int billing_def_test_seq;  // attribute

    private java.lang.String renewal_def;  // attribute

    private int renewal_def_test_seq;  // attribute

    private java.lang.String agent_ref_nbr;  // attribute

    private int has_been_renewed;  // attribute

    private int revenue_method;  // attribute

    private java.util.Date start_date;  // attribute

    private java.util.Date expire_date;  // attribute

    private java.lang.String electronic_document_identifier;  // attribute

    private int package_instance;  // attribute

    private int unit_type_id;  // attribute

    private int ex_rate_class_id;  // attribute

    private int ex_rate_class_effective_seq;  // attribute

    private int ex_ratecard_seq;  // attribute

    private int trial_period;  // attribute

    private int trial_type;  // attribute

    private int orig_order_qty;  // attribute

    private int unit_excess;  // attribute

    private java.math.BigDecimal manual_disc_amt_local;  // attribute

    private java.math.BigDecimal manual_disc_amt_base;  // attribute

    private java.math.BigDecimal manual_disc_percentage;  // attribute

    private int n_nonpaid_issues;  // attribute

    private int n_remaining_nonpaid_issues;  // attribute

    private int n_cal_units_per_seg;  // attribute

    private java.util.Date segment_expire_date;  // attribute

    private int calendar_unit;  // attribute

    private int n_items_per_seg;  // attribute

    private int n_segments_left;  // attribute

    private int is_proforma;  // attribute

    private int n_tax_updates;  // attribute

    private java.math.BigDecimal total_tax_local_amount;  // attribute

    private java.math.BigDecimal total_tax_base_amount;  // attribute

    private int renewed_from_subscrip_id;  // attribute

    private int pkg_item_seq;  // attribute

    private int pkg_def_id;  // attribute

    private int electronic_delivery;  // attribute

    private java.lang.String item_url;  // attribute

    private int payment_account_seq;  // attribute

    private int time_unit_options;  // attribute

    private int max_check_out_amt;  // attribute

    private int n_checked_out;  // attribute

    private int group_order;  // attribute

    private int deal_id;  // attribute

    private int invoice_id;  // attribute

    private java.util.Date invoice_date;  // attribute

    private java.util.Date fulfillment_date;  // attribute

    private int auto_renew_notify_sent;  // attribute

    private java.lang.String multiline_discount_schedule;  // attribute

    private java.math.BigDecimal multiline_disc_amount;  // attribute

    private int extended_days;  // attribute

    private int asynchronous_auto_renew;  // attribute

    private int n_days_graced;  // attribute

    private java.lang.String shipping_price_list;  // attribute

    private java.math.BigDecimal extended_rate;  // attribute

    private int is_back_ordered;  // attribute

    private int multiline_disc_eff_seq;  // attribute

    private int attach_exist;  // attribute

    private int addon_to_orderhdr_id;  // attribute

    private int addon_to_order_item_seq;  // attribute

    private int generic_promotion_code_seq;  // attribute

    private int charge_on_cancellation;  // attribute

    private java.util.Date last_tax_invoice_date;  // attribute

    private java.lang.String description;  // attribute

    private int p_payment_account_seq;  // attribute

    public Payment_account_order_item_select_responseOrder_item_on_payment_account() {
    }

    public Payment_account_order_item_select_responseOrder_item_on_payment_account(
           int orderhdr_id,
           int order_item_seq,
           java.lang.String user_code,
           java.lang.String currency,
           java.lang.String delivery_method,
           int source_code_id,
           java.lang.String order_category,
           int package_id,
           int package_content_seq,
           int date_stamp,
           int order_item_type,
           java.util.Date order_date,
           int order_qty,
           java.math.BigDecimal gross_base_amount,
           java.math.BigDecimal gross_local_amount,
           java.math.BigDecimal net_base_amount,
           java.math.BigDecimal net_local_amount,
           int has_tax,
           int has_delivery_charge,
           java.util.Date bill_date,
           int n_inv_efforts,
           java.util.Date last_inv_date,
           int payment_status,
           int refund_status,
           int order_type,
           int billing_type,
           int has_premium,
           int prepayment_req,
           int product_id,
           int ship_qty,
           int backord_qty,
           int subscrip_id,
           int bundle_qty,
           int audit_qual_category,
           int is_complimentary,
           int subscrip_start_type,
           int order_code_id,
           java.lang.String cancel_reason,
           int customer_group_id,
           int audit_qual_source_id,
           int audit_subscription_type_id,
           int percent_of_basic_price,
           int duration,
           int renewal_status,
           int delivery_method_perm,
           int change_qty_flag,
           int n_issues_left,
           int n_ren_effort,
           java.util.Date last_ren_date,
           int n_del_iss_left,
           int n_remaining_paid_issues,
           int ext_iss_left,
           int ext_iss_tot,
           int audit_name_title_id,
           int audit_sales_channel_id,
           java.util.Date qual_date,
           java.util.Date squal_date,
           int order_status,
           java.util.Date cancel_date,
           int pub_rotation_id,
           int renewal_category,
           java.math.BigDecimal exchange_rate,
           int prem_to_order_item_seq,
           int renewal_orderhdr_id,
           int renewal_order_item_seq,
           int subscription_def_id,
           int rate_class_id,
           int rate_class_effective_seq,
           int ratecard_seq,
           int discount_class_id,
           int disc_class_effective_seq,
           int discount_card_seq,
           int inventory_id,
           int oc_id,
           int installment_plan_id,
           int auto_payment,
           int perpetual_order,
           int agency_customer_id,
           int bill_to_customer_id,
           int bill_to_customer_address_seq,
           int renew_to_customer_id,
           int renew_to_customer_address_seq,
           int start_issue_id,
           int stop_issue_id,
           int single_issue_id,
           int customer_id,
           int customer_address_seq,
           int note_exist,
           int service_exist,
           int number_volume_sets,
           int alt_ship_customer_id,
           int alt_ship_customer_address_seq,
           int alt_ship_del_calc,
           java.lang.String distribution_method,
           java.lang.String billing_def,
           int billing_def_test_seq,
           java.lang.String renewal_def,
           int renewal_def_test_seq,
           java.lang.String agent_ref_nbr,
           int has_been_renewed,
           int revenue_method,
           java.util.Date start_date,
           java.util.Date expire_date,
           java.lang.String electronic_document_identifier,
           int package_instance,
           int unit_type_id,
           int ex_rate_class_id,
           int ex_rate_class_effective_seq,
           int ex_ratecard_seq,
           int trial_period,
           int trial_type,
           int orig_order_qty,
           int unit_excess,
           java.math.BigDecimal manual_disc_amt_local,
           java.math.BigDecimal manual_disc_amt_base,
           java.math.BigDecimal manual_disc_percentage,
           int n_nonpaid_issues,
           int n_remaining_nonpaid_issues,
           int n_cal_units_per_seg,
           java.util.Date segment_expire_date,
           int calendar_unit,
           int n_items_per_seg,
           int n_segments_left,
           int is_proforma,
           int n_tax_updates,
           java.math.BigDecimal total_tax_local_amount,
           java.math.BigDecimal total_tax_base_amount,
           int renewed_from_subscrip_id,
           int pkg_item_seq,
           int pkg_def_id,
           int electronic_delivery,
           java.lang.String item_url,
           int payment_account_seq,
           int time_unit_options,
           int max_check_out_amt,
           int n_checked_out,
           int group_order,
           int deal_id,
           int invoice_id,
           java.util.Date invoice_date,
           java.util.Date fulfillment_date,
           int auto_renew_notify_sent,
           java.lang.String multiline_discount_schedule,
           java.math.BigDecimal multiline_disc_amount,
           int extended_days,
           int asynchronous_auto_renew,
           int n_days_graced,
           java.lang.String shipping_price_list,
           java.math.BigDecimal extended_rate,
           int is_back_ordered,
           int multiline_disc_eff_seq,
           int attach_exist,
           int addon_to_orderhdr_id,
           int addon_to_order_item_seq,
           int generic_promotion_code_seq,
           int charge_on_cancellation,
           java.util.Date last_tax_invoice_date,
           java.lang.String description,
           int p_payment_account_seq) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.user_code = user_code;
           this.currency = currency;
           this.delivery_method = delivery_method;
           this.source_code_id = source_code_id;
           this.order_category = order_category;
           this.package_id = package_id;
           this.package_content_seq = package_content_seq;
           this.date_stamp = date_stamp;
           this.order_item_type = order_item_type;
           this.order_date = order_date;
           this.order_qty = order_qty;
           this.gross_base_amount = gross_base_amount;
           this.gross_local_amount = gross_local_amount;
           this.net_base_amount = net_base_amount;
           this.net_local_amount = net_local_amount;
           this.has_tax = has_tax;
           this.has_delivery_charge = has_delivery_charge;
           this.bill_date = bill_date;
           this.n_inv_efforts = n_inv_efforts;
           this.last_inv_date = last_inv_date;
           this.payment_status = payment_status;
           this.refund_status = refund_status;
           this.order_type = order_type;
           this.billing_type = billing_type;
           this.has_premium = has_premium;
           this.prepayment_req = prepayment_req;
           this.product_id = product_id;
           this.ship_qty = ship_qty;
           this.backord_qty = backord_qty;
           this.subscrip_id = subscrip_id;
           this.bundle_qty = bundle_qty;
           this.audit_qual_category = audit_qual_category;
           this.is_complimentary = is_complimentary;
           this.subscrip_start_type = subscrip_start_type;
           this.order_code_id = order_code_id;
           this.cancel_reason = cancel_reason;
           this.customer_group_id = customer_group_id;
           this.audit_qual_source_id = audit_qual_source_id;
           this.audit_subscription_type_id = audit_subscription_type_id;
           this.percent_of_basic_price = percent_of_basic_price;
           this.duration = duration;
           this.renewal_status = renewal_status;
           this.delivery_method_perm = delivery_method_perm;
           this.change_qty_flag = change_qty_flag;
           this.n_issues_left = n_issues_left;
           this.n_ren_effort = n_ren_effort;
           this.last_ren_date = last_ren_date;
           this.n_del_iss_left = n_del_iss_left;
           this.n_remaining_paid_issues = n_remaining_paid_issues;
           this.ext_iss_left = ext_iss_left;
           this.ext_iss_tot = ext_iss_tot;
           this.audit_name_title_id = audit_name_title_id;
           this.audit_sales_channel_id = audit_sales_channel_id;
           this.qual_date = qual_date;
           this.squal_date = squal_date;
           this.order_status = order_status;
           this.cancel_date = cancel_date;
           this.pub_rotation_id = pub_rotation_id;
           this.renewal_category = renewal_category;
           this.exchange_rate = exchange_rate;
           this.prem_to_order_item_seq = prem_to_order_item_seq;
           this.renewal_orderhdr_id = renewal_orderhdr_id;
           this.renewal_order_item_seq = renewal_order_item_seq;
           this.subscription_def_id = subscription_def_id;
           this.rate_class_id = rate_class_id;
           this.rate_class_effective_seq = rate_class_effective_seq;
           this.ratecard_seq = ratecard_seq;
           this.discount_class_id = discount_class_id;
           this.disc_class_effective_seq = disc_class_effective_seq;
           this.discount_card_seq = discount_card_seq;
           this.inventory_id = inventory_id;
           this.oc_id = oc_id;
           this.installment_plan_id = installment_plan_id;
           this.auto_payment = auto_payment;
           this.perpetual_order = perpetual_order;
           this.agency_customer_id = agency_customer_id;
           this.bill_to_customer_id = bill_to_customer_id;
           this.bill_to_customer_address_seq = bill_to_customer_address_seq;
           this.renew_to_customer_id = renew_to_customer_id;
           this.renew_to_customer_address_seq = renew_to_customer_address_seq;
           this.start_issue_id = start_issue_id;
           this.stop_issue_id = stop_issue_id;
           this.single_issue_id = single_issue_id;
           this.customer_id = customer_id;
           this.customer_address_seq = customer_address_seq;
           this.note_exist = note_exist;
           this.service_exist = service_exist;
           this.number_volume_sets = number_volume_sets;
           this.alt_ship_customer_id = alt_ship_customer_id;
           this.alt_ship_customer_address_seq = alt_ship_customer_address_seq;
           this.alt_ship_del_calc = alt_ship_del_calc;
           this.distribution_method = distribution_method;
           this.billing_def = billing_def;
           this.billing_def_test_seq = billing_def_test_seq;
           this.renewal_def = renewal_def;
           this.renewal_def_test_seq = renewal_def_test_seq;
           this.agent_ref_nbr = agent_ref_nbr;
           this.has_been_renewed = has_been_renewed;
           this.revenue_method = revenue_method;
           this.start_date = start_date;
           this.expire_date = expire_date;
           this.electronic_document_identifier = electronic_document_identifier;
           this.package_instance = package_instance;
           this.unit_type_id = unit_type_id;
           this.ex_rate_class_id = ex_rate_class_id;
           this.ex_rate_class_effective_seq = ex_rate_class_effective_seq;
           this.ex_ratecard_seq = ex_ratecard_seq;
           this.trial_period = trial_period;
           this.trial_type = trial_type;
           this.orig_order_qty = orig_order_qty;
           this.unit_excess = unit_excess;
           this.manual_disc_amt_local = manual_disc_amt_local;
           this.manual_disc_amt_base = manual_disc_amt_base;
           this.manual_disc_percentage = manual_disc_percentage;
           this.n_nonpaid_issues = n_nonpaid_issues;
           this.n_remaining_nonpaid_issues = n_remaining_nonpaid_issues;
           this.n_cal_units_per_seg = n_cal_units_per_seg;
           this.segment_expire_date = segment_expire_date;
           this.calendar_unit = calendar_unit;
           this.n_items_per_seg = n_items_per_seg;
           this.n_segments_left = n_segments_left;
           this.is_proforma = is_proforma;
           this.n_tax_updates = n_tax_updates;
           this.total_tax_local_amount = total_tax_local_amount;
           this.total_tax_base_amount = total_tax_base_amount;
           this.renewed_from_subscrip_id = renewed_from_subscrip_id;
           this.pkg_item_seq = pkg_item_seq;
           this.pkg_def_id = pkg_def_id;
           this.electronic_delivery = electronic_delivery;
           this.item_url = item_url;
           this.payment_account_seq = payment_account_seq;
           this.time_unit_options = time_unit_options;
           this.max_check_out_amt = max_check_out_amt;
           this.n_checked_out = n_checked_out;
           this.group_order = group_order;
           this.deal_id = deal_id;
           this.invoice_id = invoice_id;
           this.invoice_date = invoice_date;
           this.fulfillment_date = fulfillment_date;
           this.auto_renew_notify_sent = auto_renew_notify_sent;
           this.multiline_discount_schedule = multiline_discount_schedule;
           this.multiline_disc_amount = multiline_disc_amount;
           this.extended_days = extended_days;
           this.asynchronous_auto_renew = asynchronous_auto_renew;
           this.n_days_graced = n_days_graced;
           this.shipping_price_list = shipping_price_list;
           this.extended_rate = extended_rate;
           this.is_back_ordered = is_back_ordered;
           this.multiline_disc_eff_seq = multiline_disc_eff_seq;
           this.attach_exist = attach_exist;
           this.addon_to_orderhdr_id = addon_to_orderhdr_id;
           this.addon_to_order_item_seq = addon_to_order_item_seq;
           this.generic_promotion_code_seq = generic_promotion_code_seq;
           this.charge_on_cancellation = charge_on_cancellation;
           this.last_tax_invoice_date = last_tax_invoice_date;
           this.description = description;
           this.p_payment_account_seq = p_payment_account_seq;
    }


    /**
     * Gets the orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the user_code value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the currency value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the delivery_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return delivery_method
     */
    public java.lang.String getDelivery_method() {
        return delivery_method;
    }


    /**
     * Sets the delivery_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param delivery_method
     */
    public void setDelivery_method(java.lang.String delivery_method) {
        this.delivery_method = delivery_method;
    }


    /**
     * Gets the source_code_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the order_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_category
     */
    public java.lang.String getOrder_category() {
        return order_category;
    }


    /**
     * Sets the order_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_category
     */
    public void setOrder_category(java.lang.String order_category) {
        this.order_category = order_category;
    }


    /**
     * Gets the package_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return package_id
     */
    public int getPackage_id() {
        return package_id;
    }


    /**
     * Sets the package_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param package_id
     */
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }


    /**
     * Gets the package_content_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return package_content_seq
     */
    public int getPackage_content_seq() {
        return package_content_seq;
    }


    /**
     * Sets the package_content_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param package_content_seq
     */
    public void setPackage_content_seq(int package_content_seq) {
        this.package_content_seq = package_content_seq;
    }


    /**
     * Gets the date_stamp value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return date_stamp
     */
    public int getDate_stamp() {
        return date_stamp;
    }


    /**
     * Sets the date_stamp value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param date_stamp
     */
    public void setDate_stamp(int date_stamp) {
        this.date_stamp = date_stamp;
    }


    /**
     * Gets the order_item_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_item_type
     */
    public int getOrder_item_type() {
        return order_item_type;
    }


    /**
     * Sets the order_item_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_item_type
     */
    public void setOrder_item_type(int order_item_type) {
        this.order_item_type = order_item_type;
    }


    /**
     * Gets the order_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_date
     */
    public java.util.Date getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Date order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the order_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_qty
     */
    public int getOrder_qty() {
        return order_qty;
    }


    /**
     * Sets the order_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_qty
     */
    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }


    /**
     * Gets the gross_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return gross_base_amount
     */
    public java.math.BigDecimal getGross_base_amount() {
        return gross_base_amount;
    }


    /**
     * Sets the gross_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param gross_base_amount
     */
    public void setGross_base_amount(java.math.BigDecimal gross_base_amount) {
        this.gross_base_amount = gross_base_amount;
    }


    /**
     * Gets the gross_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return gross_local_amount
     */
    public java.math.BigDecimal getGross_local_amount() {
        return gross_local_amount;
    }


    /**
     * Sets the gross_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param gross_local_amount
     */
    public void setGross_local_amount(java.math.BigDecimal gross_local_amount) {
        this.gross_local_amount = gross_local_amount;
    }


    /**
     * Gets the net_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return net_base_amount
     */
    public java.math.BigDecimal getNet_base_amount() {
        return net_base_amount;
    }


    /**
     * Sets the net_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param net_base_amount
     */
    public void setNet_base_amount(java.math.BigDecimal net_base_amount) {
        this.net_base_amount = net_base_amount;
    }


    /**
     * Gets the net_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return net_local_amount
     */
    public java.math.BigDecimal getNet_local_amount() {
        return net_local_amount;
    }


    /**
     * Sets the net_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param net_local_amount
     */
    public void setNet_local_amount(java.math.BigDecimal net_local_amount) {
        this.net_local_amount = net_local_amount;
    }


    /**
     * Gets the has_tax value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return has_tax
     */
    public int getHas_tax() {
        return has_tax;
    }


    /**
     * Sets the has_tax value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param has_tax
     */
    public void setHas_tax(int has_tax) {
        this.has_tax = has_tax;
    }


    /**
     * Gets the has_delivery_charge value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return has_delivery_charge
     */
    public int getHas_delivery_charge() {
        return has_delivery_charge;
    }


    /**
     * Sets the has_delivery_charge value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param has_delivery_charge
     */
    public void setHas_delivery_charge(int has_delivery_charge) {
        this.has_delivery_charge = has_delivery_charge;
    }


    /**
     * Gets the bill_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return bill_date
     */
    public java.util.Date getBill_date() {
        return bill_date;
    }


    /**
     * Sets the bill_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param bill_date
     */
    public void setBill_date(java.util.Date bill_date) {
        this.bill_date = bill_date;
    }


    /**
     * Gets the n_inv_efforts value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_inv_efforts
     */
    public int getN_inv_efforts() {
        return n_inv_efforts;
    }


    /**
     * Sets the n_inv_efforts value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_inv_efforts
     */
    public void setN_inv_efforts(int n_inv_efforts) {
        this.n_inv_efforts = n_inv_efforts;
    }


    /**
     * Gets the last_inv_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return last_inv_date
     */
    public java.util.Date getLast_inv_date() {
        return last_inv_date;
    }


    /**
     * Sets the last_inv_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param last_inv_date
     */
    public void setLast_inv_date(java.util.Date last_inv_date) {
        this.last_inv_date = last_inv_date;
    }


    /**
     * Gets the payment_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return payment_status
     */
    public int getPayment_status() {
        return payment_status;
    }


    /**
     * Sets the payment_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param payment_status
     */
    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }


    /**
     * Gets the refund_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return refund_status
     */
    public int getRefund_status() {
        return refund_status;
    }


    /**
     * Sets the refund_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param refund_status
     */
    public void setRefund_status(int refund_status) {
        this.refund_status = refund_status;
    }


    /**
     * Gets the order_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_type
     */
    public int getOrder_type() {
        return order_type;
    }


    /**
     * Sets the order_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_type
     */
    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }


    /**
     * Gets the billing_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return billing_type
     */
    public int getBilling_type() {
        return billing_type;
    }


    /**
     * Sets the billing_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param billing_type
     */
    public void setBilling_type(int billing_type) {
        this.billing_type = billing_type;
    }


    /**
     * Gets the has_premium value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return has_premium
     */
    public int getHas_premium() {
        return has_premium;
    }


    /**
     * Sets the has_premium value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param has_premium
     */
    public void setHas_premium(int has_premium) {
        this.has_premium = has_premium;
    }


    /**
     * Gets the prepayment_req value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return prepayment_req
     */
    public int getPrepayment_req() {
        return prepayment_req;
    }


    /**
     * Sets the prepayment_req value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param prepayment_req
     */
    public void setPrepayment_req(int prepayment_req) {
        this.prepayment_req = prepayment_req;
    }


    /**
     * Gets the product_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the ship_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ship_qty
     */
    public int getShip_qty() {
        return ship_qty;
    }


    /**
     * Sets the ship_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ship_qty
     */
    public void setShip_qty(int ship_qty) {
        this.ship_qty = ship_qty;
    }


    /**
     * Gets the backord_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return backord_qty
     */
    public int getBackord_qty() {
        return backord_qty;
    }


    /**
     * Sets the backord_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param backord_qty
     */
    public void setBackord_qty(int backord_qty) {
        this.backord_qty = backord_qty;
    }


    /**
     * Gets the subscrip_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the bundle_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return bundle_qty
     */
    public int getBundle_qty() {
        return bundle_qty;
    }


    /**
     * Sets the bundle_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param bundle_qty
     */
    public void setBundle_qty(int bundle_qty) {
        this.bundle_qty = bundle_qty;
    }


    /**
     * Gets the audit_qual_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return audit_qual_category
     */
    public int getAudit_qual_category() {
        return audit_qual_category;
    }


    /**
     * Sets the audit_qual_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param audit_qual_category
     */
    public void setAudit_qual_category(int audit_qual_category) {
        this.audit_qual_category = audit_qual_category;
    }


    /**
     * Gets the is_complimentary value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return is_complimentary
     */
    public int getIs_complimentary() {
        return is_complimentary;
    }


    /**
     * Sets the is_complimentary value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param is_complimentary
     */
    public void setIs_complimentary(int is_complimentary) {
        this.is_complimentary = is_complimentary;
    }


    /**
     * Gets the subscrip_start_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return subscrip_start_type
     */
    public int getSubscrip_start_type() {
        return subscrip_start_type;
    }


    /**
     * Sets the subscrip_start_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param subscrip_start_type
     */
    public void setSubscrip_start_type(int subscrip_start_type) {
        this.subscrip_start_type = subscrip_start_type;
    }


    /**
     * Gets the order_code_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the cancel_reason value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return cancel_reason
     */
    public java.lang.String getCancel_reason() {
        return cancel_reason;
    }


    /**
     * Sets the cancel_reason value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param cancel_reason
     */
    public void setCancel_reason(java.lang.String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }


    /**
     * Gets the customer_group_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return customer_group_id
     */
    public int getCustomer_group_id() {
        return customer_group_id;
    }


    /**
     * Sets the customer_group_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param customer_group_id
     */
    public void setCustomer_group_id(int customer_group_id) {
        this.customer_group_id = customer_group_id;
    }


    /**
     * Gets the audit_qual_source_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return audit_qual_source_id
     */
    public int getAudit_qual_source_id() {
        return audit_qual_source_id;
    }


    /**
     * Sets the audit_qual_source_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param audit_qual_source_id
     */
    public void setAudit_qual_source_id(int audit_qual_source_id) {
        this.audit_qual_source_id = audit_qual_source_id;
    }


    /**
     * Gets the audit_subscription_type_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return audit_subscription_type_id
     */
    public int getAudit_subscription_type_id() {
        return audit_subscription_type_id;
    }


    /**
     * Sets the audit_subscription_type_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param audit_subscription_type_id
     */
    public void setAudit_subscription_type_id(int audit_subscription_type_id) {
        this.audit_subscription_type_id = audit_subscription_type_id;
    }


    /**
     * Gets the percent_of_basic_price value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return percent_of_basic_price
     */
    public int getPercent_of_basic_price() {
        return percent_of_basic_price;
    }


    /**
     * Sets the percent_of_basic_price value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param percent_of_basic_price
     */
    public void setPercent_of_basic_price(int percent_of_basic_price) {
        this.percent_of_basic_price = percent_of_basic_price;
    }


    /**
     * Gets the duration value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the renewal_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_status
     */
    public int getRenewal_status() {
        return renewal_status;
    }


    /**
     * Sets the renewal_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_status
     */
    public void setRenewal_status(int renewal_status) {
        this.renewal_status = renewal_status;
    }


    /**
     * Gets the delivery_method_perm value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return delivery_method_perm
     */
    public int getDelivery_method_perm() {
        return delivery_method_perm;
    }


    /**
     * Sets the delivery_method_perm value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param delivery_method_perm
     */
    public void setDelivery_method_perm(int delivery_method_perm) {
        this.delivery_method_perm = delivery_method_perm;
    }


    /**
     * Gets the change_qty_flag value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return change_qty_flag
     */
    public int getChange_qty_flag() {
        return change_qty_flag;
    }


    /**
     * Sets the change_qty_flag value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param change_qty_flag
     */
    public void setChange_qty_flag(int change_qty_flag) {
        this.change_qty_flag = change_qty_flag;
    }


    /**
     * Gets the n_issues_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_issues_left
     */
    public int getN_issues_left() {
        return n_issues_left;
    }


    /**
     * Sets the n_issues_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_issues_left
     */
    public void setN_issues_left(int n_issues_left) {
        this.n_issues_left = n_issues_left;
    }


    /**
     * Gets the n_ren_effort value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_ren_effort
     */
    public int getN_ren_effort() {
        return n_ren_effort;
    }


    /**
     * Sets the n_ren_effort value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_ren_effort
     */
    public void setN_ren_effort(int n_ren_effort) {
        this.n_ren_effort = n_ren_effort;
    }


    /**
     * Gets the last_ren_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return last_ren_date
     */
    public java.util.Date getLast_ren_date() {
        return last_ren_date;
    }


    /**
     * Sets the last_ren_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param last_ren_date
     */
    public void setLast_ren_date(java.util.Date last_ren_date) {
        this.last_ren_date = last_ren_date;
    }


    /**
     * Gets the n_del_iss_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_del_iss_left
     */
    public int getN_del_iss_left() {
        return n_del_iss_left;
    }


    /**
     * Sets the n_del_iss_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_del_iss_left
     */
    public void setN_del_iss_left(int n_del_iss_left) {
        this.n_del_iss_left = n_del_iss_left;
    }


    /**
     * Gets the n_remaining_paid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_remaining_paid_issues
     */
    public int getN_remaining_paid_issues() {
        return n_remaining_paid_issues;
    }


    /**
     * Sets the n_remaining_paid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_remaining_paid_issues
     */
    public void setN_remaining_paid_issues(int n_remaining_paid_issues) {
        this.n_remaining_paid_issues = n_remaining_paid_issues;
    }


    /**
     * Gets the ext_iss_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ext_iss_left
     */
    public int getExt_iss_left() {
        return ext_iss_left;
    }


    /**
     * Sets the ext_iss_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ext_iss_left
     */
    public void setExt_iss_left(int ext_iss_left) {
        this.ext_iss_left = ext_iss_left;
    }


    /**
     * Gets the ext_iss_tot value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ext_iss_tot
     */
    public int getExt_iss_tot() {
        return ext_iss_tot;
    }


    /**
     * Sets the ext_iss_tot value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ext_iss_tot
     */
    public void setExt_iss_tot(int ext_iss_tot) {
        this.ext_iss_tot = ext_iss_tot;
    }


    /**
     * Gets the audit_name_title_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return audit_name_title_id
     */
    public int getAudit_name_title_id() {
        return audit_name_title_id;
    }


    /**
     * Sets the audit_name_title_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param audit_name_title_id
     */
    public void setAudit_name_title_id(int audit_name_title_id) {
        this.audit_name_title_id = audit_name_title_id;
    }


    /**
     * Gets the audit_sales_channel_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return audit_sales_channel_id
     */
    public int getAudit_sales_channel_id() {
        return audit_sales_channel_id;
    }


    /**
     * Sets the audit_sales_channel_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param audit_sales_channel_id
     */
    public void setAudit_sales_channel_id(int audit_sales_channel_id) {
        this.audit_sales_channel_id = audit_sales_channel_id;
    }


    /**
     * Gets the qual_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return qual_date
     */
    public java.util.Date getQual_date() {
        return qual_date;
    }


    /**
     * Sets the qual_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param qual_date
     */
    public void setQual_date(java.util.Date qual_date) {
        this.qual_date = qual_date;
    }


    /**
     * Gets the squal_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return squal_date
     */
    public java.util.Date getSqual_date() {
        return squal_date;
    }


    /**
     * Sets the squal_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param squal_date
     */
    public void setSqual_date(java.util.Date squal_date) {
        this.squal_date = squal_date;
    }


    /**
     * Gets the order_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return order_status
     */
    public int getOrder_status() {
        return order_status;
    }


    /**
     * Sets the order_status value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param order_status
     */
    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }


    /**
     * Gets the cancel_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return cancel_date
     */
    public java.util.Date getCancel_date() {
        return cancel_date;
    }


    /**
     * Sets the cancel_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param cancel_date
     */
    public void setCancel_date(java.util.Date cancel_date) {
        this.cancel_date = cancel_date;
    }


    /**
     * Gets the pub_rotation_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return pub_rotation_id
     */
    public int getPub_rotation_id() {
        return pub_rotation_id;
    }


    /**
     * Sets the pub_rotation_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param pub_rotation_id
     */
    public void setPub_rotation_id(int pub_rotation_id) {
        this.pub_rotation_id = pub_rotation_id;
    }


    /**
     * Gets the renewal_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_category
     */
    public int getRenewal_category() {
        return renewal_category;
    }


    /**
     * Sets the renewal_category value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_category
     */
    public void setRenewal_category(int renewal_category) {
        this.renewal_category = renewal_category;
    }


    /**
     * Gets the exchange_rate value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return exchange_rate
     */
    public java.math.BigDecimal getExchange_rate() {
        return exchange_rate;
    }


    /**
     * Sets the exchange_rate value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param exchange_rate
     */
    public void setExchange_rate(java.math.BigDecimal exchange_rate) {
        this.exchange_rate = exchange_rate;
    }


    /**
     * Gets the prem_to_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return prem_to_order_item_seq
     */
    public int getPrem_to_order_item_seq() {
        return prem_to_order_item_seq;
    }


    /**
     * Sets the prem_to_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param prem_to_order_item_seq
     */
    public void setPrem_to_order_item_seq(int prem_to_order_item_seq) {
        this.prem_to_order_item_seq = prem_to_order_item_seq;
    }


    /**
     * Gets the renewal_orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_orderhdr_id
     */
    public int getRenewal_orderhdr_id() {
        return renewal_orderhdr_id;
    }


    /**
     * Sets the renewal_orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_orderhdr_id
     */
    public void setRenewal_orderhdr_id(int renewal_orderhdr_id) {
        this.renewal_orderhdr_id = renewal_orderhdr_id;
    }


    /**
     * Gets the renewal_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_order_item_seq
     */
    public int getRenewal_order_item_seq() {
        return renewal_order_item_seq;
    }


    /**
     * Sets the renewal_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_order_item_seq
     */
    public void setRenewal_order_item_seq(int renewal_order_item_seq) {
        this.renewal_order_item_seq = renewal_order_item_seq;
    }


    /**
     * Gets the subscription_def_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return subscription_def_id
     */
    public int getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(int subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the rate_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return rate_class_id
     */
    public int getRate_class_id() {
        return rate_class_id;
    }


    /**
     * Sets the rate_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param rate_class_id
     */
    public void setRate_class_id(int rate_class_id) {
        this.rate_class_id = rate_class_id;
    }


    /**
     * Gets the rate_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return rate_class_effective_seq
     */
    public int getRate_class_effective_seq() {
        return rate_class_effective_seq;
    }


    /**
     * Sets the rate_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param rate_class_effective_seq
     */
    public void setRate_class_effective_seq(int rate_class_effective_seq) {
        this.rate_class_effective_seq = rate_class_effective_seq;
    }


    /**
     * Gets the ratecard_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ratecard_seq
     */
    public int getRatecard_seq() {
        return ratecard_seq;
    }


    /**
     * Sets the ratecard_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ratecard_seq
     */
    public void setRatecard_seq(int ratecard_seq) {
        this.ratecard_seq = ratecard_seq;
    }


    /**
     * Gets the discount_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return discount_class_id
     */
    public int getDiscount_class_id() {
        return discount_class_id;
    }


    /**
     * Sets the discount_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param discount_class_id
     */
    public void setDiscount_class_id(int discount_class_id) {
        this.discount_class_id = discount_class_id;
    }


    /**
     * Gets the disc_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return disc_class_effective_seq
     */
    public int getDisc_class_effective_seq() {
        return disc_class_effective_seq;
    }


    /**
     * Sets the disc_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param disc_class_effective_seq
     */
    public void setDisc_class_effective_seq(int disc_class_effective_seq) {
        this.disc_class_effective_seq = disc_class_effective_seq;
    }


    /**
     * Gets the discount_card_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return discount_card_seq
     */
    public int getDiscount_card_seq() {
        return discount_card_seq;
    }


    /**
     * Sets the discount_card_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param discount_card_seq
     */
    public void setDiscount_card_seq(int discount_card_seq) {
        this.discount_card_seq = discount_card_seq;
    }


    /**
     * Gets the inventory_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }


    /**
     * Sets the inventory_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param inventory_id
     */
    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }


    /**
     * Gets the oc_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the installment_plan_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return installment_plan_id
     */
    public int getInstallment_plan_id() {
        return installment_plan_id;
    }


    /**
     * Sets the installment_plan_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param installment_plan_id
     */
    public void setInstallment_plan_id(int installment_plan_id) {
        this.installment_plan_id = installment_plan_id;
    }


    /**
     * Gets the auto_payment value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return auto_payment
     */
    public int getAuto_payment() {
        return auto_payment;
    }


    /**
     * Sets the auto_payment value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param auto_payment
     */
    public void setAuto_payment(int auto_payment) {
        this.auto_payment = auto_payment;
    }


    /**
     * Gets the perpetual_order value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return perpetual_order
     */
    public int getPerpetual_order() {
        return perpetual_order;
    }


    /**
     * Sets the perpetual_order value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param perpetual_order
     */
    public void setPerpetual_order(int perpetual_order) {
        this.perpetual_order = perpetual_order;
    }


    /**
     * Gets the agency_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return agency_customer_id
     */
    public int getAgency_customer_id() {
        return agency_customer_id;
    }


    /**
     * Sets the agency_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param agency_customer_id
     */
    public void setAgency_customer_id(int agency_customer_id) {
        this.agency_customer_id = agency_customer_id;
    }


    /**
     * Gets the bill_to_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return bill_to_customer_id
     */
    public int getBill_to_customer_id() {
        return bill_to_customer_id;
    }


    /**
     * Sets the bill_to_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param bill_to_customer_id
     */
    public void setBill_to_customer_id(int bill_to_customer_id) {
        this.bill_to_customer_id = bill_to_customer_id;
    }


    /**
     * Gets the bill_to_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return bill_to_customer_address_seq
     */
    public int getBill_to_customer_address_seq() {
        return bill_to_customer_address_seq;
    }


    /**
     * Sets the bill_to_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param bill_to_customer_address_seq
     */
    public void setBill_to_customer_address_seq(int bill_to_customer_address_seq) {
        this.bill_to_customer_address_seq = bill_to_customer_address_seq;
    }


    /**
     * Gets the renew_to_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renew_to_customer_id
     */
    public int getRenew_to_customer_id() {
        return renew_to_customer_id;
    }


    /**
     * Sets the renew_to_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renew_to_customer_id
     */
    public void setRenew_to_customer_id(int renew_to_customer_id) {
        this.renew_to_customer_id = renew_to_customer_id;
    }


    /**
     * Gets the renew_to_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renew_to_customer_address_seq
     */
    public int getRenew_to_customer_address_seq() {
        return renew_to_customer_address_seq;
    }


    /**
     * Sets the renew_to_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renew_to_customer_address_seq
     */
    public void setRenew_to_customer_address_seq(int renew_to_customer_address_seq) {
        this.renew_to_customer_address_seq = renew_to_customer_address_seq;
    }


    /**
     * Gets the start_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return start_issue_id
     */
    public int getStart_issue_id() {
        return start_issue_id;
    }


    /**
     * Sets the start_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param start_issue_id
     */
    public void setStart_issue_id(int start_issue_id) {
        this.start_issue_id = start_issue_id;
    }


    /**
     * Gets the stop_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return stop_issue_id
     */
    public int getStop_issue_id() {
        return stop_issue_id;
    }


    /**
     * Sets the stop_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param stop_issue_id
     */
    public void setStop_issue_id(int stop_issue_id) {
        this.stop_issue_id = stop_issue_id;
    }


    /**
     * Gets the single_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return single_issue_id
     */
    public int getSingle_issue_id() {
        return single_issue_id;
    }


    /**
     * Sets the single_issue_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param single_issue_id
     */
    public void setSingle_issue_id(int single_issue_id) {
        this.single_issue_id = single_issue_id;
    }


    /**
     * Gets the customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the note_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return note_exist
     */
    public int getNote_exist() {
        return note_exist;
    }


    /**
     * Sets the note_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param note_exist
     */
    public void setNote_exist(int note_exist) {
        this.note_exist = note_exist;
    }


    /**
     * Gets the service_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return service_exist
     */
    public int getService_exist() {
        return service_exist;
    }


    /**
     * Sets the service_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param service_exist
     */
    public void setService_exist(int service_exist) {
        this.service_exist = service_exist;
    }


    /**
     * Gets the number_volume_sets value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return number_volume_sets
     */
    public int getNumber_volume_sets() {
        return number_volume_sets;
    }


    /**
     * Sets the number_volume_sets value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param number_volume_sets
     */
    public void setNumber_volume_sets(int number_volume_sets) {
        this.number_volume_sets = number_volume_sets;
    }


    /**
     * Gets the alt_ship_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return alt_ship_customer_id
     */
    public int getAlt_ship_customer_id() {
        return alt_ship_customer_id;
    }


    /**
     * Sets the alt_ship_customer_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param alt_ship_customer_id
     */
    public void setAlt_ship_customer_id(int alt_ship_customer_id) {
        this.alt_ship_customer_id = alt_ship_customer_id;
    }


    /**
     * Gets the alt_ship_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return alt_ship_customer_address_seq
     */
    public int getAlt_ship_customer_address_seq() {
        return alt_ship_customer_address_seq;
    }


    /**
     * Sets the alt_ship_customer_address_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param alt_ship_customer_address_seq
     */
    public void setAlt_ship_customer_address_seq(int alt_ship_customer_address_seq) {
        this.alt_ship_customer_address_seq = alt_ship_customer_address_seq;
    }


    /**
     * Gets the alt_ship_del_calc value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return alt_ship_del_calc
     */
    public int getAlt_ship_del_calc() {
        return alt_ship_del_calc;
    }


    /**
     * Sets the alt_ship_del_calc value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param alt_ship_del_calc
     */
    public void setAlt_ship_del_calc(int alt_ship_del_calc) {
        this.alt_ship_del_calc = alt_ship_del_calc;
    }


    /**
     * Gets the distribution_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return distribution_method
     */
    public java.lang.String getDistribution_method() {
        return distribution_method;
    }


    /**
     * Sets the distribution_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param distribution_method
     */
    public void setDistribution_method(java.lang.String distribution_method) {
        this.distribution_method = distribution_method;
    }


    /**
     * Gets the billing_def value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return billing_def
     */
    public java.lang.String getBilling_def() {
        return billing_def;
    }


    /**
     * Sets the billing_def value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param billing_def
     */
    public void setBilling_def(java.lang.String billing_def) {
        this.billing_def = billing_def;
    }


    /**
     * Gets the billing_def_test_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return billing_def_test_seq
     */
    public int getBilling_def_test_seq() {
        return billing_def_test_seq;
    }


    /**
     * Sets the billing_def_test_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param billing_def_test_seq
     */
    public void setBilling_def_test_seq(int billing_def_test_seq) {
        this.billing_def_test_seq = billing_def_test_seq;
    }


    /**
     * Gets the renewal_def value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_def
     */
    public java.lang.String getRenewal_def() {
        return renewal_def;
    }


    /**
     * Sets the renewal_def value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_def
     */
    public void setRenewal_def(java.lang.String renewal_def) {
        this.renewal_def = renewal_def;
    }


    /**
     * Gets the renewal_def_test_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewal_def_test_seq
     */
    public int getRenewal_def_test_seq() {
        return renewal_def_test_seq;
    }


    /**
     * Sets the renewal_def_test_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewal_def_test_seq
     */
    public void setRenewal_def_test_seq(int renewal_def_test_seq) {
        this.renewal_def_test_seq = renewal_def_test_seq;
    }


    /**
     * Gets the agent_ref_nbr value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return agent_ref_nbr
     */
    public java.lang.String getAgent_ref_nbr() {
        return agent_ref_nbr;
    }


    /**
     * Sets the agent_ref_nbr value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param agent_ref_nbr
     */
    public void setAgent_ref_nbr(java.lang.String agent_ref_nbr) {
        this.agent_ref_nbr = agent_ref_nbr;
    }


    /**
     * Gets the has_been_renewed value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return has_been_renewed
     */
    public int getHas_been_renewed() {
        return has_been_renewed;
    }


    /**
     * Sets the has_been_renewed value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param has_been_renewed
     */
    public void setHas_been_renewed(int has_been_renewed) {
        this.has_been_renewed = has_been_renewed;
    }


    /**
     * Gets the revenue_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return revenue_method
     */
    public int getRevenue_method() {
        return revenue_method;
    }


    /**
     * Sets the revenue_method value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param revenue_method
     */
    public void setRevenue_method(int revenue_method) {
        this.revenue_method = revenue_method;
    }


    /**
     * Gets the start_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return start_date
     */
    public java.util.Date getStart_date() {
        return start_date;
    }


    /**
     * Sets the start_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param start_date
     */
    public void setStart_date(java.util.Date start_date) {
        this.start_date = start_date;
    }


    /**
     * Gets the expire_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return expire_date
     */
    public java.util.Date getExpire_date() {
        return expire_date;
    }


    /**
     * Sets the expire_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param expire_date
     */
    public void setExpire_date(java.util.Date expire_date) {
        this.expire_date = expire_date;
    }


    /**
     * Gets the electronic_document_identifier value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return electronic_document_identifier
     */
    public java.lang.String getElectronic_document_identifier() {
        return electronic_document_identifier;
    }


    /**
     * Sets the electronic_document_identifier value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param electronic_document_identifier
     */
    public void setElectronic_document_identifier(java.lang.String electronic_document_identifier) {
        this.electronic_document_identifier = electronic_document_identifier;
    }


    /**
     * Gets the package_instance value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return package_instance
     */
    public int getPackage_instance() {
        return package_instance;
    }


    /**
     * Sets the package_instance value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param package_instance
     */
    public void setPackage_instance(int package_instance) {
        this.package_instance = package_instance;
    }


    /**
     * Gets the unit_type_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return unit_type_id
     */
    public int getUnit_type_id() {
        return unit_type_id;
    }


    /**
     * Sets the unit_type_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param unit_type_id
     */
    public void setUnit_type_id(int unit_type_id) {
        this.unit_type_id = unit_type_id;
    }


    /**
     * Gets the ex_rate_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ex_rate_class_id
     */
    public int getEx_rate_class_id() {
        return ex_rate_class_id;
    }


    /**
     * Sets the ex_rate_class_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ex_rate_class_id
     */
    public void setEx_rate_class_id(int ex_rate_class_id) {
        this.ex_rate_class_id = ex_rate_class_id;
    }


    /**
     * Gets the ex_rate_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ex_rate_class_effective_seq
     */
    public int getEx_rate_class_effective_seq() {
        return ex_rate_class_effective_seq;
    }


    /**
     * Sets the ex_rate_class_effective_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ex_rate_class_effective_seq
     */
    public void setEx_rate_class_effective_seq(int ex_rate_class_effective_seq) {
        this.ex_rate_class_effective_seq = ex_rate_class_effective_seq;
    }


    /**
     * Gets the ex_ratecard_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return ex_ratecard_seq
     */
    public int getEx_ratecard_seq() {
        return ex_ratecard_seq;
    }


    /**
     * Sets the ex_ratecard_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param ex_ratecard_seq
     */
    public void setEx_ratecard_seq(int ex_ratecard_seq) {
        this.ex_ratecard_seq = ex_ratecard_seq;
    }


    /**
     * Gets the trial_period value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return trial_period
     */
    public int getTrial_period() {
        return trial_period;
    }


    /**
     * Sets the trial_period value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param trial_period
     */
    public void setTrial_period(int trial_period) {
        this.trial_period = trial_period;
    }


    /**
     * Gets the trial_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return trial_type
     */
    public int getTrial_type() {
        return trial_type;
    }


    /**
     * Sets the trial_type value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param trial_type
     */
    public void setTrial_type(int trial_type) {
        this.trial_type = trial_type;
    }


    /**
     * Gets the orig_order_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return orig_order_qty
     */
    public int getOrig_order_qty() {
        return orig_order_qty;
    }


    /**
     * Sets the orig_order_qty value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param orig_order_qty
     */
    public void setOrig_order_qty(int orig_order_qty) {
        this.orig_order_qty = orig_order_qty;
    }


    /**
     * Gets the unit_excess value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return unit_excess
     */
    public int getUnit_excess() {
        return unit_excess;
    }


    /**
     * Sets the unit_excess value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param unit_excess
     */
    public void setUnit_excess(int unit_excess) {
        this.unit_excess = unit_excess;
    }


    /**
     * Gets the manual_disc_amt_local value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return manual_disc_amt_local
     */
    public java.math.BigDecimal getManual_disc_amt_local() {
        return manual_disc_amt_local;
    }


    /**
     * Sets the manual_disc_amt_local value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param manual_disc_amt_local
     */
    public void setManual_disc_amt_local(java.math.BigDecimal manual_disc_amt_local) {
        this.manual_disc_amt_local = manual_disc_amt_local;
    }


    /**
     * Gets the manual_disc_amt_base value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return manual_disc_amt_base
     */
    public java.math.BigDecimal getManual_disc_amt_base() {
        return manual_disc_amt_base;
    }


    /**
     * Sets the manual_disc_amt_base value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param manual_disc_amt_base
     */
    public void setManual_disc_amt_base(java.math.BigDecimal manual_disc_amt_base) {
        this.manual_disc_amt_base = manual_disc_amt_base;
    }


    /**
     * Gets the manual_disc_percentage value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return manual_disc_percentage
     */
    public java.math.BigDecimal getManual_disc_percentage() {
        return manual_disc_percentage;
    }


    /**
     * Sets the manual_disc_percentage value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param manual_disc_percentage
     */
    public void setManual_disc_percentage(java.math.BigDecimal manual_disc_percentage) {
        this.manual_disc_percentage = manual_disc_percentage;
    }


    /**
     * Gets the n_nonpaid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_nonpaid_issues
     */
    public int getN_nonpaid_issues() {
        return n_nonpaid_issues;
    }


    /**
     * Sets the n_nonpaid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_nonpaid_issues
     */
    public void setN_nonpaid_issues(int n_nonpaid_issues) {
        this.n_nonpaid_issues = n_nonpaid_issues;
    }


    /**
     * Gets the n_remaining_nonpaid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_remaining_nonpaid_issues
     */
    public int getN_remaining_nonpaid_issues() {
        return n_remaining_nonpaid_issues;
    }


    /**
     * Sets the n_remaining_nonpaid_issues value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_remaining_nonpaid_issues
     */
    public void setN_remaining_nonpaid_issues(int n_remaining_nonpaid_issues) {
        this.n_remaining_nonpaid_issues = n_remaining_nonpaid_issues;
    }


    /**
     * Gets the n_cal_units_per_seg value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_cal_units_per_seg
     */
    public int getN_cal_units_per_seg() {
        return n_cal_units_per_seg;
    }


    /**
     * Sets the n_cal_units_per_seg value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_cal_units_per_seg
     */
    public void setN_cal_units_per_seg(int n_cal_units_per_seg) {
        this.n_cal_units_per_seg = n_cal_units_per_seg;
    }


    /**
     * Gets the segment_expire_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return segment_expire_date
     */
    public java.util.Date getSegment_expire_date() {
        return segment_expire_date;
    }


    /**
     * Sets the segment_expire_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param segment_expire_date
     */
    public void setSegment_expire_date(java.util.Date segment_expire_date) {
        this.segment_expire_date = segment_expire_date;
    }


    /**
     * Gets the calendar_unit value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return calendar_unit
     */
    public int getCalendar_unit() {
        return calendar_unit;
    }


    /**
     * Sets the calendar_unit value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param calendar_unit
     */
    public void setCalendar_unit(int calendar_unit) {
        this.calendar_unit = calendar_unit;
    }


    /**
     * Gets the n_items_per_seg value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_items_per_seg
     */
    public int getN_items_per_seg() {
        return n_items_per_seg;
    }


    /**
     * Sets the n_items_per_seg value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_items_per_seg
     */
    public void setN_items_per_seg(int n_items_per_seg) {
        this.n_items_per_seg = n_items_per_seg;
    }


    /**
     * Gets the n_segments_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_segments_left
     */
    public int getN_segments_left() {
        return n_segments_left;
    }


    /**
     * Sets the n_segments_left value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_segments_left
     */
    public void setN_segments_left(int n_segments_left) {
        this.n_segments_left = n_segments_left;
    }


    /**
     * Gets the is_proforma value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return is_proforma
     */
    public int getIs_proforma() {
        return is_proforma;
    }


    /**
     * Sets the is_proforma value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param is_proforma
     */
    public void setIs_proforma(int is_proforma) {
        this.is_proforma = is_proforma;
    }


    /**
     * Gets the n_tax_updates value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_tax_updates
     */
    public int getN_tax_updates() {
        return n_tax_updates;
    }


    /**
     * Sets the n_tax_updates value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_tax_updates
     */
    public void setN_tax_updates(int n_tax_updates) {
        this.n_tax_updates = n_tax_updates;
    }


    /**
     * Gets the total_tax_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return total_tax_local_amount
     */
    public java.math.BigDecimal getTotal_tax_local_amount() {
        return total_tax_local_amount;
    }


    /**
     * Sets the total_tax_local_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param total_tax_local_amount
     */
    public void setTotal_tax_local_amount(java.math.BigDecimal total_tax_local_amount) {
        this.total_tax_local_amount = total_tax_local_amount;
    }


    /**
     * Gets the total_tax_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return total_tax_base_amount
     */
    public java.math.BigDecimal getTotal_tax_base_amount() {
        return total_tax_base_amount;
    }


    /**
     * Sets the total_tax_base_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param total_tax_base_amount
     */
    public void setTotal_tax_base_amount(java.math.BigDecimal total_tax_base_amount) {
        this.total_tax_base_amount = total_tax_base_amount;
    }


    /**
     * Gets the renewed_from_subscrip_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return renewed_from_subscrip_id
     */
    public int getRenewed_from_subscrip_id() {
        return renewed_from_subscrip_id;
    }


    /**
     * Sets the renewed_from_subscrip_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param renewed_from_subscrip_id
     */
    public void setRenewed_from_subscrip_id(int renewed_from_subscrip_id) {
        this.renewed_from_subscrip_id = renewed_from_subscrip_id;
    }


    /**
     * Gets the pkg_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return pkg_item_seq
     */
    public int getPkg_item_seq() {
        return pkg_item_seq;
    }


    /**
     * Sets the pkg_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param pkg_item_seq
     */
    public void setPkg_item_seq(int pkg_item_seq) {
        this.pkg_item_seq = pkg_item_seq;
    }


    /**
     * Gets the pkg_def_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return pkg_def_id
     */
    public int getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(int pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the electronic_delivery value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return electronic_delivery
     */
    public int getElectronic_delivery() {
        return electronic_delivery;
    }


    /**
     * Sets the electronic_delivery value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param electronic_delivery
     */
    public void setElectronic_delivery(int electronic_delivery) {
        this.electronic_delivery = electronic_delivery;
    }


    /**
     * Gets the item_url value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return item_url
     */
    public java.lang.String getItem_url() {
        return item_url;
    }


    /**
     * Sets the item_url value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param item_url
     */
    public void setItem_url(java.lang.String item_url) {
        this.item_url = item_url;
    }


    /**
     * Gets the payment_account_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the time_unit_options value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return time_unit_options
     */
    public int getTime_unit_options() {
        return time_unit_options;
    }


    /**
     * Sets the time_unit_options value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param time_unit_options
     */
    public void setTime_unit_options(int time_unit_options) {
        this.time_unit_options = time_unit_options;
    }


    /**
     * Gets the max_check_out_amt value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return max_check_out_amt
     */
    public int getMax_check_out_amt() {
        return max_check_out_amt;
    }


    /**
     * Sets the max_check_out_amt value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param max_check_out_amt
     */
    public void setMax_check_out_amt(int max_check_out_amt) {
        this.max_check_out_amt = max_check_out_amt;
    }


    /**
     * Gets the n_checked_out value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_checked_out
     */
    public int getN_checked_out() {
        return n_checked_out;
    }


    /**
     * Sets the n_checked_out value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_checked_out
     */
    public void setN_checked_out(int n_checked_out) {
        this.n_checked_out = n_checked_out;
    }


    /**
     * Gets the group_order value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return group_order
     */
    public int getGroup_order() {
        return group_order;
    }


    /**
     * Sets the group_order value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param group_order
     */
    public void setGroup_order(int group_order) {
        this.group_order = group_order;
    }


    /**
     * Gets the deal_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return deal_id
     */
    public int getDeal_id() {
        return deal_id;
    }


    /**
     * Sets the deal_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param deal_id
     */
    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }


    /**
     * Gets the invoice_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return invoice_id
     */
    public int getInvoice_id() {
        return invoice_id;
    }


    /**
     * Sets the invoice_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param invoice_id
     */
    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }


    /**
     * Gets the invoice_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return invoice_date
     */
    public java.util.Date getInvoice_date() {
        return invoice_date;
    }


    /**
     * Sets the invoice_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param invoice_date
     */
    public void setInvoice_date(java.util.Date invoice_date) {
        this.invoice_date = invoice_date;
    }


    /**
     * Gets the fulfillment_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return fulfillment_date
     */
    public java.util.Date getFulfillment_date() {
        return fulfillment_date;
    }


    /**
     * Sets the fulfillment_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param fulfillment_date
     */
    public void setFulfillment_date(java.util.Date fulfillment_date) {
        this.fulfillment_date = fulfillment_date;
    }


    /**
     * Gets the auto_renew_notify_sent value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return auto_renew_notify_sent
     */
    public int getAuto_renew_notify_sent() {
        return auto_renew_notify_sent;
    }


    /**
     * Sets the auto_renew_notify_sent value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param auto_renew_notify_sent
     */
    public void setAuto_renew_notify_sent(int auto_renew_notify_sent) {
        this.auto_renew_notify_sent = auto_renew_notify_sent;
    }


    /**
     * Gets the multiline_discount_schedule value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return multiline_discount_schedule
     */
    public java.lang.String getMultiline_discount_schedule() {
        return multiline_discount_schedule;
    }


    /**
     * Sets the multiline_discount_schedule value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param multiline_discount_schedule
     */
    public void setMultiline_discount_schedule(java.lang.String multiline_discount_schedule) {
        this.multiline_discount_schedule = multiline_discount_schedule;
    }


    /**
     * Gets the multiline_disc_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return multiline_disc_amount
     */
    public java.math.BigDecimal getMultiline_disc_amount() {
        return multiline_disc_amount;
    }


    /**
     * Sets the multiline_disc_amount value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param multiline_disc_amount
     */
    public void setMultiline_disc_amount(java.math.BigDecimal multiline_disc_amount) {
        this.multiline_disc_amount = multiline_disc_amount;
    }


    /**
     * Gets the extended_days value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return extended_days
     */
    public int getExtended_days() {
        return extended_days;
    }


    /**
     * Sets the extended_days value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param extended_days
     */
    public void setExtended_days(int extended_days) {
        this.extended_days = extended_days;
    }


    /**
     * Gets the asynchronous_auto_renew value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return asynchronous_auto_renew
     */
    public int getAsynchronous_auto_renew() {
        return asynchronous_auto_renew;
    }


    /**
     * Sets the asynchronous_auto_renew value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param asynchronous_auto_renew
     */
    public void setAsynchronous_auto_renew(int asynchronous_auto_renew) {
        this.asynchronous_auto_renew = asynchronous_auto_renew;
    }


    /**
     * Gets the n_days_graced value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return n_days_graced
     */
    public int getN_days_graced() {
        return n_days_graced;
    }


    /**
     * Sets the n_days_graced value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param n_days_graced
     */
    public void setN_days_graced(int n_days_graced) {
        this.n_days_graced = n_days_graced;
    }


    /**
     * Gets the shipping_price_list value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return shipping_price_list
     */
    public java.lang.String getShipping_price_list() {
        return shipping_price_list;
    }


    /**
     * Sets the shipping_price_list value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param shipping_price_list
     */
    public void setShipping_price_list(java.lang.String shipping_price_list) {
        this.shipping_price_list = shipping_price_list;
    }


    /**
     * Gets the extended_rate value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return extended_rate
     */
    public java.math.BigDecimal getExtended_rate() {
        return extended_rate;
    }


    /**
     * Sets the extended_rate value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param extended_rate
     */
    public void setExtended_rate(java.math.BigDecimal extended_rate) {
        this.extended_rate = extended_rate;
    }


    /**
     * Gets the is_back_ordered value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return is_back_ordered
     */
    public int getIs_back_ordered() {
        return is_back_ordered;
    }


    /**
     * Sets the is_back_ordered value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param is_back_ordered
     */
    public void setIs_back_ordered(int is_back_ordered) {
        this.is_back_ordered = is_back_ordered;
    }


    /**
     * Gets the multiline_disc_eff_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return multiline_disc_eff_seq
     */
    public int getMultiline_disc_eff_seq() {
        return multiline_disc_eff_seq;
    }


    /**
     * Sets the multiline_disc_eff_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param multiline_disc_eff_seq
     */
    public void setMultiline_disc_eff_seq(int multiline_disc_eff_seq) {
        this.multiline_disc_eff_seq = multiline_disc_eff_seq;
    }


    /**
     * Gets the attach_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return attach_exist
     */
    public int getAttach_exist() {
        return attach_exist;
    }


    /**
     * Sets the attach_exist value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param attach_exist
     */
    public void setAttach_exist(int attach_exist) {
        this.attach_exist = attach_exist;
    }


    /**
     * Gets the addon_to_orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return addon_to_orderhdr_id
     */
    public int getAddon_to_orderhdr_id() {
        return addon_to_orderhdr_id;
    }


    /**
     * Sets the addon_to_orderhdr_id value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param addon_to_orderhdr_id
     */
    public void setAddon_to_orderhdr_id(int addon_to_orderhdr_id) {
        this.addon_to_orderhdr_id = addon_to_orderhdr_id;
    }


    /**
     * Gets the addon_to_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return addon_to_order_item_seq
     */
    public int getAddon_to_order_item_seq() {
        return addon_to_order_item_seq;
    }


    /**
     * Sets the addon_to_order_item_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param addon_to_order_item_seq
     */
    public void setAddon_to_order_item_seq(int addon_to_order_item_seq) {
        this.addon_to_order_item_seq = addon_to_order_item_seq;
    }


    /**
     * Gets the generic_promotion_code_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return generic_promotion_code_seq
     */
    public int getGeneric_promotion_code_seq() {
        return generic_promotion_code_seq;
    }


    /**
     * Sets the generic_promotion_code_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param generic_promotion_code_seq
     */
    public void setGeneric_promotion_code_seq(int generic_promotion_code_seq) {
        this.generic_promotion_code_seq = generic_promotion_code_seq;
    }


    /**
     * Gets the charge_on_cancellation value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return charge_on_cancellation
     */
    public int getCharge_on_cancellation() {
        return charge_on_cancellation;
    }


    /**
     * Sets the charge_on_cancellation value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param charge_on_cancellation
     */
    public void setCharge_on_cancellation(int charge_on_cancellation) {
        this.charge_on_cancellation = charge_on_cancellation;
    }


    /**
     * Gets the last_tax_invoice_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return last_tax_invoice_date
     */
    public java.util.Date getLast_tax_invoice_date() {
        return last_tax_invoice_date;
    }


    /**
     * Sets the last_tax_invoice_date value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param last_tax_invoice_date
     */
    public void setLast_tax_invoice_date(java.util.Date last_tax_invoice_date) {
        this.last_tax_invoice_date = last_tax_invoice_date;
    }


    /**
     * Gets the description value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the p_payment_account_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @return p_payment_account_seq
     */
    public int getP_payment_account_seq() {
        return p_payment_account_seq;
    }


    /**
     * Sets the p_payment_account_seq value for this Payment_account_order_item_select_responseOrder_item_on_payment_account.
     * 
     * @param p_payment_account_seq
     */
    public void setP_payment_account_seq(int p_payment_account_seq) {
        this.p_payment_account_seq = p_payment_account_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_account_order_item_select_responseOrder_item_on_payment_account)) return false;
        Payment_account_order_item_select_responseOrder_item_on_payment_account other = (Payment_account_order_item_select_responseOrder_item_on_payment_account) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.delivery_method==null && other.getDelivery_method()==null) || 
             (this.delivery_method!=null &&
              this.delivery_method.equals(other.getDelivery_method()))) &&
            this.source_code_id == other.getSource_code_id() &&
            ((this.order_category==null && other.getOrder_category()==null) || 
             (this.order_category!=null &&
              this.order_category.equals(other.getOrder_category()))) &&
            this.package_id == other.getPackage_id() &&
            this.package_content_seq == other.getPackage_content_seq() &&
            this.date_stamp == other.getDate_stamp() &&
            this.order_item_type == other.getOrder_item_type() &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            this.order_qty == other.getOrder_qty() &&
            ((this.gross_base_amount==null && other.getGross_base_amount()==null) || 
             (this.gross_base_amount!=null &&
              this.gross_base_amount.equals(other.getGross_base_amount()))) &&
            ((this.gross_local_amount==null && other.getGross_local_amount()==null) || 
             (this.gross_local_amount!=null &&
              this.gross_local_amount.equals(other.getGross_local_amount()))) &&
            ((this.net_base_amount==null && other.getNet_base_amount()==null) || 
             (this.net_base_amount!=null &&
              this.net_base_amount.equals(other.getNet_base_amount()))) &&
            ((this.net_local_amount==null && other.getNet_local_amount()==null) || 
             (this.net_local_amount!=null &&
              this.net_local_amount.equals(other.getNet_local_amount()))) &&
            this.has_tax == other.getHas_tax() &&
            this.has_delivery_charge == other.getHas_delivery_charge() &&
            ((this.bill_date==null && other.getBill_date()==null) || 
             (this.bill_date!=null &&
              this.bill_date.equals(other.getBill_date()))) &&
            this.n_inv_efforts == other.getN_inv_efforts() &&
            ((this.last_inv_date==null && other.getLast_inv_date()==null) || 
             (this.last_inv_date!=null &&
              this.last_inv_date.equals(other.getLast_inv_date()))) &&
            this.payment_status == other.getPayment_status() &&
            this.refund_status == other.getRefund_status() &&
            this.order_type == other.getOrder_type() &&
            this.billing_type == other.getBilling_type() &&
            this.has_premium == other.getHas_premium() &&
            this.prepayment_req == other.getPrepayment_req() &&
            this.product_id == other.getProduct_id() &&
            this.ship_qty == other.getShip_qty() &&
            this.backord_qty == other.getBackord_qty() &&
            this.subscrip_id == other.getSubscrip_id() &&
            this.bundle_qty == other.getBundle_qty() &&
            this.audit_qual_category == other.getAudit_qual_category() &&
            this.is_complimentary == other.getIs_complimentary() &&
            this.subscrip_start_type == other.getSubscrip_start_type() &&
            this.order_code_id == other.getOrder_code_id() &&
            ((this.cancel_reason==null && other.getCancel_reason()==null) || 
             (this.cancel_reason!=null &&
              this.cancel_reason.equals(other.getCancel_reason()))) &&
            this.customer_group_id == other.getCustomer_group_id() &&
            this.audit_qual_source_id == other.getAudit_qual_source_id() &&
            this.audit_subscription_type_id == other.getAudit_subscription_type_id() &&
            this.percent_of_basic_price == other.getPercent_of_basic_price() &&
            this.duration == other.getDuration() &&
            this.renewal_status == other.getRenewal_status() &&
            this.delivery_method_perm == other.getDelivery_method_perm() &&
            this.change_qty_flag == other.getChange_qty_flag() &&
            this.n_issues_left == other.getN_issues_left() &&
            this.n_ren_effort == other.getN_ren_effort() &&
            ((this.last_ren_date==null && other.getLast_ren_date()==null) || 
             (this.last_ren_date!=null &&
              this.last_ren_date.equals(other.getLast_ren_date()))) &&
            this.n_del_iss_left == other.getN_del_iss_left() &&
            this.n_remaining_paid_issues == other.getN_remaining_paid_issues() &&
            this.ext_iss_left == other.getExt_iss_left() &&
            this.ext_iss_tot == other.getExt_iss_tot() &&
            this.audit_name_title_id == other.getAudit_name_title_id() &&
            this.audit_sales_channel_id == other.getAudit_sales_channel_id() &&
            ((this.qual_date==null && other.getQual_date()==null) || 
             (this.qual_date!=null &&
              this.qual_date.equals(other.getQual_date()))) &&
            ((this.squal_date==null && other.getSqual_date()==null) || 
             (this.squal_date!=null &&
              this.squal_date.equals(other.getSqual_date()))) &&
            this.order_status == other.getOrder_status() &&
            ((this.cancel_date==null && other.getCancel_date()==null) || 
             (this.cancel_date!=null &&
              this.cancel_date.equals(other.getCancel_date()))) &&
            this.pub_rotation_id == other.getPub_rotation_id() &&
            this.renewal_category == other.getRenewal_category() &&
            ((this.exchange_rate==null && other.getExchange_rate()==null) || 
             (this.exchange_rate!=null &&
              this.exchange_rate.equals(other.getExchange_rate()))) &&
            this.prem_to_order_item_seq == other.getPrem_to_order_item_seq() &&
            this.renewal_orderhdr_id == other.getRenewal_orderhdr_id() &&
            this.renewal_order_item_seq == other.getRenewal_order_item_seq() &&
            this.subscription_def_id == other.getSubscription_def_id() &&
            this.rate_class_id == other.getRate_class_id() &&
            this.rate_class_effective_seq == other.getRate_class_effective_seq() &&
            this.ratecard_seq == other.getRatecard_seq() &&
            this.discount_class_id == other.getDiscount_class_id() &&
            this.disc_class_effective_seq == other.getDisc_class_effective_seq() &&
            this.discount_card_seq == other.getDiscount_card_seq() &&
            this.inventory_id == other.getInventory_id() &&
            this.oc_id == other.getOc_id() &&
            this.installment_plan_id == other.getInstallment_plan_id() &&
            this.auto_payment == other.getAuto_payment() &&
            this.perpetual_order == other.getPerpetual_order() &&
            this.agency_customer_id == other.getAgency_customer_id() &&
            this.bill_to_customer_id == other.getBill_to_customer_id() &&
            this.bill_to_customer_address_seq == other.getBill_to_customer_address_seq() &&
            this.renew_to_customer_id == other.getRenew_to_customer_id() &&
            this.renew_to_customer_address_seq == other.getRenew_to_customer_address_seq() &&
            this.start_issue_id == other.getStart_issue_id() &&
            this.stop_issue_id == other.getStop_issue_id() &&
            this.single_issue_id == other.getSingle_issue_id() &&
            this.customer_id == other.getCustomer_id() &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            this.note_exist == other.getNote_exist() &&
            this.service_exist == other.getService_exist() &&
            this.number_volume_sets == other.getNumber_volume_sets() &&
            this.alt_ship_customer_id == other.getAlt_ship_customer_id() &&
            this.alt_ship_customer_address_seq == other.getAlt_ship_customer_address_seq() &&
            this.alt_ship_del_calc == other.getAlt_ship_del_calc() &&
            ((this.distribution_method==null && other.getDistribution_method()==null) || 
             (this.distribution_method!=null &&
              this.distribution_method.equals(other.getDistribution_method()))) &&
            ((this.billing_def==null && other.getBilling_def()==null) || 
             (this.billing_def!=null &&
              this.billing_def.equals(other.getBilling_def()))) &&
            this.billing_def_test_seq == other.getBilling_def_test_seq() &&
            ((this.renewal_def==null && other.getRenewal_def()==null) || 
             (this.renewal_def!=null &&
              this.renewal_def.equals(other.getRenewal_def()))) &&
            this.renewal_def_test_seq == other.getRenewal_def_test_seq() &&
            ((this.agent_ref_nbr==null && other.getAgent_ref_nbr()==null) || 
             (this.agent_ref_nbr!=null &&
              this.agent_ref_nbr.equals(other.getAgent_ref_nbr()))) &&
            this.has_been_renewed == other.getHas_been_renewed() &&
            this.revenue_method == other.getRevenue_method() &&
            ((this.start_date==null && other.getStart_date()==null) || 
             (this.start_date!=null &&
              this.start_date.equals(other.getStart_date()))) &&
            ((this.expire_date==null && other.getExpire_date()==null) || 
             (this.expire_date!=null &&
              this.expire_date.equals(other.getExpire_date()))) &&
            ((this.electronic_document_identifier==null && other.getElectronic_document_identifier()==null) || 
             (this.electronic_document_identifier!=null &&
              this.electronic_document_identifier.equals(other.getElectronic_document_identifier()))) &&
            this.package_instance == other.getPackage_instance() &&
            this.unit_type_id == other.getUnit_type_id() &&
            this.ex_rate_class_id == other.getEx_rate_class_id() &&
            this.ex_rate_class_effective_seq == other.getEx_rate_class_effective_seq() &&
            this.ex_ratecard_seq == other.getEx_ratecard_seq() &&
            this.trial_period == other.getTrial_period() &&
            this.trial_type == other.getTrial_type() &&
            this.orig_order_qty == other.getOrig_order_qty() &&
            this.unit_excess == other.getUnit_excess() &&
            ((this.manual_disc_amt_local==null && other.getManual_disc_amt_local()==null) || 
             (this.manual_disc_amt_local!=null &&
              this.manual_disc_amt_local.equals(other.getManual_disc_amt_local()))) &&
            ((this.manual_disc_amt_base==null && other.getManual_disc_amt_base()==null) || 
             (this.manual_disc_amt_base!=null &&
              this.manual_disc_amt_base.equals(other.getManual_disc_amt_base()))) &&
            ((this.manual_disc_percentage==null && other.getManual_disc_percentage()==null) || 
             (this.manual_disc_percentage!=null &&
              this.manual_disc_percentage.equals(other.getManual_disc_percentage()))) &&
            this.n_nonpaid_issues == other.getN_nonpaid_issues() &&
            this.n_remaining_nonpaid_issues == other.getN_remaining_nonpaid_issues() &&
            this.n_cal_units_per_seg == other.getN_cal_units_per_seg() &&
            ((this.segment_expire_date==null && other.getSegment_expire_date()==null) || 
             (this.segment_expire_date!=null &&
              this.segment_expire_date.equals(other.getSegment_expire_date()))) &&
            this.calendar_unit == other.getCalendar_unit() &&
            this.n_items_per_seg == other.getN_items_per_seg() &&
            this.n_segments_left == other.getN_segments_left() &&
            this.is_proforma == other.getIs_proforma() &&
            this.n_tax_updates == other.getN_tax_updates() &&
            ((this.total_tax_local_amount==null && other.getTotal_tax_local_amount()==null) || 
             (this.total_tax_local_amount!=null &&
              this.total_tax_local_amount.equals(other.getTotal_tax_local_amount()))) &&
            ((this.total_tax_base_amount==null && other.getTotal_tax_base_amount()==null) || 
             (this.total_tax_base_amount!=null &&
              this.total_tax_base_amount.equals(other.getTotal_tax_base_amount()))) &&
            this.renewed_from_subscrip_id == other.getRenewed_from_subscrip_id() &&
            this.pkg_item_seq == other.getPkg_item_seq() &&
            this.pkg_def_id == other.getPkg_def_id() &&
            this.electronic_delivery == other.getElectronic_delivery() &&
            ((this.item_url==null && other.getItem_url()==null) || 
             (this.item_url!=null &&
              this.item_url.equals(other.getItem_url()))) &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            this.time_unit_options == other.getTime_unit_options() &&
            this.max_check_out_amt == other.getMax_check_out_amt() &&
            this.n_checked_out == other.getN_checked_out() &&
            this.group_order == other.getGroup_order() &&
            this.deal_id == other.getDeal_id() &&
            this.invoice_id == other.getInvoice_id() &&
            ((this.invoice_date==null && other.getInvoice_date()==null) || 
             (this.invoice_date!=null &&
              this.invoice_date.equals(other.getInvoice_date()))) &&
            ((this.fulfillment_date==null && other.getFulfillment_date()==null) || 
             (this.fulfillment_date!=null &&
              this.fulfillment_date.equals(other.getFulfillment_date()))) &&
            this.auto_renew_notify_sent == other.getAuto_renew_notify_sent() &&
            ((this.multiline_discount_schedule==null && other.getMultiline_discount_schedule()==null) || 
             (this.multiline_discount_schedule!=null &&
              this.multiline_discount_schedule.equals(other.getMultiline_discount_schedule()))) &&
            ((this.multiline_disc_amount==null && other.getMultiline_disc_amount()==null) || 
             (this.multiline_disc_amount!=null &&
              this.multiline_disc_amount.equals(other.getMultiline_disc_amount()))) &&
            this.extended_days == other.getExtended_days() &&
            this.asynchronous_auto_renew == other.getAsynchronous_auto_renew() &&
            this.n_days_graced == other.getN_days_graced() &&
            ((this.shipping_price_list==null && other.getShipping_price_list()==null) || 
             (this.shipping_price_list!=null &&
              this.shipping_price_list.equals(other.getShipping_price_list()))) &&
            ((this.extended_rate==null && other.getExtended_rate()==null) || 
             (this.extended_rate!=null &&
              this.extended_rate.equals(other.getExtended_rate()))) &&
            this.is_back_ordered == other.getIs_back_ordered() &&
            this.multiline_disc_eff_seq == other.getMultiline_disc_eff_seq() &&
            this.attach_exist == other.getAttach_exist() &&
            this.addon_to_orderhdr_id == other.getAddon_to_orderhdr_id() &&
            this.addon_to_order_item_seq == other.getAddon_to_order_item_seq() &&
            this.generic_promotion_code_seq == other.getGeneric_promotion_code_seq() &&
            this.charge_on_cancellation == other.getCharge_on_cancellation() &&
            ((this.last_tax_invoice_date==null && other.getLast_tax_invoice_date()==null) || 
             (this.last_tax_invoice_date!=null &&
              this.last_tax_invoice_date.equals(other.getLast_tax_invoice_date()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.p_payment_account_seq == other.getP_payment_account_seq();
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
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getDelivery_method() != null) {
            _hashCode += getDelivery_method().hashCode();
        }
        _hashCode += getSource_code_id();
        if (getOrder_category() != null) {
            _hashCode += getOrder_category().hashCode();
        }
        _hashCode += getPackage_id();
        _hashCode += getPackage_content_seq();
        _hashCode += getDate_stamp();
        _hashCode += getOrder_item_type();
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        _hashCode += getOrder_qty();
        if (getGross_base_amount() != null) {
            _hashCode += getGross_base_amount().hashCode();
        }
        if (getGross_local_amount() != null) {
            _hashCode += getGross_local_amount().hashCode();
        }
        if (getNet_base_amount() != null) {
            _hashCode += getNet_base_amount().hashCode();
        }
        if (getNet_local_amount() != null) {
            _hashCode += getNet_local_amount().hashCode();
        }
        _hashCode += getHas_tax();
        _hashCode += getHas_delivery_charge();
        if (getBill_date() != null) {
            _hashCode += getBill_date().hashCode();
        }
        _hashCode += getN_inv_efforts();
        if (getLast_inv_date() != null) {
            _hashCode += getLast_inv_date().hashCode();
        }
        _hashCode += getPayment_status();
        _hashCode += getRefund_status();
        _hashCode += getOrder_type();
        _hashCode += getBilling_type();
        _hashCode += getHas_premium();
        _hashCode += getPrepayment_req();
        _hashCode += getProduct_id();
        _hashCode += getShip_qty();
        _hashCode += getBackord_qty();
        _hashCode += getSubscrip_id();
        _hashCode += getBundle_qty();
        _hashCode += getAudit_qual_category();
        _hashCode += getIs_complimentary();
        _hashCode += getSubscrip_start_type();
        _hashCode += getOrder_code_id();
        if (getCancel_reason() != null) {
            _hashCode += getCancel_reason().hashCode();
        }
        _hashCode += getCustomer_group_id();
        _hashCode += getAudit_qual_source_id();
        _hashCode += getAudit_subscription_type_id();
        _hashCode += getPercent_of_basic_price();
        _hashCode += getDuration();
        _hashCode += getRenewal_status();
        _hashCode += getDelivery_method_perm();
        _hashCode += getChange_qty_flag();
        _hashCode += getN_issues_left();
        _hashCode += getN_ren_effort();
        if (getLast_ren_date() != null) {
            _hashCode += getLast_ren_date().hashCode();
        }
        _hashCode += getN_del_iss_left();
        _hashCode += getN_remaining_paid_issues();
        _hashCode += getExt_iss_left();
        _hashCode += getExt_iss_tot();
        _hashCode += getAudit_name_title_id();
        _hashCode += getAudit_sales_channel_id();
        if (getQual_date() != null) {
            _hashCode += getQual_date().hashCode();
        }
        if (getSqual_date() != null) {
            _hashCode += getSqual_date().hashCode();
        }
        _hashCode += getOrder_status();
        if (getCancel_date() != null) {
            _hashCode += getCancel_date().hashCode();
        }
        _hashCode += getPub_rotation_id();
        _hashCode += getRenewal_category();
        if (getExchange_rate() != null) {
            _hashCode += getExchange_rate().hashCode();
        }
        _hashCode += getPrem_to_order_item_seq();
        _hashCode += getRenewal_orderhdr_id();
        _hashCode += getRenewal_order_item_seq();
        _hashCode += getSubscription_def_id();
        _hashCode += getRate_class_id();
        _hashCode += getRate_class_effective_seq();
        _hashCode += getRatecard_seq();
        _hashCode += getDiscount_class_id();
        _hashCode += getDisc_class_effective_seq();
        _hashCode += getDiscount_card_seq();
        _hashCode += getInventory_id();
        _hashCode += getOc_id();
        _hashCode += getInstallment_plan_id();
        _hashCode += getAuto_payment();
        _hashCode += getPerpetual_order();
        _hashCode += getAgency_customer_id();
        _hashCode += getBill_to_customer_id();
        _hashCode += getBill_to_customer_address_seq();
        _hashCode += getRenew_to_customer_id();
        _hashCode += getRenew_to_customer_address_seq();
        _hashCode += getStart_issue_id();
        _hashCode += getStop_issue_id();
        _hashCode += getSingle_issue_id();
        _hashCode += getCustomer_id();
        _hashCode += getCustomer_address_seq();
        _hashCode += getNote_exist();
        _hashCode += getService_exist();
        _hashCode += getNumber_volume_sets();
        _hashCode += getAlt_ship_customer_id();
        _hashCode += getAlt_ship_customer_address_seq();
        _hashCode += getAlt_ship_del_calc();
        if (getDistribution_method() != null) {
            _hashCode += getDistribution_method().hashCode();
        }
        if (getBilling_def() != null) {
            _hashCode += getBilling_def().hashCode();
        }
        _hashCode += getBilling_def_test_seq();
        if (getRenewal_def() != null) {
            _hashCode += getRenewal_def().hashCode();
        }
        _hashCode += getRenewal_def_test_seq();
        if (getAgent_ref_nbr() != null) {
            _hashCode += getAgent_ref_nbr().hashCode();
        }
        _hashCode += getHas_been_renewed();
        _hashCode += getRevenue_method();
        if (getStart_date() != null) {
            _hashCode += getStart_date().hashCode();
        }
        if (getExpire_date() != null) {
            _hashCode += getExpire_date().hashCode();
        }
        if (getElectronic_document_identifier() != null) {
            _hashCode += getElectronic_document_identifier().hashCode();
        }
        _hashCode += getPackage_instance();
        _hashCode += getUnit_type_id();
        _hashCode += getEx_rate_class_id();
        _hashCode += getEx_rate_class_effective_seq();
        _hashCode += getEx_ratecard_seq();
        _hashCode += getTrial_period();
        _hashCode += getTrial_type();
        _hashCode += getOrig_order_qty();
        _hashCode += getUnit_excess();
        if (getManual_disc_amt_local() != null) {
            _hashCode += getManual_disc_amt_local().hashCode();
        }
        if (getManual_disc_amt_base() != null) {
            _hashCode += getManual_disc_amt_base().hashCode();
        }
        if (getManual_disc_percentage() != null) {
            _hashCode += getManual_disc_percentage().hashCode();
        }
        _hashCode += getN_nonpaid_issues();
        _hashCode += getN_remaining_nonpaid_issues();
        _hashCode += getN_cal_units_per_seg();
        if (getSegment_expire_date() != null) {
            _hashCode += getSegment_expire_date().hashCode();
        }
        _hashCode += getCalendar_unit();
        _hashCode += getN_items_per_seg();
        _hashCode += getN_segments_left();
        _hashCode += getIs_proforma();
        _hashCode += getN_tax_updates();
        if (getTotal_tax_local_amount() != null) {
            _hashCode += getTotal_tax_local_amount().hashCode();
        }
        if (getTotal_tax_base_amount() != null) {
            _hashCode += getTotal_tax_base_amount().hashCode();
        }
        _hashCode += getRenewed_from_subscrip_id();
        _hashCode += getPkg_item_seq();
        _hashCode += getPkg_def_id();
        _hashCode += getElectronic_delivery();
        if (getItem_url() != null) {
            _hashCode += getItem_url().hashCode();
        }
        _hashCode += getPayment_account_seq();
        _hashCode += getTime_unit_options();
        _hashCode += getMax_check_out_amt();
        _hashCode += getN_checked_out();
        _hashCode += getGroup_order();
        _hashCode += getDeal_id();
        _hashCode += getInvoice_id();
        if (getInvoice_date() != null) {
            _hashCode += getInvoice_date().hashCode();
        }
        if (getFulfillment_date() != null) {
            _hashCode += getFulfillment_date().hashCode();
        }
        _hashCode += getAuto_renew_notify_sent();
        if (getMultiline_discount_schedule() != null) {
            _hashCode += getMultiline_discount_schedule().hashCode();
        }
        if (getMultiline_disc_amount() != null) {
            _hashCode += getMultiline_disc_amount().hashCode();
        }
        _hashCode += getExtended_days();
        _hashCode += getAsynchronous_auto_renew();
        _hashCode += getN_days_graced();
        if (getShipping_price_list() != null) {
            _hashCode += getShipping_price_list().hashCode();
        }
        if (getExtended_rate() != null) {
            _hashCode += getExtended_rate().hashCode();
        }
        _hashCode += getIs_back_ordered();
        _hashCode += getMultiline_disc_eff_seq();
        _hashCode += getAttach_exist();
        _hashCode += getAddon_to_orderhdr_id();
        _hashCode += getAddon_to_order_item_seq();
        _hashCode += getGeneric_promotion_code_seq();
        _hashCode += getCharge_on_cancellation();
        if (getLast_tax_invoice_date() != null) {
            _hashCode += getLast_tax_invoice_date().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getP_payment_account_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_account_order_item_select_responseOrder_item_on_payment_account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_account_order_item_select_response>order_item_on_payment_account"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
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
        attrField.setFieldName("delivery_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delivery_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("package_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "package_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("package_content_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "package_content_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("gross_base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "gross_base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("gross_local_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "gross_local_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("net_base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "net_base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("net_local_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "net_local_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_tax");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_tax"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_delivery_charge");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_delivery_charge"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_inv_efforts");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_inv_efforts"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_inv_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_inv_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("billing_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "billing_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_premium");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_premium"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prepayment_req");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prepayment_req"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ship_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ship_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("backord_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "backord_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_qual_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_qual_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_complimentary");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_complimentary"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_start_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_start_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_group_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_group_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_qual_source_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_qual_source_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_subscription_type_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_subscription_type_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("percent_of_basic_price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "percent_of_basic_price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("duration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "duration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delivery_method_perm");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delivery_method_perm"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("change_qty_flag");
        attrField.setXmlName(new javax.xml.namespace.QName("", "change_qty_flag"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_issues_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_issues_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_ren_effort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_ren_effort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_ren_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_ren_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_del_iss_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_del_iss_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_remaining_paid_issues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_remaining_paid_issues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ext_iss_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ext_iss_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ext_iss_tot");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ext_iss_tot"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_name_title_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_name_title_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_sales_channel_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_sales_channel_id"));
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
        attrField.setFieldName("order_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pub_rotation_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pub_rotation_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("exchange_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "exchange_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prem_to_order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prem_to_order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscription_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscription_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rate_class_effective_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rate_class_effective_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ratecard_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ratecard_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("disc_class_effective_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "disc_class_effective_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_card_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_card_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inventory_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inventory_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_plan_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_plan_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_payment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_payment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("perpetual_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "perpetual_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("agency_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "agency_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_to_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renew_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renew_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renew_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renew_to_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("stop_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "stop_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("single_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "single_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("note_exist");
        attrField.setXmlName(new javax.xml.namespace.QName("", "note_exist"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_exist");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_exist"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("number_volume_sets");
        attrField.setXmlName(new javax.xml.namespace.QName("", "number_volume_sets"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alt_ship_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alt_ship_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alt_ship_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alt_ship_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alt_ship_del_calc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alt_ship_del_calc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("distribution_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "distribution_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        attrField.setFieldName("agent_ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "agent_ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_been_renewed");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_been_renewed"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("expire_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "expire_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("electronic_document_identifier");
        attrField.setXmlName(new javax.xml.namespace.QName("", "electronic_document_identifier"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("package_instance");
        attrField.setXmlName(new javax.xml.namespace.QName("", "package_instance"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_type_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_type_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ex_rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ex_rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ex_rate_class_effective_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ex_rate_class_effective_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ex_ratecard_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ex_ratecard_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("trial_period");
        attrField.setXmlName(new javax.xml.namespace.QName("", "trial_period"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("trial_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "trial_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orig_order_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orig_order_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_excess");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_excess"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manual_disc_amt_local");
        attrField.setXmlName(new javax.xml.namespace.QName("", "manual_disc_amt_local"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manual_disc_amt_base");
        attrField.setXmlName(new javax.xml.namespace.QName("", "manual_disc_amt_base"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manual_disc_percentage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "manual_disc_percentage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_nonpaid_issues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_nonpaid_issues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_remaining_nonpaid_issues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_remaining_nonpaid_issues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_cal_units_per_seg");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_cal_units_per_seg"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("segment_expire_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "segment_expire_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("calendar_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "calendar_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_items_per_seg");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_items_per_seg"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_segments_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_segments_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_proforma");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_proforma"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_tax_updates");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_tax_updates"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("total_tax_local_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "total_tax_local_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("total_tax_base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "total_tax_base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewed_from_subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewed_from_subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("electronic_delivery");
        attrField.setXmlName(new javax.xml.namespace.QName("", "electronic_delivery"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("time_unit_options");
        attrField.setXmlName(new javax.xml.namespace.QName("", "time_unit_options"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("max_check_out_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "max_check_out_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_checked_out");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_checked_out"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("group_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "group_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deal_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deal_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoice_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoice_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoice_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoice_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fulfillment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fulfillment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_renew_notify_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_renew_notify_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("multiline_discount_schedule");
        attrField.setXmlName(new javax.xml.namespace.QName("", "multiline_discount_schedule"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("multiline_disc_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "multiline_disc_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("extended_days");
        attrField.setXmlName(new javax.xml.namespace.QName("", "extended_days"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("asynchronous_auto_renew");
        attrField.setXmlName(new javax.xml.namespace.QName("", "asynchronous_auto_renew"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_days_graced");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_days_graced"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("shipping_price_list");
        attrField.setXmlName(new javax.xml.namespace.QName("", "shipping_price_list"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("extended_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "extended_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_back_ordered");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_back_ordered"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("multiline_disc_eff_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "multiline_disc_eff_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attach_exist");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attach_exist"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("addon_to_orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "addon_to_orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("addon_to_order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "addon_to_order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("generic_promotion_code_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "generic_promotion_code_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("charge_on_cancellation");
        attrField.setXmlName(new javax.xml.namespace.QName("", "charge_on_cancellation"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_tax_invoice_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_tax_invoice_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("p_payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "p_payment_account_seq"));
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
