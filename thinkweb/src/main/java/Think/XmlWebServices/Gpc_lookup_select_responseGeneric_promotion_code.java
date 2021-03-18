/**
 * Gpc_lookup_select_responseGeneric_promotion_code.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Gpc_lookup_select_responseGeneric_promotion_code  implements java.io.Serializable {
    private int source_code_id;  // attribute

    private int generic_promotion_code_seq;  // attribute

    private java.lang.String promotion_code;  // attribute

    private int qty_limit;  // attribute

    private int qty_used;  // attribute

    public Gpc_lookup_select_responseGeneric_promotion_code() {
    }

    public Gpc_lookup_select_responseGeneric_promotion_code(
           int source_code_id,
           int generic_promotion_code_seq,
           java.lang.String promotion_code,
           int qty_limit,
           int qty_used) {
           this.source_code_id = source_code_id;
           this.generic_promotion_code_seq = generic_promotion_code_seq;
           this.promotion_code = promotion_code;
           this.qty_limit = qty_limit;
           this.qty_used = qty_used;
    }


    /**
     * Gets the source_code_id value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the generic_promotion_code_seq value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @return generic_promotion_code_seq
     */
    public int getGeneric_promotion_code_seq() {
        return generic_promotion_code_seq;
    }


    /**
     * Sets the generic_promotion_code_seq value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @param generic_promotion_code_seq
     */
    public void setGeneric_promotion_code_seq(int generic_promotion_code_seq) {
        this.generic_promotion_code_seq = generic_promotion_code_seq;
    }


    /**
     * Gets the promotion_code value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @return promotion_code
     */
    public java.lang.String getPromotion_code() {
        return promotion_code;
    }


    /**
     * Sets the promotion_code value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @param promotion_code
     */
    public void setPromotion_code(java.lang.String promotion_code) {
        this.promotion_code = promotion_code;
    }


    /**
     * Gets the qty_limit value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @return qty_limit
     */
    public int getQty_limit() {
        return qty_limit;
    }


    /**
     * Sets the qty_limit value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @param qty_limit
     */
    public void setQty_limit(int qty_limit) {
        this.qty_limit = qty_limit;
    }


    /**
     * Gets the qty_used value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @return qty_used
     */
    public int getQty_used() {
        return qty_used;
    }


    /**
     * Sets the qty_used value for this Gpc_lookup_select_responseGeneric_promotion_code.
     * 
     * @param qty_used
     */
    public void setQty_used(int qty_used) {
        this.qty_used = qty_used;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Gpc_lookup_select_responseGeneric_promotion_code)) return false;
        Gpc_lookup_select_responseGeneric_promotion_code other = (Gpc_lookup_select_responseGeneric_promotion_code) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.source_code_id == other.getSource_code_id() &&
            this.generic_promotion_code_seq == other.getGeneric_promotion_code_seq() &&
            ((this.promotion_code==null && other.getPromotion_code()==null) || 
             (this.promotion_code!=null &&
              this.promotion_code.equals(other.getPromotion_code()))) &&
            this.qty_limit == other.getQty_limit() &&
            this.qty_used == other.getQty_used();
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
        _hashCode += getSource_code_id();
        _hashCode += getGeneric_promotion_code_seq();
        if (getPromotion_code() != null) {
            _hashCode += getPromotion_code().hashCode();
        }
        _hashCode += getQty_limit();
        _hashCode += getQty_used();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Gpc_lookup_select_responseGeneric_promotion_code.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>gpc_lookup_select_response>generic_promotion_code"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("generic_promotion_code_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "generic_promotion_code_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotion_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotion_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_limit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_limit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_used");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_used"));
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
