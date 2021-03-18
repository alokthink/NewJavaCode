/**
 * Excess_unit_usage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Excess_unit_usage implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Excess_unit_usage(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _no = new org.apache.axis.types.NMToken("no");
    public static final org.apache.axis.types.NMToken _yes = new org.apache.axis.types.NMToken("yes");
    public static final org.apache.axis.types.NMToken _paynow = new org.apache.axis.types.NMToken("paynow");
    public static final org.apache.axis.types.NMToken _unlimited = new org.apache.axis.types.NMToken("unlimited");
    public static final Excess_unit_usage no = new Excess_unit_usage(_no);
    public static final Excess_unit_usage yes = new Excess_unit_usage(_yes);
    public static final Excess_unit_usage paynow = new Excess_unit_usage(_paynow);
    public static final Excess_unit_usage unlimited = new Excess_unit_usage(_unlimited);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Excess_unit_usage fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Excess_unit_usage enumeration = (Excess_unit_usage)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Excess_unit_usage fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Excess_unit_usage.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "excess_unit_usage"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
