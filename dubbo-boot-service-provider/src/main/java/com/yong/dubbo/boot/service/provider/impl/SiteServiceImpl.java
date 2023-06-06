package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 如果未指定协议的话，则会为每一个协议创建一个此服务
 */
@Service(version = "default", protocol = "protocol2")
public class SiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        return "hello, " + name;
    }
}
