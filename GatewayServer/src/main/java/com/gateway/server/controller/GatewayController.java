package com.gateway.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateWay")
public class GatewayController {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(GatewayController.class);
    
	@RequestMapping(path="/{path}",method = RequestMethod.GET)
	public String get(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable String path ) {
		LOGGER.info("=========GatewayController.get:{}",path);
		LOGGER.info("GatewayController.get:{}",path);
		return "hello world: "+path;
	}
	
	/*public String post(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) String id) {
		LOGGER.info("BaseController.query:{}",id);
		return "hello world";
	}*/
}
