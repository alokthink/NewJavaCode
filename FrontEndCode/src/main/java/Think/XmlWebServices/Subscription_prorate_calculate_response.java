/**
 * Subscription_prorate_calculate_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subscription_prorate_calculate_response  implements java.io.Serializable {
    private Think.XmlWebServices.Order_item_prorate_amounts[] subscription_prorate_amounts;

    public Subscription_prorate_calculate_response() {
    }

    public Subscription_prorate_calculate_response(
           Think.XmlWebServices.Order_item_prorate_amounts[] subscription_prorate_amounts) {
           this.subscription_prorate_amounts = subscription_prorate_amounts;
    }


    /**
     * Gets the subscription_prorate_amounts value for this Subscription_prorate_calculate_response.
     * 
     * @return subscription_prorate_amounts
     */
    public Think.XmlWebServices.Order_item_prorate_amounts[] getSubscription_prorate_amounts() {
        return subscription_prorate_amounts;
    }


    /**
     * Sets the subscription_prorate_amounts value for this Subscription_prorate_calculate_response.
     * 
     * @param subscription_prorate_amounts
     */
    public void setSubscription_prorate_amounts(Think.XmlWebServices.Order_item_prorate_amounts[] subscription_prorate_amounts) {
        this.subscription_prorate_amounts = subscription_prorate_amounts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subscription_prorate_calculate_response)) return false;
        Subscription_prorate_calculate_response other = (Subscription_prorate_calculate_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subscription_prorate_amounts==null && other.getSubscription_prorate_amounts()==null) || 
             (this.subscription_prorate_amounts!=null &&
              java.util.Arrays.equals(this.subscription_prorate_amounts, other.getSubscription_prorate_amounts())));
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
        if (getSubscription_prorate_amounts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubscription_prorate_amounts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubscription_prorate_amounts(), i);
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
        new org.apache.axis.description.TypeDesc(Subscription_prorate_calculate_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscription_prorate_calculate_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscription_prorate_amounts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscription_prorate_amounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscription_prorate_amounts"));
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
