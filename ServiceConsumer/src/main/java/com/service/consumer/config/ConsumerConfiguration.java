package com.service.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 通用配置
 * @author CLb
 * @version 1.0.0
 */
@Configuration
@ComponentScan
public class ConsumerConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}