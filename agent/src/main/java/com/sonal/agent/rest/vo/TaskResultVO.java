package com.sonal.agent.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TaskResultVO {
	
	private String jobRequestId;
	
	private String taskName;

	private String result;
	
	private boolean success;

	public TaskResultVO(String jobRequestId,String taskName,String result, boolean success) {
		super();
		this.jobRequestId = jobRequestId;
		this.taskName = taskName;
		this.result = result;
		this.success = success;
	}
	
	
}
