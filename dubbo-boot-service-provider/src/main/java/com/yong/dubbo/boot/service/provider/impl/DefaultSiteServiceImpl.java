package com.yong.dubbo.boot.service.provider.impl;

import com.yong.api.SiteService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * 如果未指定协议的话，则会为每一个协议创建一个此服务
 */
@Service(version = "default")
public class DefaultSiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        URL url = RpcContext.getContext().getUrl();
        return String.format("ip: %s, protocol: %s, port: %s", url.getIp(), url.getProtocol(), url.getPort());
    }
}
