/**
 * Jqs_queue_list_responseJqs_queue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_queue_list_responseJqs_queue  extends Think.XmlWebServices.ZZJqsQueue  implements java.io.Serializable {
    private java.lang.String machine_name;  // attribute

    private java.lang.String client_description;  // attribute

    private java.lang.String password_encrypted;  // attribute

    public Jqs_queue_list_responseJqs_queue() {
    }

    public Jqs_queue_list_responseJqs_queue(
           int jqs_queue_id,
           int connection_verified,
           int current_phase,
           int health_interval,
           int job_id,
           int jqs_client_id,
           int jqs_machine_id,
           java.util.Calendar last_poll_or_pulse,
           java.lang.String login,
           int n_candidate_records,
           int n_selected_records,
           int n_updated_records,
           java.lang.String password,
           java.lang.String queue,
           java.lang.String step_name,
           java.lang.String machine_name,
           java.lang.String client_description,
           java.lang.String password_encrypted) {
        super(
            jqs_queue_id,
            connection_verified,
            current_phase,
            health_interval,
            job_id,
            jqs_client_id,
            jqs_machine_id,
            last_poll_or_pulse,
            login,
            n_candidate_records,
            n_selected_records,
            n_updated_records,
            password,
            queue,
            step_name);
        this.machine_name = machine_name;
        this.client_description = client_description;
        this.password_encrypted = password_encrypted;
    }


    /**
     * Gets the machine_name value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @return machine_name
     */
    public java.lang.String getMachine_name() {
        return machine_name;
    }


    /**
     * Sets the machine_name value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @param machine_name
     */
    public void setMachine_name(java.lang.String machine_name) {
        this.machine_name = machine_name;
    }


    /**
     * Gets the client_description value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @return client_description
     */
    public java.lang.String getClient_description() {
        return client_description;
    }


    /**
     * Sets the client_description value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @param client_description
     */
    public void setClient_description(java.lang.String client_description) {
        this.client_description = client_description;
    }


    /**
     * Gets the password_encrypted value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @return password_encrypted
     */
    public java.lang.String getPassword_encrypted() {
        return password_encrypted;
    }


    /**
     * Sets the password_encrypted value for this Jqs_queue_list_responseJqs_queue.
     * 
     * @param password_encrypted
     */
    public void setPassword_encrypted(java.lang.String password_encrypted) {
        this.password_encrypted = password_encrypted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_queue_list_responseJqs_queue)) return false;
        Jqs_queue_list_responseJqs_queue other = (Jqs_queue_list_responseJqs_queue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.machine_name==null && other.getMachine_name()==null) || 
             (this.machine_name!=null &&
              this.machine_name.equals(other.getMachine_name()))) &&
            ((this.client_description==null && other.getClient_description()==null) || 
             (this.client_description!=null &&
              this.client_description.equals(other.getClient_description()))) &&
            ((this.password_encrypted==null && other.getPassword_encrypted()==null) || 
             (this.password_encrypted!=null &&
              this.password_encrypted.equals(other.getPassword_encrypted())));
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
        if (getMachine_name() != null) {
            _hashCode += getMachine_name().hashCode();
        }
        if (getClient_description() != null) {
            _hashCode += getClient_description().hashCode();
        }
        if (getPassword_encrypted() != null) {
            _hashCode += getPassword_encrypted().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_queue_list_responseJqs_queue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_queue_list_response>jqs_queue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("machine_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "machine_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("client_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "client_description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("password_encrypted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password_encrypted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
