/**
 * @author hyd 2012-11-30 上午9:56:32 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import f.rd.paths.web.security.model.AuthoResource;
import f.rd.paths.web.security.model.Resource;

/** 
 * 资源操作服务
 * <p>
 *  
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.ResourceService#getAuthResources(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<Resource> getAuthResources(Integer authority) {
		Session session = this.sessionFactory.openSession();
		// 对应关联表
		List<AuthoResource> authResources = this.getAuthoResources(authority);
		List<Integer> resoIds = new ArrayList<Integer>();
		for (AuthoResource authoResource : authResources) {
			resoIds.add(authoResource.getResource());
		}
		Criteria criteria = session.createCriteria(Resource.class);
		criteria.add(Restrictions.in("id", resoIds));
		List<Resource> list = criteria.list();
		session.close();
		return list;
	}
	
	/**
	 * 
	 * @param authority
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<AuthoResource> getAuthoResources(Integer authority) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from AuthoResource a where a.authority=:authority").setInteger("authority", authority);
		List<AuthoResource> list = query.list();
		session.close();
		return list;
	}
	

}
