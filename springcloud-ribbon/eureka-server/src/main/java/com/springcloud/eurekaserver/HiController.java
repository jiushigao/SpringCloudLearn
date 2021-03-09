package com.springcloud.eurekaserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @GetMapping("/hi")
    public void hi(){
        System.out.println(123);
        System.out.println(6);
    }
}
