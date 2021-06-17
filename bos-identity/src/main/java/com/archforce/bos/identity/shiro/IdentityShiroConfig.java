package com.archforce.bos.identity.shiro;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return defaultWebSessionManager;
    }

    @Bean
    public DefaultWebSecurityManager webSecurityManager(@Qualifier("customRealm") CustomRealm customRealm, DefaultSessionManager sessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm);
        defaultWebSecurityManager.setCacheManager(new MemoryConstrainedCacheManager());
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("shiro.session");
        simpleCookie.setPath("/");
        return simpleCookie;
    }
}
