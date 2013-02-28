package com.mycompany.sparkexample;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class App {

    public static void main(String[] args) {
        Spark.get(new Route ("/") {

            @Override
            public Object handle(Request rqst, Response rspns) {
                return "Hello World!";
            }
        });
        
    }
}
