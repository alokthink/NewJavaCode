/**
 * Direct_debit_verify_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Direct_debit_verify_response  implements java.io.Serializable {
    private Think.XmlWebServices.Bw_response bw_response;

    public Direct_debit_verify_response() {
    }

    public Direct_debit_verify_response(
           Think.XmlWebServices.Bw_response bw_response) {
           this.bw_response = bw_response;
    }


    /**
     * Gets the bw_response value for this Direct_debit_verify_response.
     * 
     * @return bw_response
     */
    public Think.XmlWebServices.Bw_response getBw_response() {
        return bw_response;
    }


    /**
     * Sets the bw_response value for this Direct_debit_verify_response.
     * 
     * @param bw_response
     */
    public void setBw_response(Think.XmlWebServices.Bw_response bw_response) {
        this.bw_response = bw_response;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Direct_debit_verify_response)) return false;
        Direct_debit_verify_response other = (Direct_debit_verify_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bw_response==null && other.getBw_response()==null) || 
             (this.bw_response!=null &&
              this.bw_response.equals(other.getBw_response())));
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
        if (getBw_response() != null) {
            _hashCode += getBw_response().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Direct_debit_verify_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">direct_debit_verify_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bw_response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bw_response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">bw_response"));
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
