package ru.gb.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	

	@RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String hello(Model model, @PathVariable(value="name") String name) {
		model.addAttribute("name", name);
        return "hello";
    }

}
