/**
 * Upgrade_or_downgrade_enum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Upgrade_or_downgrade_enum implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Upgrade_or_downgrade_enum(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _both = new org.apache.axis.types.NMToken("both");
    public static final org.apache.axis.types.NMToken _upgrade = new org.apache.axis.types.NMToken("upgrade");
    public static final org.apache.axis.types.NMToken _downgrade = new org.apache.axis.types.NMToken("downgrade");
    public static final Upgrade_or_downgrade_enum both = new Upgrade_or_downgrade_enum(_both);
    public static final Upgrade_or_downgrade_enum upgrade = new Upgrade_or_downgrade_enum(_upgrade);
    public static final Upgrade_or_downgrade_enum downgrade = new Upgrade_or_downgrade_enum(_downgrade);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Upgrade_or_downgrade_enum fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Upgrade_or_downgrade_enum enumeration = (Upgrade_or_downgrade_enum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Upgrade_or_downgrade_enum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Upgrade_or_downgrade_enum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "upgrade_or_downgrade_enum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
