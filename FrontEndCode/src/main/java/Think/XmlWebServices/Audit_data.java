/**
 * Audit_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Audit_data  implements java.io.Serializable {
    private int audit_qual_category;

    private int audit_qual_source_id;

    private int audit_name_title_id;

    private int audit_sales_channel_id;

    private int audit_subscription_type_id;

    private int oc_id;

    private int order_code_id;

    public Audit_data() {
    }

    public Audit_data(
           int audit_qual_category,
           int audit_qual_source_id,
           int audit_name_title_id,
           int audit_sales_channel_id,
           int audit_subscription_type_id,
           int oc_id,
           int order_code_id) {
           this.audit_qual_category = audit_qual_category;
           this.audit_qual_source_id = audit_qual_source_id;
           this.audit_name_title_id = audit_name_title_id;
           this.audit_sales_channel_id = audit_sales_channel_id;
           this.audit_subscription_type_id = audit_subscription_type_id;
           this.oc_id = oc_id;
           this.order_code_id = order_code_id;
    }


    /**
     * Gets the audit_qual_category value for this Audit_data.
     * 
     * @return audit_qual_category
     */
    public int getAudit_qual_category() {
        return audit_qual_category;
    }


    /**
     * Sets the audit_qual_category value for this Audit_data.
     * 
     * @param audit_qual_category
     */
    public void setAudit_qual_category(int audit_qual_category) {
        this.audit_qual_category = audit_qual_category;
    }


    /**
     * Gets the audit_qual_source_id value for this Audit_data.
     * 
     * @return audit_qual_source_id
     */
    public int getAudit_qual_source_id() {
        return audit_qual_source_id;
    }


    /**
     * Sets the audit_qual_source_id value for this Audit_data.
     * 
     * @param audit_qual_source_id
     */
    public void setAudit_qual_source_id(int audit_qual_source_id) {
        this.audit_qual_source_id = audit_qual_source_id;
    }


    /**
     * Gets the audit_name_title_id value for this Audit_data.
     * 
     * @return audit_name_title_id
     */
    public int getAudit_name_title_id() {
        return audit_name_title_id;
    }


    /**
     * Sets the audit_name_title_id value for this Audit_data.
     * 
     * @param audit_name_title_id
     */
    public void setAudit_name_title_id(int audit_name_title_id) {
        this.audit_name_title_id = audit_name_title_id;
    }


    /**
     * Gets the audit_sales_channel_id value for this Audit_data.
     * 
     * @return audit_sales_channel_id
     */
    public int getAudit_sales_channel_id() {
        return audit_sales_channel_id;
    }


    /**
     * Sets the audit_sales_channel_id value for this Audit_data.
     * 
     * @param audit_sales_channel_id
     */
    public void setAudit_sales_channel_id(int audit_sales_channel_id) {
        this.audit_sales_channel_id = audit_sales_channel_id;
    }


    /**
     * Gets the audit_subscription_type_id value for this Audit_data.
     * 
     * @return audit_subscription_type_id
     */
    public int getAudit_subscription_type_id() {
        return audit_subscription_type_id;
    }


    /**
     * Sets the audit_subscription_type_id value for this Audit_data.
     * 
     * @param audit_subscription_type_id
     */
    public void setAudit_subscription_type_id(int audit_subscription_type_id) {
        this.audit_subscription_type_id = audit_subscription_type_id;
    }


    /**
     * Gets the oc_id value for this Audit_data.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Audit_data.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the order_code_id value for this Audit_data.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Audit_data.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Audit_data)) return false;
        Audit_data other = (Audit_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.audit_qual_category == other.getAudit_qual_category() &&
            this.audit_qual_source_id == other.getAudit_qual_source_id() &&
            this.audit_name_title_id == other.getAudit_name_title_id() &&
            this.audit_sales_channel_id == other.getAudit_sales_channel_id() &&
            this.audit_subscription_type_id == other.getAudit_subscription_type_id() &&
            this.oc_id == other.getOc_id() &&
            this.order_code_id == other.getOrder_code_id();
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
        _hashCode += getAudit_qual_category();
        _hashCode += getAudit_qual_source_id();
        _hashCode += getAudit_name_title_id();
        _hashCode += getAudit_sales_channel_id();
        _hashCode += getAudit_subscription_type_id();
        _hashCode += getOc_id();
        _hashCode += getOrder_code_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Audit_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">audit_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audit_qual_category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "audit_qual_category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audit_qual_source_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "audit_qual_source_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audit_name_title_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "audit_name_title_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audit_sales_channel_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "audit_sales_channel_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audit_subscription_type_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "audit_subscription_type_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oc_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "oc_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
