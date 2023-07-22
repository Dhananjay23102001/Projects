package in.blogify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.blogify.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer > {

	
//	public UserEntity findByUserEmailAndPassword(String userEmail,String userPwd);
	
	public UserEntity findByUserEmailAndUserPwd(String userEmail,String userPwd);

	public UserEntity findByUserEmail(String email);

}
