/**
 * Suspension_edit_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_edit_data  implements java.io.Serializable {
    private java.util.Date suspend_to_date;

    private boolean serve_backlabels;

    private Think.XmlWebServices.ZZBoolean reinstate;  // attribute

    private Think.XmlWebServices.ZZBoolean cancel;  // attribute

    public Suspension_edit_data() {
    }

    public Suspension_edit_data(
           java.util.Date suspend_to_date,
           boolean serve_backlabels,
           Think.XmlWebServices.ZZBoolean reinstate,
           Think.XmlWebServices.ZZBoolean cancel) {
           this.suspend_to_date = suspend_to_date;
           this.serve_backlabels = serve_backlabels;
           this.reinstate = reinstate;
           this.cancel = cancel;
    }


    /**
     * Gets the suspend_to_date value for this Suspension_edit_data.
     * 
     * @return suspend_to_date
     */
    public java.util.Date getSuspend_to_date() {
        return suspend_to_date;
    }


    /**
     * Sets the suspend_to_date value for this Suspension_edit_data.
     * 
     * @param suspend_to_date
     */
    public void setSuspend_to_date(java.util.Date suspend_to_date) {
        this.suspend_to_date = suspend_to_date;
    }


    /**
     * Gets the serve_backlabels value for this Suspension_edit_data.
     * 
     * @return serve_backlabels
     */
    public boolean isServe_backlabels() {
        return serve_backlabels;
    }


    /**
     * Sets the serve_backlabels value for this Suspension_edit_data.
     * 
     * @param serve_backlabels
     */
    public void setServe_backlabels(boolean serve_backlabels) {
        this.serve_backlabels = serve_backlabels;
    }


    /**
     * Gets the reinstate value for this Suspension_edit_data.
     * 
     * @return reinstate
     */
    public Think.XmlWebServices.ZZBoolean getReinstate() {
        return reinstate;
    }


    /**
     * Sets the reinstate value for this Suspension_edit_data.
     * 
     * @param reinstate
     */
    public void setReinstate(Think.XmlWebServices.ZZBoolean reinstate) {
        this.reinstate = reinstate;
    }


    /**
     * Gets the cancel value for this Suspension_edit_data.
     * 
     * @return cancel
     */
    public Think.XmlWebServices.ZZBoolean getCancel() {
        return cancel;
    }


    /**
     * Sets the cancel value for this Suspension_edit_data.
     * 
     * @param cancel
     */
    public void setCancel(Think.XmlWebServices.ZZBoolean cancel) {
        this.cancel = cancel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suspension_edit_data)) return false;
        Suspension_edit_data other = (Suspension_edit_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.suspend_to_date==null && other.getSuspend_to_date()==null) || 
             (this.suspend_to_date!=null &&
              this.suspend_to_date.equals(other.getSuspend_to_date()))) &&
            this.serve_backlabels == other.isServe_backlabels() &&
            ((this.reinstate==null && other.getReinstate()==null) || 
             (this.reinstate!=null &&
              this.reinstate.equals(other.getReinstate()))) &&
            ((this.cancel==null && other.getCancel()==null) || 
             (this.cancel!=null &&
              this.cancel.equals(other.getCancel())));
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
        if (getSuspend_to_date() != null) {
            _hashCode += getSuspend_to_date().hashCode();
        }
        _hashCode += (isServe_backlabels() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReinstate() != null) {
            _hashCode += getReinstate().hashCode();
        }
        if (getCancel() != null) {
            _hashCode += getCancel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suspension_edit_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">suspension_edit_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reinstate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reinstate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspend_to_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspend_to_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serve_backlabels");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "serve_backlabels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
