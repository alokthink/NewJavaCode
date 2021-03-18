/**
 * Unit_item_list_information_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Unit_item_list_information_response  implements java.io.Serializable {
    private Think.XmlWebServices.Unit_order_item_informationOrder_item[] unit_order_item_information;

    public Unit_item_list_information_response() {
    }

    public Unit_item_list_information_response(
           Think.XmlWebServices.Unit_order_item_informationOrder_item[] unit_order_item_information) {
           this.unit_order_item_information = unit_order_item_information;
    }


    /**
     * Gets the unit_order_item_information value for this Unit_item_list_information_response.
     * 
     * @return unit_order_item_information
     */
    public Think.XmlWebServices.Unit_order_item_informationOrder_item[] getUnit_order_item_information() {
        return unit_order_item_information;
    }


    /**
     * Sets the unit_order_item_information value for this Unit_item_list_information_response.
     * 
     * @param unit_order_item_information
     */
    public void setUnit_order_item_information(Think.XmlWebServices.Unit_order_item_informationOrder_item[] unit_order_item_information) {
        this.unit_order_item_information = unit_order_item_information;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Unit_item_list_information_response)) return false;
        Unit_item_list_information_response other = (Unit_item_list_information_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.unit_order_item_information==null && other.getUnit_order_item_information()==null) || 
             (this.unit_order_item_information!=null &&
              java.util.Arrays.equals(this.unit_order_item_information, other.getUnit_order_item_information())));
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
        if (getUnit_order_item_information() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnit_order_item_information());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnit_order_item_information(), i);
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
        new org.apache.axis.description.TypeDesc(Unit_item_list_information_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">unit_item_list_information_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit_order_item_information");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "unit_order_item_information"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">unit_order_item_information"));
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
