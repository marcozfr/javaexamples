package com.example.model.catalog;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="item_store")
@AssociationOverrides({
    @AssociationOverride(name="pk.item",joinColumns=@JoinColumn(name="itemId")),
    @AssociationOverride(name="pk.store",joinColumns=@JoinColumn(name="storeId"))
})
public class ItemStore {
    
    @EmbeddedId
    private ItemStoreId pk;
    private Integer quantity;
    private BigDecimal price;
    
    @Transient
    public Item getItem() {
        return getPk().getItem();
    }

    public void setItem(Item item) {
        getPk().setItem(item);
    }

    @Transient
    public Store getStore() {
        return getPk().getStore();
    }

    public void setStore(Store store) {
        getPk().setStore(store);
    }

    public ItemStoreId getPk() {
        return pk;
    }

    public void setPk(ItemStoreId pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemStore other = (ItemStore) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }
    
}
