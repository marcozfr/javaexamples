package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.example.model.catalog.AbstractTest;
import com.example.model.catalog.Book;
import com.example.model.catalog.Item;
import com.example.model.catalog.Order;

public class OrderTest extends AbstractTest {

    @Test
    public void createOrderTest(){
        
        List<Item> orderItems = new ArrayList<>();
        orderItems.add(new Book("item1",BigDecimal.valueOf(4.45),2));
        orderItems.add(new Book("item2",BigDecimal.valueOf(5.15),1));
        orderItems.add(new Book("itemX",BigDecimal.valueOf(1.11),4));
        
        Order order = new Order();
        order.setCreationDate(new Date());
        order.setOrderItems(orderItems);
        tx.begin();
        em.persist(order);
        tx.commit();
        assertNotNull(order.getOrderId());
    }
}
