/**
 * Paybreak_information_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Paybreak_information_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Paybreak_information_qualifier paybreak_information_qualifier;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    private Think.XmlWebServices.ZZBoolean deposit_only;  // attribute

    private Think.XmlWebServices.ZZBoolean include_pkg_mbrs;  // attribute

    public Paybreak_information_request() {
    }

    public Paybreak_information_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Paybreak_information_qualifier paybreak_information_qualifier,
           java.lang.String dsn,
           java.lang.String language_code,
           Think.XmlWebServices.ZZBoolean deposit_only,
           Think.XmlWebServices.ZZBoolean include_pkg_mbrs) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.paybreak_information_qualifier = paybreak_information_qualifier;
           this.dsn = dsn;
           this.language_code = language_code;
           this.deposit_only = deposit_only;
           this.include_pkg_mbrs = include_pkg_mbrs;
    }


    /**
     * Gets the user_login_data value for this Paybreak_information_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Paybreak_information_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Paybreak_information_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Paybreak_information_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the paybreak_information_qualifier value for this Paybreak_information_request.
     * 
     * @return paybreak_information_qualifier
     */
    public Think.XmlWebServices.Paybreak_information_qualifier getPaybreak_information_qualifier() {
        return paybreak_information_qualifier;
    }


    /**
     * Sets the paybreak_information_qualifier value for this Paybreak_information_request.
     * 
     * @param paybreak_information_qualifier
     */
    public void setPaybreak_information_qualifier(Think.XmlWebServices.Paybreak_information_qualifier paybreak_information_qualifier) {
        this.paybreak_information_qualifier = paybreak_information_qualifier;
    }


    /**
     * Gets the dsn value for this Paybreak_information_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Paybreak_information_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Paybreak_information_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Paybreak_information_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }


    /**
     * Gets the deposit_only value for this Paybreak_information_request.
     * 
     * @return deposit_only
     */
    public Think.XmlWebServices.ZZBoolean getDeposit_only() {
        return deposit_only;
    }


    /**
     * Sets the deposit_only value for this Paybreak_information_request.
     * 
     * @param deposit_only
     */
    public void setDeposit_only(Think.XmlWebServices.ZZBoolean deposit_only) {
        this.deposit_only = deposit_only;
    }


    /**
     * Gets the include_pkg_mbrs value for this Paybreak_information_request.
     * 
     * @return include_pkg_mbrs
     */
    public Think.XmlWebServices.ZZBoolean getInclude_pkg_mbrs() {
        return include_pkg_mbrs;
    }


    /**
     * Sets the include_pkg_mbrs value for this Paybreak_information_request.
     * 
     * @param include_pkg_mbrs
     */
    public void setInclude_pkg_mbrs(Think.XmlWebServices.ZZBoolean include_pkg_mbrs) {
        this.include_pkg_mbrs = include_pkg_mbrs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Paybreak_information_request)) return false;
        Paybreak_information_request other = (Paybreak_information_request) obj;
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
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.paybreak_information_qualifier==null && other.getPaybreak_information_qualifier()==null) || 
             (this.paybreak_information_qualifier!=null &&
              this.paybreak_information_qualifier.equals(other.getPaybreak_information_qualifier()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code()))) &&
            ((this.deposit_only==null && other.getDeposit_only()==null) || 
             (this.deposit_only!=null &&
              this.deposit_only.equals(other.getDeposit_only()))) &&
            ((this.include_pkg_mbrs==null && other.getInclude_pkg_mbrs()==null) || 
             (this.include_pkg_mbrs!=null &&
              this.include_pkg_mbrs.equals(other.getInclude_pkg_mbrs())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getPaybreak_information_qualifier() != null) {
            _hashCode += getPaybreak_information_qualifier().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getLanguage_code() != null) {
            _hashCode += getLanguage_code().hashCode();
        }
        if (getDeposit_only() != null) {
            _hashCode += getDeposit_only().hashCode();
        }
        if (getInclude_pkg_mbrs() != null) {
            _hashCode += getInclude_pkg_mbrs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Paybreak_information_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">paybreak_information_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "language_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deposit_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deposit_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("include_pkg_mbrs");
        attrField.setXmlName(new javax.xml.namespace.QName("", "include_pkg_mbrs"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paybreak_information_qualifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "paybreak_information_qualifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">paybreak_information_qualifier"));
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
