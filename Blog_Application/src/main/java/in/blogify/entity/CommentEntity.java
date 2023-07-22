package in.blogify.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Comment_Table")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commentId;
	
	private String email;
	
	private String name;
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private Date createdOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id")
	private PostEntity post;
		
}
