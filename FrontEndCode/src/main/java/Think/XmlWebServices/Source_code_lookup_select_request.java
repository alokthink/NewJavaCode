/**
 * Source_code_lookup_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Source_code_lookup_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.String source_code;

    private java.lang.String list;

    private java.lang.String offer;

    private java.lang.Integer oc_id;

    private java.lang.String dsn;  // attribute

    public Source_code_lookup_select_request() {
    }

    public Source_code_lookup_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.String source_code,
           java.lang.String list,
           java.lang.String offer,
           java.lang.Integer oc_id,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.source_code = source_code;
           this.list = list;
           this.offer = offer;
           this.oc_id = oc_id;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Source_code_lookup_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Source_code_lookup_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the source_code value for this Source_code_lookup_select_request.
     * 
     * @return source_code
     */
    public java.lang.String getSource_code() {
        return source_code;
    }


    /**
     * Sets the source_code value for this Source_code_lookup_select_request.
     * 
     * @param source_code
     */
    public void setSource_code(java.lang.String source_code) {
        this.source_code = source_code;
    }


    /**
     * Gets the list value for this Source_code_lookup_select_request.
     * 
     * @return list
     */
    public java.lang.String getList() {
        return list;
    }


    /**
     * Sets the list value for this Source_code_lookup_select_request.
     * 
     * @param list
     */
    public void setList(java.lang.String list) {
        this.list = list;
    }


    /**
     * Gets the offer value for this Source_code_lookup_select_request.
     * 
     * @return offer
     */
    public java.lang.String getOffer() {
        return offer;
    }


    /**
     * Sets the offer value for this Source_code_lookup_select_request.
     * 
     * @param offer
     */
    public void setOffer(java.lang.String offer) {
        this.offer = offer;
    }


    /**
     * Gets the oc_id value for this Source_code_lookup_select_request.
     * 
     * @return oc_id
     */
    public java.lang.Integer getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Source_code_lookup_select_request.
     * 
     * @param oc_id
     */
    public void setOc_id(java.lang.Integer oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the dsn value for this Source_code_lookup_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Source_code_lookup_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Source_code_lookup_select_request)) return false;
        Source_code_lookup_select_request other = (Source_code_lookup_select_request) obj;
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
            ((this.source_code==null && other.getSource_code()==null) || 
             (this.source_code!=null &&
              this.source_code.equals(other.getSource_code()))) &&
            ((this.list==null && other.getList()==null) || 
             (this.list!=null &&
              this.list.equals(other.getList()))) &&
            ((this.offer==null && other.getOffer()==null) || 
             (this.offer!=null &&
              this.offer.equals(other.getOffer()))) &&
            ((this.oc_id==null && other.getOc_id()==null) || 
             (this.oc_id!=null &&
              this.oc_id.equals(other.getOc_id()))) &&
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
        if (getSource_code() != null) {
            _hashCode += getSource_code().hashCode();
        }
        if (getList() != null) {
            _hashCode += getList().hashCode();
        }
        if (getOffer() != null) {
            _hashCode += getOffer().hashCode();
        }
        if (getOc_id() != null) {
            _hashCode += getOc_id().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Source_code_lookup_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">source_code_lookup_select_request"));
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
        elemField.setFieldName("source_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "source_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oc_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "oc_id"));
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
