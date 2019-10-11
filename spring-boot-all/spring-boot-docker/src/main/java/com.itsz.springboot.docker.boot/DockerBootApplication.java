package com.itsz.springboot.docker.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class DockerBootApplication implements CommandLineRunner {

    @Autowired
    RedisTemplate  redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DockerBootApplication.class,args);

    }

    @Override
    public void run(String... args) throws Exception {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k1","v1");
        Object k1 = ops.get("k1");
        System.out.println(k1);

        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("k2","jeremygilbert");
        String k2 = ops1.get("k2");
        System.out.println(k2);

    }
}
