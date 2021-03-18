/**
 * Suspension_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_identifier  implements java.io.Serializable {
    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private int suspension_seq;

    public Suspension_identifier() {
    }

    public Suspension_identifier(
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           int suspension_seq) {
           this.item_identifier = item_identifier;
           this.suspension_seq = suspension_seq;
    }


    /**
     * Gets the item_identifier value for this Suspension_identifier.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Suspension_identifier.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the suspension_seq value for this Suspension_identifier.
     * 
     * @return suspension_seq
     */
    public int getSuspension_seq() {
        return suspension_seq;
    }


    /**
     * Sets the suspension_seq value for this Suspension_identifier.
     * 
     * @param suspension_seq
     */
    public void setSuspension_seq(int suspension_seq) {
        this.suspension_seq = suspension_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suspension_identifier)) return false;
        Suspension_identifier other = (Suspension_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            this.suspension_seq == other.getSuspension_seq();
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
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        _hashCode += getSuspension_seq();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suspension_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">suspension_identifier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspension_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
