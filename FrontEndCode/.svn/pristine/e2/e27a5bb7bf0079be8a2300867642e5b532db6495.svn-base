/**
 * Source_code_lookup_select_responseSource_code.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Source_code_lookup_select_responseSource_code  implements java.io.Serializable {
    private int source_code_id;  // attribute

    private java.lang.String source_code;  // attribute

    private java.lang.String description;  // attribute

    public Source_code_lookup_select_responseSource_code() {
    }

    public Source_code_lookup_select_responseSource_code(
           int source_code_id,
           java.lang.String source_code,
           java.lang.String description) {
           this.source_code_id = source_code_id;
           this.source_code = source_code;
           this.description = description;
    }


    /**
     * Gets the source_code_id value for this Source_code_lookup_select_responseSource_code.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Source_code_lookup_select_responseSource_code.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the source_code value for this Source_code_lookup_select_responseSource_code.
     * 
     * @return source_code
     */
    public java.lang.String getSource_code() {
        return source_code;
    }


    /**
     * Sets the source_code value for this Source_code_lookup_select_responseSource_code.
     * 
     * @param source_code
     */
    public void setSource_code(java.lang.String source_code) {
        this.source_code = source_code;
    }


    /**
     * Gets the description value for this Source_code_lookup_select_responseSource_code.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Source_code_lookup_select_responseSource_code.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Source_code_lookup_select_responseSource_code)) return false;
        Source_code_lookup_select_responseSource_code other = (Source_code_lookup_select_responseSource_code) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.source_code_id == other.getSource_code_id() &&
            ((this.source_code==null && other.getSource_code()==null) || 
             (this.source_code!=null &&
              this.source_code.equals(other.getSource_code()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription())));
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
        _hashCode += getSource_code_id();
        if (getSource_code() != null) {
            _hashCode += getSource_code().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Source_code_lookup_select_responseSource_code.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>source_code_lookup_select_response>source_code"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
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
