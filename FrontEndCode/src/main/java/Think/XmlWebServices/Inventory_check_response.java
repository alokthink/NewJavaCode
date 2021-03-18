/**
 * Inventory_check_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Inventory_check_response  implements java.io.Serializable {
    private java.lang.String cc_inventory_check_status;  // attribute

    private int quantity_available;  // attribute

    public Inventory_check_response() {
    }

    public Inventory_check_response(
           java.lang.String cc_inventory_check_status,
           int quantity_available) {
           this.cc_inventory_check_status = cc_inventory_check_status;
           this.quantity_available = quantity_available;
    }


    /**
     * Gets the cc_inventory_check_status value for this Inventory_check_response.
     * 
     * @return cc_inventory_check_status
     */
    public java.lang.String getCc_inventory_check_status() {
        return cc_inventory_check_status;
    }


    /**
     * Sets the cc_inventory_check_status value for this Inventory_check_response.
     * 
     * @param cc_inventory_check_status
     */
    public void setCc_inventory_check_status(java.lang.String cc_inventory_check_status) {
        this.cc_inventory_check_status = cc_inventory_check_status;
    }


    /**
     * Gets the quantity_available value for this Inventory_check_response.
     * 
     * @return quantity_available
     */
    public int getQuantity_available() {
        return quantity_available;
    }


    /**
     * Sets the quantity_available value for this Inventory_check_response.
     * 
     * @param quantity_available
     */
    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Inventory_check_response)) return false;
        Inventory_check_response other = (Inventory_check_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cc_inventory_check_status==null && other.getCc_inventory_check_status()==null) || 
             (this.cc_inventory_check_status!=null &&
              this.cc_inventory_check_status.equals(other.getCc_inventory_check_status()))) &&
            this.quantity_available == other.getQuantity_available();
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
        if (getCc_inventory_check_status() != null) {
            _hashCode += getCc_inventory_check_status().hashCode();
        }
        _hashCode += getQuantity_available();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Inventory_check_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">inventory_check_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_inventory_check_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_inventory_check_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quantity_available");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quantity_available"));
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
