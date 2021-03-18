/**
 * Distributor_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Distributor_data  implements java.io.Serializable {
    private java.lang.String company;

    private java.lang.String distributor_report_prefix;

    private java.lang.Integer parent_distributor_id;

    private java.lang.String url;

    public Distributor_data() {
    }

    public Distributor_data(
           java.lang.String company,
           java.lang.String distributor_report_prefix,
           java.lang.Integer parent_distributor_id,
           java.lang.String url) {
           this.company = company;
           this.distributor_report_prefix = distributor_report_prefix;
           this.parent_distributor_id = parent_distributor_id;
           this.url = url;
    }


    /**
     * Gets the company value for this Distributor_data.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this Distributor_data.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the distributor_report_prefix value for this Distributor_data.
     * 
     * @return distributor_report_prefix
     */
    public java.lang.String getDistributor_report_prefix() {
        return distributor_report_prefix;
    }


    /**
     * Sets the distributor_report_prefix value for this Distributor_data.
     * 
     * @param distributor_report_prefix
     */
    public void setDistributor_report_prefix(java.lang.String distributor_report_prefix) {
        this.distributor_report_prefix = distributor_report_prefix;
    }


    /**
     * Gets the parent_distributor_id value for this Distributor_data.
     * 
     * @return parent_distributor_id
     */
    public java.lang.Integer getParent_distributor_id() {
        return parent_distributor_id;
    }


    /**
     * Sets the parent_distributor_id value for this Distributor_data.
     * 
     * @param parent_distributor_id
     */
    public void setParent_distributor_id(java.lang.Integer parent_distributor_id) {
        this.parent_distributor_id = parent_distributor_id;
    }


    /**
     * Gets the url value for this Distributor_data.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Distributor_data.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Distributor_data)) return false;
        Distributor_data other = (Distributor_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.distributor_report_prefix==null && other.getDistributor_report_prefix()==null) || 
             (this.distributor_report_prefix!=null &&
              this.distributor_report_prefix.equals(other.getDistributor_report_prefix()))) &&
            ((this.parent_distributor_id==null && other.getParent_distributor_id()==null) || 
             (this.parent_distributor_id!=null &&
              this.parent_distributor_id.equals(other.getParent_distributor_id()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getDistributor_report_prefix() != null) {
            _hashCode += getDistributor_report_prefix().hashCode();
        }
        if (getParent_distributor_id() != null) {
            _hashCode += getParent_distributor_id().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Distributor_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">distributor_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributor_report_prefix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "distributor_report_prefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent_distributor_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "parent_distributor_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
