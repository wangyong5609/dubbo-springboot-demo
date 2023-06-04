package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class SiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        return "hello, " + name;
    }
}
