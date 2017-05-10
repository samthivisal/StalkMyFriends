package com.dant.DAO;

import com.dant.Constant;
import com.dant.entity.Account;
import com.dant.entity.Position;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
public class AccountDAO extends BasicDAO<Account, String> {
    //TODO: gestion de la base de donnée

    public AccountDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
    }

    public static void dataInit(){
        MongoClient mongo = new MongoClient(Constant.LOCALHOST.getAdress(),Constant.LOCALHOST.getPort());
        String dbName = Constant.LOCALHOST.getDbName();
        Datastore datastore = new Morphia().map(Account.class).createDatastore(mongo,dbName);
        mongo.dropDatabase(dbName);
        Account test = new Account("K","2000","1234567","k200@gmail.com","test",new Position(123.12,456.98),new ObjectId().toString());
        Account test1 = new Account("KK","2001","12345678","k200@gmail.com","test",new Position(123.12,456.98),new ObjectId().toString());
        Account test2 = new Account("KK","2002","1234567890","k200@gmail.com","test",new Position(123.12,456.98),new ObjectId().toString());
        datastore.save(test);
        datastore.save(test1);
        datastore.save(test2);
        mongo.close();

    }

    public List<Account> getAccountByFirstName(String partName){
        MongoClient mongo = new MongoClient(Constant.LOCALHOST.getAdress(),Constant.LOCALHOST.getPort());
        String dbName = Constant.LOCALHOST.getDbName();

        Datastore datastore = new Morphia().map(Account.class).createDatastore(mongo,dbName);

        Query<Account> query = datastore.createQuery(Account.class);
        query.and(
                query.criteria("firstName").contains(partName)
        );

        QueryResults<Account> retrievedAccounts =  this.find(query);
        List<Account> result =new ArrayList<>();
        for( Account find : retrievedAccounts)
            result.add(find);
        return result;
    }



    public static void main(String[] args) {
        MongoClient mongo =new MongoClient(Constant.LOCALHOST.getAdress(),Constant.LOCALHOST.getPort());
        Morphia morphia = new Morphia();
        AccountDAO dao = new AccountDAO(mongo,morphia,Constant.LOCALHOST.getDbName());
        dao.dataInit();
//        System.out.println(dao.getAccountByFirstName("K"));


    }
}
