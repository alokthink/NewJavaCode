/**
 * ZZOrderItemInstallDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZOrderItemInstallDtl  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int installment_number;  // attribute

    private int customer_id;  // attribute

    private java.util.Date date_sent;  // attribute

    private java.math.BigDecimal install_amount;  // attribute

    private int payment_seq;  // attribute

    public ZZOrderItemInstallDtl() {
    }

    public ZZOrderItemInstallDtl(
           int orderhdr_id,
           int order_item_seq,
           int installment_number,
           int customer_id,
           java.util.Date date_sent,
           java.math.BigDecimal install_amount,
           int payment_seq) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.installment_number = installment_number;
           this.customer_id = customer_id;
           this.date_sent = date_sent;
           this.install_amount = install_amount;
           this.payment_seq = payment_seq;
    }


    /**
     * Gets the orderhdr_id value for this ZZOrderItemInstallDtl.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZOrderItemInstallDtl.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this ZZOrderItemInstallDtl.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZOrderItemInstallDtl.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the installment_number value for this ZZOrderItemInstallDtl.
     * 
     * @return installment_number
     */
    public int getInstallment_number() {
        return installment_number;
    }


    /**
     * Sets the installment_number value for this ZZOrderItemInstallDtl.
     * 
     * @param installment_number
     */
    public void setInstallment_number(int installment_number) {
        this.installment_number = installment_number;
    }


    /**
     * Gets the customer_id value for this ZZOrderItemInstallDtl.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZOrderItemInstallDtl.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the date_sent value for this ZZOrderItemInstallDtl.
     * 
     * @return date_sent
     */
    public java.util.Date getDate_sent() {
        return date_sent;
    }


    /**
     * Sets the date_sent value for this ZZOrderItemInstallDtl.
     * 
     * @param date_sent
     */
    public void setDate_sent(java.util.Date date_sent) {
        this.date_sent = date_sent;
    }


    /**
     * Gets the install_amount value for this ZZOrderItemInstallDtl.
     * 
     * @return install_amount
     */
    public java.math.BigDecimal getInstall_amount() {
        return install_amount;
    }


    /**
     * Sets the install_amount value for this ZZOrderItemInstallDtl.
     * 
     * @param install_amount
     */
    public void setInstall_amount(java.math.BigDecimal install_amount) {
        this.install_amount = install_amount;
    }


    /**
     * Gets the payment_seq value for this ZZOrderItemInstallDtl.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this ZZOrderItemInstallDtl.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZOrderItemInstallDtl)) return false;
        ZZOrderItemInstallDtl other = (ZZOrderItemInstallDtl) obj;
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
            this.installment_number == other.getInstallment_number() &&
            this.customer_id == other.getCustomer_id() &&
            ((this.date_sent==null && other.getDate_sent()==null) || 
             (this.date_sent!=null &&
              this.date_sent.equals(other.getDate_sent()))) &&
            ((this.install_amount==null && other.getInstall_amount()==null) || 
             (this.install_amount!=null &&
              this.install_amount.equals(other.getInstall_amount()))) &&
            this.payment_seq == other.getPayment_seq();
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
        _hashCode += getInstallment_number();
        _hashCode += getCustomer_id();
        if (getDate_sent() != null) {
            _hashCode += getDate_sent().hashCode();
        }
        if (getInstall_amount() != null) {
            _hashCode += getInstall_amount().hashCode();
        }
        _hashCode += getPayment_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZOrderItemInstallDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderItemInstallDtl"));
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
        attrField.setFieldName("installment_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("install_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "install_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
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
