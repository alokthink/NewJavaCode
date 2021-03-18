/**
 * Note_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Note_data  implements java.io.Serializable {
    private Think.XmlWebServices.Note_identifier note_identifier;

    private java.lang.String note_field;

    public Note_data() {
    }

    public Note_data(
           Think.XmlWebServices.Note_identifier note_identifier,
           java.lang.String note_field) {
           this.note_identifier = note_identifier;
           this.note_field = note_field;
    }


    /**
     * Gets the note_identifier value for this Note_data.
     * 
     * @return note_identifier
     */
    public Think.XmlWebServices.Note_identifier getNote_identifier() {
        return note_identifier;
    }


    /**
     * Sets the note_identifier value for this Note_data.
     * 
     * @param note_identifier
     */
    public void setNote_identifier(Think.XmlWebServices.Note_identifier note_identifier) {
        this.note_identifier = note_identifier;
    }


    /**
     * Gets the note_field value for this Note_data.
     * 
     * @return note_field
     */
    public java.lang.String getNote_field() {
        return note_field;
    }


    /**
     * Sets the note_field value for this Note_data.
     * 
     * @param note_field
     */
    public void setNote_field(java.lang.String note_field) {
        this.note_field = note_field;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Note_data)) return false;
        Note_data other = (Note_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.note_identifier==null && other.getNote_identifier()==null) || 
             (this.note_identifier!=null &&
              this.note_identifier.equals(other.getNote_identifier()))) &&
            ((this.note_field==null && other.getNote_field()==null) || 
             (this.note_field!=null &&
              this.note_field.equals(other.getNote_field())));
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
        if (getNote_identifier() != null) {
            _hashCode += getNote_identifier().hashCode();
        }
        if (getNote_field() != null) {
            _hashCode += getNote_field().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Note_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">note_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "note_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">note_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note_field");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "note_field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
