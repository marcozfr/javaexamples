package com.example.model.catalog;

import java.io.Serializable;

public class StaffMemberId implements Serializable{
    
    private static final long serialVersionUID = -6203974588733301998L;
    private String code;
    private String initials;
    
    public StaffMemberId(){
        
    }
    
    public StaffMemberId(String code, String initials) {
        super();
        this.code = code;
        this.initials = initials;
    }
    public String getCode() {
        return code;
    }
    public String getInitials() {
        return initials;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((initials == null) ? 0 : initials.hashCode());
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
        StaffMemberId other = (StaffMemberId) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (initials == null) {
            if (other.initials != null)
                return false;
        } else if (!initials.equals(other.initials))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return initials + code;
    }
    
}
