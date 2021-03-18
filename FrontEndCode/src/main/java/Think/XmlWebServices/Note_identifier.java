/**
 * Note_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Note_identifier  implements java.io.Serializable {
    private int key1;

    private java.lang.Integer key2;

    private java.lang.Integer key3;

    private java.lang.Integer seq;

    private Think.XmlWebServices.Note_type note_type;  // attribute

    public Note_identifier() {
    }

    public Note_identifier(
           int key1,
           java.lang.Integer key2,
           java.lang.Integer key3,
           java.lang.Integer seq,
           Think.XmlWebServices.Note_type note_type) {
           this.key1 = key1;
           this.key2 = key2;
           this.key3 = key3;
           this.seq = seq;
           this.note_type = note_type;
    }


    /**
     * Gets the key1 value for this Note_identifier.
     * 
     * @return key1
     */
    public int getKey1() {
        return key1;
    }


    /**
     * Sets the key1 value for this Note_identifier.
     * 
     * @param key1
     */
    public void setKey1(int key1) {
        this.key1 = key1;
    }


    /**
     * Gets the key2 value for this Note_identifier.
     * 
     * @return key2
     */
    public java.lang.Integer getKey2() {
        return key2;
    }


    /**
     * Sets the key2 value for this Note_identifier.
     * 
     * @param key2
     */
    public void setKey2(java.lang.Integer key2) {
        this.key2 = key2;
    }


    /**
     * Gets the key3 value for this Note_identifier.
     * 
     * @return key3
     */
    public java.lang.Integer getKey3() {
        return key3;
    }


    /**
     * Sets the key3 value for this Note_identifier.
     * 
     * @param key3
     */
    public void setKey3(java.lang.Integer key3) {
        this.key3 = key3;
    }


    /**
     * Gets the seq value for this Note_identifier.
     * 
     * @return seq
     */
    public java.lang.Integer getSeq() {
        return seq;
    }


    /**
     * Sets the seq value for this Note_identifier.
     * 
     * @param seq
     */
    public void setSeq(java.lang.Integer seq) {
        this.seq = seq;
    }


    /**
     * Gets the note_type value for this Note_identifier.
     * 
     * @return note_type
     */
    public Think.XmlWebServices.Note_type getNote_type() {
        return note_type;
    }


    /**
     * Sets the note_type value for this Note_identifier.
     * 
     * @param note_type
     */
    public void setNote_type(Think.XmlWebServices.Note_type note_type) {
        this.note_type = note_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Note_identifier)) return false;
        Note_identifier other = (Note_identifier) obj;
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
            ((this.key3==null && other.getKey3()==null) || 
             (this.key3!=null &&
              this.key3.equals(other.getKey3()))) &&
            ((this.seq==null && other.getSeq()==null) || 
             (this.seq!=null &&
              this.seq.equals(other.getSeq()))) &&
            ((this.note_type==null && other.getNote_type()==null) || 
             (this.note_type!=null &&
              this.note_type.equals(other.getNote_type())));
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
        if (getKey3() != null) {
            _hashCode += getKey3().hashCode();
        }
        if (getSeq() != null) {
            _hashCode += getSeq().hashCode();
        }
        if (getNote_type() != null) {
            _hashCode += getNote_type().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Note_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">note_identifier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("note_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "note_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "note_type"));
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
        elemField.setFieldName("key3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "key3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "seq"));
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
