/**
 * @author hyd 2012-11-29 下午1:21:35 
 * @version 1.0
 */
package f.rd.paths.organization;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*; 

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import f.rd.paths.organization.model.JobType;
import f.rd.paths.organization.service.JobService;

/** 
 * 测试组织结构
 * <p>
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/root-context.xml"})
public class JobServiceTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JobService jobService;
	
	@Ignore
	@Test
	public void job() {
		JobType job = this.jobService.getStaffJob(1);
		assertThat(job.getJob(), is(1));
	}
	
	@Ignore
	@Test
	public void parttime() {
		List<JobType> jobs = this.jobService.getStaffParttime(1);
		for (JobType jobType : jobs) {
			log.info("Job: {}", jobType.getJob());
		}
	}

}
