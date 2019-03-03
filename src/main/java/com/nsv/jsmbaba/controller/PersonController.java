package com.nsv.jsmbaba.controller;

import com.nsv.jsmbaba.domain.Person;
import com.nsv.jsmbaba.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/person",method = RequestMethod.POST , consumes= "application/json", produces = "application/json")
    private Person createPerson(@Valid @RequestBody Person person){
        return personService.createPerson(person);
    }

    @RequestMapping(value="/person",method = RequestMethod.GET , consumes= "application/json", produces = "application/json")
    private Person createPerson(@Valid @PathVariable int id){
        return personService.getPerson(id);
    }




}
