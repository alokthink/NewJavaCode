/**
 * Prorate_order_amounts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Prorate_order_amounts  implements java.io.Serializable {
    private java.math.BigDecimal from_oi_amount;  // attribute

    private java.math.BigDecimal to_oi_amount;  // attribute

    private int from_bundle_qty;  // attribute

    private int to_bundle_qty;  // attribute

    public Prorate_order_amounts() {
    }

    public Prorate_order_amounts(
           java.math.BigDecimal from_oi_amount,
           java.math.BigDecimal to_oi_amount,
           int from_bundle_qty,
           int to_bundle_qty) {
           this.from_oi_amount = from_oi_amount;
           this.to_oi_amount = to_oi_amount;
           this.from_bundle_qty = from_bundle_qty;
           this.to_bundle_qty = to_bundle_qty;
    }


    /**
     * Gets the from_oi_amount value for this Prorate_order_amounts.
     * 
     * @return from_oi_amount
     */
    public java.math.BigDecimal getFrom_oi_amount() {
        return from_oi_amount;
    }


    /**
     * Sets the from_oi_amount value for this Prorate_order_amounts.
     * 
     * @param from_oi_amount
     */
    public void setFrom_oi_amount(java.math.BigDecimal from_oi_amount) {
        this.from_oi_amount = from_oi_amount;
    }


    /**
     * Gets the to_oi_amount value for this Prorate_order_amounts.
     * 
     * @return to_oi_amount
     */
    public java.math.BigDecimal getTo_oi_amount() {
        return to_oi_amount;
    }


    /**
     * Sets the to_oi_amount value for this Prorate_order_amounts.
     * 
     * @param to_oi_amount
     */
    public void setTo_oi_amount(java.math.BigDecimal to_oi_amount) {
        this.to_oi_amount = to_oi_amount;
    }


    /**
     * Gets the from_bundle_qty value for this Prorate_order_amounts.
     * 
     * @return from_bundle_qty
     */
    public int getFrom_bundle_qty() {
        return from_bundle_qty;
    }


    /**
     * Sets the from_bundle_qty value for this Prorate_order_amounts.
     * 
     * @param from_bundle_qty
     */
    public void setFrom_bundle_qty(int from_bundle_qty) {
        this.from_bundle_qty = from_bundle_qty;
    }


    /**
     * Gets the to_bundle_qty value for this Prorate_order_amounts.
     * 
     * @return to_bundle_qty
     */
    public int getTo_bundle_qty() {
        return to_bundle_qty;
    }


    /**
     * Sets the to_bundle_qty value for this Prorate_order_amounts.
     * 
     * @param to_bundle_qty
     */
    public void setTo_bundle_qty(int to_bundle_qty) {
        this.to_bundle_qty = to_bundle_qty;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prorate_order_amounts)) return false;
        Prorate_order_amounts other = (Prorate_order_amounts) obj;
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
              this.to_oi_amount.equals(other.getTo_oi_amount()))) &&
            this.from_bundle_qty == other.getFrom_bundle_qty() &&
            this.to_bundle_qty == other.getTo_bundle_qty();
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
        _hashCode += getFrom_bundle_qty();
        _hashCode += getTo_bundle_qty();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Prorate_order_amounts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">prorate_order_amounts"));
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
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
