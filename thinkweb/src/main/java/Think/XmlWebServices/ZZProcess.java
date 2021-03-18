/**
 * ZZProcess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZProcess  implements java.io.Serializable {
    private int process_id;  // attribute

    private int active;  // attribute

    private int all_credit_cards;  // attribute

    private int all_direct_debits;  // attribute

    private int all_installment_plans;  // attribute

    private int all_list_rental_categories;  // attribute

    private int all_oc;  // attribute

    private int all_prospect_categories;  // attribute

    private int auddis_type;  // attribute

    private int audit_paragraph_ignore_back_is;  // attribute

    private int audit_type;  // attribute

    private int auto_renew_expire_days;  // attribute

    private int auto_renewals;  // attribute

    private int bank_def_id;  // attribute

    private java.lang.String batch_template;  // attribute

    private int bill_grp_bill_to;  // attribute

    private int bill_grp_currency;  // attribute

    private int bill_grp_def;  // attribute

    private int bill_grp_oclass;  // attribute

    private int bill_grp_order;  // attribute

    private int bills;  // attribute

    private int bundle_threshold;  // attribute

    private java.lang.String cancel_reason;  // attribute

    private java.lang.String ccard_expire_days;  // attribute

    private int cleanup_events;  // attribute

    private int co_mail;  // attribute

    private int customer_type;  // attribute

    private int days_before_end;  // attribute

    private int days_passed_for_pulls;  // attribute

    private int default_job_priority;  // attribute

    private java.lang.String description;  // attribute

    private int do_mass_kill;  // attribute

    private int do_mass_suspend;  // attribute

    private int driver_type;  // attribute

    private java.lang.String extract;  // attribute

    private java.lang.String fatal_email;  // attribute

    private java.lang.String from_email_address;  // attribute

    private int generate_renew_offers;  // attribute

    private int grace_current;  // attribute

    private int grace_new;  // attribute

    private int ics_bank_def_id;  // attribute

    private int incl_audit_paragraph_reports;  // attribute

    private int incl_pkg_members;  // attribute

    private int includes_proformas;  // attribute

    private int inserts;  // attribute

    private int installment_bills;  // attribute

    private int interval_unit;  // attribute

    private int inv_serve_label;  // attribute

    private int items_per_request;  // attribute

    private java.lang.String job_completion_email_address;  // attribute

    private java.lang.String job_done_email;  // attribute

    private java.lang.String label_group;  // attribute

    private java.lang.String label_keyline;  // attribute

    private int label_length;  // attribute

    private int leave_dd_account_number_plain;  // attribute

    private int manual_review_fulfillment;  // attribute

    private int mass_kill_interval;  // attribute

    private int mass_suspend_interval;  // attribute

    private int multiple_per_customer;  // attribute

    private int n_interval_units;  // attribute

    private java.lang.String no_connect_email;  // attribute

    private int notice_type;  // attribute

    private int notification_bits;  // attribute

    private java.lang.String nth_def;  // attribute

    private int oc_id;  // attribute

    private java.lang.String on_hold_email;  // attribute

    private java.lang.String output_ready_email;  // attribute

    private java.lang.String output_sort;  // attribute

    private int pick_list;  // attribute

    private java.lang.String priority_sort;  // attribute

    private int process_deposit_payment;  // attribute

    private int process_oc_type;  // attribute

    private int process_type;  // attribute

    private int promotions;  // attribute

    private java.lang.String queue;  // attribute

    private java.lang.String recon_work_dir;  // attribute

    private int ren_grp_currency;  // attribute

    private int ren_grp_def;  // attribute

    private int ren_grp_oclass;  // attribute

    private int ren_grp_order;  // attribute

    private int ren_grp_ren_to;  // attribute

    private int renewals;  // attribute

    private int repeating_type;  // attribute

    private int requal;  // attribute

    private int resend_notice;  // attribute

    private java.lang.String review_ready_email;  // attribute

    private int run_icverify;  // attribute

    private int schedule_payment_days;  // attribute

    private int skip_manual_pay_response;  // attribute

    private int splits;  // attribute

    private java.lang.String sql_script;  // attribute

    private int unpaid_resubmit;  // attribute

    private int upd_recon_tables;  // attribute

    private int validate_adds;  // attribute

    private int volume_group_id;  // attribute

    private java.lang.String warning_email;  // attribute

    private int write_recon_dtl;  // attribute

    public ZZProcess() {
    }

    public ZZProcess(
           int process_id,
           int active,
           int all_credit_cards,
           int all_direct_debits,
           int all_installment_plans,
           int all_list_rental_categories,
           int all_oc,
           int all_prospect_categories,
           int auddis_type,
           int audit_paragraph_ignore_back_is,
           int audit_type,
           int auto_renew_expire_days,
           int auto_renewals,
           int bank_def_id,
           java.lang.String batch_template,
           int bill_grp_bill_to,
           int bill_grp_currency,
           int bill_grp_def,
           int bill_grp_oclass,
           int bill_grp_order,
           int bills,
           int bundle_threshold,
           java.lang.String cancel_reason,
           java.lang.String ccard_expire_days,
           int cleanup_events,
           int co_mail,
           int customer_type,
           int days_before_end,
           int days_passed_for_pulls,
           int default_job_priority,
           java.lang.String description,
           int do_mass_kill,
           int do_mass_suspend,
           int driver_type,
           java.lang.String extract,
           java.lang.String fatal_email,
           java.lang.String from_email_address,
           int generate_renew_offers,
           int grace_current,
           int grace_new,
           int ics_bank_def_id,
           int incl_audit_paragraph_reports,
           int incl_pkg_members,
           int includes_proformas,
           int inserts,
           int installment_bills,
           int interval_unit,
           int inv_serve_label,
           int items_per_request,
           java.lang.String job_completion_email_address,
           java.lang.String job_done_email,
           java.lang.String label_group,
           java.lang.String label_keyline,
           int label_length,
           int leave_dd_account_number_plain,
           int manual_review_fulfillment,
           int mass_kill_interval,
           int mass_suspend_interval,
           int multiple_per_customer,
           int n_interval_units,
           java.lang.String no_connect_email,
           int notice_type,
           int notification_bits,
           java.lang.String nth_def,
           int oc_id,
           java.lang.String on_hold_email,
           java.lang.String output_ready_email,
           java.lang.String output_sort,
           int pick_list,
           java.lang.String priority_sort,
           int process_deposit_payment,
           int process_oc_type,
           int process_type,
           int promotions,
           java.lang.String queue,
           java.lang.String recon_work_dir,
           int ren_grp_currency,
           int ren_grp_def,
           int ren_grp_oclass,
           int ren_grp_order,
           int ren_grp_ren_to,
           int renewals,
           int repeating_type,
           int requal,
           int resend_notice,
           java.lang.String review_ready_email,
           int run_icverify,
           int schedule_payment_days,
           int skip_manual_pay_response,
           int splits,
           java.lang.String sql_script,
           int unpaid_resubmit,
           int upd_recon_tables,
           int validate_adds,
           int volume_group_id,
           java.lang.String warning_email,
           int write_recon_dtl) {
           this.process_id = process_id;
           this.active = active;
           this.all_credit_cards = all_credit_cards;
           this.all_direct_debits = all_direct_debits;
           this.all_installment_plans = all_installment_plans;
           this.all_list_rental_categories = all_list_rental_categories;
           this.all_oc = all_oc;
           this.all_prospect_categories = all_prospect_categories;
           this.auddis_type = auddis_type;
           this.audit_paragraph_ignore_back_is = audit_paragraph_ignore_back_is;
           this.audit_type = audit_type;
           this.auto_renew_expire_days = auto_renew_expire_days;
           this.auto_renewals = auto_renewals;
           this.bank_def_id = bank_def_id;
           this.batch_template = batch_template;
           this.bill_grp_bill_to = bill_grp_bill_to;
           this.bill_grp_currency = bill_grp_currency;
           this.bill_grp_def = bill_grp_def;
           this.bill_grp_oclass = bill_grp_oclass;
           this.bill_grp_order = bill_grp_order;
           this.bills = bills;
           this.bundle_threshold = bundle_threshold;
           this.cancel_reason = cancel_reason;
           this.ccard_expire_days = ccard_expire_days;
           this.cleanup_events = cleanup_events;
           this.co_mail = co_mail;
           this.customer_type = customer_type;
           this.days_before_end = days_before_end;
           this.days_passed_for_pulls = days_passed_for_pulls;
           this.default_job_priority = default_job_priority;
           this.description = description;
           this.do_mass_kill = do_mass_kill;
           this.do_mass_suspend = do_mass_suspend;
           this.driver_type = driver_type;
           this.extract = extract;
           this.fatal_email = fatal_email;
           this.from_email_address = from_email_address;
           this.generate_renew_offers = generate_renew_offers;
           this.grace_current = grace_current;
           this.grace_new = grace_new;
           this.ics_bank_def_id = ics_bank_def_id;
           this.incl_audit_paragraph_reports = incl_audit_paragraph_reports;
           this.incl_pkg_members = incl_pkg_members;
           this.includes_proformas = includes_proformas;
           this.inserts = inserts;
           this.installment_bills = installment_bills;
           this.interval_unit = interval_unit;
           this.inv_serve_label = inv_serve_label;
           this.items_per_request = items_per_request;
           this.job_completion_email_address = job_completion_email_address;
           this.job_done_email = job_done_email;
           this.label_group = label_group;
           this.label_keyline = label_keyline;
           this.label_length = label_length;
           this.leave_dd_account_number_plain = leave_dd_account_number_plain;
           this.manual_review_fulfillment = manual_review_fulfillment;
           this.mass_kill_interval = mass_kill_interval;
           this.mass_suspend_interval = mass_suspend_interval;
           this.multiple_per_customer = multiple_per_customer;
           this.n_interval_units = n_interval_units;
           this.no_connect_email = no_connect_email;
           this.notice_type = notice_type;
           this.notification_bits = notification_bits;
           this.nth_def = nth_def;
           this.oc_id = oc_id;
           this.on_hold_email = on_hold_email;
           this.output_ready_email = output_ready_email;
           this.output_sort = output_sort;
           this.pick_list = pick_list;
           this.priority_sort = priority_sort;
           this.process_deposit_payment = process_deposit_payment;
           this.process_oc_type = process_oc_type;
           this.process_type = process_type;
           this.promotions = promotions;
           this.queue = queue;
           this.recon_work_dir = recon_work_dir;
           this.ren_grp_currency = ren_grp_currency;
           this.ren_grp_def = ren_grp_def;
           this.ren_grp_oclass = ren_grp_oclass;
           this.ren_grp_order = ren_grp_order;
           this.ren_grp_ren_to = ren_grp_ren_to;
           this.renewals = renewals;
           this.repeating_type = repeating_type;
           this.requal = requal;
           this.resend_notice = resend_notice;
           this.review_ready_email = review_ready_email;
           this.run_icverify = run_icverify;
           this.schedule_payment_days = schedule_payment_days;
           this.skip_manual_pay_response = skip_manual_pay_response;
           this.splits = splits;
           this.sql_script = sql_script;
           this.unpaid_resubmit = unpaid_resubmit;
           this.upd_recon_tables = upd_recon_tables;
           this.validate_adds = validate_adds;
           this.volume_group_id = volume_group_id;
           this.warning_email = warning_email;
           this.write_recon_dtl = write_recon_dtl;
    }


    /**
     * Gets the process_id value for this ZZProcess.
     * 
     * @return process_id
     */
    public int getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this ZZProcess.
     * 
     * @param process_id
     */
    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the active value for this ZZProcess.
     * 
     * @return active
     */
    public int getActive() {
        return active;
    }


    /**
     * Sets the active value for this ZZProcess.
     * 
     * @param active
     */
    public void setActive(int active) {
        this.active = active;
    }


    /**
     * Gets the all_credit_cards value for this ZZProcess.
     * 
     * @return all_credit_cards
     */
    public int getAll_credit_cards() {
        return all_credit_cards;
    }


    /**
     * Sets the all_credit_cards value for this ZZProcess.
     * 
     * @param all_credit_cards
     */
    public void setAll_credit_cards(int all_credit_cards) {
        this.all_credit_cards = all_credit_cards;
    }


    /**
     * Gets the all_direct_debits value for this ZZProcess.
     * 
     * @return all_direct_debits
     */
    public int getAll_direct_debits() {
        return all_direct_debits;
    }


    /**
     * Sets the all_direct_debits value for this ZZProcess.
     * 
     * @param all_direct_debits
     */
    public void setAll_direct_debits(int all_direct_debits) {
        this.all_direct_debits = all_direct_debits;
    }


    /**
     * Gets the all_installment_plans value for this ZZProcess.
     * 
     * @return all_installment_plans
     */
    public int getAll_installment_plans() {
        return all_installment_plans;
    }


    /**
     * Sets the all_installment_plans value for this ZZProcess.
     * 
     * @param all_installment_plans
     */
    public void setAll_installment_plans(int all_installment_plans) {
        this.all_installment_plans = all_installment_plans;
    }


    /**
     * Gets the all_list_rental_categories value for this ZZProcess.
     * 
     * @return all_list_rental_categories
     */
    public int getAll_list_rental_categories() {
        return all_list_rental_categories;
    }


    /**
     * Sets the all_list_rental_categories value for this ZZProcess.
     * 
     * @param all_list_rental_categories
     */
    public void setAll_list_rental_categories(int all_list_rental_categories) {
        this.all_list_rental_categories = all_list_rental_categories;
    }


    /**
     * Gets the all_oc value for this ZZProcess.
     * 
     * @return all_oc
     */
    public int getAll_oc() {
        return all_oc;
    }


    /**
     * Sets the all_oc value for this ZZProcess.
     * 
     * @param all_oc
     */
    public void setAll_oc(int all_oc) {
        this.all_oc = all_oc;
    }


    /**
     * Gets the all_prospect_categories value for this ZZProcess.
     * 
     * @return all_prospect_categories
     */
    public int getAll_prospect_categories() {
        return all_prospect_categories;
    }


    /**
     * Sets the all_prospect_categories value for this ZZProcess.
     * 
     * @param all_prospect_categories
     */
    public void setAll_prospect_categories(int all_prospect_categories) {
        this.all_prospect_categories = all_prospect_categories;
    }


    /**
     * Gets the auddis_type value for this ZZProcess.
     * 
     * @return auddis_type
     */
    public int getAuddis_type() {
        return auddis_type;
    }


    /**
     * Sets the auddis_type value for this ZZProcess.
     * 
     * @param auddis_type
     */
    public void setAuddis_type(int auddis_type) {
        this.auddis_type = auddis_type;
    }


    /**
     * Gets the audit_paragraph_ignore_back_is value for this ZZProcess.
     * 
     * @return audit_paragraph_ignore_back_is
     */
    public int getAudit_paragraph_ignore_back_is() {
        return audit_paragraph_ignore_back_is;
    }


    /**
     * Sets the audit_paragraph_ignore_back_is value for this ZZProcess.
     * 
     * @param audit_paragraph_ignore_back_is
     */
    public void setAudit_paragraph_ignore_back_is(int audit_paragraph_ignore_back_is) {
        this.audit_paragraph_ignore_back_is = audit_paragraph_ignore_back_is;
    }


    /**
     * Gets the audit_type value for this ZZProcess.
     * 
     * @return audit_type
     */
    public int getAudit_type() {
        return audit_type;
    }


    /**
     * Sets the audit_type value for this ZZProcess.
     * 
     * @param audit_type
     */
    public void setAudit_type(int audit_type) {
        this.audit_type = audit_type;
    }


    /**
     * Gets the auto_renew_expire_days value for this ZZProcess.
     * 
     * @return auto_renew_expire_days
     */
    public int getAuto_renew_expire_days() {
        return auto_renew_expire_days;
    }


    /**
     * Sets the auto_renew_expire_days value for this ZZProcess.
     * 
     * @param auto_renew_expire_days
     */
    public void setAuto_renew_expire_days(int auto_renew_expire_days) {
        this.auto_renew_expire_days = auto_renew_expire_days;
    }


    /**
     * Gets the auto_renewals value for this ZZProcess.
     * 
     * @return auto_renewals
     */
    public int getAuto_renewals() {
        return auto_renewals;
    }


    /**
     * Sets the auto_renewals value for this ZZProcess.
     * 
     * @param auto_renewals
     */
    public void setAuto_renewals(int auto_renewals) {
        this.auto_renewals = auto_renewals;
    }


    /**
     * Gets the bank_def_id value for this ZZProcess.
     * 
     * @return bank_def_id
     */
    public int getBank_def_id() {
        return bank_def_id;
    }


    /**
     * Sets the bank_def_id value for this ZZProcess.
     * 
     * @param bank_def_id
     */
    public void setBank_def_id(int bank_def_id) {
        this.bank_def_id = bank_def_id;
    }


    /**
     * Gets the batch_template value for this ZZProcess.
     * 
     * @return batch_template
     */
    public java.lang.String getBatch_template() {
        return batch_template;
    }


    /**
     * Sets the batch_template value for this ZZProcess.
     * 
     * @param batch_template
     */
    public void setBatch_template(java.lang.String batch_template) {
        this.batch_template = batch_template;
    }


    /**
     * Gets the bill_grp_bill_to value for this ZZProcess.
     * 
     * @return bill_grp_bill_to
     */
    public int getBill_grp_bill_to() {
        return bill_grp_bill_to;
    }


    /**
     * Sets the bill_grp_bill_to value for this ZZProcess.
     * 
     * @param bill_grp_bill_to
     */
    public void setBill_grp_bill_to(int bill_grp_bill_to) {
        this.bill_grp_bill_to = bill_grp_bill_to;
    }


    /**
     * Gets the bill_grp_currency value for this ZZProcess.
     * 
     * @return bill_grp_currency
     */
    public int getBill_grp_currency() {
        return bill_grp_currency;
    }


    /**
     * Sets the bill_grp_currency value for this ZZProcess.
     * 
     * @param bill_grp_currency
     */
    public void setBill_grp_currency(int bill_grp_currency) {
        this.bill_grp_currency = bill_grp_currency;
    }


    /**
     * Gets the bill_grp_def value for this ZZProcess.
     * 
     * @return bill_grp_def
     */
    public int getBill_grp_def() {
        return bill_grp_def;
    }


    /**
     * Sets the bill_grp_def value for this ZZProcess.
     * 
     * @param bill_grp_def
     */
    public void setBill_grp_def(int bill_grp_def) {
        this.bill_grp_def = bill_grp_def;
    }


    /**
     * Gets the bill_grp_oclass value for this ZZProcess.
     * 
     * @return bill_grp_oclass
     */
    public int getBill_grp_oclass() {
        return bill_grp_oclass;
    }


    /**
     * Sets the bill_grp_oclass value for this ZZProcess.
     * 
     * @param bill_grp_oclass
     */
    public void setBill_grp_oclass(int bill_grp_oclass) {
        this.bill_grp_oclass = bill_grp_oclass;
    }


    /**
     * Gets the bill_grp_order value for this ZZProcess.
     * 
     * @return bill_grp_order
     */
    public int getBill_grp_order() {
        return bill_grp_order;
    }


    /**
     * Sets the bill_grp_order value for this ZZProcess.
     * 
     * @param bill_grp_order
     */
    public void setBill_grp_order(int bill_grp_order) {
        this.bill_grp_order = bill_grp_order;
    }


    /**
     * Gets the bills value for this ZZProcess.
     * 
     * @return bills
     */
    public int getBills() {
        return bills;
    }


    /**
     * Sets the bills value for this ZZProcess.
     * 
     * @param bills
     */
    public void setBills(int bills) {
        this.bills = bills;
    }


    /**
     * Gets the bundle_threshold value for this ZZProcess.
     * 
     * @return bundle_threshold
     */
    public int getBundle_threshold() {
        return bundle_threshold;
    }


    /**
     * Sets the bundle_threshold value for this ZZProcess.
     * 
     * @param bundle_threshold
     */
    public void setBundle_threshold(int bundle_threshold) {
        this.bundle_threshold = bundle_threshold;
    }


    /**
     * Gets the cancel_reason value for this ZZProcess.
     * 
     * @return cancel_reason
     */
    public java.lang.String getCancel_reason() {
        return cancel_reason;
    }


    /**
     * Sets the cancel_reason value for this ZZProcess.
     * 
     * @param cancel_reason
     */
    public void setCancel_reason(java.lang.String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }


    /**
     * Gets the ccard_expire_days value for this ZZProcess.
     * 
     * @return ccard_expire_days
     */
    public java.lang.String getCcard_expire_days() {
        return ccard_expire_days;
    }


    /**
     * Sets the ccard_expire_days value for this ZZProcess.
     * 
     * @param ccard_expire_days
     */
    public void setCcard_expire_days(java.lang.String ccard_expire_days) {
        this.ccard_expire_days = ccard_expire_days;
    }


    /**
     * Gets the cleanup_events value for this ZZProcess.
     * 
     * @return cleanup_events
     */
    public int getCleanup_events() {
        return cleanup_events;
    }


    /**
     * Sets the cleanup_events value for this ZZProcess.
     * 
     * @param cleanup_events
     */
    public void setCleanup_events(int cleanup_events) {
        this.cleanup_events = cleanup_events;
    }


    /**
     * Gets the co_mail value for this ZZProcess.
     * 
     * @return co_mail
     */
    public int getCo_mail() {
        return co_mail;
    }


    /**
     * Sets the co_mail value for this ZZProcess.
     * 
     * @param co_mail
     */
    public void setCo_mail(int co_mail) {
        this.co_mail = co_mail;
    }


    /**
     * Gets the customer_type value for this ZZProcess.
     * 
     * @return customer_type
     */
    public int getCustomer_type() {
        return customer_type;
    }


    /**
     * Sets the customer_type value for this ZZProcess.
     * 
     * @param customer_type
     */
    public void setCustomer_type(int customer_type) {
        this.customer_type = customer_type;
    }


    /**
     * Gets the days_before_end value for this ZZProcess.
     * 
     * @return days_before_end
     */
    public int getDays_before_end() {
        return days_before_end;
    }


    /**
     * Sets the days_before_end value for this ZZProcess.
     * 
     * @param days_before_end
     */
    public void setDays_before_end(int days_before_end) {
        this.days_before_end = days_before_end;
    }


    /**
     * Gets the days_passed_for_pulls value for this ZZProcess.
     * 
     * @return days_passed_for_pulls
     */
    public int getDays_passed_for_pulls() {
        return days_passed_for_pulls;
    }


    /**
     * Sets the days_passed_for_pulls value for this ZZProcess.
     * 
     * @param days_passed_for_pulls
     */
    public void setDays_passed_for_pulls(int days_passed_for_pulls) {
        this.days_passed_for_pulls = days_passed_for_pulls;
    }


    /**
     * Gets the default_job_priority value for this ZZProcess.
     * 
     * @return default_job_priority
     */
    public int getDefault_job_priority() {
        return default_job_priority;
    }


    /**
     * Sets the default_job_priority value for this ZZProcess.
     * 
     * @param default_job_priority
     */
    public void setDefault_job_priority(int default_job_priority) {
        this.default_job_priority = default_job_priority;
    }


    /**
     * Gets the description value for this ZZProcess.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZProcess.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the do_mass_kill value for this ZZProcess.
     * 
     * @return do_mass_kill
     */
    public int getDo_mass_kill() {
        return do_mass_kill;
    }


    /**
     * Sets the do_mass_kill value for this ZZProcess.
     * 
     * @param do_mass_kill
     */
    public void setDo_mass_kill(int do_mass_kill) {
        this.do_mass_kill = do_mass_kill;
    }


    /**
     * Gets the do_mass_suspend value for this ZZProcess.
     * 
     * @return do_mass_suspend
     */
    public int getDo_mass_suspend() {
        return do_mass_suspend;
    }


    /**
     * Sets the do_mass_suspend value for this ZZProcess.
     * 
     * @param do_mass_suspend
     */
    public void setDo_mass_suspend(int do_mass_suspend) {
        this.do_mass_suspend = do_mass_suspend;
    }


    /**
     * Gets the driver_type value for this ZZProcess.
     * 
     * @return driver_type
     */
    public int getDriver_type() {
        return driver_type;
    }


    /**
     * Sets the driver_type value for this ZZProcess.
     * 
     * @param driver_type
     */
    public void setDriver_type(int driver_type) {
        this.driver_type = driver_type;
    }


    /**
     * Gets the extract value for this ZZProcess.
     * 
     * @return extract
     */
    public java.lang.String getExtract() {
        return extract;
    }


    /**
     * Sets the extract value for this ZZProcess.
     * 
     * @param extract
     */
    public void setExtract(java.lang.String extract) {
        this.extract = extract;
    }


    /**
     * Gets the fatal_email value for this ZZProcess.
     * 
     * @return fatal_email
     */
    public java.lang.String getFatal_email() {
        return fatal_email;
    }


    /**
     * Sets the fatal_email value for this ZZProcess.
     * 
     * @param fatal_email
     */
    public void setFatal_email(java.lang.String fatal_email) {
        this.fatal_email = fatal_email;
    }


    /**
     * Gets the from_email_address value for this ZZProcess.
     * 
     * @return from_email_address
     */
    public java.lang.String getFrom_email_address() {
        return from_email_address;
    }


    /**
     * Sets the from_email_address value for this ZZProcess.
     * 
     * @param from_email_address
     */
    public void setFrom_email_address(java.lang.String from_email_address) {
        this.from_email_address = from_email_address;
    }


    /**
     * Gets the generate_renew_offers value for this ZZProcess.
     * 
     * @return generate_renew_offers
     */
    public int getGenerate_renew_offers() {
        return generate_renew_offers;
    }


    /**
     * Sets the generate_renew_offers value for this ZZProcess.
     * 
     * @param generate_renew_offers
     */
    public void setGenerate_renew_offers(int generate_renew_offers) {
        this.generate_renew_offers = generate_renew_offers;
    }


    /**
     * Gets the grace_current value for this ZZProcess.
     * 
     * @return grace_current
     */
    public int getGrace_current() {
        return grace_current;
    }


    /**
     * Sets the grace_current value for this ZZProcess.
     * 
     * @param grace_current
     */
    public void setGrace_current(int grace_current) {
        this.grace_current = grace_current;
    }


    /**
     * Gets the grace_new value for this ZZProcess.
     * 
     * @return grace_new
     */
    public int getGrace_new() {
        return grace_new;
    }


    /**
     * Sets the grace_new value for this ZZProcess.
     * 
     * @param grace_new
     */
    public void setGrace_new(int grace_new) {
        this.grace_new = grace_new;
    }


    /**
     * Gets the ics_bank_def_id value for this ZZProcess.
     * 
     * @return ics_bank_def_id
     */
    public int getIcs_bank_def_id() {
        return ics_bank_def_id;
    }


    /**
     * Sets the ics_bank_def_id value for this ZZProcess.
     * 
     * @param ics_bank_def_id
     */
    public void setIcs_bank_def_id(int ics_bank_def_id) {
        this.ics_bank_def_id = ics_bank_def_id;
    }


    /**
     * Gets the incl_audit_paragraph_reports value for this ZZProcess.
     * 
     * @return incl_audit_paragraph_reports
     */
    public int getIncl_audit_paragraph_reports() {
        return incl_audit_paragraph_reports;
    }


    /**
     * Sets the incl_audit_paragraph_reports value for this ZZProcess.
     * 
     * @param incl_audit_paragraph_reports
     */
    public void setIncl_audit_paragraph_reports(int incl_audit_paragraph_reports) {
        this.incl_audit_paragraph_reports = incl_audit_paragraph_reports;
    }


    /**
     * Gets the incl_pkg_members value for this ZZProcess.
     * 
     * @return incl_pkg_members
     */
    public int getIncl_pkg_members() {
        return incl_pkg_members;
    }


    /**
     * Sets the incl_pkg_members value for this ZZProcess.
     * 
     * @param incl_pkg_members
     */
    public void setIncl_pkg_members(int incl_pkg_members) {
        this.incl_pkg_members = incl_pkg_members;
    }


    /**
     * Gets the includes_proformas value for this ZZProcess.
     * 
     * @return includes_proformas
     */
    public int getIncludes_proformas() {
        return includes_proformas;
    }


    /**
     * Sets the includes_proformas value for this ZZProcess.
     * 
     * @param includes_proformas
     */
    public void setIncludes_proformas(int includes_proformas) {
        this.includes_proformas = includes_proformas;
    }


    /**
     * Gets the inserts value for this ZZProcess.
     * 
     * @return inserts
     */
    public int getInserts() {
        return inserts;
    }


    /**
     * Sets the inserts value for this ZZProcess.
     * 
     * @param inserts
     */
    public void setInserts(int inserts) {
        this.inserts = inserts;
    }


    /**
     * Gets the installment_bills value for this ZZProcess.
     * 
     * @return installment_bills
     */
    public int getInstallment_bills() {
        return installment_bills;
    }


    /**
     * Sets the installment_bills value for this ZZProcess.
     * 
     * @param installment_bills
     */
    public void setInstallment_bills(int installment_bills) {
        this.installment_bills = installment_bills;
    }


    /**
     * Gets the interval_unit value for this ZZProcess.
     * 
     * @return interval_unit
     */
    public int getInterval_unit() {
        return interval_unit;
    }


    /**
     * Sets the interval_unit value for this ZZProcess.
     * 
     * @param interval_unit
     */
    public void setInterval_unit(int interval_unit) {
        this.interval_unit = interval_unit;
    }


    /**
     * Gets the inv_serve_label value for this ZZProcess.
     * 
     * @return inv_serve_label
     */
    public int getInv_serve_label() {
        return inv_serve_label;
    }


    /**
     * Sets the inv_serve_label value for this ZZProcess.
     * 
     * @param inv_serve_label
     */
    public void setInv_serve_label(int inv_serve_label) {
        this.inv_serve_label = inv_serve_label;
    }


    /**
     * Gets the items_per_request value for this ZZProcess.
     * 
     * @return items_per_request
     */
    public int getItems_per_request() {
        return items_per_request;
    }


    /**
     * Sets the items_per_request value for this ZZProcess.
     * 
     * @param items_per_request
     */
    public void setItems_per_request(int items_per_request) {
        this.items_per_request = items_per_request;
    }


    /**
     * Gets the job_completion_email_address value for this ZZProcess.
     * 
     * @return job_completion_email_address
     */
    public java.lang.String getJob_completion_email_address() {
        return job_completion_email_address;
    }


    /**
     * Sets the job_completion_email_address value for this ZZProcess.
     * 
     * @param job_completion_email_address
     */
    public void setJob_completion_email_address(java.lang.String job_completion_email_address) {
        this.job_completion_email_address = job_completion_email_address;
    }


    /**
     * Gets the job_done_email value for this ZZProcess.
     * 
     * @return job_done_email
     */
    public java.lang.String getJob_done_email() {
        return job_done_email;
    }


    /**
     * Sets the job_done_email value for this ZZProcess.
     * 
     * @param job_done_email
     */
    public void setJob_done_email(java.lang.String job_done_email) {
        this.job_done_email = job_done_email;
    }


    /**
     * Gets the label_group value for this ZZProcess.
     * 
     * @return label_group
     */
    public java.lang.String getLabel_group() {
        return label_group;
    }


    /**
     * Sets the label_group value for this ZZProcess.
     * 
     * @param label_group
     */
    public void setLabel_group(java.lang.String label_group) {
        this.label_group = label_group;
    }


    /**
     * Gets the label_keyline value for this ZZProcess.
     * 
     * @return label_keyline
     */
    public java.lang.String getLabel_keyline() {
        return label_keyline;
    }


    /**
     * Sets the label_keyline value for this ZZProcess.
     * 
     * @param label_keyline
     */
    public void setLabel_keyline(java.lang.String label_keyline) {
        this.label_keyline = label_keyline;
    }


    /**
     * Gets the label_length value for this ZZProcess.
     * 
     * @return label_length
     */
    public int getLabel_length() {
        return label_length;
    }


    /**
     * Sets the label_length value for this ZZProcess.
     * 
     * @param label_length
     */
    public void setLabel_length(int label_length) {
        this.label_length = label_length;
    }


    /**
     * Gets the leave_dd_account_number_plain value for this ZZProcess.
     * 
     * @return leave_dd_account_number_plain
     */
    public int getLeave_dd_account_number_plain() {
        return leave_dd_account_number_plain;
    }


    /**
     * Sets the leave_dd_account_number_plain value for this ZZProcess.
     * 
     * @param leave_dd_account_number_plain
     */
    public void setLeave_dd_account_number_plain(int leave_dd_account_number_plain) {
        this.leave_dd_account_number_plain = leave_dd_account_number_plain;
    }


    /**
     * Gets the manual_review_fulfillment value for this ZZProcess.
     * 
     * @return manual_review_fulfillment
     */
    public int getManual_review_fulfillment() {
        return manual_review_fulfillment;
    }


    /**
     * Sets the manual_review_fulfillment value for this ZZProcess.
     * 
     * @param manual_review_fulfillment
     */
    public void setManual_review_fulfillment(int manual_review_fulfillment) {
        this.manual_review_fulfillment = manual_review_fulfillment;
    }


    /**
     * Gets the mass_kill_interval value for this ZZProcess.
     * 
     * @return mass_kill_interval
     */
    public int getMass_kill_interval() {
        return mass_kill_interval;
    }


    /**
     * Sets the mass_kill_interval value for this ZZProcess.
     * 
     * @param mass_kill_interval
     */
    public void setMass_kill_interval(int mass_kill_interval) {
        this.mass_kill_interval = mass_kill_interval;
    }


    /**
     * Gets the mass_suspend_interval value for this ZZProcess.
     * 
     * @return mass_suspend_interval
     */
    public int getMass_suspend_interval() {
        return mass_suspend_interval;
    }


    /**
     * Sets the mass_suspend_interval value for this ZZProcess.
     * 
     * @param mass_suspend_interval
     */
    public void setMass_suspend_interval(int mass_suspend_interval) {
        this.mass_suspend_interval = mass_suspend_interval;
    }


    /**
     * Gets the multiple_per_customer value for this ZZProcess.
     * 
     * @return multiple_per_customer
     */
    public int getMultiple_per_customer() {
        return multiple_per_customer;
    }


    /**
     * Sets the multiple_per_customer value for this ZZProcess.
     * 
     * @param multiple_per_customer
     */
    public void setMultiple_per_customer(int multiple_per_customer) {
        this.multiple_per_customer = multiple_per_customer;
    }


    /**
     * Gets the n_interval_units value for this ZZProcess.
     * 
     * @return n_interval_units
     */
    public int getN_interval_units() {
        return n_interval_units;
    }


    /**
     * Sets the n_interval_units value for this ZZProcess.
     * 
     * @param n_interval_units
     */
    public void setN_interval_units(int n_interval_units) {
        this.n_interval_units = n_interval_units;
    }


    /**
     * Gets the no_connect_email value for this ZZProcess.
     * 
     * @return no_connect_email
     */
    public java.lang.String getNo_connect_email() {
        return no_connect_email;
    }


    /**
     * Sets the no_connect_email value for this ZZProcess.
     * 
     * @param no_connect_email
     */
    public void setNo_connect_email(java.lang.String no_connect_email) {
        this.no_connect_email = no_connect_email;
    }


    /**
     * Gets the notice_type value for this ZZProcess.
     * 
     * @return notice_type
     */
    public int getNotice_type() {
        return notice_type;
    }


    /**
     * Sets the notice_type value for this ZZProcess.
     * 
     * @param notice_type
     */
    public void setNotice_type(int notice_type) {
        this.notice_type = notice_type;
    }


    /**
     * Gets the notification_bits value for this ZZProcess.
     * 
     * @return notification_bits
     */
    public int getNotification_bits() {
        return notification_bits;
    }


    /**
     * Sets the notification_bits value for this ZZProcess.
     * 
     * @param notification_bits
     */
    public void setNotification_bits(int notification_bits) {
        this.notification_bits = notification_bits;
    }


    /**
     * Gets the nth_def value for this ZZProcess.
     * 
     * @return nth_def
     */
    public java.lang.String getNth_def() {
        return nth_def;
    }


    /**
     * Sets the nth_def value for this ZZProcess.
     * 
     * @param nth_def
     */
    public void setNth_def(java.lang.String nth_def) {
        this.nth_def = nth_def;
    }


    /**
     * Gets the oc_id value for this ZZProcess.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this ZZProcess.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the on_hold_email value for this ZZProcess.
     * 
     * @return on_hold_email
     */
    public java.lang.String getOn_hold_email() {
        return on_hold_email;
    }


    /**
     * Sets the on_hold_email value for this ZZProcess.
     * 
     * @param on_hold_email
     */
    public void setOn_hold_email(java.lang.String on_hold_email) {
        this.on_hold_email = on_hold_email;
    }


    /**
     * Gets the output_ready_email value for this ZZProcess.
     * 
     * @return output_ready_email
     */
    public java.lang.String getOutput_ready_email() {
        return output_ready_email;
    }


    /**
     * Sets the output_ready_email value for this ZZProcess.
     * 
     * @param output_ready_email
     */
    public void setOutput_ready_email(java.lang.String output_ready_email) {
        this.output_ready_email = output_ready_email;
    }


    /**
     * Gets the output_sort value for this ZZProcess.
     * 
     * @return output_sort
     */
    public java.lang.String getOutput_sort() {
        return output_sort;
    }


    /**
     * Sets the output_sort value for this ZZProcess.
     * 
     * @param output_sort
     */
    public void setOutput_sort(java.lang.String output_sort) {
        this.output_sort = output_sort;
    }


    /**
     * Gets the pick_list value for this ZZProcess.
     * 
     * @return pick_list
     */
    public int getPick_list() {
        return pick_list;
    }


    /**
     * Sets the pick_list value for this ZZProcess.
     * 
     * @param pick_list
     */
    public void setPick_list(int pick_list) {
        this.pick_list = pick_list;
    }


    /**
     * Gets the priority_sort value for this ZZProcess.
     * 
     * @return priority_sort
     */
    public java.lang.String getPriority_sort() {
        return priority_sort;
    }


    /**
     * Sets the priority_sort value for this ZZProcess.
     * 
     * @param priority_sort
     */
    public void setPriority_sort(java.lang.String priority_sort) {
        this.priority_sort = priority_sort;
    }


    /**
     * Gets the process_deposit_payment value for this ZZProcess.
     * 
     * @return process_deposit_payment
     */
    public int getProcess_deposit_payment() {
        return process_deposit_payment;
    }


    /**
     * Sets the process_deposit_payment value for this ZZProcess.
     * 
     * @param process_deposit_payment
     */
    public void setProcess_deposit_payment(int process_deposit_payment) {
        this.process_deposit_payment = process_deposit_payment;
    }


    /**
     * Gets the process_oc_type value for this ZZProcess.
     * 
     * @return process_oc_type
     */
    public int getProcess_oc_type() {
        return process_oc_type;
    }


    /**
     * Sets the process_oc_type value for this ZZProcess.
     * 
     * @param process_oc_type
     */
    public void setProcess_oc_type(int process_oc_type) {
        this.process_oc_type = process_oc_type;
    }


    /**
     * Gets the process_type value for this ZZProcess.
     * 
     * @return process_type
     */
    public int getProcess_type() {
        return process_type;
    }


    /**
     * Sets the process_type value for this ZZProcess.
     * 
     * @param process_type
     */
    public void setProcess_type(int process_type) {
        this.process_type = process_type;
    }


    /**
     * Gets the promotions value for this ZZProcess.
     * 
     * @return promotions
     */
    public int getPromotions() {
        return promotions;
    }


    /**
     * Sets the promotions value for this ZZProcess.
     * 
     * @param promotions
     */
    public void setPromotions(int promotions) {
        this.promotions = promotions;
    }


    /**
     * Gets the queue value for this ZZProcess.
     * 
     * @return queue
     */
    public java.lang.String getQueue() {
        return queue;
    }


    /**
     * Sets the queue value for this ZZProcess.
     * 
     * @param queue
     */
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }


    /**
     * Gets the recon_work_dir value for this ZZProcess.
     * 
     * @return recon_work_dir
     */
    public java.lang.String getRecon_work_dir() {
        return recon_work_dir;
    }


    /**
     * Sets the recon_work_dir value for this ZZProcess.
     * 
     * @param recon_work_dir
     */
    public void setRecon_work_dir(java.lang.String recon_work_dir) {
        this.recon_work_dir = recon_work_dir;
    }


    /**
     * Gets the ren_grp_currency value for this ZZProcess.
     * 
     * @return ren_grp_currency
     */
    public int getRen_grp_currency() {
        return ren_grp_currency;
    }


    /**
     * Sets the ren_grp_currency value for this ZZProcess.
     * 
     * @param ren_grp_currency
     */
    public void setRen_grp_currency(int ren_grp_currency) {
        this.ren_grp_currency = ren_grp_currency;
    }


    /**
     * Gets the ren_grp_def value for this ZZProcess.
     * 
     * @return ren_grp_def
     */
    public int getRen_grp_def() {
        return ren_grp_def;
    }


    /**
     * Sets the ren_grp_def value for this ZZProcess.
     * 
     * @param ren_grp_def
     */
    public void setRen_grp_def(int ren_grp_def) {
        this.ren_grp_def = ren_grp_def;
    }


    /**
     * Gets the ren_grp_oclass value for this ZZProcess.
     * 
     * @return ren_grp_oclass
     */
    public int getRen_grp_oclass() {
        return ren_grp_oclass;
    }


    /**
     * Sets the ren_grp_oclass value for this ZZProcess.
     * 
     * @param ren_grp_oclass
     */
    public void setRen_grp_oclass(int ren_grp_oclass) {
        this.ren_grp_oclass = ren_grp_oclass;
    }


    /**
     * Gets the ren_grp_order value for this ZZProcess.
     * 
     * @return ren_grp_order
     */
    public int getRen_grp_order() {
        return ren_grp_order;
    }


    /**
     * Sets the ren_grp_order value for this ZZProcess.
     * 
     * @param ren_grp_order
     */
    public void setRen_grp_order(int ren_grp_order) {
        this.ren_grp_order = ren_grp_order;
    }


    /**
     * Gets the ren_grp_ren_to value for this ZZProcess.
     * 
     * @return ren_grp_ren_to
     */
    public int getRen_grp_ren_to() {
        return ren_grp_ren_to;
    }


    /**
     * Sets the ren_grp_ren_to value for this ZZProcess.
     * 
     * @param ren_grp_ren_to
     */
    public void setRen_grp_ren_to(int ren_grp_ren_to) {
        this.ren_grp_ren_to = ren_grp_ren_to;
    }


    /**
     * Gets the renewals value for this ZZProcess.
     * 
     * @return renewals
     */
    public int getRenewals() {
        return renewals;
    }


    /**
     * Sets the renewals value for this ZZProcess.
     * 
     * @param renewals
     */
    public void setRenewals(int renewals) {
        this.renewals = renewals;
    }


    /**
     * Gets the repeating_type value for this ZZProcess.
     * 
     * @return repeating_type
     */
    public int getRepeating_type() {
        return repeating_type;
    }


    /**
     * Sets the repeating_type value for this ZZProcess.
     * 
     * @param repeating_type
     */
    public void setRepeating_type(int repeating_type) {
        this.repeating_type = repeating_type;
    }


    /**
     * Gets the requal value for this ZZProcess.
     * 
     * @return requal
     */
    public int getRequal() {
        return requal;
    }


    /**
     * Sets the requal value for this ZZProcess.
     * 
     * @param requal
     */
    public void setRequal(int requal) {
        this.requal = requal;
    }


    /**
     * Gets the resend_notice value for this ZZProcess.
     * 
     * @return resend_notice
     */
    public int getResend_notice() {
        return resend_notice;
    }


    /**
     * Sets the resend_notice value for this ZZProcess.
     * 
     * @param resend_notice
     */
    public void setResend_notice(int resend_notice) {
        this.resend_notice = resend_notice;
    }


    /**
     * Gets the review_ready_email value for this ZZProcess.
     * 
     * @return review_ready_email
     */
    public java.lang.String getReview_ready_email() {
        return review_ready_email;
    }


    /**
     * Sets the review_ready_email value for this ZZProcess.
     * 
     * @param review_ready_email
     */
    public void setReview_ready_email(java.lang.String review_ready_email) {
        this.review_ready_email = review_ready_email;
    }


    /**
     * Gets the run_icverify value for this ZZProcess.
     * 
     * @return run_icverify
     */
    public int getRun_icverify() {
        return run_icverify;
    }


    /**
     * Sets the run_icverify value for this ZZProcess.
     * 
     * @param run_icverify
     */
    public void setRun_icverify(int run_icverify) {
        this.run_icverify = run_icverify;
    }


    /**
     * Gets the schedule_payment_days value for this ZZProcess.
     * 
     * @return schedule_payment_days
     */
    public int getSchedule_payment_days() {
        return schedule_payment_days;
    }


    /**
     * Sets the schedule_payment_days value for this ZZProcess.
     * 
     * @param schedule_payment_days
     */
    public void setSchedule_payment_days(int schedule_payment_days) {
        this.schedule_payment_days = schedule_payment_days;
    }


    /**
     * Gets the skip_manual_pay_response value for this ZZProcess.
     * 
     * @return skip_manual_pay_response
     */
    public int getSkip_manual_pay_response() {
        return skip_manual_pay_response;
    }


    /**
     * Sets the skip_manual_pay_response value for this ZZProcess.
     * 
     * @param skip_manual_pay_response
     */
    public void setSkip_manual_pay_response(int skip_manual_pay_response) {
        this.skip_manual_pay_response = skip_manual_pay_response;
    }


    /**
     * Gets the splits value for this ZZProcess.
     * 
     * @return splits
     */
    public int getSplits() {
        return splits;
    }


    /**
     * Sets the splits value for this ZZProcess.
     * 
     * @param splits
     */
    public void setSplits(int splits) {
        this.splits = splits;
    }


    /**
     * Gets the sql_script value for this ZZProcess.
     * 
     * @return sql_script
     */
    public java.lang.String getSql_script() {
        return sql_script;
    }


    /**
     * Sets the sql_script value for this ZZProcess.
     * 
     * @param sql_script
     */
    public void setSql_script(java.lang.String sql_script) {
        this.sql_script = sql_script;
    }


    /**
     * Gets the unpaid_resubmit value for this ZZProcess.
     * 
     * @return unpaid_resubmit
     */
    public int getUnpaid_resubmit() {
        return unpaid_resubmit;
    }


    /**
     * Sets the unpaid_resubmit value for this ZZProcess.
     * 
     * @param unpaid_resubmit
     */
    public void setUnpaid_resubmit(int unpaid_resubmit) {
        this.unpaid_resubmit = unpaid_resubmit;
    }


    /**
     * Gets the upd_recon_tables value for this ZZProcess.
     * 
     * @return upd_recon_tables
     */
    public int getUpd_recon_tables() {
        return upd_recon_tables;
    }


    /**
     * Sets the upd_recon_tables value for this ZZProcess.
     * 
     * @param upd_recon_tables
     */
    public void setUpd_recon_tables(int upd_recon_tables) {
        this.upd_recon_tables = upd_recon_tables;
    }


    /**
     * Gets the validate_adds value for this ZZProcess.
     * 
     * @return validate_adds
     */
    public int getValidate_adds() {
        return validate_adds;
    }


    /**
     * Sets the validate_adds value for this ZZProcess.
     * 
     * @param validate_adds
     */
    public void setValidate_adds(int validate_adds) {
        this.validate_adds = validate_adds;
    }


    /**
     * Gets the volume_group_id value for this ZZProcess.
     * 
     * @return volume_group_id
     */
    public int getVolume_group_id() {
        return volume_group_id;
    }


    /**
     * Sets the volume_group_id value for this ZZProcess.
     * 
     * @param volume_group_id
     */
    public void setVolume_group_id(int volume_group_id) {
        this.volume_group_id = volume_group_id;
    }


    /**
     * Gets the warning_email value for this ZZProcess.
     * 
     * @return warning_email
     */
    public java.lang.String getWarning_email() {
        return warning_email;
    }


    /**
     * Sets the warning_email value for this ZZProcess.
     * 
     * @param warning_email
     */
    public void setWarning_email(java.lang.String warning_email) {
        this.warning_email = warning_email;
    }


    /**
     * Gets the write_recon_dtl value for this ZZProcess.
     * 
     * @return write_recon_dtl
     */
    public int getWrite_recon_dtl() {
        return write_recon_dtl;
    }


    /**
     * Sets the write_recon_dtl value for this ZZProcess.
     * 
     * @param write_recon_dtl
     */
    public void setWrite_recon_dtl(int write_recon_dtl) {
        this.write_recon_dtl = write_recon_dtl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZProcess)) return false;
        ZZProcess other = (ZZProcess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.process_id == other.getProcess_id() &&
            this.active == other.getActive() &&
            this.all_credit_cards == other.getAll_credit_cards() &&
            this.all_direct_debits == other.getAll_direct_debits() &&
            this.all_installment_plans == other.getAll_installment_plans() &&
            this.all_list_rental_categories == other.getAll_list_rental_categories() &&
            this.all_oc == other.getAll_oc() &&
            this.all_prospect_categories == other.getAll_prospect_categories() &&
            this.auddis_type == other.getAuddis_type() &&
            this.audit_paragraph_ignore_back_is == other.getAudit_paragraph_ignore_back_is() &&
            this.audit_type == other.getAudit_type() &&
            this.auto_renew_expire_days == other.getAuto_renew_expire_days() &&
            this.auto_renewals == other.getAuto_renewals() &&
            this.bank_def_id == other.getBank_def_id() &&
            ((this.batch_template==null && other.getBatch_template()==null) || 
             (this.batch_template!=null &&
              this.batch_template.equals(other.getBatch_template()))) &&
            this.bill_grp_bill_to == other.getBill_grp_bill_to() &&
            this.bill_grp_currency == other.getBill_grp_currency() &&
            this.bill_grp_def == other.getBill_grp_def() &&
            this.bill_grp_oclass == other.getBill_grp_oclass() &&
            this.bill_grp_order == other.getBill_grp_order() &&
            this.bills == other.getBills() &&
            this.bundle_threshold == other.getBundle_threshold() &&
            ((this.cancel_reason==null && other.getCancel_reason()==null) || 
             (this.cancel_reason!=null &&
              this.cancel_reason.equals(other.getCancel_reason()))) &&
            ((this.ccard_expire_days==null && other.getCcard_expire_days()==null) || 
             (this.ccard_expire_days!=null &&
              this.ccard_expire_days.equals(other.getCcard_expire_days()))) &&
            this.cleanup_events == other.getCleanup_events() &&
            this.co_mail == other.getCo_mail() &&
            this.customer_type == other.getCustomer_type() &&
            this.days_before_end == other.getDays_before_end() &&
            this.days_passed_for_pulls == other.getDays_passed_for_pulls() &&
            this.default_job_priority == other.getDefault_job_priority() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.do_mass_kill == other.getDo_mass_kill() &&
            this.do_mass_suspend == other.getDo_mass_suspend() &&
            this.driver_type == other.getDriver_type() &&
            ((this.extract==null && other.getExtract()==null) || 
             (this.extract!=null &&
              this.extract.equals(other.getExtract()))) &&
            ((this.fatal_email==null && other.getFatal_email()==null) || 
             (this.fatal_email!=null &&
              this.fatal_email.equals(other.getFatal_email()))) &&
            ((this.from_email_address==null && other.getFrom_email_address()==null) || 
             (this.from_email_address!=null &&
              this.from_email_address.equals(other.getFrom_email_address()))) &&
            this.generate_renew_offers == other.getGenerate_renew_offers() &&
            this.grace_current == other.getGrace_current() &&
            this.grace_new == other.getGrace_new() &&
            this.ics_bank_def_id == other.getIcs_bank_def_id() &&
            this.incl_audit_paragraph_reports == other.getIncl_audit_paragraph_reports() &&
            this.incl_pkg_members == other.getIncl_pkg_members() &&
            this.includes_proformas == other.getIncludes_proformas() &&
            this.inserts == other.getInserts() &&
            this.installment_bills == other.getInstallment_bills() &&
            this.interval_unit == other.getInterval_unit() &&
            this.inv_serve_label == other.getInv_serve_label() &&
            this.items_per_request == other.getItems_per_request() &&
            ((this.job_completion_email_address==null && other.getJob_completion_email_address()==null) || 
             (this.job_completion_email_address!=null &&
              this.job_completion_email_address.equals(other.getJob_completion_email_address()))) &&
            ((this.job_done_email==null && other.getJob_done_email()==null) || 
             (this.job_done_email!=null &&
              this.job_done_email.equals(other.getJob_done_email()))) &&
            ((this.label_group==null && other.getLabel_group()==null) || 
             (this.label_group!=null &&
              this.label_group.equals(other.getLabel_group()))) &&
            ((this.label_keyline==null && other.getLabel_keyline()==null) || 
             (this.label_keyline!=null &&
              this.label_keyline.equals(other.getLabel_keyline()))) &&
            this.label_length == other.getLabel_length() &&
            this.leave_dd_account_number_plain == other.getLeave_dd_account_number_plain() &&
            this.manual_review_fulfillment == other.getManual_review_fulfillment() &&
            this.mass_kill_interval == other.getMass_kill_interval() &&
            this.mass_suspend_interval == other.getMass_suspend_interval() &&
            this.multiple_per_customer == other.getMultiple_per_customer() &&
            this.n_interval_units == other.getN_interval_units() &&
            ((this.no_connect_email==null && other.getNo_connect_email()==null) || 
             (this.no_connect_email!=null &&
              this.no_connect_email.equals(other.getNo_connect_email()))) &&
            this.notice_type == other.getNotice_type() &&
            this.notification_bits == other.getNotification_bits() &&
            ((this.nth_def==null && other.getNth_def()==null) || 
             (this.nth_def!=null &&
              this.nth_def.equals(other.getNth_def()))) &&
            this.oc_id == other.getOc_id() &&
            ((this.on_hold_email==null && other.getOn_hold_email()==null) || 
             (this.on_hold_email!=null &&
              this.on_hold_email.equals(other.getOn_hold_email()))) &&
            ((this.output_ready_email==null && other.getOutput_ready_email()==null) || 
             (this.output_ready_email!=null &&
              this.output_ready_email.equals(other.getOutput_ready_email()))) &&
            ((this.output_sort==null && other.getOutput_sort()==null) || 
             (this.output_sort!=null &&
              this.output_sort.equals(other.getOutput_sort()))) &&
            this.pick_list == other.getPick_list() &&
            ((this.priority_sort==null && other.getPriority_sort()==null) || 
             (this.priority_sort!=null &&
              this.priority_sort.equals(other.getPriority_sort()))) &&
            this.process_deposit_payment == other.getProcess_deposit_payment() &&
            this.process_oc_type == other.getProcess_oc_type() &&
            this.process_type == other.getProcess_type() &&
            this.promotions == other.getPromotions() &&
            ((this.queue==null && other.getQueue()==null) || 
             (this.queue!=null &&
              this.queue.equals(other.getQueue()))) &&
            ((this.recon_work_dir==null && other.getRecon_work_dir()==null) || 
             (this.recon_work_dir!=null &&
              this.recon_work_dir.equals(other.getRecon_work_dir()))) &&
            this.ren_grp_currency == other.getRen_grp_currency() &&
            this.ren_grp_def == other.getRen_grp_def() &&
            this.ren_grp_oclass == other.getRen_grp_oclass() &&
            this.ren_grp_order == other.getRen_grp_order() &&
            this.ren_grp_ren_to == other.getRen_grp_ren_to() &&
            this.renewals == other.getRenewals() &&
            this.repeating_type == other.getRepeating_type() &&
            this.requal == other.getRequal() &&
            this.resend_notice == other.getResend_notice() &&
            ((this.review_ready_email==null && other.getReview_ready_email()==null) || 
             (this.review_ready_email!=null &&
              this.review_ready_email.equals(other.getReview_ready_email()))) &&
            this.run_icverify == other.getRun_icverify() &&
            this.schedule_payment_days == other.getSchedule_payment_days() &&
            this.skip_manual_pay_response == other.getSkip_manual_pay_response() &&
            this.splits == other.getSplits() &&
            ((this.sql_script==null && other.getSql_script()==null) || 
             (this.sql_script!=null &&
              this.sql_script.equals(other.getSql_script()))) &&
            this.unpaid_resubmit == other.getUnpaid_resubmit() &&
            this.upd_recon_tables == other.getUpd_recon_tables() &&
            this.validate_adds == other.getValidate_adds() &&
            this.volume_group_id == other.getVolume_group_id() &&
            ((this.warning_email==null && other.getWarning_email()==null) || 
             (this.warning_email!=null &&
              this.warning_email.equals(other.getWarning_email()))) &&
            this.write_recon_dtl == other.getWrite_recon_dtl();
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
        _hashCode += getProcess_id();
        _hashCode += getActive();
        _hashCode += getAll_credit_cards();
        _hashCode += getAll_direct_debits();
        _hashCode += getAll_installment_plans();
        _hashCode += getAll_list_rental_categories();
        _hashCode += getAll_oc();
        _hashCode += getAll_prospect_categories();
        _hashCode += getAuddis_type();
        _hashCode += getAudit_paragraph_ignore_back_is();
        _hashCode += getAudit_type();
        _hashCode += getAuto_renew_expire_days();
        _hashCode += getAuto_renewals();
        _hashCode += getBank_def_id();
        if (getBatch_template() != null) {
            _hashCode += getBatch_template().hashCode();
        }
        _hashCode += getBill_grp_bill_to();
        _hashCode += getBill_grp_currency();
        _hashCode += getBill_grp_def();
        _hashCode += getBill_grp_oclass();
        _hashCode += getBill_grp_order();
        _hashCode += getBills();
        _hashCode += getBundle_threshold();
        if (getCancel_reason() != null) {
            _hashCode += getCancel_reason().hashCode();
        }
        if (getCcard_expire_days() != null) {
            _hashCode += getCcard_expire_days().hashCode();
        }
        _hashCode += getCleanup_events();
        _hashCode += getCo_mail();
        _hashCode += getCustomer_type();
        _hashCode += getDays_before_end();
        _hashCode += getDays_passed_for_pulls();
        _hashCode += getDefault_job_priority();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getDo_mass_kill();
        _hashCode += getDo_mass_suspend();
        _hashCode += getDriver_type();
        if (getExtract() != null) {
            _hashCode += getExtract().hashCode();
        }
        if (getFatal_email() != null) {
            _hashCode += getFatal_email().hashCode();
        }
        if (getFrom_email_address() != null) {
            _hashCode += getFrom_email_address().hashCode();
        }
        _hashCode += getGenerate_renew_offers();
        _hashCode += getGrace_current();
        _hashCode += getGrace_new();
        _hashCode += getIcs_bank_def_id();
        _hashCode += getIncl_audit_paragraph_reports();
        _hashCode += getIncl_pkg_members();
        _hashCode += getIncludes_proformas();
        _hashCode += getInserts();
        _hashCode += getInstallment_bills();
        _hashCode += getInterval_unit();
        _hashCode += getInv_serve_label();
        _hashCode += getItems_per_request();
        if (getJob_completion_email_address() != null) {
            _hashCode += getJob_completion_email_address().hashCode();
        }
        if (getJob_done_email() != null) {
            _hashCode += getJob_done_email().hashCode();
        }
        if (getLabel_group() != null) {
            _hashCode += getLabel_group().hashCode();
        }
        if (getLabel_keyline() != null) {
            _hashCode += getLabel_keyline().hashCode();
        }
        _hashCode += getLabel_length();
        _hashCode += getLeave_dd_account_number_plain();
        _hashCode += getManual_review_fulfillment();
        _hashCode += getMass_kill_interval();
        _hashCode += getMass_suspend_interval();
        _hashCode += getMultiple_per_customer();
        _hashCode += getN_interval_units();
        if (getNo_connect_email() != null) {
            _hashCode += getNo_connect_email().hashCode();
        }
        _hashCode += getNotice_type();
        _hashCode += getNotification_bits();
        if (getNth_def() != null) {
            _hashCode += getNth_def().hashCode();
        }
        _hashCode += getOc_id();
        if (getOn_hold_email() != null) {
            _hashCode += getOn_hold_email().hashCode();
        }
        if (getOutput_ready_email() != null) {
            _hashCode += getOutput_ready_email().hashCode();
        }
        if (getOutput_sort() != null) {
            _hashCode += getOutput_sort().hashCode();
        }
        _hashCode += getPick_list();
        if (getPriority_sort() != null) {
            _hashCode += getPriority_sort().hashCode();
        }
        _hashCode += getProcess_deposit_payment();
        _hashCode += getProcess_oc_type();
        _hashCode += getProcess_type();
        _hashCode += getPromotions();
        if (getQueue() != null) {
            _hashCode += getQueue().hashCode();
        }
        if (getRecon_work_dir() != null) {
            _hashCode += getRecon_work_dir().hashCode();
        }
        _hashCode += getRen_grp_currency();
        _hashCode += getRen_grp_def();
        _hashCode += getRen_grp_oclass();
        _hashCode += getRen_grp_order();
        _hashCode += getRen_grp_ren_to();
        _hashCode += getRenewals();
        _hashCode += getRepeating_type();
        _hashCode += getRequal();
        _hashCode += getResend_notice();
        if (getReview_ready_email() != null) {
            _hashCode += getReview_ready_email().hashCode();
        }
        _hashCode += getRun_icverify();
        _hashCode += getSchedule_payment_days();
        _hashCode += getSkip_manual_pay_response();
        _hashCode += getSplits();
        if (getSql_script() != null) {
            _hashCode += getSql_script().hashCode();
        }
        _hashCode += getUnpaid_resubmit();
        _hashCode += getUpd_recon_tables();
        _hashCode += getValidate_adds();
        _hashCode += getVolume_group_id();
        if (getWarning_email() != null) {
            _hashCode += getWarning_email().hashCode();
        }
        _hashCode += getWrite_recon_dtl();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZProcess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZProcess"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("active");
        attrField.setXmlName(new javax.xml.namespace.QName("", "active"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_credit_cards");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_credit_cards"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_direct_debits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_direct_debits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_installment_plans");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_installment_plans"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_list_rental_categories");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_list_rental_categories"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_oc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_oc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("all_prospect_categories");
        attrField.setXmlName(new javax.xml.namespace.QName("", "all_prospect_categories"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auddis_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auddis_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_paragraph_ignore_back_is");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_paragraph_ignore_back_is"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_renew_expire_days");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_renew_expire_days"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_renewals");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_renewals"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bank_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bank_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("batch_template");
        attrField.setXmlName(new javax.xml.namespace.QName("", "batch_template"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_grp_bill_to");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_grp_bill_to"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_grp_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_grp_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_grp_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_grp_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_grp_oclass");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_grp_oclass"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_grp_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_grp_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bills");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bills"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bundle_threshold");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bundle_threshold"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cancel_reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cancel_reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ccard_expire_days");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ccard_expire_days"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cleanup_events");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cleanup_events"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("co_mail");
        attrField.setXmlName(new javax.xml.namespace.QName("", "co_mail"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("days_before_end");
        attrField.setXmlName(new javax.xml.namespace.QName("", "days_before_end"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("days_passed_for_pulls");
        attrField.setXmlName(new javax.xml.namespace.QName("", "days_passed_for_pulls"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_job_priority");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_job_priority"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("do_mass_kill");
        attrField.setXmlName(new javax.xml.namespace.QName("", "do_mass_kill"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("do_mass_suspend");
        attrField.setXmlName(new javax.xml.namespace.QName("", "do_mass_suspend"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("driver_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "driver_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("extract");
        attrField.setXmlName(new javax.xml.namespace.QName("", "extract"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fatal_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fatal_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_email_address");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_email_address"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("generate_renew_offers");
        attrField.setXmlName(new javax.xml.namespace.QName("", "generate_renew_offers"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("grace_current");
        attrField.setXmlName(new javax.xml.namespace.QName("", "grace_current"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("grace_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "grace_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ics_bank_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ics_bank_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("incl_audit_paragraph_reports");
        attrField.setXmlName(new javax.xml.namespace.QName("", "incl_audit_paragraph_reports"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("incl_pkg_members");
        attrField.setXmlName(new javax.xml.namespace.QName("", "incl_pkg_members"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("includes_proformas");
        attrField.setXmlName(new javax.xml.namespace.QName("", "includes_proformas"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inserts");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inserts"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_bills");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_bills"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("interval_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "interval_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inv_serve_label");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inv_serve_label"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("items_per_request");
        attrField.setXmlName(new javax.xml.namespace.QName("", "items_per_request"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_completion_email_address");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_completion_email_address"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_done_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_done_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label_keyline");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label_keyline"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("label_length");
        attrField.setXmlName(new javax.xml.namespace.QName("", "label_length"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("leave_dd_account_number_plain");
        attrField.setXmlName(new javax.xml.namespace.QName("", "leave_dd_account_number_plain"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manual_review_fulfillment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "manual_review_fulfillment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mass_kill_interval");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mass_kill_interval"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mass_suspend_interval");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mass_suspend_interval"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("multiple_per_customer");
        attrField.setXmlName(new javax.xml.namespace.QName("", "multiple_per_customer"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_interval_units");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_interval_units"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("no_connect_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "no_connect_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("notice_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "notice_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("notification_bits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "notification_bits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nth_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nth_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("on_hold_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "on_hold_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("output_ready_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "output_ready_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("output_sort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "output_sort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pick_list");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pick_list"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("priority_sort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "priority_sort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_deposit_payment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_deposit_payment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_oc_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_oc_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotions");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotions"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("queue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "queue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("recon_work_dir");
        attrField.setXmlName(new javax.xml.namespace.QName("", "recon_work_dir"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_grp_currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_grp_currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_grp_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_grp_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_grp_oclass");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_grp_oclass"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_grp_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_grp_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ren_grp_ren_to");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ren_grp_ren_to"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewals");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewals"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("repeating_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "repeating_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("requal");
        attrField.setXmlName(new javax.xml.namespace.QName("", "requal"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("resend_notice");
        attrField.setXmlName(new javax.xml.namespace.QName("", "resend_notice"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("review_ready_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "review_ready_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("run_icverify");
        attrField.setXmlName(new javax.xml.namespace.QName("", "run_icverify"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("schedule_payment_days");
        attrField.setXmlName(new javax.xml.namespace.QName("", "schedule_payment_days"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("skip_manual_pay_response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "skip_manual_pay_response"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("splits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "splits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sql_script");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sql_script"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unpaid_resubmit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unpaid_resubmit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("upd_recon_tables");
        attrField.setXmlName(new javax.xml.namespace.QName("", "upd_recon_tables"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("validate_adds");
        attrField.setXmlName(new javax.xml.namespace.QName("", "validate_adds"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_group_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_group_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("warning_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "warning_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("write_recon_dtl");
        attrField.setXmlName(new javax.xml.namespace.QName("", "write_recon_dtl"));
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
