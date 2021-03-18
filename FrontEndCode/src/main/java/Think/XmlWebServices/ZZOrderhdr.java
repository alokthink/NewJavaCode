/**
 * ZZOrderhdr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZOrderhdr  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private java.util.Calendar order_date;  // attribute

    private java.lang.String po_number;  // attribute

    public ZZOrderhdr() {
    }

    public ZZOrderhdr(
           int orderhdr_id,
           java.util.Calendar order_date,
           java.lang.String po_number) {
           this.orderhdr_id = orderhdr_id;
           this.order_date = order_date;
           this.po_number = po_number;
    }


    /**
     * Gets the orderhdr_id value for this ZZOrderhdr.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZOrderhdr.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_date value for this ZZOrderhdr.
     * 
     * @return order_date
     */
    public java.util.Calendar getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this ZZOrderhdr.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Calendar order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the po_number value for this ZZOrderhdr.
     * 
     * @return po_number
     */
    public java.lang.String getPo_number() {
        return po_number;
    }


    /**
     * Sets the po_number value for this ZZOrderhdr.
     * 
     * @param po_number
     */
    public void setPo_number(java.lang.String po_number) {
        this.po_number = po_number;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZOrderhdr)) return false;
        ZZOrderhdr other = (ZZOrderhdr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            ((this.po_number==null && other.getPo_number()==null) || 
             (this.po_number!=null &&
              this.po_number.equals(other.getPo_number())));
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
        _hashCode += getOrderhdr_id();
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        if (getPo_number() != null) {
            _hashCode += getPo_number().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZOrderhdr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderhdr"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("po_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "po_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
