/**
 * ZZOrderItemShip.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZOrderItemShip  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int order_item_ship_seq;  // attribute

    private int date_stamp;  // attribute

    private int fifo_seq;  // attribute

    private int inventory_id;  // attribute

    private int job_id;  // attribute

    private java.lang.String profit_center;  // attribute

    private int profit_center_calendar_seq;  // attribute

    private int qty_shipped;  // attribute

    private int qty_shipped_type;  // attribute

    private java.util.Date return_date;  // attribute

    private int revenue_status;  // attribute

    private java.lang.String shipper_ref_nbr;  // attribute

    private java.lang.String user_code;  // attribute

    public ZZOrderItemShip() {
    }

    public ZZOrderItemShip(
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
           java.lang.String user_code) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.order_item_ship_seq = order_item_ship_seq;
           this.date_stamp = date_stamp;
           this.fifo_seq = fifo_seq;
           this.inventory_id = inventory_id;
           this.job_id = job_id;
           this.profit_center = profit_center;
           this.profit_center_calendar_seq = profit_center_calendar_seq;
           this.qty_shipped = qty_shipped;
           this.qty_shipped_type = qty_shipped_type;
           this.return_date = return_date;
           this.revenue_status = revenue_status;
           this.shipper_ref_nbr = shipper_ref_nbr;
           this.user_code = user_code;
    }


    /**
     * Gets the orderhdr_id value for this ZZOrderItemShip.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZOrderItemShip.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this ZZOrderItemShip.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZOrderItemShip.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the order_item_ship_seq value for this ZZOrderItemShip.
     * 
     * @return order_item_ship_seq
     */
    public int getOrder_item_ship_seq() {
        return order_item_ship_seq;
    }


    /**
     * Sets the order_item_ship_seq value for this ZZOrderItemShip.
     * 
     * @param order_item_ship_seq
     */
    public void setOrder_item_ship_seq(int order_item_ship_seq) {
        this.order_item_ship_seq = order_item_ship_seq;
    }


    /**
     * Gets the date_stamp value for this ZZOrderItemShip.
     * 
     * @return date_stamp
     */
    public int getDate_stamp() {
        return date_stamp;
    }


    /**
     * Sets the date_stamp value for this ZZOrderItemShip.
     * 
     * @param date_stamp
     */
    public void setDate_stamp(int date_stamp) {
        this.date_stamp = date_stamp;
    }


    /**
     * Gets the fifo_seq value for this ZZOrderItemShip.
     * 
     * @return fifo_seq
     */
    public int getFifo_seq() {
        return fifo_seq;
    }


    /**
     * Sets the fifo_seq value for this ZZOrderItemShip.
     * 
     * @param fifo_seq
     */
    public void setFifo_seq(int fifo_seq) {
        this.fifo_seq = fifo_seq;
    }


    /**
     * Gets the inventory_id value for this ZZOrderItemShip.
     * 
     * @return inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }


    /**
     * Sets the inventory_id value for this ZZOrderItemShip.
     * 
     * @param inventory_id
     */
    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }


    /**
     * Gets the job_id value for this ZZOrderItemShip.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this ZZOrderItemShip.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the profit_center value for this ZZOrderItemShip.
     * 
     * @return profit_center
     */
    public java.lang.String getProfit_center() {
        return profit_center;
    }


    /**
     * Sets the profit_center value for this ZZOrderItemShip.
     * 
     * @param profit_center
     */
    public void setProfit_center(java.lang.String profit_center) {
        this.profit_center = profit_center;
    }


    /**
     * Gets the profit_center_calendar_seq value for this ZZOrderItemShip.
     * 
     * @return profit_center_calendar_seq
     */
    public int getProfit_center_calendar_seq() {
        return profit_center_calendar_seq;
    }


    /**
     * Sets the profit_center_calendar_seq value for this ZZOrderItemShip.
     * 
     * @param profit_center_calendar_seq
     */
    public void setProfit_center_calendar_seq(int profit_center_calendar_seq) {
        this.profit_center_calendar_seq = profit_center_calendar_seq;
    }


    /**
     * Gets the qty_shipped value for this ZZOrderItemShip.
     * 
     * @return qty_shipped
     */
    public int getQty_shipped() {
        return qty_shipped;
    }


    /**
     * Sets the qty_shipped value for this ZZOrderItemShip.
     * 
     * @param qty_shipped
     */
    public void setQty_shipped(int qty_shipped) {
        this.qty_shipped = qty_shipped;
    }


    /**
     * Gets the qty_shipped_type value for this ZZOrderItemShip.
     * 
     * @return qty_shipped_type
     */
    public int getQty_shipped_type() {
        return qty_shipped_type;
    }


    /**
     * Sets the qty_shipped_type value for this ZZOrderItemShip.
     * 
     * @param qty_shipped_type
     */
    public void setQty_shipped_type(int qty_shipped_type) {
        this.qty_shipped_type = qty_shipped_type;
    }


    /**
     * Gets the return_date value for this ZZOrderItemShip.
     * 
     * @return return_date
     */
    public java.util.Date getReturn_date() {
        return return_date;
    }


    /**
     * Sets the return_date value for this ZZOrderItemShip.
     * 
     * @param return_date
     */
    public void setReturn_date(java.util.Date return_date) {
        this.return_date = return_date;
    }


    /**
     * Gets the revenue_status value for this ZZOrderItemShip.
     * 
     * @return revenue_status
     */
    public int getRevenue_status() {
        return revenue_status;
    }


    /**
     * Sets the revenue_status value for this ZZOrderItemShip.
     * 
     * @param revenue_status
     */
    public void setRevenue_status(int revenue_status) {
        this.revenue_status = revenue_status;
    }


    /**
     * Gets the shipper_ref_nbr value for this ZZOrderItemShip.
     * 
     * @return shipper_ref_nbr
     */
    public java.lang.String getShipper_ref_nbr() {
        return shipper_ref_nbr;
    }


    /**
     * Sets the shipper_ref_nbr value for this ZZOrderItemShip.
     * 
     * @param shipper_ref_nbr
     */
    public void setShipper_ref_nbr(java.lang.String shipper_ref_nbr) {
        this.shipper_ref_nbr = shipper_ref_nbr;
    }


    /**
     * Gets the user_code value for this ZZOrderItemShip.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this ZZOrderItemShip.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZOrderItemShip)) return false;
        ZZOrderItemShip other = (ZZOrderItemShip) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.order_item_ship_seq == other.getOrder_item_ship_seq() &&
            this.date_stamp == other.getDate_stamp() &&
            this.fifo_seq == other.getFifo_seq() &&
            this.inventory_id == other.getInventory_id() &&
            this.job_id == other.getJob_id() &&
            ((this.profit_center==null && other.getProfit_center()==null) || 
             (this.profit_center!=null &&
              this.profit_center.equals(other.getProfit_center()))) &&
            this.profit_center_calendar_seq == other.getProfit_center_calendar_seq() &&
            this.qty_shipped == other.getQty_shipped() &&
            this.qty_shipped_type == other.getQty_shipped_type() &&
            ((this.return_date==null && other.getReturn_date()==null) || 
             (this.return_date!=null &&
              this.return_date.equals(other.getReturn_date()))) &&
            this.revenue_status == other.getRevenue_status() &&
            ((this.shipper_ref_nbr==null && other.getShipper_ref_nbr()==null) || 
             (this.shipper_ref_nbr!=null &&
              this.shipper_ref_nbr.equals(other.getShipper_ref_nbr()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code())));
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
        _hashCode += getOrder_item_seq();
        _hashCode += getOrder_item_ship_seq();
        _hashCode += getDate_stamp();
        _hashCode += getFifo_seq();
        _hashCode += getInventory_id();
        _hashCode += getJob_id();
        if (getProfit_center() != null) {
            _hashCode += getProfit_center().hashCode();
        }
        _hashCode += getProfit_center_calendar_seq();
        _hashCode += getQty_shipped();
        _hashCode += getQty_shipped_type();
        if (getReturn_date() != null) {
            _hashCode += getReturn_date().hashCode();
        }
        _hashCode += getRevenue_status();
        if (getShipper_ref_nbr() != null) {
            _hashCode += getShipper_ref_nbr().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZOrderItemShip.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderItemShip"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_ship_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_ship_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fifo_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fifo_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inventory_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inventory_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("profit_center");
        attrField.setXmlName(new javax.xml.namespace.QName("", "profit_center"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("profit_center_calendar_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "profit_center_calendar_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_shipped");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_shipped"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_shipped_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_shipped_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("return_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "return_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("shipper_ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "shipper_ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
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
