package com.dant.entity;

import com.dant.entity.dto.AccountDTO;
import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Account implements Serializable {

    @Id
    private ObjectId id;

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    @Indexed(options = @IndexOptions(unique = true))
    private String phoneNumber;
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private Position location;
    @Expose
    private String token;

    @Expose
    private Date updated;

    @Expose
    @Reference
    private List<Account> friends;

    /*public Account(AccountDTO accountDTO){
        this.firstName = accountDTO.firstName;
        this.lastName = accountDTO.lastName;
        this.phoneNumber = accountDTO.phoneNumber;
        this.email = accountDTO.email;
        this.password = accountDTO.getPassword();
        this.location = new Position();
        this.token = new ObjectId().toString();
        this.updated = new Date();
    }*/
    public Account(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.location = null;
        this.token = new ObjectId().toString();
        this.updated = new Date();
        this.friends = new ArrayList<Account>();
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Position getLocation() {
        return location;
    }

    public void setLocation(Position location) {
        this.location = location;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Account> getFriends() {
        return friends;
    }

    public void setFriends(List<Account> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return email.equals(account.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return phoneNumber + password + token;
    }
}
