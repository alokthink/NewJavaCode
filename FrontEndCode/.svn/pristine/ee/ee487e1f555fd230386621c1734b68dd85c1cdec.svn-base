/**
 * Column.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Column  implements java.io.Serializable {
    private java.lang.String column_name;  // attribute

    private java.lang.String default_value;  // attribute

    private int auto_default_type;  // attribute

    private boolean nullable;  // attribute

    private java.lang.String data_type;  // attribute

    public Column() {
    }

    public Column(
           java.lang.String column_name,
           java.lang.String default_value,
           int auto_default_type,
           boolean nullable,
           java.lang.String data_type) {
           this.column_name = column_name;
           this.default_value = default_value;
           this.auto_default_type = auto_default_type;
           this.nullable = nullable;
           this.data_type = data_type;
    }


    /**
     * Gets the column_name value for this Column.
     * 
     * @return column_name
     */
    public java.lang.String getColumn_name() {
        return column_name;
    }


    /**
     * Sets the column_name value for this Column.
     * 
     * @param column_name
     */
    public void setColumn_name(java.lang.String column_name) {
        this.column_name = column_name;
    }


    /**
     * Gets the default_value value for this Column.
     * 
     * @return default_value
     */
    public java.lang.String getDefault_value() {
        return default_value;
    }


    /**
     * Sets the default_value value for this Column.
     * 
     * @param default_value
     */
    public void setDefault_value(java.lang.String default_value) {
        this.default_value = default_value;
    }


    /**
     * Gets the auto_default_type value for this Column.
     * 
     * @return auto_default_type
     */
    public int getAuto_default_type() {
        return auto_default_type;
    }


    /**
     * Sets the auto_default_type value for this Column.
     * 
     * @param auto_default_type
     */
    public void setAuto_default_type(int auto_default_type) {
        this.auto_default_type = auto_default_type;
    }


    /**
     * Gets the nullable value for this Column.
     * 
     * @return nullable
     */
    public boolean isNullable() {
        return nullable;
    }


    /**
     * Sets the nullable value for this Column.
     * 
     * @param nullable
     */
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }


    /**
     * Gets the data_type value for this Column.
     * 
     * @return data_type
     */
    public java.lang.String getData_type() {
        return data_type;
    }


    /**
     * Sets the data_type value for this Column.
     * 
     * @param data_type
     */
    public void setData_type(java.lang.String data_type) {
        this.data_type = data_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Column)) return false;
        Column other = (Column) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.column_name==null && other.getColumn_name()==null) || 
             (this.column_name!=null &&
              this.column_name.equals(other.getColumn_name()))) &&
            ((this.default_value==null && other.getDefault_value()==null) || 
             (this.default_value!=null &&
              this.default_value.equals(other.getDefault_value()))) &&
            this.auto_default_type == other.getAuto_default_type() &&
            this.nullable == other.isNullable() &&
            ((this.data_type==null && other.getData_type()==null) || 
             (this.data_type!=null &&
              this.data_type.equals(other.getData_type())));
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
        if (getColumn_name() != null) {
            _hashCode += getColumn_name().hashCode();
        }
        if (getDefault_value() != null) {
            _hashCode += getDefault_value().hashCode();
        }
        _hashCode += getAuto_default_type();
        _hashCode += (isNullable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getData_type() != null) {
            _hashCode += getData_type().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Column.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">column"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("column_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "column_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_value");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_value"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_default_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_default_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nullable");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nullable"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("data_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "data_type"));
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
