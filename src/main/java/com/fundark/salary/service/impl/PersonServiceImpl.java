package com.fundark.salary.service.impl;

import com.fundark.salary.bean.Person;
import com.fundark.salary.mapper.PersonMapper;
import com.fundark.salary.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;

    @Autowired(required = false)
    public PersonServiceImpl(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }


    @Override
    public Person getPersonById(Integer id) {
        return personMapper.getPersonById(id);
    }

    @Override
    public List<Person> getPersonList() {
        return personMapper.getPersonList();
    }

    @Override
    public int add(Person person) {
        return personMapper.add(person);
    }

    @Override
    public int delete(Integer id) {
        return personMapper.delete(id);
    }

    @Override
    public int update(Integer id, Person person) {
        return personMapper.update(id, person);
    }
}
