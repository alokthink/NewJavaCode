/**
 * Currency_reason.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Currency_reason implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Currency_reason(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _noDflt = new org.apache.axis.types.NMToken("noDflt");
    public static final org.apache.axis.types.NMToken _noPmt = new org.apache.axis.types.NMToken("noPmt");
    public static final org.apache.axis.types.NMToken _onePmt = new org.apache.axis.types.NMToken("onePmt");
    public static final org.apache.axis.types.NMToken _multPmtOne = new org.apache.axis.types.NMToken("multPmtOne");
    public static final org.apache.axis.types.NMToken _multPmtMult = new org.apache.axis.types.NMToken("multPmtMult");
    public static final org.apache.axis.types.NMToken _requested = new org.apache.axis.types.NMToken("requested");
    public static final Currency_reason noDflt = new Currency_reason(_noDflt);
    public static final Currency_reason noPmt = new Currency_reason(_noPmt);
    public static final Currency_reason onePmt = new Currency_reason(_onePmt);
    public static final Currency_reason multPmtOne = new Currency_reason(_multPmtOne);
    public static final Currency_reason multPmtMult = new Currency_reason(_multPmtMult);
    public static final Currency_reason requested = new Currency_reason(_requested);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Currency_reason fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Currency_reason enumeration = (Currency_reason)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Currency_reason fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Currency_reason.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency_reason"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
