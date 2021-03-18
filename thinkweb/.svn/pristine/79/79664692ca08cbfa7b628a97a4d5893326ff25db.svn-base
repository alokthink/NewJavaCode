/**
 * Demographic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Demographic  extends Think.XmlWebServices.ZZDemographic  implements java.io.Serializable {
    private java.lang.String cc_dem_response_seq;  // attribute

    public Demographic() {
    }

    public Demographic(
           int customer_id,
           int demographic_seq,
           int dem_form_id,
           int dem_question_id,
           java.lang.String free_form_response,
           java.util.Calendar last_response_date,
           int oc_id,
           byte[] responses,
           java.lang.String cc_dem_response_seq) {
        super(
            customer_id,
            demographic_seq,
            dem_form_id,
            dem_question_id,
            free_form_response,
            last_response_date,
            oc_id,
            responses);
        this.cc_dem_response_seq = cc_dem_response_seq;
    }


    /**
     * Gets the cc_dem_response_seq value for this Demographic.
     * 
     * @return cc_dem_response_seq
     */
    public java.lang.String getCc_dem_response_seq() {
        return cc_dem_response_seq;
    }


    /**
     * Sets the cc_dem_response_seq value for this Demographic.
     * 
     * @param cc_dem_response_seq
     */
    public void setCc_dem_response_seq(java.lang.String cc_dem_response_seq) {
        this.cc_dem_response_seq = cc_dem_response_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Demographic)) return false;
        Demographic other = (Demographic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cc_dem_response_seq==null && other.getCc_dem_response_seq()==null) || 
             (this.cc_dem_response_seq!=null &&
              this.cc_dem_response_seq.equals(other.getCc_dem_response_seq())));
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
        if (getCc_dem_response_seq() != null) {
            _hashCode += getCc_dem_response_seq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Demographic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demographic"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cc_dem_response_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cc_dem_response_seq"));
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

	@Override
	public String toString() {
		return "Demographic [cc_dem_response_seq=" + cc_dem_response_seq + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
