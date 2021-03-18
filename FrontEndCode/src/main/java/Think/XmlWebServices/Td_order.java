/**
 * Td_order.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_order  extends Think.XmlWebServices.ZZOrderhdr  implements java.io.Serializable {
    private Think.XmlWebServices.Td_item[] td_item;

    private Think.XmlWebServices.Td_package[] td_package;

    private java.math.BigDecimal price;  // attribute

    private java.math.BigDecimal tax;  // attribute

    private java.math.BigDecimal delivery;  // attribute

    private java.math.BigDecimal comm;  // attribute

    private java.math.BigDecimal total;  // attribute

    public Td_order() {
    }

    public Td_order(
           int orderhdr_id,
           java.util.Calendar order_date,
           java.lang.String po_number,
           java.math.BigDecimal price,
           java.math.BigDecimal tax,
           java.math.BigDecimal delivery,
           java.math.BigDecimal comm,
           java.math.BigDecimal total,
           Think.XmlWebServices.Td_item[] td_item,
           Think.XmlWebServices.Td_package[] td_package) {
        super(
            orderhdr_id,
            order_date,
            po_number);
        this.price = price;
        this.tax = tax;
        this.delivery = delivery;
        this.comm = comm;
        this.total = total;
        this.td_item = td_item;
        this.td_package = td_package;
    }


    /**
     * Gets the td_item value for this Td_order.
     * 
     * @return td_item
     */
    public Think.XmlWebServices.Td_item[] getTd_item() {
        return td_item;
    }


    /**
     * Sets the td_item value for this Td_order.
     * 
     * @param td_item
     */
    public void setTd_item(Think.XmlWebServices.Td_item[] td_item) {
        this.td_item = td_item;
    }

    public Think.XmlWebServices.Td_item getTd_item(int i) {
        return this.td_item[i];
    }

    public void setTd_item(int i, Think.XmlWebServices.Td_item _value) {
        this.td_item[i] = _value;
    }


    /**
     * Gets the td_package value for this Td_order.
     * 
     * @return td_package
     */
    public Think.XmlWebServices.Td_package[] getTd_package() {
        return td_package;
    }


    /**
     * Sets the td_package value for this Td_order.
     * 
     * @param td_package
     */
    public void setTd_package(Think.XmlWebServices.Td_package[] td_package) {
        this.td_package = td_package;
    }

    public Think.XmlWebServices.Td_package getTd_package(int i) {
        return this.td_package[i];
    }

    public void setTd_package(int i, Think.XmlWebServices.Td_package _value) {
        this.td_package[i] = _value;
    }


    /**
     * Gets the price value for this Td_order.
     * 
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Td_order.
     * 
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the tax value for this Td_order.
     * 
     * @return tax
     */
    public java.math.BigDecimal getTax() {
        return tax;
    }


    /**
     * Sets the tax value for this Td_order.
     * 
     * @param tax
     */
    public void setTax(java.math.BigDecimal tax) {
        this.tax = tax;
    }


    /**
     * Gets the delivery value for this Td_order.
     * 
     * @return delivery
     */
    public java.math.BigDecimal getDelivery() {
        return delivery;
    }


    /**
     * Sets the delivery value for this Td_order.
     * 
     * @param delivery
     */
    public void setDelivery(java.math.BigDecimal delivery) {
        this.delivery = delivery;
    }


    /**
     * Gets the comm value for this Td_order.
     * 
     * @return comm
     */
    public java.math.BigDecimal getComm() {
        return comm;
    }


    /**
     * Sets the comm value for this Td_order.
     * 
     * @param comm
     */
    public void setComm(java.math.BigDecimal comm) {
        this.comm = comm;
    }


    /**
     * Gets the total value for this Td_order.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this Td_order.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_order)) return false;
        Td_order other = (Td_order) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.td_item==null && other.getTd_item()==null) || 
             (this.td_item!=null &&
              java.util.Arrays.equals(this.td_item, other.getTd_item()))) &&
            ((this.td_package==null && other.getTd_package()==null) || 
             (this.td_package!=null &&
              java.util.Arrays.equals(this.td_package, other.getTd_package()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.tax==null && other.getTax()==null) || 
             (this.tax!=null &&
              this.tax.equals(other.getTax()))) &&
            ((this.delivery==null && other.getDelivery()==null) || 
             (this.delivery!=null &&
              this.delivery.equals(other.getDelivery()))) &&
            ((this.comm==null && other.getComm()==null) || 
             (this.comm!=null &&
              this.comm.equals(other.getComm()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getTd_item() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_item());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_item(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTd_package() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_package());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_package(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getTax() != null) {
            _hashCode += getTax().hashCode();
        }
        if (getDelivery() != null) {
            _hashCode += getDelivery().hashCode();
        }
        if (getComm() != null) {
            _hashCode += getComm().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_order.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_order"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tax");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tax"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delivery");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delivery"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("comm");
        attrField.setXmlName(new javax.xml.namespace.QName("", "comm"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("total");
        attrField.setXmlName(new javax.xml.namespace.QName("", "total"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_item"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_package");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_package"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_package"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
