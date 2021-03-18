/**
 * ZZPkgContent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZPkgContent  implements java.io.Serializable {
    private int order_code_id;  // attribute

    private int pkg_content_seq;  // attribute

    private java.lang.String description;  // attribute

    private int item_order_code_id;  // attribute

    private int one_time_only;  // attribute

    private int prepayment_option;  // attribute

    private int qty;  // attribute

    private int required;  // attribute

    public ZZPkgContent() {
    }

    public ZZPkgContent(
           int order_code_id,
           int pkg_content_seq,
           java.lang.String description,
           int item_order_code_id,
           int one_time_only,
           int prepayment_option,
           int qty,
           int required) {
           this.order_code_id = order_code_id;
           this.pkg_content_seq = pkg_content_seq;
           this.description = description;
           this.item_order_code_id = item_order_code_id;
           this.one_time_only = one_time_only;
           this.prepayment_option = prepayment_option;
           this.qty = qty;
           this.required = required;
    }


    /**
     * Gets the order_code_id value for this ZZPkgContent.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this ZZPkgContent.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the pkg_content_seq value for this ZZPkgContent.
     * 
     * @return pkg_content_seq
     */
    public int getPkg_content_seq() {
        return pkg_content_seq;
    }


    /**
     * Sets the pkg_content_seq value for this ZZPkgContent.
     * 
     * @param pkg_content_seq
     */
    public void setPkg_content_seq(int pkg_content_seq) {
        this.pkg_content_seq = pkg_content_seq;
    }


    /**
     * Gets the description value for this ZZPkgContent.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZPkgContent.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the item_order_code_id value for this ZZPkgContent.
     * 
     * @return item_order_code_id
     */
    public int getItem_order_code_id() {
        return item_order_code_id;
    }


    /**
     * Sets the item_order_code_id value for this ZZPkgContent.
     * 
     * @param item_order_code_id
     */
    public void setItem_order_code_id(int item_order_code_id) {
        this.item_order_code_id = item_order_code_id;
    }


    /**
     * Gets the one_time_only value for this ZZPkgContent.
     * 
     * @return one_time_only
     */
    public int getOne_time_only() {
        return one_time_only;
    }


    /**
     * Sets the one_time_only value for this ZZPkgContent.
     * 
     * @param one_time_only
     */
    public void setOne_time_only(int one_time_only) {
        this.one_time_only = one_time_only;
    }


    /**
     * Gets the prepayment_option value for this ZZPkgContent.
     * 
     * @return prepayment_option
     */
    public int getPrepayment_option() {
        return prepayment_option;
    }


    /**
     * Sets the prepayment_option value for this ZZPkgContent.
     * 
     * @param prepayment_option
     */
    public void setPrepayment_option(int prepayment_option) {
        this.prepayment_option = prepayment_option;
    }


    /**
     * Gets the qty value for this ZZPkgContent.
     * 
     * @return qty
     */
    public int getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this ZZPkgContent.
     * 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    /**
     * Gets the required value for this ZZPkgContent.
     * 
     * @return required
     */
    public int getRequired() {
        return required;
    }


    /**
     * Sets the required value for this ZZPkgContent.
     * 
     * @param required
     */
    public void setRequired(int required) {
        this.required = required;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZPkgContent)) return false;
        ZZPkgContent other = (ZZPkgContent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.order_code_id == other.getOrder_code_id() &&
            this.pkg_content_seq == other.getPkg_content_seq() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.item_order_code_id == other.getItem_order_code_id() &&
            this.one_time_only == other.getOne_time_only() &&
            this.prepayment_option == other.getPrepayment_option() &&
            this.qty == other.getQty() &&
            this.required == other.getRequired();
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
        _hashCode += getOrder_code_id();
        _hashCode += getPkg_content_seq();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getItem_order_code_id();
        _hashCode += getOne_time_only();
        _hashCode += getPrepayment_option();
        _hashCode += getQty();
        _hashCode += getRequired();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZPkgContent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZPkgContent"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_content_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_content_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("one_time_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "one_time_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prepayment_option");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prepayment_option"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "required"));
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
