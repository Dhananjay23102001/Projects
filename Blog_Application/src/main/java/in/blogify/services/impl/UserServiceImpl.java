package in.blogify.services.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.blogify.bind.UserLoginForm;
import in.blogify.bind.UserRegisterationForm;
import in.blogify.constant.AppConstant;
import in.blogify.entity.UserEntity;
import in.blogify.repositories.UserRepository;
import in.blogify.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private HttpSession httpSession;

	@Override
	public String login(UserLoginForm loginForm) {

		UserEntity result = userRepo.findByUserEmail(loginForm.getUserEmail());

		if (result == null) {
			return AppConstant.INVALID;
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!passwordEncoder.matches(loginForm.getUserPwd(), result.getUserPwd())) {
			return AppConstant.INVALID;
		}

		httpSession.setAttribute("userId", result.getUserId());

		return AppConstant.SUCCESS;
	}

	@Override
	public boolean register(UserRegisterationForm regForm) {

		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(regForm, entity);

		// Encode the password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(regForm.getUserPwd());

		entity.setUserPwd(encodedPassword);

		userRepo.save(entity);

		return true;
	}

}
