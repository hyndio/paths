/*
 * @(#) MyUserDetailsService.java  2011-3-23 上午09:04:31
 *
 * Copyright 2011 by Sparta 
 */

package f.rd.paths.web.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.sql.DataSource;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails。
 * 该UserDetails包括用户名、密码、是否可用、是否过期等信息。 sparta 11/3/29
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

//	@Autowired
//	private SysUsersDao sysUsersDao;
//	
//	@Autowired
//	private SysAuthoritiesResourcesDao pubAuthoritiesResourcesDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserCache userCache;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		//得到用户的权限
		auths = this.loadUserAuthoritiesByName(username);
		//根据用户名取得一个SysUsers对象，以获取该用户的其他信息。
		SysUsers user = this.findByUserAccount(username);
		user.setAuthorities(auths);
		user.setPassword(user.getUserPassword());
		user.setUsername(user.getUserName());
		return user;
	}
	
	private List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		try {
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<String> authorityNames = this.loadUserAuthorities(username);
			for (String roleName : authorityNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
				auths.add(authority);
			}
			return auths;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<String> loadUserAuthorities(final String username) {
		Session session = this.sessionFactory.getCurrentSession();
		/**
		 * select * from sec_user_role ur 
left join sec_user u on ur.user_=u.id_
left join sec_role_auth ra on ur.role_=ra.role_
left join sec_auth a on ra.auth_=a.id_
where u.account_='';
		 */
		Query query = session.createSQLQuery("select * from sec_user_role ur "
						+ "left join sec_user u on ur.user_=u.id_ "
						+ "left join sec_role_auth ra on ur.role_=ra.role_ "
						+ "left join sec_auth a on ra.auth_=a.id_ "
						+ "where u.account_='"
						+ username + "'");
		return query.list();
	}
	
	private SysUsers findByUserAccount(String userAccount) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			SysUsers instance = (SysUsers) session.createQuery("from SysUsers where user_account='" + userAccount + "'").uniqueResult();
			if (instance == null) {
				instance = new SysUsers();
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
		
	
	//set DataSource
	public void setDataSource( DataSource dataSource ){
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource(){
		return dataSource;
	}
	
	//设置用户缓存功能。
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }
    
    public UserCache getUserCache(){
    	return this.userCache;
    }
	
}
