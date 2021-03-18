/**
 * Px_delete_responsePending_xaction_headerPending_xaction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Px_delete_responsePending_xaction_headerPending_xaction  extends Think.XmlWebServices.ZZPendingXaction  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean _deleted;  // attribute

    public Px_delete_responsePending_xaction_headerPending_xaction() {
    }

    public Px_delete_responsePending_xaction_headerPending_xaction(
           int pending_xaction_header_id,
           int pending_xaction_seq,
           java.math.BigDecimal amount,
           java.math.BigDecimal amount_calculated,
           int change_sub_status,
           java.lang.String currency,
           int customer_add,
           int customer_address_seq,
           int customer_edit,
           int customer_id,
           java.lang.String group_barcode,
           int import_file_offset,
           int import_record_number,
           java.lang.String message_string,
           java.lang.String name,
           int oc_id,
           int order_add,
           int order_item_seq,
           int orderhdr_id,
           java.lang.String pay_currency,
           int payment_add,
           int processed_status,
           int prospect_add,
           int workflow,
           Think.XmlWebServices.ZZBoolean _deleted) {
        super(
            pending_xaction_header_id,
            pending_xaction_seq,
            amount,
            amount_calculated,
            change_sub_status,
            currency,
            customer_add,
            customer_address_seq,
            customer_edit,
            customer_id,
            group_barcode,
            import_file_offset,
            import_record_number,
            message_string,
            name,
            oc_id,
            order_add,
            order_item_seq,
            orderhdr_id,
            pay_currency,
            payment_add,
            processed_status,
            prospect_add,
            workflow);
        this._deleted = _deleted;
    }


    /**
     * Gets the _deleted value for this Px_delete_responsePending_xaction_headerPending_xaction.
     * 
     * @return _deleted
     */
    public Think.XmlWebServices.ZZBoolean get_deleted() {
        return _deleted;
    }


    /**
     * Sets the _deleted value for this Px_delete_responsePending_xaction_headerPending_xaction.
     * 
     * @param _deleted
     */
    public void set_deleted(Think.XmlWebServices.ZZBoolean _deleted) {
        this._deleted = _deleted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Px_delete_responsePending_xaction_headerPending_xaction)) return false;
        Px_delete_responsePending_xaction_headerPending_xaction other = (Px_delete_responsePending_xaction_headerPending_xaction) obj;
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
              this._deleted.equals(other.get_deleted())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Px_delete_responsePending_xaction_headerPending_xaction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>>px_delete_response>pending_xaction_header>pending_xaction"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_deleted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "_deleted"));
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
