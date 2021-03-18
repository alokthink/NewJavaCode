/**
 * Billing_effort_history.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Billing_effort_history  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int effort_number;  // attribute

    private int installment_number;  // attribute

    private int process_id;  // attribute

    private java.util.Calendar drop_date;  // attribute

    private java.lang.String description;  // attribute

    private int customer_id;  // attribute

    public Billing_effort_history() {
    }

    public Billing_effort_history(
           int orderhdr_id,
           int effort_number,
           int installment_number,
           int process_id,
           java.util.Calendar drop_date,
           java.lang.String description,
           int customer_id) {
           this.orderhdr_id = orderhdr_id;
           this.effort_number = effort_number;
           this.installment_number = installment_number;
           this.process_id = process_id;
           this.drop_date = drop_date;
           this.description = description;
           this.customer_id = customer_id;
    }


    /**
     * Gets the orderhdr_id value for this Billing_effort_history.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Billing_effort_history.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the effort_number value for this Billing_effort_history.
     * 
     * @return effort_number
     */
    public int getEffort_number() {
        return effort_number;
    }


    /**
     * Sets the effort_number value for this Billing_effort_history.
     * 
     * @param effort_number
     */
    public void setEffort_number(int effort_number) {
        this.effort_number = effort_number;
    }


    /**
     * Gets the installment_number value for this Billing_effort_history.
     * 
     * @return installment_number
     */
    public int getInstallment_number() {
        return installment_number;
    }


    /**
     * Sets the installment_number value for this Billing_effort_history.
     * 
     * @param installment_number
     */
    public void setInstallment_number(int installment_number) {
        this.installment_number = installment_number;
    }


    /**
     * Gets the process_id value for this Billing_effort_history.
     * 
     * @return process_id
     */
    public int getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this Billing_effort_history.
     * 
     * @param process_id
     */
    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the drop_date value for this Billing_effort_history.
     * 
     * @return drop_date
     */
    public java.util.Calendar getDrop_date() {
        return drop_date;
    }


    /**
     * Sets the drop_date value for this Billing_effort_history.
     * 
     * @param drop_date
     */
    public void setDrop_date(java.util.Calendar drop_date) {
        this.drop_date = drop_date;
    }


    /**
     * Gets the description value for this Billing_effort_history.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Billing_effort_history.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the customer_id value for this Billing_effort_history.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Billing_effort_history.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Billing_effort_history)) return false;
        Billing_effort_history other = (Billing_effort_history) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.effort_number == other.getEffort_number() &&
            this.installment_number == other.getInstallment_number() &&
            this.process_id == other.getProcess_id() &&
            ((this.drop_date==null && other.getDrop_date()==null) || 
             (this.drop_date!=null &&
              this.drop_date.equals(other.getDrop_date()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.customer_id == other.getCustomer_id();
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
        _hashCode += getOrderhdr_id();
        _hashCode += getEffort_number();
        _hashCode += getInstallment_number();
        _hashCode += getProcess_id();
        if (getDrop_date() != null) {
            _hashCode += getDrop_date().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getCustomer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Billing_effort_history.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">billing_effort_history"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("effort_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "effort_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("drop_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "drop_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
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
