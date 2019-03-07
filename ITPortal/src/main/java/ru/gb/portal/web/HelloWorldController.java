package ru.gb.portal.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {
	
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", getMessage());
        model.addAttribute("today", new Date());
        return "test";

    }
	
	private String getMessage() {
        return "Hello World";
    }

}
