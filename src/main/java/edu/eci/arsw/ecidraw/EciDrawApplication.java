package edu.eci.arsw.ecidraw;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "edu.eci.arsw.ecidraw" })
public class EciDrawApplication {

	@Resource
	private HttpServletRequest request;

	public static void main(String[] args) {
		SpringApplication.run(EciDrawApplication.class, args);
	}

	@GetMapping("/setname")
	public String setName(@RequestParam(value = "name", defaultValue = "Anónimo") String name) {
		request.getSession().setAttribute("name", name);
		return String.format("Hello %s!", name);
	}

	public void sessionManagement() {
		System.out.println(request.getSession(true).getId());
	}

}
