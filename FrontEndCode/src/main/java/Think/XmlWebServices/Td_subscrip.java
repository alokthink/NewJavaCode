/**
 * Td_subscrip.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_subscrip  extends Think.XmlWebServices.ZZSubscrip  implements java.io.Serializable {
    private java.lang.String cancel_reason_descr;  // attribute

    private java.lang.String start_issue_id_descr;  // attribute

    private java.lang.String stop_issue_id_descr;  // attribute

    public Td_subscrip() {
    }

    public Td_subscrip(
           int subscrip_id,
           int audit_name_change,
           int audit_title_change,
           byte[] backlabels,
           java.util.Calendar cancel_date,
           java.lang.String cancel_reason,
           int customer_id,
           int is_pkg,
           java.util.Date last_demog_update_date,
           java.util.Date last_reader_service_date,
           int n_reader_service_inq,
           int n_times_sub_renewed,
           int n_total_issues_left,
           int oc_id,
           java.util.Date orig_order_date,
           int source_code_id,
           int start_issue_id,
           int stop_issue_id,
           byte[] sub_out,
           java.lang.String title,
           java.lang.String cancel_reason_descr,
           java.lang.String start_issue_id_descr,
           java.lang.String stop_issue_id_descr) {
        super(
            subscrip_id,
            audit_name_change,
            audit_title_change,
            backlabels,
            cancel_date,
            cancel_reason,
            customer_id,
            is_pkg,
            last_demog_update_date,
            last_reader_service_date,
            n_reader_service_inq,
            n_times_sub_renewed,
            n_total_issues_left,
            oc_id,
            orig_order_date,
            source_code_id,
            start_issue_id,
            stop_issue_id,
            sub_out,
            title);
        this.cancel_reason_descr = cancel_reason_descr;
        this.start_issue_id_descr = start_issue_id_descr;
        this.stop_issue_id_descr = stop_issue_id_descr;
    }


    /**
     * Gets the cancel_reason_descr value for this Td_subscrip.
     * 
     * @return cancel_reason_descr
     */
    public java.lang.String getCancel_reason_descr() {
        return cancel_reason_descr;
    }


    /**
     * Sets the cancel_reason_descr value for this Td_subscrip.
     * 
     * @param cancel_reason_descr
     */
    public void setCancel_reason_descr(java.lang.String cancel_reason_descr) {
        this.cancel_reason_descr = cancel_reason_descr;
    }


    /**
     * Gets the start_issue_id_descr value for this Td_subscrip.
     * 
     * @return start_issue_id_descr
     */
    public java.lang.String getStart_issue_id_descr() {
        return start_issue_id_descr;
    }


    /**
     * Sets the start_issue_id_descr value for this Td_subscrip.
     * 
     * @param start_issue_id_descr
     */
    public void setStart_issue_id_descr(java.lang.String start_issue_id_descr) {
        this.start_issue_id_descr = start_issue_id_descr;
    }


    /**
     * Gets the stop_issue_id_descr value for this Td_subscrip.
     * 
     * @return stop_issue_id_descr
     */
    public java.lang.String getStop_issue_id_descr() {
        return stop_issue_id_descr;
    }


    /**
     * Sets the stop_issue_id_descr value for this Td_subscrip.
     * 
     * @param stop_issue_id_descr
     */
    public void setStop_issue_id_descr(java.lang.String stop_issue_id_descr) {
        this.stop_issue_id_descr = stop_issue_id_descr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_subscrip)) return false;
        Td_subscrip other = (Td_subscrip) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cancel_reason_descr==null && other.getCancel_reason_descr()==null) || 
             (this.cancel_reason_descr!=null &&
              this.cancel_reason_descr.equals(other.getCancel_reason_descr()))) &&
            ((this.start_issue_id_descr==null && other.getStart_issue_id_descr()==null) || 
             (this.start_issue_id_descr!=null &&
              this.start_issue_id_descr.equals(other.getStart_issue_id_descr()))) &&
            ((this.stop_issue_id_descr==null && other.getStop_issue_id_descr()==null) || 
             (this.stop_issue_id_descr!=null &&
              this.stop_issue_id_descr.equals(other.getStop_issue_id_descr())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCancel_reason_descr() != null) {
            _hashCode += getCancel_reason_descr().hashCode();
        }
        if (getStart_issue_id_descr() != null) {
            _hashCode += getStart_issue_id_descr().hashCode();
        }
        if (getStop_issue_id_descr() != null) {
            _hashCode += getStop_issue_id_descr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_subscrip.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_subscrip"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_reason_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_reason_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_issue_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_issue_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("stop_issue_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "stop_issue_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
