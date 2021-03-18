/**
 * Payment_amount_info_select_responsePayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_amount_info_select_responsePayment  implements java.io.Serializable {
    private int payment_seq;  // attribute

    private java.math.BigDecimal pay_currency_amount;  // attribute

    private java.lang.String currency;  // attribute

    private java.math.BigDecimal customer_deposit_pay_amt;  // attribute

    private java.math.BigDecimal refund_deposit_pay_amt;  // attribute

    private java.math.BigDecimal base_amount;  // attribute

    public Payment_amount_info_select_responsePayment() {
    }

    public Payment_amount_info_select_responsePayment(
           int payment_seq,
           java.math.BigDecimal pay_currency_amount,
           java.lang.String currency,
           java.math.BigDecimal customer_deposit_pay_amt,
           java.math.BigDecimal refund_deposit_pay_amt,
           java.math.BigDecimal base_amount) {
           this.payment_seq = payment_seq;
           this.pay_currency_amount = pay_currency_amount;
           this.currency = currency;
           this.customer_deposit_pay_amt = customer_deposit_pay_amt;
           this.refund_deposit_pay_amt = refund_deposit_pay_amt;
           this.base_amount = base_amount;
    }


    /**
     * Gets the payment_seq value for this Payment_amount_info_select_responsePayment.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Payment_amount_info_select_responsePayment.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the pay_currency_amount value for this Payment_amount_info_select_responsePayment.
     * 
     * @return pay_currency_amount
     */
    public java.math.BigDecimal getPay_currency_amount() {
        return pay_currency_amount;
    }


    /**
     * Sets the pay_currency_amount value for this Payment_amount_info_select_responsePayment.
     * 
     * @param pay_currency_amount
     */
    public void setPay_currency_amount(java.math.BigDecimal pay_currency_amount) {
        this.pay_currency_amount = pay_currency_amount;
    }


    /**
     * Gets the currency value for this Payment_amount_info_select_responsePayment.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Payment_amount_info_select_responsePayment.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the customer_deposit_pay_amt value for this Payment_amount_info_select_responsePayment.
     * 
     * @return customer_deposit_pay_amt
     */
    public java.math.BigDecimal getCustomer_deposit_pay_amt() {
        return customer_deposit_pay_amt;
    }


    /**
     * Sets the customer_deposit_pay_amt value for this Payment_amount_info_select_responsePayment.
     * 
     * @param customer_deposit_pay_amt
     */
    public void setCustomer_deposit_pay_amt(java.math.BigDecimal customer_deposit_pay_amt) {
        this.customer_deposit_pay_amt = customer_deposit_pay_amt;
    }


    /**
     * Gets the refund_deposit_pay_amt value for this Payment_amount_info_select_responsePayment.
     * 
     * @return refund_deposit_pay_amt
     */
    public java.math.BigDecimal getRefund_deposit_pay_amt() {
        return refund_deposit_pay_amt;
    }


    /**
     * Sets the refund_deposit_pay_amt value for this Payment_amount_info_select_responsePayment.
     * 
     * @param refund_deposit_pay_amt
     */
    public void setRefund_deposit_pay_amt(java.math.BigDecimal refund_deposit_pay_amt) {
        this.refund_deposit_pay_amt = refund_deposit_pay_amt;
    }


    /**
     * Gets the base_amount value for this Payment_amount_info_select_responsePayment.
     * 
     * @return base_amount
     */
    public java.math.BigDecimal getBase_amount() {
        return base_amount;
    }


    /**
     * Sets the base_amount value for this Payment_amount_info_select_responsePayment.
     * 
     * @param base_amount
     */
    public void setBase_amount(java.math.BigDecimal base_amount) {
        this.base_amount = base_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_amount_info_select_responsePayment)) return false;
        Payment_amount_info_select_responsePayment other = (Payment_amount_info_select_responsePayment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.payment_seq == other.getPayment_seq() &&
            ((this.pay_currency_amount==null && other.getPay_currency_amount()==null) || 
             (this.pay_currency_amount!=null &&
              this.pay_currency_amount.equals(other.getPay_currency_amount()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.customer_deposit_pay_amt==null && other.getCustomer_deposit_pay_amt()==null) || 
             (this.customer_deposit_pay_amt!=null &&
              this.customer_deposit_pay_amt.equals(other.getCustomer_deposit_pay_amt()))) &&
            ((this.refund_deposit_pay_amt==null && other.getRefund_deposit_pay_amt()==null) || 
             (this.refund_deposit_pay_amt!=null &&
              this.refund_deposit_pay_amt.equals(other.getRefund_deposit_pay_amt()))) &&
            ((this.base_amount==null && other.getBase_amount()==null) || 
             (this.base_amount!=null &&
              this.base_amount.equals(other.getBase_amount())));
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
        _hashCode += getPayment_seq();
        if (getPay_currency_amount() != null) {
            _hashCode += getPay_currency_amount().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getCustomer_deposit_pay_amt() != null) {
            _hashCode += getCustomer_deposit_pay_amt().hashCode();
        }
        if (getRefund_deposit_pay_amt() != null) {
            _hashCode += getRefund_deposit_pay_amt().hashCode();
        }
        if (getBase_amount() != null) {
            _hashCode += getBase_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_amount_info_select_responsePayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_amount_info_select_response>payment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_currency_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_currency_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_deposit_pay_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_deposit_pay_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refund_deposit_pay_amt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "refund_deposit_pay_amt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "base_amount"));
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
