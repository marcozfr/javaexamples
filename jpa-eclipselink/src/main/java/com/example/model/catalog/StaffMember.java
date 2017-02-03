package com.example.model.catalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;

@Entity
@IdClass(StaffMemberId.class)
@NamedQuery(name="findStaffMemberById",query="select sm from StaffMember sm where sm.code = :code and sm.initials = :initials")
public class StaffMember {
    
    @Id
    private String code;
    @Id
    private String initials;
    private String name;
    private String lastName;
    
    public void createInitials(){
        String i1 = name!= null ? name.substring(0,1) : null;
        String i2 = lastName!= null ? lastName.substring(0,1) : null;
        initials = (i1 != null && i2 != null) ? i1.concat(i2) : null;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
