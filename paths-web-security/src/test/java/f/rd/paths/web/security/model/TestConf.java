/**
 * @Package com.renda.soft.bpm.service.impl
 * @author hyd
 * @date 2011-10-17 下午5:18:25
 * @version V1.0
 */
package f.rd.paths.web.security.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Desc: 加载spring测试环境、配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/root-context.xml"})
public class TestConf {

	public TestConf() {
		super();
	}
	
	@Test
	public void conf() {
		
	}

}
