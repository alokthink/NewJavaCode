/**
 * Refund_calculate_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Refund_calculate_response  implements java.io.Serializable {
    private Think.XmlWebServices.Cancel_item_info[] cancel_item_info;

    private Think.XmlWebServices.Payment payment;

    public Refund_calculate_response() {
    }

    public Refund_calculate_response(
           Think.XmlWebServices.Cancel_item_info[] cancel_item_info,
           Think.XmlWebServices.Payment payment) {
           this.cancel_item_info = cancel_item_info;
           this.payment = payment;
    }


    /**
     * Gets the cancel_item_info value for this Refund_calculate_response.
     * 
     * @return cancel_item_info
     */
    public Think.XmlWebServices.Cancel_item_info[] getCancel_item_info() {
        return cancel_item_info;
    }


    /**
     * Sets the cancel_item_info value for this Refund_calculate_response.
     * 
     * @param cancel_item_info
     */
    public void setCancel_item_info(Think.XmlWebServices.Cancel_item_info[] cancel_item_info) {
        this.cancel_item_info = cancel_item_info;
    }

    public Think.XmlWebServices.Cancel_item_info getCancel_item_info(int i) {
        return this.cancel_item_info[i];
    }

    public void setCancel_item_info(int i, Think.XmlWebServices.Cancel_item_info _value) {
        this.cancel_item_info[i] = _value;
    }


    /**
     * Gets the payment value for this Refund_calculate_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Refund_calculate_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Refund_calculate_response)) return false;
        Refund_calculate_response other = (Refund_calculate_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancel_item_info==null && other.getCancel_item_info()==null) || 
             (this.cancel_item_info!=null &&
              java.util.Arrays.equals(this.cancel_item_info, other.getCancel_item_info()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment())));
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
        if (getCancel_item_info() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCancel_item_info());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCancel_item_info(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Refund_calculate_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">refund_calculate_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_item_info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_item_info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_item_info"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
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
