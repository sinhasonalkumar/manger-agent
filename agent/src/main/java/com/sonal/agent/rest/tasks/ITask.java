package com.sonal.agent.rest.tasks;

import com.sonal.agent.rest.vo.JobRequestVO;
import com.sonal.agent.rest.vo.TaskResultVO;

import reactor.core.publisher.Mono;

public interface ITask {

	Mono<TaskResultVO> execute(JobRequestVO jobRequestVO);
	
}
