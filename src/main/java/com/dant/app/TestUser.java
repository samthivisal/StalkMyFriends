package com.dant.app;

import com.dant.Constant;
import com.dant.DAO.AccountDAO;
import com.dant.entity.Account;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/u/")
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
    @Path("/{user}/status")
    @Produces("text/xml")
    public String getUser(@PathParam("user") String userName) {
        if (userName.equals("admin")) {
            return dao.getAccountByFirstName("K").toString();
        }
        return "hello world";
    }
    @POST
    @Path("/connect/user={phone}&password={password}")
    @Produces("text/json")
    public File connect(@PathParam("phone") String phone, @PathParam("password") String password) {
        return new GetData().accountConnection(phone,password);

    }

}
