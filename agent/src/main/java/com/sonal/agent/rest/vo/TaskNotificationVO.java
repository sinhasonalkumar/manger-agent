package com.sonal.agent.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames=true)
public class TaskNotificationVO {

	private String jobRequestId;
	
	private String taskName;
	
	private String status;
	
	private String result;

	public TaskNotificationVO(String jobRequestId, String taskName, String status , String result) {
		super();
		this.jobRequestId = jobRequestId;
		this.taskName = taskName;
		this.status = status;
		this.result = result;
	}
	
	
}
