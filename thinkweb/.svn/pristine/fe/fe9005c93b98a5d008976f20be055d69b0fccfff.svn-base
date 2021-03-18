/**
 * Customer_name_diff_from_address_info_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_name_diff_from_address_info_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.ZZBoolean has_different_name_on_addr;  // attribute

    public Customer_name_diff_from_address_info_response() {
    }

    public Customer_name_diff_from_address_info_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.ZZBoolean has_different_name_on_addr) {
           this.customer_identifier = customer_identifier;
           this.has_different_name_on_addr = has_different_name_on_addr;
    }


    /**
     * Gets the customer_identifier value for this Customer_name_diff_from_address_info_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_name_diff_from_address_info_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the has_different_name_on_addr value for this Customer_name_diff_from_address_info_response.
     * 
     * @return has_different_name_on_addr
     */
    public Think.XmlWebServices.ZZBoolean getHas_different_name_on_addr() {
        return has_different_name_on_addr;
    }


    /**
     * Sets the has_different_name_on_addr value for this Customer_name_diff_from_address_info_response.
     * 
     * @param has_different_name_on_addr
     */
    public void setHas_different_name_on_addr(Think.XmlWebServices.ZZBoolean has_different_name_on_addr) {
        this.has_different_name_on_addr = has_different_name_on_addr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_name_diff_from_address_info_response)) return false;
        Customer_name_diff_from_address_info_response other = (Customer_name_diff_from_address_info_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.has_different_name_on_addr==null && other.getHas_different_name_on_addr()==null) || 
             (this.has_different_name_on_addr!=null &&
              this.has_different_name_on_addr.equals(other.getHas_different_name_on_addr())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getHas_different_name_on_addr() != null) {
            _hashCode += getHas_different_name_on_addr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_name_diff_from_address_info_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_name_diff_from_address_info_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_different_name_on_addr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_different_name_on_addr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
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
