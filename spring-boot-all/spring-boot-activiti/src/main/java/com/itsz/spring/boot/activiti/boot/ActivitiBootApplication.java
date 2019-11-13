package com.itsz.spring.boot.activiti.boot;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
},scanBasePackages = {
        "com.itsz.spring.boot.activiti.boot",
        "com.itsz.spring.boot.activiti.controller",
        "com.itsz.spring.boot.activiti.service"
}
)
public class ActivitiBootApplication implements CommandLineRunner {

    private static final String PROCESS_DEFINE_KEY = "vacationProcess";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    public static void main(String[] args) {
        SpringApplication.run(ActivitiBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
