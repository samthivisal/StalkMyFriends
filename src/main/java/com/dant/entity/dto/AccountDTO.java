package com.dant.entity.dto;

import com.dant.entity.Position;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by OPERMAN Timoty on 10/05/2017.
 */
public class AccountDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
