package com.archforce.oss.service;

import com.archforce.oss.entity.PushDateDto;

import java.sql.SQLException;

public interface IServerOsInfoService {
    PushDateDto getPushDate() throws SQLException;
}
