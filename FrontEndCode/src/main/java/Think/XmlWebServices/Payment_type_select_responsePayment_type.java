/**
 * Payment_type_select_responsePayment_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_type_select_responsePayment_type  implements java.io.Serializable {
    private java.lang.String payment_type;  // attribute

    private java.lang.String description;  // attribute

    private int payment_form;  // attribute

    private int realize_cash_when;  // attribute

    private int use_as_default;  // attribute

    private int credit_card_type;  // attribute

    private int card_verification_usage;  // attribute

    public Payment_type_select_responsePayment_type() {
    }

    public Payment_type_select_responsePayment_type(
           java.lang.String payment_type,
           java.lang.String description,
           int payment_form,
           int realize_cash_when,
           int use_as_default,
           int credit_card_type,
           int card_verification_usage) {
           this.payment_type = payment_type;
           this.description = description;
           this.payment_form = payment_form;
           this.realize_cash_when = realize_cash_when;
           this.use_as_default = use_as_default;
           this.credit_card_type = credit_card_type;
           this.card_verification_usage = card_verification_usage;
    }


    /**
     * Gets the payment_type value for this Payment_type_select_responsePayment_type.
     * 
     * @return payment_type
     */
    public java.lang.String getPayment_type() {
        return payment_type;
    }


    /**
     * Sets the payment_type value for this Payment_type_select_responsePayment_type.
     * 
     * @param payment_type
     */
    public void setPayment_type(java.lang.String payment_type) {
        this.payment_type = payment_type;
    }


    /**
     * Gets the description value for this Payment_type_select_responsePayment_type.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Payment_type_select_responsePayment_type.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the payment_form value for this Payment_type_select_responsePayment_type.
     * 
     * @return payment_form
     */
    public int getPayment_form() {
        return payment_form;
    }


    /**
     * Sets the payment_form value for this Payment_type_select_responsePayment_type.
     * 
     * @param payment_form
     */
    public void setPayment_form(int payment_form) {
        this.payment_form = payment_form;
    }


    /**
     * Gets the realize_cash_when value for this Payment_type_select_responsePayment_type.
     * 
     * @return realize_cash_when
     */
    public int getRealize_cash_when() {
        return realize_cash_when;
    }


    /**
     * Sets the realize_cash_when value for this Payment_type_select_responsePayment_type.
     * 
     * @param realize_cash_when
     */
    public void setRealize_cash_when(int realize_cash_when) {
        this.realize_cash_when = realize_cash_when;
    }


    /**
     * Gets the use_as_default value for this Payment_type_select_responsePayment_type.
     * 
     * @return use_as_default
     */
    public int getUse_as_default() {
        return use_as_default;
    }


    /**
     * Sets the use_as_default value for this Payment_type_select_responsePayment_type.
     * 
     * @param use_as_default
     */
    public void setUse_as_default(int use_as_default) {
        this.use_as_default = use_as_default;
    }


    /**
     * Gets the credit_card_type value for this Payment_type_select_responsePayment_type.
     * 
     * @return credit_card_type
     */
    public int getCredit_card_type() {
        return credit_card_type;
    }


    /**
     * Sets the credit_card_type value for this Payment_type_select_responsePayment_type.
     * 
     * @param credit_card_type
     */
    public void setCredit_card_type(int credit_card_type) {
        this.credit_card_type = credit_card_type;
    }


    /**
     * Gets the card_verification_usage value for this Payment_type_select_responsePayment_type.
     * 
     * @return card_verification_usage
     */
    public int getCard_verification_usage() {
        return card_verification_usage;
    }


    /**
     * Sets the card_verification_usage value for this Payment_type_select_responsePayment_type.
     * 
     * @param card_verification_usage
     */
    public void setCard_verification_usage(int card_verification_usage) {
        this.card_verification_usage = card_verification_usage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_type_select_responsePayment_type)) return false;
        Payment_type_select_responsePayment_type other = (Payment_type_select_responsePayment_type) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payment_type==null && other.getPayment_type()==null) || 
             (this.payment_type!=null &&
              this.payment_type.equals(other.getPayment_type()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.payment_form == other.getPayment_form() &&
            this.realize_cash_when == other.getRealize_cash_when() &&
            this.use_as_default == other.getUse_as_default() &&
            this.credit_card_type == other.getCredit_card_type() &&
            this.card_verification_usage == other.getCard_verification_usage();
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
        if (getPayment_type() != null) {
            _hashCode += getPayment_type().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getPayment_form();
        _hashCode += getRealize_cash_when();
        _hashCode += getUse_as_default();
        _hashCode += getCredit_card_type();
        _hashCode += getCard_verification_usage();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_type_select_responsePayment_type.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_type_select_response>payment_type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_form");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_form"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("realize_cash_when");
        attrField.setXmlName(new javax.xml.namespace.QName("", "realize_cash_when"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("use_as_default");
        attrField.setXmlName(new javax.xml.namespace.QName("", "use_as_default"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("card_verification_usage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "card_verification_usage"));
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
