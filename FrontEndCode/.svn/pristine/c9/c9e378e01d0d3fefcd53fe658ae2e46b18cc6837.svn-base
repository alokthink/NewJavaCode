/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Service  extends Think.XmlWebServices.ZZService  implements java.io.Serializable {
    private Think.XmlWebServices.ZZServiceNote service_note;

    private Think.XmlWebServices.Auxiliary_data[] auxiliary_data;

    public Service() {
    }

    public Service(
           int customer_id,
           int service_seq,
           java.lang.String cause_code,
           java.lang.String claim_ref_nbr,
           java.lang.String complaint_code,
           java.util.Date complaint_date,
           java.util.Date followup_date,
           int order_item_seq,
           int orderhdr_id,
           java.lang.String service_code,
           java.util.Date service_date,
           int service_status,
           int subscrip_id,
           java.lang.String user_code,
           Think.XmlWebServices.ZZServiceNote service_note,
           Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        super(
            customer_id,
            service_seq,
            cause_code,
            claim_ref_nbr,
            complaint_code,
            complaint_date,
            followup_date,
            order_item_seq,
            orderhdr_id,
            service_code,
            service_date,
            service_status,
            subscrip_id,
            user_code);
        this.service_note = service_note;
        this.auxiliary_data = auxiliary_data;
    }


    /**
     * Gets the service_note value for this Service.
     * 
     * @return service_note
     */
    public Think.XmlWebServices.ZZServiceNote getService_note() {
        return service_note;
    }


    /**
     * Sets the service_note value for this Service.
     * 
     * @param service_note
     */
    public void setService_note(Think.XmlWebServices.ZZServiceNote service_note) {
        this.service_note = service_note;
    }


    /**
     * Gets the auxiliary_data value for this Service.
     * 
     * @return auxiliary_data
     */
    public Think.XmlWebServices.Auxiliary_data[] getAuxiliary_data() {
        return auxiliary_data;
    }


    /**
     * Sets the auxiliary_data value for this Service.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Service)) return false;
        Service other = (Service) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.service_note==null && other.getService_note()==null) || 
             (this.service_note!=null &&
              this.service_note.equals(other.getService_note()))) &&
            ((this.auxiliary_data==null && other.getAuxiliary_data()==null) || 
             (this.auxiliary_data!=null &&
              java.util.Arrays.equals(this.auxiliary_data, other.getAuxiliary_data())));
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
        if (getService_note() != null) {
            _hashCode += getService_note().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Service.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">service"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "service_note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZServiceNote"));
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
