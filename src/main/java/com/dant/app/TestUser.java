package com.dant.app;

import com.dant.Constant;
import com.dant.DAO.AccountDAO;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/{user}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestUser {
    MongoClient mongo ;
    Morphia morphia ;
    AccountDAO dao ;

    public TestUser() {
         this.mongo =new MongoClient(Constant.LOCALHOST.getAdress(),Constant.LOCALHOST.getPort());
         this.morphia = new Morphia();
         this.dao = new AccountDAO(mongo,morphia,Constant.LOCALHOST.getDbName());
    }

    @GET
    @Path("/status")
    @Produces("text/xml")
    public String getUser(@PathParam("user") String userName) {
        if (userName.equals("admin")) {
            return dao.getAccountByFirstName("K").toString();
        }
        return "hello world";
    }
}
