/**
 * Work_table_selection_update_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Work_table_selection_update_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Work_table_selection_update_requestJob_identifier job_identifier;

    private java.lang.String work_table_seq_list;

    private java.lang.String dsn;  // attribute

    public Work_table_selection_update_request() {
    }

    public Work_table_selection_update_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Work_table_selection_update_requestJob_identifier job_identifier,
           java.lang.String work_table_seq_list,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.job_identifier = job_identifier;
           this.work_table_seq_list = work_table_seq_list;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Work_table_selection_update_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Work_table_selection_update_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the job_identifier value for this Work_table_selection_update_request.
     * 
     * @return job_identifier
     */
    public Think.XmlWebServices.Work_table_selection_update_requestJob_identifier getJob_identifier() {
        return job_identifier;
    }


    /**
     * Sets the job_identifier value for this Work_table_selection_update_request.
     * 
     * @param job_identifier
     */
    public void setJob_identifier(Think.XmlWebServices.Work_table_selection_update_requestJob_identifier job_identifier) {
        this.job_identifier = job_identifier;
    }


    /**
     * Gets the work_table_seq_list value for this Work_table_selection_update_request.
     * 
     * @return work_table_seq_list
     */
    public java.lang.String getWork_table_seq_list() {
        return work_table_seq_list;
    }


    /**
     * Sets the work_table_seq_list value for this Work_table_selection_update_request.
     * 
     * @param work_table_seq_list
     */
    public void setWork_table_seq_list(java.lang.String work_table_seq_list) {
        this.work_table_seq_list = work_table_seq_list;
    }


    /**
     * Gets the dsn value for this Work_table_selection_update_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Work_table_selection_update_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Work_table_selection_update_request)) return false;
        Work_table_selection_update_request other = (Work_table_selection_update_request) obj;
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
            ((this.job_identifier==null && other.getJob_identifier()==null) || 
             (this.job_identifier!=null &&
              this.job_identifier.equals(other.getJob_identifier()))) &&
            ((this.work_table_seq_list==null && other.getWork_table_seq_list()==null) || 
             (this.work_table_seq_list!=null &&
              this.work_table_seq_list.equals(other.getWork_table_seq_list()))) &&
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
        if (getJob_identifier() != null) {
            _hashCode += getJob_identifier().hashCode();
        }
        if (getWork_table_seq_list() != null) {
            _hashCode += getWork_table_seq_list().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Work_table_selection_update_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">work_table_selection_update_request"));
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
        elemField.setFieldName("job_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>work_table_selection_update_request>job_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_table_seq_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_seq_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
