package com.dant.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by OPERMAN Timoty on 04/05/2017.
 */
public class Position {

    private double latitude;
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
        return "Position{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public JsonElement toJSON() {
        JsonObject result = new JsonObject();
        result.add("latitude", new JsonPrimitive(this.getLatitude()));
        result.add("longitude", new JsonPrimitive(this.getLongitude()));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Position(3.56,5.65).toJSON());
    }
}
