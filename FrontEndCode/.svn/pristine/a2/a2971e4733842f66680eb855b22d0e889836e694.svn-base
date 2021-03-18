/**
 * Attachment_select_requestAttachment_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Attachment_select_requestAttachment_type implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Attachment_select_requestAttachment_type(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _all = "all";
    public static final java.lang.String _customer = "customer";
    public static final java.lang.String _item = "item";
    public static final java.lang.String _payment = "payment";
    public static final Attachment_select_requestAttachment_type all = new Attachment_select_requestAttachment_type(_all);
    public static final Attachment_select_requestAttachment_type customer = new Attachment_select_requestAttachment_type(_customer);
    public static final Attachment_select_requestAttachment_type item = new Attachment_select_requestAttachment_type(_item);
    public static final Attachment_select_requestAttachment_type payment = new Attachment_select_requestAttachment_type(_payment);
    public java.lang.String getValue() { return _value_;}
    public static Attachment_select_requestAttachment_type fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Attachment_select_requestAttachment_type enumeration = (Attachment_select_requestAttachment_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Attachment_select_requestAttachment_type fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attachment_select_requestAttachment_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>attachment_select_request>attachment_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
