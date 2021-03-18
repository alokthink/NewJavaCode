/**
 * Gpc_lookup_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Gpc_lookup_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Gpc_lookup_select_responseGeneric_promotion_code generic_promotion_code;

    public Gpc_lookup_select_response() {
    }

    public Gpc_lookup_select_response(
           Think.XmlWebServices.Gpc_lookup_select_responseGeneric_promotion_code generic_promotion_code) {
           this.generic_promotion_code = generic_promotion_code;
    }


    /**
     * Gets the generic_promotion_code value for this Gpc_lookup_select_response.
     * 
     * @return generic_promotion_code
     */
    public Think.XmlWebServices.Gpc_lookup_select_responseGeneric_promotion_code getGeneric_promotion_code() {
        return generic_promotion_code;
    }


    /**
     * Sets the generic_promotion_code value for this Gpc_lookup_select_response.
     * 
     * @param generic_promotion_code
     */
    public void setGeneric_promotion_code(Think.XmlWebServices.Gpc_lookup_select_responseGeneric_promotion_code generic_promotion_code) {
        this.generic_promotion_code = generic_promotion_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Gpc_lookup_select_response)) return false;
        Gpc_lookup_select_response other = (Gpc_lookup_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.generic_promotion_code==null && other.getGeneric_promotion_code()==null) || 
             (this.generic_promotion_code!=null &&
              this.generic_promotion_code.equals(other.getGeneric_promotion_code())));
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
        if (getGeneric_promotion_code() != null) {
            _hashCode += getGeneric_promotion_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Gpc_lookup_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">gpc_lookup_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generic_promotion_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "generic_promotion_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>gpc_lookup_select_response>generic_promotion_code"));
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
