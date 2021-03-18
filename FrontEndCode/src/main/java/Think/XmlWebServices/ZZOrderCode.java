/**
 * ZZOrderCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZOrderCode  implements java.io.Serializable {
    private int order_code_id;  // attribute

    private int active;  // attribute

    private int allow_on_internet;  // attribute

    private int audit_name_title_id;  // attribute

    private int audit_qual_category;  // attribute

    private int audit_qual_source_id;  // attribute

    private int audit_sales_channel_id;  // attribute

    private int audit_subscription_type_id;  // attribute

    private int auto_payment;  // attribute

    private int auto_renewal;  // attribute

    private int auto_replace;  // attribute

    private int backstart_tb_renewals;  // attribute

    private int charge_shipping;  // attribute

    private java.lang.String commodity_code;  // attribute

    private int controlled;  // attribute

    private int credit_card_process;  // attribute

    private java.lang.String description;  // attribute

    private int disallow_install_billing;  // attribute

    private int discount_class_id;  // attribute

    private java.lang.String edition;  // attribute

    private int electronic_delivery;  // attribute

    private int excess_rate_class_id;  // attribute

    private int extfree_qty_limit;  // attribute

    private java.util.Date from_date;  // attribute

    private java.util.Date fulfillment_date;  // attribute

    private int grace_qty;  // attribute

    private java.lang.String image_url;  // attribute

    private int installment_billing_only;  // attribute

    private int installment_plan_id;  // attribute

    private int is_addon;  // attribute

    private int is_proforma;  // attribute

    private java.lang.String isbn;  // attribute

    private int issue_id;  // attribute

    private int item_type;  // attribute

    private java.lang.String item_url;  // attribute

    private int max_n_items;  // attribute

    private java.lang.String media;  // attribute

    private int min_n_items;  // attribute

    private int new_renewal_card_id;  // attribute

    private int newsub_rate_class_id;  // attribute

    private int no_charge;  // attribute

    private int oc_id;  // attribute

    private java.lang.String order_code;  // attribute

    private int order_code_type;  // attribute

    private int perpetual_order;  // attribute

    private int pkg_only_item;  // attribute

    private int place_anyway_if_cant_auth;  // attribute

    private int premium;  // attribute

    private int premium_order_code_id;  // attribute

    private int prepayment_req;  // attribute

    private java.math.BigDecimal price;  // attribute

    private java.lang.String product_author;  // attribute

    private java.lang.String product_color;  // attribute

    private java.lang.String product_size;  // attribute

    private java.lang.String product_style;  // attribute

    private int pub_rotation_id;  // attribute

    private int qty;  // attribute

    private int reinstate_proforma_on_removal;  // attribute

    private int renew_as_proforma;  // attribute

    private int revenue_method;  // attribute

    private int sample_copy_order;  // attribute

    private int segmented_order;  // attribute

    private java.lang.String settle_retry_def;  // attribute

    private int ship_premium_percentage;  // attribute

    private java.math.BigDecimal ship_weight;  // attribute

    private int standord;  // attribute

    private int start_type;  // attribute

    private java.lang.String subscriber_site_long_desc;  // attribute

    private java.lang.String subscriber_site_short_desc;  // attribute

    private int subscription_category_id;  // attribute

    private int taxable;  // attribute

    private java.lang.String taxonomy;  // attribute

    private int term_id;  // attribute

    private int time_unit_options;  // attribute

    private java.util.Date to_date;  // attribute

    private int trial_period;  // attribute

    private int trial_type;  // attribute

    private int unit_excess;  // attribute

    private int unit_type_id;  // attribute

    private java.lang.String user_code;  // attribute

    public ZZOrderCode() {
    }

    public ZZOrderCode(
           int order_code_id,
           int active,
           int allow_on_internet,
           int audit_name_title_id,
           int audit_qual_category,
           int audit_qual_source_id,
           int audit_sales_channel_id,
           int audit_subscription_type_id,
           int auto_payment,
           int auto_renewal,
           int auto_replace,
           int backstart_tb_renewals,
           int charge_shipping,
           java.lang.String commodity_code,
           int controlled,
           int credit_card_process,
           java.lang.String description,
           int disallow_install_billing,
           int discount_class_id,
           java.lang.String edition,
           int electronic_delivery,
           int excess_rate_class_id,
           int extfree_qty_limit,
           java.util.Date from_date,
           java.util.Date fulfillment_date,
           int grace_qty,
           java.lang.String image_url,
           int installment_billing_only,
           int installment_plan_id,
           int is_addon,
           int is_proforma,
           java.lang.String isbn,
           int issue_id,
           int item_type,
           java.lang.String item_url,
           int max_n_items,
           java.lang.String media,
           int min_n_items,
           int new_renewal_card_id,
           int newsub_rate_class_id,
           int no_charge,
           int oc_id,
           java.lang.String order_code,
           int order_code_type,
           int perpetual_order,
           int pkg_only_item,
           int place_anyway_if_cant_auth,
           int premium,
           int premium_order_code_id,
           int prepayment_req,
           java.math.BigDecimal price,
           java.lang.String product_author,
           java.lang.String product_color,
           java.lang.String product_size,
           java.lang.String product_style,
           int pub_rotation_id,
           int qty,
           int reinstate_proforma_on_removal,
           int renew_as_proforma,
           int revenue_method,
           int sample_copy_order,
           int segmented_order,
           java.lang.String settle_retry_def,
           int ship_premium_percentage,
           java.math.BigDecimal ship_weight,
           int standord,
           int start_type,
           java.lang.String subscriber_site_long_desc,
           java.lang.String subscriber_site_short_desc,
           int subscription_category_id,
           int taxable,
           java.lang.String taxonomy,
           int term_id,
           int time_unit_options,
           java.util.Date to_date,
           int trial_period,
           int trial_type,
           int unit_excess,
           int unit_type_id,
           java.lang.String user_code) {
           this.order_code_id = order_code_id;
           this.active = active;
           this.allow_on_internet = allow_on_internet;
           this.audit_name_title_id = audit_name_title_id;
           this.audit_qual_category = audit_qual_category;
           this.audit_qual_source_id = audit_qual_source_id;
           this.audit_sales_channel_id = audit_sales_channel_id;
           this.audit_subscription_type_id = audit_subscription_type_id;
           this.auto_payment = auto_payment;
           this.auto_renewal = auto_renewal;
           this.auto_replace = auto_replace;
           this.backstart_tb_renewals = backstart_tb_renewals;
           this.charge_shipping = charge_shipping;
           this.commodity_code = commodity_code;
           this.controlled = controlled;
           this.credit_card_process = credit_card_process;
           this.description = description;
           this.disallow_install_billing = disallow_install_billing;
           this.discount_class_id = discount_class_id;
           this.edition = edition;
           this.electronic_delivery = electronic_delivery;
           this.excess_rate_class_id = excess_rate_class_id;
           this.extfree_qty_limit = extfree_qty_limit;
           this.from_date = from_date;
           this.fulfillment_date = fulfillment_date;
           this.grace_qty = grace_qty;
           this.image_url = image_url;
           this.installment_billing_only = installment_billing_only;
           this.installment_plan_id = installment_plan_id;
           this.is_addon = is_addon;
           this.is_proforma = is_proforma;
           this.isbn = isbn;
           this.issue_id = issue_id;
           this.item_type = item_type;
           this.item_url = item_url;
           this.max_n_items = max_n_items;
           this.media = media;
           this.min_n_items = min_n_items;
           this.new_renewal_card_id = new_renewal_card_id;
           this.newsub_rate_class_id = newsub_rate_class_id;
           this.no_charge = no_charge;
           this.oc_id = oc_id;
           this.order_code = order_code;
           this.order_code_type = order_code_type;
           this.perpetual_order = perpetual_order;
           this.pkg_only_item = pkg_only_item;
           this.place_anyway_if_cant_auth = place_anyway_if_cant_auth;
           this.premium = premium;
           this.premium_order_code_id = premium_order_code_id;
           this.prepayment_req = prepayment_req;
           this.price = price;
           this.product_author = product_author;
           this.product_color = product_color;
           this.product_size = product_size;
           this.product_style = product_style;
           this.pub_rotation_id = pub_rotation_id;
           this.qty = qty;
           this.reinstate_proforma_on_removal = reinstate_proforma_on_removal;
           this.renew_as_proforma = renew_as_proforma;
           this.revenue_method = revenue_method;
           this.sample_copy_order = sample_copy_order;
           this.segmented_order = segmented_order;
           this.settle_retry_def = settle_retry_def;
           this.ship_premium_percentage = ship_premium_percentage;
           this.ship_weight = ship_weight;
           this.standord = standord;
           this.start_type = start_type;
           this.subscriber_site_long_desc = subscriber_site_long_desc;
           this.subscriber_site_short_desc = subscriber_site_short_desc;
           this.subscription_category_id = subscription_category_id;
           this.taxable = taxable;
           this.taxonomy = taxonomy;
           this.term_id = term_id;
           this.time_unit_options = time_unit_options;
           this.to_date = to_date;
           this.trial_period = trial_period;
           this.trial_type = trial_type;
           this.unit_excess = unit_excess;
           this.unit_type_id = unit_type_id;
           this.user_code = user_code;
    }


    /**
     * Gets the order_code_id value for this ZZOrderCode.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this ZZOrderCode.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the active value for this ZZOrderCode.
     * 
     * @return active
     */
    public int getActive() {
        return active;
    }


    /**
     * Sets the active value for this ZZOrderCode.
     * 
     * @param active
     */
    public void setActive(int active) {
        this.active = active;
    }


    /**
     * Gets the allow_on_internet value for this ZZOrderCode.
     * 
     * @return allow_on_internet
     */
    public int getAllow_on_internet() {
        return allow_on_internet;
    }


    /**
     * Sets the allow_on_internet value for this ZZOrderCode.
     * 
     * @param allow_on_internet
     */
    public void setAllow_on_internet(int allow_on_internet) {
        this.allow_on_internet = allow_on_internet;
    }


    /**
     * Gets the audit_name_title_id value for this ZZOrderCode.
     * 
     * @return audit_name_title_id
     */
    public int getAudit_name_title_id() {
        return audit_name_title_id;
    }


    /**
     * Sets the audit_name_title_id value for this ZZOrderCode.
     * 
     * @param audit_name_title_id
     */
    public void setAudit_name_title_id(int audit_name_title_id) {
        this.audit_name_title_id = audit_name_title_id;
    }


    /**
     * Gets the audit_qual_category value for this ZZOrderCode.
     * 
     * @return audit_qual_category
     */
    public int getAudit_qual_category() {
        return audit_qual_category;
    }


    /**
     * Sets the audit_qual_category value for this ZZOrderCode.
     * 
     * @param audit_qual_category
     */
    public void setAudit_qual_category(int audit_qual_category) {
        this.audit_qual_category = audit_qual_category;
    }


    /**
     * Gets the audit_qual_source_id value for this ZZOrderCode.
     * 
     * @return audit_qual_source_id
     */
    public int getAudit_qual_source_id() {
        return audit_qual_source_id;
    }


    /**
     * Sets the audit_qual_source_id value for this ZZOrderCode.
     * 
     * @param audit_qual_source_id
     */
    public void setAudit_qual_source_id(int audit_qual_source_id) {
        this.audit_qual_source_id = audit_qual_source_id;
    }


    /**
     * Gets the audit_sales_channel_id value for this ZZOrderCode.
     * 
     * @return audit_sales_channel_id
     */
    public int getAudit_sales_channel_id() {
        return audit_sales_channel_id;
    }


    /**
     * Sets the audit_sales_channel_id value for this ZZOrderCode.
     * 
     * @param audit_sales_channel_id
     */
    public void setAudit_sales_channel_id(int audit_sales_channel_id) {
        this.audit_sales_channel_id = audit_sales_channel_id;
    }


    /**
     * Gets the audit_subscription_type_id value for this ZZOrderCode.
     * 
     * @return audit_subscription_type_id
     */
    public int getAudit_subscription_type_id() {
        return audit_subscription_type_id;
    }


    /**
     * Sets the audit_subscription_type_id value for this ZZOrderCode.
     * 
     * @param audit_subscription_type_id
     */
    public void setAudit_subscription_type_id(int audit_subscription_type_id) {
        this.audit_subscription_type_id = audit_subscription_type_id;
    }


    /**
     * Gets the auto_payment value for this ZZOrderCode.
     * 
     * @return auto_payment
     */
    public int getAuto_payment() {
        return auto_payment;
    }


    /**
     * Sets the auto_payment value for this ZZOrderCode.
     * 
     * @param auto_payment
     */
    public void setAuto_payment(int auto_payment) {
        this.auto_payment = auto_payment;
    }


    /**
     * Gets the auto_renewal value for this ZZOrderCode.
     * 
     * @return auto_renewal
     */
    public int getAuto_renewal() {
        return auto_renewal;
    }


    /**
     * Sets the auto_renewal value for this ZZOrderCode.
     * 
     * @param auto_renewal
     */
    public void setAuto_renewal(int auto_renewal) {
        this.auto_renewal = auto_renewal;
    }


    /**
     * Gets the auto_replace value for this ZZOrderCode.
     * 
     * @return auto_replace
     */
    public int getAuto_replace() {
        return auto_replace;
    }


    /**
     * Sets the auto_replace value for this ZZOrderCode.
     * 
     * @param auto_replace
     */
    public void setAuto_replace(int auto_replace) {
        this.auto_replace = auto_replace;
    }


    /**
     * Gets the backstart_tb_renewals value for this ZZOrderCode.
     * 
     * @return backstart_tb_renewals
     */
    public int getBackstart_tb_renewals() {
        return backstart_tb_renewals;
    }


    /**
     * Sets the backstart_tb_renewals value for this ZZOrderCode.
     * 
     * @param backstart_tb_renewals
     */
    public void setBackstart_tb_renewals(int backstart_tb_renewals) {
        this.backstart_tb_renewals = backstart_tb_renewals;
    }


    /**
     * Gets the charge_shipping value for this ZZOrderCode.
     * 
     * @return charge_shipping
     */
    public int getCharge_shipping() {
        return charge_shipping;
    }


    /**
     * Sets the charge_shipping value for this ZZOrderCode.
     * 
     * @param charge_shipping
     */
    public void setCharge_shipping(int charge_shipping) {
        this.charge_shipping = charge_shipping;
    }


    /**
     * Gets the commodity_code value for this ZZOrderCode.
     * 
     * @return commodity_code
     */
    public java.lang.String getCommodity_code() {
        return commodity_code;
    }


    /**
     * Sets the commodity_code value for this ZZOrderCode.
     * 
     * @param commodity_code
     */
    public void setCommodity_code(java.lang.String commodity_code) {
        this.commodity_code = commodity_code;
    }


    /**
     * Gets the controlled value for this ZZOrderCode.
     * 
     * @return controlled
     */
    public int getControlled() {
        return controlled;
    }


    /**
     * Sets the controlled value for this ZZOrderCode.
     * 
     * @param controlled
     */
    public void setControlled(int controlled) {
        this.controlled = controlled;
    }


    /**
     * Gets the credit_card_process value for this ZZOrderCode.
     * 
     * @return credit_card_process
     */
    public int getCredit_card_process() {
        return credit_card_process;
    }


    /**
     * Sets the credit_card_process value for this ZZOrderCode.
     * 
     * @param credit_card_process
     */
    public void setCredit_card_process(int credit_card_process) {
        this.credit_card_process = credit_card_process;
    }


    /**
     * Gets the description value for this ZZOrderCode.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZOrderCode.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the disallow_install_billing value for this ZZOrderCode.
     * 
     * @return disallow_install_billing
     */
    public int getDisallow_install_billing() {
        return disallow_install_billing;
    }


    /**
     * Sets the disallow_install_billing value for this ZZOrderCode.
     * 
     * @param disallow_install_billing
     */
    public void setDisallow_install_billing(int disallow_install_billing) {
        this.disallow_install_billing = disallow_install_billing;
    }


    /**
     * Gets the discount_class_id value for this ZZOrderCode.
     * 
     * @return discount_class_id
     */
    public int getDiscount_class_id() {
        return discount_class_id;
    }


    /**
     * Sets the discount_class_id value for this ZZOrderCode.
     * 
     * @param discount_class_id
     */
    public void setDiscount_class_id(int discount_class_id) {
        this.discount_class_id = discount_class_id;
    }


    /**
     * Gets the edition value for this ZZOrderCode.
     * 
     * @return edition
     */
    public java.lang.String getEdition() {
        return edition;
    }


    /**
     * Sets the edition value for this ZZOrderCode.
     * 
     * @param edition
     */
    public void setEdition(java.lang.String edition) {
        this.edition = edition;
    }


    /**
     * Gets the electronic_delivery value for this ZZOrderCode.
     * 
     * @return electronic_delivery
     */
    public int getElectronic_delivery() {
        return electronic_delivery;
    }


    /**
     * Sets the electronic_delivery value for this ZZOrderCode.
     * 
     * @param electronic_delivery
     */
    public void setElectronic_delivery(int electronic_delivery) {
        this.electronic_delivery = electronic_delivery;
    }


    /**
     * Gets the excess_rate_class_id value for this ZZOrderCode.
     * 
     * @return excess_rate_class_id
     */
    public int getExcess_rate_class_id() {
        return excess_rate_class_id;
    }


    /**
     * Sets the excess_rate_class_id value for this ZZOrderCode.
     * 
     * @param excess_rate_class_id
     */
    public void setExcess_rate_class_id(int excess_rate_class_id) {
        this.excess_rate_class_id = excess_rate_class_id;
    }


    /**
     * Gets the extfree_qty_limit value for this ZZOrderCode.
     * 
     * @return extfree_qty_limit
     */
    public int getExtfree_qty_limit() {
        return extfree_qty_limit;
    }


    /**
     * Sets the extfree_qty_limit value for this ZZOrderCode.
     * 
     * @param extfree_qty_limit
     */
    public void setExtfree_qty_limit(int extfree_qty_limit) {
        this.extfree_qty_limit = extfree_qty_limit;
    }


    /**
     * Gets the from_date value for this ZZOrderCode.
     * 
     * @return from_date
     */
    public java.util.Date getFrom_date() {
        return from_date;
    }


    /**
     * Sets the from_date value for this ZZOrderCode.
     * 
     * @param from_date
     */
    public void setFrom_date(java.util.Date from_date) {
        this.from_date = from_date;
    }


    /**
     * Gets the fulfillment_date value for this ZZOrderCode.
     * 
     * @return fulfillment_date
     */
    public java.util.Date getFulfillment_date() {
        return fulfillment_date;
    }


    /**
     * Sets the fulfillment_date value for this ZZOrderCode.
     * 
     * @param fulfillment_date
     */
    public void setFulfillment_date(java.util.Date fulfillment_date) {
        this.fulfillment_date = fulfillment_date;
    }


    /**
     * Gets the grace_qty value for this ZZOrderCode.
     * 
     * @return grace_qty
     */
    public int getGrace_qty() {
        return grace_qty;
    }


    /**
     * Sets the grace_qty value for this ZZOrderCode.
     * 
     * @param grace_qty
     */
    public void setGrace_qty(int grace_qty) {
        this.grace_qty = grace_qty;
    }


    /**
     * Gets the image_url value for this ZZOrderCode.
     * 
     * @return image_url
     */
    public java.lang.String getImage_url() {
        return image_url;
    }


    /**
     * Sets the image_url value for this ZZOrderCode.
     * 
     * @param image_url
     */
    public void setImage_url(java.lang.String image_url) {
        this.image_url = image_url;
    }


    /**
     * Gets the installment_billing_only value for this ZZOrderCode.
     * 
     * @return installment_billing_only
     */
    public int getInstallment_billing_only() {
        return installment_billing_only;
    }


    /**
     * Sets the installment_billing_only value for this ZZOrderCode.
     * 
     * @param installment_billing_only
     */
    public void setInstallment_billing_only(int installment_billing_only) {
        this.installment_billing_only = installment_billing_only;
    }


    /**
     * Gets the installment_plan_id value for this ZZOrderCode.
     * 
     * @return installment_plan_id
     */
    public int getInstallment_plan_id() {
        return installment_plan_id;
    }


    /**
     * Sets the installment_plan_id value for this ZZOrderCode.
     * 
     * @param installment_plan_id
     */
    public void setInstallment_plan_id(int installment_plan_id) {
        this.installment_plan_id = installment_plan_id;
    }


    /**
     * Gets the is_addon value for this ZZOrderCode.
     * 
     * @return is_addon
     */
    public int getIs_addon() {
        return is_addon;
    }


    /**
     * Sets the is_addon value for this ZZOrderCode.
     * 
     * @param is_addon
     */
    public void setIs_addon(int is_addon) {
        this.is_addon = is_addon;
    }


    /**
     * Gets the is_proforma value for this ZZOrderCode.
     * 
     * @return is_proforma
     */
    public int getIs_proforma() {
        return is_proforma;
    }


    /**
     * Sets the is_proforma value for this ZZOrderCode.
     * 
     * @param is_proforma
     */
    public void setIs_proforma(int is_proforma) {
        this.is_proforma = is_proforma;
    }


    /**
     * Gets the isbn value for this ZZOrderCode.
     * 
     * @return isbn
     */
    public java.lang.String getIsbn() {
        return isbn;
    }


    /**
     * Sets the isbn value for this ZZOrderCode.
     * 
     * @param isbn
     */
    public void setIsbn(java.lang.String isbn) {
        this.isbn = isbn;
    }


    /**
     * Gets the issue_id value for this ZZOrderCode.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this ZZOrderCode.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the item_type value for this ZZOrderCode.
     * 
     * @return item_type
     */
    public int getItem_type() {
        return item_type;
    }


    /**
     * Sets the item_type value for this ZZOrderCode.
     * 
     * @param item_type
     */
    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }


    /**
     * Gets the item_url value for this ZZOrderCode.
     * 
     * @return item_url
     */
    public java.lang.String getItem_url() {
        return item_url;
    }


    /**
     * Sets the item_url value for this ZZOrderCode.
     * 
     * @param item_url
     */
    public void setItem_url(java.lang.String item_url) {
        this.item_url = item_url;
    }


    /**
     * Gets the max_n_items value for this ZZOrderCode.
     * 
     * @return max_n_items
     */
    public int getMax_n_items() {
        return max_n_items;
    }


    /**
     * Sets the max_n_items value for this ZZOrderCode.
     * 
     * @param max_n_items
     */
    public void setMax_n_items(int max_n_items) {
        this.max_n_items = max_n_items;
    }


    /**
     * Gets the media value for this ZZOrderCode.
     * 
     * @return media
     */
    public java.lang.String getMedia() {
        return media;
    }


    /**
     * Sets the media value for this ZZOrderCode.
     * 
     * @param media
     */
    public void setMedia(java.lang.String media) {
        this.media = media;
    }


    /**
     * Gets the min_n_items value for this ZZOrderCode.
     * 
     * @return min_n_items
     */
    public int getMin_n_items() {
        return min_n_items;
    }


    /**
     * Sets the min_n_items value for this ZZOrderCode.
     * 
     * @param min_n_items
     */
    public void setMin_n_items(int min_n_items) {
        this.min_n_items = min_n_items;
    }


    /**
     * Gets the new_renewal_card_id value for this ZZOrderCode.
     * 
     * @return new_renewal_card_id
     */
    public int getNew_renewal_card_id() {
        return new_renewal_card_id;
    }


    /**
     * Sets the new_renewal_card_id value for this ZZOrderCode.
     * 
     * @param new_renewal_card_id
     */
    public void setNew_renewal_card_id(int new_renewal_card_id) {
        this.new_renewal_card_id = new_renewal_card_id;
    }


    /**
     * Gets the newsub_rate_class_id value for this ZZOrderCode.
     * 
     * @return newsub_rate_class_id
     */
    public int getNewsub_rate_class_id() {
        return newsub_rate_class_id;
    }


    /**
     * Sets the newsub_rate_class_id value for this ZZOrderCode.
     * 
     * @param newsub_rate_class_id
     */
    public void setNewsub_rate_class_id(int newsub_rate_class_id) {
        this.newsub_rate_class_id = newsub_rate_class_id;
    }


    /**
     * Gets the no_charge value for this ZZOrderCode.
     * 
     * @return no_charge
     */
    public int getNo_charge() {
        return no_charge;
    }


    /**
     * Sets the no_charge value for this ZZOrderCode.
     * 
     * @param no_charge
     */
    public void setNo_charge(int no_charge) {
        this.no_charge = no_charge;
    }


    /**
     * Gets the oc_id value for this ZZOrderCode.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this ZZOrderCode.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the order_code value for this ZZOrderCode.
     * 
     * @return order_code
     */
    public java.lang.String getOrder_code() {
        return order_code;
    }


    /**
     * Sets the order_code value for this ZZOrderCode.
     * 
     * @param order_code
     */
    public void setOrder_code(java.lang.String order_code) {
        this.order_code = order_code;
    }


    /**
     * Gets the order_code_type value for this ZZOrderCode.
     * 
     * @return order_code_type
     */
    public int getOrder_code_type() {
        return order_code_type;
    }


    /**
     * Sets the order_code_type value for this ZZOrderCode.
     * 
     * @param order_code_type
     */
    public void setOrder_code_type(int order_code_type) {
        this.order_code_type = order_code_type;
    }


    /**
     * Gets the perpetual_order value for this ZZOrderCode.
     * 
     * @return perpetual_order
     */
    public int getPerpetual_order() {
        return perpetual_order;
    }


    /**
     * Sets the perpetual_order value for this ZZOrderCode.
     * 
     * @param perpetual_order
     */
    public void setPerpetual_order(int perpetual_order) {
        this.perpetual_order = perpetual_order;
    }


    /**
     * Gets the pkg_only_item value for this ZZOrderCode.
     * 
     * @return pkg_only_item
     */
    public int getPkg_only_item() {
        return pkg_only_item;
    }


    /**
     * Sets the pkg_only_item value for this ZZOrderCode.
     * 
     * @param pkg_only_item
     */
    public void setPkg_only_item(int pkg_only_item) {
        this.pkg_only_item = pkg_only_item;
    }


    /**
     * Gets the place_anyway_if_cant_auth value for this ZZOrderCode.
     * 
     * @return place_anyway_if_cant_auth
     */
    public int getPlace_anyway_if_cant_auth() {
        return place_anyway_if_cant_auth;
    }


    /**
     * Sets the place_anyway_if_cant_auth value for this ZZOrderCode.
     * 
     * @param place_anyway_if_cant_auth
     */
    public void setPlace_anyway_if_cant_auth(int place_anyway_if_cant_auth) {
        this.place_anyway_if_cant_auth = place_anyway_if_cant_auth;
    }


    /**
     * Gets the premium value for this ZZOrderCode.
     * 
     * @return premium
     */
    public int getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this ZZOrderCode.
     * 
     * @param premium
     */
    public void setPremium(int premium) {
        this.premium = premium;
    }


    /**
     * Gets the premium_order_code_id value for this ZZOrderCode.
     * 
     * @return premium_order_code_id
     */
    public int getPremium_order_code_id() {
        return premium_order_code_id;
    }


    /**
     * Sets the premium_order_code_id value for this ZZOrderCode.
     * 
     * @param premium_order_code_id
     */
    public void setPremium_order_code_id(int premium_order_code_id) {
        this.premium_order_code_id = premium_order_code_id;
    }


    /**
     * Gets the prepayment_req value for this ZZOrderCode.
     * 
     * @return prepayment_req
     */
    public int getPrepayment_req() {
        return prepayment_req;
    }


    /**
     * Sets the prepayment_req value for this ZZOrderCode.
     * 
     * @param prepayment_req
     */
    public void setPrepayment_req(int prepayment_req) {
        this.prepayment_req = prepayment_req;
    }


    /**
     * Gets the price value for this ZZOrderCode.
     * 
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this ZZOrderCode.
     * 
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the product_author value for this ZZOrderCode.
     * 
     * @return product_author
     */
    public java.lang.String getProduct_author() {
        return product_author;
    }


    /**
     * Sets the product_author value for this ZZOrderCode.
     * 
     * @param product_author
     */
    public void setProduct_author(java.lang.String product_author) {
        this.product_author = product_author;
    }


    /**
     * Gets the product_color value for this ZZOrderCode.
     * 
     * @return product_color
     */
    public java.lang.String getProduct_color() {
        return product_color;
    }


    /**
     * Sets the product_color value for this ZZOrderCode.
     * 
     * @param product_color
     */
    public void setProduct_color(java.lang.String product_color) {
        this.product_color = product_color;
    }


    /**
     * Gets the product_size value for this ZZOrderCode.
     * 
     * @return product_size
     */
    public java.lang.String getProduct_size() {
        return product_size;
    }


    /**
     * Sets the product_size value for this ZZOrderCode.
     * 
     * @param product_size
     */
    public void setProduct_size(java.lang.String product_size) {
        this.product_size = product_size;
    }


    /**
     * Gets the product_style value for this ZZOrderCode.
     * 
     * @return product_style
     */
    public java.lang.String getProduct_style() {
        return product_style;
    }


    /**
     * Sets the product_style value for this ZZOrderCode.
     * 
     * @param product_style
     */
    public void setProduct_style(java.lang.String product_style) {
        this.product_style = product_style;
    }


    /**
     * Gets the pub_rotation_id value for this ZZOrderCode.
     * 
     * @return pub_rotation_id
     */
    public int getPub_rotation_id() {
        return pub_rotation_id;
    }


    /**
     * Sets the pub_rotation_id value for this ZZOrderCode.
     * 
     * @param pub_rotation_id
     */
    public void setPub_rotation_id(int pub_rotation_id) {
        this.pub_rotation_id = pub_rotation_id;
    }


    /**
     * Gets the qty value for this ZZOrderCode.
     * 
     * @return qty
     */
    public int getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this ZZOrderCode.
     * 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    /**
     * Gets the reinstate_proforma_on_removal value for this ZZOrderCode.
     * 
     * @return reinstate_proforma_on_removal
     */
    public int getReinstate_proforma_on_removal() {
        return reinstate_proforma_on_removal;
    }


    /**
     * Sets the reinstate_proforma_on_removal value for this ZZOrderCode.
     * 
     * @param reinstate_proforma_on_removal
     */
    public void setReinstate_proforma_on_removal(int reinstate_proforma_on_removal) {
        this.reinstate_proforma_on_removal = reinstate_proforma_on_removal;
    }


    /**
     * Gets the renew_as_proforma value for this ZZOrderCode.
     * 
     * @return renew_as_proforma
     */
    public int getRenew_as_proforma() {
        return renew_as_proforma;
    }


    /**
     * Sets the renew_as_proforma value for this ZZOrderCode.
     * 
     * @param renew_as_proforma
     */
    public void setRenew_as_proforma(int renew_as_proforma) {
        this.renew_as_proforma = renew_as_proforma;
    }


    /**
     * Gets the revenue_method value for this ZZOrderCode.
     * 
     * @return revenue_method
     */
    public int getRevenue_method() {
        return revenue_method;
    }


    /**
     * Sets the revenue_method value for this ZZOrderCode.
     * 
     * @param revenue_method
     */
    public void setRevenue_method(int revenue_method) {
        this.revenue_method = revenue_method;
    }


    /**
     * Gets the sample_copy_order value for this ZZOrderCode.
     * 
     * @return sample_copy_order
     */
    public int getSample_copy_order() {
        return sample_copy_order;
    }


    /**
     * Sets the sample_copy_order value for this ZZOrderCode.
     * 
     * @param sample_copy_order
     */
    public void setSample_copy_order(int sample_copy_order) {
        this.sample_copy_order = sample_copy_order;
    }


    /**
     * Gets the segmented_order value for this ZZOrderCode.
     * 
     * @return segmented_order
     */
    public int getSegmented_order() {
        return segmented_order;
    }


    /**
     * Sets the segmented_order value for this ZZOrderCode.
     * 
     * @param segmented_order
     */
    public void setSegmented_order(int segmented_order) {
        this.segmented_order = segmented_order;
    }


    /**
     * Gets the settle_retry_def value for this ZZOrderCode.
     * 
     * @return settle_retry_def
     */
    public java.lang.String getSettle_retry_def() {
        return settle_retry_def;
    }


    /**
     * Sets the settle_retry_def value for this ZZOrderCode.
     * 
     * @param settle_retry_def
     */
    public void setSettle_retry_def(java.lang.String settle_retry_def) {
        this.settle_retry_def = settle_retry_def;
    }


    /**
     * Gets the ship_premium_percentage value for this ZZOrderCode.
     * 
     * @return ship_premium_percentage
     */
    public int getShip_premium_percentage() {
        return ship_premium_percentage;
    }


    /**
     * Sets the ship_premium_percentage value for this ZZOrderCode.
     * 
     * @param ship_premium_percentage
     */
    public void setShip_premium_percentage(int ship_premium_percentage) {
        this.ship_premium_percentage = ship_premium_percentage;
    }


    /**
     * Gets the ship_weight value for this ZZOrderCode.
     * 
     * @return ship_weight
     */
    public java.math.BigDecimal getShip_weight() {
        return ship_weight;
    }


    /**
     * Sets the ship_weight value for this ZZOrderCode.
     * 
     * @param ship_weight
     */
    public void setShip_weight(java.math.BigDecimal ship_weight) {
        this.ship_weight = ship_weight;
    }


    /**
     * Gets the standord value for this ZZOrderCode.
     * 
     * @return standord
     */
    public int getStandord() {
        return standord;
    }


    /**
     * Sets the standord value for this ZZOrderCode.
     * 
     * @param standord
     */
    public void setStandord(int standord) {
        this.standord = standord;
    }


    /**
     * Gets the start_type value for this ZZOrderCode.
     * 
     * @return start_type
     */
    public int getStart_type() {
        return start_type;
    }


    /**
     * Sets the start_type value for this ZZOrderCode.
     * 
     * @param start_type
     */
    public void setStart_type(int start_type) {
        this.start_type = start_type;
    }


    /**
     * Gets the subscriber_site_long_desc value for this ZZOrderCode.
     * 
     * @return subscriber_site_long_desc
     */
    public java.lang.String getSubscriber_site_long_desc() {
        return subscriber_site_long_desc;
    }


    /**
     * Sets the subscriber_site_long_desc value for this ZZOrderCode.
     * 
     * @param subscriber_site_long_desc
     */
    public void setSubscriber_site_long_desc(java.lang.String subscriber_site_long_desc) {
        this.subscriber_site_long_desc = subscriber_site_long_desc;
    }


    /**
     * Gets the subscriber_site_short_desc value for this ZZOrderCode.
     * 
     * @return subscriber_site_short_desc
     */
    public java.lang.String getSubscriber_site_short_desc() {
        return subscriber_site_short_desc;
    }


    /**
     * Sets the subscriber_site_short_desc value for this ZZOrderCode.
     * 
     * @param subscriber_site_short_desc
     */
    public void setSubscriber_site_short_desc(java.lang.String subscriber_site_short_desc) {
        this.subscriber_site_short_desc = subscriber_site_short_desc;
    }


    /**
     * Gets the subscription_category_id value for this ZZOrderCode.
     * 
     * @return subscription_category_id
     */
    public int getSubscription_category_id() {
        return subscription_category_id;
    }


    /**
     * Sets the subscription_category_id value for this ZZOrderCode.
     * 
     * @param subscription_category_id
     */
    public void setSubscription_category_id(int subscription_category_id) {
        this.subscription_category_id = subscription_category_id;
    }


    /**
     * Gets the taxable value for this ZZOrderCode.
     * 
     * @return taxable
     */
    public int getTaxable() {
        return taxable;
    }


    /**
     * Sets the taxable value for this ZZOrderCode.
     * 
     * @param taxable
     */
    public void setTaxable(int taxable) {
        this.taxable = taxable;
    }


    /**
     * Gets the taxonomy value for this ZZOrderCode.
     * 
     * @return taxonomy
     */
    public java.lang.String getTaxonomy() {
        return taxonomy;
    }


    /**
     * Sets the taxonomy value for this ZZOrderCode.
     * 
     * @param taxonomy
     */
    public void setTaxonomy(java.lang.String taxonomy) {
        this.taxonomy = taxonomy;
    }


    /**
     * Gets the term_id value for this ZZOrderCode.
     * 
     * @return term_id
     */
    public int getTerm_id() {
        return term_id;
    }


    /**
     * Sets the term_id value for this ZZOrderCode.
     * 
     * @param term_id
     */
    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }


    /**
     * Gets the time_unit_options value for this ZZOrderCode.
     * 
     * @return time_unit_options
     */
    public int getTime_unit_options() {
        return time_unit_options;
    }


    /**
     * Sets the time_unit_options value for this ZZOrderCode.
     * 
     * @param time_unit_options
     */
    public void setTime_unit_options(int time_unit_options) {
        this.time_unit_options = time_unit_options;
    }


    /**
     * Gets the to_date value for this ZZOrderCode.
     * 
     * @return to_date
     */
    public java.util.Date getTo_date() {
        return to_date;
    }


    /**
     * Sets the to_date value for this ZZOrderCode.
     * 
     * @param to_date
     */
    public void setTo_date(java.util.Date to_date) {
        this.to_date = to_date;
    }


    /**
     * Gets the trial_period value for this ZZOrderCode.
     * 
     * @return trial_period
     */
    public int getTrial_period() {
        return trial_period;
    }


    /**
     * Sets the trial_period value for this ZZOrderCode.
     * 
     * @param trial_period
     */
    public void setTrial_period(int trial_period) {
        this.trial_period = trial_period;
    }


    /**
     * Gets the trial_type value for this ZZOrderCode.
     * 
     * @return trial_type
     */
    public int getTrial_type() {
        return trial_type;
    }


    /**
     * Sets the trial_type value for this ZZOrderCode.
     * 
     * @param trial_type
     */
    public void setTrial_type(int trial_type) {
        this.trial_type = trial_type;
    }


    /**
     * Gets the unit_excess value for this ZZOrderCode.
     * 
     * @return unit_excess
     */
    public int getUnit_excess() {
        return unit_excess;
    }


    /**
     * Sets the unit_excess value for this ZZOrderCode.
     * 
     * @param unit_excess
     */
    public void setUnit_excess(int unit_excess) {
        this.unit_excess = unit_excess;
    }


    /**
     * Gets the unit_type_id value for this ZZOrderCode.
     * 
     * @return unit_type_id
     */
    public int getUnit_type_id() {
        return unit_type_id;
    }


    /**
     * Sets the unit_type_id value for this ZZOrderCode.
     * 
     * @param unit_type_id
     */
    public void setUnit_type_id(int unit_type_id) {
        this.unit_type_id = unit_type_id;
    }


    /**
     * Gets the user_code value for this ZZOrderCode.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this ZZOrderCode.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZOrderCode)) return false;
        ZZOrderCode other = (ZZOrderCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.order_code_id == other.getOrder_code_id() &&
            this.active == other.getActive() &&
            this.allow_on_internet == other.getAllow_on_internet() &&
            this.audit_name_title_id == other.getAudit_name_title_id() &&
            this.audit_qual_category == other.getAudit_qual_category() &&
            this.audit_qual_source_id == other.getAudit_qual_source_id() &&
            this.audit_sales_channel_id == other.getAudit_sales_channel_id() &&
            this.audit_subscription_type_id == other.getAudit_subscription_type_id() &&
            this.auto_payment == other.getAuto_payment() &&
            this.auto_renewal == other.getAuto_renewal() &&
            this.auto_replace == other.getAuto_replace() &&
            this.backstart_tb_renewals == other.getBackstart_tb_renewals() &&
            this.charge_shipping == other.getCharge_shipping() &&
            ((this.commodity_code==null && other.getCommodity_code()==null) || 
             (this.commodity_code!=null &&
              this.commodity_code.equals(other.getCommodity_code()))) &&
            this.controlled == other.getControlled() &&
            this.credit_card_process == other.getCredit_card_process() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.disallow_install_billing == other.getDisallow_install_billing() &&
            this.discount_class_id == other.getDiscount_class_id() &&
            ((this.edition==null && other.getEdition()==null) || 
             (this.edition!=null &&
              this.edition.equals(other.getEdition()))) &&
            this.electronic_delivery == other.getElectronic_delivery() &&
            this.excess_rate_class_id == other.getExcess_rate_class_id() &&
            this.extfree_qty_limit == other.getExtfree_qty_limit() &&
            ((this.from_date==null && other.getFrom_date()==null) || 
             (this.from_date!=null &&
              this.from_date.equals(other.getFrom_date()))) &&
            ((this.fulfillment_date==null && other.getFulfillment_date()==null) || 
             (this.fulfillment_date!=null &&
              this.fulfillment_date.equals(other.getFulfillment_date()))) &&
            this.grace_qty == other.getGrace_qty() &&
            ((this.image_url==null && other.getImage_url()==null) || 
             (this.image_url!=null &&
              this.image_url.equals(other.getImage_url()))) &&
            this.installment_billing_only == other.getInstallment_billing_only() &&
            this.installment_plan_id == other.getInstallment_plan_id() &&
            this.is_addon == other.getIs_addon() &&
            this.is_proforma == other.getIs_proforma() &&
            ((this.isbn==null && other.getIsbn()==null) || 
             (this.isbn!=null &&
              this.isbn.equals(other.getIsbn()))) &&
            this.issue_id == other.getIssue_id() &&
            this.item_type == other.getItem_type() &&
            ((this.item_url==null && other.getItem_url()==null) || 
             (this.item_url!=null &&
              this.item_url.equals(other.getItem_url()))) &&
            this.max_n_items == other.getMax_n_items() &&
            ((this.media==null && other.getMedia()==null) || 
             (this.media!=null &&
              this.media.equals(other.getMedia()))) &&
            this.min_n_items == other.getMin_n_items() &&
            this.new_renewal_card_id == other.getNew_renewal_card_id() &&
            this.newsub_rate_class_id == other.getNewsub_rate_class_id() &&
            this.no_charge == other.getNo_charge() &&
            this.oc_id == other.getOc_id() &&
            ((this.order_code==null && other.getOrder_code()==null) || 
             (this.order_code!=null &&
              this.order_code.equals(other.getOrder_code()))) &&
            this.order_code_type == other.getOrder_code_type() &&
            this.perpetual_order == other.getPerpetual_order() &&
            this.pkg_only_item == other.getPkg_only_item() &&
            this.place_anyway_if_cant_auth == other.getPlace_anyway_if_cant_auth() &&
            this.premium == other.getPremium() &&
            this.premium_order_code_id == other.getPremium_order_code_id() &&
            this.prepayment_req == other.getPrepayment_req() &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.product_author==null && other.getProduct_author()==null) || 
             (this.product_author!=null &&
              this.product_author.equals(other.getProduct_author()))) &&
            ((this.product_color==null && other.getProduct_color()==null) || 
             (this.product_color!=null &&
              this.product_color.equals(other.getProduct_color()))) &&
            ((this.product_size==null && other.getProduct_size()==null) || 
             (this.product_size!=null &&
              this.product_size.equals(other.getProduct_size()))) &&
            ((this.product_style==null && other.getProduct_style()==null) || 
             (this.product_style!=null &&
              this.product_style.equals(other.getProduct_style()))) &&
            this.pub_rotation_id == other.getPub_rotation_id() &&
            this.qty == other.getQty() &&
            this.reinstate_proforma_on_removal == other.getReinstate_proforma_on_removal() &&
            this.renew_as_proforma == other.getRenew_as_proforma() &&
            this.revenue_method == other.getRevenue_method() &&
            this.sample_copy_order == other.getSample_copy_order() &&
            this.segmented_order == other.getSegmented_order() &&
            ((this.settle_retry_def==null && other.getSettle_retry_def()==null) || 
             (this.settle_retry_def!=null &&
              this.settle_retry_def.equals(other.getSettle_retry_def()))) &&
            this.ship_premium_percentage == other.getShip_premium_percentage() &&
            ((this.ship_weight==null && other.getShip_weight()==null) || 
             (this.ship_weight!=null &&
              this.ship_weight.equals(other.getShip_weight()))) &&
            this.standord == other.getStandord() &&
            this.start_type == other.getStart_type() &&
            ((this.subscriber_site_long_desc==null && other.getSubscriber_site_long_desc()==null) || 
             (this.subscriber_site_long_desc!=null &&
              this.subscriber_site_long_desc.equals(other.getSubscriber_site_long_desc()))) &&
            ((this.subscriber_site_short_desc==null && other.getSubscriber_site_short_desc()==null) || 
             (this.subscriber_site_short_desc!=null &&
              this.subscriber_site_short_desc.equals(other.getSubscriber_site_short_desc()))) &&
            this.subscription_category_id == other.getSubscription_category_id() &&
            this.taxable == other.getTaxable() &&
            ((this.taxonomy==null && other.getTaxonomy()==null) || 
             (this.taxonomy!=null &&
              this.taxonomy.equals(other.getTaxonomy()))) &&
            this.term_id == other.getTerm_id() &&
            this.time_unit_options == other.getTime_unit_options() &&
            ((this.to_date==null && other.getTo_date()==null) || 
             (this.to_date!=null &&
              this.to_date.equals(other.getTo_date()))) &&
            this.trial_period == other.getTrial_period() &&
            this.trial_type == other.getTrial_type() &&
            this.unit_excess == other.getUnit_excess() &&
            this.unit_type_id == other.getUnit_type_id() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code())));
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
        _hashCode += getOrder_code_id();
        _hashCode += getActive();
        _hashCode += getAllow_on_internet();
        _hashCode += getAudit_name_title_id();
        _hashCode += getAudit_qual_category();
        _hashCode += getAudit_qual_source_id();
        _hashCode += getAudit_sales_channel_id();
        _hashCode += getAudit_subscription_type_id();
        _hashCode += getAuto_payment();
        _hashCode += getAuto_renewal();
        _hashCode += getAuto_replace();
        _hashCode += getBackstart_tb_renewals();
        _hashCode += getCharge_shipping();
        if (getCommodity_code() != null) {
            _hashCode += getCommodity_code().hashCode();
        }
        _hashCode += getControlled();
        _hashCode += getCredit_card_process();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getDisallow_install_billing();
        _hashCode += getDiscount_class_id();
        if (getEdition() != null) {
            _hashCode += getEdition().hashCode();
        }
        _hashCode += getElectronic_delivery();
        _hashCode += getExcess_rate_class_id();
        _hashCode += getExtfree_qty_limit();
        if (getFrom_date() != null) {
            _hashCode += getFrom_date().hashCode();
        }
        if (getFulfillment_date() != null) {
            _hashCode += getFulfillment_date().hashCode();
        }
        _hashCode += getGrace_qty();
        if (getImage_url() != null) {
            _hashCode += getImage_url().hashCode();
        }
        _hashCode += getInstallment_billing_only();
        _hashCode += getInstallment_plan_id();
        _hashCode += getIs_addon();
        _hashCode += getIs_proforma();
        if (getIsbn() != null) {
            _hashCode += getIsbn().hashCode();
        }
        _hashCode += getIssue_id();
        _hashCode += getItem_type();
        if (getItem_url() != null) {
            _hashCode += getItem_url().hashCode();
        }
        _hashCode += getMax_n_items();
        if (getMedia() != null) {
            _hashCode += getMedia().hashCode();
        }
        _hashCode += getMin_n_items();
        _hashCode += getNew_renewal_card_id();
        _hashCode += getNewsub_rate_class_id();
        _hashCode += getNo_charge();
        _hashCode += getOc_id();
        if (getOrder_code() != null) {
            _hashCode += getOrder_code().hashCode();
        }
        _hashCode += getOrder_code_type();
        _hashCode += getPerpetual_order();
        _hashCode += getPkg_only_item();
        _hashCode += getPlace_anyway_if_cant_auth();
        _hashCode += getPremium();
        _hashCode += getPremium_order_code_id();
        _hashCode += getPrepayment_req();
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getProduct_author() != null) {
            _hashCode += getProduct_author().hashCode();
        }
        if (getProduct_color() != null) {
            _hashCode += getProduct_color().hashCode();
        }
        if (getProduct_size() != null) {
            _hashCode += getProduct_size().hashCode();
        }
        if (getProduct_style() != null) {
            _hashCode += getProduct_style().hashCode();
        }
        _hashCode += getPub_rotation_id();
        _hashCode += getQty();
        _hashCode += getReinstate_proforma_on_removal();
        _hashCode += getRenew_as_proforma();
        _hashCode += getRevenue_method();
        _hashCode += getSample_copy_order();
        _hashCode += getSegmented_order();
        if (getSettle_retry_def() != null) {
            _hashCode += getSettle_retry_def().hashCode();
        }
        _hashCode += getShip_premium_percentage();
        if (getShip_weight() != null) {
            _hashCode += getShip_weight().hashCode();
        }
        _hashCode += getStandord();
        _hashCode += getStart_type();
        if (getSubscriber_site_long_desc() != null) {
            _hashCode += getSubscriber_site_long_desc().hashCode();
        }
        if (getSubscriber_site_short_desc() != null) {
            _hashCode += getSubscriber_site_short_desc().hashCode();
        }
        _hashCode += getSubscription_category_id();
        _hashCode += getTaxable();
        if (getTaxonomy() != null) {
            _hashCode += getTaxonomy().hashCode();
        }
        _hashCode += getTerm_id();
        _hashCode += getTime_unit_options();
        if (getTo_date() != null) {
            _hashCode += getTo_date().hashCode();
        }
        _hashCode += getTrial_period();
        _hashCode += getTrial_type();
        _hashCode += getUnit_excess();
        _hashCode += getUnit_type_id();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZOrderCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZOrderCode"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("active");
        attrField.setXmlName(new javax.xml.namespace.QName("", "active"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("allow_on_internet");
        attrField.setXmlName(new javax.xml.namespace.QName("", "allow_on_internet"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_name_title_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_name_title_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_qual_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_qual_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_qual_source_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_qual_source_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_sales_channel_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_sales_channel_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_subscription_type_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_subscription_type_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_payment");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_payment"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_renewal");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_renewal"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("auto_replace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "auto_replace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("backstart_tb_renewals");
        attrField.setXmlName(new javax.xml.namespace.QName("", "backstart_tb_renewals"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("charge_shipping");
        attrField.setXmlName(new javax.xml.namespace.QName("", "charge_shipping"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("commodity_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "commodity_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("controlled");
        attrField.setXmlName(new javax.xml.namespace.QName("", "controlled"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_card_process");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_card_process"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("disallow_install_billing");
        attrField.setXmlName(new javax.xml.namespace.QName("", "disallow_install_billing"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("edition");
        attrField.setXmlName(new javax.xml.namespace.QName("", "edition"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("electronic_delivery");
        attrField.setXmlName(new javax.xml.namespace.QName("", "electronic_delivery"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("excess_rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "excess_rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("extfree_qty_limit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "extfree_qty_limit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("from_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "from_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fulfillment_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fulfillment_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("grace_qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "grace_qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("image_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "image_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_billing_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_billing_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("installment_plan_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "installment_plan_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_addon");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_addon"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_proforma");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_proforma"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("isbn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "isbn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("item_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "item_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("max_n_items");
        attrField.setXmlName(new javax.xml.namespace.QName("", "max_n_items"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("media");
        attrField.setXmlName(new javax.xml.namespace.QName("", "media"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("min_n_items");
        attrField.setXmlName(new javax.xml.namespace.QName("", "min_n_items"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_renewal_card_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_renewal_card_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("newsub_rate_class_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "newsub_rate_class_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("no_charge");
        attrField.setXmlName(new javax.xml.namespace.QName("", "no_charge"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_code_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_code_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("perpetual_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "perpetual_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_only_item");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_only_item"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("place_anyway_if_cant_auth");
        attrField.setXmlName(new javax.xml.namespace.QName("", "place_anyway_if_cant_auth"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("premium");
        attrField.setXmlName(new javax.xml.namespace.QName("", "premium"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("premium_order_code_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "premium_order_code_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prepayment_req");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prepayment_req"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_author");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_author"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_color");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_color"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_size");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_size"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pub_rotation_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pub_rotation_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reinstate_proforma_on_removal");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reinstate_proforma_on_removal"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renew_as_proforma");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renew_as_proforma"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("revenue_method");
        attrField.setXmlName(new javax.xml.namespace.QName("", "revenue_method"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sample_copy_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sample_copy_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("segmented_order");
        attrField.setXmlName(new javax.xml.namespace.QName("", "segmented_order"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("settle_retry_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "settle_retry_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ship_premium_percentage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ship_premium_percentage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ship_weight");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ship_weight"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("standord");
        attrField.setXmlName(new javax.xml.namespace.QName("", "standord"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("start_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "start_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscriber_site_long_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscriber_site_long_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscriber_site_short_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscriber_site_short_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscription_category_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscription_category_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("taxable");
        attrField.setXmlName(new javax.xml.namespace.QName("", "taxable"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("taxonomy");
        attrField.setXmlName(new javax.xml.namespace.QName("", "taxonomy"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("term_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "term_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("time_unit_options");
        attrField.setXmlName(new javax.xml.namespace.QName("", "time_unit_options"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("to_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "to_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("trial_period");
        attrField.setXmlName(new javax.xml.namespace.QName("", "trial_period"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("trial_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "trial_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_excess");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_excess"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("unit_type_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "unit_type_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
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
