/**
 * Aux_field_select_requestTable_name.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Aux_field_select_requestTable_name implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Aux_field_select_requestTable_name(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _customer = "customer";
    public static final java.lang.String _customer_address = "customer_address";
    public static final java.lang.String _order_item = "order_item";
    public static final java.lang.String _payment = "payment";
    public static final java.lang.String _customer_login = "customer_login";
    public static final java.lang.String _service = "service";
    public static final java.lang.String _NA = "NA";
    public static final Aux_field_select_requestTable_name customer = new Aux_field_select_requestTable_name(_customer);
    public static final Aux_field_select_requestTable_name customer_address = new Aux_field_select_requestTable_name(_customer_address);
    public static final Aux_field_select_requestTable_name order_item = new Aux_field_select_requestTable_name(_order_item);
    public static final Aux_field_select_requestTable_name payment = new Aux_field_select_requestTable_name(_payment);
    public static final Aux_field_select_requestTable_name customer_login = new Aux_field_select_requestTable_name(_customer_login);
    public static final Aux_field_select_requestTable_name service = new Aux_field_select_requestTable_name(_service);
    public static final Aux_field_select_requestTable_name NA = new Aux_field_select_requestTable_name(_NA);
    public java.lang.String getValue() { return _value_;}
    public static Aux_field_select_requestTable_name fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Aux_field_select_requestTable_name enumeration = (Aux_field_select_requestTable_name)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Aux_field_select_requestTable_name fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
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
        new org.apache.axis.description.TypeDesc(Aux_field_select_requestTable_name.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>aux_field_select_request>table_name"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
