package f.rd.paths.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import f.rd.paths.ws.client.SlowlyRequsetClient;

@Controller
public class SlowlyController {
	
	@Autowired
	private SlowlyRequsetClient slowlyRequsetClient;
	
	@RequestMapping("/slowlySpead")
	public void sendSlowlyData() {
		this.slowlyRequsetClient.sendSlowlyData();
	}

}
