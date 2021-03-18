/**
 * User_code_activity_add_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class User_code_activity_add_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.User_code_activity_data user_code_activity_data;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean submit;  // attribute

    public User_code_activity_add_request() {
    }

    public User_code_activity_add_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.User_code_activity_data user_code_activity_data,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean submit) {
           this.user_login_data = user_login_data;
           this.user_code_activity_data = user_code_activity_data;
           this.dsn = dsn;
           this.submit = submit;
    }


    /**
     * Gets the user_login_data value for this User_code_activity_add_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this User_code_activity_add_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the user_code_activity_data value for this User_code_activity_add_request.
     * 
     * @return user_code_activity_data
     */
    public Think.XmlWebServices.User_code_activity_data getUser_code_activity_data() {
        return user_code_activity_data;
    }


    /**
     * Sets the user_code_activity_data value for this User_code_activity_add_request.
     * 
     * @param user_code_activity_data
     */
    public void setUser_code_activity_data(Think.XmlWebServices.User_code_activity_data user_code_activity_data) {
        this.user_code_activity_data = user_code_activity_data;
    }


    /**
     * Gets the dsn value for this User_code_activity_add_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this User_code_activity_add_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the submit value for this User_code_activity_add_request.
     * 
     * @return submit
     */
    public Think.XmlWebServices.ZZBoolean getSubmit() {
        return submit;
    }


    /**
     * Sets the submit value for this User_code_activity_add_request.
     * 
     * @param submit
     */
    public void setSubmit(Think.XmlWebServices.ZZBoolean submit) {
        this.submit = submit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User_code_activity_add_request)) return false;
        User_code_activity_add_request other = (User_code_activity_add_request) obj;
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
            ((this.user_code_activity_data==null && other.getUser_code_activity_data()==null) || 
             (this.user_code_activity_data!=null &&
              this.user_code_activity_data.equals(other.getUser_code_activity_data()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.submit==null && other.getSubmit()==null) || 
             (this.submit!=null &&
              this.submit.equals(other.getSubmit())));
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
        if (getUser_code_activity_data() != null) {
            _hashCode += getUser_code_activity_data().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getSubmit() != null) {
            _hashCode += getSubmit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(User_code_activity_add_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_code_activity_add_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("submit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "submit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_code_activity_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code_activity_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_code_activity_data"));
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
