/**
 * Reference_cache_change_count_responseTable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Reference_cache_change_count_responseTable  implements java.io.Serializable {
    private java.lang.String table_name;  // attribute

    private int change_count;  // attribute

    public Reference_cache_change_count_responseTable() {
    }

    public Reference_cache_change_count_responseTable(
           java.lang.String table_name,
           int change_count) {
           this.table_name = table_name;
           this.change_count = change_count;
    }


    /**
     * Gets the table_name value for this Reference_cache_change_count_responseTable.
     * 
     * @return table_name
     */
    public java.lang.String getTable_name() {
        return table_name;
    }


    /**
     * Sets the table_name value for this Reference_cache_change_count_responseTable.
     * 
     * @param table_name
     */
    public void setTable_name(java.lang.String table_name) {
        this.table_name = table_name;
    }


    /**
     * Gets the change_count value for this Reference_cache_change_count_responseTable.
     * 
     * @return change_count
     */
    public int getChange_count() {
        return change_count;
    }


    /**
     * Sets the change_count value for this Reference_cache_change_count_responseTable.
     * 
     * @param change_count
     */
    public void setChange_count(int change_count) {
        this.change_count = change_count;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Reference_cache_change_count_responseTable)) return false;
        Reference_cache_change_count_responseTable other = (Reference_cache_change_count_responseTable) obj;
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
            this.change_count == other.getChange_count();
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
        _hashCode += getChange_count();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Reference_cache_change_count_responseTable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>reference_cache_change_count_response>table"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("table_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "table_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("change_count");
        attrField.setXmlName(new javax.xml.namespace.QName("", "change_count"));
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
