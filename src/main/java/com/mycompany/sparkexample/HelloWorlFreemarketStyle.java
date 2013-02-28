package com.mycompany.sparkexample;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
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
public class HelloWorlFreemarketStyle {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorlFreemarketStyle.class, "/");

        Spark.get(new Route("/welcome") {
            @Override
            public Object handle(Request rqst, Response rspns) {

                StringWriter writer = new StringWriter();

                try {
                    Template template = configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Willy");

                    template.process(helloMap, writer);                    

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return writer;
            }
        });
    }
}
