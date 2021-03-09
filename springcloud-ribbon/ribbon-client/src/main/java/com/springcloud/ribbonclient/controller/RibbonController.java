package com.springcloud.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    LoadBalancerClient loadBalancer;

    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance stores = loadBalancer.choose("stores");
        return stores.getHost()+":"+stores.getPort();
    }
}
