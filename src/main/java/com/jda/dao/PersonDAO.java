package com.jda.dao;

import com.jda.bo.GroovyPerson;

import java.util.List;

public interface PersonDAO {

    List<GroovyPerson> findAll();
    GroovyPerson findById(long id);
    List<GroovyPerson> findByLastName(String name);
    GroovyPerson create(GroovyPerson p);
    GroovyPerson update(GroovyPerson p);
    boolean delete(long id);
}
