package com.archforce.bos.identity.config;

import com.archforce.bos.identity.service.ResourceService;
import com.archforce.bos.identity.shiro.*;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class IdentityShiroConfig {

    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(IdentityConfig identityConfig) {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setCacheManager(new MemoryConstrainedCacheManager());
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        defaultWebSessionManager.setGlobalSessionTimeout(identityConfig.getExpireTime());
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdCookie(simpleCookie());
//        defaultWebSessionManager.setGlobalSessionTimeout(10 * 1000);
        return defaultWebSessionManager;
    }

    @Bean
    public DefaultWebSecurityManager webSecurityManager(@Qualifier("customRealm") CustomRealm customRealm, DefaultWebSessionManager sessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm);
        defaultWebSecurityManager.setCacheManager(new MemoryConstrainedCacheManager());
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager, ResourceService resourceService,
                                                         IdentityConfig identityConfig, @Qualifier("kaptchaFilter") Filter kaptchaFilter) {
        ShiroPermissionFactory shiroPermissionFactory = new ShiroPermissionFactory();
        shiroPermissionFactory.setSecurityManager(securityManager);
        shiroPermissionFactory.setResourceService(resourceService); //AjaxAuthenticationFilter
        shiroPermissionFactory.setIdentityConfig(identityConfig);
        shiroPermissionFactory.getFilters().put("authc", new AjaxAuthenticationFilter());
        shiroPermissionFactory.getFilters().put("resources", new AnyResourcesAuthorizationFilter());
        shiroPermissionFactory.setFilterChainDefinitions(ShiroPermissionFactory.definition);

        return shiroPermissionFactory;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("shiro.session");
        simpleCookie.setPath("/");
        return simpleCookie;
    }
}
