package com.example.model.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long orderItemId;
    private String item;
    private Double unitPrice;
    private Integer quantity;
    
    public OrderItem() {
        super();
    }
    public OrderItem(String item, Double unitPrice, Integer quantity) {
        super();
        this.item = item;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public String getItem() {
        return item;
    }
    public Long getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
