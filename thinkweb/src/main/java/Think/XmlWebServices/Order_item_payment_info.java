/**
 * Order_item_payment_info.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_payment_info  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private java.lang.String order_currency;  // attribute

    private java.math.BigDecimal net_local_amount;  // attribute

    private java.math.BigDecimal net_base_amount;  // attribute

    private java.util.Calendar order_date;  // attribute

    private java.lang.String oc_description;  // attribute

    private java.lang.String order_description;  // attribute

    private int customer_id;  // attribute

    private java.lang.String payment_type;  // attribute

    private java.lang.String pay_currency;  // attribute

    private java.math.BigDecimal pay_currency_amount;  // attribute

    private java.math.BigDecimal pay_base_amount;  // attribute

    private java.util.Date payment_date;  // attribute

    private int order_item_type;  // attribute

    private int product_id;  // attribute

    private int subscription_def_id;  // attribute

    private int start_issue_id;  // attribute

    private int oc_id;  // attribute

    public Order_item_payment_info() {
    }

    public Order_item_payment_info(
           int orderhdr_id,
           int order_item_seq,
           java.lang.String order_currency,
           java.math.BigDecimal net_local_amount,
           java.math.BigDecimal net_base_amount,
           java.util.Calendar order_date,
           java.lang.String oc_description,
           java.lang.String order_description,
           int customer_id,
           java.lang.String payment_type,
           java.lang.String pay_currency,
           java.math.BigDecimal pay_currency_amount,
           java.math.BigDecimal pay_base_amount,
           java.util.Date payment_date,
           int order_item_type,
           int product_id,
           int subscription_def_id,
           int start_issue_id,
           int oc_id) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.order_currency = order_currency;
           this.net_local_amount = net_local_amount;
           this.net_base_amount = net_base_amount;
           this.order_date = order_date;
           this.oc_description = oc_description;
           this.order_description = order_description;
           this.customer_id = customer_id;
           this.payment_type = payment_type;
           this.pay_currency = pay_currency;
           this.pay_currency_amount = pay_currency_amount;
           this.pay_base_amount = pay_base_amount;
           this.payment_date = payment_date;
           this.order_item_type = order_item_type;
           this.product_id = product_id;
           this.subscription_def_id = subscription_def_id;
           this.start_issue_id = start_issue_id;
           this.oc_id = oc_id;
    }


    /**
     * Gets the orderhdr_id value for this Order_item_payment_info.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Order_item_payment_info.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Order_item_payment_info.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Order_item_payment_info.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the order_currency value for this Order_item_payment_info.
     * 
     * @return order_currency
     */
    public java.lang.String getOrder_currency() {
        return order_currency;
    }


    /**
     * Sets the order_currency value for this Order_item_payment_info.
     * 
     * @param order_currency
     */
    public void setOrder_currency(java.lang.String order_currency) {
        this.order_currency = order_currency;
    }


    /**
     * Gets the net_local_amount value for this Order_item_payment_info.
     * 
     * @return net_local_amount
     */
    public java.math.BigDecimal getNet_local_amount() {
        return net_local_amount;
    }


    /**
     * Sets the net_local_amount value for this Order_item_payment_info.
     * 
     * @param net_local_amount
     */
    public void setNet_local_amount(java.math.BigDecimal net_local_amount) {
        this.net_local_amount = net_local_amount;
    }


    /**
     * Gets the net_base_amount value for this Order_item_payment_info.
     * 
     * @return net_base_amount
     */
    public java.math.BigDecimal getNet_base_amount() {
        return net_base_amount;
    }


    /**
     * Sets the net_base_amount value for this Order_item_payment_info.
     * 
     * @param net_base_amount
     */
    public void setNet_base_amount(java.math.BigDecimal net_base_amount) {
        this.net_base_amount = net_base_amount;
    }


    /**
     * Gets the order_date value for this Order_item_payment_info.
     * 
     * @return order_date
     */
    public java.util.Calendar getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this Order_item_payment_info.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Calendar order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the oc_description value for this Order_item_payment_info.
     * 
     * @return oc_description
     */
    public java.lang.String getOc_description() {
        return oc_description;
    }


    /**
     * Sets the oc_description value for this Order_item_payment_info.
     * 
     * @param oc_description
     */
    public void setOc_description(java.lang.String oc_description) {
        this.oc_description = oc_description;
    }


    /**
     * Gets the order_description value for this Order_item_payment_info.
     * 
     * @return order_description
     */
    public java.lang.String getOrder_description() {
        return order_description;
    }


    /**
     * Sets the order_description value for this Order_item_payment_info.
     * 
     * @param order_description
     */
    public void setOrder_description(java.lang.String order_description) {
        this.order_description = order_description;
    }


    /**
     * Gets the customer_id value for this Order_item_payment_info.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Order_item_payment_info.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the payment_type value for this Order_item_payment_info.
     * 
     * @return payment_type
     */
    public java.lang.String getPayment_type() {
        return payment_type;
    }


    /**
     * Sets the payment_type value for this Order_item_payment_info.
     * 
     * @param payment_type
     */
    public void setPayment_type(java.lang.String payment_type) {
        this.payment_type = payment_type;
    }


    /**
     * Gets the pay_currency value for this Order_item_payment_info.
     * 
     * @return pay_currency
     */
    public java.lang.String getPay_currency() {
        return pay_currency;
    }


    /**
     * Sets the pay_currency value for this Order_item_payment_info.
     * 
     * @param pay_currency
     */
    public void setPay_currency(java.lang.String pay_currency) {
        this.pay_currency = pay_currency;
    }


    /**
     * Gets the pay_currency_amount value for this Order_item_payment_info.
     * 
     * @return pay_currency_amount
     */
    public java.math.BigDecimal getPay_currency_amount() {
        return pay_currency_amount;
    }


    /**
     * Sets the pay_currency_amount value for this Order_item_payment_info.
     * 
     * @param pay_currency_amount
     */
    public void setPay_currency_amount(java.math.BigDecimal pay_currency_amount) {
        this.pay_currency_amount = pay_currency_amount;
    }


    /**
     * Gets the pay_base_amount value for this Order_item_payment_info.
     * 
     * @return pay_base_amount
     */
    public java.math.BigDecimal getPay_base_amount() {
        return pay_base_amount;
    }


    /**
     * Sets the pay_base_amount value for this Order_item_payment_info.
     * 
     * @param pay_base_amount
     */
    public void setPay_base_amount(java.math.BigDecimal pay_base_amount) {
        this.pay_base_amount = pay_base_amount;
    }


    /**
     * Gets the payment_date value for this Order_item_payment_info.
     * 
     * @return payment_date
     */
    public java.util.Date getPayment_date() {
        return payment_date;
    }


    /**
     * Sets the payment_date value for this Order_item_payment_info.
     * 
     * @param payment_date
     */
    public void setPayment_date(java.util.Date payment_date) {
        this.payment_date = payment_date;
    }


    /**
     * Gets the order_item_type value for this Order_item_payment_info.
     * 
     * @return order_item_type
     */
    public int getOrder_item_type() {
        return order_item_type;
    }


    /**
     * Sets the order_item_type value for this Order_item_payment_info.
     * 
     * @param order_item_type
     */
    public void setOrder_item_type(int order_item_type) {
        this.order_item_type = order_item_type;
    }


    /**
     * Gets the product_id value for this Order_item_payment_info.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Order_item_payment_info.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the subscription_def_id value for this Order_item_payment_info.
     * 
     * @return subscription_def_id
     */
    public int getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Order_item_payment_info.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(int subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the start_issue_id value for this Order_item_payment_info.
     * 
     * @return start_issue_id
     */
    public int getStart_issue_id() {
        return start_issue_id;
    }


    /**
     * Sets the start_issue_id value for this Order_item_payment_info.
     * 
     * @param start_issue_id
     */
    public void setStart_issue_id(int start_issue_id) {
        this.start_issue_id = start_issue_id;
    }


    /**
     * Gets the oc_id value for this Order_item_payment_info.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Order_item_payment_info.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_payment_info)) return false;
        Order_item_payment_info other = (Order_item_payment_info) obj;
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
            ((this.order_currency==null && other.getOrder_currency()==null) || 
             (this.order_currency!=null &&
              this.order_currency.equals(other.getOrder_currency()))) &&
            ((this.net_local_amount==null && other.getNet_local_amount()==null) || 
             (this.net_local_amount!=null &&
              this.net_local_amount.equals(other.getNet_local_amount()))) &&
            ((this.net_base_amount==null && other.getNet_base_amount()==null) || 
             (this.net_base_amount!=null &&
              this.net_base_amount.equals(other.getNet_base_amount()))) &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            ((this.oc_description==null && other.getOc_description()==null) || 
             (this.oc_description!=null &&
              this.oc_description.equals(other.getOc_description()))) &&
            ((this.order_description==null && other.getOrder_description()==null) || 
             (this.order_description!=null &&
              this.order_description.equals(other.getOrder_description()))) &&
            this.customer_id == other.getCustomer_id() &&
            ((this.payment_type==null && other.getPayment_type()==null) || 
             (this.payment_type!=null &&
              this.payment_type.equals(other.getPayment_type()))) &&
            ((this.pay_currency==null && other.getPay_currency()==null) || 
             (this.pay_currency!=null &&
              this.pay_currency.equals(other.getPay_currency()))) &&
            ((this.pay_currency_amount==null && other.getPay_currency_amount()==null) || 
             (this.pay_currency_amount!=null &&
              this.pay_currency_amount.equals(other.getPay_currency_amount()))) &&
            ((this.pay_base_amount==null && other.getPay_base_amount()==null) || 
             (this.pay_base_amount!=null &&
              this.pay_base_amount.equals(other.getPay_base_amount()))) &&
            ((this.payment_date==null && other.getPayment_date()==null) || 
             (this.payment_date!=null &&
              this.payment_date.equals(other.getPayment_date()))) &&
            this.order_item_type == other.getOrder_item_type() &&
            this.product_id == other.getProduct_id() &&
            this.subscription_def_id == other.getSubscription_def_id() &&
            this.start_issue_id == other.getStart_issue_id() &&
            this.oc_id == other.getOc_id();
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
        if (getOrder_currency() != null) {
            _hashCode += getOrder_currency().hashCode();
        }
        if (getNet_local_amount() != null) {
            _hashCode += getNet_local_amount().hashCode();
        }
        if (getNet_base_amount() != null) {
            _hashCode += getNet_base_amount().hashCode();
        }
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        if (getOc_description() != null) {
            _hashCode += getOc_description().hashCode();
        }
        if (getOrder_description() != null) {
            _hashCode += getOrder_description().hashCode();
        }
        _hashCode += getCustomer_id();
        if (getPayment_type() != null) {
            _hashCode += getPayment_type().hashCode();
        }
        if (getPay_currency() != null) {
            _hashCode += getPay_currency().hashCode();
        }
        if (getPay_currency_amount() != null) {
            _hashCode += getPay_currency_amount().hashCode();
        }
        if (getPay_base_amount() != null) {
            _hashCode += getPay_base_amount().hashCode();
        }
        if (getPayment_date() != null) {
            _hashCode += getPayment_date().hashCode();
        }
        _hashCode += getOrder_item_type();
        _hashCode += getProduct_id();
        _hashCode += getSubscription_def_id();
        _hashCode += getStart_issue_id();
        _hashCode += getOc_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_payment_info.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_payment_info"));
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
        attrField.setFieldName("order_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("net_local_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "net_local_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("net_base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "net_base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_currency_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_currency_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pay_base_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pay_base_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscription_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscription_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
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
