package com.chaindo.resources;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Path("authentication")
public class AuthenticationResource {

    static Logger logger = Logger.getLogger(AuthenticationResource.class);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authLogin(UserLogInInfo user) {
        logger.info("User is trying to log in");
        String username = user.getUsername();
        String password = user.getPassword();

        // TODO: get rid of the hard-coded username and password
        if ("admin".equals(username) && "admin".equals(password)) {
            long currentTimeMillis = System.currentTimeMillis();
            Date now = new Date(currentTimeMillis);
            Date expireTime = new Date(currentTimeMillis + 8640000);   // expire in 2.4 hours
            System.out.println(now + " ~ " + expireTime);

            String jwt = Jwts.builder()
                    .setId("1") // version
                    .setAudience("user")    // role
                    .signWith(SignatureAlgorithm.HS256, "THIS_SECURITY_KEY")
                    .setSubject(username)   // tile
                    .setIssuedAt(now)       // issue time
                    .setExpiration(expireTime)  // expire time
                    .claim("email", "abc@gmail.com") // custom JWT Claims
                    .compact();

            UserLoggedIn.logInUser(username);

            return Response.status(Response.Status.CREATED).entity("{\"jwt\":\"" + jwt + "\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
