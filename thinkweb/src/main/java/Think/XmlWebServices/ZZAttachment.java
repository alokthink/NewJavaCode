/**
 * ZZAttachment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZAttachment  implements java.io.Serializable {
    private int attachment_id;  // attribute

    private java.lang.String attachment_category;  // attribute

    private byte[] attachment_content;  // attribute

    private int attachment_type;  // attribute

    private java.lang.String attachment_url;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int customer_id;  // attribute

    private java.lang.String file_name;  // attribute

    private java.lang.String note_field;  // attribute

    private int order_item_seq;  // attribute

    private int orderhdr_id;  // attribute

    private int payment_seq;  // attribute

    private java.lang.String user_code;  // attribute

    public ZZAttachment() {
    }

    public ZZAttachment(
           int attachment_id,
           java.lang.String attachment_category,
           byte[] attachment_content,
           int attachment_type,
           java.lang.String attachment_url,
           java.util.Calendar creation_date,
           int customer_id,
           java.lang.String file_name,
           java.lang.String note_field,
           int order_item_seq,
           int orderhdr_id,
           int payment_seq,
           java.lang.String user_code) {
           this.attachment_id = attachment_id;
           this.attachment_category = attachment_category;
           this.attachment_content = attachment_content;
           this.attachment_type = attachment_type;
           this.attachment_url = attachment_url;
           this.creation_date = creation_date;
           this.customer_id = customer_id;
           this.file_name = file_name;
           this.note_field = note_field;
           this.order_item_seq = order_item_seq;
           this.orderhdr_id = orderhdr_id;
           this.payment_seq = payment_seq;
           this.user_code = user_code;
    }


    /**
     * Gets the attachment_id value for this ZZAttachment.
     * 
     * @return attachment_id
     */
    public int getAttachment_id() {
        return attachment_id;
    }


    /**
     * Sets the attachment_id value for this ZZAttachment.
     * 
     * @param attachment_id
     */
    public void setAttachment_id(int attachment_id) {
        this.attachment_id = attachment_id;
    }


    /**
     * Gets the attachment_category value for this ZZAttachment.
     * 
     * @return attachment_category
     */
    public java.lang.String getAttachment_category() {
        return attachment_category;
    }


    /**
     * Sets the attachment_category value for this ZZAttachment.
     * 
     * @param attachment_category
     */
    public void setAttachment_category(java.lang.String attachment_category) {
        this.attachment_category = attachment_category;
    }


    /**
     * Gets the attachment_content value for this ZZAttachment.
     * 
     * @return attachment_content
     */
    public byte[] getAttachment_content() {
        return attachment_content;
    }


    /**
     * Sets the attachment_content value for this ZZAttachment.
     * 
     * @param attachment_content
     */
    public void setAttachment_content(byte[] attachment_content) {
        this.attachment_content = attachment_content;
    }


    /**
     * Gets the attachment_type value for this ZZAttachment.
     * 
     * @return attachment_type
     */
    public int getAttachment_type() {
        return attachment_type;
    }


    /**
     * Sets the attachment_type value for this ZZAttachment.
     * 
     * @param attachment_type
     */
    public void setAttachment_type(int attachment_type) {
        this.attachment_type = attachment_type;
    }


    /**
     * Gets the attachment_url value for this ZZAttachment.
     * 
     * @return attachment_url
     */
    public java.lang.String getAttachment_url() {
        return attachment_url;
    }


    /**
     * Sets the attachment_url value for this ZZAttachment.
     * 
     * @param attachment_url
     */
    public void setAttachment_url(java.lang.String attachment_url) {
        this.attachment_url = attachment_url;
    }


    /**
     * Gets the creation_date value for this ZZAttachment.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZAttachment.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the customer_id value for this ZZAttachment.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZAttachment.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the file_name value for this ZZAttachment.
     * 
     * @return file_name
     */
    public java.lang.String getFile_name() {
        return file_name;
    }


    /**
     * Sets the file_name value for this ZZAttachment.
     * 
     * @param file_name
     */
    public void setFile_name(java.lang.String file_name) {
        this.file_name = file_name;
    }


    /**
     * Gets the note_field value for this ZZAttachment.
     * 
     * @return note_field
     */
    public java.lang.String getNote_field() {
        return note_field;
    }


    /**
     * Sets the note_field value for this ZZAttachment.
     * 
     * @param note_field
     */
    public void setNote_field(java.lang.String note_field) {
        this.note_field = note_field;
    }


    /**
     * Gets the order_item_seq value for this ZZAttachment.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZAttachment.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the orderhdr_id value for this ZZAttachment.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZAttachment.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the payment_seq value for this ZZAttachment.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this ZZAttachment.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the user_code value for this ZZAttachment.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this ZZAttachment.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZAttachment)) return false;
        ZZAttachment other = (ZZAttachment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.attachment_id == other.getAttachment_id() &&
            ((this.attachment_category==null && other.getAttachment_category()==null) || 
             (this.attachment_category!=null &&
              this.attachment_category.equals(other.getAttachment_category()))) &&
            ((this.attachment_content==null && other.getAttachment_content()==null) || 
             (this.attachment_content!=null &&
              java.util.Arrays.equals(this.attachment_content, other.getAttachment_content()))) &&
            this.attachment_type == other.getAttachment_type() &&
            ((this.attachment_url==null && other.getAttachment_url()==null) || 
             (this.attachment_url!=null &&
              this.attachment_url.equals(other.getAttachment_url()))) &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.customer_id == other.getCustomer_id() &&
            ((this.file_name==null && other.getFile_name()==null) || 
             (this.file_name!=null &&
              this.file_name.equals(other.getFile_name()))) &&
            ((this.note_field==null && other.getNote_field()==null) || 
             (this.note_field!=null &&
              this.note_field.equals(other.getNote_field()))) &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.payment_seq == other.getPayment_seq() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code())));
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
        _hashCode += getAttachment_id();
        if (getAttachment_category() != null) {
            _hashCode += getAttachment_category().hashCode();
        }
        if (getAttachment_content() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachment_content());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachment_content(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getAttachment_type();
        if (getAttachment_url() != null) {
            _hashCode += getAttachment_url().hashCode();
        }
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getCustomer_id();
        if (getFile_name() != null) {
            _hashCode += getFile_name().hashCode();
        }
        if (getNote_field() != null) {
            _hashCode += getNote_field().hashCode();
        }
        _hashCode += getOrder_item_seq();
        _hashCode += getOrderhdr_id();
        _hashCode += getPayment_seq();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZAttachment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZAttachment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_content");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_content"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachment_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachment_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("file_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "file_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("note_field");
        attrField.setXmlName(new javax.xml.namespace.QName("", "note_field"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
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
