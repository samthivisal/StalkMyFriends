package com.dant.controller;

import com.dant.dao.AccountDAO;
import com.dant.entity.Account;
import com.dant.entity.dto.AccountDTO;
import com.dant.entity.dto.AccountLoginDTO;
import com.dant.entity.dto.PositionDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */

@Path("/a")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    @POST
    @Path("/connect")
    public Account connect(AccountLoginDTO accountDTO) {
        return new AccountDAO().connection(accountDTO.phone, accountDTO.password);
    }

    @POST
    @Path("/create")
    public Account create(AccountDTO accountDTO) {
        return new AccountDAO().create(accountDTO);
    }

    @POST
    @Path("/delete")
    public void delete(AccountLoginDTO accountLoginDTO) {
        new AccountDAO().delete(accountLoginDTO.phone,accountLoginDTO.password);
    }

    @POST
    @Path("/updateLocation")
    public void updateLocation(PositionDTO positionDTO) {
        new AccountDAO().updateLocation(positionDTO.token,positionDTO.location);
    }



}
