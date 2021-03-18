/**
 * Jqs_alert_select_responseJqs_alert.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_alert_select_responseJqs_alert  implements java.io.Serializable {
    private int jqs_alert_id;  // attribute

    private int notification_type;  // attribute

    private java.util.Calendar datetime;  // attribute

    private java.lang.String error_message;  // attribute

    private java.lang.String email;  // attribute

    private int alert_sent;  // attribute

    private int jqs_client_id;  // attribute

    private int job_id;  // attribute

    private java.lang.String step_name;  // attribute

    private int current_phase;  // attribute

    public Jqs_alert_select_responseJqs_alert() {
    }

    public Jqs_alert_select_responseJqs_alert(
           int jqs_alert_id,
           int notification_type,
           java.util.Calendar datetime,
           java.lang.String error_message,
           java.lang.String email,
           int alert_sent,
           int jqs_client_id,
           int job_id,
           java.lang.String step_name,
           int current_phase) {
           this.jqs_alert_id = jqs_alert_id;
           this.notification_type = notification_type;
           this.datetime = datetime;
           this.error_message = error_message;
           this.email = email;
           this.alert_sent = alert_sent;
           this.jqs_client_id = jqs_client_id;
           this.job_id = job_id;
           this.step_name = step_name;
           this.current_phase = current_phase;
    }


    /**
     * Gets the jqs_alert_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return jqs_alert_id
     */
    public int getJqs_alert_id() {
        return jqs_alert_id;
    }


    /**
     * Sets the jqs_alert_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param jqs_alert_id
     */
    public void setJqs_alert_id(int jqs_alert_id) {
        this.jqs_alert_id = jqs_alert_id;
    }


    /**
     * Gets the notification_type value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return notification_type
     */
    public int getNotification_type() {
        return notification_type;
    }


    /**
     * Sets the notification_type value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param notification_type
     */
    public void setNotification_type(int notification_type) {
        this.notification_type = notification_type;
    }


    /**
     * Gets the datetime value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return datetime
     */
    public java.util.Calendar getDatetime() {
        return datetime;
    }


    /**
     * Sets the datetime value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param datetime
     */
    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


    /**
     * Gets the error_message value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return error_message
     */
    public java.lang.String getError_message() {
        return error_message;
    }


    /**
     * Sets the error_message value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param error_message
     */
    public void setError_message(java.lang.String error_message) {
        this.error_message = error_message;
    }


    /**
     * Gets the email value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the alert_sent value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return alert_sent
     */
    public int getAlert_sent() {
        return alert_sent;
    }


    /**
     * Sets the alert_sent value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param alert_sent
     */
    public void setAlert_sent(int alert_sent) {
        this.alert_sent = alert_sent;
    }


    /**
     * Gets the jqs_client_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return jqs_client_id
     */
    public int getJqs_client_id() {
        return jqs_client_id;
    }


    /**
     * Sets the jqs_client_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param jqs_client_id
     */
    public void setJqs_client_id(int jqs_client_id) {
        this.jqs_client_id = jqs_client_id;
    }


    /**
     * Gets the job_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the step_name value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return step_name
     */
    public java.lang.String getStep_name() {
        return step_name;
    }


    /**
     * Sets the step_name value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param step_name
     */
    public void setStep_name(java.lang.String step_name) {
        this.step_name = step_name;
    }


    /**
     * Gets the current_phase value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @return current_phase
     */
    public int getCurrent_phase() {
        return current_phase;
    }


    /**
     * Sets the current_phase value for this Jqs_alert_select_responseJqs_alert.
     * 
     * @param current_phase
     */
    public void setCurrent_phase(int current_phase) {
        this.current_phase = current_phase;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_alert_select_responseJqs_alert)) return false;
        Jqs_alert_select_responseJqs_alert other = (Jqs_alert_select_responseJqs_alert) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_alert_id == other.getJqs_alert_id() &&
            this.notification_type == other.getNotification_type() &&
            ((this.datetime==null && other.getDatetime()==null) || 
             (this.datetime!=null &&
              this.datetime.equals(other.getDatetime()))) &&
            ((this.error_message==null && other.getError_message()==null) || 
             (this.error_message!=null &&
              this.error_message.equals(other.getError_message()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.alert_sent == other.getAlert_sent() &&
            this.jqs_client_id == other.getJqs_client_id() &&
            this.job_id == other.getJob_id() &&
            ((this.step_name==null && other.getStep_name()==null) || 
             (this.step_name!=null &&
              this.step_name.equals(other.getStep_name()))) &&
            this.current_phase == other.getCurrent_phase();
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
        _hashCode += getJqs_alert_id();
        _hashCode += getNotification_type();
        if (getDatetime() != null) {
            _hashCode += getDatetime().hashCode();
        }
        if (getError_message() != null) {
            _hashCode += getError_message().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getAlert_sent();
        _hashCode += getJqs_client_id();
        _hashCode += getJob_id();
        if (getStep_name() != null) {
            _hashCode += getStep_name().hashCode();
        }
        _hashCode += getCurrent_phase();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_alert_select_responseJqs_alert.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_alert_select_response>jqs_alert"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_alert_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_alert_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("notification_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "notification_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("datetime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "datetime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("error_message");
        attrField.setXmlName(new javax.xml.namespace.QName("", "error_message"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alert_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alert_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_client_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_client_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("step_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "step_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("current_phase");
        attrField.setXmlName(new javax.xml.namespace.QName("", "current_phase"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
