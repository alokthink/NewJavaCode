/**
 * Consortium_part_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Consortium_part_type implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Consortium_part_type(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _notInConsortium = new org.apache.axis.types.NMToken("notInConsortium");
    public static final org.apache.axis.types.NMToken _group = new org.apache.axis.types.NMToken("group");
    public static final org.apache.axis.types.NMToken _groupMember = new org.apache.axis.types.NMToken("groupMember");
    public static final org.apache.axis.types.NMToken _orderingGroup = new org.apache.axis.types.NMToken("orderingGroup");
    public static final Consortium_part_type notInConsortium = new Consortium_part_type(_notInConsortium);
    public static final Consortium_part_type group = new Consortium_part_type(_group);
    public static final Consortium_part_type groupMember = new Consortium_part_type(_groupMember);
    public static final Consortium_part_type orderingGroup = new Consortium_part_type(_orderingGroup);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Consortium_part_type fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Consortium_part_type enumeration = (Consortium_part_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Consortium_part_type fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Consortium_part_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "consortium_part_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
