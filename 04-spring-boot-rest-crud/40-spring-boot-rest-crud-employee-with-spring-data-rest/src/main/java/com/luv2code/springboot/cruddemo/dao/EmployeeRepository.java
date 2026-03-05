package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}



//JpaRepository<Employee, Integer> means:
//You’re managing Employee entities.
//The primary key type is Integer.
//JpaRepository already provides all CRUD methods, such as:
//findAll()This is the most powerful part.
//findById(id)
//save(entity)
//deleteById(id)
//count()