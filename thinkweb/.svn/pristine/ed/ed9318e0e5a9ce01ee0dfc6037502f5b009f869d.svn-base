/**
 * Payment_account_clear_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_account_clear_response  implements java.io.Serializable {
    private Think.XmlWebServices.Payment_account_identifier payment_account_identifier;

    private Think.XmlWebServices.ZZPaymentAccount payment_account;

    public Payment_account_clear_response() {
    }

    public Payment_account_clear_response(
           Think.XmlWebServices.Payment_account_identifier payment_account_identifier,
           Think.XmlWebServices.ZZPaymentAccount payment_account) {
           this.payment_account_identifier = payment_account_identifier;
           this.payment_account = payment_account;
    }


    /**
     * Gets the payment_account_identifier value for this Payment_account_clear_response.
     * 
     * @return payment_account_identifier
     */
    public Think.XmlWebServices.Payment_account_identifier getPayment_account_identifier() {
        return payment_account_identifier;
    }


    /**
     * Sets the payment_account_identifier value for this Payment_account_clear_response.
     * 
     * @param payment_account_identifier
     */
    public void setPayment_account_identifier(Think.XmlWebServices.Payment_account_identifier payment_account_identifier) {
        this.payment_account_identifier = payment_account_identifier;
    }


    /**
     * Gets the payment_account value for this Payment_account_clear_response.
     * 
     * @return payment_account
     */
    public Think.XmlWebServices.ZZPaymentAccount getPayment_account() {
        return payment_account;
    }


    /**
     * Sets the payment_account value for this Payment_account_clear_response.
     * 
     * @param payment_account
     */
    public void setPayment_account(Think.XmlWebServices.ZZPaymentAccount payment_account) {
        this.payment_account = payment_account;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_account_clear_response)) return false;
        Payment_account_clear_response other = (Payment_account_clear_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payment_account_identifier==null && other.getPayment_account_identifier()==null) || 
             (this.payment_account_identifier!=null &&
              this.payment_account_identifier.equals(other.getPayment_account_identifier()))) &&
            ((this.payment_account==null && other.getPayment_account()==null) || 
             (this.payment_account!=null &&
              this.payment_account.equals(other.getPayment_account())));
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
        if (getPayment_account_identifier() != null) {
            _hashCode += getPayment_account_identifier().hashCode();
        }
        if (getPayment_account() != null) {
            _hashCode += getPayment_account().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_account_clear_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_clear_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZPaymentAccount"));
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

}
