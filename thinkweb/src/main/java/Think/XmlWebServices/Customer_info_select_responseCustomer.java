/**
 * Customer_info_select_responseCustomer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_info_select_responseCustomer  implements java.io.Serializable {
    private int customer_id;  // attribute

    private java.lang.String list_rental_category;  // attribute

    private int default_bill_to_customer_id;  // attribute

    private int def_bill_to_cust_addr_seq;  // attribute

    private int default_renew_to_customer_id;  // attribute

    private int def_renew_to_cust_addr_seq;  // attribute

    private java.lang.String credit_status;  // attribute

    private java.lang.String lname;  // attribute

    private java.lang.String initial_name;  // attribute

    private java.lang.String fname;  // attribute

    private java.lang.String salutation;  // attribute

    private java.lang.String suffix;  // attribute

    private java.lang.String title;  // attribute

    private java.lang.String email;  // attribute

    private byte[] email_authorization;  // attribute

    private java.lang.String old_customer_id;  // attribute

    private java.lang.String login;  // attribute

    private java.lang.String hint;  // attribute

    private java.lang.String response;  // attribute

    public Customer_info_select_responseCustomer() {
    }

    public Customer_info_select_responseCustomer(
           int customer_id,
           java.lang.String list_rental_category,
           int default_bill_to_customer_id,
           int def_bill_to_cust_addr_seq,
           int default_renew_to_customer_id,
           int def_renew_to_cust_addr_seq,
           java.lang.String credit_status,
           java.lang.String lname,
           java.lang.String initial_name,
           java.lang.String fname,
           java.lang.String salutation,
           java.lang.String suffix,
           java.lang.String title,
           java.lang.String email,
           byte[] email_authorization,
           java.lang.String old_customer_id,
           java.lang.String login,
           java.lang.String hint,
           java.lang.String response) {
           this.customer_id = customer_id;
           this.list_rental_category = list_rental_category;
           this.default_bill_to_customer_id = default_bill_to_customer_id;
           this.def_bill_to_cust_addr_seq = def_bill_to_cust_addr_seq;
           this.default_renew_to_customer_id = default_renew_to_customer_id;
           this.def_renew_to_cust_addr_seq = def_renew_to_cust_addr_seq;
           this.credit_status = credit_status;
           this.lname = lname;
           this.initial_name = initial_name;
           this.fname = fname;
           this.salutation = salutation;
           this.suffix = suffix;
           this.title = title;
           this.email = email;
           this.email_authorization = email_authorization;
           this.old_customer_id = old_customer_id;
           this.login = login;
           this.hint = hint;
           this.response = response;
    }


    /**
     * Gets the customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the list_rental_category value for this Customer_info_select_responseCustomer.
     * 
     * @return list_rental_category
     */
    public java.lang.String getList_rental_category() {
        return list_rental_category;
    }


    /**
     * Sets the list_rental_category value for this Customer_info_select_responseCustomer.
     * 
     * @param list_rental_category
     */
    public void setList_rental_category(java.lang.String list_rental_category) {
        this.list_rental_category = list_rental_category;
    }


    /**
     * Gets the default_bill_to_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @return default_bill_to_customer_id
     */
    public int getDefault_bill_to_customer_id() {
        return default_bill_to_customer_id;
    }


    /**
     * Sets the default_bill_to_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @param default_bill_to_customer_id
     */
    public void setDefault_bill_to_customer_id(int default_bill_to_customer_id) {
        this.default_bill_to_customer_id = default_bill_to_customer_id;
    }


    /**
     * Gets the def_bill_to_cust_addr_seq value for this Customer_info_select_responseCustomer.
     * 
     * @return def_bill_to_cust_addr_seq
     */
    public int getDef_bill_to_cust_addr_seq() {
        return def_bill_to_cust_addr_seq;
    }


    /**
     * Sets the def_bill_to_cust_addr_seq value for this Customer_info_select_responseCustomer.
     * 
     * @param def_bill_to_cust_addr_seq
     */
    public void setDef_bill_to_cust_addr_seq(int def_bill_to_cust_addr_seq) {
        this.def_bill_to_cust_addr_seq = def_bill_to_cust_addr_seq;
    }


    /**
     * Gets the default_renew_to_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @return default_renew_to_customer_id
     */
    public int getDefault_renew_to_customer_id() {
        return default_renew_to_customer_id;
    }


    /**
     * Sets the default_renew_to_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @param default_renew_to_customer_id
     */
    public void setDefault_renew_to_customer_id(int default_renew_to_customer_id) {
        this.default_renew_to_customer_id = default_renew_to_customer_id;
    }


    /**
     * Gets the def_renew_to_cust_addr_seq value for this Customer_info_select_responseCustomer.
     * 
     * @return def_renew_to_cust_addr_seq
     */
    public int getDef_renew_to_cust_addr_seq() {
        return def_renew_to_cust_addr_seq;
    }


    /**
     * Sets the def_renew_to_cust_addr_seq value for this Customer_info_select_responseCustomer.
     * 
     * @param def_renew_to_cust_addr_seq
     */
    public void setDef_renew_to_cust_addr_seq(int def_renew_to_cust_addr_seq) {
        this.def_renew_to_cust_addr_seq = def_renew_to_cust_addr_seq;
    }


    /**
     * Gets the credit_status value for this Customer_info_select_responseCustomer.
     * 
     * @return credit_status
     */
    public java.lang.String getCredit_status() {
        return credit_status;
    }


    /**
     * Sets the credit_status value for this Customer_info_select_responseCustomer.
     * 
     * @param credit_status
     */
    public void setCredit_status(java.lang.String credit_status) {
        this.credit_status = credit_status;
    }


    /**
     * Gets the lname value for this Customer_info_select_responseCustomer.
     * 
     * @return lname
     */
    public java.lang.String getLname() {
        return lname;
    }


    /**
     * Sets the lname value for this Customer_info_select_responseCustomer.
     * 
     * @param lname
     */
    public void setLname(java.lang.String lname) {
        this.lname = lname;
    }


    /**
     * Gets the initial_name value for this Customer_info_select_responseCustomer.
     * 
     * @return initial_name
     */
    public java.lang.String getInitial_name() {
        return initial_name;
    }


    /**
     * Sets the initial_name value for this Customer_info_select_responseCustomer.
     * 
     * @param initial_name
     */
    public void setInitial_name(java.lang.String initial_name) {
        this.initial_name = initial_name;
    }


    /**
     * Gets the fname value for this Customer_info_select_responseCustomer.
     * 
     * @return fname
     */
    public java.lang.String getFname() {
        return fname;
    }


    /**
     * Sets the fname value for this Customer_info_select_responseCustomer.
     * 
     * @param fname
     */
    public void setFname(java.lang.String fname) {
        this.fname = fname;
    }


    /**
     * Gets the salutation value for this Customer_info_select_responseCustomer.
     * 
     * @return salutation
     */
    public java.lang.String getSalutation() {
        return salutation;
    }


    /**
     * Sets the salutation value for this Customer_info_select_responseCustomer.
     * 
     * @param salutation
     */
    public void setSalutation(java.lang.String salutation) {
        this.salutation = salutation;
    }


    /**
     * Gets the suffix value for this Customer_info_select_responseCustomer.
     * 
     * @return suffix
     */
    public java.lang.String getSuffix() {
        return suffix;
    }


    /**
     * Sets the suffix value for this Customer_info_select_responseCustomer.
     * 
     * @param suffix
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }


    /**
     * Gets the title value for this Customer_info_select_responseCustomer.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Customer_info_select_responseCustomer.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the email value for this Customer_info_select_responseCustomer.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Customer_info_select_responseCustomer.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the email_authorization value for this Customer_info_select_responseCustomer.
     * 
     * @return email_authorization
     */
    public byte[] getEmail_authorization() {
        return email_authorization;
    }


    /**
     * Sets the email_authorization value for this Customer_info_select_responseCustomer.
     * 
     * @param email_authorization
     */
    public void setEmail_authorization(byte[] email_authorization) {
        this.email_authorization = email_authorization;
    }


    /**
     * Gets the old_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @return old_customer_id
     */
    public java.lang.String getOld_customer_id() {
        return old_customer_id;
    }


    /**
     * Sets the old_customer_id value for this Customer_info_select_responseCustomer.
     * 
     * @param old_customer_id
     */
    public void setOld_customer_id(java.lang.String old_customer_id) {
        this.old_customer_id = old_customer_id;
    }


    /**
     * Gets the login value for this Customer_info_select_responseCustomer.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this Customer_info_select_responseCustomer.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the hint value for this Customer_info_select_responseCustomer.
     * 
     * @return hint
     */
    public java.lang.String getHint() {
        return hint;
    }


    /**
     * Sets the hint value for this Customer_info_select_responseCustomer.
     * 
     * @param hint
     */
    public void setHint(java.lang.String hint) {
        this.hint = hint;
    }


    /**
     * Gets the response value for this Customer_info_select_responseCustomer.
     * 
     * @return response
     */
    public java.lang.String getResponse() {
        return response;
    }


    /**
     * Sets the response value for this Customer_info_select_responseCustomer.
     * 
     * @param response
     */
    public void setResponse(java.lang.String response) {
        this.response = response;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_info_select_responseCustomer)) return false;
        Customer_info_select_responseCustomer other = (Customer_info_select_responseCustomer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
            ((this.list_rental_category==null && other.getList_rental_category()==null) || 
             (this.list_rental_category!=null &&
              this.list_rental_category.equals(other.getList_rental_category()))) &&
            this.default_bill_to_customer_id == other.getDefault_bill_to_customer_id() &&
            this.def_bill_to_cust_addr_seq == other.getDef_bill_to_cust_addr_seq() &&
            this.default_renew_to_customer_id == other.getDefault_renew_to_customer_id() &&
            this.def_renew_to_cust_addr_seq == other.getDef_renew_to_cust_addr_seq() &&
            ((this.credit_status==null && other.getCredit_status()==null) || 
             (this.credit_status!=null &&
              this.credit_status.equals(other.getCredit_status()))) &&
            ((this.lname==null && other.getLname()==null) || 
             (this.lname!=null &&
              this.lname.equals(other.getLname()))) &&
            ((this.initial_name==null && other.getInitial_name()==null) || 
             (this.initial_name!=null &&
              this.initial_name.equals(other.getInitial_name()))) &&
            ((this.fname==null && other.getFname()==null) || 
             (this.fname!=null &&
              this.fname.equals(other.getFname()))) &&
            ((this.salutation==null && other.getSalutation()==null) || 
             (this.salutation!=null &&
              this.salutation.equals(other.getSalutation()))) &&
            ((this.suffix==null && other.getSuffix()==null) || 
             (this.suffix!=null &&
              this.suffix.equals(other.getSuffix()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.email_authorization==null && other.getEmail_authorization()==null) || 
             (this.email_authorization!=null &&
              java.util.Arrays.equals(this.email_authorization, other.getEmail_authorization()))) &&
            ((this.old_customer_id==null && other.getOld_customer_id()==null) || 
             (this.old_customer_id!=null &&
              this.old_customer_id.equals(other.getOld_customer_id()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.hint==null && other.getHint()==null) || 
             (this.hint!=null &&
              this.hint.equals(other.getHint()))) &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse())));
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
        if (getList_rental_category() != null) {
            _hashCode += getList_rental_category().hashCode();
        }
        _hashCode += getDefault_bill_to_customer_id();
        _hashCode += getDef_bill_to_cust_addr_seq();
        _hashCode += getDefault_renew_to_customer_id();
        _hashCode += getDef_renew_to_cust_addr_seq();
        if (getCredit_status() != null) {
            _hashCode += getCredit_status().hashCode();
        }
        if (getLname() != null) {
            _hashCode += getLname().hashCode();
        }
        if (getInitial_name() != null) {
            _hashCode += getInitial_name().hashCode();
        }
        if (getFname() != null) {
            _hashCode += getFname().hashCode();
        }
        if (getSalutation() != null) {
            _hashCode += getSalutation().hashCode();
        }
        if (getSuffix() != null) {
            _hashCode += getSuffix().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
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
        if (getOld_customer_id() != null) {
            _hashCode += getOld_customer_id().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getHint() != null) {
            _hashCode += getHint().hashCode();
        }
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_info_select_responseCustomer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_info_select_response>customer"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("list_rental_category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "list_rental_category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_bill_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_bill_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("def_bill_to_cust_addr_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "def_bill_to_cust_addr_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_renew_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_renew_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("def_renew_to_cust_addr_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "def_renew_to_cust_addr_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("credit_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "credit_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lname");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lname"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("initial_name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "initial_name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fname");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fname"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("salutation");
        attrField.setXmlName(new javax.xml.namespace.QName("", "salutation"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suffix");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suffix"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("title");
        attrField.setXmlName(new javax.xml.namespace.QName("", "title"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("email_authorization");
        attrField.setXmlName(new javax.xml.namespace.QName("", "email_authorization"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("old_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "old_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("login");
        attrField.setXmlName(new javax.xml.namespace.QName("", "login"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("hint");
        attrField.setXmlName(new javax.xml.namespace.QName("", "hint"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "response"));
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
