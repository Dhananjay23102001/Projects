package in.skilltech.enquiry_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String loadIndexPage() {

		return "index";

	}

}
