/**
 * Payment_refund_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_refund_data  extends Think.XmlWebServices.ZZCreditCard  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Payment_account_identifier payment_account_identifier;

    private java.math.BigDecimal amount;

    private java.lang.String currency;

    private java.lang.String transaction_reason;

    private java.lang.String payment_type;

    private java.lang.String id_nbr_last_four;

    private java.util.Date exp_date;

    private Think.XmlWebServices.ZZBoolean skip_bank_def_ref_num_check;  // attribute

    private Think.XmlWebServices.ZZBoolean refund_to_deposit;  // attribute

    public Payment_refund_data() {
    }

    public Payment_refund_data(
           java.util.Date card_expire_date,
           java.lang.String card_number,
           java.lang.String card_verification_value,
           java.lang.Integer credit_card_bill_address_seq,
           java.lang.Integer credit_card_bill_customer_id,
           java.lang.String credit_card_info,
           java.lang.String credit_card_issue_id,
           java.util.Date credit_card_start_date,
           Think.XmlWebServices.ZZBoolean skip_bank_def_ref_num_check,
           Think.XmlWebServices.ZZBoolean refund_to_deposit,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Payment_account_identifier payment_account_identifier,
           java.math.BigDecimal amount,
           java.lang.String currency,
           java.lang.String transaction_reason,
           java.lang.String payment_type,
           java.lang.String id_nbr_last_four,
           java.util.Date exp_date) {
        super(
            card_expire_date,
            card_number,
            card_verification_value,
            credit_card_bill_address_seq,
            credit_card_bill_customer_id,
            credit_card_info,
            credit_card_issue_id,
            credit_card_start_date);
        this.skip_bank_def_ref_num_check = skip_bank_def_ref_num_check;
        this.refund_to_deposit = refund_to_deposit;
        this.customer_identifier = customer_identifier;
        this.payment_account_identifier = payment_account_identifier;
        this.amount = amount;
        this.currency = currency;
        this.transaction_reason = transaction_reason;
        this.payment_type = payment_type;
        this.id_nbr_last_four = id_nbr_last_four;
        this.exp_date = exp_date;
    }


    /**
     * Gets the customer_identifier value for this Payment_refund_data.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_refund_data.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the payment_account_identifier value for this Payment_refund_data.
     * 
     * @return payment_account_identifier
     */
    public Think.XmlWebServices.Payment_account_identifier getPayment_account_identifier() {
        return payment_account_identifier;
    }


    /**
     * Sets the payment_account_identifier value for this Payment_refund_data.
     * 
     * @param payment_account_identifier
     */
    public void setPayment_account_identifier(Think.XmlWebServices.Payment_account_identifier payment_account_identifier) {
        this.payment_account_identifier = payment_account_identifier;
    }


    /**
     * Gets the amount value for this Payment_refund_data.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Payment_refund_data.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the currency value for this Payment_refund_data.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Payment_refund_data.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the transaction_reason value for this Payment_refund_data.
     * 
     * @return transaction_reason
     */
    public java.lang.String getTransaction_reason() {
        return transaction_reason;
    }


    /**
     * Sets the transaction_reason value for this Payment_refund_data.
     * 
     * @param transaction_reason
     */
    public void setTransaction_reason(java.lang.String transaction_reason) {
        this.transaction_reason = transaction_reason;
    }


    /**
     * Gets the payment_type value for this Payment_refund_data.
     * 
     * @return payment_type
     */
    public java.lang.String getPayment_type() {
        return payment_type;
    }


    /**
     * Sets the payment_type value for this Payment_refund_data.
     * 
     * @param payment_type
     */
    public void setPayment_type(java.lang.String payment_type) {
        this.payment_type = payment_type;
    }


    /**
     * Gets the id_nbr_last_four value for this Payment_refund_data.
     * 
     * @return id_nbr_last_four
     */
    public java.lang.String getId_nbr_last_four() {
        return id_nbr_last_four;
    }


    /**
     * Sets the id_nbr_last_four value for this Payment_refund_data.
     * 
     * @param id_nbr_last_four
     */
    public void setId_nbr_last_four(java.lang.String id_nbr_last_four) {
        this.id_nbr_last_four = id_nbr_last_four;
    }


    /**
     * Gets the exp_date value for this Payment_refund_data.
     * 
     * @return exp_date
     */
    public java.util.Date getExp_date() {
        return exp_date;
    }


    /**
     * Sets the exp_date value for this Payment_refund_data.
     * 
     * @param exp_date
     */
    public void setExp_date(java.util.Date exp_date) {
        this.exp_date = exp_date;
    }


    /**
     * Gets the skip_bank_def_ref_num_check value for this Payment_refund_data.
     * 
     * @return skip_bank_def_ref_num_check
     */
    public Think.XmlWebServices.ZZBoolean getSkip_bank_def_ref_num_check() {
        return skip_bank_def_ref_num_check;
    }


    /**
     * Sets the skip_bank_def_ref_num_check value for this Payment_refund_data.
     * 
     * @param skip_bank_def_ref_num_check
     */
    public void setSkip_bank_def_ref_num_check(Think.XmlWebServices.ZZBoolean skip_bank_def_ref_num_check) {
        this.skip_bank_def_ref_num_check = skip_bank_def_ref_num_check;
    }


    /**
     * Gets the refund_to_deposit value for this Payment_refund_data.
     * 
     * @return refund_to_deposit
     */
    public Think.XmlWebServices.ZZBoolean getRefund_to_deposit() {
        return refund_to_deposit;
    }


    /**
     * Sets the refund_to_deposit value for this Payment_refund_data.
     * 
     * @param refund_to_deposit
     */
    public void setRefund_to_deposit(Think.XmlWebServices.ZZBoolean refund_to_deposit) {
        this.refund_to_deposit = refund_to_deposit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_refund_data)) return false;
        Payment_refund_data other = (Payment_refund_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.payment_account_identifier==null && other.getPayment_account_identifier()==null) || 
             (this.payment_account_identifier!=null &&
              this.payment_account_identifier.equals(other.getPayment_account_identifier()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.transaction_reason==null && other.getTransaction_reason()==null) || 
             (this.transaction_reason!=null &&
              this.transaction_reason.equals(other.getTransaction_reason()))) &&
            ((this.payment_type==null && other.getPayment_type()==null) || 
             (this.payment_type!=null &&
              this.payment_type.equals(other.getPayment_type()))) &&
            ((this.id_nbr_last_four==null && other.getId_nbr_last_four()==null) || 
             (this.id_nbr_last_four!=null &&
              this.id_nbr_last_four.equals(other.getId_nbr_last_four()))) &&
            ((this.exp_date==null && other.getExp_date()==null) || 
             (this.exp_date!=null &&
              this.exp_date.equals(other.getExp_date()))) &&
            ((this.skip_bank_def_ref_num_check==null && other.getSkip_bank_def_ref_num_check()==null) || 
             (this.skip_bank_def_ref_num_check!=null &&
              this.skip_bank_def_ref_num_check.equals(other.getSkip_bank_def_ref_num_check()))) &&
            ((this.refund_to_deposit==null && other.getRefund_to_deposit()==null) || 
             (this.refund_to_deposit!=null &&
              this.refund_to_deposit.equals(other.getRefund_to_deposit())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getPayment_account_identifier() != null) {
            _hashCode += getPayment_account_identifier().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getTransaction_reason() != null) {
            _hashCode += getTransaction_reason().hashCode();
        }
        if (getPayment_type() != null) {
            _hashCode += getPayment_type().hashCode();
        }
        if (getId_nbr_last_four() != null) {
            _hashCode += getId_nbr_last_four().hashCode();
        }
        if (getExp_date() != null) {
            _hashCode += getExp_date().hashCode();
        }
        if (getSkip_bank_def_ref_num_check() != null) {
            _hashCode += getSkip_bank_def_ref_num_check().hashCode();
        }
        if (getRefund_to_deposit() != null) {
            _hashCode += getRefund_to_deposit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_refund_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_refund_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("skip_bank_def_ref_num_check");
        attrField.setXmlName(new javax.xml.namespace.QName("", "skip_bank_def_ref_num_check"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_to_deposit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_to_deposit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaction_reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transaction_reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_nbr_last_four");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "id_nbr_last_four"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exp_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "exp_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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

	@Override
	public String toString() {
		return "Payment_refund_data [customer_identifier=" + customer_identifier + ", payment_account_identifier="
				+ payment_account_identifier + ", amount=" + amount + ", currency=" + currency + ", transaction_reason="
				+ transaction_reason + ", payment_type=" + payment_type + ", id_nbr_last_four=" + id_nbr_last_four
				+ ", exp_date=" + exp_date + ", skip_bank_def_ref_num_check=" + skip_bank_def_ref_num_check
				+ ", refund_to_deposit=" + refund_to_deposit + ", __equalsCalc=" + __equalsCalc + ", __hashCodeCalc="
				+ __hashCodeCalc + "]";
	}
    

}
