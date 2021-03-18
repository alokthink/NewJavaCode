/**
 * ZZInstallmentPlan.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZInstallmentPlan  implements java.io.Serializable {
    private int installment_plan_id;  // attribute

    private int allow_default_usage;  // attribute

    private int auto_setup;  // attribute

    private java.lang.String description;  // attribute

    private int interval;  // attribute

    private int interval_type;  // attribute

    private int nbr_installments;  // attribute

    private java.lang.String report;  // attribute

    private int unpaid_issues_new;  // attribute

    private int unpaid_issues_renew;  // attribute

    public ZZInstallmentPlan() {
    }

    public ZZInstallmentPlan(
           int installment_plan_id,
           int allow_default_usage,
           int auto_setup,
           java.lang.String description,
           int interval,
           int interval_type,
           int nbr_installments,
           java.lang.String report,
           int unpaid_issues_new,
           int unpaid_issues_renew) {
           this.installment_plan_id = installment_plan_id;
           this.allow_default_usage = allow_default_usage;
           this.auto_setup = auto_setup;
           this.description = description;
           this.interval = interval;
           this.interval_type = interval_type;
           this.nbr_installments = nbr_installments;
           this.report = report;
           this.unpaid_issues_new = unpaid_issues_new;
           this.unpaid_issues_renew = unpaid_issues_renew;
    }


    /**
     * Gets the installment_plan_id value for this ZZInstallmentPlan.
     * 
     * @return installment_plan_id
     */
    public int getInstallment_plan_id() {
        return installment_plan_id;
    }


    /**
     * Sets the installment_plan_id value for this ZZInstallmentPlan.
     * 
     * @param installment_plan_id
     */
    public void setInstallment_plan_id(int installment_plan_id) {
        this.installment_plan_id = installment_plan_id;
    }


    /**
     * Gets the allow_default_usage value for this ZZInstallmentPlan.
     * 
     * @return allow_default_usage
     */
    public int getAllow_default_usage() {
        return allow_default_usage;
    }


    /**
     * Sets the allow_default_usage value for this ZZInstallmentPlan.
     * 
     * @param allow_default_usage
     */
    public void setAllow_default_usage(int allow_default_usage) {
        this.allow_default_usage = allow_default_usage;
    }


    /**
     * Gets the auto_setup value for this ZZInstallmentPlan.
     * 
     * @return auto_setup
     */
    public int getAuto_setup() {
        return auto_setup;
    }


    /**
     * Sets the auto_setup value for this ZZInstallmentPlan.
     * 
     * @param auto_setup
     */
    public void setAuto_setup(int auto_setup) {
        this.auto_setup = auto_setup;
    }


    /**
     * Gets the description value for this ZZInstallmentPlan.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZInstallmentPlan.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the interval value for this ZZInstallmentPlan.
     * 
     * @return interval
     */
    public int getInterval() {
        return interval;
    }


    /**
     * Sets the interval value for this ZZInstallmentPlan.
     * 
     * @param interval
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }


    /**
     * Gets the interval_type value for this ZZInstallmentPlan.
     * 
     * @return interval_type
     */
    public int getInterval_type() {
        return interval_type;
    }


    /**
     * Sets the interval_type value for this ZZInstallmentPlan.
     * 
     * @param interval_type
     */
    public void setInterval_type(int interval_type) {
        this.interval_type = interval_type;
    }


    /**
     * Gets the nbr_installments value for this ZZInstallmentPlan.
     * 
     * @return nbr_installments
     */
    public int getNbr_installments() {
        return nbr_installments;
    }


    /**
     * Sets the nbr_installments value for this ZZInstallmentPlan.
     * 
     * @param nbr_installments
     */
    public void setNbr_installments(int nbr_installments) {
        this.nbr_installments = nbr_installments;
    }


    /**
     * Gets the report value for this ZZInstallmentPlan.
     * 
     * @return report
     */
    public java.lang.String getReport() {
        return report;
    }


    /**
     * Sets the report value for this ZZInstallmentPlan.
     * 
     * @param report
     */
    public void setReport(java.lang.String report) {
        this.report = report;
    }


    /**
     * Gets the unpaid_issues_new value for this ZZInstallmentPlan.
     * 
     * @return unpaid_issues_new
     */
    public int getUnpaid_issues_new() {
        return unpaid_issues_new;
    }


    /**
     * Sets the unpaid_issues_new value for this ZZInstallmentPlan.
     * 
     * @param unpaid_issues_new
     */
    public void setUnpaid_issues_new(int unpaid_issues_new) {
        this.unpaid_issues_new = unpaid_issues_new;
    }


    /**
     * Gets the unpaid_issues_renew value for this ZZInstallmentPlan.
     * 
     * @return unpaid_issues_renew
     */
    public int getUnpaid_issues_renew() {
        return unpaid_issues_renew;
    }


    /**
     * Sets the unpaid_issues_renew value for this ZZInstallmentPlan.
     * 
     * @param unpaid_issues_renew
     */
    public void setUnpaid_issues_renew(int unpaid_issues_renew) {
        this.unpaid_issues_renew = unpaid_issues_renew;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZInstallmentPlan)) return false;
        ZZInstallmentPlan other = (ZZInstallmentPlan) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.installment_plan_id == other.getInstallment_plan_id() &&
            this.allow_default_usage == other.getAllow_default_usage() &&
            this.auto_setup == other.getAuto_setup() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.interval == other.getInterval() &&
            this.interval_type == other.getInterval_type() &&
            this.nbr_installments == other.getNbr_installments() &&
            ((this.report==null && other.getReport()==null) || 
             (this.report!=null &&
              this.report.equals(other.getReport()))) &&
            this.unpaid_issues_new == other.getUnpaid_issues_new() &&
            this.unpaid_issues_renew == other.getUnpaid_issues_renew();
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
        _hashCode += getInstallment_plan_id();
        _hashCode += getAllow_default_usage();
        _hashCode += getAuto_setup();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getInterval();
        _hashCode += getInterval_type();
        _hashCode += getNbr_installments();
        if (getReport() != null) {
            _hashCode += getReport().hashCode();
        }
        _hashCode += getUnpaid_issues_new();
        _hashCode += getUnpaid_issues_renew();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZInstallmentPlan.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZInstallmentPlan"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_plan_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_plan_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("allow_default_usage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "allow_default_usage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_setup");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_setup"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("interval");
        attrField.setXmlName(new javax.xml.namespace.QName("", "interval"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("interval_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "interval_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nbr_installments");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nbr_installments"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("report");
        attrField.setXmlName(new javax.xml.namespace.QName("", "report"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unpaid_issues_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unpaid_issues_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unpaid_issues_renew");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unpaid_issues_renew"));
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
