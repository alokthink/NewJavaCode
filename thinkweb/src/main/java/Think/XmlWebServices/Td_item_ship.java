/**
 * Td_item_ship.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_item_ship  extends Think.XmlWebServices.ZZOrderItemShip  implements java.io.Serializable {
    private java.lang.String date_stamp_descr;  // attribute

    private java.lang.String user_code_descr;  // attribute

    public Td_item_ship() {
    }

    public Td_item_ship(
           int orderhdr_id,
           int order_item_seq,
           int order_item_ship_seq,
           int date_stamp,
           int fifo_seq,
           int inventory_id,
           int job_id,
           java.lang.String profit_center,
           int profit_center_calendar_seq,
           int qty_shipped,
           int qty_shipped_type,
           java.util.Date return_date,
           int revenue_status,
           java.lang.String shipper_ref_nbr,
           java.lang.String user_code,
           java.lang.String date_stamp_descr,
           java.lang.String user_code_descr) {
        super(
            orderhdr_id,
            order_item_seq,
            order_item_ship_seq,
            date_stamp,
            fifo_seq,
            inventory_id,
            job_id,
            profit_center,
            profit_center_calendar_seq,
            qty_shipped,
            qty_shipped_type,
            return_date,
            revenue_status,
            shipper_ref_nbr,
            user_code);
        this.date_stamp_descr = date_stamp_descr;
        this.user_code_descr = user_code_descr;
    }


    /**
     * Gets the date_stamp_descr value for this Td_item_ship.
     * 
     * @return date_stamp_descr
     */
    public java.lang.String getDate_stamp_descr() {
        return date_stamp_descr;
    }


    /**
     * Sets the date_stamp_descr value for this Td_item_ship.
     * 
     * @param date_stamp_descr
     */
    public void setDate_stamp_descr(java.lang.String date_stamp_descr) {
        this.date_stamp_descr = date_stamp_descr;
    }


    /**
     * Gets the user_code_descr value for this Td_item_ship.
     * 
     * @return user_code_descr
     */
    public java.lang.String getUser_code_descr() {
        return user_code_descr;
    }


    /**
     * Sets the user_code_descr value for this Td_item_ship.
     * 
     * @param user_code_descr
     */
    public void setUser_code_descr(java.lang.String user_code_descr) {
        this.user_code_descr = user_code_descr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_item_ship)) return false;
        Td_item_ship other = (Td_item_ship) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.date_stamp_descr==null && other.getDate_stamp_descr()==null) || 
             (this.date_stamp_descr!=null &&
              this.date_stamp_descr.equals(other.getDate_stamp_descr()))) &&
            ((this.user_code_descr==null && other.getUser_code_descr()==null) || 
             (this.user_code_descr!=null &&
              this.user_code_descr.equals(other.getUser_code_descr())));
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
        if (getDate_stamp_descr() != null) {
            _hashCode += getDate_stamp_descr().hashCode();
        }
        if (getUser_code_descr() != null) {
            _hashCode += getUser_code_descr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_item_ship.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_item_ship"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code_descr"));
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
