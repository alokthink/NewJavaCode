/**
 * Job_select_responseJob.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Job_select_responseJob  implements java.io.Serializable {
    private int job_id;  // attribute

    private java.lang.String label_keyline;  // attribute

    private java.lang.String label_group;  // attribute

    private int process_id;  // attribute

    private java.util.Date cutoff_date;  // attribute

    private java.util.Date drop_date;  // attribute

    private java.lang.String note;  // attribute

    private java.lang.String nth_def;  // attribute

    private java.lang.String list_company;  // attribute

    private java.lang.String purpose;  // attribute

    private int n_candidate_records;  // attribute

    private int n_selected_records;  // attribute

    private java.util.Calendar start_date_time;  // attribute

    private int n_days_to_next_run;  // attribute

    private int n_updated_records;  // attribute

    private java.lang.String description;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int grace_new;  // attribute

    private int grace_current;  // attribute

    private int pending_xaction_header_id;  // attribute

    private int job_priority;  // attribute

    private java.lang.String job_description;  // attribute

    private int end_select_date_stamp;  // attribute

    private int create_audit_galley;  // attribute

    private int sort_audit_galley;  // attribute

    private int nth_audit_galley;  // attribute

    private java.util.Date audit_galley_doc_ref_date;  // attribute

    private java.lang.String queue;  // attribute

    private int force_repeat;  // attribute

    private int auto_renewals;  // attribute

    private java.util.Date schedule_payment_date;  // attribute

    private int volume_group_id;  // attribute

    private java.lang.String sql_script;  // attribute

    private java.lang.String work_file;  // attribute

    private java.util.Date select_start_date;  // attribute

    private java.util.Date select_end_date;  // attribute

    private int inv_serve_label;  // attribute

    private java.lang.String cleanup_def;  // attribute

    private java.lang.String audit_galley_sort_def;  // attribute

    private int output_step;  // attribute

    private int has_errors;  // attribute

    private java.util.Calendar end_job_datetime;  // attribute

    private int n_minutes_to_next_run;  // attribute

    private java.lang.String user_code;  // attribute

    private int write_recon_dtl;  // attribute

    private int cleanedup;  // attribute

    private int adj_order_issue_method;  // attribute

    private int upd_recon_tables;  // attribute

    private int repeating_type;  // attribute

    private int interval_unit;  // attribute

    private int n_interval_units;  // attribute

    private java.lang.String job_completion_email_address;  // attribute

    private int log_option;  // attribute

    private int run_payment_after_bill;  // attribute

    private int bacs_step;  // attribute

    private int back_issues_on_reinstated;  // attribute

    private int manual_review_fulfillment;  // attribute

    private int status;  // attribute

    private int step_number;  // attribute

    private java.lang.String step_name;  // attribute

    private int hold_bits;  // attribute

    private int generate_renew_offers;  // attribute

    private java.util.Calendar last_pulse;  // attribute

    private int incl_pkg_members;  // attribute

    private java.lang.String process_description;  // attribute

    public Job_select_responseJob() {
    }

    public Job_select_responseJob(
           int job_id,
           java.lang.String label_keyline,
           java.lang.String label_group,
           int process_id,
           java.util.Date cutoff_date,
           java.util.Date drop_date,
           java.lang.String note,
           java.lang.String nth_def,
           java.lang.String list_company,
           java.lang.String purpose,
           int n_candidate_records,
           int n_selected_records,
           java.util.Calendar start_date_time,
           int n_days_to_next_run,
           int n_updated_records,
           java.lang.String description,
           java.util.Calendar creation_date,
           int grace_new,
           int grace_current,
           int pending_xaction_header_id,
           int job_priority,
           java.lang.String job_description,
           int end_select_date_stamp,
           int create_audit_galley,
           int sort_audit_galley,
           int nth_audit_galley,
           java.util.Date audit_galley_doc_ref_date,
           java.lang.String queue,
           int force_repeat,
           int auto_renewals,
           java.util.Date schedule_payment_date,
           int volume_group_id,
           java.lang.String sql_script,
           java.lang.String work_file,
           java.util.Date select_start_date,
           java.util.Date select_end_date,
           int inv_serve_label,
           java.lang.String cleanup_def,
           java.lang.String audit_galley_sort_def,
           int output_step,
           int has_errors,
           java.util.Calendar end_job_datetime,
           int n_minutes_to_next_run,
           java.lang.String user_code,
           int write_recon_dtl,
           int cleanedup,
           int adj_order_issue_method,
           int upd_recon_tables,
           int repeating_type,
           int interval_unit,
           int n_interval_units,
           java.lang.String job_completion_email_address,
           int log_option,
           int run_payment_after_bill,
           int bacs_step,
           int back_issues_on_reinstated,
           int manual_review_fulfillment,
           int status,
           int step_number,
           java.lang.String step_name,
           int hold_bits,
           int generate_renew_offers,
           java.util.Calendar last_pulse,
           int incl_pkg_members,
           java.lang.String process_description) {
           this.job_id = job_id;
           this.label_keyline = label_keyline;
           this.label_group = label_group;
           this.process_id = process_id;
           this.cutoff_date = cutoff_date;
           this.drop_date = drop_date;
           this.note = note;
           this.nth_def = nth_def;
           this.list_company = list_company;
           this.purpose = purpose;
           this.n_candidate_records = n_candidate_records;
           this.n_selected_records = n_selected_records;
           this.start_date_time = start_date_time;
           this.n_days_to_next_run = n_days_to_next_run;
           this.n_updated_records = n_updated_records;
           this.description = description;
           this.creation_date = creation_date;
           this.grace_new = grace_new;
           this.grace_current = grace_current;
           this.pending_xaction_header_id = pending_xaction_header_id;
           this.job_priority = job_priority;
           this.job_description = job_description;
           this.end_select_date_stamp = end_select_date_stamp;
           this.create_audit_galley = create_audit_galley;
           this.sort_audit_galley = sort_audit_galley;
           this.nth_audit_galley = nth_audit_galley;
           this.audit_galley_doc_ref_date = audit_galley_doc_ref_date;
           this.queue = queue;
           this.force_repeat = force_repeat;
           this.auto_renewals = auto_renewals;
           this.schedule_payment_date = schedule_payment_date;
           this.volume_group_id = volume_group_id;
           this.sql_script = sql_script;
           this.work_file = work_file;
           this.select_start_date = select_start_date;
           this.select_end_date = select_end_date;
           this.inv_serve_label = inv_serve_label;
           this.cleanup_def = cleanup_def;
           this.audit_galley_sort_def = audit_galley_sort_def;
           this.output_step = output_step;
           this.has_errors = has_errors;
           this.end_job_datetime = end_job_datetime;
           this.n_minutes_to_next_run = n_minutes_to_next_run;
           this.user_code = user_code;
           this.write_recon_dtl = write_recon_dtl;
           this.cleanedup = cleanedup;
           this.adj_order_issue_method = adj_order_issue_method;
           this.upd_recon_tables = upd_recon_tables;
           this.repeating_type = repeating_type;
           this.interval_unit = interval_unit;
           this.n_interval_units = n_interval_units;
           this.job_completion_email_address = job_completion_email_address;
           this.log_option = log_option;
           this.run_payment_after_bill = run_payment_after_bill;
           this.bacs_step = bacs_step;
           this.back_issues_on_reinstated = back_issues_on_reinstated;
           this.manual_review_fulfillment = manual_review_fulfillment;
           this.status = status;
           this.step_number = step_number;
           this.step_name = step_name;
           this.hold_bits = hold_bits;
           this.generate_renew_offers = generate_renew_offers;
           this.last_pulse = last_pulse;
           this.incl_pkg_members = incl_pkg_members;
           this.process_description = process_description;
    }


    /**
     * Gets the job_id value for this Job_select_responseJob.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this Job_select_responseJob.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the label_keyline value for this Job_select_responseJob.
     * 
     * @return label_keyline
     */
    public java.lang.String getLabel_keyline() {
        return label_keyline;
    }


    /**
     * Sets the label_keyline value for this Job_select_responseJob.
     * 
     * @param label_keyline
     */
    public void setLabel_keyline(java.lang.String label_keyline) {
        this.label_keyline = label_keyline;
    }


    /**
     * Gets the label_group value for this Job_select_responseJob.
     * 
     * @return label_group
     */
    public java.lang.String getLabel_group() {
        return label_group;
    }


    /**
     * Sets the label_group value for this Job_select_responseJob.
     * 
     * @param label_group
     */
    public void setLabel_group(java.lang.String label_group) {
        this.label_group = label_group;
    }


    /**
     * Gets the process_id value for this Job_select_responseJob.
     * 
     * @return process_id
     */
    public int getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this Job_select_responseJob.
     * 
     * @param process_id
     */
    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the cutoff_date value for this Job_select_responseJob.
     * 
     * @return cutoff_date
     */
    public java.util.Date getCutoff_date() {
        return cutoff_date;
    }


    /**
     * Sets the cutoff_date value for this Job_select_responseJob.
     * 
     * @param cutoff_date
     */
    public void setCutoff_date(java.util.Date cutoff_date) {
        this.cutoff_date = cutoff_date;
    }


    /**
     * Gets the drop_date value for this Job_select_responseJob.
     * 
     * @return drop_date
     */
    public java.util.Date getDrop_date() {
        return drop_date;
    }


    /**
     * Sets the drop_date value for this Job_select_responseJob.
     * 
     * @param drop_date
     */
    public void setDrop_date(java.util.Date drop_date) {
        this.drop_date = drop_date;
    }


    /**
     * Gets the note value for this Job_select_responseJob.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this Job_select_responseJob.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the nth_def value for this Job_select_responseJob.
     * 
     * @return nth_def
     */
    public java.lang.String getNth_def() {
        return nth_def;
    }


    /**
     * Sets the nth_def value for this Job_select_responseJob.
     * 
     * @param nth_def
     */
    public void setNth_def(java.lang.String nth_def) {
        this.nth_def = nth_def;
    }


    /**
     * Gets the list_company value for this Job_select_responseJob.
     * 
     * @return list_company
     */
    public java.lang.String getList_company() {
        return list_company;
    }


    /**
     * Sets the list_company value for this Job_select_responseJob.
     * 
     * @param list_company
     */
    public void setList_company(java.lang.String list_company) {
        this.list_company = list_company;
    }


    /**
     * Gets the purpose value for this Job_select_responseJob.
     * 
     * @return purpose
     */
    public java.lang.String getPurpose() {
        return purpose;
    }


    /**
     * Sets the purpose value for this Job_select_responseJob.
     * 
     * @param purpose
     */
    public void setPurpose(java.lang.String purpose) {
        this.purpose = purpose;
    }


    /**
     * Gets the n_candidate_records value for this Job_select_responseJob.
     * 
     * @return n_candidate_records
     */
    public int getN_candidate_records() {
        return n_candidate_records;
    }


    /**
     * Sets the n_candidate_records value for this Job_select_responseJob.
     * 
     * @param n_candidate_records
     */
    public void setN_candidate_records(int n_candidate_records) {
        this.n_candidate_records = n_candidate_records;
    }


    /**
     * Gets the n_selected_records value for this Job_select_responseJob.
     * 
     * @return n_selected_records
     */
    public int getN_selected_records() {
        return n_selected_records;
    }


    /**
     * Sets the n_selected_records value for this Job_select_responseJob.
     * 
     * @param n_selected_records
     */
    public void setN_selected_records(int n_selected_records) {
        this.n_selected_records = n_selected_records;
    }


    /**
     * Gets the start_date_time value for this Job_select_responseJob.
     * 
     * @return start_date_time
     */
    public java.util.Calendar getStart_date_time() {
        return start_date_time;
    }


    /**
     * Sets the start_date_time value for this Job_select_responseJob.
     * 
     * @param start_date_time
     */
    public void setStart_date_time(java.util.Calendar start_date_time) {
        this.start_date_time = start_date_time;
    }


    /**
     * Gets the n_days_to_next_run value for this Job_select_responseJob.
     * 
     * @return n_days_to_next_run
     */
    public int getN_days_to_next_run() {
        return n_days_to_next_run;
    }


    /**
     * Sets the n_days_to_next_run value for this Job_select_responseJob.
     * 
     * @param n_days_to_next_run
     */
    public void setN_days_to_next_run(int n_days_to_next_run) {
        this.n_days_to_next_run = n_days_to_next_run;
    }


    /**
     * Gets the n_updated_records value for this Job_select_responseJob.
     * 
     * @return n_updated_records
     */
    public int getN_updated_records() {
        return n_updated_records;
    }


    /**
     * Sets the n_updated_records value for this Job_select_responseJob.
     * 
     * @param n_updated_records
     */
    public void setN_updated_records(int n_updated_records) {
        this.n_updated_records = n_updated_records;
    }


    /**
     * Gets the description value for this Job_select_responseJob.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Job_select_responseJob.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the creation_date value for this Job_select_responseJob.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this Job_select_responseJob.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the grace_new value for this Job_select_responseJob.
     * 
     * @return grace_new
     */
    public int getGrace_new() {
        return grace_new;
    }


    /**
     * Sets the grace_new value for this Job_select_responseJob.
     * 
     * @param grace_new
     */
    public void setGrace_new(int grace_new) {
        this.grace_new = grace_new;
    }


    /**
     * Gets the grace_current value for this Job_select_responseJob.
     * 
     * @return grace_current
     */
    public int getGrace_current() {
        return grace_current;
    }


    /**
     * Sets the grace_current value for this Job_select_responseJob.
     * 
     * @param grace_current
     */
    public void setGrace_current(int grace_current) {
        this.grace_current = grace_current;
    }


    /**
     * Gets the pending_xaction_header_id value for this Job_select_responseJob.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this Job_select_responseJob.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the job_priority value for this Job_select_responseJob.
     * 
     * @return job_priority
     */
    public int getJob_priority() {
        return job_priority;
    }


    /**
     * Sets the job_priority value for this Job_select_responseJob.
     * 
     * @param job_priority
     */
    public void setJob_priority(int job_priority) {
        this.job_priority = job_priority;
    }


    /**
     * Gets the job_description value for this Job_select_responseJob.
     * 
     * @return job_description
     */
    public java.lang.String getJob_description() {
        return job_description;
    }


    /**
     * Sets the job_description value for this Job_select_responseJob.
     * 
     * @param job_description
     */
    public void setJob_description(java.lang.String job_description) {
        this.job_description = job_description;
    }


    /**
     * Gets the end_select_date_stamp value for this Job_select_responseJob.
     * 
     * @return end_select_date_stamp
     */
    public int getEnd_select_date_stamp() {
        return end_select_date_stamp;
    }


    /**
     * Sets the end_select_date_stamp value for this Job_select_responseJob.
     * 
     * @param end_select_date_stamp
     */
    public void setEnd_select_date_stamp(int end_select_date_stamp) {
        this.end_select_date_stamp = end_select_date_stamp;
    }


    /**
     * Gets the create_audit_galley value for this Job_select_responseJob.
     * 
     * @return create_audit_galley
     */
    public int getCreate_audit_galley() {
        return create_audit_galley;
    }


    /**
     * Sets the create_audit_galley value for this Job_select_responseJob.
     * 
     * @param create_audit_galley
     */
    public void setCreate_audit_galley(int create_audit_galley) {
        this.create_audit_galley = create_audit_galley;
    }


    /**
     * Gets the sort_audit_galley value for this Job_select_responseJob.
     * 
     * @return sort_audit_galley
     */
    public int getSort_audit_galley() {
        return sort_audit_galley;
    }


    /**
     * Sets the sort_audit_galley value for this Job_select_responseJob.
     * 
     * @param sort_audit_galley
     */
    public void setSort_audit_galley(int sort_audit_galley) {
        this.sort_audit_galley = sort_audit_galley;
    }


    /**
     * Gets the nth_audit_galley value for this Job_select_responseJob.
     * 
     * @return nth_audit_galley
     */
    public int getNth_audit_galley() {
        return nth_audit_galley;
    }


    /**
     * Sets the nth_audit_galley value for this Job_select_responseJob.
     * 
     * @param nth_audit_galley
     */
    public void setNth_audit_galley(int nth_audit_galley) {
        this.nth_audit_galley = nth_audit_galley;
    }


    /**
     * Gets the audit_galley_doc_ref_date value for this Job_select_responseJob.
     * 
     * @return audit_galley_doc_ref_date
     */
    public java.util.Date getAudit_galley_doc_ref_date() {
        return audit_galley_doc_ref_date;
    }


    /**
     * Sets the audit_galley_doc_ref_date value for this Job_select_responseJob.
     * 
     * @param audit_galley_doc_ref_date
     */
    public void setAudit_galley_doc_ref_date(java.util.Date audit_galley_doc_ref_date) {
        this.audit_galley_doc_ref_date = audit_galley_doc_ref_date;
    }


    /**
     * Gets the queue value for this Job_select_responseJob.
     * 
     * @return queue
     */
    public java.lang.String getQueue() {
        return queue;
    }


    /**
     * Sets the queue value for this Job_select_responseJob.
     * 
     * @param queue
     */
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }


    /**
     * Gets the force_repeat value for this Job_select_responseJob.
     * 
     * @return force_repeat
     */
    public int getForce_repeat() {
        return force_repeat;
    }


    /**
     * Sets the force_repeat value for this Job_select_responseJob.
     * 
     * @param force_repeat
     */
    public void setForce_repeat(int force_repeat) {
        this.force_repeat = force_repeat;
    }


    /**
     * Gets the auto_renewals value for this Job_select_responseJob.
     * 
     * @return auto_renewals
     */
    public int getAuto_renewals() {
        return auto_renewals;
    }


    /**
     * Sets the auto_renewals value for this Job_select_responseJob.
     * 
     * @param auto_renewals
     */
    public void setAuto_renewals(int auto_renewals) {
        this.auto_renewals = auto_renewals;
    }


    /**
     * Gets the schedule_payment_date value for this Job_select_responseJob.
     * 
     * @return schedule_payment_date
     */
    public java.util.Date getSchedule_payment_date() {
        return schedule_payment_date;
    }


    /**
     * Sets the schedule_payment_date value for this Job_select_responseJob.
     * 
     * @param schedule_payment_date
     */
    public void setSchedule_payment_date(java.util.Date schedule_payment_date) {
        this.schedule_payment_date = schedule_payment_date;
    }


    /**
     * Gets the volume_group_id value for this Job_select_responseJob.
     * 
     * @return volume_group_id
     */
    public int getVolume_group_id() {
        return volume_group_id;
    }


    /**
     * Sets the volume_group_id value for this Job_select_responseJob.
     * 
     * @param volume_group_id
     */
    public void setVolume_group_id(int volume_group_id) {
        this.volume_group_id = volume_group_id;
    }


    /**
     * Gets the sql_script value for this Job_select_responseJob.
     * 
     * @return sql_script
     */
    public java.lang.String getSql_script() {
        return sql_script;
    }


    /**
     * Sets the sql_script value for this Job_select_responseJob.
     * 
     * @param sql_script
     */
    public void setSql_script(java.lang.String sql_script) {
        this.sql_script = sql_script;
    }


    /**
     * Gets the work_file value for this Job_select_responseJob.
     * 
     * @return work_file
     */
    public java.lang.String getWork_file() {
        return work_file;
    }


    /**
     * Sets the work_file value for this Job_select_responseJob.
     * 
     * @param work_file
     */
    public void setWork_file(java.lang.String work_file) {
        this.work_file = work_file;
    }


    /**
     * Gets the select_start_date value for this Job_select_responseJob.
     * 
     * @return select_start_date
     */
    public java.util.Date getSelect_start_date() {
        return select_start_date;
    }


    /**
     * Sets the select_start_date value for this Job_select_responseJob.
     * 
     * @param select_start_date
     */
    public void setSelect_start_date(java.util.Date select_start_date) {
        this.select_start_date = select_start_date;
    }


    /**
     * Gets the select_end_date value for this Job_select_responseJob.
     * 
     * @return select_end_date
     */
    public java.util.Date getSelect_end_date() {
        return select_end_date;
    }


    /**
     * Sets the select_end_date value for this Job_select_responseJob.
     * 
     * @param select_end_date
     */
    public void setSelect_end_date(java.util.Date select_end_date) {
        this.select_end_date = select_end_date;
    }


    /**
     * Gets the inv_serve_label value for this Job_select_responseJob.
     * 
     * @return inv_serve_label
     */
    public int getInv_serve_label() {
        return inv_serve_label;
    }


    /**
     * Sets the inv_serve_label value for this Job_select_responseJob.
     * 
     * @param inv_serve_label
     */
    public void setInv_serve_label(int inv_serve_label) {
        this.inv_serve_label = inv_serve_label;
    }


    /**
     * Gets the cleanup_def value for this Job_select_responseJob.
     * 
     * @return cleanup_def
     */
    public java.lang.String getCleanup_def() {
        return cleanup_def;
    }


    /**
     * Sets the cleanup_def value for this Job_select_responseJob.
     * 
     * @param cleanup_def
     */
    public void setCleanup_def(java.lang.String cleanup_def) {
        this.cleanup_def = cleanup_def;
    }


    /**
     * Gets the audit_galley_sort_def value for this Job_select_responseJob.
     * 
     * @return audit_galley_sort_def
     */
    public java.lang.String getAudit_galley_sort_def() {
        return audit_galley_sort_def;
    }


    /**
     * Sets the audit_galley_sort_def value for this Job_select_responseJob.
     * 
     * @param audit_galley_sort_def
     */
    public void setAudit_galley_sort_def(java.lang.String audit_galley_sort_def) {
        this.audit_galley_sort_def = audit_galley_sort_def;
    }


    /**
     * Gets the output_step value for this Job_select_responseJob.
     * 
     * @return output_step
     */
    public int getOutput_step() {
        return output_step;
    }


    /**
     * Sets the output_step value for this Job_select_responseJob.
     * 
     * @param output_step
     */
    public void setOutput_step(int output_step) {
        this.output_step = output_step;
    }


    /**
     * Gets the has_errors value for this Job_select_responseJob.
     * 
     * @return has_errors
     */
    public int getHas_errors() {
        return has_errors;
    }


    /**
     * Sets the has_errors value for this Job_select_responseJob.
     * 
     * @param has_errors
     */
    public void setHas_errors(int has_errors) {
        this.has_errors = has_errors;
    }


    /**
     * Gets the end_job_datetime value for this Job_select_responseJob.
     * 
     * @return end_job_datetime
     */
    public java.util.Calendar getEnd_job_datetime() {
        return end_job_datetime;
    }


    /**
     * Sets the end_job_datetime value for this Job_select_responseJob.
     * 
     * @param end_job_datetime
     */
    public void setEnd_job_datetime(java.util.Calendar end_job_datetime) {
        this.end_job_datetime = end_job_datetime;
    }


    /**
     * Gets the n_minutes_to_next_run value for this Job_select_responseJob.
     * 
     * @return n_minutes_to_next_run
     */
    public int getN_minutes_to_next_run() {
        return n_minutes_to_next_run;
    }


    /**
     * Sets the n_minutes_to_next_run value for this Job_select_responseJob.
     * 
     * @param n_minutes_to_next_run
     */
    public void setN_minutes_to_next_run(int n_minutes_to_next_run) {
        this.n_minutes_to_next_run = n_minutes_to_next_run;
    }


    /**
     * Gets the user_code value for this Job_select_responseJob.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Job_select_responseJob.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the write_recon_dtl value for this Job_select_responseJob.
     * 
     * @return write_recon_dtl
     */
    public int getWrite_recon_dtl() {
        return write_recon_dtl;
    }


    /**
     * Sets the write_recon_dtl value for this Job_select_responseJob.
     * 
     * @param write_recon_dtl
     */
    public void setWrite_recon_dtl(int write_recon_dtl) {
        this.write_recon_dtl = write_recon_dtl;
    }


    /**
     * Gets the cleanedup value for this Job_select_responseJob.
     * 
     * @return cleanedup
     */
    public int getCleanedup() {
        return cleanedup;
    }


    /**
     * Sets the cleanedup value for this Job_select_responseJob.
     * 
     * @param cleanedup
     */
    public void setCleanedup(int cleanedup) {
        this.cleanedup = cleanedup;
    }


    /**
     * Gets the adj_order_issue_method value for this Job_select_responseJob.
     * 
     * @return adj_order_issue_method
     */
    public int getAdj_order_issue_method() {
        return adj_order_issue_method;
    }


    /**
     * Sets the adj_order_issue_method value for this Job_select_responseJob.
     * 
     * @param adj_order_issue_method
     */
    public void setAdj_order_issue_method(int adj_order_issue_method) {
        this.adj_order_issue_method = adj_order_issue_method;
    }


    /**
     * Gets the upd_recon_tables value for this Job_select_responseJob.
     * 
     * @return upd_recon_tables
     */
    public int getUpd_recon_tables() {
        return upd_recon_tables;
    }


    /**
     * Sets the upd_recon_tables value for this Job_select_responseJob.
     * 
     * @param upd_recon_tables
     */
    public void setUpd_recon_tables(int upd_recon_tables) {
        this.upd_recon_tables = upd_recon_tables;
    }


    /**
     * Gets the repeating_type value for this Job_select_responseJob.
     * 
     * @return repeating_type
     */
    public int getRepeating_type() {
        return repeating_type;
    }


    /**
     * Sets the repeating_type value for this Job_select_responseJob.
     * 
     * @param repeating_type
     */
    public void setRepeating_type(int repeating_type) {
        this.repeating_type = repeating_type;
    }


    /**
     * Gets the interval_unit value for this Job_select_responseJob.
     * 
     * @return interval_unit
     */
    public int getInterval_unit() {
        return interval_unit;
    }


    /**
     * Sets the interval_unit value for this Job_select_responseJob.
     * 
     * @param interval_unit
     */
    public void setInterval_unit(int interval_unit) {
        this.interval_unit = interval_unit;
    }


    /**
     * Gets the n_interval_units value for this Job_select_responseJob.
     * 
     * @return n_interval_units
     */
    public int getN_interval_units() {
        return n_interval_units;
    }


    /**
     * Sets the n_interval_units value for this Job_select_responseJob.
     * 
     * @param n_interval_units
     */
    public void setN_interval_units(int n_interval_units) {
        this.n_interval_units = n_interval_units;
    }


    /**
     * Gets the job_completion_email_address value for this Job_select_responseJob.
     * 
     * @return job_completion_email_address
     */
    public java.lang.String getJob_completion_email_address() {
        return job_completion_email_address;
    }


    /**
     * Sets the job_completion_email_address value for this Job_select_responseJob.
     * 
     * @param job_completion_email_address
     */
    public void setJob_completion_email_address(java.lang.String job_completion_email_address) {
        this.job_completion_email_address = job_completion_email_address;
    }


    /**
     * Gets the log_option value for this Job_select_responseJob.
     * 
     * @return log_option
     */
    public int getLog_option() {
        return log_option;
    }


    /**
     * Sets the log_option value for this Job_select_responseJob.
     * 
     * @param log_option
     */
    public void setLog_option(int log_option) {
        this.log_option = log_option;
    }


    /**
     * Gets the run_payment_after_bill value for this Job_select_responseJob.
     * 
     * @return run_payment_after_bill
     */
    public int getRun_payment_after_bill() {
        return run_payment_after_bill;
    }


    /**
     * Sets the run_payment_after_bill value for this Job_select_responseJob.
     * 
     * @param run_payment_after_bill
     */
    public void setRun_payment_after_bill(int run_payment_after_bill) {
        this.run_payment_after_bill = run_payment_after_bill;
    }


    /**
     * Gets the bacs_step value for this Job_select_responseJob.
     * 
     * @return bacs_step
     */
    public int getBacs_step() {
        return bacs_step;
    }


    /**
     * Sets the bacs_step value for this Job_select_responseJob.
     * 
     * @param bacs_step
     */
    public void setBacs_step(int bacs_step) {
        this.bacs_step = bacs_step;
    }


    /**
     * Gets the back_issues_on_reinstated value for this Job_select_responseJob.
     * 
     * @return back_issues_on_reinstated
     */
    public int getBack_issues_on_reinstated() {
        return back_issues_on_reinstated;
    }


    /**
     * Sets the back_issues_on_reinstated value for this Job_select_responseJob.
     * 
     * @param back_issues_on_reinstated
     */
    public void setBack_issues_on_reinstated(int back_issues_on_reinstated) {
        this.back_issues_on_reinstated = back_issues_on_reinstated;
    }


    /**
     * Gets the manual_review_fulfillment value for this Job_select_responseJob.
     * 
     * @return manual_review_fulfillment
     */
    public int getManual_review_fulfillment() {
        return manual_review_fulfillment;
    }


    /**
     * Sets the manual_review_fulfillment value for this Job_select_responseJob.
     * 
     * @param manual_review_fulfillment
     */
    public void setManual_review_fulfillment(int manual_review_fulfillment) {
        this.manual_review_fulfillment = manual_review_fulfillment;
    }


    /**
     * Gets the status value for this Job_select_responseJob.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Job_select_responseJob.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the step_number value for this Job_select_responseJob.
     * 
     * @return step_number
     */
    public int getStep_number() {
        return step_number;
    }


    /**
     * Sets the step_number value for this Job_select_responseJob.
     * 
     * @param step_number
     */
    public void setStep_number(int step_number) {
        this.step_number = step_number;
    }


    /**
     * Gets the step_name value for this Job_select_responseJob.
     * 
     * @return step_name
     */
    public java.lang.String getStep_name() {
        return step_name;
    }


    /**
     * Sets the step_name value for this Job_select_responseJob.
     * 
     * @param step_name
     */
    public void setStep_name(java.lang.String step_name) {
        this.step_name = step_name;
    }


    /**
     * Gets the hold_bits value for this Job_select_responseJob.
     * 
     * @return hold_bits
     */
    public int getHold_bits() {
        return hold_bits;
    }


    /**
     * Sets the hold_bits value for this Job_select_responseJob.
     * 
     * @param hold_bits
     */
    public void setHold_bits(int hold_bits) {
        this.hold_bits = hold_bits;
    }


    /**
     * Gets the generate_renew_offers value for this Job_select_responseJob.
     * 
     * @return generate_renew_offers
     */
    public int getGenerate_renew_offers() {
        return generate_renew_offers;
    }


    /**
     * Sets the generate_renew_offers value for this Job_select_responseJob.
     * 
     * @param generate_renew_offers
     */
    public void setGenerate_renew_offers(int generate_renew_offers) {
        this.generate_renew_offers = generate_renew_offers;
    }


    /**
     * Gets the last_pulse value for this Job_select_responseJob.
     * 
     * @return last_pulse
     */
    public java.util.Calendar getLast_pulse() {
        return last_pulse;
    }


    /**
     * Sets the last_pulse value for this Job_select_responseJob.
     * 
     * @param last_pulse
     */
    public void setLast_pulse(java.util.Calendar last_pulse) {
        this.last_pulse = last_pulse;
    }


    /**
     * Gets the incl_pkg_members value for this Job_select_responseJob.
     * 
     * @return incl_pkg_members
     */
    public int getIncl_pkg_members() {
        return incl_pkg_members;
    }


    /**
     * Sets the incl_pkg_members value for this Job_select_responseJob.
     * 
     * @param incl_pkg_members
     */
    public void setIncl_pkg_members(int incl_pkg_members) {
        this.incl_pkg_members = incl_pkg_members;
    }


    /**
     * Gets the process_description value for this Job_select_responseJob.
     * 
     * @return process_description
     */
    public java.lang.String getProcess_description() {
        return process_description;
    }


    /**
     * Sets the process_description value for this Job_select_responseJob.
     * 
     * @param process_description
     */
    public void setProcess_description(java.lang.String process_description) {
        this.process_description = process_description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Job_select_responseJob)) return false;
        Job_select_responseJob other = (Job_select_responseJob) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            ((this.label_keyline==null && other.getLabel_keyline()==null) || 
             (this.label_keyline!=null &&
              this.label_keyline.equals(other.getLabel_keyline()))) &&
            ((this.label_group==null && other.getLabel_group()==null) || 
             (this.label_group!=null &&
              this.label_group.equals(other.getLabel_group()))) &&
            this.process_id == other.getProcess_id() &&
            ((this.cutoff_date==null && other.getCutoff_date()==null) || 
             (this.cutoff_date!=null &&
              this.cutoff_date.equals(other.getCutoff_date()))) &&
            ((this.drop_date==null && other.getDrop_date()==null) || 
             (this.drop_date!=null &&
              this.drop_date.equals(other.getDrop_date()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.nth_def==null && other.getNth_def()==null) || 
             (this.nth_def!=null &&
              this.nth_def.equals(other.getNth_def()))) &&
            ((this.list_company==null && other.getList_company()==null) || 
             (this.list_company!=null &&
              this.list_company.equals(other.getList_company()))) &&
            ((this.purpose==null && other.getPurpose()==null) || 
             (this.purpose!=null &&
              this.purpose.equals(other.getPurpose()))) &&
            this.n_candidate_records == other.getN_candidate_records() &&
            this.n_selected_records == other.getN_selected_records() &&
            ((this.start_date_time==null && other.getStart_date_time()==null) || 
             (this.start_date_time!=null &&
              this.start_date_time.equals(other.getStart_date_time()))) &&
            this.n_days_to_next_run == other.getN_days_to_next_run() &&
            this.n_updated_records == other.getN_updated_records() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.grace_new == other.getGrace_new() &&
            this.grace_current == other.getGrace_current() &&
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            this.job_priority == other.getJob_priority() &&
            ((this.job_description==null && other.getJob_description()==null) || 
             (this.job_description!=null &&
              this.job_description.equals(other.getJob_description()))) &&
            this.end_select_date_stamp == other.getEnd_select_date_stamp() &&
            this.create_audit_galley == other.getCreate_audit_galley() &&
            this.sort_audit_galley == other.getSort_audit_galley() &&
            this.nth_audit_galley == other.getNth_audit_galley() &&
            ((this.audit_galley_doc_ref_date==null && other.getAudit_galley_doc_ref_date()==null) || 
             (this.audit_galley_doc_ref_date!=null &&
              this.audit_galley_doc_ref_date.equals(other.getAudit_galley_doc_ref_date()))) &&
            ((this.queue==null && other.getQueue()==null) || 
             (this.queue!=null &&
              this.queue.equals(other.getQueue()))) &&
            this.force_repeat == other.getForce_repeat() &&
            this.auto_renewals == other.getAuto_renewals() &&
            ((this.schedule_payment_date==null && other.getSchedule_payment_date()==null) || 
             (this.schedule_payment_date!=null &&
              this.schedule_payment_date.equals(other.getSchedule_payment_date()))) &&
            this.volume_group_id == other.getVolume_group_id() &&
            ((this.sql_script==null && other.getSql_script()==null) || 
             (this.sql_script!=null &&
              this.sql_script.equals(other.getSql_script()))) &&
            ((this.work_file==null && other.getWork_file()==null) || 
             (this.work_file!=null &&
              this.work_file.equals(other.getWork_file()))) &&
            ((this.select_start_date==null && other.getSelect_start_date()==null) || 
             (this.select_start_date!=null &&
              this.select_start_date.equals(other.getSelect_start_date()))) &&
            ((this.select_end_date==null && other.getSelect_end_date()==null) || 
             (this.select_end_date!=null &&
              this.select_end_date.equals(other.getSelect_end_date()))) &&
            this.inv_serve_label == other.getInv_serve_label() &&
            ((this.cleanup_def==null && other.getCleanup_def()==null) || 
             (this.cleanup_def!=null &&
              this.cleanup_def.equals(other.getCleanup_def()))) &&
            ((this.audit_galley_sort_def==null && other.getAudit_galley_sort_def()==null) || 
             (this.audit_galley_sort_def!=null &&
              this.audit_galley_sort_def.equals(other.getAudit_galley_sort_def()))) &&
            this.output_step == other.getOutput_step() &&
            this.has_errors == other.getHas_errors() &&
            ((this.end_job_datetime==null && other.getEnd_job_datetime()==null) || 
             (this.end_job_datetime!=null &&
              this.end_job_datetime.equals(other.getEnd_job_datetime()))) &&
            this.n_minutes_to_next_run == other.getN_minutes_to_next_run() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            this.write_recon_dtl == other.getWrite_recon_dtl() &&
            this.cleanedup == other.getCleanedup() &&
            this.adj_order_issue_method == other.getAdj_order_issue_method() &&
            this.upd_recon_tables == other.getUpd_recon_tables() &&
            this.repeating_type == other.getRepeating_type() &&
            this.interval_unit == other.getInterval_unit() &&
            this.n_interval_units == other.getN_interval_units() &&
            ((this.job_completion_email_address==null && other.getJob_completion_email_address()==null) || 
             (this.job_completion_email_address!=null &&
              this.job_completion_email_address.equals(other.getJob_completion_email_address()))) &&
            this.log_option == other.getLog_option() &&
            this.run_payment_after_bill == other.getRun_payment_after_bill() &&
            this.bacs_step == other.getBacs_step() &&
            this.back_issues_on_reinstated == other.getBack_issues_on_reinstated() &&
            this.manual_review_fulfillment == other.getManual_review_fulfillment() &&
            this.status == other.getStatus() &&
            this.step_number == other.getStep_number() &&
            ((this.step_name==null && other.getStep_name()==null) || 
             (this.step_name!=null &&
              this.step_name.equals(other.getStep_name()))) &&
            this.hold_bits == other.getHold_bits() &&
            this.generate_renew_offers == other.getGenerate_renew_offers() &&
            ((this.last_pulse==null && other.getLast_pulse()==null) || 
             (this.last_pulse!=null &&
              this.last_pulse.equals(other.getLast_pulse()))) &&
            this.incl_pkg_members == other.getIncl_pkg_members() &&
            ((this.process_description==null && other.getProcess_description()==null) || 
             (this.process_description!=null &&
              this.process_description.equals(other.getProcess_description())));
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
        _hashCode += getJob_id();
        if (getLabel_keyline() != null) {
            _hashCode += getLabel_keyline().hashCode();
        }
        if (getLabel_group() != null) {
            _hashCode += getLabel_group().hashCode();
        }
        _hashCode += getProcess_id();
        if (getCutoff_date() != null) {
            _hashCode += getCutoff_date().hashCode();
        }
        if (getDrop_date() != null) {
            _hashCode += getDrop_date().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getNth_def() != null) {
            _hashCode += getNth_def().hashCode();
        }
        if (getList_company() != null) {
            _hashCode += getList_company().hashCode();
        }
        if (getPurpose() != null) {
            _hashCode += getPurpose().hashCode();
        }
        _hashCode += getN_candidate_records();
        _hashCode += getN_selected_records();
        if (getStart_date_time() != null) {
            _hashCode += getStart_date_time().hashCode();
        }
        _hashCode += getN_days_to_next_run();
        _hashCode += getN_updated_records();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getGrace_new();
        _hashCode += getGrace_current();
        _hashCode += getPending_xaction_header_id();
        _hashCode += getJob_priority();
        if (getJob_description() != null) {
            _hashCode += getJob_description().hashCode();
        }
        _hashCode += getEnd_select_date_stamp();
        _hashCode += getCreate_audit_galley();
        _hashCode += getSort_audit_galley();
        _hashCode += getNth_audit_galley();
        if (getAudit_galley_doc_ref_date() != null) {
            _hashCode += getAudit_galley_doc_ref_date().hashCode();
        }
        if (getQueue() != null) {
            _hashCode += getQueue().hashCode();
        }
        _hashCode += getForce_repeat();
        _hashCode += getAuto_renewals();
        if (getSchedule_payment_date() != null) {
            _hashCode += getSchedule_payment_date().hashCode();
        }
        _hashCode += getVolume_group_id();
        if (getSql_script() != null) {
            _hashCode += getSql_script().hashCode();
        }
        if (getWork_file() != null) {
            _hashCode += getWork_file().hashCode();
        }
        if (getSelect_start_date() != null) {
            _hashCode += getSelect_start_date().hashCode();
        }
        if (getSelect_end_date() != null) {
            _hashCode += getSelect_end_date().hashCode();
        }
        _hashCode += getInv_serve_label();
        if (getCleanup_def() != null) {
            _hashCode += getCleanup_def().hashCode();
        }
        if (getAudit_galley_sort_def() != null) {
            _hashCode += getAudit_galley_sort_def().hashCode();
        }
        _hashCode += getOutput_step();
        _hashCode += getHas_errors();
        if (getEnd_job_datetime() != null) {
            _hashCode += getEnd_job_datetime().hashCode();
        }
        _hashCode += getN_minutes_to_next_run();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        _hashCode += getWrite_recon_dtl();
        _hashCode += getCleanedup();
        _hashCode += getAdj_order_issue_method();
        _hashCode += getUpd_recon_tables();
        _hashCode += getRepeating_type();
        _hashCode += getInterval_unit();
        _hashCode += getN_interval_units();
        if (getJob_completion_email_address() != null) {
            _hashCode += getJob_completion_email_address().hashCode();
        }
        _hashCode += getLog_option();
        _hashCode += getRun_payment_after_bill();
        _hashCode += getBacs_step();
        _hashCode += getBack_issues_on_reinstated();
        _hashCode += getManual_review_fulfillment();
        _hashCode += getStatus();
        _hashCode += getStep_number();
        if (getStep_name() != null) {
            _hashCode += getStep_name().hashCode();
        }
        _hashCode += getHold_bits();
        _hashCode += getGenerate_renew_offers();
        if (getLast_pulse() != null) {
            _hashCode += getLast_pulse().hashCode();
        }
        _hashCode += getIncl_pkg_members();
        if (getProcess_description() != null) {
            _hashCode += getProcess_description().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Job_select_responseJob.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>job_select_response>job"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label_keyline");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label_keyline"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cutoff_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cutoff_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("drop_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "drop_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("note");
        attrField.setXmlName(new javax.xml.namespace.QName("", "note"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nth_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nth_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("list_company");
        attrField.setXmlName(new javax.xml.namespace.QName("", "list_company"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("purpose");
        attrField.setXmlName(new javax.xml.namespace.QName("", "purpose"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_candidate_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_candidate_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_selected_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_selected_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_date_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_date_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_days_to_next_run");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_days_to_next_run"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_updated_records");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_updated_records"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("grace_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "grace_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("grace_current");
        attrField.setXmlName(new javax.xml.namespace.QName("", "grace_current"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_header_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_header_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_priority");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_priority"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("end_select_date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "end_select_date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("create_audit_galley");
        attrField.setXmlName(new javax.xml.namespace.QName("", "create_audit_galley"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sort_audit_galley");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sort_audit_galley"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nth_audit_galley");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nth_audit_galley"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_galley_doc_ref_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_galley_doc_ref_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("queue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "queue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("force_repeat");
        attrField.setXmlName(new javax.xml.namespace.QName("", "force_repeat"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_renewals");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_renewals"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("schedule_payment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "schedule_payment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_group_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_group_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sql_script");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sql_script"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("work_file");
        attrField.setXmlName(new javax.xml.namespace.QName("", "work_file"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("select_start_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "select_start_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("select_end_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "select_end_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inv_serve_label");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inv_serve_label"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cleanup_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cleanup_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_galley_sort_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_galley_sort_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("output_step");
        attrField.setXmlName(new javax.xml.namespace.QName("", "output_step"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("has_errors");
        attrField.setXmlName(new javax.xml.namespace.QName("", "has_errors"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("end_job_datetime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "end_job_datetime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_minutes_to_next_run");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_minutes_to_next_run"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("write_recon_dtl");
        attrField.setXmlName(new javax.xml.namespace.QName("", "write_recon_dtl"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cleanedup");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cleanedup"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("adj_order_issue_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "adj_order_issue_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("upd_recon_tables");
        attrField.setXmlName(new javax.xml.namespace.QName("", "upd_recon_tables"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("repeating_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "repeating_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("interval_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "interval_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_interval_units");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_interval_units"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_completion_email_address");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_completion_email_address"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("log_option");
        attrField.setXmlName(new javax.xml.namespace.QName("", "log_option"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("run_payment_after_bill");
        attrField.setXmlName(new javax.xml.namespace.QName("", "run_payment_after_bill"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bacs_step");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bacs_step"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("back_issues_on_reinstated");
        attrField.setXmlName(new javax.xml.namespace.QName("", "back_issues_on_reinstated"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manual_review_fulfillment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "manual_review_fulfillment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("step_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "step_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("step_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "step_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("hold_bits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "hold_bits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("generate_renew_offers");
        attrField.setXmlName(new javax.xml.namespace.QName("", "generate_renew_offers"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("last_pulse");
        attrField.setXmlName(new javax.xml.namespace.QName("", "last_pulse"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("incl_pkg_members");
        attrField.setXmlName(new javax.xml.namespace.QName("", "incl_pkg_members"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_description"));
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
