/**
 * Unit_order_item_informationOrder_item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Unit_order_item_informationOrder_item  extends Think.XmlWebServices.ZZOrderItem  implements java.io.Serializable {
    private Think.XmlWebServices.Cc_status_enum cc_status;  // attribute

    private int cc_quantity_available;  // attribute

    private Think.XmlWebServices.Excess_unit_usage cc_excess_unit_usage;  // attribute

    private java.lang.Integer cc_max_checkout;  // attribute

    private Think.XmlWebServices.ZZBoolean cc_needs_checkin;  // attribute

    public Unit_order_item_informationOrder_item() {
    }

    public Unit_order_item_informationOrder_item(
           int orderhdr_id,
           int order_item_seq,
           int addon_to_order_item_seq,
           int addon_to_orderhdr_id,
           int agency_customer_id,
           java.lang.String agent_ref_nbr,
           int alt_ship_customer_address_seq,
           int alt_ship_customer_id,
           int alt_ship_del_calc,
           int asynchronous_auto_renew,
           int attach_exist,
           int audit_name_title_id,
           int audit_qual_category,
           int audit_qual_source_id,
           int audit_sales_channel_id,
           int audit_subscription_type_id,
           int auto_payment,
           int auto_renew_notify_sent,
           int backord_qty,
           java.util.Date bill_date,
           int bill_to_customer_address_seq,
           int bill_to_customer_id,
           java.lang.String billing_def,
           int billing_def_test_seq,
           int billing_type,
           int bundle_qty,
           int calendar_unit,
           java.util.Calendar cancel_date,
           java.lang.String cancel_reason,
           int change_qty_flag,
           int charge_on_cancellation,
           java.lang.String currency,
           int customer_address_seq,
           int customer_group_id,
           int customer_id,
           int date_stamp,
           int deal_id,
           java.lang.String delivery_method,
           int delivery_method_perm,
           int disc_class_effective_seq,
           int discount_card_seq,
           int discount_class_id,
           java.lang.String distribution_method,
           int duration,
           int electronic_delivery,
           java.lang.String electronic_document_identifier,
           int ex_rate_class_effective_seq,
           int ex_rate_class_id,
           int ex_ratecard_seq,
           java.math.BigDecimal exchange_rate,
           java.util.Date expire_date,
           int ext_iss_left,
           int ext_iss_tot,
           int extended_days,
           java.math.BigDecimal extended_rate,
           java.util.Date fulfillment_date,
           int generic_promotion_code_seq,
           java.math.BigDecimal gross_base_amount,
           java.math.BigDecimal gross_local_amount,
           int group_order,
           int has_been_renewed,
           int has_delivery_charge,
           int has_premium,
           int has_tax,
           int installment_plan_id,
           int inventory_id,
           java.util.Date invoice_date,
           int invoice_id,
           int is_back_ordered,
           int is_complimentary,
           int is_proforma,
           java.lang.String item_url,
           java.util.Date last_inv_date,
           java.util.Date last_ren_date,
           java.util.Calendar last_tax_invoice_date,
           java.math.BigDecimal manual_disc_amt_base,
           java.math.BigDecimal manual_disc_amt_local,
           java.math.BigDecimal manual_disc_percentage,
           int max_check_out_amt,
           java.math.BigDecimal multiline_disc_amount,
           int multiline_disc_eff_seq,
           java.lang.String multiline_discount_schedule,
           int n_cal_units_per_seg,
           int n_checked_out,
           int n_days_graced,
           int n_del_iss_left,
           int n_inv_efforts,
           int n_issues_left,
           int n_items_per_seg,
           int n_nonpaid_issues,
           int n_remaining_nonpaid_issues,
           int n_remaining_paid_issues,
           int n_ren_effort,
           int n_segments_left,
           int n_tax_updates,
           java.math.BigDecimal net_base_amount,
           java.math.BigDecimal net_local_amount,
           int note_exist,
           int number_volume_sets,
           int oc_id,
           java.lang.String order_category,
           int order_code_id,
           java.util.Calendar order_date,
           int order_item_type,
           int order_qty,
           int order_status,
           int order_type,
           int orig_order_qty,
           int package_content_seq,
           int package_id,
           int package_instance,
           int payment_account_seq,
           int payment_status,
           int percent_of_basic_price,
           int perpetual_order,
           int pkg_def_id,
           int pkg_item_seq,
           int prem_to_order_item_seq,
           int prepayment_req,
           int product_id,
           int pub_rotation_id,
           java.util.Date qual_date,
           int rate_class_effective_seq,
           int rate_class_id,
           int ratecard_seq,
           int refund_status,
           int renew_to_customer_address_seq,
           int renew_to_customer_id,
           int renewal_category,
           java.lang.String renewal_def,
           int renewal_def_test_seq,
           int renewal_order_item_seq,
           int renewal_orderhdr_id,
           int renewal_status,
           int renewed_from_subscrip_id,
           int revenue_method,
           java.util.Date segment_expire_date,
           int service_exist,
           int ship_qty,
           java.lang.String shipping_price_list,
           int single_issue_id,
           int source_code_id,
           java.util.Date squal_date,
           java.util.Date start_date,
           int start_issue_id,
           int stop_issue_id,
           int subscrip_id,
           int subscrip_start_type,
           int subscription_def_id,
           int time_unit_options,
           java.math.BigDecimal total_tax_base_amount,
           java.math.BigDecimal total_tax_local_amount,
           int trial_period,
           int trial_type,
           int unit_excess,
           int unit_type_id,
           java.lang.String user_code,
           Think.XmlWebServices.Cc_status_enum cc_status,
           int cc_quantity_available,
           Think.XmlWebServices.Excess_unit_usage cc_excess_unit_usage,
           java.lang.Integer cc_max_checkout,
           Think.XmlWebServices.ZZBoolean cc_needs_checkin) {
        super(
            orderhdr_id,
            order_item_seq,
            addon_to_order_item_seq,
            addon_to_orderhdr_id,
            agency_customer_id,
            agent_ref_nbr,
            alt_ship_customer_address_seq,
            alt_ship_customer_id,
            alt_ship_del_calc,
            asynchronous_auto_renew,
            attach_exist,
            audit_name_title_id,
            audit_qual_category,
            audit_qual_source_id,
            audit_sales_channel_id,
            audit_subscription_type_id,
            auto_payment,
            auto_renew_notify_sent,
            backord_qty,
            bill_date,
            bill_to_customer_address_seq,
            bill_to_customer_id,
            billing_def,
            billing_def_test_seq,
            billing_type,
            bundle_qty,
            calendar_unit,
            cancel_date,
            cancel_reason,
            change_qty_flag,
            charge_on_cancellation,
            currency,
            customer_address_seq,
            customer_group_id,
            customer_id,
            date_stamp,
            deal_id,
            delivery_method,
            delivery_method_perm,
            disc_class_effective_seq,
            discount_card_seq,
            discount_class_id,
            distribution_method,
            duration,
            electronic_delivery,
            electronic_document_identifier,
            ex_rate_class_effective_seq,
            ex_rate_class_id,
            ex_ratecard_seq,
            exchange_rate,
            expire_date,
            ext_iss_left,
            ext_iss_tot,
            extended_days,
            extended_rate,
            fulfillment_date,
            generic_promotion_code_seq,
            gross_base_amount,
            gross_local_amount,
            group_order,
            has_been_renewed,
            has_delivery_charge,
            has_premium,
            has_tax,
            installment_plan_id,
            inventory_id,
            invoice_date,
            invoice_id,
            is_back_ordered,
            is_complimentary,
            is_proforma,
            item_url,
            last_inv_date,
            last_ren_date,
            last_tax_invoice_date,
            manual_disc_amt_base,
            manual_disc_amt_local,
            manual_disc_percentage,
            max_check_out_amt,
            multiline_disc_amount,
            multiline_disc_eff_seq,
            multiline_discount_schedule,
            n_cal_units_per_seg,
            n_checked_out,
            n_days_graced,
            n_del_iss_left,
            n_inv_efforts,
            n_issues_left,
            n_items_per_seg,
            n_nonpaid_issues,
            n_remaining_nonpaid_issues,
            n_remaining_paid_issues,
            n_ren_effort,
            n_segments_left,
            n_tax_updates,
            net_base_amount,
            net_local_amount,
            note_exist,
            number_volume_sets,
            oc_id,
            order_category,
            order_code_id,
            order_date,
            order_item_type,
            order_qty,
            order_status,
            order_type,
            orig_order_qty,
            package_content_seq,
            package_id,
            package_instance,
            payment_account_seq,
            payment_status,
            percent_of_basic_price,
            perpetual_order,
            pkg_def_id,
            pkg_item_seq,
            prem_to_order_item_seq,
            prepayment_req,
            product_id,
            pub_rotation_id,
            qual_date,
            rate_class_effective_seq,
            rate_class_id,
            ratecard_seq,
            refund_status,
            renew_to_customer_address_seq,
            renew_to_customer_id,
            renewal_category,
            renewal_def,
            renewal_def_test_seq,
            renewal_order_item_seq,
            renewal_orderhdr_id,
            renewal_status,
            renewed_from_subscrip_id,
            revenue_method,
            segment_expire_date,
            service_exist,
            ship_qty,
            shipping_price_list,
            single_issue_id,
            source_code_id,
            squal_date,
            start_date,
            start_issue_id,
            stop_issue_id,
            subscrip_id,
            subscrip_start_type,
            subscription_def_id,
            time_unit_options,
            total_tax_base_amount,
            total_tax_local_amount,
            trial_period,
            trial_type,
            unit_excess,
            unit_type_id,
            user_code);
        this.cc_status = cc_status;
        this.cc_quantity_available = cc_quantity_available;
        this.cc_excess_unit_usage = cc_excess_unit_usage;
        this.cc_max_checkout = cc_max_checkout;
        this.cc_needs_checkin = cc_needs_checkin;
    }


    /**
     * Gets the cc_status value for this Unit_order_item_informationOrder_item.
     * 
     * @return cc_status
     */
    public Think.XmlWebServices.Cc_status_enum getCc_status() {
        return cc_status;
    }


    /**
     * Sets the cc_status value for this Unit_order_item_informationOrder_item.
     * 
     * @param cc_status
     */
    public void setCc_status(Think.XmlWebServices.Cc_status_enum cc_status) {
        this.cc_status = cc_status;
    }


    /**
     * Gets the cc_quantity_available value for this Unit_order_item_informationOrder_item.
     * 
     * @return cc_quantity_available
     */
    public int getCc_quantity_available() {
        return cc_quantity_available;
    }


    /**
     * Sets the cc_quantity_available value for this Unit_order_item_informationOrder_item.
     * 
     * @param cc_quantity_available
     */
    public void setCc_quantity_available(int cc_quantity_available) {
        this.cc_quantity_available = cc_quantity_available;
    }


    /**
     * Gets the cc_excess_unit_usage value for this Unit_order_item_informationOrder_item.
     * 
     * @return cc_excess_unit_usage
     */
    public Think.XmlWebServices.Excess_unit_usage getCc_excess_unit_usage() {
        return cc_excess_unit_usage;
    }


    /**
     * Sets the cc_excess_unit_usage value for this Unit_order_item_informationOrder_item.
     * 
     * @param cc_excess_unit_usage
     */
    public void setCc_excess_unit_usage(Think.XmlWebServices.Excess_unit_usage cc_excess_unit_usage) {
        this.cc_excess_unit_usage = cc_excess_unit_usage;
    }


    /**
     * Gets the cc_max_checkout value for this Unit_order_item_informationOrder_item.
     * 
     * @return cc_max_checkout
     */
    public java.lang.Integer getCc_max_checkout() {
        return cc_max_checkout;
    }


    /**
     * Sets the cc_max_checkout value for this Unit_order_item_informationOrder_item.
     * 
     * @param cc_max_checkout
     */
    public void setCc_max_checkout(java.lang.Integer cc_max_checkout) {
        this.cc_max_checkout = cc_max_checkout;
    }


    /**
     * Gets the cc_needs_checkin value for this Unit_order_item_informationOrder_item.
     * 
     * @return cc_needs_checkin
     */
    public Think.XmlWebServices.ZZBoolean getCc_needs_checkin() {
        return cc_needs_checkin;
    }


    /**
     * Sets the cc_needs_checkin value for this Unit_order_item_informationOrder_item.
     * 
     * @param cc_needs_checkin
     */
    public void setCc_needs_checkin(Think.XmlWebServices.ZZBoolean cc_needs_checkin) {
        this.cc_needs_checkin = cc_needs_checkin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Unit_order_item_informationOrder_item)) return false;
        Unit_order_item_informationOrder_item other = (Unit_order_item_informationOrder_item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cc_status==null && other.getCc_status()==null) || 
             (this.cc_status!=null &&
              this.cc_status.equals(other.getCc_status()))) &&
            this.cc_quantity_available == other.getCc_quantity_available() &&
            ((this.cc_excess_unit_usage==null && other.getCc_excess_unit_usage()==null) || 
             (this.cc_excess_unit_usage!=null &&
              this.cc_excess_unit_usage.equals(other.getCc_excess_unit_usage()))) &&
            ((this.cc_max_checkout==null && other.getCc_max_checkout()==null) || 
             (this.cc_max_checkout!=null &&
              this.cc_max_checkout.equals(other.getCc_max_checkout()))) &&
            ((this.cc_needs_checkin==null && other.getCc_needs_checkin()==null) || 
             (this.cc_needs_checkin!=null &&
              this.cc_needs_checkin.equals(other.getCc_needs_checkin())));
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
        if (getCc_status() != null) {
            _hashCode += getCc_status().hashCode();
        }
        _hashCode += getCc_quantity_available();
        if (getCc_excess_unit_usage() != null) {
            _hashCode += getCc_excess_unit_usage().hashCode();
        }
        if (getCc_max_checkout() != null) {
            _hashCode += getCc_max_checkout().hashCode();
        }
        if (getCc_needs_checkin() != null) {
            _hashCode += getCc_needs_checkin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Unit_order_item_informationOrder_item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>unit_order_item_information>order_item"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cc_status_enum"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_quantity_available");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_quantity_available"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_excess_unit_usage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_excess_unit_usage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "excess_unit_usage"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_max_checkout");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_max_checkout"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_needs_checkin");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_needs_checkin"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
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
