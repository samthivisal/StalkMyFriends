package com.dant.dao;

import com.dant.Constant;
import com.dant.entity.Account;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
class DatastoreInit {

    public static Datastore getDatastore() {
        return Init.datastore;
    }

    private DatastoreInit() {
    }

    private static class Init {

        private static final Datastore datastore = init();

        private static Datastore init() {
            MongoClient clientMongo = new MongoClient(Constant.LOCALHOST.getAdress(), Constant.LOCALHOST.getPort());
            return new Morphia().map(Account.class).createDatastore(clientMongo, Constant.LOCALHOST.getDbName());
        }

    }
}
