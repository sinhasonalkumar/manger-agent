package com.sonal.agent.rest.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobRequestVO implements Serializable {

	private String jobRequestId;

	private String param1;

	private String param2;

}
