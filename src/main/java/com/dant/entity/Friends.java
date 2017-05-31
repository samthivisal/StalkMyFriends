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

    @Expose
    private String number1;

    @Expose
    private String number2;

    @Expose
    private boolean accepted;

    public Friends(){}

    public Friends(String number1, String number2){
        this.number1 = number1;
        this.number2 = number2;
        accepted = false;
    }

    public String getAccount1(){
        return number1;
    }

    public String getAccount2(){
        return number2;
    }

    public boolean isAccepted(){
        return accepted;
    }

    public void accept(boolean accept){
        accepted = accept;
    }

    public String toString(){
        return number1 +"\n" +number2 +"\n" +accepted;
    }

}
