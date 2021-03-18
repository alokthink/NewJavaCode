/**
 * Single_issue_price.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Single_issue_price  implements java.io.Serializable {
    private int issue_id;  // attribute

    private java.util.Date issue_date;  // attribute

    private java.lang.String enumeration;  // attribute

    private int enum_issue_nbr;  // attribute

    private int enum_volume_nbr;  // attribute

    private int cc_item_qty;  // attribute

    private java.lang.String cc_currency;  // attribute

    private java.lang.String cc_actual_currency;  // attribute

    private java.math.BigDecimal cc_item_price;  // attribute

    public Single_issue_price() {
    }

    public Single_issue_price(
           int issue_id,
           java.util.Date issue_date,
           java.lang.String enumeration,
           int enum_issue_nbr,
           int enum_volume_nbr,
           int cc_item_qty,
           java.lang.String cc_currency,
           java.lang.String cc_actual_currency,
           java.math.BigDecimal cc_item_price) {
           this.issue_id = issue_id;
           this.issue_date = issue_date;
           this.enumeration = enumeration;
           this.enum_issue_nbr = enum_issue_nbr;
           this.enum_volume_nbr = enum_volume_nbr;
           this.cc_item_qty = cc_item_qty;
           this.cc_currency = cc_currency;
           this.cc_actual_currency = cc_actual_currency;
           this.cc_item_price = cc_item_price;
    }


    /**
     * Gets the issue_id value for this Single_issue_price.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Single_issue_price.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the issue_date value for this Single_issue_price.
     * 
     * @return issue_date
     */
    public java.util.Date getIssue_date() {
        return issue_date;
    }


    /**
     * Sets the issue_date value for this Single_issue_price.
     * 
     * @param issue_date
     */
    public void setIssue_date(java.util.Date issue_date) {
        this.issue_date = issue_date;
    }


    /**
     * Gets the enumeration value for this Single_issue_price.
     * 
     * @return enumeration
     */
    public java.lang.String getEnumeration() {
        return enumeration;
    }


    /**
     * Sets the enumeration value for this Single_issue_price.
     * 
     * @param enumeration
     */
    public void setEnumeration(java.lang.String enumeration) {
        this.enumeration = enumeration;
    }


    /**
     * Gets the enum_issue_nbr value for this Single_issue_price.
     * 
     * @return enum_issue_nbr
     */
    public int getEnum_issue_nbr() {
        return enum_issue_nbr;
    }


    /**
     * Sets the enum_issue_nbr value for this Single_issue_price.
     * 
     * @param enum_issue_nbr
     */
    public void setEnum_issue_nbr(int enum_issue_nbr) {
        this.enum_issue_nbr = enum_issue_nbr;
    }


    /**
     * Gets the enum_volume_nbr value for this Single_issue_price.
     * 
     * @return enum_volume_nbr
     */
    public int getEnum_volume_nbr() {
        return enum_volume_nbr;
    }


    /**
     * Sets the enum_volume_nbr value for this Single_issue_price.
     * 
     * @param enum_volume_nbr
     */
    public void setEnum_volume_nbr(int enum_volume_nbr) {
        this.enum_volume_nbr = enum_volume_nbr;
    }


    /**
     * Gets the cc_item_qty value for this Single_issue_price.
     * 
     * @return cc_item_qty
     */
    public int getCc_item_qty() {
        return cc_item_qty;
    }


    /**
     * Sets the cc_item_qty value for this Single_issue_price.
     * 
     * @param cc_item_qty
     */
    public void setCc_item_qty(int cc_item_qty) {
        this.cc_item_qty = cc_item_qty;
    }


    /**
     * Gets the cc_currency value for this Single_issue_price.
     * 
     * @return cc_currency
     */
    public java.lang.String getCc_currency() {
        return cc_currency;
    }


    /**
     * Sets the cc_currency value for this Single_issue_price.
     * 
     * @param cc_currency
     */
    public void setCc_currency(java.lang.String cc_currency) {
        this.cc_currency = cc_currency;
    }


    /**
     * Gets the cc_actual_currency value for this Single_issue_price.
     * 
     * @return cc_actual_currency
     */
    public java.lang.String getCc_actual_currency() {
        return cc_actual_currency;
    }


    /**
     * Sets the cc_actual_currency value for this Single_issue_price.
     * 
     * @param cc_actual_currency
     */
    public void setCc_actual_currency(java.lang.String cc_actual_currency) {
        this.cc_actual_currency = cc_actual_currency;
    }


    /**
     * Gets the cc_item_price value for this Single_issue_price.
     * 
     * @return cc_item_price
     */
    public java.math.BigDecimal getCc_item_price() {
        return cc_item_price;
    }


    /**
     * Sets the cc_item_price value for this Single_issue_price.
     * 
     * @param cc_item_price
     */
    public void setCc_item_price(java.math.BigDecimal cc_item_price) {
        this.cc_item_price = cc_item_price;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Single_issue_price)) return false;
        Single_issue_price other = (Single_issue_price) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.issue_id == other.getIssue_id() &&
            ((this.issue_date==null && other.getIssue_date()==null) || 
             (this.issue_date!=null &&
              this.issue_date.equals(other.getIssue_date()))) &&
            ((this.enumeration==null && other.getEnumeration()==null) || 
             (this.enumeration!=null &&
              this.enumeration.equals(other.getEnumeration()))) &&
            this.enum_issue_nbr == other.getEnum_issue_nbr() &&
            this.enum_volume_nbr == other.getEnum_volume_nbr() &&
            this.cc_item_qty == other.getCc_item_qty() &&
            ((this.cc_currency==null && other.getCc_currency()==null) || 
             (this.cc_currency!=null &&
              this.cc_currency.equals(other.getCc_currency()))) &&
            ((this.cc_actual_currency==null && other.getCc_actual_currency()==null) || 
             (this.cc_actual_currency!=null &&
              this.cc_actual_currency.equals(other.getCc_actual_currency()))) &&
            ((this.cc_item_price==null && other.getCc_item_price()==null) || 
             (this.cc_item_price!=null &&
              this.cc_item_price.equals(other.getCc_item_price())));
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
        _hashCode += getIssue_id();
        if (getIssue_date() != null) {
            _hashCode += getIssue_date().hashCode();
        }
        if (getEnumeration() != null) {
            _hashCode += getEnumeration().hashCode();
        }
        _hashCode += getEnum_issue_nbr();
        _hashCode += getEnum_volume_nbr();
        _hashCode += getCc_item_qty();
        if (getCc_currency() != null) {
            _hashCode += getCc_currency().hashCode();
        }
        if (getCc_actual_currency() != null) {
            _hashCode += getCc_actual_currency().hashCode();
        }
        if (getCc_item_price() != null) {
            _hashCode += getCc_item_price().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Single_issue_price.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">single_issue_price"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enum_issue_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enum_issue_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enum_volume_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enum_volume_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_item_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_item_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_actual_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_actual_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_item_price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_item_price"));
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
