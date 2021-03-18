/**
 * Payment_information_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_information_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Payment payment;

    private int[] payment_change_info;

    private Think.XmlWebServices.Order_item_for_payment[] order_item_for_payment;

    public Payment_information_response() {
    }

    public Payment_information_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Payment payment,
           int[] payment_change_info,
           Think.XmlWebServices.Order_item_for_payment[] order_item_for_payment) {
           this.customer_identifier = customer_identifier;
           this.payment = payment;
           this.payment_change_info = payment_change_info;
           this.order_item_for_payment = order_item_for_payment;
    }


    /**
     * Gets the customer_identifier value for this Payment_information_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_information_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the payment value for this Payment_information_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Payment_information_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }


    /**
     * Gets the payment_change_info value for this Payment_information_response.
     * 
     * @return payment_change_info
     */
    public int[] getPayment_change_info() {
        return payment_change_info;
    }


    /**
     * Sets the payment_change_info value for this Payment_information_response.
     * 
     * @param payment_change_info
     */
    public void setPayment_change_info(int[] payment_change_info) {
        this.payment_change_info = payment_change_info;
    }


    /**
     * Gets the order_item_for_payment value for this Payment_information_response.
     * 
     * @return order_item_for_payment
     */
    public Think.XmlWebServices.Order_item_for_payment[] getOrder_item_for_payment() {
        return order_item_for_payment;
    }


    /**
     * Sets the order_item_for_payment value for this Payment_information_response.
     * 
     * @param order_item_for_payment
     */
    public void setOrder_item_for_payment(Think.XmlWebServices.Order_item_for_payment[] order_item_for_payment) {
        this.order_item_for_payment = order_item_for_payment;
    }

    public Think.XmlWebServices.Order_item_for_payment getOrder_item_for_payment(int i) {
        return this.order_item_for_payment[i];
    }

    public void setOrder_item_for_payment(int i, Think.XmlWebServices.Order_item_for_payment _value) {
        this.order_item_for_payment[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_information_response)) return false;
        Payment_information_response other = (Payment_information_response) obj;
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
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment()))) &&
            ((this.payment_change_info==null && other.getPayment_change_info()==null) || 
             (this.payment_change_info!=null &&
              java.util.Arrays.equals(this.payment_change_info, other.getPayment_change_info()))) &&
            ((this.order_item_for_payment==null && other.getOrder_item_for_payment()==null) || 
             (this.order_item_for_payment!=null &&
              java.util.Arrays.equals(this.order_item_for_payment, other.getOrder_item_for_payment())));
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
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        if (getPayment_change_info() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayment_change_info());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayment_change_info(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrder_item_for_payment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item_for_payment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item_for_payment(), i);
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
        new org.apache.axis.description.TypeDesc(Payment_information_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_information_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_change_info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_change_info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_change_info"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_for_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_for_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_for_payment"));
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
