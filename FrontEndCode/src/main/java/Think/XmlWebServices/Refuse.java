/**
 * Refuse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Refuse  implements java.io.Serializable {
    private java.lang.String req_elem;  // attribute

    private java.lang.String table_name;  // attribute

    private java.lang.String description;  // attribute

    private java.lang.String error_code;  // attribute

    private Think.XmlWebServices.Refuse_why why;  // attribute

    public Refuse() {
    }

    public Refuse(
           java.lang.String req_elem,
           java.lang.String table_name,
           java.lang.String description,
           java.lang.String error_code,
           Think.XmlWebServices.Refuse_why why) {
           this.req_elem = req_elem;
           this.table_name = table_name;
           this.description = description;
           this.error_code = error_code;
           this.why = why;
    }


    /**
     * Gets the req_elem value for this Refuse.
     * 
     * @return req_elem
     */
    public java.lang.String getReq_elem() {
        return req_elem;
    }


    /**
     * Sets the req_elem value for this Refuse.
     * 
     * @param req_elem
     */
    public void setReq_elem(java.lang.String req_elem) {
        this.req_elem = req_elem;
    }


    /**
     * Gets the table_name value for this Refuse.
     * 
     * @return table_name
     */
    public java.lang.String getTable_name() {
        return table_name;
    }


    /**
     * Sets the table_name value for this Refuse.
     * 
     * @param table_name
     */
    public void setTable_name(java.lang.String table_name) {
        this.table_name = table_name;
    }


    /**
     * Gets the description value for this Refuse.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Refuse.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the error_code value for this Refuse.
     * 
     * @return error_code
     */
    public java.lang.String getError_code() {
        return error_code;
    }


    /**
     * Sets the error_code value for this Refuse.
     * 
     * @param error_code
     */
    public void setError_code(java.lang.String error_code) {
        this.error_code = error_code;
    }


    /**
     * Gets the why value for this Refuse.
     * 
     * @return why
     */
    public Think.XmlWebServices.Refuse_why getWhy() {
        return why;
    }


    /**
     * Sets the why value for this Refuse.
     * 
     * @param why
     */
    public void setWhy(Think.XmlWebServices.Refuse_why why) {
        this.why = why;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Refuse)) return false;
        Refuse other = (Refuse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.req_elem==null && other.getReq_elem()==null) || 
             (this.req_elem!=null &&
              this.req_elem.equals(other.getReq_elem()))) &&
            ((this.table_name==null && other.getTable_name()==null) || 
             (this.table_name!=null &&
              this.table_name.equals(other.getTable_name()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.error_code==null && other.getError_code()==null) || 
             (this.error_code!=null &&
              this.error_code.equals(other.getError_code()))) &&
            ((this.why==null && other.getWhy()==null) || 
             (this.why!=null &&
              this.why.equals(other.getWhy())));
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
        if (getReq_elem() != null) {
            _hashCode += getReq_elem().hashCode();
        }
        if (getTable_name() != null) {
            _hashCode += getTable_name().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getError_code() != null) {
            _hashCode += getError_code().hashCode();
        }
        if (getWhy() != null) {
            _hashCode += getWhy().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Refuse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">refuse"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("req_elem");
        attrField.setXmlName(new javax.xml.namespace.QName("", "req_elem"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("table_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "table_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("error_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "error_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("why");
        attrField.setXmlName(new javax.xml.namespace.QName("", "why"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "refuse_why"));
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
