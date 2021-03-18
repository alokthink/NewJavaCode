/**
 * Order_item_needs_payment_settled_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_needs_payment_settled_response  implements java.io.Serializable {
    private boolean needs_payment_settled;  // attribute

    public Order_item_needs_payment_settled_response() {
    }

    public Order_item_needs_payment_settled_response(
           boolean needs_payment_settled) {
           this.needs_payment_settled = needs_payment_settled;
    }


    /**
     * Gets the needs_payment_settled value for this Order_item_needs_payment_settled_response.
     * 
     * @return needs_payment_settled
     */
    public boolean isNeeds_payment_settled() {
        return needs_payment_settled;
    }


    /**
     * Sets the needs_payment_settled value for this Order_item_needs_payment_settled_response.
     * 
     * @param needs_payment_settled
     */
    public void setNeeds_payment_settled(boolean needs_payment_settled) {
        this.needs_payment_settled = needs_payment_settled;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_needs_payment_settled_response)) return false;
        Order_item_needs_payment_settled_response other = (Order_item_needs_payment_settled_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.needs_payment_settled == other.isNeeds_payment_settled();
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
        _hashCode += (isNeeds_payment_settled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_needs_payment_settled_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_needs_payment_settled_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("needs_payment_settled");
        attrField.setXmlName(new javax.xml.namespace.QName("", "needs_payment_settled"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
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
