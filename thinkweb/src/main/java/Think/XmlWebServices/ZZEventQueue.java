/**
 * ZZEventQueue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZEventQueue  implements java.io.Serializable {
    private int event_queue_id;  // attribute

    private java.lang.String alt_url;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int customer_address_seq;  // attribute

    private int customer_group_customer_id;  // attribute

    private int customer_id;  // attribute

    private int customer_login_id;  // attribute

    private java.lang.String email;  // attribute

    private int issue_id;  // attribute

    private java.lang.String message;  // attribute

    private int oc_id;  // attribute

    private int order_item_seq;  // attribute

    private int orderhdr_id;  // attribute

    private int payment_account_seq;  // attribute

    private int payment_seq;  // attribute

    private int product_id;  // attribute

    private int service_seq;  // attribute

    private int source_job_id;  // attribute

    private int source_work_table_seq;  // attribute

    private int status;  // attribute

    private int subscrip_id;  // attribute

    private int suspension_seq;  // attribute

    private int transaction_event;  // attribute

    public ZZEventQueue() {
    }

    public ZZEventQueue(
           int event_queue_id,
           java.lang.String alt_url,
           java.util.Calendar creation_date,
           int customer_address_seq,
           int customer_group_customer_id,
           int customer_id,
           int customer_login_id,
           java.lang.String email,
           int issue_id,
           java.lang.String message,
           int oc_id,
           int order_item_seq,
           int orderhdr_id,
           int payment_account_seq,
           int payment_seq,
           int product_id,
           int service_seq,
           int source_job_id,
           int source_work_table_seq,
           int status,
           int subscrip_id,
           int suspension_seq,
           int transaction_event) {
           this.event_queue_id = event_queue_id;
           this.alt_url = alt_url;
           this.creation_date = creation_date;
           this.customer_address_seq = customer_address_seq;
           this.customer_group_customer_id = customer_group_customer_id;
           this.customer_id = customer_id;
           this.customer_login_id = customer_login_id;
           this.email = email;
           this.issue_id = issue_id;
           this.message = message;
           this.oc_id = oc_id;
           this.order_item_seq = order_item_seq;
           this.orderhdr_id = orderhdr_id;
           this.payment_account_seq = payment_account_seq;
           this.payment_seq = payment_seq;
           this.product_id = product_id;
           this.service_seq = service_seq;
           this.source_job_id = source_job_id;
           this.source_work_table_seq = source_work_table_seq;
           this.status = status;
           this.subscrip_id = subscrip_id;
           this.suspension_seq = suspension_seq;
           this.transaction_event = transaction_event;
    }


    /**
     * Gets the event_queue_id value for this ZZEventQueue.
     * 
     * @return event_queue_id
     */
    public int getEvent_queue_id() {
        return event_queue_id;
    }


    /**
     * Sets the event_queue_id value for this ZZEventQueue.
     * 
     * @param event_queue_id
     */
    public void setEvent_queue_id(int event_queue_id) {
        this.event_queue_id = event_queue_id;
    }


    /**
     * Gets the alt_url value for this ZZEventQueue.
     * 
     * @return alt_url
     */
    public java.lang.String getAlt_url() {
        return alt_url;
    }


    /**
     * Sets the alt_url value for this ZZEventQueue.
     * 
     * @param alt_url
     */
    public void setAlt_url(java.lang.String alt_url) {
        this.alt_url = alt_url;
    }


    /**
     * Gets the creation_date value for this ZZEventQueue.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZEventQueue.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the customer_address_seq value for this ZZEventQueue.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this ZZEventQueue.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the customer_group_customer_id value for this ZZEventQueue.
     * 
     * @return customer_group_customer_id
     */
    public int getCustomer_group_customer_id() {
        return customer_group_customer_id;
    }


    /**
     * Sets the customer_group_customer_id value for this ZZEventQueue.
     * 
     * @param customer_group_customer_id
     */
    public void setCustomer_group_customer_id(int customer_group_customer_id) {
        this.customer_group_customer_id = customer_group_customer_id;
    }


    /**
     * Gets the customer_id value for this ZZEventQueue.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZEventQueue.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_login_id value for this ZZEventQueue.
     * 
     * @return customer_login_id
     */
    public int getCustomer_login_id() {
        return customer_login_id;
    }


    /**
     * Sets the customer_login_id value for this ZZEventQueue.
     * 
     * @param customer_login_id
     */
    public void setCustomer_login_id(int customer_login_id) {
        this.customer_login_id = customer_login_id;
    }


    /**
     * Gets the email value for this ZZEventQueue.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ZZEventQueue.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the issue_id value for this ZZEventQueue.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this ZZEventQueue.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the message value for this ZZEventQueue.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this ZZEventQueue.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the oc_id value for this ZZEventQueue.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this ZZEventQueue.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the order_item_seq value for this ZZEventQueue.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZEventQueue.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the orderhdr_id value for this ZZEventQueue.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZEventQueue.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the payment_account_seq value for this ZZEventQueue.
     * 
     * @return payment_account_seq
     */
    public int getPayment_account_seq() {
        return payment_account_seq;
    }


    /**
     * Sets the payment_account_seq value for this ZZEventQueue.
     * 
     * @param payment_account_seq
     */
    public void setPayment_account_seq(int payment_account_seq) {
        this.payment_account_seq = payment_account_seq;
    }


    /**
     * Gets the payment_seq value for this ZZEventQueue.
     * 
     * @return payment_seq
     */
    public int getPayment_seq() {
        return payment_seq;
    }


    /**
     * Sets the payment_seq value for this ZZEventQueue.
     * 
     * @param payment_seq
     */
    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }


    /**
     * Gets the product_id value for this ZZEventQueue.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this ZZEventQueue.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the service_seq value for this ZZEventQueue.
     * 
     * @return service_seq
     */
    public int getService_seq() {
        return service_seq;
    }


    /**
     * Sets the service_seq value for this ZZEventQueue.
     * 
     * @param service_seq
     */
    public void setService_seq(int service_seq) {
        this.service_seq = service_seq;
    }


    /**
     * Gets the source_job_id value for this ZZEventQueue.
     * 
     * @return source_job_id
     */
    public int getSource_job_id() {
        return source_job_id;
    }


    /**
     * Sets the source_job_id value for this ZZEventQueue.
     * 
     * @param source_job_id
     */
    public void setSource_job_id(int source_job_id) {
        this.source_job_id = source_job_id;
    }


    /**
     * Gets the source_work_table_seq value for this ZZEventQueue.
     * 
     * @return source_work_table_seq
     */
    public int getSource_work_table_seq() {
        return source_work_table_seq;
    }


    /**
     * Sets the source_work_table_seq value for this ZZEventQueue.
     * 
     * @param source_work_table_seq
     */
    public void setSource_work_table_seq(int source_work_table_seq) {
        this.source_work_table_seq = source_work_table_seq;
    }


    /**
     * Gets the status value for this ZZEventQueue.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ZZEventQueue.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the subscrip_id value for this ZZEventQueue.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this ZZEventQueue.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the suspension_seq value for this ZZEventQueue.
     * 
     * @return suspension_seq
     */
    public int getSuspension_seq() {
        return suspension_seq;
    }


    /**
     * Sets the suspension_seq value for this ZZEventQueue.
     * 
     * @param suspension_seq
     */
    public void setSuspension_seq(int suspension_seq) {
        this.suspension_seq = suspension_seq;
    }


    /**
     * Gets the transaction_event value for this ZZEventQueue.
     * 
     * @return transaction_event
     */
    public int getTransaction_event() {
        return transaction_event;
    }


    /**
     * Sets the transaction_event value for this ZZEventQueue.
     * 
     * @param transaction_event
     */
    public void setTransaction_event(int transaction_event) {
        this.transaction_event = transaction_event;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZEventQueue)) return false;
        ZZEventQueue other = (ZZEventQueue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.event_queue_id == other.getEvent_queue_id() &&
            ((this.alt_url==null && other.getAlt_url()==null) || 
             (this.alt_url!=null &&
              this.alt_url.equals(other.getAlt_url()))) &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            this.customer_group_customer_id == other.getCustomer_group_customer_id() &&
            this.customer_id == other.getCustomer_id() &&
            this.customer_login_id == other.getCustomer_login_id() &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.issue_id == other.getIssue_id() &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.oc_id == other.getOc_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.payment_account_seq == other.getPayment_account_seq() &&
            this.payment_seq == other.getPayment_seq() &&
            this.product_id == other.getProduct_id() &&
            this.service_seq == other.getService_seq() &&
            this.source_job_id == other.getSource_job_id() &&
            this.source_work_table_seq == other.getSource_work_table_seq() &&
            this.status == other.getStatus() &&
            this.subscrip_id == other.getSubscrip_id() &&
            this.suspension_seq == other.getSuspension_seq() &&
            this.transaction_event == other.getTransaction_event();
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
        _hashCode += getEvent_queue_id();
        if (getAlt_url() != null) {
            _hashCode += getAlt_url().hashCode();
        }
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getCustomer_address_seq();
        _hashCode += getCustomer_group_customer_id();
        _hashCode += getCustomer_id();
        _hashCode += getCustomer_login_id();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getIssue_id();
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += getOc_id();
        _hashCode += getOrder_item_seq();
        _hashCode += getOrderhdr_id();
        _hashCode += getPayment_account_seq();
        _hashCode += getPayment_seq();
        _hashCode += getProduct_id();
        _hashCode += getService_seq();
        _hashCode += getSource_job_id();
        _hashCode += getSource_work_table_seq();
        _hashCode += getStatus();
        _hashCode += getSubscrip_id();
        _hashCode += getSuspension_seq();
        _hashCode += getTransaction_event();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZEventQueue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZEventQueue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("event_queue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "event_queue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alt_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alt_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_group_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_group_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("message");
        attrField.setXmlName(new javax.xml.namespace.QName("", "message"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_account_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_account_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("payment_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "payment_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("product_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_work_table_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_work_table_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suspension_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suspension_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transaction_event");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transaction_event"));
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
