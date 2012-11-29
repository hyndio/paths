/**
 * @author hyd 2012-11-29 上午10:33:19 
 * @version 1.0
 */
package f.rd.paths.organization.service;

import java.util.List;

import f.rd.paths.organization.model.JobType;

/** 
 * 岗位操作服务
 * <p>
 *  
 */
public interface JobService {

	/**
	 * 获取人员的主要岗位
	 * @param staff 人员标识
	 * @return
	 */
	JobType getStaffJob(Integer staff);
	
	/**
	 * 获取人员的兼职岗位
	 * @param staff 人员标识
	 * @return
	 */
	List<JobType> getStaffParttime(Integer staff);
}
