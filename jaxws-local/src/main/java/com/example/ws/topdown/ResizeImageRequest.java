
package com.example.ws.topdown;

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
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetHeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "fileName",
    "targetHeight",
    "targetWidth"
})
@XmlRootElement(name = "resizeImageRequest")
public class ResizeImageRequest {

    @XmlElement(required = true)
    protected String fileName;
    protected int targetHeight;
    protected int targetWidth;

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the targetHeight property.
     * 
     */
    public int getTargetHeight() {
        return targetHeight;
    }

    /**
     * Sets the value of the targetHeight property.
     * 
     */
    public void setTargetHeight(int value) {
        this.targetHeight = value;
    }

    /**
     * Gets the value of the targetWidth property.
     * 
     */
    public int getTargetWidth() {
        return targetWidth;
    }

    /**
     * Sets the value of the targetWidth property.
     * 
     */
    public void setTargetWidth(int value) {
        this.targetWidth = value;
    }

}
