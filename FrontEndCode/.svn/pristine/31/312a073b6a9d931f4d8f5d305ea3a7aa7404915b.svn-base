/**
 * Cc_status_enum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Cc_status_enum implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Cc_status_enum(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _active = new org.apache.axis.types.NMToken("active");
    public static final org.apache.axis.types.NMToken _trial = new org.apache.axis.types.NMToken("trial");
    public static final org.apache.axis.types.NMToken _future = new org.apache.axis.types.NMToken("future");
    public static final org.apache.axis.types.NMToken _inactive = new org.apache.axis.types.NMToken("inactive");
    public static final org.apache.axis.types.NMToken _completed = new org.apache.axis.types.NMToken("completed");
    public static final org.apache.axis.types.NMToken _cancelled = new org.apache.axis.types.NMToken("cancelled");
    public static final org.apache.axis.types.NMToken _suspended = new org.apache.axis.types.NMToken("suspended");
    public static final Cc_status_enum active = new Cc_status_enum(_active);
    public static final Cc_status_enum trial = new Cc_status_enum(_trial);
    public static final Cc_status_enum future = new Cc_status_enum(_future);
    public static final Cc_status_enum inactive = new Cc_status_enum(_inactive);
    public static final Cc_status_enum completed = new Cc_status_enum(_completed);
    public static final Cc_status_enum cancelled = new Cc_status_enum(_cancelled);
    public static final Cc_status_enum suspended = new Cc_status_enum(_suspended);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Cc_status_enum fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Cc_status_enum enumeration = (Cc_status_enum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Cc_status_enum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Cc_status_enum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cc_status_enum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
