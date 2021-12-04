package edu.baylor.cs.se.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Contest {

    @Id
    @Column(name = "contestid", nullable = false)
    @GeneratedValue
    private Long contestid;

    @Column
    private Integer Capacity;
    
    @Column
    private Date date;

    @Column
    private String name;
    
    @Column
    private boolean registration_allowed;
    
    @Column
    private LocalDate registration_from;
    
    @Column
    private LocalDate registration_to;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contest", cascade = CascadeType.ALL)
    private Set<Team> teams = new HashSet();
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contest", cascade = CascadeType.ALL)
    private Person manager;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contest_id")
    
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contest", cascade = CascadeType.ALL)
    private Contest subcontest;
    

    public Long getId() {
        return contestid;
    }

    public String getName() {
        return name;
    }
    public Integer getCap() {
        return Capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCap(Integer name) {
        this.Capacity = name;
    }

    public Date getDate() {
        return date;
    }

  
  
    public LocalDate getregistration_from() {
        return registration_from;
    }

    public void setregistration_from(LocalDate date) {
        this.registration_from = date;
    }
    public LocalDate getregistration_to() {
        return registration_to;
    }

    public void setregistration_to(LocalDate date) {
        this.registration_to = date;
    }

    

    public Set getteams() {
        return teams;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person man) {
        this.manager = man;
    }

public Contest getcontests() {
        return subcontest;
    }

public void setcontests(Contest c) {
    this.subcontest = c;
}
    
}
