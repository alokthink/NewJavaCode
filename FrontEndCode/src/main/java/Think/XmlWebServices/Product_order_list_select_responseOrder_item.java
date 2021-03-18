/**
 * Product_order_list_select_responseOrder_item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Product_order_list_select_responseOrder_item  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int oc_id;  // attribute

    private int source_code_id;  // attribute

    private int bundle_qty;  // attribute

    private int order_status;  // attribute

    private int order_code_id;  // attribute

    private int product_id;  // attribute

    private java.util.Calendar order_date;  // attribute

    private int order_qty;  // attribute

    private int order_item_type;  // attribute

    private int pkg_item_seq;  // attribute

    private java.lang.String item_url;  // attribute

    private java.lang.String description;  // attribute

    private java.lang.String product_color;  // attribute

    private java.lang.String product_size;  // attribute

    private java.lang.String product_style;  // attribute

    private java.lang.String image_url;  // attribute

    private java.lang.String status;  // attribute

    public Product_order_list_select_responseOrder_item() {
    }

    public Product_order_list_select_responseOrder_item(
           int orderhdr_id,
           int order_item_seq,
           int oc_id,
           int source_code_id,
           int bundle_qty,
           int order_status,
           int order_code_id,
           int product_id,
           java.util.Calendar order_date,
           int order_qty,
           int order_item_type,
           int pkg_item_seq,
           java.lang.String item_url,
           java.lang.String description,
           java.lang.String product_color,
           java.lang.String product_size,
           java.lang.String product_style,
           java.lang.String image_url,
           java.lang.String status) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.oc_id = oc_id;
           this.source_code_id = source_code_id;
           this.bundle_qty = bundle_qty;
           this.order_status = order_status;
           this.order_code_id = order_code_id;
           this.product_id = product_id;
           this.order_date = order_date;
           this.order_qty = order_qty;
           this.order_item_type = order_item_type;
           this.pkg_item_seq = pkg_item_seq;
           this.item_url = item_url;
           this.description = description;
           this.product_color = product_color;
           this.product_size = product_size;
           this.product_style = product_style;
           this.image_url = image_url;
           this.status = status;
    }


    /**
     * Gets the orderhdr_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the oc_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the source_code_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the bundle_qty value for this Product_order_list_select_responseOrder_item.
     * 
     * @return bundle_qty
     */
    public int getBundle_qty() {
        return bundle_qty;
    }


    /**
     * Sets the bundle_qty value for this Product_order_list_select_responseOrder_item.
     * 
     * @param bundle_qty
     */
    public void setBundle_qty(int bundle_qty) {
        this.bundle_qty = bundle_qty;
    }


    /**
     * Gets the order_status value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_status
     */
    public int getOrder_status() {
        return order_status;
    }


    /**
     * Sets the order_status value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_status
     */
    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }


    /**
     * Gets the order_code_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the product_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Product_order_list_select_responseOrder_item.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the order_date value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_date
     */
    public java.util.Calendar getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Calendar order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the order_qty value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_qty
     */
    public int getOrder_qty() {
        return order_qty;
    }


    /**
     * Sets the order_qty value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_qty
     */
    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }


    /**
     * Gets the order_item_type value for this Product_order_list_select_responseOrder_item.
     * 
     * @return order_item_type
     */
    public int getOrder_item_type() {
        return order_item_type;
    }


    /**
     * Sets the order_item_type value for this Product_order_list_select_responseOrder_item.
     * 
     * @param order_item_type
     */
    public void setOrder_item_type(int order_item_type) {
        this.order_item_type = order_item_type;
    }


    /**
     * Gets the pkg_item_seq value for this Product_order_list_select_responseOrder_item.
     * 
     * @return pkg_item_seq
     */
    public int getPkg_item_seq() {
        return pkg_item_seq;
    }


    /**
     * Sets the pkg_item_seq value for this Product_order_list_select_responseOrder_item.
     * 
     * @param pkg_item_seq
     */
    public void setPkg_item_seq(int pkg_item_seq) {
        this.pkg_item_seq = pkg_item_seq;
    }


    /**
     * Gets the item_url value for this Product_order_list_select_responseOrder_item.
     * 
     * @return item_url
     */
    public java.lang.String getItem_url() {
        return item_url;
    }


    /**
     * Sets the item_url value for this Product_order_list_select_responseOrder_item.
     * 
     * @param item_url
     */
    public void setItem_url(java.lang.String item_url) {
        this.item_url = item_url;
    }


    /**
     * Gets the description value for this Product_order_list_select_responseOrder_item.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Product_order_list_select_responseOrder_item.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the product_color value for this Product_order_list_select_responseOrder_item.
     * 
     * @return product_color
     */
    public java.lang.String getProduct_color() {
        return product_color;
    }


    /**
     * Sets the product_color value for this Product_order_list_select_responseOrder_item.
     * 
     * @param product_color
     */
    public void setProduct_color(java.lang.String product_color) {
        this.product_color = product_color;
    }


    /**
     * Gets the product_size value for this Product_order_list_select_responseOrder_item.
     * 
     * @return product_size
     */
    public java.lang.String getProduct_size() {
        return product_size;
    }


    /**
     * Sets the product_size value for this Product_order_list_select_responseOrder_item.
     * 
     * @param product_size
     */
    public void setProduct_size(java.lang.String product_size) {
        this.product_size = product_size;
    }


    /**
     * Gets the product_style value for this Product_order_list_select_responseOrder_item.
     * 
     * @return product_style
     */
    public java.lang.String getProduct_style() {
        return product_style;
    }


    /**
     * Sets the product_style value for this Product_order_list_select_responseOrder_item.
     * 
     * @param product_style
     */
    public void setProduct_style(java.lang.String product_style) {
        this.product_style = product_style;
    }


    /**
     * Gets the image_url value for this Product_order_list_select_responseOrder_item.
     * 
     * @return image_url
     */
    public java.lang.String getImage_url() {
        return image_url;
    }


    /**
     * Sets the image_url value for this Product_order_list_select_responseOrder_item.
     * 
     * @param image_url
     */
    public void setImage_url(java.lang.String image_url) {
        this.image_url = image_url;
    }


    /**
     * Gets the status value for this Product_order_list_select_responseOrder_item.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Product_order_list_select_responseOrder_item.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Product_order_list_select_responseOrder_item)) return false;
        Product_order_list_select_responseOrder_item other = (Product_order_list_select_responseOrder_item) obj;
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
            this.oc_id == other.getOc_id() &&
            this.source_code_id == other.getSource_code_id() &&
            this.bundle_qty == other.getBundle_qty() &&
            this.order_status == other.getOrder_status() &&
            this.order_code_id == other.getOrder_code_id() &&
            this.product_id == other.getProduct_id() &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            this.order_qty == other.getOrder_qty() &&
            this.order_item_type == other.getOrder_item_type() &&
            this.pkg_item_seq == other.getPkg_item_seq() &&
            ((this.item_url==null && other.getItem_url()==null) || 
             (this.item_url!=null &&
              this.item_url.equals(other.getItem_url()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.product_color==null && other.getProduct_color()==null) || 
             (this.product_color!=null &&
              this.product_color.equals(other.getProduct_color()))) &&
            ((this.product_size==null && other.getProduct_size()==null) || 
             (this.product_size!=null &&
              this.product_size.equals(other.getProduct_size()))) &&
            ((this.product_style==null && other.getProduct_style()==null) || 
             (this.product_style!=null &&
              this.product_style.equals(other.getProduct_style()))) &&
            ((this.image_url==null && other.getImage_url()==null) || 
             (this.image_url!=null &&
              this.image_url.equals(other.getImage_url()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        _hashCode += getOc_id();
        _hashCode += getSource_code_id();
        _hashCode += getBundle_qty();
        _hashCode += getOrder_status();
        _hashCode += getOrder_code_id();
        _hashCode += getProduct_id();
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        _hashCode += getOrder_qty();
        _hashCode += getOrder_item_type();
        _hashCode += getPkg_item_seq();
        if (getItem_url() != null) {
            _hashCode += getItem_url().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getProduct_color() != null) {
            _hashCode += getProduct_color().hashCode();
        }
        if (getProduct_size() != null) {
            _hashCode += getProduct_size().hashCode();
        }
        if (getProduct_style() != null) {
            _hashCode += getProduct_style().hashCode();
        }
        if (getImage_url() != null) {
            _hashCode += getImage_url().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Product_order_list_select_responseOrder_item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>product_order_list_select_response>order_item"));
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
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_color");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_color"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_size");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_size"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("image_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "image_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
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
