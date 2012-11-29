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

import f.rd.paths.organization.model.JobType;
import f.rd.paths.organization.model.StaffJob;

/** 
 * 岗位操作服务
 * <p>
 *  
 */
@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see f.rd.paths.organization.service.JobService#getStaffJob(java.lang.Integer)
	 */
	public JobType getStaffJob(Integer staff) {
		Session session = this.sessionFactory.openSession();
		return (JobType) session.get(StaffJob.class, staff);
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.organization.service.JobService#getStaffParttime(java.lang.Integer)
	 */
	public List<JobType> getStaffParttime(Integer staff) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from StaffParttime s where s.staff=:staff").setInteger("staff", staff);
		return query.list();
	}

}
