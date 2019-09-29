package com.itsz.springboot.autoconfig.selector;

import com.itsz.springboot.autoconfig.config.SayHelloConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {SayHelloConfiguration.class.getName()};
    }
}
