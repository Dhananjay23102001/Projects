package in.blogify.services;

import java.util.List;

import in.blogify.bind.CommentBind;
import in.blogify.entity.CommentEntity;

public interface CommentService {

	public boolean saveAllComments(CommentBind commentBind );
	
	public List<CommentEntity> getCommentsByPost(Integer postId) ;
	
	 public void deleteComment(Integer commentId);
}
