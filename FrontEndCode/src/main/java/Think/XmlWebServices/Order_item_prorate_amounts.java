/**
 * Order_item_prorate_amounts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_prorate_amounts  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int subscrip_id;  // attribute

    private java.lang.String currency;  // attribute

    private int from_order_qty;  // attribute

    private int to_order_qty;  // attribute

    private int remaining_items;  // attribute

    private java.math.BigDecimal from_rate;  // attribute

    private java.math.BigDecimal to_rate;  // attribute

    private int from_bundle_qty;  // attribute

    private int to_bundle_qty;  // attribute

    private java.math.BigDecimal from_order_amount;  // attribute

    private java.math.BigDecimal full_order_amount;  // attribute

    private java.math.BigDecimal prorated_order_amount;  // attribute

    private java.math.BigDecimal price_change;  // attribute

    public Order_item_prorate_amounts() {
    }

    public Order_item_prorate_amounts(
           int orderhdr_id,
           int order_item_seq,
           int subscrip_id,
           java.lang.String currency,
           int from_order_qty,
           int to_order_qty,
           int remaining_items,
           java.math.BigDecimal from_rate,
           java.math.BigDecimal to_rate,
           int from_bundle_qty,
           int to_bundle_qty,
           java.math.BigDecimal from_order_amount,
           java.math.BigDecimal full_order_amount,
           java.math.BigDecimal prorated_order_amount,
           java.math.BigDecimal price_change) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.subscrip_id = subscrip_id;
           this.currency = currency;
           this.from_order_qty = from_order_qty;
           this.to_order_qty = to_order_qty;
           this.remaining_items = remaining_items;
           this.from_rate = from_rate;
           this.to_rate = to_rate;
           this.from_bundle_qty = from_bundle_qty;
           this.to_bundle_qty = to_bundle_qty;
           this.from_order_amount = from_order_amount;
           this.full_order_amount = full_order_amount;
           this.prorated_order_amount = prorated_order_amount;
           this.price_change = price_change;
    }


    /**
     * Gets the orderhdr_id value for this Order_item_prorate_amounts.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Order_item_prorate_amounts.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Order_item_prorate_amounts.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Order_item_prorate_amounts.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the subscrip_id value for this Order_item_prorate_amounts.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Order_item_prorate_amounts.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the currency value for this Order_item_prorate_amounts.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Order_item_prorate_amounts.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the from_order_qty value for this Order_item_prorate_amounts.
     * 
     * @return from_order_qty
     */
    public int getFrom_order_qty() {
        return from_order_qty;
    }


    /**
     * Sets the from_order_qty value for this Order_item_prorate_amounts.
     * 
     * @param from_order_qty
     */
    public void setFrom_order_qty(int from_order_qty) {
        this.from_order_qty = from_order_qty;
    }


    /**
     * Gets the to_order_qty value for this Order_item_prorate_amounts.
     * 
     * @return to_order_qty
     */
    public int getTo_order_qty() {
        return to_order_qty;
    }


    /**
     * Sets the to_order_qty value for this Order_item_prorate_amounts.
     * 
     * @param to_order_qty
     */
    public void setTo_order_qty(int to_order_qty) {
        this.to_order_qty = to_order_qty;
    }


    /**
     * Gets the remaining_items value for this Order_item_prorate_amounts.
     * 
     * @return remaining_items
     */
    public int getRemaining_items() {
        return remaining_items;
    }


    /**
     * Sets the remaining_items value for this Order_item_prorate_amounts.
     * 
     * @param remaining_items
     */
    public void setRemaining_items(int remaining_items) {
        this.remaining_items = remaining_items;
    }


    /**
     * Gets the from_rate value for this Order_item_prorate_amounts.
     * 
     * @return from_rate
     */
    public java.math.BigDecimal getFrom_rate() {
        return from_rate;
    }


    /**
     * Sets the from_rate value for this Order_item_prorate_amounts.
     * 
     * @param from_rate
     */
    public void setFrom_rate(java.math.BigDecimal from_rate) {
        this.from_rate = from_rate;
    }


    /**
     * Gets the to_rate value for this Order_item_prorate_amounts.
     * 
     * @return to_rate
     */
    public java.math.BigDecimal getTo_rate() {
        return to_rate;
    }


    /**
     * Sets the to_rate value for this Order_item_prorate_amounts.
     * 
     * @param to_rate
     */
    public void setTo_rate(java.math.BigDecimal to_rate) {
        this.to_rate = to_rate;
    }


    /**
     * Gets the from_bundle_qty value for this Order_item_prorate_amounts.
     * 
     * @return from_bundle_qty
     */
    public int getFrom_bundle_qty() {
        return from_bundle_qty;
    }


    /**
     * Sets the from_bundle_qty value for this Order_item_prorate_amounts.
     * 
     * @param from_bundle_qty
     */
    public void setFrom_bundle_qty(int from_bundle_qty) {
        this.from_bundle_qty = from_bundle_qty;
    }


    /**
     * Gets the to_bundle_qty value for this Order_item_prorate_amounts.
     * 
     * @return to_bundle_qty
     */
    public int getTo_bundle_qty() {
        return to_bundle_qty;
    }


    /**
     * Sets the to_bundle_qty value for this Order_item_prorate_amounts.
     * 
     * @param to_bundle_qty
     */
    public void setTo_bundle_qty(int to_bundle_qty) {
        this.to_bundle_qty = to_bundle_qty;
    }


    /**
     * Gets the from_order_amount value for this Order_item_prorate_amounts.
     * 
     * @return from_order_amount
     */
    public java.math.BigDecimal getFrom_order_amount() {
        return from_order_amount;
    }


    /**
     * Sets the from_order_amount value for this Order_item_prorate_amounts.
     * 
     * @param from_order_amount
     */
    public void setFrom_order_amount(java.math.BigDecimal from_order_amount) {
        this.from_order_amount = from_order_amount;
    }


    /**
     * Gets the full_order_amount value for this Order_item_prorate_amounts.
     * 
     * @return full_order_amount
     */
    public java.math.BigDecimal getFull_order_amount() {
        return full_order_amount;
    }


    /**
     * Sets the full_order_amount value for this Order_item_prorate_amounts.
     * 
     * @param full_order_amount
     */
    public void setFull_order_amount(java.math.BigDecimal full_order_amount) {
        this.full_order_amount = full_order_amount;
    }


    /**
     * Gets the prorated_order_amount value for this Order_item_prorate_amounts.
     * 
     * @return prorated_order_amount
     */
    public java.math.BigDecimal getProrated_order_amount() {
        return prorated_order_amount;
    }


    /**
     * Sets the prorated_order_amount value for this Order_item_prorate_amounts.
     * 
     * @param prorated_order_amount
     */
    public void setProrated_order_amount(java.math.BigDecimal prorated_order_amount) {
        this.prorated_order_amount = prorated_order_amount;
    }


    /**
     * Gets the price_change value for this Order_item_prorate_amounts.
     * 
     * @return price_change
     */
    public java.math.BigDecimal getPrice_change() {
        return price_change;
    }


    /**
     * Sets the price_change value for this Order_item_prorate_amounts.
     * 
     * @param price_change
     */
    public void setPrice_change(java.math.BigDecimal price_change) {
        this.price_change = price_change;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_prorate_amounts)) return false;
        Order_item_prorate_amounts other = (Order_item_prorate_amounts) obj;
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
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            this.from_order_qty == other.getFrom_order_qty() &&
            this.to_order_qty == other.getTo_order_qty() &&
            this.remaining_items == other.getRemaining_items() &&
            ((this.from_rate==null && other.getFrom_rate()==null) || 
             (this.from_rate!=null &&
              this.from_rate.equals(other.getFrom_rate()))) &&
            ((this.to_rate==null && other.getTo_rate()==null) || 
             (this.to_rate!=null &&
              this.to_rate.equals(other.getTo_rate()))) &&
            this.from_bundle_qty == other.getFrom_bundle_qty() &&
            this.to_bundle_qty == other.getTo_bundle_qty() &&
            ((this.from_order_amount==null && other.getFrom_order_amount()==null) || 
             (this.from_order_amount!=null &&
              this.from_order_amount.equals(other.getFrom_order_amount()))) &&
            ((this.full_order_amount==null && other.getFull_order_amount()==null) || 
             (this.full_order_amount!=null &&
              this.full_order_amount.equals(other.getFull_order_amount()))) &&
            ((this.prorated_order_amount==null && other.getProrated_order_amount()==null) || 
             (this.prorated_order_amount!=null &&
              this.prorated_order_amount.equals(other.getProrated_order_amount()))) &&
            ((this.price_change==null && other.getPrice_change()==null) || 
             (this.price_change!=null &&
              this.price_change.equals(other.getPrice_change())));
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
        _hashCode += getSubscrip_id();
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        _hashCode += getFrom_order_qty();
        _hashCode += getTo_order_qty();
        _hashCode += getRemaining_items();
        if (getFrom_rate() != null) {
            _hashCode += getFrom_rate().hashCode();
        }
        if (getTo_rate() != null) {
            _hashCode += getTo_rate().hashCode();
        }
        _hashCode += getFrom_bundle_qty();
        _hashCode += getTo_bundle_qty();
        if (getFrom_order_amount() != null) {
            _hashCode += getFrom_order_amount().hashCode();
        }
        if (getFull_order_amount() != null) {
            _hashCode += getFull_order_amount().hashCode();
        }
        if (getProrated_order_amount() != null) {
            _hashCode += getProrated_order_amount().hashCode();
        }
        if (getPrice_change() != null) {
            _hashCode += getPrice_change().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_prorate_amounts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_prorate_amounts"));
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
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_order_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_order_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_order_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_order_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("remaining_items");
        attrField.setXmlName(new javax.xml.namespace.QName("", "remaining_items"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_bundle_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_bundle_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_order_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_order_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("full_order_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "full_order_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prorated_order_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prorated_order_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price_change"));
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
