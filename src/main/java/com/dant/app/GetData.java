package com.dant.app;

import com.dant.Constant;
import com.dant.entity.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.FindOptions;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
public class GetData {
    public static MongoClient clientMongo;
    public static Datastore datastore;

    public GetData() {
        clientMongo = new MongoClient(Constant.LOCALHOST.getAdress(), Constant.LOCALHOST.getPort());
        datastore = new Morphia().map(Account.class).createDatastore(clientMongo, Constant.LOCALHOST.getDbName());
    }

    public File accountInfoByToken(String token) {
        Account result = datastore.find(Account.class).field("token").equal(token).get();
        if (result == null)
            return null;
        try {
            return result.toJSON();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public File accountInfoByFistname(String firstName) {
        ArrayList<Account> result = new
                ArrayList<>(datastore.find(Account.class).field("firstName").equal(firstName).asList());
        if (result == null)
            return null;
        try {
            return Account.listToJSON(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public File accountInfoByLastname(String lastName) {
        ArrayList<Account> result = new
                ArrayList<>(datastore.find(Account.class).field("lastName").equal(lastName).asList());
        if (result == null)
            return null;
        try {
            return Account.listToJSON(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public File accountInfoByPhonenumber(String phoneNumber) {
        Account result = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        if (result == null)
            return null;
        try {
            return result.toJSON();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public File accountConnection(String phoneNumber, String password) {
        Account result = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        if (result == null)
            return null;
        if (result.getPassword().equals(password)) {
            try {
                return result.toJSON();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else return null;

    }

    public File friendlist(String token) {
        Account result = datastore.find(Account.class).field("token").equal(token).get();
        if (result == null)
            return null;
        try {
            return result.toJSON();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public static void main(String[] args) {
        GetData gd = new GetData();
//        gd.accountInfoByToken("591189fa2ff84c31c0917700");
        gd.accountInfoByFistname("k");
//        File output = new File("cache/AccountOutput.json");
//        System.out.println(output.getAbsolutePath());
//        File output2 = new File("cache/AccountListOutput.json");
    }

}
