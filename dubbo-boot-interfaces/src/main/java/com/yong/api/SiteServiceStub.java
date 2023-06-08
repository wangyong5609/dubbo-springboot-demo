package com.yong.api;

import com.yong.api.SiteService;

public class SiteServiceStub implements SiteService {
    private final SiteService siteService;

    public SiteServiceStub(SiteService siteService) {
        this.siteService = siteService;
    }

    @Override
    public String getName(String name) {
        try {
            return siteService.getName(name);
        }catch (Exception e) {
            return "stub: " + name;
        }
    }
}
