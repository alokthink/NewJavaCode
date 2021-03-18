/**
 * ZZOrderItemInstall.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZOrderItemInstall  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private java.lang.String auddis_transaction_code;  // attribute

    private int bacs_transaction_code;  // attribute

    private int cancel_dd;  // attribute

    private int current_year_sent;  // attribute

    private int ddi_accepted;  // attribute

    private int ddi_logged;  // attribute

    private java.lang.String debit_account_ref;  // attribute

    private int install_auto_payment;  // attribute

    private int install_payment_account_seq;  // attribute

    private java.util.Date mandate_date;  // attribute

    private java.util.Date most_recent_payment_date;  // attribute

    private java.util.Date next_payment_date;  // attribute

    private java.util.Date notice_date;  // attribute

    private java.util.Date payment_end_date;  // attribute

    private java.util.Date payment_start_date;  // attribute

    private int pull_day;  // attribute

    private int send_notice;  // attribute

    private int year_end_sent;  // attribute

    public ZZOrderItemInstall() {
    }

    public ZZOrderItemInstall(
           int orderhdr_id,
           int order_item_seq,
           java.lang.String auddis_transaction_code,
           int bacs_transaction_code,
           int cancel_dd,
           int current_year_sent,
           int ddi_accepted,
           int ddi_logged,
           java.lang.String debit_account_ref,
           int install_auto_payment,
           int install_payment_account_seq,
           java.util.Date mandate_date,
           java.util.Date most_recent_payment_date,
           java.util.Date next_payment_date,
           java.util.Date notice_date,
           java.util.Date payment_end_date,
           java.util.Date payment_start_date,
           int pull_day,
           int send_notice,
           int year_end_sent) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.auddis_transaction_code = auddis_transaction_code;
           this.bacs_transaction_code = bacs_transaction_code;
           this.cancel_dd = cancel_dd;
           this.current_year_sent = current_year_sent;
           this.ddi_accepted = ddi_accepted;
           this.ddi_logged = ddi_logged;
           this.debit_account_ref = debit_account_ref;
           this.install_auto_payment = install_auto_payment;
           this.install_payment_account_seq = install_payment_account_seq;
           this.mandate_date = mandate_date;
           this.most_recent_payment_date = most_recent_payment_date;
           this.next_payment_date = next_payment_date;
           this.notice_date = notice_date;
           this.payment_end_date = payment_end_date;
           this.payment_start_date = payment_start_date;
           this.pull_day = pull_day;
           this.send_notice = send_notice;
           this.year_end_sent = year_end_sent;
    }


    /**
     * Gets the orderhdr_id value for this ZZOrderItemInstall.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZOrderItemInstall.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this ZZOrderItemInstall.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZOrderItemInstall.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the auddis_transaction_code value for this ZZOrderItemInstall.
     * 
     * @return auddis_transaction_code
     */
    public java.lang.String getAuddis_transaction_code() {
        return auddis_transaction_code;
    }


    /**
     * Sets the auddis_transaction_code value for this ZZOrderItemInstall.
     * 
     * @param auddis_transaction_code
     */
    public void setAuddis_transaction_code(java.lang.String auddis_transaction_code) {
        this.auddis_transaction_code = auddis_transaction_code;
    }


    /**
     * Gets the bacs_transaction_code value for this ZZOrderItemInstall.
     * 
     * @return bacs_transaction_code
     */
    public int getBacs_transaction_code() {
        return bacs_transaction_code;
    }


    /**
     * Sets the bacs_transaction_code value for this ZZOrderItemInstall.
     * 
     * @param bacs_transaction_code
     */
    public void setBacs_transaction_code(int bacs_transaction_code) {
        this.bacs_transaction_code = bacs_transaction_code;
    }


    /**
     * Gets the cancel_dd value for this ZZOrderItemInstall.
     * 
     * @return cancel_dd
     */
    public int getCancel_dd() {
        return cancel_dd;
    }


    /**
     * Sets the cancel_dd value for this ZZOrderItemInstall.
     * 
     * @param cancel_dd
     */
    public void setCancel_dd(int cancel_dd) {
        this.cancel_dd = cancel_dd;
    }


    /**
     * Gets the current_year_sent value for this ZZOrderItemInstall.
     * 
     * @return current_year_sent
     */
    public int getCurrent_year_sent() {
        return current_year_sent;
    }


    /**
     * Sets the current_year_sent value for this ZZOrderItemInstall.
     * 
     * @param current_year_sent
     */
    public void setCurrent_year_sent(int current_year_sent) {
        this.current_year_sent = current_year_sent;
    }


    /**
     * Gets the ddi_accepted value for this ZZOrderItemInstall.
     * 
     * @return ddi_accepted
     */
    public int getDdi_accepted() {
        return ddi_accepted;
    }


    /**
     * Sets the ddi_accepted value for this ZZOrderItemInstall.
     * 
     * @param ddi_accepted
     */
    public void setDdi_accepted(int ddi_accepted) {
        this.ddi_accepted = ddi_accepted;
    }


    /**
     * Gets the ddi_logged value for this ZZOrderItemInstall.
     * 
     * @return ddi_logged
     */
    public int getDdi_logged() {
        return ddi_logged;
    }


    /**
     * Sets the ddi_logged value for this ZZOrderItemInstall.
     * 
     * @param ddi_logged
     */
    public void setDdi_logged(int ddi_logged) {
        this.ddi_logged = ddi_logged;
    }


    /**
     * Gets the debit_account_ref value for this ZZOrderItemInstall.
     * 
     * @return debit_account_ref
     */
    public java.lang.String getDebit_account_ref() {
        return debit_account_ref;
    }


    /**
     * Sets the debit_account_ref value for this ZZOrderItemInstall.
     * 
     * @param debit_account_ref
     */
    public void setDebit_account_ref(java.lang.String debit_account_ref) {
        this.debit_account_ref = debit_account_ref;
    }


    /**
     * Gets the install_auto_payment value for this ZZOrderItemInstall.
     * 
     * @return install_auto_payment
     */
    public int getInstall_auto_payment() {
        return install_auto_payment;
    }


    /**
     * Sets the install_auto_payment value for this ZZOrderItemInstall.
     * 
     * @param install_auto_payment
     */
    public void setInstall_auto_payment(int install_auto_payment) {
        this.install_auto_payment = install_auto_payment;
    }


    /**
     * Gets the install_payment_account_seq value for this ZZOrderItemInstall.
     * 
     * @return install_payment_account_seq
     */
    public int getInstall_payment_account_seq() {
        return install_payment_account_seq;
    }


    /**
     * Sets the install_payment_account_seq value for this ZZOrderItemInstall.
     * 
     * @param install_payment_account_seq
     */
    public void setInstall_payment_account_seq(int install_payment_account_seq) {
        this.install_payment_account_seq = install_payment_account_seq;
    }


    /**
     * Gets the mandate_date value for this ZZOrderItemInstall.
     * 
     * @return mandate_date
     */
    public java.util.Date getMandate_date() {
        return mandate_date;
    }


    /**
     * Sets the mandate_date value for this ZZOrderItemInstall.
     * 
     * @param mandate_date
     */
    public void setMandate_date(java.util.Date mandate_date) {
        this.mandate_date = mandate_date;
    }


    /**
     * Gets the most_recent_payment_date value for this ZZOrderItemInstall.
     * 
     * @return most_recent_payment_date
     */
    public java.util.Date getMost_recent_payment_date() {
        return most_recent_payment_date;
    }


    /**
     * Sets the most_recent_payment_date value for this ZZOrderItemInstall.
     * 
     * @param most_recent_payment_date
     */
    public void setMost_recent_payment_date(java.util.Date most_recent_payment_date) {
        this.most_recent_payment_date = most_recent_payment_date;
    }


    /**
     * Gets the next_payment_date value for this ZZOrderItemInstall.
     * 
     * @return next_payment_date
     */
    public java.util.Date getNext_payment_date() {
        return next_payment_date;
    }


    /**
     * Sets the next_payment_date value for this ZZOrderItemInstall.
     * 
     * @param next_payment_date
     */
    public void setNext_payment_date(java.util.Date next_payment_date) {
        this.next_payment_date = next_payment_date;
    }


    /**
     * Gets the notice_date value for this ZZOrderItemInstall.
     * 
     * @return notice_date
     */
    public java.util.Date getNotice_date() {
        return notice_date;
    }


    /**
     * Sets the notice_date value for this ZZOrderItemInstall.
     * 
     * @param notice_date
     */
    public void setNotice_date(java.util.Date notice_date) {
        this.notice_date = notice_date;
    }


    /**
     * Gets the payment_end_date value for this ZZOrderItemInstall.
     * 
     * @return payment_end_date
     */
    public java.util.Date getPayment_end_date() {
        return payment_end_date;
    }


    /**
     * Sets the payment_end_date value for this ZZOrderItemInstall.
     * 
     * @param payment_end_date
     */
    public void setPayment_end_date(java.util.Date payment_end_date) {
        this.payment_end_date = payment_end_date;
    }


    /**
     * Gets the payment_start_date value for this ZZOrderItemInstall.
     * 
     * @return payment_start_date
     */
    public java.util.Date getPayment_start_date() {
        return payment_start_date;
    }


    /**
     * Sets the payment_start_date value for this ZZOrderItemInstall.
     * 
     * @param payment_start_date
     */
    public void setPayment_start_date(java.util.Date payment_start_date) {
        this.payment_start_date = payment_start_date;
    }


    /**
     * Gets the pull_day value for this ZZOrderItemInstall.
     * 
     * @return pull_day
     */
    public int getPull_day() {
        return pull_day;
    }


    /**
     * Sets the pull_day value for this ZZOrderItemInstall.
     * 
     * @param pull_day
     */
    public void setPull_day(int pull_day) {
        this.pull_day = pull_day;
    }


    /**
     * Gets the send_notice value for this ZZOrderItemInstall.
     * 
     * @return send_notice
     */
    public int getSend_notice() {
        return send_notice;
    }


    /**
     * Sets the send_notice value for this ZZOrderItemInstall.
     * 
     * @param send_notice
     */
    public void setSend_notice(int send_notice) {
        this.send_notice = send_notice;
    }


    /**
     * Gets the year_end_sent value for this ZZOrderItemInstall.
     * 
     * @return year_end_sent
     */
    public int getYear_end_sent() {
        return year_end_sent;
    }


    /**
     * Sets the year_end_sent value for this ZZOrderItemInstall.
     * 
     * @param year_end_sent
     */
    public void setYear_end_sent(int year_end_sent) {
        this.year_end_sent = year_end_sent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZOrderItemInstall)) return false;
        ZZOrderItemInstall other = (ZZOrderItemInstall) obj;
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
            ((this.auddis_transaction_code==null && other.getAuddis_transaction_code()==null) || 
             (this.auddis_transaction_code!=null &&
              this.auddis_transaction_code.equals(other.getAuddis_transaction_code()))) &&
            this.bacs_transaction_code == other.getBacs_transaction_code() &&
            this.cancel_dd == other.getCancel_dd() &&
            this.current_year_sent == other.getCurrent_year_sent() &&
            this.ddi_accepted == other.getDdi_accepted() &&
            this.ddi_logged == other.getDdi_logged() &&
            ((this.debit_account_ref==null && other.getDebit_account_ref()==null) || 
             (this.debit_account_ref!=null &&
              this.debit_account_ref.equals(other.getDebit_account_ref()))) &&
            this.install_auto_payment == other.getInstall_auto_payment() &&
            this.install_payment_account_seq == other.getInstall_payment_account_seq() &&
            ((this.mandate_date==null && other.getMandate_date()==null) || 
             (this.mandate_date!=null &&
              this.mandate_date.equals(other.getMandate_date()))) &&
            ((this.most_recent_payment_date==null && other.getMost_recent_payment_date()==null) || 
             (this.most_recent_payment_date!=null &&
              this.most_recent_payment_date.equals(other.getMost_recent_payment_date()))) &&
            ((this.next_payment_date==null && other.getNext_payment_date()==null) || 
             (this.next_payment_date!=null &&
              this.next_payment_date.equals(other.getNext_payment_date()))) &&
            ((this.notice_date==null && other.getNotice_date()==null) || 
             (this.notice_date!=null &&
              this.notice_date.equals(other.getNotice_date()))) &&
            ((this.payment_end_date==null && other.getPayment_end_date()==null) || 
             (this.payment_end_date!=null &&
              this.payment_end_date.equals(other.getPayment_end_date()))) &&
            ((this.payment_start_date==null && other.getPayment_start_date()==null) || 
             (this.payment_start_date!=null &&
              this.payment_start_date.equals(other.getPayment_start_date()))) &&
            this.pull_day == other.getPull_day() &&
            this.send_notice == other.getSend_notice() &&
            this.year_end_sent == other.getYear_end_sent();
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
        if (getAuddis_transaction_code() != null) {
            _hashCode += getAuddis_transaction_code().hashCode();
        }
        _hashCode += getBacs_transaction_code();
        _hashCode += getCancel_dd();
        _hashCode += getCurrent_year_sent();
        _hashCode += getDdi_accepted();
        _hashCode += getDdi_logged();
        if (getDebit_account_ref() != null) {
            _hashCode += getDebit_account_ref().hashCode();
        }
        _hashCode += getInstall_auto_payment();
        _hashCode += getInstall_payment_account_seq();
        if (getMandate_date() != null) {
            _hashCode += getMandate_date().hashCode();
        }
        if (getMost_recent_payment_date() != null) {
            _hashCode += getMost_recent_payment_date().hashCode();
        }
        if (getNext_payment_date() != null) {
            _hashCode += getNext_payment_date().hashCode();
        }
        if (getNotice_date() != null) {
            _hashCode += getNotice_date().hashCode();
        }
        if (getPayment_end_date() != null) {
            _hashCode += getPayment_end_date().hashCode();
        }
        if (getPayment_start_date() != null) {
            _hashCode += getPayment_start_date().hashCode();
        }
        _hashCode += getPull_day();
        _hashCode += getSend_notice();
        _hashCode += getYear_end_sent();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZOrderItemInstall.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderItemInstall"));
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
        attrField.setFieldName("auddis_transaction_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auddis_transaction_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bacs_transaction_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bacs_transaction_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_dd");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_dd"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("current_year_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "current_year_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ddi_accepted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ddi_accepted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ddi_logged");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ddi_logged"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("debit_account_ref");
        attrField.setXmlName(new javax.xml.namespace.QName("", "debit_account_ref"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("install_auto_payment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "install_auto_payment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("install_payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "install_payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mandate_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mandate_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("most_recent_payment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "most_recent_payment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("next_payment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "next_payment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("notice_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "notice_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_end_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_end_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_start_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_start_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pull_day");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pull_day"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_notice");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_notice"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("year_end_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "year_end_sent"));
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
