/**
 * Item_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Order_data order_data;

    private Think.XmlWebServices.Disambiguation_list[] disambiguation_list;

    private Think.XmlWebServices.Item_data[] pool;

    public Item_list_response() {
    }

    public Item_list_response(
           Think.XmlWebServices.Order_data order_data,
           Think.XmlWebServices.Disambiguation_list[] disambiguation_list,
           Think.XmlWebServices.Item_data[] pool) {
           this.order_data = order_data;
           this.disambiguation_list = disambiguation_list;
           this.pool = pool;
    }


    /**
     * Gets the order_data value for this Item_list_response.
     * 
     * @return order_data
     */
    public Think.XmlWebServices.Order_data getOrder_data() {
        return order_data;
    }


    /**
     * Sets the order_data value for this Item_list_response.
     * 
     * @param order_data
     */
    public void setOrder_data(Think.XmlWebServices.Order_data order_data) {
        this.order_data = order_data;
    }


    /**
     * Gets the disambiguation_list value for this Item_list_response.
     * 
     * @return disambiguation_list
     */
    public Think.XmlWebServices.Disambiguation_list[] getDisambiguation_list() {
        return disambiguation_list;
    }


    /**
     * Sets the disambiguation_list value for this Item_list_response.
     * 
     * @param disambiguation_list
     */
    public void setDisambiguation_list(Think.XmlWebServices.Disambiguation_list[] disambiguation_list) {
        this.disambiguation_list = disambiguation_list;
    }

    public Think.XmlWebServices.Disambiguation_list getDisambiguation_list(int i) {
        return this.disambiguation_list[i];
    }

    public void setDisambiguation_list(int i, Think.XmlWebServices.Disambiguation_list _value) {
        this.disambiguation_list[i] = _value;
    }


    /**
     * Gets the pool value for this Item_list_response.
     * 
     * @return pool
     */
    public Think.XmlWebServices.Item_data[] getPool() {
        return pool;
    }


    /**
     * Sets the pool value for this Item_list_response.
     * 
     * @param pool
     */
    public void setPool(Think.XmlWebServices.Item_data[] pool) {
        this.pool = pool;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_list_response)) return false;
        Item_list_response other = (Item_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_data==null && other.getOrder_data()==null) || 
             (this.order_data!=null &&
              this.order_data.equals(other.getOrder_data()))) &&
            ((this.disambiguation_list==null && other.getDisambiguation_list()==null) || 
             (this.disambiguation_list!=null &&
              java.util.Arrays.equals(this.disambiguation_list, other.getDisambiguation_list()))) &&
            ((this.pool==null && other.getPool()==null) || 
             (this.pool!=null &&
              java.util.Arrays.equals(this.pool, other.getPool())));
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
        if (getOrder_data() != null) {
            _hashCode += getOrder_data().hashCode();
        }
        if (getDisambiguation_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDisambiguation_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDisambiguation_list(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPool() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPool());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPool(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_list_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disambiguation_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_list"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pool");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pool"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">pool"));
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
