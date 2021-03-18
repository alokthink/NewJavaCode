/**
 * Return_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Return_data  implements java.io.Serializable {
    private int return_qty;

    private Think.XmlWebServices.ZZBoolean return_inventory;  // attribute

    public Return_data() {
    }

    public Return_data(
           int return_qty,
           Think.XmlWebServices.ZZBoolean return_inventory) {
           this.return_qty = return_qty;
           this.return_inventory = return_inventory;
    }


    /**
     * Gets the return_qty value for this Return_data.
     * 
     * @return return_qty
     */
    public int getReturn_qty() {
        return return_qty;
    }


    /**
     * Sets the return_qty value for this Return_data.
     * 
     * @param return_qty
     */
    public void setReturn_qty(int return_qty) {
        this.return_qty = return_qty;
    }


    /**
     * Gets the return_inventory value for this Return_data.
     * 
     * @return return_inventory
     */
    public Think.XmlWebServices.ZZBoolean getReturn_inventory() {
        return return_inventory;
    }


    /**
     * Sets the return_inventory value for this Return_data.
     * 
     * @param return_inventory
     */
    public void setReturn_inventory(Think.XmlWebServices.ZZBoolean return_inventory) {
        this.return_inventory = return_inventory;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Return_data)) return false;
        Return_data other = (Return_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.return_qty == other.getReturn_qty() &&
            ((this.return_inventory==null && other.getReturn_inventory()==null) || 
             (this.return_inventory!=null &&
              this.return_inventory.equals(other.getReturn_inventory())));
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
        _hashCode += getReturn_qty();
        if (getReturn_inventory() != null) {
            _hashCode += getReturn_inventory().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Return_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">return_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("return_inventory");
        attrField.setXmlName(new javax.xml.namespace.QName("", "return_inventory"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("return_qty");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "return_qty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
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
