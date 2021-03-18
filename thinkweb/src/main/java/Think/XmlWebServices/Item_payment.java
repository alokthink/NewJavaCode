/**
 * Item_payment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_payment  implements java.io.Serializable {
    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.math.BigDecimal amount;

    private java.math.BigDecimal pay_currency_amount;

    private Think.XmlWebServices.Threshold_option_enum threshold_option;  // attribute

    public Item_payment() {
    }

    public Item_payment(
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.math.BigDecimal amount,
           java.math.BigDecimal pay_currency_amount,
           Think.XmlWebServices.Threshold_option_enum threshold_option) {
           this.item_identifier = item_identifier;
           this.amount = amount;
           this.pay_currency_amount = pay_currency_amount;
           this.threshold_option = threshold_option;
    }


    /**
     * Gets the item_identifier value for this Item_payment.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Item_payment.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the amount value for this Item_payment.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Item_payment.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the pay_currency_amount value for this Item_payment.
     * 
     * @return pay_currency_amount
     */
    public java.math.BigDecimal getPay_currency_amount() {
        return pay_currency_amount;
    }


    /**
     * Sets the pay_currency_amount value for this Item_payment.
     * 
     * @param pay_currency_amount
     */
    public void setPay_currency_amount(java.math.BigDecimal pay_currency_amount) {
        this.pay_currency_amount = pay_currency_amount;
    }


    /**
     * Gets the threshold_option value for this Item_payment.
     * 
     * @return threshold_option
     */
    public Think.XmlWebServices.Threshold_option_enum getThreshold_option() {
        return threshold_option;
    }


    /**
     * Sets the threshold_option value for this Item_payment.
     * 
     * @param threshold_option
     */
    public void setThreshold_option(Think.XmlWebServices.Threshold_option_enum threshold_option) {
        this.threshold_option = threshold_option;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_payment)) return false;
        Item_payment other = (Item_payment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.pay_currency_amount==null && other.getPay_currency_amount()==null) || 
             (this.pay_currency_amount!=null &&
              this.pay_currency_amount.equals(other.getPay_currency_amount()))) &&
            ((this.threshold_option==null && other.getThreshold_option()==null) || 
             (this.threshold_option!=null &&
              this.threshold_option.equals(other.getThreshold_option())));
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
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getPay_currency_amount() != null) {
            _hashCode += getPay_currency_amount().hashCode();
        }
        if (getThreshold_option() != null) {
            _hashCode += getThreshold_option().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_payment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_payment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("threshold_option");
        attrField.setXmlName(new javax.xml.namespace.QName("", "threshold_option"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "threshold_option_enum"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pay_currency_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pay_currency_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
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

	@Override
	public String toString() {
		return "Item_payment [item_identifier=" + item_identifier + ", amount="
				+ amount + ", pay_currency_amount=" + pay_currency_amount
				+ ", threshold_option=" + threshold_option + ", __equalsCalc="
				+ __equalsCalc + ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
