/**
 * Installment_detail_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Installment_detail_data  implements java.io.Serializable {
    private int installment_number;

    private java.math.BigDecimal install_amount;

    public Installment_detail_data() {
    }

    public Installment_detail_data(
           int installment_number,
           java.math.BigDecimal install_amount) {
           this.installment_number = installment_number;
           this.install_amount = install_amount;
    }


    /**
     * Gets the installment_number value for this Installment_detail_data.
     * 
     * @return installment_number
     */
    public int getInstallment_number() {
        return installment_number;
    }


    /**
     * Sets the installment_number value for this Installment_detail_data.
     * 
     * @param installment_number
     */
    public void setInstallment_number(int installment_number) {
        this.installment_number = installment_number;
    }


    /**
     * Gets the install_amount value for this Installment_detail_data.
     * 
     * @return install_amount
     */
    public java.math.BigDecimal getInstall_amount() {
        return install_amount;
    }


    /**
     * Sets the install_amount value for this Installment_detail_data.
     * 
     * @param install_amount
     */
    public void setInstall_amount(java.math.BigDecimal install_amount) {
        this.install_amount = install_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Installment_detail_data)) return false;
        Installment_detail_data other = (Installment_detail_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.installment_number == other.getInstallment_number() &&
            ((this.install_amount==null && other.getInstall_amount()==null) || 
             (this.install_amount!=null &&
              this.install_amount.equals(other.getInstall_amount())));
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
        _hashCode += getInstallment_number();
        if (getInstall_amount() != null) {
            _hashCode += getInstall_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Installment_detail_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">installment_detail_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installment_number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "installment_number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("install_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "install_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
