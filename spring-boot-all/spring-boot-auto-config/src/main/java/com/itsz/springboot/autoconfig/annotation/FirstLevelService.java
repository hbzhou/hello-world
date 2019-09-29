package com.itsz.springboot.autoconfig.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME )
@Documented
@Service
public @interface FirstLevelService {

    String value() default "";
}
