package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.domain.Person;
import com.nsv.jsmbaba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(Integer id) {
        Optional<Person> personById = personRepository.findById(id);
        return personById.get();
    }
}
