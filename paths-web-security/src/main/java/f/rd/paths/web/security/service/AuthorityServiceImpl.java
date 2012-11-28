/**
 * @author hyd 2012-11-28 下午4:39:50 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import f.rd.paths.web.security.model.Authority;

/** 
 * 权限操作服务
 * <p>
 *  
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.AuthorityService#getAuthorityNames(java.lang.String)
	 */
	public List<String> getAuthorityNames(String username) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see f.rd.paths.web.security.service.AuthorityService#getAuthorities(java.lang.String)
	 */
	public List<Authority> getAuthorities(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
