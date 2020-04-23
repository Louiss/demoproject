package com.lxc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.lxc.study"})
@SpringBootApplication
public class DemoprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoprojectApplication.class, args);
    }

}
