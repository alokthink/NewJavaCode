/**
 * Back_issue_list_select_responseBack_issue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Back_issue_list_select_responseBack_issue  implements java.io.Serializable {
    private int subscrip_id;  // attribute

    private int issue_id;  // attribute

    private int qty_ordered;  // attribute

    private int qty_sent;  // attribute

    private int status;  // attribute

    private int reason;  // attribute

    private int rollback_job_id;  // attribute

    private int issue_type;  // attribute

    public Back_issue_list_select_responseBack_issue() {
    }

    public Back_issue_list_select_responseBack_issue(
           int subscrip_id,
           int issue_id,
           int qty_ordered,
           int qty_sent,
           int status,
           int reason,
           int rollback_job_id,
           int issue_type) {
           this.subscrip_id = subscrip_id;
           this.issue_id = issue_id;
           this.qty_ordered = qty_ordered;
           this.qty_sent = qty_sent;
           this.status = status;
           this.reason = reason;
           this.rollback_job_id = rollback_job_id;
           this.issue_type = issue_type;
    }


    /**
     * Gets the subscrip_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the issue_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the qty_ordered value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return qty_ordered
     */
    public int getQty_ordered() {
        return qty_ordered;
    }


    /**
     * Sets the qty_ordered value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param qty_ordered
     */
    public void setQty_ordered(int qty_ordered) {
        this.qty_ordered = qty_ordered;
    }


    /**
     * Gets the qty_sent value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return qty_sent
     */
    public int getQty_sent() {
        return qty_sent;
    }


    /**
     * Sets the qty_sent value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param qty_sent
     */
    public void setQty_sent(int qty_sent) {
        this.qty_sent = qty_sent;
    }


    /**
     * Gets the status value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the reason value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return reason
     */
    public int getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param reason
     */
    public void setReason(int reason) {
        this.reason = reason;
    }


    /**
     * Gets the rollback_job_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return rollback_job_id
     */
    public int getRollback_job_id() {
        return rollback_job_id;
    }


    /**
     * Sets the rollback_job_id value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param rollback_job_id
     */
    public void setRollback_job_id(int rollback_job_id) {
        this.rollback_job_id = rollback_job_id;
    }


    /**
     * Gets the issue_type value for this Back_issue_list_select_responseBack_issue.
     * 
     * @return issue_type
     */
    public int getIssue_type() {
        return issue_type;
    }


    /**
     * Sets the issue_type value for this Back_issue_list_select_responseBack_issue.
     * 
     * @param issue_type
     */
    public void setIssue_type(int issue_type) {
        this.issue_type = issue_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Back_issue_list_select_responseBack_issue)) return false;
        Back_issue_list_select_responseBack_issue other = (Back_issue_list_select_responseBack_issue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.subscrip_id == other.getSubscrip_id() &&
            this.issue_id == other.getIssue_id() &&
            this.qty_ordered == other.getQty_ordered() &&
            this.qty_sent == other.getQty_sent() &&
            this.status == other.getStatus() &&
            this.reason == other.getReason() &&
            this.rollback_job_id == other.getRollback_job_id() &&
            this.issue_type == other.getIssue_type();
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
        _hashCode += getSubscrip_id();
        _hashCode += getIssue_id();
        _hashCode += getQty_ordered();
        _hashCode += getQty_sent();
        _hashCode += getStatus();
        _hashCode += getReason();
        _hashCode += getRollback_job_id();
        _hashCode += getIssue_type();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Back_issue_list_select_responseBack_issue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>back_issue_list_select_response>back_issue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_ordered");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_ordered"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_type"));
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
