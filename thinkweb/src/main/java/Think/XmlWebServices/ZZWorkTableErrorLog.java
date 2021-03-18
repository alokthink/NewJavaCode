/**
 * ZZWorkTableErrorLog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZWorkTableErrorLog  implements java.io.Serializable {
    private int job_id;  // attribute

    private int work_table_seq;  // attribute

    private int status;  // attribute

    private java.util.Calendar log_time;  // attribute

    private java.lang.String message_string;  // attribute

    private java.lang.String step_name;  // attribute

    public ZZWorkTableErrorLog() {
    }

    public ZZWorkTableErrorLog(
           int job_id,
           int work_table_seq,
           int status,
           java.util.Calendar log_time,
           java.lang.String message_string,
           java.lang.String step_name) {
           this.job_id = job_id;
           this.work_table_seq = work_table_seq;
           this.status = status;
           this.log_time = log_time;
           this.message_string = message_string;
           this.step_name = step_name;
    }


    /**
     * Gets the job_id value for this ZZWorkTableErrorLog.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this ZZWorkTableErrorLog.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the work_table_seq value for this ZZWorkTableErrorLog.
     * 
     * @return work_table_seq
     */
    public int getWork_table_seq() {
        return work_table_seq;
    }


    /**
     * Sets the work_table_seq value for this ZZWorkTableErrorLog.
     * 
     * @param work_table_seq
     */
    public void setWork_table_seq(int work_table_seq) {
        this.work_table_seq = work_table_seq;
    }


    /**
     * Gets the status value for this ZZWorkTableErrorLog.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ZZWorkTableErrorLog.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the log_time value for this ZZWorkTableErrorLog.
     * 
     * @return log_time
     */
    public java.util.Calendar getLog_time() {
        return log_time;
    }


    /**
     * Sets the log_time value for this ZZWorkTableErrorLog.
     * 
     * @param log_time
     */
    public void setLog_time(java.util.Calendar log_time) {
        this.log_time = log_time;
    }


    /**
     * Gets the message_string value for this ZZWorkTableErrorLog.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this ZZWorkTableErrorLog.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }


    /**
     * Gets the step_name value for this ZZWorkTableErrorLog.
     * 
     * @return step_name
     */
    public java.lang.String getStep_name() {
        return step_name;
    }


    /**
     * Sets the step_name value for this ZZWorkTableErrorLog.
     * 
     * @param step_name
     */
    public void setStep_name(java.lang.String step_name) {
        this.step_name = step_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZWorkTableErrorLog)) return false;
        ZZWorkTableErrorLog other = (ZZWorkTableErrorLog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            this.work_table_seq == other.getWork_table_seq() &&
            this.status == other.getStatus() &&
            ((this.log_time==null && other.getLog_time()==null) || 
             (this.log_time!=null &&
              this.log_time.equals(other.getLog_time()))) &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string()))) &&
            ((this.step_name==null && other.getStep_name()==null) || 
             (this.step_name!=null &&
              this.step_name.equals(other.getStep_name())));
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
        _hashCode += getWork_table_seq();
        _hashCode += getStatus();
        if (getLog_time() != null) {
            _hashCode += getLog_time().hashCode();
        }
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        if (getStep_name() != null) {
            _hashCode += getStep_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZWorkTableErrorLog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZWorkTableErrorLog"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("work_table_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "work_table_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("log_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "log_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("message_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "message_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("step_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "step_name"));
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
