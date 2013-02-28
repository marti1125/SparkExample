package com.mycompany.sparkexample;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.Arrays;
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
public class PostFavorityFruit {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(PostFavorityFruit.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request rqst, Response rspns) {

                try {

                    Map<String, Object> fruitsMap = new HashMap<String, Object>();
                    fruitsMap.put("fruits", Arrays.asList("apple", "banana", "peach", "orange"));

                    Template template = configuration.getTemplate("fruitpicker.ftl");

                    StringWriter writer = new StringWriter();

                    template.process(fruitsMap, writer);

                    return writer;

                } catch (Exception ex) {
                    halt(500);
                    return null;
                }

            }
        });

        Spark.post(new Route("/favority_fruit") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                final String fruit = rqst.queryParams("fruit");
                if (fruit == null) {
                    return "Why don't you pick one?";
                } else {
                    return "Your favority fruit is: " + fruit;
                }

            }
        });

    }
}
