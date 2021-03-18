/**
 * Jqs_alert_add_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_alert_add_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZJqsAlert jqs_alert;

    public Jqs_alert_add_response() {
    }

    public Jqs_alert_add_response(
           Think.XmlWebServices.ZZJqsAlert jqs_alert) {
           this.jqs_alert = jqs_alert;
    }


    /**
     * Gets the jqs_alert value for this Jqs_alert_add_response.
     * 
     * @return jqs_alert
     */
    public Think.XmlWebServices.ZZJqsAlert getJqs_alert() {
        return jqs_alert;
    }


    /**
     * Sets the jqs_alert value for this Jqs_alert_add_response.
     * 
     * @param jqs_alert
     */
    public void setJqs_alert(Think.XmlWebServices.ZZJqsAlert jqs_alert) {
        this.jqs_alert = jqs_alert;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_alert_add_response)) return false;
        Jqs_alert_add_response other = (Jqs_alert_add_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jqs_alert==null && other.getJqs_alert()==null) || 
             (this.jqs_alert!=null &&
              this.jqs_alert.equals(other.getJqs_alert())));
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
        if (getJqs_alert() != null) {
            _hashCode += getJqs_alert().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_alert_add_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_alert_add_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_alert");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_alert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZJqsAlert"));
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
