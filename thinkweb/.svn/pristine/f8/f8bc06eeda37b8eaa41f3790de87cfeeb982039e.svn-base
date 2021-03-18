/**
 * Bw_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Bw_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean is_verified;  // attribute

    private java.lang.String bank_wizard_errors;  // attribute

    public Bw_response() {
    }

    public Bw_response(
           Think.XmlWebServices.ZZBoolean is_verified,
           java.lang.String bank_wizard_errors) {
           this.is_verified = is_verified;
           this.bank_wizard_errors = bank_wizard_errors;
    }


    /**
     * Gets the is_verified value for this Bw_response.
     * 
     * @return is_verified
     */
    public Think.XmlWebServices.ZZBoolean getIs_verified() {
        return is_verified;
    }


    /**
     * Sets the is_verified value for this Bw_response.
     * 
     * @param is_verified
     */
    public void setIs_verified(Think.XmlWebServices.ZZBoolean is_verified) {
        this.is_verified = is_verified;
    }


    /**
     * Gets the bank_wizard_errors value for this Bw_response.
     * 
     * @return bank_wizard_errors
     */
    public java.lang.String getBank_wizard_errors() {
        return bank_wizard_errors;
    }


    /**
     * Sets the bank_wizard_errors value for this Bw_response.
     * 
     * @param bank_wizard_errors
     */
    public void setBank_wizard_errors(java.lang.String bank_wizard_errors) {
        this.bank_wizard_errors = bank_wizard_errors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bw_response)) return false;
        Bw_response other = (Bw_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.is_verified==null && other.getIs_verified()==null) || 
             (this.is_verified!=null &&
              this.is_verified.equals(other.getIs_verified()))) &&
            ((this.bank_wizard_errors==null && other.getBank_wizard_errors()==null) || 
             (this.bank_wizard_errors!=null &&
              this.bank_wizard_errors.equals(other.getBank_wizard_errors())));
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
        if (getIs_verified() != null) {
            _hashCode += getIs_verified().hashCode();
        }
        if (getBank_wizard_errors() != null) {
            _hashCode += getBank_wizard_errors().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bw_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">bw_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_verified");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_verified"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bank_wizard_errors");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bank_wizard_errors"));
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
