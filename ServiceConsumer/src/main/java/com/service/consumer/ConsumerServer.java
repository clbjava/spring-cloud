package com.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务消费者
 * 
 * @author clb
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class ConsumerServer {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerServer.class, args);
	}
}
