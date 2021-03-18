/**
 * Change_cost_per_day.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Change_cost_per_day  implements java.io.Serializable {
    private java.math.BigDecimal from_cost_per_day;  // attribute

    private java.math.BigDecimal to_cost_per_day;  // attribute

    public Change_cost_per_day() {
    }

    public Change_cost_per_day(
           java.math.BigDecimal from_cost_per_day,
           java.math.BigDecimal to_cost_per_day) {
           this.from_cost_per_day = from_cost_per_day;
           this.to_cost_per_day = to_cost_per_day;
    }


    /**
     * Gets the from_cost_per_day value for this Change_cost_per_day.
     * 
     * @return from_cost_per_day
     */
    public java.math.BigDecimal getFrom_cost_per_day() {
        return from_cost_per_day;
    }


    /**
     * Sets the from_cost_per_day value for this Change_cost_per_day.
     * 
     * @param from_cost_per_day
     */
    public void setFrom_cost_per_day(java.math.BigDecimal from_cost_per_day) {
        this.from_cost_per_day = from_cost_per_day;
    }


    /**
     * Gets the to_cost_per_day value for this Change_cost_per_day.
     * 
     * @return to_cost_per_day
     */
    public java.math.BigDecimal getTo_cost_per_day() {
        return to_cost_per_day;
    }


    /**
     * Sets the to_cost_per_day value for this Change_cost_per_day.
     * 
     * @param to_cost_per_day
     */
    public void setTo_cost_per_day(java.math.BigDecimal to_cost_per_day) {
        this.to_cost_per_day = to_cost_per_day;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Change_cost_per_day)) return false;
        Change_cost_per_day other = (Change_cost_per_day) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.from_cost_per_day==null && other.getFrom_cost_per_day()==null) || 
             (this.from_cost_per_day!=null &&
              this.from_cost_per_day.equals(other.getFrom_cost_per_day()))) &&
            ((this.to_cost_per_day==null && other.getTo_cost_per_day()==null) || 
             (this.to_cost_per_day!=null &&
              this.to_cost_per_day.equals(other.getTo_cost_per_day())));
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
        if (getFrom_cost_per_day() != null) {
            _hashCode += getFrom_cost_per_day().hashCode();
        }
        if (getTo_cost_per_day() != null) {
            _hashCode += getTo_cost_per_day().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Change_cost_per_day.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_cost_per_day"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_cost_per_day");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_cost_per_day"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_cost_per_day");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_cost_per_day"));
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
