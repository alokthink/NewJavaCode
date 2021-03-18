/**
 * ZZItemIdentifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZItemIdentifier  implements java.io.Serializable {
    private int orderhdr_id;

    private int order_item_seq;

    private Think.XmlWebServices.ZZBoolean send_back_issues;  // attribute

    public ZZItemIdentifier() {
    }

    public ZZItemIdentifier(
           int orderhdr_id,
           int order_item_seq,
           Think.XmlWebServices.ZZBoolean send_back_issues) {
           this.orderhdr_id = orderhdr_id;
           this.order_item_seq = order_item_seq;
           this.send_back_issues = send_back_issues;
    }


    /**
     * Gets the orderhdr_id value for this ZZItemIdentifier.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZItemIdentifier.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the order_item_seq value for this ZZItemIdentifier.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZItemIdentifier.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the send_back_issues value for this ZZItemIdentifier.
     * 
     * @return send_back_issues
     */
    public Think.XmlWebServices.ZZBoolean getSend_back_issues() {
        return send_back_issues;
    }


    /**
     * Sets the send_back_issues value for this ZZItemIdentifier.
     * 
     * @param send_back_issues
     */
    public void setSend_back_issues(Think.XmlWebServices.ZZBoolean send_back_issues) {
        this.send_back_issues = send_back_issues;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZItemIdentifier)) return false;
        ZZItemIdentifier other = (ZZItemIdentifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.order_item_seq == other.getOrder_item_seq() &&
            ((this.send_back_issues==null && other.getSend_back_issues()==null) || 
             (this.send_back_issues!=null &&
              this.send_back_issues.equals(other.getSend_back_issues())));
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
        _hashCode += getOrderhdr_id();
        _hashCode += getOrder_item_seq();
        if (getSend_back_issues() != null) {
            _hashCode += getSend_back_issues().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZItemIdentifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("send_back_issues");
        attrField.setXmlName(new javax.xml.namespace.QName("", "send_back_issues"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

	@Override
	public String toString() {
		return "ZZItemIdentifier [orderhdr_id=" + orderhdr_id
				+ ", order_item_seq=" + order_item_seq + ", send_back_issues="
				+ send_back_issues + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
