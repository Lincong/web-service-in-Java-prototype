package com.chaindo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.chaindo.model.User;
import com.chaindo.database.*;
import org.hibernate.Session;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("/{userId}")
    public User getUser(@PathParam("userId") String userId) {
        User user = new User(12, "LLC profile", "Lincong", "Li");

        UserTest person = new UserTest();
        person.setId(1);
        person.setName("Concretepage");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        return user;
    }

}
