/**
 * Customer_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_data  extends Think.XmlWebServices.ZZName  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_address_data[] customer_address_data;

    private Think.XmlWebServices.Customer_login_data customer_login_data;

    private Think.XmlWebServices.Prospect_data[] prospect_data;

    private Think.XmlWebServices.Agency_data agency_data;

    private Think.XmlWebServices.Distributor_data distributor_data;

    private Think.XmlWebServices.Ip_address_data[] ip_address_datas;

    private Think.XmlWebServices.Customer_group_data customer_group_data;

    private Think.XmlWebServices.Group_member_data[] group_member_datas;

    private java.lang.Integer default_bill_to_customer_id;

    private java.lang.Integer def_bill_to_cust_addr_seq;

    private java.lang.Integer default_renew_to_customer_id;

    private java.lang.Integer def_renew_to_cust_addr_seq;

    private java.lang.Integer default_cust_addr_seq;

    private java.lang.String list_rental_category;

    private byte[] email_authorization;

    private java.lang.String credit_status;

    private java.lang.Integer oc_id;

    private java.lang.String customer_category;

    private java.lang.String institutional_identifier;

    private java.lang.String parent_inst_identifier;

    private java.lang.String company;

    private java.lang.Integer sales_representative_id;

    private Think.XmlWebServices.Auxiliary_data[] auxiliary_data;

    private Think.XmlWebServices.ZZBoolean suppress_email_change_notify;  // attribute

    public Customer_data() {
    }

    public Customer_data(
           java.lang.String lname,
           java.lang.String initial_name,
           java.lang.String fname,
           java.lang.String salutation,
           java.lang.String suffix,
           java.lang.String title,
           java.lang.String email,
           Think.XmlWebServices.ZZBoolean suppress_email_change_notify,
           Think.XmlWebServices.Customer_address_data[] customer_address_data,
           Think.XmlWebServices.Customer_login_data customer_login_data,
           Think.XmlWebServices.Prospect_data[] prospect_data,
           Think.XmlWebServices.Agency_data agency_data,
           Think.XmlWebServices.Distributor_data distributor_data,
           Think.XmlWebServices.Ip_address_data[] ip_address_datas,
           Think.XmlWebServices.Customer_group_data customer_group_data,
           Think.XmlWebServices.Group_member_data[] group_member_datas,
           java.lang.Integer default_bill_to_customer_id,
           java.lang.Integer def_bill_to_cust_addr_seq,
           java.lang.Integer default_renew_to_customer_id,
           java.lang.Integer def_renew_to_cust_addr_seq,
           java.lang.Integer default_cust_addr_seq,
           java.lang.String list_rental_category,
           byte[] email_authorization,
           java.lang.String credit_status,
           java.lang.Integer oc_id,
           java.lang.String customer_category,
           java.lang.String institutional_identifier,
           java.lang.String parent_inst_identifier,
           java.lang.String company,
           java.lang.Integer sales_representative_id,
           Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        super(
            lname,
            initial_name,
            fname,
            salutation,
            suffix,
            title,
            email);
        this.suppress_email_change_notify = suppress_email_change_notify;
        this.customer_address_data = customer_address_data;
        this.customer_login_data = customer_login_data;
        this.prospect_data = prospect_data;
        this.agency_data = agency_data;
        this.distributor_data = distributor_data;
        this.ip_address_datas = ip_address_datas;
        this.customer_group_data = customer_group_data;
        this.group_member_datas = group_member_datas;
        this.default_bill_to_customer_id = default_bill_to_customer_id;
        this.def_bill_to_cust_addr_seq = def_bill_to_cust_addr_seq;
        this.default_renew_to_customer_id = default_renew_to_customer_id;
        this.def_renew_to_cust_addr_seq = def_renew_to_cust_addr_seq;
        this.default_cust_addr_seq = default_cust_addr_seq;
        this.list_rental_category = list_rental_category;
        this.email_authorization = email_authorization;
        this.credit_status = credit_status;
        this.oc_id = oc_id;
        this.customer_category = customer_category;
        this.institutional_identifier = institutional_identifier;
        this.parent_inst_identifier = parent_inst_identifier;
        this.company = company;
        this.sales_representative_id = sales_representative_id;
        this.auxiliary_data = auxiliary_data;
    }


    /**
     * Gets the customer_address_data value for this Customer_data.
     * 
     * @return customer_address_data
     */
    public Think.XmlWebServices.Customer_address_data[] getCustomer_address_data() {
        return customer_address_data;
    }


    /**
     * Sets the customer_address_data value for this Customer_data.
     * 
     * @param customer_address_data
     */
    public void setCustomer_address_data(Think.XmlWebServices.Customer_address_data[] customer_address_data) {
        this.customer_address_data = customer_address_data;
    }

    public Think.XmlWebServices.Customer_address_data getCustomer_address_data(int i) {
        return this.customer_address_data[i];
    }

    public void setCustomer_address_data(int i, Think.XmlWebServices.Customer_address_data _value) {
        this.customer_address_data[i] = _value;
    }


    /**
     * Gets the customer_login_data value for this Customer_data.
     * 
     * @return customer_login_data
     */
    public Think.XmlWebServices.Customer_login_data getCustomer_login_data() {
        return customer_login_data;
    }


    /**
     * Sets the customer_login_data value for this Customer_data.
     * 
     * @param customer_login_data
     */
    public void setCustomer_login_data(Think.XmlWebServices.Customer_login_data customer_login_data) {
        this.customer_login_data = customer_login_data;
    }


    /**
     * Gets the prospect_data value for this Customer_data.
     * 
     * @return prospect_data
     */
    public Think.XmlWebServices.Prospect_data[] getProspect_data() {
        return prospect_data;
    }


    /**
     * Sets the prospect_data value for this Customer_data.
     * 
     * @param prospect_data
     */
    public void setProspect_data(Think.XmlWebServices.Prospect_data[] prospect_data) {
        this.prospect_data = prospect_data;
    }

    public Think.XmlWebServices.Prospect_data getProspect_data(int i) {
        return this.prospect_data[i];
    }

    public void setProspect_data(int i, Think.XmlWebServices.Prospect_data _value) {
        this.prospect_data[i] = _value;
    }


    /**
     * Gets the agency_data value for this Customer_data.
     * 
     * @return agency_data
     */
    public Think.XmlWebServices.Agency_data getAgency_data() {
        return agency_data;
    }


    /**
     * Sets the agency_data value for this Customer_data.
     * 
     * @param agency_data
     */
    public void setAgency_data(Think.XmlWebServices.Agency_data agency_data) {
        this.agency_data = agency_data;
    }


    /**
     * Gets the distributor_data value for this Customer_data.
     * 
     * @return distributor_data
     */
    public Think.XmlWebServices.Distributor_data getDistributor_data() {
        return distributor_data;
    }


    /**
     * Sets the distributor_data value for this Customer_data.
     * 
     * @param distributor_data
     */
    public void setDistributor_data(Think.XmlWebServices.Distributor_data distributor_data) {
        this.distributor_data = distributor_data;
    }


    /**
     * Gets the ip_address_datas value for this Customer_data.
     * 
     * @return ip_address_datas
     */
    public Think.XmlWebServices.Ip_address_data[] getIp_address_datas() {
        return ip_address_datas;
    }


    /**
     * Sets the ip_address_datas value for this Customer_data.
     * 
     * @param ip_address_datas
     */
    public void setIp_address_datas(Think.XmlWebServices.Ip_address_data[] ip_address_datas) {
        this.ip_address_datas = ip_address_datas;
    }


    /**
     * Gets the customer_group_data value for this Customer_data.
     * 
     * @return customer_group_data
     */
    public Think.XmlWebServices.Customer_group_data getCustomer_group_data() {
        return customer_group_data;
    }


    /**
     * Sets the customer_group_data value for this Customer_data.
     * 
     * @param customer_group_data
     */
    public void setCustomer_group_data(Think.XmlWebServices.Customer_group_data customer_group_data) {
        this.customer_group_data = customer_group_data;
    }


    /**
     * Gets the group_member_datas value for this Customer_data.
     * 
     * @return group_member_datas
     */
    public Think.XmlWebServices.Group_member_data[] getGroup_member_datas() {
        return group_member_datas;
    }


    /**
     * Sets the group_member_datas value for this Customer_data.
     * 
     * @param group_member_datas
     */
    public void setGroup_member_datas(Think.XmlWebServices.Group_member_data[] group_member_datas) {
        this.group_member_datas = group_member_datas;
    }


    /**
     * Gets the default_bill_to_customer_id value for this Customer_data.
     * 
     * @return default_bill_to_customer_id
     */
    public java.lang.Integer getDefault_bill_to_customer_id() {
        return default_bill_to_customer_id;
    }


    /**
     * Sets the default_bill_to_customer_id value for this Customer_data.
     * 
     * @param default_bill_to_customer_id
     */
    public void setDefault_bill_to_customer_id(java.lang.Integer default_bill_to_customer_id) {
        this.default_bill_to_customer_id = default_bill_to_customer_id;
    }


    /**
     * Gets the def_bill_to_cust_addr_seq value for this Customer_data.
     * 
     * @return def_bill_to_cust_addr_seq
     */
    public java.lang.Integer getDef_bill_to_cust_addr_seq() {
        return def_bill_to_cust_addr_seq;
    }


    /**
     * Sets the def_bill_to_cust_addr_seq value for this Customer_data.
     * 
     * @param def_bill_to_cust_addr_seq
     */
    public void setDef_bill_to_cust_addr_seq(java.lang.Integer def_bill_to_cust_addr_seq) {
        this.def_bill_to_cust_addr_seq = def_bill_to_cust_addr_seq;
    }


    /**
     * Gets the default_renew_to_customer_id value for this Customer_data.
     * 
     * @return default_renew_to_customer_id
     */
    public java.lang.Integer getDefault_renew_to_customer_id() {
        return default_renew_to_customer_id;
    }


    /**
     * Sets the default_renew_to_customer_id value for this Customer_data.
     * 
     * @param default_renew_to_customer_id
     */
    public void setDefault_renew_to_customer_id(java.lang.Integer default_renew_to_customer_id) {
        this.default_renew_to_customer_id = default_renew_to_customer_id;
    }


    /**
     * Gets the def_renew_to_cust_addr_seq value for this Customer_data.
     * 
     * @return def_renew_to_cust_addr_seq
     */
    public java.lang.Integer getDef_renew_to_cust_addr_seq() {
        return def_renew_to_cust_addr_seq;
    }


    /**
     * Sets the def_renew_to_cust_addr_seq value for this Customer_data.
     * 
     * @param def_renew_to_cust_addr_seq
     */
    public void setDef_renew_to_cust_addr_seq(java.lang.Integer def_renew_to_cust_addr_seq) {
        this.def_renew_to_cust_addr_seq = def_renew_to_cust_addr_seq;
    }


    /**
     * Gets the default_cust_addr_seq value for this Customer_data.
     * 
     * @return default_cust_addr_seq
     */
    public java.lang.Integer getDefault_cust_addr_seq() {
        return default_cust_addr_seq;
    }


    /**
     * Sets the default_cust_addr_seq value for this Customer_data.
     * 
     * @param default_cust_addr_seq
     */
    public void setDefault_cust_addr_seq(java.lang.Integer default_cust_addr_seq) {
        this.default_cust_addr_seq = default_cust_addr_seq;
    }


    /**
     * Gets the list_rental_category value for this Customer_data.
     * 
     * @return list_rental_category
     */
    public java.lang.String getList_rental_category() {
        return list_rental_category;
    }


    /**
     * Sets the list_rental_category value for this Customer_data.
     * 
     * @param list_rental_category
     */
    public void setList_rental_category(java.lang.String list_rental_category) {
        this.list_rental_category = list_rental_category;
    }


    /**
     * Gets the email_authorization value for this Customer_data.
     * 
     * @return email_authorization
     */
    public byte[] getEmail_authorization() {
        return email_authorization;
    }


    /**
     * Sets the email_authorization value for this Customer_data.
     * 
     * @param email_authorization
     */
    public void setEmail_authorization(byte[] email_authorization) {
        this.email_authorization = email_authorization;
    }


    /**
     * Gets the credit_status value for this Customer_data.
     * 
     * @return credit_status
     */
    public java.lang.String getCredit_status() {
        return credit_status;
    }


    /**
     * Sets the credit_status value for this Customer_data.
     * 
     * @param credit_status
     */
    public void setCredit_status(java.lang.String credit_status) {
        this.credit_status = credit_status;
    }


    /**
     * Gets the oc_id value for this Customer_data.
     * 
     * @return oc_id
     */
    public java.lang.Integer getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Customer_data.
     * 
     * @param oc_id
     */
    public void setOc_id(java.lang.Integer oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the customer_category value for this Customer_data.
     * 
     * @return customer_category
     */
    public java.lang.String getCustomer_category() {
        return customer_category;
    }


    /**
     * Sets the customer_category value for this Customer_data.
     * 
     * @param customer_category
     */
    public void setCustomer_category(java.lang.String customer_category) {
        this.customer_category = customer_category;
    }


    /**
     * Gets the institutional_identifier value for this Customer_data.
     * 
     * @return institutional_identifier
     */
    public java.lang.String getInstitutional_identifier() {
        return institutional_identifier;
    }


    /**
     * Sets the institutional_identifier value for this Customer_data.
     * 
     * @param institutional_identifier
     */
    public void setInstitutional_identifier(java.lang.String institutional_identifier) {
        this.institutional_identifier = institutional_identifier;
    }


    /**
     * Gets the parent_inst_identifier value for this Customer_data.
     * 
     * @return parent_inst_identifier
     */
    public java.lang.String getParent_inst_identifier() {
        return parent_inst_identifier;
    }


    /**
     * Sets the parent_inst_identifier value for this Customer_data.
     * 
     * @param parent_inst_identifier
     */
    public void setParent_inst_identifier(java.lang.String parent_inst_identifier) {
        this.parent_inst_identifier = parent_inst_identifier;
    }


    /**
     * Gets the company value for this Customer_data.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this Customer_data.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the sales_representative_id value for this Customer_data.
     * 
     * @return sales_representative_id
     */
    public java.lang.Integer getSales_representative_id() {
        return sales_representative_id;
    }


    /**
     * Sets the sales_representative_id value for this Customer_data.
     * 
     * @param sales_representative_id
     */
    public void setSales_representative_id(java.lang.Integer sales_representative_id) {
        this.sales_representative_id = sales_representative_id;
    }


    /**
     * Gets the auxiliary_data value for this Customer_data.
     * 
     * @return auxiliary_data
     */
    public Think.XmlWebServices.Auxiliary_data[] getAuxiliary_data() {
        return auxiliary_data;
    }


    /**
     * Sets the auxiliary_data value for this Customer_data.
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
     * Gets the suppress_email_change_notify value for this Customer_data.
     * 
     * @return suppress_email_change_notify
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_email_change_notify() {
        return suppress_email_change_notify;
    }


    /**
     * Sets the suppress_email_change_notify value for this Customer_data.
     * 
     * @param suppress_email_change_notify
     */
    public void setSuppress_email_change_notify(Think.XmlWebServices.ZZBoolean suppress_email_change_notify) {
        this.suppress_email_change_notify = suppress_email_change_notify;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_data)) return false;
        Customer_data other = (Customer_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_address_data==null && other.getCustomer_address_data()==null) || 
             (this.customer_address_data!=null &&
              java.util.Arrays.equals(this.customer_address_data, other.getCustomer_address_data()))) &&
            ((this.customer_login_data==null && other.getCustomer_login_data()==null) || 
             (this.customer_login_data!=null &&
              this.customer_login_data.equals(other.getCustomer_login_data()))) &&
            ((this.prospect_data==null && other.getProspect_data()==null) || 
             (this.prospect_data!=null &&
              java.util.Arrays.equals(this.prospect_data, other.getProspect_data()))) &&
            ((this.agency_data==null && other.getAgency_data()==null) || 
             (this.agency_data!=null &&
              this.agency_data.equals(other.getAgency_data()))) &&
            ((this.distributor_data==null && other.getDistributor_data()==null) || 
             (this.distributor_data!=null &&
              this.distributor_data.equals(other.getDistributor_data()))) &&
            ((this.ip_address_datas==null && other.getIp_address_datas()==null) || 
             (this.ip_address_datas!=null &&
              java.util.Arrays.equals(this.ip_address_datas, other.getIp_address_datas()))) &&
            ((this.customer_group_data==null && other.getCustomer_group_data()==null) || 
             (this.customer_group_data!=null &&
              this.customer_group_data.equals(other.getCustomer_group_data()))) &&
            ((this.group_member_datas==null && other.getGroup_member_datas()==null) || 
             (this.group_member_datas!=null &&
              java.util.Arrays.equals(this.group_member_datas, other.getGroup_member_datas()))) &&
            ((this.default_bill_to_customer_id==null && other.getDefault_bill_to_customer_id()==null) || 
             (this.default_bill_to_customer_id!=null &&
              this.default_bill_to_customer_id.equals(other.getDefault_bill_to_customer_id()))) &&
            ((this.def_bill_to_cust_addr_seq==null && other.getDef_bill_to_cust_addr_seq()==null) || 
             (this.def_bill_to_cust_addr_seq!=null &&
              this.def_bill_to_cust_addr_seq.equals(other.getDef_bill_to_cust_addr_seq()))) &&
            ((this.default_renew_to_customer_id==null && other.getDefault_renew_to_customer_id()==null) || 
             (this.default_renew_to_customer_id!=null &&
              this.default_renew_to_customer_id.equals(other.getDefault_renew_to_customer_id()))) &&
            ((this.def_renew_to_cust_addr_seq==null && other.getDef_renew_to_cust_addr_seq()==null) || 
             (this.def_renew_to_cust_addr_seq!=null &&
              this.def_renew_to_cust_addr_seq.equals(other.getDef_renew_to_cust_addr_seq()))) &&
            ((this.default_cust_addr_seq==null && other.getDefault_cust_addr_seq()==null) || 
             (this.default_cust_addr_seq!=null &&
              this.default_cust_addr_seq.equals(other.getDefault_cust_addr_seq()))) &&
            ((this.list_rental_category==null && other.getList_rental_category()==null) || 
             (this.list_rental_category!=null &&
              this.list_rental_category.equals(other.getList_rental_category()))) &&
            ((this.email_authorization==null && other.getEmail_authorization()==null) || 
             (this.email_authorization!=null &&
              java.util.Arrays.equals(this.email_authorization, other.getEmail_authorization()))) &&
            ((this.credit_status==null && other.getCredit_status()==null) || 
             (this.credit_status!=null &&
              this.credit_status.equals(other.getCredit_status()))) &&
            ((this.oc_id==null && other.getOc_id()==null) || 
             (this.oc_id!=null &&
              this.oc_id.equals(other.getOc_id()))) &&
            ((this.customer_category==null && other.getCustomer_category()==null) || 
             (this.customer_category!=null &&
              this.customer_category.equals(other.getCustomer_category()))) &&
            ((this.institutional_identifier==null && other.getInstitutional_identifier()==null) || 
             (this.institutional_identifier!=null &&
              this.institutional_identifier.equals(other.getInstitutional_identifier()))) &&
            ((this.parent_inst_identifier==null && other.getParent_inst_identifier()==null) || 
             (this.parent_inst_identifier!=null &&
              this.parent_inst_identifier.equals(other.getParent_inst_identifier()))) &&
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.sales_representative_id==null && other.getSales_representative_id()==null) || 
             (this.sales_representative_id!=null &&
              this.sales_representative_id.equals(other.getSales_representative_id()))) &&
            ((this.auxiliary_data==null && other.getAuxiliary_data()==null) || 
             (this.auxiliary_data!=null &&
              java.util.Arrays.equals(this.auxiliary_data, other.getAuxiliary_data()))) &&
            ((this.suppress_email_change_notify==null && other.getSuppress_email_change_notify()==null) || 
             (this.suppress_email_change_notify!=null &&
              this.suppress_email_change_notify.equals(other.getSuppress_email_change_notify())));
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
        if (getCustomer_address_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_address_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_address_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomer_login_data() != null) {
            _hashCode += getCustomer_login_data().hashCode();
        }
        if (getProspect_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProspect_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProspect_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAgency_data() != null) {
            _hashCode += getAgency_data().hashCode();
        }
        if (getDistributor_data() != null) {
            _hashCode += getDistributor_data().hashCode();
        }
        if (getIp_address_datas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIp_address_datas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIp_address_datas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomer_group_data() != null) {
            _hashCode += getCustomer_group_data().hashCode();
        }
        if (getGroup_member_datas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroup_member_datas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroup_member_datas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefault_bill_to_customer_id() != null) {
            _hashCode += getDefault_bill_to_customer_id().hashCode();
        }
        if (getDef_bill_to_cust_addr_seq() != null) {
            _hashCode += getDef_bill_to_cust_addr_seq().hashCode();
        }
        if (getDefault_renew_to_customer_id() != null) {
            _hashCode += getDefault_renew_to_customer_id().hashCode();
        }
        if (getDef_renew_to_cust_addr_seq() != null) {
            _hashCode += getDef_renew_to_cust_addr_seq().hashCode();
        }
        if (getDefault_cust_addr_seq() != null) {
            _hashCode += getDefault_cust_addr_seq().hashCode();
        }
        if (getList_rental_category() != null) {
            _hashCode += getList_rental_category().hashCode();
        }
        if (getEmail_authorization() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmail_authorization());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmail_authorization(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCredit_status() != null) {
            _hashCode += getCredit_status().hashCode();
        }
        if (getOc_id() != null) {
            _hashCode += getOc_id().hashCode();
        }
        if (getCustomer_category() != null) {
            _hashCode += getCustomer_category().hashCode();
        }
        if (getInstitutional_identifier() != null) {
            _hashCode += getInstitutional_identifier().hashCode();
        }
        if (getParent_inst_identifier() != null) {
            _hashCode += getParent_inst_identifier().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getSales_representative_id() != null) {
            _hashCode += getSales_representative_id().hashCode();
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
        if (getSuppress_email_change_notify() != null) {
            _hashCode += getSuppress_email_change_notify().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_email_change_notify");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_email_change_notify"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prospect_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "prospect_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "prospect_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">agency_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributor_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "distributor_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">distributor_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ip_address_datas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ip_address_datas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">ip_address_datas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_group_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_group_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_group_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_member_datas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "group_member_datas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">group_member_datas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("default_bill_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "default_bill_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def_bill_to_cust_addr_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "def_bill_to_cust_addr_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("default_renew_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "default_renew_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def_renew_to_cust_addr_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "def_renew_to_cust_addr_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("default_cust_addr_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "default_cust_addr_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_rental_category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "list_rental_category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email_authorization");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "email_authorization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "credit_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oc_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "oc_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institutional_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "institutional_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent_inst_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "parent_inst_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sales_representative_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "sales_representative_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
