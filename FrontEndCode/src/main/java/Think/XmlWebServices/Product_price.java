/**
 * Product_price.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Product_price  extends Think.XmlWebServices.ZZProduct  implements java.io.Serializable {
    private int cc_item_qty;  // attribute

    private java.lang.String cc_currency;  // attribute

    private java.lang.String cc_actual_currency;  // attribute

    private java.math.BigDecimal cc_item_price;  // attribute

    public Product_price() {
    }

    public Product_price(
           int product_id,
           int allow_on_internet,
           java.lang.String auxiliary_1,
           java.lang.String auxiliary_2,
           java.lang.String description,
           java.lang.String image_url,
           int inventory_id,
           java.lang.String item_url,
           int oc_id,
           int order_code_id,
           int premium_order_code_id,
           java.math.BigDecimal price,
           java.lang.String product,
           java.lang.String product_color,
           java.lang.String product_size,
           java.lang.String product_style,
           int rate_class_id,
           java.lang.String tag_line,
           java.lang.String taxonomy,
           int cc_item_qty,
           java.lang.String cc_currency,
           java.lang.String cc_actual_currency,
           java.math.BigDecimal cc_item_price) {
        super(
            product_id,
            allow_on_internet,
            auxiliary_1,
            auxiliary_2,
            description,
            image_url,
            inventory_id,
            item_url,
            oc_id,
            order_code_id,
            premium_order_code_id,
            price,
            product,
            product_color,
            product_size,
            product_style,
            rate_class_id,
            tag_line,
            taxonomy);
        this.cc_item_qty = cc_item_qty;
        this.cc_currency = cc_currency;
        this.cc_actual_currency = cc_actual_currency;
        this.cc_item_price = cc_item_price;
    }


    /**
     * Gets the cc_item_qty value for this Product_price.
     * 
     * @return cc_item_qty
     */
    public int getCc_item_qty() {
        return cc_item_qty;
    }


    /**
     * Sets the cc_item_qty value for this Product_price.
     * 
     * @param cc_item_qty
     */
    public void setCc_item_qty(int cc_item_qty) {
        this.cc_item_qty = cc_item_qty;
    }


    /**
     * Gets the cc_currency value for this Product_price.
     * 
     * @return cc_currency
     */
    public java.lang.String getCc_currency() {
        return cc_currency;
    }


    /**
     * Sets the cc_currency value for this Product_price.
     * 
     * @param cc_currency
     */
    public void setCc_currency(java.lang.String cc_currency) {
        this.cc_currency = cc_currency;
    }


    /**
     * Gets the cc_actual_currency value for this Product_price.
     * 
     * @return cc_actual_currency
     */
    public java.lang.String getCc_actual_currency() {
        return cc_actual_currency;
    }


    /**
     * Sets the cc_actual_currency value for this Product_price.
     * 
     * @param cc_actual_currency
     */
    public void setCc_actual_currency(java.lang.String cc_actual_currency) {
        this.cc_actual_currency = cc_actual_currency;
    }


    /**
     * Gets the cc_item_price value for this Product_price.
     * 
     * @return cc_item_price
     */
    public java.math.BigDecimal getCc_item_price() {
        return cc_item_price;
    }


    /**
     * Sets the cc_item_price value for this Product_price.
     * 
     * @param cc_item_price
     */
    public void setCc_item_price(java.math.BigDecimal cc_item_price) {
        this.cc_item_price = cc_item_price;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Product_price)) return false;
        Product_price other = (Product_price) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.cc_item_qty == other.getCc_item_qty() &&
            ((this.cc_currency==null && other.getCc_currency()==null) || 
             (this.cc_currency!=null &&
              this.cc_currency.equals(other.getCc_currency()))) &&
            ((this.cc_actual_currency==null && other.getCc_actual_currency()==null) || 
             (this.cc_actual_currency!=null &&
              this.cc_actual_currency.equals(other.getCc_actual_currency()))) &&
            ((this.cc_item_price==null && other.getCc_item_price()==null) || 
             (this.cc_item_price!=null &&
              this.cc_item_price.equals(other.getCc_item_price())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getCc_item_qty();
        if (getCc_currency() != null) {
            _hashCode += getCc_currency().hashCode();
        }
        if (getCc_actual_currency() != null) {
            _hashCode += getCc_actual_currency().hashCode();
        }
        if (getCc_item_price() != null) {
            _hashCode += getCc_item_price().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Product_price.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">product_price"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_item_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_item_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_actual_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_actual_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_item_price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_item_price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
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
