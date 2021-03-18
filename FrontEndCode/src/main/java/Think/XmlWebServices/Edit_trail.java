/**
 * Edit_trail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Edit_trail  implements java.io.Serializable {
    private java.util.Calendar creation_date;  // attribute

    private java.lang.String xaction_name;  // attribute

    private java.lang.String edited;  // attribute

    private java.lang.String table_enum;  // attribute

    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int payment_seq;  // attribute

    private int customer_address_seq;  // attribute

    private int payment_account_seq;  // attribute

    private java.lang.String before_change;  // attribute

    private java.lang.String after_change;  // attribute

    private java.lang.String column_name;  // attribute

    private int document_reference_id;  // attribute

    private java.lang.String description;  // attribute

    private int document_reference_seq;  // attribute

    private int pending_xaction_header_id;  // attribute

    private int voucher_id;  // attribute

    private java.lang.String voucher_nbr;  // attribute

    private java.lang.String user_code;  // attribute

    private int edit_trail_id;  // attribute

    private int customer_id;  // attribute

    public Edit_trail() {
    }

    public Edit_trail(
           java.util.Calendar creation_date,
           java.lang.String xaction_name,
           java.lang.String edited,
           java.lang.String table_enum,
           int orderhdr_id,
           int order_item_seq,
           int payment_seq,
           int customer_address_seq,
           int payment_account_seq,
           java.lang.String before_change,
           java.lang.String after_change,
           java.lang.String column_name,
           int document_reference_id,
           java.lang.String description,
           int document_reference_seq,
           int pending_xaction_header_id,
           int voucher_id,
           java.lang.String voucher_nbr,
           java.lang.String user_code,
           int edit_trail_id,
           int customer_id) {
           this.creation_date = creation_date;
           this.xaction_name = xaction_name;
           this.edited = edited;
           this.table_enum = table_enum;
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.payment_seq = payment_seq;
           this.customer_address_seq = customer_address_seq;
           this.payment_account_seq = payment_account_seq;
           this.before_change = before_change;
           this.after_change = after_change;
           this.column_name = column_name;
           this.document_reference_id = document_reference_id;
           this.description = description;
           this.document_reference_seq = document_reference_seq;
           this.pending_xaction_header_id = pending_xaction_header_id;
           this.voucher_id = voucher_id;
           this.voucher_nbr = voucher_nbr;
           this.user_code = user_code;
           this.edit_trail_id = edit_trail_id;
           this.customer_id = customer_id;
    }


    /**
     * Gets the creation_date value for this Edit_trail.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Edit_trail.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the xaction_name value for this Edit_trail.
     * 
     * @return xaction_name
     */
    public java.lang.String getXaction_name() {
        return xaction_name;
    }


    /**
     * Sets the xaction_name value for this Edit_trail.
     * 
     * @param xaction_name
     */
    public void setXaction_name(java.lang.String xaction_name) {
        this.xaction_name = xaction_name;
    }


    /**
     * Gets the edited value for this Edit_trail.
     * 
     * @return edited
     */
    public java.lang.String getEdited() {
        return edited;
    }


    /**
     * Sets the edited value for this Edit_trail.
     * 
     * @param edited
     */
    public void setEdited(java.lang.String edited) {
        this.edited = edited;
    }


    /**
     * Gets the table_enum value for this Edit_trail.
     * 
     * @return table_enum
     */
    public java.lang.String getTable_enum() {
        return table_enum;
    }


    /**
     * Sets the table_enum value for this Edit_trail.
     * 
     * @param table_enum
     */
    public void setTable_enum(java.lang.String table_enum) {
        this.table_enum = table_enum;
    }


    /**
     * Gets the orderhdr_id value for this Edit_trail.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Edit_trail.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Edit_trail.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Edit_trail.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the payment_seq value for this Edit_trail.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Edit_trail.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the customer_address_seq value for this Edit_trail.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Edit_trail.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the payment_account_seq value for this Edit_trail.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this Edit_trail.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the before_change value for this Edit_trail.
     * 
     * @return before_change
     */
    public java.lang.String getBefore_change() {
        return before_change;
    }


    /**
     * Sets the before_change value for this Edit_trail.
     * 
     * @param before_change
     */
    public void setBefore_change(java.lang.String before_change) {
        this.before_change = before_change;
    }


    /**
     * Gets the after_change value for this Edit_trail.
     * 
     * @return after_change
     */
    public java.lang.String getAfter_change() {
        return after_change;
    }


    /**
     * Sets the after_change value for this Edit_trail.
     * 
     * @param after_change
     */
    public void setAfter_change(java.lang.String after_change) {
        this.after_change = after_change;
    }


    /**
     * Gets the column_name value for this Edit_trail.
     * 
     * @return column_name
     */
    public java.lang.String getColumn_name() {
        return column_name;
    }


    /**
     * Sets the column_name value for this Edit_trail.
     * 
     * @param column_name
     */
    public void setColumn_name(java.lang.String column_name) {
        this.column_name = column_name;
    }


    /**
     * Gets the document_reference_id value for this Edit_trail.
     * 
     * @return document_reference_id
     */
    public int getDocument_reference_id() {
        return document_reference_id;
    }


    /**
     * Sets the document_reference_id value for this Edit_trail.
     * 
     * @param document_reference_id
     */
    public void setDocument_reference_id(int document_reference_id) {
        this.document_reference_id = document_reference_id;
    }


    /**
     * Gets the description value for this Edit_trail.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Edit_trail.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the document_reference_seq value for this Edit_trail.
     * 
     * @return document_reference_seq
     */
    public int getDocument_reference_seq() {
        return document_reference_seq;
    }


    /**
     * Sets the document_reference_seq value for this Edit_trail.
     * 
     * @param document_reference_seq
     */
    public void setDocument_reference_seq(int document_reference_seq) {
        this.document_reference_seq = document_reference_seq;
    }


    /**
     * Gets the pending_xaction_header_id value for this Edit_trail.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this Edit_trail.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the voucher_id value for this Edit_trail.
     * 
     * @return voucher_id
     */
    public int getVoucher_id() {
        return voucher_id;
    }


    /**
     * Sets the voucher_id value for this Edit_trail.
     * 
     * @param voucher_id
     */
    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }


    /**
     * Gets the voucher_nbr value for this Edit_trail.
     * 
     * @return voucher_nbr
     */
    public java.lang.String getVoucher_nbr() {
        return voucher_nbr;
    }


    /**
     * Sets the voucher_nbr value for this Edit_trail.
     * 
     * @param voucher_nbr
     */
    public void setVoucher_nbr(java.lang.String voucher_nbr) {
        this.voucher_nbr = voucher_nbr;
    }


    /**
     * Gets the user_code value for this Edit_trail.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Edit_trail.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the edit_trail_id value for this Edit_trail.
     * 
     * @return edit_trail_id
     */
    public int getEdit_trail_id() {
        return edit_trail_id;
    }


    /**
     * Sets the edit_trail_id value for this Edit_trail.
     * 
     * @param edit_trail_id
     */
    public void setEdit_trail_id(int edit_trail_id) {
        this.edit_trail_id = edit_trail_id;
    }


    /**
     * Gets the customer_id value for this Edit_trail.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Edit_trail.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Edit_trail)) return false;
        Edit_trail other = (Edit_trail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.xaction_name==null && other.getXaction_name()==null) || 
             (this.xaction_name!=null &&
              this.xaction_name.equals(other.getXaction_name()))) &&
            ((this.edited==null && other.getEdited()==null) || 
             (this.edited!=null &&
              this.edited.equals(other.getEdited()))) &&
            ((this.table_enum==null && other.getTable_enum()==null) || 
             (this.table_enum!=null &&
              this.table_enum.equals(other.getTable_enum()))) &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.payment_seq == other.getPayment_seq() &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            ((this.before_change==null && other.getBefore_change()==null) || 
             (this.before_change!=null &&
              this.before_change.equals(other.getBefore_change()))) &&
            ((this.after_change==null && other.getAfter_change()==null) || 
             (this.after_change!=null &&
              this.after_change.equals(other.getAfter_change()))) &&
            ((this.column_name==null && other.getColumn_name()==null) || 
             (this.column_name!=null &&
              this.column_name.equals(other.getColumn_name()))) &&
            this.document_reference_id == other.getDocument_reference_id() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.document_reference_seq == other.getDocument_reference_seq() &&
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            this.voucher_id == other.getVoucher_id() &&
            ((this.voucher_nbr==null && other.getVoucher_nbr()==null) || 
             (this.voucher_nbr!=null &&
              this.voucher_nbr.equals(other.getVoucher_nbr()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            this.edit_trail_id == other.getEdit_trail_id() &&
            this.customer_id == other.getCustomer_id();
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
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getXaction_name() != null) {
            _hashCode += getXaction_name().hashCode();
        }
        if (getEdited() != null) {
            _hashCode += getEdited().hashCode();
        }
        if (getTable_enum() != null) {
            _hashCode += getTable_enum().hashCode();
        }
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getPayment_seq();
        _hashCode += getCustomer_address_seq();
        _hashCode += getPayment_account_seq();
        if (getBefore_change() != null) {
            _hashCode += getBefore_change().hashCode();
        }
        if (getAfter_change() != null) {
            _hashCode += getAfter_change().hashCode();
        }
        if (getColumn_name() != null) {
            _hashCode += getColumn_name().hashCode();
        }
        _hashCode += getDocument_reference_id();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getDocument_reference_seq();
        _hashCode += getPending_xaction_header_id();
        _hashCode += getVoucher_id();
        if (getVoucher_nbr() != null) {
            _hashCode += getVoucher_nbr().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        _hashCode += getEdit_trail_id();
        _hashCode += getCustomer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Edit_trail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">edit_trail"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("xaction_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "xaction_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("edited");
        attrField.setXmlName(new javax.xml.namespace.QName("", "edited"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("table_enum");
        attrField.setXmlName(new javax.xml.namespace.QName("", "table_enum"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
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
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("before_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "before_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("after_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "after_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("column_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "column_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("document_reference_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "document_reference_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("document_reference_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "document_reference_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_header_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_header_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("voucher_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "voucher_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("voucher_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "voucher_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("edit_trail_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "edit_trail_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
