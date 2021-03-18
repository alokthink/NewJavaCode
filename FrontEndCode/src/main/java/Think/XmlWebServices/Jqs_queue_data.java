/**
 * Jqs_queue_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_queue_data  implements java.io.Serializable {
    private int jqs_machine_id;

    private int jqs_client_id;

    private java.lang.String login;

    private java.lang.String password;

    private int connection_verified;

    private java.lang.String queue;

    private java.lang.Integer job_id;

    private java.lang.String step_name;

    private java.lang.String current_phase;

    private int health_interval;

    private java.lang.Integer n_candidate_records;

    private java.lang.Integer n_selected_records;

    private java.lang.Integer n_updated_records;

    public Jqs_queue_data() {
    }

    public Jqs_queue_data(
           int jqs_machine_id,
           int jqs_client_id,
           java.lang.String login,
           java.lang.String password,
           int connection_verified,
           java.lang.String queue,
           java.lang.Integer job_id,
           java.lang.String step_name,
           java.lang.String current_phase,
           int health_interval,
           java.lang.Integer n_candidate_records,
           java.lang.Integer n_selected_records,
           java.lang.Integer n_updated_records) {
           this.jqs_machine_id = jqs_machine_id;
           this.jqs_client_id = jqs_client_id;
           this.login = login;
           this.password = password;
           this.connection_verified = connection_verified;
           this.queue = queue;
           this.job_id = job_id;
           this.step_name = step_name;
           this.current_phase = current_phase;
           this.health_interval = health_interval;
           this.n_candidate_records = n_candidate_records;
           this.n_selected_records = n_selected_records;
           this.n_updated_records = n_updated_records;
    }


    /**
     * Gets the jqs_machine_id value for this Jqs_queue_data.
     * 
     * @return jqs_machine_id
     */
    public int getJqs_machine_id() {
        return jqs_machine_id;
    }


    /**
     * Sets the jqs_machine_id value for this Jqs_queue_data.
     * 
     * @param jqs_machine_id
     */
    public void setJqs_machine_id(int jqs_machine_id) {
        this.jqs_machine_id = jqs_machine_id;
    }


    /**
     * Gets the jqs_client_id value for this Jqs_queue_data.
     * 
     * @return jqs_client_id
     */
    public int getJqs_client_id() {
        return jqs_client_id;
    }


    /**
     * Sets the jqs_client_id value for this Jqs_queue_data.
     * 
     * @param jqs_client_id
     */
    public void setJqs_client_id(int jqs_client_id) {
        this.jqs_client_id = jqs_client_id;
    }


    /**
     * Gets the login value for this Jqs_queue_data.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this Jqs_queue_data.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the password value for this Jqs_queue_data.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this Jqs_queue_data.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the connection_verified value for this Jqs_queue_data.
     * 
     * @return connection_verified
     */
    public int getConnection_verified() {
        return connection_verified;
    }


    /**
     * Sets the connection_verified value for this Jqs_queue_data.
     * 
     * @param connection_verified
     */
    public void setConnection_verified(int connection_verified) {
        this.connection_verified = connection_verified;
    }


    /**
     * Gets the queue value for this Jqs_queue_data.
     * 
     * @return queue
     */
    public java.lang.String getQueue() {
        return queue;
    }


    /**
     * Sets the queue value for this Jqs_queue_data.
     * 
     * @param queue
     */
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }


    /**
     * Gets the job_id value for this Jqs_queue_data.
     * 
     * @return job_id
     */
    public java.lang.Integer getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Jqs_queue_data.
     * 
     * @param job_id
     */
    public void setJob_id(java.lang.Integer job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the step_name value for this Jqs_queue_data.
     * 
     * @return step_name
     */
    public java.lang.String getStep_name() {
        return step_name;
    }


    /**
     * Sets the step_name value for this Jqs_queue_data.
     * 
     * @param step_name
     */
    public void setStep_name(java.lang.String step_name) {
        this.step_name = step_name;
    }


    /**
     * Gets the current_phase value for this Jqs_queue_data.
     * 
     * @return current_phase
     */
    public java.lang.String getCurrent_phase() {
        return current_phase;
    }


    /**
     * Sets the current_phase value for this Jqs_queue_data.
     * 
     * @param current_phase
     */
    public void setCurrent_phase(java.lang.String current_phase) {
        this.current_phase = current_phase;
    }


    /**
     * Gets the health_interval value for this Jqs_queue_data.
     * 
     * @return health_interval
     */
    public int getHealth_interval() {
        return health_interval;
    }


    /**
     * Sets the health_interval value for this Jqs_queue_data.
     * 
     * @param health_interval
     */
    public void setHealth_interval(int health_interval) {
        this.health_interval = health_interval;
    }


    /**
     * Gets the n_candidate_records value for this Jqs_queue_data.
     * 
     * @return n_candidate_records
     */
    public java.lang.Integer getN_candidate_records() {
        return n_candidate_records;
    }


    /**
     * Sets the n_candidate_records value for this Jqs_queue_data.
     * 
     * @param n_candidate_records
     */
    public void setN_candidate_records(java.lang.Integer n_candidate_records) {
        this.n_candidate_records = n_candidate_records;
    }


    /**
     * Gets the n_selected_records value for this Jqs_queue_data.
     * 
     * @return n_selected_records
     */
    public java.lang.Integer getN_selected_records() {
        return n_selected_records;
    }


    /**
     * Sets the n_selected_records value for this Jqs_queue_data.
     * 
     * @param n_selected_records
     */
    public void setN_selected_records(java.lang.Integer n_selected_records) {
        this.n_selected_records = n_selected_records;
    }


    /**
     * Gets the n_updated_records value for this Jqs_queue_data.
     * 
     * @return n_updated_records
     */
    public java.lang.Integer getN_updated_records() {
        return n_updated_records;
    }


    /**
     * Sets the n_updated_records value for this Jqs_queue_data.
     * 
     * @param n_updated_records
     */
    public void setN_updated_records(java.lang.Integer n_updated_records) {
        this.n_updated_records = n_updated_records;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_queue_data)) return false;
        Jqs_queue_data other = (Jqs_queue_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_machine_id == other.getJqs_machine_id() &&
            this.jqs_client_id == other.getJqs_client_id() &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            this.connection_verified == other.getConnection_verified() &&
            ((this.queue==null && other.getQueue()==null) || 
             (this.queue!=null &&
              this.queue.equals(other.getQueue()))) &&
            ((this.job_id==null && other.getJob_id()==null) || 
             (this.job_id!=null &&
              this.job_id.equals(other.getJob_id()))) &&
            ((this.step_name==null && other.getStep_name()==null) || 
             (this.step_name!=null &&
              this.step_name.equals(other.getStep_name()))) &&
            ((this.current_phase==null && other.getCurrent_phase()==null) || 
             (this.current_phase!=null &&
              this.current_phase.equals(other.getCurrent_phase()))) &&
            this.health_interval == other.getHealth_interval() &&
            ((this.n_candidate_records==null && other.getN_candidate_records()==null) || 
             (this.n_candidate_records!=null &&
              this.n_candidate_records.equals(other.getN_candidate_records()))) &&
            ((this.n_selected_records==null && other.getN_selected_records()==null) || 
             (this.n_selected_records!=null &&
              this.n_selected_records.equals(other.getN_selected_records()))) &&
            ((this.n_updated_records==null && other.getN_updated_records()==null) || 
             (this.n_updated_records!=null &&
              this.n_updated_records.equals(other.getN_updated_records())));
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
        _hashCode += getJqs_client_id();
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        _hashCode += getConnection_verified();
        if (getQueue() != null) {
            _hashCode += getQueue().hashCode();
        }
        if (getJob_id() != null) {
            _hashCode += getJob_id().hashCode();
        }
        if (getStep_name() != null) {
            _hashCode += getStep_name().hashCode();
        }
        if (getCurrent_phase() != null) {
            _hashCode += getCurrent_phase().hashCode();
        }
        _hashCode += getHealth_interval();
        if (getN_candidate_records() != null) {
            _hashCode += getN_candidate_records().hashCode();
        }
        if (getN_selected_records() != null) {
            _hashCode += getN_selected_records().hashCode();
        }
        if (getN_updated_records() != null) {
            _hashCode += getN_updated_records().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_queue_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_queue_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_machine_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_machine_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_client_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_client_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connection_verified");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "connection_verified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "queue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("step_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "step_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("current_phase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "current_phase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("health_interval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "health_interval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n_candidate_records");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "n_candidate_records"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n_selected_records");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "n_selected_records"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n_updated_records");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "n_updated_records"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
