/**
 * Td_effort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_effort  extends Think.XmlWebServices.ZZTDWorkTable  implements java.io.Serializable {
    private Think.XmlWebServices.Td_renewal_offer[] td_renewal_offer;

    private Think.XmlWebServices.Td_billing_amount[] td_billing_amount;

    private Think.XmlWebServices.Td_promotion[] td_promotion;

    private java.lang.String message_string;  // attribute

    public Td_effort() {
    }

    public Td_effort(
           int job_id,
           int work_table_seq,
           int added,
           int audit_name_title_id,
           int audit_qual_source_id,
           int audit_sales_channel_id,
           int audit_subscription_type_id,
           java.lang.String billing_code,
           java.lang.String billing_def,
           int billing_def_test_seq,
           int billing_effort_number,
           java.lang.String billing_group_barcode,
           int billing_installment_number,
           java.lang.String billing_item_barcode,
           java.lang.String currency,
           int customer_group_customer_id,
           int customer_id,
           int customer_login_id,
           int discount_class_id,
           int duration,
           java.lang.String email,
           java.lang.String enumeration,
           int event_queue_id,
           int has_tax,
           byte[] insert_bits,
           int inventory_id,
           int invoice_id,
           int invoice_number,
           java.util.Date issue_date,
           int issue_id,
           int job_ren_offer_id,
           java.lang.String label1,
           java.lang.String label10,
           java.lang.String label2,
           java.lang.String label3,
           java.lang.String label4,
           java.lang.String label5,
           java.lang.String label6,
           java.lang.String label7,
           java.lang.String label8,
           java.lang.String label9,
           int new_audit_qual_category,
           int new_n_deferred_issues_left,
           int oc_id,
           int old_audit_qual_category,
           java.util.Date order_date,
           int order_item_seq,
           int orderhdr_id,
           java.lang.String other_label1,
           java.lang.String other_label10,
           java.lang.String other_label2,
           java.lang.String other_label3,
           java.lang.String other_label4,
           java.lang.String other_label5,
           java.lang.String other_label6,
           java.lang.String other_label7,
           java.lang.String other_label8,
           java.lang.String other_label9,
           int package_id,
           java.math.BigDecimal pay_amount,
           java.lang.String pay_auth_code,
           java.util.Date pay_auth_date,
           java.lang.String pay_check_number,
           java.util.Date pay_clear_date,
           int pay_clear_status,
           java.lang.String pay_credit_card_info,
           java.util.Date pay_exp_date,
           java.lang.String pay_id_nbr,
           java.lang.String pay_ref_nbr,
           java.lang.String pay_status_reason,
           int payment_account_seq,
           int payment_seq,
           int percent_of_basic_price,
           java.lang.String priority_sort_string,
           java.lang.String product_color,
           int product_id,
           java.lang.String product_size,
           java.lang.String product_style,
           byte[] promotion_bits,
           java.util.Date qual_date,
           int quantity,
           int quantity_backordered,
           int rate_class_id,
           int refund_via_process,
           int renewal_card_id,
           java.lang.String renewal_def,
           int renewal_def_test_seq,
           int renewal_effort_number,
           int revenue_method,
           int selected,
           int send_to_customer_address_seq,
           int send_to_customer_id,
           int service_seq,
           java.lang.String sort_string,
           java.lang.String source_code,
           int source_code_id,
           java.lang.String source_format,
           int source_job_id,
           int source_work_table_seq,
           java.lang.String split_value,
           java.util.Date squal_date,
           java.lang.String state,
           int subscrip_id,
           int suppress_billing_output,
           int suppress_email,
           int suppress_renewal_output,
           int suspension_seq,
           java.lang.String taxonomy,
           int transaction_event,
           int undeliverable,
           byte[] update_mask,
           int was_company,
           int was_name,
           int was_title,
           int work_record_status,
           java.lang.String zip,
           java.lang.String new_audit_qual_category_descr,
           java.lang.String old_audit_qual_category_descr,
           java.lang.String pay_clear_status_descr,
           java.lang.String revenue_method_descr,
           java.lang.String selected_descr,
           java.lang.String transaction_event_descr,
           java.lang.String work_record_status_descr,
           java.lang.String message_string,
           Think.XmlWebServices.Td_renewal_offer[] td_renewal_offer,
           Think.XmlWebServices.Td_billing_amount[] td_billing_amount,
           Think.XmlWebServices.Td_promotion[] td_promotion) {
        super(
            job_id,
            work_table_seq,
            added,
            audit_name_title_id,
            audit_qual_source_id,
            audit_sales_channel_id,
            audit_subscription_type_id,
            billing_code,
            billing_def,
            billing_def_test_seq,
            billing_effort_number,
            billing_group_barcode,
            billing_installment_number,
            billing_item_barcode,
            currency,
            customer_group_customer_id,
            customer_id,
            customer_login_id,
            discount_class_id,
            duration,
            email,
            enumeration,
            event_queue_id,
            has_tax,
            insert_bits,
            inventory_id,
            invoice_id,
            invoice_number,
            issue_date,
            issue_id,
            job_ren_offer_id,
            label1,
            label10,
            label2,
            label3,
            label4,
            label5,
            label6,
            label7,
            label8,
            label9,
            new_audit_qual_category,
            new_n_deferred_issues_left,
            oc_id,
            old_audit_qual_category,
            order_date,
            order_item_seq,
            orderhdr_id,
            other_label1,
            other_label10,
            other_label2,
            other_label3,
            other_label4,
            other_label5,
            other_label6,
            other_label7,
            other_label8,
            other_label9,
            package_id,
            pay_amount,
            pay_auth_code,
            pay_auth_date,
            pay_check_number,
            pay_clear_date,
            pay_clear_status,
            pay_credit_card_info,
            pay_exp_date,
            pay_id_nbr,
            pay_ref_nbr,
            pay_status_reason,
            payment_account_seq,
            payment_seq,
            percent_of_basic_price,
            priority_sort_string,
            product_color,
            product_id,
            product_size,
            product_style,
            promotion_bits,
            qual_date,
            quantity,
            quantity_backordered,
            rate_class_id,
            refund_via_process,
            renewal_card_id,
            renewal_def,
            renewal_def_test_seq,
            renewal_effort_number,
            revenue_method,
            selected,
            send_to_customer_address_seq,
            send_to_customer_id,
            service_seq,
            sort_string,
            source_code,
            source_code_id,
            source_format,
            source_job_id,
            source_work_table_seq,
            split_value,
            squal_date,
            state,
            subscrip_id,
            suppress_billing_output,
            suppress_email,
            suppress_renewal_output,
            suspension_seq,
            taxonomy,
            transaction_event,
            undeliverable,
            update_mask,
            was_company,
            was_name,
            was_title,
            work_record_status,
            zip,
            new_audit_qual_category_descr,
            old_audit_qual_category_descr,
            pay_clear_status_descr,
            revenue_method_descr,
            selected_descr,
            transaction_event_descr,
            work_record_status_descr);
        this.message_string = message_string;
        this.td_renewal_offer = td_renewal_offer;
        this.td_billing_amount = td_billing_amount;
        this.td_promotion = td_promotion;
    }


    /**
     * Gets the td_renewal_offer value for this Td_effort.
     * 
     * @return td_renewal_offer
     */
    public Think.XmlWebServices.Td_renewal_offer[] getTd_renewal_offer() {
        return td_renewal_offer;
    }


    /**
     * Sets the td_renewal_offer value for this Td_effort.
     * 
     * @param td_renewal_offer
     */
    public void setTd_renewal_offer(Think.XmlWebServices.Td_renewal_offer[] td_renewal_offer) {
        this.td_renewal_offer = td_renewal_offer;
    }

    public Think.XmlWebServices.Td_renewal_offer getTd_renewal_offer(int i) {
        return this.td_renewal_offer[i];
    }

    public void setTd_renewal_offer(int i, Think.XmlWebServices.Td_renewal_offer _value) {
        this.td_renewal_offer[i] = _value;
    }


    /**
     * Gets the td_billing_amount value for this Td_effort.
     * 
     * @return td_billing_amount
     */
    public Think.XmlWebServices.Td_billing_amount[] getTd_billing_amount() {
        return td_billing_amount;
    }


    /**
     * Sets the td_billing_amount value for this Td_effort.
     * 
     * @param td_billing_amount
     */
    public void setTd_billing_amount(Think.XmlWebServices.Td_billing_amount[] td_billing_amount) {
        this.td_billing_amount = td_billing_amount;
    }

    public Think.XmlWebServices.Td_billing_amount getTd_billing_amount(int i) {
        return this.td_billing_amount[i];
    }

    public void setTd_billing_amount(int i, Think.XmlWebServices.Td_billing_amount _value) {
        this.td_billing_amount[i] = _value;
    }


    /**
     * Gets the td_promotion value for this Td_effort.
     * 
     * @return td_promotion
     */
    public Think.XmlWebServices.Td_promotion[] getTd_promotion() {
        return td_promotion;
    }


    /**
     * Sets the td_promotion value for this Td_effort.
     * 
     * @param td_promotion
     */
    public void setTd_promotion(Think.XmlWebServices.Td_promotion[] td_promotion) {
        this.td_promotion = td_promotion;
    }

    public Think.XmlWebServices.Td_promotion getTd_promotion(int i) {
        return this.td_promotion[i];
    }

    public void setTd_promotion(int i, Think.XmlWebServices.Td_promotion _value) {
        this.td_promotion[i] = _value;
    }


    /**
     * Gets the message_string value for this Td_effort.
     * 
     * @return message_string
     */
    public java.lang.String getMessage_string() {
        return message_string;
    }


    /**
     * Sets the message_string value for this Td_effort.
     * 
     * @param message_string
     */
    public void setMessage_string(java.lang.String message_string) {
        this.message_string = message_string;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_effort)) return false;
        Td_effort other = (Td_effort) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.td_renewal_offer==null && other.getTd_renewal_offer()==null) || 
             (this.td_renewal_offer!=null &&
              java.util.Arrays.equals(this.td_renewal_offer, other.getTd_renewal_offer()))) &&
            ((this.td_billing_amount==null && other.getTd_billing_amount()==null) || 
             (this.td_billing_amount!=null &&
              java.util.Arrays.equals(this.td_billing_amount, other.getTd_billing_amount()))) &&
            ((this.td_promotion==null && other.getTd_promotion()==null) || 
             (this.td_promotion!=null &&
              java.util.Arrays.equals(this.td_promotion, other.getTd_promotion()))) &&
            ((this.message_string==null && other.getMessage_string()==null) || 
             (this.message_string!=null &&
              this.message_string.equals(other.getMessage_string())));
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
        if (getTd_renewal_offer() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_renewal_offer());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_renewal_offer(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTd_billing_amount() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_billing_amount());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_billing_amount(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTd_promotion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_promotion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_promotion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMessage_string() != null) {
            _hashCode += getMessage_string().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_effort.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_effort"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("message_string");
        attrField.setXmlName(new javax.xml.namespace.QName("", "message_string"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_renewal_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_renewal_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_renewal_offer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_billing_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_billing_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_billing_amount"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_promotion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_promotion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_promotion"));
        elemField.setMinOccurs(0);
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
