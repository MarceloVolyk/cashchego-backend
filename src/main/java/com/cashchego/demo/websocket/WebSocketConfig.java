package com.cashchego.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Prefixo para tópicos que os clientes podem assinar
        config.setApplicationDestinationPrefixes("/app"); // Prefixo para mensagens direcionadas a métodos anotados com @MessageMapping
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // Endpoint para conexão WebSocket
                .setAllowedOriginPatterns("*")
                .withSockJS(); // Habilita fallback para SockJS
 /*     registry.addEndpoint("/ws")
        .setAllowedOrigins(
            "http://localhost:8080",
            "http://127.0.0.1:5500", // Live Server
            "https://seusite.com"
        )*/
    }
}

//url para testes: http://localhost:8080/websocket-test.html