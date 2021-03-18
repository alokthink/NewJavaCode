/**
 * Change_cost_per_issue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Change_cost_per_issue  implements java.io.Serializable {
    private java.math.BigDecimal from_cost_per_issue;  // attribute

    private java.math.BigDecimal to_cost_per_issue;  // attribute

    public Change_cost_per_issue() {
    }

    public Change_cost_per_issue(
           java.math.BigDecimal from_cost_per_issue,
           java.math.BigDecimal to_cost_per_issue) {
           this.from_cost_per_issue = from_cost_per_issue;
           this.to_cost_per_issue = to_cost_per_issue;
    }


    /**
     * Gets the from_cost_per_issue value for this Change_cost_per_issue.
     * 
     * @return from_cost_per_issue
     */
    public java.math.BigDecimal getFrom_cost_per_issue() {
        return from_cost_per_issue;
    }


    /**
     * Sets the from_cost_per_issue value for this Change_cost_per_issue.
     * 
     * @param from_cost_per_issue
     */
    public void setFrom_cost_per_issue(java.math.BigDecimal from_cost_per_issue) {
        this.from_cost_per_issue = from_cost_per_issue;
    }


    /**
     * Gets the to_cost_per_issue value for this Change_cost_per_issue.
     * 
     * @return to_cost_per_issue
     */
    public java.math.BigDecimal getTo_cost_per_issue() {
        return to_cost_per_issue;
    }


    /**
     * Sets the to_cost_per_issue value for this Change_cost_per_issue.
     * 
     * @param to_cost_per_issue
     */
    public void setTo_cost_per_issue(java.math.BigDecimal to_cost_per_issue) {
        this.to_cost_per_issue = to_cost_per_issue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Change_cost_per_issue)) return false;
        Change_cost_per_issue other = (Change_cost_per_issue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.from_cost_per_issue==null && other.getFrom_cost_per_issue()==null) || 
             (this.from_cost_per_issue!=null &&
              this.from_cost_per_issue.equals(other.getFrom_cost_per_issue()))) &&
            ((this.to_cost_per_issue==null && other.getTo_cost_per_issue()==null) || 
             (this.to_cost_per_issue!=null &&
              this.to_cost_per_issue.equals(other.getTo_cost_per_issue())));
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
        if (getFrom_cost_per_issue() != null) {
            _hashCode += getFrom_cost_per_issue().hashCode();
        }
        if (getTo_cost_per_issue() != null) {
            _hashCode += getTo_cost_per_issue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Change_cost_per_issue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_cost_per_issue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_cost_per_issue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_cost_per_issue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_cost_per_issue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_cost_per_issue"));
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
