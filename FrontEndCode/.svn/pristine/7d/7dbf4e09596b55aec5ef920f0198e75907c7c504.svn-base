/**
 * Credit_card_verify_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Credit_card_verify_response  implements java.io.Serializable {
    private Think.XmlWebServices.Ics_response ics_response;

    public Credit_card_verify_response() {
    }

    public Credit_card_verify_response(
           Think.XmlWebServices.Ics_response ics_response) {
           this.ics_response = ics_response;
    }


    /**
     * Gets the ics_response value for this Credit_card_verify_response.
     * 
     * @return ics_response
     */
    public Think.XmlWebServices.Ics_response getIcs_response() {
        return ics_response;
    }


    /**
     * Sets the ics_response value for this Credit_card_verify_response.
     * 
     * @param ics_response
     */
    public void setIcs_response(Think.XmlWebServices.Ics_response ics_response) {
        this.ics_response = ics_response;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Credit_card_verify_response)) return false;
        Credit_card_verify_response other = (Credit_card_verify_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ics_response==null && other.getIcs_response()==null) || 
             (this.ics_response!=null &&
              this.ics_response.equals(other.getIcs_response())));
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
        if (getIcs_response() != null) {
            _hashCode += getIcs_response().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Credit_card_verify_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">credit_card_verify_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ics_response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ics_response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">ics_response"));
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
