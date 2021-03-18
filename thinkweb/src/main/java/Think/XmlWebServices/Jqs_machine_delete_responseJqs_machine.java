/**
 * Jqs_machine_delete_responseJqs_machine.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_machine_delete_responseJqs_machine  extends Think.XmlWebServices.ZZJqsMachine  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean _deleted;  // attribute

    public Jqs_machine_delete_responseJqs_machine() {
    }

    public Jqs_machine_delete_responseJqs_machine(
           int jqs_machine_id,
           java.lang.String description,
           java.util.Calendar last_poll,
           java.lang.String machine_name,
           Think.XmlWebServices.ZZBoolean _deleted) {
        super(
            jqs_machine_id,
            description,
            last_poll,
            machine_name);
        this._deleted = _deleted;
    }


    /**
     * Gets the _deleted value for this Jqs_machine_delete_responseJqs_machine.
     * 
     * @return _deleted
     */
    public Think.XmlWebServices.ZZBoolean get_deleted() {
        return _deleted;
    }


    /**
     * Sets the _deleted value for this Jqs_machine_delete_responseJqs_machine.
     * 
     * @param _deleted
     */
    public void set_deleted(Think.XmlWebServices.ZZBoolean _deleted) {
        this._deleted = _deleted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_machine_delete_responseJqs_machine)) return false;
        Jqs_machine_delete_responseJqs_machine other = (Jqs_machine_delete_responseJqs_machine) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this._deleted==null && other.get_deleted()==null) || 
             (this._deleted!=null &&
              this._deleted.equals(other.get_deleted())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (get_deleted() != null) {
            _hashCode += get_deleted().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_machine_delete_responseJqs_machine.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_machine_delete_response>jqs_machine"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_deleted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "_deleted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
