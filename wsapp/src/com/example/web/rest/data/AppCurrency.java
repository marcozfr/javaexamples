package com.example.web.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppCurrency {

    private String symbol;
    private String name;
    @JsonProperty("symbol_native")
    private String symbolNative;
    @JsonProperty("decimal_digits")
    private Integer decimalDigits;
    private Integer rounding;
    private String code;
    @JsonProperty("name_plural")
    private String namePlural;
    
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbolNative() {
        return symbolNative;
    }
    public void setSymbolNative(String symbolNative) {
        this.symbolNative = symbolNative;
    }
    public Integer getDecimalDigits() {
        return decimalDigits;
    }
    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }
    public Integer getRounding() {
        return rounding;
    }
    public void setRounding(Integer rounding) {
        this.rounding = rounding;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNamePlural() {
        return namePlural;
    }
    public void setNamePlural(String namePlural) {
        this.namePlural = namePlural;
    }
    
    
    
}
