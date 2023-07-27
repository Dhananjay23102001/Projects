package in.blogify.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.blogify.bind.CommentBind;
import in.blogify.entity.CommentEntity;
import in.blogify.repositories.CommentRepository;
import in.blogify.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public boolean saveAllComments(CommentBind commentBind) {

		CommentEntity entity = new CommentEntity();

		BeanUtils.copyProperties(commentBind, entity);

		commentRepo.save(entity);

		return true;
	}

	@Override
	public List<CommentEntity> getCommentsByPost(Integer postId) {

		return commentRepo.findByPostPostId(postId);
	}

	@Override
	public void deleteComment(Integer commentId) {

		commentRepo.deleteById(commentId);

	}

}
