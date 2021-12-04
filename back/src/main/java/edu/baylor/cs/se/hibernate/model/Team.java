package edu.baylor.cs.se.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.*;


@Entity
public class Team {

    @Id
    @Column(name = "teamid", nullable = false)
    @GeneratedValue
    private Long teamid;

    @Column(name = "rank", nullable = false)
    private Integer rank;

    @Column
    private String state;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "team",  cascade = CascadeType.ALL)
    public List<Person> persons  = new ArrayList<>();
   
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    private Person coach;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "conestid")
    private Contest contest;
    
    
    public Long getId() {
        return teamid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Integer getrank() {
        return rank;
    }

    public void setrank(Integer rank) {
        this.rank = rank;
    }

    public void setpersons(List<Person> rank) {
        this.persons = rank;
    }

  
    public List<Person> getpersons() {
        return persons;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

	
}
