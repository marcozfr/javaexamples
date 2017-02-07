package com.example.model.catalog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StaffMemberTest extends AbstractTest {

    @Test
    public void createStaffMemberTest(){
        StaffMember member = new StaffMember();
        member.setCode("001");
        member.setLastName("Clark");
        member.setName("Thomas");
        member.createInitials();
        
        tx.begin();
        
        em.persist(member);
        
        assertEquals("001", member.getCode());
        
        assertEquals("TC", member.getInitials());
        
        StaffMemberId id = new StaffMemberId("001","TC");
        
        StaffMember found = em.find(StaffMember.class, id);
        
        assertEquals(id.getCode(), found.getCode());
        
        assertEquals(id.getInitials(), found.getInitials());
        
        tx.commit();
        
    }
    
}
