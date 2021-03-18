/**
 * Transfer_item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Transfer_item  implements java.io.Serializable {
    private Think.XmlWebServices.Order_item order_item;

    private Think.XmlWebServices.Transfer_customer[] transfer_customer;

    public Transfer_item() {
    }

    public Transfer_item(
           Think.XmlWebServices.Order_item order_item,
           Think.XmlWebServices.Transfer_customer[] transfer_customer) {
           this.order_item = order_item;
           this.transfer_customer = transfer_customer;
    }


    /**
     * Gets the order_item value for this Transfer_item.
     * 
     * @return order_item
     */
    public Think.XmlWebServices.Order_item getOrder_item() {
        return order_item;
    }


    /**
     * Sets the order_item value for this Transfer_item.
     * 
     * @param order_item
     */
    public void setOrder_item(Think.XmlWebServices.Order_item order_item) {
        this.order_item = order_item;
    }


    /**
     * Gets the transfer_customer value for this Transfer_item.
     * 
     * @return transfer_customer
     */
    public Think.XmlWebServices.Transfer_customer[] getTransfer_customer() {
        return transfer_customer;
    }


    /**
     * Sets the transfer_customer value for this Transfer_item.
     * 
     * @param transfer_customer
     */
    public void setTransfer_customer(Think.XmlWebServices.Transfer_customer[] transfer_customer) {
        this.transfer_customer = transfer_customer;
    }

    public Think.XmlWebServices.Transfer_customer getTransfer_customer(int i) {
        return this.transfer_customer[i];
    }

    public void setTransfer_customer(int i, Think.XmlWebServices.Transfer_customer _value) {
        this.transfer_customer[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Transfer_item)) return false;
        Transfer_item other = (Transfer_item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_item==null && other.getOrder_item()==null) || 
             (this.order_item!=null &&
              this.order_item.equals(other.getOrder_item()))) &&
            ((this.transfer_customer==null && other.getTransfer_customer()==null) || 
             (this.transfer_customer!=null &&
              java.util.Arrays.equals(this.transfer_customer, other.getTransfer_customer())));
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
        if (getOrder_item() != null) {
            _hashCode += getOrder_item().hashCode();
        }
        if (getTransfer_customer() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransfer_customer());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransfer_customer(), i);
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
        new org.apache.axis.description.TypeDesc(Transfer_item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">transfer_item"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transfer_customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_customer"));
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
