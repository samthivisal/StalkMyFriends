package com.dant.app;

import com.dant.Constant;
import com.dant.DAO.AccountDAO;
import com.dant.entity.Account;
import com.mongodb.MongoClient;
import org.apache.commons.io.FileUtils;
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

    @POST
    @Path("/connect/user={phone}&password={password}")
    @Produces("text/html")
    public String connect(@PathParam("phone") String phone, @PathParam("password") String password) {
//        try {
//            return FileUtils.readFileToString(new GetData().accountConnection(phone,password),"UTF-8");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "lololol";
    }

    @GET
    @Path("/{user}/status")
    @Produces("text/html")
    public String getUser(@PathParam("user") String userName) {
        if (userName.equals("admin")) {
            return "yolo" ;
        }
        try {
            return FileUtils.readFileToString(new GetData().accountInfoByFistname(userName),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }


}
