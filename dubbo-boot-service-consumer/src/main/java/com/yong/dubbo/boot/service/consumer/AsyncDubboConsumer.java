package com.yong.dubbo.boot.service.consumer;

import com.yong.api.SiteService;
import com.yong.api.SiteServiceListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

@EnableAutoConfiguration
public class AsyncDubboConsumer {

    @Reference(version = "async")
    private SiteService siteService;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AsyncDubboConsumer.class);
        SiteService siteService = context.getBean(SiteService.class);

        CompletableFuture<String> asyncConsumer = siteService.siteAsync("async consumer");
        asyncConsumer.whenComplete((v, e) -> {
            if (e != null) {
                e.printStackTrace();
            }else{
                System.out.println("result: " + v);
            }
        });

        System.out.println("Asynchronous end of call");
    }
}
