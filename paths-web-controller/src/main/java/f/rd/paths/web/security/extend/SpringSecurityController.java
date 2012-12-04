/**
 * @author hyd 2012-11-20 上午10:45:57 
 * @version 1.0
 */
package f.rd.paths.web.security.extend;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/** 
 * SpringSecurity的一些核心用法
 * <p>
 *  
 */
public class SpringSecurityController {

	public void a() {
		/**
		 * 这要取用户名
		 */
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		} 
		System.out.println(username);
	}
}
