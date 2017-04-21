package com.example.model.catalog;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@NamedQueries(
  @NamedQuery(name="findAllStores",query="select s from Store s left join fetch s.itemStore")
)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Store {

    @Id
    @GeneratedValue
    private Long storeId;
    private String businessName;
    private Long altitute;
    private Long latitude;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="pk.store")
    private Set<ItemStore> itemStore;
    
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public Long getAltitute() {
        return altitute;
    }
    public void setAltitute(Long altitute) {
        this.altitute = altitute;
    }
    public Long getLatitude() {
        return latitude;
    }
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Set<ItemStore> getItemStore() {
        return itemStore;
    }
    public void setItemStore(Set<ItemStore> itemStore) {
        this.itemStore = itemStore;
    }
    
    
}
