package com.itsz.email.config;

import com.itsz.springboot.email.config.StatusConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "com.itsz.springboot.email.config")
@SpringBootTest
public class StatusConfigTest {

    @Autowired
    private StatusConfig statusConfig;

    @Test
    public void testStatusConfigMap() {
        Map<String, String> statusMap = statusConfig.getMaps();
        statusMap.forEach((key, value) -> {
            System.out.println(key + "------" + value);
        });
    }

    @Test
    public void testStatusConfigList() {
        List<String> topics = statusConfig.getTopics();
        for (String topic : topics) {
            System.out.println(topic);
        }
    }


}
