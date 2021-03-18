/**
 * Promotion_card_offer_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Promotion_card_offer_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Promotion_card_offer[] promotion_card_from_effort;

    public Promotion_card_offer_list_response() {
    }

    public Promotion_card_offer_list_response(
           Think.XmlWebServices.Promotion_card_offer[] promotion_card_from_effort) {
           this.promotion_card_from_effort = promotion_card_from_effort;
    }


    /**
     * Gets the promotion_card_from_effort value for this Promotion_card_offer_list_response.
     * 
     * @return promotion_card_from_effort
     */
    public Think.XmlWebServices.Promotion_card_offer[] getPromotion_card_from_effort() {
        return promotion_card_from_effort;
    }


    /**
     * Sets the promotion_card_from_effort value for this Promotion_card_offer_list_response.
     * 
     * @param promotion_card_from_effort
     */
    public void setPromotion_card_from_effort(Think.XmlWebServices.Promotion_card_offer[] promotion_card_from_effort) {
        this.promotion_card_from_effort = promotion_card_from_effort;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Promotion_card_offer_list_response)) return false;
        Promotion_card_offer_list_response other = (Promotion_card_offer_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.promotion_card_from_effort==null && other.getPromotion_card_from_effort()==null) || 
             (this.promotion_card_from_effort!=null &&
              java.util.Arrays.equals(this.promotion_card_from_effort, other.getPromotion_card_from_effort())));
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
        if (getPromotion_card_from_effort() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromotion_card_from_effort());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromotion_card_from_effort(), i);
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
        new org.apache.axis.description.TypeDesc(Promotion_card_offer_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">promotion_card_offer_list_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotion_card_from_effort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "promotion_card_from_effort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">promotion_card_from_effort"));
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
