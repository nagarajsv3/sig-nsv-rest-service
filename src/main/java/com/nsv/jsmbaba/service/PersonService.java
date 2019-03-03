package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.domain.Person;

import java.util.Optional;

public interface PersonService {
    Person createPerson(Person person);

    Person getPerson(Integer id);
}
