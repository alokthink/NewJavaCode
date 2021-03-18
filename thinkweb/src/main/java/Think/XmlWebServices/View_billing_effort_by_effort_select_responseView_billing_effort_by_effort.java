/**
 * View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class View_billing_effort_by_effort_select_responseView_billing_effort_by_effort  implements java.io.Serializable {
    private int effort_number;  // attribute

    private int totaleffort;  // attribute

    private int job_id;  // attribute

    public View_billing_effort_by_effort_select_responseView_billing_effort_by_effort() {
    }

    public View_billing_effort_by_effort_select_responseView_billing_effort_by_effort(
           int effort_number,
           int totaleffort,
           int job_id) {
           this.effort_number = effort_number;
           this.totaleffort = totaleffort;
           this.job_id = job_id;
    }


    /**
     * Gets the effort_number value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @return effort_number
     */
    public int getEffort_number() {
        return effort_number;
    }


    /**
     * Sets the effort_number value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @param effort_number
     */
    public void setEffort_number(int effort_number) {
        this.effort_number = effort_number;
    }


    /**
     * Gets the totaleffort value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @return totaleffort
     */
    public int getTotaleffort() {
        return totaleffort;
    }


    /**
     * Sets the totaleffort value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @param totaleffort
     */
    public void setTotaleffort(int totaleffort) {
        this.totaleffort = totaleffort;
    }


    /**
     * Gets the job_id value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_billing_effort_by_effort_select_responseView_billing_effort_by_effort)) return false;
        View_billing_effort_by_effort_select_responseView_billing_effort_by_effort other = (View_billing_effort_by_effort_select_responseView_billing_effort_by_effort) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.effort_number == other.getEffort_number() &&
            this.totaleffort == other.getTotaleffort() &&
            this.job_id == other.getJob_id();
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
        _hashCode += getEffort_number();
        _hashCode += getTotaleffort();
        _hashCode += getJob_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_billing_effort_by_effort_select_responseView_billing_effort_by_effort.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>view_billing_effort_by_effort_select_response>view_billing_effort_by_effort"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("effort_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "effort_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("totaleffort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "totaleffort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
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
