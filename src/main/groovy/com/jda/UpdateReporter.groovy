package com.jda

import java.util.logging.Logger

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
class UpdateReporter {

    Logger log = Logger.getLogger(UpdateReporter.class.name)

    @Before("execution(void set*(*))")
    void reportOnSet(JoinPoint jp) {

        String method = jp.signature.name
        String base = method - 'set'
        String property = base[0].toLowerCase() + base[1..-1]
        def current = jp.target."$property"
        log.info "About to change $property from $current to ${jp.args[0]}"
        println "About to change $property from $current to ${jp.args[0]}"

    }
}
