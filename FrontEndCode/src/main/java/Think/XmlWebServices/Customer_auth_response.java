/**
 * Customer_auth_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_auth_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Auth_customer auth_customer;

    private Think.XmlWebServices.Auxiliary_field[][][] auth_subscription;

    private Think.XmlWebServices.Auxiliary_field[][] auth_item;

    public Customer_auth_response() {
    }

    public Customer_auth_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Auth_customer auth_customer,
           Think.XmlWebServices.Auxiliary_field[][][] auth_subscription,
           Think.XmlWebServices.Auxiliary_field[][] auth_item) {
           this.customer_identifier = customer_identifier;
           this.auth_customer = auth_customer;
           this.auth_subscription = auth_subscription;
           this.auth_item = auth_item;
    }


    /**
     * Gets the customer_identifier value for this Customer_auth_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_auth_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the auth_customer value for this Customer_auth_response.
     * 
     * @return auth_customer
     */
    public Think.XmlWebServices.Auth_customer getAuth_customer() {
        return auth_customer;
    }


    /**
     * Sets the auth_customer value for this Customer_auth_response.
     * 
     * @param auth_customer
     */
    public void setAuth_customer(Think.XmlWebServices.Auth_customer auth_customer) {
        this.auth_customer = auth_customer;
    }


    /**
     * Gets the auth_subscription value for this Customer_auth_response.
     * 
     * @return auth_subscription
     */
    public Think.XmlWebServices.Auxiliary_field[][][] getAuth_subscription() {
        return auth_subscription;
    }


    /**
     * Sets the auth_subscription value for this Customer_auth_response.
     * 
     * @param auth_subscription
     */
    public void setAuth_subscription(Think.XmlWebServices.Auxiliary_field[][][] auth_subscription) {
        this.auth_subscription = auth_subscription;
    }

    public Think.XmlWebServices.Auxiliary_field[][] getAuth_subscription(int i) {
        return this.auth_subscription[i];
    }

    public void setAuth_subscription(int i, Think.XmlWebServices.Auxiliary_field[][] _value) {
        this.auth_subscription[i] = _value;
    }


    /**
     * Gets the auth_item value for this Customer_auth_response.
     * 
     * @return auth_item
     */
    public Think.XmlWebServices.Auxiliary_field[][] getAuth_item() {
        return auth_item;
    }


    /**
     * Sets the auth_item value for this Customer_auth_response.
     * 
     * @param auth_item
     */
    public void setAuth_item(Think.XmlWebServices.Auxiliary_field[][] auth_item) {
        this.auth_item = auth_item;
    }

    public Think.XmlWebServices.Auxiliary_field[] getAuth_item(int i) {
        return this.auth_item[i];
    }

    public void setAuth_item(int i, Think.XmlWebServices.Auxiliary_field[] _value) {
        this.auth_item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_auth_response)) return false;
        Customer_auth_response other = (Customer_auth_response) obj;
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
            ((this.auth_customer==null && other.getAuth_customer()==null) || 
             (this.auth_customer!=null &&
              this.auth_customer.equals(other.getAuth_customer()))) &&
            ((this.auth_subscription==null && other.getAuth_subscription()==null) || 
             (this.auth_subscription!=null &&
              java.util.Arrays.equals(this.auth_subscription, other.getAuth_subscription()))) &&
            ((this.auth_item==null && other.getAuth_item()==null) || 
             (this.auth_item!=null &&
              java.util.Arrays.equals(this.auth_item, other.getAuth_item())));
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
        if (getAuth_customer() != null) {
            _hashCode += getAuth_customer().hashCode();
        }
        if (getAuth_subscription() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuth_subscription());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuth_subscription(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAuth_item() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuth_item());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuth_item(), i);
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
        new org.apache.axis.description.TypeDesc(Customer_auth_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_auth_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auth_customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">auth_customer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_subscription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auth_subscription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auth_subscription"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auth_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auth_item"));
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
