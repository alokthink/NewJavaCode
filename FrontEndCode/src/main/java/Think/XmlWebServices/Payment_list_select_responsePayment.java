/**
 * Payment_list_select_responsePayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_list_select_responsePayment  implements java.io.Serializable {
    private int payment_seq;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private java.lang.String user_code;  // attribute

    private java.lang.String id_nbr;  // attribute

    private java.lang.String currency;  // attribute

    private java.math.BigDecimal pay_currency_amount;  // attribute

    private int payment_clear_status;  // attribute

    private java.lang.String transaction_reason;  // attribute

    private int transaction_type;  // attribute

    private java.lang.String check_number;  // attribute

    private java.lang.String id_nbr_last_four;  // attribute

    private java.util.Date exp_date;  // attribute

    private int payment_account_seq;  // attribute

    private java.lang.String payment_type;  // attribute

    private int payment_form;  // attribute

    private java.lang.String payment_cls_desc;  // attribute

    private java.lang.String transaction_reason_descr;  // attribute

    private java.lang.String tran_type_desc;  // attribute

    public Payment_list_select_responsePayment() {
    }

    public Payment_list_select_responsePayment(
           int payment_seq,
           java.util.Calendar creation_date,
           java.lang.String user_code,
           java.lang.String id_nbr,
           java.lang.String currency,
           java.math.BigDecimal pay_currency_amount,
           int payment_clear_status,
           java.lang.String transaction_reason,
           int transaction_type,
           java.lang.String check_number,
           java.lang.String id_nbr_last_four,
           java.util.Date exp_date,
           int payment_account_seq,
           java.lang.String payment_type,
           int payment_form,
           java.lang.String payment_cls_desc,
           java.lang.String transaction_reason_descr,
           java.lang.String tran_type_desc) {
           this.payment_seq = payment_seq;
           this.creation_date = creation_date;
           this.user_code = user_code;
           this.id_nbr = id_nbr;
           this.currency = currency;
           this.pay_currency_amount = pay_currency_amount;
           this.payment_clear_status = payment_clear_status;
           this.transaction_reason = transaction_reason;
           this.transaction_type = transaction_type;
           this.check_number = check_number;
           this.id_nbr_last_four = id_nbr_last_four;
           this.exp_date = exp_date;
           this.payment_account_seq = payment_account_seq;
           this.payment_type = payment_type;
           this.payment_form = payment_form;
           this.payment_cls_desc = payment_cls_desc;
           this.transaction_reason_descr = transaction_reason_descr;
           this.tran_type_desc = tran_type_desc;
    }


    /**
     * Gets the payment_seq value for this Payment_list_select_responsePayment.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Payment_list_select_responsePayment.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the creation_date value for this Payment_list_select_responsePayment.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Payment_list_select_responsePayment.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the user_code value for this Payment_list_select_responsePayment.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Payment_list_select_responsePayment.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the id_nbr value for this Payment_list_select_responsePayment.
     * 
     * @return id_nbr
     */
    public java.lang.String getId_nbr() {
        return id_nbr;
    }


    /**
     * Sets the id_nbr value for this Payment_list_select_responsePayment.
     * 
     * @param id_nbr
     */
    public void setId_nbr(java.lang.String id_nbr) {
        this.id_nbr = id_nbr;
    }


    /**
     * Gets the currency value for this Payment_list_select_responsePayment.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Payment_list_select_responsePayment.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the pay_currency_amount value for this Payment_list_select_responsePayment.
     * 
     * @return pay_currency_amount
     */
    public java.math.BigDecimal getPay_currency_amount() {
        return pay_currency_amount;
    }


    /**
     * Sets the pay_currency_amount value for this Payment_list_select_responsePayment.
     * 
     * @param pay_currency_amount
     */
    public void setPay_currency_amount(java.math.BigDecimal pay_currency_amount) {
        this.pay_currency_amount = pay_currency_amount;
    }


    /**
     * Gets the payment_clear_status value for this Payment_list_select_responsePayment.
     * 
     * @return payment_clear_status
     */
    public int getPayment_clear_status() {
        return payment_clear_status;
    }


    /**
     * Sets the payment_clear_status value for this Payment_list_select_responsePayment.
     * 
     * @param payment_clear_status
     */
    public void setPayment_clear_status(int payment_clear_status) {
        this.payment_clear_status = payment_clear_status;
    }


    /**
     * Gets the transaction_reason value for this Payment_list_select_responsePayment.
     * 
     * @return transaction_reason
     */
    public java.lang.String getTransaction_reason() {
        return transaction_reason;
    }


    /**
     * Sets the transaction_reason value for this Payment_list_select_responsePayment.
     * 
     * @param transaction_reason
     */
    public void setTransaction_reason(java.lang.String transaction_reason) {
        this.transaction_reason = transaction_reason;
    }


    /**
     * Gets the transaction_type value for this Payment_list_select_responsePayment.
     * 
     * @return transaction_type
     */
    public int getTransaction_type() {
        return transaction_type;
    }


    /**
     * Sets the transaction_type value for this Payment_list_select_responsePayment.
     * 
     * @param transaction_type
     */
    public void setTransaction_type(int transaction_type) {
        this.transaction_type = transaction_type;
    }


    /**
     * Gets the check_number value for this Payment_list_select_responsePayment.
     * 
     * @return check_number
     */
    public java.lang.String getCheck_number() {
        return check_number;
    }


    /**
     * Sets the check_number value for this Payment_list_select_responsePayment.
     * 
     * @param check_number
     */
    public void setCheck_number(java.lang.String check_number) {
        this.check_number = check_number;
    }


    /**
     * Gets the id_nbr_last_four value for this Payment_list_select_responsePayment.
     * 
     * @return id_nbr_last_four
     */
    public java.lang.String getId_nbr_last_four() {
        return id_nbr_last_four;
    }


    /**
     * Sets the id_nbr_last_four value for this Payment_list_select_responsePayment.
     * 
     * @param id_nbr_last_four
     */
    public void setId_nbr_last_four(java.lang.String id_nbr_last_four) {
        this.id_nbr_last_four = id_nbr_last_four;
    }


    /**
     * Gets the exp_date value for this Payment_list_select_responsePayment.
     * 
     * @return exp_date
     */
    public java.util.Date getExp_date() {
        return exp_date;
    }


    /**
     * Sets the exp_date value for this Payment_list_select_responsePayment.
     * 
     * @param exp_date
     */
    public void setExp_date(java.util.Date exp_date) {
        this.exp_date = exp_date;
    }


    /**
     * Gets the payment_account_seq value for this Payment_list_select_responsePayment.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Payment_list_select_responsePayment.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the payment_type value for this Payment_list_select_responsePayment.
     * 
     * @return payment_type
     */
    public java.lang.String getPayment_type() {
        return payment_type;
    }


    /**
     * Sets the payment_type value for this Payment_list_select_responsePayment.
     * 
     * @param payment_type
     */
    public void setPayment_type(java.lang.String payment_type) {
        this.payment_type = payment_type;
    }


    /**
     * Gets the payment_form value for this Payment_list_select_responsePayment.
     * 
     * @return payment_form
     */
    public int getPayment_form() {
        return payment_form;
    }


    /**
     * Sets the payment_form value for this Payment_list_select_responsePayment.
     * 
     * @param payment_form
     */
    public void setPayment_form(int payment_form) {
        this.payment_form = payment_form;
    }


    /**
     * Gets the payment_cls_desc value for this Payment_list_select_responsePayment.
     * 
     * @return payment_cls_desc
     */
    public java.lang.String getPayment_cls_desc() {
        return payment_cls_desc;
    }


    /**
     * Sets the payment_cls_desc value for this Payment_list_select_responsePayment.
     * 
     * @param payment_cls_desc
     */
    public void setPayment_cls_desc(java.lang.String payment_cls_desc) {
        this.payment_cls_desc = payment_cls_desc;
    }


    /**
     * Gets the transaction_reason_descr value for this Payment_list_select_responsePayment.
     * 
     * @return transaction_reason_descr
     */
    public java.lang.String getTransaction_reason_descr() {
        return transaction_reason_descr;
    }


    /**
     * Sets the transaction_reason_descr value for this Payment_list_select_responsePayment.
     * 
     * @param transaction_reason_descr
     */
    public void setTransaction_reason_descr(java.lang.String transaction_reason_descr) {
        this.transaction_reason_descr = transaction_reason_descr;
    }


    /**
     * Gets the tran_type_desc value for this Payment_list_select_responsePayment.
     * 
     * @return tran_type_desc
     */
    public java.lang.String getTran_type_desc() {
        return tran_type_desc;
    }


    /**
     * Sets the tran_type_desc value for this Payment_list_select_responsePayment.
     * 
     * @param tran_type_desc
     */
    public void setTran_type_desc(java.lang.String tran_type_desc) {
        this.tran_type_desc = tran_type_desc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_list_select_responsePayment)) return false;
        Payment_list_select_responsePayment other = (Payment_list_select_responsePayment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.payment_seq == other.getPayment_seq() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.id_nbr==null && other.getId_nbr()==null) || 
             (this.id_nbr!=null &&
              this.id_nbr.equals(other.getId_nbr()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.pay_currency_amount==null && other.getPay_currency_amount()==null) || 
             (this.pay_currency_amount!=null &&
              this.pay_currency_amount.equals(other.getPay_currency_amount()))) &&
            this.payment_clear_status == other.getPayment_clear_status() &&
            ((this.transaction_reason==null && other.getTransaction_reason()==null) || 
             (this.transaction_reason!=null &&
              this.transaction_reason.equals(other.getTransaction_reason()))) &&
            this.transaction_type == other.getTransaction_type() &&
            ((this.check_number==null && other.getCheck_number()==null) || 
             (this.check_number!=null &&
              this.check_number.equals(other.getCheck_number()))) &&
            ((this.id_nbr_last_four==null && other.getId_nbr_last_four()==null) || 
             (this.id_nbr_last_four!=null &&
              this.id_nbr_last_four.equals(other.getId_nbr_last_four()))) &&
            ((this.exp_date==null && other.getExp_date()==null) || 
             (this.exp_date!=null &&
              this.exp_date.equals(other.getExp_date()))) &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            ((this.payment_type==null && other.getPayment_type()==null) || 
             (this.payment_type!=null &&
              this.payment_type.equals(other.getPayment_type()))) &&
            this.payment_form == other.getPayment_form() &&
            ((this.payment_cls_desc==null && other.getPayment_cls_desc()==null) || 
             (this.payment_cls_desc!=null &&
              this.payment_cls_desc.equals(other.getPayment_cls_desc()))) &&
            ((this.transaction_reason_descr==null && other.getTransaction_reason_descr()==null) || 
             (this.transaction_reason_descr!=null &&
              this.transaction_reason_descr.equals(other.getTransaction_reason_descr()))) &&
            ((this.tran_type_desc==null && other.getTran_type_desc()==null) || 
             (this.tran_type_desc!=null &&
              this.tran_type_desc.equals(other.getTran_type_desc())));
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
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getId_nbr() != null) {
            _hashCode += getId_nbr().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getPay_currency_amount() != null) {
            _hashCode += getPay_currency_amount().hashCode();
        }
        _hashCode += getPayment_clear_status();
        if (getTransaction_reason() != null) {
            _hashCode += getTransaction_reason().hashCode();
        }
        _hashCode += getTransaction_type();
        if (getCheck_number() != null) {
            _hashCode += getCheck_number().hashCode();
        }
        if (getId_nbr_last_four() != null) {
            _hashCode += getId_nbr_last_four().hashCode();
        }
        if (getExp_date() != null) {
            _hashCode += getExp_date().hashCode();
        }
        _hashCode += getPayment_account_seq();
        if (getPayment_type() != null) {
            _hashCode += getPayment_type().hashCode();
        }
        _hashCode += getPayment_form();
        if (getPayment_cls_desc() != null) {
            _hashCode += getPayment_cls_desc().hashCode();
        }
        if (getTransaction_reason_descr() != null) {
            _hashCode += getTransaction_reason_descr().hashCode();
        }
        if (getTran_type_desc() != null) {
            _hashCode += getTran_type_desc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_list_select_responsePayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_list_select_response>payment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_currency_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_currency_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_clear_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_clear_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        attrField.setFieldName("check_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "check_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id_nbr_last_four");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id_nbr_last_four"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("exp_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "exp_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_form");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_form"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_cls_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_cls_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transaction_reason_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transaction_reason_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tran_type_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tran_type_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
