package com.archforce.oss.entity;

public class WebSocketMessageDto {
    private String cmd;
    private Object body;

    public WebSocketMessageDto() {
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
