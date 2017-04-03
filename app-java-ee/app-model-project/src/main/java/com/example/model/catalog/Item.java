package com.example.model.catalog;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,name="itemType")
@NamedQuery(name="getItemById",query="select i from Item i where i.itemId = :id")
public class Item {

    @Id @GeneratedValue
    private Long itemId;
//    private String itemType;
    private String item;
    private BigDecimal price;
    private Integer quantity;

    public Item() {
        super();
    }
    public Item(String item, BigDecimal price, Integer quantity) {
        super();
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }
//    public String getItemType() {
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
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
