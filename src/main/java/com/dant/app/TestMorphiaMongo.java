package com.dant.app;

import com.dant.entity.Account;
import com.dant.entity.Position;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */
public class TestMorphiaMongo {
    public static void main(String[] args){
//        MongoClient m = new MongoClient("127.0.0.1",27017);
//        Datastore datastore = new Morphia().map(Account.class).createDatastore(m,"Usertest");
        Account test = new Account("K","2000","1234567890","k200@gmail.com","test",new Position(123.12,456.98),"toto12345");
//        Account test1 = new Account("KK","2001","1234567890","k200@gmail.com","test",new Position(123.12,456.98),"toto12345");
//        Account test2 = new Account("KKK","2002","1234567890","k200@gmail.com","test",new Position(123.12,456.98),"toto12345");
//        datastore.save(test);
//        datastore.save(test1);
//        datastore.save(test2);
//        m.close();
        System.out.println(test);
    }
}
