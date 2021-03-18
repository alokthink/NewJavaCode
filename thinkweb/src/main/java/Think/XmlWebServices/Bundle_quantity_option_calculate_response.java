/**
 * Bundle_quantity_option_calculate_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Bundle_quantity_option_calculate_response  implements java.io.Serializable {
    private Think.XmlWebServices.Change_order_quantities change_order_quantities;

    private Think.XmlWebServices.Change_order_amounts change_order_amounts;

    private Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue;

    private Think.XmlWebServices.Prorate_order_amounts prorate_order_amounts;

    public Bundle_quantity_option_calculate_response() {
    }

    public Bundle_quantity_option_calculate_response(
           Think.XmlWebServices.Change_order_quantities change_order_quantities,
           Think.XmlWebServices.Change_order_amounts change_order_amounts,
           Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue,
           Think.XmlWebServices.Prorate_order_amounts prorate_order_amounts) {
           this.change_order_quantities = change_order_quantities;
           this.change_order_amounts = change_order_amounts;
           this.change_cost_per_issue = change_cost_per_issue;
           this.prorate_order_amounts = prorate_order_amounts;
    }


    /**
     * Gets the change_order_quantities value for this Bundle_quantity_option_calculate_response.
     * 
     * @return change_order_quantities
     */
    public Think.XmlWebServices.Change_order_quantities getChange_order_quantities() {
        return change_order_quantities;
    }


    /**
     * Sets the change_order_quantities value for this Bundle_quantity_option_calculate_response.
     * 
     * @param change_order_quantities
     */
    public void setChange_order_quantities(Think.XmlWebServices.Change_order_quantities change_order_quantities) {
        this.change_order_quantities = change_order_quantities;
    }


    /**
     * Gets the change_order_amounts value for this Bundle_quantity_option_calculate_response.
     * 
     * @return change_order_amounts
     */
    public Think.XmlWebServices.Change_order_amounts getChange_order_amounts() {
        return change_order_amounts;
    }


    /**
     * Sets the change_order_amounts value for this Bundle_quantity_option_calculate_response.
     * 
     * @param change_order_amounts
     */
    public void setChange_order_amounts(Think.XmlWebServices.Change_order_amounts change_order_amounts) {
        this.change_order_amounts = change_order_amounts;
    }


    /**
     * Gets the change_cost_per_issue value for this Bundle_quantity_option_calculate_response.
     * 
     * @return change_cost_per_issue
     */
    public Think.XmlWebServices.Change_cost_per_issue getChange_cost_per_issue() {
        return change_cost_per_issue;
    }


    /**
     * Sets the change_cost_per_issue value for this Bundle_quantity_option_calculate_response.
     * 
     * @param change_cost_per_issue
     */
    public void setChange_cost_per_issue(Think.XmlWebServices.Change_cost_per_issue change_cost_per_issue) {
        this.change_cost_per_issue = change_cost_per_issue;
    }


    /**
     * Gets the prorate_order_amounts value for this Bundle_quantity_option_calculate_response.
     * 
     * @return prorate_order_amounts
     */
    public Think.XmlWebServices.Prorate_order_amounts getProrate_order_amounts() {
        return prorate_order_amounts;
    }


    /**
     * Sets the prorate_order_amounts value for this Bundle_quantity_option_calculate_response.
     * 
     * @param prorate_order_amounts
     */
    public void setProrate_order_amounts(Think.XmlWebServices.Prorate_order_amounts prorate_order_amounts) {
        this.prorate_order_amounts = prorate_order_amounts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bundle_quantity_option_calculate_response)) return false;
        Bundle_quantity_option_calculate_response other = (Bundle_quantity_option_calculate_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.change_order_quantities==null && other.getChange_order_quantities()==null) || 
             (this.change_order_quantities!=null &&
              this.change_order_quantities.equals(other.getChange_order_quantities()))) &&
            ((this.change_order_amounts==null && other.getChange_order_amounts()==null) || 
             (this.change_order_amounts!=null &&
              this.change_order_amounts.equals(other.getChange_order_amounts()))) &&
            ((this.change_cost_per_issue==null && other.getChange_cost_per_issue()==null) || 
             (this.change_cost_per_issue!=null &&
              this.change_cost_per_issue.equals(other.getChange_cost_per_issue()))) &&
            ((this.prorate_order_amounts==null && other.getProrate_order_amounts()==null) || 
             (this.prorate_order_amounts!=null &&
              this.prorate_order_amounts.equals(other.getProrate_order_amounts())));
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
        if (getChange_order_quantities() != null) {
            _hashCode += getChange_order_quantities().hashCode();
        }
        if (getChange_order_amounts() != null) {
            _hashCode += getChange_order_amounts().hashCode();
        }
        if (getChange_cost_per_issue() != null) {
            _hashCode += getChange_cost_per_issue().hashCode();
        }
        if (getProrate_order_amounts() != null) {
            _hashCode += getProrate_order_amounts().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bundle_quantity_option_calculate_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">bundle_quantity_option_calculate_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("change_order_quantities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "change_order_quantities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">change_order_quantities"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prorate_order_amounts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "prorate_order_amounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">prorate_order_amounts"));
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
