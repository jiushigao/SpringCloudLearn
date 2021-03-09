package com.springcloud.eurekaribbonclient.controller;

import com.springcloud.eurekaribbonclient.ribbon.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService service;

    @Autowired
    LoadBalancerClient client;

    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        return service.hi(name);
    }

    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance choose = client.choose("eureka-client");
        return choose.getHost()+":"+choose.getPort();
    }
}
