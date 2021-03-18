/**
 * Jqs_alert_select_requestAlert_sent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_alert_select_requestAlert_sent implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Jqs_alert_select_requestAlert_sent(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _yes = "yes";
    public static final java.lang.String _no = "no";
    public static final java.lang.String _either = "either";
    public static final Jqs_alert_select_requestAlert_sent yes = new Jqs_alert_select_requestAlert_sent(_yes);
    public static final Jqs_alert_select_requestAlert_sent no = new Jqs_alert_select_requestAlert_sent(_no);
    public static final Jqs_alert_select_requestAlert_sent either = new Jqs_alert_select_requestAlert_sent(_either);
    public java.lang.String getValue() { return _value_;}
    public static Jqs_alert_select_requestAlert_sent fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Jqs_alert_select_requestAlert_sent enumeration = (Jqs_alert_select_requestAlert_sent)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Jqs_alert_select_requestAlert_sent fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Jqs_alert_select_requestAlert_sent.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_alert_select_request>alert_sent"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
