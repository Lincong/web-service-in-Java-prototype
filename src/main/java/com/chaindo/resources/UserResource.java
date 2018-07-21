package com.chaindo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.chaindo.model.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("/{userId}")
    public User getUser(@PathParam("userId") String userId) {
        User user = new User(12, "LLC profile", "Lincong", "Li");
        return user;
    }

}
