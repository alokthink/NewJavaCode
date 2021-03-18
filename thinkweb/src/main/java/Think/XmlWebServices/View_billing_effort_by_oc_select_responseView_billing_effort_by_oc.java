/**
 * View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class View_billing_effort_by_oc_select_responseView_billing_effort_by_oc  implements java.io.Serializable {
    private java.lang.String oc;  // attribute

    private int oc_id;  // attribute

    private int totaleffort;  // attribute

    private int job_id;  // attribute

    public View_billing_effort_by_oc_select_responseView_billing_effort_by_oc() {
    }

    public View_billing_effort_by_oc_select_responseView_billing_effort_by_oc(
           java.lang.String oc,
           int oc_id,
           int totaleffort,
           int job_id) {
           this.oc = oc;
           this.oc_id = oc_id;
           this.totaleffort = totaleffort;
           this.job_id = job_id;
    }


    /**
     * Gets the oc value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @return oc
     */
    public java.lang.String getOc() {
        return oc;
    }


    /**
     * Sets the oc value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @param oc
     */
    public void setOc(java.lang.String oc) {
        this.oc = oc;
    }


    /**
     * Gets the oc_id value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the totaleffort value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @return totaleffort
     */
    public int getTotaleffort() {
        return totaleffort;
    }


    /**
     * Sets the totaleffort value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @param totaleffort
     */
    public void setTotaleffort(int totaleffort) {
        this.totaleffort = totaleffort;
    }


    /**
     * Gets the job_id value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_billing_effort_by_oc_select_responseView_billing_effort_by_oc)) return false;
        View_billing_effort_by_oc_select_responseView_billing_effort_by_oc other = (View_billing_effort_by_oc_select_responseView_billing_effort_by_oc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oc==null && other.getOc()==null) || 
             (this.oc!=null &&
              this.oc.equals(other.getOc()))) &&
            this.oc_id == other.getOc_id() &&
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
        if (getOc() != null) {
            _hashCode += getOc().hashCode();
        }
        _hashCode += getOc_id();
        _hashCode += getTotaleffort();
        _hashCode += getJob_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_billing_effort_by_oc_select_responseView_billing_effort_by_oc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>view_billing_effort_by_oc_select_response>view_billing_effort_by_oc"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
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
