package com.archforce.bos.identity.shiro;

import com.archforce.bos.identity.service.ResourceService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

/**
 * URL 动态控制
 */
public class ShiroPermissionFactory extends ShiroFilterFactoryBean {
    private ResourceService resourceService;
    public static String definition;
    private IdentityConfig identityConfig;



}
