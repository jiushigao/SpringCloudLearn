package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope//spring cloud bus 通过消息队列可以在不重启的情况下更新配置，不仅会更新当前应用的配置，通过消息队列可以将集群部署的其他机器同步更新
public class ConfigClientApplication {
    @Value("${foo}")
    String foo;
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi(){
        return foo;
    }

}
