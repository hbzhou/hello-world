package com.itsz.springboot.aop.boot.controller;

import com.itsz.springboot.aop.boot.annotation.SystemLog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Tester", tags = "TESTER")
public class TesterController {

    @SystemLog("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) {
    }

    @SystemLog("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @SystemLog("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) {
    }
}
