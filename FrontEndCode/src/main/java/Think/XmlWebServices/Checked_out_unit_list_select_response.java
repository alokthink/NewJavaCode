/**
 * Checked_out_unit_list_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Checked_out_unit_list_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out[] unit_item_on_check_out;

    public Checked_out_unit_list_select_response() {
    }

    public Checked_out_unit_list_select_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out[] unit_item_on_check_out) {
           this.customer_identifier = customer_identifier;
           this.unit_item_on_check_out = unit_item_on_check_out;
    }


    /**
     * Gets the customer_identifier value for this Checked_out_unit_list_select_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Checked_out_unit_list_select_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the unit_item_on_check_out value for this Checked_out_unit_list_select_response.
     * 
     * @return unit_item_on_check_out
     */
    public Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out[] getUnit_item_on_check_out() {
        return unit_item_on_check_out;
    }


    /**
     * Sets the unit_item_on_check_out value for this Checked_out_unit_list_select_response.
     * 
     * @param unit_item_on_check_out
     */
    public void setUnit_item_on_check_out(Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out[] unit_item_on_check_out) {
        this.unit_item_on_check_out = unit_item_on_check_out;
    }

    public Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out getUnit_item_on_check_out(int i) {
        return this.unit_item_on_check_out[i];
    }

    public void setUnit_item_on_check_out(int i, Think.XmlWebServices.Checked_out_unit_list_select_responseUnit_item_on_check_out _value) {
        this.unit_item_on_check_out[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Checked_out_unit_list_select_response)) return false;
        Checked_out_unit_list_select_response other = (Checked_out_unit_list_select_response) obj;
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
            ((this.unit_item_on_check_out==null && other.getUnit_item_on_check_out()==null) || 
             (this.unit_item_on_check_out!=null &&
              java.util.Arrays.equals(this.unit_item_on_check_out, other.getUnit_item_on_check_out())));
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
        if (getUnit_item_on_check_out() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnit_item_on_check_out());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnit_item_on_check_out(), i);
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
        new org.apache.axis.description.TypeDesc(Checked_out_unit_list_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">checked_out_unit_list_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit_item_on_check_out");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "unit_item_on_check_out"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>checked_out_unit_list_select_response>unit_item_on_check_out"));
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
