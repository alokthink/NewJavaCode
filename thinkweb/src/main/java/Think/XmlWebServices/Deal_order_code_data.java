/**
 * Deal_order_code_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Deal_order_code_data  implements java.io.Serializable {
    private int order_code_id;

    private int deal_order_code_type;

    private java.lang.Integer source_code_id;

    private Think.XmlWebServices.ZZBoolean delete;  // attribute

    public Deal_order_code_data() {
    }

    public Deal_order_code_data(
           int order_code_id,
           int deal_order_code_type,
           java.lang.Integer source_code_id,
           Think.XmlWebServices.ZZBoolean delete) {
           this.order_code_id = order_code_id;
           this.deal_order_code_type = deal_order_code_type;
           this.source_code_id = source_code_id;
           this.delete = delete;
    }


    /**
     * Gets the order_code_id value for this Deal_order_code_data.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Deal_order_code_data.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the deal_order_code_type value for this Deal_order_code_data.
     * 
     * @return deal_order_code_type
     */
    public int getDeal_order_code_type() {
        return deal_order_code_type;
    }


    /**
     * Sets the deal_order_code_type value for this Deal_order_code_data.
     * 
     * @param deal_order_code_type
     */
    public void setDeal_order_code_type(int deal_order_code_type) {
        this.deal_order_code_type = deal_order_code_type;
    }


    /**
     * Gets the source_code_id value for this Deal_order_code_data.
     * 
     * @return source_code_id
     */
    public java.lang.Integer getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Deal_order_code_data.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(java.lang.Integer source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the delete value for this Deal_order_code_data.
     * 
     * @return delete
     */
    public Think.XmlWebServices.ZZBoolean getDelete() {
        return delete;
    }


    /**
     * Sets the delete value for this Deal_order_code_data.
     * 
     * @param delete
     */
    public void setDelete(Think.XmlWebServices.ZZBoolean delete) {
        this.delete = delete;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deal_order_code_data)) return false;
        Deal_order_code_data other = (Deal_order_code_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.order_code_id == other.getOrder_code_id() &&
            this.deal_order_code_type == other.getDeal_order_code_type() &&
            ((this.source_code_id==null && other.getSource_code_id()==null) || 
             (this.source_code_id!=null &&
              this.source_code_id.equals(other.getSource_code_id()))) &&
            ((this.delete==null && other.getDelete()==null) || 
             (this.delete!=null &&
              this.delete.equals(other.getDelete())));
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
        _hashCode += getOrder_code_id();
        _hashCode += getDeal_order_code_type();
        if (getSource_code_id() != null) {
            _hashCode += getSource_code_id().hashCode();
        }
        if (getDelete() != null) {
            _hashCode += getDelete().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Deal_order_code_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">deal_order_code_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delete");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delete"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_order_code_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_order_code_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "source_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
