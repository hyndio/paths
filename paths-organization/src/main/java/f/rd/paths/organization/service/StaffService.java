/**
 * @author hyd 2012-12-4 上午10:25:15 
 * @version 1.0
 */
package f.rd.paths.organization.service;

import f.rd.paths.organization.model.Staff;

/** 
 * 人员操作
 * <p>
 *  
 */
public interface StaffService {

	/**
	 * 获取人员的基本信息
	 * @param id 人员标识
	 * @return
	 */
	Staff get(Integer id);
}
