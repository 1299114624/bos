package com.archforce.bos.identity.shiro;

import com.archforce.bos.identity.config.IdentityConfig;
import com.archforce.bos.identity.entity.Resource;
import com.archforce.bos.identity.service.ResourceService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * URL 动态控制
 */
public class ShiroPermissionFactory extends ShiroFilterFactoryBean {

    private ResourceService resourceService;

    public static String definition;

    private IdentityConfig identityConfig;

    public ShiroPermissionFactory() {
    }

    @Override
    public void setFilterChainDefinitions(String definitions) {
        synchronized (this) {
            definitions = Objects.isNull(definitions) ? "" : definitions;
            definition = definitions;
            Map<String, String> extChians = new LinkedHashMap();
            if (!Objects.isNull(identityConfig.getAnno())) {
                identityConfig.getAnno().forEach(s -> {
                    if (!StringUtils.isEmpty(s)) {
                        extChians.put(s, "anon");
                    }
                });
            }
            List<Resource> allMenu = resourceService.getAllMenu();
            Map<String, String[]> urlMap = new LinkedHashMap<>();
            for (Resource item : allMenu) {
                if (StringUtils.isEmpty(item.getMenuUrl())) {
                    continue;
                }
                String[] menuUrlArr = item.getMenuUrl().split(";");
                for (String menuUrl : menuUrlArr) {
                    String[] resourceCode = urlMap.get(menuUrl);
                    if (StringUtils.isEmpty(resourceCode)) {
                        resourceCode = new String[]{};
                    }
                    resourceCode = StringUtils.addStringToArray(resourceCode, item.getResCode());
                    urlMap.put(menuUrl, resourceCode);
                }
            }

            for (Map.Entry<String, String[]> item : urlMap.entrySet()) {
                extChians.put(item.getKey(), "resources,resources[" + StringUtils.arrayToCommaDelimitedString(item.getValue()) + "]");
            }
            if (!Objects.isNull(identityConfig.getAuthc())) {
                identityConfig.getAuthc().forEach(s -> {
                    if (!StringUtils.isEmpty(s)) {
                        extChians.put(s, "authc");
                    }
                });
            }
            if (!Objects.isNull(identityConfig.getExternal())) {
                identityConfig.getExternal().forEach(s -> {
                    if (!StringUtils.isEmpty(s)) {
                        extChians.put(s, "external");
                    }
                });
            }
            // 配置验证码拦截器
            if (!Objects.isNull(identityConfig.getKaptcha())) {
                extChians.put(identityConfig.getKaptcha(), "kaptcha,anon");
            }
            this.setFilterChainDefinitionMap(extChians);
        }
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public IdentityConfig getIdentityConfig() {
        return identityConfig;
    }

    public void setIdentityConfig(IdentityConfig identityConfig) {
        this.identityConfig = identityConfig;
    }
}
