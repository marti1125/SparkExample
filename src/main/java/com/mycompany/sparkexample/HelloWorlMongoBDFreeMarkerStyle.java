package com.mycompany.sparkexample;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author willy
 */
public class HelloWorlMongoBDFreeMarkerStyle {
    
    public static void main(String[] args) throws UnknownHostException {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorlMongoBDFreeMarkerStyle.class, "/");
        
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));        
        DB database = client.getDB("course");        
        final DBCollection collection = database.getCollection("hello");

        Spark.get(new Route("/mongodb") {
            @Override
            public Object handle(Request rqst, Response rspns) {

                StringWriter writer = new StringWriter();

                try {
                    Template template = configuration.getTemplate("hello.ftl");

                    DBObject document = collection.findOne();

                    template.process(document, writer);                    

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return writer;
            }
        });
    }
    
}
