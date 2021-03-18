/**
 * Demographic_update_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Demographic_update_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer customer;

    private Think.XmlWebServices.Demographic[] demographic;

    public Demographic_update_response() {
    }

    public Demographic_update_response(
           Think.XmlWebServices.Customer customer,
           Think.XmlWebServices.Demographic[] demographic) {
           this.customer = customer;
           this.demographic = demographic;
    }


    /**
     * Gets the customer value for this Demographic_update_response.
     * 
     * @return customer
     */
    public Think.XmlWebServices.Customer getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Demographic_update_response.
     * 
     * @param customer
     */
    public void setCustomer(Think.XmlWebServices.Customer customer) {
        this.customer = customer;
    }


    /**
     * Gets the demographic value for this Demographic_update_response.
     * 
     * @return demographic
     */
    public Think.XmlWebServices.Demographic[] getDemographic() {
        return demographic;
    }


    /**
     * Sets the demographic value for this Demographic_update_response.
     * 
     * @param demographic
     */
    public void setDemographic(Think.XmlWebServices.Demographic[] demographic) {
        this.demographic = demographic;
    }

    public Think.XmlWebServices.Demographic getDemographic(int i) {
        return this.demographic[i];
    }

    public void setDemographic(int i, Think.XmlWebServices.Demographic _value) {
        this.demographic[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Demographic_update_response)) return false;
        Demographic_update_response other = (Demographic_update_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.demographic==null && other.getDemographic()==null) || 
             (this.demographic!=null &&
              java.util.Arrays.equals(this.demographic, other.getDemographic())));
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
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getDemographic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDemographic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDemographic(), i);
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
        new org.apache.axis.description.TypeDesc(Demographic_update_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demographic_update_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demographic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic"));
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
