package in.blogify.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="User_Table")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer userId;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userEmail;
	
	private String userPwd;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<PostEntity> allPost;
	
	
}
