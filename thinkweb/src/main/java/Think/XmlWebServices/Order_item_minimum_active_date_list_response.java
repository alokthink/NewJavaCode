/**
 * Order_item_minimum_active_date_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_item_minimum_active_date_list_response  implements java.io.Serializable {
    private java.util.Date minimum_active_date;  // attribute

    public Order_item_minimum_active_date_list_response() {
    }

    public Order_item_minimum_active_date_list_response(
           java.util.Date minimum_active_date) {
           this.minimum_active_date = minimum_active_date;
    }


    /**
     * Gets the minimum_active_date value for this Order_item_minimum_active_date_list_response.
     * 
     * @return minimum_active_date
     */
    public java.util.Date getMinimum_active_date() {
        return minimum_active_date;
    }


    /**
     * Sets the minimum_active_date value for this Order_item_minimum_active_date_list_response.
     * 
     * @param minimum_active_date
     */
    public void setMinimum_active_date(java.util.Date minimum_active_date) {
        this.minimum_active_date = minimum_active_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_item_minimum_active_date_list_response)) return false;
        Order_item_minimum_active_date_list_response other = (Order_item_minimum_active_date_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.minimum_active_date==null && other.getMinimum_active_date()==null) || 
             (this.minimum_active_date!=null &&
              this.minimum_active_date.equals(other.getMinimum_active_date())));
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
        if (getMinimum_active_date() != null) {
            _hashCode += getMinimum_active_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_item_minimum_active_date_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_minimum_active_date_list_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("minimum_active_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "minimum_active_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
