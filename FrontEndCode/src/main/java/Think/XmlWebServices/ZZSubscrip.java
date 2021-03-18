/**
 * ZZSubscrip.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

import java.util.Arrays;

public class ZZSubscrip  implements java.io.Serializable {
    private int subscrip_id;  // attribute

    private int audit_name_change;  // attribute

    private int audit_title_change;  // attribute

    private byte[] backlabels;  // attribute

    private java.util.Calendar cancel_date;  // attribute

    private java.lang.String cancel_reason;  // attribute

    private int customer_id;  // attribute

    private int is_pkg;  // attribute

    private java.util.Date last_demog_update_date;  // attribute

    private java.util.Date last_reader_service_date;  // attribute

    private int n_reader_service_inq;  // attribute

    private int n_times_sub_renewed;  // attribute

    private int n_total_issues_left;  // attribute

    private int oc_id;  // attribute

    private java.util.Date orig_order_date;  // attribute

    private int source_code_id;  // attribute

    private int start_issue_id;  // attribute

    private int stop_issue_id;  // attribute

    private byte[] sub_out;  // attribute

    private java.lang.String title;  // attribute

    public ZZSubscrip() {
    }

    public ZZSubscrip(
           int subscrip_id,
           int audit_name_change,
           int audit_title_change,
           byte[] backlabels,
           java.util.Calendar cancel_date,
           java.lang.String cancel_reason,
           int customer_id,
           int is_pkg,
           java.util.Date last_demog_update_date,
           java.util.Date last_reader_service_date,
           int n_reader_service_inq,
           int n_times_sub_renewed,
           int n_total_issues_left,
           int oc_id,
           java.util.Date orig_order_date,
           int source_code_id,
           int start_issue_id,
           int stop_issue_id,
           byte[] sub_out,
           java.lang.String title) {
           this.subscrip_id = subscrip_id;
           this.audit_name_change = audit_name_change;
           this.audit_title_change = audit_title_change;
           this.backlabels = backlabels;
           this.cancel_date = cancel_date;
           this.cancel_reason = cancel_reason;
           this.customer_id = customer_id;
           this.is_pkg = is_pkg;
           this.last_demog_update_date = last_demog_update_date;
           this.last_reader_service_date = last_reader_service_date;
           this.n_reader_service_inq = n_reader_service_inq;
           this.n_times_sub_renewed = n_times_sub_renewed;
           this.n_total_issues_left = n_total_issues_left;
           this.oc_id = oc_id;
           this.orig_order_date = orig_order_date;
           this.source_code_id = source_code_id;
           this.start_issue_id = start_issue_id;
           this.stop_issue_id = stop_issue_id;
           this.sub_out = sub_out;
           this.title = title;
    }


    /**
     * Gets the subscrip_id value for this ZZSubscrip.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this ZZSubscrip.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the audit_name_change value for this ZZSubscrip.
     * 
     * @return audit_name_change
     */
    public int getAudit_name_change() {
        return audit_name_change;
    }


    /**
     * Sets the audit_name_change value for this ZZSubscrip.
     * 
     * @param audit_name_change
     */
    public void setAudit_name_change(int audit_name_change) {
        this.audit_name_change = audit_name_change;
    }


    /**
     * Gets the audit_title_change value for this ZZSubscrip.
     * 
     * @return audit_title_change
     */
    public int getAudit_title_change() {
        return audit_title_change;
    }


    /**
     * Sets the audit_title_change value for this ZZSubscrip.
     * 
     * @param audit_title_change
     */
    public void setAudit_title_change(int audit_title_change) {
        this.audit_title_change = audit_title_change;
    }


    /**
     * Gets the backlabels value for this ZZSubscrip.
     * 
     * @return backlabels
     */
    public byte[] getBacklabels() {
        return backlabels;
    }


    /**
     * Sets the backlabels value for this ZZSubscrip.
     * 
     * @param backlabels
     */
    public void setBacklabels(byte[] backlabels) {
        this.backlabels = backlabels;
    }


    /**
     * Gets the cancel_date value for this ZZSubscrip.
     * 
     * @return cancel_date
     */
    public java.util.Calendar getCancel_date() {
        return cancel_date;
    }


    /**
     * Sets the cancel_date value for this ZZSubscrip.
     * 
     * @param cancel_date
     */
    public void setCancel_date(java.util.Calendar cancel_date) {
        this.cancel_date = cancel_date;
    }


    /**
     * Gets the cancel_reason value for this ZZSubscrip.
     * 
     * @return cancel_reason
     */
    public java.lang.String getCancel_reason() {
        return cancel_reason;
    }


    /**
     * Sets the cancel_reason value for this ZZSubscrip.
     * 
     * @param cancel_reason
     */
    public void setCancel_reason(java.lang.String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }


    /**
     * Gets the customer_id value for this ZZSubscrip.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZSubscrip.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the is_pkg value for this ZZSubscrip.
     * 
     * @return is_pkg
     */
    public int getIs_pkg() {
        return is_pkg;
    }


    /**
     * Sets the is_pkg value for this ZZSubscrip.
     * 
     * @param is_pkg
     */
    public void setIs_pkg(int is_pkg) {
        this.is_pkg = is_pkg;
    }


    /**
     * Gets the last_demog_update_date value for this ZZSubscrip.
     * 
     * @return last_demog_update_date
     */
    public java.util.Date getLast_demog_update_date() {
        return last_demog_update_date;
    }


    /**
     * Sets the last_demog_update_date value for this ZZSubscrip.
     * 
     * @param last_demog_update_date
     */
    public void setLast_demog_update_date(java.util.Date last_demog_update_date) {
        this.last_demog_update_date = last_demog_update_date;
    }


    /**
     * Gets the last_reader_service_date value for this ZZSubscrip.
     * 
     * @return last_reader_service_date
     */
    public java.util.Date getLast_reader_service_date() {
        return last_reader_service_date;
    }


    /**
     * Sets the last_reader_service_date value for this ZZSubscrip.
     * 
     * @param last_reader_service_date
     */
    public void setLast_reader_service_date(java.util.Date last_reader_service_date) {
        this.last_reader_service_date = last_reader_service_date;
    }


    /**
     * Gets the n_reader_service_inq value for this ZZSubscrip.
     * 
     * @return n_reader_service_inq
     */
    public int getN_reader_service_inq() {
        return n_reader_service_inq;
    }


    /**
     * Sets the n_reader_service_inq value for this ZZSubscrip.
     * 
     * @param n_reader_service_inq
     */
    public void setN_reader_service_inq(int n_reader_service_inq) {
        this.n_reader_service_inq = n_reader_service_inq;
    }


    /**
     * Gets the n_times_sub_renewed value for this ZZSubscrip.
     * 
     * @return n_times_sub_renewed
     */
    public int getN_times_sub_renewed() {
        return n_times_sub_renewed;
    }


    /**
     * Sets the n_times_sub_renewed value for this ZZSubscrip.
     * 
     * @param n_times_sub_renewed
     */
    public void setN_times_sub_renewed(int n_times_sub_renewed) {
        this.n_times_sub_renewed = n_times_sub_renewed;
    }


    /**
     * Gets the n_total_issues_left value for this ZZSubscrip.
     * 
     * @return n_total_issues_left
     */
    public int getN_total_issues_left() {
        return n_total_issues_left;
    }


    /**
     * Sets the n_total_issues_left value for this ZZSubscrip.
     * 
     * @param n_total_issues_left
     */
    public void setN_total_issues_left(int n_total_issues_left) {
        this.n_total_issues_left = n_total_issues_left;
    }


    /**
     * Gets the oc_id value for this ZZSubscrip.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this ZZSubscrip.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the orig_order_date value for this ZZSubscrip.
     * 
     * @return orig_order_date
     */
    public java.util.Date getOrig_order_date() {
        return orig_order_date;
    }


    /**
     * Sets the orig_order_date value for this ZZSubscrip.
     * 
     * @param orig_order_date
     */
    public void setOrig_order_date(java.util.Date orig_order_date) {
        this.orig_order_date = orig_order_date;
    }


    /**
     * Gets the source_code_id value for this ZZSubscrip.
     * 
     * @return source_code_id
     */
    public int getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this ZZSubscrip.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(int source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the start_issue_id value for this ZZSubscrip.
     * 
     * @return start_issue_id
     */
    public int getStart_issue_id() {
        return start_issue_id;
    }


    /**
     * Sets the start_issue_id value for this ZZSubscrip.
     * 
     * @param start_issue_id
     */
    public void setStart_issue_id(int start_issue_id) {
        this.start_issue_id = start_issue_id;
    }


    /**
     * Gets the stop_issue_id value for this ZZSubscrip.
     * 
     * @return stop_issue_id
     */
    public int getStop_issue_id() {
        return stop_issue_id;
    }


    /**
     * Sets the stop_issue_id value for this ZZSubscrip.
     * 
     * @param stop_issue_id
     */
    public void setStop_issue_id(int stop_issue_id) {
        this.stop_issue_id = stop_issue_id;
    }


    /**
     * Gets the sub_out value for this ZZSubscrip.
     * 
     * @return sub_out
     */
    public byte[] getSub_out() {
        return sub_out;
    }


    /**
     * Sets the sub_out value for this ZZSubscrip.
     * 
     * @param sub_out
     */
    public void setSub_out(byte[] sub_out) {
        this.sub_out = sub_out;
    }


    /**
     * Gets the title value for this ZZSubscrip.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ZZSubscrip.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZSubscrip)) return false;
        ZZSubscrip other = (ZZSubscrip) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.subscrip_id == other.getSubscrip_id() &&
            this.audit_name_change == other.getAudit_name_change() &&
            this.audit_title_change == other.getAudit_title_change() &&
            ((this.backlabels==null && other.getBacklabels()==null) || 
             (this.backlabels!=null &&
              java.util.Arrays.equals(this.backlabels, other.getBacklabels()))) &&
            ((this.cancel_date==null && other.getCancel_date()==null) || 
             (this.cancel_date!=null &&
              this.cancel_date.equals(other.getCancel_date()))) &&
            ((this.cancel_reason==null && other.getCancel_reason()==null) || 
             (this.cancel_reason!=null &&
              this.cancel_reason.equals(other.getCancel_reason()))) &&
            this.customer_id == other.getCustomer_id() &&
            this.is_pkg == other.getIs_pkg() &&
            ((this.last_demog_update_date==null && other.getLast_demog_update_date()==null) || 
             (this.last_demog_update_date!=null &&
              this.last_demog_update_date.equals(other.getLast_demog_update_date()))) &&
            ((this.last_reader_service_date==null && other.getLast_reader_service_date()==null) || 
             (this.last_reader_service_date!=null &&
              this.last_reader_service_date.equals(other.getLast_reader_service_date()))) &&
            this.n_reader_service_inq == other.getN_reader_service_inq() &&
            this.n_times_sub_renewed == other.getN_times_sub_renewed() &&
            this.n_total_issues_left == other.getN_total_issues_left() &&
            this.oc_id == other.getOc_id() &&
            ((this.orig_order_date==null && other.getOrig_order_date()==null) || 
             (this.orig_order_date!=null &&
              this.orig_order_date.equals(other.getOrig_order_date()))) &&
            this.source_code_id == other.getSource_code_id() &&
            this.start_issue_id == other.getStart_issue_id() &&
            this.stop_issue_id == other.getStop_issue_id() &&
            ((this.sub_out==null && other.getSub_out()==null) || 
             (this.sub_out!=null &&
              java.util.Arrays.equals(this.sub_out, other.getSub_out()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
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
        _hashCode += getSubscrip_id();
        _hashCode += getAudit_name_change();
        _hashCode += getAudit_title_change();
        if (getBacklabels() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBacklabels());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBacklabels(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCancel_date() != null) {
            _hashCode += getCancel_date().hashCode();
        }
        if (getCancel_reason() != null) {
            _hashCode += getCancel_reason().hashCode();
        }
        _hashCode += getCustomer_id();
        _hashCode += getIs_pkg();
        if (getLast_demog_update_date() != null) {
            _hashCode += getLast_demog_update_date().hashCode();
        }
        if (getLast_reader_service_date() != null) {
            _hashCode += getLast_reader_service_date().hashCode();
        }
        _hashCode += getN_reader_service_inq();
        _hashCode += getN_times_sub_renewed();
        _hashCode += getN_total_issues_left();
        _hashCode += getOc_id();
        if (getOrig_order_date() != null) {
            _hashCode += getOrig_order_date().hashCode();
        }
        _hashCode += getSource_code_id();
        _hashCode += getStart_issue_id();
        _hashCode += getStop_issue_id();
        if (getSub_out() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSub_out());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSub_out(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZSubscrip.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscrip"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_name_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_name_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_title_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_title_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("backlabels");
        attrField.setXmlName(new javax.xml.namespace.QName("", "backlabels"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_pkg");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_pkg"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_demog_update_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_demog_update_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_reader_service_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_reader_service_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_reader_service_inq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_reader_service_inq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_times_sub_renewed");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_times_sub_renewed"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_total_issues_left");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_total_issues_left"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orig_order_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orig_order_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("stop_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "stop_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sub_out");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sub_out"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("title");
        attrField.setXmlName(new javax.xml.namespace.QName("", "title"));
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

	@Override
	public String toString() {
		return "ZZSubscrip [subscrip_id=" + subscrip_id + ", audit_name_change=" + audit_name_change
				+ ", audit_title_change=" + audit_title_change + ", backlabels=" + Arrays.toString(backlabels)
				+ ", cancel_date=" + cancel_date + ", cancel_reason=" + cancel_reason + ", customer_id=" + customer_id
				+ ", is_pkg=" + is_pkg + ", last_demog_update_date=" + last_demog_update_date
				+ ", last_reader_service_date=" + last_reader_service_date + ", n_reader_service_inq="
				+ n_reader_service_inq + ", n_times_sub_renewed=" + n_times_sub_renewed + ", n_total_issues_left="
				+ n_total_issues_left + ", oc_id=" + oc_id + ", orig_order_date=" + orig_order_date
				+ ", source_code_id=" + source_code_id + ", start_issue_id=" + start_issue_id + ", stop_issue_id="
				+ stop_issue_id + ", sub_out=" + Arrays.toString(sub_out) + ", title=" + title + ", __equalsCalc="
				+ __equalsCalc + ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
