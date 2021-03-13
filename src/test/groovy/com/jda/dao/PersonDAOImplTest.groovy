package com.jda.dao

import com.jda.bo.GroovyPerson
import com.jda.impl.PersonDAOImpl
import groovyx.net.http.RESTClient
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.server.ResourceConfig
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.GenericType
import javax.ws.rs.core.MediaType;

@Ignore
class PersonDAOImplTest extends Specification {

    PersonDAO dao = new PersonDAOImpl()

    ResourceConfig rc = new ResourceConfig().packages('com.jda.resource')

    @Shared
    Client c = ClientBuilder.newClient()

    @Shared
    WebTarget target

   @Shared
    static HttpServer server

    def setupSpec() {
        server = HttpServer.createSimpleServer('http://localhost:8080/')
        server.start()

        target = c.target('http://localhost:8080')

        println 'server started'
    }

    def cleanupSpec() {
        server?.shutdown()

        println 'server shutdown'
    }

    def 'server is running'() {
        expect: server.started
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
