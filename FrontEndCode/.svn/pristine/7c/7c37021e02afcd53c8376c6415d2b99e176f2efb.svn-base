/**
 * Sales_representative_list_select_responseSales_representative.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Sales_representative_list_select_responseSales_representative  implements java.io.Serializable {
    private int sales_representative_id;  // attribute

    private java.lang.String sales_representative;  // attribute

    private int inactive;  // attribute

    public Sales_representative_list_select_responseSales_representative() {
    }

    public Sales_representative_list_select_responseSales_representative(
           int sales_representative_id,
           java.lang.String sales_representative,
           int inactive) {
           this.sales_representative_id = sales_representative_id;
           this.sales_representative = sales_representative;
           this.inactive = inactive;
    }


    /**
     * Gets the sales_representative_id value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @return sales_representative_id
     */
    public int getSales_representative_id() {
        return sales_representative_id;
    }


    /**
     * Sets the sales_representative_id value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @param sales_representative_id
     */
    public void setSales_representative_id(int sales_representative_id) {
        this.sales_representative_id = sales_representative_id;
    }


    /**
     * Gets the sales_representative value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @return sales_representative
     */
    public java.lang.String getSales_representative() {
        return sales_representative;
    }


    /**
     * Sets the sales_representative value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @param sales_representative
     */
    public void setSales_representative(java.lang.String sales_representative) {
        this.sales_representative = sales_representative;
    }


    /**
     * Gets the inactive value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @return inactive
     */
    public int getInactive() {
        return inactive;
    }


    /**
     * Sets the inactive value for this Sales_representative_list_select_responseSales_representative.
     * 
     * @param inactive
     */
    public void setInactive(int inactive) {
        this.inactive = inactive;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sales_representative_list_select_responseSales_representative)) return false;
        Sales_representative_list_select_responseSales_representative other = (Sales_representative_list_select_responseSales_representative) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.sales_representative_id == other.getSales_representative_id() &&
            ((this.sales_representative==null && other.getSales_representative()==null) || 
             (this.sales_representative!=null &&
              this.sales_representative.equals(other.getSales_representative()))) &&
            this.inactive == other.getInactive();
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
        _hashCode += getSales_representative_id();
        if (getSales_representative() != null) {
            _hashCode += getSales_representative().hashCode();
        }
        _hashCode += getInactive();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sales_representative_list_select_responseSales_representative.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>sales_representative_list_select_response>sales_representative"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sales_representative_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sales_representative_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sales_representative");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sales_representative"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inactive");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inactive"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
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
