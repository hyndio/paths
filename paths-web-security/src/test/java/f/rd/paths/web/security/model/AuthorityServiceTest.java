/**
 * @author hyd 2012-11-29 下午2:30:35 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import f.rd.paths.web.security.service.AuthorityService;

/** 
 * 测试权限服务
 * <p>
 *  
 */
public class AuthorityServiceTest extends TestConf {
	
	@Autowired
	private AuthorityService authorityService;
	
	@Ignore
	@Test
	public void getAuthorities() {
		List<Authority> as = this.authorityService.getAuthorities("test");
		for (Authority authority : as) {
			System.out.println(authority.getCode() + ": " + authority.getName());
		}
	}
	

}
