package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.domain.Person;
import com.nsv.jsmbaba.repository.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        validatePerson(person);
        return personRepository.save(person);
    }

    private void validatePerson(Person person) {
        if(StringUtils.isNotEmpty(person.getStartDate()) && StringUtils.isEmpty(person.getEndDate())){
            throw new IllegalArgumentException("EndDate is empty");
        }else if(StringUtils.isEmpty(person.getStartDate()) && StringUtils.isNotEmpty(person.getEndDate())){
            throw new IllegalArgumentException("StartDate is empty");
        }

    }

    @Override
    public Person getPerson(Integer id) {
        Optional<Person> personById = personRepository.findById(id);
        return personById.get();
    }
}
