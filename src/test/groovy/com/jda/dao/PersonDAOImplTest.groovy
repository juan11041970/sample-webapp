package com.jda.dao

import com.jda.bo.GroovyPerson
import com.jda.impl.PersonDAOImpl
import groovyx.net.http.RESTClient
import org.glassfish.grizzly.http.server.HttpServer
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


class PersonDAOImplTest extends Specification {

    PersonDAO dao = new PersonDAOImpl()

    RESTClient client = new RESTClient('http://localhost:8080/restserviceexample', groovyx.net.http.ContentType.JSON)

   @Shared
    static HttpServer server

    def setupSpec() {
        server = HttpServer.createSimpleServer()
        server.start()


        println 'server started'
    }

    def cleanupSpec() {
        server?.shutdown()

        println 'server shutdown'
    }

    def 'server is running'() {

        def response = client.get(path: "status")
        println "response status is: ${response.status}"

        expect: server.started
    }

    def 'get request returns all people'() {

        when:
        def response = client.get(path: 'people')

        then:
        response.status == 200
        response.contentType == 'application/json'

    }

    def 'insert and delete new person'() {

        GroovyPerson person = new GroovyPerson(first: 'John',  last: 'Johnson')

        when:
        dao.create(person)

        then:
        dao.findAll().size() == old(dao.findAll().size) + 1

        when:
        dao.delete(person.id)

        then:
        dao.findAll().size() == old(dao.findAll().size()) - 1

        println 'Done with PersonDAOImpl test'

    }

}
