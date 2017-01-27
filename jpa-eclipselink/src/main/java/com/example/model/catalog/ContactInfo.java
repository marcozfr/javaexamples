package com.example.model.catalog;

import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    
    private String email;
    private String phoneNumber;
    private String linkedinAccount;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLinkedinAccount() {
        return linkedinAccount;
    }
    public void setLinkedinAccount(String linkedinAccount) {
        this.linkedinAccount = linkedinAccount;
    }
    

}
