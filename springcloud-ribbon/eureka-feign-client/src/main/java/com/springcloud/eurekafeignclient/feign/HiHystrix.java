package com.springcloud.eurekafeignclient.feign;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String sayHiFromEurekaClient(String name) {
        return "哎呀！服务崩溃了>_<,"+name+",sorry！";
    }
}
