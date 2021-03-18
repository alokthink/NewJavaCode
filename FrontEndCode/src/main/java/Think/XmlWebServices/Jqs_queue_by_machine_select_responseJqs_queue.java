/**
 * Jqs_queue_by_machine_select_responseJqs_queue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_queue_by_machine_select_responseJqs_queue  implements java.io.Serializable {
    private int jqs_machine_id;  // attribute

    private int jqs_queue_id;  // attribute

    private int jqs_client_id;  // attribute

    private java.util.Calendar last_poll_or_pulse;  // attribute

    public Jqs_queue_by_machine_select_responseJqs_queue() {
    }

    public Jqs_queue_by_machine_select_responseJqs_queue(
           int jqs_machine_id,
           int jqs_queue_id,
           int jqs_client_id,
           java.util.Calendar last_poll_or_pulse) {
           this.jqs_machine_id = jqs_machine_id;
           this.jqs_queue_id = jqs_queue_id;
           this.jqs_client_id = jqs_client_id;
           this.last_poll_or_pulse = last_poll_or_pulse;
    }


    /**
     * Gets the jqs_machine_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @return jqs_machine_id
     */
    public int getJqs_machine_id() {
        return jqs_machine_id;
    }


    /**
     * Sets the jqs_machine_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @param jqs_machine_id
     */
    public void setJqs_machine_id(int jqs_machine_id) {
        this.jqs_machine_id = jqs_machine_id;
    }


    /**
     * Gets the jqs_queue_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @return jqs_queue_id
     */
    public int getJqs_queue_id() {
        return jqs_queue_id;
    }


    /**
     * Sets the jqs_queue_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @param jqs_queue_id
     */
    public void setJqs_queue_id(int jqs_queue_id) {
        this.jqs_queue_id = jqs_queue_id;
    }


    /**
     * Gets the jqs_client_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @return jqs_client_id
     */
    public int getJqs_client_id() {
        return jqs_client_id;
    }


    /**
     * Sets the jqs_client_id value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @param jqs_client_id
     */
    public void setJqs_client_id(int jqs_client_id) {
        this.jqs_client_id = jqs_client_id;
    }


    /**
     * Gets the last_poll_or_pulse value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @return last_poll_or_pulse
     */
    public java.util.Calendar getLast_poll_or_pulse() {
        return last_poll_or_pulse;
    }


    /**
     * Sets the last_poll_or_pulse value for this Jqs_queue_by_machine_select_responseJqs_queue.
     * 
     * @param last_poll_or_pulse
     */
    public void setLast_poll_or_pulse(java.util.Calendar last_poll_or_pulse) {
        this.last_poll_or_pulse = last_poll_or_pulse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_queue_by_machine_select_responseJqs_queue)) return false;
        Jqs_queue_by_machine_select_responseJqs_queue other = (Jqs_queue_by_machine_select_responseJqs_queue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_machine_id == other.getJqs_machine_id() &&
            this.jqs_queue_id == other.getJqs_queue_id() &&
            this.jqs_client_id == other.getJqs_client_id() &&
            ((this.last_poll_or_pulse==null && other.getLast_poll_or_pulse()==null) || 
             (this.last_poll_or_pulse!=null &&
              this.last_poll_or_pulse.equals(other.getLast_poll_or_pulse())));
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
        _hashCode += getJqs_machine_id();
        _hashCode += getJqs_queue_id();
        _hashCode += getJqs_client_id();
        if (getLast_poll_or_pulse() != null) {
            _hashCode += getLast_poll_or_pulse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_queue_by_machine_select_responseJqs_queue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_queue_by_machine_select_response>jqs_queue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_machine_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_machine_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_queue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_queue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_client_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_client_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_poll_or_pulse");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_poll_or_pulse"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
