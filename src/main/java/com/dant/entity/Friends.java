package com.dant.entity;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by nguyen on 30/05/2017.
 */

@Entity
public class Friends {

    @Id
    private ObjectId id;

    @Reference
    private Account account1;

    @Reference
    private Account account2;

    @Expose
    private boolean accepted;

    public Friends(Account account1, Account account2){
        this.account1 = account1;
        this.account2 = account2;
        accepted = false;
    }

    public Account getAccount1(){
        return account1;
    }

    public Account getAccount2(){
        return account2;
    }

    public boolean isAccepted(){
        return accepted;
    }

    public void accept(boolean accept){
        accepted = accept;
    }

}
