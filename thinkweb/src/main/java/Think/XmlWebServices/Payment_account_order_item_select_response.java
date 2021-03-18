/**
 * Payment_account_order_item_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_account_order_item_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account[] order_item_on_payment_account;

    public Payment_account_order_item_select_response() {
    }

    public Payment_account_order_item_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account[] order_item_on_payment_account) {
           this.customer_identifier = customer_identifier;
           this.order_item_on_payment_account = order_item_on_payment_account;
    }


    /**
     * Gets the customer_identifier value for this Payment_account_order_item_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_account_order_item_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the order_item_on_payment_account value for this Payment_account_order_item_select_response.
     * 
     * @return order_item_on_payment_account
     */
    public Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account[] getOrder_item_on_payment_account() {
        return order_item_on_payment_account;
    }


    /**
     * Sets the order_item_on_payment_account value for this Payment_account_order_item_select_response.
     * 
     * @param order_item_on_payment_account
     */
    public void setOrder_item_on_payment_account(Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account[] order_item_on_payment_account) {
        this.order_item_on_payment_account = order_item_on_payment_account;
    }

    public Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account getOrder_item_on_payment_account(int i) {
        return this.order_item_on_payment_account[i];
    }

    public void setOrder_item_on_payment_account(int i, Think.XmlWebServices.Payment_account_order_item_select_responseOrder_item_on_payment_account _value) {
        this.order_item_on_payment_account[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_account_order_item_select_response)) return false;
        Payment_account_order_item_select_response other = (Payment_account_order_item_select_response) obj;
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
            ((this.order_item_on_payment_account==null && other.getOrder_item_on_payment_account()==null) || 
             (this.order_item_on_payment_account!=null &&
              java.util.Arrays.equals(this.order_item_on_payment_account, other.getOrder_item_on_payment_account())));
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
        if (getOrder_item_on_payment_account() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item_on_payment_account());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item_on_payment_account(), i);
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
        new org.apache.axis.description.TypeDesc(Payment_account_order_item_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_order_item_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_on_payment_account");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_on_payment_account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_account_order_item_select_response>order_item_on_payment_account"));
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
