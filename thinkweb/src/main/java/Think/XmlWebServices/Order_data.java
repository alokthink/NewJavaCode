/**
 * Order_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

import java.util.Arrays;

public class Order_data  implements java.io.Serializable {
    private java.lang.Integer orderhdr_id;

    private java.util.Calendar order_date;

    private java.lang.String po_number;

    private Think.XmlWebServices.Item_data[] item_data;

    private Think.XmlWebServices.Suspension_add_data[] suspension_add_data;

    private Think.XmlWebServices.ZZBoolean for_renewal;  // attribute

    private Think.XmlWebServices.Email_confirmation_enum email_confirmation;  // attribute

    private int event_queue_oc_id;  // attribute

    public Order_data() {
    }

    public Order_data(
           java.lang.Integer orderhdr_id,
           java.util.Calendar order_date,
           java.lang.String po_number,
           Think.XmlWebServices.Item_data[] item_data,
           Think.XmlWebServices.Suspension_add_data[] suspension_add_data,
           Think.XmlWebServices.ZZBoolean for_renewal,
           Think.XmlWebServices.Email_confirmation_enum email_confirmation,
           int event_queue_oc_id) {
           this.orderhdr_id = orderhdr_id;
           this.order_date = order_date;
           this.po_number = po_number;
           this.item_data = item_data;
           this.suspension_add_data = suspension_add_data;
           this.for_renewal = for_renewal;
           this.email_confirmation = email_confirmation;
           this.event_queue_oc_id = event_queue_oc_id;
    }


    /**
     * Gets the orderhdr_id value for this Order_data.
     * 
     * @return orderhdr_id
     */
    public java.lang.Integer getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Order_data.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.Integer orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_date value for this Order_data.
     * 
     * @return order_date
     */
    public java.util.Calendar getOrder_date() {
        return order_date;
    }


    /**
     * Sets the order_date value for this Order_data.
     * 
     * @param order_date
     */
    public void setOrder_date(java.util.Calendar order_date) {
        this.order_date = order_date;
    }


    /**
     * Gets the po_number value for this Order_data.
     * 
     * @return po_number
     */
    public java.lang.String getPo_number() {
        return po_number;
    }


    /**
     * Sets the po_number value for this Order_data.
     * 
     * @param po_number
     */
    public void setPo_number(java.lang.String po_number) {
        this.po_number = po_number;
    }


    /**
     * Gets the item_data value for this Order_data.
     * 
     * @return item_data
     */
    public Think.XmlWebServices.Item_data[] getItem_data() {
        return item_data;
    }


    /**
     * Sets the item_data value for this Order_data.
     * 
     * @param item_data
     */
    public void setItem_data(Think.XmlWebServices.Item_data[] item_data) {
        this.item_data = item_data;
    }

    public Think.XmlWebServices.Item_data getItem_data(int i) {
        return this.item_data[i];
    }

    public void setItem_data(int i, Think.XmlWebServices.Item_data _value) {
        this.item_data[i] = _value;
    }


    /**
     * Gets the suspension_add_data value for this Order_data.
     * 
     * @return suspension_add_data
     */
    public Think.XmlWebServices.Suspension_add_data[] getSuspension_add_data() {
        return suspension_add_data;
    }


    /**
     * Sets the suspension_add_data value for this Order_data.
     * 
     * @param suspension_add_data
     */
    public void setSuspension_add_data(Think.XmlWebServices.Suspension_add_data[] suspension_add_data) {
        this.suspension_add_data = suspension_add_data;
    }

    public Think.XmlWebServices.Suspension_add_data getSuspension_add_data(int i) {
        return this.suspension_add_data[i];
    }

    public void setSuspension_add_data(int i, Think.XmlWebServices.Suspension_add_data _value) {
        this.suspension_add_data[i] = _value;
    }


    /**
     * Gets the for_renewal value for this Order_data.
     * 
     * @return for_renewal
     */
    public Think.XmlWebServices.ZZBoolean getFor_renewal() {
        return for_renewal;
    }


    /**
     * Sets the for_renewal value for this Order_data.
     * 
     * @param for_renewal
     */
    public void setFor_renewal(Think.XmlWebServices.ZZBoolean for_renewal) {
        this.for_renewal = for_renewal;
    }


    /**
     * Gets the email_confirmation value for this Order_data.
     * 
     * @return email_confirmation
     */
    public Think.XmlWebServices.Email_confirmation_enum getEmail_confirmation() {
        return email_confirmation;
    }


    /**
     * Sets the email_confirmation value for this Order_data.
     * 
     * @param email_confirmation
     */
    public void setEmail_confirmation(Think.XmlWebServices.Email_confirmation_enum email_confirmation) {
        this.email_confirmation = email_confirmation;
    }


    /**
     * Gets the event_queue_oc_id value for this Order_data.
     * 
     * @return event_queue_oc_id
     */
    public int getEvent_queue_oc_id() {
        return event_queue_oc_id;
    }


    /**
     * Sets the event_queue_oc_id value for this Order_data.
     * 
     * @param event_queue_oc_id
     */
    public void setEvent_queue_oc_id(int event_queue_oc_id) {
        this.event_queue_oc_id = event_queue_oc_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_data)) return false;
        Order_data other = (Order_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
            ((this.order_date==null && other.getOrder_date()==null) || 
             (this.order_date!=null &&
              this.order_date.equals(other.getOrder_date()))) &&
            ((this.po_number==null && other.getPo_number()==null) || 
             (this.po_number!=null &&
              this.po_number.equals(other.getPo_number()))) &&
            ((this.item_data==null && other.getItem_data()==null) || 
             (this.item_data!=null &&
              java.util.Arrays.equals(this.item_data, other.getItem_data()))) &&
            ((this.suspension_add_data==null && other.getSuspension_add_data()==null) || 
             (this.suspension_add_data!=null &&
              java.util.Arrays.equals(this.suspension_add_data, other.getSuspension_add_data()))) &&
            ((this.for_renewal==null && other.getFor_renewal()==null) || 
             (this.for_renewal!=null &&
              this.for_renewal.equals(other.getFor_renewal()))) &&
            ((this.email_confirmation==null && other.getEmail_confirmation()==null) || 
             (this.email_confirmation!=null &&
              this.email_confirmation.equals(other.getEmail_confirmation()))) &&
            this.event_queue_oc_id == other.getEvent_queue_oc_id();
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
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getOrder_date() != null) {
            _hashCode += getOrder_date().hashCode();
        }
        if (getPo_number() != null) {
            _hashCode += getPo_number().hashCode();
        }
        if (getItem_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSuspension_add_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSuspension_add_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSuspension_add_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFor_renewal() != null) {
            _hashCode += getFor_renewal().hashCode();
        }
        if (getEmail_confirmation() != null) {
            _hashCode += getEmail_confirmation().hashCode();
        }
        _hashCode += getEvent_queue_oc_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("for_renewal");
        attrField.setXmlName(new javax.xml.namespace.QName("", "for_renewal"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email_confirmation");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email_confirmation"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "email_confirmation_enum"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("event_queue_oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "event_queue_oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("po_number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "po_number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_data"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspension_add_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_add_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_add_data"));
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

	@Override
	public String toString() {
		return "Order_data [orderhdr_id=" + orderhdr_id + ", order_date=" + order_date + ", po_number=" + po_number
				+ ", item_data=" + Arrays.toString(item_data) + ", suspension_add_data="
				+ Arrays.toString(suspension_add_data) + ", for_renewal=" + for_renewal + ", email_confirmation="
				+ email_confirmation + ", event_queue_oc_id=" + event_queue_oc_id + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
