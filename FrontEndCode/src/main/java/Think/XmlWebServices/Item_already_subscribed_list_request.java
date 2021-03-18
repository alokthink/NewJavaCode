/**
 * Item_already_subscribed_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_already_subscribed_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_address_identifier customer_address_identifier;

    private Think.XmlWebServices.Order_data order_data;

    private Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list;

    private Think.XmlWebServices.Order_item[] items_in_progress;

    private java.lang.String dsn;  // attribute

    public Item_already_subscribed_list_request() {
    }

    public Item_already_subscribed_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_address_identifier customer_address_identifier,
           Think.XmlWebServices.Order_data order_data,
           Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list,
           Think.XmlWebServices.Order_item[] items_in_progress,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.customer_address_identifier = customer_address_identifier;
           this.order_data = order_data;
           this.pkg_mbr_disambiguation_list = pkg_mbr_disambiguation_list;
           this.items_in_progress = items_in_progress;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Item_already_subscribed_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Item_already_subscribed_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_address_identifier value for this Item_already_subscribed_list_request.
     * 
     * @return customer_address_identifier
     */
    public Think.XmlWebServices.Customer_address_identifier getCustomer_address_identifier() {
        return customer_address_identifier;
    }


    /**
     * Sets the customer_address_identifier value for this Item_already_subscribed_list_request.
     * 
     * @param customer_address_identifier
     */
    public void setCustomer_address_identifier(Think.XmlWebServices.Customer_address_identifier customer_address_identifier) {
        this.customer_address_identifier = customer_address_identifier;
    }


    /**
     * Gets the order_data value for this Item_already_subscribed_list_request.
     * 
     * @return order_data
     */
    public Think.XmlWebServices.Order_data getOrder_data() {
        return order_data;
    }


    /**
     * Sets the order_data value for this Item_already_subscribed_list_request.
     * 
     * @param order_data
     */
    public void setOrder_data(Think.XmlWebServices.Order_data order_data) {
        this.order_data = order_data;
    }


    /**
     * Gets the pkg_mbr_disambiguation_list value for this Item_already_subscribed_list_request.
     * 
     * @return pkg_mbr_disambiguation_list
     */
    public Think.XmlWebServices.Pkg_mbr_disambiguation_data[] getPkg_mbr_disambiguation_list() {
        return pkg_mbr_disambiguation_list;
    }


    /**
     * Sets the pkg_mbr_disambiguation_list value for this Item_already_subscribed_list_request.
     * 
     * @param pkg_mbr_disambiguation_list
     */
    public void setPkg_mbr_disambiguation_list(Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list) {
        this.pkg_mbr_disambiguation_list = pkg_mbr_disambiguation_list;
    }


    /**
     * Gets the items_in_progress value for this Item_already_subscribed_list_request.
     * 
     * @return items_in_progress
     */
    public Think.XmlWebServices.Order_item[] getItems_in_progress() {
        return items_in_progress;
    }


    /**
     * Sets the items_in_progress value for this Item_already_subscribed_list_request.
     * 
     * @param items_in_progress
     */
    public void setItems_in_progress(Think.XmlWebServices.Order_item[] items_in_progress) {
        this.items_in_progress = items_in_progress;
    }


    /**
     * Gets the dsn value for this Item_already_subscribed_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Item_already_subscribed_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_already_subscribed_list_request)) return false;
        Item_already_subscribed_list_request other = (Item_already_subscribed_list_request) obj;
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
            ((this.pkg_mbr_disambiguation_list==null && other.getPkg_mbr_disambiguation_list()==null) || 
             (this.pkg_mbr_disambiguation_list!=null &&
              java.util.Arrays.equals(this.pkg_mbr_disambiguation_list, other.getPkg_mbr_disambiguation_list()))) &&
            ((this.items_in_progress==null && other.getItems_in_progress()==null) || 
             (this.items_in_progress!=null &&
              java.util.Arrays.equals(this.items_in_progress, other.getItems_in_progress()))) &&
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
        if (getCustomer_address_identifier() != null) {
            _hashCode += getCustomer_address_identifier().hashCode();
        }
        if (getOrder_data() != null) {
            _hashCode += getOrder_data().hashCode();
        }
        if (getPkg_mbr_disambiguation_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPkg_mbr_disambiguation_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPkg_mbr_disambiguation_list(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_already_subscribed_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_already_subscribed_list_request"));
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
        elemField.setFieldName("pkg_mbr_disambiguation_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_mbr_disambiguation_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">pkg_mbr_disambiguation_list"));
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
