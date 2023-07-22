package in.skilltech.enquiry_management.services;

import in.skilltech.enquiry_management.bind.LoginForm;
import in.skilltech.enquiry_management.bind.SignupForm;
import in.skilltech.enquiry_management.bind.UnlockForm;

public interface UserService {

	public boolean signUp(SignupForm form);

	public boolean unlockAccount(UnlockForm form);

	public String login(LoginForm form);

	public boolean emailForForgot(String email);
}
