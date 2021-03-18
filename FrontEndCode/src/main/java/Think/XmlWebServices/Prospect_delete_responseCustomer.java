/**
 * Prospect_delete_responseCustomer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Prospect_delete_responseCustomer  extends Think.XmlWebServices.ZZCustomer  implements java.io.Serializable {
    private Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect[] customer_prospect;

    public Prospect_delete_responseCustomer() {
    }

    public Prospect_delete_responseCustomer(
           int customer_id,
           java.lang.String company,
           java.util.Calendar creation_date,
           java.lang.String credit_status,
           java.lang.String customer_category,
           int def_bill_to_cust_addr_seq,
           int def_renew_to_cust_addr_seq,
           int default_bill_to_customer_id,
           int default_cust_addr_seq,
           int default_renew_to_customer_id,
           java.lang.String email,
           byte[] email_authorization,
           java.lang.String fname,
           int inactive,
           java.lang.String initial_name,
           java.lang.String institutional_identifier,
           java.lang.String list_rental_category,
           java.lang.String lname,
           int nbr_times_issued,
           int oc_id,
           java.lang.String old_customer_id,
           java.lang.String old_email,
           java.lang.String parent_inst_identifier,
           int prospect_only,
           int sales_representative_id,
           java.lang.String salutation,
           java.lang.String suffix,
           java.lang.String title,
           java.lang.String user_code,
           Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect[] customer_prospect) {
        super(
            customer_id,
            company,
            creation_date,
            credit_status,
            customer_category,
            def_bill_to_cust_addr_seq,
            def_renew_to_cust_addr_seq,
            default_bill_to_customer_id,
            default_cust_addr_seq,
            default_renew_to_customer_id,
            email,
            email_authorization,
            fname,
            inactive,
            initial_name,
            institutional_identifier,
            list_rental_category,
            lname,
            nbr_times_issued,
            oc_id,
            old_customer_id,
            old_email,
            parent_inst_identifier,
            prospect_only,
            sales_representative_id,
            salutation,
            suffix,
            title,
            user_code);
        this.customer_prospect = customer_prospect;
    }


    /**
     * Gets the customer_prospect value for this Prospect_delete_responseCustomer.
     * 
     * @return customer_prospect
     */
    public Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect[] getCustomer_prospect() {
        return customer_prospect;
    }


    /**
     * Sets the customer_prospect value for this Prospect_delete_responseCustomer.
     * 
     * @param customer_prospect
     */
    public void setCustomer_prospect(Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect[] customer_prospect) {
        this.customer_prospect = customer_prospect;
    }

    public Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect getCustomer_prospect(int i) {
        return this.customer_prospect[i];
    }

    public void setCustomer_prospect(int i, Think.XmlWebServices.Prospect_delete_responseCustomerCustomer_prospect _value) {
        this.customer_prospect[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prospect_delete_responseCustomer)) return false;
        Prospect_delete_responseCustomer other = (Prospect_delete_responseCustomer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_prospect==null && other.getCustomer_prospect()==null) || 
             (this.customer_prospect!=null &&
              java.util.Arrays.equals(this.customer_prospect, other.getCustomer_prospect())));
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
        if (getCustomer_prospect() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_prospect());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_prospect(), i);
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
        new org.apache.axis.description.TypeDesc(Prospect_delete_responseCustomer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>prospect_delete_response>customer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_prospect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_prospect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>>prospect_delete_response>customer>customer_prospect"));
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
