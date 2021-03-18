/**
 * Agency_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Agency_data  implements java.io.Serializable {
    private java.lang.String agency_code;

    private boolean accept_ord;

    private boolean agency_bill_to;

    private boolean agency_pays_tax;

    private boolean agency_renew_to;

    private java.lang.String company;

    private boolean discounts;

    private java.math.BigDecimal new_commission;

    private java.lang.String payment_threshold;

    private boolean remit;

    private java.math.BigDecimal ren_commission;

    private java.lang.Boolean tax_based_on_gross;

    public Agency_data() {
    }

    public Agency_data(
           java.lang.String agency_code,
           boolean accept_ord,
           boolean agency_bill_to,
           boolean agency_pays_tax,
           boolean agency_renew_to,
           java.lang.String company,
           boolean discounts,
           java.math.BigDecimal new_commission,
           java.lang.String payment_threshold,
           boolean remit,
           java.math.BigDecimal ren_commission,
           java.lang.Boolean tax_based_on_gross) {
           this.agency_code = agency_code;
           this.accept_ord = accept_ord;
           this.agency_bill_to = agency_bill_to;
           this.agency_pays_tax = agency_pays_tax;
           this.agency_renew_to = agency_renew_to;
           this.company = company;
           this.discounts = discounts;
           this.new_commission = new_commission;
           this.payment_threshold = payment_threshold;
           this.remit = remit;
           this.ren_commission = ren_commission;
           this.tax_based_on_gross = tax_based_on_gross;
    }


    /**
     * Gets the agency_code value for this Agency_data.
     * 
     * @return agency_code
     */
    public java.lang.String getAgency_code() {
        return agency_code;
    }


    /**
     * Sets the agency_code value for this Agency_data.
     * 
     * @param agency_code
     */
    public void setAgency_code(java.lang.String agency_code) {
        this.agency_code = agency_code;
    }


    /**
     * Gets the accept_ord value for this Agency_data.
     * 
     * @return accept_ord
     */
    public boolean isAccept_ord() {
        return accept_ord;
    }


    /**
     * Sets the accept_ord value for this Agency_data.
     * 
     * @param accept_ord
     */
    public void setAccept_ord(boolean accept_ord) {
        this.accept_ord = accept_ord;
    }


    /**
     * Gets the agency_bill_to value for this Agency_data.
     * 
     * @return agency_bill_to
     */
    public boolean isAgency_bill_to() {
        return agency_bill_to;
    }


    /**
     * Sets the agency_bill_to value for this Agency_data.
     * 
     * @param agency_bill_to
     */
    public void setAgency_bill_to(boolean agency_bill_to) {
        this.agency_bill_to = agency_bill_to;
    }


    /**
     * Gets the agency_pays_tax value for this Agency_data.
     * 
     * @return agency_pays_tax
     */
    public boolean isAgency_pays_tax() {
        return agency_pays_tax;
    }


    /**
     * Sets the agency_pays_tax value for this Agency_data.
     * 
     * @param agency_pays_tax
     */
    public void setAgency_pays_tax(boolean agency_pays_tax) {
        this.agency_pays_tax = agency_pays_tax;
    }


    /**
     * Gets the agency_renew_to value for this Agency_data.
     * 
     * @return agency_renew_to
     */
    public boolean isAgency_renew_to() {
        return agency_renew_to;
    }


    /**
     * Sets the agency_renew_to value for this Agency_data.
     * 
     * @param agency_renew_to
     */
    public void setAgency_renew_to(boolean agency_renew_to) {
        this.agency_renew_to = agency_renew_to;
    }


    /**
     * Gets the company value for this Agency_data.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this Agency_data.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the discounts value for this Agency_data.
     * 
     * @return discounts
     */
    public boolean isDiscounts() {
        return discounts;
    }


    /**
     * Sets the discounts value for this Agency_data.
     * 
     * @param discounts
     */
    public void setDiscounts(boolean discounts) {
        this.discounts = discounts;
    }


    /**
     * Gets the new_commission value for this Agency_data.
     * 
     * @return new_commission
     */
    public java.math.BigDecimal getNew_commission() {
        return new_commission;
    }


    /**
     * Sets the new_commission value for this Agency_data.
     * 
     * @param new_commission
     */
    public void setNew_commission(java.math.BigDecimal new_commission) {
        this.new_commission = new_commission;
    }


    /**
     * Gets the payment_threshold value for this Agency_data.
     * 
     * @return payment_threshold
     */
    public java.lang.String getPayment_threshold() {
        return payment_threshold;
    }


    /**
     * Sets the payment_threshold value for this Agency_data.
     * 
     * @param payment_threshold
     */
    public void setPayment_threshold(java.lang.String payment_threshold) {
        this.payment_threshold = payment_threshold;
    }


    /**
     * Gets the remit value for this Agency_data.
     * 
     * @return remit
     */
    public boolean isRemit() {
        return remit;
    }


    /**
     * Sets the remit value for this Agency_data.
     * 
     * @param remit
     */
    public void setRemit(boolean remit) {
        this.remit = remit;
    }


    /**
     * Gets the ren_commission value for this Agency_data.
     * 
     * @return ren_commission
     */
    public java.math.BigDecimal getRen_commission() {
        return ren_commission;
    }


    /**
     * Sets the ren_commission value for this Agency_data.
     * 
     * @param ren_commission
     */
    public void setRen_commission(java.math.BigDecimal ren_commission) {
        this.ren_commission = ren_commission;
    }


    /**
     * Gets the tax_based_on_gross value for this Agency_data.
     * 
     * @return tax_based_on_gross
     */
    public java.lang.Boolean getTax_based_on_gross() {
        return tax_based_on_gross;
    }


    /**
     * Sets the tax_based_on_gross value for this Agency_data.
     * 
     * @param tax_based_on_gross
     */
    public void setTax_based_on_gross(java.lang.Boolean tax_based_on_gross) {
        this.tax_based_on_gross = tax_based_on_gross;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Agency_data)) return false;
        Agency_data other = (Agency_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agency_code==null && other.getAgency_code()==null) || 
             (this.agency_code!=null &&
              this.agency_code.equals(other.getAgency_code()))) &&
            this.accept_ord == other.isAccept_ord() &&
            this.agency_bill_to == other.isAgency_bill_to() &&
            this.agency_pays_tax == other.isAgency_pays_tax() &&
            this.agency_renew_to == other.isAgency_renew_to() &&
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            this.discounts == other.isDiscounts() &&
            ((this.new_commission==null && other.getNew_commission()==null) || 
             (this.new_commission!=null &&
              this.new_commission.equals(other.getNew_commission()))) &&
            ((this.payment_threshold==null && other.getPayment_threshold()==null) || 
             (this.payment_threshold!=null &&
              this.payment_threshold.equals(other.getPayment_threshold()))) &&
            this.remit == other.isRemit() &&
            ((this.ren_commission==null && other.getRen_commission()==null) || 
             (this.ren_commission!=null &&
              this.ren_commission.equals(other.getRen_commission()))) &&
            ((this.tax_based_on_gross==null && other.getTax_based_on_gross()==null) || 
             (this.tax_based_on_gross!=null &&
              this.tax_based_on_gross.equals(other.getTax_based_on_gross())));
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
        if (getAgency_code() != null) {
            _hashCode += getAgency_code().hashCode();
        }
        _hashCode += (isAccept_ord() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAgency_bill_to() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAgency_pays_tax() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAgency_renew_to() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        _hashCode += (isDiscounts() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNew_commission() != null) {
            _hashCode += getNew_commission().hashCode();
        }
        if (getPayment_threshold() != null) {
            _hashCode += getPayment_threshold().hashCode();
        }
        _hashCode += (isRemit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRen_commission() != null) {
            _hashCode += getRen_commission().hashCode();
        }
        if (getTax_based_on_gross() != null) {
            _hashCode += getTax_based_on_gross().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Agency_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">agency_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accept_ord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "accept_ord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_bill_to");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_bill_to"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_pays_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_pays_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_renew_to");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_renew_to"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("discounts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "discounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("new_commission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "new_commission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_threshold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment_threshold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "remit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ren_commission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ren_commission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_based_on_gross");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "tax_based_on_gross"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
