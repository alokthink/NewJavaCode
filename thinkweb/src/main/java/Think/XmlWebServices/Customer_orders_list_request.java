/**
 * Customer_orders_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_orders_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.lang.String table_or_view_name;

    private Think.XmlWebServices.Order_types_to_include include_order_types;

    private Think.XmlWebServices.ZZBoolean include_inactives;

    private java.lang.Integer limit_to_oc_id;

    private Think.XmlWebServices.ZZBoolean limit_paid;

    private Think.XmlWebServices.ZZBoolean limit_controlled;

    private Think.XmlWebServices.ZZBoolean limit_complimentary;

    private java.lang.Integer search_activated_subscrip_id;

    private java.lang.Integer search_activated_orderhdr_id;

    private java.lang.Integer search_activated_order_item_seq;

    private java.lang.Integer search_activated_pkg_item_seq;

    private java.lang.Integer search_activated_order_status;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean load_pkg_members;  // attribute

    public Customer_orders_list_request() {
    }

    public Customer_orders_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.lang.String table_or_view_name,
           Think.XmlWebServices.Order_types_to_include include_order_types,
           Think.XmlWebServices.ZZBoolean include_inactives,
           java.lang.Integer limit_to_oc_id,
           Think.XmlWebServices.ZZBoolean limit_paid,
           Think.XmlWebServices.ZZBoolean limit_controlled,
           Think.XmlWebServices.ZZBoolean limit_complimentary,
           java.lang.Integer search_activated_subscrip_id,
           java.lang.Integer search_activated_orderhdr_id,
           java.lang.Integer search_activated_order_item_seq,
           java.lang.Integer search_activated_pkg_item_seq,
           java.lang.Integer search_activated_order_status,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean load_pkg_members) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.table_or_view_name = table_or_view_name;
           this.include_order_types = include_order_types;
           this.include_inactives = include_inactives;
           this.limit_to_oc_id = limit_to_oc_id;
           this.limit_paid = limit_paid;
           this.limit_controlled = limit_controlled;
           this.limit_complimentary = limit_complimentary;
           this.search_activated_subscrip_id = search_activated_subscrip_id;
           this.search_activated_orderhdr_id = search_activated_orderhdr_id;
           this.search_activated_order_item_seq = search_activated_order_item_seq;
           this.search_activated_pkg_item_seq = search_activated_pkg_item_seq;
           this.search_activated_order_status = search_activated_order_status;
           this.dsn = dsn;
           this.load_pkg_members = load_pkg_members;
    }


    /**
     * Gets the user_login_data value for this Customer_orders_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Customer_orders_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Customer_orders_list_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_orders_list_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the table_or_view_name value for this Customer_orders_list_request.
     * 
     * @return table_or_view_name
     */
    public java.lang.String getTable_or_view_name() {
        return table_or_view_name;
    }


    /**
     * Sets the table_or_view_name value for this Customer_orders_list_request.
     * 
     * @param table_or_view_name
     */
    public void setTable_or_view_name(java.lang.String table_or_view_name) {
        this.table_or_view_name = table_or_view_name;
    }


    /**
     * Gets the include_order_types value for this Customer_orders_list_request.
     * 
     * @return include_order_types
     */
    public Think.XmlWebServices.Order_types_to_include getInclude_order_types() {
        return include_order_types;
    }


    /**
     * Sets the include_order_types value for this Customer_orders_list_request.
     * 
     * @param include_order_types
     */
    public void setInclude_order_types(Think.XmlWebServices.Order_types_to_include include_order_types) {
        this.include_order_types = include_order_types;
    }


    /**
     * Gets the include_inactives value for this Customer_orders_list_request.
     * 
     * @return include_inactives
     */
    public Think.XmlWebServices.ZZBoolean getInclude_inactives() {
        return include_inactives;
    }


    /**
     * Sets the include_inactives value for this Customer_orders_list_request.
     * 
     * @param include_inactives
     */
    public void setInclude_inactives(Think.XmlWebServices.ZZBoolean include_inactives) {
        this.include_inactives = include_inactives;
    }


    /**
     * Gets the limit_to_oc_id value for this Customer_orders_list_request.
     * 
     * @return limit_to_oc_id
     */
    public java.lang.Integer getLimit_to_oc_id() {
        return limit_to_oc_id;
    }


    /**
     * Sets the limit_to_oc_id value for this Customer_orders_list_request.
     * 
     * @param limit_to_oc_id
     */
    public void setLimit_to_oc_id(java.lang.Integer limit_to_oc_id) {
        this.limit_to_oc_id = limit_to_oc_id;
    }


    /**
     * Gets the limit_paid value for this Customer_orders_list_request.
     * 
     * @return limit_paid
     */
    public Think.XmlWebServices.ZZBoolean getLimit_paid() {
        return limit_paid;
    }


    /**
     * Sets the limit_paid value for this Customer_orders_list_request.
     * 
     * @param limit_paid
     */
    public void setLimit_paid(Think.XmlWebServices.ZZBoolean limit_paid) {
        this.limit_paid = limit_paid;
    }


    /**
     * Gets the limit_controlled value for this Customer_orders_list_request.
     * 
     * @return limit_controlled
     */
    public Think.XmlWebServices.ZZBoolean getLimit_controlled() {
        return limit_controlled;
    }


    /**
     * Sets the limit_controlled value for this Customer_orders_list_request.
     * 
     * @param limit_controlled
     */
    public void setLimit_controlled(Think.XmlWebServices.ZZBoolean limit_controlled) {
        this.limit_controlled = limit_controlled;
    }


    /**
     * Gets the limit_complimentary value for this Customer_orders_list_request.
     * 
     * @return limit_complimentary
     */
    public Think.XmlWebServices.ZZBoolean getLimit_complimentary() {
        return limit_complimentary;
    }


    /**
     * Sets the limit_complimentary value for this Customer_orders_list_request.
     * 
     * @param limit_complimentary
     */
    public void setLimit_complimentary(Think.XmlWebServices.ZZBoolean limit_complimentary) {
        this.limit_complimentary = limit_complimentary;
    }


    /**
     * Gets the search_activated_subscrip_id value for this Customer_orders_list_request.
     * 
     * @return search_activated_subscrip_id
     */
    public java.lang.Integer getSearch_activated_subscrip_id() {
        return search_activated_subscrip_id;
    }


    /**
     * Sets the search_activated_subscrip_id value for this Customer_orders_list_request.
     * 
     * @param search_activated_subscrip_id
     */
    public void setSearch_activated_subscrip_id(java.lang.Integer search_activated_subscrip_id) {
        this.search_activated_subscrip_id = search_activated_subscrip_id;
    }


    /**
     * Gets the search_activated_orderhdr_id value for this Customer_orders_list_request.
     * 
     * @return search_activated_orderhdr_id
     */
    public java.lang.Integer getSearch_activated_orderhdr_id() {
        return search_activated_orderhdr_id;
    }


    /**
     * Sets the search_activated_orderhdr_id value for this Customer_orders_list_request.
     * 
     * @param search_activated_orderhdr_id
     */
    public void setSearch_activated_orderhdr_id(java.lang.Integer search_activated_orderhdr_id) {
        this.search_activated_orderhdr_id = search_activated_orderhdr_id;
    }


    /**
     * Gets the search_activated_order_item_seq value for this Customer_orders_list_request.
     * 
     * @return search_activated_order_item_seq
     */
    public java.lang.Integer getSearch_activated_order_item_seq() {
        return search_activated_order_item_seq;
    }


    /**
     * Sets the search_activated_order_item_seq value for this Customer_orders_list_request.
     * 
     * @param search_activated_order_item_seq
     */
    public void setSearch_activated_order_item_seq(java.lang.Integer search_activated_order_item_seq) {
        this.search_activated_order_item_seq = search_activated_order_item_seq;
    }


    /**
     * Gets the search_activated_pkg_item_seq value for this Customer_orders_list_request.
     * 
     * @return search_activated_pkg_item_seq
     */
    public java.lang.Integer getSearch_activated_pkg_item_seq() {
        return search_activated_pkg_item_seq;
    }


    /**
     * Sets the search_activated_pkg_item_seq value for this Customer_orders_list_request.
     * 
     * @param search_activated_pkg_item_seq
     */
    public void setSearch_activated_pkg_item_seq(java.lang.Integer search_activated_pkg_item_seq) {
        this.search_activated_pkg_item_seq = search_activated_pkg_item_seq;
    }


    /**
     * Gets the search_activated_order_status value for this Customer_orders_list_request.
     * 
     * @return search_activated_order_status
     */
    public java.lang.Integer getSearch_activated_order_status() {
        return search_activated_order_status;
    }


    /**
     * Sets the search_activated_order_status value for this Customer_orders_list_request.
     * 
     * @param search_activated_order_status
     */
    public void setSearch_activated_order_status(java.lang.Integer search_activated_order_status) {
        this.search_activated_order_status = search_activated_order_status;
    }


    /**
     * Gets the dsn value for this Customer_orders_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Customer_orders_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the load_pkg_members value for this Customer_orders_list_request.
     * 
     * @return load_pkg_members
     */
    public Think.XmlWebServices.ZZBoolean getLoad_pkg_members() {
        return load_pkg_members;
    }


    /**
     * Sets the load_pkg_members value for this Customer_orders_list_request.
     * 
     * @param load_pkg_members
     */
    public void setLoad_pkg_members(Think.XmlWebServices.ZZBoolean load_pkg_members) {
        this.load_pkg_members = load_pkg_members;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_orders_list_request)) return false;
        Customer_orders_list_request other = (Customer_orders_list_request) obj;
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
            ((this.table_or_view_name==null && other.getTable_or_view_name()==null) || 
             (this.table_or_view_name!=null &&
              this.table_or_view_name.equals(other.getTable_or_view_name()))) &&
            ((this.include_order_types==null && other.getInclude_order_types()==null) || 
             (this.include_order_types!=null &&
              this.include_order_types.equals(other.getInclude_order_types()))) &&
            ((this.include_inactives==null && other.getInclude_inactives()==null) || 
             (this.include_inactives!=null &&
              this.include_inactives.equals(other.getInclude_inactives()))) &&
            ((this.limit_to_oc_id==null && other.getLimit_to_oc_id()==null) || 
             (this.limit_to_oc_id!=null &&
              this.limit_to_oc_id.equals(other.getLimit_to_oc_id()))) &&
            ((this.limit_paid==null && other.getLimit_paid()==null) || 
             (this.limit_paid!=null &&
              this.limit_paid.equals(other.getLimit_paid()))) &&
            ((this.limit_controlled==null && other.getLimit_controlled()==null) || 
             (this.limit_controlled!=null &&
              this.limit_controlled.equals(other.getLimit_controlled()))) &&
            ((this.limit_complimentary==null && other.getLimit_complimentary()==null) || 
             (this.limit_complimentary!=null &&
              this.limit_complimentary.equals(other.getLimit_complimentary()))) &&
            ((this.search_activated_subscrip_id==null && other.getSearch_activated_subscrip_id()==null) || 
             (this.search_activated_subscrip_id!=null &&
              this.search_activated_subscrip_id.equals(other.getSearch_activated_subscrip_id()))) &&
            ((this.search_activated_orderhdr_id==null && other.getSearch_activated_orderhdr_id()==null) || 
             (this.search_activated_orderhdr_id!=null &&
              this.search_activated_orderhdr_id.equals(other.getSearch_activated_orderhdr_id()))) &&
            ((this.search_activated_order_item_seq==null && other.getSearch_activated_order_item_seq()==null) || 
             (this.search_activated_order_item_seq!=null &&
              this.search_activated_order_item_seq.equals(other.getSearch_activated_order_item_seq()))) &&
            ((this.search_activated_pkg_item_seq==null && other.getSearch_activated_pkg_item_seq()==null) || 
             (this.search_activated_pkg_item_seq!=null &&
              this.search_activated_pkg_item_seq.equals(other.getSearch_activated_pkg_item_seq()))) &&
            ((this.search_activated_order_status==null && other.getSearch_activated_order_status()==null) || 
             (this.search_activated_order_status!=null &&
              this.search_activated_order_status.equals(other.getSearch_activated_order_status()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.load_pkg_members==null && other.getLoad_pkg_members()==null) || 
             (this.load_pkg_members!=null &&
              this.load_pkg_members.equals(other.getLoad_pkg_members())));
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
        if (getTable_or_view_name() != null) {
            _hashCode += getTable_or_view_name().hashCode();
        }
        if (getInclude_order_types() != null) {
            _hashCode += getInclude_order_types().hashCode();
        }
        if (getInclude_inactives() != null) {
            _hashCode += getInclude_inactives().hashCode();
        }
        if (getLimit_to_oc_id() != null) {
            _hashCode += getLimit_to_oc_id().hashCode();
        }
        if (getLimit_paid() != null) {
            _hashCode += getLimit_paid().hashCode();
        }
        if (getLimit_controlled() != null) {
            _hashCode += getLimit_controlled().hashCode();
        }
        if (getLimit_complimentary() != null) {
            _hashCode += getLimit_complimentary().hashCode();
        }
        if (getSearch_activated_subscrip_id() != null) {
            _hashCode += getSearch_activated_subscrip_id().hashCode();
        }
        if (getSearch_activated_orderhdr_id() != null) {
            _hashCode += getSearch_activated_orderhdr_id().hashCode();
        }
        if (getSearch_activated_order_item_seq() != null) {
            _hashCode += getSearch_activated_order_item_seq().hashCode();
        }
        if (getSearch_activated_pkg_item_seq() != null) {
            _hashCode += getSearch_activated_pkg_item_seq().hashCode();
        }
        if (getSearch_activated_order_status() != null) {
            _hashCode += getSearch_activated_order_status().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getLoad_pkg_members() != null) {
            _hashCode += getLoad_pkg_members().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_orders_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_orders_list_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("load_pkg_members");
        attrField.setXmlName(new javax.xml.namespace.QName("", "load_pkg_members"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
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
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table_or_view_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "table_or_view_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("include_order_types");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "include_order_types"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_types_to_include"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("include_inactives");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "include_inactives"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit_to_oc_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "limit_to_oc_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit_paid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "limit_paid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit_controlled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "limit_controlled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit_complimentary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "limit_complimentary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_activated_subscrip_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "search_activated_subscrip_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_activated_orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "search_activated_orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_activated_order_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "search_activated_order_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_activated_pkg_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "search_activated_pkg_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_activated_order_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "search_activated_order_status"));
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
