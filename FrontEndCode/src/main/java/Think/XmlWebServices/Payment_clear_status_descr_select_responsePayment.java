/**
 * Payment_clear_status_descr_select_responsePayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_clear_status_descr_select_responsePayment  implements java.io.Serializable {
    private java.lang.String short_description;  // attribute

    public Payment_clear_status_descr_select_responsePayment() {
    }

    public Payment_clear_status_descr_select_responsePayment(
           java.lang.String short_description) {
           this.short_description = short_description;
    }


    /**
     * Gets the short_description value for this Payment_clear_status_descr_select_responsePayment.
     * 
     * @return short_description
     */
    public java.lang.String getShort_description() {
        return short_description;
    }


    /**
     * Sets the short_description value for this Payment_clear_status_descr_select_responsePayment.
     * 
     * @param short_description
     */
    public void setShort_description(java.lang.String short_description) {
        this.short_description = short_description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_clear_status_descr_select_responsePayment)) return false;
        Payment_clear_status_descr_select_responsePayment other = (Payment_clear_status_descr_select_responsePayment) obj;
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
        new org.apache.axis.description.TypeDesc(Payment_clear_status_descr_select_responsePayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>payment_clear_status_descr_select_response>payment"));
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
