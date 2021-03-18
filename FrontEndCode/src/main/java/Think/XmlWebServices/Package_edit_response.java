/**
 * Package_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Package_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer customer;

    private Think.XmlWebServices.Orderhdr orderhdr;

    private Think.XmlWebServices.Demographic demographic;

    private Think.XmlWebServices.ZZSubscrip subscrip;

    private Think.XmlWebServices.Trusted_data trusted_data;

    private Think.XmlWebServices.Payment[] payment;

    public Package_edit_response() {
    }

    public Package_edit_response(
           Think.XmlWebServices.Customer customer,
           Think.XmlWebServices.Orderhdr orderhdr,
           Think.XmlWebServices.Demographic demographic,
           Think.XmlWebServices.ZZSubscrip subscrip,
           Think.XmlWebServices.Trusted_data trusted_data,
           Think.XmlWebServices.Payment[] payment) {
           this.customer = customer;
           this.orderhdr = orderhdr;
           this.demographic = demographic;
           this.subscrip = subscrip;
           this.trusted_data = trusted_data;
           this.payment = payment;
    }


    /**
     * Gets the customer value for this Package_edit_response.
     * 
     * @return customer
     */
    public Think.XmlWebServices.Customer getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Package_edit_response.
     * 
     * @param customer
     */
    public void setCustomer(Think.XmlWebServices.Customer customer) {
        this.customer = customer;
    }


    /**
     * Gets the orderhdr value for this Package_edit_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Package_edit_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr orderhdr) {
        this.orderhdr = orderhdr;
    }


    /**
     * Gets the demographic value for this Package_edit_response.
     * 
     * @return demographic
     */
    public Think.XmlWebServices.Demographic getDemographic() {
        return demographic;
    }


    /**
     * Sets the demographic value for this Package_edit_response.
     * 
     * @param demographic
     */
    public void setDemographic(Think.XmlWebServices.Demographic demographic) {
        this.demographic = demographic;
    }


    /**
     * Gets the subscrip value for this Package_edit_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Package_edit_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip subscrip) {
        this.subscrip = subscrip;
    }


    /**
     * Gets the trusted_data value for this Package_edit_response.
     * 
     * @return trusted_data
     */
    public Think.XmlWebServices.Trusted_data getTrusted_data() {
        return trusted_data;
    }


    /**
     * Sets the trusted_data value for this Package_edit_response.
     * 
     * @param trusted_data
     */
    public void setTrusted_data(Think.XmlWebServices.Trusted_data trusted_data) {
        this.trusted_data = trusted_data;
    }


    /**
     * Gets the payment value for this Package_edit_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment[] getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Package_edit_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment[] payment) {
        this.payment = payment;
    }

    public Think.XmlWebServices.Payment getPayment(int i) {
        return this.payment[i];
    }

    public void setPayment(int i, Think.XmlWebServices.Payment _value) {
        this.payment[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Package_edit_response)) return false;
        Package_edit_response other = (Package_edit_response) obj;
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
            ((this.orderhdr==null && other.getOrderhdr()==null) || 
             (this.orderhdr!=null &&
              this.orderhdr.equals(other.getOrderhdr()))) &&
            ((this.demographic==null && other.getDemographic()==null) || 
             (this.demographic!=null &&
              this.demographic.equals(other.getDemographic()))) &&
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              this.subscrip.equals(other.getSubscrip()))) &&
            ((this.trusted_data==null && other.getTrusted_data()==null) || 
             (this.trusted_data!=null &&
              this.trusted_data.equals(other.getTrusted_data()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              java.util.Arrays.equals(this.payment, other.getPayment())));
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
        if (getOrderhdr() != null) {
            _hashCode += getOrderhdr().hashCode();
        }
        if (getDemographic() != null) {
            _hashCode += getDemographic().hashCode();
        }
        if (getSubscrip() != null) {
            _hashCode += getSubscrip().hashCode();
        }
        if (getTrusted_data() != null) {
            _hashCode += getTrusted_data().hashCode();
        }
        if (getPayment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayment(), i);
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
        new org.apache.axis.description.TypeDesc(Package_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">package_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">orderhdr"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demographic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demographic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demographic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscrip"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trusted_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "trusted_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">trusted_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
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
