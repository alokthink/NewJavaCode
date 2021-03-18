/**
 * Source_code_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Source_code_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Source_code_select_responseSource_code source_code;

    public Source_code_select_response() {
    }

    public Source_code_select_response(
           Think.XmlWebServices.Source_code_select_responseSource_code source_code) {
           this.source_code = source_code;
    }


    /**
     * Gets the source_code value for this Source_code_select_response.
     * 
     * @return source_code
     */
    public Think.XmlWebServices.Source_code_select_responseSource_code getSource_code() {
        return source_code;
    }


    /**
     * Sets the source_code value for this Source_code_select_response.
     * 
     * @param source_code
     */
    public void setSource_code(Think.XmlWebServices.Source_code_select_responseSource_code source_code) {
        this.source_code = source_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Source_code_select_response)) return false;
        Source_code_select_response other = (Source_code_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.source_code==null && other.getSource_code()==null) || 
             (this.source_code!=null &&
              this.source_code.equals(other.getSource_code())));
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
        if (getSource_code() != null) {
            _hashCode += getSource_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Source_code_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">source_code_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "source_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>source_code_select_response>source_code"));
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
