package com.example.model.catalog;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,name="itemType")
@NamedQuery(name="getItemById",query="select i from Item i where i.itemId = :id")
public class Item {

    @Id @GeneratedValue
    private Long itemId;
//    private String itemType;
    private String description;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="pk.item")
    private Set<ItemStore> itemStore;
    
    public Item() {
        super();
    }
    
    public Item(String description) {
        super();
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public Set<ItemStore> getItemStore() {
        return itemStore;
    }

    public void setItemStore(Set<ItemStore> itemStore) {
        this.itemStore = itemStore;
    }

//        public String getItemType() {
//        return itemType;
//    }
//    public void setItemType(String itemType) {
//        this.itemType = itemType;
//    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
