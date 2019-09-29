package com.itsz.springboot.autoconfig.annotation;

import com.itsz.springboot.autoconfig.selector.HelloWorldImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import({SayHelloConfiguration.class})
@Import({HelloWorldImportSelector.class})
public @interface EnableSayHello {
}
