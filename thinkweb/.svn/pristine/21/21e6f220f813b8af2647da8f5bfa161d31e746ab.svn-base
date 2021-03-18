/**
 * Key.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Key  implements java.io.Serializable {
    private java.lang.String table_name;  // attribute

    private java.lang.String row_version;  // attribute

    public Key() {
    }

    public Key(
           java.lang.String table_name,
           java.lang.String row_version) {
           this.table_name = table_name;
           this.row_version = row_version;
    }


    /**
     * Gets the table_name value for this Key.
     * 
     * @return table_name
     */
    public java.lang.String getTable_name() {
        return table_name;
    }


    /**
     * Sets the table_name value for this Key.
     * 
     * @param table_name
     */
    public void setTable_name(java.lang.String table_name) {
        this.table_name = table_name;
    }


    /**
     * Gets the row_version value for this Key.
     * 
     * @return row_version
     */
    public java.lang.String getRow_version() {
        return row_version;
    }


    /**
     * Sets the row_version value for this Key.
     * 
     * @param row_version
     */
    public void setRow_version(java.lang.String row_version) {
        this.row_version = row_version;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Key)) return false;
        Key other = (Key) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.table_name==null && other.getTable_name()==null) || 
             (this.table_name!=null &&
              this.table_name.equals(other.getTable_name()))) &&
            ((this.row_version==null && other.getRow_version()==null) || 
             (this.row_version!=null &&
              this.row_version.equals(other.getRow_version())));
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
        if (getTable_name() != null) {
            _hashCode += getTable_name().hashCode();
        }
        if (getRow_version() != null) {
            _hashCode += getRow_version().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Key.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">key"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("table_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "table_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("row_version");
        attrField.setXmlName(new javax.xml.namespace.QName("", "row_version"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
