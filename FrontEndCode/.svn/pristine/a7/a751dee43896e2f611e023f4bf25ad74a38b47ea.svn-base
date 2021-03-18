/**
 * Px_check_counts_and_amounts_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_check_counts_and_amounts_response  implements java.io.Serializable {
    private boolean counts_match;  // attribute

    private boolean amounts_match;  // attribute

    public Px_check_counts_and_amounts_response() {
    }

    public Px_check_counts_and_amounts_response(
           boolean counts_match,
           boolean amounts_match) {
           this.counts_match = counts_match;
           this.amounts_match = amounts_match;
    }


    /**
     * Gets the counts_match value for this Px_check_counts_and_amounts_response.
     * 
     * @return counts_match
     */
    public boolean isCounts_match() {
        return counts_match;
    }


    /**
     * Sets the counts_match value for this Px_check_counts_and_amounts_response.
     * 
     * @param counts_match
     */
    public void setCounts_match(boolean counts_match) {
        this.counts_match = counts_match;
    }


    /**
     * Gets the amounts_match value for this Px_check_counts_and_amounts_response.
     * 
     * @return amounts_match
     */
    public boolean isAmounts_match() {
        return amounts_match;
    }


    /**
     * Sets the amounts_match value for this Px_check_counts_and_amounts_response.
     * 
     * @param amounts_match
     */
    public void setAmounts_match(boolean amounts_match) {
        this.amounts_match = amounts_match;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_check_counts_and_amounts_response)) return false;
        Px_check_counts_and_amounts_response other = (Px_check_counts_and_amounts_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.counts_match == other.isCounts_match() &&
            this.amounts_match == other.isAmounts_match();
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
        _hashCode += (isCounts_match() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAmounts_match() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_check_counts_and_amounts_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">px_check_counts_and_amounts_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("counts_match");
        attrField.setXmlName(new javax.xml.namespace.QName("", "counts_match"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("amounts_match");
        attrField.setXmlName(new javax.xml.namespace.QName("", "amounts_match"));
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
