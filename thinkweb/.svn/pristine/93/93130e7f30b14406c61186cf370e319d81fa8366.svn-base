/**
 * Threshold_range.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Threshold_range implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Threshold_range(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _partial = new org.apache.axis.types.NMToken("partial");
    public static final org.apache.axis.types.NMToken _under = new org.apache.axis.types.NMToken("under");
    public static final org.apache.axis.types.NMToken _under_accept_as_full = new org.apache.axis.types.NMToken("under_accept_as_full");
    public static final org.apache.axis.types.NMToken _full = new org.apache.axis.types.NMToken("full");
    public static final org.apache.axis.types.NMToken _over_accept_as_full = new org.apache.axis.types.NMToken("over_accept_as_full");
    public static final org.apache.axis.types.NMToken _over = new org.apache.axis.types.NMToken("over");
    public static final org.apache.axis.types.NMToken _refund_or_deposit = new org.apache.axis.types.NMToken("refund_or_deposit");
    public static final Threshold_range partial = new Threshold_range(_partial);
    public static final Threshold_range under = new Threshold_range(_under);
    public static final Threshold_range under_accept_as_full = new Threshold_range(_under_accept_as_full);
    public static final Threshold_range full = new Threshold_range(_full);
    public static final Threshold_range over_accept_as_full = new Threshold_range(_over_accept_as_full);
    public static final Threshold_range over = new Threshold_range(_over);
    public static final Threshold_range refund_or_deposit = new Threshold_range(_refund_or_deposit);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Threshold_range fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Threshold_range enumeration = (Threshold_range)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Threshold_range fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Threshold_range.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "threshold_range"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
