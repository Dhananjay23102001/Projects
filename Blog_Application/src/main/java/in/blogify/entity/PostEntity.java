package in.blogify.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Post_Table")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;

	@Lob
	private String content;

	private String description;

	private String title;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	private List<CommentEntity> comments;

}
