package com.mycompany.sparkexample;

import com.mongodb.BasicDBList;
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
public class SortSkipLimit {

    public static void main(String[] args) throws UnknownHostException {

        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection list = courseDB.getCollection("DotNotationTest");

        list.drop();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.insert(new BasicDBObject("_id", i)
                    .append("start",
                    new BasicDBObject("x", random.nextInt(2))
                    .append("y", random.nextInt(90) + 10))
                    .append("end",
                    new BasicDBObject("x", random.nextInt(2))
                    .append("y", random.nextInt(90) + 10)));
        }

        DBCursor cursor = list.find().sort(
                new BasicDBObject("start.x", 1).append("start.y", -1)
                ).skip(2).limit(10);

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
