/**
 * Doc_ref_batch_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Doc_ref_batch_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.String doc_ref_types_comma_sep_list;

    private Think.XmlWebServices.ZZBoolean active;

    private java.lang.String description_like;

    private java.lang.String user_code;

    private Think.XmlWebServices.User_code_matches user_code_matches;

    private java.lang.String batch_template;

    private java.lang.String dsn;  // attribute

    public Doc_ref_batch_list_request() {
    }

    public Doc_ref_batch_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.String doc_ref_types_comma_sep_list,
           Think.XmlWebServices.ZZBoolean active,
           java.lang.String description_like,
           java.lang.String user_code,
           Think.XmlWebServices.User_code_matches user_code_matches,
           java.lang.String batch_template,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.doc_ref_types_comma_sep_list = doc_ref_types_comma_sep_list;
           this.active = active;
           this.description_like = description_like;
           this.user_code = user_code;
           this.user_code_matches = user_code_matches;
           this.batch_template = batch_template;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Doc_ref_batch_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Doc_ref_batch_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the doc_ref_types_comma_sep_list value for this Doc_ref_batch_list_request.
     * 
     * @return doc_ref_types_comma_sep_list
     */
    public java.lang.String getDoc_ref_types_comma_sep_list() {
        return doc_ref_types_comma_sep_list;
    }


    /**
     * Sets the doc_ref_types_comma_sep_list value for this Doc_ref_batch_list_request.
     * 
     * @param doc_ref_types_comma_sep_list
     */
    public void setDoc_ref_types_comma_sep_list(java.lang.String doc_ref_types_comma_sep_list) {
        this.doc_ref_types_comma_sep_list = doc_ref_types_comma_sep_list;
    }


    /**
     * Gets the active value for this Doc_ref_batch_list_request.
     * 
     * @return active
     */
    public Think.XmlWebServices.ZZBoolean getActive() {
        return active;
    }


    /**
     * Sets the active value for this Doc_ref_batch_list_request.
     * 
     * @param active
     */
    public void setActive(Think.XmlWebServices.ZZBoolean active) {
        this.active = active;
    }


    /**
     * Gets the description_like value for this Doc_ref_batch_list_request.
     * 
     * @return description_like
     */
    public java.lang.String getDescription_like() {
        return description_like;
    }


    /**
     * Sets the description_like value for this Doc_ref_batch_list_request.
     * 
     * @param description_like
     */
    public void setDescription_like(java.lang.String description_like) {
        this.description_like = description_like;
    }


    /**
     * Gets the user_code value for this Doc_ref_batch_list_request.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Doc_ref_batch_list_request.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the user_code_matches value for this Doc_ref_batch_list_request.
     * 
     * @return user_code_matches
     */
    public Think.XmlWebServices.User_code_matches getUser_code_matches() {
        return user_code_matches;
    }


    /**
     * Sets the user_code_matches value for this Doc_ref_batch_list_request.
     * 
     * @param user_code_matches
     */
    public void setUser_code_matches(Think.XmlWebServices.User_code_matches user_code_matches) {
        this.user_code_matches = user_code_matches;
    }


    /**
     * Gets the batch_template value for this Doc_ref_batch_list_request.
     * 
     * @return batch_template
     */
    public java.lang.String getBatch_template() {
        return batch_template;
    }


    /**
     * Sets the batch_template value for this Doc_ref_batch_list_request.
     * 
     * @param batch_template
     */
    public void setBatch_template(java.lang.String batch_template) {
        this.batch_template = batch_template;
    }


    /**
     * Gets the dsn value for this Doc_ref_batch_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Doc_ref_batch_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Doc_ref_batch_list_request)) return false;
        Doc_ref_batch_list_request other = (Doc_ref_batch_list_request) obj;
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
            ((this.doc_ref_types_comma_sep_list==null && other.getDoc_ref_types_comma_sep_list()==null) || 
             (this.doc_ref_types_comma_sep_list!=null &&
              this.doc_ref_types_comma_sep_list.equals(other.getDoc_ref_types_comma_sep_list()))) &&
            ((this.active==null && other.getActive()==null) || 
             (this.active!=null &&
              this.active.equals(other.getActive()))) &&
            ((this.description_like==null && other.getDescription_like()==null) || 
             (this.description_like!=null &&
              this.description_like.equals(other.getDescription_like()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.user_code_matches==null && other.getUser_code_matches()==null) || 
             (this.user_code_matches!=null &&
              this.user_code_matches.equals(other.getUser_code_matches()))) &&
            ((this.batch_template==null && other.getBatch_template()==null) || 
             (this.batch_template!=null &&
              this.batch_template.equals(other.getBatch_template()))) &&
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
        if (getDoc_ref_types_comma_sep_list() != null) {
            _hashCode += getDoc_ref_types_comma_sep_list().hashCode();
        }
        if (getActive() != null) {
            _hashCode += getActive().hashCode();
        }
        if (getDescription_like() != null) {
            _hashCode += getDescription_like().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getUser_code_matches() != null) {
            _hashCode += getUser_code_matches().hashCode();
        }
        if (getBatch_template() != null) {
            _hashCode += getBatch_template().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Doc_ref_batch_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">doc_ref_batch_list_request"));
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
        elemField.setFieldName("doc_ref_types_comma_sep_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "doc_ref_types_comma_sep_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description_like");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "description_like"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_code_matches");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code_matches"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code_matches"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batch_template");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "batch_template"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
