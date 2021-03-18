/**
 * Installment_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Installment_data  implements java.io.Serializable {
    private int install_auto_payment;

    private java.lang.Integer install_payment_account_seq;

    private java.util.Date notice_date;

    private java.lang.Boolean send_notice;

    private java.lang.String debit_account_ref;

    private java.lang.Boolean current_year_sent;

    private java.lang.Boolean year_end_sent;

    private java.util.Date payment_start_date;

    private int pull_day;

    private java.lang.Boolean cancel_dd;

    private java.lang.Boolean ddi_logged;

    private java.lang.Boolean ddi_accepted;

    private Think.XmlWebServices.Installment_detail_data[] installment_detail_data;

    public Installment_data() {
    }

    public Installment_data(
           int install_auto_payment,
           java.lang.Integer install_payment_account_seq,
           java.util.Date notice_date,
           java.lang.Boolean send_notice,
           java.lang.String debit_account_ref,
           java.lang.Boolean current_year_sent,
           java.lang.Boolean year_end_sent,
           java.util.Date payment_start_date,
           int pull_day,
           java.lang.Boolean cancel_dd,
           java.lang.Boolean ddi_logged,
           java.lang.Boolean ddi_accepted,
           Think.XmlWebServices.Installment_detail_data[] installment_detail_data) {
           this.install_auto_payment = install_auto_payment;
           this.install_payment_account_seq = install_payment_account_seq;
           this.notice_date = notice_date;
           this.send_notice = send_notice;
           this.debit_account_ref = debit_account_ref;
           this.current_year_sent = current_year_sent;
           this.year_end_sent = year_end_sent;
           this.payment_start_date = payment_start_date;
           this.pull_day = pull_day;
           this.cancel_dd = cancel_dd;
           this.ddi_logged = ddi_logged;
           this.ddi_accepted = ddi_accepted;
           this.installment_detail_data = installment_detail_data;
    }


    /**
     * Gets the install_auto_payment value for this Installment_data.
     * 
     * @return install_auto_payment
     */
    public int getInstall_auto_payment() {
        return install_auto_payment;
    }


    /**
     * Sets the install_auto_payment value for this Installment_data.
     * 
     * @param install_auto_payment
     */
    public void setInstall_auto_payment(int install_auto_payment) {
        this.install_auto_payment = install_auto_payment;
    }


    /**
     * Gets the install_payment_account_seq value for this Installment_data.
     * 
     * @return install_payment_account_seq
     */
    public java.lang.Integer getInstall_payment_account_seq() {
        return install_payment_account_seq;
    }


    /**
     * Sets the install_payment_account_seq value for this Installment_data.
     * 
     * @param install_payment_account_seq
     */
    public void setInstall_payment_account_seq(java.lang.Integer install_payment_account_seq) {
        this.install_payment_account_seq = install_payment_account_seq;
    }


    /**
     * Gets the notice_date value for this Installment_data.
     * 
     * @return notice_date
     */
    public java.util.Date getNotice_date() {
        return notice_date;
    }


    /**
     * Sets the notice_date value for this Installment_data.
     * 
     * @param notice_date
     */
    public void setNotice_date(java.util.Date notice_date) {
        this.notice_date = notice_date;
    }


    /**
     * Gets the send_notice value for this Installment_data.
     * 
     * @return send_notice
     */
    public java.lang.Boolean getSend_notice() {
        return send_notice;
    }


    /**
     * Sets the send_notice value for this Installment_data.
     * 
     * @param send_notice
     */
    public void setSend_notice(java.lang.Boolean send_notice) {
        this.send_notice = send_notice;
    }


    /**
     * Gets the debit_account_ref value for this Installment_data.
     * 
     * @return debit_account_ref
     */
    public java.lang.String getDebit_account_ref() {
        return debit_account_ref;
    }


    /**
     * Sets the debit_account_ref value for this Installment_data.
     * 
     * @param debit_account_ref
     */
    public void setDebit_account_ref(java.lang.String debit_account_ref) {
        this.debit_account_ref = debit_account_ref;
    }


    /**
     * Gets the current_year_sent value for this Installment_data.
     * 
     * @return current_year_sent
     */
    public java.lang.Boolean getCurrent_year_sent() {
        return current_year_sent;
    }


    /**
     * Sets the current_year_sent value for this Installment_data.
     * 
     * @param current_year_sent
     */
    public void setCurrent_year_sent(java.lang.Boolean current_year_sent) {
        this.current_year_sent = current_year_sent;
    }


    /**
     * Gets the year_end_sent value for this Installment_data.
     * 
     * @return year_end_sent
     */
    public java.lang.Boolean getYear_end_sent() {
        return year_end_sent;
    }


    /**
     * Sets the year_end_sent value for this Installment_data.
     * 
     * @param year_end_sent
     */
    public void setYear_end_sent(java.lang.Boolean year_end_sent) {
        this.year_end_sent = year_end_sent;
    }


    /**
     * Gets the payment_start_date value for this Installment_data.
     * 
     * @return payment_start_date
     */
    public java.util.Date getPayment_start_date() {
        return payment_start_date;
    }


    /**
     * Sets the payment_start_date value for this Installment_data.
     * 
     * @param payment_start_date
     */
    public void setPayment_start_date(java.util.Date payment_start_date) {
        this.payment_start_date = payment_start_date;
    }


    /**
     * Gets the pull_day value for this Installment_data.
     * 
     * @return pull_day
     */
    public int getPull_day() {
        return pull_day;
    }


    /**
     * Sets the pull_day value for this Installment_data.
     * 
     * @param pull_day
     */
    public void setPull_day(int pull_day) {
        this.pull_day = pull_day;
    }


    /**
     * Gets the cancel_dd value for this Installment_data.
     * 
     * @return cancel_dd
     */
    public java.lang.Boolean getCancel_dd() {
        return cancel_dd;
    }


    /**
     * Sets the cancel_dd value for this Installment_data.
     * 
     * @param cancel_dd
     */
    public void setCancel_dd(java.lang.Boolean cancel_dd) {
        this.cancel_dd = cancel_dd;
    }


    /**
     * Gets the ddi_logged value for this Installment_data.
     * 
     * @return ddi_logged
     */
    public java.lang.Boolean getDdi_logged() {
        return ddi_logged;
    }


    /**
     * Sets the ddi_logged value for this Installment_data.
     * 
     * @param ddi_logged
     */
    public void setDdi_logged(java.lang.Boolean ddi_logged) {
        this.ddi_logged = ddi_logged;
    }


    /**
     * Gets the ddi_accepted value for this Installment_data.
     * 
     * @return ddi_accepted
     */
    public java.lang.Boolean getDdi_accepted() {
        return ddi_accepted;
    }


    /**
     * Sets the ddi_accepted value for this Installment_data.
     * 
     * @param ddi_accepted
     */
    public void setDdi_accepted(java.lang.Boolean ddi_accepted) {
        this.ddi_accepted = ddi_accepted;
    }


    /**
     * Gets the installment_detail_data value for this Installment_data.
     * 
     * @return installment_detail_data
     */
    public Think.XmlWebServices.Installment_detail_data[] getInstallment_detail_data() {
        return installment_detail_data;
    }


    /**
     * Sets the installment_detail_data value for this Installment_data.
     * 
     * @param installment_detail_data
     */
    public void setInstallment_detail_data(Think.XmlWebServices.Installment_detail_data[] installment_detail_data) {
        this.installment_detail_data = installment_detail_data;
    }

    public Think.XmlWebServices.Installment_detail_data getInstallment_detail_data(int i) {
        return this.installment_detail_data[i];
    }

    public void setInstallment_detail_data(int i, Think.XmlWebServices.Installment_detail_data _value) {
        this.installment_detail_data[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Installment_data)) return false;
        Installment_data other = (Installment_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.install_auto_payment == other.getInstall_auto_payment() &&
            ((this.install_payment_account_seq==null && other.getInstall_payment_account_seq()==null) || 
             (this.install_payment_account_seq!=null &&
              this.install_payment_account_seq.equals(other.getInstall_payment_account_seq()))) &&
            ((this.notice_date==null && other.getNotice_date()==null) || 
             (this.notice_date!=null &&
              this.notice_date.equals(other.getNotice_date()))) &&
            ((this.send_notice==null && other.getSend_notice()==null) || 
             (this.send_notice!=null &&
              this.send_notice.equals(other.getSend_notice()))) &&
            ((this.debit_account_ref==null && other.getDebit_account_ref()==null) || 
             (this.debit_account_ref!=null &&
              this.debit_account_ref.equals(other.getDebit_account_ref()))) &&
            ((this.current_year_sent==null && other.getCurrent_year_sent()==null) || 
             (this.current_year_sent!=null &&
              this.current_year_sent.equals(other.getCurrent_year_sent()))) &&
            ((this.year_end_sent==null && other.getYear_end_sent()==null) || 
             (this.year_end_sent!=null &&
              this.year_end_sent.equals(other.getYear_end_sent()))) &&
            ((this.payment_start_date==null && other.getPayment_start_date()==null) || 
             (this.payment_start_date!=null &&
              this.payment_start_date.equals(other.getPayment_start_date()))) &&
            this.pull_day == other.getPull_day() &&
            ((this.cancel_dd==null && other.getCancel_dd()==null) || 
             (this.cancel_dd!=null &&
              this.cancel_dd.equals(other.getCancel_dd()))) &&
            ((this.ddi_logged==null && other.getDdi_logged()==null) || 
             (this.ddi_logged!=null &&
              this.ddi_logged.equals(other.getDdi_logged()))) &&
            ((this.ddi_accepted==null && other.getDdi_accepted()==null) || 
             (this.ddi_accepted!=null &&
              this.ddi_accepted.equals(other.getDdi_accepted()))) &&
            ((this.installment_detail_data==null && other.getInstallment_detail_data()==null) || 
             (this.installment_detail_data!=null &&
              java.util.Arrays.equals(this.installment_detail_data, other.getInstallment_detail_data())));
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
        _hashCode += getInstall_auto_payment();
        if (getInstall_payment_account_seq() != null) {
            _hashCode += getInstall_payment_account_seq().hashCode();
        }
        if (getNotice_date() != null) {
            _hashCode += getNotice_date().hashCode();
        }
        if (getSend_notice() != null) {
            _hashCode += getSend_notice().hashCode();
        }
        if (getDebit_account_ref() != null) {
            _hashCode += getDebit_account_ref().hashCode();
        }
        if (getCurrent_year_sent() != null) {
            _hashCode += getCurrent_year_sent().hashCode();
        }
        if (getYear_end_sent() != null) {
            _hashCode += getYear_end_sent().hashCode();
        }
        if (getPayment_start_date() != null) {
            _hashCode += getPayment_start_date().hashCode();
        }
        _hashCode += getPull_day();
        if (getCancel_dd() != null) {
            _hashCode += getCancel_dd().hashCode();
        }
        if (getDdi_logged() != null) {
            _hashCode += getDdi_logged().hashCode();
        }
        if (getDdi_accepted() != null) {
            _hashCode += getDdi_accepted().hashCode();
        }
        if (getInstallment_detail_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInstallment_detail_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInstallment_detail_data(), i);
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
        new org.apache.axis.description.TypeDesc(Installment_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">installment_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("install_auto_payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "install_auto_payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("install_payment_account_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "install_payment_account_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notice_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "notice_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("send_notice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "send_notice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debit_account_ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "debit_account_ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("current_year_sent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "current_year_sent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year_end_sent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "year_end_sent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_start_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_start_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pull_day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pull_day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_dd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cancel_dd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddi_logged");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ddi_logged"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddi_accepted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ddi_accepted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installment_detail_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "installment_detail_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "installment_detail_data"));
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
