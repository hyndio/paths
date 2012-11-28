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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import f.rd.paths.web.security.model.User;
import f.rd.paths.web.security.service.AuthorityService;
import f.rd.paths.web.security.service.UserService;

/** 
 * 获取用户信息及所拥有的权限：<br>
 * 数据源、用户缓存（通过数据库管理用户、角色、权限、资源）。
 * <p>
 *  
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 用户登录信息
		User user = this.userService.get(username);
		// 用户所拥有的权限
		Collection<GrantedAuthority> authorities = this.loadUserAuthoritiesByName(username);
		// 转换为UserDetails
		return new UserDetailsImpl(user.getStaff(), user.getUsername(), user.getPassword(), user.isEnabled(), authorities);
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	private List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		try {
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<String> authorityNames = this.authorityService.getAuthorityNames(username);
			for (String name: authorityNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(name);
				auths.add(authority);
			}
			return auths;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
