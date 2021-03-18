/**
 * Work_table_payment_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Work_table_payment_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZWorkTablePayment work_table_payment;

    public Work_table_payment_edit_response() {
    }

    public Work_table_payment_edit_response(
           Think.XmlWebServices.ZZWorkTablePayment work_table_payment) {
           this.work_table_payment = work_table_payment;
    }


    /**
     * Gets the work_table_payment value for this Work_table_payment_edit_response.
     * 
     * @return work_table_payment
     */
    public Think.XmlWebServices.ZZWorkTablePayment getWork_table_payment() {
        return work_table_payment;
    }


    /**
     * Sets the work_table_payment value for this Work_table_payment_edit_response.
     * 
     * @param work_table_payment
     */
    public void setWork_table_payment(Think.XmlWebServices.ZZWorkTablePayment work_table_payment) {
        this.work_table_payment = work_table_payment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Work_table_payment_edit_response)) return false;
        Work_table_payment_edit_response other = (Work_table_payment_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
        if (getWork_table_payment() != null) {
            _hashCode += getWork_table_payment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Work_table_payment_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">work_table_payment_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_table_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZWorkTablePayment"));
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
