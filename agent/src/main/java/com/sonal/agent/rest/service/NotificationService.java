package com.sonal.agent.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sonal.agent.rest.vo.JobNotificationVO;
import com.sonal.agent.rest.vo.JobResultVO;
import com.sonal.agent.rest.vo.TaskNotificationVO;
import com.sonal.agent.rest.vo.TaskResultVO;

import reactor.core.publisher.Mono;

@Service
public class NotificationService {

	public final Logger logger = LoggerFactory.getLogger(NotificationService.class);

	public Mono<Boolean> sendTaskNotification(TaskResultVO taskResultVO) {

		TaskNotificationVO taskNotificationVO = new TaskNotificationVO(taskResultVO.getJobRequestId(), taskResultVO.getTaskName(), "Completed", taskResultVO.getResult());
		logger.info("Sending Task Notification To Manager : " + taskNotificationVO);

		return Mono.just(true);
	}
	
	public Mono<Boolean> sendJobNotification(JobResultVO jobResultVO) {
		
		JobNotificationVO jobNotificationVO = new JobNotificationVO(jobResultVO);

		logger.info("Sending Job Notification To Manager : " + jobNotificationVO);

		return Mono.just(true);
	}
}

