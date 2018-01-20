package masterSpringMvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import masterSpringMvc.services.GreetModel;
import masterSpringMvc.services.GreetService;

@RestController
public class Greeting {
	@Autowired
	GreetService service;

	@RequestMapping("/greeting")
	public GreetModel greeting(@RequestParam(value = "name", defaultValue = "Boss") String name) {
		return service.getGreet(name);
	}
}
	