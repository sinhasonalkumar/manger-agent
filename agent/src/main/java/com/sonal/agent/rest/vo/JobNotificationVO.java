package com.sonal.agent.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames=true)
public class JobNotificationVO {
	
	private JobResultVO jobResultVO;

	public JobNotificationVO(JobResultVO jobResultVO) {
		super();
		this.jobResultVO = jobResultVO;
	}

	

}
