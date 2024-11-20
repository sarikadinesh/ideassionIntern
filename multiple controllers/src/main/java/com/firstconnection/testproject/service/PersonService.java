package com.firstconnection.testproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstconnection.testproject.model.Person;
import com.firstconnection.testproject.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person personDetails) {
        return personRepository.findById(id).map(person -> {
            person.setName(personDetails.getName());
            person.setAge(personDetails.getAge());
            return personRepository.save(person);
        });
    }

    public boolean deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
