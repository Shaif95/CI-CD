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
public class Person {

    @Id
    @Column(name = "personid", nullable = false)
    @GeneratedValue
    private Long personid;

    @Column
    private LocalDate birthdate;

    @Column
  
    private String email;
    
    @Column
    
    private String name;
    
    @Column
    private String university;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamid")
    private Team team;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contestid")
    private Contest contest;

    public Long getId() {
        return personid;
    }

    public String getName() {
        return name;
    }

    public void setDate(LocalDate date) {
        this.birthdate = date;
    }
    
    public LocalDate getDate() {
        return birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getuniv() {
        return university;
    }

    public void setuniv(String univ) {
        this.university = univ;
    }
}
