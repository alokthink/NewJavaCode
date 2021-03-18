/**
 * Oc_descr_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Oc_descr_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Oc_descr_select_responseOc oc;

    public Oc_descr_select_response() {
    }

    public Oc_descr_select_response(
           Think.XmlWebServices.Oc_descr_select_responseOc oc) {
           this.oc = oc;
    }


    /**
     * Gets the oc value for this Oc_descr_select_response.
     * 
     * @return oc
     */
    public Think.XmlWebServices.Oc_descr_select_responseOc getOc() {
        return oc;
    }


    /**
     * Sets the oc value for this Oc_descr_select_response.
     * 
     * @param oc
     */
    public void setOc(Think.XmlWebServices.Oc_descr_select_responseOc oc) {
        this.oc = oc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Oc_descr_select_response)) return false;
        Oc_descr_select_response other = (Oc_descr_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oc==null && other.getOc()==null) || 
             (this.oc!=null &&
              this.oc.equals(other.getOc())));
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
        if (getOc() != null) {
            _hashCode += getOc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Oc_descr_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">oc_descr_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "oc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>oc_descr_select_response>oc"));
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
