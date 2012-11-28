/**
 * @author hyd 2012-11-28 下午4:35:33 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.List;

import f.rd.paths.web.security.model.Authority;

/** 
 * 权限操作服务
 * <p>
 *  
 */
public interface AuthorityService {
	
	/**
	 * 获取权限名称列表
	 * @param username 用登录账号
	 * @return
	 */
	List<String> getAuthorityNames(String username);
	
	/**
	 * 获取权限实体列表
	 * @param username 用户登录账号
	 * @return
	 */
	List<Authority> getAuthorities(String username);

}
