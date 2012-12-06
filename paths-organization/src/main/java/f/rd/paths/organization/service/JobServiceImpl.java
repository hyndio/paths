/**
 * @author hyd 2012-11-29 上午11:48:41 
 * @version 1.0
 */
package f.rd.paths.organization.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

import f.rd.paths.organization.model.JobType;
import f.rd.paths.organization.model.StaffJob;

/** 
 * 岗位操作服务
 * <p>
 *  
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.organization.service.JobService#getStaffJob(java.lang.Integer)
	 */
	@Cacheable(cacheName="organization")
	public JobType getStaffJob(Integer staff) {
		Session session = this.sessionFactory.openSession();
		JobType jobType = (JobType) session.get(StaffJob.class, staff);
		session.close();
		return jobType;
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.organization.service.JobService#getStaffParttime(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(cacheName="organization")
	public List<JobType> getStaffParttime(Integer staff) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from StaffParttime s where s.staff=:staff").setInteger("staff", staff);
		List<JobType> list = query.list();
		session.close();
		return list;
	}

}
