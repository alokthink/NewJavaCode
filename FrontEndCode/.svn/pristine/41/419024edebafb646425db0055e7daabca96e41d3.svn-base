/**
 * Domain_value_descr_select_responseDomain_value.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Domain_value_descr_select_responseDomain_value  implements java.io.Serializable {
    private java.lang.String short_description;  // attribute

    public Domain_value_descr_select_responseDomain_value() {
    }

    public Domain_value_descr_select_responseDomain_value(
           java.lang.String short_description) {
           this.short_description = short_description;
    }


    /**
     * Gets the short_description value for this Domain_value_descr_select_responseDomain_value.
     * 
     * @return short_description
     */
    public java.lang.String getShort_description() {
        return short_description;
    }


    /**
     * Sets the short_description value for this Domain_value_descr_select_responseDomain_value.
     * 
     * @param short_description
     */
    public void setShort_description(java.lang.String short_description) {
        this.short_description = short_description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Domain_value_descr_select_responseDomain_value)) return false;
        Domain_value_descr_select_responseDomain_value other = (Domain_value_descr_select_responseDomain_value) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.short_description==null && other.getShort_description()==null) || 
             (this.short_description!=null &&
              this.short_description.equals(other.getShort_description())));
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
        if (getShort_description() != null) {
            _hashCode += getShort_description().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Domain_value_descr_select_responseDomain_value.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>domain_value_descr_select_response>domain_value"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("short_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "short_description"));
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
