/**
 * @author hyd 2012-11-30 上午9:53:36 
 * @version 1.0
 */
package f.rd.paths.web.security.service;

import java.util.List;

import f.rd.paths.web.security.model.Resource;

/** 
 * 资源操作服务
 * <p>
 *  
 */
public interface ResourceService {
	
	/**
	 * 获取对就权限下的所有资源
	 * @param authority 权限的标识
	 * @return
	 */
	List<Resource> getAuthResources(Integer authority);
} 
