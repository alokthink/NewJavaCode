/**
 * Customer_address_edit_effect_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_address_edit_effect_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_address_identifier customer_address_identifier;

    private Think.XmlWebServices.Customer_address_data customer_address_data;

    private Think.XmlWebServices.Trusted_data trusted_data;

    private java.lang.String dsn;  // attribute

    public Customer_address_edit_effect_list_request() {
    }

    public Customer_address_edit_effect_list_request(
           Think.XmlWebServices.Customer_address_identifier customer_address_identifier,
           Think.XmlWebServices.Customer_address_data customer_address_data,
           Think.XmlWebServices.Trusted_data trusted_data,
           java.lang.String dsn) {
           this.customer_address_identifier = customer_address_identifier;
           this.customer_address_data = customer_address_data;
           this.trusted_data = trusted_data;
           this.dsn = dsn;
    }


    /**
     * Gets the customer_address_identifier value for this Customer_address_edit_effect_list_request.
     * 
     * @return customer_address_identifier
     */
    public Think.XmlWebServices.Customer_address_identifier getCustomer_address_identifier() {
        return customer_address_identifier;
    }


    /**
     * Sets the customer_address_identifier value for this Customer_address_edit_effect_list_request.
     * 
     * @param customer_address_identifier
     */
    public void setCustomer_address_identifier(Think.XmlWebServices.Customer_address_identifier customer_address_identifier) {
        this.customer_address_identifier = customer_address_identifier;
    }


    /**
     * Gets the customer_address_data value for this Customer_address_edit_effect_list_request.
     * 
     * @return customer_address_data
     */
    public Think.XmlWebServices.Customer_address_data getCustomer_address_data() {
        return customer_address_data;
    }


    /**
     * Sets the customer_address_data value for this Customer_address_edit_effect_list_request.
     * 
     * @param customer_address_data
     */
    public void setCustomer_address_data(Think.XmlWebServices.Customer_address_data customer_address_data) {
        this.customer_address_data = customer_address_data;
    }


    /**
     * Gets the trusted_data value for this Customer_address_edit_effect_list_request.
     * 
     * @return trusted_data
     */
    public Think.XmlWebServices.Trusted_data getTrusted_data() {
        return trusted_data;
    }


    /**
     * Sets the trusted_data value for this Customer_address_edit_effect_list_request.
     * 
     * @param trusted_data
     */
    public void setTrusted_data(Think.XmlWebServices.Trusted_data trusted_data) {
        this.trusted_data = trusted_data;
    }


    /**
     * Gets the dsn value for this Customer_address_edit_effect_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Customer_address_edit_effect_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_address_edit_effect_list_request)) return false;
        Customer_address_edit_effect_list_request other = (Customer_address_edit_effect_list_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_address_identifier==null && other.getCustomer_address_identifier()==null) || 
             (this.customer_address_identifier!=null &&
              this.customer_address_identifier.equals(other.getCustomer_address_identifier()))) &&
            ((this.customer_address_data==null && other.getCustomer_address_data()==null) || 
             (this.customer_address_data!=null &&
              this.customer_address_data.equals(other.getCustomer_address_data()))) &&
            ((this.trusted_data==null && other.getTrusted_data()==null) || 
             (this.trusted_data!=null &&
              this.trusted_data.equals(other.getTrusted_data()))) &&
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
        if (getCustomer_address_identifier() != null) {
            _hashCode += getCustomer_address_identifier().hashCode();
        }
        if (getCustomer_address_data() != null) {
            _hashCode += getCustomer_address_data().hashCode();
        }
        if (getTrusted_data() != null) {
            _hashCode += getTrusted_data().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_address_edit_effect_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_address_edit_effect_list_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_address_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_address_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trusted_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "trusted_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">trusted_data"));
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
