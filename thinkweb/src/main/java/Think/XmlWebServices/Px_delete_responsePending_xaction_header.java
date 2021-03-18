/**
 * Px_delete_responsePending_xaction_header.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_delete_responsePending_xaction_header  extends Think.XmlWebServices.ZZPendingXactionHeader  implements java.io.Serializable {
    private Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction[] pending_xaction;

    public Px_delete_responsePending_xaction_header() {
    }

    public Px_delete_responsePending_xaction_header(
           int pending_xaction_header_id,
           java.math.BigDecimal amt_pay,
           java.math.BigDecimal amt_pkg,
           java.math.BigDecimal amt_prod,
           java.math.BigDecimal amt_renew,
           java.math.BigDecimal amt_single,
           java.math.BigDecimal amt_sub,
           java.lang.String assigned_to_user_code,
           int auto_submit,
           java.math.BigDecimal base_amt_pay,
           java.math.BigDecimal base_amt_pkg,
           java.math.BigDecimal base_amt_prod,
           java.math.BigDecimal base_amt_renew,
           java.math.BigDecimal base_amt_single,
           java.math.BigDecimal base_amt_sub,
           java.math.BigDecimal base_pamt_pay,
           java.math.BigDecimal base_pamt_pkg,
           java.math.BigDecimal base_pamt_prod,
           java.math.BigDecimal base_pamt_renew,
           java.math.BigDecimal base_pamt_single,
           java.math.BigDecimal base_pamt_sub,
           java.math.BigDecimal base_xamt_pay,
           java.math.BigDecimal base_xamt_pkg,
           java.math.BigDecimal base_xamt_prod,
           java.math.BigDecimal base_xamt_renew,
           java.math.BigDecimal base_xamt_single,
           java.math.BigDecimal base_xamt_sub,
           java.lang.String batch_template,
           int cnt_cust,
           int cnt_doc,
           int cnt_other,
           int cnt_pay,
           int cnt_pkg,
           int cnt_prod,
           int cnt_renew,
           int cnt_single,
           int cnt_sub,
           java.util.Calendar creation_date,
           java.lang.String creator_user_code,
           java.lang.String currency,
           java.lang.String cust_edit_source_file,
           java.lang.String description,
           int document_reference_id,
           byte[] handling_options,
           java.lang.String import_profile,
           int input_done,
           java.lang.String kickout_file,
           int lookup_by_barcode,
           java.lang.String memo,
           int oc_id,
           java.math.BigDecimal pamt_pay,
           java.math.BigDecimal pamt_pkg,
           java.math.BigDecimal pamt_prod,
           java.math.BigDecimal pamt_renew,
           java.math.BigDecimal pamt_single,
           java.math.BigDecimal pamt_sub,
           int pcnt_cust,
           int pcnt_doc,
           int pcnt_other,
           int pcnt_pay,
           int pcnt_pkg,
           int pcnt_prod,
           int pcnt_renew,
           int pcnt_single,
           int pcnt_sub,
           java.util.Date processed_date,
           java.math.BigDecimal rec_defcash,
           java.math.BigDecimal rec_defcred,
           int submitted,
           int transaction_source,
           int voucher_id,
           java.math.BigDecimal xamt_pay,
           java.math.BigDecimal xamt_pkg,
           java.math.BigDecimal xamt_prod,
           java.math.BigDecimal xamt_renew,
           java.math.BigDecimal xamt_single,
           java.math.BigDecimal xamt_sub,
           int xcnt_cust,
           int xcnt_doc,
           int xcnt_other,
           int xcnt_pay,
           int xcnt_pkg,
           int xcnt_prod,
           int xcnt_renew,
           int xcnt_single,
           int xcnt_sub,
           Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction[] pending_xaction) {
        super(
            pending_xaction_header_id,
            amt_pay,
            amt_pkg,
            amt_prod,
            amt_renew,
            amt_single,
            amt_sub,
            assigned_to_user_code,
            auto_submit,
            base_amt_pay,
            base_amt_pkg,
            base_amt_prod,
            base_amt_renew,
            base_amt_single,
            base_amt_sub,
            base_pamt_pay,
            base_pamt_pkg,
            base_pamt_prod,
            base_pamt_renew,
            base_pamt_single,
            base_pamt_sub,
            base_xamt_pay,
            base_xamt_pkg,
            base_xamt_prod,
            base_xamt_renew,
            base_xamt_single,
            base_xamt_sub,
            batch_template,
            cnt_cust,
            cnt_doc,
            cnt_other,
            cnt_pay,
            cnt_pkg,
            cnt_prod,
            cnt_renew,
            cnt_single,
            cnt_sub,
            creation_date,
            creator_user_code,
            currency,
            cust_edit_source_file,
            description,
            document_reference_id,
            handling_options,
            import_profile,
            input_done,
            kickout_file,
            lookup_by_barcode,
            memo,
            oc_id,
            pamt_pay,
            pamt_pkg,
            pamt_prod,
            pamt_renew,
            pamt_single,
            pamt_sub,
            pcnt_cust,
            pcnt_doc,
            pcnt_other,
            pcnt_pay,
            pcnt_pkg,
            pcnt_prod,
            pcnt_renew,
            pcnt_single,
            pcnt_sub,
            processed_date,
            rec_defcash,
            rec_defcred,
            submitted,
            transaction_source,
            voucher_id,
            xamt_pay,
            xamt_pkg,
            xamt_prod,
            xamt_renew,
            xamt_single,
            xamt_sub,
            xcnt_cust,
            xcnt_doc,
            xcnt_other,
            xcnt_pay,
            xcnt_pkg,
            xcnt_prod,
            xcnt_renew,
            xcnt_single,
            xcnt_sub);
        this.pending_xaction = pending_xaction;
    }


    /**
     * Gets the pending_xaction value for this Px_delete_responsePending_xaction_header.
     * 
     * @return pending_xaction
     */
    public Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction[] getPending_xaction() {
        return pending_xaction;
    }


    /**
     * Sets the pending_xaction value for this Px_delete_responsePending_xaction_header.
     * 
     * @param pending_xaction
     */
    public void setPending_xaction(Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction[] pending_xaction) {
        this.pending_xaction = pending_xaction;
    }

    public Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction getPending_xaction(int i) {
        return this.pending_xaction[i];
    }

    public void setPending_xaction(int i, Think.XmlWebServices.Px_delete_responsePending_xaction_headerPending_xaction _value) {
        this.pending_xaction[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_delete_responsePending_xaction_header)) return false;
        Px_delete_responsePending_xaction_header other = (Px_delete_responsePending_xaction_header) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.pending_xaction==null && other.getPending_xaction()==null) || 
             (this.pending_xaction!=null &&
              java.util.Arrays.equals(this.pending_xaction, other.getPending_xaction())));
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
        if (getPending_xaction() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPending_xaction());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPending_xaction(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_delete_responsePending_xaction_header.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>px_delete_response>pending_xaction_header"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pending_xaction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pending_xaction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>>px_delete_response>pending_xaction_header>pending_xaction"));
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
