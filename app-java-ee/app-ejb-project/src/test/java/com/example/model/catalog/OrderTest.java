package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class OrderTest extends AbstractTest {

    @Test
    public void createOrderTest(){
        
        List<Item> orderItems = new ArrayList<>();
        orderItems.add(new Book("item1"));
        orderItems.add(new Book("item2"));
        orderItems.add(new Book("itemX"));
        
        Order order = new Order();
        order.setCreationDate(new Date());
        order.setOrderItems(orderItems);
        tx.begin();
        em.persist(order);
        tx.commit();
        assertNotNull(order.getOrderId());
    }
}
