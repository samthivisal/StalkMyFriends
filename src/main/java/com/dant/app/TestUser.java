package com.dant.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/users/{user}{password}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestUser {
    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("user") String userName,@PathParam("password") String password) {
        return  userName + password;
    }
}
