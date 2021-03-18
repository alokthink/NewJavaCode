/**
 * Credit_card_payment_clear_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Credit_card_payment_clear_response  implements java.io.Serializable {
    private Think.XmlWebServices.Payment payment;

    private Think.XmlWebServices.ZZWorkTablePayment[] work_table_payment;

    public Credit_card_payment_clear_response() {
    }

    public Credit_card_payment_clear_response(
           Think.XmlWebServices.Payment payment,
           Think.XmlWebServices.ZZWorkTablePayment[] work_table_payment) {
           this.payment = payment;
           this.work_table_payment = work_table_payment;
    }


    /**
     * Gets the payment value for this Credit_card_payment_clear_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Credit_card_payment_clear_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }


    /**
     * Gets the work_table_payment value for this Credit_card_payment_clear_response.
     * 
     * @return work_table_payment
     */
    public Think.XmlWebServices.ZZWorkTablePayment[] getWork_table_payment() {
        return work_table_payment;
    }


    /**
     * Sets the work_table_payment value for this Credit_card_payment_clear_response.
     * 
     * @param work_table_payment
     */
    public void setWork_table_payment(Think.XmlWebServices.ZZWorkTablePayment[] work_table_payment) {
        this.work_table_payment = work_table_payment;
    }

    public Think.XmlWebServices.ZZWorkTablePayment getWork_table_payment(int i) {
        return this.work_table_payment[i];
    }

    public void setWork_table_payment(int i, Think.XmlWebServices.ZZWorkTablePayment _value) {
        this.work_table_payment[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Credit_card_payment_clear_response)) return false;
        Credit_card_payment_clear_response other = (Credit_card_payment_clear_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment()))) &&
            ((this.work_table_payment==null && other.getWork_table_payment()==null) || 
             (this.work_table_payment!=null &&
              java.util.Arrays.equals(this.work_table_payment, other.getWork_table_payment())));
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
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        if (getWork_table_payment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWork_table_payment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWork_table_payment(), i);
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
        new org.apache.axis.description.TypeDesc(Credit_card_payment_clear_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">credit_card_payment_clear_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_table_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_payment"));
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
