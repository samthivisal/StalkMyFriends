package com.dant.dao;

import org.mongodb.morphia.Datastore;

/**
 * Created by nguyen on 30/05/2017.
 */
public class FriendsDAO {
    private final Datastore datastore = DatastoreInit.getDatastore();

    public boolean addContact(){
        return true;
    }
}
