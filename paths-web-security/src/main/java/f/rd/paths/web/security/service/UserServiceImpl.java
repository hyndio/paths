/**
 * @author hyd 2012-11-28 下午4:11:02 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import f.rd.paths.web.security.model.User;

/** 
 * 用户登录信息操作服务
 * <p>
 *  
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取用户登录信息
	 * @param staff 人员标识
	 * @return
	 */
	public User get(Integer staff) {
		Session session = this.sessionFactory.openSession();
		return (User) session.get(User.class, staff);
	}

	/**
	 * 获取用户登录信息
	 * @param username 唯一的登录名
	 * @return
	 */
	public User get(String username) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User a where a.username=:username").setString("username", username);
		return (User) query.uniqueResult();
	}

}
