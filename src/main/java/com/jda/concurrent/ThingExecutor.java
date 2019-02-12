package com.jda.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThingExecutor {

    public static void main (String... args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] hostList = { "http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
                "http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://en.wikipedia.org" };

        for (int i = 0; i < hostList.length; i++) {

            Runnable processor = new ThingProcessor(hostList[i]);
            executor.execute(processor);
        }
        executor.shutdown();
    }
}
