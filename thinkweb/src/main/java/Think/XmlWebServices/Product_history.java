/**
 * Product_history.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Product_history  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int qty_shipped_type;  // attribute

    private int qty_shipped;  // attribute

    private java.util.Calendar drop_date;  // attribute

    private java.util.Calendar return_date;  // attribute

    private java.lang.String shipper_ref_nbr;  // attribute

    private int customer_id;  // attribute

    public Product_history() {
    }

    public Product_history(
           int orderhdr_id,
           int qty_shipped_type,
           int qty_shipped,
           java.util.Calendar drop_date,
           java.util.Calendar return_date,
           java.lang.String shipper_ref_nbr,
           int customer_id) {
           this.orderhdr_id = orderhdr_id;
           this.qty_shipped_type = qty_shipped_type;
           this.qty_shipped = qty_shipped;
           this.drop_date = drop_date;
           this.return_date = return_date;
           this.shipper_ref_nbr = shipper_ref_nbr;
           this.customer_id = customer_id;
    }


    /**
     * Gets the orderhdr_id value for this Product_history.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Product_history.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the qty_shipped_type value for this Product_history.
     * 
     * @return qty_shipped_type
     */
    public int getQty_shipped_type() {
        return qty_shipped_type;
    }


    /**
     * Sets the qty_shipped_type value for this Product_history.
     * 
     * @param qty_shipped_type
     */
    public void setQty_shipped_type(int qty_shipped_type) {
        this.qty_shipped_type = qty_shipped_type;
    }


    /**
     * Gets the qty_shipped value for this Product_history.
     * 
     * @return qty_shipped
     */
    public int getQty_shipped() {
        return qty_shipped;
    }


    /**
     * Sets the qty_shipped value for this Product_history.
     * 
     * @param qty_shipped
     */
    public void setQty_shipped(int qty_shipped) {
        this.qty_shipped = qty_shipped;
    }


    /**
     * Gets the drop_date value for this Product_history.
     * 
     * @return drop_date
     */
    public java.util.Calendar getDrop_date() {
        return drop_date;
    }


    /**
     * Sets the drop_date value for this Product_history.
     * 
     * @param drop_date
     */
    public void setDrop_date(java.util.Calendar drop_date) {
        this.drop_date = drop_date;
    }


    /**
     * Gets the return_date value for this Product_history.
     * 
     * @return return_date
     */
    public java.util.Calendar getReturn_date() {
        return return_date;
    }


    /**
     * Sets the return_date value for this Product_history.
     * 
     * @param return_date
     */
    public void setReturn_date(java.util.Calendar return_date) {
        this.return_date = return_date;
    }


    /**
     * Gets the shipper_ref_nbr value for this Product_history.
     * 
     * @return shipper_ref_nbr
     */
    public java.lang.String getShipper_ref_nbr() {
        return shipper_ref_nbr;
    }


    /**
     * Sets the shipper_ref_nbr value for this Product_history.
     * 
     * @param shipper_ref_nbr
     */
    public void setShipper_ref_nbr(java.lang.String shipper_ref_nbr) {
        this.shipper_ref_nbr = shipper_ref_nbr;
    }


    /**
     * Gets the customer_id value for this Product_history.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Product_history.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Product_history)) return false;
        Product_history other = (Product_history) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.qty_shipped_type == other.getQty_shipped_type() &&
            this.qty_shipped == other.getQty_shipped() &&
            ((this.drop_date==null && other.getDrop_date()==null) || 
             (this.drop_date!=null &&
              this.drop_date.equals(other.getDrop_date()))) &&
            ((this.return_date==null && other.getReturn_date()==null) || 
             (this.return_date!=null &&
              this.return_date.equals(other.getReturn_date()))) &&
            ((this.shipper_ref_nbr==null && other.getShipper_ref_nbr()==null) || 
             (this.shipper_ref_nbr!=null &&
              this.shipper_ref_nbr.equals(other.getShipper_ref_nbr()))) &&
            this.customer_id == other.getCustomer_id();
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
        _hashCode += getQty_shipped_type();
        _hashCode += getQty_shipped();
        if (getDrop_date() != null) {
            _hashCode += getDrop_date().hashCode();
        }
        if (getReturn_date() != null) {
            _hashCode += getReturn_date().hashCode();
        }
        if (getShipper_ref_nbr() != null) {
            _hashCode += getShipper_ref_nbr().hashCode();
        }
        _hashCode += getCustomer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Product_history.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">product_history"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_shipped_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_shipped_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_shipped");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_shipped"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("drop_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "drop_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("return_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "return_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("shipper_ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "shipper_ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
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
