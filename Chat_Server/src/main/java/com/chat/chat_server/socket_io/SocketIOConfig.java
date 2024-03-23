package com.chat.chat_server.socket_io;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {
    @Value("${socket-server.port}")
    private int port;

    @Bean
    public SocketIOServer socketIOServer(){
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(port);
        config.setOrigin("*");
        config.setTransports(Transport.POLLING, Transport.WEBSOCKET);
//        config.setOrigin("https://wetalk.ibme.edu.vn/service-chat");
        config.setOrigin("http://202.191.56.11:8050");
        return new SocketIOServer(config);
    }

}
