package com.jda.dao

import groovy.transform.NotYetImplemented
import org.junit.Test

import java.util.logging.Logger
import static groovy.test.GroovyAssert.shouldFail

class GrooovyTestCase extends GroovyTestCase {

    def Logger LOG = Logger.getLogger("GrooovyTestCase.class")

    void testAssertsTest() {
        assertTrue(1 == 1)
        assertEquals("test", "test")

        def x = "43"
        assertNotNull "x cannot be null", x

        log.info "Done with testAsserts"
        println "Done with testAsserts"
    }

    void testvalidAccessTest() {
        def numbers = [1,2,3,4]
        def msg = shouldFail IndexOutOfBoundsException, {
            numbers.get(4)
        }

        println msg.message
        assert msg.message.contains('Index: 4, Size: 4')
    }

    @NotYetImplemented
    void testNotYetImplemented2Test() {
        assert 1 == 2
    }


    @Test
    void testShouldFailReturn() {
        def e = shouldFail {
            throw new RuntimeException('foo', new RuntimeException('bar'))
        }
        assert e instanceof RuntimeException
        assert e.message == 'foo'
        assert e.cause.message == 'bar'

        LOG.info "Done with shouldFailReturn test"
    }

}
