/**
 * Customer_credit_status_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_credit_status_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Customer_credit_status_select_responseCredit_status[] credit_status;

    public Customer_credit_status_select_response() {
    }

    public Customer_credit_status_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Customer_credit_status_select_responseCredit_status[] credit_status) {
           this.customer_identifier = customer_identifier;
           this.credit_status = credit_status;
    }


    /**
     * Gets the customer_identifier value for this Customer_credit_status_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_credit_status_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the credit_status value for this Customer_credit_status_select_response.
     * 
     * @return credit_status
     */
    public Think.XmlWebServices.Customer_credit_status_select_responseCredit_status[] getCredit_status() {
        return credit_status;
    }


    /**
     * Sets the credit_status value for this Customer_credit_status_select_response.
     * 
     * @param credit_status
     */
    public void setCredit_status(Think.XmlWebServices.Customer_credit_status_select_responseCredit_status[] credit_status) {
        this.credit_status = credit_status;
    }

    public Think.XmlWebServices.Customer_credit_status_select_responseCredit_status getCredit_status(int i) {
        return this.credit_status[i];
    }

    public void setCredit_status(int i, Think.XmlWebServices.Customer_credit_status_select_responseCredit_status _value) {
        this.credit_status[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_credit_status_select_response)) return false;
        Customer_credit_status_select_response other = (Customer_credit_status_select_response) obj;
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
            ((this.credit_status==null && other.getCredit_status()==null) || 
             (this.credit_status!=null &&
              java.util.Arrays.equals(this.credit_status, other.getCredit_status())));
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
        if (getCredit_status() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCredit_status());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCredit_status(), i);
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
        new org.apache.axis.description.TypeDesc(Customer_credit_status_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_credit_status_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "credit_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_credit_status_select_response>credit_status"));
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
