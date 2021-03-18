/**
 * Work_table_payment_edit_requestWork_table_payment_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Work_table_payment_edit_requestWork_table_payment_identifier  implements java.io.Serializable {
    private int job_id;

    private int work_table_seq;

    public Work_table_payment_edit_requestWork_table_payment_identifier() {
    }

    public Work_table_payment_edit_requestWork_table_payment_identifier(
           int job_id,
           int work_table_seq) {
           this.job_id = job_id;
           this.work_table_seq = work_table_seq;
    }


    /**
     * Gets the job_id value for this Work_table_payment_edit_requestWork_table_payment_identifier.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Work_table_payment_edit_requestWork_table_payment_identifier.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the work_table_seq value for this Work_table_payment_edit_requestWork_table_payment_identifier.
     * 
     * @return work_table_seq
     */
    public int getWork_table_seq() {
        return work_table_seq;
    }


    /**
     * Sets the work_table_seq value for this Work_table_payment_edit_requestWork_table_payment_identifier.
     * 
     * @param work_table_seq
     */
    public void setWork_table_seq(int work_table_seq) {
        this.work_table_seq = work_table_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Work_table_payment_edit_requestWork_table_payment_identifier)) return false;
        Work_table_payment_edit_requestWork_table_payment_identifier other = (Work_table_payment_edit_requestWork_table_payment_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            this.work_table_seq == other.getWork_table_seq();
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
        _hashCode += getJob_id();
        _hashCode += getWork_table_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Work_table_payment_edit_requestWork_table_payment_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>work_table_payment_edit_request>work_table_payment_identifier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_table_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_table_seq"));
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
