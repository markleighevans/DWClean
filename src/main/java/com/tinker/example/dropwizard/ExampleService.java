package com.tinker.example.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.tinker.example.dropwizard.config.ExampleServiceConfiguration;
import com.tinker.example.dropwizard.hello.HelloResource;

public class ExampleService extends Service<ExampleServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExampleServiceConfiguration> bootstrap) {
        bootstrap.setName("dropwizard-example");
    }

    @Override
    public void run(ExampleServiceConfiguration conf, Environment env) throws Exception {
        env.addResource(new HelloResource(conf.getMessages()));
    }

}
