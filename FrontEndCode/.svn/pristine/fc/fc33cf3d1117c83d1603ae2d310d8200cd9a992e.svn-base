/**
 * Change_subscrip_amounts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Change_subscrip_amounts  implements java.io.Serializable {
    private java.math.BigDecimal from_subscrip_amount;  // attribute

    private java.math.BigDecimal to_subscrip_amount;  // attribute

    public Change_subscrip_amounts() {
    }

    public Change_subscrip_amounts(
           java.math.BigDecimal from_subscrip_amount,
           java.math.BigDecimal to_subscrip_amount) {
           this.from_subscrip_amount = from_subscrip_amount;
           this.to_subscrip_amount = to_subscrip_amount;
    }


    /**
     * Gets the from_subscrip_amount value for this Change_subscrip_amounts.
     * 
     * @return from_subscrip_amount
     */
    public java.math.BigDecimal getFrom_subscrip_amount() {
        return from_subscrip_amount;
    }


    /**
     * Sets the from_subscrip_amount value for this Change_subscrip_amounts.
     * 
     * @param from_subscrip_amount
     */
    public void setFrom_subscrip_amount(java.math.BigDecimal from_subscrip_amount) {
        this.from_subscrip_amount = from_subscrip_amount;
    }


    /**
     * Gets the to_subscrip_amount value for this Change_subscrip_amounts.
     * 
     * @return to_subscrip_amount
     */
    public java.math.BigDecimal getTo_subscrip_amount() {
        return to_subscrip_amount;
    }


    /**
     * Sets the to_subscrip_amount value for this Change_subscrip_amounts.
     * 
     * @param to_subscrip_amount
     */
    public void setTo_subscrip_amount(java.math.BigDecimal to_subscrip_amount) {
        this.to_subscrip_amount = to_subscrip_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Change_subscrip_amounts)) return false;
        Change_subscrip_amounts other = (Change_subscrip_amounts) obj;
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
              this.to_subscrip_amount.equals(other.getTo_subscrip_amount())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Change_subscrip_amounts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_subscrip_amounts"));
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
