/**
 * Px_detail_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_detail_data  implements java.io.Serializable {
    private java.lang.String table_name;

    private java.lang.String column_name;

    private java.lang.String target_value;

    private java.lang.String import_value;

    private java.lang.String message_string;

    private java.lang.Integer bad_value;

    public Px_detail_data() {
    }

    public Px_detail_data(
           java.lang.String table_name,
           java.lang.String column_name,
           java.lang.String target_value,
           java.lang.String import_value,
           java.lang.String message_string,
           java.lang.Integer bad_value) {
           this.table_name = table_name;
           this.column_name = column_name;
           this.target_value = target_value;
           this.import_value = import_value;
           this.message_string = message_string;
           this.bad_value = bad_value;
    }


    /**
     * Gets the table_name value for this Px_detail_data.
     * 
     * @return table_name
     */
    public java.lang.String getTable_name() {
        return table_name;
    }


    /**
     * Sets the table_name value for this Px_detail_data.
     * 
     * @param table_name
     */
    public void setTable_name(java.lang.String table_name) {
        this.table_name = table_name;
    }


    /**
     * Gets the column_name value for this Px_detail_data.
     * 
     * @return column_name
     */
    public java.lang.String getColumn_name() {
        return column_name;
    }


    /**
     * Sets the column_name value for this Px_detail_data.
     * 
     * @param column_name
     */
    public void setColumn_name(java.lang.String column_name) {
        this.column_name = column_name;
    }


    /**
     * Gets the target_value value for this Px_detail_data.
     * 
     * @return target_value
     */
    public java.lang.String getTarget_value() {
        return target_value;
    }


    /**
     * Sets the target_value value for this Px_detail_data.
     * 
     * @param target_value
     */
    public void setTarget_value(java.lang.String target_value) {
        this.target_value = target_value;
    }


    /**
     * Gets the import_value value for this Px_detail_data.
     * 
     * @return import_value
     */
    public java.lang.String getImport_value() {
        return import_value;
    }


    /**
     * Sets the import_value value for this Px_detail_data.
     * 
     * @param import_value
     */
    public void setImport_value(java.lang.String import_value) {
        this.import_value = import_value;
    }


    /**
     * Gets the message_string value for this Px_detail_data.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this Px_detail_data.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }


    /**
     * Gets the bad_value value for this Px_detail_data.
     * 
     * @return bad_value
     */
    public java.lang.Integer getBad_value() {
        return bad_value;
    }


    /**
     * Sets the bad_value value for this Px_detail_data.
     * 
     * @param bad_value
     */
    public void setBad_value(java.lang.Integer bad_value) {
        this.bad_value = bad_value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_detail_data)) return false;
        Px_detail_data other = (Px_detail_data) obj;
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
            ((this.column_name==null && other.getColumn_name()==null) || 
             (this.column_name!=null &&
              this.column_name.equals(other.getColumn_name()))) &&
            ((this.target_value==null && other.getTarget_value()==null) || 
             (this.target_value!=null &&
              this.target_value.equals(other.getTarget_value()))) &&
            ((this.import_value==null && other.getImport_value()==null) || 
             (this.import_value!=null &&
              this.import_value.equals(other.getImport_value()))) &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string()))) &&
            ((this.bad_value==null && other.getBad_value()==null) || 
             (this.bad_value!=null &&
              this.bad_value.equals(other.getBad_value())));
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
        if (getColumn_name() != null) {
            _hashCode += getColumn_name().hashCode();
        }
        if (getTarget_value() != null) {
            _hashCode += getTarget_value().hashCode();
        }
        if (getImport_value() != null) {
            _hashCode += getImport_value().hashCode();
        }
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        if (getBad_value() != null) {
            _hashCode += getBad_value().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_detail_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">px_detail_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "table_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("column_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "column_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("target_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "target_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("import_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "import_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message_string");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "message_string"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bad_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bad_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
