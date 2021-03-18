/**
 * Prorate_subscrip_amounts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Prorate_subscrip_amounts  implements java.io.Serializable {
    private java.math.BigDecimal from_subscrip_amount;  // attribute

    private java.math.BigDecimal to_subscrip_amount;  // attribute

    private java.math.BigDecimal price_change;  // attribute

    private int from_bundle_qty;  // attribute

    private int to_bundle_qty;  // attribute

    public Prorate_subscrip_amounts() {
    }

    public Prorate_subscrip_amounts(
           java.math.BigDecimal from_subscrip_amount,
           java.math.BigDecimal to_subscrip_amount,
           java.math.BigDecimal price_change,
           int from_bundle_qty,
           int to_bundle_qty) {
           this.from_subscrip_amount = from_subscrip_amount;
           this.to_subscrip_amount = to_subscrip_amount;
           this.price_change = price_change;
           this.from_bundle_qty = from_bundle_qty;
           this.to_bundle_qty = to_bundle_qty;
    }


    /**
     * Gets the from_subscrip_amount value for this Prorate_subscrip_amounts.
     * 
     * @return from_subscrip_amount
     */
    public java.math.BigDecimal getFrom_subscrip_amount() {
        return from_subscrip_amount;
    }


    /**
     * Sets the from_subscrip_amount value for this Prorate_subscrip_amounts.
     * 
     * @param from_subscrip_amount
     */
    public void setFrom_subscrip_amount(java.math.BigDecimal from_subscrip_amount) {
        this.from_subscrip_amount = from_subscrip_amount;
    }


    /**
     * Gets the to_subscrip_amount value for this Prorate_subscrip_amounts.
     * 
     * @return to_subscrip_amount
     */
    public java.math.BigDecimal getTo_subscrip_amount() {
        return to_subscrip_amount;
    }


    /**
     * Sets the to_subscrip_amount value for this Prorate_subscrip_amounts.
     * 
     * @param to_subscrip_amount
     */
    public void setTo_subscrip_amount(java.math.BigDecimal to_subscrip_amount) {
        this.to_subscrip_amount = to_subscrip_amount;
    }


    /**
     * Gets the price_change value for this Prorate_subscrip_amounts.
     * 
     * @return price_change
     */
    public java.math.BigDecimal getPrice_change() {
        return price_change;
    }


    /**
     * Sets the price_change value for this Prorate_subscrip_amounts.
     * 
     * @param price_change
     */
    public void setPrice_change(java.math.BigDecimal price_change) {
        this.price_change = price_change;
    }


    /**
     * Gets the from_bundle_qty value for this Prorate_subscrip_amounts.
     * 
     * @return from_bundle_qty
     */
    public int getFrom_bundle_qty() {
        return from_bundle_qty;
    }


    /**
     * Sets the from_bundle_qty value for this Prorate_subscrip_amounts.
     * 
     * @param from_bundle_qty
     */
    public void setFrom_bundle_qty(int from_bundle_qty) {
        this.from_bundle_qty = from_bundle_qty;
    }


    /**
     * Gets the to_bundle_qty value for this Prorate_subscrip_amounts.
     * 
     * @return to_bundle_qty
     */
    public int getTo_bundle_qty() {
        return to_bundle_qty;
    }


    /**
     * Sets the to_bundle_qty value for this Prorate_subscrip_amounts.
     * 
     * @param to_bundle_qty
     */
    public void setTo_bundle_qty(int to_bundle_qty) {
        this.to_bundle_qty = to_bundle_qty;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prorate_subscrip_amounts)) return false;
        Prorate_subscrip_amounts other = (Prorate_subscrip_amounts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.from_subscrip_amount==null && other.getFrom_subscrip_amount()==null) || 
             (this.from_subscrip_amount!=null &&
              this.from_subscrip_amount.equals(other.getFrom_subscrip_amount()))) &&
            ((this.to_subscrip_amount==null && other.getTo_subscrip_amount()==null) || 
             (this.to_subscrip_amount!=null &&
              this.to_subscrip_amount.equals(other.getTo_subscrip_amount()))) &&
            ((this.price_change==null && other.getPrice_change()==null) || 
             (this.price_change!=null &&
              this.price_change.equals(other.getPrice_change()))) &&
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
        if (getFrom_subscrip_amount() != null) {
            _hashCode += getFrom_subscrip_amount().hashCode();
        }
        if (getTo_subscrip_amount() != null) {
            _hashCode += getTo_subscrip_amount().hashCode();
        }
        if (getPrice_change() != null) {
            _hashCode += getPrice_change().hashCode();
        }
        _hashCode += getFrom_bundle_qty();
        _hashCode += getTo_bundle_qty();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Prorate_subscrip_amounts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">prorate_subscrip_amounts"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_subscrip_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_subscrip_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_subscrip_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_subscrip_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price_change"));
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
