/**
 * ZZDealOrderingCustomer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZDealOrderingCustomer  implements java.io.Serializable {
    private int deal_id;  // attribute

    private int customer_id;  // attribute

    public ZZDealOrderingCustomer() {
    }

    public ZZDealOrderingCustomer(
           int deal_id,
           int customer_id) {
           this.deal_id = deal_id;
           this.customer_id = customer_id;
    }


    /**
     * Gets the deal_id value for this ZZDealOrderingCustomer.
     * 
     * @return deal_id
     */
    public int getDeal_id() {
        return deal_id;
    }


    /**
     * Sets the deal_id value for this ZZDealOrderingCustomer.
     * 
     * @param deal_id
     */
    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }


    /**
     * Gets the customer_id value for this ZZDealOrderingCustomer.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZDealOrderingCustomer.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZDealOrderingCustomer)) return false;
        ZZDealOrderingCustomer other = (ZZDealOrderingCustomer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.deal_id == other.getDeal_id() &&
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
        _hashCode += getDeal_id();
        _hashCode += getCustomer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZDealOrderingCustomer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZDealOrderingCustomer"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deal_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deal_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
