/**
 * Cancel_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Cancel_data  implements java.io.Serializable {
    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.util.Calendar cancel_date;

    private java.lang.String cancel_reason;

    private java.math.BigDecimal amount;

    private java.lang.String currency;

    private Think.XmlWebServices.ZZBoolean no_refund;  // attribute

    private Think.XmlWebServices.ZZBoolean item_only;  // attribute

    private Think.XmlWebServices.ZZBoolean stragglers_too;  // attribute

    private Think.XmlWebServices.ZZBoolean override_deal_do_not_cancel;  // attribute

    private Think.XmlWebServices.Renewal_status_on_cancel renewal_status_on_cancel;  // attribute

    private Think.XmlWebServices.ZZBoolean apply_renewal_status_on_cancel_to_ren_chain;  // attribute

    public Cancel_data() {
    }

    public Cancel_data(
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.util.Calendar cancel_date,
           java.lang.String cancel_reason,
           java.math.BigDecimal amount,
           java.lang.String currency,
           Think.XmlWebServices.ZZBoolean no_refund,
           Think.XmlWebServices.ZZBoolean item_only,
           Think.XmlWebServices.ZZBoolean stragglers_too,
           Think.XmlWebServices.ZZBoolean override_deal_do_not_cancel,
           Think.XmlWebServices.Renewal_status_on_cancel renewal_status_on_cancel,
           Think.XmlWebServices.ZZBoolean apply_renewal_status_on_cancel_to_ren_chain) {
           this.item_identifier = item_identifier;
           this.cancel_date = cancel_date;
           this.cancel_reason = cancel_reason;
           this.amount = amount;
           this.currency = currency;
           this.no_refund = no_refund;
           this.item_only = item_only;
           this.stragglers_too = stragglers_too;
           this.override_deal_do_not_cancel = override_deal_do_not_cancel;
           this.renewal_status_on_cancel = renewal_status_on_cancel;
           this.apply_renewal_status_on_cancel_to_ren_chain = apply_renewal_status_on_cancel_to_ren_chain;
    }


    /**
     * Gets the item_identifier value for this Cancel_data.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Cancel_data.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the cancel_date value for this Cancel_data.
     * 
     * @return cancel_date
     */
    public java.util.Calendar getCancel_date() {
        return cancel_date;
    }


    /**
     * Sets the cancel_date value for this Cancel_data.
     * 
     * @param cancel_date
     */
    public void setCancel_date(java.util.Calendar cancel_date) {
        this.cancel_date = cancel_date;
    }


    /**
     * Gets the cancel_reason value for this Cancel_data.
     * 
     * @return cancel_reason
     */
    public java.lang.String getCancel_reason() {
        return cancel_reason;
    }


    /**
     * Sets the cancel_reason value for this Cancel_data.
     * 
     * @param cancel_reason
     */
    public void setCancel_reason(java.lang.String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }


    /**
     * Gets the amount value for this Cancel_data.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Cancel_data.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the currency value for this Cancel_data.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Cancel_data.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the no_refund value for this Cancel_data.
     * 
     * @return no_refund
     */
    public Think.XmlWebServices.ZZBoolean getNo_refund() {
        return no_refund;
    }


    /**
     * Sets the no_refund value for this Cancel_data.
     * 
     * @param no_refund
     */
    public void setNo_refund(Think.XmlWebServices.ZZBoolean no_refund) {
        this.no_refund = no_refund;
    }


    /**
     * Gets the item_only value for this Cancel_data.
     * 
     * @return item_only
     */
    public Think.XmlWebServices.ZZBoolean getItem_only() {
        return item_only;
    }


    /**
     * Sets the item_only value for this Cancel_data.
     * 
     * @param item_only
     */
    public void setItem_only(Think.XmlWebServices.ZZBoolean item_only) {
        this.item_only = item_only;
    }


    /**
     * Gets the stragglers_too value for this Cancel_data.
     * 
     * @return stragglers_too
     */
    public Think.XmlWebServices.ZZBoolean getStragglers_too() {
        return stragglers_too;
    }


    /**
     * Sets the stragglers_too value for this Cancel_data.
     * 
     * @param stragglers_too
     */
    public void setStragglers_too(Think.XmlWebServices.ZZBoolean stragglers_too) {
        this.stragglers_too = stragglers_too;
    }


    /**
     * Gets the override_deal_do_not_cancel value for this Cancel_data.
     * 
     * @return override_deal_do_not_cancel
     */
    public Think.XmlWebServices.ZZBoolean getOverride_deal_do_not_cancel() {
        return override_deal_do_not_cancel;
    }


    /**
     * Sets the override_deal_do_not_cancel value for this Cancel_data.
     * 
     * @param override_deal_do_not_cancel
     */
    public void setOverride_deal_do_not_cancel(Think.XmlWebServices.ZZBoolean override_deal_do_not_cancel) {
        this.override_deal_do_not_cancel = override_deal_do_not_cancel;
    }


    /**
     * Gets the renewal_status_on_cancel value for this Cancel_data.
     * 
     * @return renewal_status_on_cancel
     */
    public Think.XmlWebServices.Renewal_status_on_cancel getRenewal_status_on_cancel() {
        return renewal_status_on_cancel;
    }


    /**
     * Sets the renewal_status_on_cancel value for this Cancel_data.
     * 
     * @param renewal_status_on_cancel
     */
    public void setRenewal_status_on_cancel(Think.XmlWebServices.Renewal_status_on_cancel renewal_status_on_cancel) {
        this.renewal_status_on_cancel = renewal_status_on_cancel;
    }


    /**
     * Gets the apply_renewal_status_on_cancel_to_ren_chain value for this Cancel_data.
     * 
     * @return apply_renewal_status_on_cancel_to_ren_chain
     */
    public Think.XmlWebServices.ZZBoolean getApply_renewal_status_on_cancel_to_ren_chain() {
        return apply_renewal_status_on_cancel_to_ren_chain;
    }


    /**
     * Sets the apply_renewal_status_on_cancel_to_ren_chain value for this Cancel_data.
     * 
     * @param apply_renewal_status_on_cancel_to_ren_chain
     */
    public void setApply_renewal_status_on_cancel_to_ren_chain(Think.XmlWebServices.ZZBoolean apply_renewal_status_on_cancel_to_ren_chain) {
        this.apply_renewal_status_on_cancel_to_ren_chain = apply_renewal_status_on_cancel_to_ren_chain;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cancel_data)) return false;
        Cancel_data other = (Cancel_data) obj;
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
            ((this.cancel_date==null && other.getCancel_date()==null) || 
             (this.cancel_date!=null &&
              this.cancel_date.equals(other.getCancel_date()))) &&
            ((this.cancel_reason==null && other.getCancel_reason()==null) || 
             (this.cancel_reason!=null &&
              this.cancel_reason.equals(other.getCancel_reason()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.no_refund==null && other.getNo_refund()==null) || 
             (this.no_refund!=null &&
              this.no_refund.equals(other.getNo_refund()))) &&
            ((this.item_only==null && other.getItem_only()==null) || 
             (this.item_only!=null &&
              this.item_only.equals(other.getItem_only()))) &&
            ((this.stragglers_too==null && other.getStragglers_too()==null) || 
             (this.stragglers_too!=null &&
              this.stragglers_too.equals(other.getStragglers_too()))) &&
            ((this.override_deal_do_not_cancel==null && other.getOverride_deal_do_not_cancel()==null) || 
             (this.override_deal_do_not_cancel!=null &&
              this.override_deal_do_not_cancel.equals(other.getOverride_deal_do_not_cancel()))) &&
            ((this.renewal_status_on_cancel==null && other.getRenewal_status_on_cancel()==null) || 
             (this.renewal_status_on_cancel!=null &&
              this.renewal_status_on_cancel.equals(other.getRenewal_status_on_cancel()))) &&
            ((this.apply_renewal_status_on_cancel_to_ren_chain==null && other.getApply_renewal_status_on_cancel_to_ren_chain()==null) || 
             (this.apply_renewal_status_on_cancel_to_ren_chain!=null &&
              this.apply_renewal_status_on_cancel_to_ren_chain.equals(other.getApply_renewal_status_on_cancel_to_ren_chain())));
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
        if (getCancel_date() != null) {
            _hashCode += getCancel_date().hashCode();
        }
        if (getCancel_reason() != null) {
            _hashCode += getCancel_reason().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getNo_refund() != null) {
            _hashCode += getNo_refund().hashCode();
        }
        if (getItem_only() != null) {
            _hashCode += getItem_only().hashCode();
        }
        if (getStragglers_too() != null) {
            _hashCode += getStragglers_too().hashCode();
        }
        if (getOverride_deal_do_not_cancel() != null) {
            _hashCode += getOverride_deal_do_not_cancel().hashCode();
        }
        if (getRenewal_status_on_cancel() != null) {
            _hashCode += getRenewal_status_on_cancel().hashCode();
        }
        if (getApply_renewal_status_on_cancel_to_ren_chain() != null) {
            _hashCode += getApply_renewal_status_on_cancel_to_ren_chain().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cancel_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">cancel_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("no_refund");
        attrField.setXmlName(new javax.xml.namespace.QName("", "no_refund"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("stragglers_too");
        attrField.setXmlName(new javax.xml.namespace.QName("", "stragglers_too"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("override_deal_do_not_cancel");
        attrField.setXmlName(new javax.xml.namespace.QName("", "override_deal_do_not_cancel"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_status_on_cancel");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_status_on_cancel"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_status_on_cancel"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("apply_renewal_status_on_cancel_to_ren_chain");
        attrField.setXmlName(new javax.xml.namespace.QName("", "apply_renewal_status_on_cancel_to_ren_chain"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

}
