/**
 * Pub_select_responsePub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Pub_select_responsePub  implements java.io.Serializable {
    private int oc_id;  // attribute

    private java.lang.String issn;  // attribute

    private java.lang.String inherited_from;  // attribute

    private java.lang.String converted_to;  // attribute

    private int start_type;  // attribute

    private int audited;  // attribute

    private int qp_sub_type_required;  // attribute

    private int qp_qual_source_required;  // attribute

    private int qp_name_title_required;  // attribute

    private int qp_sales_channel_required;  // attribute

    private int qp_max_backstarts_on_new;  // attribute

    private int qp_max_backissues_on_reinst;  // attribute

    private int qp_backissues_on_reinst;  // attribute

    private int qf_sub_type_required;  // attribute

    private int qf_qual_source_required;  // attribute

    private int qf_name_title_required;  // attribute

    private int qf_sales_channel_required;  // attribute

    private int qf_max_backstarts_on_new;  // attribute

    private int qf_max_backissues_on_reinst;  // attribute

    private int qf_backissues_on_reinst;  // attribute

    private int nqp_sub_type_required;  // attribute

    private int nqp_qual_source_required;  // attribute

    private int nqp_name_title_required;  // attribute

    private int nqp_sales_channel_required;  // attribute

    private int nqp_max_backstarts_on_new;  // attribute

    private int nqp_max_backissues_on_reinst;  // attribute

    private int nqp_backissues_on_reinst;  // attribute

    private int nqf_sub_type_required;  // attribute

    private int nqf_qual_source_required;  // attribute

    private int nqf_name_title_required;  // attribute

    private int nqf_sales_channel_required;  // attribute

    private int nqf_max_backstarts_on_new;  // attribute

    private int nqf_max_backissues_on_reinst;  // attribute

    private int nqf_backissues_on_reinst;  // attribute

    private int n_issues;  // attribute

    private int n_calendar_units;  // attribute

    private int calendar_unit;  // attribute

    private java.lang.String on_string;  // attribute

    private int on_calendar_unit;  // attribute

    private int on_day;  // attribute

    private java.lang.String volume_caption;  // attribute

    private int volume_format;  // attribute

    private java.lang.String volume_change_date;  // attribute

    private java.lang.String issue_caption;  // attribute

    private int issue_format;  // attribute

    private int issue_continuous;  // attribute

    private int n_issues_per_volume;  // attribute

    private int start_date_type_anytime;  // attribute

    private int backstart_n_issues_anytime;  // attribute

    private int start_date_type_volume_group;  // attribute

    private int unit_audits;  // attribute

    private java.math.BigDecimal annual_rate;  // attribute

    private java.lang.String region_list;  // attribute

    private java.lang.String sales_channel_pub_group;  // attribute

    private java.lang.String name_title_pub_group;  // attribute

    private java.lang.String qual_source_pub_group;  // attribute

    private java.lang.String sub_type_pub_group;  // attribute

    private int add_kill_report;  // attribute

    private int qp;  // attribute

    private int qf;  // attribute

    private int nqp;  // attribute

    private int nqf;  // attribute

    private java.lang.String duration_pub_group;  // attribute

    private java.lang.String price_pub_group;  // attribute

    private java.lang.String demog_pub_group;  // attribute

    private int qp_prompt_for_backissues;  // attribute

    private int qf_prompt_for_backissues;  // attribute

    private int nqp_prompt_for_backissues;  // attribute

    private int nqf_prompt_for_backissues;  // attribute

    private int no_spaces_in_enumeration;  // attribute

    private int accrual_time_unit;  // attribute

    private int accrual_time;  // attribute

    private int revenue_method;  // attribute

    private int start_date_type_date_based;  // attribute

    private int start_n_days_date_based;  // attribute

    private int suppress_enumeration;  // attribute

    private int max_qual_date_age;  // attribute

    public Pub_select_responsePub() {
    }

    public Pub_select_responsePub(
           int oc_id,
           java.lang.String issn,
           java.lang.String inherited_from,
           java.lang.String converted_to,
           int start_type,
           int audited,
           int qp_sub_type_required,
           int qp_qual_source_required,
           int qp_name_title_required,
           int qp_sales_channel_required,
           int qp_max_backstarts_on_new,
           int qp_max_backissues_on_reinst,
           int qp_backissues_on_reinst,
           int qf_sub_type_required,
           int qf_qual_source_required,
           int qf_name_title_required,
           int qf_sales_channel_required,
           int qf_max_backstarts_on_new,
           int qf_max_backissues_on_reinst,
           int qf_backissues_on_reinst,
           int nqp_sub_type_required,
           int nqp_qual_source_required,
           int nqp_name_title_required,
           int nqp_sales_channel_required,
           int nqp_max_backstarts_on_new,
           int nqp_max_backissues_on_reinst,
           int nqp_backissues_on_reinst,
           int nqf_sub_type_required,
           int nqf_qual_source_required,
           int nqf_name_title_required,
           int nqf_sales_channel_required,
           int nqf_max_backstarts_on_new,
           int nqf_max_backissues_on_reinst,
           int nqf_backissues_on_reinst,
           int n_issues,
           int n_calendar_units,
           int calendar_unit,
           java.lang.String on_string,
           int on_calendar_unit,
           int on_day,
           java.lang.String volume_caption,
           int volume_format,
           java.lang.String volume_change_date,
           java.lang.String issue_caption,
           int issue_format,
           int issue_continuous,
           int n_issues_per_volume,
           int start_date_type_anytime,
           int backstart_n_issues_anytime,
           int start_date_type_volume_group,
           int unit_audits,
           java.math.BigDecimal annual_rate,
           java.lang.String region_list,
           java.lang.String sales_channel_pub_group,
           java.lang.String name_title_pub_group,
           java.lang.String qual_source_pub_group,
           java.lang.String sub_type_pub_group,
           int add_kill_report,
           int qp,
           int qf,
           int nqp,
           int nqf,
           java.lang.String duration_pub_group,
           java.lang.String price_pub_group,
           java.lang.String demog_pub_group,
           int qp_prompt_for_backissues,
           int qf_prompt_for_backissues,
           int nqp_prompt_for_backissues,
           int nqf_prompt_for_backissues,
           int no_spaces_in_enumeration,
           int accrual_time_unit,
           int accrual_time,
           int revenue_method,
           int start_date_type_date_based,
           int start_n_days_date_based,
           int suppress_enumeration,
           int max_qual_date_age) {
           this.oc_id = oc_id;
           this.issn = issn;
           this.inherited_from = inherited_from;
           this.converted_to = converted_to;
           this.start_type = start_type;
           this.audited = audited;
           this.qp_sub_type_required = qp_sub_type_required;
           this.qp_qual_source_required = qp_qual_source_required;
           this.qp_name_title_required = qp_name_title_required;
           this.qp_sales_channel_required = qp_sales_channel_required;
           this.qp_max_backstarts_on_new = qp_max_backstarts_on_new;
           this.qp_max_backissues_on_reinst = qp_max_backissues_on_reinst;
           this.qp_backissues_on_reinst = qp_backissues_on_reinst;
           this.qf_sub_type_required = qf_sub_type_required;
           this.qf_qual_source_required = qf_qual_source_required;
           this.qf_name_title_required = qf_name_title_required;
           this.qf_sales_channel_required = qf_sales_channel_required;
           this.qf_max_backstarts_on_new = qf_max_backstarts_on_new;
           this.qf_max_backissues_on_reinst = qf_max_backissues_on_reinst;
           this.qf_backissues_on_reinst = qf_backissues_on_reinst;
           this.nqp_sub_type_required = nqp_sub_type_required;
           this.nqp_qual_source_required = nqp_qual_source_required;
           this.nqp_name_title_required = nqp_name_title_required;
           this.nqp_sales_channel_required = nqp_sales_channel_required;
           this.nqp_max_backstarts_on_new = nqp_max_backstarts_on_new;
           this.nqp_max_backissues_on_reinst = nqp_max_backissues_on_reinst;
           this.nqp_backissues_on_reinst = nqp_backissues_on_reinst;
           this.nqf_sub_type_required = nqf_sub_type_required;
           this.nqf_qual_source_required = nqf_qual_source_required;
           this.nqf_name_title_required = nqf_name_title_required;
           this.nqf_sales_channel_required = nqf_sales_channel_required;
           this.nqf_max_backstarts_on_new = nqf_max_backstarts_on_new;
           this.nqf_max_backissues_on_reinst = nqf_max_backissues_on_reinst;
           this.nqf_backissues_on_reinst = nqf_backissues_on_reinst;
           this.n_issues = n_issues;
           this.n_calendar_units = n_calendar_units;
           this.calendar_unit = calendar_unit;
           this.on_string = on_string;
           this.on_calendar_unit = on_calendar_unit;
           this.on_day = on_day;
           this.volume_caption = volume_caption;
           this.volume_format = volume_format;
           this.volume_change_date = volume_change_date;
           this.issue_caption = issue_caption;
           this.issue_format = issue_format;
           this.issue_continuous = issue_continuous;
           this.n_issues_per_volume = n_issues_per_volume;
           this.start_date_type_anytime = start_date_type_anytime;
           this.backstart_n_issues_anytime = backstart_n_issues_anytime;
           this.start_date_type_volume_group = start_date_type_volume_group;
           this.unit_audits = unit_audits;
           this.annual_rate = annual_rate;
           this.region_list = region_list;
           this.sales_channel_pub_group = sales_channel_pub_group;
           this.name_title_pub_group = name_title_pub_group;
           this.qual_source_pub_group = qual_source_pub_group;
           this.sub_type_pub_group = sub_type_pub_group;
           this.add_kill_report = add_kill_report;
           this.qp = qp;
           this.qf = qf;
           this.nqp = nqp;
           this.nqf = nqf;
           this.duration_pub_group = duration_pub_group;
           this.price_pub_group = price_pub_group;
           this.demog_pub_group = demog_pub_group;
           this.qp_prompt_for_backissues = qp_prompt_for_backissues;
           this.qf_prompt_for_backissues = qf_prompt_for_backissues;
           this.nqp_prompt_for_backissues = nqp_prompt_for_backissues;
           this.nqf_prompt_for_backissues = nqf_prompt_for_backissues;
           this.no_spaces_in_enumeration = no_spaces_in_enumeration;
           this.accrual_time_unit = accrual_time_unit;
           this.accrual_time = accrual_time;
           this.revenue_method = revenue_method;
           this.start_date_type_date_based = start_date_type_date_based;
           this.start_n_days_date_based = start_n_days_date_based;
           this.suppress_enumeration = suppress_enumeration;
           this.max_qual_date_age = max_qual_date_age;
    }


    /**
     * Gets the oc_id value for this Pub_select_responsePub.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Pub_select_responsePub.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the issn value for this Pub_select_responsePub.
     * 
     * @return issn
     */
    public java.lang.String getIssn() {
        return issn;
    }


    /**
     * Sets the issn value for this Pub_select_responsePub.
     * 
     * @param issn
     */
    public void setIssn(java.lang.String issn) {
        this.issn = issn;
    }


    /**
     * Gets the inherited_from value for this Pub_select_responsePub.
     * 
     * @return inherited_from
     */
    public java.lang.String getInherited_from() {
        return inherited_from;
    }


    /**
     * Sets the inherited_from value for this Pub_select_responsePub.
     * 
     * @param inherited_from
     */
    public void setInherited_from(java.lang.String inherited_from) {
        this.inherited_from = inherited_from;
    }


    /**
     * Gets the converted_to value for this Pub_select_responsePub.
     * 
     * @return converted_to
     */
    public java.lang.String getConverted_to() {
        return converted_to;
    }


    /**
     * Sets the converted_to value for this Pub_select_responsePub.
     * 
     * @param converted_to
     */
    public void setConverted_to(java.lang.String converted_to) {
        this.converted_to = converted_to;
    }


    /**
     * Gets the start_type value for this Pub_select_responsePub.
     * 
     * @return start_type
     */
    public int getStart_type() {
        return start_type;
    }


    /**
     * Sets the start_type value for this Pub_select_responsePub.
     * 
     * @param start_type
     */
    public void setStart_type(int start_type) {
        this.start_type = start_type;
    }


    /**
     * Gets the audited value for this Pub_select_responsePub.
     * 
     * @return audited
     */
    public int getAudited() {
        return audited;
    }


    /**
     * Sets the audited value for this Pub_select_responsePub.
     * 
     * @param audited
     */
    public void setAudited(int audited) {
        this.audited = audited;
    }


    /**
     * Gets the qp_sub_type_required value for this Pub_select_responsePub.
     * 
     * @return qp_sub_type_required
     */
    public int getQp_sub_type_required() {
        return qp_sub_type_required;
    }


    /**
     * Sets the qp_sub_type_required value for this Pub_select_responsePub.
     * 
     * @param qp_sub_type_required
     */
    public void setQp_sub_type_required(int qp_sub_type_required) {
        this.qp_sub_type_required = qp_sub_type_required;
    }


    /**
     * Gets the qp_qual_source_required value for this Pub_select_responsePub.
     * 
     * @return qp_qual_source_required
     */
    public int getQp_qual_source_required() {
        return qp_qual_source_required;
    }


    /**
     * Sets the qp_qual_source_required value for this Pub_select_responsePub.
     * 
     * @param qp_qual_source_required
     */
    public void setQp_qual_source_required(int qp_qual_source_required) {
        this.qp_qual_source_required = qp_qual_source_required;
    }


    /**
     * Gets the qp_name_title_required value for this Pub_select_responsePub.
     * 
     * @return qp_name_title_required
     */
    public int getQp_name_title_required() {
        return qp_name_title_required;
    }


    /**
     * Sets the qp_name_title_required value for this Pub_select_responsePub.
     * 
     * @param qp_name_title_required
     */
    public void setQp_name_title_required(int qp_name_title_required) {
        this.qp_name_title_required = qp_name_title_required;
    }


    /**
     * Gets the qp_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @return qp_sales_channel_required
     */
    public int getQp_sales_channel_required() {
        return qp_sales_channel_required;
    }


    /**
     * Sets the qp_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @param qp_sales_channel_required
     */
    public void setQp_sales_channel_required(int qp_sales_channel_required) {
        this.qp_sales_channel_required = qp_sales_channel_required;
    }


    /**
     * Gets the qp_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @return qp_max_backstarts_on_new
     */
    public int getQp_max_backstarts_on_new() {
        return qp_max_backstarts_on_new;
    }


    /**
     * Sets the qp_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @param qp_max_backstarts_on_new
     */
    public void setQp_max_backstarts_on_new(int qp_max_backstarts_on_new) {
        this.qp_max_backstarts_on_new = qp_max_backstarts_on_new;
    }


    /**
     * Gets the qp_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return qp_max_backissues_on_reinst
     */
    public int getQp_max_backissues_on_reinst() {
        return qp_max_backissues_on_reinst;
    }


    /**
     * Sets the qp_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param qp_max_backissues_on_reinst
     */
    public void setQp_max_backissues_on_reinst(int qp_max_backissues_on_reinst) {
        this.qp_max_backissues_on_reinst = qp_max_backissues_on_reinst;
    }


    /**
     * Gets the qp_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return qp_backissues_on_reinst
     */
    public int getQp_backissues_on_reinst() {
        return qp_backissues_on_reinst;
    }


    /**
     * Sets the qp_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param qp_backissues_on_reinst
     */
    public void setQp_backissues_on_reinst(int qp_backissues_on_reinst) {
        this.qp_backissues_on_reinst = qp_backissues_on_reinst;
    }


    /**
     * Gets the qf_sub_type_required value for this Pub_select_responsePub.
     * 
     * @return qf_sub_type_required
     */
    public int getQf_sub_type_required() {
        return qf_sub_type_required;
    }


    /**
     * Sets the qf_sub_type_required value for this Pub_select_responsePub.
     * 
     * @param qf_sub_type_required
     */
    public void setQf_sub_type_required(int qf_sub_type_required) {
        this.qf_sub_type_required = qf_sub_type_required;
    }


    /**
     * Gets the qf_qual_source_required value for this Pub_select_responsePub.
     * 
     * @return qf_qual_source_required
     */
    public int getQf_qual_source_required() {
        return qf_qual_source_required;
    }


    /**
     * Sets the qf_qual_source_required value for this Pub_select_responsePub.
     * 
     * @param qf_qual_source_required
     */
    public void setQf_qual_source_required(int qf_qual_source_required) {
        this.qf_qual_source_required = qf_qual_source_required;
    }


    /**
     * Gets the qf_name_title_required value for this Pub_select_responsePub.
     * 
     * @return qf_name_title_required
     */
    public int getQf_name_title_required() {
        return qf_name_title_required;
    }


    /**
     * Sets the qf_name_title_required value for this Pub_select_responsePub.
     * 
     * @param qf_name_title_required
     */
    public void setQf_name_title_required(int qf_name_title_required) {
        this.qf_name_title_required = qf_name_title_required;
    }


    /**
     * Gets the qf_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @return qf_sales_channel_required
     */
    public int getQf_sales_channel_required() {
        return qf_sales_channel_required;
    }


    /**
     * Sets the qf_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @param qf_sales_channel_required
     */
    public void setQf_sales_channel_required(int qf_sales_channel_required) {
        this.qf_sales_channel_required = qf_sales_channel_required;
    }


    /**
     * Gets the qf_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @return qf_max_backstarts_on_new
     */
    public int getQf_max_backstarts_on_new() {
        return qf_max_backstarts_on_new;
    }


    /**
     * Sets the qf_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @param qf_max_backstarts_on_new
     */
    public void setQf_max_backstarts_on_new(int qf_max_backstarts_on_new) {
        this.qf_max_backstarts_on_new = qf_max_backstarts_on_new;
    }


    /**
     * Gets the qf_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return qf_max_backissues_on_reinst
     */
    public int getQf_max_backissues_on_reinst() {
        return qf_max_backissues_on_reinst;
    }


    /**
     * Sets the qf_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param qf_max_backissues_on_reinst
     */
    public void setQf_max_backissues_on_reinst(int qf_max_backissues_on_reinst) {
        this.qf_max_backissues_on_reinst = qf_max_backissues_on_reinst;
    }


    /**
     * Gets the qf_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return qf_backissues_on_reinst
     */
    public int getQf_backissues_on_reinst() {
        return qf_backissues_on_reinst;
    }


    /**
     * Sets the qf_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param qf_backissues_on_reinst
     */
    public void setQf_backissues_on_reinst(int qf_backissues_on_reinst) {
        this.qf_backissues_on_reinst = qf_backissues_on_reinst;
    }


    /**
     * Gets the nqp_sub_type_required value for this Pub_select_responsePub.
     * 
     * @return nqp_sub_type_required
     */
    public int getNqp_sub_type_required() {
        return nqp_sub_type_required;
    }


    /**
     * Sets the nqp_sub_type_required value for this Pub_select_responsePub.
     * 
     * @param nqp_sub_type_required
     */
    public void setNqp_sub_type_required(int nqp_sub_type_required) {
        this.nqp_sub_type_required = nqp_sub_type_required;
    }


    /**
     * Gets the nqp_qual_source_required value for this Pub_select_responsePub.
     * 
     * @return nqp_qual_source_required
     */
    public int getNqp_qual_source_required() {
        return nqp_qual_source_required;
    }


    /**
     * Sets the nqp_qual_source_required value for this Pub_select_responsePub.
     * 
     * @param nqp_qual_source_required
     */
    public void setNqp_qual_source_required(int nqp_qual_source_required) {
        this.nqp_qual_source_required = nqp_qual_source_required;
    }


    /**
     * Gets the nqp_name_title_required value for this Pub_select_responsePub.
     * 
     * @return nqp_name_title_required
     */
    public int getNqp_name_title_required() {
        return nqp_name_title_required;
    }


    /**
     * Sets the nqp_name_title_required value for this Pub_select_responsePub.
     * 
     * @param nqp_name_title_required
     */
    public void setNqp_name_title_required(int nqp_name_title_required) {
        this.nqp_name_title_required = nqp_name_title_required;
    }


    /**
     * Gets the nqp_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @return nqp_sales_channel_required
     */
    public int getNqp_sales_channel_required() {
        return nqp_sales_channel_required;
    }


    /**
     * Sets the nqp_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @param nqp_sales_channel_required
     */
    public void setNqp_sales_channel_required(int nqp_sales_channel_required) {
        this.nqp_sales_channel_required = nqp_sales_channel_required;
    }


    /**
     * Gets the nqp_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @return nqp_max_backstarts_on_new
     */
    public int getNqp_max_backstarts_on_new() {
        return nqp_max_backstarts_on_new;
    }


    /**
     * Sets the nqp_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @param nqp_max_backstarts_on_new
     */
    public void setNqp_max_backstarts_on_new(int nqp_max_backstarts_on_new) {
        this.nqp_max_backstarts_on_new = nqp_max_backstarts_on_new;
    }


    /**
     * Gets the nqp_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return nqp_max_backissues_on_reinst
     */
    public int getNqp_max_backissues_on_reinst() {
        return nqp_max_backissues_on_reinst;
    }


    /**
     * Sets the nqp_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param nqp_max_backissues_on_reinst
     */
    public void setNqp_max_backissues_on_reinst(int nqp_max_backissues_on_reinst) {
        this.nqp_max_backissues_on_reinst = nqp_max_backissues_on_reinst;
    }


    /**
     * Gets the nqp_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return nqp_backissues_on_reinst
     */
    public int getNqp_backissues_on_reinst() {
        return nqp_backissues_on_reinst;
    }


    /**
     * Sets the nqp_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param nqp_backissues_on_reinst
     */
    public void setNqp_backissues_on_reinst(int nqp_backissues_on_reinst) {
        this.nqp_backissues_on_reinst = nqp_backissues_on_reinst;
    }


    /**
     * Gets the nqf_sub_type_required value for this Pub_select_responsePub.
     * 
     * @return nqf_sub_type_required
     */
    public int getNqf_sub_type_required() {
        return nqf_sub_type_required;
    }


    /**
     * Sets the nqf_sub_type_required value for this Pub_select_responsePub.
     * 
     * @param nqf_sub_type_required
     */
    public void setNqf_sub_type_required(int nqf_sub_type_required) {
        this.nqf_sub_type_required = nqf_sub_type_required;
    }


    /**
     * Gets the nqf_qual_source_required value for this Pub_select_responsePub.
     * 
     * @return nqf_qual_source_required
     */
    public int getNqf_qual_source_required() {
        return nqf_qual_source_required;
    }


    /**
     * Sets the nqf_qual_source_required value for this Pub_select_responsePub.
     * 
     * @param nqf_qual_source_required
     */
    public void setNqf_qual_source_required(int nqf_qual_source_required) {
        this.nqf_qual_source_required = nqf_qual_source_required;
    }


    /**
     * Gets the nqf_name_title_required value for this Pub_select_responsePub.
     * 
     * @return nqf_name_title_required
     */
    public int getNqf_name_title_required() {
        return nqf_name_title_required;
    }


    /**
     * Sets the nqf_name_title_required value for this Pub_select_responsePub.
     * 
     * @param nqf_name_title_required
     */
    public void setNqf_name_title_required(int nqf_name_title_required) {
        this.nqf_name_title_required = nqf_name_title_required;
    }


    /**
     * Gets the nqf_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @return nqf_sales_channel_required
     */
    public int getNqf_sales_channel_required() {
        return nqf_sales_channel_required;
    }


    /**
     * Sets the nqf_sales_channel_required value for this Pub_select_responsePub.
     * 
     * @param nqf_sales_channel_required
     */
    public void setNqf_sales_channel_required(int nqf_sales_channel_required) {
        this.nqf_sales_channel_required = nqf_sales_channel_required;
    }


    /**
     * Gets the nqf_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @return nqf_max_backstarts_on_new
     */
    public int getNqf_max_backstarts_on_new() {
        return nqf_max_backstarts_on_new;
    }


    /**
     * Sets the nqf_max_backstarts_on_new value for this Pub_select_responsePub.
     * 
     * @param nqf_max_backstarts_on_new
     */
    public void setNqf_max_backstarts_on_new(int nqf_max_backstarts_on_new) {
        this.nqf_max_backstarts_on_new = nqf_max_backstarts_on_new;
    }


    /**
     * Gets the nqf_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return nqf_max_backissues_on_reinst
     */
    public int getNqf_max_backissues_on_reinst() {
        return nqf_max_backissues_on_reinst;
    }


    /**
     * Sets the nqf_max_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param nqf_max_backissues_on_reinst
     */
    public void setNqf_max_backissues_on_reinst(int nqf_max_backissues_on_reinst) {
        this.nqf_max_backissues_on_reinst = nqf_max_backissues_on_reinst;
    }


    /**
     * Gets the nqf_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @return nqf_backissues_on_reinst
     */
    public int getNqf_backissues_on_reinst() {
        return nqf_backissues_on_reinst;
    }


    /**
     * Sets the nqf_backissues_on_reinst value for this Pub_select_responsePub.
     * 
     * @param nqf_backissues_on_reinst
     */
    public void setNqf_backissues_on_reinst(int nqf_backissues_on_reinst) {
        this.nqf_backissues_on_reinst = nqf_backissues_on_reinst;
    }


    /**
     * Gets the n_issues value for this Pub_select_responsePub.
     * 
     * @return n_issues
     */
    public int getN_issues() {
        return n_issues;
    }


    /**
     * Sets the n_issues value for this Pub_select_responsePub.
     * 
     * @param n_issues
     */
    public void setN_issues(int n_issues) {
        this.n_issues = n_issues;
    }


    /**
     * Gets the n_calendar_units value for this Pub_select_responsePub.
     * 
     * @return n_calendar_units
     */
    public int getN_calendar_units() {
        return n_calendar_units;
    }


    /**
     * Sets the n_calendar_units value for this Pub_select_responsePub.
     * 
     * @param n_calendar_units
     */
    public void setN_calendar_units(int n_calendar_units) {
        this.n_calendar_units = n_calendar_units;
    }


    /**
     * Gets the calendar_unit value for this Pub_select_responsePub.
     * 
     * @return calendar_unit
     */
    public int getCalendar_unit() {
        return calendar_unit;
    }


    /**
     * Sets the calendar_unit value for this Pub_select_responsePub.
     * 
     * @param calendar_unit
     */
    public void setCalendar_unit(int calendar_unit) {
        this.calendar_unit = calendar_unit;
    }


    /**
     * Gets the on_string value for this Pub_select_responsePub.
     * 
     * @return on_string
     */
    public java.lang.String getOn_string() {
        return on_string;
    }


    /**
     * Sets the on_string value for this Pub_select_responsePub.
     * 
     * @param on_string
     */
    public void setOn_string(java.lang.String on_string) {
        this.on_string = on_string;
    }


    /**
     * Gets the on_calendar_unit value for this Pub_select_responsePub.
     * 
     * @return on_calendar_unit
     */
    public int getOn_calendar_unit() {
        return on_calendar_unit;
    }


    /**
     * Sets the on_calendar_unit value for this Pub_select_responsePub.
     * 
     * @param on_calendar_unit
     */
    public void setOn_calendar_unit(int on_calendar_unit) {
        this.on_calendar_unit = on_calendar_unit;
    }


    /**
     * Gets the on_day value for this Pub_select_responsePub.
     * 
     * @return on_day
     */
    public int getOn_day() {
        return on_day;
    }


    /**
     * Sets the on_day value for this Pub_select_responsePub.
     * 
     * @param on_day
     */
    public void setOn_day(int on_day) {
        this.on_day = on_day;
    }


    /**
     * Gets the volume_caption value for this Pub_select_responsePub.
     * 
     * @return volume_caption
     */
    public java.lang.String getVolume_caption() {
        return volume_caption;
    }


    /**
     * Sets the volume_caption value for this Pub_select_responsePub.
     * 
     * @param volume_caption
     */
    public void setVolume_caption(java.lang.String volume_caption) {
        this.volume_caption = volume_caption;
    }


    /**
     * Gets the volume_format value for this Pub_select_responsePub.
     * 
     * @return volume_format
     */
    public int getVolume_format() {
        return volume_format;
    }


    /**
     * Sets the volume_format value for this Pub_select_responsePub.
     * 
     * @param volume_format
     */
    public void setVolume_format(int volume_format) {
        this.volume_format = volume_format;
    }


    /**
     * Gets the volume_change_date value for this Pub_select_responsePub.
     * 
     * @return volume_change_date
     */
    public java.lang.String getVolume_change_date() {
        return volume_change_date;
    }


    /**
     * Sets the volume_change_date value for this Pub_select_responsePub.
     * 
     * @param volume_change_date
     */
    public void setVolume_change_date(java.lang.String volume_change_date) {
        this.volume_change_date = volume_change_date;
    }


    /**
     * Gets the issue_caption value for this Pub_select_responsePub.
     * 
     * @return issue_caption
     */
    public java.lang.String getIssue_caption() {
        return issue_caption;
    }


    /**
     * Sets the issue_caption value for this Pub_select_responsePub.
     * 
     * @param issue_caption
     */
    public void setIssue_caption(java.lang.String issue_caption) {
        this.issue_caption = issue_caption;
    }


    /**
     * Gets the issue_format value for this Pub_select_responsePub.
     * 
     * @return issue_format
     */
    public int getIssue_format() {
        return issue_format;
    }


    /**
     * Sets the issue_format value for this Pub_select_responsePub.
     * 
     * @param issue_format
     */
    public void setIssue_format(int issue_format) {
        this.issue_format = issue_format;
    }


    /**
     * Gets the issue_continuous value for this Pub_select_responsePub.
     * 
     * @return issue_continuous
     */
    public int getIssue_continuous() {
        return issue_continuous;
    }


    /**
     * Sets the issue_continuous value for this Pub_select_responsePub.
     * 
     * @param issue_continuous
     */
    public void setIssue_continuous(int issue_continuous) {
        this.issue_continuous = issue_continuous;
    }


    /**
     * Gets the n_issues_per_volume value for this Pub_select_responsePub.
     * 
     * @return n_issues_per_volume
     */
    public int getN_issues_per_volume() {
        return n_issues_per_volume;
    }


    /**
     * Sets the n_issues_per_volume value for this Pub_select_responsePub.
     * 
     * @param n_issues_per_volume
     */
    public void setN_issues_per_volume(int n_issues_per_volume) {
        this.n_issues_per_volume = n_issues_per_volume;
    }


    /**
     * Gets the start_date_type_anytime value for this Pub_select_responsePub.
     * 
     * @return start_date_type_anytime
     */
    public int getStart_date_type_anytime() {
        return start_date_type_anytime;
    }


    /**
     * Sets the start_date_type_anytime value for this Pub_select_responsePub.
     * 
     * @param start_date_type_anytime
     */
    public void setStart_date_type_anytime(int start_date_type_anytime) {
        this.start_date_type_anytime = start_date_type_anytime;
    }


    /**
     * Gets the backstart_n_issues_anytime value for this Pub_select_responsePub.
     * 
     * @return backstart_n_issues_anytime
     */
    public int getBackstart_n_issues_anytime() {
        return backstart_n_issues_anytime;
    }


    /**
     * Sets the backstart_n_issues_anytime value for this Pub_select_responsePub.
     * 
     * @param backstart_n_issues_anytime
     */
    public void setBackstart_n_issues_anytime(int backstart_n_issues_anytime) {
        this.backstart_n_issues_anytime = backstart_n_issues_anytime;
    }


    /**
     * Gets the start_date_type_volume_group value for this Pub_select_responsePub.
     * 
     * @return start_date_type_volume_group
     */
    public int getStart_date_type_volume_group() {
        return start_date_type_volume_group;
    }


    /**
     * Sets the start_date_type_volume_group value for this Pub_select_responsePub.
     * 
     * @param start_date_type_volume_group
     */
    public void setStart_date_type_volume_group(int start_date_type_volume_group) {
        this.start_date_type_volume_group = start_date_type_volume_group;
    }


    /**
     * Gets the unit_audits value for this Pub_select_responsePub.
     * 
     * @return unit_audits
     */
    public int getUnit_audits() {
        return unit_audits;
    }


    /**
     * Sets the unit_audits value for this Pub_select_responsePub.
     * 
     * @param unit_audits
     */
    public void setUnit_audits(int unit_audits) {
        this.unit_audits = unit_audits;
    }


    /**
     * Gets the annual_rate value for this Pub_select_responsePub.
     * 
     * @return annual_rate
     */
    public java.math.BigDecimal getAnnual_rate() {
        return annual_rate;
    }


    /**
     * Sets the annual_rate value for this Pub_select_responsePub.
     * 
     * @param annual_rate
     */
    public void setAnnual_rate(java.math.BigDecimal annual_rate) {
        this.annual_rate = annual_rate;
    }


    /**
     * Gets the region_list value for this Pub_select_responsePub.
     * 
     * @return region_list
     */
    public java.lang.String getRegion_list() {
        return region_list;
    }


    /**
     * Sets the region_list value for this Pub_select_responsePub.
     * 
     * @param region_list
     */
    public void setRegion_list(java.lang.String region_list) {
        this.region_list = region_list;
    }


    /**
     * Gets the sales_channel_pub_group value for this Pub_select_responsePub.
     * 
     * @return sales_channel_pub_group
     */
    public java.lang.String getSales_channel_pub_group() {
        return sales_channel_pub_group;
    }


    /**
     * Sets the sales_channel_pub_group value for this Pub_select_responsePub.
     * 
     * @param sales_channel_pub_group
     */
    public void setSales_channel_pub_group(java.lang.String sales_channel_pub_group) {
        this.sales_channel_pub_group = sales_channel_pub_group;
    }


    /**
     * Gets the name_title_pub_group value for this Pub_select_responsePub.
     * 
     * @return name_title_pub_group
     */
    public java.lang.String getName_title_pub_group() {
        return name_title_pub_group;
    }


    /**
     * Sets the name_title_pub_group value for this Pub_select_responsePub.
     * 
     * @param name_title_pub_group
     */
    public void setName_title_pub_group(java.lang.String name_title_pub_group) {
        this.name_title_pub_group = name_title_pub_group;
    }


    /**
     * Gets the qual_source_pub_group value for this Pub_select_responsePub.
     * 
     * @return qual_source_pub_group
     */
    public java.lang.String getQual_source_pub_group() {
        return qual_source_pub_group;
    }


    /**
     * Sets the qual_source_pub_group value for this Pub_select_responsePub.
     * 
     * @param qual_source_pub_group
     */
    public void setQual_source_pub_group(java.lang.String qual_source_pub_group) {
        this.qual_source_pub_group = qual_source_pub_group;
    }


    /**
     * Gets the sub_type_pub_group value for this Pub_select_responsePub.
     * 
     * @return sub_type_pub_group
     */
    public java.lang.String getSub_type_pub_group() {
        return sub_type_pub_group;
    }


    /**
     * Sets the sub_type_pub_group value for this Pub_select_responsePub.
     * 
     * @param sub_type_pub_group
     */
    public void setSub_type_pub_group(java.lang.String sub_type_pub_group) {
        this.sub_type_pub_group = sub_type_pub_group;
    }


    /**
     * Gets the add_kill_report value for this Pub_select_responsePub.
     * 
     * @return add_kill_report
     */
    public int getAdd_kill_report() {
        return add_kill_report;
    }


    /**
     * Sets the add_kill_report value for this Pub_select_responsePub.
     * 
     * @param add_kill_report
     */
    public void setAdd_kill_report(int add_kill_report) {
        this.add_kill_report = add_kill_report;
    }


    /**
     * Gets the qp value for this Pub_select_responsePub.
     * 
     * @return qp
     */
    public int getQp() {
        return qp;
    }


    /**
     * Sets the qp value for this Pub_select_responsePub.
     * 
     * @param qp
     */
    public void setQp(int qp) {
        this.qp = qp;
    }


    /**
     * Gets the qf value for this Pub_select_responsePub.
     * 
     * @return qf
     */
    public int getQf() {
        return qf;
    }


    /**
     * Sets the qf value for this Pub_select_responsePub.
     * 
     * @param qf
     */
    public void setQf(int qf) {
        this.qf = qf;
    }


    /**
     * Gets the nqp value for this Pub_select_responsePub.
     * 
     * @return nqp
     */
    public int getNqp() {
        return nqp;
    }


    /**
     * Sets the nqp value for this Pub_select_responsePub.
     * 
     * @param nqp
     */
    public void setNqp(int nqp) {
        this.nqp = nqp;
    }


    /**
     * Gets the nqf value for this Pub_select_responsePub.
     * 
     * @return nqf
     */
    public int getNqf() {
        return nqf;
    }


    /**
     * Sets the nqf value for this Pub_select_responsePub.
     * 
     * @param nqf
     */
    public void setNqf(int nqf) {
        this.nqf = nqf;
    }


    /**
     * Gets the duration_pub_group value for this Pub_select_responsePub.
     * 
     * @return duration_pub_group
     */
    public java.lang.String getDuration_pub_group() {
        return duration_pub_group;
    }


    /**
     * Sets the duration_pub_group value for this Pub_select_responsePub.
     * 
     * @param duration_pub_group
     */
    public void setDuration_pub_group(java.lang.String duration_pub_group) {
        this.duration_pub_group = duration_pub_group;
    }


    /**
     * Gets the price_pub_group value for this Pub_select_responsePub.
     * 
     * @return price_pub_group
     */
    public java.lang.String getPrice_pub_group() {
        return price_pub_group;
    }


    /**
     * Sets the price_pub_group value for this Pub_select_responsePub.
     * 
     * @param price_pub_group
     */
    public void setPrice_pub_group(java.lang.String price_pub_group) {
        this.price_pub_group = price_pub_group;
    }


    /**
     * Gets the demog_pub_group value for this Pub_select_responsePub.
     * 
     * @return demog_pub_group
     */
    public java.lang.String getDemog_pub_group() {
        return demog_pub_group;
    }


    /**
     * Sets the demog_pub_group value for this Pub_select_responsePub.
     * 
     * @param demog_pub_group
     */
    public void setDemog_pub_group(java.lang.String demog_pub_group) {
        this.demog_pub_group = demog_pub_group;
    }


    /**
     * Gets the qp_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @return qp_prompt_for_backissues
     */
    public int getQp_prompt_for_backissues() {
        return qp_prompt_for_backissues;
    }


    /**
     * Sets the qp_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @param qp_prompt_for_backissues
     */
    public void setQp_prompt_for_backissues(int qp_prompt_for_backissues) {
        this.qp_prompt_for_backissues = qp_prompt_for_backissues;
    }


    /**
     * Gets the qf_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @return qf_prompt_for_backissues
     */
    public int getQf_prompt_for_backissues() {
        return qf_prompt_for_backissues;
    }


    /**
     * Sets the qf_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @param qf_prompt_for_backissues
     */
    public void setQf_prompt_for_backissues(int qf_prompt_for_backissues) {
        this.qf_prompt_for_backissues = qf_prompt_for_backissues;
    }


    /**
     * Gets the nqp_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @return nqp_prompt_for_backissues
     */
    public int getNqp_prompt_for_backissues() {
        return nqp_prompt_for_backissues;
    }


    /**
     * Sets the nqp_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @param nqp_prompt_for_backissues
     */
    public void setNqp_prompt_for_backissues(int nqp_prompt_for_backissues) {
        this.nqp_prompt_for_backissues = nqp_prompt_for_backissues;
    }


    /**
     * Gets the nqf_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @return nqf_prompt_for_backissues
     */
    public int getNqf_prompt_for_backissues() {
        return nqf_prompt_for_backissues;
    }


    /**
     * Sets the nqf_prompt_for_backissues value for this Pub_select_responsePub.
     * 
     * @param nqf_prompt_for_backissues
     */
    public void setNqf_prompt_for_backissues(int nqf_prompt_for_backissues) {
        this.nqf_prompt_for_backissues = nqf_prompt_for_backissues;
    }


    /**
     * Gets the no_spaces_in_enumeration value for this Pub_select_responsePub.
     * 
     * @return no_spaces_in_enumeration
     */
    public int getNo_spaces_in_enumeration() {
        return no_spaces_in_enumeration;
    }


    /**
     * Sets the no_spaces_in_enumeration value for this Pub_select_responsePub.
     * 
     * @param no_spaces_in_enumeration
     */
    public void setNo_spaces_in_enumeration(int no_spaces_in_enumeration) {
        this.no_spaces_in_enumeration = no_spaces_in_enumeration;
    }


    /**
     * Gets the accrual_time_unit value for this Pub_select_responsePub.
     * 
     * @return accrual_time_unit
     */
    public int getAccrual_time_unit() {
        return accrual_time_unit;
    }


    /**
     * Sets the accrual_time_unit value for this Pub_select_responsePub.
     * 
     * @param accrual_time_unit
     */
    public void setAccrual_time_unit(int accrual_time_unit) {
        this.accrual_time_unit = accrual_time_unit;
    }


    /**
     * Gets the accrual_time value for this Pub_select_responsePub.
     * 
     * @return accrual_time
     */
    public int getAccrual_time() {
        return accrual_time;
    }


    /**
     * Sets the accrual_time value for this Pub_select_responsePub.
     * 
     * @param accrual_time
     */
    public void setAccrual_time(int accrual_time) {
        this.accrual_time = accrual_time;
    }


    /**
     * Gets the revenue_method value for this Pub_select_responsePub.
     * 
     * @return revenue_method
     */
    public int getRevenue_method() {
        return revenue_method;
    }


    /**
     * Sets the revenue_method value for this Pub_select_responsePub.
     * 
     * @param revenue_method
     */
    public void setRevenue_method(int revenue_method) {
        this.revenue_method = revenue_method;
    }


    /**
     * Gets the start_date_type_date_based value for this Pub_select_responsePub.
     * 
     * @return start_date_type_date_based
     */
    public int getStart_date_type_date_based() {
        return start_date_type_date_based;
    }


    /**
     * Sets the start_date_type_date_based value for this Pub_select_responsePub.
     * 
     * @param start_date_type_date_based
     */
    public void setStart_date_type_date_based(int start_date_type_date_based) {
        this.start_date_type_date_based = start_date_type_date_based;
    }


    /**
     * Gets the start_n_days_date_based value for this Pub_select_responsePub.
     * 
     * @return start_n_days_date_based
     */
    public int getStart_n_days_date_based() {
        return start_n_days_date_based;
    }


    /**
     * Sets the start_n_days_date_based value for this Pub_select_responsePub.
     * 
     * @param start_n_days_date_based
     */
    public void setStart_n_days_date_based(int start_n_days_date_based) {
        this.start_n_days_date_based = start_n_days_date_based;
    }


    /**
     * Gets the suppress_enumeration value for this Pub_select_responsePub.
     * 
     * @return suppress_enumeration
     */
    public int getSuppress_enumeration() {
        return suppress_enumeration;
    }


    /**
     * Sets the suppress_enumeration value for this Pub_select_responsePub.
     * 
     * @param suppress_enumeration
     */
    public void setSuppress_enumeration(int suppress_enumeration) {
        this.suppress_enumeration = suppress_enumeration;
    }


    /**
     * Gets the max_qual_date_age value for this Pub_select_responsePub.
     * 
     * @return max_qual_date_age
     */
    public int getMax_qual_date_age() {
        return max_qual_date_age;
    }


    /**
     * Sets the max_qual_date_age value for this Pub_select_responsePub.
     * 
     * @param max_qual_date_age
     */
    public void setMax_qual_date_age(int max_qual_date_age) {
        this.max_qual_date_age = max_qual_date_age;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pub_select_responsePub)) return false;
        Pub_select_responsePub other = (Pub_select_responsePub) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.oc_id == other.getOc_id() &&
            ((this.issn==null && other.getIssn()==null) || 
             (this.issn!=null &&
              this.issn.equals(other.getIssn()))) &&
            ((this.inherited_from==null && other.getInherited_from()==null) || 
             (this.inherited_from!=null &&
              this.inherited_from.equals(other.getInherited_from()))) &&
            ((this.converted_to==null && other.getConverted_to()==null) || 
             (this.converted_to!=null &&
              this.converted_to.equals(other.getConverted_to()))) &&
            this.start_type == other.getStart_type() &&
            this.audited == other.getAudited() &&
            this.qp_sub_type_required == other.getQp_sub_type_required() &&
            this.qp_qual_source_required == other.getQp_qual_source_required() &&
            this.qp_name_title_required == other.getQp_name_title_required() &&
            this.qp_sales_channel_required == other.getQp_sales_channel_required() &&
            this.qp_max_backstarts_on_new == other.getQp_max_backstarts_on_new() &&
            this.qp_max_backissues_on_reinst == other.getQp_max_backissues_on_reinst() &&
            this.qp_backissues_on_reinst == other.getQp_backissues_on_reinst() &&
            this.qf_sub_type_required == other.getQf_sub_type_required() &&
            this.qf_qual_source_required == other.getQf_qual_source_required() &&
            this.qf_name_title_required == other.getQf_name_title_required() &&
            this.qf_sales_channel_required == other.getQf_sales_channel_required() &&
            this.qf_max_backstarts_on_new == other.getQf_max_backstarts_on_new() &&
            this.qf_max_backissues_on_reinst == other.getQf_max_backissues_on_reinst() &&
            this.qf_backissues_on_reinst == other.getQf_backissues_on_reinst() &&
            this.nqp_sub_type_required == other.getNqp_sub_type_required() &&
            this.nqp_qual_source_required == other.getNqp_qual_source_required() &&
            this.nqp_name_title_required == other.getNqp_name_title_required() &&
            this.nqp_sales_channel_required == other.getNqp_sales_channel_required() &&
            this.nqp_max_backstarts_on_new == other.getNqp_max_backstarts_on_new() &&
            this.nqp_max_backissues_on_reinst == other.getNqp_max_backissues_on_reinst() &&
            this.nqp_backissues_on_reinst == other.getNqp_backissues_on_reinst() &&
            this.nqf_sub_type_required == other.getNqf_sub_type_required() &&
            this.nqf_qual_source_required == other.getNqf_qual_source_required() &&
            this.nqf_name_title_required == other.getNqf_name_title_required() &&
            this.nqf_sales_channel_required == other.getNqf_sales_channel_required() &&
            this.nqf_max_backstarts_on_new == other.getNqf_max_backstarts_on_new() &&
            this.nqf_max_backissues_on_reinst == other.getNqf_max_backissues_on_reinst() &&
            this.nqf_backissues_on_reinst == other.getNqf_backissues_on_reinst() &&
            this.n_issues == other.getN_issues() &&
            this.n_calendar_units == other.getN_calendar_units() &&
            this.calendar_unit == other.getCalendar_unit() &&
            ((this.on_string==null && other.getOn_string()==null) || 
             (this.on_string!=null &&
              this.on_string.equals(other.getOn_string()))) &&
            this.on_calendar_unit == other.getOn_calendar_unit() &&
            this.on_day == other.getOn_day() &&
            ((this.volume_caption==null && other.getVolume_caption()==null) || 
             (this.volume_caption!=null &&
              this.volume_caption.equals(other.getVolume_caption()))) &&
            this.volume_format == other.getVolume_format() &&
            ((this.volume_change_date==null && other.getVolume_change_date()==null) || 
             (this.volume_change_date!=null &&
              this.volume_change_date.equals(other.getVolume_change_date()))) &&
            ((this.issue_caption==null && other.getIssue_caption()==null) || 
             (this.issue_caption!=null &&
              this.issue_caption.equals(other.getIssue_caption()))) &&
            this.issue_format == other.getIssue_format() &&
            this.issue_continuous == other.getIssue_continuous() &&
            this.n_issues_per_volume == other.getN_issues_per_volume() &&
            this.start_date_type_anytime == other.getStart_date_type_anytime() &&
            this.backstart_n_issues_anytime == other.getBackstart_n_issues_anytime() &&
            this.start_date_type_volume_group == other.getStart_date_type_volume_group() &&
            this.unit_audits == other.getUnit_audits() &&
            ((this.annual_rate==null && other.getAnnual_rate()==null) || 
             (this.annual_rate!=null &&
              this.annual_rate.equals(other.getAnnual_rate()))) &&
            ((this.region_list==null && other.getRegion_list()==null) || 
             (this.region_list!=null &&
              this.region_list.equals(other.getRegion_list()))) &&
            ((this.sales_channel_pub_group==null && other.getSales_channel_pub_group()==null) || 
             (this.sales_channel_pub_group!=null &&
              this.sales_channel_pub_group.equals(other.getSales_channel_pub_group()))) &&
            ((this.name_title_pub_group==null && other.getName_title_pub_group()==null) || 
             (this.name_title_pub_group!=null &&
              this.name_title_pub_group.equals(other.getName_title_pub_group()))) &&
            ((this.qual_source_pub_group==null && other.getQual_source_pub_group()==null) || 
             (this.qual_source_pub_group!=null &&
              this.qual_source_pub_group.equals(other.getQual_source_pub_group()))) &&
            ((this.sub_type_pub_group==null && other.getSub_type_pub_group()==null) || 
             (this.sub_type_pub_group!=null &&
              this.sub_type_pub_group.equals(other.getSub_type_pub_group()))) &&
            this.add_kill_report == other.getAdd_kill_report() &&
            this.qp == other.getQp() &&
            this.qf == other.getQf() &&
            this.nqp == other.getNqp() &&
            this.nqf == other.getNqf() &&
            ((this.duration_pub_group==null && other.getDuration_pub_group()==null) || 
             (this.duration_pub_group!=null &&
              this.duration_pub_group.equals(other.getDuration_pub_group()))) &&
            ((this.price_pub_group==null && other.getPrice_pub_group()==null) || 
             (this.price_pub_group!=null &&
              this.price_pub_group.equals(other.getPrice_pub_group()))) &&
            ((this.demog_pub_group==null && other.getDemog_pub_group()==null) || 
             (this.demog_pub_group!=null &&
              this.demog_pub_group.equals(other.getDemog_pub_group()))) &&
            this.qp_prompt_for_backissues == other.getQp_prompt_for_backissues() &&
            this.qf_prompt_for_backissues == other.getQf_prompt_for_backissues() &&
            this.nqp_prompt_for_backissues == other.getNqp_prompt_for_backissues() &&
            this.nqf_prompt_for_backissues == other.getNqf_prompt_for_backissues() &&
            this.no_spaces_in_enumeration == other.getNo_spaces_in_enumeration() &&
            this.accrual_time_unit == other.getAccrual_time_unit() &&
            this.accrual_time == other.getAccrual_time() &&
            this.revenue_method == other.getRevenue_method() &&
            this.start_date_type_date_based == other.getStart_date_type_date_based() &&
            this.start_n_days_date_based == other.getStart_n_days_date_based() &&
            this.suppress_enumeration == other.getSuppress_enumeration() &&
            this.max_qual_date_age == other.getMax_qual_date_age();
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
        _hashCode += getOc_id();
        if (getIssn() != null) {
            _hashCode += getIssn().hashCode();
        }
        if (getInherited_from() != null) {
            _hashCode += getInherited_from().hashCode();
        }
        if (getConverted_to() != null) {
            _hashCode += getConverted_to().hashCode();
        }
        _hashCode += getStart_type();
        _hashCode += getAudited();
        _hashCode += getQp_sub_type_required();
        _hashCode += getQp_qual_source_required();
        _hashCode += getQp_name_title_required();
        _hashCode += getQp_sales_channel_required();
        _hashCode += getQp_max_backstarts_on_new();
        _hashCode += getQp_max_backissues_on_reinst();
        _hashCode += getQp_backissues_on_reinst();
        _hashCode += getQf_sub_type_required();
        _hashCode += getQf_qual_source_required();
        _hashCode += getQf_name_title_required();
        _hashCode += getQf_sales_channel_required();
        _hashCode += getQf_max_backstarts_on_new();
        _hashCode += getQf_max_backissues_on_reinst();
        _hashCode += getQf_backissues_on_reinst();
        _hashCode += getNqp_sub_type_required();
        _hashCode += getNqp_qual_source_required();
        _hashCode += getNqp_name_title_required();
        _hashCode += getNqp_sales_channel_required();
        _hashCode += getNqp_max_backstarts_on_new();
        _hashCode += getNqp_max_backissues_on_reinst();
        _hashCode += getNqp_backissues_on_reinst();
        _hashCode += getNqf_sub_type_required();
        _hashCode += getNqf_qual_source_required();
        _hashCode += getNqf_name_title_required();
        _hashCode += getNqf_sales_channel_required();
        _hashCode += getNqf_max_backstarts_on_new();
        _hashCode += getNqf_max_backissues_on_reinst();
        _hashCode += getNqf_backissues_on_reinst();
        _hashCode += getN_issues();
        _hashCode += getN_calendar_units();
        _hashCode += getCalendar_unit();
        if (getOn_string() != null) {
            _hashCode += getOn_string().hashCode();
        }
        _hashCode += getOn_calendar_unit();
        _hashCode += getOn_day();
        if (getVolume_caption() != null) {
            _hashCode += getVolume_caption().hashCode();
        }
        _hashCode += getVolume_format();
        if (getVolume_change_date() != null) {
            _hashCode += getVolume_change_date().hashCode();
        }
        if (getIssue_caption() != null) {
            _hashCode += getIssue_caption().hashCode();
        }
        _hashCode += getIssue_format();
        _hashCode += getIssue_continuous();
        _hashCode += getN_issues_per_volume();
        _hashCode += getStart_date_type_anytime();
        _hashCode += getBackstart_n_issues_anytime();
        _hashCode += getStart_date_type_volume_group();
        _hashCode += getUnit_audits();
        if (getAnnual_rate() != null) {
            _hashCode += getAnnual_rate().hashCode();
        }
        if (getRegion_list() != null) {
            _hashCode += getRegion_list().hashCode();
        }
        if (getSales_channel_pub_group() != null) {
            _hashCode += getSales_channel_pub_group().hashCode();
        }
        if (getName_title_pub_group() != null) {
            _hashCode += getName_title_pub_group().hashCode();
        }
        if (getQual_source_pub_group() != null) {
            _hashCode += getQual_source_pub_group().hashCode();
        }
        if (getSub_type_pub_group() != null) {
            _hashCode += getSub_type_pub_group().hashCode();
        }
        _hashCode += getAdd_kill_report();
        _hashCode += getQp();
        _hashCode += getQf();
        _hashCode += getNqp();
        _hashCode += getNqf();
        if (getDuration_pub_group() != null) {
            _hashCode += getDuration_pub_group().hashCode();
        }
        if (getPrice_pub_group() != null) {
            _hashCode += getPrice_pub_group().hashCode();
        }
        if (getDemog_pub_group() != null) {
            _hashCode += getDemog_pub_group().hashCode();
        }
        _hashCode += getQp_prompt_for_backissues();
        _hashCode += getQf_prompt_for_backissues();
        _hashCode += getNqp_prompt_for_backissues();
        _hashCode += getNqf_prompt_for_backissues();
        _hashCode += getNo_spaces_in_enumeration();
        _hashCode += getAccrual_time_unit();
        _hashCode += getAccrual_time();
        _hashCode += getRevenue_method();
        _hashCode += getStart_date_type_date_based();
        _hashCode += getStart_n_days_date_based();
        _hashCode += getSuppress_enumeration();
        _hashCode += getMax_qual_date_age();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pub_select_responsePub.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>pub_select_response>pub"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inherited_from");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inherited_from"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("converted_to");
        attrField.setXmlName(new javax.xml.namespace.QName("", "converted_to"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audited");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audited"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_sub_type_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_sub_type_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_qual_source_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_qual_source_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_name_title_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_name_title_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_sales_channel_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_sales_channel_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_max_backstarts_on_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_max_backstarts_on_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_max_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_max_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_sub_type_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_sub_type_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_qual_source_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_qual_source_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_name_title_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_name_title_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_sales_channel_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_sales_channel_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_max_backstarts_on_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_max_backstarts_on_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_max_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_max_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_sub_type_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_sub_type_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_qual_source_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_qual_source_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_name_title_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_name_title_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_sales_channel_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_sales_channel_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_max_backstarts_on_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_max_backstarts_on_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_max_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_max_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_sub_type_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_sub_type_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_qual_source_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_qual_source_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_name_title_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_name_title_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_sales_channel_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_sales_channel_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_max_backstarts_on_new");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_max_backstarts_on_new"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_max_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_max_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_backissues_on_reinst");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_backissues_on_reinst"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_issues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_issues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_calendar_units");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_calendar_units"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("calendar_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "calendar_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("on_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "on_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("on_calendar_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "on_calendar_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("on_day");
        attrField.setXmlName(new javax.xml.namespace.QName("", "on_day"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_caption");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_caption"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_format");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_format"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_change_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_change_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_caption");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_caption"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_format");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_format"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_continuous");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_continuous"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_issues_per_volume");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_issues_per_volume"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_date_type_anytime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_date_type_anytime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("backstart_n_issues_anytime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "backstart_n_issues_anytime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_date_type_volume_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_date_type_volume_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_audits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_audits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("annual_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "annual_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("region_list");
        attrField.setXmlName(new javax.xml.namespace.QName("", "region_list"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sales_channel_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sales_channel_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("name_title_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "name_title_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qual_source_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qual_source_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sub_type_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sub_type_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("add_kill_report");
        attrField.setXmlName(new javax.xml.namespace.QName("", "add_kill_report"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("duration_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "duration_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("demog_pub_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "demog_pub_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qp_prompt_for_backissues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qp_prompt_for_backissues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qf_prompt_for_backissues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qf_prompt_for_backissues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqp_prompt_for_backissues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqp_prompt_for_backissues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nqf_prompt_for_backissues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nqf_prompt_for_backissues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("no_spaces_in_enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "no_spaces_in_enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("accrual_time_unit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "accrual_time_unit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("accrual_time");
        attrField.setXmlName(new javax.xml.namespace.QName("", "accrual_time"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_date_type_date_based");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_date_type_date_based"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_n_days_date_based");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_n_days_date_based"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("max_qual_date_age");
        attrField.setXmlName(new javax.xml.namespace.QName("", "max_qual_date_age"));
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
