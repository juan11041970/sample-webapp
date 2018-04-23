package com.jda.dao

import com.jda.bo.GroovyPerson
import com.jda.impl.PersonDAOImpl
import groovyx.net.http.RESTClient
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


class PersonDAOImplTest extends Specification {

    PersonDAO dao = new PersonDAOImpl()

//    RESTClient client = new RESTClient("http://localhost:8080/")
//
//    @Shared
//    WebTarget target
//
//   @Shared
//    static HttpServer server

//    def setupSpec() {
//        server = HttpServer.createSimpleServer('http://localhost:8080/')
//        server.start()
//
//        Client c = ClientBuilder.newClient()
//        target = c.target('http://localhost:8080'.toURI())
//
//        println 'server started'
//    }
//
//    def cleanupSpec() {
//        server?.shutdown()
//
//        println 'server shutdown'
//    }
//
//    def 'server is running'() {
//
////        def response = client.get(path: "status")
////        println "response status is: ${response.status}"
//
//        expect: server.started
//    }


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
