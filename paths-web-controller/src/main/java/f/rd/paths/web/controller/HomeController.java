package f.rd.paths.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import f.rd.paths.organization.model.Staff;
import f.rd.paths.organization.service.StaffService;
import f.rd.paths.web.security.extend.impl.UserDetailsImpl;


@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Staff staff = null;
		if (principal != null && principal instanceof UserDetailsImpl) {
			staff = this.staffService.get(((UserDetailsImpl) principal).getStaff());
		}
		model.addAttribute("staff", staff);
		return "home";
	}
	
	@RequestMapping("/clickHere")
	public String click(Model model) {
		log.info("------------------------");
		log.info("简单跳转！！");
		model.addAttribute("calculater", 90);
		log.info("------------------------");
		return "index";
	}
	
}
