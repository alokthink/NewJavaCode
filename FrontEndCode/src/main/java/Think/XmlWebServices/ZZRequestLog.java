/**
 * ZZRequestLog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZRequestLog  implements java.io.Serializable {
    private int request_log_id;  // attribute

    private java.lang.String client_machine_name;  // attribute

    private java.lang.String edit_trail;  // attribute

    private java.lang.String expanded_info;  // attribute

    private java.lang.String request;  // attribute

    private java.util.Calendar request_date_time;  // attribute

    private java.lang.String response;  // attribute

    private java.lang.String server_machine_name;  // attribute

    private java.util.Calendar status_change_date_time;  // attribute

    private int user_definable_status;  // attribute

    public ZZRequestLog() {
    }

    public ZZRequestLog(
           int request_log_id,
           java.lang.String client_machine_name,
           java.lang.String edit_trail,
           java.lang.String expanded_info,
           java.lang.String request,
           java.util.Calendar request_date_time,
           java.lang.String response,
           java.lang.String server_machine_name,
           java.util.Calendar status_change_date_time,
           int user_definable_status) {
           this.request_log_id = request_log_id;
           this.client_machine_name = client_machine_name;
           this.edit_trail = edit_trail;
           this.expanded_info = expanded_info;
           this.request = request;
           this.request_date_time = request_date_time;
           this.response = response;
           this.server_machine_name = server_machine_name;
           this.status_change_date_time = status_change_date_time;
           this.user_definable_status = user_definable_status;
    }


    /**
     * Gets the request_log_id value for this ZZRequestLog.
     * 
     * @return request_log_id
     */
    public int getRequest_log_id() {
        return request_log_id;
    }


    /**
     * Sets the request_log_id value for this ZZRequestLog.
     * 
     * @param request_log_id
     */
    public void setRequest_log_id(int request_log_id) {
        this.request_log_id = request_log_id;
    }


    /**
     * Gets the client_machine_name value for this ZZRequestLog.
     * 
     * @return client_machine_name
     */
    public java.lang.String getClient_machine_name() {
        return client_machine_name;
    }


    /**
     * Sets the client_machine_name value for this ZZRequestLog.
     * 
     * @param client_machine_name
     */
    public void setClient_machine_name(java.lang.String client_machine_name) {
        this.client_machine_name = client_machine_name;
    }


    /**
     * Gets the edit_trail value for this ZZRequestLog.
     * 
     * @return edit_trail
     */
    public java.lang.String getEdit_trail() {
        return edit_trail;
    }


    /**
     * Sets the edit_trail value for this ZZRequestLog.
     * 
     * @param edit_trail
     */
    public void setEdit_trail(java.lang.String edit_trail) {
        this.edit_trail = edit_trail;
    }


    /**
     * Gets the expanded_info value for this ZZRequestLog.
     * 
     * @return expanded_info
     */
    public java.lang.String getExpanded_info() {
        return expanded_info;
    }


    /**
     * Sets the expanded_info value for this ZZRequestLog.
     * 
     * @param expanded_info
     */
    public void setExpanded_info(java.lang.String expanded_info) {
        this.expanded_info = expanded_info;
    }


    /**
     * Gets the request value for this ZZRequestLog.
     * 
     * @return request
     */
    public java.lang.String getRequest() {
        return request;
    }


    /**
     * Sets the request value for this ZZRequestLog.
     * 
     * @param request
     */
    public void setRequest(java.lang.String request) {
        this.request = request;
    }


    /**
     * Gets the request_date_time value for this ZZRequestLog.
     * 
     * @return request_date_time
     */
    public java.util.Calendar getRequest_date_time() {
        return request_date_time;
    }


    /**
     * Sets the request_date_time value for this ZZRequestLog.
     * 
     * @param request_date_time
     */
    public void setRequest_date_time(java.util.Calendar request_date_time) {
        this.request_date_time = request_date_time;
    }


    /**
     * Gets the response value for this ZZRequestLog.
     * 
     * @return response
     */
    public java.lang.String getResponse() {
        return response;
    }


    /**
     * Sets the response value for this ZZRequestLog.
     * 
     * @param response
     */
    public void setResponse(java.lang.String response) {
        this.response = response;
    }


    /**
     * Gets the server_machine_name value for this ZZRequestLog.
     * 
     * @return server_machine_name
     */
    public java.lang.String getServer_machine_name() {
        return server_machine_name;
    }


    /**
     * Sets the server_machine_name value for this ZZRequestLog.
     * 
     * @param server_machine_name
     */
    public void setServer_machine_name(java.lang.String server_machine_name) {
        this.server_machine_name = server_machine_name;
    }


    /**
     * Gets the status_change_date_time value for this ZZRequestLog.
     * 
     * @return status_change_date_time
     */
    public java.util.Calendar getStatus_change_date_time() {
        return status_change_date_time;
    }


    /**
     * Sets the status_change_date_time value for this ZZRequestLog.
     * 
     * @param status_change_date_time
     */
    public void setStatus_change_date_time(java.util.Calendar status_change_date_time) {
        this.status_change_date_time = status_change_date_time;
    }


    /**
     * Gets the user_definable_status value for this ZZRequestLog.
     * 
     * @return user_definable_status
     */
    public int getUser_definable_status() {
        return user_definable_status;
    }


    /**
     * Sets the user_definable_status value for this ZZRequestLog.
     * 
     * @param user_definable_status
     */
    public void setUser_definable_status(int user_definable_status) {
        this.user_definable_status = user_definable_status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZRequestLog)) return false;
        ZZRequestLog other = (ZZRequestLog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.request_log_id == other.getRequest_log_id() &&
            ((this.client_machine_name==null && other.getClient_machine_name()==null) || 
             (this.client_machine_name!=null &&
              this.client_machine_name.equals(other.getClient_machine_name()))) &&
            ((this.edit_trail==null && other.getEdit_trail()==null) || 
             (this.edit_trail!=null &&
              this.edit_trail.equals(other.getEdit_trail()))) &&
            ((this.expanded_info==null && other.getExpanded_info()==null) || 
             (this.expanded_info!=null &&
              this.expanded_info.equals(other.getExpanded_info()))) &&
            ((this.request==null && other.getRequest()==null) || 
             (this.request!=null &&
              this.request.equals(other.getRequest()))) &&
            ((this.request_date_time==null && other.getRequest_date_time()==null) || 
             (this.request_date_time!=null &&
              this.request_date_time.equals(other.getRequest_date_time()))) &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            ((this.server_machine_name==null && other.getServer_machine_name()==null) || 
             (this.server_machine_name!=null &&
              this.server_machine_name.equals(other.getServer_machine_name()))) &&
            ((this.status_change_date_time==null && other.getStatus_change_date_time()==null) || 
             (this.status_change_date_time!=null &&
              this.status_change_date_time.equals(other.getStatus_change_date_time()))) &&
            this.user_definable_status == other.getUser_definable_status();
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
        _hashCode += getRequest_log_id();
        if (getClient_machine_name() != null) {
            _hashCode += getClient_machine_name().hashCode();
        }
        if (getEdit_trail() != null) {
            _hashCode += getEdit_trail().hashCode();
        }
        if (getExpanded_info() != null) {
            _hashCode += getExpanded_info().hashCode();
        }
        if (getRequest() != null) {
            _hashCode += getRequest().hashCode();
        }
        if (getRequest_date_time() != null) {
            _hashCode += getRequest_date_time().hashCode();
        }
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        if (getServer_machine_name() != null) {
            _hashCode += getServer_machine_name().hashCode();
        }
        if (getStatus_change_date_time() != null) {
            _hashCode += getStatus_change_date_time().hashCode();
        }
        _hashCode += getUser_definable_status();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZRequestLog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZRequestLog"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("request_log_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "request_log_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("client_machine_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "client_machine_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("edit_trail");
        attrField.setXmlName(new javax.xml.namespace.QName("", "edit_trail"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("expanded_info");
        attrField.setXmlName(new javax.xml.namespace.QName("", "expanded_info"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("request");
        attrField.setXmlName(new javax.xml.namespace.QName("", "request"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("request_date_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "request_date_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "response"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("server_machine_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "server_machine_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status_change_date_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status_change_date_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_definable_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_definable_status"));
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
