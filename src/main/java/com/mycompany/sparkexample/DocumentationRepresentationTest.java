package com.mycompany.sparkexample;

import com.mongodb.BasicDBObject;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author willy
 */
public class DocumentationRepresentationTest {
    
    public static void main(String[] args) {

        BasicDBObject doc = new BasicDBObject();
        doc.put("userName","admin");
        doc.put("brithDate", new Date(234832423));
        doc.put("programmer",true);
        doc.put("age",8);
        doc.put("languages", Arrays.asList("Java", "C++"));
        doc.put("address",new BasicDBObject("stree","20 Main")
                .append("town", "Westfield")
                .append("zip","56789"));
        
    }
    
}
