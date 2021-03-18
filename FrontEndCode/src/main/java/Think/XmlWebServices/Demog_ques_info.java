/**
 * Demog_ques_info.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Demog_ques_info  implements java.io.Serializable {
    private Think.XmlWebServices.Demog_resp_info[] demog_resp_infos;

    private int dem_q_id;  // attribute

    private java.lang.String dem_q_label;  // attribute

    private java.lang.String dem_q_text;  // attribute

    private boolean dem_q_multiResp;  // attribute

    private boolean dem_q_required;  // attribute

    private boolean dem_q_freeonly;  // attribute

    private int dem_q_numResp;  // attribute

    public Demog_ques_info() {
    }

    public Demog_ques_info(
           Think.XmlWebServices.Demog_resp_info[] demog_resp_infos,
           int dem_q_id,
           java.lang.String dem_q_label,
           java.lang.String dem_q_text,
           boolean dem_q_multiResp,
           boolean dem_q_required,
           boolean dem_q_freeonly,
           int dem_q_numResp) {
           this.demog_resp_infos = demog_resp_infos;
           this.dem_q_id = dem_q_id;
           this.dem_q_label = dem_q_label;
           this.dem_q_text = dem_q_text;
           this.dem_q_multiResp = dem_q_multiResp;
           this.dem_q_required = dem_q_required;
           this.dem_q_freeonly = dem_q_freeonly;
           this.dem_q_numResp = dem_q_numResp;
    }


    /**
     * Gets the demog_resp_infos value for this Demog_ques_info.
     * 
     * @return demog_resp_infos
     */
    public Think.XmlWebServices.Demog_resp_info[] getDemog_resp_infos() {
        return demog_resp_infos;
    }


    /**
     * Sets the demog_resp_infos value for this Demog_ques_info.
     * 
     * @param demog_resp_infos
     */
    public void setDemog_resp_infos(Think.XmlWebServices.Demog_resp_info[] demog_resp_infos) {
        this.demog_resp_infos = demog_resp_infos;
    }


    /**
     * Gets the dem_q_id value for this Demog_ques_info.
     * 
     * @return dem_q_id
     */
    public int getDem_q_id() {
        return dem_q_id;
    }


    /**
     * Sets the dem_q_id value for this Demog_ques_info.
     * 
     * @param dem_q_id
     */
    public void setDem_q_id(int dem_q_id) {
        this.dem_q_id = dem_q_id;
    }


    /**
     * Gets the dem_q_label value for this Demog_ques_info.
     * 
     * @return dem_q_label
     */
    public java.lang.String getDem_q_label() {
        return dem_q_label;
    }


    /**
     * Sets the dem_q_label value for this Demog_ques_info.
     * 
     * @param dem_q_label
     */
    public void setDem_q_label(java.lang.String dem_q_label) {
        this.dem_q_label = dem_q_label;
    }


    /**
     * Gets the dem_q_text value for this Demog_ques_info.
     * 
     * @return dem_q_text
     */
    public java.lang.String getDem_q_text() {
        return dem_q_text;
    }


    /**
     * Sets the dem_q_text value for this Demog_ques_info.
     * 
     * @param dem_q_text
     */
    public void setDem_q_text(java.lang.String dem_q_text) {
        this.dem_q_text = dem_q_text;
    }


    /**
     * Gets the dem_q_multiResp value for this Demog_ques_info.
     * 
     * @return dem_q_multiResp
     */
    public boolean isDem_q_multiResp() {
        return dem_q_multiResp;
    }


    /**
     * Sets the dem_q_multiResp value for this Demog_ques_info.
     * 
     * @param dem_q_multiResp
     */
    public void setDem_q_multiResp(boolean dem_q_multiResp) {
        this.dem_q_multiResp = dem_q_multiResp;
    }


    /**
     * Gets the dem_q_required value for this Demog_ques_info.
     * 
     * @return dem_q_required
     */
    public boolean isDem_q_required() {
        return dem_q_required;
    }


    /**
     * Sets the dem_q_required value for this Demog_ques_info.
     * 
     * @param dem_q_required
     */
    public void setDem_q_required(boolean dem_q_required) {
        this.dem_q_required = dem_q_required;
    }


    /**
     * Gets the dem_q_freeonly value for this Demog_ques_info.
     * 
     * @return dem_q_freeonly
     */
    public boolean isDem_q_freeonly() {
        return dem_q_freeonly;
    }


    /**
     * Sets the dem_q_freeonly value for this Demog_ques_info.
     * 
     * @param dem_q_freeonly
     */
    public void setDem_q_freeonly(boolean dem_q_freeonly) {
        this.dem_q_freeonly = dem_q_freeonly;
    }


    /**
     * Gets the dem_q_numResp value for this Demog_ques_info.
     * 
     * @return dem_q_numResp
     */
    public int getDem_q_numResp() {
        return dem_q_numResp;
    }


    /**
     * Sets the dem_q_numResp value for this Demog_ques_info.
     * 
     * @param dem_q_numResp
     */
    public void setDem_q_numResp(int dem_q_numResp) {
        this.dem_q_numResp = dem_q_numResp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Demog_ques_info)) return false;
        Demog_ques_info other = (Demog_ques_info) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.demog_resp_infos==null && other.getDemog_resp_infos()==null) || 
             (this.demog_resp_infos!=null &&
              java.util.Arrays.equals(this.demog_resp_infos, other.getDemog_resp_infos()))) &&
            this.dem_q_id == other.getDem_q_id() &&
            ((this.dem_q_label==null && other.getDem_q_label()==null) || 
             (this.dem_q_label!=null &&
              this.dem_q_label.equals(other.getDem_q_label()))) &&
            ((this.dem_q_text==null && other.getDem_q_text()==null) || 
             (this.dem_q_text!=null &&
              this.dem_q_text.equals(other.getDem_q_text()))) &&
            this.dem_q_multiResp == other.isDem_q_multiResp() &&
            this.dem_q_required == other.isDem_q_required() &&
            this.dem_q_freeonly == other.isDem_q_freeonly() &&
            this.dem_q_numResp == other.getDem_q_numResp();
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
        if (getDemog_resp_infos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDemog_resp_infos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDemog_resp_infos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getDem_q_id();
        if (getDem_q_label() != null) {
            _hashCode += getDem_q_label().hashCode();
        }
        if (getDem_q_text() != null) {
            _hashCode += getDem_q_text().hashCode();
        }
        _hashCode += (isDem_q_multiResp() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDem_q_required() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDem_q_freeonly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getDem_q_numResp();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Demog_ques_info.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demog_ques_info"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_label");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_label"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_text");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_text"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_multiResp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_multiResp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_freeonly");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_freeonly"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_q_numResp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_q_numResp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demog_resp_infos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demog_resp_infos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demog_resp_infos"));
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
