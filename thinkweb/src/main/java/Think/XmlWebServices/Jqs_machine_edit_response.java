/**
 * Jqs_machine_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_machine_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZJqsMachine jqs_machine;

    public Jqs_machine_edit_response() {
    }

    public Jqs_machine_edit_response(
           Think.XmlWebServices.ZZJqsMachine jqs_machine) {
           this.jqs_machine = jqs_machine;
    }


    /**
     * Gets the jqs_machine value for this Jqs_machine_edit_response.
     * 
     * @return jqs_machine
     */
    public Think.XmlWebServices.ZZJqsMachine getJqs_machine() {
        return jqs_machine;
    }


    /**
     * Sets the jqs_machine value for this Jqs_machine_edit_response.
     * 
     * @param jqs_machine
     */
    public void setJqs_machine(Think.XmlWebServices.ZZJqsMachine jqs_machine) {
        this.jqs_machine = jqs_machine;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_machine_edit_response)) return false;
        Jqs_machine_edit_response other = (Jqs_machine_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jqs_machine==null && other.getJqs_machine()==null) || 
             (this.jqs_machine!=null &&
              this.jqs_machine.equals(other.getJqs_machine())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getJqs_machine() != null) {
            _hashCode += getJqs_machine().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_machine_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_machine_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_machine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_machine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZJqsMachine"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
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
