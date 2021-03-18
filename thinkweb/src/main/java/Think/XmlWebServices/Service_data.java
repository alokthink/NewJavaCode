/**
 * Service_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Service_data  implements java.io.Serializable {
    private java.lang.String cause_code;

    private java.lang.String claim_ref_nbr;

    private java.lang.String complaint_code;

    private java.util.Date complaint_date;

    private java.util.Date followup_date;

    private java.lang.Integer order_item_seq;

    private java.lang.Integer orderhdr_id;

    private java.lang.String service_code;

    private java.util.Date service_date;

    private int service_status;

    private java.lang.Integer subscrip_id;

    private java.lang.String user_code;

    private java.lang.String note_field;

    private java.lang.String email_addresses;

    private Think.XmlWebServices.Form_letter_history_data[] form_letter_history_data;

    private Think.XmlWebServices.Auxiliary_data[] auxiliary_data;

    private Think.XmlWebServices.ZZBoolean email_cause;  // attribute

    private Think.XmlWebServices.ZZBoolean email_complaint;  // attribute

    private Think.XmlWebServices.ZZBoolean email_service;  // attribute

    public Service_data() {
    }

    public Service_data(
           java.lang.String cause_code,
           java.lang.String claim_ref_nbr,
           java.lang.String complaint_code,
           java.util.Date complaint_date,
           java.util.Date followup_date,
           java.lang.Integer order_item_seq,
           java.lang.Integer orderhdr_id,
           java.lang.String service_code,
           java.util.Date service_date,
           int service_status,
           java.lang.Integer subscrip_id,
           java.lang.String user_code,
           java.lang.String note_field,
           java.lang.String email_addresses,
           Think.XmlWebServices.Form_letter_history_data[] form_letter_history_data,
           Think.XmlWebServices.Auxiliary_data[] auxiliary_data,
           Think.XmlWebServices.ZZBoolean email_cause,
           Think.XmlWebServices.ZZBoolean email_complaint,
           Think.XmlWebServices.ZZBoolean email_service) {
           this.cause_code = cause_code;
           this.claim_ref_nbr = claim_ref_nbr;
           this.complaint_code = complaint_code;
           this.complaint_date = complaint_date;
           this.followup_date = followup_date;
           this.order_item_seq = order_item_seq;
           this.orderhdr_id = orderhdr_id;
           this.service_code = service_code;
           this.service_date = service_date;
           this.service_status = service_status;
           this.subscrip_id = subscrip_id;
           this.user_code = user_code;
           this.note_field = note_field;
           this.email_addresses = email_addresses;
           this.form_letter_history_data = form_letter_history_data;
           this.auxiliary_data = auxiliary_data;
           this.email_cause = email_cause;
           this.email_complaint = email_complaint;
           this.email_service = email_service;
    }


    /**
     * Gets the cause_code value for this Service_data.
     * 
     * @return cause_code
     */
    public java.lang.String getCause_code() {
        return cause_code;
    }


    /**
     * Sets the cause_code value for this Service_data.
     * 
     * @param cause_code
     */
    public void setCause_code(java.lang.String cause_code) {
        this.cause_code = cause_code;
    }


    /**
     * Gets the claim_ref_nbr value for this Service_data.
     * 
     * @return claim_ref_nbr
     */
    public java.lang.String getClaim_ref_nbr() {
        return claim_ref_nbr;
    }


    /**
     * Sets the claim_ref_nbr value for this Service_data.
     * 
     * @param claim_ref_nbr
     */
    public void setClaim_ref_nbr(java.lang.String claim_ref_nbr) {
        this.claim_ref_nbr = claim_ref_nbr;
    }


    /**
     * Gets the complaint_code value for this Service_data.
     * 
     * @return complaint_code
     */
    public java.lang.String getComplaint_code() {
        return complaint_code;
    }


    /**
     * Sets the complaint_code value for this Service_data.
     * 
     * @param complaint_code
     */
    public void setComplaint_code(java.lang.String complaint_code) {
        this.complaint_code = complaint_code;
    }


    /**
     * Gets the complaint_date value for this Service_data.
     * 
     * @return complaint_date
     */
    public java.util.Date getComplaint_date() {
        return complaint_date;
    }


    /**
     * Sets the complaint_date value for this Service_data.
     * 
     * @param complaint_date
     */
    public void setComplaint_date(java.util.Date complaint_date) {
        this.complaint_date = complaint_date;
    }


    /**
     * Gets the followup_date value for this Service_data.
     * 
     * @return followup_date
     */
    public java.util.Date getFollowup_date() {
        return followup_date;
    }


    /**
     * Sets the followup_date value for this Service_data.
     * 
     * @param followup_date
     */
    public void setFollowup_date(java.util.Date followup_date) {
        this.followup_date = followup_date;
    }


    /**
     * Gets the order_item_seq value for this Service_data.
     * 
     * @return order_item_seq
     */
    public java.lang.Integer getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this Service_data.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(java.lang.Integer order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the orderhdr_id value for this Service_data.
     * 
     * @return orderhdr_id
     */
    public java.lang.Integer getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Service_data.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(java.lang.Integer orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the service_code value for this Service_data.
     * 
     * @return service_code
     */
    public java.lang.String getService_code() {
        return service_code;
    }


    /**
     * Sets the service_code value for this Service_data.
     * 
     * @param service_code
     */
    public void setService_code(java.lang.String service_code) {
        this.service_code = service_code;
    }


    /**
     * Gets the service_date value for this Service_data.
     * 
     * @return service_date
     */
    public java.util.Date getService_date() {
        return service_date;
    }


    /**
     * Sets the service_date value for this Service_data.
     * 
     * @param service_date
     */
    public void setService_date(java.util.Date service_date) {
        this.service_date = service_date;
    }


    /**
     * Gets the service_status value for this Service_data.
     * 
     * @return service_status
     */
    public int getService_status() {
        return service_status;
    }


    /**
     * Sets the service_status value for this Service_data.
     * 
     * @param service_status
     */
    public void setService_status(int service_status) {
        this.service_status = service_status;
    }


    /**
     * Gets the subscrip_id value for this Service_data.
     * 
     * @return subscrip_id
     */
    public java.lang.Integer getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Service_data.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(java.lang.Integer subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the user_code value for this Service_data.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Service_data.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the note_field value for this Service_data.
     * 
     * @return note_field
     */
    public java.lang.String getNote_field() {
        return note_field;
    }


    /**
     * Sets the note_field value for this Service_data.
     * 
     * @param note_field
     */
    public void setNote_field(java.lang.String note_field) {
        this.note_field = note_field;
    }


    /**
     * Gets the email_addresses value for this Service_data.
     * 
     * @return email_addresses
     */
    public java.lang.String getEmail_addresses() {
        return email_addresses;
    }


    /**
     * Sets the email_addresses value for this Service_data.
     * 
     * @param email_addresses
     */
    public void setEmail_addresses(java.lang.String email_addresses) {
        this.email_addresses = email_addresses;
    }


    /**
     * Gets the form_letter_history_data value for this Service_data.
     * 
     * @return form_letter_history_data
     */
    public Think.XmlWebServices.Form_letter_history_data[] getForm_letter_history_data() {
        return form_letter_history_data;
    }


    /**
     * Sets the form_letter_history_data value for this Service_data.
     * 
     * @param form_letter_history_data
     */
    public void setForm_letter_history_data(Think.XmlWebServices.Form_letter_history_data[] form_letter_history_data) {
        this.form_letter_history_data = form_letter_history_data;
    }

    public Think.XmlWebServices.Form_letter_history_data getForm_letter_history_data(int i) {
        return this.form_letter_history_data[i];
    }

    public void setForm_letter_history_data(int i, Think.XmlWebServices.Form_letter_history_data _value) {
        this.form_letter_history_data[i] = _value;
    }


    /**
     * Gets the auxiliary_data value for this Service_data.
     * 
     * @return auxiliary_data
     */
    public Think.XmlWebServices.Auxiliary_data[] getAuxiliary_data() {
        return auxiliary_data;
    }


    /**
     * Sets the auxiliary_data value for this Service_data.
     * 
     * @param auxiliary_data
     */
    public void setAuxiliary_data(Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        this.auxiliary_data = auxiliary_data;
    }

    public Think.XmlWebServices.Auxiliary_data getAuxiliary_data(int i) {
        return this.auxiliary_data[i];
    }

    public void setAuxiliary_data(int i, Think.XmlWebServices.Auxiliary_data _value) {
        this.auxiliary_data[i] = _value;
    }


    /**
     * Gets the email_cause value for this Service_data.
     * 
     * @return email_cause
     */
    public Think.XmlWebServices.ZZBoolean getEmail_cause() {
        return email_cause;
    }


    /**
     * Sets the email_cause value for this Service_data.
     * 
     * @param email_cause
     */
    public void setEmail_cause(Think.XmlWebServices.ZZBoolean email_cause) {
        this.email_cause = email_cause;
    }


    /**
     * Gets the email_complaint value for this Service_data.
     * 
     * @return email_complaint
     */
    public Think.XmlWebServices.ZZBoolean getEmail_complaint() {
        return email_complaint;
    }


    /**
     * Sets the email_complaint value for this Service_data.
     * 
     * @param email_complaint
     */
    public void setEmail_complaint(Think.XmlWebServices.ZZBoolean email_complaint) {
        this.email_complaint = email_complaint;
    }


    /**
     * Gets the email_service value for this Service_data.
     * 
     * @return email_service
     */
    public Think.XmlWebServices.ZZBoolean getEmail_service() {
        return email_service;
    }


    /**
     * Sets the email_service value for this Service_data.
     * 
     * @param email_service
     */
    public void setEmail_service(Think.XmlWebServices.ZZBoolean email_service) {
        this.email_service = email_service;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Service_data)) return false;
        Service_data other = (Service_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cause_code==null && other.getCause_code()==null) || 
             (this.cause_code!=null &&
              this.cause_code.equals(other.getCause_code()))) &&
            ((this.claim_ref_nbr==null && other.getClaim_ref_nbr()==null) || 
             (this.claim_ref_nbr!=null &&
              this.claim_ref_nbr.equals(other.getClaim_ref_nbr()))) &&
            ((this.complaint_code==null && other.getComplaint_code()==null) || 
             (this.complaint_code!=null &&
              this.complaint_code.equals(other.getComplaint_code()))) &&
            ((this.complaint_date==null && other.getComplaint_date()==null) || 
             (this.complaint_date!=null &&
              this.complaint_date.equals(other.getComplaint_date()))) &&
            ((this.followup_date==null && other.getFollowup_date()==null) || 
             (this.followup_date!=null &&
              this.followup_date.equals(other.getFollowup_date()))) &&
            ((this.order_item_seq==null && other.getOrder_item_seq()==null) || 
             (this.order_item_seq!=null &&
              this.order_item_seq.equals(other.getOrder_item_seq()))) &&
            ((this.orderhdr_id==null && other.getOrderhdr_id()==null) || 
             (this.orderhdr_id!=null &&
              this.orderhdr_id.equals(other.getOrderhdr_id()))) &&
            ((this.service_code==null && other.getService_code()==null) || 
             (this.service_code!=null &&
              this.service_code.equals(other.getService_code()))) &&
            ((this.service_date==null && other.getService_date()==null) || 
             (this.service_date!=null &&
              this.service_date.equals(other.getService_date()))) &&
            this.service_status == other.getService_status() &&
            ((this.subscrip_id==null && other.getSubscrip_id()==null) || 
             (this.subscrip_id!=null &&
              this.subscrip_id.equals(other.getSubscrip_id()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.note_field==null && other.getNote_field()==null) || 
             (this.note_field!=null &&
              this.note_field.equals(other.getNote_field()))) &&
            ((this.email_addresses==null && other.getEmail_addresses()==null) || 
             (this.email_addresses!=null &&
              this.email_addresses.equals(other.getEmail_addresses()))) &&
            ((this.form_letter_history_data==null && other.getForm_letter_history_data()==null) || 
             (this.form_letter_history_data!=null &&
              java.util.Arrays.equals(this.form_letter_history_data, other.getForm_letter_history_data()))) &&
            ((this.auxiliary_data==null && other.getAuxiliary_data()==null) || 
             (this.auxiliary_data!=null &&
              java.util.Arrays.equals(this.auxiliary_data, other.getAuxiliary_data()))) &&
            ((this.email_cause==null && other.getEmail_cause()==null) || 
             (this.email_cause!=null &&
              this.email_cause.equals(other.getEmail_cause()))) &&
            ((this.email_complaint==null && other.getEmail_complaint()==null) || 
             (this.email_complaint!=null &&
              this.email_complaint.equals(other.getEmail_complaint()))) &&
            ((this.email_service==null && other.getEmail_service()==null) || 
             (this.email_service!=null &&
              this.email_service.equals(other.getEmail_service())));
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
        if (getCause_code() != null) {
            _hashCode += getCause_code().hashCode();
        }
        if (getClaim_ref_nbr() != null) {
            _hashCode += getClaim_ref_nbr().hashCode();
        }
        if (getComplaint_code() != null) {
            _hashCode += getComplaint_code().hashCode();
        }
        if (getComplaint_date() != null) {
            _hashCode += getComplaint_date().hashCode();
        }
        if (getFollowup_date() != null) {
            _hashCode += getFollowup_date().hashCode();
        }
        if (getOrder_item_seq() != null) {
            _hashCode += getOrder_item_seq().hashCode();
        }
        if (getOrderhdr_id() != null) {
            _hashCode += getOrderhdr_id().hashCode();
        }
        if (getService_code() != null) {
            _hashCode += getService_code().hashCode();
        }
        if (getService_date() != null) {
            _hashCode += getService_date().hashCode();
        }
        _hashCode += getService_status();
        if (getSubscrip_id() != null) {
            _hashCode += getSubscrip_id().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getNote_field() != null) {
            _hashCode += getNote_field().hashCode();
        }
        if (getEmail_addresses() != null) {
            _hashCode += getEmail_addresses().hashCode();
        }
        if (getForm_letter_history_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getForm_letter_history_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getForm_letter_history_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAuxiliary_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuxiliary_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuxiliary_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEmail_cause() != null) {
            _hashCode += getEmail_cause().hashCode();
        }
        if (getEmail_complaint() != null) {
            _hashCode += getEmail_complaint().hashCode();
        }
        if (getEmail_service() != null) {
            _hashCode += getEmail_service().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Service_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">service_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email_cause");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email_cause"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email_complaint");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email_complaint"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email_service");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email_service"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cause_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "cause_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claim_ref_nbr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "claim_ref_nbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complaint_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "complaint_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complaint_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "complaint_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("followup_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "followup_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("service_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note_field");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "note_field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email_addresses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "email_addresses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("form_letter_history_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "form_letter_history_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "form_letter_history_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auxiliary_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
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
