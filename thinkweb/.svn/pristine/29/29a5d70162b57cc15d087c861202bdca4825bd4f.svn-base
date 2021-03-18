/**
 * Inventory_sufficient_for_sample_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Inventory_sufficient_for_sample_response  implements java.io.Serializable {
    private boolean inventory_sufficient;  // attribute

    public Inventory_sufficient_for_sample_response() {
    }

    public Inventory_sufficient_for_sample_response(
           boolean inventory_sufficient) {
           this.inventory_sufficient = inventory_sufficient;
    }


    /**
     * Gets the inventory_sufficient value for this Inventory_sufficient_for_sample_response.
     * 
     * @return inventory_sufficient
     */
    public boolean isInventory_sufficient() {
        return inventory_sufficient;
    }


    /**
     * Sets the inventory_sufficient value for this Inventory_sufficient_for_sample_response.
     * 
     * @param inventory_sufficient
     */
    public void setInventory_sufficient(boolean inventory_sufficient) {
        this.inventory_sufficient = inventory_sufficient;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Inventory_sufficient_for_sample_response)) return false;
        Inventory_sufficient_for_sample_response other = (Inventory_sufficient_for_sample_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.inventory_sufficient == other.isInventory_sufficient();
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
        _hashCode += (isInventory_sufficient() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Inventory_sufficient_for_sample_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">inventory_sufficient_for_sample_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inventory_sufficient");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inventory_sufficient"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
