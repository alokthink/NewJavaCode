/**
 * Order_cancel_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_cancel_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.ZZSubscrip subscrip;

    private Think.XmlWebServices.Orderhdr[] orderhdr;

    private Think.XmlWebServices.Payment[] payment;

    public Order_cancel_response() {
    }

    public Order_cancel_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.ZZSubscrip subscrip,
           Think.XmlWebServices.Orderhdr[] orderhdr,
           Think.XmlWebServices.Payment[] payment) {
           this.customer_identifier = customer_identifier;
           this.subscrip = subscrip;
           this.orderhdr = orderhdr;
           this.payment = payment;
    }


    /**
     * Gets the customer_identifier value for this Order_cancel_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Order_cancel_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the subscrip value for this Order_cancel_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Order_cancel_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip subscrip) {
        this.subscrip = subscrip;
    }


    /**
     * Gets the orderhdr value for this Order_cancel_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr[] getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Order_cancel_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr[] orderhdr) {
        this.orderhdr = orderhdr;
    }

    public Think.XmlWebServices.Orderhdr getOrderhdr(int i) {
        return this.orderhdr[i];
    }

    public void setOrderhdr(int i, Think.XmlWebServices.Orderhdr _value) {
        this.orderhdr[i] = _value;
    }


    /**
     * Gets the payment value for this Order_cancel_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment[] getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Order_cancel_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment[] payment) {
        this.payment = payment;
    }

    public Think.XmlWebServices.Payment getPayment(int i) {
        return this.payment[i];
    }

    public void setPayment(int i, Think.XmlWebServices.Payment _value) {
        this.payment[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_cancel_response)) return false;
        Order_cancel_response other = (Order_cancel_response) obj;
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
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              this.subscrip.equals(other.getSubscrip()))) &&
            ((this.orderhdr==null && other.getOrderhdr()==null) || 
             (this.orderhdr!=null &&
              java.util.Arrays.equals(this.orderhdr, other.getOrderhdr()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              java.util.Arrays.equals(this.payment, other.getPayment())));
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
        if (getSubscrip() != null) {
            _hashCode += getSubscrip().hashCode();
        }
        if (getOrderhdr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderhdr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrderhdr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPayment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayment(), i);
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
        new org.apache.axis.description.TypeDesc(Order_cancel_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_cancel_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscrip"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
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
