package com.tinker.example.dropwizard.hello;

import com.tinker.example.dropwizard.config.MessagesConfiguration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path(value = "/hello")
public class HelloResource {
    private String Tally = "";
    private final MessagesConfiguration conf;

    @Inject
    public HelloResource(final MessagesConfiguration conf) {
        this.conf = conf;
    }

    @GET
    public String sayHello() {
        return conf.getHello();
    }

    @GET
    @Path("/List")
    public String sayTinkerMessage() {
        //return conf.getTinkerMessage();
        return this.Tally;
    }


    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public String create(@FormParam("forename") String param1,
                         @FormParam("surname") String param2,
                         @HeaderParam("X-Auth-Token") String token,
                         @Context HttpServletRequest request) {
        String response = "";
        response += "param1=" + param1 + "<BR>";
        response += "param2=" + param2 + "<BR>";
        response += "Header Token=" + token + "<BR>";
        response += "ip = " + request.getRemoteAddr() + "<BR>";
        response += "Browser = " + request.getHeader("User-Agent") + "<BR>";
        Tally += response;
        return response;

    }

}