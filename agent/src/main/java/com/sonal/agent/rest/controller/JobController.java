package com.sonal.agent.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.agent.rest.service.JobServer;
import com.sonal.agent.rest.vo.JobRequestVO;
import com.sonal.agent.rest.vo.JobResultVO;

import reactor.core.publisher.Mono;

@RestController
public class JobController {

	@Autowired
	private JobServer jobserver;

	@PostMapping(value = "/kickOffJob", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<JobResultVO> kickOffJob(@RequestBody JobRequestVO jobRequestVO) {
		
		jobserver.startJob(jobRequestVO);

		return Mono.just(new JobResultVO(jobRequestVO.getJobRequestId(), true, "Started"));
	}

}
