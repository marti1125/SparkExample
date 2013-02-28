/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sparkexample;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author willy
 */
public class Routes {
    
    public static void main(String[] args) {

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return "welcome World!";
            }
        });
        
        Spark.get(new Route("/test") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return "This is a page test \n";
            }
        });
        
        Spark.get(new Route("/echo/:thing") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return rqst.params(":thing");
            }
        });
        
    }
    
}
