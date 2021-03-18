/**
 * Document_reference_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Document_reference_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZDocumentReference document_reference;

    public Document_reference_edit_response() {
    }

    public Document_reference_edit_response(
           Think.XmlWebServices.ZZDocumentReference document_reference) {
           this.document_reference = document_reference;
    }


    /**
     * Gets the document_reference value for this Document_reference_edit_response.
     * 
     * @return document_reference
     */
    public Think.XmlWebServices.ZZDocumentReference getDocument_reference() {
        return document_reference;
    }


    /**
     * Sets the document_reference value for this Document_reference_edit_response.
     * 
     * @param document_reference
     */
    public void setDocument_reference(Think.XmlWebServices.ZZDocumentReference document_reference) {
        this.document_reference = document_reference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Document_reference_edit_response)) return false;
        Document_reference_edit_response other = (Document_reference_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.document_reference==null && other.getDocument_reference()==null) || 
             (this.document_reference!=null &&
              this.document_reference.equals(other.getDocument_reference())));
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
        if (getDocument_reference() != null) {
            _hashCode += getDocument_reference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Document_reference_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">document_reference_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document_reference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "document_reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZDocumentReference"));
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
