package com.dant.app;

import com.dant.Constant;
import com.dant.entity.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.MongoClient;
import org.apache.commons.io.FileUtils;
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

    public Account accountInfoByToken(String token) {
        Account result = datastore.find(Account.class).field("token").equal(token).get();
        return result;
    }

    public List<Account> accountInfoByFistname(String firstName) {
        ArrayList<Account> result = new
                ArrayList<>(datastore.find(Account.class).field("firstName").equal(firstName).asList());
            return result;
    }

    public List<Account> accountInfoByLastname(String lastName) {
        ArrayList<Account> result = new
                ArrayList<>(datastore.find(Account.class).field("lastName").equal(lastName).asList());
            return result;
    }

    public Account accountInfoByPhonenumber(String phoneNumber) {
        Account result = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
            return result;
    }

    public Account accountConnection(String phoneNumber, String password) {
        Account result = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        return result;
    }

    public static void main(String[] args) {
        GetData gd = new GetData();
//        gd.accountInfoByToken("591189fa2ff84c31c0917700");
//        gd.accountInfoByFistname("k");
//        File output = new File("cache/AccountOutput.json");
//        System.out.println(output.getAbsolutePath());
//        File output2 = new File("cache/AccountListOutput.json");
//        try {
//            System.out.println(FileUtils.readFileToString(new GetData().accountConnection("1234567890","test"),"UTF-8"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
