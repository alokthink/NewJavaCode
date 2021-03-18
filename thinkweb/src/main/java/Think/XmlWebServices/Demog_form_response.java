/**
 * Demog_form_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Demog_form_response  implements java.io.Serializable {
    private Think.XmlWebServices.Demog_ques_info[] demog_ques_infos;

    private int resp_dem_form_id;  // attribute

    private int resp_dem_form_oc_id;  // attribute

    private Think.XmlWebServices.ZZBoolean dem_any_required;  // attribute

    private int dem_num_quests;  // attribute

    private Think.XmlWebServices.ZZBoolean display_demog_form;  // attribute

    public Demog_form_response() {
    }

    public Demog_form_response(
           Think.XmlWebServices.Demog_ques_info[] demog_ques_infos,
           int resp_dem_form_id,
           int resp_dem_form_oc_id,
           Think.XmlWebServices.ZZBoolean dem_any_required,
           int dem_num_quests,
           Think.XmlWebServices.ZZBoolean display_demog_form) {
           this.demog_ques_infos = demog_ques_infos;
           this.resp_dem_form_id = resp_dem_form_id;
           this.resp_dem_form_oc_id = resp_dem_form_oc_id;
           this.dem_any_required = dem_any_required;
           this.dem_num_quests = dem_num_quests;
           this.display_demog_form = display_demog_form;
    }


    /**
     * Gets the demog_ques_infos value for this Demog_form_response.
     * 
     * @return demog_ques_infos
     */
    public Think.XmlWebServices.Demog_ques_info[] getDemog_ques_infos() {
        return demog_ques_infos;
    }


    /**
     * Sets the demog_ques_infos value for this Demog_form_response.
     * 
     * @param demog_ques_infos
     */
    public void setDemog_ques_infos(Think.XmlWebServices.Demog_ques_info[] demog_ques_infos) {
        this.demog_ques_infos = demog_ques_infos;
    }


    /**
     * Gets the resp_dem_form_id value for this Demog_form_response.
     * 
     * @return resp_dem_form_id
     */
    public int getResp_dem_form_id() {
        return resp_dem_form_id;
    }


    /**
     * Sets the resp_dem_form_id value for this Demog_form_response.
     * 
     * @param resp_dem_form_id
     */
    public void setResp_dem_form_id(int resp_dem_form_id) {
        this.resp_dem_form_id = resp_dem_form_id;
    }


    /**
     * Gets the resp_dem_form_oc_id value for this Demog_form_response.
     * 
     * @return resp_dem_form_oc_id
     */
    public int getResp_dem_form_oc_id() {
        return resp_dem_form_oc_id;
    }


    /**
     * Sets the resp_dem_form_oc_id value for this Demog_form_response.
     * 
     * @param resp_dem_form_oc_id
     */
    public void setResp_dem_form_oc_id(int resp_dem_form_oc_id) {
        this.resp_dem_form_oc_id = resp_dem_form_oc_id;
    }


    /**
     * Gets the dem_any_required value for this Demog_form_response.
     * 
     * @return dem_any_required
     */
    public Think.XmlWebServices.ZZBoolean getDem_any_required() {
        return dem_any_required;
    }


    /**
     * Sets the dem_any_required value for this Demog_form_response.
     * 
     * @param dem_any_required
     */
    public void setDem_any_required(Think.XmlWebServices.ZZBoolean dem_any_required) {
        this.dem_any_required = dem_any_required;
    }


    /**
     * Gets the dem_num_quests value for this Demog_form_response.
     * 
     * @return dem_num_quests
     */
    public int getDem_num_quests() {
        return dem_num_quests;
    }


    /**
     * Sets the dem_num_quests value for this Demog_form_response.
     * 
     * @param dem_num_quests
     */
    public void setDem_num_quests(int dem_num_quests) {
        this.dem_num_quests = dem_num_quests;
    }


    /**
     * Gets the display_demog_form value for this Demog_form_response.
     * 
     * @return display_demog_form
     */
    public Think.XmlWebServices.ZZBoolean getDisplay_demog_form() {
        return display_demog_form;
    }


    /**
     * Sets the display_demog_form value for this Demog_form_response.
     * 
     * @param display_demog_form
     */
    public void setDisplay_demog_form(Think.XmlWebServices.ZZBoolean display_demog_form) {
        this.display_demog_form = display_demog_form;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Demog_form_response)) return false;
        Demog_form_response other = (Demog_form_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.demog_ques_infos==null && other.getDemog_ques_infos()==null) || 
             (this.demog_ques_infos!=null &&
              java.util.Arrays.equals(this.demog_ques_infos, other.getDemog_ques_infos()))) &&
            this.resp_dem_form_id == other.getResp_dem_form_id() &&
            this.resp_dem_form_oc_id == other.getResp_dem_form_oc_id() &&
            ((this.dem_any_required==null && other.getDem_any_required()==null) || 
             (this.dem_any_required!=null &&
              this.dem_any_required.equals(other.getDem_any_required()))) &&
            this.dem_num_quests == other.getDem_num_quests() &&
            ((this.display_demog_form==null && other.getDisplay_demog_form()==null) || 
             (this.display_demog_form!=null &&
              this.display_demog_form.equals(other.getDisplay_demog_form())));
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
        if (getDemog_ques_infos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDemog_ques_infos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDemog_ques_infos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResp_dem_form_id();
        _hashCode += getResp_dem_form_oc_id();
        if (getDem_any_required() != null) {
            _hashCode += getDem_any_required().hashCode();
        }
        _hashCode += getDem_num_quests();
        if (getDisplay_demog_form() != null) {
            _hashCode += getDisplay_demog_form().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Demog_form_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demog_form_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("resp_dem_form_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "resp_dem_form_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("resp_dem_form_oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "resp_dem_form_oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_any_required");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_any_required"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dem_num_quests");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dem_num_quests"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("display_demog_form");
        attrField.setXmlName(new javax.xml.namespace.QName("", "display_demog_form"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("demog_ques_infos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "demog_ques_infos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">demog_ques_infos"));
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
