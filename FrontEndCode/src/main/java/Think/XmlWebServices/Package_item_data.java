/**
 * Package_item_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Package_item_data  implements java.io.Serializable {
    private java.lang.Integer source_code_id;

    private java.lang.Integer pkg_def_id;

    private java.lang.Integer rate_class_effective_seq;

    private java.lang.Integer bundle_qty;

    private Think.XmlWebServices.Item_amt_break_data item_amt_break_data;

    private java.lang.String currency;

    private java.lang.Integer customer_address_seq;

    private java.lang.Integer renew_to_customer_id;

    private java.lang.Integer renew_to_customer_address_seq;

    private java.lang.Integer renewal_status;

    private java.lang.String cancel_reason;

    private java.lang.Integer auto_payment;

    private java.lang.Integer payment_account_seq;

    private java.lang.Integer agency_customer_id;

    private java.lang.String agent_ref_nbr;

    private java.lang.String order_category;

    private java.lang.Boolean is_proforma;

    private java.lang.Integer bill_to_customer_id;

    private java.lang.Integer bill_to_customer_address_seq;

    private java.lang.Integer alt_ship_customer_id;

    private java.lang.Integer alt_ship_customer_address_seq;

    private java.util.Date bill_date;

    private java.lang.Integer billing_type;

    private java.util.Date qual_date;

    private java.lang.Integer installment_plan_id;

    private Think.XmlWebServices.Installment_data installment_data;

    private java.lang.Integer extended_days;

    private java.util.Date expire_date;

    private Think.XmlWebServices.Auxiliary_data[] auxiliary_data;

    private Think.XmlWebServices.ZZBoolean include_tax;  // attribute

    private Think.XmlWebServices.ZZBoolean add_or_remove_mbrs;  // attribute

    private Think.XmlWebServices.ZZBoolean suppress_ccinfo_check;  // attribute

    private Think.XmlWebServices.ZZBoolean ignore_bad_credit;  // attribute

    private Think.XmlWebServices.Threshold_option_enum threshold_option;  // attribute

    private Think.XmlWebServices.ZZBoolean no_content;  // attribute

    private Think.XmlWebServices.ZZBoolean cancel_member;  // attribute

    public Package_item_data() {
    }

    public Package_item_data(
           java.lang.Integer source_code_id,
           java.lang.Integer pkg_def_id,
           java.lang.Integer rate_class_effective_seq,
           java.lang.Integer bundle_qty,
           Think.XmlWebServices.Item_amt_break_data item_amt_break_data,
           java.lang.String currency,
           java.lang.Integer customer_address_seq,
           java.lang.Integer renew_to_customer_id,
           java.lang.Integer renew_to_customer_address_seq,
           java.lang.Integer renewal_status,
           java.lang.String cancel_reason,
           java.lang.Integer auto_payment,
           java.lang.Integer payment_account_seq,
           java.lang.Integer agency_customer_id,
           java.lang.String agent_ref_nbr,
           java.lang.String order_category,
           java.lang.Boolean is_proforma,
           java.lang.Integer bill_to_customer_id,
           java.lang.Integer bill_to_customer_address_seq,
           java.lang.Integer alt_ship_customer_id,
           java.lang.Integer alt_ship_customer_address_seq,
           java.util.Date bill_date,
           java.lang.Integer billing_type,
           java.util.Date qual_date,
           java.lang.Integer installment_plan_id,
           Think.XmlWebServices.Installment_data installment_data,
           java.lang.Integer extended_days,
           java.util.Date expire_date,
           Think.XmlWebServices.Auxiliary_data[] auxiliary_data,
           Think.XmlWebServices.ZZBoolean include_tax,
           Think.XmlWebServices.ZZBoolean add_or_remove_mbrs,
           Think.XmlWebServices.ZZBoolean suppress_ccinfo_check,
           Think.XmlWebServices.ZZBoolean ignore_bad_credit,
           Think.XmlWebServices.Threshold_option_enum threshold_option,
           Think.XmlWebServices.ZZBoolean no_content,
           Think.XmlWebServices.ZZBoolean cancel_member) {
           this.source_code_id = source_code_id;
           this.pkg_def_id = pkg_def_id;
           this.rate_class_effective_seq = rate_class_effective_seq;
           this.bundle_qty = bundle_qty;
           this.item_amt_break_data = item_amt_break_data;
           this.currency = currency;
           this.customer_address_seq = customer_address_seq;
           this.renew_to_customer_id = renew_to_customer_id;
           this.renew_to_customer_address_seq = renew_to_customer_address_seq;
           this.renewal_status = renewal_status;
           this.cancel_reason = cancel_reason;
           this.auto_payment = auto_payment;
           this.payment_account_seq = payment_account_seq;
           this.agency_customer_id = agency_customer_id;
           this.agent_ref_nbr = agent_ref_nbr;
           this.order_category = order_category;
           this.is_proforma = is_proforma;
           this.bill_to_customer_id = bill_to_customer_id;
           this.bill_to_customer_address_seq = bill_to_customer_address_seq;
           this.alt_ship_customer_id = alt_ship_customer_id;
           this.alt_ship_customer_address_seq = alt_ship_customer_address_seq;
           this.bill_date = bill_date;
           this.billing_type = billing_type;
           this.qual_date = qual_date;
           this.installment_plan_id = installment_plan_id;
           this.installment_data = installment_data;
           this.extended_days = extended_days;
           this.expire_date = expire_date;
           this.auxiliary_data = auxiliary_data;
           this.include_tax = include_tax;
           this.add_or_remove_mbrs = add_or_remove_mbrs;
           this.suppress_ccinfo_check = suppress_ccinfo_check;
           this.ignore_bad_credit = ignore_bad_credit;
           this.threshold_option = threshold_option;
           this.no_content = no_content;
           this.cancel_member = cancel_member;
    }


    /**
     * Gets the source_code_id value for this Package_item_data.
     * 
     * @return source_code_id
     */
    public java.lang.Integer getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Package_item_data.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(java.lang.Integer source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the pkg_def_id value for this Package_item_data.
     * 
     * @return pkg_def_id
     */
    public java.lang.Integer getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Package_item_data.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(java.lang.Integer pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the rate_class_effective_seq value for this Package_item_data.
     * 
     * @return rate_class_effective_seq
     */
    public java.lang.Integer getRate_class_effective_seq() {
        return rate_class_effective_seq;
    }


    /**
     * Sets the rate_class_effective_seq value for this Package_item_data.
     * 
     * @param rate_class_effective_seq
     */
    public void setRate_class_effective_seq(java.lang.Integer rate_class_effective_seq) {
        this.rate_class_effective_seq = rate_class_effective_seq;
    }


    /**
     * Gets the bundle_qty value for this Package_item_data.
     * 
     * @return bundle_qty
     */
    public java.lang.Integer getBundle_qty() {
        return bundle_qty;
    }


    /**
     * Sets the bundle_qty value for this Package_item_data.
     * 
     * @param bundle_qty
     */
    public void setBundle_qty(java.lang.Integer bundle_qty) {
        this.bundle_qty = bundle_qty;
    }


    /**
     * Gets the item_amt_break_data value for this Package_item_data.
     * 
     * @return item_amt_break_data
     */
    public Think.XmlWebServices.Item_amt_break_data getItem_amt_break_data() {
        return item_amt_break_data;
    }


    /**
     * Sets the item_amt_break_data value for this Package_item_data.
     * 
     * @param item_amt_break_data
     */
    public void setItem_amt_break_data(Think.XmlWebServices.Item_amt_break_data item_amt_break_data) {
        this.item_amt_break_data = item_amt_break_data;
    }


    /**
     * Gets the currency value for this Package_item_data.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Package_item_data.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the customer_address_seq value for this Package_item_data.
     * 
     * @return customer_address_seq
     */
    public java.lang.Integer getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Package_item_data.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(java.lang.Integer customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the renew_to_customer_id value for this Package_item_data.
     * 
     * @return renew_to_customer_id
     */
    public java.lang.Integer getRenew_to_customer_id() {
        return renew_to_customer_id;
    }


    /**
     * Sets the renew_to_customer_id value for this Package_item_data.
     * 
     * @param renew_to_customer_id
     */
    public void setRenew_to_customer_id(java.lang.Integer renew_to_customer_id) {
        this.renew_to_customer_id = renew_to_customer_id;
    }


    /**
     * Gets the renew_to_customer_address_seq value for this Package_item_data.
     * 
     * @return renew_to_customer_address_seq
     */
    public java.lang.Integer getRenew_to_customer_address_seq() {
        return renew_to_customer_address_seq;
    }


    /**
     * Sets the renew_to_customer_address_seq value for this Package_item_data.
     * 
     * @param renew_to_customer_address_seq
     */
    public void setRenew_to_customer_address_seq(java.lang.Integer renew_to_customer_address_seq) {
        this.renew_to_customer_address_seq = renew_to_customer_address_seq;
    }


    /**
     * Gets the renewal_status value for this Package_item_data.
     * 
     * @return renewal_status
     */
    public java.lang.Integer getRenewal_status() {
        return renewal_status;
    }


    /**
     * Sets the renewal_status value for this Package_item_data.
     * 
     * @param renewal_status
     */
    public void setRenewal_status(java.lang.Integer renewal_status) {
        this.renewal_status = renewal_status;
    }


    /**
     * Gets the cancel_reason value for this Package_item_data.
     * 
     * @return cancel_reason
     */
    public java.lang.String getCancel_reason() {
        return cancel_reason;
    }


    /**
     * Sets the cancel_reason value for this Package_item_data.
     * 
     * @param cancel_reason
     */
    public void setCancel_reason(java.lang.String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }


    /**
     * Gets the auto_payment value for this Package_item_data.
     * 
     * @return auto_payment
     */
    public java.lang.Integer getAuto_payment() {
        return auto_payment;
    }


    /**
     * Sets the auto_payment value for this Package_item_data.
     * 
     * @param auto_payment
     */
    public void setAuto_payment(java.lang.Integer auto_payment) {
        this.auto_payment = auto_payment;
    }


    /**
     * Gets the payment_account_seq value for this Package_item_data.
     * 
     * @return payment_account_seq
     */
    public java.lang.Integer getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Package_item_data.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(java.lang.Integer payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the agency_customer_id value for this Package_item_data.
     * 
     * @return agency_customer_id
     */
    public java.lang.Integer getAgency_customer_id() {
        return agency_customer_id;
    }


    /**
     * Sets the agency_customer_id value for this Package_item_data.
     * 
     * @param agency_customer_id
     */
    public void setAgency_customer_id(java.lang.Integer agency_customer_id) {
        this.agency_customer_id = agency_customer_id;
    }


    /**
     * Gets the agent_ref_nbr value for this Package_item_data.
     * 
     * @return agent_ref_nbr
     */
    public java.lang.String getAgent_ref_nbr() {
        return agent_ref_nbr;
    }


    /**
     * Sets the agent_ref_nbr value for this Package_item_data.
     * 
     * @param agent_ref_nbr
     */
    public void setAgent_ref_nbr(java.lang.String agent_ref_nbr) {
        this.agent_ref_nbr = agent_ref_nbr;
    }


    /**
     * Gets the order_category value for this Package_item_data.
     * 
     * @return order_category
     */
    public java.lang.String getOrder_category() {
        return order_category;
    }


    /**
     * Sets the order_category value for this Package_item_data.
     * 
     * @param order_category
     */
    public void setOrder_category(java.lang.String order_category) {
        this.order_category = order_category;
    }


    /**
     * Gets the is_proforma value for this Package_item_data.
     * 
     * @return is_proforma
     */
    public java.lang.Boolean getIs_proforma() {
        return is_proforma;
    }


    /**
     * Sets the is_proforma value for this Package_item_data.
     * 
     * @param is_proforma
     */
    public void setIs_proforma(java.lang.Boolean is_proforma) {
        this.is_proforma = is_proforma;
    }


    /**
     * Gets the bill_to_customer_id value for this Package_item_data.
     * 
     * @return bill_to_customer_id
     */
    public java.lang.Integer getBill_to_customer_id() {
        return bill_to_customer_id;
    }


    /**
     * Sets the bill_to_customer_id value for this Package_item_data.
     * 
     * @param bill_to_customer_id
     */
    public void setBill_to_customer_id(java.lang.Integer bill_to_customer_id) {
        this.bill_to_customer_id = bill_to_customer_id;
    }


    /**
     * Gets the bill_to_customer_address_seq value for this Package_item_data.
     * 
     * @return bill_to_customer_address_seq
     */
    public java.lang.Integer getBill_to_customer_address_seq() {
        return bill_to_customer_address_seq;
    }


    /**
     * Sets the bill_to_customer_address_seq value for this Package_item_data.
     * 
     * @param bill_to_customer_address_seq
     */
    public void setBill_to_customer_address_seq(java.lang.Integer bill_to_customer_address_seq) {
        this.bill_to_customer_address_seq = bill_to_customer_address_seq;
    }


    /**
     * Gets the alt_ship_customer_id value for this Package_item_data.
     * 
     * @return alt_ship_customer_id
     */
    public java.lang.Integer getAlt_ship_customer_id() {
        return alt_ship_customer_id;
    }


    /**
     * Sets the alt_ship_customer_id value for this Package_item_data.
     * 
     * @param alt_ship_customer_id
     */
    public void setAlt_ship_customer_id(java.lang.Integer alt_ship_customer_id) {
        this.alt_ship_customer_id = alt_ship_customer_id;
    }


    /**
     * Gets the alt_ship_customer_address_seq value for this Package_item_data.
     * 
     * @return alt_ship_customer_address_seq
     */
    public java.lang.Integer getAlt_ship_customer_address_seq() {
        return alt_ship_customer_address_seq;
    }


    /**
     * Sets the alt_ship_customer_address_seq value for this Package_item_data.
     * 
     * @param alt_ship_customer_address_seq
     */
    public void setAlt_ship_customer_address_seq(java.lang.Integer alt_ship_customer_address_seq) {
        this.alt_ship_customer_address_seq = alt_ship_customer_address_seq;
    }


    /**
     * Gets the bill_date value for this Package_item_data.
     * 
     * @return bill_date
     */
    public java.util.Date getBill_date() {
        return bill_date;
    }


    /**
     * Sets the bill_date value for this Package_item_data.
     * 
     * @param bill_date
     */
    public void setBill_date(java.util.Date bill_date) {
        this.bill_date = bill_date;
    }


    /**
     * Gets the billing_type value for this Package_item_data.
     * 
     * @return billing_type
     */
    public java.lang.Integer getBilling_type() {
        return billing_type;
    }


    /**
     * Sets the billing_type value for this Package_item_data.
     * 
     * @param billing_type
     */
    public void setBilling_type(java.lang.Integer billing_type) {
        this.billing_type = billing_type;
    }


    /**
     * Gets the qual_date value for this Package_item_data.
     * 
     * @return qual_date
     */
    public java.util.Date getQual_date() {
        return qual_date;
    }


    /**
     * Sets the qual_date value for this Package_item_data.
     * 
     * @param qual_date
     */
    public void setQual_date(java.util.Date qual_date) {
        this.qual_date = qual_date;
    }


    /**
     * Gets the installment_plan_id value for this Package_item_data.
     * 
     * @return installment_plan_id
     */
    public java.lang.Integer getInstallment_plan_id() {
        return installment_plan_id;
    }


    /**
     * Sets the installment_plan_id value for this Package_item_data.
     * 
     * @param installment_plan_id
     */
    public void setInstallment_plan_id(java.lang.Integer installment_plan_id) {
        this.installment_plan_id = installment_plan_id;
    }


    /**
     * Gets the installment_data value for this Package_item_data.
     * 
     * @return installment_data
     */
    public Think.XmlWebServices.Installment_data getInstallment_data() {
        return installment_data;
    }


    /**
     * Sets the installment_data value for this Package_item_data.
     * 
     * @param installment_data
     */
    public void setInstallment_data(Think.XmlWebServices.Installment_data installment_data) {
        this.installment_data = installment_data;
    }


    /**
     * Gets the extended_days value for this Package_item_data.
     * 
     * @return extended_days
     */
    public java.lang.Integer getExtended_days() {
        return extended_days;
    }


    /**
     * Sets the extended_days value for this Package_item_data.
     * 
     * @param extended_days
     */
    public void setExtended_days(java.lang.Integer extended_days) {
        this.extended_days = extended_days;
    }


    /**
     * Gets the expire_date value for this Package_item_data.
     * 
     * @return expire_date
     */
    public java.util.Date getExpire_date() {
        return expire_date;
    }


    /**
     * Sets the expire_date value for this Package_item_data.
     * 
     * @param expire_date
     */
    public void setExpire_date(java.util.Date expire_date) {
        this.expire_date = expire_date;
    }


    /**
     * Gets the auxiliary_data value for this Package_item_data.
     * 
     * @return auxiliary_data
     */
    public Think.XmlWebServices.Auxiliary_data[] getAuxiliary_data() {
        return auxiliary_data;
    }


    /**
     * Sets the auxiliary_data value for this Package_item_data.
     * 
     * @param auxiliary_data
     */
    public void setAuxiliary_data(Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        this.auxiliary_data = auxiliary_data;
    }

    public Think.XmlWebServices.Auxiliary_data getAuxiliary_data(int i) {
        return this.auxiliary_data[i];
    }

    public void setAuxiliary_data(int i, Think.XmlWebServices.Auxiliary_data _value) {
        this.auxiliary_data[i] = _value;
    }


    /**
     * Gets the include_tax value for this Package_item_data.
     * 
     * @return include_tax
     */
    public Think.XmlWebServices.ZZBoolean getInclude_tax() {
        return include_tax;
    }


    /**
     * Sets the include_tax value for this Package_item_data.
     * 
     * @param include_tax
     */
    public void setInclude_tax(Think.XmlWebServices.ZZBoolean include_tax) {
        this.include_tax = include_tax;
    }


    /**
     * Gets the add_or_remove_mbrs value for this Package_item_data.
     * 
     * @return add_or_remove_mbrs
     */
    public Think.XmlWebServices.ZZBoolean getAdd_or_remove_mbrs() {
        return add_or_remove_mbrs;
    }


    /**
     * Sets the add_or_remove_mbrs value for this Package_item_data.
     * 
     * @param add_or_remove_mbrs
     */
    public void setAdd_or_remove_mbrs(Think.XmlWebServices.ZZBoolean add_or_remove_mbrs) {
        this.add_or_remove_mbrs = add_or_remove_mbrs;
    }


    /**
     * Gets the suppress_ccinfo_check value for this Package_item_data.
     * 
     * @return suppress_ccinfo_check
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_ccinfo_check() {
        return suppress_ccinfo_check;
    }


    /**
     * Sets the suppress_ccinfo_check value for this Package_item_data.
     * 
     * @param suppress_ccinfo_check
     */
    public void setSuppress_ccinfo_check(Think.XmlWebServices.ZZBoolean suppress_ccinfo_check) {
        this.suppress_ccinfo_check = suppress_ccinfo_check;
    }


    /**
     * Gets the ignore_bad_credit value for this Package_item_data.
     * 
     * @return ignore_bad_credit
     */
    public Think.XmlWebServices.ZZBoolean getIgnore_bad_credit() {
        return ignore_bad_credit;
    }


    /**
     * Sets the ignore_bad_credit value for this Package_item_data.
     * 
     * @param ignore_bad_credit
     */
    public void setIgnore_bad_credit(Think.XmlWebServices.ZZBoolean ignore_bad_credit) {
        this.ignore_bad_credit = ignore_bad_credit;
    }


    /**
     * Gets the threshold_option value for this Package_item_data.
     * 
     * @return threshold_option
     */
    public Think.XmlWebServices.Threshold_option_enum getThreshold_option() {
        return threshold_option;
    }


    /**
     * Sets the threshold_option value for this Package_item_data.
     * 
     * @param threshold_option
     */
    public void setThreshold_option(Think.XmlWebServices.Threshold_option_enum threshold_option) {
        this.threshold_option = threshold_option;
    }


    /**
     * Gets the no_content value for this Package_item_data.
     * 
     * @return no_content
     */
    public Think.XmlWebServices.ZZBoolean getNo_content() {
        return no_content;
    }


    /**
     * Sets the no_content value for this Package_item_data.
     * 
     * @param no_content
     */
    public void setNo_content(Think.XmlWebServices.ZZBoolean no_content) {
        this.no_content = no_content;
    }


    /**
     * Gets the cancel_member value for this Package_item_data.
     * 
     * @return cancel_member
     */
    public Think.XmlWebServices.ZZBoolean getCancel_member() {
        return cancel_member;
    }


    /**
     * Sets the cancel_member value for this Package_item_data.
     * 
     * @param cancel_member
     */
    public void setCancel_member(Think.XmlWebServices.ZZBoolean cancel_member) {
        this.cancel_member = cancel_member;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Package_item_data)) return false;
        Package_item_data other = (Package_item_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.source_code_id==null && other.getSource_code_id()==null) || 
             (this.source_code_id!=null &&
              this.source_code_id.equals(other.getSource_code_id()))) &&
            ((this.pkg_def_id==null && other.getPkg_def_id()==null) || 
             (this.pkg_def_id!=null &&
              this.pkg_def_id.equals(other.getPkg_def_id()))) &&
            ((this.rate_class_effective_seq==null && other.getRate_class_effective_seq()==null) || 
             (this.rate_class_effective_seq!=null &&
              this.rate_class_effective_seq.equals(other.getRate_class_effective_seq()))) &&
            ((this.bundle_qty==null && other.getBundle_qty()==null) || 
             (this.bundle_qty!=null &&
              this.bundle_qty.equals(other.getBundle_qty()))) &&
            ((this.item_amt_break_data==null && other.getItem_amt_break_data()==null) || 
             (this.item_amt_break_data!=null &&
              this.item_amt_break_data.equals(other.getItem_amt_break_data()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.customer_address_seq==null && other.getCustomer_address_seq()==null) || 
             (this.customer_address_seq!=null &&
              this.customer_address_seq.equals(other.getCustomer_address_seq()))) &&
            ((this.renew_to_customer_id==null && other.getRenew_to_customer_id()==null) || 
             (this.renew_to_customer_id!=null &&
              this.renew_to_customer_id.equals(other.getRenew_to_customer_id()))) &&
            ((this.renew_to_customer_address_seq==null && other.getRenew_to_customer_address_seq()==null) || 
             (this.renew_to_customer_address_seq!=null &&
              this.renew_to_customer_address_seq.equals(other.getRenew_to_customer_address_seq()))) &&
            ((this.renewal_status==null && other.getRenewal_status()==null) || 
             (this.renewal_status!=null &&
              this.renewal_status.equals(other.getRenewal_status()))) &&
            ((this.cancel_reason==null && other.getCancel_reason()==null) || 
             (this.cancel_reason!=null &&
              this.cancel_reason.equals(other.getCancel_reason()))) &&
            ((this.auto_payment==null && other.getAuto_payment()==null) || 
             (this.auto_payment!=null &&
              this.auto_payment.equals(other.getAuto_payment()))) &&
            ((this.payment_account_seq==null && other.getPayment_account_seq()==null) || 
             (this.payment_account_seq!=null &&
              this.payment_account_seq.equals(other.getPayment_account_seq()))) &&
            ((this.agency_customer_id==null && other.getAgency_customer_id()==null) || 
             (this.agency_customer_id!=null &&
              this.agency_customer_id.equals(other.getAgency_customer_id()))) &&
            ((this.agent_ref_nbr==null && other.getAgent_ref_nbr()==null) || 
             (this.agent_ref_nbr!=null &&
              this.agent_ref_nbr.equals(other.getAgent_ref_nbr()))) &&
            ((this.order_category==null && other.getOrder_category()==null) || 
             (this.order_category!=null &&
              this.order_category.equals(other.getOrder_category()))) &&
            ((this.is_proforma==null && other.getIs_proforma()==null) || 
             (this.is_proforma!=null &&
              this.is_proforma.equals(other.getIs_proforma()))) &&
            ((this.bill_to_customer_id==null && other.getBill_to_customer_id()==null) || 
             (this.bill_to_customer_id!=null &&
              this.bill_to_customer_id.equals(other.getBill_to_customer_id()))) &&
            ((this.bill_to_customer_address_seq==null && other.getBill_to_customer_address_seq()==null) || 
             (this.bill_to_customer_address_seq!=null &&
              this.bill_to_customer_address_seq.equals(other.getBill_to_customer_address_seq()))) &&
            ((this.alt_ship_customer_id==null && other.getAlt_ship_customer_id()==null) || 
             (this.alt_ship_customer_id!=null &&
              this.alt_ship_customer_id.equals(other.getAlt_ship_customer_id()))) &&
            ((this.alt_ship_customer_address_seq==null && other.getAlt_ship_customer_address_seq()==null) || 
             (this.alt_ship_customer_address_seq!=null &&
              this.alt_ship_customer_address_seq.equals(other.getAlt_ship_customer_address_seq()))) &&
            ((this.bill_date==null && other.getBill_date()==null) || 
             (this.bill_date!=null &&
              this.bill_date.equals(other.getBill_date()))) &&
            ((this.billing_type==null && other.getBilling_type()==null) || 
             (this.billing_type!=null &&
              this.billing_type.equals(other.getBilling_type()))) &&
            ((this.qual_date==null && other.getQual_date()==null) || 
             (this.qual_date!=null &&
              this.qual_date.equals(other.getQual_date()))) &&
            ((this.installment_plan_id==null && other.getInstallment_plan_id()==null) || 
             (this.installment_plan_id!=null &&
              this.installment_plan_id.equals(other.getInstallment_plan_id()))) &&
            ((this.installment_data==null && other.getInstallment_data()==null) || 
             (this.installment_data!=null &&
              this.installment_data.equals(other.getInstallment_data()))) &&
            ((this.extended_days==null && other.getExtended_days()==null) || 
             (this.extended_days!=null &&
              this.extended_days.equals(other.getExtended_days()))) &&
            ((this.expire_date==null && other.getExpire_date()==null) || 
             (this.expire_date!=null &&
              this.expire_date.equals(other.getExpire_date()))) &&
            ((this.auxiliary_data==null && other.getAuxiliary_data()==null) || 
             (this.auxiliary_data!=null &&
              java.util.Arrays.equals(this.auxiliary_data, other.getAuxiliary_data()))) &&
            ((this.include_tax==null && other.getInclude_tax()==null) || 
             (this.include_tax!=null &&
              this.include_tax.equals(other.getInclude_tax()))) &&
            ((this.add_or_remove_mbrs==null && other.getAdd_or_remove_mbrs()==null) || 
             (this.add_or_remove_mbrs!=null &&
              this.add_or_remove_mbrs.equals(other.getAdd_or_remove_mbrs()))) &&
            ((this.suppress_ccinfo_check==null && other.getSuppress_ccinfo_check()==null) || 
             (this.suppress_ccinfo_check!=null &&
              this.suppress_ccinfo_check.equals(other.getSuppress_ccinfo_check()))) &&
            ((this.ignore_bad_credit==null && other.getIgnore_bad_credit()==null) || 
             (this.ignore_bad_credit!=null &&
              this.ignore_bad_credit.equals(other.getIgnore_bad_credit()))) &&
            ((this.threshold_option==null && other.getThreshold_option()==null) || 
             (this.threshold_option!=null &&
              this.threshold_option.equals(other.getThreshold_option()))) &&
            ((this.no_content==null && other.getNo_content()==null) || 
             (this.no_content!=null &&
              this.no_content.equals(other.getNo_content()))) &&
            ((this.cancel_member==null && other.getCancel_member()==null) || 
             (this.cancel_member!=null &&
              this.cancel_member.equals(other.getCancel_member())));
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
        if (getSource_code_id() != null) {
            _hashCode += getSource_code_id().hashCode();
        }
        if (getPkg_def_id() != null) {
            _hashCode += getPkg_def_id().hashCode();
        }
        if (getRate_class_effective_seq() != null) {
            _hashCode += getRate_class_effective_seq().hashCode();
        }
        if (getBundle_qty() != null) {
            _hashCode += getBundle_qty().hashCode();
        }
        if (getItem_amt_break_data() != null) {
            _hashCode += getItem_amt_break_data().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getCustomer_address_seq() != null) {
            _hashCode += getCustomer_address_seq().hashCode();
        }
        if (getRenew_to_customer_id() != null) {
            _hashCode += getRenew_to_customer_id().hashCode();
        }
        if (getRenew_to_customer_address_seq() != null) {
            _hashCode += getRenew_to_customer_address_seq().hashCode();
        }
        if (getRenewal_status() != null) {
            _hashCode += getRenewal_status().hashCode();
        }
        if (getCancel_reason() != null) {
            _hashCode += getCancel_reason().hashCode();
        }
        if (getAuto_payment() != null) {
            _hashCode += getAuto_payment().hashCode();
        }
        if (getPayment_account_seq() != null) {
            _hashCode += getPayment_account_seq().hashCode();
        }
        if (getAgency_customer_id() != null) {
            _hashCode += getAgency_customer_id().hashCode();
        }
        if (getAgent_ref_nbr() != null) {
            _hashCode += getAgent_ref_nbr().hashCode();
        }
        if (getOrder_category() != null) {
            _hashCode += getOrder_category().hashCode();
        }
        if (getIs_proforma() != null) {
            _hashCode += getIs_proforma().hashCode();
        }
        if (getBill_to_customer_id() != null) {
            _hashCode += getBill_to_customer_id().hashCode();
        }
        if (getBill_to_customer_address_seq() != null) {
            _hashCode += getBill_to_customer_address_seq().hashCode();
        }
        if (getAlt_ship_customer_id() != null) {
            _hashCode += getAlt_ship_customer_id().hashCode();
        }
        if (getAlt_ship_customer_address_seq() != null) {
            _hashCode += getAlt_ship_customer_address_seq().hashCode();
        }
        if (getBill_date() != null) {
            _hashCode += getBill_date().hashCode();
        }
        if (getBilling_type() != null) {
            _hashCode += getBilling_type().hashCode();
        }
        if (getQual_date() != null) {
            _hashCode += getQual_date().hashCode();
        }
        if (getInstallment_plan_id() != null) {
            _hashCode += getInstallment_plan_id().hashCode();
        }
        if (getInstallment_data() != null) {
            _hashCode += getInstallment_data().hashCode();
        }
        if (getExtended_days() != null) {
            _hashCode += getExtended_days().hashCode();
        }
        if (getExpire_date() != null) {
            _hashCode += getExpire_date().hashCode();
        }
        if (getAuxiliary_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuxiliary_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuxiliary_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInclude_tax() != null) {
            _hashCode += getInclude_tax().hashCode();
        }
        if (getAdd_or_remove_mbrs() != null) {
            _hashCode += getAdd_or_remove_mbrs().hashCode();
        }
        if (getSuppress_ccinfo_check() != null) {
            _hashCode += getSuppress_ccinfo_check().hashCode();
        }
        if (getIgnore_bad_credit() != null) {
            _hashCode += getIgnore_bad_credit().hashCode();
        }
        if (getThreshold_option() != null) {
            _hashCode += getThreshold_option().hashCode();
        }
        if (getNo_content() != null) {
            _hashCode += getNo_content().hashCode();
        }
        if (getCancel_member() != null) {
            _hashCode += getCancel_member().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Package_item_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">package_item_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("include_tax");
        attrField.setXmlName(new javax.xml.namespace.QName("", "include_tax"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("add_or_remove_mbrs");
        attrField.setXmlName(new javax.xml.namespace.QName("", "add_or_remove_mbrs"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_ccinfo_check");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_ccinfo_check"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ignore_bad_credit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ignore_bad_credit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("threshold_option");
        attrField.setXmlName(new javax.xml.namespace.QName("", "threshold_option"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "threshold_option_enum"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("no_content");
        attrField.setXmlName(new javax.xml.namespace.QName("", "no_content"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_member");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_member"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "source_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkg_def_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_def_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate_class_effective_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "rate_class_effective_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bundle_qty");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bundle_qty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_amt_break_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_amt_break_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_amt_break_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renew_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renew_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renew_to_customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renew_to_customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auto_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auto_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agent_ref_nbr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agent_ref_nbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_proforma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "is_proforma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bill_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_to_customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bill_to_customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alt_ship_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "alt_ship_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alt_ship_customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "alt_ship_customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bill_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billing_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "billing_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qual_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "qual_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installment_plan_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "installment_plan_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installment_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "installment_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">installment_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extended_days");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "extended_days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expire_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "expire_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auxiliary_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
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
