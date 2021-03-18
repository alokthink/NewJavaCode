/**
 * Px_add_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_add_response  implements java.io.Serializable {
    private Think.XmlWebServices.Pending_xaction_header pending_xaction_header;

    public Px_add_response() {
    }

    public Px_add_response(
           Think.XmlWebServices.Pending_xaction_header pending_xaction_header) {
           this.pending_xaction_header = pending_xaction_header;
    }


    /**
     * Gets the pending_xaction_header value for this Px_add_response.
     * 
     * @return pending_xaction_header
     */
    public Think.XmlWebServices.Pending_xaction_header getPending_xaction_header() {
        return pending_xaction_header;
    }


    /**
     * Sets the pending_xaction_header value for this Px_add_response.
     * 
     * @param pending_xaction_header
     */
    public void setPending_xaction_header(Think.XmlWebServices.Pending_xaction_header pending_xaction_header) {
        this.pending_xaction_header = pending_xaction_header;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_add_response)) return false;
        Px_add_response other = (Px_add_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pending_xaction_header==null && other.getPending_xaction_header()==null) || 
             (this.pending_xaction_header!=null &&
              this.pending_xaction_header.equals(other.getPending_xaction_header())));
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
        if (getPending_xaction_header() != null) {
            _hashCode += getPending_xaction_header().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_add_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">px_add_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pending_xaction_header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pending_xaction_header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">pending_xaction_header"));
        elemField.setMinOccurs(0);
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
