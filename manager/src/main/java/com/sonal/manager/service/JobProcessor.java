package com.sonal.manager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sonal.manager.rest.vo.JobRequestVO;
import com.sonal.manager.rest.vo.JobResponseVO;

import reactor.core.publisher.Mono;

@Service
public class JobProcessor {
	
	@Autowired
	private WebClient webClient;
	
	public Mono<JobResponseVO> process(JobRequestVO jobRequestVO){
		String jobRequestId = UUID.randomUUID().toString();
		jobRequestVO.setJobRequestId(jobRequestId);
		
		Mono<JobResponseVO> jobResponseVO = webClient.post()
		 .uri("http://localhost:8081/kickOffJob")
	     .accept(MediaType.APPLICATION_JSON)
	     .syncBody(jobRequestVO)
	     .exchange()
	     .flatMap(cr -> cr.bodyToMono(JobResponseVO.class));
		
		return jobResponseVO;
	}
}
