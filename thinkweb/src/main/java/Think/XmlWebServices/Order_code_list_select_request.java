/**
 * Order_code_list_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_code_list_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private int oc_id;

    private Think.XmlWebServices.Order_code_list_select_requestOrder_code_type order_code_type;

    private Think.XmlWebServices.Order_code_list_select_requestAllow_on_internet allow_on_internet;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    public Order_code_list_select_request() {
    }

    public Order_code_list_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           int oc_id,
           Think.XmlWebServices.Order_code_list_select_requestOrder_code_type order_code_type,
           Think.XmlWebServices.Order_code_list_select_requestAllow_on_internet allow_on_internet,
           java.lang.String dsn,
           java.lang.String language_code) {
           this.user_login_data = user_login_data;
           this.oc_id = oc_id;
           this.order_code_type = order_code_type;
           this.allow_on_internet = allow_on_internet;
           this.dsn = dsn;
           this.language_code = language_code;
    }


    /**
     * Gets the user_login_data value for this Order_code_list_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Order_code_list_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the oc_id value for this Order_code_list_select_request.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Order_code_list_select_request.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the order_code_type value for this Order_code_list_select_request.
     * 
     * @return order_code_type
     */
    public Think.XmlWebServices.Order_code_list_select_requestOrder_code_type getOrder_code_type() {
        return order_code_type;
    }


    /**
     * Sets the order_code_type value for this Order_code_list_select_request.
     * 
     * @param order_code_type
     */
    public void setOrder_code_type(Think.XmlWebServices.Order_code_list_select_requestOrder_code_type order_code_type) {
        this.order_code_type = order_code_type;
    }


    /**
     * Gets the allow_on_internet value for this Order_code_list_select_request.
     * 
     * @return allow_on_internet
     */
    public Think.XmlWebServices.Order_code_list_select_requestAllow_on_internet getAllow_on_internet() {
        return allow_on_internet;
    }


    /**
     * Sets the allow_on_internet value for this Order_code_list_select_request.
     * 
     * @param allow_on_internet
     */
    public void setAllow_on_internet(Think.XmlWebServices.Order_code_list_select_requestAllow_on_internet allow_on_internet) {
        this.allow_on_internet = allow_on_internet;
    }


    /**
     * Gets the dsn value for this Order_code_list_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Order_code_list_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Order_code_list_select_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Order_code_list_select_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_code_list_select_request)) return false;
        Order_code_list_select_request other = (Order_code_list_select_request) obj;
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
            this.oc_id == other.getOc_id() &&
            ((this.order_code_type==null && other.getOrder_code_type()==null) || 
             (this.order_code_type!=null &&
              this.order_code_type.equals(other.getOrder_code_type()))) &&
            ((this.allow_on_internet==null && other.getAllow_on_internet()==null) || 
             (this.allow_on_internet!=null &&
              this.allow_on_internet.equals(other.getAllow_on_internet()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code())));
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
        _hashCode += getOc_id();
        if (getOrder_code_type() != null) {
            _hashCode += getOrder_code_type().hashCode();
        }
        if (getAllow_on_internet() != null) {
            _hashCode += getAllow_on_internet().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getLanguage_code() != null) {
            _hashCode += getLanguage_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_code_list_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_code_list_select_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "language_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oc_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "oc_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>order_code_list_select_request>order_code_type"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allow_on_internet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "allow_on_internet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>order_code_list_select_request>allow_on_internet"));
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
