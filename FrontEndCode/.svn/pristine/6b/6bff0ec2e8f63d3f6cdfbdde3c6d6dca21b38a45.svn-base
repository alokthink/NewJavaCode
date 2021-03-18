/**
 * Suspension_reason.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_reason implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Suspension_reason(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _nonpay = new org.apache.axis.types.NMToken("nonpay");
    public static final org.apache.axis.types.NMToken _payhold = new org.apache.axis.types.NMToken("payhold");
    public static final org.apache.axis.types.NMToken _requested = new org.apache.axis.types.NMToken("requested");
    public static final org.apache.axis.types.NMToken _oldDemographics = new org.apache.axis.types.NMToken("oldDemographics");
    public static final org.apache.axis.types.NMToken _behavior = new org.apache.axis.types.NMToken("behavior");
    public static final org.apache.axis.types.NMToken _waitingSettleRetry = new org.apache.axis.types.NMToken("waitingSettleRetry");
    public static final Suspension_reason nonpay = new Suspension_reason(_nonpay);
    public static final Suspension_reason payhold = new Suspension_reason(_payhold);
    public static final Suspension_reason requested = new Suspension_reason(_requested);
    public static final Suspension_reason oldDemographics = new Suspension_reason(_oldDemographics);
    public static final Suspension_reason behavior = new Suspension_reason(_behavior);
    public static final Suspension_reason waitingSettleRetry = new Suspension_reason(_waitingSettleRetry);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Suspension_reason fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Suspension_reason enumeration = (Suspension_reason)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Suspension_reason fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Suspension_reason.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_reason"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
