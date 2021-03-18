/**
 * ZZQuickOrderContent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZQuickOrderContent  implements java.io.Serializable {
    private int order_code_id;  // attribute

    private int quick_order_content_seq;  // attribute

    private java.lang.String description;  // attribute

    private int issue_id;  // attribute

    private int item_order_code_id;  // attribute

    private int pkg_def_id;  // attribute

    private int product_id;  // attribute

    private int qty;  // attribute

    private int subscription_def_id;  // attribute

    public ZZQuickOrderContent() {
    }

    public ZZQuickOrderContent(
           int order_code_id,
           int quick_order_content_seq,
           java.lang.String description,
           int issue_id,
           int item_order_code_id,
           int pkg_def_id,
           int product_id,
           int qty,
           int subscription_def_id) {
           this.order_code_id = order_code_id;
           this.quick_order_content_seq = quick_order_content_seq;
           this.description = description;
           this.issue_id = issue_id;
           this.item_order_code_id = item_order_code_id;
           this.pkg_def_id = pkg_def_id;
           this.product_id = product_id;
           this.qty = qty;
           this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the order_code_id value for this ZZQuickOrderContent.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this ZZQuickOrderContent.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the quick_order_content_seq value for this ZZQuickOrderContent.
     * 
     * @return quick_order_content_seq
     */
    public int getQuick_order_content_seq() {
        return quick_order_content_seq;
    }


    /**
     * Sets the quick_order_content_seq value for this ZZQuickOrderContent.
     * 
     * @param quick_order_content_seq
     */
    public void setQuick_order_content_seq(int quick_order_content_seq) {
        this.quick_order_content_seq = quick_order_content_seq;
    }


    /**
     * Gets the description value for this ZZQuickOrderContent.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZQuickOrderContent.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the issue_id value for this ZZQuickOrderContent.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this ZZQuickOrderContent.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the item_order_code_id value for this ZZQuickOrderContent.
     * 
     * @return item_order_code_id
     */
    public int getItem_order_code_id() {
        return item_order_code_id;
    }


    /**
     * Sets the item_order_code_id value for this ZZQuickOrderContent.
     * 
     * @param item_order_code_id
     */
    public void setItem_order_code_id(int item_order_code_id) {
        this.item_order_code_id = item_order_code_id;
    }


    /**
     * Gets the pkg_def_id value for this ZZQuickOrderContent.
     * 
     * @return pkg_def_id
     */
    public int getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this ZZQuickOrderContent.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(int pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the product_id value for this ZZQuickOrderContent.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this ZZQuickOrderContent.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the qty value for this ZZQuickOrderContent.
     * 
     * @return qty
     */
    public int getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this ZZQuickOrderContent.
     * 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    /**
     * Gets the subscription_def_id value for this ZZQuickOrderContent.
     * 
     * @return subscription_def_id
     */
    public int getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this ZZQuickOrderContent.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(int subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZQuickOrderContent)) return false;
        ZZQuickOrderContent other = (ZZQuickOrderContent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.order_code_id == other.getOrder_code_id() &&
            this.quick_order_content_seq == other.getQuick_order_content_seq() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.issue_id == other.getIssue_id() &&
            this.item_order_code_id == other.getItem_order_code_id() &&
            this.pkg_def_id == other.getPkg_def_id() &&
            this.product_id == other.getProduct_id() &&
            this.qty == other.getQty() &&
            this.subscription_def_id == other.getSubscription_def_id();
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
        _hashCode += getQuick_order_content_seq();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getIssue_id();
        _hashCode += getItem_order_code_id();
        _hashCode += getPkg_def_id();
        _hashCode += getProduct_id();
        _hashCode += getQty();
        _hashCode += getSubscription_def_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZQuickOrderContent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZQuickOrderContent"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quick_order_content_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quick_order_content_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscription_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscription_def_id"));
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
