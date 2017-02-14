package com.example.model.catalog;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.example.model.catalog.listener.CustomerAgeCalcListener;

@Entity
@EntityListeners(value=CustomerAgeCalcListener.class)
public class Customer {
    
    @Id
    @GeneratedValue
    private Long customerId;
    
    @Version
    private Integer version;
    
    private String firstName;
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Transient
    private Integer age;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    @Embedded
    private ContactInfo contactInfo;
    
    @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name="BILLADDRESS_FK",nullable=true)
    private Address billingAddress;
    
    public Long getCustomerId() {
        return customerId;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
