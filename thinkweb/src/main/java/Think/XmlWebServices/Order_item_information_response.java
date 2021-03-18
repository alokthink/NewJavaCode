/**
 * Order_item_information_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_information_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier[] customer_identifier;

    private Think.XmlWebServices.Order_item_information[] order_item_information;

    public Order_item_information_response() {
    }

    public Order_item_information_response(
           Think.XmlWebServices.Customer_identifier[] customer_identifier,
           Think.XmlWebServices.Order_item_information[] order_item_information) {
           this.customer_identifier = customer_identifier;
           this.order_item_information = order_item_information;
    }


    /**
     * Gets the customer_identifier value for this Order_item_information_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier[] getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Order_item_information_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier[] customer_identifier) {
        this.customer_identifier = customer_identifier;
    }

    public Think.XmlWebServices.Customer_identifier getCustomer_identifier(int i) {
        return this.customer_identifier[i];
    }

    public void setCustomer_identifier(int i, Think.XmlWebServices.Customer_identifier _value) {
        this.customer_identifier[i] = _value;
    }


    /**
     * Gets the order_item_information value for this Order_item_information_response.
     * 
     * @return order_item_information
     */
    public Think.XmlWebServices.Order_item_information[] getOrder_item_information() {
        return order_item_information;
    }


    /**
     * Sets the order_item_information value for this Order_item_information_response.
     * 
     * @param order_item_information
     */
    public void setOrder_item_information(Think.XmlWebServices.Order_item_information[] order_item_information) {
        this.order_item_information = order_item_information;
    }

    public Think.XmlWebServices.Order_item_information getOrder_item_information(int i) {
        return this.order_item_information[i];
    }

    public void setOrder_item_information(int i, Think.XmlWebServices.Order_item_information _value) {
        this.order_item_information[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_information_response)) return false;
        Order_item_information_response other = (Order_item_information_response) obj;
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
              java.util.Arrays.equals(this.customer_identifier, other.getCustomer_identifier()))) &&
            ((this.order_item_information==null && other.getOrder_item_information()==null) || 
             (this.order_item_information!=null &&
              java.util.Arrays.equals(this.order_item_information, other.getOrder_item_information())));
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_identifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_identifier(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrder_item_information() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item_information());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item_information(), i);
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
        new org.apache.axis.description.TypeDesc(Order_item_information_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_information_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_information");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_information"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_information"));
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
