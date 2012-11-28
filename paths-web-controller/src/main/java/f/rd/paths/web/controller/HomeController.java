package f.rd.paths.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import f.rd.paths.groovy.Calculator;


@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Calculator calculator;
	
	@RequestMapping("/clickHere")
	public String click(Model model) {
		log.info("------------------------");
		log.info("简单跳转！！");
		model.addAttribute("calculater", this.calculator.add(1, 5));
		log.info("------------------------");
		return "index";
	}
	
}
