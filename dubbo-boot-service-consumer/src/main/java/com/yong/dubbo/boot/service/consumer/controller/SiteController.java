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
    @Reference
    private SiteService siteService;

    @GetMapping("/name")
    public String getName(String name) {
        return siteService.getName(name);
    }
}
