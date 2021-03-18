/**
 * Server_datetime_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Server_datetime_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Server_datetime_list_responseServer_datetime server_datetime;

    public Server_datetime_list_response() {
    }

    public Server_datetime_list_response(
           Think.XmlWebServices.Server_datetime_list_responseServer_datetime server_datetime) {
           this.server_datetime = server_datetime;
    }


    /**
     * Gets the server_datetime value for this Server_datetime_list_response.
     * 
     * @return server_datetime
     */
    public Think.XmlWebServices.Server_datetime_list_responseServer_datetime getServer_datetime() {
        return server_datetime;
    }


    /**
     * Sets the server_datetime value for this Server_datetime_list_response.
     * 
     * @param server_datetime
     */
    public void setServer_datetime(Think.XmlWebServices.Server_datetime_list_responseServer_datetime server_datetime) {
        this.server_datetime = server_datetime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Server_datetime_list_response)) return false;
        Server_datetime_list_response other = (Server_datetime_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.server_datetime==null && other.getServer_datetime()==null) || 
             (this.server_datetime!=null &&
              this.server_datetime.equals(other.getServer_datetime())));
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
        if (getServer_datetime() != null) {
            _hashCode += getServer_datetime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Server_datetime_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">server_datetime_list_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("server_datetime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "server_datetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>server_datetime_list_response>server_datetime"));
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
