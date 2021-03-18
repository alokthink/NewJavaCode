/**
 * Px_update_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_update_data  implements java.io.Serializable {
    private int processed_status;

    private Think.XmlWebServices.Response_data response_data;

    private java.lang.String message_string;

    public Px_update_data() {
    }

    public Px_update_data(
           int processed_status,
           Think.XmlWebServices.Response_data response_data,
           java.lang.String message_string) {
           this.processed_status = processed_status;
           this.response_data = response_data;
           this.message_string = message_string;
    }


    /**
     * Gets the processed_status value for this Px_update_data.
     * 
     * @return processed_status
     */
    public int getProcessed_status() {
        return processed_status;
    }


    /**
     * Sets the processed_status value for this Px_update_data.
     * 
     * @param processed_status
     */
    public void setProcessed_status(int processed_status) {
        this.processed_status = processed_status;
    }


    /**
     * Gets the response_data value for this Px_update_data.
     * 
     * @return response_data
     */
    public Think.XmlWebServices.Response_data getResponse_data() {
        return response_data;
    }


    /**
     * Sets the response_data value for this Px_update_data.
     * 
     * @param response_data
     */
    public void setResponse_data(Think.XmlWebServices.Response_data response_data) {
        this.response_data = response_data;
    }


    /**
     * Gets the message_string value for this Px_update_data.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this Px_update_data.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_update_data)) return false;
        Px_update_data other = (Px_update_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.processed_status == other.getProcessed_status() &&
            ((this.response_data==null && other.getResponse_data()==null) || 
             (this.response_data!=null &&
              this.response_data.equals(other.getResponse_data()))) &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string())));
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
        _hashCode += getProcessed_status();
        if (getResponse_data() != null) {
            _hashCode += getResponse_data().hashCode();
        }
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_update_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">px_update_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processed_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "processed_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "response_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">response_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message_string");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "message_string"));
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
