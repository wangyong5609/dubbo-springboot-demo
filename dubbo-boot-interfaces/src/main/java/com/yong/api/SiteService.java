package com.yong.api;

public interface SiteService {

    String getName(String name);
    // Parameter callback
    default String getName(String name, String key, SiteServiceListener siteServiceListener) {
        return null;
    }

}
