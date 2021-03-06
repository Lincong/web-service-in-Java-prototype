package com.chaindo.resources;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.glassfish.jersey.server.ContainerRequest;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

@Provider
@Priority(Priorities.AUTHENTICATION)    // priority level of the filter
public class ResourceFilter implements ContainerRequestFilter {

    static Logger logger = Logger.getLogger(ResourceFilter.class);

    public void filter(ContainerRequestContext ctx) {
        String method = ctx.getMethod().toLowerCase();
        String path = ((ContainerRequest) ctx).getPath(true).toLowerCase();
        // 过滤非验证资源，如授权登录、注册等静态资源
        logger.info("In filter");
        logger.info("method: " + method);
        logger.info("path: " + path);

        if ("post".equals(method) && "/authentication/login".equals(path)) {
            // ctx.setSecurityContext(new SecurityContextAuthorizer(uriInfo,new AuthorPricinple(name), new String[]{"user"}));
            logger.info("Not block the login request");
            return;
        }

        Response response = null;
        final String authHeader = ctx.getHeaderString("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response = Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Missing or invalid Authorization header").build();
        } else {
            final String token = authHeader.substring(7);
            try {
                Claims jwts = Jwts.parser()
                        .setSigningKey("THIS_SECURITY_KEY")
                        .parseClaimsJws(token)
                        .getBody();

                // TODO
                // 根据username查询是否存在此用户
                 String username = jwts.getSubject();
                 if(!UserLoggedIn.userLoggedIn(username)){
                     logger.error("user with username " + username + "does not exist");
                     throw new Exception();
                 }
                // 判断token版本是否一致
                // String version = jwts.getId();
            } catch (ExpiredJwtException e) {
                response = Response.status(Response.Status.FORBIDDEN).entity("Token is expired").build();
            } catch (Exception e) {
                response = Response.status(Response.Status.FORBIDDEN).entity("Token is invalid").build();
            }
        }
        ctx.abortWith(response);
    }
}
