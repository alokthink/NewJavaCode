/**
 * Credit_card_verify_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Credit_card_verify_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Payment_account_data payment_account_data;

    private Think.XmlWebServices.Customer_data customer_data;

    private java.lang.String dsn;  // attribute

    public Credit_card_verify_request() {
    }

    public Credit_card_verify_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Payment_account_data payment_account_data,
           Think.XmlWebServices.Customer_data customer_data,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.payment_account_data = payment_account_data;
           this.customer_data = customer_data;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Credit_card_verify_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Credit_card_verify_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the payment_account_data value for this Credit_card_verify_request.
     * 
     * @return payment_account_data
     */
    public Think.XmlWebServices.Payment_account_data getPayment_account_data() {
        return payment_account_data;
    }


    /**
     * Sets the payment_account_data value for this Credit_card_verify_request.
     * 
     * @param payment_account_data
     */
    public void setPayment_account_data(Think.XmlWebServices.Payment_account_data payment_account_data) {
        this.payment_account_data = payment_account_data;
    }


    /**
     * Gets the customer_data value for this Credit_card_verify_request.
     * 
     * @return customer_data
     */
    public Think.XmlWebServices.Customer_data getCustomer_data() {
        return customer_data;
    }


    /**
     * Sets the customer_data value for this Credit_card_verify_request.
     * 
     * @param customer_data
     */
    public void setCustomer_data(Think.XmlWebServices.Customer_data customer_data) {
        this.customer_data = customer_data;
    }


    /**
     * Gets the dsn value for this Credit_card_verify_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Credit_card_verify_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Credit_card_verify_request)) return false;
        Credit_card_verify_request other = (Credit_card_verify_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.payment_account_data==null && other.getPayment_account_data()==null) || 
             (this.payment_account_data!=null &&
              this.payment_account_data.equals(other.getPayment_account_data()))) &&
            ((this.customer_data==null && other.getCustomer_data()==null) || 
             (this.customer_data!=null &&
              this.customer_data.equals(other.getCustomer_data()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getPayment_account_data() != null) {
            _hashCode += getPayment_account_data().hashCode();
        }
        if (getCustomer_data() != null) {
            _hashCode += getCustomer_data().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Credit_card_verify_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">credit_card_verify_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_data"));
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
