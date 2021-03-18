/**
 * Transfer_role_enum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Transfer_role_enum implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Transfer_role_enum(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _transfer_owner = new org.apache.axis.types.NMToken("transfer_owner");
    public static final org.apache.axis.types.NMToken _transfer_bill_to = new org.apache.axis.types.NMToken("transfer_bill_to");
    public static final org.apache.axis.types.NMToken _transfer_renew_to = new org.apache.axis.types.NMToken("transfer_renew_to");
    public static final Transfer_role_enum transfer_owner = new Transfer_role_enum(_transfer_owner);
    public static final Transfer_role_enum transfer_bill_to = new Transfer_role_enum(_transfer_bill_to);
    public static final Transfer_role_enum transfer_renew_to = new Transfer_role_enum(_transfer_renew_to);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Transfer_role_enum fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Transfer_role_enum enumeration = (Transfer_role_enum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Transfer_role_enum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Transfer_role_enum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_role_enum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
