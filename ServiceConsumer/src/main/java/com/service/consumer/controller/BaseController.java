package com.service.consumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("base")
public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
    
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	@RequestMapping(value = "query", method = RequestMethod.GET)
	public String query(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) String id) {
		LOGGER.info("BaseController.query:{}", id);
		return this.restTemplate.getForObject("http://ServiceProvider/" + id, String.class);
	}
	
	public void failHandle() {
		LOGGER.info("fail");
	}

	@GetMapping("/servers")
	public void logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-provider");
		// 打印当前选择的是哪个节点
		LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}

}
