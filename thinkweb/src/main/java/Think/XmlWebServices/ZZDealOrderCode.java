/**
 * ZZDealOrderCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZDealOrderCode  implements java.io.Serializable {
    private int deal_id;  // attribute

    private int order_code_id;  // attribute

    private int deal_order_code_type;  // attribute

    private int source_code_id;  // attribute

    public ZZDealOrderCode() {
    }

    public ZZDealOrderCode(
           int deal_id,
           int order_code_id,
           int deal_order_code_type,
           int source_code_id) {
           this.deal_id = deal_id;
           this.order_code_id = order_code_id;
           this.deal_order_code_type = deal_order_code_type;
           this.source_code_id = source_code_id;
    }


    /**
     * Gets the deal_id value for this ZZDealOrderCode.
     * 
     * @return deal_id
     */
    public int getDeal_id() {
        return deal_id;
    }


    /**
     * Sets the deal_id value for this ZZDealOrderCode.
     * 
     * @param deal_id
     */
    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }


    /**
     * Gets the order_code_id value for this ZZDealOrderCode.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this ZZDealOrderCode.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the deal_order_code_type value for this ZZDealOrderCode.
     * 
     * @return deal_order_code_type
     */
    public int getDeal_order_code_type() {
        return deal_order_code_type;
    }


    /**
     * Sets the deal_order_code_type value for this ZZDealOrderCode.
     * 
     * @param deal_order_code_type
     */
    public void setDeal_order_code_type(int deal_order_code_type) {
        this.deal_order_code_type = deal_order_code_type;
    }


    /**
     * Gets the source_code_id value for this ZZDealOrderCode.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this ZZDealOrderCode.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZDealOrderCode)) return false;
        ZZDealOrderCode other = (ZZDealOrderCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.deal_id == other.getDeal_id() &&
            this.order_code_id == other.getOrder_code_id() &&
            this.deal_order_code_type == other.getDeal_order_code_type() &&
            this.source_code_id == other.getSource_code_id();
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
        _hashCode += getDeal_id();
        _hashCode += getOrder_code_id();
        _hashCode += getDeal_order_code_type();
        _hashCode += getSource_code_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZDealOrderCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZDealOrderCode"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deal_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deal_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deal_order_code_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deal_order_code_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
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
