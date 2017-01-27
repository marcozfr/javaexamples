package com.example.model.catalog;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;

@Entity
@SecondaryTables({
    @SecondaryTable(name="city"),
    @SecondaryTable(name="country")
})
@Access(AccessType.FIELD)
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName="SEQ_ADDRESS", name = "seqAddress")
    private Long id;
    
    private String street1;
    
    private String street2;
    
    @Column(table="city")
    private String city;
    
    @Column(table="city")
    private String state;
    
    @Column(table="city")
    private String zipCode;

    @Column(table="country")
    private String country;
    
    @Column(table="country")
    private String countryCode;

    @Access(AccessType.PROPERTY)
    @Column(length=20)
    public String getStreet1() {
        return street1;
    }

    @Access(AccessType.PROPERTY)
    @Column(length=3)
    public String getStreet2() {
        return street2;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    
    
}
