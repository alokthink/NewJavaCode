/**
 * Jqs_client_add_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_client_add_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZJqsClient jqs_client;

    public Jqs_client_add_response() {
    }

    public Jqs_client_add_response(
           Think.XmlWebServices.ZZJqsClient jqs_client) {
           this.jqs_client = jqs_client;
    }


    /**
     * Gets the jqs_client value for this Jqs_client_add_response.
     * 
     * @return jqs_client
     */
    public Think.XmlWebServices.ZZJqsClient getJqs_client() {
        return jqs_client;
    }


    /**
     * Sets the jqs_client value for this Jqs_client_add_response.
     * 
     * @param jqs_client
     */
    public void setJqs_client(Think.XmlWebServices.ZZJqsClient jqs_client) {
        this.jqs_client = jqs_client;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_client_add_response)) return false;
        Jqs_client_add_response other = (Jqs_client_add_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jqs_client==null && other.getJqs_client()==null) || 
             (this.jqs_client!=null &&
              this.jqs_client.equals(other.getJqs_client())));
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
        if (getJqs_client() != null) {
            _hashCode += getJqs_client().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_client_add_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_client_add_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_client");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZJqsClient"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
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
