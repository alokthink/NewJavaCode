/**
 * Note_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Note_type implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Note_type(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _customer = new org.apache.axis.types.NMToken("customer");
    public static final org.apache.axis.types.NMToken _item = new org.apache.axis.types.NMToken("item");
    public static final org.apache.axis.types.NMToken _payment = new org.apache.axis.types.NMToken("payment");
    public static final org.apache.axis.types.NMToken _service = new org.apache.axis.types.NMToken("service");
    public static final org.apache.axis.types.NMToken _subscrip = new org.apache.axis.types.NMToken("subscrip");
    public static final org.apache.axis.types.NMToken _suspension = new org.apache.axis.types.NMToken("suspension");
    public static final Note_type customer = new Note_type(_customer);
    public static final Note_type item = new Note_type(_item);
    public static final Note_type payment = new Note_type(_payment);
    public static final Note_type service = new Note_type(_service);
    public static final Note_type subscrip = new Note_type(_subscrip);
    public static final Note_type suspension = new Note_type(_suspension);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Note_type fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Note_type enumeration = (Note_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Note_type fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        try {
            return fromValue(new org.apache.axis.types.NMToken(value));
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_.toString();}
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
        new org.apache.axis.description.TypeDesc(Note_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "note_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
