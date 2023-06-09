package com.yong.dubbo.boot.service.consumer;

import com.yong.api.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

@EnableAutoConfiguration
public class LoadBalanceDubboConsumer {

//    @Reference(version = "default", loadbalance = "roundrobin")
//    @Reference(version = "default", loadbalance = "leastactive")
    @Reference(version = "default", loadbalance = "consistenthash")
    private SiteService siteService;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LoadBalanceDubboConsumer.class);
        SiteService siteService = context.getBean(SiteService.class);

        for (int i = 0; i < 10; i++) {
            String name = siteService.getName("loadBalance");
            System.out.println(name);
        }
    }
}
