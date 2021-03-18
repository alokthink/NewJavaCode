/**
 * ZZCustomerAddress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZCustomerAddress  implements java.io.Serializable {
    private int customer_id;  // attribute

    private int customer_address_seq;  // attribute

    private java.lang.String address1;  // attribute

    private java.lang.String address2;  // attribute

    private java.lang.String address3;  // attribute

    private java.lang.String address_status;  // attribute

    private java.lang.String address_type;  // attribute

    private int audit_company_id;  // attribute

    private java.lang.String audit_county;  // attribute

    private int audit_name_change;  // attribute

    private int audit_title_change;  // attribute

    private java.lang.String carrier;  // attribute

    private int cass_date;  // attribute

    private int change_type;  // attribute

    private java.lang.String city;  // attribute

    private java.lang.String company;  // attribute

    private java.lang.String county;  // attribute

    private java.lang.String delivery_point;  // attribute

    private java.lang.String department;  // attribute

    private java.lang.String dp_barcode;  // attribute

    private java.util.Date effective_date;  // attribute

    private java.lang.String eighthundred;  // attribute

    private java.lang.String email;  // attribute

    private java.lang.String faxnbr;  // attribute

    private java.lang.String fname;  // attribute

    private int ignored_clean;  // attribute

    private java.lang.String initial_name;  // attribute

    private java.lang.String institutional_identifier;  // attribute

    private java.lang.String lname;  // attribute

    private java.lang.String lot_nbr;  // attribute

    private java.lang.String mailstop;  // attribute

    private java.lang.String old_email;  // attribute

    private java.lang.String phone;  // attribute

    private int replace_customer_address_seq;  // attribute

    private java.util.Date reverse_date;  // attribute

    private java.lang.String salutation;  // attribute

    private int special_tax_id;  // attribute

    private java.lang.String state;  // attribute

    private java.lang.String suffix;  // attribute

    private int supp_clean;  // attribute

    private java.lang.String tax_id_number;  // attribute

    private java.lang.String title;  // attribute

    private java.lang.String zip;  // attribute

    public ZZCustomerAddress() {
    }

    public ZZCustomerAddress(
           int customer_id,
           int customer_address_seq,
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String address3,
           java.lang.String address_status,
           java.lang.String address_type,
           int audit_company_id,
           java.lang.String audit_county,
           int audit_name_change,
           int audit_title_change,
           java.lang.String carrier,
           int cass_date,
           int change_type,
           java.lang.String city,
           java.lang.String company,
           java.lang.String county,
           java.lang.String delivery_point,
           java.lang.String department,
           java.lang.String dp_barcode,
           java.util.Date effective_date,
           java.lang.String eighthundred,
           java.lang.String email,
           java.lang.String faxnbr,
           java.lang.String fname,
           int ignored_clean,
           java.lang.String initial_name,
           java.lang.String institutional_identifier,
           java.lang.String lname,
           java.lang.String lot_nbr,
           java.lang.String mailstop,
           java.lang.String old_email,
           java.lang.String phone,
           int replace_customer_address_seq,
           java.util.Date reverse_date,
           java.lang.String salutation,
           int special_tax_id,
           java.lang.String state,
           java.lang.String suffix,
           int supp_clean,
           java.lang.String tax_id_number,
           java.lang.String title,
           java.lang.String zip) {
           this.customer_id = customer_id;
           this.customer_address_seq = customer_address_seq;
           this.address1 = address1;
           this.address2 = address2;
           this.address3 = address3;
           this.address_status = address_status;
           this.address_type = address_type;
           this.audit_company_id = audit_company_id;
           this.audit_county = audit_county;
           this.audit_name_change = audit_name_change;
           this.audit_title_change = audit_title_change;
           this.carrier = carrier;
           this.cass_date = cass_date;
           this.change_type = change_type;
           this.city = city;
           this.company = company;
           this.county = county;
           this.delivery_point = delivery_point;
           this.department = department;
           this.dp_barcode = dp_barcode;
           this.effective_date = effective_date;
           this.eighthundred = eighthundred;
           this.email = email;
           this.faxnbr = faxnbr;
           this.fname = fname;
           this.ignored_clean = ignored_clean;
           this.initial_name = initial_name;
           this.institutional_identifier = institutional_identifier;
           this.lname = lname;
           this.lot_nbr = lot_nbr;
           this.mailstop = mailstop;
           this.old_email = old_email;
           this.phone = phone;
           this.replace_customer_address_seq = replace_customer_address_seq;
           this.reverse_date = reverse_date;
           this.salutation = salutation;
           this.special_tax_id = special_tax_id;
           this.state = state;
           this.suffix = suffix;
           this.supp_clean = supp_clean;
           this.tax_id_number = tax_id_number;
           this.title = title;
           this.zip = zip;
    }


    /**
     * Gets the customer_id value for this ZZCustomerAddress.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZCustomerAddress.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_address_seq value for this ZZCustomerAddress.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this ZZCustomerAddress.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the address1 value for this ZZCustomerAddress.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this ZZCustomerAddress.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this ZZCustomerAddress.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this ZZCustomerAddress.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the address3 value for this ZZCustomerAddress.
     * 
     * @return address3
     */
    public java.lang.String getAddress3() {
        return address3;
    }


    /**
     * Sets the address3 value for this ZZCustomerAddress.
     * 
     * @param address3
     */
    public void setAddress3(java.lang.String address3) {
        this.address3 = address3;
    }


    /**
     * Gets the address_status value for this ZZCustomerAddress.
     * 
     * @return address_status
     */
    public java.lang.String getAddress_status() {
        return address_status;
    }


    /**
     * Sets the address_status value for this ZZCustomerAddress.
     * 
     * @param address_status
     */
    public void setAddress_status(java.lang.String address_status) {
        this.address_status = address_status;
    }


    /**
     * Gets the address_type value for this ZZCustomerAddress.
     * 
     * @return address_type
     */
    public java.lang.String getAddress_type() {
        return address_type;
    }


    /**
     * Sets the address_type value for this ZZCustomerAddress.
     * 
     * @param address_type
     */
    public void setAddress_type(java.lang.String address_type) {
        this.address_type = address_type;
    }


    /**
     * Gets the audit_company_id value for this ZZCustomerAddress.
     * 
     * @return audit_company_id
     */
    public int getAudit_company_id() {
        return audit_company_id;
    }


    /**
     * Sets the audit_company_id value for this ZZCustomerAddress.
     * 
     * @param audit_company_id
     */
    public void setAudit_company_id(int audit_company_id) {
        this.audit_company_id = audit_company_id;
    }


    /**
     * Gets the audit_county value for this ZZCustomerAddress.
     * 
     * @return audit_county
     */
    public java.lang.String getAudit_county() {
        return audit_county;
    }


    /**
     * Sets the audit_county value for this ZZCustomerAddress.
     * 
     * @param audit_county
     */
    public void setAudit_county(java.lang.String audit_county) {
        this.audit_county = audit_county;
    }


    /**
     * Gets the audit_name_change value for this ZZCustomerAddress.
     * 
     * @return audit_name_change
     */
    public int getAudit_name_change() {
        return audit_name_change;
    }


    /**
     * Sets the audit_name_change value for this ZZCustomerAddress.
     * 
     * @param audit_name_change
     */
    public void setAudit_name_change(int audit_name_change) {
        this.audit_name_change = audit_name_change;
    }


    /**
     * Gets the audit_title_change value for this ZZCustomerAddress.
     * 
     * @return audit_title_change
     */
    public int getAudit_title_change() {
        return audit_title_change;
    }


    /**
     * Sets the audit_title_change value for this ZZCustomerAddress.
     * 
     * @param audit_title_change
     */
    public void setAudit_title_change(int audit_title_change) {
        this.audit_title_change = audit_title_change;
    }


    /**
     * Gets the carrier value for this ZZCustomerAddress.
     * 
     * @return carrier
     */
    public java.lang.String getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this ZZCustomerAddress.
     * 
     * @param carrier
     */
    public void setCarrier(java.lang.String carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the cass_date value for this ZZCustomerAddress.
     * 
     * @return cass_date
     */
    public int getCass_date() {
        return cass_date;
    }


    /**
     * Sets the cass_date value for this ZZCustomerAddress.
     * 
     * @param cass_date
     */
    public void setCass_date(int cass_date) {
        this.cass_date = cass_date;
    }


    /**
     * Gets the change_type value for this ZZCustomerAddress.
     * 
     * @return change_type
     */
    public int getChange_type() {
        return change_type;
    }


    /**
     * Sets the change_type value for this ZZCustomerAddress.
     * 
     * @param change_type
     */
    public void setChange_type(int change_type) {
        this.change_type = change_type;
    }


    /**
     * Gets the city value for this ZZCustomerAddress.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this ZZCustomerAddress.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the company value for this ZZCustomerAddress.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this ZZCustomerAddress.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the county value for this ZZCustomerAddress.
     * 
     * @return county
     */
    public java.lang.String getCounty() {
        return county;
    }


    /**
     * Sets the county value for this ZZCustomerAddress.
     * 
     * @param county
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }


    /**
     * Gets the delivery_point value for this ZZCustomerAddress.
     * 
     * @return delivery_point
     */
    public java.lang.String getDelivery_point() {
        return delivery_point;
    }


    /**
     * Sets the delivery_point value for this ZZCustomerAddress.
     * 
     * @param delivery_point
     */
    public void setDelivery_point(java.lang.String delivery_point) {
        this.delivery_point = delivery_point;
    }


    /**
     * Gets the department value for this ZZCustomerAddress.
     * 
     * @return department
     */
    public java.lang.String getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this ZZCustomerAddress.
     * 
     * @param department
     */
    public void setDepartment(java.lang.String department) {
        this.department = department;
    }


    /**
     * Gets the dp_barcode value for this ZZCustomerAddress.
     * 
     * @return dp_barcode
     */
    public java.lang.String getDp_barcode() {
        return dp_barcode;
    }


    /**
     * Sets the dp_barcode value for this ZZCustomerAddress.
     * 
     * @param dp_barcode
     */
    public void setDp_barcode(java.lang.String dp_barcode) {
        this.dp_barcode = dp_barcode;
    }


    /**
     * Gets the effective_date value for this ZZCustomerAddress.
     * 
     * @return effective_date
     */
    public java.util.Date getEffective_date() {
        return effective_date;
    }


    /**
     * Sets the effective_date value for this ZZCustomerAddress.
     * 
     * @param effective_date
     */
    public void setEffective_date(java.util.Date effective_date) {
        this.effective_date = effective_date;
    }


    /**
     * Gets the eighthundred value for this ZZCustomerAddress.
     * 
     * @return eighthundred
     */
    public java.lang.String getEighthundred() {
        return eighthundred;
    }


    /**
     * Sets the eighthundred value for this ZZCustomerAddress.
     * 
     * @param eighthundred
     */
    public void setEighthundred(java.lang.String eighthundred) {
        this.eighthundred = eighthundred;
    }


    /**
     * Gets the email value for this ZZCustomerAddress.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ZZCustomerAddress.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the faxnbr value for this ZZCustomerAddress.
     * 
     * @return faxnbr
     */
    public java.lang.String getFaxnbr() {
        return faxnbr;
    }


    /**
     * Sets the faxnbr value for this ZZCustomerAddress.
     * 
     * @param faxnbr
     */
    public void setFaxnbr(java.lang.String faxnbr) {
        this.faxnbr = faxnbr;
    }


    /**
     * Gets the fname value for this ZZCustomerAddress.
     * 
     * @return fname
     */
    public java.lang.String getFname() {
        return fname;
    }


    /**
     * Sets the fname value for this ZZCustomerAddress.
     * 
     * @param fname
     */
    public void setFname(java.lang.String fname) {
        this.fname = fname;
    }


    /**
     * Gets the ignored_clean value for this ZZCustomerAddress.
     * 
     * @return ignored_clean
     */
    public int getIgnored_clean() {
        return ignored_clean;
    }


    /**
     * Sets the ignored_clean value for this ZZCustomerAddress.
     * 
     * @param ignored_clean
     */
    public void setIgnored_clean(int ignored_clean) {
        this.ignored_clean = ignored_clean;
    }


    /**
     * Gets the initial_name value for this ZZCustomerAddress.
     * 
     * @return initial_name
     */
    public java.lang.String getInitial_name() {
        return initial_name;
    }


    /**
     * Sets the initial_name value for this ZZCustomerAddress.
     * 
     * @param initial_name
     */
    public void setInitial_name(java.lang.String initial_name) {
        this.initial_name = initial_name;
    }


    /**
     * Gets the institutional_identifier value for this ZZCustomerAddress.
     * 
     * @return institutional_identifier
     */
    public java.lang.String getInstitutional_identifier() {
        return institutional_identifier;
    }


    /**
     * Sets the institutional_identifier value for this ZZCustomerAddress.
     * 
     * @param institutional_identifier
     */
    public void setInstitutional_identifier(java.lang.String institutional_identifier) {
        this.institutional_identifier = institutional_identifier;
    }


    /**
     * Gets the lname value for this ZZCustomerAddress.
     * 
     * @return lname
     */
    public java.lang.String getLname() {
        return lname;
    }


    /**
     * Sets the lname value for this ZZCustomerAddress.
     * 
     * @param lname
     */
    public void setLname(java.lang.String lname) {
        this.lname = lname;
    }


    /**
     * Gets the lot_nbr value for this ZZCustomerAddress.
     * 
     * @return lot_nbr
     */
    public java.lang.String getLot_nbr() {
        return lot_nbr;
    }


    /**
     * Sets the lot_nbr value for this ZZCustomerAddress.
     * 
     * @param lot_nbr
     */
    public void setLot_nbr(java.lang.String lot_nbr) {
        this.lot_nbr = lot_nbr;
    }


    /**
     * Gets the mailstop value for this ZZCustomerAddress.
     * 
     * @return mailstop
     */
    public java.lang.String getMailstop() {
        return mailstop;
    }


    /**
     * Sets the mailstop value for this ZZCustomerAddress.
     * 
     * @param mailstop
     */
    public void setMailstop(java.lang.String mailstop) {
        this.mailstop = mailstop;
    }


    /**
     * Gets the old_email value for this ZZCustomerAddress.
     * 
     * @return old_email
     */
    public java.lang.String getOld_email() {
        return old_email;
    }


    /**
     * Sets the old_email value for this ZZCustomerAddress.
     * 
     * @param old_email
     */
    public void setOld_email(java.lang.String old_email) {
        this.old_email = old_email;
    }


    /**
     * Gets the phone value for this ZZCustomerAddress.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this ZZCustomerAddress.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the replace_customer_address_seq value for this ZZCustomerAddress.
     * 
     * @return replace_customer_address_seq
     */
    public int getReplace_customer_address_seq() {
        return replace_customer_address_seq;
    }


    /**
     * Sets the replace_customer_address_seq value for this ZZCustomerAddress.
     * 
     * @param replace_customer_address_seq
     */
    public void setReplace_customer_address_seq(int replace_customer_address_seq) {
        this.replace_customer_address_seq = replace_customer_address_seq;
    }


    /**
     * Gets the reverse_date value for this ZZCustomerAddress.
     * 
     * @return reverse_date
     */
    public java.util.Date getReverse_date() {
        return reverse_date;
    }


    /**
     * Sets the reverse_date value for this ZZCustomerAddress.
     * 
     * @param reverse_date
     */
    public void setReverse_date(java.util.Date reverse_date) {
        this.reverse_date = reverse_date;
    }


    /**
     * Gets the salutation value for this ZZCustomerAddress.
     * 
     * @return salutation
     */
    public java.lang.String getSalutation() {
        return salutation;
    }


    /**
     * Sets the salutation value for this ZZCustomerAddress.
     * 
     * @param salutation
     */
    public void setSalutation(java.lang.String salutation) {
        this.salutation = salutation;
    }


    /**
     * Gets the special_tax_id value for this ZZCustomerAddress.
     * 
     * @return special_tax_id
     */
    public int getSpecial_tax_id() {
        return special_tax_id;
    }


    /**
     * Sets the special_tax_id value for this ZZCustomerAddress.
     * 
     * @param special_tax_id
     */
    public void setSpecial_tax_id(int special_tax_id) {
        this.special_tax_id = special_tax_id;
    }


    /**
     * Gets the state value for this ZZCustomerAddress.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this ZZCustomerAddress.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the suffix value for this ZZCustomerAddress.
     * 
     * @return suffix
     */
    public java.lang.String getSuffix() {
        return suffix;
    }


    /**
     * Sets the suffix value for this ZZCustomerAddress.
     * 
     * @param suffix
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }


    /**
     * Gets the supp_clean value for this ZZCustomerAddress.
     * 
     * @return supp_clean
     */
    public int getSupp_clean() {
        return supp_clean;
    }


    /**
     * Sets the supp_clean value for this ZZCustomerAddress.
     * 
     * @param supp_clean
     */
    public void setSupp_clean(int supp_clean) {
        this.supp_clean = supp_clean;
    }


    /**
     * Gets the tax_id_number value for this ZZCustomerAddress.
     * 
     * @return tax_id_number
     */
    public java.lang.String getTax_id_number() {
        return tax_id_number;
    }


    /**
     * Sets the tax_id_number value for this ZZCustomerAddress.
     * 
     * @param tax_id_number
     */
    public void setTax_id_number(java.lang.String tax_id_number) {
        this.tax_id_number = tax_id_number;
    }


    /**
     * Gets the title value for this ZZCustomerAddress.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ZZCustomerAddress.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the zip value for this ZZCustomerAddress.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this ZZCustomerAddress.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZCustomerAddress)) return false;
        ZZCustomerAddress other = (ZZCustomerAddress) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
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
            this.audit_company_id == other.getAudit_company_id() &&
            ((this.audit_county==null && other.getAudit_county()==null) || 
             (this.audit_county!=null &&
              this.audit_county.equals(other.getAudit_county()))) &&
            this.audit_name_change == other.getAudit_name_change() &&
            this.audit_title_change == other.getAudit_title_change() &&
            ((this.carrier==null && other.getCarrier()==null) || 
             (this.carrier!=null &&
              this.carrier.equals(other.getCarrier()))) &&
            this.cass_date == other.getCass_date() &&
            this.change_type == other.getChange_type() &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
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
            ((this.effective_date==null && other.getEffective_date()==null) || 
             (this.effective_date!=null &&
              this.effective_date.equals(other.getEffective_date()))) &&
            ((this.eighthundred==null && other.getEighthundred()==null) || 
             (this.eighthundred!=null &&
              this.eighthundred.equals(other.getEighthundred()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.faxnbr==null && other.getFaxnbr()==null) || 
             (this.faxnbr!=null &&
              this.faxnbr.equals(other.getFaxnbr()))) &&
            ((this.fname==null && other.getFname()==null) || 
             (this.fname!=null &&
              this.fname.equals(other.getFname()))) &&
            this.ignored_clean == other.getIgnored_clean() &&
            ((this.initial_name==null && other.getInitial_name()==null) || 
             (this.initial_name!=null &&
              this.initial_name.equals(other.getInitial_name()))) &&
            ((this.institutional_identifier==null && other.getInstitutional_identifier()==null) || 
             (this.institutional_identifier!=null &&
              this.institutional_identifier.equals(other.getInstitutional_identifier()))) &&
            ((this.lname==null && other.getLname()==null) || 
             (this.lname!=null &&
              this.lname.equals(other.getLname()))) &&
            ((this.lot_nbr==null && other.getLot_nbr()==null) || 
             (this.lot_nbr!=null &&
              this.lot_nbr.equals(other.getLot_nbr()))) &&
            ((this.mailstop==null && other.getMailstop()==null) || 
             (this.mailstop!=null &&
              this.mailstop.equals(other.getMailstop()))) &&
            ((this.old_email==null && other.getOld_email()==null) || 
             (this.old_email!=null &&
              this.old_email.equals(other.getOld_email()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            this.replace_customer_address_seq == other.getReplace_customer_address_seq() &&
            ((this.reverse_date==null && other.getReverse_date()==null) || 
             (this.reverse_date!=null &&
              this.reverse_date.equals(other.getReverse_date()))) &&
            ((this.salutation==null && other.getSalutation()==null) || 
             (this.salutation!=null &&
              this.salutation.equals(other.getSalutation()))) &&
            this.special_tax_id == other.getSpecial_tax_id() &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.suffix==null && other.getSuffix()==null) || 
             (this.suffix!=null &&
              this.suffix.equals(other.getSuffix()))) &&
            this.supp_clean == other.getSupp_clean() &&
            ((this.tax_id_number==null && other.getTax_id_number()==null) || 
             (this.tax_id_number!=null &&
              this.tax_id_number.equals(other.getTax_id_number()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip())));
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
        _hashCode += getCustomer_id();
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
        _hashCode += getAudit_company_id();
        if (getAudit_county() != null) {
            _hashCode += getAudit_county().hashCode();
        }
        _hashCode += getAudit_name_change();
        _hashCode += getAudit_title_change();
        if (getCarrier() != null) {
            _hashCode += getCarrier().hashCode();
        }
        _hashCode += getCass_date();
        _hashCode += getChange_type();
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
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
        if (getEffective_date() != null) {
            _hashCode += getEffective_date().hashCode();
        }
        if (getEighthundred() != null) {
            _hashCode += getEighthundred().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFaxnbr() != null) {
            _hashCode += getFaxnbr().hashCode();
        }
        if (getFname() != null) {
            _hashCode += getFname().hashCode();
        }
        _hashCode += getIgnored_clean();
        if (getInitial_name() != null) {
            _hashCode += getInitial_name().hashCode();
        }
        if (getInstitutional_identifier() != null) {
            _hashCode += getInstitutional_identifier().hashCode();
        }
        if (getLname() != null) {
            _hashCode += getLname().hashCode();
        }
        if (getLot_nbr() != null) {
            _hashCode += getLot_nbr().hashCode();
        }
        if (getMailstop() != null) {
            _hashCode += getMailstop().hashCode();
        }
        if (getOld_email() != null) {
            _hashCode += getOld_email().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        _hashCode += getReplace_customer_address_seq();
        if (getReverse_date() != null) {
            _hashCode += getReverse_date().hashCode();
        }
        if (getSalutation() != null) {
            _hashCode += getSalutation().hashCode();
        }
        _hashCode += getSpecial_tax_id();
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getSuffix() != null) {
            _hashCode += getSuffix().hashCode();
        }
        _hashCode += getSupp_clean();
        if (getTax_id_number() != null) {
            _hashCode += getTax_id_number().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZCustomerAddress.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZCustomerAddress"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
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
        attrField.setFieldName("audit_company_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_company_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_county");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_county"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_name_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_name_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_title_change");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_title_change"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        attrField.setFieldName("change_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "change_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("city");
        attrField.setXmlName(new javax.xml.namespace.QName("", "city"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("company");
        attrField.setXmlName(new javax.xml.namespace.QName("", "company"));
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
        attrField.setFieldName("effective_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "effective_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("eighthundred");
        attrField.setXmlName(new javax.xml.namespace.QName("", "eighthundred"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("faxnbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "faxnbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fname");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fname"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ignored_clean");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ignored_clean"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("initial_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "initial_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("institutional_identifier");
        attrField.setXmlName(new javax.xml.namespace.QName("", "institutional_identifier"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lname");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lname"));
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
        attrField.setFieldName("old_email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "old_email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("phone");
        attrField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("replace_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "replace_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reverse_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reverse_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("salutation");
        attrField.setXmlName(new javax.xml.namespace.QName("", "salutation"));
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
        attrField.setFieldName("suffix");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suffix"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("supp_clean");
        attrField.setXmlName(new javax.xml.namespace.QName("", "supp_clean"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tax_id_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tax_id_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("title");
        attrField.setXmlName(new javax.xml.namespace.QName("", "title"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("zip");
        attrField.setXmlName(new javax.xml.namespace.QName("", "zip"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
