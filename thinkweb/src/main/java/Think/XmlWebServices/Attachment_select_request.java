/**
 * Attachment_select_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Attachment_select_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private int customer_id;

    private java.lang.Integer orderhdr_id;

    private java.lang.Integer order_item_seq;

    private java.lang.Integer payment_seq;

    private Think.XmlWebServices.Attachment_select_requestAttachment_type attachment_type;

    private java.lang.String dsn;  // attribute

    public Attachment_select_request() {
    }

    public Attachment_select_request(
           Think.XmlWebServices.User_login_data user_login_data,
           int customer_id,
           java.lang.Integer orderhdr_id,
           java.lang.Integer order_item_seq,
           java.lang.Integer payment_seq,
           Think.XmlWebServices.Attachment_select_requestAttachment_type attachment_type,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.customer_id = customer_id;
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.payment_seq = payment_seq;
           this.attachment_type = attachment_type;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Attachment_select_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Attachment_select_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_id value for this Attachment_select_request.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Attachment_select_request.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the orderhdr_id value for this Attachment_select_request.
     * 
     * @return orderhdr_id
     */
    public java.lang.Integer getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Attachment_select_request.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.Integer orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Attachment_select_request.
     * 
     * @return order_item_seq
     */
    public java.lang.Integer getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Attachment_select_request.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(java.lang.Integer order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the payment_seq value for this Attachment_select_request.
     * 
     * @return payment_seq
     */
    public java.lang.Integer getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Attachment_select_request.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(java.lang.Integer payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the attachment_type value for this Attachment_select_request.
     * 
     * @return attachment_type
     */
    public Think.XmlWebServices.Attachment_select_requestAttachment_type getAttachment_type() {
        return attachment_type;
    }


    /**
     * Sets the attachment_type value for this Attachment_select_request.
     * 
     * @param attachment_type
     */
    public void setAttachment_type(Think.XmlWebServices.Attachment_select_requestAttachment_type attachment_type) {
        this.attachment_type = attachment_type;
    }


    /**
     * Gets the dsn value for this Attachment_select_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Attachment_select_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Attachment_select_request)) return false;
        Attachment_select_request other = (Attachment_select_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            this.customer_id == other.getCustomer_id() &&
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
            ((this.order_item_seq==null && other.getOrder_item_seq()==null) || 
             (this.order_item_seq!=null &&
              this.order_item_seq.equals(other.getOrder_item_seq()))) &&
            ((this.payment_seq==null && other.getPayment_seq()==null) || 
             (this.payment_seq!=null &&
              this.payment_seq.equals(other.getPayment_seq()))) &&
            ((this.attachment_type==null && other.getAttachment_type()==null) || 
             (this.attachment_type!=null &&
              this.attachment_type.equals(other.getAttachment_type()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        _hashCode += getCustomer_id();
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getOrder_item_seq() != null) {
            _hashCode += getOrder_item_seq().hashCode();
        }
        if (getPayment_seq() != null) {
            _hashCode += getPayment_seq().hashCode();
        }
        if (getAttachment_type() != null) {
            _hashCode += getAttachment_type().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attachment_select_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">attachment_select_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachment_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "attachment_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>attachment_select_request>attachment_type"));
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
