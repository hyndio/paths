/**
 * @author hyd 2012-12-4 上午10:27:23 
 * @version 1.0
 */
package f.rd.paths.organization.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

import f.rd.paths.organization.model.Staff;

/** 
 * 人员操作
 * <p>
 *  
 */
@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see f.rd.paths.organization.service.StaffService#get(java.lang.Integer)
	 */
	@Cacheable(cacheName="organization")
	public Staff get(Integer id) {
		Session session = this.sessionFactory.openSession();
		return (Staff) session.get(Staff.class, id);
	}

}
