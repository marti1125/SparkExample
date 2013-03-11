package com.mycompany.sparkexample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

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
        DBCollection collection = courseDB.getCollection("findCriteriaTest");

        collection.drop();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            collection.insert(new BasicDBObject("x", random.nextInt(2))
                    .append("y", random.nextInt(100))
                    .append("z", random.nextInt(1000)));
        }

        QueryBuilder builder = new QueryBuilder().start("x").is(0)
                .and("y").greaterThan(10).lessThan(70);

        DBObject query = new BasicDBObject("x", 0)
                .append("y", new BasicDBObject("$gt", 10)
                .append("$lt", 90));

        /*DBObject doc = new BasicDBObject("_id", new ObjectId()).append("x", 1);
         DBObject doc2 = new BasicDBObject().append("x", 2);

         System.out.println(doc); 

         collection.insert(Arrays.asList(doc, doc2));

         System.out.println(doc);*/

        /*System.out.println("Find one: ");
         DBObject one = collection.findOne();
         System.out.println(one);*/

        System.out.println("\nCount: ");
        long count = collection.count(builder.get());
        System.out.println(count);

        System.out.println("\nFind all: ");
        DBCursor cursor = collection.find(query, new BasicDBObject("y", true)
                .append("_id", 0));

        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }

    }
}
