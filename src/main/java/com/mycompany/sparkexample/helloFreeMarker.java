/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sparkexample;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author willy
 */
public class helloFreeMarker {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(helloFreeMarker.class, "/");

        StringWriter write = new StringWriter();

        try {
            Template template = configuration.getTemplate("hello.ftl");

            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Willy");

            template.process(helloMap, write);

            System.out.println(write);

        } catch (Exception ex) {

            System.out.println(ex);
        }


    }
}
