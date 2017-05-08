package com.dant.app;

import com.dant.entity.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
public abstract class GetData {

    public static File userInfo(String token) {
        File userInfo = new File("Output.json");
        MongoClient m = new MongoClient("127.0.0.1", 27017);
        Datastore datastore = new Morphia().map(Account.class).createDatastore(m, "Usertest");
        Account result = datastore.find(Account.class).field("token").equal(token).get();
        if (result != null) {
            System.out.println(result);
            try (Writer writer = new FileWriter(userInfo)) {
                Gson gson = new GsonBuilder().create();
                gson.toJson(result, writer);
            } catch (Exception e) {
                System.out.println("could make writter");
            }
        }
        else System.out.println("fail");

        return userInfo;
    }

    public static void main(String[] args) {
        GetData.userInfo("591094ee2ff84c09f85101ee");
    }

}
