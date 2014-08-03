package com.tinker.example.dropwizard.config;

import javax.validation.constraints.NotNull;

public class MessagesConfiguration {

    @NotNull
    private String hello;
    private String TinkerMessage;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getTinkerMessage() {
        return TinkerMessage;
    }

    public void setTinkerMessage(String TinkerMessage) {
        this.TinkerMessage = TinkerMessage;
    }
}
