package ru.otus.pro.psannikov.spring.service;

import ru.otus.pro.psannikov.spring.data.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PeopleService {
    Map<Long, Person> personMap = new HashMap<>();
    Map<String, Person> nameMap = new HashMap<>();
    AtomicLong ctr = new AtomicLong();

    public Person addPerson(Person person) {
        if (nameMap.containsKey(person.getName())) {
            return nameMap.get(person.getName());
        }
        if (person.getId() == null) {
            person.setId(ctr.incrementAndGet());
        }

        personMap.put(person.getId(), person);
        nameMap.put(person.getName(),person);
        return person;
    }

    public void deletePerson(Long id) {
        personMap.remove(id);
    }

    public Collection<Person> getPersons()  {
        return personMap.values();
    }

    public Person getPerson(Long id) {
        return personMap.get(id);
    }

}
