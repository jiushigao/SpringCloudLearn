package com.springcloud.eurekafeignclient.service;

import com.springcloud.eurekafeignclient.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FeignService {
    @Qualifier("eurekaClientFeign")
    @Autowired
    EurekaClientFeign feign;

    public String hi(String name){
        return feign.sayHiFromEurekaClient(name);
    }
}
