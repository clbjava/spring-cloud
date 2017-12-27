package com.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关服务
 * @author clb
 * @version 1.0.0
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayServer 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayServer.class, args);
    }
}
