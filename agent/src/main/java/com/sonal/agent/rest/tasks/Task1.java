package com.sonal.agent.rest.tasks;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sonal.agent.rest.service.NotificationService;
import com.sonal.agent.rest.vo.JobRequestVO;
import com.sonal.agent.rest.vo.TaskResultVO;

import reactor.core.publisher.Mono;

@Component
@Qualifier("task1")
public class Task1 implements ITask{
	
	@Autowired
	private NotificationService notificationService;

	@Override
	public Mono<TaskResultVO> execute(JobRequestVO jobRequestVO) {
		
		Mono<TaskResultVO> result = null;
		
		//ProcessBuilder processBuilder = new ProcessBuilder("ls -lart");
		int waitFor = 0;
		Process process = null;
	
		TaskResultVO taskResult = null;
		try {
			//process = processBuilder.start();
			process = Runtime.getRuntime().exec("ls -lart");
			waitFor = process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			taskResult = new TaskResultVO(jobRequestVO.getJobRequestId(),"Task1","Task1 Failed To Execute", false);
			result = Mono.just(taskResult);
		}
		
		if(waitFor == 0){
			taskResult = new TaskResultVO(jobRequestVO.getJobRequestId(),"Task1","Task1 Success Fully Executed", true);
			result = Mono.just(taskResult);
		}else{
			taskResult = new TaskResultVO(jobRequestVO.getJobRequestId(),"Task1","Task1 Failed To Execute", false);
			result = Mono.just(taskResult);
		}
		
		notificationService.sendTaskNotification(taskResult);
		
		return result;
	}

	
}
