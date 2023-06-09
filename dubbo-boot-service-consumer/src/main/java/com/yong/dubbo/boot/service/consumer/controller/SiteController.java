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
//    @Reference(version = "timeout", timeout = 3000)
//    @Reference(version = "timeout", timeout = 1000, mock = "force:return mock")
    @Reference(version = "timeout", timeout = 1000, stub = "true") // when stub is true, A proxy object for SiteServiceStub will be created
    private SiteService siteServiceA;
    @GetMapping("/name")
    public String getName(String name) {
        return siteServiceA.getName(name);
    }
}
