/**
 * Order_code_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_code_data  implements java.io.Serializable {
    private java.lang.Integer order_code_id;

    private java.lang.Integer subscription_def_id;

    private java.lang.Integer pkg_def_id;

    public Order_code_data() {
    }

    public Order_code_data(
           java.lang.Integer order_code_id,
           java.lang.Integer subscription_def_id,
           java.lang.Integer pkg_def_id) {
           this.order_code_id = order_code_id;
           this.subscription_def_id = subscription_def_id;
           this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the order_code_id value for this Order_code_data.
     * 
     * @return order_code_id
     */
    public java.lang.Integer getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Order_code_data.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(java.lang.Integer order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the subscription_def_id value for this Order_code_data.
     * 
     * @return subscription_def_id
     */
    public java.lang.Integer getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Order_code_data.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(java.lang.Integer subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the pkg_def_id value for this Order_code_data.
     * 
     * @return pkg_def_id
     */
    public java.lang.Integer getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Order_code_data.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(java.lang.Integer pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_code_data)) return false;
        Order_code_data other = (Order_code_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_code_id==null && other.getOrder_code_id()==null) || 
             (this.order_code_id!=null &&
              this.order_code_id.equals(other.getOrder_code_id()))) &&
            ((this.subscription_def_id==null && other.getSubscription_def_id()==null) || 
             (this.subscription_def_id!=null &&
              this.subscription_def_id.equals(other.getSubscription_def_id()))) &&
            ((this.pkg_def_id==null && other.getPkg_def_id()==null) || 
             (this.pkg_def_id!=null &&
              this.pkg_def_id.equals(other.getPkg_def_id())));
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
        if (getOrder_code_id() != null) {
            _hashCode += getOrder_code_id().hashCode();
        }
        if (getSubscription_def_id() != null) {
            _hashCode += getSubscription_def_id().hashCode();
        }
        if (getPkg_def_id() != null) {
            _hashCode += getPkg_def_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_code_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_code_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscription_def_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscription_def_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkg_def_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_def_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
