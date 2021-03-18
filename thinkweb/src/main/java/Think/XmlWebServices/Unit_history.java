/**
 * Unit_history.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Unit_history  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int unit_history_seq;  // attribute

    private int quantity;  // attribute

    private int unit_usage;  // attribute

    private java.lang.String unit_description;  // attribute

    private int subscrip_id;  // attribute

    public Unit_history() {
    }

    public Unit_history(
           int orderhdr_id,
           int order_item_seq,
           int unit_history_seq,
           int quantity,
           int unit_usage,
           java.lang.String unit_description,
           int subscrip_id) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.unit_history_seq = unit_history_seq;
           this.quantity = quantity;
           this.unit_usage = unit_usage;
           this.unit_description = unit_description;
           this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the orderhdr_id value for this Unit_history.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Unit_history.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Unit_history.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Unit_history.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the unit_history_seq value for this Unit_history.
     * 
     * @return unit_history_seq
     */
    public int getUnit_history_seq() {
        return unit_history_seq;
    }


    /**
     * Sets the unit_history_seq value for this Unit_history.
     * 
     * @param unit_history_seq
     */
    public void setUnit_history_seq(int unit_history_seq) {
        this.unit_history_seq = unit_history_seq;
    }


    /**
     * Gets the quantity value for this Unit_history.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this Unit_history.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the unit_usage value for this Unit_history.
     * 
     * @return unit_usage
     */
    public int getUnit_usage() {
        return unit_usage;
    }


    /**
     * Sets the unit_usage value for this Unit_history.
     * 
     * @param unit_usage
     */
    public void setUnit_usage(int unit_usage) {
        this.unit_usage = unit_usage;
    }


    /**
     * Gets the unit_description value for this Unit_history.
     * 
     * @return unit_description
     */
    public java.lang.String getUnit_description() {
        return unit_description;
    }


    /**
     * Sets the unit_description value for this Unit_history.
     * 
     * @param unit_description
     */
    public void setUnit_description(java.lang.String unit_description) {
        this.unit_description = unit_description;
    }


    /**
     * Gets the subscrip_id value for this Unit_history.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Unit_history.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Unit_history)) return false;
        Unit_history other = (Unit_history) obj;
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
            this.unit_history_seq == other.getUnit_history_seq() &&
            this.quantity == other.getQuantity() &&
            this.unit_usage == other.getUnit_usage() &&
            ((this.unit_description==null && other.getUnit_description()==null) || 
             (this.unit_description!=null &&
              this.unit_description.equals(other.getUnit_description()))) &&
            this.subscrip_id == other.getSubscrip_id();
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
        _hashCode += getUnit_history_seq();
        _hashCode += getQuantity();
        _hashCode += getUnit_usage();
        if (getUnit_description() != null) {
            _hashCode += getUnit_description().hashCode();
        }
        _hashCode += getSubscrip_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Unit_history.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">unit_history"));
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
        attrField.setFieldName("unit_history_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_history_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quantity");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quantity"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_usage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_usage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
