package com.archforce.oss.entity;

public class PushDateDto {
    private String currentTime;
    private String TradeTime;

    public PushDateDto() {
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTradeTime() {
        return TradeTime;
    }

    public void setTradeTime(String tradeTime) {
        TradeTime = tradeTime;
    }
}
