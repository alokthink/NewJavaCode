/**
 * Payment_info_option_enum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_info_option_enum implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Payment_info_option_enum(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _no_info = new org.apache.axis.types.NMToken("no_info");
    public static final org.apache.axis.types.NMToken _use_credit_card = new org.apache.axis.types.NMToken("use_credit_card");
    public static final org.apache.axis.types.NMToken _use_direct_debit = new org.apache.axis.types.NMToken("use_direct_debit");
    public static final Payment_info_option_enum no_info = new Payment_info_option_enum(_no_info);
    public static final Payment_info_option_enum use_credit_card = new Payment_info_option_enum(_use_credit_card);
    public static final Payment_info_option_enum use_direct_debit = new Payment_info_option_enum(_use_direct_debit);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Payment_info_option_enum fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Payment_info_option_enum enumeration = (Payment_info_option_enum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Payment_info_option_enum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Payment_info_option_enum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_info_option_enum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
