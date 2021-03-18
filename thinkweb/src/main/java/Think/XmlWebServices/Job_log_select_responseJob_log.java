/**
 * Job_log_select_responseJob_log.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Job_log_select_responseJob_log  implements java.io.Serializable {
    private int job_id;  // attribute

    private int job_log_seq;  // attribute

    private int is_error;  // attribute

    private java.lang.String message_string;  // attribute

    private java.util.Calendar log_time;  // attribute

    public Job_log_select_responseJob_log() {
    }

    public Job_log_select_responseJob_log(
           int job_id,
           int job_log_seq,
           int is_error,
           java.lang.String message_string,
           java.util.Calendar log_time) {
           this.job_id = job_id;
           this.job_log_seq = job_log_seq;
           this.is_error = is_error;
           this.message_string = message_string;
           this.log_time = log_time;
    }


    /**
     * Gets the job_id value for this Job_log_select_responseJob_log.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Job_log_select_responseJob_log.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the job_log_seq value for this Job_log_select_responseJob_log.
     * 
     * @return job_log_seq
     */
    public int getJob_log_seq() {
        return job_log_seq;
    }


    /**
     * Sets the job_log_seq value for this Job_log_select_responseJob_log.
     * 
     * @param job_log_seq
     */
    public void setJob_log_seq(int job_log_seq) {
        this.job_log_seq = job_log_seq;
    }


    /**
     * Gets the is_error value for this Job_log_select_responseJob_log.
     * 
     * @return is_error
     */
    public int getIs_error() {
        return is_error;
    }


    /**
     * Sets the is_error value for this Job_log_select_responseJob_log.
     * 
     * @param is_error
     */
    public void setIs_error(int is_error) {
        this.is_error = is_error;
    }


    /**
     * Gets the message_string value for this Job_log_select_responseJob_log.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this Job_log_select_responseJob_log.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }


    /**
     * Gets the log_time value for this Job_log_select_responseJob_log.
     * 
     * @return log_time
     */
    public java.util.Calendar getLog_time() {
        return log_time;
    }


    /**
     * Sets the log_time value for this Job_log_select_responseJob_log.
     * 
     * @param log_time
     */
    public void setLog_time(java.util.Calendar log_time) {
        this.log_time = log_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Job_log_select_responseJob_log)) return false;
        Job_log_select_responseJob_log other = (Job_log_select_responseJob_log) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            this.job_log_seq == other.getJob_log_seq() &&
            this.is_error == other.getIs_error() &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string()))) &&
            ((this.log_time==null && other.getLog_time()==null) || 
             (this.log_time!=null &&
              this.log_time.equals(other.getLog_time())));
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
        _hashCode += getJob_id();
        _hashCode += getJob_log_seq();
        _hashCode += getIs_error();
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        if (getLog_time() != null) {
            _hashCode += getLog_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Job_log_select_responseJob_log.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>job_log_select_response>job_log"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_log_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_log_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_error");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_error"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("message_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "message_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("log_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "log_time"));
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
