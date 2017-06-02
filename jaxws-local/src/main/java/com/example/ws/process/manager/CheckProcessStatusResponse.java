
package com.example.ws.process.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="executionResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processStatus",
    "executionResult"
})
@XmlRootElement(name = "checkProcessStatusResponse")
public class CheckProcessStatusResponse {

    @XmlElement(required = true)
    protected String processStatus;
    @XmlElement(required = true)
    protected String executionResult;

    /**
     * Gets the value of the processStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * Sets the value of the processStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessStatus(String value) {
        this.processStatus = value;
    }

    /**
     * Gets the value of the executionResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionResult() {
        return executionResult;
    }

    /**
     * Sets the value of the executionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionResult(String value) {
        this.executionResult = value;
    }

}
