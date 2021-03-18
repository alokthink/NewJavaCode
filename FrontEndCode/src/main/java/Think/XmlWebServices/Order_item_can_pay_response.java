/**
 * Order_item_can_pay_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_can_pay_response  implements java.io.Serializable {
    private boolean can_pay;  // attribute

    private int reason_cannot_pay_code;  // attribute

    private java.lang.String reason_cannot_pay_string;  // attribute

    public Order_item_can_pay_response() {
    }

    public Order_item_can_pay_response(
           boolean can_pay,
           int reason_cannot_pay_code,
           java.lang.String reason_cannot_pay_string) {
           this.can_pay = can_pay;
           this.reason_cannot_pay_code = reason_cannot_pay_code;
           this.reason_cannot_pay_string = reason_cannot_pay_string;
    }


    /**
     * Gets the can_pay value for this Order_item_can_pay_response.
     * 
     * @return can_pay
     */
    public boolean isCan_pay() {
        return can_pay;
    }


    /**
     * Sets the can_pay value for this Order_item_can_pay_response.
     * 
     * @param can_pay
     */
    public void setCan_pay(boolean can_pay) {
        this.can_pay = can_pay;
    }


    /**
     * Gets the reason_cannot_pay_code value for this Order_item_can_pay_response.
     * 
     * @return reason_cannot_pay_code
     */
    public int getReason_cannot_pay_code() {
        return reason_cannot_pay_code;
    }


    /**
     * Sets the reason_cannot_pay_code value for this Order_item_can_pay_response.
     * 
     * @param reason_cannot_pay_code
     */
    public void setReason_cannot_pay_code(int reason_cannot_pay_code) {
        this.reason_cannot_pay_code = reason_cannot_pay_code;
    }


    /**
     * Gets the reason_cannot_pay_string value for this Order_item_can_pay_response.
     * 
     * @return reason_cannot_pay_string
     */
    public java.lang.String getReason_cannot_pay_string() {
        return reason_cannot_pay_string;
    }


    /**
     * Sets the reason_cannot_pay_string value for this Order_item_can_pay_response.
     * 
     * @param reason_cannot_pay_string
     */
    public void setReason_cannot_pay_string(java.lang.String reason_cannot_pay_string) {
        this.reason_cannot_pay_string = reason_cannot_pay_string;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_can_pay_response)) return false;
        Order_item_can_pay_response other = (Order_item_can_pay_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.can_pay == other.isCan_pay() &&
            this.reason_cannot_pay_code == other.getReason_cannot_pay_code() &&
            ((this.reason_cannot_pay_string==null && other.getReason_cannot_pay_string()==null) || 
             (this.reason_cannot_pay_string!=null &&
              this.reason_cannot_pay_string.equals(other.getReason_cannot_pay_string())));
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
        _hashCode += (isCan_pay() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getReason_cannot_pay_code();
        if (getReason_cannot_pay_string() != null) {
            _hashCode += getReason_cannot_pay_string().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_can_pay_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_can_pay_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("can_pay");
        attrField.setXmlName(new javax.xml.namespace.QName("", "can_pay"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reason_cannot_pay_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reason_cannot_pay_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reason_cannot_pay_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reason_cannot_pay_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
