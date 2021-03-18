/**
 * Request_log_delete_responseRequest_log.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Request_log_delete_responseRequest_log  extends Think.XmlWebServices.ZZRequestLog  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean _deleted;  // attribute

    public Request_log_delete_responseRequest_log() {
    }

    public Request_log_delete_responseRequest_log(
           int request_log_id,
           java.lang.String client_machine_name,
           java.lang.String edit_trail,
           java.lang.String expanded_info,
           java.lang.String request,
           java.util.Calendar request_date_time,
           java.lang.String response,
           java.lang.String server_machine_name,
           java.util.Calendar status_change_date_time,
           int user_definable_status,
           Think.XmlWebServices.ZZBoolean _deleted) {
        super(
            request_log_id,
            client_machine_name,
            edit_trail,
            expanded_info,
            request,
            request_date_time,
            response,
            server_machine_name,
            status_change_date_time,
            user_definable_status);
        this._deleted = _deleted;
    }


    /**
     * Gets the _deleted value for this Request_log_delete_responseRequest_log.
     * 
     * @return _deleted
     */
    public Think.XmlWebServices.ZZBoolean get_deleted() {
        return _deleted;
    }


    /**
     * Sets the _deleted value for this Request_log_delete_responseRequest_log.
     * 
     * @param _deleted
     */
    public void set_deleted(Think.XmlWebServices.ZZBoolean _deleted) {
        this._deleted = _deleted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Request_log_delete_responseRequest_log)) return false;
        Request_log_delete_responseRequest_log other = (Request_log_delete_responseRequest_log) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this._deleted==null && other.get_deleted()==null) || 
             (this._deleted!=null &&
              this._deleted.equals(other.get_deleted())));
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
        if (get_deleted() != null) {
            _hashCode += get_deleted().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Request_log_delete_responseRequest_log.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>request_log_delete_response>request_log"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_deleted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "_deleted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
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
