/**
 * State_nonsuppressed_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class State_nonsuppressed_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.String excluded_countries;

    private Think.XmlWebServices.ZZBoolean exclude_foreign;

    private java.lang.String dsn;  // attribute

    public State_nonsuppressed_select_request() {
    }

    public State_nonsuppressed_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.String excluded_countries,
           Think.XmlWebServices.ZZBoolean exclude_foreign,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.excluded_countries = excluded_countries;
           this.exclude_foreign = exclude_foreign;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this State_nonsuppressed_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this State_nonsuppressed_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the excluded_countries value for this State_nonsuppressed_select_request.
     * 
     * @return excluded_countries
     */
    public java.lang.String getExcluded_countries() {
        return excluded_countries;
    }


    /**
     * Sets the excluded_countries value for this State_nonsuppressed_select_request.
     * 
     * @param excluded_countries
     */
    public void setExcluded_countries(java.lang.String excluded_countries) {
        this.excluded_countries = excluded_countries;
    }


    /**
     * Gets the exclude_foreign value for this State_nonsuppressed_select_request.
     * 
     * @return exclude_foreign
     */
    public Think.XmlWebServices.ZZBoolean getExclude_foreign() {
        return exclude_foreign;
    }


    /**
     * Sets the exclude_foreign value for this State_nonsuppressed_select_request.
     * 
     * @param exclude_foreign
     */
    public void setExclude_foreign(Think.XmlWebServices.ZZBoolean exclude_foreign) {
        this.exclude_foreign = exclude_foreign;
    }


    /**
     * Gets the dsn value for this State_nonsuppressed_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this State_nonsuppressed_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof State_nonsuppressed_select_request)) return false;
        State_nonsuppressed_select_request other = (State_nonsuppressed_select_request) obj;
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
            ((this.excluded_countries==null && other.getExcluded_countries()==null) || 
             (this.excluded_countries!=null &&
              this.excluded_countries.equals(other.getExcluded_countries()))) &&
            ((this.exclude_foreign==null && other.getExclude_foreign()==null) || 
             (this.exclude_foreign!=null &&
              this.exclude_foreign.equals(other.getExclude_foreign()))) &&
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
        if (getExcluded_countries() != null) {
            _hashCode += getExcluded_countries().hashCode();
        }
        if (getExclude_foreign() != null) {
            _hashCode += getExclude_foreign().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(State_nonsuppressed_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">state_nonsuppressed_select_request"));
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
        elemField.setFieldName("excluded_countries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "excluded_countries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exclude_foreign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "exclude_foreign"));
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
