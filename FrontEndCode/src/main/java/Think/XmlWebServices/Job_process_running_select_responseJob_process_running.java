/**
 * Job_process_running_select_responseJob_process_running.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Job_process_running_select_responseJob_process_running  implements java.io.Serializable {
    private java.lang.String machine_name;  // attribute

    private java.util.Calendar started;  // attribute

    private java.util.Calendar last_yo_po_se_yo;  // attribute

    public Job_process_running_select_responseJob_process_running() {
    }

    public Job_process_running_select_responseJob_process_running(
           java.lang.String machine_name,
           java.util.Calendar started,
           java.util.Calendar last_yo_po_se_yo) {
           this.machine_name = machine_name;
           this.started = started;
           this.last_yo_po_se_yo = last_yo_po_se_yo;
    }


    /**
     * Gets the machine_name value for this Job_process_running_select_responseJob_process_running.
     * 
     * @return machine_name
     */
    public java.lang.String getMachine_name() {
        return machine_name;
    }


    /**
     * Sets the machine_name value for this Job_process_running_select_responseJob_process_running.
     * 
     * @param machine_name
     */
    public void setMachine_name(java.lang.String machine_name) {
        this.machine_name = machine_name;
    }


    /**
     * Gets the started value for this Job_process_running_select_responseJob_process_running.
     * 
     * @return started
     */
    public java.util.Calendar getStarted() {
        return started;
    }


    /**
     * Sets the started value for this Job_process_running_select_responseJob_process_running.
     * 
     * @param started
     */
    public void setStarted(java.util.Calendar started) {
        this.started = started;
    }


    /**
     * Gets the last_yo_po_se_yo value for this Job_process_running_select_responseJob_process_running.
     * 
     * @return last_yo_po_se_yo
     */
    public java.util.Calendar getLast_yo_po_se_yo() {
        return last_yo_po_se_yo;
    }


    /**
     * Sets the last_yo_po_se_yo value for this Job_process_running_select_responseJob_process_running.
     * 
     * @param last_yo_po_se_yo
     */
    public void setLast_yo_po_se_yo(java.util.Calendar last_yo_po_se_yo) {
        this.last_yo_po_se_yo = last_yo_po_se_yo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Job_process_running_select_responseJob_process_running)) return false;
        Job_process_running_select_responseJob_process_running other = (Job_process_running_select_responseJob_process_running) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.machine_name==null && other.getMachine_name()==null) || 
             (this.machine_name!=null &&
              this.machine_name.equals(other.getMachine_name()))) &&
            ((this.started==null && other.getStarted()==null) || 
             (this.started!=null &&
              this.started.equals(other.getStarted()))) &&
            ((this.last_yo_po_se_yo==null && other.getLast_yo_po_se_yo()==null) || 
             (this.last_yo_po_se_yo!=null &&
              this.last_yo_po_se_yo.equals(other.getLast_yo_po_se_yo())));
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
        if (getMachine_name() != null) {
            _hashCode += getMachine_name().hashCode();
        }
        if (getStarted() != null) {
            _hashCode += getStarted().hashCode();
        }
        if (getLast_yo_po_se_yo() != null) {
            _hashCode += getLast_yo_po_se_yo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Job_process_running_select_responseJob_process_running.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>job_process_running_select_response>job_process_running"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("machine_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "machine_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("started");
        attrField.setXmlName(new javax.xml.namespace.QName("", "started"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_yo_po_se_yo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_yo_po_se_yo"));
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
