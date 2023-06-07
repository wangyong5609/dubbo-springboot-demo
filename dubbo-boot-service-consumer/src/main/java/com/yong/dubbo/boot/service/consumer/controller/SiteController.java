package com.yong.dubbo.boot.service.consumer.controller;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/site")
public class SiteController {
    // <dubbo:reference
//    @Reference(version = "async")
//    @Reference(version = "default", url = "dubbo://192.168.88.1:20883/com.yong.api.SiteService:default")
    @Reference(version = "timeout", timeout = 3000)
    private SiteService siteServiceA;
    @GetMapping("/name")
    public String getName(String name) {
        return siteServiceA.getName(name);
    }
}
