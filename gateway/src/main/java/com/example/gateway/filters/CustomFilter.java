package com.example.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(CustomFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Solicitud hacia: " + exchange.getRequest().getPath());
        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getCookies() " + exchange.getRequest().getCookies());

        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getLocalAddress() " + exchange.getRequest().getLocalAddress());
        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getURI() " + exchange.getRequest().getURI());
        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getPath() " + exchange.getRequest().getPath());
        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getMethod() " + exchange.getRequest().getMethod());

        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getBody() " + exchange.getRequest().getBody());
        logger.info("Info de pedido hacia: " +exchange.getRequest().getPath() + " con exchange.getRequest().getHeaders() " + exchange.getRequest().getHeaders());






        return chain.filter(exchange);
    }
}
