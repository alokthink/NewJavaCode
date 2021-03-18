/**
 * ZZSuspensionNote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZSuspensionNote  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int suspension_seq;  // attribute

    private int suspension_note_seq;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private java.lang.String note_field;  // attribute

    private java.lang.String user_code;  // attribute

    public ZZSuspensionNote() {
    }

    public ZZSuspensionNote(
           int orderhdr_id,
           int order_item_seq,
           int suspension_seq,
           int suspension_note_seq,
           java.util.Calendar creation_date,
           java.lang.String note_field,
           java.lang.String user_code) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.suspension_seq = suspension_seq;
           this.suspension_note_seq = suspension_note_seq;
           this.creation_date = creation_date;
           this.note_field = note_field;
           this.user_code = user_code;
    }


    /**
     * Gets the orderhdr_id value for this ZZSuspensionNote.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZSuspensionNote.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this ZZSuspensionNote.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZSuspensionNote.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the suspension_seq value for this ZZSuspensionNote.
     * 
     * @return suspension_seq
     */
    public int getSuspension_seq() {
        return suspension_seq;
    }


    /**
     * Sets the suspension_seq value for this ZZSuspensionNote.
     * 
     * @param suspension_seq
     */
    public void setSuspension_seq(int suspension_seq) {
        this.suspension_seq = suspension_seq;
    }


    /**
     * Gets the suspension_note_seq value for this ZZSuspensionNote.
     * 
     * @return suspension_note_seq
     */
    public int getSuspension_note_seq() {
        return suspension_note_seq;
    }


    /**
     * Sets the suspension_note_seq value for this ZZSuspensionNote.
     * 
     * @param suspension_note_seq
     */
    public void setSuspension_note_seq(int suspension_note_seq) {
        this.suspension_note_seq = suspension_note_seq;
    }


    /**
     * Gets the creation_date value for this ZZSuspensionNote.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZSuspensionNote.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the note_field value for this ZZSuspensionNote.
     * 
     * @return note_field
     */
    public java.lang.String getNote_field() {
        return note_field;
    }


    /**
     * Sets the note_field value for this ZZSuspensionNote.
     * 
     * @param note_field
     */
    public void setNote_field(java.lang.String note_field) {
        this.note_field = note_field;
    }


    /**
     * Gets the user_code value for this ZZSuspensionNote.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this ZZSuspensionNote.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZSuspensionNote)) return false;
        ZZSuspensionNote other = (ZZSuspensionNote) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.suspension_seq == other.getSuspension_seq() &&
            this.suspension_note_seq == other.getSuspension_note_seq() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.note_field==null && other.getNote_field()==null) || 
             (this.note_field!=null &&
              this.note_field.equals(other.getNote_field()))) &&
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
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getSuspension_seq();
        _hashCode += getSuspension_note_seq();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getNote_field() != null) {
            _hashCode += getNote_field().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZSuspensionNote.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSuspensionNote"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspension_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspension_note_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_note_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
