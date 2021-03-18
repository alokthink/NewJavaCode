/**
 * Suspension_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZSubscrip subscrip;

    private Think.XmlWebServices.Orderhdr orderhdr;

    public Suspension_edit_response() {
    }

    public Suspension_edit_response(
           Think.XmlWebServices.ZZSubscrip subscrip,
           Think.XmlWebServices.Orderhdr orderhdr) {
           this.subscrip = subscrip;
           this.orderhdr = orderhdr;
    }


    /**
     * Gets the subscrip value for this Suspension_edit_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Suspension_edit_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip subscrip) {
        this.subscrip = subscrip;
    }


    /**
     * Gets the orderhdr value for this Suspension_edit_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Suspension_edit_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr orderhdr) {
        this.orderhdr = orderhdr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suspension_edit_response)) return false;
        Suspension_edit_response other = (Suspension_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              this.subscrip.equals(other.getSubscrip()))) &&
            ((this.orderhdr==null && other.getOrderhdr()==null) || 
             (this.orderhdr!=null &&
              this.orderhdr.equals(other.getOrderhdr())));
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
        if (getSubscrip() != null) {
            _hashCode += getSubscrip().hashCode();
        }
        if (getOrderhdr() != null) {
            _hashCode += getOrderhdr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suspension_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">suspension_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscrip"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">orderhdr"));
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
