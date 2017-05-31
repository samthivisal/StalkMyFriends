package com.dant.controller;

import com.dant.dao.AccountDAO;
import com.dant.entity.Account;
import com.dant.entity.dto.AccountDTO;
import com.dant.entity.dto.PositionDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    @POST
    @Path("/connect")
    public AccountDTO connect(Account account) {
         return new AccountDAO().connection(account.getPhoneNumber(), account.getPassword());
    }

    @POST
    @Path("/create")
    public AccountDTO create(Account account) {
        return new AccountDAO().create(account);
    }

    @POST
    @Path("/logout")
    public Response logOut(Account account) {
        new AccountDAO().logOut(account.getPhoneNumber());
        return Response.status(200).build();
    }


    @DELETE
    @Path("/delete")
    public Response delete(Account account) {
        new AccountDAO().delete(account.getPhoneNumber(),account.getPassword());
        return Response.status(200).build();
    }

    @POST
    @Path("/updateLocation")
    public Response updateLocation(PositionDTO positionDTO) {
        new AccountDAO().updateLocation(positionDTO.account.getToken(),positionDTO.location);
        return Response.status(200).build();
    }

}
