/**
 * Distribution_attribute_value.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Distribution_attribute_value  implements java.io.Serializable {
    private java.lang.String distribution_method;

    private java.lang.String distribution_attribute;

    private java.lang.String dist_attribute_value;

    public Distribution_attribute_value() {
    }

    public Distribution_attribute_value(
           java.lang.String distribution_method,
           java.lang.String distribution_attribute,
           java.lang.String dist_attribute_value) {
           this.distribution_method = distribution_method;
           this.distribution_attribute = distribution_attribute;
           this.dist_attribute_value = dist_attribute_value;
    }


    /**
     * Gets the distribution_method value for this Distribution_attribute_value.
     * 
     * @return distribution_method
     */
    public java.lang.String getDistribution_method() {
        return distribution_method;
    }


    /**
     * Sets the distribution_method value for this Distribution_attribute_value.
     * 
     * @param distribution_method
     */
    public void setDistribution_method(java.lang.String distribution_method) {
        this.distribution_method = distribution_method;
    }


    /**
     * Gets the distribution_attribute value for this Distribution_attribute_value.
     * 
     * @return distribution_attribute
     */
    public java.lang.String getDistribution_attribute() {
        return distribution_attribute;
    }


    /**
     * Sets the distribution_attribute value for this Distribution_attribute_value.
     * 
     * @param distribution_attribute
     */
    public void setDistribution_attribute(java.lang.String distribution_attribute) {
        this.distribution_attribute = distribution_attribute;
    }


    /**
     * Gets the dist_attribute_value value for this Distribution_attribute_value.
     * 
     * @return dist_attribute_value
     */
    public java.lang.String getDist_attribute_value() {
        return dist_attribute_value;
    }


    /**
     * Sets the dist_attribute_value value for this Distribution_attribute_value.
     * 
     * @param dist_attribute_value
     */
    public void setDist_attribute_value(java.lang.String dist_attribute_value) {
        this.dist_attribute_value = dist_attribute_value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Distribution_attribute_value)) return false;
        Distribution_attribute_value other = (Distribution_attribute_value) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.distribution_method==null && other.getDistribution_method()==null) || 
             (this.distribution_method!=null &&
              this.distribution_method.equals(other.getDistribution_method()))) &&
            ((this.distribution_attribute==null && other.getDistribution_attribute()==null) || 
             (this.distribution_attribute!=null &&
              this.distribution_attribute.equals(other.getDistribution_attribute()))) &&
            ((this.dist_attribute_value==null && other.getDist_attribute_value()==null) || 
             (this.dist_attribute_value!=null &&
              this.dist_attribute_value.equals(other.getDist_attribute_value())));
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
        if (getDistribution_method() != null) {
            _hashCode += getDistribution_method().hashCode();
        }
        if (getDistribution_attribute() != null) {
            _hashCode += getDistribution_attribute().hashCode();
        }
        if (getDist_attribute_value() != null) {
            _hashCode += getDist_attribute_value().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Distribution_attribute_value.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">distribution_attribute_value"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distribution_method");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "distribution_method"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distribution_attribute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "distribution_attribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dist_attribute_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dist_attribute_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
