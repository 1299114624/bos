package com.archforce.arc.config;

import com.archforce.arc.service.impl.AlarmLogWebSocketImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
@Component("monitorWebSocketConfig")
public class WebSocketConfig implements WebSocketConfigurer {
    @Value("${bos.websocket}")
    private String websocket;

    public WebSocketConfig() {
    }

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.webSocketService(), new String[]{this.websocket})
                .addInterceptors(new HandshakeInterceptor[]{new HttpSessionHandshakeInterceptor()})
                .setAllowedOrigins(new String[]{"*"});
    }

    @Bean
    public WebSocketHandler webSocketService() {
        return new AlarmLogWebSocketImpl();
    }
}
