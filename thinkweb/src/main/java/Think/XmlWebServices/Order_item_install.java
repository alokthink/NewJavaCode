/**
 * Order_item_install.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

import java.util.Arrays;

public class Order_item_install  extends Think.XmlWebServices.ZZOrderItemInstall  implements java.io.Serializable {
    private Think.XmlWebServices.ZZOrderItemInstallDtl[] order_item_install_dtl;

    public Order_item_install() {
    }

    public Order_item_install(
           int orderhdr_id,
           int order_item_seq,
           java.lang.String auddis_transaction_code,
           int bacs_transaction_code,
           int cancel_dd,
           int current_year_sent,
           int ddi_accepted,
           int ddi_logged,
           java.lang.String debit_account_ref,
           int install_auto_payment,
           int install_payment_account_seq,
           java.util.Date mandate_date,
           java.util.Date most_recent_payment_date,
           java.util.Date next_payment_date,
           java.util.Date notice_date,
           java.util.Date payment_end_date,
           java.util.Date payment_start_date,
           int pull_day,
           int send_notice,
           int year_end_sent,
           Think.XmlWebServices.ZZOrderItemInstallDtl[] order_item_install_dtl) {
        super(
            orderhdr_id,
            order_item_seq,
            auddis_transaction_code,
            bacs_transaction_code,
            cancel_dd,
            current_year_sent,
            ddi_accepted,
            ddi_logged,
            debit_account_ref,
            install_auto_payment,
            install_payment_account_seq,
            mandate_date,
            most_recent_payment_date,
            next_payment_date,
            notice_date,
            payment_end_date,
            payment_start_date,
            pull_day,
            send_notice,
            year_end_sent);
        this.order_item_install_dtl = order_item_install_dtl;
    }


    /**
     * Gets the order_item_install_dtl value for this Order_item_install.
     * 
     * @return order_item_install_dtl
     */
    public Think.XmlWebServices.ZZOrderItemInstallDtl[] getOrder_item_install_dtl() {
        return order_item_install_dtl;
    }


    /**
     * Sets the order_item_install_dtl value for this Order_item_install.
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
        if (!(obj instanceof Order_item_install)) return false;
        Order_item_install other = (Order_item_install) obj;
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
        new org.apache.axis.description.TypeDesc(Order_item_install.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_item_install"));
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

	@Override
	public String toString() {
		return "Order_item_install [order_item_install_dtl=" + Arrays.toString(order_item_install_dtl)
				+ ", __equalsCalc=" + __equalsCalc + ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
