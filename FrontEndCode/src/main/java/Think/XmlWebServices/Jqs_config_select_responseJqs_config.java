/**
 * Jqs_config_select_responseJqs_config.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_config_select_responseJqs_config  implements java.io.Serializable {
    private java.lang.String default_notification_email;  // attribute

    public Jqs_config_select_responseJqs_config() {
    }

    public Jqs_config_select_responseJqs_config(
           java.lang.String default_notification_email) {
           this.default_notification_email = default_notification_email;
    }


    /**
     * Gets the default_notification_email value for this Jqs_config_select_responseJqs_config.
     * 
     * @return default_notification_email
     */
    public java.lang.String getDefault_notification_email() {
        return default_notification_email;
    }


    /**
     * Sets the default_notification_email value for this Jqs_config_select_responseJqs_config.
     * 
     * @param default_notification_email
     */
    public void setDefault_notification_email(java.lang.String default_notification_email) {
        this.default_notification_email = default_notification_email;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_config_select_responseJqs_config)) return false;
        Jqs_config_select_responseJqs_config other = (Jqs_config_select_responseJqs_config) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.default_notification_email==null && other.getDefault_notification_email()==null) || 
             (this.default_notification_email!=null &&
              this.default_notification_email.equals(other.getDefault_notification_email())));
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
        if (getDefault_notification_email() != null) {
            _hashCode += getDefault_notification_email().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_config_select_responseJqs_config.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_config_select_response>jqs_config"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_notification_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_notification_email"));
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
