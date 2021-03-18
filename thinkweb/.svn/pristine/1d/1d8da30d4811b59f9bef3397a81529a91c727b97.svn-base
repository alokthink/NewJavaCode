/**
 * Payment_waiting_auth_or_post_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_waiting_auth_or_post_response  implements java.io.Serializable {
    private boolean waiting_auth_or_post;  // attribute

    public Payment_waiting_auth_or_post_response() {
    }

    public Payment_waiting_auth_or_post_response(
           boolean waiting_auth_or_post) {
           this.waiting_auth_or_post = waiting_auth_or_post;
    }


    /**
     * Gets the waiting_auth_or_post value for this Payment_waiting_auth_or_post_response.
     * 
     * @return waiting_auth_or_post
     */
    public boolean isWaiting_auth_or_post() {
        return waiting_auth_or_post;
    }


    /**
     * Sets the waiting_auth_or_post value for this Payment_waiting_auth_or_post_response.
     * 
     * @param waiting_auth_or_post
     */
    public void setWaiting_auth_or_post(boolean waiting_auth_or_post) {
        this.waiting_auth_or_post = waiting_auth_or_post;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_waiting_auth_or_post_response)) return false;
        Payment_waiting_auth_or_post_response other = (Payment_waiting_auth_or_post_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.waiting_auth_or_post == other.isWaiting_auth_or_post();
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
        _hashCode += (isWaiting_auth_or_post() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_waiting_auth_or_post_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_waiting_auth_or_post_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("waiting_auth_or_post");
        attrField.setXmlName(new javax.xml.namespace.QName("", "waiting_auth_or_post"));
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
