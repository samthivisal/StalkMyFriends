package com.dant;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
public enum Constant {
    LOCALHOST ("127.0.0.1" ,27017,"smfDb");

    private final String Adress;
    private final int port;
    private final String dbName;

    Constant(String adress, int port, String dbName) {
        Adress = adress;
        this.port = port;
        this.dbName = dbName;
    }

    public String getAdress() {
        return Adress;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
}
