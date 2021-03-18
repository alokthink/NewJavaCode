/**
 * Subscrip_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subscrip_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZSubscrip subscrip;

    private Think.XmlWebServices.Orderhdr orderhdr;

    private java.math.BigDecimal cc_commission_amount;  // attribute

    private java.math.BigDecimal cc_delivery_amount;  // attribute

    private java.math.BigDecimal cc_item_amount;  // attribute

    private java.math.BigDecimal cc_tax_amount;  // attribute

    private java.math.BigDecimal cc_total_amount;  // attribute

    public Subscrip_edit_response() {
    }

    public Subscrip_edit_response(
           Think.XmlWebServices.ZZSubscrip subscrip,
           Think.XmlWebServices.Orderhdr orderhdr,
           java.math.BigDecimal cc_commission_amount,
           java.math.BigDecimal cc_delivery_amount,
           java.math.BigDecimal cc_item_amount,
           java.math.BigDecimal cc_tax_amount,
           java.math.BigDecimal cc_total_amount) {
           this.subscrip = subscrip;
           this.orderhdr = orderhdr;
           this.cc_commission_amount = cc_commission_amount;
           this.cc_delivery_amount = cc_delivery_amount;
           this.cc_item_amount = cc_item_amount;
           this.cc_tax_amount = cc_tax_amount;
           this.cc_total_amount = cc_total_amount;
    }


    /**
     * Gets the subscrip value for this Subscrip_edit_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Subscrip_edit_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip subscrip) {
        this.subscrip = subscrip;
    }


    /**
     * Gets the orderhdr value for this Subscrip_edit_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Subscrip_edit_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr orderhdr) {
        this.orderhdr = orderhdr;
    }


    /**
     * Gets the cc_commission_amount value for this Subscrip_edit_response.
     * 
     * @return cc_commission_amount
     */
    public java.math.BigDecimal getCc_commission_amount() {
        return cc_commission_amount;
    }


    /**
     * Sets the cc_commission_amount value for this Subscrip_edit_response.
     * 
     * @param cc_commission_amount
     */
    public void setCc_commission_amount(java.math.BigDecimal cc_commission_amount) {
        this.cc_commission_amount = cc_commission_amount;
    }


    /**
     * Gets the cc_delivery_amount value for this Subscrip_edit_response.
     * 
     * @return cc_delivery_amount
     */
    public java.math.BigDecimal getCc_delivery_amount() {
        return cc_delivery_amount;
    }


    /**
     * Sets the cc_delivery_amount value for this Subscrip_edit_response.
     * 
     * @param cc_delivery_amount
     */
    public void setCc_delivery_amount(java.math.BigDecimal cc_delivery_amount) {
        this.cc_delivery_amount = cc_delivery_amount;
    }


    /**
     * Gets the cc_item_amount value for this Subscrip_edit_response.
     * 
     * @return cc_item_amount
     */
    public java.math.BigDecimal getCc_item_amount() {
        return cc_item_amount;
    }


    /**
     * Sets the cc_item_amount value for this Subscrip_edit_response.
     * 
     * @param cc_item_amount
     */
    public void setCc_item_amount(java.math.BigDecimal cc_item_amount) {
        this.cc_item_amount = cc_item_amount;
    }


    /**
     * Gets the cc_tax_amount value for this Subscrip_edit_response.
     * 
     * @return cc_tax_amount
     */
    public java.math.BigDecimal getCc_tax_amount() {
        return cc_tax_amount;
    }


    /**
     * Sets the cc_tax_amount value for this Subscrip_edit_response.
     * 
     * @param cc_tax_amount
     */
    public void setCc_tax_amount(java.math.BigDecimal cc_tax_amount) {
        this.cc_tax_amount = cc_tax_amount;
    }


    /**
     * Gets the cc_total_amount value for this Subscrip_edit_response.
     * 
     * @return cc_total_amount
     */
    public java.math.BigDecimal getCc_total_amount() {
        return cc_total_amount;
    }


    /**
     * Sets the cc_total_amount value for this Subscrip_edit_response.
     * 
     * @param cc_total_amount
     */
    public void setCc_total_amount(java.math.BigDecimal cc_total_amount) {
        this.cc_total_amount = cc_total_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subscrip_edit_response)) return false;
        Subscrip_edit_response other = (Subscrip_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              this.subscrip.equals(other.getSubscrip()))) &&
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
        if (getSubscrip() != null) {
            _hashCode += getSubscrip().hashCode();
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
        new org.apache.axis.description.TypeDesc(Subscrip_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscrip_edit_response"));
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
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscrip"));
        elemField.setNillable(false);
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
