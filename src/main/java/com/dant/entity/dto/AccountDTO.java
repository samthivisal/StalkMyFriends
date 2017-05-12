package com.dant.entity.dto;

import com.dant.entity.Position;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by OPERMAN Timoty on 10/05/2017.
 */
public class AccountDTO implements Serializable {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public String password;

    public String getPassword() {
        return password;
    }
}
