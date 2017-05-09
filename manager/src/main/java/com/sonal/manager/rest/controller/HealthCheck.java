package com.sonal.manager.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.manager.client.AgentClient;
import com.sonal.manager.rest.vo.HealthVO;

import reactor.core.publisher.Mono;

@RestController
public class HealthCheck {
	
	@Autowired
	private AgentClient agentClient;
	
	@GetMapping(value="/healthCheck")
	public Mono<ResponseEntity<HealthVO>> healthCheck(){
		HealthVO health = new HealthVO();
		health.setStatus("Manager Healthy !! ");
		ResponseEntity<HealthVO> response = new  ResponseEntity<>(health,HttpStatus.OK);
		return Mono.just(response);
	}
	
	@GetMapping(value="/agent/healthCheck")
	public Mono<ResponseEntity<HealthVO>> agentHealthCheck(){
		return agentClient.checkAgentHealth()
						  .map(r -> new ResponseEntity<>(r,HttpStatus.OK))
						  .onErrorReturn(new ResponseEntity<>(new HealthVO("Dead"),HttpStatus.SERVICE_UNAVAILABLE));
	}

}
