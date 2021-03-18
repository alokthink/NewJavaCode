/**
 * Px_add_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_add_data  implements java.io.Serializable {
    private int workflow;

    private int processed_status;

    private Think.XmlWebServices.Request_data request_data;

    private Think.XmlWebServices.Response_data response_data;

    private java.lang.String message_string;

    private java.lang.String name;

    private java.lang.Integer import_record_number;

    private java.lang.Integer import_file_offset;

    private Think.XmlWebServices.Px_detail_data[] px_detail_data;

    public Px_add_data() {
    }

    public Px_add_data(
           int workflow,
           int processed_status,
           Think.XmlWebServices.Request_data request_data,
           Think.XmlWebServices.Response_data response_data,
           java.lang.String message_string,
           java.lang.String name,
           java.lang.Integer import_record_number,
           java.lang.Integer import_file_offset,
           Think.XmlWebServices.Px_detail_data[] px_detail_data) {
           this.workflow = workflow;
           this.processed_status = processed_status;
           this.request_data = request_data;
           this.response_data = response_data;
           this.message_string = message_string;
           this.name = name;
           this.import_record_number = import_record_number;
           this.import_file_offset = import_file_offset;
           this.px_detail_data = px_detail_data;
    }


    /**
     * Gets the workflow value for this Px_add_data.
     * 
     * @return workflow
     */
    public int getWorkflow() {
        return workflow;
    }


    /**
     * Sets the workflow value for this Px_add_data.
     * 
     * @param workflow
     */
    public void setWorkflow(int workflow) {
        this.workflow = workflow;
    }


    /**
     * Gets the processed_status value for this Px_add_data.
     * 
     * @return processed_status
     */
    public int getProcessed_status() {
        return processed_status;
    }


    /**
     * Sets the processed_status value for this Px_add_data.
     * 
     * @param processed_status
     */
    public void setProcessed_status(int processed_status) {
        this.processed_status = processed_status;
    }


    /**
     * Gets the request_data value for this Px_add_data.
     * 
     * @return request_data
     */
    public Think.XmlWebServices.Request_data getRequest_data() {
        return request_data;
    }


    /**
     * Sets the request_data value for this Px_add_data.
     * 
     * @param request_data
     */
    public void setRequest_data(Think.XmlWebServices.Request_data request_data) {
        this.request_data = request_data;
    }


    /**
     * Gets the response_data value for this Px_add_data.
     * 
     * @return response_data
     */
    public Think.XmlWebServices.Response_data getResponse_data() {
        return response_data;
    }


    /**
     * Sets the response_data value for this Px_add_data.
     * 
     * @param response_data
     */
    public void setResponse_data(Think.XmlWebServices.Response_data response_data) {
        this.response_data = response_data;
    }


    /**
     * Gets the message_string value for this Px_add_data.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this Px_add_data.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }


    /**
     * Gets the name value for this Px_add_data.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Px_add_data.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the import_record_number value for this Px_add_data.
     * 
     * @return import_record_number
     */
    public java.lang.Integer getImport_record_number() {
        return import_record_number;
    }


    /**
     * Sets the import_record_number value for this Px_add_data.
     * 
     * @param import_record_number
     */
    public void setImport_record_number(java.lang.Integer import_record_number) {
        this.import_record_number = import_record_number;
    }


    /**
     * Gets the import_file_offset value for this Px_add_data.
     * 
     * @return import_file_offset
     */
    public java.lang.Integer getImport_file_offset() {
        return import_file_offset;
    }


    /**
     * Sets the import_file_offset value for this Px_add_data.
     * 
     * @param import_file_offset
     */
    public void setImport_file_offset(java.lang.Integer import_file_offset) {
        this.import_file_offset = import_file_offset;
    }


    /**
     * Gets the px_detail_data value for this Px_add_data.
     * 
     * @return px_detail_data
     */
    public Think.XmlWebServices.Px_detail_data[] getPx_detail_data() {
        return px_detail_data;
    }


    /**
     * Sets the px_detail_data value for this Px_add_data.
     * 
     * @param px_detail_data
     */
    public void setPx_detail_data(Think.XmlWebServices.Px_detail_data[] px_detail_data) {
        this.px_detail_data = px_detail_data;
    }

    public Think.XmlWebServices.Px_detail_data getPx_detail_data(int i) {
        return this.px_detail_data[i];
    }

    public void setPx_detail_data(int i, Think.XmlWebServices.Px_detail_data _value) {
        this.px_detail_data[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_add_data)) return false;
        Px_add_data other = (Px_add_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.workflow == other.getWorkflow() &&
            this.processed_status == other.getProcessed_status() &&
            ((this.request_data==null && other.getRequest_data()==null) || 
             (this.request_data!=null &&
              this.request_data.equals(other.getRequest_data()))) &&
            ((this.response_data==null && other.getResponse_data()==null) || 
             (this.response_data!=null &&
              this.response_data.equals(other.getResponse_data()))) &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.import_record_number==null && other.getImport_record_number()==null) || 
             (this.import_record_number!=null &&
              this.import_record_number.equals(other.getImport_record_number()))) &&
            ((this.import_file_offset==null && other.getImport_file_offset()==null) || 
             (this.import_file_offset!=null &&
              this.import_file_offset.equals(other.getImport_file_offset()))) &&
            ((this.px_detail_data==null && other.getPx_detail_data()==null) || 
             (this.px_detail_data!=null &&
              java.util.Arrays.equals(this.px_detail_data, other.getPx_detail_data())));
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
        _hashCode += getWorkflow();
        _hashCode += getProcessed_status();
        if (getRequest_data() != null) {
            _hashCode += getRequest_data().hashCode();
        }
        if (getResponse_data() != null) {
            _hashCode += getResponse_data().hashCode();
        }
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getImport_record_number() != null) {
            _hashCode += getImport_record_number().hashCode();
        }
        if (getImport_file_offset() != null) {
            _hashCode += getImport_file_offset().hashCode();
        }
        if (getPx_detail_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPx_detail_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPx_detail_data(), i);
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
        new org.apache.axis.description.TypeDesc(Px_add_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">px_add_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "workflow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processed_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "processed_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("request_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "request_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">request_data"));
        elemField.setMinOccurs(0);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("import_record_number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "import_record_number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("import_file_offset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "import_file_offset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("px_detail_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "px_detail_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "px_detail_data"));
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
