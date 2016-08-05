package com.alirabiee.datx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity( securedEnabled = false )
public class DatxTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run( DatxTestApplication.class, args );
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources( DatxTestApplication.class );
    }
}
