package com.archforce.arc.service;

public interface IWebSocketPermission {
    default boolean checkPermission(Long userId, String permission) {
        return true;
    }
}
