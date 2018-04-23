package com.jda.application;

import com.jda.resource.PersonResource;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        super(PersonResource.class);
    }
}
