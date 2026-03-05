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

    //define a constructor for dependency injection

   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach){
       System.out.println("In constructor: " + getClass().getSimpleName());
       myCoach=theCoach;
   }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
