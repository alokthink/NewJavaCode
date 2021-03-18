/**
 * Suspension_list_select_responseSuspension.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Suspension_list_select_responseSuspension  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int order_item_seq;  // attribute

    private int suspension_seq;  // attribute

    private int subscrip_id;  // attribute

    private java.lang.String user_code;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int suspension_status;  // attribute

    private int old_order_status;  // attribute

    private int suspended_order_status;  // attribute

    private java.util.Date suspend_from_date;  // attribute

    private java.util.Date suspend_to_date;  // attribute

    private int begin_issue_id;  // attribute

    private int end_issue_id;  // attribute

    private int serve_backlabels;  // attribute

    private int n_backlabels;  // attribute

    private int rollback_suspension_status;  // attribute

    private java.util.Date rollback_suspend_from_date;  // attribute

    private java.util.Date rollback_suspend_to_date;  // attribute

    private int rollback_begin_issue_id;  // attribute

    private int rollback_end_issue_id;  // attribute

    private int rollback_serve_backlabels;  // attribute

    private int rollback_n_backlabels;  // attribute

    private int rollback_old_order_status;  // attribute

    private int rollback_job_id;  // attribute

    public Suspension_list_select_responseSuspension() {
    }

    public Suspension_list_select_responseSuspension(
           int orderhdr_id,
           int order_item_seq,
           int suspension_seq,
           int subscrip_id,
           java.lang.String user_code,
           java.util.Calendar creation_date,
           int suspension_status,
           int old_order_status,
           int suspended_order_status,
           java.util.Date suspend_from_date,
           java.util.Date suspend_to_date,
           int begin_issue_id,
           int end_issue_id,
           int serve_backlabels,
           int n_backlabels,
           int rollback_suspension_status,
           java.util.Date rollback_suspend_from_date,
           java.util.Date rollback_suspend_to_date,
           int rollback_begin_issue_id,
           int rollback_end_issue_id,
           int rollback_serve_backlabels,
           int rollback_n_backlabels,
           int rollback_old_order_status,
           int rollback_job_id) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.suspension_seq = suspension_seq;
           this.subscrip_id = subscrip_id;
           this.user_code = user_code;
           this.creation_date = creation_date;
           this.suspension_status = suspension_status;
           this.old_order_status = old_order_status;
           this.suspended_order_status = suspended_order_status;
           this.suspend_from_date = suspend_from_date;
           this.suspend_to_date = suspend_to_date;
           this.begin_issue_id = begin_issue_id;
           this.end_issue_id = end_issue_id;
           this.serve_backlabels = serve_backlabels;
           this.n_backlabels = n_backlabels;
           this.rollback_suspension_status = rollback_suspension_status;
           this.rollback_suspend_from_date = rollback_suspend_from_date;
           this.rollback_suspend_to_date = rollback_suspend_to_date;
           this.rollback_begin_issue_id = rollback_begin_issue_id;
           this.rollback_end_issue_id = rollback_end_issue_id;
           this.rollback_serve_backlabels = rollback_serve_backlabels;
           this.rollback_n_backlabels = rollback_n_backlabels;
           this.rollback_old_order_status = rollback_old_order_status;
           this.rollback_job_id = rollback_job_id;
    }


    /**
     * Gets the orderhdr_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this Suspension_list_select_responseSuspension.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Suspension_list_select_responseSuspension.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the suspension_seq value for this Suspension_list_select_responseSuspension.
     * 
     * @return suspension_seq
     */
    public int getSuspension_seq() {
        return suspension_seq;
    }


    /**
     * Sets the suspension_seq value for this Suspension_list_select_responseSuspension.
     * 
     * @param suspension_seq
     */
    public void setSuspension_seq(int suspension_seq) {
        this.suspension_seq = suspension_seq;
    }


    /**
     * Gets the subscrip_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the user_code value for this Suspension_list_select_responseSuspension.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Suspension_list_select_responseSuspension.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the creation_date value for this Suspension_list_select_responseSuspension.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Suspension_list_select_responseSuspension.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the suspension_status value for this Suspension_list_select_responseSuspension.
     * 
     * @return suspension_status
     */
    public int getSuspension_status() {
        return suspension_status;
    }


    /**
     * Sets the suspension_status value for this Suspension_list_select_responseSuspension.
     * 
     * @param suspension_status
     */
    public void setSuspension_status(int suspension_status) {
        this.suspension_status = suspension_status;
    }


    /**
     * Gets the old_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @return old_order_status
     */
    public int getOld_order_status() {
        return old_order_status;
    }


    /**
     * Sets the old_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @param old_order_status
     */
    public void setOld_order_status(int old_order_status) {
        this.old_order_status = old_order_status;
    }


    /**
     * Gets the suspended_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @return suspended_order_status
     */
    public int getSuspended_order_status() {
        return suspended_order_status;
    }


    /**
     * Sets the suspended_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @param suspended_order_status
     */
    public void setSuspended_order_status(int suspended_order_status) {
        this.suspended_order_status = suspended_order_status;
    }


    /**
     * Gets the suspend_from_date value for this Suspension_list_select_responseSuspension.
     * 
     * @return suspend_from_date
     */
    public java.util.Date getSuspend_from_date() {
        return suspend_from_date;
    }


    /**
     * Sets the suspend_from_date value for this Suspension_list_select_responseSuspension.
     * 
     * @param suspend_from_date
     */
    public void setSuspend_from_date(java.util.Date suspend_from_date) {
        this.suspend_from_date = suspend_from_date;
    }


    /**
     * Gets the suspend_to_date value for this Suspension_list_select_responseSuspension.
     * 
     * @return suspend_to_date
     */
    public java.util.Date getSuspend_to_date() {
        return suspend_to_date;
    }


    /**
     * Sets the suspend_to_date value for this Suspension_list_select_responseSuspension.
     * 
     * @param suspend_to_date
     */
    public void setSuspend_to_date(java.util.Date suspend_to_date) {
        this.suspend_to_date = suspend_to_date;
    }


    /**
     * Gets the begin_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return begin_issue_id
     */
    public int getBegin_issue_id() {
        return begin_issue_id;
    }


    /**
     * Sets the begin_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param begin_issue_id
     */
    public void setBegin_issue_id(int begin_issue_id) {
        this.begin_issue_id = begin_issue_id;
    }


    /**
     * Gets the end_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return end_issue_id
     */
    public int getEnd_issue_id() {
        return end_issue_id;
    }


    /**
     * Sets the end_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param end_issue_id
     */
    public void setEnd_issue_id(int end_issue_id) {
        this.end_issue_id = end_issue_id;
    }


    /**
     * Gets the serve_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @return serve_backlabels
     */
    public int getServe_backlabels() {
        return serve_backlabels;
    }


    /**
     * Sets the serve_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @param serve_backlabels
     */
    public void setServe_backlabels(int serve_backlabels) {
        this.serve_backlabels = serve_backlabels;
    }


    /**
     * Gets the n_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @return n_backlabels
     */
    public int getN_backlabels() {
        return n_backlabels;
    }


    /**
     * Sets the n_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @param n_backlabels
     */
    public void setN_backlabels(int n_backlabels) {
        this.n_backlabels = n_backlabels;
    }


    /**
     * Gets the rollback_suspension_status value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_suspension_status
     */
    public int getRollback_suspension_status() {
        return rollback_suspension_status;
    }


    /**
     * Sets the rollback_suspension_status value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_suspension_status
     */
    public void setRollback_suspension_status(int rollback_suspension_status) {
        this.rollback_suspension_status = rollback_suspension_status;
    }


    /**
     * Gets the rollback_suspend_from_date value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_suspend_from_date
     */
    public java.util.Date getRollback_suspend_from_date() {
        return rollback_suspend_from_date;
    }


    /**
     * Sets the rollback_suspend_from_date value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_suspend_from_date
     */
    public void setRollback_suspend_from_date(java.util.Date rollback_suspend_from_date) {
        this.rollback_suspend_from_date = rollback_suspend_from_date;
    }


    /**
     * Gets the rollback_suspend_to_date value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_suspend_to_date
     */
    public java.util.Date getRollback_suspend_to_date() {
        return rollback_suspend_to_date;
    }


    /**
     * Sets the rollback_suspend_to_date value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_suspend_to_date
     */
    public void setRollback_suspend_to_date(java.util.Date rollback_suspend_to_date) {
        this.rollback_suspend_to_date = rollback_suspend_to_date;
    }


    /**
     * Gets the rollback_begin_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_begin_issue_id
     */
    public int getRollback_begin_issue_id() {
        return rollback_begin_issue_id;
    }


    /**
     * Sets the rollback_begin_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_begin_issue_id
     */
    public void setRollback_begin_issue_id(int rollback_begin_issue_id) {
        this.rollback_begin_issue_id = rollback_begin_issue_id;
    }


    /**
     * Gets the rollback_end_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_end_issue_id
     */
    public int getRollback_end_issue_id() {
        return rollback_end_issue_id;
    }


    /**
     * Sets the rollback_end_issue_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_end_issue_id
     */
    public void setRollback_end_issue_id(int rollback_end_issue_id) {
        this.rollback_end_issue_id = rollback_end_issue_id;
    }


    /**
     * Gets the rollback_serve_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_serve_backlabels
     */
    public int getRollback_serve_backlabels() {
        return rollback_serve_backlabels;
    }


    /**
     * Sets the rollback_serve_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_serve_backlabels
     */
    public void setRollback_serve_backlabels(int rollback_serve_backlabels) {
        this.rollback_serve_backlabels = rollback_serve_backlabels;
    }


    /**
     * Gets the rollback_n_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_n_backlabels
     */
    public int getRollback_n_backlabels() {
        return rollback_n_backlabels;
    }


    /**
     * Sets the rollback_n_backlabels value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_n_backlabels
     */
    public void setRollback_n_backlabels(int rollback_n_backlabels) {
        this.rollback_n_backlabels = rollback_n_backlabels;
    }


    /**
     * Gets the rollback_old_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_old_order_status
     */
    public int getRollback_old_order_status() {
        return rollback_old_order_status;
    }


    /**
     * Sets the rollback_old_order_status value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_old_order_status
     */
    public void setRollback_old_order_status(int rollback_old_order_status) {
        this.rollback_old_order_status = rollback_old_order_status;
    }


    /**
     * Gets the rollback_job_id value for this Suspension_list_select_responseSuspension.
     * 
     * @return rollback_job_id
     */
    public int getRollback_job_id() {
        return rollback_job_id;
    }


    /**
     * Sets the rollback_job_id value for this Suspension_list_select_responseSuspension.
     * 
     * @param rollback_job_id
     */
    public void setRollback_job_id(int rollback_job_id) {
        this.rollback_job_id = rollback_job_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suspension_list_select_responseSuspension)) return false;
        Suspension_list_select_responseSuspension other = (Suspension_list_select_responseSuspension) obj;
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
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.suspension_status == other.getSuspension_status() &&
            this.old_order_status == other.getOld_order_status() &&
            this.suspended_order_status == other.getSuspended_order_status() &&
            ((this.suspend_from_date==null && other.getSuspend_from_date()==null) || 
             (this.suspend_from_date!=null &&
              this.suspend_from_date.equals(other.getSuspend_from_date()))) &&
            ((this.suspend_to_date==null && other.getSuspend_to_date()==null) || 
             (this.suspend_to_date!=null &&
              this.suspend_to_date.equals(other.getSuspend_to_date()))) &&
            this.begin_issue_id == other.getBegin_issue_id() &&
            this.end_issue_id == other.getEnd_issue_id() &&
            this.serve_backlabels == other.getServe_backlabels() &&
            this.n_backlabels == other.getN_backlabels() &&
            this.rollback_suspension_status == other.getRollback_suspension_status() &&
            ((this.rollback_suspend_from_date==null && other.getRollback_suspend_from_date()==null) || 
             (this.rollback_suspend_from_date!=null &&
              this.rollback_suspend_from_date.equals(other.getRollback_suspend_from_date()))) &&
            ((this.rollback_suspend_to_date==null && other.getRollback_suspend_to_date()==null) || 
             (this.rollback_suspend_to_date!=null &&
              this.rollback_suspend_to_date.equals(other.getRollback_suspend_to_date()))) &&
            this.rollback_begin_issue_id == other.getRollback_begin_issue_id() &&
            this.rollback_end_issue_id == other.getRollback_end_issue_id() &&
            this.rollback_serve_backlabels == other.getRollback_serve_backlabels() &&
            this.rollback_n_backlabels == other.getRollback_n_backlabels() &&
            this.rollback_old_order_status == other.getRollback_old_order_status() &&
            this.rollback_job_id == other.getRollback_job_id();
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
        _hashCode += getSubscrip_id();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getSuspension_status();
        _hashCode += getOld_order_status();
        _hashCode += getSuspended_order_status();
        if (getSuspend_from_date() != null) {
            _hashCode += getSuspend_from_date().hashCode();
        }
        if (getSuspend_to_date() != null) {
            _hashCode += getSuspend_to_date().hashCode();
        }
        _hashCode += getBegin_issue_id();
        _hashCode += getEnd_issue_id();
        _hashCode += getServe_backlabels();
        _hashCode += getN_backlabels();
        _hashCode += getRollback_suspension_status();
        if (getRollback_suspend_from_date() != null) {
            _hashCode += getRollback_suspend_from_date().hashCode();
        }
        if (getRollback_suspend_to_date() != null) {
            _hashCode += getRollback_suspend_to_date().hashCode();
        }
        _hashCode += getRollback_begin_issue_id();
        _hashCode += getRollback_end_issue_id();
        _hashCode += getRollback_serve_backlabels();
        _hashCode += getRollback_n_backlabels();
        _hashCode += getRollback_old_order_status();
        _hashCode += getRollback_job_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suspension_list_select_responseSuspension.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>suspension_list_select_response>suspension"));
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
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
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
        attrField.setFieldName("suspension_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("old_order_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "old_order_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspended_order_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspended_order_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspend_from_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspend_from_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspend_to_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspend_to_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("begin_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "begin_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("end_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "end_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("serve_backlabels");
        attrField.setXmlName(new javax.xml.namespace.QName("", "serve_backlabels"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_backlabels");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_backlabels"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_suspension_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_suspension_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_suspend_from_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_suspend_from_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_suspend_to_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_suspend_to_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_begin_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_begin_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_end_issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_end_issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_serve_backlabels");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_serve_backlabels"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_n_backlabels");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_n_backlabels"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_old_order_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_old_order_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_job_id"));
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
