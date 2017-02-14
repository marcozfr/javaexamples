package com.fr.labs.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Local {
    
    @Id
    @GeneratedValue
    private Long localId;
    
    @OneToMany(fetch=FetchType.LAZY)
    private List<Field> fields;
    
}
