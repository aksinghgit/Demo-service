	package com.demo;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
 * @author amritesh
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.demo")
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
}