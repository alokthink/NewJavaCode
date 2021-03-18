/**
 * Change_order_amounts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Change_order_amounts  implements java.io.Serializable {
    private java.math.BigDecimal from_oi_amount;  // attribute

    private java.math.BigDecimal to_oi_amount;  // attribute

    public Change_order_amounts() {
    }

    public Change_order_amounts(
           java.math.BigDecimal from_oi_amount,
           java.math.BigDecimal to_oi_amount) {
           this.from_oi_amount = from_oi_amount;
           this.to_oi_amount = to_oi_amount;
    }


    /**
     * Gets the from_oi_amount value for this Change_order_amounts.
     * 
     * @return from_oi_amount
     */
    public java.math.BigDecimal getFrom_oi_amount() {
        return from_oi_amount;
    }


    /**
     * Sets the from_oi_amount value for this Change_order_amounts.
     * 
     * @param from_oi_amount
     */
    public void setFrom_oi_amount(java.math.BigDecimal from_oi_amount) {
        this.from_oi_amount = from_oi_amount;
    }


    /**
     * Gets the to_oi_amount value for this Change_order_amounts.
     * 
     * @return to_oi_amount
     */
    public java.math.BigDecimal getTo_oi_amount() {
        return to_oi_amount;
    }


    /**
     * Sets the to_oi_amount value for this Change_order_amounts.
     * 
     * @param to_oi_amount
     */
    public void setTo_oi_amount(java.math.BigDecimal to_oi_amount) {
        this.to_oi_amount = to_oi_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Change_order_amounts)) return false;
        Change_order_amounts other = (Change_order_amounts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.from_oi_amount==null && other.getFrom_oi_amount()==null) || 
             (this.from_oi_amount!=null &&
              this.from_oi_amount.equals(other.getFrom_oi_amount()))) &&
            ((this.to_oi_amount==null && other.getTo_oi_amount()==null) || 
             (this.to_oi_amount!=null &&
              this.to_oi_amount.equals(other.getTo_oi_amount())));
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
        if (getFrom_oi_amount() != null) {
            _hashCode += getFrom_oi_amount().hashCode();
        }
        if (getTo_oi_amount() != null) {
            _hashCode += getTo_oi_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Change_order_amounts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_order_amounts"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_oi_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_oi_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_oi_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_oi_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
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
