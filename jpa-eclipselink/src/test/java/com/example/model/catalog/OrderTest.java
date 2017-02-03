package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class OrderTest extends AbstractTest {

    @Test
    public void createOrderTest(){
        
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("item1",4.45,2));
        orderItems.add(new OrderItem("item2",5.15,1));
        orderItems.add(new OrderItem("itemX",1.52,4));
        
        Order order = new Order();
        order.setCreationDate(new Date());
        order.setOrderItems(orderItems);
        tx.begin();
        em.persist(order);
        tx.commit();
        assertNotNull(order.getOrderId());
    }
}
