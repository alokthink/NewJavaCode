/**
 * Order_quantity_option_calculate_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_quantity_option_calculate_response  implements java.io.Serializable {
    private Think.XmlWebServices.Change_order_amounts change_order_amounts;

    private Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue;

    public Order_quantity_option_calculate_response() {
    }

    public Order_quantity_option_calculate_response(
           Think.XmlWebServices.Change_order_amounts change_order_amounts,
           Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue) {
           this.change_order_amounts = change_order_amounts;
           this.change_cost_per_issue = change_cost_per_issue;
    }


    /**
     * Gets the change_order_amounts value for this Order_quantity_option_calculate_response.
     * 
     * @return change_order_amounts
     */
    public Think.XmlWebServices.Change_order_amounts getChange_order_amounts() {
        return change_order_amounts;
    }


    /**
     * Sets the change_order_amounts value for this Order_quantity_option_calculate_response.
     * 
     * @param change_order_amounts
     */
    public void setChange_order_amounts(Think.XmlWebServices.Change_order_amounts change_order_amounts) {
        this.change_order_amounts = change_order_amounts;
    }


    /**
     * Gets the change_cost_per_issue value for this Order_quantity_option_calculate_response.
     * 
     * @return change_cost_per_issue
     */
    public Think.XmlWebServices.Change_cost_per_issue getChange_cost_per_issue() {
        return change_cost_per_issue;
    }


    /**
     * Sets the change_cost_per_issue value for this Order_quantity_option_calculate_response.
     * 
     * @param change_cost_per_issue
     */
    public void setChange_cost_per_issue(Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue) {
        this.change_cost_per_issue = change_cost_per_issue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_quantity_option_calculate_response)) return false;
        Order_quantity_option_calculate_response other = (Order_quantity_option_calculate_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.change_order_amounts==null && other.getChange_order_amounts()==null) || 
             (this.change_order_amounts!=null &&
              this.change_order_amounts.equals(other.getChange_order_amounts()))) &&
            ((this.change_cost_per_issue==null && other.getChange_cost_per_issue()==null) || 
             (this.change_cost_per_issue!=null &&
              this.change_cost_per_issue.equals(other.getChange_cost_per_issue())));
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
        if (getChange_order_amounts() != null) {
            _hashCode += getChange_order_amounts().hashCode();
        }
        if (getChange_cost_per_issue() != null) {
            _hashCode += getChange_cost_per_issue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_quantity_option_calculate_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_quantity_option_calculate_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("change_order_amounts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "change_order_amounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_order_amounts"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("change_cost_per_issue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "change_cost_per_issue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_cost_per_issue"));
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
