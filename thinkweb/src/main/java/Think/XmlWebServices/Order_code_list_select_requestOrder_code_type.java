/**
 * Order_code_list_select_requestOrder_code_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_code_list_select_requestOrder_code_type implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Order_code_list_select_requestOrder_code_type(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _subscriptions = "subscriptions";
    public static final java.lang.String _single_issues = "single_issues";
    public static final java.lang.String _products = "products";
    public static final java.lang.String _electronic_documents = "electronic_documents";
    public static final java.lang.String _packages = "packages";
    public static final java.lang.String _quick_orders = "quick_orders";
    public static final java.lang.String _NA = "NA";
    public static final Order_code_list_select_requestOrder_code_type subscriptions = new Order_code_list_select_requestOrder_code_type(_subscriptions);
    public static final Order_code_list_select_requestOrder_code_type single_issues = new Order_code_list_select_requestOrder_code_type(_single_issues);
    public static final Order_code_list_select_requestOrder_code_type products = new Order_code_list_select_requestOrder_code_type(_products);
    public static final Order_code_list_select_requestOrder_code_type electronic_documents = new Order_code_list_select_requestOrder_code_type(_electronic_documents);
    public static final Order_code_list_select_requestOrder_code_type packages = new Order_code_list_select_requestOrder_code_type(_packages);
    public static final Order_code_list_select_requestOrder_code_type quick_orders = new Order_code_list_select_requestOrder_code_type(_quick_orders);
    public static final Order_code_list_select_requestOrder_code_type NA = new Order_code_list_select_requestOrder_code_type(_NA);
    public java.lang.String getValue() { return _value_;}
    public static Order_code_list_select_requestOrder_code_type fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Order_code_list_select_requestOrder_code_type enumeration = (Order_code_list_select_requestOrder_code_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Order_code_list_select_requestOrder_code_type fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Order_code_list_select_requestOrder_code_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>order_code_list_select_request>order_code_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
