/**
 * Customer_group_info_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_group_info_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Customer_group_info_select_responseCustomer_group[] customer_group;

    public Customer_group_info_select_response() {
    }

    public Customer_group_info_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Customer_group_info_select_responseCustomer_group[] customer_group) {
           this.customer_identifier = customer_identifier;
           this.customer_group = customer_group;
    }


    /**
     * Gets the customer_identifier value for this Customer_group_info_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_group_info_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the customer_group value for this Customer_group_info_select_response.
     * 
     * @return customer_group
     */
    public Think.XmlWebServices.Customer_group_info_select_responseCustomer_group[] getCustomer_group() {
        return customer_group;
    }


    /**
     * Sets the customer_group value for this Customer_group_info_select_response.
     * 
     * @param customer_group
     */
    public void setCustomer_group(Think.XmlWebServices.Customer_group_info_select_responseCustomer_group[] customer_group) {
        this.customer_group = customer_group;
    }

    public Think.XmlWebServices.Customer_group_info_select_responseCustomer_group getCustomer_group(int i) {
        return this.customer_group[i];
    }

    public void setCustomer_group(int i, Think.XmlWebServices.Customer_group_info_select_responseCustomer_group _value) {
        this.customer_group[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_group_info_select_response)) return false;
        Customer_group_info_select_response other = (Customer_group_info_select_response) obj;
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
            ((this.customer_group==null && other.getCustomer_group()==null) || 
             (this.customer_group!=null &&
              java.util.Arrays.equals(this.customer_group, other.getCustomer_group())));
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
        if (getCustomer_group() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_group());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_group(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_group_info_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_group_info_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_group");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_group_info_select_response>customer_group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
