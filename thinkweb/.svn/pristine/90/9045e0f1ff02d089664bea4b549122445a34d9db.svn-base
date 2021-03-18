/**
 * Customer_login_history.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_login_history  implements java.io.Serializable {
    private java.util.Calendar login_time;  // attribute

    private int login_validate_status;  // attribute

    private int ip_address;  // attribute

    private int customer_login_id;  // attribute

    public Customer_login_history() {
    }

    public Customer_login_history(
           java.util.Calendar login_time,
           int login_validate_status,
           int ip_address,
           int customer_login_id) {
           this.login_time = login_time;
           this.login_validate_status = login_validate_status;
           this.ip_address = ip_address;
           this.customer_login_id = customer_login_id;
    }


    /**
     * Gets the login_time value for this Customer_login_history.
     * 
     * @return login_time
     */
    public java.util.Calendar getLogin_time() {
        return login_time;
    }


    /**
     * Sets the login_time value for this Customer_login_history.
     * 
     * @param login_time
     */
    public void setLogin_time(java.util.Calendar login_time) {
        this.login_time = login_time;
    }


    /**
     * Gets the login_validate_status value for this Customer_login_history.
     * 
     * @return login_validate_status
     */
    public int getLogin_validate_status() {
        return login_validate_status;
    }


    /**
     * Sets the login_validate_status value for this Customer_login_history.
     * 
     * @param login_validate_status
     */
    public void setLogin_validate_status(int login_validate_status) {
        this.login_validate_status = login_validate_status;
    }


    /**
     * Gets the ip_address value for this Customer_login_history.
     * 
     * @return ip_address
     */
    public int getIp_address() {
        return ip_address;
    }


    /**
     * Sets the ip_address value for this Customer_login_history.
     * 
     * @param ip_address
     */
    public void setIp_address(int ip_address) {
        this.ip_address = ip_address;
    }


    /**
     * Gets the customer_login_id value for this Customer_login_history.
     * 
     * @return customer_login_id
     */
    public int getCustomer_login_id() {
        return customer_login_id;
    }


    /**
     * Sets the customer_login_id value for this Customer_login_history.
     * 
     * @param customer_login_id
     */
    public void setCustomer_login_id(int customer_login_id) {
        this.customer_login_id = customer_login_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_login_history)) return false;
        Customer_login_history other = (Customer_login_history) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.login_time==null && other.getLogin_time()==null) || 
             (this.login_time!=null &&
              this.login_time.equals(other.getLogin_time()))) &&
            this.login_validate_status == other.getLogin_validate_status() &&
            this.ip_address == other.getIp_address() &&
            this.customer_login_id == other.getCustomer_login_id();
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
        if (getLogin_time() != null) {
            _hashCode += getLogin_time().hashCode();
        }
        _hashCode += getLogin_validate_status();
        _hashCode += getIp_address();
        _hashCode += getCustomer_login_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_login_history.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login_history"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login_validate_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login_validate_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ip_address");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ip_address"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_id"));
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
