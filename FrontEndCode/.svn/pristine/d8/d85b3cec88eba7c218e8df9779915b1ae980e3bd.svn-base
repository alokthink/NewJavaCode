/**
 * Unit_history_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Unit_history_data  implements java.io.Serializable {
    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private int unit_history_seq;

    private java.util.Calendar creation_date;

    public Unit_history_data() {
    }

    public Unit_history_data(
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           int unit_history_seq,
           java.util.Calendar creation_date) {
           this.item_identifier = item_identifier;
           this.unit_history_seq = unit_history_seq;
           this.creation_date = creation_date;
    }


    /**
     * Gets the item_identifier value for this Unit_history_data.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Unit_history_data.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the unit_history_seq value for this Unit_history_data.
     * 
     * @return unit_history_seq
     */
    public int getUnit_history_seq() {
        return unit_history_seq;
    }


    /**
     * Sets the unit_history_seq value for this Unit_history_data.
     * 
     * @param unit_history_seq
     */
    public void setUnit_history_seq(int unit_history_seq) {
        this.unit_history_seq = unit_history_seq;
    }


    /**
     * Gets the creation_date value for this Unit_history_data.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Unit_history_data.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Unit_history_data)) return false;
        Unit_history_data other = (Unit_history_data) obj;
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
            this.unit_history_seq == other.getUnit_history_seq() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date())));
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
        _hashCode += getUnit_history_seq();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Unit_history_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">unit_history_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit_history_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "unit_history_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creation_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "creation_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
