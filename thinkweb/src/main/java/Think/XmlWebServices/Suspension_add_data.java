/**
 * Suspension_add_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_add_data  implements java.io.Serializable {
    private java.util.Date suspend_from_date;

    private java.util.Date suspend_to_date;

    private java.lang.Boolean serve_backlabels;

    private java.lang.String suspension_of;

    private Think.XmlWebServices.Suspension_reason suspension_reason;  // attribute

    public Suspension_add_data() {
    }

    public Suspension_add_data(
           java.util.Date suspend_from_date,
           java.util.Date suspend_to_date,
           java.lang.Boolean serve_backlabels,
           java.lang.String suspension_of,
           Think.XmlWebServices.Suspension_reason suspension_reason) {
           this.suspend_from_date = suspend_from_date;
           this.suspend_to_date = suspend_to_date;
           this.serve_backlabels = serve_backlabels;
           this.suspension_of = suspension_of;
           this.suspension_reason = suspension_reason;
    }


    /**
     * Gets the suspend_from_date value for this Suspension_add_data.
     * 
     * @return suspend_from_date
     */
    public java.util.Date getSuspend_from_date() {
        return suspend_from_date;
    }


    /**
     * Sets the suspend_from_date value for this Suspension_add_data.
     * 
     * @param suspend_from_date
     */
    public void setSuspend_from_date(java.util.Date suspend_from_date) {
        this.suspend_from_date = suspend_from_date;
    }


    /**
     * Gets the suspend_to_date value for this Suspension_add_data.
     * 
     * @return suspend_to_date
     */
    public java.util.Date getSuspend_to_date() {
        return suspend_to_date;
    }


    /**
     * Sets the suspend_to_date value for this Suspension_add_data.
     * 
     * @param suspend_to_date
     */
    public void setSuspend_to_date(java.util.Date suspend_to_date) {
        this.suspend_to_date = suspend_to_date;
    }


    /**
     * Gets the serve_backlabels value for this Suspension_add_data.
     * 
     * @return serve_backlabels
     */
    public java.lang.Boolean getServe_backlabels() {
        return serve_backlabels;
    }


    /**
     * Sets the serve_backlabels value for this Suspension_add_data.
     * 
     * @param serve_backlabels
     */
    public void setServe_backlabels(java.lang.Boolean serve_backlabels) {
        this.serve_backlabels = serve_backlabels;
    }


    /**
     * Gets the suspension_of value for this Suspension_add_data.
     * 
     * @return suspension_of
     */
    public java.lang.String getSuspension_of() {
        return suspension_of;
    }


    /**
     * Sets the suspension_of value for this Suspension_add_data.
     * 
     * @param suspension_of
     */
    public void setSuspension_of(java.lang.String suspension_of) {
        this.suspension_of = suspension_of;
    }


    /**
     * Gets the suspension_reason value for this Suspension_add_data.
     * 
     * @return suspension_reason
     */
    public Think.XmlWebServices.Suspension_reason getSuspension_reason() {
        return suspension_reason;
    }


    /**
     * Sets the suspension_reason value for this Suspension_add_data.
     * 
     * @param suspension_reason
     */
    public void setSuspension_reason(Think.XmlWebServices.Suspension_reason suspension_reason) {
        this.suspension_reason = suspension_reason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suspension_add_data)) return false;
        Suspension_add_data other = (Suspension_add_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.suspend_from_date==null && other.getSuspend_from_date()==null) || 
             (this.suspend_from_date!=null &&
              this.suspend_from_date.equals(other.getSuspend_from_date()))) &&
            ((this.suspend_to_date==null && other.getSuspend_to_date()==null) || 
             (this.suspend_to_date!=null &&
              this.suspend_to_date.equals(other.getSuspend_to_date()))) &&
            ((this.serve_backlabels==null && other.getServe_backlabels()==null) || 
             (this.serve_backlabels!=null &&
              this.serve_backlabels.equals(other.getServe_backlabels()))) &&
            ((this.suspension_of==null && other.getSuspension_of()==null) || 
             (this.suspension_of!=null &&
              this.suspension_of.equals(other.getSuspension_of()))) &&
            ((this.suspension_reason==null && other.getSuspension_reason()==null) || 
             (this.suspension_reason!=null &&
              this.suspension_reason.equals(other.getSuspension_reason())));
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
        if (getSuspend_from_date() != null) {
            _hashCode += getSuspend_from_date().hashCode();
        }
        if (getSuspend_to_date() != null) {
            _hashCode += getSuspend_to_date().hashCode();
        }
        if (getServe_backlabels() != null) {
            _hashCode += getServe_backlabels().hashCode();
        }
        if (getSuspension_of() != null) {
            _hashCode += getSuspension_of().hashCode();
        }
        if (getSuspension_reason() != null) {
            _hashCode += getSuspension_reason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suspension_add_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">suspension_add_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspension_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_reason"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspend_from_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspend_from_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspension_of");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_of"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
