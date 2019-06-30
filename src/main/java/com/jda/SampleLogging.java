package com.jda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleLogging {

    private static Logger LOG = LoggerFactory.getLogger(SampleLogging.class);

    public static void main(String[] args) {

       String logLevel = args[0];

       if (logLevel == "FATAL") {
           LOG.error("debugging at FATAL level");
       } else if (logLevel == "ERROR") {
           LOG.error("debugging at ERROR level");
       } else if (logLevel == "INFO") {
           LOG.error("debugging at INFO level");
       } else if (logLevel == "DEBUG") {
           LOG.error("debugging at DEBUG level");
       } else {
           LOG.error("debugging at TRACE level");
       }
    }
}
