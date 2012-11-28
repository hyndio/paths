/**
 * @author hyd 2012-11-28 下午4:06:30 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import f.rd.paths.web.security.model.User;

/** 
 * 用户登录信息操作服务
 * <p>
 *  
 */
public interface UserService {
	
	/**
	 * 获取用户登录信息
	 * @param staff 人员标识
	 * @return
	 */
	User get(Integer staff);
	
	/**
	 * 获取用户登录信息
	 * @param username 唯一的登录名
	 * @return
	 */
	User get(String username);

}
