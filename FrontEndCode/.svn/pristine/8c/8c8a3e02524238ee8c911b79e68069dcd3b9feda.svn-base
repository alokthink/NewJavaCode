/**
 * Customer_credit_status_select_responseCredit_status.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_credit_status_select_responseCredit_status  implements java.io.Serializable {
    private java.lang.String description;  // attribute

    private java.lang.String credit_status;  // attribute

    private int bad_credit;  // attribute

    public Customer_credit_status_select_responseCredit_status() {
    }

    public Customer_credit_status_select_responseCredit_status(
           java.lang.String description,
           java.lang.String credit_status,
           int bad_credit) {
           this.description = description;
           this.credit_status = credit_status;
           this.bad_credit = bad_credit;
    }


    /**
     * Gets the description value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the credit_status value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @return credit_status
     */
    public java.lang.String getCredit_status() {
        return credit_status;
    }


    /**
     * Sets the credit_status value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @param credit_status
     */
    public void setCredit_status(java.lang.String credit_status) {
        this.credit_status = credit_status;
    }


    /**
     * Gets the bad_credit value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @return bad_credit
     */
    public int getBad_credit() {
        return bad_credit;
    }


    /**
     * Sets the bad_credit value for this Customer_credit_status_select_responseCredit_status.
     * 
     * @param bad_credit
     */
    public void setBad_credit(int bad_credit) {
        this.bad_credit = bad_credit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_credit_status_select_responseCredit_status)) return false;
        Customer_credit_status_select_responseCredit_status other = (Customer_credit_status_select_responseCredit_status) obj;
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
            ((this.credit_status==null && other.getCredit_status()==null) || 
             (this.credit_status!=null &&
              this.credit_status.equals(other.getCredit_status()))) &&
            this.bad_credit == other.getBad_credit();
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
        if (getCredit_status() != null) {
            _hashCode += getCredit_status().hashCode();
        }
        _hashCode += getBad_credit();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_credit_status_select_responseCredit_status.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_credit_status_select_response>credit_status"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bad_credit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bad_credit"));
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
