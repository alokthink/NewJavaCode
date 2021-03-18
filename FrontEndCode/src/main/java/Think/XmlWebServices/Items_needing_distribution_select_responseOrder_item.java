/**
 * Items_needing_distribution_select_responseOrder_item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Items_needing_distribution_select_responseOrder_item  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int customer_id;  // attribute

    private int customer_address_seq;  // attribute

    private java.lang.String distribution_method;  // attribute

    public Items_needing_distribution_select_responseOrder_item() {
    }

    public Items_needing_distribution_select_responseOrder_item(
           int orderhdr_id,
           int order_item_seq,
           int customer_id,
           int customer_address_seq,
           java.lang.String distribution_method) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.customer_id = customer_id;
           this.customer_address_seq = customer_address_seq;
           this.distribution_method = distribution_method;
    }


    /**
     * Gets the orderhdr_id value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the customer_id value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_address_seq value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the distribution_method value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @return distribution_method
     */
    public java.lang.String getDistribution_method() {
        return distribution_method;
    }


    /**
     * Sets the distribution_method value for this Items_needing_distribution_select_responseOrder_item.
     * 
     * @param distribution_method
     */
    public void setDistribution_method(java.lang.String distribution_method) {
        this.distribution_method = distribution_method;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Items_needing_distribution_select_responseOrder_item)) return false;
        Items_needing_distribution_select_responseOrder_item other = (Items_needing_distribution_select_responseOrder_item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.customer_id == other.getCustomer_id() &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            ((this.distribution_method==null && other.getDistribution_method()==null) || 
             (this.distribution_method!=null &&
              this.distribution_method.equals(other.getDistribution_method())));
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
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getCustomer_id();
        _hashCode += getCustomer_address_seq();
        if (getDistribution_method() != null) {
            _hashCode += getDistribution_method().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Items_needing_distribution_select_responseOrder_item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>items_needing_distribution_select_response>order_item"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("distribution_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "distribution_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
