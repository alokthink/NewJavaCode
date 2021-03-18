/**
 * Renewal_card_offer_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Renewal_card_offer_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Ren_card_order_code[] renewal_card_from_effort;

    public Renewal_card_offer_list_response() {
    }

    public Renewal_card_offer_list_response(
           Think.XmlWebServices.Ren_card_order_code[] renewal_card_from_effort) {
           this.renewal_card_from_effort = renewal_card_from_effort;
    }


    /**
     * Gets the renewal_card_from_effort value for this Renewal_card_offer_list_response.
     * 
     * @return renewal_card_from_effort
     */
    public Think.XmlWebServices.Ren_card_order_code[] getRenewal_card_from_effort() {
        return renewal_card_from_effort;
    }


    /**
     * Sets the renewal_card_from_effort value for this Renewal_card_offer_list_response.
     * 
     * @param renewal_card_from_effort
     */
    public void setRenewal_card_from_effort(Think.XmlWebServices.Ren_card_order_code[] renewal_card_from_effort) {
        this.renewal_card_from_effort = renewal_card_from_effort;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Renewal_card_offer_list_response)) return false;
        Renewal_card_offer_list_response other = (Renewal_card_offer_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.renewal_card_from_effort==null && other.getRenewal_card_from_effort()==null) || 
             (this.renewal_card_from_effort!=null &&
              java.util.Arrays.equals(this.renewal_card_from_effort, other.getRenewal_card_from_effort())));
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
        if (getRenewal_card_from_effort() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRenewal_card_from_effort());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRenewal_card_from_effort(), i);
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
        new org.apache.axis.description.TypeDesc(Renewal_card_offer_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_card_offer_list_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_card_from_effort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_card_from_effort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_card_from_effort"));
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
