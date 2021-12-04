package edu.baylor.cs.se.hibernate.controller;

import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.services.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Ignore this as it is Spring and not Java EE (Jax-RS) controller
@RestController
@CrossOrigin(origins = "https://front2345545454.herokuapp.com/")
public class MyController {

    private SuperRepository superRepository;

    //you should generally favour constructor/setter injection over field injection
    @Autowired
    public MyController(SuperRepository superRepository){
        this.superRepository = superRepository;
    }

    //very bad practise - using GET method to insert something to DB
    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public ResponseEntity populate(){
        superRepository.populate();
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/allteams", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeams(  ){
    	 System.out.print("Results : ");
    	return new ResponseEntity(superRepository.getTeams(),HttpStatus.OK);
       
    }
    

    @RequestMapping(value = "/allpersons", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersons(  ){
    	 System.out.print("Results : ");
    	return new ResponseEntity(superRepository.getPersons(),HttpStatus.OK);
       
    }

    
   

    @RequestMapping(value = "/age", method = RequestMethod.GET)
    public ResponseEntity<Person> getStudentsbyAge(  ){
    	 System.out.print("Results : ");
    	return new ResponseEntity(superRepository.getStudentByAge(),HttpStatus.OK);
       
    }
    
    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public ResponseEntity<String> CompareCapacity(  ){
    	 System.out.print("Results : ");
    	return new ResponseEntity(superRepository.getContest(),HttpStatus.OK);
       
    }

   
}
