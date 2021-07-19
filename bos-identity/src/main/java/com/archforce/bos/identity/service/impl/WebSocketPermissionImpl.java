package com.archforce.bos.identity.service.impl;

import com.archforce.bos.identity.entity.Resource;
import com.archforce.oss.service.IWebSocketPermission;
import com.archforce.bos.identity.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class WebSocketPermissionImpl implements IWebSocketPermission{
    @Autowired
    private ResourceService resourceService;

    @Override
    public boolean checkPermission(Long userId, String permission) {
        List<Resource> resourceList = resourceService.getResourceByUserId(userId);
        if (CollectionUtils.isEmpty(resourceList)) {
            return false;
        }
        for (Resource item : resourceList) {
            if (item.getResCode().contains(permission)) {
                return true;
            }
        }
        return false;
    }
}
