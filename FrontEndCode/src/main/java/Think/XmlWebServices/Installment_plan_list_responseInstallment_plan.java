/**
 * Installment_plan_list_responseInstallment_plan.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Installment_plan_list_responseInstallment_plan  extends Think.XmlWebServices.ZZInstallmentPlan  implements java.io.Serializable {
    private Think.XmlWebServices.ZZOrderItemInstallDtl[] order_item_install_dtl;

    public Installment_plan_list_responseInstallment_plan() {
    }

    public Installment_plan_list_responseInstallment_plan(
           int installment_plan_id,
           int allow_default_usage,
           int auto_setup,
           java.lang.String description,
           int interval,
           int interval_type,
           int nbr_installments,
           java.lang.String report,
           int unpaid_issues_new,
           int unpaid_issues_renew,
           Think.XmlWebServices.ZZOrderItemInstallDtl[] order_item_install_dtl) {
        super(
            installment_plan_id,
            allow_default_usage,
            auto_setup,
            description,
            interval,
            interval_type,
            nbr_installments,
            report,
            unpaid_issues_new,
            unpaid_issues_renew);
        this.order_item_install_dtl = order_item_install_dtl;
    }


    /**
     * Gets the order_item_install_dtl value for this Installment_plan_list_responseInstallment_plan.
     * 
     * @return order_item_install_dtl
     */
    public Think.XmlWebServices.ZZOrderItemInstallDtl[] getOrder_item_install_dtl() {
        return order_item_install_dtl;
    }


    /**
     * Sets the order_item_install_dtl value for this Installment_plan_list_responseInstallment_plan.
     * 
     * @param order_item_install_dtl
     */
    public void setOrder_item_install_dtl(Think.XmlWebServices.ZZOrderItemInstallDtl[] order_item_install_dtl) {
        this.order_item_install_dtl = order_item_install_dtl;
    }

    public Think.XmlWebServices.ZZOrderItemInstallDtl getOrder_item_install_dtl(int i) {
        return this.order_item_install_dtl[i];
    }

    public void setOrder_item_install_dtl(int i, Think.XmlWebServices.ZZOrderItemInstallDtl _value) {
        this.order_item_install_dtl[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Installment_plan_list_responseInstallment_plan)) return false;
        Installment_plan_list_responseInstallment_plan other = (Installment_plan_list_responseInstallment_plan) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.order_item_install_dtl==null && other.getOrder_item_install_dtl()==null) || 
             (this.order_item_install_dtl!=null &&
              java.util.Arrays.equals(this.order_item_install_dtl, other.getOrder_item_install_dtl())));
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
        if (getOrder_item_install_dtl() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item_install_dtl());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item_install_dtl(), i);
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
        new org.apache.axis.description.TypeDesc(Installment_plan_list_responseInstallment_plan.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>installment_plan_list_response>installment_plan"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_install_dtl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_install_dtl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_install_dtl"));
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
