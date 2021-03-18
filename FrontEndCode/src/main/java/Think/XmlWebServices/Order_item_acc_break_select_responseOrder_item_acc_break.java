/**
 * Order_item_acc_break_select_responseOrder_item_acc_break.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_acc_break_select_responseOrder_item_acc_break  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int acc_break_type;  // attribute

    private java.math.BigDecimal ar;  // attribute

    private java.math.BigDecimal cash;  // attribute

    private java.math.BigDecimal liability;  // attribute

    private java.math.BigDecimal revenue;  // attribute

    public Order_item_acc_break_select_responseOrder_item_acc_break() {
    }

    public Order_item_acc_break_select_responseOrder_item_acc_break(
           int orderhdr_id,
           int order_item_seq,
           int acc_break_type,
           java.math.BigDecimal ar,
           java.math.BigDecimal cash,
           java.math.BigDecimal liability,
           java.math.BigDecimal revenue) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.acc_break_type = acc_break_type;
           this.ar = ar;
           this.cash = cash;
           this.liability = liability;
           this.revenue = revenue;
    }


    /**
     * Gets the orderhdr_id value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the acc_break_type value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return acc_break_type
     */
    public int getAcc_break_type() {
        return acc_break_type;
    }


    /**
     * Sets the acc_break_type value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param acc_break_type
     */
    public void setAcc_break_type(int acc_break_type) {
        this.acc_break_type = acc_break_type;
    }


    /**
     * Gets the ar value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return ar
     */
    public java.math.BigDecimal getAr() {
        return ar;
    }


    /**
     * Sets the ar value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param ar
     */
    public void setAr(java.math.BigDecimal ar) {
        this.ar = ar;
    }


    /**
     * Gets the cash value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return cash
     */
    public java.math.BigDecimal getCash() {
        return cash;
    }


    /**
     * Sets the cash value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param cash
     */
    public void setCash(java.math.BigDecimal cash) {
        this.cash = cash;
    }


    /**
     * Gets the liability value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return liability
     */
    public java.math.BigDecimal getLiability() {
        return liability;
    }


    /**
     * Sets the liability value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param liability
     */
    public void setLiability(java.math.BigDecimal liability) {
        this.liability = liability;
    }


    /**
     * Gets the revenue value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @return revenue
     */
    public java.math.BigDecimal getRevenue() {
        return revenue;
    }


    /**
     * Sets the revenue value for this Order_item_acc_break_select_responseOrder_item_acc_break.
     * 
     * @param revenue
     */
    public void setRevenue(java.math.BigDecimal revenue) {
        this.revenue = revenue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_acc_break_select_responseOrder_item_acc_break)) return false;
        Order_item_acc_break_select_responseOrder_item_acc_break other = (Order_item_acc_break_select_responseOrder_item_acc_break) obj;
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
            this.acc_break_type == other.getAcc_break_type() &&
            ((this.ar==null && other.getAr()==null) || 
             (this.ar!=null &&
              this.ar.equals(other.getAr()))) &&
            ((this.cash==null && other.getCash()==null) || 
             (this.cash!=null &&
              this.cash.equals(other.getCash()))) &&
            ((this.liability==null && other.getLiability()==null) || 
             (this.liability!=null &&
              this.liability.equals(other.getLiability()))) &&
            ((this.revenue==null && other.getRevenue()==null) || 
             (this.revenue!=null &&
              this.revenue.equals(other.getRevenue())));
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
        _hashCode += getAcc_break_type();
        if (getAr() != null) {
            _hashCode += getAr().hashCode();
        }
        if (getCash() != null) {
            _hashCode += getCash().hashCode();
        }
        if (getLiability() != null) {
            _hashCode += getLiability().hashCode();
        }
        if (getRevenue() != null) {
            _hashCode += getRevenue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_acc_break_select_responseOrder_item_acc_break.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>order_item_acc_break_select_response>order_item_acc_break"));
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
        attrField.setFieldName("acc_break_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "acc_break_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ar");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ar"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cash");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cash"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("liability");
        attrField.setXmlName(new javax.xml.namespace.QName("", "liability"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue"));
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
