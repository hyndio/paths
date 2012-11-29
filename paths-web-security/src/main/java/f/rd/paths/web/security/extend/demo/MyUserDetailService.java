/**
 * @author hyd 2012-11-29 下午3:43:49 
 * @version 1.0
 */
package f.rd.paths.web.security.extend.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 在这个类中，你就可以从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等。
 * 建议通过我们封装的平台级持久层管理类获取和管理。
 * <p>
 * 
 */
public class MyUserDetailService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		GrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
		
		// auths.add(auth2);
		if (username.equals("cyu")) {
			auths = new ArrayList<GrantedAuthority>();
			GrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");
			auths.add(auth1);
			auths.add(auth2);
		}

		// User(String username, String password, boolean enabled, boolean
		// accountNonExpired,
		// boolean credentialsNonExpired, boolean accountNonLocked,
		// Collection<GrantedAuthority> authorities) {
		User user = new User(username, "sap123", true, true, true, true, auths);
		return user;
	}

}
