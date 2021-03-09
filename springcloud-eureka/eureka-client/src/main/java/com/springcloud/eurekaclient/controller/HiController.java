package com.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(){
        return "i'm from "+port ;
    }

    @GetMapping("/getBaidu")
    public String getBaidu(){
        RestTemplate rest = new RestTemplate();
        String s = rest.getForObject("https://www.baidu.com/",String.class);
        return s;
    }


}
