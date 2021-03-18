/**
 * Td_item_paid_for.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_item_paid_for  extends Think.XmlWebServices.ZZTDOrderItem  implements java.io.Serializable {
    private java.math.BigDecimal price_paid;  // attribute

    private java.math.BigDecimal tax_paid;  // attribute

    private java.math.BigDecimal delivery_paid;  // attribute

    private java.math.BigDecimal comm_paid;  // attribute

    private java.math.BigDecimal total_paid;  // attribute

    public Td_item_paid_for() {
    }

    public Td_item_paid_for(
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
           java.lang.String order_code_id_descr,
           java.lang.String user_code_descr,
           java.lang.String currency_descr,
           java.lang.String delivery_method_descr,
           java.lang.String source_code_id_descr,
           java.lang.String order_category_descr,
           java.lang.String cancel_reason_descr,
           java.lang.String audit_qual_source_id_descr,
           java.lang.String audit_subscription_type_id_descr,
           java.lang.String audit_name_title_id_descr,
           java.lang.String audit_sales_channel_id_descr,
           java.lang.String discount_class_id_descr,
           java.lang.String oc_id_descr,
           java.lang.String rate_class_id_descr,
           java.lang.String agency_customer_id_descr,
           java.lang.String distribution_method_descr,
           java.lang.String billing_def_descr,
           java.lang.String renewal_def_descr,
           java.lang.String unit_type_id_descr,
           java.lang.String ex_rate_class_id_descr,
           java.lang.String pub_rotation_id_descr,
           java.lang.String subscription_def_id_descr,
           java.lang.String product_id_descr,
           java.lang.String start_issue_id_descr,
           java.lang.String stop_issue_id_descr,
           java.lang.String single_issue_id_descr,
           java.lang.String pkg_def_id_descr,
           java.lang.String deal_id_descr,
           java.lang.String order_status_descr,
           java.lang.String payment_status_descr,
           java.lang.String audit_qual_category_descr,
           java.lang.String auto_payment_descr,
           java.lang.String billing_type_descr,
           java.lang.String calendar_unit_descr,
           java.lang.String order_item_type_descr,
           java.lang.String order_type_descr,
           java.lang.String refund_status_descr,
           java.lang.String renewal_category_descr,
           java.lang.String renewal_status_descr,
           java.lang.String revenue_method_descr,
           java.lang.String subscrip_start_type_descr,
           java.lang.String trial_type_descr,
           java.lang.String unit_excess_descr,
           java.math.BigDecimal price_paid,
           java.math.BigDecimal tax_paid,
           java.math.BigDecimal delivery_paid,
           java.math.BigDecimal comm_paid,
           java.math.BigDecimal total_paid) {
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
            user_code,
            order_code_id_descr,
            user_code_descr,
            currency_descr,
            delivery_method_descr,
            source_code_id_descr,
            order_category_descr,
            cancel_reason_descr,
            audit_qual_source_id_descr,
            audit_subscription_type_id_descr,
            audit_name_title_id_descr,
            audit_sales_channel_id_descr,
            discount_class_id_descr,
            oc_id_descr,
            rate_class_id_descr,
            agency_customer_id_descr,
            distribution_method_descr,
            billing_def_descr,
            renewal_def_descr,
            unit_type_id_descr,
            ex_rate_class_id_descr,
            pub_rotation_id_descr,
            subscription_def_id_descr,
            product_id_descr,
            start_issue_id_descr,
            stop_issue_id_descr,
            single_issue_id_descr,
            pkg_def_id_descr,
            deal_id_descr,
            order_status_descr,
            payment_status_descr,
            audit_qual_category_descr,
            auto_payment_descr,
            billing_type_descr,
            calendar_unit_descr,
            order_item_type_descr,
            order_type_descr,
            refund_status_descr,
            renewal_category_descr,
            renewal_status_descr,
            revenue_method_descr,
            subscrip_start_type_descr,
            trial_type_descr,
            unit_excess_descr);
        this.price_paid = price_paid;
        this.tax_paid = tax_paid;
        this.delivery_paid = delivery_paid;
        this.comm_paid = comm_paid;
        this.total_paid = total_paid;
    }


    /**
     * Gets the price_paid value for this Td_item_paid_for.
     * 
     * @return price_paid
     */
    public java.math.BigDecimal getPrice_paid() {
        return price_paid;
    }


    /**
     * Sets the price_paid value for this Td_item_paid_for.
     * 
     * @param price_paid
     */
    public void setPrice_paid(java.math.BigDecimal price_paid) {
        this.price_paid = price_paid;
    }


    /**
     * Gets the tax_paid value for this Td_item_paid_for.
     * 
     * @return tax_paid
     */
    public java.math.BigDecimal getTax_paid() {
        return tax_paid;
    }


    /**
     * Sets the tax_paid value for this Td_item_paid_for.
     * 
     * @param tax_paid
     */
    public void setTax_paid(java.math.BigDecimal tax_paid) {
        this.tax_paid = tax_paid;
    }


    /**
     * Gets the delivery_paid value for this Td_item_paid_for.
     * 
     * @return delivery_paid
     */
    public java.math.BigDecimal getDelivery_paid() {
        return delivery_paid;
    }


    /**
     * Sets the delivery_paid value for this Td_item_paid_for.
     * 
     * @param delivery_paid
     */
    public void setDelivery_paid(java.math.BigDecimal delivery_paid) {
        this.delivery_paid = delivery_paid;
    }


    /**
     * Gets the comm_paid value for this Td_item_paid_for.
     * 
     * @return comm_paid
     */
    public java.math.BigDecimal getComm_paid() {
        return comm_paid;
    }


    /**
     * Sets the comm_paid value for this Td_item_paid_for.
     * 
     * @param comm_paid
     */
    public void setComm_paid(java.math.BigDecimal comm_paid) {
        this.comm_paid = comm_paid;
    }


    /**
     * Gets the total_paid value for this Td_item_paid_for.
     * 
     * @return total_paid
     */
    public java.math.BigDecimal getTotal_paid() {
        return total_paid;
    }


    /**
     * Sets the total_paid value for this Td_item_paid_for.
     * 
     * @param total_paid
     */
    public void setTotal_paid(java.math.BigDecimal total_paid) {
        this.total_paid = total_paid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_item_paid_for)) return false;
        Td_item_paid_for other = (Td_item_paid_for) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.price_paid==null && other.getPrice_paid()==null) || 
             (this.price_paid!=null &&
              this.price_paid.equals(other.getPrice_paid()))) &&
            ((this.tax_paid==null && other.getTax_paid()==null) || 
             (this.tax_paid!=null &&
              this.tax_paid.equals(other.getTax_paid()))) &&
            ((this.delivery_paid==null && other.getDelivery_paid()==null) || 
             (this.delivery_paid!=null &&
              this.delivery_paid.equals(other.getDelivery_paid()))) &&
            ((this.comm_paid==null && other.getComm_paid()==null) || 
             (this.comm_paid!=null &&
              this.comm_paid.equals(other.getComm_paid()))) &&
            ((this.total_paid==null && other.getTotal_paid()==null) || 
             (this.total_paid!=null &&
              this.total_paid.equals(other.getTotal_paid())));
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
        if (getPrice_paid() != null) {
            _hashCode += getPrice_paid().hashCode();
        }
        if (getTax_paid() != null) {
            _hashCode += getTax_paid().hashCode();
        }
        if (getDelivery_paid() != null) {
            _hashCode += getDelivery_paid().hashCode();
        }
        if (getComm_paid() != null) {
            _hashCode += getComm_paid().hashCode();
        }
        if (getTotal_paid() != null) {
            _hashCode += getTotal_paid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_item_paid_for.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_item_paid_for"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("price_paid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "price_paid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tax_paid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tax_paid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delivery_paid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delivery_paid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("comm_paid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "comm_paid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("total_paid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "total_paid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
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
