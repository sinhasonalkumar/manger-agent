package com.sonal.agent.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames=true)
public class JobResultVO {

	private String jobRequestId;

	private boolean success;

	private String status;

	public JobResultVO(String jobRequestId, boolean success, String status) {
		super();
		this.jobRequestId = jobRequestId;
		this.success = success;
		this.status = status;
	}
}
