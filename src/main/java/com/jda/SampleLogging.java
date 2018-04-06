package com.jda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleLogging {

    private static Logger LOGGER = LoggerFactory.getLogger(SampleLogging.class);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            if (i % 2 == 0)
                LOGGER.info("Hello {}", i);
            else
                LOGGER.debug("I am on index {}", i);
            
    }
}
