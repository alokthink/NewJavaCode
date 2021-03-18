/**
 * Promotion_history_offer_list_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Promotion_history_offer_list_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[][] promotion_history;

    public Promotion_history_offer_list_select_response() {
    }

    public Promotion_history_offer_list_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[][] promotion_history) {
           this.customer_identifier = customer_identifier;
           this.promotion_history = promotion_history;
    }


    /**
     * Gets the customer_identifier value for this Promotion_history_offer_list_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Promotion_history_offer_list_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the promotion_history value for this Promotion_history_offer_list_select_response.
     * 
     * @return promotion_history
     */
    public Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[][] getPromotion_history() {
        return promotion_history;
    }


    /**
     * Sets the promotion_history value for this Promotion_history_offer_list_select_response.
     * 
     * @param promotion_history
     */
    public void setPromotion_history(Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[][] promotion_history) {
        this.promotion_history = promotion_history;
    }

    public Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[] getPromotion_history(int i) {
        return this.promotion_history[i];
    }

    public void setPromotion_history(int i, Think.XmlWebServices.Promotion_history_offer_list_select_responsePromotion_historyPromotion_hist_offer[] _value) {
        this.promotion_history[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Promotion_history_offer_list_select_response)) return false;
        Promotion_history_offer_list_select_response other = (Promotion_history_offer_list_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.promotion_history==null && other.getPromotion_history()==null) || 
             (this.promotion_history!=null &&
              java.util.Arrays.equals(this.promotion_history, other.getPromotion_history())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getPromotion_history() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromotion_history());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromotion_history(), i);
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
        new org.apache.axis.description.TypeDesc(Promotion_history_offer_list_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">promotion_history_offer_list_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotion_history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "promotion_history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>promotion_history_offer_list_select_response>promotion_history"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
