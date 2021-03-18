/**
 * Service_note_select_responseService_note.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Service_note_select_responseService_note  implements java.io.Serializable {
    private int customer_id;  // attribute

    private int service_seq;  // attribute

    private int service_note_seq;  // attribute

    private java.lang.String user_code;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private java.lang.String note_field;  // attribute

    public Service_note_select_responseService_note() {
    }

    public Service_note_select_responseService_note(
           int customer_id,
           int service_seq,
           int service_note_seq,
           java.lang.String user_code,
           java.util.Calendar creation_date,
           java.lang.String note_field) {
           this.customer_id = customer_id;
           this.service_seq = service_seq;
           this.service_note_seq = service_note_seq;
           this.user_code = user_code;
           this.creation_date = creation_date;
           this.note_field = note_field;
    }


    /**
     * Gets the customer_id value for this Service_note_select_responseService_note.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Service_note_select_responseService_note.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the service_seq value for this Service_note_select_responseService_note.
     * 
     * @return service_seq
     */
    public int getService_seq() {
        return service_seq;
    }


    /**
     * Sets the service_seq value for this Service_note_select_responseService_note.
     * 
     * @param service_seq
     */
    public void setService_seq(int service_seq) {
        this.service_seq = service_seq;
    }


    /**
     * Gets the service_note_seq value for this Service_note_select_responseService_note.
     * 
     * @return service_note_seq
     */
    public int getService_note_seq() {
        return service_note_seq;
    }


    /**
     * Sets the service_note_seq value for this Service_note_select_responseService_note.
     * 
     * @param service_note_seq
     */
    public void setService_note_seq(int service_note_seq) {
        this.service_note_seq = service_note_seq;
    }


    /**
     * Gets the user_code value for this Service_note_select_responseService_note.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Service_note_select_responseService_note.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the creation_date value for this Service_note_select_responseService_note.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Service_note_select_responseService_note.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the note_field value for this Service_note_select_responseService_note.
     * 
     * @return note_field
     */
    public java.lang.String getNote_field() {
        return note_field;
    }


    /**
     * Sets the note_field value for this Service_note_select_responseService_note.
     * 
     * @param note_field
     */
    public void setNote_field(java.lang.String note_field) {
        this.note_field = note_field;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Service_note_select_responseService_note)) return false;
        Service_note_select_responseService_note other = (Service_note_select_responseService_note) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
            this.service_seq == other.getService_seq() &&
            this.service_note_seq == other.getService_note_seq() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.note_field==null && other.getNote_field()==null) || 
             (this.note_field!=null &&
              this.note_field.equals(other.getNote_field())));
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
        _hashCode += getCustomer_id();
        _hashCode += getService_seq();
        _hashCode += getService_note_seq();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getNote_field() != null) {
            _hashCode += getNote_field().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Service_note_select_responseService_note.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>service_note_select_response>service_note"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_note_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_note_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("note_field");
        attrField.setXmlName(new javax.xml.namespace.QName("", "note_field"));
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
