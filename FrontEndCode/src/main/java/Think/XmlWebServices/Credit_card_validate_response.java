/**
 * Credit_card_validate_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Credit_card_validate_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean is_valid;  // attribute

    private java.lang.Integer determined_credit_card_type;  // attribute

    public Credit_card_validate_response() {
    }

    public Credit_card_validate_response(
           Think.XmlWebServices.ZZBoolean is_valid,
           java.lang.Integer determined_credit_card_type) {
           this.is_valid = is_valid;
           this.determined_credit_card_type = determined_credit_card_type;
    }


    /**
     * Gets the is_valid value for this Credit_card_validate_response.
     * 
     * @return is_valid
     */
    public Think.XmlWebServices.ZZBoolean getIs_valid() {
        return is_valid;
    }


    /**
     * Sets the is_valid value for this Credit_card_validate_response.
     * 
     * @param is_valid
     */
    public void setIs_valid(Think.XmlWebServices.ZZBoolean is_valid) {
        this.is_valid = is_valid;
    }


    /**
     * Gets the determined_credit_card_type value for this Credit_card_validate_response.
     * 
     * @return determined_credit_card_type
     */
    public java.lang.Integer getDetermined_credit_card_type() {
        return determined_credit_card_type;
    }


    /**
     * Sets the determined_credit_card_type value for this Credit_card_validate_response.
     * 
     * @param determined_credit_card_type
     */
    public void setDetermined_credit_card_type(java.lang.Integer determined_credit_card_type) {
        this.determined_credit_card_type = determined_credit_card_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Credit_card_validate_response)) return false;
        Credit_card_validate_response other = (Credit_card_validate_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.is_valid==null && other.getIs_valid()==null) || 
             (this.is_valid!=null &&
              this.is_valid.equals(other.getIs_valid()))) &&
            ((this.determined_credit_card_type==null && other.getDetermined_credit_card_type()==null) || 
             (this.determined_credit_card_type!=null &&
              this.determined_credit_card_type.equals(other.getDetermined_credit_card_type())));
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
        if (getIs_valid() != null) {
            _hashCode += getIs_valid().hashCode();
        }
        if (getDetermined_credit_card_type() != null) {
            _hashCode += getDetermined_credit_card_type().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Credit_card_validate_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">credit_card_validate_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_valid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_valid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("determined_credit_card_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "determined_credit_card_type"));
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
