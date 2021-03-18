/**
 * Order_add_deposit_use_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_add_deposit_use_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_address_identifier customer_address_identifier;

    private Think.XmlWebServices.Order_data order_data;

    private Think.XmlWebServices.Unit_data[] usage_data;

    private java.lang.String currency;

    private Think.XmlWebServices.Response[] demographic_data;

    private Think.XmlWebServices.Order_item[] items_in_progress;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean submit;  // attribute

    private int doc_ref_id;  // attribute

    private Think.XmlWebServices.ZZBoolean check_missing_fields;  // attribute

    private Think.XmlWebServices.ZZBoolean suppress_events;  // attribute

    public Order_add_deposit_use_request() {
    }

    public Order_add_deposit_use_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_address_identifier customer_address_identifier,
           Think.XmlWebServices.Order_data order_data,
           Think.XmlWebServices.Unit_data[] usage_data,
           java.lang.String currency,
           Think.XmlWebServices.Response[] demographic_data,
           Think.XmlWebServices.Order_item[] items_in_progress,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean submit,
           int doc_ref_id,
           Think.XmlWebServices.ZZBoolean check_missing_fields,
           Think.XmlWebServices.ZZBoolean suppress_events) {
           this.user_login_data = user_login_data;
           this.customer_address_identifier = customer_address_identifier;
           this.order_data = order_data;
           this.usage_data = usage_data;
           this.currency = currency;
           this.demographic_data = demographic_data;
           this.items_in_progress = items_in_progress;
           this.dsn = dsn;
           this.submit = submit;
           this.doc_ref_id = doc_ref_id;
           this.check_missing_fields = check_missing_fields;
           this.suppress_events = suppress_events;
    }


    /**
     * Gets the user_login_data value for this Order_add_deposit_use_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Order_add_deposit_use_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_address_identifier value for this Order_add_deposit_use_request.
     * 
     * @return customer_address_identifier
     */
    public Think.XmlWebServices.Customer_address_identifier getCustomer_address_identifier() {
        return customer_address_identifier;
    }


    /**
     * Sets the customer_address_identifier value for this Order_add_deposit_use_request.
     * 
     * @param customer_address_identifier
     */
    public void setCustomer_address_identifier(Think.XmlWebServices.Customer_address_identifier customer_address_identifier) {
        this.customer_address_identifier = customer_address_identifier;
    }


    /**
     * Gets the order_data value for this Order_add_deposit_use_request.
     * 
     * @return order_data
     */
    public Think.XmlWebServices.Order_data getOrder_data() {
        return order_data;
    }


    /**
     * Sets the order_data value for this Order_add_deposit_use_request.
     * 
     * @param order_data
     */
    public void setOrder_data(Think.XmlWebServices.Order_data order_data) {
        this.order_data = order_data;
    }


    /**
     * Gets the usage_data value for this Order_add_deposit_use_request.
     * 
     * @return usage_data
     */
    public Think.XmlWebServices.Unit_data[] getUsage_data() {
        return usage_data;
    }


    /**
     * Sets the usage_data value for this Order_add_deposit_use_request.
     * 
     * @param usage_data
     */
    public void setUsage_data(Think.XmlWebServices.Unit_data[] usage_data) {
        this.usage_data = usage_data;
    }


    /**
     * Gets the currency value for this Order_add_deposit_use_request.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Order_add_deposit_use_request.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the demographic_data value for this Order_add_deposit_use_request.
     * 
     * @return demographic_data
     */
    public Think.XmlWebServices.Response[] getDemographic_data() {
        return demographic_data;
    }


    /**
     * Sets the demographic_data value for this Order_add_deposit_use_request.
     * 
     * @param demographic_data
     */
    public void setDemographic_data(Think.XmlWebServices.Response[] demographic_data) {
        this.demographic_data = demographic_data;
    }


    /**
     * Gets the items_in_progress value for this Order_add_deposit_use_request.
     * 
     * @return items_in_progress
     */
    public Think.XmlWebServices.Order_item[] getItems_in_progress() {
        return items_in_progress;
    }


    /**
     * Sets the items_in_progress value for this Order_add_deposit_use_request.
     * 
     * @param items_in_progress
     */
    public void setItems_in_progress(Think.XmlWebServices.Order_item[] items_in_progress) {
        this.items_in_progress = items_in_progress;
    }


    /**
     * Gets the dsn value for this Order_add_deposit_use_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Order_add_deposit_use_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the submit value for this Order_add_deposit_use_request.
     * 
     * @return submit
     */
    public Think.XmlWebServices.ZZBoolean getSubmit() {
        return submit;
    }


    /**
     * Sets the submit value for this Order_add_deposit_use_request.
     * 
     * @param submit
     */
    public void setSubmit(Think.XmlWebServices.ZZBoolean submit) {
        this.submit = submit;
    }


    /**
     * Gets the doc_ref_id value for this Order_add_deposit_use_request.
     * 
     * @return doc_ref_id
     */
    public int getDoc_ref_id() {
        return doc_ref_id;
    }


    /**
     * Sets the doc_ref_id value for this Order_add_deposit_use_request.
     * 
     * @param doc_ref_id
     */
    public void setDoc_ref_id(int doc_ref_id) {
        this.doc_ref_id = doc_ref_id;
    }


    /**
     * Gets the check_missing_fields value for this Order_add_deposit_use_request.
     * 
     * @return check_missing_fields
     */
    public Think.XmlWebServices.ZZBoolean getCheck_missing_fields() {
        return check_missing_fields;
    }


    /**
     * Sets the check_missing_fields value for this Order_add_deposit_use_request.
     * 
     * @param check_missing_fields
     */
    public void setCheck_missing_fields(Think.XmlWebServices.ZZBoolean check_missing_fields) {
        this.check_missing_fields = check_missing_fields;
    }


    /**
     * Gets the suppress_events value for this Order_add_deposit_use_request.
     * 
     * @return suppress_events
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_events() {
        return suppress_events;
    }


    /**
     * Sets the suppress_events value for this Order_add_deposit_use_request.
     * 
     * @param suppress_events
     */
    public void setSuppress_events(Think.XmlWebServices.ZZBoolean suppress_events) {
        this.suppress_events = suppress_events;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_add_deposit_use_request)) return false;
        Order_add_deposit_use_request other = (Order_add_deposit_use_request) obj;
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
            ((this.customer_address_identifier==null && other.getCustomer_address_identifier()==null) || 
             (this.customer_address_identifier!=null &&
              this.customer_address_identifier.equals(other.getCustomer_address_identifier()))) &&
            ((this.order_data==null && other.getOrder_data()==null) || 
             (this.order_data!=null &&
              this.order_data.equals(other.getOrder_data()))) &&
            ((this.usage_data==null && other.getUsage_data()==null) || 
             (this.usage_data!=null &&
              java.util.Arrays.equals(this.usage_data, other.getUsage_data()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.demographic_data==null && other.getDemographic_data()==null) || 
             (this.demographic_data!=null &&
              java.util.Arrays.equals(this.demographic_data, other.getDemographic_data()))) &&
            ((this.items_in_progress==null && other.getItems_in_progress()==null) || 
             (this.items_in_progress!=null &&
              java.util.Arrays.equals(this.items_in_progress, other.getItems_in_progress()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.submit==null && other.getSubmit()==null) || 
             (this.submit!=null &&
              this.submit.equals(other.getSubmit()))) &&
            this.doc_ref_id == other.getDoc_ref_id() &&
            ((this.check_missing_fields==null && other.getCheck_missing_fields()==null) || 
             (this.check_missing_fields!=null &&
              this.check_missing_fields.equals(other.getCheck_missing_fields()))) &&
            ((this.suppress_events==null && other.getSuppress_events()==null) || 
             (this.suppress_events!=null &&
              this.suppress_events.equals(other.getSuppress_events())));
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
        if (getCustomer_address_identifier() != null) {
            _hashCode += getCustomer_address_identifier().hashCode();
        }
        if (getOrder_data() != null) {
            _hashCode += getOrder_data().hashCode();
        }
        if (getUsage_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUsage_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUsage_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getDemographic_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDemographic_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDemographic_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItems_in_progress() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItems_in_progress());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItems_in_progress(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getSubmit() != null) {
            _hashCode += getSubmit().hashCode();
        }
        _hashCode += getDoc_ref_id();
        if (getCheck_missing_fields() != null) {
            _hashCode += getCheck_missing_fields().hashCode();
        }
        if (getSuppress_events() != null) {
            _hashCode += getSuppress_events().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_add_deposit_use_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_add_deposit_use_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("submit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "submit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("doc_ref_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "doc_ref_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("check_missing_fields");
        attrField.setXmlName(new javax.xml.namespace.QName("", "check_missing_fields"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_events");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_events"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_address_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usage_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "usage_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">usage_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demographic_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demographic_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items_in_progress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "items_in_progress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">items_in_progress"));
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
