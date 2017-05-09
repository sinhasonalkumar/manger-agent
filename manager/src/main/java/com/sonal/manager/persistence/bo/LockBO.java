package com.sonal.manager.persistence.bo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class LockBO implements Serializable {

	@Id
	private String id;
	
	
	private String lockName;
	
	private boolean isLocked;
	
	@Indexed(expireAfterSeconds=15)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date created;
	
	@Version
	private int version;
	
}
