/**
 * History_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class History_type implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected History_type(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _subscription = new org.apache.axis.types.NMToken("subscription");
    public static final org.apache.axis.types.NMToken _single_issue = new org.apache.axis.types.NMToken("single_issue");
    public static final org.apache.axis.types.NMToken _product = new org.apache.axis.types.NMToken("product");
    public static final org.apache.axis.types.NMToken _renewal_effort = new org.apache.axis.types.NMToken("renewal_effort");
    public static final org.apache.axis.types.NMToken _billing_effort = new org.apache.axis.types.NMToken("billing_effort");
    public static final org.apache.axis.types.NMToken _promotion_effort = new org.apache.axis.types.NMToken("promotion_effort");
    public static final org.apache.axis.types.NMToken _unit = new org.apache.axis.types.NMToken("unit");
    public static final org.apache.axis.types.NMToken _customer_login = new org.apache.axis.types.NMToken("customer_login");
    public static final History_type subscription = new History_type(_subscription);
    public static final History_type single_issue = new History_type(_single_issue);
    public static final History_type product = new History_type(_product);
    public static final History_type renewal_effort = new History_type(_renewal_effort);
    public static final History_type billing_effort = new History_type(_billing_effort);
    public static final History_type promotion_effort = new History_type(_promotion_effort);
    public static final History_type unit = new History_type(_unit);
    public static final History_type customer_login = new History_type(_customer_login);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static History_type fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        History_type enumeration = (History_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static History_type fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(History_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "history_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
