/**
 * Order_transfer_information_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_transfer_information_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Transfer_item[] transfer_item;

    public Order_transfer_information_response() {
    }

    public Order_transfer_information_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Transfer_item[] transfer_item) {
           this.customer_identifier = customer_identifier;
           this.transfer_item = transfer_item;
    }


    /**
     * Gets the customer_identifier value for this Order_transfer_information_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Order_transfer_information_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the transfer_item value for this Order_transfer_information_response.
     * 
     * @return transfer_item
     */
    public Think.XmlWebServices.Transfer_item[] getTransfer_item() {
        return transfer_item;
    }


    /**
     * Sets the transfer_item value for this Order_transfer_information_response.
     * 
     * @param transfer_item
     */
    public void setTransfer_item(Think.XmlWebServices.Transfer_item[] transfer_item) {
        this.transfer_item = transfer_item;
    }

    public Think.XmlWebServices.Transfer_item getTransfer_item(int i) {
        return this.transfer_item[i];
    }

    public void setTransfer_item(int i, Think.XmlWebServices.Transfer_item _value) {
        this.transfer_item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_transfer_information_response)) return false;
        Order_transfer_information_response other = (Order_transfer_information_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.transfer_item==null && other.getTransfer_item()==null) || 
             (this.transfer_item!=null &&
              java.util.Arrays.equals(this.transfer_item, other.getTransfer_item())));
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
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getTransfer_item() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransfer_item());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransfer_item(), i);
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
        new org.apache.axis.description.TypeDesc(Order_transfer_information_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_transfer_information_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transfer_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_item"));
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
