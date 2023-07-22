package in.blogify.bind;

import lombok.Data;

@Data
public class UserRegisterationForm {

	private Integer userId;

	private String userFirstName;

	private String userLastName;

	private String userEmail;

	private String userPwd;
}
