package com.itsz.java.webservice.service;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "helloWorldService", targetNamespace = "http://www.itsz.cn")
public class HelloWorldService {

    public String sayHello(@WebParam(name="name") String name){
        return  "hello: " + name;
    }

}
