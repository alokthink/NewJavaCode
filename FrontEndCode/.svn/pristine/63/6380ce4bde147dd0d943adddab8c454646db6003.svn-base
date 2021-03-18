/**
 * Form_letter_history_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Form_letter_history_data  implements java.io.Serializable {
    private int service_type;

    private int report_item_id;

    private java.util.Date start_date_time;

    public Form_letter_history_data() {
    }

    public Form_letter_history_data(
           int service_type,
           int report_item_id,
           java.util.Date start_date_time) {
           this.service_type = service_type;
           this.report_item_id = report_item_id;
           this.start_date_time = start_date_time;
    }


    /**
     * Gets the service_type value for this Form_letter_history_data.
     * 
     * @return service_type
     */
    public int getService_type() {
        return service_type;
    }


    /**
     * Sets the service_type value for this Form_letter_history_data.
     * 
     * @param service_type
     */
    public void setService_type(int service_type) {
        this.service_type = service_type;
    }


    /**
     * Gets the report_item_id value for this Form_letter_history_data.
     * 
     * @return report_item_id
     */
    public int getReport_item_id() {
        return report_item_id;
    }


    /**
     * Sets the report_item_id value for this Form_letter_history_data.
     * 
     * @param report_item_id
     */
    public void setReport_item_id(int report_item_id) {
        this.report_item_id = report_item_id;
    }


    /**
     * Gets the start_date_time value for this Form_letter_history_data.
     * 
     * @return start_date_time
     */
    public java.util.Date getStart_date_time() {
        return start_date_time;
    }


    /**
     * Sets the start_date_time value for this Form_letter_history_data.
     * 
     * @param start_date_time
     */
    public void setStart_date_time(java.util.Date start_date_time) {
        this.start_date_time = start_date_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Form_letter_history_data)) return false;
        Form_letter_history_data other = (Form_letter_history_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.service_type == other.getService_type() &&
            this.report_item_id == other.getReport_item_id() &&
            ((this.start_date_time==null && other.getStart_date_time()==null) || 
             (this.start_date_time!=null &&
              this.start_date_time.equals(other.getStart_date_time())));
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
        _hashCode += getService_type();
        _hashCode += getReport_item_id();
        if (getStart_date_time() != null) {
            _hashCode += getStart_date_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Form_letter_history_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">form_letter_history_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("report_item_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "report_item_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start_date_time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "start_date_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
