/**
 * Item_amt_break_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_amt_break_data  implements java.io.Serializable {
    private Think.XmlWebServices.Order_item_break_type order_item_break_type;

    private java.math.BigDecimal base_amount;

    private java.math.BigDecimal local_amount;

    private java.lang.String tax_rate_category;

    private java.lang.String state;

    private java.lang.String jurisdiction_seq;

    private java.lang.String tax_type;

    private Think.XmlWebServices.ZZBoolean commission_excluded;  // attribute

    public Item_amt_break_data() {
    }

    public Item_amt_break_data(
           Think.XmlWebServices.Order_item_break_type order_item_break_type,
           java.math.BigDecimal base_amount,
           java.math.BigDecimal local_amount,
           java.lang.String tax_rate_category,
           java.lang.String state,
           java.lang.String jurisdiction_seq,
           java.lang.String tax_type,
           Think.XmlWebServices.ZZBoolean commission_excluded) {
           this.order_item_break_type = order_item_break_type;
           this.base_amount = base_amount;
           this.local_amount = local_amount;
           this.tax_rate_category = tax_rate_category;
           this.state = state;
           this.jurisdiction_seq = jurisdiction_seq;
           this.tax_type = tax_type;
           this.commission_excluded = commission_excluded;
    }


    /**
     * Gets the order_item_break_type value for this Item_amt_break_data.
     * 
     * @return order_item_break_type
     */
    public Think.XmlWebServices.Order_item_break_type getOrder_item_break_type() {
        return order_item_break_type;
    }


    /**
     * Sets the order_item_break_type value for this Item_amt_break_data.
     * 
     * @param order_item_break_type
     */
    public void setOrder_item_break_type(Think.XmlWebServices.Order_item_break_type order_item_break_type) {
        this.order_item_break_type = order_item_break_type;
    }


    /**
     * Gets the base_amount value for this Item_amt_break_data.
     * 
     * @return base_amount
     */
    public java.math.BigDecimal getBase_amount() {
        return base_amount;
    }


    /**
     * Sets the base_amount value for this Item_amt_break_data.
     * 
     * @param base_amount
     */
    public void setBase_amount(java.math.BigDecimal base_amount) {
        this.base_amount = base_amount;
    }


    /**
     * Gets the local_amount value for this Item_amt_break_data.
     * 
     * @return local_amount
     */
    public java.math.BigDecimal getLocal_amount() {
        return local_amount;
    }


    /**
     * Sets the local_amount value for this Item_amt_break_data.
     * 
     * @param local_amount
     */
    public void setLocal_amount(java.math.BigDecimal local_amount) {
        this.local_amount = local_amount;
    }


    /**
     * Gets the tax_rate_category value for this Item_amt_break_data.
     * 
     * @return tax_rate_category
     */
    public java.lang.String getTax_rate_category() {
        return tax_rate_category;
    }


    /**
     * Sets the tax_rate_category value for this Item_amt_break_data.
     * 
     * @param tax_rate_category
     */
    public void setTax_rate_category(java.lang.String tax_rate_category) {
        this.tax_rate_category = tax_rate_category;
    }


    /**
     * Gets the state value for this Item_amt_break_data.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Item_amt_break_data.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the jurisdiction_seq value for this Item_amt_break_data.
     * 
     * @return jurisdiction_seq
     */
    public java.lang.String getJurisdiction_seq() {
        return jurisdiction_seq;
    }


    /**
     * Sets the jurisdiction_seq value for this Item_amt_break_data.
     * 
     * @param jurisdiction_seq
     */
    public void setJurisdiction_seq(java.lang.String jurisdiction_seq) {
        this.jurisdiction_seq = jurisdiction_seq;
    }


    /**
     * Gets the tax_type value for this Item_amt_break_data.
     * 
     * @return tax_type
     */
    public java.lang.String getTax_type() {
        return tax_type;
    }


    /**
     * Sets the tax_type value for this Item_amt_break_data.
     * 
     * @param tax_type
     */
    public void setTax_type(java.lang.String tax_type) {
        this.tax_type = tax_type;
    }


    /**
     * Gets the commission_excluded value for this Item_amt_break_data.
     * 
     * @return commission_excluded
     */
    public Think.XmlWebServices.ZZBoolean getCommission_excluded() {
        return commission_excluded;
    }


    /**
     * Sets the commission_excluded value for this Item_amt_break_data.
     * 
     * @param commission_excluded
     */
    public void setCommission_excluded(Think.XmlWebServices.ZZBoolean commission_excluded) {
        this.commission_excluded = commission_excluded;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_amt_break_data)) return false;
        Item_amt_break_data other = (Item_amt_break_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_item_break_type==null && other.getOrder_item_break_type()==null) || 
             (this.order_item_break_type!=null &&
              this.order_item_break_type.equals(other.getOrder_item_break_type()))) &&
            ((this.base_amount==null && other.getBase_amount()==null) || 
             (this.base_amount!=null &&
              this.base_amount.equals(other.getBase_amount()))) &&
            ((this.local_amount==null && other.getLocal_amount()==null) || 
             (this.local_amount!=null &&
              this.local_amount.equals(other.getLocal_amount()))) &&
            ((this.tax_rate_category==null && other.getTax_rate_category()==null) || 
             (this.tax_rate_category!=null &&
              this.tax_rate_category.equals(other.getTax_rate_category()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.jurisdiction_seq==null && other.getJurisdiction_seq()==null) || 
             (this.jurisdiction_seq!=null &&
              this.jurisdiction_seq.equals(other.getJurisdiction_seq()))) &&
            ((this.tax_type==null && other.getTax_type()==null) || 
             (this.tax_type!=null &&
              this.tax_type.equals(other.getTax_type()))) &&
            ((this.commission_excluded==null && other.getCommission_excluded()==null) || 
             (this.commission_excluded!=null &&
              this.commission_excluded.equals(other.getCommission_excluded())));
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
        if (getOrder_item_break_type() != null) {
            _hashCode += getOrder_item_break_type().hashCode();
        }
        if (getBase_amount() != null) {
            _hashCode += getBase_amount().hashCode();
        }
        if (getLocal_amount() != null) {
            _hashCode += getLocal_amount().hashCode();
        }
        if (getTax_rate_category() != null) {
            _hashCode += getTax_rate_category().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getJurisdiction_seq() != null) {
            _hashCode += getJurisdiction_seq().hashCode();
        }
        if (getTax_type() != null) {
            _hashCode += getTax_type().hashCode();
        }
        if (getCommission_excluded() != null) {
            _hashCode += getCommission_excluded().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_amt_break_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_amt_break_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("commission_excluded");
        attrField.setXmlName(new javax.xml.namespace.QName("", "commission_excluded"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_break_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_break_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_break_type"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("base_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "base_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("local_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "local_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_rate_category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "tax_rate_category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jurisdiction_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jurisdiction_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "tax_type"));
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
