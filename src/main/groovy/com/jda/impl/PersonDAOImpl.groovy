package com.jda.impl

import com.jda.bo.GroovyPerson
import com.jda.bo.JavaProduct
import com.jda.dao.PersonDAO
import groovy.sql.Sql

class PersonDAOImpl implements  PersonDAO {

    Sql sql = Sql.newInstance("jdbc:mysql://localhost:3306/billtools", 'root', 'tobi2000')

    PersonDAOImpl() {

        println "BEGINNING"

        sql.execute """

        create table if not exists people (
          id int primary key AUTO_INCREMENT,
          first varchar(25),
          last varchar(25)
        )
     """
        println "DONE!!!"
    }

    static void main(String[] args) {

        PersonDAO personDAO = new PersonDAOImpl()
        GroovyPerson person = new GroovyPerson()
        person.first = 'Juan'
        person.last = 'Alvarado'

        personDAO.create(person)
    }

    List<GroovyPerson> findAll() {

//        def people = sql.rows( sqlQuery).collect { row ->
//            new JavaProduct(row.collectEntries { k, v -> [k.toLowerCase(), v]})
//        }

        def query = 'select * from people'

       def everyBody =  sql.rows(query).collect { row ->
                new GroovyPerson(row.collectEntries { k, v -> [k.toLowerCase(), v]})
        }

        return everyBody
    }

    GroovyPerson findById(long id) {
        return null
    }

    List<GroovyPerson> findByLastName(String name) {
        return null
    }

    GroovyPerson create(GroovyPerson p) {

        String txt = 'insert into people(id, first, last) values(?, ?, ?)'
        def keys = sql.executeInsert txt, [null, p.first, p.last]
        p.id = keys [0][0]

        return p
    }

    GroovyPerson update(GroovyPerson p) {
        return null
    }

    boolean delete(long id) {

        def param = [id]
        def query = 'delete from people where id = ?'
        return sql.execute(query, param)
    }
}
