package com.codingstudy.login.components;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 *  缓存管理token
 */
public class TokenCache {

    private static final String TOKEN_KEY = "token";
    private static Cache<String,String> cache = CacheBuilder.newBuilder().build();

    /**
     * 保存
     * @param token
     */
    public static void setToken(String token) {

        cache.put(TOKEN_KEY,token);
    }

    /**
     * 取
     * @return
     */
    public static String getTokenFromCache(){
        return cache.getIfPresent(TOKEN_KEY);
    }
}