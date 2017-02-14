package com.fr.labs.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fr.labs.model.types.UnitType;

@Entity
public class Field {
    
    @Id 
    @GeneratedValue
    private Long fieldId;
    
    private Integer fieldNumber;
    
    private String fieldName;

    @Enumerated(EnumType.STRING)
    private UnitType measureType;
    
    private Long longSize;
    
    private Long wideSize;
    
    public UnitType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(UnitType measureType) {
        this.measureType = measureType;
    }

    public Long getLongSize() {
        return longSize;
    }

    public void setLongSize(Long longSize) {
        this.longSize = longSize;
    }

    public Long getWideSize() {
        return wideSize;
    }

    public void setWideSize(Long wideSize) {
        this.wideSize = wideSize;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(Integer fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    

}
