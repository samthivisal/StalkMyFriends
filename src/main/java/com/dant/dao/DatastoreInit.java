package com.dant.dao;

import com.dant.Constant;
import com.dant.entity.Account;
import com.dant.entity.Position;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.HashSet;
import java.util.Set;

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
            Set<Class> sets = new HashSet<>(1);
            sets.add(Account.class);
            sets.add(Position.class);
            return new Morphia(sets).createDatastore(clientMongo, Constant.LOCALHOST.getDbName());
        }

    }
}
