/**
 * @author hyd 2012-11-29 上午10:38:25 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.List;

import f.rd.paths.organization.model.JobType;
import f.rd.paths.web.security.model.JobRole;

/** 
 * 角色操作服务
 * <p>
 *  
 */
public interface RoleSerivce {
	
	/**
	 * 获取岗位角色列表
	 * @param job 岗位标识
	 * @return
	 */
	List<JobRole> getJobRole(Integer job);
	
	/**
	 * 获取岗位角色列表
	 * @param jobs 岗位列表
	 * @return
	 */
	List<JobRole> getJobRole(List<JobType> jobs);

}
