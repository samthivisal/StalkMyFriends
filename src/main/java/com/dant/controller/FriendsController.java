package com.dant.controller;

import com.dant.dao.FriendsDAO;
import com.dant.entity.Account;
import com.dant.entity.Friends;
import com.dant.entity.dto.AccountDTO;
import com.dant.entity.dto.FriendsDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by nguye on 30/05/2017.
 */

@Path("/api/friends")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FriendsController {

    @POST
    @Path("/add")
    public Response add(Friends friends){
        new FriendsDAO().addContact(friends.getAccount1(), friends.getAccount2());
        return Response.status(200).build();
    }

    @POST
    @Path("/accept")
    public Response accept(Friends friends){
        new FriendsDAO().accept(friends.getAccount1(), friends.getAccount2(), friends.isAccepted());
        return Response.status(200).build();
    }

    @POST
    @Path("/list")
    public List<AccountDTO> list(Friends friends){
        return new FriendsDAO().getFriends(friends.getAccount1());
    }

}
