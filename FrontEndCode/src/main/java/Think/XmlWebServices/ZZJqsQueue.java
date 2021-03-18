/**
 * ZZJqsQueue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZJqsQueue  implements java.io.Serializable {
    private int jqs_queue_id;  // attribute

    private int connection_verified;  // attribute

    private int current_phase;  // attribute

    private int health_interval;  // attribute

    private int job_id;  // attribute

    private int jqs_client_id;  // attribute

    private int jqs_machine_id;  // attribute

    private java.util.Calendar last_poll_or_pulse;  // attribute

    private java.lang.String login;  // attribute

    private int n_candidate_records;  // attribute

    private int n_selected_records;  // attribute

    private int n_updated_records;  // attribute

    private java.lang.String password;  // attribute

    private java.lang.String queue;  // attribute

    private java.lang.String step_name;  // attribute

    public ZZJqsQueue() {
    }

    public ZZJqsQueue(
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
           java.lang.String step_name) {
           this.jqs_queue_id = jqs_queue_id;
           this.connection_verified = connection_verified;
           this.current_phase = current_phase;
           this.health_interval = health_interval;
           this.job_id = job_id;
           this.jqs_client_id = jqs_client_id;
           this.jqs_machine_id = jqs_machine_id;
           this.last_poll_or_pulse = last_poll_or_pulse;
           this.login = login;
           this.n_candidate_records = n_candidate_records;
           this.n_selected_records = n_selected_records;
           this.n_updated_records = n_updated_records;
           this.password = password;
           this.queue = queue;
           this.step_name = step_name;
    }


    /**
     * Gets the jqs_queue_id value for this ZZJqsQueue.
     * 
     * @return jqs_queue_id
     */
    public int getJqs_queue_id() {
        return jqs_queue_id;
    }


    /**
     * Sets the jqs_queue_id value for this ZZJqsQueue.
     * 
     * @param jqs_queue_id
     */
    public void setJqs_queue_id(int jqs_queue_id) {
        this.jqs_queue_id = jqs_queue_id;
    }


    /**
     * Gets the connection_verified value for this ZZJqsQueue.
     * 
     * @return connection_verified
     */
    public int getConnection_verified() {
        return connection_verified;
    }


    /**
     * Sets the connection_verified value for this ZZJqsQueue.
     * 
     * @param connection_verified
     */
    public void setConnection_verified(int connection_verified) {
        this.connection_verified = connection_verified;
    }


    /**
     * Gets the current_phase value for this ZZJqsQueue.
     * 
     * @return current_phase
     */
    public int getCurrent_phase() {
        return current_phase;
    }


    /**
     * Sets the current_phase value for this ZZJqsQueue.
     * 
     * @param current_phase
     */
    public void setCurrent_phase(int current_phase) {
        this.current_phase = current_phase;
    }


    /**
     * Gets the health_interval value for this ZZJqsQueue.
     * 
     * @return health_interval
     */
    public int getHealth_interval() {
        return health_interval;
    }


    /**
     * Sets the health_interval value for this ZZJqsQueue.
     * 
     * @param health_interval
     */
    public void setHealth_interval(int health_interval) {
        this.health_interval = health_interval;
    }


    /**
     * Gets the job_id value for this ZZJqsQueue.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this ZZJqsQueue.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the jqs_client_id value for this ZZJqsQueue.
     * 
     * @return jqs_client_id
     */
    public int getJqs_client_id() {
        return jqs_client_id;
    }


    /**
     * Sets the jqs_client_id value for this ZZJqsQueue.
     * 
     * @param jqs_client_id
     */
    public void setJqs_client_id(int jqs_client_id) {
        this.jqs_client_id = jqs_client_id;
    }


    /**
     * Gets the jqs_machine_id value for this ZZJqsQueue.
     * 
     * @return jqs_machine_id
     */
    public int getJqs_machine_id() {
        return jqs_machine_id;
    }


    /**
     * Sets the jqs_machine_id value for this ZZJqsQueue.
     * 
     * @param jqs_machine_id
     */
    public void setJqs_machine_id(int jqs_machine_id) {
        this.jqs_machine_id = jqs_machine_id;
    }


    /**
     * Gets the last_poll_or_pulse value for this ZZJqsQueue.
     * 
     * @return last_poll_or_pulse
     */
    public java.util.Calendar getLast_poll_or_pulse() {
        return last_poll_or_pulse;
    }


    /**
     * Sets the last_poll_or_pulse value for this ZZJqsQueue.
     * 
     * @param last_poll_or_pulse
     */
    public void setLast_poll_or_pulse(java.util.Calendar last_poll_or_pulse) {
        this.last_poll_or_pulse = last_poll_or_pulse;
    }


    /**
     * Gets the login value for this ZZJqsQueue.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this ZZJqsQueue.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the n_candidate_records value for this ZZJqsQueue.
     * 
     * @return n_candidate_records
     */
    public int getN_candidate_records() {
        return n_candidate_records;
    }


    /**
     * Sets the n_candidate_records value for this ZZJqsQueue.
     * 
     * @param n_candidate_records
     */
    public void setN_candidate_records(int n_candidate_records) {
        this.n_candidate_records = n_candidate_records;
    }


    /**
     * Gets the n_selected_records value for this ZZJqsQueue.
     * 
     * @return n_selected_records
     */
    public int getN_selected_records() {
        return n_selected_records;
    }


    /**
     * Sets the n_selected_records value for this ZZJqsQueue.
     * 
     * @param n_selected_records
     */
    public void setN_selected_records(int n_selected_records) {
        this.n_selected_records = n_selected_records;
    }


    /**
     * Gets the n_updated_records value for this ZZJqsQueue.
     * 
     * @return n_updated_records
     */
    public int getN_updated_records() {
        return n_updated_records;
    }


    /**
     * Sets the n_updated_records value for this ZZJqsQueue.
     * 
     * @param n_updated_records
     */
    public void setN_updated_records(int n_updated_records) {
        this.n_updated_records = n_updated_records;
    }


    /**
     * Gets the password value for this ZZJqsQueue.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ZZJqsQueue.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the queue value for this ZZJqsQueue.
     * 
     * @return queue
     */
    public java.lang.String getQueue() {
        return queue;
    }


    /**
     * Sets the queue value for this ZZJqsQueue.
     * 
     * @param queue
     */
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }


    /**
     * Gets the step_name value for this ZZJqsQueue.
     * 
     * @return step_name
     */
    public java.lang.String getStep_name() {
        return step_name;
    }


    /**
     * Sets the step_name value for this ZZJqsQueue.
     * 
     * @param step_name
     */
    public void setStep_name(java.lang.String step_name) {
        this.step_name = step_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZJqsQueue)) return false;
        ZZJqsQueue other = (ZZJqsQueue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_queue_id == other.getJqs_queue_id() &&
            this.connection_verified == other.getConnection_verified() &&
            this.current_phase == other.getCurrent_phase() &&
            this.health_interval == other.getHealth_interval() &&
            this.job_id == other.getJob_id() &&
            this.jqs_client_id == other.getJqs_client_id() &&
            this.jqs_machine_id == other.getJqs_machine_id() &&
            ((this.last_poll_or_pulse==null && other.getLast_poll_or_pulse()==null) || 
             (this.last_poll_or_pulse!=null &&
              this.last_poll_or_pulse.equals(other.getLast_poll_or_pulse()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.n_candidate_records == other.getN_candidate_records() &&
            this.n_selected_records == other.getN_selected_records() &&
            this.n_updated_records == other.getN_updated_records() &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.queue==null && other.getQueue()==null) || 
             (this.queue!=null &&
              this.queue.equals(other.getQueue()))) &&
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
        _hashCode += getJqs_queue_id();
        _hashCode += getConnection_verified();
        _hashCode += getCurrent_phase();
        _hashCode += getHealth_interval();
        _hashCode += getJob_id();
        _hashCode += getJqs_client_id();
        _hashCode += getJqs_machine_id();
        if (getLast_poll_or_pulse() != null) {
            _hashCode += getLast_poll_or_pulse().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += getN_candidate_records();
        _hashCode += getN_selected_records();
        _hashCode += getN_updated_records();
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getQueue() != null) {
            _hashCode += getQueue().hashCode();
        }
        if (getStep_name() != null) {
            _hashCode += getStep_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZJqsQueue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZJqsQueue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_queue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_queue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("connection_verified");
        attrField.setXmlName(new javax.xml.namespace.QName("", "connection_verified"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("current_phase");
        attrField.setXmlName(new javax.xml.namespace.QName("", "current_phase"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("health_interval");
        attrField.setXmlName(new javax.xml.namespace.QName("", "health_interval"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_client_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_client_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("jqs_machine_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "jqs_machine_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_poll_or_pulse");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_poll_or_pulse"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_candidate_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_candidate_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_selected_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_selected_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_updated_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_updated_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("password");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("queue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "queue"));
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
