package com.archforce.bos.identity.service.impl;

import com.archforce.oss.service.IWebSocketPermission;
import com.archforce.bos.identity.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketPermissionImpl implements IWebSocketPermission{
    @Autowired
    private ResourceService resourceService;

//    @Override
//    public boolean checkPermission(Long userId, String permission) {
//
//    }
}
