package com.archforce.arc.service;

import com.archforce.arc.entity.PushDateDto;

import java.sql.SQLException;

public interface IServerOsInfoService {
    PushDateDto getPushDate() throws SQLException;
}
