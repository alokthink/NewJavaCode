/**
 * ZZCustomerLogin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZCustomerLogin  implements java.io.Serializable {
    private int customer_login_id;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int customer_id;  // attribute

    private int customer_login_question_id;  // attribute

    private java.lang.String hint;  // attribute

    private int invalid_auth_attempts;  // attribute

    private int is_primary_login;  // attribute

    private int locked_out;  // attribute

    private java.util.Calendar lockout_start;  // attribute

    private java.lang.String login;  // attribute

    private java.lang.String password;  // attribute

    private int pending_xaction_header_id;  // attribute

    private int pending_xaction_seq;  // attribute

    private java.lang.String response;  // attribute

    private int salt;  // attribute

    private java.util.Calendar temp_expire;  // attribute

    public ZZCustomerLogin() {
    }

    public ZZCustomerLogin(
           int customer_login_id,
           java.util.Calendar creation_date,
           int customer_id,
           int customer_login_question_id,
           java.lang.String hint,
           int invalid_auth_attempts,
           int is_primary_login,
           int locked_out,
           java.util.Calendar lockout_start,
           java.lang.String login,
           java.lang.String password,
           int pending_xaction_header_id,
           int pending_xaction_seq,
           java.lang.String response,
           int salt,
           java.util.Calendar temp_expire) {
           this.customer_login_id = customer_login_id;
           this.creation_date = creation_date;
           this.customer_id = customer_id;
           this.customer_login_question_id = customer_login_question_id;
           this.hint = hint;
           this.invalid_auth_attempts = invalid_auth_attempts;
           this.is_primary_login = is_primary_login;
           this.locked_out = locked_out;
           this.lockout_start = lockout_start;
           this.login = login;
           this.password = password;
           this.pending_xaction_header_id = pending_xaction_header_id;
           this.pending_xaction_seq = pending_xaction_seq;
           this.response = response;
           this.salt = salt;
           this.temp_expire = temp_expire;
    }


    /**
     * Gets the customer_login_id value for this ZZCustomerLogin.
     * 
     * @return customer_login_id
     */
    public int getCustomer_login_id() {
        return customer_login_id;
    }


    /**
     * Sets the customer_login_id value for this ZZCustomerLogin.
     * 
     * @param customer_login_id
     */
    public void setCustomer_login_id(int customer_login_id) {
        this.customer_login_id = customer_login_id;
    }


    /**
     * Gets the creation_date value for this ZZCustomerLogin.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZCustomerLogin.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the customer_id value for this ZZCustomerLogin.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZCustomerLogin.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_login_question_id value for this ZZCustomerLogin.
     * 
     * @return customer_login_question_id
     */
    public int getCustomer_login_question_id() {
        return customer_login_question_id;
    }


    /**
     * Sets the customer_login_question_id value for this ZZCustomerLogin.
     * 
     * @param customer_login_question_id
     */
    public void setCustomer_login_question_id(int customer_login_question_id) {
        this.customer_login_question_id = customer_login_question_id;
    }


    /**
     * Gets the hint value for this ZZCustomerLogin.
     * 
     * @return hint
     */
    public java.lang.String getHint() {
        return hint;
    }


    /**
     * Sets the hint value for this ZZCustomerLogin.
     * 
     * @param hint
     */
    public void setHint(java.lang.String hint) {
        this.hint = hint;
    }


    /**
     * Gets the invalid_auth_attempts value for this ZZCustomerLogin.
     * 
     * @return invalid_auth_attempts
     */
    public int getInvalid_auth_attempts() {
        return invalid_auth_attempts;
    }


    /**
     * Sets the invalid_auth_attempts value for this ZZCustomerLogin.
     * 
     * @param invalid_auth_attempts
     */
    public void setInvalid_auth_attempts(int invalid_auth_attempts) {
        this.invalid_auth_attempts = invalid_auth_attempts;
    }


    /**
     * Gets the is_primary_login value for this ZZCustomerLogin.
     * 
     * @return is_primary_login
     */
    public int getIs_primary_login() {
        return is_primary_login;
    }


    /**
     * Sets the is_primary_login value for this ZZCustomerLogin.
     * 
     * @param is_primary_login
     */
    public void setIs_primary_login(int is_primary_login) {
        this.is_primary_login = is_primary_login;
    }


    /**
     * Gets the locked_out value for this ZZCustomerLogin.
     * 
     * @return locked_out
     */
    public int getLocked_out() {
        return locked_out;
    }


    /**
     * Sets the locked_out value for this ZZCustomerLogin.
     * 
     * @param locked_out
     */
    public void setLocked_out(int locked_out) {
        this.locked_out = locked_out;
    }


    /**
     * Gets the lockout_start value for this ZZCustomerLogin.
     * 
     * @return lockout_start
     */
    public java.util.Calendar getLockout_start() {
        return lockout_start;
    }


    /**
     * Sets the lockout_start value for this ZZCustomerLogin.
     * 
     * @param lockout_start
     */
    public void setLockout_start(java.util.Calendar lockout_start) {
        this.lockout_start = lockout_start;
    }


    /**
     * Gets the login value for this ZZCustomerLogin.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this ZZCustomerLogin.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the password value for this ZZCustomerLogin.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ZZCustomerLogin.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the pending_xaction_header_id value for this ZZCustomerLogin.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this ZZCustomerLogin.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the pending_xaction_seq value for this ZZCustomerLogin.
     * 
     * @return pending_xaction_seq
     */
    public int getPending_xaction_seq() {
        return pending_xaction_seq;
    }


    /**
     * Sets the pending_xaction_seq value for this ZZCustomerLogin.
     * 
     * @param pending_xaction_seq
     */
    public void setPending_xaction_seq(int pending_xaction_seq) {
        this.pending_xaction_seq = pending_xaction_seq;
    }


    /**
     * Gets the response value for this ZZCustomerLogin.
     * 
     * @return response
     */
    public java.lang.String getResponse() {
        return response;
    }


    /**
     * Sets the response value for this ZZCustomerLogin.
     * 
     * @param response
     */
    public void setResponse(java.lang.String response) {
        this.response = response;
    }


    /**
     * Gets the salt value for this ZZCustomerLogin.
     * 
     * @return salt
     */
    public int getSalt() {
        return salt;
    }


    /**
     * Sets the salt value for this ZZCustomerLogin.
     * 
     * @param salt
     */
    public void setSalt(int salt) {
        this.salt = salt;
    }


    /**
     * Gets the temp_expire value for this ZZCustomerLogin.
     * 
     * @return temp_expire
     */
    public java.util.Calendar getTemp_expire() {
        return temp_expire;
    }


    /**
     * Sets the temp_expire value for this ZZCustomerLogin.
     * 
     * @param temp_expire
     */
    public void setTemp_expire(java.util.Calendar temp_expire) {
        this.temp_expire = temp_expire;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZCustomerLogin)) return false;
        ZZCustomerLogin other = (ZZCustomerLogin) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_login_id == other.getCustomer_login_id() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.customer_id == other.getCustomer_id() &&
            this.customer_login_question_id == other.getCustomer_login_question_id() &&
            ((this.hint==null && other.getHint()==null) || 
             (this.hint!=null &&
              this.hint.equals(other.getHint()))) &&
            this.invalid_auth_attempts == other.getInvalid_auth_attempts() &&
            this.is_primary_login == other.getIs_primary_login() &&
            this.locked_out == other.getLocked_out() &&
            ((this.lockout_start==null && other.getLockout_start()==null) || 
             (this.lockout_start!=null &&
              this.lockout_start.equals(other.getLockout_start()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            this.pending_xaction_seq == other.getPending_xaction_seq() &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            this.salt == other.getSalt() &&
            ((this.temp_expire==null && other.getTemp_expire()==null) || 
             (this.temp_expire!=null &&
              this.temp_expire.equals(other.getTemp_expire())));
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
        _hashCode += getCustomer_login_id();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getCustomer_id();
        _hashCode += getCustomer_login_question_id();
        if (getHint() != null) {
            _hashCode += getHint().hashCode();
        }
        _hashCode += getInvalid_auth_attempts();
        _hashCode += getIs_primary_login();
        _hashCode += getLocked_out();
        if (getLockout_start() != null) {
            _hashCode += getLockout_start().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        _hashCode += getPending_xaction_header_id();
        _hashCode += getPending_xaction_seq();
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        _hashCode += getSalt();
        if (getTemp_expire() != null) {
            _hashCode += getTemp_expire().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZCustomerLogin.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZCustomerLogin"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_question_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_question_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("hint");
        attrField.setXmlName(new javax.xml.namespace.QName("", "hint"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invalid_auth_attempts");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invalid_auth_attempts"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_primary_login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_primary_login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("locked_out");
        attrField.setXmlName(new javax.xml.namespace.QName("", "locked_out"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lockout_start");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lockout_start"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("password");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_header_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_header_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "response"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("salt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "salt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("temp_expire");
        attrField.setXmlName(new javax.xml.namespace.QName("", "temp_expire"));
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
