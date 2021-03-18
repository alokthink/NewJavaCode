/**
 * Orderhdr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

import java.util.Arrays;

public class Orderhdr  extends Think.XmlWebServices.ZZOrderhdr  implements java.io.Serializable {
    private Think.XmlWebServices.Order_item[] order_item;

    public Orderhdr() {
    }

    public Orderhdr(
           int orderhdr_id,
           java.util.Calendar order_date,
           java.lang.String po_number,
           Think.XmlWebServices.Order_item[] order_item) {
        super(
            orderhdr_id,
            order_date,
            po_number);
        this.order_item = order_item;
    }


    /**
     * Gets the order_item value for this Orderhdr.
     * 
     * @return order_item
     */
    public Think.XmlWebServices.Order_item[] getOrder_item() {
        return order_item;
    }


    /**
     * Sets the order_item value for this Orderhdr.
     * 
     * @param order_item
     */
    public void setOrder_item(Think.XmlWebServices.Order_item[] order_item) {
        this.order_item = order_item;
    }

    public Think.XmlWebServices.Order_item getOrder_item(int i) {
        return this.order_item[i];
    }

    public void setOrder_item(int i, Think.XmlWebServices.Order_item _value) {
        this.order_item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Orderhdr)) return false;
        Orderhdr other = (Orderhdr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.order_item==null && other.getOrder_item()==null) || 
             (this.order_item!=null &&
              java.util.Arrays.equals(this.order_item, other.getOrder_item())));
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
        if (getOrder_item() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrder_item());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrder_item(), i);
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
        new org.apache.axis.description.TypeDesc(Orderhdr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">orderhdr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_item"));
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
		return "Orderhdr [order_item=" + Arrays.toString(order_item) + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
