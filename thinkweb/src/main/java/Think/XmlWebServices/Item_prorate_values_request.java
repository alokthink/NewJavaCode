/**
 * Item_prorate_values_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_prorate_values_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Item_payment[] item_payment;

    private java.lang.String dsn;  // attribute

    public Item_prorate_values_request() {
    }

    public Item_prorate_values_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Item_payment[] item_payment,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.item_payment = item_payment;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Item_prorate_values_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Item_prorate_values_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the item_payment value for this Item_prorate_values_request.
     * 
     * @return item_payment
     */
    public Think.XmlWebServices.Item_payment[] getItem_payment() {
        return item_payment;
    }


    /**
     * Sets the item_payment value for this Item_prorate_values_request.
     * 
     * @param item_payment
     */
    public void setItem_payment(Think.XmlWebServices.Item_payment[] item_payment) {
        this.item_payment = item_payment;
    }

    public Think.XmlWebServices.Item_payment getItem_payment(int i) {
        return this.item_payment[i];
    }

    public void setItem_payment(int i, Think.XmlWebServices.Item_payment _value) {
        this.item_payment[i] = _value;
    }


    /**
     * Gets the dsn value for this Item_prorate_values_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Item_prorate_values_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_prorate_values_request)) return false;
        Item_prorate_values_request other = (Item_prorate_values_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.item_payment==null && other.getItem_payment()==null) || 
             (this.item_payment!=null &&
              java.util.Arrays.equals(this.item_payment, other.getItem_payment()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getItem_payment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem_payment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem_payment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_prorate_values_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_prorate_values_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_payment"));
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
