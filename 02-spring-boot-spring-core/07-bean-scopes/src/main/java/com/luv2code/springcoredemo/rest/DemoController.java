package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a specialized annotation in Spring Boot that
// marks a class as a controller where every method automatically
// returns data (JSON or XML) instead of a view (like an HTML page).
//It is basically a combination of:
//@Controller + @ResponseBody
//@Controller → Tells Spring this class handles web requests.
//
//@ResponseBody → Tells Spring to return
// the method’s return value as the response body (not as a view name).
@RestController
public class DemoController {

    //define a private field for the dependency

    private Coach myCoach;

    private Coach anotherCoach;

    //define a constructor for dependency injection

   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theanotherCoach){
       System.out.println("In constructor: " + getClass().getSimpleName());
       myCoach=theCoach;
       anotherCoach=theanotherCoach;
       //Default scope is singleton
       //All dependency injections for the bean will reference the same bean
   }


    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check(){
       return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
       //check to see if this is the same bean
        //True or False depending in the bean scope
        //singleton:true
        //prototype :false
    }
}
