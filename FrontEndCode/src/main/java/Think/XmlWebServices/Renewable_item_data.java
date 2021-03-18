/**
 * Renewable_item_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Renewable_item_data  implements java.io.Serializable {
    private java.lang.Integer extended_days;

    private java.lang.Integer ext_iss_tot;

    private java.lang.Integer renewal_status;

    private java.lang.Integer payment_account_seq;

    public Renewable_item_data() {
    }

    public Renewable_item_data(
           java.lang.Integer extended_days,
           java.lang.Integer ext_iss_tot,
           java.lang.Integer renewal_status,
           java.lang.Integer payment_account_seq) {
           this.extended_days = extended_days;
           this.ext_iss_tot = ext_iss_tot;
           this.renewal_status = renewal_status;
           this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the extended_days value for this Renewable_item_data.
     * 
     * @return extended_days
     */
    public java.lang.Integer getExtended_days() {
        return extended_days;
    }


    /**
     * Sets the extended_days value for this Renewable_item_data.
     * 
     * @param extended_days
     */
    public void setExtended_days(java.lang.Integer extended_days) {
        this.extended_days = extended_days;
    }


    /**
     * Gets the ext_iss_tot value for this Renewable_item_data.
     * 
     * @return ext_iss_tot
     */
    public java.lang.Integer getExt_iss_tot() {
        return ext_iss_tot;
    }


    /**
     * Sets the ext_iss_tot value for this Renewable_item_data.
     * 
     * @param ext_iss_tot
     */
    public void setExt_iss_tot(java.lang.Integer ext_iss_tot) {
        this.ext_iss_tot = ext_iss_tot;
    }


    /**
     * Gets the renewal_status value for this Renewable_item_data.
     * 
     * @return renewal_status
     */
    public java.lang.Integer getRenewal_status() {
        return renewal_status;
    }


    /**
     * Sets the renewal_status value for this Renewable_item_data.
     * 
     * @param renewal_status
     */
    public void setRenewal_status(java.lang.Integer renewal_status) {
        this.renewal_status = renewal_status;
    }


    /**
     * Gets the payment_account_seq value for this Renewable_item_data.
     * 
     * @return payment_account_seq
     */
    public java.lang.Integer getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Renewable_item_data.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(java.lang.Integer payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Renewable_item_data)) return false;
        Renewable_item_data other = (Renewable_item_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extended_days==null && other.getExtended_days()==null) || 
             (this.extended_days!=null &&
              this.extended_days.equals(other.getExtended_days()))) &&
            ((this.ext_iss_tot==null && other.getExt_iss_tot()==null) || 
             (this.ext_iss_tot!=null &&
              this.ext_iss_tot.equals(other.getExt_iss_tot()))) &&
            ((this.renewal_status==null && other.getRenewal_status()==null) || 
             (this.renewal_status!=null &&
              this.renewal_status.equals(other.getRenewal_status()))) &&
            ((this.payment_account_seq==null && other.getPayment_account_seq()==null) || 
             (this.payment_account_seq!=null &&
              this.payment_account_seq.equals(other.getPayment_account_seq())));
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
        if (getExtended_days() != null) {
            _hashCode += getExtended_days().hashCode();
        }
        if (getExt_iss_tot() != null) {
            _hashCode += getExt_iss_tot().hashCode();
        }
        if (getRenewal_status() != null) {
            _hashCode += getRenewal_status().hashCode();
        }
        if (getPayment_account_seq() != null) {
            _hashCode += getPayment_account_seq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Renewable_item_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewable_item_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extended_days");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "extended_days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext_iss_tot");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ext_iss_tot"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
