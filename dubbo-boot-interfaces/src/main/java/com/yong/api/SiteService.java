package com.yong.api;

import java.util.concurrent.CompletableFuture;

public interface SiteService {

    String getName(String name);
    // Parameter callback
    default String getName(String name, String key, SiteServiceListener siteServiceListener) {
        return null;
    }

    default CompletableFuture<String> siteAsync(String name) {
        return null;
    }
}
