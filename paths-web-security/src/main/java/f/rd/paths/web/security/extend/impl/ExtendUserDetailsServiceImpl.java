/**
 * @author hyd 2012-11-28 下午3:57:13 
 * @version 1.0
 */
package f.rd.paths.web.security.extend.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import f.rd.paths.web.security.model.Authority;
import f.rd.paths.web.security.model.User;
import f.rd.paths.web.security.service.AuthorityService;
import f.rd.paths.web.security.service.UserService;

/** 
 * 获取用户信息及所拥有的权限：<br>
 * 数据源、用户缓存（通过数据库管理用户、角色、权限、资源）。
 * <p>
 *  
 */
@Service
public class ExtendUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserCache userCache;
	
	public UserCache getUserCache() {
		return userCache;
	}

	// 设置用户缓存功能。
	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			// 用户登录信息
			User user = this.userService.get(username);
			// 用户所拥有的权限
			Collection<GrantedAuthority> authorities = this.loadUserAuthoritiesByName(username);
			// 转换为UserDetails
			return new UserDetailsImpl(user.getStaff(), user.getUsername(), user.getPassword(), user.isEnabled(), authorities);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 转换为UserDetails
		return null;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	private List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		try {
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<Authority> authority = this.authorityService.getAuthorities(username);
			for (Authority auth: authority) {
				GrantedAuthority gauth = new SimpleGrantedAuthority(auth.getCode());
				auths.add(gauth);
			}
			return auths;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
