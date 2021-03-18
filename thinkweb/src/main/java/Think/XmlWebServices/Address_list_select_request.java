/**
 * Address_list_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Address_list_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.lang.String lname;

    private java.lang.String lname_truncated;

    private java.lang.String fname;

    private java.lang.String fname_truncated;

    private java.lang.String initial_name;

    private java.lang.String initial_name_truncated;

    private java.lang.String orderhdr_id;

    private java.lang.String dsn;  // attribute

    public Address_list_select_request() {
    }

    public Address_list_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.lang.String lname,
           java.lang.String lname_truncated,
           java.lang.String fname,
           java.lang.String fname_truncated,
           java.lang.String initial_name,
           java.lang.String initial_name_truncated,
           java.lang.String orderhdr_id,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.lname = lname;
           this.lname_truncated = lname_truncated;
           this.fname = fname;
           this.fname_truncated = fname_truncated;
           this.initial_name = initial_name;
           this.initial_name_truncated = initial_name_truncated;
           this.orderhdr_id = orderhdr_id;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Address_list_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Address_list_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Address_list_select_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Address_list_select_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the lname value for this Address_list_select_request.
     * 
     * @return lname
     */
    public java.lang.String getLname() {
        return lname;
    }


    /**
     * Sets the lname value for this Address_list_select_request.
     * 
     * @param lname
     */
    public void setLname(java.lang.String lname) {
        this.lname = lname;
    }


    /**
     * Gets the lname_truncated value for this Address_list_select_request.
     * 
     * @return lname_truncated
     */
    public java.lang.String getLname_truncated() {
        return lname_truncated;
    }


    /**
     * Sets the lname_truncated value for this Address_list_select_request.
     * 
     * @param lname_truncated
     */
    public void setLname_truncated(java.lang.String lname_truncated) {
        this.lname_truncated = lname_truncated;
    }


    /**
     * Gets the fname value for this Address_list_select_request.
     * 
     * @return fname
     */
    public java.lang.String getFname() {
        return fname;
    }


    /**
     * Sets the fname value for this Address_list_select_request.
     * 
     * @param fname
     */
    public void setFname(java.lang.String fname) {
        this.fname = fname;
    }


    /**
     * Gets the fname_truncated value for this Address_list_select_request.
     * 
     * @return fname_truncated
     */
    public java.lang.String getFname_truncated() {
        return fname_truncated;
    }


    /**
     * Sets the fname_truncated value for this Address_list_select_request.
     * 
     * @param fname_truncated
     */
    public void setFname_truncated(java.lang.String fname_truncated) {
        this.fname_truncated = fname_truncated;
    }


    /**
     * Gets the initial_name value for this Address_list_select_request.
     * 
     * @return initial_name
     */
    public java.lang.String getInitial_name() {
        return initial_name;
    }


    /**
     * Sets the initial_name value for this Address_list_select_request.
     * 
     * @param initial_name
     */
    public void setInitial_name(java.lang.String initial_name) {
        this.initial_name = initial_name;
    }


    /**
     * Gets the initial_name_truncated value for this Address_list_select_request.
     * 
     * @return initial_name_truncated
     */
    public java.lang.String getInitial_name_truncated() {
        return initial_name_truncated;
    }


    /**
     * Sets the initial_name_truncated value for this Address_list_select_request.
     * 
     * @param initial_name_truncated
     */
    public void setInitial_name_truncated(java.lang.String initial_name_truncated) {
        this.initial_name_truncated = initial_name_truncated;
    }


    /**
     * Gets the orderhdr_id value for this Address_list_select_request.
     * 
     * @return orderhdr_id
     */
    public java.lang.String getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Address_list_select_request.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.String orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the dsn value for this Address_list_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Address_list_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Address_list_select_request)) return false;
        Address_list_select_request other = (Address_list_select_request) obj;
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
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.lname==null && other.getLname()==null) || 
             (this.lname!=null &&
              this.lname.equals(other.getLname()))) &&
            ((this.lname_truncated==null && other.getLname_truncated()==null) || 
             (this.lname_truncated!=null &&
              this.lname_truncated.equals(other.getLname_truncated()))) &&
            ((this.fname==null && other.getFname()==null) || 
             (this.fname!=null &&
              this.fname.equals(other.getFname()))) &&
            ((this.fname_truncated==null && other.getFname_truncated()==null) || 
             (this.fname_truncated!=null &&
              this.fname_truncated.equals(other.getFname_truncated()))) &&
            ((this.initial_name==null && other.getInitial_name()==null) || 
             (this.initial_name!=null &&
              this.initial_name.equals(other.getInitial_name()))) &&
            ((this.initial_name_truncated==null && other.getInitial_name_truncated()==null) || 
             (this.initial_name_truncated!=null &&
              this.initial_name_truncated.equals(other.getInitial_name_truncated()))) &&
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getLname() != null) {
            _hashCode += getLname().hashCode();
        }
        if (getLname_truncated() != null) {
            _hashCode += getLname_truncated().hashCode();
        }
        if (getFname() != null) {
            _hashCode += getFname().hashCode();
        }
        if (getFname_truncated() != null) {
            _hashCode += getFname_truncated().hashCode();
        }
        if (getInitial_name() != null) {
            _hashCode += getInitial_name().hashCode();
        }
        if (getInitial_name_truncated() != null) {
            _hashCode += getInitial_name_truncated().hashCode();
        }
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Address_list_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">address_list_select_request"));
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
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "lname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lname_truncated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "lname_truncated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "fname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fname_truncated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "fname_truncated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initial_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "initial_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initial_name_truncated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "initial_name_truncated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
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
