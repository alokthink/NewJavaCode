/**
 * Ip_address_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Ip_address_data  implements java.io.Serializable {
    private java.lang.String low_ip_dotted;

    private java.lang.String high_ip_dotted;

    public Ip_address_data() {
    }

    public Ip_address_data(
           java.lang.String low_ip_dotted,
           java.lang.String high_ip_dotted) {
           this.low_ip_dotted = low_ip_dotted;
           this.high_ip_dotted = high_ip_dotted;
    }


    /**
     * Gets the low_ip_dotted value for this Ip_address_data.
     * 
     * @return low_ip_dotted
     */
    public java.lang.String getLow_ip_dotted() {
        return low_ip_dotted;
    }


    /**
     * Sets the low_ip_dotted value for this Ip_address_data.
     * 
     * @param low_ip_dotted
     */
    public void setLow_ip_dotted(java.lang.String low_ip_dotted) {
        this.low_ip_dotted = low_ip_dotted;
    }


    /**
     * Gets the high_ip_dotted value for this Ip_address_data.
     * 
     * @return high_ip_dotted
     */
    public java.lang.String getHigh_ip_dotted() {
        return high_ip_dotted;
    }


    /**
     * Sets the high_ip_dotted value for this Ip_address_data.
     * 
     * @param high_ip_dotted
     */
    public void setHigh_ip_dotted(java.lang.String high_ip_dotted) {
        this.high_ip_dotted = high_ip_dotted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ip_address_data)) return false;
        Ip_address_data other = (Ip_address_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.low_ip_dotted==null && other.getLow_ip_dotted()==null) || 
             (this.low_ip_dotted!=null &&
              this.low_ip_dotted.equals(other.getLow_ip_dotted()))) &&
            ((this.high_ip_dotted==null && other.getHigh_ip_dotted()==null) || 
             (this.high_ip_dotted!=null &&
              this.high_ip_dotted.equals(other.getHigh_ip_dotted())));
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
        if (getLow_ip_dotted() != null) {
            _hashCode += getLow_ip_dotted().hashCode();
        }
        if (getHigh_ip_dotted() != null) {
            _hashCode += getHigh_ip_dotted().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ip_address_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">ip_address_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("low_ip_dotted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "low_ip_dotted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("high_ip_dotted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "high_ip_dotted"));
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
