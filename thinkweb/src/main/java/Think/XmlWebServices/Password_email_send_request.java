/**
 * Password_email_send_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Password_email_send_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_login_data customer_login_data;

    private java.lang.String dsn;  // attribute

    private int event_queue_oc_id;  // attribute

    private Think.XmlWebServices.ZZBoolean reset_to_default;  // attribute

    public Password_email_send_request() {
    }

    public Password_email_send_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_login_data customer_login_data,
           java.lang.String dsn,
           int event_queue_oc_id,
           Think.XmlWebServices.ZZBoolean reset_to_default) {
           this.user_login_data = user_login_data;
           this.customer_login_data = customer_login_data;
           this.dsn = dsn;
           this.event_queue_oc_id = event_queue_oc_id;
           this.reset_to_default = reset_to_default;
    }


    /**
     * Gets the user_login_data value for this Password_email_send_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Password_email_send_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_login_data value for this Password_email_send_request.
     * 
     * @return customer_login_data
     */
    public Think.XmlWebServices.Customer_login_data getCustomer_login_data() {
        return customer_login_data;
    }


    /**
     * Sets the customer_login_data value for this Password_email_send_request.
     * 
     * @param customer_login_data
     */
    public void setCustomer_login_data(Think.XmlWebServices.Customer_login_data customer_login_data) {
        this.customer_login_data = customer_login_data;
    }


    /**
     * Gets the dsn value for this Password_email_send_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Password_email_send_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the event_queue_oc_id value for this Password_email_send_request.
     * 
     * @return event_queue_oc_id
     */
    public int getEvent_queue_oc_id() {
        return event_queue_oc_id;
    }


    /**
     * Sets the event_queue_oc_id value for this Password_email_send_request.
     * 
     * @param event_queue_oc_id
     */
    public void setEvent_queue_oc_id(int event_queue_oc_id) {
        this.event_queue_oc_id = event_queue_oc_id;
    }


    /**
     * Gets the reset_to_default value for this Password_email_send_request.
     * 
     * @return reset_to_default
     */
    public Think.XmlWebServices.ZZBoolean getReset_to_default() {
        return reset_to_default;
    }


    /**
     * Sets the reset_to_default value for this Password_email_send_request.
     * 
     * @param reset_to_default
     */
    public void setReset_to_default(Think.XmlWebServices.ZZBoolean reset_to_default) {
        this.reset_to_default = reset_to_default;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Password_email_send_request)) return false;
        Password_email_send_request other = (Password_email_send_request) obj;
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
            ((this.customer_login_data==null && other.getCustomer_login_data()==null) || 
             (this.customer_login_data!=null &&
              this.customer_login_data.equals(other.getCustomer_login_data()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            this.event_queue_oc_id == other.getEvent_queue_oc_id() &&
            ((this.reset_to_default==null && other.getReset_to_default()==null) || 
             (this.reset_to_default!=null &&
              this.reset_to_default.equals(other.getReset_to_default())));
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
        if (getCustomer_login_data() != null) {
            _hashCode += getCustomer_login_data().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        _hashCode += getEvent_queue_oc_id();
        if (getReset_to_default() != null) {
            _hashCode += getReset_to_default().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Password_email_send_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">password_email_send_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("event_queue_oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "event_queue_oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reset_to_default");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reset_to_default"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login_data"));
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
