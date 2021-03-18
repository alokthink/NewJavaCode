/**
 * Ren_card_order_code.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Ren_card_order_code  implements java.io.Serializable {
    private int renewal_card_id;  // attribute

    private int renewal_card_from_effort;  // attribute

    private int ren_card_order_code_seq;  // attribute

    private java.lang.String description;  // attribute

    private int order_code_id;  // attribute

    private int rate_class_id;  // attribute

    private int discount_class_id;  // attribute

    private int source_code_id;  // attribute

    private int subscription_def_id;  // attribute

    private int pkg_def_id;  // attribute

    private int term_id;  // attribute

    private boolean default_offer;  // attribute

    public Ren_card_order_code() {
    }

    public Ren_card_order_code(
           int renewal_card_id,
           int renewal_card_from_effort,
           int ren_card_order_code_seq,
           java.lang.String description,
           int order_code_id,
           int rate_class_id,
           int discount_class_id,
           int source_code_id,
           int subscription_def_id,
           int pkg_def_id,
           int term_id,
           boolean default_offer) {
           this.renewal_card_id = renewal_card_id;
           this.renewal_card_from_effort = renewal_card_from_effort;
           this.ren_card_order_code_seq = ren_card_order_code_seq;
           this.description = description;
           this.order_code_id = order_code_id;
           this.rate_class_id = rate_class_id;
           this.discount_class_id = discount_class_id;
           this.source_code_id = source_code_id;
           this.subscription_def_id = subscription_def_id;
           this.pkg_def_id = pkg_def_id;
           this.term_id = term_id;
           this.default_offer = default_offer;
    }


    /**
     * Gets the renewal_card_id value for this Ren_card_order_code.
     * 
     * @return renewal_card_id
     */
    public int getRenewal_card_id() {
        return renewal_card_id;
    }


    /**
     * Sets the renewal_card_id value for this Ren_card_order_code.
     * 
     * @param renewal_card_id
     */
    public void setRenewal_card_id(int renewal_card_id) {
        this.renewal_card_id = renewal_card_id;
    }


    /**
     * Gets the renewal_card_from_effort value for this Ren_card_order_code.
     * 
     * @return renewal_card_from_effort
     */
    public int getRenewal_card_from_effort() {
        return renewal_card_from_effort;
    }


    /**
     * Sets the renewal_card_from_effort value for this Ren_card_order_code.
     * 
     * @param renewal_card_from_effort
     */
    public void setRenewal_card_from_effort(int renewal_card_from_effort) {
        this.renewal_card_from_effort = renewal_card_from_effort;
    }


    /**
     * Gets the ren_card_order_code_seq value for this Ren_card_order_code.
     * 
     * @return ren_card_order_code_seq
     */
    public int getRen_card_order_code_seq() {
        return ren_card_order_code_seq;
    }


    /**
     * Sets the ren_card_order_code_seq value for this Ren_card_order_code.
     * 
     * @param ren_card_order_code_seq
     */
    public void setRen_card_order_code_seq(int ren_card_order_code_seq) {
        this.ren_card_order_code_seq = ren_card_order_code_seq;
    }


    /**
     * Gets the description value for this Ren_card_order_code.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Ren_card_order_code.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the order_code_id value for this Ren_card_order_code.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Ren_card_order_code.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the rate_class_id value for this Ren_card_order_code.
     * 
     * @return rate_class_id
     */
    public int getRate_class_id() {
        return rate_class_id;
    }


    /**
     * Sets the rate_class_id value for this Ren_card_order_code.
     * 
     * @param rate_class_id
     */
    public void setRate_class_id(int rate_class_id) {
        this.rate_class_id = rate_class_id;
    }


    /**
     * Gets the discount_class_id value for this Ren_card_order_code.
     * 
     * @return discount_class_id
     */
    public int getDiscount_class_id() {
        return discount_class_id;
    }


    /**
     * Sets the discount_class_id value for this Ren_card_order_code.
     * 
     * @param discount_class_id
     */
    public void setDiscount_class_id(int discount_class_id) {
        this.discount_class_id = discount_class_id;
    }


    /**
     * Gets the source_code_id value for this Ren_card_order_code.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Ren_card_order_code.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the subscription_def_id value for this Ren_card_order_code.
     * 
     * @return subscription_def_id
     */
    public int getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Ren_card_order_code.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(int subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the pkg_def_id value for this Ren_card_order_code.
     * 
     * @return pkg_def_id
     */
    public int getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Ren_card_order_code.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(int pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the term_id value for this Ren_card_order_code.
     * 
     * @return term_id
     */
    public int getTerm_id() {
        return term_id;
    }


    /**
     * Sets the term_id value for this Ren_card_order_code.
     * 
     * @param term_id
     */
    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }


    /**
     * Gets the default_offer value for this Ren_card_order_code.
     * 
     * @return default_offer
     */
    public boolean isDefault_offer() {
        return default_offer;
    }


    /**
     * Sets the default_offer value for this Ren_card_order_code.
     * 
     * @param default_offer
     */
    public void setDefault_offer(boolean default_offer) {
        this.default_offer = default_offer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ren_card_order_code)) return false;
        Ren_card_order_code other = (Ren_card_order_code) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.renewal_card_id == other.getRenewal_card_id() &&
            this.renewal_card_from_effort == other.getRenewal_card_from_effort() &&
            this.ren_card_order_code_seq == other.getRen_card_order_code_seq() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.order_code_id == other.getOrder_code_id() &&
            this.rate_class_id == other.getRate_class_id() &&
            this.discount_class_id == other.getDiscount_class_id() &&
            this.source_code_id == other.getSource_code_id() &&
            this.subscription_def_id == other.getSubscription_def_id() &&
            this.pkg_def_id == other.getPkg_def_id() &&
            this.term_id == other.getTerm_id() &&
            this.default_offer == other.isDefault_offer();
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
        _hashCode += getRenewal_card_id();
        _hashCode += getRenewal_card_from_effort();
        _hashCode += getRen_card_order_code_seq();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getOrder_code_id();
        _hashCode += getRate_class_id();
        _hashCode += getDiscount_class_id();
        _hashCode += getSource_code_id();
        _hashCode += getSubscription_def_id();
        _hashCode += getPkg_def_id();
        _hashCode += getTerm_id();
        _hashCode += (isDefault_offer() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ren_card_order_code.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">ren_card_order_code"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_card_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_card_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_card_from_effort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_card_from_effort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_card_order_code_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_card_order_code_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscription_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscription_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("term_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "term_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_offer");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_offer"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
