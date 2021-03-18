/**
 * Journal_select_responseJournal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Journal_select_responseJournal  implements java.io.Serializable {
    private int journal_id;  // attribute

    private int date_stamp;  // attribute

    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int posting_reference;  // attribute

    private java.math.BigDecimal tax_amount;  // attribute

    private java.math.BigDecimal net_amount;  // attribute

    private java.math.BigDecimal del_amount;  // attribute

    private java.math.BigDecimal com_amount;  // attribute

    private int debit_account;  // attribute

    private int qty_debit_account;  // attribute

    private int credit_account;  // attribute

    private int qty_credit_account;  // attribute

    private int qty;  // attribute

    private int customer_id;  // attribute

    private int payment_seq;  // attribute

    private int bndl_qty;  // attribute

    private int job_id;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private java.lang.String post_ref_desc;  // attribute

    public Journal_select_responseJournal() {
    }

    public Journal_select_responseJournal(
           int journal_id,
           int date_stamp,
           int orderhdr_id,
           int order_item_seq,
           int posting_reference,
           java.math.BigDecimal tax_amount,
           java.math.BigDecimal net_amount,
           java.math.BigDecimal del_amount,
           java.math.BigDecimal com_amount,
           int debit_account,
           int qty_debit_account,
           int credit_account,
           int qty_credit_account,
           int qty,
           int customer_id,
           int payment_seq,
           int bndl_qty,
           int job_id,
           java.util.Calendar creation_date,
           java.lang.String post_ref_desc) {
           this.journal_id = journal_id;
           this.date_stamp = date_stamp;
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.posting_reference = posting_reference;
           this.tax_amount = tax_amount;
           this.net_amount = net_amount;
           this.del_amount = del_amount;
           this.com_amount = com_amount;
           this.debit_account = debit_account;
           this.qty_debit_account = qty_debit_account;
           this.credit_account = credit_account;
           this.qty_credit_account = qty_credit_account;
           this.qty = qty;
           this.customer_id = customer_id;
           this.payment_seq = payment_seq;
           this.bndl_qty = bndl_qty;
           this.job_id = job_id;
           this.creation_date = creation_date;
           this.post_ref_desc = post_ref_desc;
    }


    /**
     * Gets the journal_id value for this Journal_select_responseJournal.
     * 
     * @return journal_id
     */
    public int getJournal_id() {
        return journal_id;
    }


    /**
     * Sets the journal_id value for this Journal_select_responseJournal.
     * 
     * @param journal_id
     */
    public void setJournal_id(int journal_id) {
        this.journal_id = journal_id;
    }


    /**
     * Gets the date_stamp value for this Journal_select_responseJournal.
     * 
     * @return date_stamp
     */
    public int getDate_stamp() {
        return date_stamp;
    }


    /**
     * Sets the date_stamp value for this Journal_select_responseJournal.
     * 
     * @param date_stamp
     */
    public void setDate_stamp(int date_stamp) {
        this.date_stamp = date_stamp;
    }


    /**
     * Gets the orderhdr_id value for this Journal_select_responseJournal.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Journal_select_responseJournal.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Journal_select_responseJournal.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Journal_select_responseJournal.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the posting_reference value for this Journal_select_responseJournal.
     * 
     * @return posting_reference
     */
    public int getPosting_reference() {
        return posting_reference;
    }


    /**
     * Sets the posting_reference value for this Journal_select_responseJournal.
     * 
     * @param posting_reference
     */
    public void setPosting_reference(int posting_reference) {
        this.posting_reference = posting_reference;
    }


    /**
     * Gets the tax_amount value for this Journal_select_responseJournal.
     * 
     * @return tax_amount
     */
    public java.math.BigDecimal getTax_amount() {
        return tax_amount;
    }


    /**
     * Sets the tax_amount value for this Journal_select_responseJournal.
     * 
     * @param tax_amount
     */
    public void setTax_amount(java.math.BigDecimal tax_amount) {
        this.tax_amount = tax_amount;
    }


    /**
     * Gets the net_amount value for this Journal_select_responseJournal.
     * 
     * @return net_amount
     */
    public java.math.BigDecimal getNet_amount() {
        return net_amount;
    }


    /**
     * Sets the net_amount value for this Journal_select_responseJournal.
     * 
     * @param net_amount
     */
    public void setNet_amount(java.math.BigDecimal net_amount) {
        this.net_amount = net_amount;
    }


    /**
     * Gets the del_amount value for this Journal_select_responseJournal.
     * 
     * @return del_amount
     */
    public java.math.BigDecimal getDel_amount() {
        return del_amount;
    }


    /**
     * Sets the del_amount value for this Journal_select_responseJournal.
     * 
     * @param del_amount
     */
    public void setDel_amount(java.math.BigDecimal del_amount) {
        this.del_amount = del_amount;
    }


    /**
     * Gets the com_amount value for this Journal_select_responseJournal.
     * 
     * @return com_amount
     */
    public java.math.BigDecimal getCom_amount() {
        return com_amount;
    }


    /**
     * Sets the com_amount value for this Journal_select_responseJournal.
     * 
     * @param com_amount
     */
    public void setCom_amount(java.math.BigDecimal com_amount) {
        this.com_amount = com_amount;
    }


    /**
     * Gets the debit_account value for this Journal_select_responseJournal.
     * 
     * @return debit_account
     */
    public int getDebit_account() {
        return debit_account;
    }


    /**
     * Sets the debit_account value for this Journal_select_responseJournal.
     * 
     * @param debit_account
     */
    public void setDebit_account(int debit_account) {
        this.debit_account = debit_account;
    }


    /**
     * Gets the qty_debit_account value for this Journal_select_responseJournal.
     * 
     * @return qty_debit_account
     */
    public int getQty_debit_account() {
        return qty_debit_account;
    }


    /**
     * Sets the qty_debit_account value for this Journal_select_responseJournal.
     * 
     * @param qty_debit_account
     */
    public void setQty_debit_account(int qty_debit_account) {
        this.qty_debit_account = qty_debit_account;
    }


    /**
     * Gets the credit_account value for this Journal_select_responseJournal.
     * 
     * @return credit_account
     */
    public int getCredit_account() {
        return credit_account;
    }


    /**
     * Sets the credit_account value for this Journal_select_responseJournal.
     * 
     * @param credit_account
     */
    public void setCredit_account(int credit_account) {
        this.credit_account = credit_account;
    }


    /**
     * Gets the qty_credit_account value for this Journal_select_responseJournal.
     * 
     * @return qty_credit_account
     */
    public int getQty_credit_account() {
        return qty_credit_account;
    }


    /**
     * Sets the qty_credit_account value for this Journal_select_responseJournal.
     * 
     * @param qty_credit_account
     */
    public void setQty_credit_account(int qty_credit_account) {
        this.qty_credit_account = qty_credit_account;
    }


    /**
     * Gets the qty value for this Journal_select_responseJournal.
     * 
     * @return qty
     */
    public int getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this Journal_select_responseJournal.
     * 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    /**
     * Gets the customer_id value for this Journal_select_responseJournal.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Journal_select_responseJournal.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the payment_seq value for this Journal_select_responseJournal.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this Journal_select_responseJournal.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the bndl_qty value for this Journal_select_responseJournal.
     * 
     * @return bndl_qty
     */
    public int getBndl_qty() {
        return bndl_qty;
    }


    /**
     * Sets the bndl_qty value for this Journal_select_responseJournal.
     * 
     * @param bndl_qty
     */
    public void setBndl_qty(int bndl_qty) {
        this.bndl_qty = bndl_qty;
    }


    /**
     * Gets the job_id value for this Journal_select_responseJournal.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Journal_select_responseJournal.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the creation_date value for this Journal_select_responseJournal.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Journal_select_responseJournal.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the post_ref_desc value for this Journal_select_responseJournal.
     * 
     * @return post_ref_desc
     */
    public java.lang.String getPost_ref_desc() {
        return post_ref_desc;
    }


    /**
     * Sets the post_ref_desc value for this Journal_select_responseJournal.
     * 
     * @param post_ref_desc
     */
    public void setPost_ref_desc(java.lang.String post_ref_desc) {
        this.post_ref_desc = post_ref_desc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Journal_select_responseJournal)) return false;
        Journal_select_responseJournal other = (Journal_select_responseJournal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.journal_id == other.getJournal_id() &&
            this.date_stamp == other.getDate_stamp() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.posting_reference == other.getPosting_reference() &&
            ((this.tax_amount==null && other.getTax_amount()==null) || 
             (this.tax_amount!=null &&
              this.tax_amount.equals(other.getTax_amount()))) &&
            ((this.net_amount==null && other.getNet_amount()==null) || 
             (this.net_amount!=null &&
              this.net_amount.equals(other.getNet_amount()))) &&
            ((this.del_amount==null && other.getDel_amount()==null) || 
             (this.del_amount!=null &&
              this.del_amount.equals(other.getDel_amount()))) &&
            ((this.com_amount==null && other.getCom_amount()==null) || 
             (this.com_amount!=null &&
              this.com_amount.equals(other.getCom_amount()))) &&
            this.debit_account == other.getDebit_account() &&
            this.qty_debit_account == other.getQty_debit_account() &&
            this.credit_account == other.getCredit_account() &&
            this.qty_credit_account == other.getQty_credit_account() &&
            this.qty == other.getQty() &&
            this.customer_id == other.getCustomer_id() &&
            this.payment_seq == other.getPayment_seq() &&
            this.bndl_qty == other.getBndl_qty() &&
            this.job_id == other.getJob_id() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            ((this.post_ref_desc==null && other.getPost_ref_desc()==null) || 
             (this.post_ref_desc!=null &&
              this.post_ref_desc.equals(other.getPost_ref_desc())));
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
        _hashCode += getJournal_id();
        _hashCode += getDate_stamp();
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getPosting_reference();
        if (getTax_amount() != null) {
            _hashCode += getTax_amount().hashCode();
        }
        if (getNet_amount() != null) {
            _hashCode += getNet_amount().hashCode();
        }
        if (getDel_amount() != null) {
            _hashCode += getDel_amount().hashCode();
        }
        if (getCom_amount() != null) {
            _hashCode += getCom_amount().hashCode();
        }
        _hashCode += getDebit_account();
        _hashCode += getQty_debit_account();
        _hashCode += getCredit_account();
        _hashCode += getQty_credit_account();
        _hashCode += getQty();
        _hashCode += getCustomer_id();
        _hashCode += getPayment_seq();
        _hashCode += getBndl_qty();
        _hashCode += getJob_id();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        if (getPost_ref_desc() != null) {
            _hashCode += getPost_ref_desc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Journal_select_responseJournal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>journal_select_response>journal"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("journal_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "journal_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        attrField.setFieldName("posting_reference");
        attrField.setXmlName(new javax.xml.namespace.QName("", "posting_reference"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tax_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tax_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("net_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "net_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("del_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "del_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("com_amount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "com_amount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("debit_account");
        attrField.setXmlName(new javax.xml.namespace.QName("", "debit_account"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_debit_account");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_debit_account"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_account");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_account"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_credit_account");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_credit_account"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bndl_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bndl_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("post_ref_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "post_ref_desc"));
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
