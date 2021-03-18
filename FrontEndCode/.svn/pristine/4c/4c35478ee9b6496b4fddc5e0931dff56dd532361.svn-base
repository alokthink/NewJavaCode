/**
 * Process_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Process_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.Integer process_id;

    private Think.XmlWebServices.Process_select_requestActive_only active_only;

    private java.lang.String dsn;  // attribute

    public Process_select_request() {
    }

    public Process_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.Integer process_id,
           Think.XmlWebServices.Process_select_requestActive_only active_only,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.process_id = process_id;
           this.active_only = active_only;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Process_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Process_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the process_id value for this Process_select_request.
     * 
     * @return process_id
     */
    public java.lang.Integer getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this Process_select_request.
     * 
     * @param process_id
     */
    public void setProcess_id(java.lang.Integer process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the active_only value for this Process_select_request.
     * 
     * @return active_only
     */
    public Think.XmlWebServices.Process_select_requestActive_only getActive_only() {
        return active_only;
    }


    /**
     * Sets the active_only value for this Process_select_request.
     * 
     * @param active_only
     */
    public void setActive_only(Think.XmlWebServices.Process_select_requestActive_only active_only) {
        this.active_only = active_only;
    }


    /**
     * Gets the dsn value for this Process_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Process_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Process_select_request)) return false;
        Process_select_request other = (Process_select_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.process_id==null && other.getProcess_id()==null) || 
             (this.process_id!=null &&
              this.process_id.equals(other.getProcess_id()))) &&
            ((this.active_only==null && other.getActive_only()==null) || 
             (this.active_only!=null &&
              this.active_only.equals(other.getActive_only()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getProcess_id() != null) {
            _hashCode += getProcess_id().hashCode();
        }
        if (getActive_only() != null) {
            _hashCode += getActive_only().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Process_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">process_select_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("process_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "process_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active_only");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "active_only"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>process_select_request>active_only"));
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
