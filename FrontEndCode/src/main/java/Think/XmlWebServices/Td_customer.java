/**
 * Td_customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_customer  extends Think.XmlWebServices.ZZCustomer  implements java.io.Serializable {
    private java.lang.Object[] td_service;

    private Think.XmlWebServices.Td_customerTd_customer_login_history[] td_customer_login_history;

    private Think.XmlWebServices.ZZIpAddress[] td_ip_address;

    private int customer_address_seq;  // attribute

    private java.lang.String address1;  // attribute

    private java.lang.String address2;  // attribute

    private java.lang.String address3;  // attribute

    private java.lang.String address_status;  // attribute

    private java.lang.String address_type;  // attribute

    private java.lang.String carrier;  // attribute

    private int cass_date;  // attribute

    private java.lang.String city;  // attribute

    private java.lang.String county;  // attribute

    private java.lang.String delivery_point;  // attribute

    private java.lang.String department;  // attribute

    private java.lang.String dp_barcode;  // attribute

    private java.lang.String eighthundred;  // attribute

    private java.lang.String faxnbr;  // attribute

    private java.lang.String lot_nbr;  // attribute

    private java.lang.String mailstop;  // attribute

    private java.lang.String phone;  // attribute

    private int special_tax_id;  // attribute

    private java.lang.String state;  // attribute

    private java.lang.String tax_id_number;  // attribute

    private java.lang.String zip;  // attribute

    private java.lang.String temporary_password;  // attribute

    private int customer_login_id;  // attribute

    private int customer_login_question_id;  // attribute

    private java.lang.String hint;  // attribute

    private int invalid_auth_attempts;  // attribute

    private int is_primary_login;  // attribute

    private int locked_out;  // attribute

    private java.util.Calendar lockout_start;  // attribute

    private java.lang.String login;  // attribute

    private int pending_xaction_header_id;  // attribute

    private int pending_xaction_seq;  // attribute

    private java.lang.String response;  // attribute

    private int salt;  // attribute

    private java.lang.String credit_status_descr;  // attribute

    private java.lang.String customer_category_descr;  // attribute

    private java.lang.String list_rental_category_descr;  // attribute

    private java.lang.String user_code_descr;  // attribute

    private java.lang.String oc_id_descr;  // attribute

    private java.lang.String sales_representative_id_descr;  // attribute

    private java.lang.String address_status_descr;  // attribute

    private java.lang.String address_type_descr;  // attribute

    private java.lang.String state_descr;  // attribute

    private java.lang.String audit_company_id_descr;  // attribute

    private java.lang.String audit_county_descr;  // attribute

    private java.lang.String change_type_descr;  // attribute

    public Td_customer() {
    }

    public Td_customer(
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
           int customer_address_seq,
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String address3,
           java.lang.String address_status,
           java.lang.String address_type,
           java.lang.String carrier,
           int cass_date,
           java.lang.String city,
           java.lang.String county,
           java.lang.String delivery_point,
           java.lang.String department,
           java.lang.String dp_barcode,
           java.lang.String eighthundred,
           java.lang.String faxnbr,
           java.lang.String lot_nbr,
           java.lang.String mailstop,
           java.lang.String phone,
           int special_tax_id,
           java.lang.String state,
           java.lang.String tax_id_number,
           java.lang.String zip,
           java.lang.String temporary_password,
           int customer_login_id,
           int customer_login_question_id,
           java.lang.String hint,
           int invalid_auth_attempts,
           int is_primary_login,
           int locked_out,
           java.util.Calendar lockout_start,
           java.lang.String login,
           int pending_xaction_header_id,
           int pending_xaction_seq,
           java.lang.String response,
           int salt,
           java.lang.String credit_status_descr,
           java.lang.String customer_category_descr,
           java.lang.String list_rental_category_descr,
           java.lang.String user_code_descr,
           java.lang.String oc_id_descr,
           java.lang.String sales_representative_id_descr,
           java.lang.String address_status_descr,
           java.lang.String address_type_descr,
           java.lang.String state_descr,
           java.lang.String audit_company_id_descr,
           java.lang.String audit_county_descr,
           java.lang.String change_type_descr,
           java.lang.Object[] td_service,
           Think.XmlWebServices.Td_customerTd_customer_login_history[] td_customer_login_history,
           Think.XmlWebServices.ZZIpAddress[] td_ip_address) {
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
        this.customer_address_seq = customer_address_seq;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address_status = address_status;
        this.address_type = address_type;
        this.carrier = carrier;
        this.cass_date = cass_date;
        this.city = city;
        this.county = county;
        this.delivery_point = delivery_point;
        this.department = department;
        this.dp_barcode = dp_barcode;
        this.eighthundred = eighthundred;
        this.faxnbr = faxnbr;
        this.lot_nbr = lot_nbr;
        this.mailstop = mailstop;
        this.phone = phone;
        this.special_tax_id = special_tax_id;
        this.state = state;
        this.tax_id_number = tax_id_number;
        this.zip = zip;
        this.temporary_password = temporary_password;
        this.customer_login_id = customer_login_id;
        this.customer_login_question_id = customer_login_question_id;
        this.hint = hint;
        this.invalid_auth_attempts = invalid_auth_attempts;
        this.is_primary_login = is_primary_login;
        this.locked_out = locked_out;
        this.lockout_start = lockout_start;
        this.login = login;
        this.pending_xaction_header_id = pending_xaction_header_id;
        this.pending_xaction_seq = pending_xaction_seq;
        this.response = response;
        this.salt = salt;
        this.credit_status_descr = credit_status_descr;
        this.customer_category_descr = customer_category_descr;
        this.list_rental_category_descr = list_rental_category_descr;
        this.user_code_descr = user_code_descr;
        this.oc_id_descr = oc_id_descr;
        this.sales_representative_id_descr = sales_representative_id_descr;
        this.address_status_descr = address_status_descr;
        this.address_type_descr = address_type_descr;
        this.state_descr = state_descr;
        this.audit_company_id_descr = audit_company_id_descr;
        this.audit_county_descr = audit_county_descr;
        this.change_type_descr = change_type_descr;
        this.td_service = td_service;
        this.td_customer_login_history = td_customer_login_history;
        this.td_ip_address = td_ip_address;
    }


    /**
     * Gets the td_service value for this Td_customer.
     * 
     * @return td_service
     */
    public java.lang.Object[] getTd_service() {
        return td_service;
    }


    /**
     * Sets the td_service value for this Td_customer.
     * 
     * @param td_service
     */
    public void setTd_service(java.lang.Object[] td_service) {
        this.td_service = td_service;
    }

    public java.lang.Object getTd_service(int i) {
        return this.td_service[i];
    }

    public void setTd_service(int i, java.lang.Object _value) {
        this.td_service[i] = _value;
    }


    /**
     * Gets the td_customer_login_history value for this Td_customer.
     * 
     * @return td_customer_login_history
     */
    public Think.XmlWebServices.Td_customerTd_customer_login_history[] getTd_customer_login_history() {
        return td_customer_login_history;
    }


    /**
     * Sets the td_customer_login_history value for this Td_customer.
     * 
     * @param td_customer_login_history
     */
    public void setTd_customer_login_history(Think.XmlWebServices.Td_customerTd_customer_login_history[] td_customer_login_history) {
        this.td_customer_login_history = td_customer_login_history;
    }

    public Think.XmlWebServices.Td_customerTd_customer_login_history getTd_customer_login_history(int i) {
        return this.td_customer_login_history[i];
    }

    public void setTd_customer_login_history(int i, Think.XmlWebServices.Td_customerTd_customer_login_history _value) {
        this.td_customer_login_history[i] = _value;
    }


    /**
     * Gets the td_ip_address value for this Td_customer.
     * 
     * @return td_ip_address
     */
    public Think.XmlWebServices.ZZIpAddress[] getTd_ip_address() {
        return td_ip_address;
    }


    /**
     * Sets the td_ip_address value for this Td_customer.
     * 
     * @param td_ip_address
     */
    public void setTd_ip_address(Think.XmlWebServices.ZZIpAddress[] td_ip_address) {
        this.td_ip_address = td_ip_address;
    }

    public Think.XmlWebServices.ZZIpAddress getTd_ip_address(int i) {
        return this.td_ip_address[i];
    }

    public void setTd_ip_address(int i, Think.XmlWebServices.ZZIpAddress _value) {
        this.td_ip_address[i] = _value;
    }


    /**
     * Gets the customer_address_seq value for this Td_customer.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Td_customer.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the address1 value for this Td_customer.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this Td_customer.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this Td_customer.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this Td_customer.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the address3 value for this Td_customer.
     * 
     * @return address3
     */
    public java.lang.String getAddress3() {
        return address3;
    }


    /**
     * Sets the address3 value for this Td_customer.
     * 
     * @param address3
     */
    public void setAddress3(java.lang.String address3) {
        this.address3 = address3;
    }


    /**
     * Gets the address_status value for this Td_customer.
     * 
     * @return address_status
     */
    public java.lang.String getAddress_status() {
        return address_status;
    }


    /**
     * Sets the address_status value for this Td_customer.
     * 
     * @param address_status
     */
    public void setAddress_status(java.lang.String address_status) {
        this.address_status = address_status;
    }


    /**
     * Gets the address_type value for this Td_customer.
     * 
     * @return address_type
     */
    public java.lang.String getAddress_type() {
        return address_type;
    }


    /**
     * Sets the address_type value for this Td_customer.
     * 
     * @param address_type
     */
    public void setAddress_type(java.lang.String address_type) {
        this.address_type = address_type;
    }


    /**
     * Gets the carrier value for this Td_customer.
     * 
     * @return carrier
     */
    public java.lang.String getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this Td_customer.
     * 
     * @param carrier
     */
    public void setCarrier(java.lang.String carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the cass_date value for this Td_customer.
     * 
     * @return cass_date
     */
    public int getCass_date() {
        return cass_date;
    }


    /**
     * Sets the cass_date value for this Td_customer.
     * 
     * @param cass_date
     */
    public void setCass_date(int cass_date) {
        this.cass_date = cass_date;
    }


    /**
     * Gets the city value for this Td_customer.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this Td_customer.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the county value for this Td_customer.
     * 
     * @return county
     */
    public java.lang.String getCounty() {
        return county;
    }


    /**
     * Sets the county value for this Td_customer.
     * 
     * @param county
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }


    /**
     * Gets the delivery_point value for this Td_customer.
     * 
     * @return delivery_point
     */
    public java.lang.String getDelivery_point() {
        return delivery_point;
    }


    /**
     * Sets the delivery_point value for this Td_customer.
     * 
     * @param delivery_point
     */
    public void setDelivery_point(java.lang.String delivery_point) {
        this.delivery_point = delivery_point;
    }


    /**
     * Gets the department value for this Td_customer.
     * 
     * @return department
     */
    public java.lang.String getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this Td_customer.
     * 
     * @param department
     */
    public void setDepartment(java.lang.String department) {
        this.department = department;
    }


    /**
     * Gets the dp_barcode value for this Td_customer.
     * 
     * @return dp_barcode
     */
    public java.lang.String getDp_barcode() {
        return dp_barcode;
    }


    /**
     * Sets the dp_barcode value for this Td_customer.
     * 
     * @param dp_barcode
     */
    public void setDp_barcode(java.lang.String dp_barcode) {
        this.dp_barcode = dp_barcode;
    }


    /**
     * Gets the eighthundred value for this Td_customer.
     * 
     * @return eighthundred
     */
    public java.lang.String getEighthundred() {
        return eighthundred;
    }


    /**
     * Sets the eighthundred value for this Td_customer.
     * 
     * @param eighthundred
     */
    public void setEighthundred(java.lang.String eighthundred) {
        this.eighthundred = eighthundred;
    }


    /**
     * Gets the faxnbr value for this Td_customer.
     * 
     * @return faxnbr
     */
    public java.lang.String getFaxnbr() {
        return faxnbr;
    }


    /**
     * Sets the faxnbr value for this Td_customer.
     * 
     * @param faxnbr
     */
    public void setFaxnbr(java.lang.String faxnbr) {
        this.faxnbr = faxnbr;
    }


    /**
     * Gets the lot_nbr value for this Td_customer.
     * 
     * @return lot_nbr
     */
    public java.lang.String getLot_nbr() {
        return lot_nbr;
    }


    /**
     * Sets the lot_nbr value for this Td_customer.
     * 
     * @param lot_nbr
     */
    public void setLot_nbr(java.lang.String lot_nbr) {
        this.lot_nbr = lot_nbr;
    }


    /**
     * Gets the mailstop value for this Td_customer.
     * 
     * @return mailstop
     */
    public java.lang.String getMailstop() {
        return mailstop;
    }


    /**
     * Sets the mailstop value for this Td_customer.
     * 
     * @param mailstop
     */
    public void setMailstop(java.lang.String mailstop) {
        this.mailstop = mailstop;
    }


    /**
     * Gets the phone value for this Td_customer.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this Td_customer.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the special_tax_id value for this Td_customer.
     * 
     * @return special_tax_id
     */
    public int getSpecial_tax_id() {
        return special_tax_id;
    }


    /**
     * Sets the special_tax_id value for this Td_customer.
     * 
     * @param special_tax_id
     */
    public void setSpecial_tax_id(int special_tax_id) {
        this.special_tax_id = special_tax_id;
    }


    /**
     * Gets the state value for this Td_customer.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Td_customer.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the tax_id_number value for this Td_customer.
     * 
     * @return tax_id_number
     */
    public java.lang.String getTax_id_number() {
        return tax_id_number;
    }


    /**
     * Sets the tax_id_number value for this Td_customer.
     * 
     * @param tax_id_number
     */
    public void setTax_id_number(java.lang.String tax_id_number) {
        this.tax_id_number = tax_id_number;
    }


    /**
     * Gets the zip value for this Td_customer.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this Td_customer.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }


    /**
     * Gets the temporary_password value for this Td_customer.
     * 
     * @return temporary_password
     */
    public java.lang.String getTemporary_password() {
        return temporary_password;
    }


    /**
     * Sets the temporary_password value for this Td_customer.
     * 
     * @param temporary_password
     */
    public void setTemporary_password(java.lang.String temporary_password) {
        this.temporary_password = temporary_password;
    }


    /**
     * Gets the customer_login_id value for this Td_customer.
     * 
     * @return customer_login_id
     */
    public int getCustomer_login_id() {
        return customer_login_id;
    }


    /**
     * Sets the customer_login_id value for this Td_customer.
     * 
     * @param customer_login_id
     */
    public void setCustomer_login_id(int customer_login_id) {
        this.customer_login_id = customer_login_id;
    }


    /**
     * Gets the customer_login_question_id value for this Td_customer.
     * 
     * @return customer_login_question_id
     */
    public int getCustomer_login_question_id() {
        return customer_login_question_id;
    }


    /**
     * Sets the customer_login_question_id value for this Td_customer.
     * 
     * @param customer_login_question_id
     */
    public void setCustomer_login_question_id(int customer_login_question_id) {
        this.customer_login_question_id = customer_login_question_id;
    }


    /**
     * Gets the hint value for this Td_customer.
     * 
     * @return hint
     */
    public java.lang.String getHint() {
        return hint;
    }


    /**
     * Sets the hint value for this Td_customer.
     * 
     * @param hint
     */
    public void setHint(java.lang.String hint) {
        this.hint = hint;
    }


    /**
     * Gets the invalid_auth_attempts value for this Td_customer.
     * 
     * @return invalid_auth_attempts
     */
    public int getInvalid_auth_attempts() {
        return invalid_auth_attempts;
    }


    /**
     * Sets the invalid_auth_attempts value for this Td_customer.
     * 
     * @param invalid_auth_attempts
     */
    public void setInvalid_auth_attempts(int invalid_auth_attempts) {
        this.invalid_auth_attempts = invalid_auth_attempts;
    }


    /**
     * Gets the is_primary_login value for this Td_customer.
     * 
     * @return is_primary_login
     */
    public int getIs_primary_login() {
        return is_primary_login;
    }


    /**
     * Sets the is_primary_login value for this Td_customer.
     * 
     * @param is_primary_login
     */
    public void setIs_primary_login(int is_primary_login) {
        this.is_primary_login = is_primary_login;
    }


    /**
     * Gets the locked_out value for this Td_customer.
     * 
     * @return locked_out
     */
    public int getLocked_out() {
        return locked_out;
    }


    /**
     * Sets the locked_out value for this Td_customer.
     * 
     * @param locked_out
     */
    public void setLocked_out(int locked_out) {
        this.locked_out = locked_out;
    }


    /**
     * Gets the lockout_start value for this Td_customer.
     * 
     * @return lockout_start
     */
    public java.util.Calendar getLockout_start() {
        return lockout_start;
    }


    /**
     * Sets the lockout_start value for this Td_customer.
     * 
     * @param lockout_start
     */
    public void setLockout_start(java.util.Calendar lockout_start) {
        this.lockout_start = lockout_start;
    }


    /**
     * Gets the login value for this Td_customer.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this Td_customer.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the pending_xaction_header_id value for this Td_customer.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this Td_customer.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the pending_xaction_seq value for this Td_customer.
     * 
     * @return pending_xaction_seq
     */
    public int getPending_xaction_seq() {
        return pending_xaction_seq;
    }


    /**
     * Sets the pending_xaction_seq value for this Td_customer.
     * 
     * @param pending_xaction_seq
     */
    public void setPending_xaction_seq(int pending_xaction_seq) {
        this.pending_xaction_seq = pending_xaction_seq;
    }


    /**
     * Gets the response value for this Td_customer.
     * 
     * @return response
     */
    public java.lang.String getResponse() {
        return response;
    }


    /**
     * Sets the response value for this Td_customer.
     * 
     * @param response
     */
    public void setResponse(java.lang.String response) {
        this.response = response;
    }


    /**
     * Gets the salt value for this Td_customer.
     * 
     * @return salt
     */
    public int getSalt() {
        return salt;
    }


    /**
     * Sets the salt value for this Td_customer.
     * 
     * @param salt
     */
    public void setSalt(int salt) {
        this.salt = salt;
    }


    /**
     * Gets the credit_status_descr value for this Td_customer.
     * 
     * @return credit_status_descr
     */
    public java.lang.String getCredit_status_descr() {
        return credit_status_descr;
    }


    /**
     * Sets the credit_status_descr value for this Td_customer.
     * 
     * @param credit_status_descr
     */
    public void setCredit_status_descr(java.lang.String credit_status_descr) {
        this.credit_status_descr = credit_status_descr;
    }


    /**
     * Gets the customer_category_descr value for this Td_customer.
     * 
     * @return customer_category_descr
     */
    public java.lang.String getCustomer_category_descr() {
        return customer_category_descr;
    }


    /**
     * Sets the customer_category_descr value for this Td_customer.
     * 
     * @param customer_category_descr
     */
    public void setCustomer_category_descr(java.lang.String customer_category_descr) {
        this.customer_category_descr = customer_category_descr;
    }


    /**
     * Gets the list_rental_category_descr value for this Td_customer.
     * 
     * @return list_rental_category_descr
     */
    public java.lang.String getList_rental_category_descr() {
        return list_rental_category_descr;
    }


    /**
     * Sets the list_rental_category_descr value for this Td_customer.
     * 
     * @param list_rental_category_descr
     */
    public void setList_rental_category_descr(java.lang.String list_rental_category_descr) {
        this.list_rental_category_descr = list_rental_category_descr;
    }


    /**
     * Gets the user_code_descr value for this Td_customer.
     * 
     * @return user_code_descr
     */
    public java.lang.String getUser_code_descr() {
        return user_code_descr;
    }


    /**
     * Sets the user_code_descr value for this Td_customer.
     * 
     * @param user_code_descr
     */
    public void setUser_code_descr(java.lang.String user_code_descr) {
        this.user_code_descr = user_code_descr;
    }


    /**
     * Gets the oc_id_descr value for this Td_customer.
     * 
     * @return oc_id_descr
     */
    public java.lang.String getOc_id_descr() {
        return oc_id_descr;
    }


    /**
     * Sets the oc_id_descr value for this Td_customer.
     * 
     * @param oc_id_descr
     */
    public void setOc_id_descr(java.lang.String oc_id_descr) {
        this.oc_id_descr = oc_id_descr;
    }


    /**
     * Gets the sales_representative_id_descr value for this Td_customer.
     * 
     * @return sales_representative_id_descr
     */
    public java.lang.String getSales_representative_id_descr() {
        return sales_representative_id_descr;
    }


    /**
     * Sets the sales_representative_id_descr value for this Td_customer.
     * 
     * @param sales_representative_id_descr
     */
    public void setSales_representative_id_descr(java.lang.String sales_representative_id_descr) {
        this.sales_representative_id_descr = sales_representative_id_descr;
    }


    /**
     * Gets the address_status_descr value for this Td_customer.
     * 
     * @return address_status_descr
     */
    public java.lang.String getAddress_status_descr() {
        return address_status_descr;
    }


    /**
     * Sets the address_status_descr value for this Td_customer.
     * 
     * @param address_status_descr
     */
    public void setAddress_status_descr(java.lang.String address_status_descr) {
        this.address_status_descr = address_status_descr;
    }


    /**
     * Gets the address_type_descr value for this Td_customer.
     * 
     * @return address_type_descr
     */
    public java.lang.String getAddress_type_descr() {
        return address_type_descr;
    }


    /**
     * Sets the address_type_descr value for this Td_customer.
     * 
     * @param address_type_descr
     */
    public void setAddress_type_descr(java.lang.String address_type_descr) {
        this.address_type_descr = address_type_descr;
    }


    /**
     * Gets the state_descr value for this Td_customer.
     * 
     * @return state_descr
     */
    public java.lang.String getState_descr() {
        return state_descr;
    }


    /**
     * Sets the state_descr value for this Td_customer.
     * 
     * @param state_descr
     */
    public void setState_descr(java.lang.String state_descr) {
        this.state_descr = state_descr;
    }


    /**
     * Gets the audit_company_id_descr value for this Td_customer.
     * 
     * @return audit_company_id_descr
     */
    public java.lang.String getAudit_company_id_descr() {
        return audit_company_id_descr;
    }


    /**
     * Sets the audit_company_id_descr value for this Td_customer.
     * 
     * @param audit_company_id_descr
     */
    public void setAudit_company_id_descr(java.lang.String audit_company_id_descr) {
        this.audit_company_id_descr = audit_company_id_descr;
    }


    /**
     * Gets the audit_county_descr value for this Td_customer.
     * 
     * @return audit_county_descr
     */
    public java.lang.String getAudit_county_descr() {
        return audit_county_descr;
    }


    /**
     * Sets the audit_county_descr value for this Td_customer.
     * 
     * @param audit_county_descr
     */
    public void setAudit_county_descr(java.lang.String audit_county_descr) {
        this.audit_county_descr = audit_county_descr;
    }


    /**
     * Gets the change_type_descr value for this Td_customer.
     * 
     * @return change_type_descr
     */
    public java.lang.String getChange_type_descr() {
        return change_type_descr;
    }


    /**
     * Sets the change_type_descr value for this Td_customer.
     * 
     * @param change_type_descr
     */
    public void setChange_type_descr(java.lang.String change_type_descr) {
        this.change_type_descr = change_type_descr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_customer)) return false;
        Td_customer other = (Td_customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.td_service==null && other.getTd_service()==null) || 
             (this.td_service!=null &&
              java.util.Arrays.equals(this.td_service, other.getTd_service()))) &&
            ((this.td_customer_login_history==null && other.getTd_customer_login_history()==null) || 
             (this.td_customer_login_history!=null &&
              java.util.Arrays.equals(this.td_customer_login_history, other.getTd_customer_login_history()))) &&
            ((this.td_ip_address==null && other.getTd_ip_address()==null) || 
             (this.td_ip_address!=null &&
              java.util.Arrays.equals(this.td_ip_address, other.getTd_ip_address()))) &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            ((this.address1==null && other.getAddress1()==null) || 
             (this.address1!=null &&
              this.address1.equals(other.getAddress1()))) &&
            ((this.address2==null && other.getAddress2()==null) || 
             (this.address2!=null &&
              this.address2.equals(other.getAddress2()))) &&
            ((this.address3==null && other.getAddress3()==null) || 
             (this.address3!=null &&
              this.address3.equals(other.getAddress3()))) &&
            ((this.address_status==null && other.getAddress_status()==null) || 
             (this.address_status!=null &&
              this.address_status.equals(other.getAddress_status()))) &&
            ((this.address_type==null && other.getAddress_type()==null) || 
             (this.address_type!=null &&
              this.address_type.equals(other.getAddress_type()))) &&
            ((this.carrier==null && other.getCarrier()==null) || 
             (this.carrier!=null &&
              this.carrier.equals(other.getCarrier()))) &&
            this.cass_date == other.getCass_date() &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.county==null && other.getCounty()==null) || 
             (this.county!=null &&
              this.county.equals(other.getCounty()))) &&
            ((this.delivery_point==null && other.getDelivery_point()==null) || 
             (this.delivery_point!=null &&
              this.delivery_point.equals(other.getDelivery_point()))) &&
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment()))) &&
            ((this.dp_barcode==null && other.getDp_barcode()==null) || 
             (this.dp_barcode!=null &&
              this.dp_barcode.equals(other.getDp_barcode()))) &&
            ((this.eighthundred==null && other.getEighthundred()==null) || 
             (this.eighthundred!=null &&
              this.eighthundred.equals(other.getEighthundred()))) &&
            ((this.faxnbr==null && other.getFaxnbr()==null) || 
             (this.faxnbr!=null &&
              this.faxnbr.equals(other.getFaxnbr()))) &&
            ((this.lot_nbr==null && other.getLot_nbr()==null) || 
             (this.lot_nbr!=null &&
              this.lot_nbr.equals(other.getLot_nbr()))) &&
            ((this.mailstop==null && other.getMailstop()==null) || 
             (this.mailstop!=null &&
              this.mailstop.equals(other.getMailstop()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            this.special_tax_id == other.getSpecial_tax_id() &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.tax_id_number==null && other.getTax_id_number()==null) || 
             (this.tax_id_number!=null &&
              this.tax_id_number.equals(other.getTax_id_number()))) &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip()))) &&
            ((this.temporary_password==null && other.getTemporary_password()==null) || 
             (this.temporary_password!=null &&
              this.temporary_password.equals(other.getTemporary_password()))) &&
            this.customer_login_id == other.getCustomer_login_id() &&
            this.customer_login_question_id == other.getCustomer_login_question_id() &&
            ((this.hint==null && other.getHint()==null) || 
             (this.hint!=null &&
              this.hint.equals(other.getHint()))) &&
            this.invalid_auth_attempts == other.getInvalid_auth_attempts() &&
            this.is_primary_login == other.getIs_primary_login() &&
            this.locked_out == other.getLocked_out() &&
            ((this.lockout_start==null && other.getLockout_start()==null) || 
             (this.lockout_start!=null &&
              this.lockout_start.equals(other.getLockout_start()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            this.pending_xaction_seq == other.getPending_xaction_seq() &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            this.salt == other.getSalt() &&
            ((this.credit_status_descr==null && other.getCredit_status_descr()==null) || 
             (this.credit_status_descr!=null &&
              this.credit_status_descr.equals(other.getCredit_status_descr()))) &&
            ((this.customer_category_descr==null && other.getCustomer_category_descr()==null) || 
             (this.customer_category_descr!=null &&
              this.customer_category_descr.equals(other.getCustomer_category_descr()))) &&
            ((this.list_rental_category_descr==null && other.getList_rental_category_descr()==null) || 
             (this.list_rental_category_descr!=null &&
              this.list_rental_category_descr.equals(other.getList_rental_category_descr()))) &&
            ((this.user_code_descr==null && other.getUser_code_descr()==null) || 
             (this.user_code_descr!=null &&
              this.user_code_descr.equals(other.getUser_code_descr()))) &&
            ((this.oc_id_descr==null && other.getOc_id_descr()==null) || 
             (this.oc_id_descr!=null &&
              this.oc_id_descr.equals(other.getOc_id_descr()))) &&
            ((this.sales_representative_id_descr==null && other.getSales_representative_id_descr()==null) || 
             (this.sales_representative_id_descr!=null &&
              this.sales_representative_id_descr.equals(other.getSales_representative_id_descr()))) &&
            ((this.address_status_descr==null && other.getAddress_status_descr()==null) || 
             (this.address_status_descr!=null &&
              this.address_status_descr.equals(other.getAddress_status_descr()))) &&
            ((this.address_type_descr==null && other.getAddress_type_descr()==null) || 
             (this.address_type_descr!=null &&
              this.address_type_descr.equals(other.getAddress_type_descr()))) &&
            ((this.state_descr==null && other.getState_descr()==null) || 
             (this.state_descr!=null &&
              this.state_descr.equals(other.getState_descr()))) &&
            ((this.audit_company_id_descr==null && other.getAudit_company_id_descr()==null) || 
             (this.audit_company_id_descr!=null &&
              this.audit_company_id_descr.equals(other.getAudit_company_id_descr()))) &&
            ((this.audit_county_descr==null && other.getAudit_county_descr()==null) || 
             (this.audit_county_descr!=null &&
              this.audit_county_descr.equals(other.getAudit_county_descr()))) &&
            ((this.change_type_descr==null && other.getChange_type_descr()==null) || 
             (this.change_type_descr!=null &&
              this.change_type_descr.equals(other.getChange_type_descr())));
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
        if (getTd_service() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_service());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_service(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTd_customer_login_history() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_customer_login_history());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_customer_login_history(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTd_ip_address() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_ip_address());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_ip_address(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCustomer_address_seq();
        if (getAddress1() != null) {
            _hashCode += getAddress1().hashCode();
        }
        if (getAddress2() != null) {
            _hashCode += getAddress2().hashCode();
        }
        if (getAddress3() != null) {
            _hashCode += getAddress3().hashCode();
        }
        if (getAddress_status() != null) {
            _hashCode += getAddress_status().hashCode();
        }
        if (getAddress_type() != null) {
            _hashCode += getAddress_type().hashCode();
        }
        if (getCarrier() != null) {
            _hashCode += getCarrier().hashCode();
        }
        _hashCode += getCass_date();
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getCounty() != null) {
            _hashCode += getCounty().hashCode();
        }
        if (getDelivery_point() != null) {
            _hashCode += getDelivery_point().hashCode();
        }
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        if (getDp_barcode() != null) {
            _hashCode += getDp_barcode().hashCode();
        }
        if (getEighthundred() != null) {
            _hashCode += getEighthundred().hashCode();
        }
        if (getFaxnbr() != null) {
            _hashCode += getFaxnbr().hashCode();
        }
        if (getLot_nbr() != null) {
            _hashCode += getLot_nbr().hashCode();
        }
        if (getMailstop() != null) {
            _hashCode += getMailstop().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        _hashCode += getSpecial_tax_id();
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getTax_id_number() != null) {
            _hashCode += getTax_id_number().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        if (getTemporary_password() != null) {
            _hashCode += getTemporary_password().hashCode();
        }
        _hashCode += getCustomer_login_id();
        _hashCode += getCustomer_login_question_id();
        if (getHint() != null) {
            _hashCode += getHint().hashCode();
        }
        _hashCode += getInvalid_auth_attempts();
        _hashCode += getIs_primary_login();
        _hashCode += getLocked_out();
        if (getLockout_start() != null) {
            _hashCode += getLockout_start().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += getPending_xaction_header_id();
        _hashCode += getPending_xaction_seq();
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        _hashCode += getSalt();
        if (getCredit_status_descr() != null) {
            _hashCode += getCredit_status_descr().hashCode();
        }
        if (getCustomer_category_descr() != null) {
            _hashCode += getCustomer_category_descr().hashCode();
        }
        if (getList_rental_category_descr() != null) {
            _hashCode += getList_rental_category_descr().hashCode();
        }
        if (getUser_code_descr() != null) {
            _hashCode += getUser_code_descr().hashCode();
        }
        if (getOc_id_descr() != null) {
            _hashCode += getOc_id_descr().hashCode();
        }
        if (getSales_representative_id_descr() != null) {
            _hashCode += getSales_representative_id_descr().hashCode();
        }
        if (getAddress_status_descr() != null) {
            _hashCode += getAddress_status_descr().hashCode();
        }
        if (getAddress_type_descr() != null) {
            _hashCode += getAddress_type_descr().hashCode();
        }
        if (getState_descr() != null) {
            _hashCode += getState_descr().hashCode();
        }
        if (getAudit_company_id_descr() != null) {
            _hashCode += getAudit_company_id_descr().hashCode();
        }
        if (getAudit_county_descr() != null) {
            _hashCode += getAudit_county_descr().hashCode();
        }
        if (getChange_type_descr() != null) {
            _hashCode += getChange_type_descr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_customer"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address1");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address1"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address2");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address2"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address3");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address3"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("carrier");
        attrField.setXmlName(new javax.xml.namespace.QName("", "carrier"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cass_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cass_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("city");
        attrField.setXmlName(new javax.xml.namespace.QName("", "city"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("county");
        attrField.setXmlName(new javax.xml.namespace.QName("", "county"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delivery_point");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delivery_point"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("department");
        attrField.setXmlName(new javax.xml.namespace.QName("", "department"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dp_barcode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dp_barcode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("eighthundred");
        attrField.setXmlName(new javax.xml.namespace.QName("", "eighthundred"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("faxnbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "faxnbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lot_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lot_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mailstop");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mailstop"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("phone");
        attrField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("special_tax_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "special_tax_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("state");
        attrField.setXmlName(new javax.xml.namespace.QName("", "state"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tax_id_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tax_id_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("zip");
        attrField.setXmlName(new javax.xml.namespace.QName("", "zip"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("temporary_password");
        attrField.setXmlName(new javax.xml.namespace.QName("", "temporary_password"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_question_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_question_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("hint");
        attrField.setXmlName(new javax.xml.namespace.QName("", "hint"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invalid_auth_attempts");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invalid_auth_attempts"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("is_primary_login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "is_primary_login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("locked_out");
        attrField.setXmlName(new javax.xml.namespace.QName("", "locked_out"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lockout_start");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lockout_start"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_header_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_header_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pending_xaction_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pending_xaction_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "response"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("salt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "salt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_status_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_status_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_category_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_category_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("list_rental_category_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "list_rental_category_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sales_representative_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sales_representative_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address_status_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address_status_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("address_type_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "address_type_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("state_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "state_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_company_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_company_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_county_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_county_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("change_type_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "change_type_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_service");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_customer_login_history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_customer_login_history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>td_customer>td_customer_login_history"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_ip_address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_ip_address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZIpAddress"));
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
