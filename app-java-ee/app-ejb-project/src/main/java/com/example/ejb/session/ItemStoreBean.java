package com.example.ejb.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.Query;

import com.example.model.catalog.Store;
import com.example.model.catalog.dto.ItemsByStoreDTO;

@Stateless
@WebService
public class ItemStoreBean extends CrudBean {

    @Resource
    private SessionContext sessionContext;
    
    public Store saveStore(Store store){
        return save(store);
    }
    
    public List<Store> findAllStores(){
        Query q = getEntityManager().createNamedQuery("findAllStores");
        return q.getResultList();
    }
    
    public List<ItemsByStoreDTO> findAllItemsByStore(){
        Query q = getEntityManager().createQuery("select i.itemId , i.itemType, iz.quantity, iz.price, s.storeId, s.businessName "
                + " from ItemStore iz inner join iz.pk.item i inner join iz.pk.store s");
        List<Object[]> resultList = q.getResultList();
        List<ItemsByStoreDTO> resultObjList = new ArrayList<>();
        for(Object[] record : resultList){
            ItemsByStoreDTO recordObj = new ItemsByStoreDTO();
            recordObj.setItemId((Long)record[0]);
            recordObj.setItemType((String)record[1]);
            recordObj.setQuantity((Integer)record[2]);
            recordObj.setPrice((BigDecimal)record[3]);
            recordObj.setStoreId((Long)record[4]);
            recordObj.setStoreName((String)record[5]);
            resultObjList.add(recordObj);
        }
        return resultObjList; 
    }
    
}
