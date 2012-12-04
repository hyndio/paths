/**
 * @author hyd 2012-11-30 下午3:51:57 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import f.rd.paths.web.security.extend.impl.ExtendUserDetailsServiceImpl;

/** 
 * TODO
 * <p>
 *  
 */
public class UserDetailsServiceImplTest extends TestConf {

	@Autowired
	private ExtendUserDetailsServiceImpl impl;
	
	@Ignore
	@Test
	public void ss() {
		UserDetails user = this.impl.loadUserByUsername("test");
		
		System.out.println();
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAuthorities().size());
		System.out.println();
				
	}
	
}
