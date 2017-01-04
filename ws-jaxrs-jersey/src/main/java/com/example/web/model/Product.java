package com.example.web.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String code;
    private String woodType;
    private String color;
    private Date creationDate;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal depth;
    
    public Product() {
        super();
    }
    public Product(String code, BigDecimal height, BigDecimal width, BigDecimal depth) {
        super();
        this.code = code;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getWoodType() {
        return woodType;
    }
    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public BigDecimal getHeight() {
        return height;
    }
    public void setHeight(BigDecimal height) {
        this.height = height;
    }
    public BigDecimal getWidth() {
        return width;
    }
    public void setWidth(BigDecimal width) {
        this.width = width;
    }
    public BigDecimal getDepth() {
        return depth;
    }
    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }
    
    
    
}
