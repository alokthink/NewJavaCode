/**
 * Missed_issues_list_select_responseMissed_issues.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Missed_issues_list_select_responseMissed_issues  implements java.io.Serializable {
    private int subscrip_id;  // attribute

    private int issue_id;  // attribute

    public Missed_issues_list_select_responseMissed_issues() {
    }

    public Missed_issues_list_select_responseMissed_issues(
           int subscrip_id,
           int issue_id) {
           this.subscrip_id = subscrip_id;
           this.issue_id = issue_id;
    }


    /**
     * Gets the subscrip_id value for this Missed_issues_list_select_responseMissed_issues.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Missed_issues_list_select_responseMissed_issues.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the issue_id value for this Missed_issues_list_select_responseMissed_issues.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Missed_issues_list_select_responseMissed_issues.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Missed_issues_list_select_responseMissed_issues)) return false;
        Missed_issues_list_select_responseMissed_issues other = (Missed_issues_list_select_responseMissed_issues) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.subscrip_id == other.getSubscrip_id() &&
            this.issue_id == other.getIssue_id();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Missed_issues_list_select_responseMissed_issues.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>missed_issues_list_select_response>missed_issues"));
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
