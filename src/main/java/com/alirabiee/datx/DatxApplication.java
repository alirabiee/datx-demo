package com.alirabiee.datx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity( securedEnabled = true )
public class DatxApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run( DatxApplication.class, args );
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources( DatxApplication.class );
    }
}
