package com.sonal.manager.persistence.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.manager.persistence.bo.LockBO;

public interface LockDAO extends MongoRepository<LockBO, String>{

	List<LockBO> findByLockName(String lockName);
}
