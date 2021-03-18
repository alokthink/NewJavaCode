/**
 * Package_list_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Package_list_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Package_list_select_requestPremium_only premium_only;

    private Think.XmlWebServices.ZZBoolean internet_only;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    public Package_list_select_request() {
    }

    public Package_list_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Package_list_select_requestPremium_only premium_only,
           Think.XmlWebServices.ZZBoolean internet_only,
           java.lang.String dsn,
           java.lang.String language_code) {
           this.user_login_data = user_login_data;
           this.premium_only = premium_only;
           this.internet_only = internet_only;
           this.dsn = dsn;
           this.language_code = language_code;
    }


    /**
     * Gets the user_login_data value for this Package_list_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Package_list_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the premium_only value for this Package_list_select_request.
     * 
     * @return premium_only
     */
    public Think.XmlWebServices.Package_list_select_requestPremium_only getPremium_only() {
        return premium_only;
    }


    /**
     * Sets the premium_only value for this Package_list_select_request.
     * 
     * @param premium_only
     */
    public void setPremium_only(Think.XmlWebServices.Package_list_select_requestPremium_only premium_only) {
        this.premium_only = premium_only;
    }


    /**
     * Gets the internet_only value for this Package_list_select_request.
     * 
     * @return internet_only
     */
    public Think.XmlWebServices.ZZBoolean getInternet_only() {
        return internet_only;
    }


    /**
     * Sets the internet_only value for this Package_list_select_request.
     * 
     * @param internet_only
     */
    public void setInternet_only(Think.XmlWebServices.ZZBoolean internet_only) {
        this.internet_only = internet_only;
    }


    /**
     * Gets the dsn value for this Package_list_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Package_list_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Package_list_select_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Package_list_select_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Package_list_select_request)) return false;
        Package_list_select_request other = (Package_list_select_request) obj;
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
            ((this.premium_only==null && other.getPremium_only()==null) || 
             (this.premium_only!=null &&
              this.premium_only.equals(other.getPremium_only()))) &&
            ((this.internet_only==null && other.getInternet_only()==null) || 
             (this.internet_only!=null &&
              this.internet_only.equals(other.getInternet_only()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code())));
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
        if (getPremium_only() != null) {
            _hashCode += getPremium_only().hashCode();
        }
        if (getInternet_only() != null) {
            _hashCode += getInternet_only().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getLanguage_code() != null) {
            _hashCode += getLanguage_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Package_list_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">package_list_select_request"));
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
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premium_only");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "premium_only"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>package_list_select_request>premium_only"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internet_only");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "internet_only"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
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
