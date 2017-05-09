package com.sonal.manager.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sonal.manager.rest.vo.HealthVO;

import reactor.core.publisher.Mono;

@Service
public class AgentClient {

	@Autowired
	private WebClient webClient;
	
	public Mono<HealthVO> checkAgentHealth(){
		return webClient.get()
				 .uri("http://localhost:8081/healthCheck")
			     .accept(MediaType.APPLICATION_JSON)
			     .exchange()
			     .flatMap(cr -> cr.bodyToMono(HealthVO.class));
			     
			     
	}
	
	
}
