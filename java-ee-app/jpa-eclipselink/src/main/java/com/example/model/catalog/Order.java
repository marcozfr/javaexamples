package com.example.model.catalog;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_order")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="join_order_item",
        joinColumns=@JoinColumn(name="order_fk"),
        inverseJoinColumns=@JoinColumn(name="order_line_fk"))
    private List<Item> orderItems;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }
    
}
