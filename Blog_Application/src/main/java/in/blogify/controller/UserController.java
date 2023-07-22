package in.blogify.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.blogify.bind.UserLoginForm;
import in.blogify.bind.UserRegisterationForm;
import in.blogify.constant.AppConstant;
import in.blogify.constant.ModelAttributes;
import in.blogify.constant.UIConstant;
import in.blogify.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices services;

	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String loginPage(Model model) {

		UserLoginForm loginform = new UserLoginForm();
		model.addAttribute(ModelAttributes.LOGINFORM, loginform);
		return UIConstant.LOGIN;
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginform") UserLoginForm loginform, Model model) {

		String status = services.login(loginform);

		if (status.contains("Success")) {

			return "redirect:viewpost";
		}

		model.addAttribute(ModelAttributes.ERRORMSG, status);

		return UIConstant.LOGIN;
	}

	@GetMapping("/reg")
	public String regPage(Model model) {
		UserRegisterationForm regForm = new UserRegisterationForm();
		model.addAttribute(ModelAttributes.REGFORM, regForm);
		return UIConstant.REG;
	}

	@PostMapping("/reg")
	public String reg(@ModelAttribute("regform") UserRegisterationForm form, Model model) {

		boolean status = services.register(form);

		if (status) {

			model.addAttribute(ModelAttributes.SUCCESSMSG, AppConstant.ACCOUNTCREATE);
		} else {
			model.addAttribute(ModelAttributes.ERRORMSG, AppConstant.EMAILTAKEN);
		}

		return UIConstant.REG;
	}

	@GetMapping("/logout")
	public String logout() {

		session.invalidate();

		return "redirect:/";
	}

}
