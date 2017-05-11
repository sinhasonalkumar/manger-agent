package com.sonal.agent.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sonal.agent.rest.tasks.ITask;
import com.sonal.agent.rest.vo.JobRequestVO;
import com.sonal.agent.rest.vo.JobResultVO;

@Service
public class JobServer {

	@Autowired
	@Qualifier("task1")
	private ITask task1;

	@Autowired
	@Qualifier("task2")
	private ITask task2;

	@Autowired
	@Qualifier("task3")
	private ITask task3;
	
	@Autowired
	private NotificationService notificationService;

	@Async
	public void startJob(final JobRequestVO jobRequestVO) {
		
		notificationService.sendJobNotification(new JobResultVO(jobRequestVO.getJobRequestId(), true, "Inprogress"));
		
		task1.execute(jobRequestVO)
			 .then(task2.execute(jobRequestVO))
			 .then(task3.execute(jobRequestVO))
			 .then(notificationService.sendJobNotification(new JobResultVO(jobRequestVO.getJobRequestId(), true, "Completed")));

	}
}
