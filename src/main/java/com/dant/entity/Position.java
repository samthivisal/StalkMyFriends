package com.dant.entity;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */
public class Position {
    @Expose
    private double latitude;
    @Expose
    private double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Position[" + latitude +',' + longitude +']';
    }

}
