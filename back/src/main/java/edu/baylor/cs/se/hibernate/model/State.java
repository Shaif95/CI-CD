package edu.baylor.cs.se.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class State{

    @Id
    @GeneratedValue
    private Long id;


    private enum state { ACCEPTED , PENDING , CANCELED }  

    public Long getId() {
        return id;
    }
    
    

}
