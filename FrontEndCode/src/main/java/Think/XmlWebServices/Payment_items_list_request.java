/**
 * Payment_items_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_items_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.lang.Integer orderhdr_id;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean single_item_only;  // attribute

    private Think.XmlWebServices.ZZBoolean include_cancelled;  // attribute

    private Think.XmlWebServices.ZZBoolean non_zero_balance_only;  // attribute

    private Think.XmlWebServices.Customer_role customer_role;  // attribute

    public Payment_items_list_request() {
    }

    public Payment_items_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.lang.Integer orderhdr_id,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean single_item_only,
           Think.XmlWebServices.ZZBoolean include_cancelled,
           Think.XmlWebServices.ZZBoolean non_zero_balance_only,
           Think.XmlWebServices.Customer_role customer_role) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.orderhdr_id = orderhdr_id;
           this.item_identifier = item_identifier;
           this.dsn = dsn;
           this.single_item_only = single_item_only;
           this.include_cancelled = include_cancelled;
           this.non_zero_balance_only = non_zero_balance_only;
           this.customer_role = customer_role;
    }


    /**
     * Gets the user_login_data value for this Payment_items_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Payment_items_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Payment_items_list_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_items_list_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the orderhdr_id value for this Payment_items_list_request.
     * 
     * @return orderhdr_id
     */
    public java.lang.Integer getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Payment_items_list_request.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.Integer orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the item_identifier value for this Payment_items_list_request.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Payment_items_list_request.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the dsn value for this Payment_items_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Payment_items_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the single_item_only value for this Payment_items_list_request.
     * 
     * @return single_item_only
     */
    public Think.XmlWebServices.ZZBoolean getSingle_item_only() {
        return single_item_only;
    }


    /**
     * Sets the single_item_only value for this Payment_items_list_request.
     * 
     * @param single_item_only
     */
    public void setSingle_item_only(Think.XmlWebServices.ZZBoolean single_item_only) {
        this.single_item_only = single_item_only;
    }


    /**
     * Gets the include_cancelled value for this Payment_items_list_request.
     * 
     * @return include_cancelled
     */
    public Think.XmlWebServices.ZZBoolean getInclude_cancelled() {
        return include_cancelled;
    }


    /**
     * Sets the include_cancelled value for this Payment_items_list_request.
     * 
     * @param include_cancelled
     */
    public void setInclude_cancelled(Think.XmlWebServices.ZZBoolean include_cancelled) {
        this.include_cancelled = include_cancelled;
    }


    /**
     * Gets the non_zero_balance_only value for this Payment_items_list_request.
     * 
     * @return non_zero_balance_only
     */
    public Think.XmlWebServices.ZZBoolean getNon_zero_balance_only() {
        return non_zero_balance_only;
    }


    /**
     * Sets the non_zero_balance_only value for this Payment_items_list_request.
     * 
     * @param non_zero_balance_only
     */
    public void setNon_zero_balance_only(Think.XmlWebServices.ZZBoolean non_zero_balance_only) {
        this.non_zero_balance_only = non_zero_balance_only;
    }


    /**
     * Gets the customer_role value for this Payment_items_list_request.
     * 
     * @return customer_role
     */
    public Think.XmlWebServices.Customer_role getCustomer_role() {
        return customer_role;
    }


    /**
     * Sets the customer_role value for this Payment_items_list_request.
     * 
     * @param customer_role
     */
    public void setCustomer_role(Think.XmlWebServices.Customer_role customer_role) {
        this.customer_role = customer_role;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_items_list_request)) return false;
        Payment_items_list_request other = (Payment_items_list_request) obj;
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
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.single_item_only==null && other.getSingle_item_only()==null) || 
             (this.single_item_only!=null &&
              this.single_item_only.equals(other.getSingle_item_only()))) &&
            ((this.include_cancelled==null && other.getInclude_cancelled()==null) || 
             (this.include_cancelled!=null &&
              this.include_cancelled.equals(other.getInclude_cancelled()))) &&
            ((this.non_zero_balance_only==null && other.getNon_zero_balance_only()==null) || 
             (this.non_zero_balance_only!=null &&
              this.non_zero_balance_only.equals(other.getNon_zero_balance_only()))) &&
            ((this.customer_role==null && other.getCustomer_role()==null) || 
             (this.customer_role!=null &&
              this.customer_role.equals(other.getCustomer_role())));
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
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getSingle_item_only() != null) {
            _hashCode += getSingle_item_only().hashCode();
        }
        if (getInclude_cancelled() != null) {
            _hashCode += getInclude_cancelled().hashCode();
        }
        if (getNon_zero_balance_only() != null) {
            _hashCode += getNon_zero_balance_only().hashCode();
        }
        if (getCustomer_role() != null) {
            _hashCode += getCustomer_role().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_items_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_items_list_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("single_item_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "single_item_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("include_cancelled");
        attrField.setXmlName(new javax.xml.namespace.QName("", "include_cancelled"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("non_zero_balance_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "non_zero_balance_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_role");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_role"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_role"));
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
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
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
