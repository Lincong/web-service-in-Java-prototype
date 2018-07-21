package com.chaindo.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("example")
public class ExampleRequest {

    @Path("{example}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String example(@PathParam("example") String example) {
       Logger.getLogger(getClass()).info("Working!");
       return example + " hahahahhahah";
    }

}