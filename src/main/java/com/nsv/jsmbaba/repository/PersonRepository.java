package com.nsv.jsmbaba.repository;

import com.nsv.jsmbaba.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}