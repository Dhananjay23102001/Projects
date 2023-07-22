package in.blogify.services;

import in.blogify.bind.UserLoginForm;
import in.blogify.bind.UserRegisterationForm;


public interface UserServices {

	public String login(UserLoginForm loginForm);
	
	public boolean register(UserRegisterationForm regForm);
	
	
}
