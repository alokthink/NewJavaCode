/**
 * Credit_card_validate_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Credit_card_validate_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.String credit_card_number;

    private java.lang.Integer credit_card_type;

    private java.lang.String dsn;  // attribute

    public Credit_card_validate_request() {
    }

    public Credit_card_validate_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.String credit_card_number,
           java.lang.Integer credit_card_type,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.credit_card_number = credit_card_number;
           this.credit_card_type = credit_card_type;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Credit_card_validate_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Credit_card_validate_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the credit_card_number value for this Credit_card_validate_request.
     * 
     * @return credit_card_number
     */
    public java.lang.String getCredit_card_number() {
        return credit_card_number;
    }


    /**
     * Sets the credit_card_number value for this Credit_card_validate_request.
     * 
     * @param credit_card_number
     */
    public void setCredit_card_number(java.lang.String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }


    /**
     * Gets the credit_card_type value for this Credit_card_validate_request.
     * 
     * @return credit_card_type
     */
    public java.lang.Integer getCredit_card_type() {
        return credit_card_type;
    }


    /**
     * Sets the credit_card_type value for this Credit_card_validate_request.
     * 
     * @param credit_card_type
     */
    public void setCredit_card_type(java.lang.Integer credit_card_type) {
        this.credit_card_type = credit_card_type;
    }


    /**
     * Gets the dsn value for this Credit_card_validate_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Credit_card_validate_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Credit_card_validate_request)) return false;
        Credit_card_validate_request other = (Credit_card_validate_request) obj;
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
            ((this.credit_card_number==null && other.getCredit_card_number()==null) || 
             (this.credit_card_number!=null &&
              this.credit_card_number.equals(other.getCredit_card_number()))) &&
            ((this.credit_card_type==null && other.getCredit_card_type()==null) || 
             (this.credit_card_type!=null &&
              this.credit_card_type.equals(other.getCredit_card_type()))) &&
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
        if (getCredit_card_number() != null) {
            _hashCode += getCredit_card_number().hashCode();
        }
        if (getCredit_card_type() != null) {
            _hashCode += getCredit_card_type().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Credit_card_validate_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">credit_card_validate_request"));
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
        elemField.setFieldName("credit_card_number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "credit_card_number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit_card_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "credit_card_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

}
