/**
 * Attachment_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Attachment_identifier  implements java.io.Serializable {
    private int key1;

    private java.lang.Integer key2;

    private java.lang.Integer attachment_id;

    private Think.XmlWebServices.Attachment_type attachment_type;  // attribute

    public Attachment_identifier() {
    }

    public Attachment_identifier(
           int key1,
           java.lang.Integer key2,
           java.lang.Integer attachment_id,
           Think.XmlWebServices.Attachment_type attachment_type) {
           this.key1 = key1;
           this.key2 = key2;
           this.attachment_id = attachment_id;
           this.attachment_type = attachment_type;
    }


    /**
     * Gets the key1 value for this Attachment_identifier.
     * 
     * @return key1
     */
    public int getKey1() {
        return key1;
    }


    /**
     * Sets the key1 value for this Attachment_identifier.
     * 
     * @param key1
     */
    public void setKey1(int key1) {
        this.key1 = key1;
    }


    /**
     * Gets the key2 value for this Attachment_identifier.
     * 
     * @return key2
     */
    public java.lang.Integer getKey2() {
        return key2;
    }


    /**
     * Sets the key2 value for this Attachment_identifier.
     * 
     * @param key2
     */
    public void setKey2(java.lang.Integer key2) {
        this.key2 = key2;
    }


    /**
     * Gets the attachment_id value for this Attachment_identifier.
     * 
     * @return attachment_id
     */
    public java.lang.Integer getAttachment_id() {
        return attachment_id;
    }


    /**
     * Sets the attachment_id value for this Attachment_identifier.
     * 
     * @param attachment_id
     */
    public void setAttachment_id(java.lang.Integer attachment_id) {
        this.attachment_id = attachment_id;
    }


    /**
     * Gets the attachment_type value for this Attachment_identifier.
     * 
     * @return attachment_type
     */
    public Think.XmlWebServices.Attachment_type getAttachment_type() {
        return attachment_type;
    }


    /**
     * Sets the attachment_type value for this Attachment_identifier.
     * 
     * @param attachment_type
     */
    public void setAttachment_type(Think.XmlWebServices.Attachment_type attachment_type) {
        this.attachment_type = attachment_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Attachment_identifier)) return false;
        Attachment_identifier other = (Attachment_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.key1 == other.getKey1() &&
            ((this.key2==null && other.getKey2()==null) || 
             (this.key2!=null &&
              this.key2.equals(other.getKey2()))) &&
            ((this.attachment_id==null && other.getAttachment_id()==null) || 
             (this.attachment_id!=null &&
              this.attachment_id.equals(other.getAttachment_id()))) &&
            ((this.attachment_type==null && other.getAttachment_type()==null) || 
             (this.attachment_type!=null &&
              this.attachment_type.equals(other.getAttachment_type())));
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
        _hashCode += getKey1();
        if (getKey2() != null) {
            _hashCode += getKey2().hashCode();
        }
        if (getAttachment_id() != null) {
            _hashCode += getAttachment_id().hashCode();
        }
        if (getAttachment_type() != null) {
            _hashCode += getAttachment_type().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attachment_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">attachment_identifier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "attachment_type"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "key1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "key2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachment_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "attachment_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
