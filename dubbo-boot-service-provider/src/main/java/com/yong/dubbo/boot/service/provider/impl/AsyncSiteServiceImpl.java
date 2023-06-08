package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

@Service(version = "async", protocol = "protocol2")
public class AsyncSiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        return "async, " + name;
    }

    @Override
    public CompletableFuture<String> siteAsync(String name) {
        System.out.println("enable async");
        return CompletableFuture.supplyAsync(()-> {
           return getName(name);
        });
    }
}
