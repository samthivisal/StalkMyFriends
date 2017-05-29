package com.dant.entity.dto;

import com.dant.entity.Position;
import com.dant.entity.Account;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by OPERMAN Timoty on 10/05/2017.
 */
public class AccountDTO implements Serializable {
    @Expose
    public String firstName;
    @Expose
    public String lastName;
    @Expose
    public String phoneNumber;
    @Expose
    public String token;

    public AccountDTO(Account account){
        firstName = account.getFirstName();
        lastName = account.getLastName();
        phoneNumber = account.getPhoneNumber();
        token = account.getToken();
    }

    public String getToken(){   return token;}

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
