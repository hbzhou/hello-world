package com.itsz.java.webservice;


import cn.itsz.HelloWorldService;
import cn.itsz.HelloWorldService_Service;

public class WebServiceClient {

    public static void main(String[] args) {
        /**
         * <service name="helloWorldService">
         * 获得服务名称
         */
        HelloWorldService_Service mywebService = new HelloWorldService_Service();

        /**
         * <port name="HelloWorldServicePort" binding="tns:HelloWorldServicePortBinding">
         */
        HelloWorldService helloWorldService = mywebService.getHelloWorldServicePort();

        /**
         * 调用方法
         */
        System.out.println(helloWorldService.sayHello("webService"));

    }
}
