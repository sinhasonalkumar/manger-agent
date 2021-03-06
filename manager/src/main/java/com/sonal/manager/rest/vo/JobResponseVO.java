package com.sonal.manager.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobResponseVO {

	private String jobRequestId;

	private boolean success;

	private String status;

	public JobResponseVO(String jobRequestId, boolean success, String status) {
		super();
		this.jobRequestId = jobRequestId;
		this.success = success;
		this.status = status;
	}
}
