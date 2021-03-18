/**
 * Subgroup_move_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subgroup_move_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier[] customer_identifier;

    private Think.XmlWebServices.Customer[] customer;

    public Subgroup_move_response() {
    }

    public Subgroup_move_response(
           Think.XmlWebServices.Customer_identifier[] customer_identifier,
           Think.XmlWebServices.Customer[] customer) {
           this.customer_identifier = customer_identifier;
           this.customer = customer;
    }


    /**
     * Gets the customer_identifier value for this Subgroup_move_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier[] getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Subgroup_move_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier[] customer_identifier) {
        this.customer_identifier = customer_identifier;
    }

    public Think.XmlWebServices.Customer_identifier getCustomer_identifier(int i) {
        return this.customer_identifier[i];
    }

    public void setCustomer_identifier(int i, Think.XmlWebServices.Customer_identifier _value) {
        this.customer_identifier[i] = _value;
    }


    /**
     * Gets the customer value for this Subgroup_move_response.
     * 
     * @return customer
     */
    public Think.XmlWebServices.Customer[] getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Subgroup_move_response.
     * 
     * @param customer
     */
    public void setCustomer(Think.XmlWebServices.Customer[] customer) {
        this.customer = customer;
    }

    public Think.XmlWebServices.Customer getCustomer(int i) {
        return this.customer[i];
    }

    public void setCustomer(int i, Think.XmlWebServices.Customer _value) {
        this.customer[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subgroup_move_response)) return false;
        Subgroup_move_response other = (Subgroup_move_response) obj;
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
              java.util.Arrays.equals(this.customer_identifier, other.getCustomer_identifier()))) &&
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              java.util.Arrays.equals(this.customer, other.getCustomer())));
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_identifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_identifier(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomer() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer(), i);
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
        new org.apache.axis.description.TypeDesc(Subgroup_move_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subgroup_move_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer"));
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
