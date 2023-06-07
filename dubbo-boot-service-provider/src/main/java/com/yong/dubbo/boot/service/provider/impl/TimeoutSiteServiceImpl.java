package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * 如果未指定协议的话，则会为每一个协议创建一个此服务
 */
@Service(version = "timeout", timeout = 4000)
public class TimeoutSiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "timeout";
    }
}
