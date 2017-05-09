package com.sonal.manager.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sonal.manager.rest.vo.JobRequestVO;
import com.sonal.manager.rest.vo.JobResponseVO;

import reactor.core.publisher.Mono;

@Service
public class JobProcessor {
 
	public Mono<JobResponseVO> process(JobRequestVO jobRequestVO){
		String jobRequestId = UUID.randomUUID().toString();
		JobResponseVO jobResponseVO = new JobResponseVO();
		jobResponseVO.setJobRequestId(jobRequestId);
		return Mono.just(jobResponseVO);
	}
}
