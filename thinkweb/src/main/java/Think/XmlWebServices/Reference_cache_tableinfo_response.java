/**
 * Reference_cache_tableinfo_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Reference_cache_tableinfo_response  implements java.io.Serializable {
    private Think.XmlWebServices.Primary_key[] primary_keys;

    private Think.XmlWebServices.Column[] columns;

    public Reference_cache_tableinfo_response() {
    }

    public Reference_cache_tableinfo_response(
           Think.XmlWebServices.Primary_key[] primary_keys,
           Think.XmlWebServices.Column[] columns) {
           this.primary_keys = primary_keys;
           this.columns = columns;
    }


    /**
     * Gets the primary_keys value for this Reference_cache_tableinfo_response.
     * 
     * @return primary_keys
     */
    public Think.XmlWebServices.Primary_key[] getPrimary_keys() {
        return primary_keys;
    }


    /**
     * Sets the primary_keys value for this Reference_cache_tableinfo_response.
     * 
     * @param primary_keys
     */
    public void setPrimary_keys(Think.XmlWebServices.Primary_key[] primary_keys) {
        this.primary_keys = primary_keys;
    }


    /**
     * Gets the columns value for this Reference_cache_tableinfo_response.
     * 
     * @return columns
     */
    public Think.XmlWebServices.Column[] getColumns() {
        return columns;
    }


    /**
     * Sets the columns value for this Reference_cache_tableinfo_response.
     * 
     * @param columns
     */
    public void setColumns(Think.XmlWebServices.Column[] columns) {
        this.columns = columns;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Reference_cache_tableinfo_response)) return false;
        Reference_cache_tableinfo_response other = (Reference_cache_tableinfo_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.primary_keys==null && other.getPrimary_keys()==null) || 
             (this.primary_keys!=null &&
              java.util.Arrays.equals(this.primary_keys, other.getPrimary_keys()))) &&
            ((this.columns==null && other.getColumns()==null) || 
             (this.columns!=null &&
              java.util.Arrays.equals(this.columns, other.getColumns())));
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
        if (getPrimary_keys() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrimary_keys());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrimary_keys(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getColumns() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getColumns());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getColumns(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Reference_cache_tableinfo_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">reference_cache_tableinfo_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primary_keys");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "primary_keys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">primary_keys"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("columns");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "columns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">columns"));
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
