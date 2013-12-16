package com.demoapp.javademoapp;
 
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome() - desde " + address.getHostAddress());
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}
 
	@RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name + " - desde " + address.getHostAddress());
		return "index";
 
	}
 
}
