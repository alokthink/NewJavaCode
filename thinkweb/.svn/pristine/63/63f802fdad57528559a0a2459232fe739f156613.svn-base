/**
 * Customer_orders_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_orders_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZOrderItem[] order_item;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private int srch_subscrip_id;  // attribute

    private int srch_orderhdr_id;  // attribute

    private int srch_order_item_seq;  // attribute

    public Customer_orders_list_response() {
    }

    public Customer_orders_list_response(
           Think.XmlWebServices.ZZOrderItem[] order_item,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           int srch_subscrip_id,
           int srch_orderhdr_id,
           int srch_order_item_seq) {
           this.order_item = order_item;
           this.customer_identifier = customer_identifier;
           this.srch_subscrip_id = srch_subscrip_id;
           this.srch_orderhdr_id = srch_orderhdr_id;
           this.srch_order_item_seq = srch_order_item_seq;
    }


    /**
     * Gets the order_item value for this Customer_orders_list_response.
     * 
     * @return order_item
     */
    public Think.XmlWebServices.ZZOrderItem[] getOrder_item() {
        return order_item;
    }


    /**
     * Sets the order_item value for this Customer_orders_list_response.
     * 
     * @param order_item
     */
    public void setOrder_item(Think.XmlWebServices.ZZOrderItem[] order_item) {
        this.order_item = order_item;
    }

    public Think.XmlWebServices.ZZOrderItem getOrder_item(int i) {
        return this.order_item[i];
    }

    public void setOrder_item(int i, Think.XmlWebServices.ZZOrderItem _value) {
        this.order_item[i] = _value;
    }


    /**
     * Gets the customer_identifier value for this Customer_orders_list_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Customer_orders_list_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the srch_subscrip_id value for this Customer_orders_list_response.
     * 
     * @return srch_subscrip_id
     */
    public int getSrch_subscrip_id() {
        return srch_subscrip_id;
    }


    /**
     * Sets the srch_subscrip_id value for this Customer_orders_list_response.
     * 
     * @param srch_subscrip_id
     */
    public void setSrch_subscrip_id(int srch_subscrip_id) {
        this.srch_subscrip_id = srch_subscrip_id;
    }


    /**
     * Gets the srch_orderhdr_id value for this Customer_orders_list_response.
     * 
     * @return srch_orderhdr_id
     */
    public int getSrch_orderhdr_id() {
        return srch_orderhdr_id;
    }


    /**
     * Sets the srch_orderhdr_id value for this Customer_orders_list_response.
     * 
     * @param srch_orderhdr_id
     */
    public void setSrch_orderhdr_id(int srch_orderhdr_id) {
        this.srch_orderhdr_id = srch_orderhdr_id;
    }


    /**
     * Gets the srch_order_item_seq value for this Customer_orders_list_response.
     * 
     * @return srch_order_item_seq
     */
    public int getSrch_order_item_seq() {
        return srch_order_item_seq;
    }


    /**
     * Sets the srch_order_item_seq value for this Customer_orders_list_response.
     * 
     * @param srch_order_item_seq
     */
    public void setSrch_order_item_seq(int srch_order_item_seq) {
        this.srch_order_item_seq = srch_order_item_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_orders_list_response)) return false;
        Customer_orders_list_response other = (Customer_orders_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_item==null && other.getOrder_item()==null) || 
             (this.order_item!=null &&
              java.util.Arrays.equals(this.order_item, other.getOrder_item()))) &&
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            this.srch_subscrip_id == other.getSrch_subscrip_id() &&
            this.srch_orderhdr_id == other.getSrch_orderhdr_id() &&
            this.srch_order_item_seq == other.getSrch_order_item_seq();
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
        if (getOrder_item() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        _hashCode += getSrch_subscrip_id();
        _hashCode += getSrch_orderhdr_id();
        _hashCode += getSrch_order_item_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_orders_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_orders_list_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("srch_subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "srch_subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("srch_orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "srch_orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("srch_order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "srch_order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
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
