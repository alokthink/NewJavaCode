/**
 * Change_bundle_quantity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Change_bundle_quantity  implements java.io.Serializable {
    private java.math.BigDecimal price;  // attribute

    private int bundle_quantity;  // attribute

    public Change_bundle_quantity() {
    }

    public Change_bundle_quantity(
           java.math.BigDecimal price,
           int bundle_quantity) {
           this.price = price;
           this.bundle_quantity = bundle_quantity;
    }


    /**
     * Gets the price value for this Change_bundle_quantity.
     * 
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Change_bundle_quantity.
     * 
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the bundle_quantity value for this Change_bundle_quantity.
     * 
     * @return bundle_quantity
     */
    public int getBundle_quantity() {
        return bundle_quantity;
    }


    /**
     * Sets the bundle_quantity value for this Change_bundle_quantity.
     * 
     * @param bundle_quantity
     */
    public void setBundle_quantity(int bundle_quantity) {
        this.bundle_quantity = bundle_quantity;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Change_bundle_quantity)) return false;
        Change_bundle_quantity other = (Change_bundle_quantity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            this.bundle_quantity == other.getBundle_quantity();
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
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        _hashCode += getBundle_quantity();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Change_bundle_quantity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_bundle_quantity"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bundle_quantity");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bundle_quantity"));
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
