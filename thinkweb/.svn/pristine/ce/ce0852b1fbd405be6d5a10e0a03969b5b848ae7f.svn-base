/**
 * Renewal_history_offer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Renewal_history_offer  implements java.io.Serializable {
    private int renewal_history_seq;

    private int renewal_history_offer_seq;

    public Renewal_history_offer() {
    }

    public Renewal_history_offer(
           int renewal_history_seq,
           int renewal_history_offer_seq) {
           this.renewal_history_seq = renewal_history_seq;
           this.renewal_history_offer_seq = renewal_history_offer_seq;
    }


    /**
     * Gets the renewal_history_seq value for this Renewal_history_offer.
     * 
     * @return renewal_history_seq
     */
    public int getRenewal_history_seq() {
        return renewal_history_seq;
    }


    /**
     * Sets the renewal_history_seq value for this Renewal_history_offer.
     * 
     * @param renewal_history_seq
     */
    public void setRenewal_history_seq(int renewal_history_seq) {
        this.renewal_history_seq = renewal_history_seq;
    }


    /**
     * Gets the renewal_history_offer_seq value for this Renewal_history_offer.
     * 
     * @return renewal_history_offer_seq
     */
    public int getRenewal_history_offer_seq() {
        return renewal_history_offer_seq;
    }


    /**
     * Sets the renewal_history_offer_seq value for this Renewal_history_offer.
     * 
     * @param renewal_history_offer_seq
     */
    public void setRenewal_history_offer_seq(int renewal_history_offer_seq) {
        this.renewal_history_offer_seq = renewal_history_offer_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Renewal_history_offer)) return false;
        Renewal_history_offer other = (Renewal_history_offer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.renewal_history_seq == other.getRenewal_history_seq() &&
            this.renewal_history_offer_seq == other.getRenewal_history_offer_seq();
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
        _hashCode += getRenewal_history_seq();
        _hashCode += getRenewal_history_offer_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Renewal_history_offer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_history_offer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_history_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_history_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_history_offer_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_history_offer_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
