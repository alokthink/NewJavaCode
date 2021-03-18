/**
 * Ics_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Ics_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean is_verified;  // attribute

    private Think.XmlWebServices.ZZBoolean expired;  // attribute

    private java.lang.String candidate_secure_store_id;  // attribute

    public Ics_response() {
    }

    public Ics_response(
           Think.XmlWebServices.ZZBoolean is_verified,
           Think.XmlWebServices.ZZBoolean expired,
           java.lang.String candidate_secure_store_id) {
           this.is_verified = is_verified;
           this.expired = expired;
           this.candidate_secure_store_id = candidate_secure_store_id;
    }


    /**
     * Gets the is_verified value for this Ics_response.
     * 
     * @return is_verified
     */
    public Think.XmlWebServices.ZZBoolean getIs_verified() {
        return is_verified;
    }


    /**
     * Sets the is_verified value for this Ics_response.
     * 
     * @param is_verified
     */
    public void setIs_verified(Think.XmlWebServices.ZZBoolean is_verified) {
        this.is_verified = is_verified;
    }


    /**
     * Gets the expired value for this Ics_response.
     * 
     * @return expired
     */
    public Think.XmlWebServices.ZZBoolean getExpired() {
        return expired;
    }


    /**
     * Sets the expired value for this Ics_response.
     * 
     * @param expired
     */
    public void setExpired(Think.XmlWebServices.ZZBoolean expired) {
        this.expired = expired;
    }


    /**
     * Gets the candidate_secure_store_id value for this Ics_response.
     * 
     * @return candidate_secure_store_id
     */
    public java.lang.String getCandidate_secure_store_id() {
        return candidate_secure_store_id;
    }


    /**
     * Sets the candidate_secure_store_id value for this Ics_response.
     * 
     * @param candidate_secure_store_id
     */
    public void setCandidate_secure_store_id(java.lang.String candidate_secure_store_id) {
        this.candidate_secure_store_id = candidate_secure_store_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ics_response)) return false;
        Ics_response other = (Ics_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.is_verified==null && other.getIs_verified()==null) || 
             (this.is_verified!=null &&
              this.is_verified.equals(other.getIs_verified()))) &&
            ((this.expired==null && other.getExpired()==null) || 
             (this.expired!=null &&
              this.expired.equals(other.getExpired()))) &&
            ((this.candidate_secure_store_id==null && other.getCandidate_secure_store_id()==null) || 
             (this.candidate_secure_store_id!=null &&
              this.candidate_secure_store_id.equals(other.getCandidate_secure_store_id())));
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
        if (getIs_verified() != null) {
            _hashCode += getIs_verified().hashCode();
        }
        if (getExpired() != null) {
            _hashCode += getExpired().hashCode();
        }
        if (getCandidate_secure_store_id() != null) {
            _hashCode += getCandidate_secure_store_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ics_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">ics_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_verified");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_verified"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("expired");
        attrField.setXmlName(new javax.xml.namespace.QName("", "expired"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("candidate_secure_store_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "candidate_secure_store_id"));
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
