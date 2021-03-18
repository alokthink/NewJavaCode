/**
 * Order_types_to_include.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_types_to_include implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Order_types_to_include(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _All = new org.apache.axis.types.NMToken("All");
    public static final org.apache.axis.types.NMToken _Subs = new org.apache.axis.types.NMToken("Subs");
    public static final org.apache.axis.types.NMToken _Singles = new org.apache.axis.types.NMToken("Singles");
    public static final org.apache.axis.types.NMToken _Prods = new org.apache.axis.types.NMToken("Prods");
    public static final org.apache.axis.types.NMToken _Pkgs = new org.apache.axis.types.NMToken("Pkgs");
    public static final org.apache.axis.types.NMToken _ElecDocs = new org.apache.axis.types.NMToken("ElecDocs");
    public static final Order_types_to_include All = new Order_types_to_include(_All);
    public static final Order_types_to_include Subs = new Order_types_to_include(_Subs);
    public static final Order_types_to_include Singles = new Order_types_to_include(_Singles);
    public static final Order_types_to_include Prods = new Order_types_to_include(_Prods);
    public static final Order_types_to_include Pkgs = new Order_types_to_include(_Pkgs);
    public static final Order_types_to_include ElecDocs = new Order_types_to_include(_ElecDocs);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Order_types_to_include fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Order_types_to_include enumeration = (Order_types_to_include)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Order_types_to_include fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Order_types_to_include.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_types_to_include"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
