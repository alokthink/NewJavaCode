/**
 * Customer_login_question_list_select_responseCustomer_login_question.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_login_question_list_select_responseCustomer_login_question  implements java.io.Serializable {
    private int customer_login_question_id;  // attribute

    private java.lang.String question;  // attribute

    private int inactive;  // attribute

    public Customer_login_question_list_select_responseCustomer_login_question() {
    }

    public Customer_login_question_list_select_responseCustomer_login_question(
           int customer_login_question_id,
           java.lang.String question,
           int inactive) {
           this.customer_login_question_id = customer_login_question_id;
           this.question = question;
           this.inactive = inactive;
    }


    /**
     * Gets the customer_login_question_id value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @return customer_login_question_id
     */
    public int getCustomer_login_question_id() {
        return customer_login_question_id;
    }


    /**
     * Sets the customer_login_question_id value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @param customer_login_question_id
     */
    public void setCustomer_login_question_id(int customer_login_question_id) {
        this.customer_login_question_id = customer_login_question_id;
    }


    /**
     * Gets the question value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @return question
     */
    public java.lang.String getQuestion() {
        return question;
    }


    /**
     * Sets the question value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @param question
     */
    public void setQuestion(java.lang.String question) {
        this.question = question;
    }


    /**
     * Gets the inactive value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @return inactive
     */
    public int getInactive() {
        return inactive;
    }


    /**
     * Sets the inactive value for this Customer_login_question_list_select_responseCustomer_login_question.
     * 
     * @param inactive
     */
    public void setInactive(int inactive) {
        this.inactive = inactive;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_login_question_list_select_responseCustomer_login_question)) return false;
        Customer_login_question_list_select_responseCustomer_login_question other = (Customer_login_question_list_select_responseCustomer_login_question) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_login_question_id == other.getCustomer_login_question_id() &&
            ((this.question==null && other.getQuestion()==null) || 
             (this.question!=null &&
              this.question.equals(other.getQuestion()))) &&
            this.inactive == other.getInactive();
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
        _hashCode += getCustomer_login_question_id();
        if (getQuestion() != null) {
            _hashCode += getQuestion().hashCode();
        }
        _hashCode += getInactive();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer_login_question_list_select_responseCustomer_login_question.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>customer_login_question_list_select_response>customer_login_question"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_login_question_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_login_question_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("question");
        attrField.setXmlName(new javax.xml.namespace.QName("", "question"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inactive");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inactive"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

}
