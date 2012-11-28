package f.rd.paths.service.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component("springQuartzTimer")
public class SpringQuartzTimer {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static int counter = 1;  
	
	public void doBiz () {
		log.info("------------------------");
		log.info("第 {} 次！", counter++);
		log.info("------------------------");
	}
	
}
