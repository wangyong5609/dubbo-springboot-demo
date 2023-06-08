package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import com.yong.api.SiteServiceListener;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

/**
 * 如果未指定协议的话，则会为每一个协议创建一个此服务
 */
@Service(version = "callback", methods = {@Method(name="siteName", arguments = {@Argument(index = 2, callback = true)})}, callbacks = 3)
public class CallbackSiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "timeout";
    }

    @Override
    public String getName(String name, String key, SiteServiceListener siteServiceListener) {
        siteServiceListener.changed("provider data");
        return "callback:" +name;
    }
}
