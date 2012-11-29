/**
 * @author hyd 2012-11-28 下午4:35:33 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.List;

import f.rd.paths.web.security.model.Authority;
import f.rd.paths.web.security.model.JobRole;

/** 
 * 权限操作服务
 * <p>
 *  
 */
public interface AuthorityService {
	
	/**
	 * 获取权限实体列表
	 * @param username 用户登录账号
	 * @return
	 */
	List<Authority> getAuthorities(String username);

	/**
	 * 获取权限实体列表
	 * @param role 岗位角色标识
	 * @return
	 */
	List<Authority> getAuthorities(List<JobRole> roles);
}
