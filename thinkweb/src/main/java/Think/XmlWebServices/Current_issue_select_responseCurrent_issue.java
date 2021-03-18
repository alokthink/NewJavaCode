/**
 * Current_issue_select_responseCurrent_issue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Current_issue_select_responseCurrent_issue  implements java.io.Serializable {
    private java.lang.String description;  // attribute

    private java.lang.String subscriber_site_long_desc;  // attribute

    private int oc_id;  // attribute

    private int issue_id;  // attribute

    private java.lang.String enumeration;  // attribute

    private java.util.Date next_issue;  // attribute

    public Current_issue_select_responseCurrent_issue() {
    }

    public Current_issue_select_responseCurrent_issue(
           java.lang.String description,
           java.lang.String subscriber_site_long_desc,
           int oc_id,
           int issue_id,
           java.lang.String enumeration,
           java.util.Date next_issue) {
           this.description = description;
           this.subscriber_site_long_desc = subscriber_site_long_desc;
           this.oc_id = oc_id;
           this.issue_id = issue_id;
           this.enumeration = enumeration;
           this.next_issue = next_issue;
    }


    /**
     * Gets the description value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the subscriber_site_long_desc value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return subscriber_site_long_desc
     */
    public java.lang.String getSubscriber_site_long_desc() {
        return subscriber_site_long_desc;
    }


    /**
     * Sets the subscriber_site_long_desc value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param subscriber_site_long_desc
     */
    public void setSubscriber_site_long_desc(java.lang.String subscriber_site_long_desc) {
        this.subscriber_site_long_desc = subscriber_site_long_desc;
    }


    /**
     * Gets the oc_id value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the issue_id value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the enumeration value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return enumeration
     */
    public java.lang.String getEnumeration() {
        return enumeration;
    }


    /**
     * Sets the enumeration value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param enumeration
     */
    public void setEnumeration(java.lang.String enumeration) {
        this.enumeration = enumeration;
    }


    /**
     * Gets the next_issue value for this Current_issue_select_responseCurrent_issue.
     * 
     * @return next_issue
     */
    public java.util.Date getNext_issue() {
        return next_issue;
    }


    /**
     * Sets the next_issue value for this Current_issue_select_responseCurrent_issue.
     * 
     * @param next_issue
     */
    public void setNext_issue(java.util.Date next_issue) {
        this.next_issue = next_issue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Current_issue_select_responseCurrent_issue)) return false;
        Current_issue_select_responseCurrent_issue other = (Current_issue_select_responseCurrent_issue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.subscriber_site_long_desc==null && other.getSubscriber_site_long_desc()==null) || 
             (this.subscriber_site_long_desc!=null &&
              this.subscriber_site_long_desc.equals(other.getSubscriber_site_long_desc()))) &&
            this.oc_id == other.getOc_id() &&
            this.issue_id == other.getIssue_id() &&
            ((this.enumeration==null && other.getEnumeration()==null) || 
             (this.enumeration!=null &&
              this.enumeration.equals(other.getEnumeration()))) &&
            ((this.next_issue==null && other.getNext_issue()==null) || 
             (this.next_issue!=null &&
              this.next_issue.equals(other.getNext_issue())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSubscriber_site_long_desc() != null) {
            _hashCode += getSubscriber_site_long_desc().hashCode();
        }
        _hashCode += getOc_id();
        _hashCode += getIssue_id();
        if (getEnumeration() != null) {
            _hashCode += getEnumeration().hashCode();
        }
        if (getNext_issue() != null) {
            _hashCode += getNext_issue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Current_issue_select_responseCurrent_issue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>current_issue_select_response>current_issue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscriber_site_long_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscriber_site_long_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("next_issue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "next_issue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
