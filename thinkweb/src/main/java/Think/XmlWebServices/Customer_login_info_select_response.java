/**
 * Customer_login_info_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_login_info_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Customer_login_info_select_responseCustomer_login[] customer_login;

    public Customer_login_info_select_response() {
    }

    public Customer_login_info_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Customer_login_info_select_responseCustomer_login[] customer_login) {
           this.customer_identifier = customer_identifier;
           this.customer_login = customer_login;
    }


    /**
     * Gets the customer_identifier value for this Customer_login_info_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_login_info_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the customer_login value for this Customer_login_info_select_response.
     * 
     * @return customer_login
     */
    public Think.XmlWebServices.Customer_login_info_select_responseCustomer_login[] getCustomer_login() {
        return customer_login;
    }


    /**
     * Sets the customer_login value for this Customer_login_info_select_response.
     * 
     * @param customer_login
     */
    public void setCustomer_login(Think.XmlWebServices.Customer_login_info_select_responseCustomer_login[] customer_login) {
        this.customer_login = customer_login;
    }

    public Think.XmlWebServices.Customer_login_info_select_responseCustomer_login getCustomer_login(int i) {
        return this.customer_login[i];
    }

    public void setCustomer_login(int i, Think.XmlWebServices.Customer_login_info_select_responseCustomer_login _value) {
        this.customer_login[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_login_info_select_response)) return false;
        Customer_login_info_select_response other = (Customer_login_info_select_response) obj;
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
            ((this.customer_login==null && other.getCustomer_login()==null) || 
             (this.customer_login!=null &&
              java.util.Arrays.equals(this.customer_login, other.getCustomer_login())));
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
        if (getCustomer_login() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_login());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_login(), i);
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
        new org.apache.axis.description.TypeDesc(Customer_login_info_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login_info_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_login_info_select_response>customer_login"));
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
