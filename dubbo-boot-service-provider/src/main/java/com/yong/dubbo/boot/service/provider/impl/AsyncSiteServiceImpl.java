package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "async", protocol = "protocol2")
public class AsyncSiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        return "async, " + name;
    }
}
