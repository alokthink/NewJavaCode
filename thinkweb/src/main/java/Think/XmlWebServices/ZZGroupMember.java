/**
 * ZZGroupMember.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZGroupMember  implements java.io.Serializable {
    private int customer_group_customer_id;  // attribute

    private int customer_id;  // attribute

    private int active;  // attribute

    private int authorized;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int customer_address_seq;  // attribute

    private int n_copies;  // attribute

    private int processing_priority;  // attribute

    public ZZGroupMember() {
    }

    public ZZGroupMember(
           int customer_group_customer_id,
           int customer_id,
           int active,
           int authorized,
           java.util.Calendar creation_date,
           int customer_address_seq,
           int n_copies,
           int processing_priority) {
           this.customer_group_customer_id = customer_group_customer_id;
           this.customer_id = customer_id;
           this.active = active;
           this.authorized = authorized;
           this.creation_date = creation_date;
           this.customer_address_seq = customer_address_seq;
           this.n_copies = n_copies;
           this.processing_priority = processing_priority;
    }


    /**
     * Gets the customer_group_customer_id value for this ZZGroupMember.
     * 
     * @return customer_group_customer_id
     */
    public int getCustomer_group_customer_id() {
        return customer_group_customer_id;
    }


    /**
     * Sets the customer_group_customer_id value for this ZZGroupMember.
     * 
     * @param customer_group_customer_id
     */
    public void setCustomer_group_customer_id(int customer_group_customer_id) {
        this.customer_group_customer_id = customer_group_customer_id;
    }


    /**
     * Gets the customer_id value for this ZZGroupMember.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZGroupMember.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the active value for this ZZGroupMember.
     * 
     * @return active
     */
    public int getActive() {
        return active;
    }


    /**
     * Sets the active value for this ZZGroupMember.
     * 
     * @param active
     */
    public void setActive(int active) {
        this.active = active;
    }


    /**
     * Gets the authorized value for this ZZGroupMember.
     * 
     * @return authorized
     */
    public int getAuthorized() {
        return authorized;
    }


    /**
     * Sets the authorized value for this ZZGroupMember.
     * 
     * @param authorized
     */
    public void setAuthorized(int authorized) {
        this.authorized = authorized;
    }


    /**
     * Gets the creation_date value for this ZZGroupMember.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZGroupMember.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the customer_address_seq value for this ZZGroupMember.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this ZZGroupMember.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the n_copies value for this ZZGroupMember.
     * 
     * @return n_copies
     */
    public int getN_copies() {
        return n_copies;
    }


    /**
     * Sets the n_copies value for this ZZGroupMember.
     * 
     * @param n_copies
     */
    public void setN_copies(int n_copies) {
        this.n_copies = n_copies;
    }


    /**
     * Gets the processing_priority value for this ZZGroupMember.
     * 
     * @return processing_priority
     */
    public int getProcessing_priority() {
        return processing_priority;
    }


    /**
     * Sets the processing_priority value for this ZZGroupMember.
     * 
     * @param processing_priority
     */
    public void setProcessing_priority(int processing_priority) {
        this.processing_priority = processing_priority;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZGroupMember)) return false;
        ZZGroupMember other = (ZZGroupMember) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_group_customer_id == other.getCustomer_group_customer_id() &&
            this.customer_id == other.getCustomer_id() &&
            this.active == other.getActive() &&
            this.authorized == other.getAuthorized() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            this.n_copies == other.getN_copies() &&
            this.processing_priority == other.getProcessing_priority();
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
        _hashCode += getCustomer_group_customer_id();
        _hashCode += getCustomer_id();
        _hashCode += getActive();
        _hashCode += getAuthorized();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getCustomer_address_seq();
        _hashCode += getN_copies();
        _hashCode += getProcessing_priority();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZGroupMember.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZGroupMember"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_group_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_group_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("active");
        attrField.setXmlName(new javax.xml.namespace.QName("", "active"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("authorized");
        attrField.setXmlName(new javax.xml.namespace.QName("", "authorized"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_copies");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_copies"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("processing_priority");
        attrField.setXmlName(new javax.xml.namespace.QName("", "processing_priority"));
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
