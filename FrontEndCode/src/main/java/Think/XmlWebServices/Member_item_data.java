/**
 * Member_item_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Member_item_data  implements java.io.Serializable {
    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.lang.String delivery_method;

    private Think.XmlWebServices.Item_amt_break_data[] item_amt_break_data;

    private java.lang.Integer customer_address_seq;

    private java.util.Date start_date;

    private java.lang.Integer start_issue_id;

    private Think.XmlWebServices.ZZBoolean suppress_audit_check;  // attribute

    private Think.XmlWebServices.ZZBoolean suppress_payment_acct_seq;  // attribute

    public Member_item_data() {
    }

    public Member_item_data(
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.lang.String delivery_method,
           Think.XmlWebServices.Item_amt_break_data[] item_amt_break_data,
           java.lang.Integer customer_address_seq,
           java.util.Date start_date,
           java.lang.Integer start_issue_id,
           Think.XmlWebServices.ZZBoolean suppress_audit_check,
           Think.XmlWebServices.ZZBoolean suppress_payment_acct_seq) {
           this.item_identifier = item_identifier;
           this.delivery_method = delivery_method;
           this.item_amt_break_data = item_amt_break_data;
           this.customer_address_seq = customer_address_seq;
           this.start_date = start_date;
           this.start_issue_id = start_issue_id;
           this.suppress_audit_check = suppress_audit_check;
           this.suppress_payment_acct_seq = suppress_payment_acct_seq;
    }


    /**
     * Gets the item_identifier value for this Member_item_data.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Member_item_data.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the delivery_method value for this Member_item_data.
     * 
     * @return delivery_method
     */
    public java.lang.String getDelivery_method() {
        return delivery_method;
    }


    /**
     * Sets the delivery_method value for this Member_item_data.
     * 
     * @param delivery_method
     */
    public void setDelivery_method(java.lang.String delivery_method) {
        this.delivery_method = delivery_method;
    }


    /**
     * Gets the item_amt_break_data value for this Member_item_data.
     * 
     * @return item_amt_break_data
     */
    public Think.XmlWebServices.Item_amt_break_data[] getItem_amt_break_data() {
        return item_amt_break_data;
    }


    /**
     * Sets the item_amt_break_data value for this Member_item_data.
     * 
     * @param item_amt_break_data
     */
    public void setItem_amt_break_data(Think.XmlWebServices.Item_amt_break_data[] item_amt_break_data) {
        this.item_amt_break_data = item_amt_break_data;
    }

    public Think.XmlWebServices.Item_amt_break_data getItem_amt_break_data(int i) {
        return this.item_amt_break_data[i];
    }

    public void setItem_amt_break_data(int i, Think.XmlWebServices.Item_amt_break_data _value) {
        this.item_amt_break_data[i] = _value;
    }


    /**
     * Gets the customer_address_seq value for this Member_item_data.
     * 
     * @return customer_address_seq
     */
    public java.lang.Integer getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Member_item_data.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(java.lang.Integer customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the start_date value for this Member_item_data.
     * 
     * @return start_date
     */
    public java.util.Date getStart_date() {
        return start_date;
    }


    /**
     * Sets the start_date value for this Member_item_data.
     * 
     * @param start_date
     */
    public void setStart_date(java.util.Date start_date) {
        this.start_date = start_date;
    }


    /**
     * Gets the start_issue_id value for this Member_item_data.
     * 
     * @return start_issue_id
     */
    public java.lang.Integer getStart_issue_id() {
        return start_issue_id;
    }


    /**
     * Sets the start_issue_id value for this Member_item_data.
     * 
     * @param start_issue_id
     */
    public void setStart_issue_id(java.lang.Integer start_issue_id) {
        this.start_issue_id = start_issue_id;
    }


    /**
     * Gets the suppress_audit_check value for this Member_item_data.
     * 
     * @return suppress_audit_check
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_audit_check() {
        return suppress_audit_check;
    }


    /**
     * Sets the suppress_audit_check value for this Member_item_data.
     * 
     * @param suppress_audit_check
     */
    public void setSuppress_audit_check(Think.XmlWebServices.ZZBoolean suppress_audit_check) {
        this.suppress_audit_check = suppress_audit_check;
    }


    /**
     * Gets the suppress_payment_acct_seq value for this Member_item_data.
     * 
     * @return suppress_payment_acct_seq
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_payment_acct_seq() {
        return suppress_payment_acct_seq;
    }


    /**
     * Sets the suppress_payment_acct_seq value for this Member_item_data.
     * 
     * @param suppress_payment_acct_seq
     */
    public void setSuppress_payment_acct_seq(Think.XmlWebServices.ZZBoolean suppress_payment_acct_seq) {
        this.suppress_payment_acct_seq = suppress_payment_acct_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Member_item_data)) return false;
        Member_item_data other = (Member_item_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.delivery_method==null && other.getDelivery_method()==null) || 
             (this.delivery_method!=null &&
              this.delivery_method.equals(other.getDelivery_method()))) &&
            ((this.item_amt_break_data==null && other.getItem_amt_break_data()==null) || 
             (this.item_amt_break_data!=null &&
              java.util.Arrays.equals(this.item_amt_break_data, other.getItem_amt_break_data()))) &&
            ((this.customer_address_seq==null && other.getCustomer_address_seq()==null) || 
             (this.customer_address_seq!=null &&
              this.customer_address_seq.equals(other.getCustomer_address_seq()))) &&
            ((this.start_date==null && other.getStart_date()==null) || 
             (this.start_date!=null &&
              this.start_date.equals(other.getStart_date()))) &&
            ((this.start_issue_id==null && other.getStart_issue_id()==null) || 
             (this.start_issue_id!=null &&
              this.start_issue_id.equals(other.getStart_issue_id()))) &&
            ((this.suppress_audit_check==null && other.getSuppress_audit_check()==null) || 
             (this.suppress_audit_check!=null &&
              this.suppress_audit_check.equals(other.getSuppress_audit_check()))) &&
            ((this.suppress_payment_acct_seq==null && other.getSuppress_payment_acct_seq()==null) || 
             (this.suppress_payment_acct_seq!=null &&
              this.suppress_payment_acct_seq.equals(other.getSuppress_payment_acct_seq())));
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
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getDelivery_method() != null) {
            _hashCode += getDelivery_method().hashCode();
        }
        if (getItem_amt_break_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem_amt_break_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem_amt_break_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomer_address_seq() != null) {
            _hashCode += getCustomer_address_seq().hashCode();
        }
        if (getStart_date() != null) {
            _hashCode += getStart_date().hashCode();
        }
        if (getStart_issue_id() != null) {
            _hashCode += getStart_issue_id().hashCode();
        }
        if (getSuppress_audit_check() != null) {
            _hashCode += getSuppress_audit_check().hashCode();
        }
        if (getSuppress_payment_acct_seq() != null) {
            _hashCode += getSuppress_payment_acct_seq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Member_item_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">member_item_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_audit_check");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_audit_check"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_payment_acct_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_payment_acct_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delivery_method");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "delivery_method"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_amt_break_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_amt_break_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_amt_break_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "start_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start_issue_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "start_issue_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
