package com.nsv.jsmbaba.controller;

import com.nsv.jsmbaba.domain.Person;
import com.nsv.jsmbaba.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/person/create",method = RequestMethod.POST , consumes= "application/json", produces = "application/json")
    private Person createPerson(@Valid @RequestBody Person person){
        log.info("creating person {}",person.toString());
        return personService.createPerson(person);
    }

    @RequestMapping(value="/person/get",method = RequestMethod.POST , consumes= "application/json", produces = "application/json")
    private Person getPerson(@Valid @RequestBody Person person){
        log.info("reading a person {}",person.toString());
        return personService.getPerson(person.getId());
    }

    @RequestMapping(value="/person/get/{id}",method = RequestMethod.GET , consumes= "application/json", produces = "application/json")
    private Person getPersonById(@Valid @PathVariable("id") int id){
        log.info("reading person using id {}",id);
        return personService.getPerson(id);
    }

    @RequestMapping(value="/person/get",method = RequestMethod.GET , consumes= "application/json", produces = "application/json")
    private Person getPersonByIdQueryParam(@Valid @RequestParam("id") int id){
        log.info("reading person using id {}",id);
        return personService.getPerson(id);
    }




}
