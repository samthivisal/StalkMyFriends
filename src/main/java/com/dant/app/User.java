package com.dant.app;

import com.dant.entity.Account;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/u/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class User {

    @POST
    @Path("/connect")
    public Account connect(@QueryParam("phone") String phone, @QueryParam("password") String password) {
        return new GetData().accountConnection(phone, password);
    }

}
