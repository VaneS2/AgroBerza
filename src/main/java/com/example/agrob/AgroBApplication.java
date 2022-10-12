package com.example.agrob;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Array;
import java.util.ArrayList;

@SpringBootApplication
public class AgroBApplication {

    public static void main(String[] args) {

      ConfigurableApplicationContext ap=  SpringApplication.run(AgroBApplication.class, args);
        for(String p: ap.getBeanDefinitionNames())
        {
            System.out.println(p);
        }



    }

}
