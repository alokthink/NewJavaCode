/**
 * Transaction_data_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Transaction_data_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.ZZCustomerGroupIdentifier customer_group_identifier;

    private Think.XmlWebServices.Customer_address_identifier customer_address_identifier;

    private Think.XmlWebServices.Customer_login_identifier customer_login_identifier;

    private Think.XmlWebServices.Service_identifier service_identifier;

    private Think.XmlWebServices.Suspension_identifier suspension_identifier;

    private java.lang.Integer orderhdr_id;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private Think.XmlWebServices.Payment_identifier payment_identifier;

    private Think.XmlWebServices.Payment_account_identifier payment_account_identifier;

    private Think.XmlWebServices.Transaction_data_requestWork_renewal_offer work_renewal_offer;

    private Think.XmlWebServices.Transaction_data_requestWork_promotion_offer work_promotion_offer;

    private java.lang.Integer issue_id;

    private Think.XmlWebServices.Job_identifier job_identifier;

    private java.lang.String dsn;  // attribute

    public Transaction_data_request() {
    }

    public Transaction_data_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.ZZCustomerGroupIdentifier customer_group_identifier,
           Think.XmlWebServices.Customer_address_identifier customer_address_identifier,
           Think.XmlWebServices.Customer_login_identifier customer_login_identifier,
           Think.XmlWebServices.Service_identifier service_identifier,
           Think.XmlWebServices.Suspension_identifier suspension_identifier,
           java.lang.Integer orderhdr_id,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           Think.XmlWebServices.Payment_identifier payment_identifier,
           Think.XmlWebServices.Payment_account_identifier payment_account_identifier,
           Think.XmlWebServices.Transaction_data_requestWork_renewal_offer work_renewal_offer,
           Think.XmlWebServices.Transaction_data_requestWork_promotion_offer work_promotion_offer,
           java.lang.Integer issue_id,
           Think.XmlWebServices.Job_identifier job_identifier,
           java.lang.String dsn) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.customer_group_identifier = customer_group_identifier;
           this.customer_address_identifier = customer_address_identifier;
           this.customer_login_identifier = customer_login_identifier;
           this.service_identifier = service_identifier;
           this.suspension_identifier = suspension_identifier;
           this.orderhdr_id = orderhdr_id;
           this.item_identifier = item_identifier;
           this.payment_identifier = payment_identifier;
           this.payment_account_identifier = payment_account_identifier;
           this.work_renewal_offer = work_renewal_offer;
           this.work_promotion_offer = work_promotion_offer;
           this.issue_id = issue_id;
           this.job_identifier = job_identifier;
           this.dsn = dsn;
    }


    /**
     * Gets the user_login_data value for this Transaction_data_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Transaction_data_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Transaction_data_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Transaction_data_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the customer_group_identifier value for this Transaction_data_request.
     * 
     * @return customer_group_identifier
     */
    public Think.XmlWebServices.ZZCustomerGroupIdentifier getCustomer_group_identifier() {
        return customer_group_identifier;
    }


    /**
     * Sets the customer_group_identifier value for this Transaction_data_request.
     * 
     * @param customer_group_identifier
     */
    public void setCustomer_group_identifier(Think.XmlWebServices.ZZCustomerGroupIdentifier customer_group_identifier) {
        this.customer_group_identifier = customer_group_identifier;
    }


    /**
     * Gets the customer_address_identifier value for this Transaction_data_request.
     * 
     * @return customer_address_identifier
     */
    public Think.XmlWebServices.Customer_address_identifier getCustomer_address_identifier() {
        return customer_address_identifier;
    }


    /**
     * Sets the customer_address_identifier value for this Transaction_data_request.
     * 
     * @param customer_address_identifier
     */
    public void setCustomer_address_identifier(Think.XmlWebServices.Customer_address_identifier customer_address_identifier) {
        this.customer_address_identifier = customer_address_identifier;
    }


    /**
     * Gets the customer_login_identifier value for this Transaction_data_request.
     * 
     * @return customer_login_identifier
     */
    public Think.XmlWebServices.Customer_login_identifier getCustomer_login_identifier() {
        return customer_login_identifier;
    }


    /**
     * Sets the customer_login_identifier value for this Transaction_data_request.
     * 
     * @param customer_login_identifier
     */
    public void setCustomer_login_identifier(Think.XmlWebServices.Customer_login_identifier customer_login_identifier) {
        this.customer_login_identifier = customer_login_identifier;
    }


    /**
     * Gets the service_identifier value for this Transaction_data_request.
     * 
     * @return service_identifier
     */
    public Think.XmlWebServices.Service_identifier getService_identifier() {
        return service_identifier;
    }


    /**
     * Sets the service_identifier value for this Transaction_data_request.
     * 
     * @param service_identifier
     */
    public void setService_identifier(Think.XmlWebServices.Service_identifier service_identifier) {
        this.service_identifier = service_identifier;
    }


    /**
     * Gets the suspension_identifier value for this Transaction_data_request.
     * 
     * @return suspension_identifier
     */
    public Think.XmlWebServices.Suspension_identifier getSuspension_identifier() {
        return suspension_identifier;
    }


    /**
     * Sets the suspension_identifier value for this Transaction_data_request.
     * 
     * @param suspension_identifier
     */
    public void setSuspension_identifier(Think.XmlWebServices.Suspension_identifier suspension_identifier) {
        this.suspension_identifier = suspension_identifier;
    }


    /**
     * Gets the orderhdr_id value for this Transaction_data_request.
     * 
     * @return orderhdr_id
     */
    public java.lang.Integer getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Transaction_data_request.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.Integer orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the item_identifier value for this Transaction_data_request.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Transaction_data_request.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the payment_identifier value for this Transaction_data_request.
     * 
     * @return payment_identifier
     */
    public Think.XmlWebServices.Payment_identifier getPayment_identifier() {
        return payment_identifier;
    }


    /**
     * Sets the payment_identifier value for this Transaction_data_request.
     * 
     * @param payment_identifier
     */
    public void setPayment_identifier(Think.XmlWebServices.Payment_identifier payment_identifier) {
        this.payment_identifier = payment_identifier;
    }


    /**
     * Gets the payment_account_identifier value for this Transaction_data_request.
     * 
     * @return payment_account_identifier
     */
    public Think.XmlWebServices.Payment_account_identifier getPayment_account_identifier() {
        return payment_account_identifier;
    }


    /**
     * Sets the payment_account_identifier value for this Transaction_data_request.
     * 
     * @param payment_account_identifier
     */
    public void setPayment_account_identifier(Think.XmlWebServices.Payment_account_identifier payment_account_identifier) {
        this.payment_account_identifier = payment_account_identifier;
    }


    /**
     * Gets the work_renewal_offer value for this Transaction_data_request.
     * 
     * @return work_renewal_offer
     */
    public Think.XmlWebServices.Transaction_data_requestWork_renewal_offer getWork_renewal_offer() {
        return work_renewal_offer;
    }


    /**
     * Sets the work_renewal_offer value for this Transaction_data_request.
     * 
     * @param work_renewal_offer
     */
    public void setWork_renewal_offer(Think.XmlWebServices.Transaction_data_requestWork_renewal_offer work_renewal_offer) {
        this.work_renewal_offer = work_renewal_offer;
    }


    /**
     * Gets the work_promotion_offer value for this Transaction_data_request.
     * 
     * @return work_promotion_offer
     */
    public Think.XmlWebServices.Transaction_data_requestWork_promotion_offer getWork_promotion_offer() {
        return work_promotion_offer;
    }


    /**
     * Sets the work_promotion_offer value for this Transaction_data_request.
     * 
     * @param work_promotion_offer
     */
    public void setWork_promotion_offer(Think.XmlWebServices.Transaction_data_requestWork_promotion_offer work_promotion_offer) {
        this.work_promotion_offer = work_promotion_offer;
    }


    /**
     * Gets the issue_id value for this Transaction_data_request.
     * 
     * @return issue_id
     */
    public java.lang.Integer getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Transaction_data_request.
     * 
     * @param issue_id
     */
    public void setIssue_id(java.lang.Integer issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the job_identifier value for this Transaction_data_request.
     * 
     * @return job_identifier
     */
    public Think.XmlWebServices.Job_identifier getJob_identifier() {
        return job_identifier;
    }


    /**
     * Sets the job_identifier value for this Transaction_data_request.
     * 
     * @param job_identifier
     */
    public void setJob_identifier(Think.XmlWebServices.Job_identifier job_identifier) {
        this.job_identifier = job_identifier;
    }


    /**
     * Gets the dsn value for this Transaction_data_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Transaction_data_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Transaction_data_request)) return false;
        Transaction_data_request other = (Transaction_data_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.customer_group_identifier==null && other.getCustomer_group_identifier()==null) || 
             (this.customer_group_identifier!=null &&
              this.customer_group_identifier.equals(other.getCustomer_group_identifier()))) &&
            ((this.customer_address_identifier==null && other.getCustomer_address_identifier()==null) || 
             (this.customer_address_identifier!=null &&
              this.customer_address_identifier.equals(other.getCustomer_address_identifier()))) &&
            ((this.customer_login_identifier==null && other.getCustomer_login_identifier()==null) || 
             (this.customer_login_identifier!=null &&
              this.customer_login_identifier.equals(other.getCustomer_login_identifier()))) &&
            ((this.service_identifier==null && other.getService_identifier()==null) || 
             (this.service_identifier!=null &&
              this.service_identifier.equals(other.getService_identifier()))) &&
            ((this.suspension_identifier==null && other.getSuspension_identifier()==null) || 
             (this.suspension_identifier!=null &&
              this.suspension_identifier.equals(other.getSuspension_identifier()))) &&
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.payment_identifier==null && other.getPayment_identifier()==null) || 
             (this.payment_identifier!=null &&
              this.payment_identifier.equals(other.getPayment_identifier()))) &&
            ((this.payment_account_identifier==null && other.getPayment_account_identifier()==null) || 
             (this.payment_account_identifier!=null &&
              this.payment_account_identifier.equals(other.getPayment_account_identifier()))) &&
            ((this.work_renewal_offer==null && other.getWork_renewal_offer()==null) || 
             (this.work_renewal_offer!=null &&
              this.work_renewal_offer.equals(other.getWork_renewal_offer()))) &&
            ((this.work_promotion_offer==null && other.getWork_promotion_offer()==null) || 
             (this.work_promotion_offer!=null &&
              this.work_promotion_offer.equals(other.getWork_promotion_offer()))) &&
            ((this.issue_id==null && other.getIssue_id()==null) || 
             (this.issue_id!=null &&
              this.issue_id.equals(other.getIssue_id()))) &&
            ((this.job_identifier==null && other.getJob_identifier()==null) || 
             (this.job_identifier!=null &&
              this.job_identifier.equals(other.getJob_identifier()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getCustomer_group_identifier() != null) {
            _hashCode += getCustomer_group_identifier().hashCode();
        }
        if (getCustomer_address_identifier() != null) {
            _hashCode += getCustomer_address_identifier().hashCode();
        }
        if (getCustomer_login_identifier() != null) {
            _hashCode += getCustomer_login_identifier().hashCode();
        }
        if (getService_identifier() != null) {
            _hashCode += getService_identifier().hashCode();
        }
        if (getSuspension_identifier() != null) {
            _hashCode += getSuspension_identifier().hashCode();
        }
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getPayment_identifier() != null) {
            _hashCode += getPayment_identifier().hashCode();
        }
        if (getPayment_account_identifier() != null) {
            _hashCode += getPayment_account_identifier().hashCode();
        }
        if (getWork_renewal_offer() != null) {
            _hashCode += getWork_renewal_offer().hashCode();
        }
        if (getWork_promotion_offer() != null) {
            _hashCode += getWork_promotion_offer().hashCode();
        }
        if (getIssue_id() != null) {
            _hashCode += getIssue_id().hashCode();
        }
        if (getJob_identifier() != null) {
            _hashCode += getJob_identifier().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Transaction_data_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">transaction_data_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_group_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_group_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZCustomerGroupIdentifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_address_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_login_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_login_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">service_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspension_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "suspension_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">suspension_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_account_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_account_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_account_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_renewal_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_renewal_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>transaction_data_request>work_renewal_offer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("work_promotion_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "work_promotion_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>transaction_data_request>work_promotion_offer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issue_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "issue_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">job_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
