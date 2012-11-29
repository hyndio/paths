/**
 * @author hyd 2012-11-28 下午4:39:50 
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
import f.rd.paths.organization.service.JobService;
import f.rd.paths.web.security.model.Authority;
import f.rd.paths.web.security.model.JobRole;
import f.rd.paths.web.security.model.RoleAuthority;
import f.rd.paths.web.security.model.User;

/** 
 * 权限操作服务
 * <p>
 *  
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	@Autowired
	private RoleSerivce roleSerivce;

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.AuthorityService#getAuthorities(java.lang.String)
	 */
	public List<Authority> getAuthorities(String username) {
		// 用户登录信息
		User user = this.userService.get(username);
		// 用户所在的岗位（包括主要岗位、兼职岗位）
		JobType jobm = this.jobService.getStaffJob(user.getStaff());
		List<JobType> jobp = this.jobService.getStaffParttime(user.getStaff());
		if (jobp != null) {
			jobp.add(jobm);
		}
		List<JobRole> roles = this.roleSerivce.getJobRole(jobp);
		return this.getAuthorities(roles);
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.AuthorityService#getRoleAuthorities(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<Authority> getAuthorities(List<JobRole> roles) {
		List<RoleAuthority> ra = this.getRoleAuthorities(roles);
		// 如果角色中没有权限，
		if (ra.size() < 1) {
			return new ArrayList<Authority>();
		}
		List<Integer> authIds = new ArrayList<Integer>();
		for (RoleAuthority roleAuthority : ra) {
			authIds.add(roleAuthority.getAuthority());
		}
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Authority.class);
		criteria.add(Restrictions.in("id", authIds));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	private List<RoleAuthority> getRoleAuthorities(List<JobRole> roles) {
		// 角色列表
		List<Integer> roleIds = new ArrayList<Integer>();
		for (JobRole role: roles) {
			roleIds.add(role.getId());
		}
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(RoleAuthority.class);
		criteria.add(Restrictions.in("role", roleIds));
		return criteria.list();
	}

}
