/**
 * Prospect_delete_responseCustomerCustomer_prospect.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Prospect_delete_responseCustomerCustomer_prospect  extends Think.XmlWebServices.ZZCustomerProspect  implements java.io.Serializable {
    private Think.XmlWebServices.ZZBoolean _deleted;  // attribute

    public Prospect_delete_responseCustomerCustomer_prospect() {
    }

    public Prospect_delete_responseCustomerCustomer_prospect(
           int customer_id,
           int customer_prospect_seq,
           int active_prospect,
           int audit_name_title_id,
           int audit_qual_category,
           int audit_qual_source_id,
           int audit_sales_channel_id,
           int audit_subscription_type_id,
           java.util.Calendar creation_date,
           int customer_address_seq,
           int oc_id,
           java.lang.String prospect_category,
           java.util.Date qual_date,
           int referred_by_customer_id,
           int source_code_id,
           Think.XmlWebServices.ZZBoolean _deleted) {
        super(
            customer_id,
            customer_prospect_seq,
            active_prospect,
            audit_name_title_id,
            audit_qual_category,
            audit_qual_source_id,
            audit_sales_channel_id,
            audit_subscription_type_id,
            creation_date,
            customer_address_seq,
            oc_id,
            prospect_category,
            qual_date,
            referred_by_customer_id,
            source_code_id);
        this._deleted = _deleted;
    }


    /**
     * Gets the _deleted value for this Prospect_delete_responseCustomerCustomer_prospect.
     * 
     * @return _deleted
     */
    public Think.XmlWebServices.ZZBoolean get_deleted() {
        return _deleted;
    }


    /**
     * Sets the _deleted value for this Prospect_delete_responseCustomerCustomer_prospect.
     * 
     * @param _deleted
     */
    public void set_deleted(Think.XmlWebServices.ZZBoolean _deleted) {
        this._deleted = _deleted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prospect_delete_responseCustomerCustomer_prospect)) return false;
        Prospect_delete_responseCustomerCustomer_prospect other = (Prospect_delete_responseCustomerCustomer_prospect) obj;
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
        new org.apache.axis.description.TypeDesc(Prospect_delete_responseCustomerCustomer_prospect.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>>prospect_delete_response>customer>customer_prospect"));
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
