package com.archforce.arc.service.impl;

import com.archforce.arc.entity.PushDateDto;
import com.archforce.arc.service.IServerOsInfoService;
import com.archforce.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Calendar;

@Service
public class ServerOsInfoServiceImpl implements IServerOsInfoService {
    @Override
    public PushDateDto getPushDate() throws SQLException {
        PushDateDto pushDateDto = new PushDateDto();
        String tradeDate = "";
        String currentDate = DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss");
        pushDateDto.setCurrentTime(currentDate);
        pushDateDto.setTradeTime(tradeDate);
        return pushDateDto;
    }
}
