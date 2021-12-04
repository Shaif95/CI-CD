package edu.baylor.cs.se.hibernate.services;

import edu.baylor.cs.se.hibernate.model.Contest;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.*;

//Spring annotations, feel free to ignore it
@Repository
@Transactional
public class SuperRepository {

    @PersistenceContext

    @Autowired
    public EntityManager em;

    public void populate(){


        LocalDate date1 = LocalDate.of(1995,01,01);
        LocalDate date2 = LocalDate.of(1995,01,01);
        LocalDate date3 = LocalDate.of(1995,01,01);
        LocalDate date4 = LocalDate.of(1995,01,01);
        LocalDate date5 = LocalDate.of(1995,01,01);
        LocalDate date6 = LocalDate.of(1995,01,01);

        LocalDate date7 = LocalDate.of(1995,01,01);
        LocalDate date8 = LocalDate.of(1995,01,01);
        LocalDate date9 = LocalDate.of(1995,01,01);
        LocalDate date10 = LocalDate.of(1995,01,01);
        LocalDate date11 = LocalDate.of(1995,01,01);
        LocalDate date12 = LocalDate.of(1995,01,01);

        LocalDate date13 = LocalDate.of(1995,01,01);
        LocalDate date14 = LocalDate.of(1995,01,01);
        LocalDate date15 = LocalDate.of(1995,01,01);

        Person person1 = createPerson("Bob", "bob@gmail.com","BU",date1);
        Person person2 = createPerson("Bobby", "bobby@gmail.com","BU",date2);
        Person person3 = createPerson("Bobi", "bobi@gmail.com","BU",date3);
        Person person4 = createPerson("Jim", "jim@gmail.com","BU",date4);
        Person person5 = createPerson("Jimmy", "jimmy@gmail.com","BU",date5);
        Person person6 = createPerson("Jimy", "jimy@gmail.com","BU",date6);
        Person person7 = createPerson("Rob", "rob@gmail.com","DU",date7);
        Person person8 = createPerson("Robby", "robbyb@gmail.com","DU",date8);
        Person person9 = createPerson("Robi", "robi@gmail.com","DU",date9);

        Person person10 = createPerson("Tim", "tim@gmail.com","DU",date10);
        Person person11 = createPerson("Timmy", "timmy@gmail.com","BU",date11);
        Person person12 = createPerson("Timi", "timi@gmail.com","DU",date12);

        Person person13 = createPerson("Rodger", "rodger@gmail.com","DU",date13);



        Team team1 = new Team();
        team1.setName("Jarvis");
        team1.setrank(1);
        team1.setState("ACCEPTED");
        team1.setCoach(person10);
        List<Person> p = new ArrayList<>() ;
        p.add(person1);
        p.add(person2);
        p.add(person3);
        team1.setpersons(p);
        team1.setCoach(person10);
        em.persist(team1);


        Team team2 = new Team();
        team2.setName("Oracle");
        team2.setrank(2);
        team2.setState("ACCEPTED");
        team2.setCoach(person11);
        List<Person> p1 = new ArrayList<>();
        p1.add(person4);
        p1.add(person5);
        p1.add(person6);
        team2.setpersons(p1);
        team2.setCoach(person11);
        em.persist(team2);


        Team team3 = new Team();
        team3.setName("JLow");
        team3.setrank(3);
        team3.setState("ACCEPTED");
        team3.setCoach(person11);
        List<Person> p2  = new ArrayList<>();
        p2.add(person7);
        p2.add(person8);
        p2.add(person9);
        team1.setpersons(p2);
        team3.setCoach(person12);
        em.persist(team3);


        Contest contest = new Contest();
        contest.setName("Round1");
        contest.setManager(person13);
        contest.setregistration_from(date14);
        contest.setregistration_to(date15);
        contest.setCap(3);
        contest.getteams().add(team1);
        contest.getteams().add(team2);
        contest.getteams().add(team3);
        em.persist(contest);

        Contest maincontest = new Contest();
        maincontest.setName("ICPC");
        maincontest.setManager(person13);
        maincontest.getteams().add(team1);
        maincontest.getteams().add(team2);
        maincontest.getteams().add(team3);
        maincontest.setCap(3);
        maincontest.setregistration_from(date14);
        maincontest.setregistration_to(date15);
        maincontest.setcontests(contest);;
        em.persist(maincontest);


    }


    public List<Team> getTeams(){
        return em.createQuery("SELECT t FROM Team t ").getResultList();
    }

    public List<Person> getPersons(){
        return em.createQuery("SELECT p FROM Person p").getResultList();
    }



    private Person createPerson(String name, String email, String univ, LocalDate date){
        Person person = new Person();
        person.setName(name);
        person.setDate(date);
        person.setemail(email);
        person.setuniv(univ);
        em.persist(person);
        return person;

    }
    
  
    


	public MultiValueMap getStudentByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiValueMap getContest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public EntityManager getEntityManager()
	{
		return em;
	}
}
