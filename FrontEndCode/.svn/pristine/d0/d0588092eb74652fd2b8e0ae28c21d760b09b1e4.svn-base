/**
 * Px_add_requestPx_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_add_requestPx_identifier  extends Think.XmlWebServices.ZZPXIdentifier  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean latest_open_for_internet;  // attribute

    public Px_add_requestPx_identifier() {
    }

    public Px_add_requestPx_identifier(
           int pending_xaction_header_id,
           java.lang.Integer pending_xaction_seq,
           Think.XmlWebServices.ZZBoolean latest_open_for_internet) {
        super(
            pending_xaction_header_id,
            pending_xaction_seq);
        this.latest_open_for_internet = latest_open_for_internet;
    }


    /**
     * Gets the latest_open_for_internet value for this Px_add_requestPx_identifier.
     * 
     * @return latest_open_for_internet
     */
    public Think.XmlWebServices.ZZBoolean getLatest_open_for_internet() {
        return latest_open_for_internet;
    }


    /**
     * Sets the latest_open_for_internet value for this Px_add_requestPx_identifier.
     * 
     * @param latest_open_for_internet
     */
    public void setLatest_open_for_internet(Think.XmlWebServices.ZZBoolean latest_open_for_internet) {
        this.latest_open_for_internet = latest_open_for_internet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_add_requestPx_identifier)) return false;
        Px_add_requestPx_identifier other = (Px_add_requestPx_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.latest_open_for_internet==null && other.getLatest_open_for_internet()==null) || 
             (this.latest_open_for_internet!=null &&
              this.latest_open_for_internet.equals(other.getLatest_open_for_internet())));
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
        if (getLatest_open_for_internet() != null) {
            _hashCode += getLatest_open_for_internet().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_add_requestPx_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>px_add_request>px_identifier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("latest_open_for_internet");
        attrField.setXmlName(new javax.xml.namespace.QName("", "latest_open_for_internet"));
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
