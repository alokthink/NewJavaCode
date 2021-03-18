/**
 * Server_datetime_list_responseServer_datetime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Server_datetime_list_responseServer_datetime  implements java.io.Serializable {
    private java.util.Calendar datetime;  // attribute

    public Server_datetime_list_responseServer_datetime() {
    }

    public Server_datetime_list_responseServer_datetime(
           java.util.Calendar datetime) {
           this.datetime = datetime;
    }


    /**
     * Gets the datetime value for this Server_datetime_list_responseServer_datetime.
     * 
     * @return datetime
     */
    public java.util.Calendar getDatetime() {
        return datetime;
    }


    /**
     * Sets the datetime value for this Server_datetime_list_responseServer_datetime.
     * 
     * @param datetime
     */
    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Server_datetime_list_responseServer_datetime)) return false;
        Server_datetime_list_responseServer_datetime other = (Server_datetime_list_responseServer_datetime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datetime==null && other.getDatetime()==null) || 
             (this.datetime!=null &&
              this.datetime.equals(other.getDatetime())));
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
        if (getDatetime() != null) {
            _hashCode += getDatetime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Server_datetime_list_responseServer_datetime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>server_datetime_list_response>server_datetime"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("datetime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "datetime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
