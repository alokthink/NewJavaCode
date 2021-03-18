/**
 * Also_ordered_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Also_ordered_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Also_ordered_list_responseAlso_ordered also_ordered;

    private java.util.Calendar limit_by_date;  // attribute

    private java.lang.String language_code;  // attribute

    public Also_ordered_list_response() {
    }

    public Also_ordered_list_response(
           Think.XmlWebServices.Also_ordered_list_responseAlso_ordered also_ordered,
           java.util.Calendar limit_by_date,
           java.lang.String language_code) {
           this.also_ordered = also_ordered;
           this.limit_by_date = limit_by_date;
           this.language_code = language_code;
    }


    /**
     * Gets the also_ordered value for this Also_ordered_list_response.
     * 
     * @return also_ordered
     */
    public Think.XmlWebServices.Also_ordered_list_responseAlso_ordered getAlso_ordered() {
        return also_ordered;
    }


    /**
     * Sets the also_ordered value for this Also_ordered_list_response.
     * 
     * @param also_ordered
     */
    public void setAlso_ordered(Think.XmlWebServices.Also_ordered_list_responseAlso_ordered also_ordered) {
        this.also_ordered = also_ordered;
    }


    /**
     * Gets the limit_by_date value for this Also_ordered_list_response.
     * 
     * @return limit_by_date
     */
    public java.util.Calendar getLimit_by_date() {
        return limit_by_date;
    }


    /**
     * Sets the limit_by_date value for this Also_ordered_list_response.
     * 
     * @param limit_by_date
     */
    public void setLimit_by_date(java.util.Calendar limit_by_date) {
        this.limit_by_date = limit_by_date;
    }


    /**
     * Gets the language_code value for this Also_ordered_list_response.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Also_ordered_list_response.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Also_ordered_list_response)) return false;
        Also_ordered_list_response other = (Also_ordered_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.also_ordered==null && other.getAlso_ordered()==null) || 
             (this.also_ordered!=null &&
              this.also_ordered.equals(other.getAlso_ordered()))) &&
            ((this.limit_by_date==null && other.getLimit_by_date()==null) || 
             (this.limit_by_date!=null &&
              this.limit_by_date.equals(other.getLimit_by_date()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code())));
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
        if (getAlso_ordered() != null) {
            _hashCode += getAlso_ordered().hashCode();
        }
        if (getLimit_by_date() != null) {
            _hashCode += getLimit_by_date().hashCode();
        }
        if (getLanguage_code() != null) {
            _hashCode += getLanguage_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Also_ordered_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">also_ordered_list_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("limit_by_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "limit_by_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "language_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("also_ordered");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "also_ordered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>also_ordered_list_response>also_ordered"));
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
