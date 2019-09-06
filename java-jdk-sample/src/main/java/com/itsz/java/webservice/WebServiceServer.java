package com.itsz.java.webservice;

import javax.xml.ws.Endpoint;

import com.itsz.java.webservice.service.HelloWorldService;

public class WebServiceServer {

   //

    /**
     * wsimport -b "1.xml" -clientjar hello-world-ws-client-1.0.jar  http://10.200.6.15:456/helloWord?wsdl
     *  生成客户端jar
     * @param args
     */

    public static void main(String[] args) {
            Endpoint.publish("http://10.200.6.15:456/helloWord", new HelloWorldService());

    }
}
