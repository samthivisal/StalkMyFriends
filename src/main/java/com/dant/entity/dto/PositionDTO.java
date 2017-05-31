package com.dant.entity.dto;

import com.dant.entity.Account;
import com.dant.entity.Position;
import com.google.gson.annotations.Expose;

/**
 * Created by OPERMAN Timoty on 11/05/2017.
 */
public class PositionDTO {
    @Expose
    public Account account;
    @Expose
    public Position location;

    public PositionDTO(Account account, Position location){
        this.account = account;
        this.location = location;
    }

    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Position getLocation(){return location;}

    public void setLocation(Position location){
        this.location = location;
    }
}