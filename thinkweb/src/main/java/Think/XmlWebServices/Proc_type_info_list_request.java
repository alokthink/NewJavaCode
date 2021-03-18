/**
 * Proc_type_info_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Proc_type_info_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.Integer job_id;

    private java.lang.Integer process_id;

    private java.lang.Integer process_type;

    private java.lang.String dsn;  // attribute

    public Proc_type_info_list_request() {
    }

    public Proc_type_info_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.Integer job_id,
           java.lang.Integer process_id,
           java.lang.Integer process_type,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.job_id = job_id;
           this.process_id = process_id;
           this.process_type = process_type;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Proc_type_info_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Proc_type_info_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the job_id value for this Proc_type_info_list_request.
     * 
     * @return job_id
     */
    public java.lang.Integer getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Proc_type_info_list_request.
     * 
     * @param job_id
     */
    public void setJob_id(java.lang.Integer job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the process_id value for this Proc_type_info_list_request.
     * 
     * @return process_id
     */
    public java.lang.Integer getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this Proc_type_info_list_request.
     * 
     * @param process_id
     */
    public void setProcess_id(java.lang.Integer process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the process_type value for this Proc_type_info_list_request.
     * 
     * @return process_type
     */
    public java.lang.Integer getProcess_type() {
        return process_type;
    }


    /**
     * Sets the process_type value for this Proc_type_info_list_request.
     * 
     * @param process_type
     */
    public void setProcess_type(java.lang.Integer process_type) {
        this.process_type = process_type;
    }


    /**
     * Gets the dsn value for this Proc_type_info_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Proc_type_info_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Proc_type_info_list_request)) return false;
        Proc_type_info_list_request other = (Proc_type_info_list_request) obj;
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
            ((this.job_id==null && other.getJob_id()==null) || 
             (this.job_id!=null &&
              this.job_id.equals(other.getJob_id()))) &&
            ((this.process_id==null && other.getProcess_id()==null) || 
             (this.process_id!=null &&
              this.process_id.equals(other.getProcess_id()))) &&
            ((this.process_type==null && other.getProcess_type()==null) || 
             (this.process_type!=null &&
              this.process_type.equals(other.getProcess_type()))) &&
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
        if (getJob_id() != null) {
            _hashCode += getJob_id().hashCode();
        }
        if (getProcess_id() != null) {
            _hashCode += getProcess_id().hashCode();
        }
        if (getProcess_type() != null) {
            _hashCode += getProcess_type().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Proc_type_info_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">proc_type_info_list_request"));
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
        elemField.setFieldName("job_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("process_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "process_type"));
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
