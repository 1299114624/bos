package com.archforce.arc.service.impl;

import com.archforce.arc.entity.PushDateDto;
import com.archforce.arc.entity.WebSocketMessageDto;
import com.archforce.common.log.LogUtils;
import com.archforce.arc.service.IServerOsInfoService;
import com.archforce.arc.service.IWebSocketPermission;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class AlarmLogWebSocketImpl extends TextWebSocketHandler {
    Logger logger = LoggerFactory.getLogger(AlarmLogWebSocketImpl.class);
    private static final List<WebSocketSession> logSessions = Collections.synchronizedList(new ArrayList<>());
    private static final List<WebSocketSession> timeSession = Collections.synchronizedList(new ArrayList<>());
    private static String permission = "OM";
    private Timer timeTimer;
    private Timer logTimer;
    @Value("${sys.datetime}")
    private String sysDateTime;
    @Value("${bos.login}")
    private String login;
    @Value("${bos.logout}")
    private String logout;

    @Autowired
    private IServerOsInfoService serverOsInfoService;
    @Autowired
    private IWebSocketPermission webSocketPermission;

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LogUtils.debug(AlarmLogWebSocketImpl.class, "Websocket提示信息", "connection to the websocket success...");
        if (Objects.isNull(this.logTimer)) {
            LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "connection to the websocket success...");
            this.timeTask();
            this.pushTask();
        }
    }

    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if (this.logger.isDebugEnabled()) {
            LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "websocket connection closed closeCode:" + status.getCode());
            timeSession.remove(session);
            logSessions.remove(session);
        }
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            if (!session.isOpen()) {
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "user session closed");
                return;
            }
            String messagePay = ((String) message.getPayload()).toLowerCase();
            if (messagePay.contains(this.login)) {
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "login user success...");
                timeSession.add(session);
                Long userId = Long.valueOf(messagePay.split(this.login)[1]);
                boolean checkPermission = this.webSocketPermission.checkPermission(userId, permission);
                if (checkPermission) {
                    LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "用户有推送告警日志权限");
                    logSessions.add(session);
                }
            } else if (messagePay.contains(this.logout)) {
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "logout user success...");
                logSessions.remove(session);
                timeSession.remove(session);
                session.close();
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "websocket connection closed");
            } else {
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "账号暂无权限推送消息...");
                session.close();
            }
        } catch (Exception e) {
            LogUtils.debug(AlarmLogWebSocketImpl.class, "Websocket提示信息", "websocket:" + e.getMessage());
        }
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        try {
            if (session.isOpen()) {
                session.close();
            }
            timeSession.remove(session);
            logSessions.remove(session);
        } catch (Exception e) {
            LogUtils.debug(AlarmLogWebSocketImpl.class, "Websocket提示信息", "client closed..." + e.getMessage());
            timeSession.remove(session);
            logSessions.remove(session);
        }
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    private synchronized void timeTask() {
        if (Objects.nonNull(this.timeTimer)) {
            LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "timerTime nonnull");
        } else {
            this.timeTimer = new Timer(true);
            long delay = 0L;
            AlarmLogWebSocketImpl.CurrentTimeTask currentTimeTask = new AlarmLogWebSocketImpl.CurrentTimeTask(timeSession);
            this.timeTimer.schedule(currentTimeTask, delay, 500L);
        }
    }
    private synchronized void pushTask() {
        if (Objects.nonNull(this.logTimer)) {
            LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket提示信息", "logTimer nonnull");
        } else {
            this.logTimer = new Timer(true);
            long delay = 0L;
//            AlarmLogWebSocketImpl.CurrentTimeTask currentTimeTask = new AlarmLogWebSocketImpl.CurrentTimeTask(timeSession);
//            this.timeTimer.schedule(currentTimeTask, delay, 500L);
        }
    }

    private synchronized void sendMessage(TextMessage textMessage, WebSocketSession session) throws IOException {
        session.sendMessage(textMessage);
    }

    class CurrentTimeTask extends TimerTask {
        private List<WebSocketSession> sessions;

        public CurrentTimeTask(List<WebSocketSession> sessions) {
            this.sessions = sessions;
        }

        public void run() {
            try {
                PushDateDto pushDateDto = AlarmLogWebSocketImpl.this.serverOsInfoService.getPushDate();
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
                mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, Boolean.TRUE);
                mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, Boolean.TRUE);
                WebSocketMessageDto webSocketMessageDto = new WebSocketMessageDto();
                webSocketMessageDto.setCmd(AlarmLogWebSocketImpl.this.sysDateTime);
                webSocketMessageDto.setBody(pushDateDto);
                String json = mapper.writeValueAsString(webSocketMessageDto);
                TextMessage textMessage = new TextMessage(json);

                WebSocketSession session;
                for (Iterator var6 = this.sessions.iterator(); var6.hasNext(); AlarmLogWebSocketImpl.this.sendMessage(textMessage, session)) {
                    session = (WebSocketSession)var6.next();
                    if (!session.isOpen()) {
                        this.sessions.remove(session);
                    }
                }
            } catch (Exception var8) {
                LogUtils.info(AlarmLogWebSocketImpl.class, "Websocket推送系统时间异常", "推送系统时间异常：" + var8.getMessage(), var8);
            }
        }
    }
}
