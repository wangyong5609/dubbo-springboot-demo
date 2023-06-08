package com.yong.dubbo.boot.service.consumer;

import com.yong.api.SiteService;
import com.yong.api.SiteServiceListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class CallbackDubboConsumer {

    @Reference(version = "callback")
    private SiteService siteService;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CallbackDubboConsumer.class);
        SiteService siteService = context.getBean(SiteService.class);
        // The purpose of key is to ensure that the impl provided by the consumer and invoked by the provider are the same
        String name = siteService.getName("CallbackDubboConsumer", "k1", new SiteServiceListenerImpl());
        System.out.println(name);
        String name1 = siteService.getName("CallbackDubboConsumer", "k2", new SiteServiceListenerImpl());
        System.out.println(name1);
        String name2 = siteService.getName("CallbackDubboConsumer", "k3", new SiteServiceListenerImpl());
        System.out.println(name2);
    }
}
