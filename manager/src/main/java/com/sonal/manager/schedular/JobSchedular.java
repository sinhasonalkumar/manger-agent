package com.sonal.manager.schedular;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sonal.manager.app.constants.LockType;
import com.sonal.manager.persistence.bo.LockBO;
import com.sonal.manager.persistence.dao.LockDAO;


@Component
public class JobSchedular {
	
	 public final Logger logger = LoggerFactory.getLogger(JobSchedular.class);

	@Autowired
	private LockDAO lockDAO;

	@Scheduled(fixedDelay = 2000)
	public void startSchedulingJobs() {

		List<LockBO> locks = lockDAO.findByLockName(LockType.SCHEDULE_JOB.name());

		if (!(locks != null & locks.size() == 1)) {
			if(accquireLock()){
				scheduleJobs();
				releaseLock();
			}
		}else{
			logger.info("Can not Schedule Job As Lock Is Already Arquired ");
		}

	}
	
	private void scheduleJobs(){
		logger.info("Scheduled Jobs");
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(3) * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean accquireLock() {
		boolean result = false;
		try {
			LockBO lock = new LockBO();
			lock.setLockName(LockType.SCHEDULE_JOB.name());
			lock.setLocked(true);
			lock.setCreated(new Date());
			lockDAO.save(lock);
			result = true;
		} catch (OptimisticLockingFailureException e) {
			logger.error("Failed To Accquire Lock");
			result = false;
		}
		return result;
	}
	
	private boolean releaseLock() {
		boolean result = false;
		try {
			
			List<LockBO> locks = lockDAO.findByLockName(LockType.SCHEDULE_JOB.name());
			LockBO lock = locks.get(0);
			lockDAO.delete(lock);
		} catch (IndexOutOfBoundsException e) {
			logger.error("No Lock Found To Release ");
			result = false;
		}
		return result;
	}
}
