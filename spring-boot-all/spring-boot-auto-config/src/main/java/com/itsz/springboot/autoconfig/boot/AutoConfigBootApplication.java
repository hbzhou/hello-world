package com.itsz.springboot.autoconfig.boot;

import com.itsz.springboot.autoconfig.config.SayHelloConfiguration;
import com.itsz.springboot.autoconfig.service.HelloWorldService;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(
        scanBasePackages = {
                "com.itsz.springboot.autoconfig.config"
        }
)
//@EnableSayHello
public class AutoConfigBootApplication {

    public static void main(String[] args) {
      SpringApplication springApplication = new SpringApplication(AutoConfigBootApplication.class);
      springApplication.setBannerMode(Banner.Mode.OFF);
      springApplication.run(args);

        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(SayHelloConfiguration.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(HelloWorldService.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
