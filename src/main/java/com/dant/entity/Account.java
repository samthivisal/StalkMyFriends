package com.dant.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;


@Entity
public class Account implements Serializable {
    @Id
    @Expose
    private String id;

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phoneNumber;
    @Expose
    private String email;

    private String password;
    @Expose
    private Position location;
    @Expose
    private String token;

    @Expose
    private long updated;

    public Account(String firstName, String lastName, String phoneNumber, String email, String password, Position location, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.location = location;
        this.token = token;
        this.updated = System.currentTimeMillis();
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
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
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "********" + '\'' +
                ", location=" + location +
                ", token='" + token + '\'' +
                ", updated=" + updated +
                '}';
    }

    public File toJSON() {
        File output = new File("cache/AccountOutput.json");
        try (Writer writer = new FileWriter(output)) {
            System.out.println("list to Json ok");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            gson.toJson(this, writer);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return output;
    }

    public static File listToJSON(List<Account> listAccount){
        File output = new File("cache/AccountListOutput.json");
        try (Writer writer = new FileWriter(output)) {
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            gson.toJson(listAccount, writer);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return output;
    }


}
