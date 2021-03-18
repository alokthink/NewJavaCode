/**
 * Proc_type_info_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Proc_type_info_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.Proc_type_info_list_responseStepsStep[] steps;

    private int processType;  // attribute

    private int manualReviewStepNumber;  // attribute

    private int outputStepNumber;  // attribute

    private int reprintStepNumber;  // attribute

    private int updateStepNumber;  // attribute

    private int rollbackStepNumber;  // attribute

    public Proc_type_info_list_response() {
    }

    public Proc_type_info_list_response(
           Think.XmlWebServices.Proc_type_info_list_responseStepsStep[] steps,
           int processType,
           int manualReviewStepNumber,
           int outputStepNumber,
           int reprintStepNumber,
           int updateStepNumber,
           int rollbackStepNumber) {
           this.steps = steps;
           this.processType = processType;
           this.manualReviewStepNumber = manualReviewStepNumber;
           this.outputStepNumber = outputStepNumber;
           this.reprintStepNumber = reprintStepNumber;
           this.updateStepNumber = updateStepNumber;
           this.rollbackStepNumber = rollbackStepNumber;
    }


    /**
     * Gets the steps value for this Proc_type_info_list_response.
     * 
     * @return steps
     */
    public Think.XmlWebServices.Proc_type_info_list_responseStepsStep[] getSteps() {
        return steps;
    }


    /**
     * Sets the steps value for this Proc_type_info_list_response.
     * 
     * @param steps
     */
    public void setSteps(Think.XmlWebServices.Proc_type_info_list_responseStepsStep[] steps) {
        this.steps = steps;
    }


    /**
     * Gets the processType value for this Proc_type_info_list_response.
     * 
     * @return processType
     */
    public int getProcessType() {
        return processType;
    }


    /**
     * Sets the processType value for this Proc_type_info_list_response.
     * 
     * @param processType
     */
    public void setProcessType(int processType) {
        this.processType = processType;
    }


    /**
     * Gets the manualReviewStepNumber value for this Proc_type_info_list_response.
     * 
     * @return manualReviewStepNumber
     */
    public int getManualReviewStepNumber() {
        return manualReviewStepNumber;
    }


    /**
     * Sets the manualReviewStepNumber value for this Proc_type_info_list_response.
     * 
     * @param manualReviewStepNumber
     */
    public void setManualReviewStepNumber(int manualReviewStepNumber) {
        this.manualReviewStepNumber = manualReviewStepNumber;
    }


    /**
     * Gets the outputStepNumber value for this Proc_type_info_list_response.
     * 
     * @return outputStepNumber
     */
    public int getOutputStepNumber() {
        return outputStepNumber;
    }


    /**
     * Sets the outputStepNumber value for this Proc_type_info_list_response.
     * 
     * @param outputStepNumber
     */
    public void setOutputStepNumber(int outputStepNumber) {
        this.outputStepNumber = outputStepNumber;
    }


    /**
     * Gets the reprintStepNumber value for this Proc_type_info_list_response.
     * 
     * @return reprintStepNumber
     */
    public int getReprintStepNumber() {
        return reprintStepNumber;
    }


    /**
     * Sets the reprintStepNumber value for this Proc_type_info_list_response.
     * 
     * @param reprintStepNumber
     */
    public void setReprintStepNumber(int reprintStepNumber) {
        this.reprintStepNumber = reprintStepNumber;
    }


    /**
     * Gets the updateStepNumber value for this Proc_type_info_list_response.
     * 
     * @return updateStepNumber
     */
    public int getUpdateStepNumber() {
        return updateStepNumber;
    }


    /**
     * Sets the updateStepNumber value for this Proc_type_info_list_response.
     * 
     * @param updateStepNumber
     */
    public void setUpdateStepNumber(int updateStepNumber) {
        this.updateStepNumber = updateStepNumber;
    }


    /**
     * Gets the rollbackStepNumber value for this Proc_type_info_list_response.
     * 
     * @return rollbackStepNumber
     */
    public int getRollbackStepNumber() {
        return rollbackStepNumber;
    }


    /**
     * Sets the rollbackStepNumber value for this Proc_type_info_list_response.
     * 
     * @param rollbackStepNumber
     */
    public void setRollbackStepNumber(int rollbackStepNumber) {
        this.rollbackStepNumber = rollbackStepNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Proc_type_info_list_response)) return false;
        Proc_type_info_list_response other = (Proc_type_info_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.steps==null && other.getSteps()==null) || 
             (this.steps!=null &&
              java.util.Arrays.equals(this.steps, other.getSteps()))) &&
            this.processType == other.getProcessType() &&
            this.manualReviewStepNumber == other.getManualReviewStepNumber() &&
            this.outputStepNumber == other.getOutputStepNumber() &&
            this.reprintStepNumber == other.getReprintStepNumber() &&
            this.updateStepNumber == other.getUpdateStepNumber() &&
            this.rollbackStepNumber == other.getRollbackStepNumber();
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
        if (getSteps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSteps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSteps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getProcessType();
        _hashCode += getManualReviewStepNumber();
        _hashCode += getOutputStepNumber();
        _hashCode += getReprintStepNumber();
        _hashCode += getUpdateStepNumber();
        _hashCode += getRollbackStepNumber();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Proc_type_info_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">proc_type_info_list_response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("processType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ProcessType"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("manualReviewStepNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ManualReviewStepNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("outputStepNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "OutputStepNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reprintStepNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ReprintStepNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("updateStepNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "UpdateStepNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollbackStepNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "RollbackStepNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("steps");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "steps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>>proc_type_info_list_response>steps>step"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "step"));
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
