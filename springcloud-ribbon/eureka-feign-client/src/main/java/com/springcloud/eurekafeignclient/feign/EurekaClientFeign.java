package com.springcloud.eurekafeignclient.feign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
@Qualifier("eurekaClientFeign")
public interface EurekaClientFeign {
    @GetMapping("/hi")
    public String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
