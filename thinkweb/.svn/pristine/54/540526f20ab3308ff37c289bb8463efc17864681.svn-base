/**
 * User_code_matches.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class User_code_matches implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected User_code_matches(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _ucUserCode = new org.apache.axis.types.NMToken("ucUserCode");
    public static final org.apache.axis.types.NMToken _ucAssignedTo = new org.apache.axis.types.NMToken("ucAssignedTo");
    public static final org.apache.axis.types.NMToken _ucUserCodeAndAssignedTo = new org.apache.axis.types.NMToken("ucUserCodeAndAssignedTo");
    public static final org.apache.axis.types.NMToken _ucUserCodeOrAssignedTo = new org.apache.axis.types.NMToken("ucUserCodeOrAssignedTo");
    public static final User_code_matches ucUserCode = new User_code_matches(_ucUserCode);
    public static final User_code_matches ucAssignedTo = new User_code_matches(_ucAssignedTo);
    public static final User_code_matches ucUserCodeAndAssignedTo = new User_code_matches(_ucUserCodeAndAssignedTo);
    public static final User_code_matches ucUserCodeOrAssignedTo = new User_code_matches(_ucUserCodeOrAssignedTo);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static User_code_matches fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        User_code_matches enumeration = (User_code_matches)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static User_code_matches fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(User_code_matches.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code_matches"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
