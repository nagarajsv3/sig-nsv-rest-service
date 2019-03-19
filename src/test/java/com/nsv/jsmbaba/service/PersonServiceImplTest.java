package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.domain.Person;
import com.nsv.jsmbaba.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class PersonServiceImplTest {

    @TestConfiguration
    static class PersonServiceImplContextConfiguration{
        @Bean
        public PersonService personServiceImpl(){
            return new PersonServiceImpl();
        }
    }

    @Autowired
    private PersonService personServiceImpl;

    @MockBean
    private PersonRepository personRepository;

    @Before
    public void setup() {
        Person person = new Person();
        person.setName("Virat");
        person.setAge(29);

        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person));
    }

    @Test
    public void getPerson(){
        Person person = new Person();
        person.setName("Virat");

        Assert.assertEquals(person.getName(), personServiceImpl.getPerson(1).getName());
    }
}
