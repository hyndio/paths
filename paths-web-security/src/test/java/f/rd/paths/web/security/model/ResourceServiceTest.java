/**
 * @author hyd 2012-11-30 上午10:09:01 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import f.rd.paths.web.security.service.ResourceService;

/** 
 * 加载资源测试
 * <p>
 *  
 */
public class ResourceServiceTest extends TestConf {

	@Autowired
	private ResourceService resourceService;
	
	@Ignore
	@Test
	public void authResources() {
		List<Resource> authResources = this.resourceService.getAuthResources(2);
		System.out.println();
		for (Resource resource : authResources) {
			System.out.println(resource.getUri());
		}
		System.out.println();
	}
}
