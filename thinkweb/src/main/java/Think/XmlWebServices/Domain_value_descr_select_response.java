/**
 * Domain_value_descr_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Domain_value_descr_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Domain_value_descr_select_responseDomain_value domain_value;

    public Domain_value_descr_select_response() {
    }

    public Domain_value_descr_select_response(
           Think.XmlWebServices.Domain_value_descr_select_responseDomain_value domain_value) {
           this.domain_value = domain_value;
    }


    /**
     * Gets the domain_value value for this Domain_value_descr_select_response.
     * 
     * @return domain_value
     */
    public Think.XmlWebServices.Domain_value_descr_select_responseDomain_value getDomain_value() {
        return domain_value;
    }


    /**
     * Sets the domain_value value for this Domain_value_descr_select_response.
     * 
     * @param domain_value
     */
    public void setDomain_value(Think.XmlWebServices.Domain_value_descr_select_responseDomain_value domain_value) {
        this.domain_value = domain_value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Domain_value_descr_select_response)) return false;
        Domain_value_descr_select_response other = (Domain_value_descr_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domain_value==null && other.getDomain_value()==null) || 
             (this.domain_value!=null &&
              this.domain_value.equals(other.getDomain_value())));
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
        if (getDomain_value() != null) {
            _hashCode += getDomain_value().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Domain_value_descr_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">domain_value_descr_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domain_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "domain_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>domain_value_descr_select_response>domain_value"));
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
