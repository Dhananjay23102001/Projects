package in.skilltech.enquiry_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.skilltech.enquiry_management.bind.AdminLoginForm;
import in.skilltech.enquiry_management.constants.AppConstant;
import in.skilltech.enquiry_management.entity_classes.AitAdminDetails;
import in.skilltech.enquiry_management.entity_classes.AitUserDetails;


@Controller
public class AdminController {

	@Autowired
	private in.skilltech.enquiry_management.repositories.AdminDtlsRepo dtlsRepo;

	@Autowired
	private HttpSession session;

	@Autowired
	private in.skilltech.enquiry_management.repositories.UserDtlsRepo userDtlsRepo;

	@GetMapping("/admin")
	public String loginPage(Model model) {

		model.addAttribute("admin", new AdminLoginForm());
		return AppConstant.ADMIN_LOGIN_PAGE;

	}

	@PostMapping("/admin")
	public String adminLogin(@ModelAttribute("admin") AdminLoginForm admin, Model model) {

		AitAdminDetails result = dtlsRepo.findByAdminEmailAndAdminPassword(admin.getAdminEmail(),
				admin.getAdminPassword());

		if (result != null) {
			return "redirect:/Allusers";
		} else {
			model.addAttribute("errorMsg", "Invalid credentials");
			return AppConstant.ADMIN_LOGIN_PAGE;
		}
	}

	@GetMapping("/Allusers")
	public String loadUser(Model model) {

		List<AitUserDetails> findAll = userDtlsRepo.findAll();

		model.addAttribute("alluser", findAll);

		return AppConstant.VIEW_USERS_PAGE;

	}

	@GetMapping("/adminlogin/{userEmail}/{passWord}")
	public String login(@PathVariable("userEmail") String userEmail, @PathVariable("passWord") String passWord,
			Model model) {

		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// AitUserDetails result = userDtlsRepo.findByUserEmail(userEmail);

		AitUserDetails result = userDtlsRepo.findByUserEmailAndPassWord(userEmail, passWord);

		session.setAttribute("userId", result.getUserId());

		return "redirect:/dashboard";

	}

}
