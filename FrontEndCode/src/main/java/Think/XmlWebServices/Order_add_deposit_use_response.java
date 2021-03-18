/**
 * Order_add_deposit_use_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_add_deposit_use_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Customer customer;

    private Think.XmlWebServices.Demographic[] demographic;

    private Think.XmlWebServices.ZZSubscrip[] subscrip;

    private Think.XmlWebServices.Orderhdr orderhdr;

    private java.math.BigDecimal cc_commission_amount;  // attribute

    private java.math.BigDecimal cc_delivery_amount;  // attribute

    private java.math.BigDecimal cc_item_amount;  // attribute

    private java.math.BigDecimal cc_tax_amount;  // attribute

    private java.math.BigDecimal cc_total_amount;  // attribute

    public Order_add_deposit_use_response() {
    }

    public Order_add_deposit_use_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Customer customer,
           Think.XmlWebServices.Demographic[] demographic,
           Think.XmlWebServices.ZZSubscrip[] subscrip,
           Think.XmlWebServices.Orderhdr orderhdr,
           java.math.BigDecimal cc_commission_amount,
           java.math.BigDecimal cc_delivery_amount,
           java.math.BigDecimal cc_item_amount,
           java.math.BigDecimal cc_tax_amount,
           java.math.BigDecimal cc_total_amount) {
           this.customer_identifier = customer_identifier;
           this.customer = customer;
           this.demographic = demographic;
           this.subscrip = subscrip;
           this.orderhdr = orderhdr;
           this.cc_commission_amount = cc_commission_amount;
           this.cc_delivery_amount = cc_delivery_amount;
           this.cc_item_amount = cc_item_amount;
           this.cc_tax_amount = cc_tax_amount;
           this.cc_total_amount = cc_total_amount;
    }


    /**
     * Gets the customer_identifier value for this Order_add_deposit_use_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Order_add_deposit_use_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the customer value for this Order_add_deposit_use_response.
     * 
     * @return customer
     */
    public Think.XmlWebServices.Customer getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Order_add_deposit_use_response.
     * 
     * @param customer
     */
    public void setCustomer(Think.XmlWebServices.Customer customer) {
        this.customer = customer;
    }


    /**
     * Gets the demographic value for this Order_add_deposit_use_response.
     * 
     * @return demographic
     */
    public Think.XmlWebServices.Demographic[] getDemographic() {
        return demographic;
    }


    /**
     * Sets the demographic value for this Order_add_deposit_use_response.
     * 
     * @param demographic
     */
    public void setDemographic(Think.XmlWebServices.Demographic[] demographic) {
        this.demographic = demographic;
    }

    public Think.XmlWebServices.Demographic getDemographic(int i) {
        return this.demographic[i];
    }

    public void setDemographic(int i, Think.XmlWebServices.Demographic _value) {
        this.demographic[i] = _value;
    }


    /**
     * Gets the subscrip value for this Order_add_deposit_use_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip[] getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Order_add_deposit_use_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip[] subscrip) {
        this.subscrip = subscrip;
    }

    public Think.XmlWebServices.ZZSubscrip getSubscrip(int i) {
        return this.subscrip[i];
    }

    public void setSubscrip(int i, Think.XmlWebServices.ZZSubscrip _value) {
        this.subscrip[i] = _value;
    }


    /**
     * Gets the orderhdr value for this Order_add_deposit_use_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Order_add_deposit_use_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr orderhdr) {
        this.orderhdr = orderhdr;
    }


    /**
     * Gets the cc_commission_amount value for this Order_add_deposit_use_response.
     * 
     * @return cc_commission_amount
     */
    public java.math.BigDecimal getCc_commission_amount() {
        return cc_commission_amount;
    }


    /**
     * Sets the cc_commission_amount value for this Order_add_deposit_use_response.
     * 
     * @param cc_commission_amount
     */
    public void setCc_commission_amount(java.math.BigDecimal cc_commission_amount) {
        this.cc_commission_amount = cc_commission_amount;
    }


    /**
     * Gets the cc_delivery_amount value for this Order_add_deposit_use_response.
     * 
     * @return cc_delivery_amount
     */
    public java.math.BigDecimal getCc_delivery_amount() {
        return cc_delivery_amount;
    }


    /**
     * Sets the cc_delivery_amount value for this Order_add_deposit_use_response.
     * 
     * @param cc_delivery_amount
     */
    public void setCc_delivery_amount(java.math.BigDecimal cc_delivery_amount) {
        this.cc_delivery_amount = cc_delivery_amount;
    }


    /**
     * Gets the cc_item_amount value for this Order_add_deposit_use_response.
     * 
     * @return cc_item_amount
     */
    public java.math.BigDecimal getCc_item_amount() {
        return cc_item_amount;
    }


    /**
     * Sets the cc_item_amount value for this Order_add_deposit_use_response.
     * 
     * @param cc_item_amount
     */
    public void setCc_item_amount(java.math.BigDecimal cc_item_amount) {
        this.cc_item_amount = cc_item_amount;
    }


    /**
     * Gets the cc_tax_amount value for this Order_add_deposit_use_response.
     * 
     * @return cc_tax_amount
     */
    public java.math.BigDecimal getCc_tax_amount() {
        return cc_tax_amount;
    }


    /**
     * Sets the cc_tax_amount value for this Order_add_deposit_use_response.
     * 
     * @param cc_tax_amount
     */
    public void setCc_tax_amount(java.math.BigDecimal cc_tax_amount) {
        this.cc_tax_amount = cc_tax_amount;
    }


    /**
     * Gets the cc_total_amount value for this Order_add_deposit_use_response.
     * 
     * @return cc_total_amount
     */
    public java.math.BigDecimal getCc_total_amount() {
        return cc_total_amount;
    }


    /**
     * Sets the cc_total_amount value for this Order_add_deposit_use_response.
     * 
     * @param cc_total_amount
     */
    public void setCc_total_amount(java.math.BigDecimal cc_total_amount) {
        this.cc_total_amount = cc_total_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_add_deposit_use_response)) return false;
        Order_add_deposit_use_response other = (Order_add_deposit_use_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.demographic==null && other.getDemographic()==null) || 
             (this.demographic!=null &&
              java.util.Arrays.equals(this.demographic, other.getDemographic()))) &&
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              java.util.Arrays.equals(this.subscrip, other.getSubscrip()))) &&
            ((this.orderhdr==null && other.getOrderhdr()==null) || 
             (this.orderhdr!=null &&
              this.orderhdr.equals(other.getOrderhdr()))) &&
            ((this.cc_commission_amount==null && other.getCc_commission_amount()==null) || 
             (this.cc_commission_amount!=null &&
              this.cc_commission_amount.equals(other.getCc_commission_amount()))) &&
            ((this.cc_delivery_amount==null && other.getCc_delivery_amount()==null) || 
             (this.cc_delivery_amount!=null &&
              this.cc_delivery_amount.equals(other.getCc_delivery_amount()))) &&
            ((this.cc_item_amount==null && other.getCc_item_amount()==null) || 
             (this.cc_item_amount!=null &&
              this.cc_item_amount.equals(other.getCc_item_amount()))) &&
            ((this.cc_tax_amount==null && other.getCc_tax_amount()==null) || 
             (this.cc_tax_amount!=null &&
              this.cc_tax_amount.equals(other.getCc_tax_amount()))) &&
            ((this.cc_total_amount==null && other.getCc_total_amount()==null) || 
             (this.cc_total_amount!=null &&
              this.cc_total_amount.equals(other.getCc_total_amount())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getDemographic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDemographic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDemographic(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubscrip() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubscrip());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubscrip(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrderhdr() != null) {
            _hashCode += getOrderhdr().hashCode();
        }
        if (getCc_commission_amount() != null) {
            _hashCode += getCc_commission_amount().hashCode();
        }
        if (getCc_delivery_amount() != null) {
            _hashCode += getCc_delivery_amount().hashCode();
        }
        if (getCc_item_amount() != null) {
            _hashCode += getCc_item_amount().hashCode();
        }
        if (getCc_tax_amount() != null) {
            _hashCode += getCc_tax_amount().hashCode();
        }
        if (getCc_total_amount() != null) {
            _hashCode += getCc_total_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_add_deposit_use_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_add_deposit_use_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_commission_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_commission_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_delivery_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_delivery_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_item_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_item_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_tax_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_tax_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_total_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_total_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demographic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">orderhdr"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
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
