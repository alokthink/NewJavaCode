/**
 * View_payment_deposit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class View_payment_deposit  extends Think.XmlWebServices.ZZPayment  implements java.io.Serializable {
    private java.math.BigDecimal customer_deposit_base_amt;  // attribute

    private java.math.BigDecimal initial_deposit_pay_amt;  // attribute

    private java.math.BigDecimal initial_deposit_base_amt;  // attribute

    public View_payment_deposit() {
    }

    public View_payment_deposit(
           int customer_id,
           int payment_seq,
           java.lang.String auth_code,
           java.util.Date auth_date,
           java.lang.String ba_nbr,
           int bacs_id,
           java.math.BigDecimal base_amount,
           int cancel_itm_after_settle_retry,
           java.lang.String card_verification_value,
           int cash_realized,
           int cc_cleaned,
           java.lang.String check_number,
           java.util.Date clear_date,
           int commission,
           java.util.Calendar creation_date,
           int credit_card_bill_address_seq,
           int credit_card_bill_customer_id,
           java.lang.String credit_card_info,
           java.lang.String credit_card_issue_id,
           java.util.Date credit_card_start_date,
           java.lang.String currency,
           java.math.BigDecimal customer_deposit_pay_amt,
           int date_stamp,
           int deposit_transaction,
           int effort_nbr,
           java.util.Date exp_date,
           int hosted_secure_token_pmt,
           int ics_bank_def_id,
           java.lang.String id_nbr,
           java.lang.String id_nbr_last_four,
           int is_ecommerce,
           int is_recurring,
           int is_reversed,
           int max_settle_retries,
           int n_days_between_settle_retries,
           int n_settle_retries_left,
           int nbr_times_issued,
           int needs_memo_post,
           java.util.Date next_settle_retry_date,
           java.math.BigDecimal pay_currency_amount,
           java.math.BigDecimal pay_exchange_rate,
           int payment_account_seq,
           int payment_clear_method,
           int payment_clear_status,
           java.lang.String payment_type,
           int pending_xaction_header_id,
           int processing,
           int realize_cash_when,
           java.lang.String ref_nbr,
           java.math.BigDecimal refund_deposit_pay_amt,
           int status_noedit,
           int suspend_after_n_settle_retries,
           java.lang.String transaction_reason,
           int transaction_type,
           java.lang.String user_code,
           java.math.BigDecimal customer_deposit_base_amt,
           java.math.BigDecimal initial_deposit_pay_amt,
           java.math.BigDecimal initial_deposit_base_amt) {
        super(
            customer_id,
            payment_seq,
            auth_code,
            auth_date,
            ba_nbr,
            bacs_id,
            base_amount,
            cancel_itm_after_settle_retry,
            card_verification_value,
            cash_realized,
            cc_cleaned,
            check_number,
            clear_date,
            commission,
            creation_date,
            credit_card_bill_address_seq,
            credit_card_bill_customer_id,
            credit_card_info,
            credit_card_issue_id,
            credit_card_start_date,
            currency,
            customer_deposit_pay_amt,
            date_stamp,
            deposit_transaction,
            effort_nbr,
            exp_date,
            hosted_secure_token_pmt,
            ics_bank_def_id,
            id_nbr,
            id_nbr_last_four,
            is_ecommerce,
            is_recurring,
            is_reversed,
            max_settle_retries,
            n_days_between_settle_retries,
            n_settle_retries_left,
            nbr_times_issued,
            needs_memo_post,
            next_settle_retry_date,
            pay_currency_amount,
            pay_exchange_rate,
            payment_account_seq,
            payment_clear_method,
            payment_clear_status,
            payment_type,
            pending_xaction_header_id,
            processing,
            realize_cash_when,
            ref_nbr,
            refund_deposit_pay_amt,
            status_noedit,
            suspend_after_n_settle_retries,
            transaction_reason,
            transaction_type,
            user_code);
        this.customer_deposit_base_amt = customer_deposit_base_amt;
        this.initial_deposit_pay_amt = initial_deposit_pay_amt;
        this.initial_deposit_base_amt = initial_deposit_base_amt;
    }


    /**
     * Gets the customer_deposit_base_amt value for this View_payment_deposit.
     * 
     * @return customer_deposit_base_amt
     */
    public java.math.BigDecimal getCustomer_deposit_base_amt() {
        return customer_deposit_base_amt;
    }


    /**
     * Sets the customer_deposit_base_amt value for this View_payment_deposit.
     * 
     * @param customer_deposit_base_amt
     */
    public void setCustomer_deposit_base_amt(java.math.BigDecimal customer_deposit_base_amt) {
        this.customer_deposit_base_amt = customer_deposit_base_amt;
    }


    /**
     * Gets the initial_deposit_pay_amt value for this View_payment_deposit.
     * 
     * @return initial_deposit_pay_amt
     */
    public java.math.BigDecimal getInitial_deposit_pay_amt() {
        return initial_deposit_pay_amt;
    }


    /**
     * Sets the initial_deposit_pay_amt value for this View_payment_deposit.
     * 
     * @param initial_deposit_pay_amt
     */
    public void setInitial_deposit_pay_amt(java.math.BigDecimal initial_deposit_pay_amt) {
        this.initial_deposit_pay_amt = initial_deposit_pay_amt;
    }


    /**
     * Gets the initial_deposit_base_amt value for this View_payment_deposit.
     * 
     * @return initial_deposit_base_amt
     */
    public java.math.BigDecimal getInitial_deposit_base_amt() {
        return initial_deposit_base_amt;
    }


    /**
     * Sets the initial_deposit_base_amt value for this View_payment_deposit.
     * 
     * @param initial_deposit_base_amt
     */
    public void setInitial_deposit_base_amt(java.math.BigDecimal initial_deposit_base_amt) {
        this.initial_deposit_base_amt = initial_deposit_base_amt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_payment_deposit)) return false;
        View_payment_deposit other = (View_payment_deposit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_deposit_base_amt==null && other.getCustomer_deposit_base_amt()==null) || 
             (this.customer_deposit_base_amt!=null &&
              this.customer_deposit_base_amt.equals(other.getCustomer_deposit_base_amt()))) &&
            ((this.initial_deposit_pay_amt==null && other.getInitial_deposit_pay_amt()==null) || 
             (this.initial_deposit_pay_amt!=null &&
              this.initial_deposit_pay_amt.equals(other.getInitial_deposit_pay_amt()))) &&
            ((this.initial_deposit_base_amt==null && other.getInitial_deposit_base_amt()==null) || 
             (this.initial_deposit_base_amt!=null &&
              this.initial_deposit_base_amt.equals(other.getInitial_deposit_base_amt())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCustomer_deposit_base_amt() != null) {
            _hashCode += getCustomer_deposit_base_amt().hashCode();
        }
        if (getInitial_deposit_pay_amt() != null) {
            _hashCode += getInitial_deposit_pay_amt().hashCode();
        }
        if (getInitial_deposit_base_amt() != null) {
            _hashCode += getInitial_deposit_base_amt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_payment_deposit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">view_payment_deposit"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_deposit_base_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_deposit_base_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("initial_deposit_pay_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "initial_deposit_pay_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("initial_deposit_base_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "initial_deposit_base_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
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
