/**
 * @author hyd 2012-11-29 下午2:01:49 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import f.rd.paths.organization.model.JobType;
import f.rd.paths.web.security.model.JobRole;

/** 
 * 角色服务
 * <p>
 *  
 */
@Service("roleService")
public class RoleServiceImpl implements RoleSerivce {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.RoleSerivce#getJobRole(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<JobRole> getJobRole(Integer job) {
		Session session = this.sessionFactory.openSession();
		List<JobRole> jobRole = (List<JobRole>) session.createQuery("from JobRole j where j.job=:job").setInteger("job", job).list();
		return jobRole;
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.RoleSerivce#getJobRole(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	public List<JobRole> getJobRole(List<JobType> jobs) {
		Session session = this.sessionFactory.openSession();
		List<Integer> jobIds = new ArrayList<Integer>();
		for (JobType jt : jobs) {
			jobIds.add(jt.getJob());
		}
		Criteria criteria = session.createCriteria(JobRole.class);
		criteria.add(Restrictions.in("job", jobIds));
		return criteria.list();
	}

}
