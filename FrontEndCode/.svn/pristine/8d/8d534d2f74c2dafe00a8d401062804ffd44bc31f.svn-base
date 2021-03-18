/**
 * Payment_account_clear_ex_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_account_clear_ex_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Payment payment;

    private Think.XmlWebServices.ZZWorkTablePayment work_table_payment;

    public Payment_account_clear_ex_response() {
    }

    public Payment_account_clear_ex_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Payment payment,
           Think.XmlWebServices.ZZWorkTablePayment work_table_payment) {
           this.customer_identifier = customer_identifier;
           this.payment = payment;
           this.work_table_payment = work_table_payment;
    }


    /**
     * Gets the customer_identifier value for this Payment_account_clear_ex_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_account_clear_ex_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the payment value for this Payment_account_clear_ex_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Payment_account_clear_ex_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }


    /**
     * Gets the work_table_payment value for this Payment_account_clear_ex_response.
     * 
     * @return work_table_payment
     */
    public Think.XmlWebServices.ZZWorkTablePayment getWork_table_payment() {
        return work_table_payment;
    }


    /**
     * Sets the work_table_payment value for this Payment_account_clear_ex_response.
     * 
     * @param work_table_payment
     */
    public void setWork_table_payment(Think.XmlWebServices.ZZWorkTablePayment work_table_payment) {
        this.work_table_payment = work_table_payment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_account_clear_ex_response)) return false;
        Payment_account_clear_ex_response other = (Payment_account_clear_ex_response) obj;
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
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment()))) &&
            ((this.work_table_payment==null && other.getWork_table_payment()==null) || 
             (this.work_table_payment!=null &&
              this.work_table_payment.equals(other.getWork_table_payment())));
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
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        if (getWork_table_payment() != null) {
            _hashCode += getWork_table_payment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_account_clear_ex_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_clear_ex_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_table_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZWorkTablePayment"));
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
