/**
 * Job_delete_responseJob.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Job_delete_responseJob  extends Think.XmlWebServices.ZZJob  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean _deleted;  // attribute

    private java.lang.String failureReason;  // attribute

    public Job_delete_responseJob() {
    }

    public Job_delete_responseJob(
           int job_id,
           int adj_order_issue_method,
           java.util.Date audit_galley_doc_ref_date,
           java.lang.String audit_galley_sort_def,
           int auto_renewals,
           int back_issues_on_reinstated,
           int bacs_step,
           int cleanedup,
           java.lang.String cleanup_def,
           int create_audit_galley,
           java.util.Calendar creation_date,
           java.util.Date cutoff_date,
           java.lang.String description,
           java.util.Date drop_date,
           java.util.Calendar end_job_datetime,
           int end_select_date_stamp,
           int force_repeat,
           int generate_renew_offers,
           int grace_current,
           int grace_new,
           int has_errors,
           int hold_bits,
           int incl_pkg_members,
           int interval_unit,
           int inv_serve_label,
           java.lang.String job_completion_email_address,
           java.lang.String job_description,
           int job_priority,
           java.lang.String label_group,
           java.lang.String label_keyline,
           java.util.Calendar last_pulse,
           java.lang.String list_company,
           int log_option,
           int manual_review_fulfillment,
           int n_candidate_records,
           int n_days_to_next_run,
           int n_interval_units,
           int n_minutes_to_next_run,
           int n_selected_records,
           int n_updated_records,
           java.lang.String note,
           int nth_audit_galley,
           java.lang.String nth_def,
           int output_step,
           int pending_xaction_header_id,
           int process_id,
           java.lang.String purpose,
           java.lang.String queue,
           int repeating_type,
           int run_payment_after_bill,
           java.util.Date schedule_payment_date,
           java.util.Date select_end_date,
           java.util.Date select_start_date,
           int sort_audit_galley,
           java.lang.String sql_script,
           java.util.Calendar start_date_time,
           int status,
           java.lang.String step_name,
           int step_number,
           int upd_recon_tables,
           java.lang.String user_code,
           int volume_group_id,
           java.lang.String work_file,
           int write_recon_dtl,
           Think.XmlWebServices.ZZBoolean _deleted,
           java.lang.String failureReason) {
        super(
            job_id,
            adj_order_issue_method,
            audit_galley_doc_ref_date,
            audit_galley_sort_def,
            auto_renewals,
            back_issues_on_reinstated,
            bacs_step,
            cleanedup,
            cleanup_def,
            create_audit_galley,
            creation_date,
            cutoff_date,
            description,
            drop_date,
            end_job_datetime,
            end_select_date_stamp,
            force_repeat,
            generate_renew_offers,
            grace_current,
            grace_new,
            has_errors,
            hold_bits,
            incl_pkg_members,
            interval_unit,
            inv_serve_label,
            job_completion_email_address,
            job_description,
            job_priority,
            label_group,
            label_keyline,
            last_pulse,
            list_company,
            log_option,
            manual_review_fulfillment,
            n_candidate_records,
            n_days_to_next_run,
            n_interval_units,
            n_minutes_to_next_run,
            n_selected_records,
            n_updated_records,
            note,
            nth_audit_galley,
            nth_def,
            output_step,
            pending_xaction_header_id,
            process_id,
            purpose,
            queue,
            repeating_type,
            run_payment_after_bill,
            schedule_payment_date,
            select_end_date,
            select_start_date,
            sort_audit_galley,
            sql_script,
            start_date_time,
            status,
            step_name,
            step_number,
            upd_recon_tables,
            user_code,
            volume_group_id,
            work_file,
            write_recon_dtl);
        this._deleted = _deleted;
        this.failureReason = failureReason;
    }


    /**
     * Gets the _deleted value for this Job_delete_responseJob.
     * 
     * @return _deleted
     */
    public Think.XmlWebServices.ZZBoolean get_deleted() {
        return _deleted;
    }


    /**
     * Sets the _deleted value for this Job_delete_responseJob.
     * 
     * @param _deleted
     */
    public void set_deleted(Think.XmlWebServices.ZZBoolean _deleted) {
        this._deleted = _deleted;
    }


    /**
     * Gets the failureReason value for this Job_delete_responseJob.
     * 
     * @return failureReason
     */
    public java.lang.String getFailureReason() {
        return failureReason;
    }


    /**
     * Sets the failureReason value for this Job_delete_responseJob.
     * 
     * @param failureReason
     */
    public void setFailureReason(java.lang.String failureReason) {
        this.failureReason = failureReason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Job_delete_responseJob)) return false;
        Job_delete_responseJob other = (Job_delete_responseJob) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this._deleted==null && other.get_deleted()==null) || 
             (this._deleted!=null &&
              this._deleted.equals(other.get_deleted()))) &&
            ((this.failureReason==null && other.getFailureReason()==null) || 
             (this.failureReason!=null &&
              this.failureReason.equals(other.getFailureReason())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (get_deleted() != null) {
            _hashCode += get_deleted().hashCode();
        }
        if (getFailureReason() != null) {
            _hashCode += getFailureReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Job_delete_responseJob.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>job_delete_response>job"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_deleted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "_deleted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("failureReason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "failureReason"));
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
