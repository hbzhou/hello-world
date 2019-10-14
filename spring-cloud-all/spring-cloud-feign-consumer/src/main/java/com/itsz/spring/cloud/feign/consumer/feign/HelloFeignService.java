package com.itsz.spring.cloud.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-feign-provider",fallback = HystrixHelloServiceFallback.class)
public interface HelloFeignService {

    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);
}
