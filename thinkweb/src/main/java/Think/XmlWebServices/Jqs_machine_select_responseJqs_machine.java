/**
 * Jqs_machine_select_responseJqs_machine.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_machine_select_responseJqs_machine  implements java.io.Serializable {
    private int jqs_machine_id;  // attribute

    private java.lang.String machine_name;  // attribute

    private java.lang.String description;  // attribute

    private java.util.Calendar last_poll;  // attribute

    public Jqs_machine_select_responseJqs_machine() {
    }

    public Jqs_machine_select_responseJqs_machine(
           int jqs_machine_id,
           java.lang.String machine_name,
           java.lang.String description,
           java.util.Calendar last_poll) {
           this.jqs_machine_id = jqs_machine_id;
           this.machine_name = machine_name;
           this.description = description;
           this.last_poll = last_poll;
    }


    /**
     * Gets the jqs_machine_id value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @return jqs_machine_id
     */
    public int getJqs_machine_id() {
        return jqs_machine_id;
    }


    /**
     * Sets the jqs_machine_id value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @param jqs_machine_id
     */
    public void setJqs_machine_id(int jqs_machine_id) {
        this.jqs_machine_id = jqs_machine_id;
    }


    /**
     * Gets the machine_name value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @return machine_name
     */
    public java.lang.String getMachine_name() {
        return machine_name;
    }


    /**
     * Sets the machine_name value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @param machine_name
     */
    public void setMachine_name(java.lang.String machine_name) {
        this.machine_name = machine_name;
    }


    /**
     * Gets the description value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the last_poll value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @return last_poll
     */
    public java.util.Calendar getLast_poll() {
        return last_poll;
    }


    /**
     * Sets the last_poll value for this Jqs_machine_select_responseJqs_machine.
     * 
     * @param last_poll
     */
    public void setLast_poll(java.util.Calendar last_poll) {
        this.last_poll = last_poll;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_machine_select_responseJqs_machine)) return false;
        Jqs_machine_select_responseJqs_machine other = (Jqs_machine_select_responseJqs_machine) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_machine_id == other.getJqs_machine_id() &&
            ((this.machine_name==null && other.getMachine_name()==null) || 
             (this.machine_name!=null &&
              this.machine_name.equals(other.getMachine_name()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.last_poll==null && other.getLast_poll()==null) || 
             (this.last_poll!=null &&
              this.last_poll.equals(other.getLast_poll())));
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
        if (getMachine_name() != null) {
            _hashCode += getMachine_name().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getLast_poll() != null) {
            _hashCode += getLast_poll().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_machine_select_responseJqs_machine.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_machine_select_response>jqs_machine"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_machine_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_machine_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("machine_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "machine_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_poll");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_poll"));
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
