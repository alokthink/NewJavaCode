/**
 * Jqs_client_list_responseJqs_client.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_client_list_responseJqs_client  extends Think.XmlWebServices.ZZJqsClient  implements java.io.Serializable {
    private java.lang.String password_encrypted;  // attribute

    public Jqs_client_list_responseJqs_client() {
    }

    public Jqs_client_list_responseJqs_client(
           int jqs_client_id,
           int connection_verified,
           java.lang.String default_fatal_email,
           java.lang.String default_from_email,
           java.lang.String default_job_done_email,
           java.lang.String default_no_connect_email,
           int default_notification_bits,
           java.lang.String default_on_hold_email,
           java.lang.String default_output_ready_email,
           java.lang.String default_review_ready_email,
           java.lang.String default_warning_email,
           java.lang.String description,
           java.lang.String dsn,
           java.lang.String login,
           java.lang.String password,
           java.lang.String password_encrypted) {
        super(
            jqs_client_id,
            connection_verified,
            default_fatal_email,
            default_from_email,
            default_job_done_email,
            default_no_connect_email,
            default_notification_bits,
            default_on_hold_email,
            default_output_ready_email,
            default_review_ready_email,
            default_warning_email,
            description,
            dsn,
            login,
            password);
        this.password_encrypted = password_encrypted;
    }


    /**
     * Gets the password_encrypted value for this Jqs_client_list_responseJqs_client.
     * 
     * @return password_encrypted
     */
    public java.lang.String getPassword_encrypted() {
        return password_encrypted;
    }


    /**
     * Sets the password_encrypted value for this Jqs_client_list_responseJqs_client.
     * 
     * @param password_encrypted
     */
    public void setPassword_encrypted(java.lang.String password_encrypted) {
        this.password_encrypted = password_encrypted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_client_list_responseJqs_client)) return false;
        Jqs_client_list_responseJqs_client other = (Jqs_client_list_responseJqs_client) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.password_encrypted==null && other.getPassword_encrypted()==null) || 
             (this.password_encrypted!=null &&
              this.password_encrypted.equals(other.getPassword_encrypted())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getPassword_encrypted() != null) {
            _hashCode += getPassword_encrypted().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_client_list_responseJqs_client.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_client_list_response>jqs_client"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("password_encrypted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password_encrypted"));
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
