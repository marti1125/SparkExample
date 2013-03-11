package com.mycompany.sparkexample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author willy
 */
public class InsertTest {

    public static void main(String[] args) throws UnknownHostException {

        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection collection = courseDB.getCollection("insertTest");

        collection.drop();
        
        for(int i = 0; i < 10; i++){
            collection.insert(new BasicDBObject("x", new Random().nextInt(100)));
        }

        /*DBObject doc = new BasicDBObject("_id", new ObjectId()).append("x", 1);
        DBObject doc2 = new BasicDBObject().append("x", 2);

        System.out.println(doc); 

        collection.insert(Arrays.asList(doc, doc2));

        System.out.println(doc);*/

        System.out.println("Find one: ");
        DBObject one = collection.findOne();
        System.out.println(one);
        
        System.out.println("\nFind all: ");
        DBCursor cursor = collection.find();
        
        try {
            while(cursor.hasNext()){
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }
        
        System.out.println("\nCount: ");
        long count = collection.count();
        System.out.println(count);
        
    }
}
