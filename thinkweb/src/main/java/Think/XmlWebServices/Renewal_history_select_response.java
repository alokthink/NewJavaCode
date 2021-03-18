/**
 * Renewal_history_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Renewal_history_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Renewal_history_select_responseRenewal_history renewal_history;

    public Renewal_history_select_response() {
    }

    public Renewal_history_select_response(
           Think.XmlWebServices.Renewal_history_select_responseRenewal_history renewal_history) {
           this.renewal_history = renewal_history;
    }


    /**
     * Gets the renewal_history value for this Renewal_history_select_response.
     * 
     * @return renewal_history
     */
    public Think.XmlWebServices.Renewal_history_select_responseRenewal_history getRenewal_history() {
        return renewal_history;
    }


    /**
     * Sets the renewal_history value for this Renewal_history_select_response.
     * 
     * @param renewal_history
     */
    public void setRenewal_history(Think.XmlWebServices.Renewal_history_select_responseRenewal_history renewal_history) {
        this.renewal_history = renewal_history;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Renewal_history_select_response)) return false;
        Renewal_history_select_response other = (Renewal_history_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.renewal_history==null && other.getRenewal_history()==null) || 
             (this.renewal_history!=null &&
              this.renewal_history.equals(other.getRenewal_history())));
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
        if (getRenewal_history() != null) {
            _hashCode += getRenewal_history().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Renewal_history_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_history_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>renewal_history_select_response>renewal_history"));
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
